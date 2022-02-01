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
  private String bZn;
  private boolean hLN;
  private String hLO;
  private Map<String, String> hLP;
  public int hLQ;
  public int hLR;
  private int hLS;
  String hLT;
  private byte[] hLU;
  private boolean hLV;
  public boolean hLW;
  private boolean hLX;
  private boolean hLY;
  private CronetLogic.CronetTaskCallback hLZ;
  private int hMa;
  private int hMb;
  private byte[] hMc;
  private String hMd;
  private String hMe;
  private Map<String, List<String>> hMf;
  public int hMg;
  private int mErrorCode;
  private String mSavePath;
  private String mURL;
  
  public x(String paramString, int paramInt)
  {
    AppMethodBeat.i(132870);
    this.hLN = false;
    this.hLO = "";
    this.hLP = new HashMap();
    this.hLQ = 5000;
    this.hLR = 5000;
    this.bZn = "GET";
    this.hLV = false;
    this.hLW = false;
    this.hLX = false;
    this.hLY = false;
    this.hMa = 8;
    this.hMb = -1;
    this.hMd = "";
    this.mErrorCode = 0;
    this.hMe = "";
    this.hMf = new HashMap();
    this.hMg = 0;
    this.mURL = paramString;
    this.hLS = paramInt;
    AppMethodBeat.o(132870);
  }
  
  private void a(CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    try
    {
      AppMethodBeat.i(132880);
      this.hLN = true;
      this.hMb = paramCronetTaskResult.statusCode;
      this.hMc = paramCronetTaskResult.data;
      this.hMd = paramCronetTaskResult.errorMsg;
      this.mErrorCode = paramCronetTaskResult.errorCode;
      this.hMe = paramCronetTaskResult.statusText;
      this.hMf = paramCronetTaskResult.getHeaderMapList();
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
  
  private void aEY()
  {
    try
    {
      AppMethodBeat.i(132881);
      Object localObject1 = new CronetLogic.CronetRequestParams();
      ((CronetLogic.CronetRequestParams)localObject1).url = this.mURL;
      ((CronetLogic.CronetRequestParams)localObject1).followRedirect = false;
      ((CronetLogic.CronetRequestParams)localObject1).bodyData = this.hLU;
      ((CronetLogic.CronetRequestParams)localObject1).method = this.bZn;
      ((CronetLogic.CronetRequestParams)localObject1).useMemoryCache = this.hLW;
      ((CronetLogic.CronetRequestParams)localObject1).useHttp2 = this.hLX;
      ((CronetLogic.CronetRequestParams)localObject1).useQuic = this.hLY;
      ((CronetLogic.CronetRequestParams)localObject1).makeRequestHeader(this.hLP);
      ((CronetLogic.CronetRequestParams)localObject1).taskType = this.hMa;
      if (this.hMg != 0)
      {
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams = new CronetLogic.DefaultHttpTaskParams();
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams.reportId = this.hMg;
      }
      switch (this.hMa)
      {
      }
      for (;;)
      {
        localObject1 = CronetLogic.startCronetDefaultHttpTask((CronetLogic.CronetRequestParams)localObject1, this);
        for (;;)
        {
          this.hLO = ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId;
          try
          {
            wait(this.hLQ + this.hLR);
            if (!this.hLN) {
              CronetLogic.cancelCronetTask(this.hLO);
            }
            aEZ();
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
  
  private void aEZ()
  {
    AppMethodBeat.i(132882);
    Object localObject = new HashMap();
    ((Map)localObject).putAll(this.hMf);
    this.hMf.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry != null) && (localEntry.getKey() != null))
      {
        String str = (String)localEntry.getKey();
        this.hMf.put(str.toLowerCase(), localEntry.getValue());
      }
    }
    AppMethodBeat.o(132882);
  }
  
  public final void Bc(String paramString)
  {
    AppMethodBeat.i(132872);
    this.hLP.put("Referer", paramString);
    AppMethodBeat.o(132872);
  }
  
  public final void a(CronetLogic.CronetTaskCallback paramCronetTaskCallback)
  {
    this.hLZ = paramCronetTaskCallback;
  }
  
  public final String aES()
  {
    return this.hLT;
  }
  
  public final int aET()
  {
    return this.hLS;
  }
  
  public final void aEU()
  {
    this.hLV = false;
  }
  
  public final String aEV()
  {
    return this.mSavePath;
  }
  
  public final void aEW()
  {
    this.hMa = 2;
  }
  
  public final void aEX()
  {
    this.hLX = true;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(192880);
    if (("".equals(this.hLO)) && (this.hMa == 2)) {
      aEY();
    }
    AppMethodBeat.o(192880);
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
    AppMethodBeat.i(202271);
    String str = getHeaderField("content-type");
    AppMethodBeat.o(202271);
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
    List localList = (List)this.hMf.get(paramString.toLowerCase());
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
    return this.hMf;
  }
  
  public final String getHost()
  {
    return "";
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(132877);
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.hMc);
    AppMethodBeat.o(132877);
    return localByteArrayInputStream;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(132876);
    if ((this.hLN) && (this.hMb != -1))
    {
      i = this.hMb;
      AppMethodBeat.o(132876);
      return i;
    }
    if ("".equals(this.hLO)) {
      aEY();
    }
    int i = this.hMb;
    AppMethodBeat.o(132876);
    return i;
  }
  
  public final String getResponseMessage()
  {
    return this.hMe;
  }
  
  public final String getURL()
  {
    return this.mURL;
  }
  
  public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
  {
    AppMethodBeat.i(192883);
    if (this.hLZ != null)
    {
      this.hMf = CronetLogic.getHeaderList(paramResponseHeader);
      paramInt = this.hLZ.onCronetReceiveHeader(paramResponseHeader, paramInt);
      AppMethodBeat.o(192883);
      return paramInt;
    }
    AppMethodBeat.o(192883);
    return 0;
  }
  
  public final void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    AppMethodBeat.i(132879);
    ad.i("MicroMsg.CronetConnect", "receive callback, status %d, error %d, msg %s", new Object[] { Integer.valueOf(paramCronetTaskResult.statusCode), Integer.valueOf(paramCronetTaskResult.errorCode), paramCronetTaskResult.errorMsg });
    a(paramCronetTaskResult);
    if (this.hLZ != null) {
      this.hLZ.onCronetTaskCompleted(paramString, paramCronetTaskResult);
    }
    AppMethodBeat.o(132879);
  }
  
  public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress)
  {
    AppMethodBeat.i(192882);
    if (this.hLZ != null) {
      this.hLZ.onDownloadProgressChanged(paramString, paramCronetDownloadProgress);
    }
    AppMethodBeat.o(192882);
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.hLQ = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.hLR = paramInt;
  }
  
  public final void setRequestMethod(String paramString)
  {
    this.bZn = paramString;
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132871);
    this.hLP.put(paramString1, paramString2);
    AppMethodBeat.o(132871);
  }
  
  public final void setSavePath(String paramString)
  {
    this.mSavePath = paramString;
  }
  
  public final void setUseCaches(boolean paramBoolean)
  {
    this.hLW = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.x
 * JD-Core Version:    0.7.0.1
 */