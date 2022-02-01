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
  private static List<CronetTaskNetworkStateCallback> cronetTaskNetworkStateCallbackList = new ArrayList();
  private static boolean useHttpdns = false;
  
  public static void addCronetTaskNetworkStateCallback(CronetTaskNetworkStateCallback paramCronetTaskNetworkStateCallback)
  {
    cronetTaskNetworkStateCallbackList.add(paramCronetTaskNetworkStateCallback);
  }
  
  public static native void cancelCronetTask(String paramString);
  
  public static CertVerifyResult convertToCronetResult(AndroidCertVerifyResult paramAndroidCertVerifyResult)
  {
    CertVerifyResult localCertVerifyResult = new CertVerifyResult();
    localCertVerifyResult.status = paramAndroidCertVerifyResult.getStatus();
    localCertVerifyResult.isIssuedByKnownRoot = paramAndroidCertVerifyResult.isIssuedByKnownRoot();
    localCertVerifyResult.certificateChain = paramAndroidCertVerifyResult.getCertificateChainEncoded();
    return localCertVerifyResult;
  }
  
  public static Map<String, List<String>> getHeaderList(CronetLogic.ResponseHeader paramResponseHeader)
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
  
  public static Map<String, String> getHeaderMap(CronetLogic.ResponseHeader paramResponseHeader)
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
  
  public static void notifyCronetWeaknet(boolean paramBoolean)
  {
    Object localObject = new StringBuilder("receive weaknet notify ");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Log.i("cronet", i);
      if ((cronetTaskNetworkStateCallbackList == null) || (cronetTaskNetworkStateCallbackList.size() <= 0)) {
        break;
      }
      localObject = cronetTaskNetworkStateCallbackList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((CronetTaskNetworkStateCallback)((Iterator)localObject).next()).onNetWeakChange(paramBoolean);
      }
    }
  }
  
  public static void removeCronetTaskNetworkStateCallback(CronetTaskNetworkStateCallback paramCronetTaskNetworkStateCallback)
  {
    cronetTaskNetworkStateCallbackList.remove(paramCronetTaskNetworkStateCallback);
  }
  
  public static native void removeUserCert();
  
  public static native void setGoodNetNotifyInterval(int paramInt);
  
  public static void setUseHttpdns(boolean paramBoolean)
  {
    Log.i("cronet", "use httpdns ".concat(String.valueOf(paramBoolean)));
    useHttpdns = paramBoolean;
  }
  
  public static native void setUserCertVerify(boolean paramBoolean);
  
  public static native CronetLogic.CronetHttpsCreateResult startCronetDefaultHttpTask(CronetLogic.CronetRequestParams paramCronetRequestParams, CronetLogic.CronetTaskCallback paramCronetTaskCallback);
  
  public static native CronetLogic.CronetHttpsCreateResult startCronetDownloadTask(CronetLogic.CronetRequestParams paramCronetRequestParams, CronetLogic.CronetTaskCallback paramCronetTaskCallback);
  
  public static native CronetLogic.CronetHttpsCreateResult startCronetHttpTask(CronetLogic.CronetRequestParams paramCronetRequestParams, CronetLogic.CronetTaskCallback paramCronetTaskCallback);
  
  public static CertVerifyResult verifyCertWithUserCA(byte[][] paramArrayOfByte)
  {
    int j = 0;
    label436:
    label439:
    label442:
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
            break label436;
          }
          localObject2 = (X509Certificate)localKeyStore.getCertificate((String)paramArrayOfByte.next());
          localObject3 = ((List)localObject1).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label442;
          }
          localX509Certificate = (X509Certificate)((Iterator)localObject3).next();
          try
          {
            localX509Certificate.verify(((X509Certificate)localObject2).getPublicKey());
            Log.i("cronet", "do user verify success");
            i = 1;
            if (i == 0) {
              break label439;
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
  
  public static abstract interface CronetTaskNetworkStateCallback
  {
    public abstract void onNetWeakChange(boolean paramBoolean);
  }
  
  public static class HeaderMap
  {
    public String key = "";
    public String value = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mars.cdn.CronetLogic
 * JD-Core Version:    0.7.0.1
 */