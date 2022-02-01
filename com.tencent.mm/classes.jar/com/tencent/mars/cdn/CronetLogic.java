package com.tencent.mars.cdn;

import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CronetLogic
{
  private static boolean useHttpdns = false;
  
  public static native void cancelCronetTask(String paramString);
  
  public static CertVerifyResult convertToCronetResult(AndroidCertVerifyResult paramAndroidCertVerifyResult)
  {
    CertVerifyResult localCertVerifyResult = new CertVerifyResult();
    localCertVerifyResult.status = paramAndroidCertVerifyResult.getStatus();
    localCertVerifyResult.isIssuedByKnownRoot = paramAndroidCertVerifyResult.isIssuedByKnownRoot();
    localCertVerifyResult.certificateChain = paramAndroidCertVerifyResult.getCertificateChainEncoded();
    return localCertVerifyResult;
  }
  
  public static Map<String, List<String>> getHeaderList(ResponseHeader paramResponseHeader)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = getHeaderMap(paramResponseHeader).entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramResponseHeader = (Map.Entry)localIterator.next();
      String str1 = (String)paramResponseHeader.getKey();
      if ((str1 != null) && (!str1.isEmpty()))
      {
        String str2 = (String)paramResponseHeader.getValue();
        List localList = (List)localHashMap.get(str1);
        paramResponseHeader = localList;
        if (localList == null) {
          paramResponseHeader = new ArrayList();
        }
        paramResponseHeader.add(str2);
        localHashMap.put(str1, paramResponseHeader);
      }
    }
    return localHashMap;
  }
  
  public static Map<String, String> getHeaderMap(ResponseHeader paramResponseHeader)
  {
    IdentityHashMap localIdentityHashMap = new IdentityHashMap();
    if ((paramResponseHeader != null) && (paramResponseHeader.headers != null))
    {
      paramResponseHeader = paramResponseHeader.headers;
      int j = paramResponseHeader.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramResponseHeader[i];
        if ((localObject != null) && (localObject.key != null) && (localObject.value != null)) {
          localIdentityHashMap.put(new String(localObject.key), localObject.value);
        }
        i += 1;
      }
    }
    return localIdentityHashMap;
  }
  
  public static String getSystemProperty(String paramString)
  {
    String str = System.getProperty(paramString);
    Log.d("cronet", "property " + paramString + " res " + str);
    return str;
  }
  
  public static boolean getUseHttpdns()
  {
    return useHttpdns;
  }
  
  public static native CronetLogic.WebPageProfile getWebPagePerformanceWithURL(String paramString);
  
  public static native void removeUserCert();
  
  public static void setUseHttpdns(boolean paramBoolean)
  {
    Log.i("cronet", "use httpdns ".concat(String.valueOf(paramBoolean)));
    useHttpdns = paramBoolean;
  }
  
  public static native void setUserCertVerify(boolean paramBoolean);
  
  public static native CronetHttpsCreateResult startCronetDefaultHttpTask(CronetRequestParams paramCronetRequestParams, CronetTaskCallback paramCronetTaskCallback);
  
  public static native CronetHttpsCreateResult startCronetDownloadTask(CronetRequestParams paramCronetRequestParams, CronetTaskCallback paramCronetTaskCallback);
  
  public static native CronetHttpsCreateResult startCronetHttpTask(CronetRequestParams paramCronetRequestParams, CronetTaskCallback paramCronetTaskCallback);
  
  public static CertVerifyResult verifyCertWithUserCA(byte[][] paramArrayOfByte)
  {
    int j = 0;
    label435:
    label438:
    label441:
    for (;;)
    {
      try
      {
        Log.i("cronet", "verifyCertWithUserCA");
        KeyStore localKeyStore = KeyStore.getInstance("AndroidCAStore");
        localKeyStore.load(null, null);
        Object localObject2 = new ArrayList();
        Object localObject1 = localKeyStore.aliases();
        Object localObject3;
        if (((Enumeration)localObject1).hasMoreElements())
        {
          localObject3 = (String)((Enumeration)localObject1).nextElement();
          if ((localObject3 == null) || (!((String)localObject3).startsWith("user:"))) {
            continue;
          }
          ((List)localObject2).add(localObject3);
          continue;
        }
        int k;
        int i;
        X509Certificate localX509Certificate;
        continue;
      }
      catch (KeyStoreException paramArrayOfByte)
      {
        Log.e("cronet", paramArrayOfByte.getLocalizedMessage());
        return convertToCronetResult(new AndroidCertVerifyResult(-1));
        Log.i("cronet", "alias list size %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        if (((List)localObject2).size() > 0)
        {
          localObject1 = new ArrayList();
          k = paramArrayOfByte.length;
          i = 0;
          if (i < k) {
            try
            {
              ((List)localObject1).add(X509Util.createCertificateFromBytes(paramArrayOfByte[i]));
              i += 1;
            }
            catch (CertificateException paramArrayOfByte)
            {
              Log.e("cronet", paramArrayOfByte.getLocalizedMessage());
              return convertToCronetResult(new AndroidCertVerifyResult(-5));
            }
          }
          paramArrayOfByte = ((List)localObject2).iterator();
          i = j;
          if (!paramArrayOfByte.hasNext()) {
            break label435;
          }
          localObject2 = (X509Certificate)localKeyStore.getCertificate((String)paramArrayOfByte.next());
          localObject3 = ((List)localObject1).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label441;
          }
          localX509Certificate = (X509Certificate)((Iterator)localObject3).next();
          try
          {
            localX509Certificate.verify(((X509Certificate)localObject2).getPublicKey());
            Log.i("cronet", "do user verify success");
            i = 1;
            if (i == 0) {
              break label438;
            }
            if (i == 0) {
              continue;
            }
            return convertToCronetResult(new AndroidCertVerifyResult(0));
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("cronet", localException, "Exception: check user verify certificate", new Object[0]);
          }
          continue;
        }
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        Log.e("cronet", paramArrayOfByte.getLocalizedMessage());
        return convertToCronetResult(new AndroidCertVerifyResult(-1));
        return convertToCronetResult(new AndroidCertVerifyResult(-1));
        Log.e("cronet", "checkServerTrusted self check aliasList null");
        return convertToCronetResult(new AndroidCertVerifyResult(-1));
      }
      catch (CertificateException paramArrayOfByte)
      {
        Log.e("cronet", paramArrayOfByte.getLocalizedMessage());
        return convertToCronetResult(new AndroidCertVerifyResult(-1));
      }
      catch (IOException paramArrayOfByte)
      {
        Log.e("cronet", paramArrayOfByte.getLocalizedMessage());
        return convertToCronetResult(new AndroidCertVerifyResult(-1));
      }
    }
  }
  
  public static class CertVerifyResult
  {
    public byte[][] certificateChain = null;
    public boolean isIssuedByKnownRoot = false;
    public int status = 0;
  }
  
  public static class CronetHttpsCreateResult
  {
    public int createRet = 0;
    public String taskId = "";
  }
  
  public static class CronetRequestParams
  {
    public byte[] bodyData = null;
    public boolean cachePerformance = false;
    public CronetLogic.DefaultHttpTaskParams defaultHttpTaskParams = null;
    public boolean followRedirect = false;
    public String header = "";
    public CronetLogic.HeaderMap[] headers = null;
    public CronetLogic.HostIPHint hostIPHint = null;
    public int maxRedirectCount = 2;
    public String method = "";
    public boolean needGenerateId = true;
    public boolean needWirteCache = false;
    public String savePath = "";
    public String taskId = "";
    public int taskType = 0;
    public String url = "";
    public boolean useHttp2 = false;
    public boolean useMemoryCache = false;
    public boolean useNewdns = false;
    public boolean useQuic = false;
    
    public void makeRequestHeader(Map<String, String> paramMap)
    {
      if ((paramMap != null) && (paramMap.isEmpty())) {}
      label120:
      for (;;)
      {
        return;
        int j = paramMap.size();
        this.headers = new CronetLogic.HeaderMap[j];
        paramMap = paramMap.entrySet().iterator();
        int i = 0;
        for (;;)
        {
          if (!paramMap.hasNext()) {
            break label120;
          }
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          CronetLogic.HeaderMap localHeaderMap = new CronetLogic.HeaderMap();
          localHeaderMap.key = ((String)localEntry.getKey());
          localHeaderMap.value = ((String)localEntry.getValue());
          this.headers[i] = localHeaderMap;
          i += 1;
          if (i > j) {
            break;
          }
        }
      }
    }
  }
  
  public static abstract interface CronetTaskCallback
  {
    public abstract int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt);
    
    public abstract void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult);
    
    public abstract void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress);
  }
  
  public static class CronetTaskResult
  {
    public byte[] data = null;
    public int errorCode = 0;
    public String errorMsg = "";
    public CronetLogic.HeaderMap[] headers = null;
    public String newLocation = "";
    public String originTaskId = "";
    public int quicErrorCode = 0;
    public String rawHeader = "";
    public int statusCode = 0;
    public String statusText = "";
    public long totalReceiveByte = 0L;
    public long totalWriteByte = 0L;
    public CronetLogic.WebPageProfile webPageProfile;
    
    public String getDataString()
    {
      try
      {
        String str = new String(this.data, "UTF-8");
        return str;
      }
      catch (Exception localException) {}
      return "";
    }
    
    public Map<String, String> getHeaderMap()
    {
      IdentityHashMap localIdentityHashMap = new IdentityHashMap();
      if (this.headers != null)
      {
        CronetLogic.HeaderMap[] arrayOfHeaderMap = this.headers;
        int j = arrayOfHeaderMap.length;
        int i = 0;
        while (i < j)
        {
          CronetLogic.HeaderMap localHeaderMap = arrayOfHeaderMap[i];
          if ((localHeaderMap != null) && (localHeaderMap.key != null) && (localHeaderMap.value != null)) {
            localIdentityHashMap.put(new String(localHeaderMap.key), localHeaderMap.value);
          }
          i += 1;
        }
      }
      return localIdentityHashMap;
    }
    
    public Map<String, List<String>> getHeaderMapList()
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = getHeaderMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        if ((str1 != null) && (!str1.isEmpty()))
        {
          String str2 = (String)((Map.Entry)localObject).getValue();
          List localList = (List)localHashMap.get(str1);
          localObject = localList;
          if (localList == null) {
            localObject = new ArrayList();
          }
          ((List)localObject).add(str2);
          localHashMap.put(str1, localObject);
        }
      }
      return localHashMap;
    }
  }
  
  public static class DefaultHttpTaskParams
  {
    public int reportId = 0;
  }
  
  public static class HeaderMap
  {
    public String key = "";
    public String value = "";
  }
  
  public static class ResponseHeader
  {
    public CronetLogic.HeaderMap[] headers = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.cdn.CronetLogic
 * JD-Core Version:    0.7.0.1
 */