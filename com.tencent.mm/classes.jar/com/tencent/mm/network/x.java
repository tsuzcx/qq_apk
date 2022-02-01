package com.tencent.mm.network;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetHttpsCreateResult;
import com.tencent.mars.cdn.CronetLogic.CronetRequestParams;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.DefaultHttpTaskParams;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class x
  implements CronetLogic.CronetTaskCallback, w
{
  private String cgz;
  private boolean iFA;
  private String iFB;
  private Map<String, String> iFC;
  public int iFD;
  public int iFE;
  private int iFF;
  String iFG;
  private byte[] iFH;
  private boolean iFI;
  public boolean iFJ;
  private boolean iFK;
  private boolean iFL;
  private CronetLogic.CronetTaskCallback iFM;
  private int iFN;
  private int iFO;
  private byte[] iFP;
  private String iFQ;
  private String iFR;
  private Map<String, List<String>> iFS;
  public int iFT;
  public boolean iFU;
  private int mErrorCode;
  private String mSavePath;
  private String mURL;
  
  public x(String paramString, int paramInt)
  {
    AppMethodBeat.i(132870);
    this.iFA = false;
    this.iFB = "";
    this.iFC = new HashMap();
    this.iFD = 5000;
    this.iFE = 5000;
    this.cgz = "GET";
    this.iFI = false;
    this.iFJ = false;
    this.iFK = false;
    this.iFL = false;
    this.iFN = 8;
    this.iFO = -1;
    this.iFQ = "";
    this.mErrorCode = 0;
    this.iFR = "";
    this.iFS = new HashMap();
    this.iFT = 0;
    this.iFU = false;
    this.mURL = paramString;
    this.iFF = paramInt;
    AppMethodBeat.o(132870);
  }
  
  private void a(CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    try
    {
      AppMethodBeat.i(132880);
      this.iFA = true;
      this.iFO = paramCronetTaskResult.statusCode;
      this.iFP = paramCronetTaskResult.data;
      this.iFQ = paramCronetTaskResult.errorMsg;
      this.mErrorCode = paramCronetTaskResult.errorCode;
      this.iFR = paramCronetTaskResult.statusText;
      this.iFS = paramCronetTaskResult.getHeaderMapList();
      notify();
      AppMethodBeat.o(132880);
      return;
    }
    finally
    {
      paramCronetTaskResult = finally;
      throw paramCronetTaskResult;
    }
  }
  
  private void aOW()
  {
    try
    {
      AppMethodBeat.i(132881);
      Object localObject1 = new CronetLogic.CronetRequestParams();
      ((CronetLogic.CronetRequestParams)localObject1).url = this.mURL;
      ((CronetLogic.CronetRequestParams)localObject1).followRedirect = false;
      ((CronetLogic.CronetRequestParams)localObject1).bodyData = this.iFH;
      ((CronetLogic.CronetRequestParams)localObject1).method = this.cgz;
      ((CronetLogic.CronetRequestParams)localObject1).useMemoryCache = this.iFJ;
      ((CronetLogic.CronetRequestParams)localObject1).useHttp2 = this.iFK;
      ((CronetLogic.CronetRequestParams)localObject1).useQuic = this.iFL;
      ((CronetLogic.CronetRequestParams)localObject1).makeRequestHeader(this.iFC);
      ((CronetLogic.CronetRequestParams)localObject1).taskType = this.iFN;
      if (this.iFT != 0)
      {
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams = new CronetLogic.DefaultHttpTaskParams();
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams.reportId = this.iFT;
      }
      switch (this.iFN)
      {
      }
      for (;;)
      {
        ((CronetLogic.CronetRequestParams)localObject1).useNewdns = this.iFU;
        localObject1 = CronetLogic.startCronetDefaultHttpTask((CronetLogic.CronetRequestParams)localObject1, this);
        for (;;)
        {
          this.iFB = ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId;
          try
          {
            wait(this.iFD + this.iFE);
            if (!this.iFA) {
              CronetLogic.cancelCronetTask(this.iFB);
            }
            aOX();
            AppMethodBeat.o(132881);
            return;
            localObject1 = CronetLogic.startCronetHttpTask((CronetLogic.CronetRequestParams)localObject1, this);
            continue;
            ((CronetLogic.CronetRequestParams)localObject1).savePath = this.mSavePath;
            ((CronetLogic.CronetRequestParams)localObject1).needWirteCache = true;
            localObject1 = CronetLogic.startCronetDownloadTask((CronetLogic.CronetRequestParams)localObject1, this);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.e("MicroMsg.CronetConnect", "createAndStartCronetRequest " + localException.getLocalizedMessage());
            }
          }
        }
      }
    }
    finally {}
  }
  
  private void aOX()
  {
    AppMethodBeat.i(132882);
    Object localObject = new HashMap();
    ((Map)localObject).putAll(this.iFS);
    this.iFS.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry != null) && (localEntry.getKey() != null))
      {
        String str = (String)localEntry.getKey();
        this.iFS.put(str.toLowerCase(), localEntry.getValue());
      }
    }
    AppMethodBeat.o(132882);
  }
  
  public final void Iv(String paramString)
  {
    AppMethodBeat.i(132872);
    this.iFC.put("Referer", paramString);
    AppMethodBeat.o(132872);
  }
  
  public final void a(CronetLogic.CronetTaskCallback paramCronetTaskCallback)
  {
    this.iFM = paramCronetTaskCallback;
  }
  
  public final String aOR()
  {
    return this.iFG;
  }
  
  public final int aOS()
  {
    return this.iFF;
  }
  
  public final void aOT()
  {
    this.iFI = false;
  }
  
  public final void aOU()
  {
    this.iFN = 2;
  }
  
  public final void aOV()
  {
    this.iFK = true;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(189850);
    if (("".equals(this.iFB)) && (this.iFN == 2)) {
      aOW();
    }
    AppMethodBeat.o(189850);
  }
  
  public final void disconnect() {}
  
  public final int getContentLength()
  {
    AppMethodBeat.i(132875);
    String str = getHeaderField("content-length");
    if (str == null)
    {
      AppMethodBeat.o(132875);
      return -1;
    }
    l1 = -1L;
    try
    {
      long l2 = Long.parseLong(str);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.CronetConnect", "getContentLength content-length " + localException.getLocalizedMessage());
      }
      int i = (int)l1;
      AppMethodBeat.o(132875);
      return i;
    }
    if (l1 > 2147483647L)
    {
      AppMethodBeat.o(132875);
      return -1;
    }
  }
  
  public final String getContentType()
  {
    AppMethodBeat.i(221714);
    String str = getHeaderField("content-type");
    AppMethodBeat.o(221714);
    return str;
  }
  
  public final String getHeaderField(String paramString)
  {
    AppMethodBeat.i(132878);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(132878);
      return "";
    }
    List localList = (List)this.iFS.get(paramString.toLowerCase());
    if (localList == null)
    {
      ad.w("MicroMsg.CronetConnect", "getHeaderField %s is null", new Object[] { paramString });
      AppMethodBeat.o(132878);
      return "";
    }
    ad.i("MicroMsg.CronetConnect", "getHeaderField field %s, value %s ", new Object[] { paramString, localList.get(0) });
    paramString = (String)localList.get(0);
    AppMethodBeat.o(132878);
    return paramString;
  }
  
  public final int getHeaderFieldInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(132874);
    String str = getHeaderField(paramString);
    try
    {
      int i = Integer.parseInt(str);
      AppMethodBeat.o(132874);
      return i;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CronetConnect", "getHeaderFieldInt field " + paramString + " " + localException.getLocalizedMessage());
      AppMethodBeat.o(132874);
    }
    return paramInt;
  }
  
  public final Map<String, List<String>> getHeaderFields()
  {
    return this.iFS;
  }
  
  public final String getHost()
  {
    return "";
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(132877);
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.iFP);
    AppMethodBeat.o(132877);
    return localByteArrayInputStream;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(132876);
    if ((this.iFA) && (this.iFO != -1))
    {
      i = this.iFO;
      AppMethodBeat.o(132876);
      return i;
    }
    if ("".equals(this.iFB)) {
      aOW();
    }
    int i = this.iFO;
    AppMethodBeat.o(132876);
    return i;
  }
  
  public final String getResponseMessage()
  {
    return this.iFR;
  }
  
  public final String getSavePath()
  {
    return this.mSavePath;
  }
  
  public final String getURL()
  {
    return this.mURL;
  }
  
  public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
  {
    AppMethodBeat.i(189853);
    if (this.iFM != null)
    {
      this.iFS = CronetLogic.getHeaderList(paramResponseHeader);
      paramInt = this.iFM.onCronetReceiveHeader(paramResponseHeader, paramInt);
      AppMethodBeat.o(189853);
      return paramInt;
    }
    AppMethodBeat.o(189853);
    return 0;
  }
  
  public final void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    AppMethodBeat.i(132879);
    ad.i("MicroMsg.CronetConnect", "receive callback, status %d, error %d, msg %s", new Object[] { Integer.valueOf(paramCronetTaskResult.statusCode), Integer.valueOf(paramCronetTaskResult.errorCode), paramCronetTaskResult.errorMsg });
    a(paramCronetTaskResult);
    if (this.iFM != null) {
      this.iFM.onCronetTaskCompleted(paramString, paramCronetTaskResult);
    }
    AppMethodBeat.o(132879);
  }
  
  public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress)
  {
    AppMethodBeat.i(189852);
    if (this.iFM != null) {
      this.iFM.onDownloadProgressChanged(paramString, paramCronetDownloadProgress);
    }
    AppMethodBeat.o(189852);
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.iFD = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.iFE = paramInt;
  }
  
  public final void setRequestMethod(String paramString)
  {
    this.cgz = paramString;
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132871);
    this.iFC.put(paramString1, paramString2);
    AppMethodBeat.o(132871);
  }
  
  public final void setSavePath(String paramString)
  {
    this.mSavePath = paramString;
  }
  
  public final void setUseCaches(boolean paramBoolean)
  {
    this.iFJ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.x
 * JD-Core Version:    0.7.0.1
 */