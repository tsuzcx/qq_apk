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
  private String csu;
  private boolean jEX;
  private String jEY;
  private Map<String, String> jEZ;
  public int jFa;
  public int jFb;
  private int jFc;
  String jFd;
  private byte[] jFe;
  private boolean jFf;
  public boolean jFg;
  private boolean jFh;
  private boolean jFi;
  private CronetLogic.CronetTaskCallback jFj;
  private int jFk;
  private int jFl;
  private byte[] jFm;
  private String jFn;
  private String jFo;
  private Map<String, List<String>> jFp;
  public int jFq;
  public boolean jFr;
  private int mErrorCode;
  private String mSavePath;
  private String mURL;
  
  public z(String paramString, int paramInt)
  {
    AppMethodBeat.i(132870);
    this.jEX = false;
    this.jEY = "";
    this.jEZ = new HashMap();
    this.jFa = 5000;
    this.jFb = 5000;
    this.csu = "GET";
    this.jFf = false;
    this.jFg = false;
    this.jFh = false;
    this.jFi = false;
    this.jFk = 8;
    this.jFl = -1;
    this.jFn = "";
    this.mErrorCode = 0;
    this.jFo = "";
    this.jFp = new HashMap();
    this.jFq = 0;
    this.jFr = false;
    this.mURL = paramString;
    this.jFc = paramInt;
    AppMethodBeat.o(132870);
  }
  
  private void a(CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    try
    {
      AppMethodBeat.i(132880);
      this.jEX = true;
      this.jFl = paramCronetTaskResult.statusCode;
      this.jFm = paramCronetTaskResult.data;
      this.jFn = paramCronetTaskResult.errorMsg;
      this.mErrorCode = paramCronetTaskResult.errorCode;
      this.jFo = paramCronetTaskResult.statusText;
      this.jFp = paramCronetTaskResult.getHeaderMapList();
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
  
  private void bjV()
  {
    try
    {
      AppMethodBeat.i(132881);
      Object localObject1 = new CronetLogic.CronetRequestParams();
      ((CronetLogic.CronetRequestParams)localObject1).url = this.mURL;
      ((CronetLogic.CronetRequestParams)localObject1).followRedirect = false;
      ((CronetLogic.CronetRequestParams)localObject1).bodyData = this.jFe;
      ((CronetLogic.CronetRequestParams)localObject1).method = this.csu;
      ((CronetLogic.CronetRequestParams)localObject1).useMemoryCache = this.jFg;
      ((CronetLogic.CronetRequestParams)localObject1).useHttp2 = this.jFh;
      ((CronetLogic.CronetRequestParams)localObject1).useQuic = this.jFi;
      ((CronetLogic.CronetRequestParams)localObject1).makeRequestHeader(this.jEZ);
      ((CronetLogic.CronetRequestParams)localObject1).taskType = this.jFk;
      if (this.jFq != 0)
      {
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams = new CronetLogic.DefaultHttpTaskParams();
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams.reportId = this.jFq;
      }
      switch (this.jFk)
      {
      }
      for (;;)
      {
        ((CronetLogic.CronetRequestParams)localObject1).useNewdns = this.jFr;
        localObject1 = CronetLogic.startCronetDefaultHttpTask((CronetLogic.CronetRequestParams)localObject1, this);
        for (;;)
        {
          this.jEY = ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId;
          try
          {
            wait(this.jFa + this.jFb);
            if (!this.jEX) {
              CronetLogic.cancelCronetTask(this.jEY);
            }
            bjW();
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
  
  private void bjW()
  {
    AppMethodBeat.i(132882);
    Object localObject = new HashMap();
    ((Map)localObject).putAll(this.jFp);
    this.jFp.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry != null) && (localEntry.getKey() != null))
      {
        String str = (String)localEntry.getKey();
        this.jFp.put(str.toLowerCase(), localEntry.getValue());
      }
    }
    AppMethodBeat.o(132882);
  }
  
  public final void RU(String paramString)
  {
    AppMethodBeat.i(132872);
    this.jEZ.put("Referer", paramString);
    AppMethodBeat.o(132872);
  }
  
  public final void a(CronetLogic.CronetTaskCallback paramCronetTaskCallback)
  {
    this.jFj = paramCronetTaskCallback;
  }
  
  public final String bjP()
  {
    return this.jFd;
  }
  
  public final int bjQ()
  {
    return this.jFc;
  }
  
  public final void bjR()
  {
    this.jFf = false;
  }
  
  public final void bjS()
  {
    this.jFk = 2;
  }
  
  public final void bjT()
  {
    this.jFh = true;
  }
  
  public final void bjU()
  {
    this.jFq = 1500;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(197109);
    if (("".equals(this.jEY)) && (this.jFk == 2)) {
      bjV();
    }
    AppMethodBeat.o(197109);
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
  
  public final String getContentType()
  {
    AppMethodBeat.i(258488);
    String str = getHeaderField("content-type");
    AppMethodBeat.o(258488);
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
    List localList = (List)this.jFp.get(paramString.toLowerCase());
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
      Log.e("MicroMsg.CronetConnect", "getHeaderFieldInt field " + paramString + " " + localException.getLocalizedMessage());
      AppMethodBeat.o(132874);
    }
    return paramInt;
  }
  
  public final Map<String, List<String>> getHeaderFields()
  {
    return this.jFp;
  }
  
  public final String getHost()
  {
    return "";
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(132877);
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.jFm);
    AppMethodBeat.o(132877);
    return localByteArrayInputStream;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(132876);
    if ((this.jEX) && (this.jFl != -1))
    {
      i = this.jFl;
      AppMethodBeat.o(132876);
      return i;
    }
    if ("".equals(this.jEY)) {
      bjV();
    }
    int i = this.jFl;
    AppMethodBeat.o(132876);
    return i;
  }
  
  public final String getResponseMessage()
  {
    return this.jFo;
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
    AppMethodBeat.i(197112);
    if (this.jFj != null)
    {
      this.jFp = CronetLogic.getHeaderList(paramResponseHeader);
      paramInt = this.jFj.onCronetReceiveHeader(paramResponseHeader, paramInt);
      AppMethodBeat.o(197112);
      return paramInt;
    }
    AppMethodBeat.o(197112);
    return 0;
  }
  
  public final void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    AppMethodBeat.i(132879);
    Log.i("MicroMsg.CronetConnect", "receive callback, status %d, error %d, msg %s", new Object[] { Integer.valueOf(paramCronetTaskResult.statusCode), Integer.valueOf(paramCronetTaskResult.errorCode), paramCronetTaskResult.errorMsg });
    a(paramCronetTaskResult);
    if (this.jFj != null) {
      this.jFj.onCronetTaskCompleted(paramString, paramCronetTaskResult);
    }
    AppMethodBeat.o(132879);
  }
  
  public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress)
  {
    AppMethodBeat.i(197111);
    if (this.jFj != null) {
      this.jFj.onDownloadProgressChanged(paramString, paramCronetDownloadProgress);
    }
    AppMethodBeat.o(197111);
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.jFa = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.jFb = paramInt;
  }
  
  public final void setRequestMethod(String paramString)
  {
    this.csu = paramString;
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132871);
    this.jEZ.put(paramString1, paramString2);
    AppMethodBeat.o(132871);
  }
  
  public final void setSavePath(String paramString)
  {
    this.mSavePath = paramString;
  }
  
  public final void setUseCaches(boolean paramBoolean)
  {
    this.jFg = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.z
 * JD-Core Version:    0.7.0.1
 */