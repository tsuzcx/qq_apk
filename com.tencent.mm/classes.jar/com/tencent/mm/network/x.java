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
import com.tencent.mm.sdk.platformtools.ac;
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
  private String bWk;
  private String imA;
  private Map<String, List<String>> imB;
  public int imC;
  public boolean imD;
  private boolean imj;
  private String imk;
  private Map<String, String> iml;
  public int imm;
  public int imn;
  private int imo;
  String imp;
  private byte[] imq;
  private boolean imr;
  public boolean ims;
  private boolean imt;
  private boolean imu;
  private CronetLogic.CronetTaskCallback imv;
  private int imw;
  private int imx;
  private byte[] imy;
  private String imz;
  private int mErrorCode;
  private String mSavePath;
  private String mURL;
  
  public x(String paramString, int paramInt)
  {
    AppMethodBeat.i(132870);
    this.imj = false;
    this.imk = "";
    this.iml = new HashMap();
    this.imm = 5000;
    this.imn = 5000;
    this.bWk = "GET";
    this.imr = false;
    this.ims = false;
    this.imt = false;
    this.imu = false;
    this.imw = 8;
    this.imx = -1;
    this.imz = "";
    this.mErrorCode = 0;
    this.imA = "";
    this.imB = new HashMap();
    this.imC = 0;
    this.imD = false;
    this.mURL = paramString;
    this.imo = paramInt;
    AppMethodBeat.o(132870);
  }
  
  private void a(CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    try
    {
      AppMethodBeat.i(132880);
      this.imj = true;
      this.imx = paramCronetTaskResult.statusCode;
      this.imy = paramCronetTaskResult.data;
      this.imz = paramCronetTaskResult.errorMsg;
      this.mErrorCode = paramCronetTaskResult.errorCode;
      this.imA = paramCronetTaskResult.statusText;
      this.imB = paramCronetTaskResult.getHeaderMapList();
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
  
  private void aLP()
  {
    try
    {
      AppMethodBeat.i(132881);
      Object localObject1 = new CronetLogic.CronetRequestParams();
      ((CronetLogic.CronetRequestParams)localObject1).url = this.mURL;
      ((CronetLogic.CronetRequestParams)localObject1).followRedirect = false;
      ((CronetLogic.CronetRequestParams)localObject1).bodyData = this.imq;
      ((CronetLogic.CronetRequestParams)localObject1).method = this.bWk;
      ((CronetLogic.CronetRequestParams)localObject1).useMemoryCache = this.ims;
      ((CronetLogic.CronetRequestParams)localObject1).useHttp2 = this.imt;
      ((CronetLogic.CronetRequestParams)localObject1).useQuic = this.imu;
      ((CronetLogic.CronetRequestParams)localObject1).makeRequestHeader(this.iml);
      ((CronetLogic.CronetRequestParams)localObject1).taskType = this.imw;
      if (this.imC != 0)
      {
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams = new CronetLogic.DefaultHttpTaskParams();
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams.reportId = this.imC;
      }
      switch (this.imw)
      {
      }
      for (;;)
      {
        ((CronetLogic.CronetRequestParams)localObject1).useNewdns = this.imD;
        localObject1 = CronetLogic.startCronetDefaultHttpTask((CronetLogic.CronetRequestParams)localObject1, this);
        for (;;)
        {
          this.imk = ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId;
          try
          {
            wait(this.imm + this.imn);
            if (!this.imj) {
              CronetLogic.cancelCronetTask(this.imk);
            }
            aLQ();
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
              ac.e("MicroMsg.CronetConnect", "createAndStartCronetRequest " + localException.getLocalizedMessage());
            }
          }
        }
      }
    }
    finally {}
  }
  
  private void aLQ()
  {
    AppMethodBeat.i(132882);
    Object localObject = new HashMap();
    ((Map)localObject).putAll(this.imB);
    this.imB.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry != null) && (localEntry.getKey() != null))
      {
        String str = (String)localEntry.getKey();
        this.imB.put(str.toLowerCase(), localEntry.getValue());
      }
    }
    AppMethodBeat.o(132882);
  }
  
  public final void Fh(String paramString)
  {
    AppMethodBeat.i(132872);
    this.iml.put("Referer", paramString);
    AppMethodBeat.o(132872);
  }
  
  public final void a(CronetLogic.CronetTaskCallback paramCronetTaskCallback)
  {
    this.imv = paramCronetTaskCallback;
  }
  
  public final String aLJ()
  {
    return this.imp;
  }
  
  public final int aLK()
  {
    return this.imo;
  }
  
  public final void aLL()
  {
    this.imr = false;
  }
  
  public final String aLM()
  {
    return this.mSavePath;
  }
  
  public final void aLN()
  {
    this.imw = 2;
  }
  
  public final void aLO()
  {
    this.imt = true;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(206893);
    if (("".equals(this.imk)) && (this.imw == 2)) {
      aLP();
    }
    AppMethodBeat.o(206893);
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
        ac.e("MicroMsg.CronetConnect", "getContentLength content-length " + localException.getLocalizedMessage());
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
    AppMethodBeat.i(210307);
    String str = getHeaderField("content-type");
    AppMethodBeat.o(210307);
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
    List localList = (List)this.imB.get(paramString.toLowerCase());
    if (localList == null)
    {
      ac.w("MicroMsg.CronetConnect", "getHeaderField %s is null", new Object[] { paramString });
      AppMethodBeat.o(132878);
      return "";
    }
    ac.i("MicroMsg.CronetConnect", "getHeaderField field %s, value %s ", new Object[] { paramString, localList.get(0) });
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
      ac.e("MicroMsg.CronetConnect", "getHeaderFieldInt field " + paramString + " " + localException.getLocalizedMessage());
      AppMethodBeat.o(132874);
    }
    return paramInt;
  }
  
  public final Map<String, List<String>> getHeaderFields()
  {
    return this.imB;
  }
  
  public final String getHost()
  {
    return "";
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(132877);
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.imy);
    AppMethodBeat.o(132877);
    return localByteArrayInputStream;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(132876);
    if ((this.imj) && (this.imx != -1))
    {
      i = this.imx;
      AppMethodBeat.o(132876);
      return i;
    }
    if ("".equals(this.imk)) {
      aLP();
    }
    int i = this.imx;
    AppMethodBeat.o(132876);
    return i;
  }
  
  public final String getResponseMessage()
  {
    return this.imA;
  }
  
  public final String getURL()
  {
    return this.mURL;
  }
  
  public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt)
  {
    AppMethodBeat.i(206896);
    if (this.imv != null)
    {
      this.imB = CronetLogic.getHeaderList(paramResponseHeader);
      paramInt = this.imv.onCronetReceiveHeader(paramResponseHeader, paramInt);
      AppMethodBeat.o(206896);
      return paramInt;
    }
    AppMethodBeat.o(206896);
    return 0;
  }
  
  public final void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    AppMethodBeat.i(132879);
    ac.i("MicroMsg.CronetConnect", "receive callback, status %d, error %d, msg %s", new Object[] { Integer.valueOf(paramCronetTaskResult.statusCode), Integer.valueOf(paramCronetTaskResult.errorCode), paramCronetTaskResult.errorMsg });
    a(paramCronetTaskResult);
    if (this.imv != null) {
      this.imv.onCronetTaskCompleted(paramString, paramCronetTaskResult);
    }
    AppMethodBeat.o(132879);
  }
  
  public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress)
  {
    AppMethodBeat.i(206895);
    if (this.imv != null) {
      this.imv.onDownloadProgressChanged(paramString, paramCronetDownloadProgress);
    }
    AppMethodBeat.o(206895);
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.imm = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.imn = paramInt;
  }
  
  public final void setRequestMethod(String paramString)
  {
    this.bWk = paramString;
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132871);
    this.iml.put(paramString1, paramString2);
    AppMethodBeat.o(132871);
  }
  
  public final void setSavePath(String paramString)
  {
    this.mSavePath = paramString;
  }
  
  public final void setUseCaches(boolean paramBoolean)
  {
    this.ims = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.x
 * JD-Core Version:    0.7.0.1
 */