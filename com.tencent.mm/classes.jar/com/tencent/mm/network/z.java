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
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class z
  implements CronetLogic.CronetTaskCallback, y
{
  private String cqz;
  private int mErrorCode;
  private String mSavePath;
  private String mURL;
  private boolean mvA;
  private String mvB;
  private Map<String, String> mvC;
  public int mvD;
  public int mvE;
  private int mvF;
  String mvG;
  private byte[] mvH;
  private boolean mvI;
  public boolean mvJ;
  private boolean mvK;
  private boolean mvL;
  private CronetLogic.CronetTaskCallback mvM;
  private int mvN;
  private int mvO;
  private byte[] mvP;
  private String mvQ;
  private String mvR;
  private Map<String, List<String>> mvS;
  public int mvT;
  public boolean mvU;
  
  public z(String paramString, int paramInt)
  {
    AppMethodBeat.i(132870);
    this.mvA = false;
    this.mvB = "";
    this.mvC = new HashMap();
    this.mvD = 5000;
    this.mvE = 5000;
    this.cqz = "GET";
    this.mvI = false;
    this.mvJ = false;
    this.mvK = false;
    this.mvL = false;
    this.mvN = 8;
    this.mvO = -1;
    this.mvQ = "";
    this.mErrorCode = 0;
    this.mvR = "";
    this.mvS = new HashMap();
    this.mvT = 0;
    this.mvU = false;
    this.mURL = paramString;
    this.mvF = paramInt;
    AppMethodBeat.o(132870);
  }
  
  private void a(CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    try
    {
      AppMethodBeat.i(132880);
      this.mvA = true;
      this.mvO = paramCronetTaskResult.statusCode;
      this.mvP = paramCronetTaskResult.data;
      this.mvQ = paramCronetTaskResult.errorMsg;
      this.mErrorCode = paramCronetTaskResult.errorCode;
      this.mvR = paramCronetTaskResult.statusText;
      this.mvS = paramCronetTaskResult.getHeaderMapList();
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
  
  private void btE()
  {
    try
    {
      AppMethodBeat.i(132881);
      Object localObject1 = new CronetLogic.CronetRequestParams();
      ((CronetLogic.CronetRequestParams)localObject1).url = this.mURL;
      ((CronetLogic.CronetRequestParams)localObject1).followRedirect = false;
      ((CronetLogic.CronetRequestParams)localObject1).bodyData = this.mvH;
      ((CronetLogic.CronetRequestParams)localObject1).method = this.cqz;
      ((CronetLogic.CronetRequestParams)localObject1).useMemoryCache = this.mvJ;
      ((CronetLogic.CronetRequestParams)localObject1).useHttp2 = this.mvK;
      ((CronetLogic.CronetRequestParams)localObject1).useQuic = this.mvL;
      ((CronetLogic.CronetRequestParams)localObject1).makeRequestHeader(this.mvC);
      ((CronetLogic.CronetRequestParams)localObject1).taskType = this.mvN;
      if (this.mvT != 0)
      {
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams = new CronetLogic.DefaultHttpTaskParams();
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams.reportId = this.mvT;
      }
      switch (this.mvN)
      {
      }
      for (;;)
      {
        ((CronetLogic.CronetRequestParams)localObject1).useNewdns = this.mvU;
        localObject1 = CronetLogic.startCronetDefaultHttpTask((CronetLogic.CronetRequestParams)localObject1, this);
        for (;;)
        {
          this.mvB = ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId;
          try
          {
            wait(this.mvD + this.mvE);
            if (!this.mvA) {
              CronetLogic.cancelCronetTask(this.mvB);
            }
            btF();
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
  
  private void btF()
  {
    AppMethodBeat.i(132882);
    Object localObject = new HashMap();
    ((Map)localObject).putAll(this.mvS);
    this.mvS.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry != null) && (localEntry.getKey() != null))
      {
        String str = (String)localEntry.getKey();
        this.mvS.put(str.toLowerCase(), localEntry.getValue());
      }
    }
    AppMethodBeat.o(132882);
  }
  
  public final void Zu(String paramString)
  {
    this.cqz = paramString;
  }
  
  public final String Zv(String paramString)
  {
    AppMethodBeat.i(132878);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(132878);
      return "";
    }
    List localList = (List)this.mvS.get(paramString.toLowerCase());
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
  
  public final void Zw(String paramString)
  {
    AppMethodBeat.i(132872);
    this.mvC.put("Referer", paramString);
    AppMethodBeat.o(132872);
  }
  
  public final void a(CronetLogic.CronetTaskCallback paramCronetTaskCallback)
  {
    this.mvM = paramCronetTaskCallback;
  }
  
  public final int aW(String paramString, int paramInt)
  {
    AppMethodBeat.i(132874);
    String str = Zv(paramString);
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
  
  public final void bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132871);
    this.mvC.put(paramString1, paramString2);
    AppMethodBeat.o(132871);
  }
  
  public final void btA()
  {
    this.mvK = true;
  }
  
  public final void btB()
  {
    this.mvT = 1500;
  }
  
  public final String btC()
  {
    return this.mvR;
  }
  
  public final String btD()
  {
    return this.mURL;
  }
  
  public final int btt()
  {
    AppMethodBeat.i(132875);
    String str = Zv("content-length");
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
  
  public final String btu()
  {
    AppMethodBeat.i(292879);
    String str = Zv("content-type");
    AppMethodBeat.o(292879);
    return str;
  }
  
  public final Map<String, List<String>> btv()
  {
    return this.mvS;
  }
  
  public final String btw()
  {
    return this.mvG;
  }
  
  public final int btx()
  {
    return this.mvF;
  }
  
  public final void bty()
  {
    this.mvI = false;
  }
  
  public final void btz()
  {
    this.mvN = 2;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(200849);
    if (("".equals(this.mvB)) && (this.mvN == 2)) {
      btE();
    }
    AppMethodBeat.o(200849);
  }
  
  public final void disconnect() {}
  
  public final void gM(boolean paramBoolean)
  {
    this.mvJ = paramBoolean;
  }
  
  public final String getHost()
  {
    return "";
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(132877);
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.mvP);
    AppMethodBeat.o(132877);
    return localByteArrayInputStream;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(132876);
    if ((this.mvA) && (this.mvO != -1))
    {
      i = this.mvO;
      AppMethodBeat.o(132876);
      return i;
    }
    if ("".equals(this.mvB)) {
      btE();
    }
    int i = this.mvO;
    AppMethodBeat.o(132876);
    return i;
  }
  
  public final String getSavePath()
  {
    return this.mSavePath;
  }
  
  public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramResponseHeader, int paramInt, String paramString)
  {
    AppMethodBeat.i(200867);
    if (this.mvM != null)
    {
      this.mvS = CronetLogic.getHeaderList(paramResponseHeader);
      paramInt = this.mvM.onCronetReceiveHeader(paramResponseHeader, paramInt, paramString);
      AppMethodBeat.o(200867);
      return paramInt;
    }
    AppMethodBeat.o(200867);
    return 0;
  }
  
  public final void onCronetTaskCompleted(String paramString1, CronetLogic.CronetTaskResult paramCronetTaskResult, String paramString2)
  {
    AppMethodBeat.i(200865);
    Log.i("MicroMsg.CronetConnect", "receive callback, status %d, error %d, msg %s", new Object[] { Integer.valueOf(paramCronetTaskResult.statusCode), Integer.valueOf(paramCronetTaskResult.errorCode), paramCronetTaskResult.errorMsg });
    a(paramCronetTaskResult);
    if (this.mvM != null) {
      this.mvM.onCronetTaskCompleted(paramString1, paramCronetTaskResult, paramString2);
    }
    AppMethodBeat.o(200865);
  }
  
  public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress)
  {
    AppMethodBeat.i(200863);
    if (this.mvM != null) {
      this.mvM.onDownloadProgressChanged(paramString, paramCronetDownloadProgress);
    }
    AppMethodBeat.o(200863);
  }
  
  public final void setSavePath(String paramString)
  {
    this.mSavePath = paramString;
  }
  
  public final void xA(int paramInt)
  {
    this.mvE = paramInt;
  }
  
  public final void xz(int paramInt)
  {
    this.mvD = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.z
 * JD-Core Version:    0.7.0.1
 */