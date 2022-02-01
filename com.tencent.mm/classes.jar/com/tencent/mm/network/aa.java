package com.tencent.mm.network;

import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.ChunkedData;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetHttpsCreateResult;
import com.tencent.mars.cdn.CronetLogic.CronetRequestParams;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.DefaultHttpTaskParams;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class aa
  implements CronetLogic.CronetTaskCallback, z
{
  public String eir;
  private int mErrorCode;
  public String mSavePath;
  public String mURL;
  private boolean poZ;
  private String ppa;
  private Map<String, String> ppb;
  public int ppc;
  public int ppd;
  private int ppe;
  String ppf;
  private byte[] ppg;
  public boolean pph;
  public boolean ppi;
  public boolean ppj;
  private boolean ppk;
  public CronetLogic.CronetTaskCallback ppl;
  public int ppm;
  private int ppn;
  private byte[] ppo;
  private String ppp;
  public String ppq;
  public Map<String, List<String>> ppr;
  public int pps;
  public boolean ppt;
  
  public aa(String paramString, int paramInt)
  {
    AppMethodBeat.i(132870);
    this.poZ = false;
    this.ppa = "";
    this.ppb = new HashMap();
    this.ppc = 5000;
    this.ppd = 5000;
    this.eir = "GET";
    this.pph = false;
    this.ppi = false;
    this.ppj = false;
    this.ppk = false;
    this.ppm = 8;
    this.ppn = -1;
    this.ppp = "";
    this.mErrorCode = 0;
    this.ppq = "";
    this.ppr = new HashMap();
    this.pps = 0;
    this.ppt = false;
    this.mURL = paramString;
    this.ppe = paramInt;
    AppMethodBeat.o(132870);
  }
  
  private void a(CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    try
    {
      AppMethodBeat.i(132880);
      this.poZ = true;
      this.ppn = paramCronetTaskResult.statusCode;
      this.ppo = paramCronetTaskResult.data;
      this.ppp = paramCronetTaskResult.errorMsg;
      this.mErrorCode = paramCronetTaskResult.errorCode;
      this.ppq = paramCronetTaskResult.statusText;
      this.ppr = paramCronetTaskResult.getHeaderMapList();
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
  
  private void bRi()
  {
    try
    {
      AppMethodBeat.i(132881);
      Object localObject1 = new CronetLogic.CronetRequestParams();
      ((CronetLogic.CronetRequestParams)localObject1).url = this.mURL;
      ((CronetLogic.CronetRequestParams)localObject1).followRedirect = false;
      ((CronetLogic.CronetRequestParams)localObject1).bodyData = this.ppg;
      ((CronetLogic.CronetRequestParams)localObject1).method = this.eir;
      ((CronetLogic.CronetRequestParams)localObject1).useMemoryCache = this.ppi;
      ((CronetLogic.CronetRequestParams)localObject1).useHttp2 = this.ppj;
      ((CronetLogic.CronetRequestParams)localObject1).useQuic = this.ppk;
      ((CronetLogic.CronetRequestParams)localObject1).makeRequestHeader(this.ppb);
      ((CronetLogic.CronetRequestParams)localObject1).taskType = this.ppm;
      if (this.pps != 0)
      {
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams = new CronetLogic.DefaultHttpTaskParams();
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams.reportId = this.pps;
      }
      switch (this.ppm)
      {
      }
      for (;;)
      {
        ((CronetLogic.CronetRequestParams)localObject1).useNewdns = this.ppt;
        localObject1 = CronetLogic.startCronetDefaultHttpTask((CronetLogic.CronetRequestParams)localObject1, this);
        for (;;)
        {
          this.ppa = ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId;
          try
          {
            wait(this.ppc + this.ppd);
            if (!this.poZ) {
              CronetLogic.cancelCronetTask(this.ppa);
            }
            bRj();
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
              Log.e("MicroMsg.CronetConnect", "createAndStartCronetRequest " + localException.getLocalizedMessage());
            }
          }
        }
      }
    }
    finally {}
  }
  
  private void bRj()
  {
    AppMethodBeat.i(132882);
    Object localObject = new HashMap();
    ((Map)localObject).putAll(this.ppr);
    this.ppr.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry != null) && (localEntry.getKey() != null))
      {
        String str = (String)localEntry.getKey();
        this.ppr.put(str.toLowerCase(), (List)localEntry.getValue());
      }
    }
    AppMethodBeat.o(132882);
  }
  
  public final void Rx(String paramString)
  {
    this.eir = paramString;
  }
  
  public final void Ry(String paramString)
  {
    AppMethodBeat.i(132872);
    this.ppb.put("Referer", paramString);
    AppMethodBeat.o(132872);
  }
  
  public final int bRd()
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
        Log.e("MicroMsg.CronetConnect", "getContentLength content-length " + localException.getLocalizedMessage());
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
  
  public final String bRe()
  {
    AppMethodBeat.i(369588);
    String str = getHeaderField("content-type");
    AppMethodBeat.o(369588);
    return str;
  }
  
  public final Map<String, List<String>> bRf()
  {
    return this.ppr;
  }
  
  public final String bRg()
  {
    return this.ppf;
  }
  
  public final int bRh()
  {
    return this.ppe;
  }
  
  public final int bk(String paramString, int paramInt)
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
      Log.e("MicroMsg.CronetConnect", "getHeaderFieldInt field " + paramString + " " + localException.getLocalizedMessage());
      AppMethodBeat.o(132874);
    }
    return paramInt;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(241135);
    if (("".equals(this.ppa)) && (this.ppm == 2)) {
      bRi();
    }
    AppMethodBeat.o(241135);
  }
  
  public final void disconnect() {}
  
  public final String getHeaderField(String paramString)
  {
    AppMethodBeat.i(132878);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(132878);
      return "";
    }
    List localList = (List)this.ppr.get(paramString.toLowerCase());
    if (localList == null)
    {
      Log.w("MicroMsg.CronetConnect", "getHeaderField %s is null", new Object[] { paramString });
      AppMethodBeat.o(132878);
      return "";
    }
    Log.i("MicroMsg.CronetConnect", "getHeaderField field %s, value %s ", new Object[] { paramString, localList.get(0) });
    paramString = (String)localList.get(0);
    AppMethodBeat.o(132878);
    return paramString;
  }
  
  public final String getHost()
  {
    return "";
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(132877);
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.ppo);
    AppMethodBeat.o(132877);
    return localByteArrayInputStream;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(132876);
    if ((this.poZ) && (this.ppn != -1))
    {
      i = this.ppn;
      AppMethodBeat.o(132876);
      return i;
    }
    if ("".equals(this.ppa)) {
      bRi();
    }
    int i = this.ppn;
    AppMethodBeat.o(132876);
    return i;
  }
  
  public final void hB(boolean paramBoolean)
  {
    this.ppi = paramBoolean;
  }
  
  public final void onCronetReceiveChunkedData(CronetLogic.ChunkedData paramChunkedData, long paramLong) {}
  
  public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt, String paramString)
  {
    AppMethodBeat.i(241162);
    Log.d("MicroMsg.CronetConnect", "onCronetReceiveHeader ".concat(String.valueOf(paramInt)));
    if (this.ppl != null)
    {
      this.ppr = CronetLogic.getHeaderList(paramResponseHeader);
      paramInt = this.ppl.onCronetReceiveHeader(paramResponseHeader, paramInt, paramString);
      AppMethodBeat.o(241162);
      return paramInt;
    }
    AppMethodBeat.o(241162);
    return 0;
  }
  
  public final void onCronetReceiveUploadProgress(long paramLong1, long paramLong2) {}
  
  public final void onCronetTaskCompleted(String paramString1, CronetLogic.CronetTaskResult paramCronetTaskResult, String paramString2)
  {
    AppMethodBeat.i(241160);
    Log.i("MicroMsg.CronetConnect", "receive callback, status %d, error %d, msg %s", new Object[] { Integer.valueOf(paramCronetTaskResult.statusCode), Integer.valueOf(paramCronetTaskResult.errorCode), paramCronetTaskResult.errorMsg });
    a(paramCronetTaskResult);
    if (this.ppl != null) {
      this.ppl.onCronetTaskCompleted(paramString1, paramCronetTaskResult, paramString2);
    }
    AppMethodBeat.o(241160);
  }
  
  public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress)
  {
    AppMethodBeat.i(241157);
    if (this.ppl != null) {
      this.ppl.onDownloadProgressChanged(paramString, paramCronetDownloadProgress);
    }
    AppMethodBeat.o(241157);
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132871);
    this.ppb.put(paramString1, paramString2);
    AppMethodBeat.o(132871);
  }
  
  public final void xx(int paramInt)
  {
    this.ppc = paramInt;
  }
  
  public final void xy(int paramInt)
  {
    this.ppd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.aa
 * JD-Core Version:    0.7.0.1
 */