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
import com.tencent.mm.sdk.platformtools.ae;
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
  private byte[] iIA;
  private boolean iIB;
  public boolean iIC;
  private boolean iID;
  private boolean iIE;
  private CronetLogic.CronetTaskCallback iIF;
  private int iIG;
  private int iIH;
  private byte[] iII;
  private String iIJ;
  private String iIK;
  private Map<String, List<String>> iIL;
  public int iIM;
  public boolean iIN;
  private boolean iIt;
  private String iIu;
  private Map<String, String> iIv;
  public int iIw;
  public int iIx;
  private int iIy;
  String iIz;
  private int mErrorCode;
  private String mSavePath;
  private String mURL;
  
  public x(String paramString, int paramInt)
  {
    AppMethodBeat.i(132870);
    this.iIt = false;
    this.iIu = "";
    this.iIv = new HashMap();
    this.iIw = 5000;
    this.iIx = 5000;
    this.cgz = "GET";
    this.iIB = false;
    this.iIC = false;
    this.iID = false;
    this.iIE = false;
    this.iIG = 8;
    this.iIH = -1;
    this.iIJ = "";
    this.mErrorCode = 0;
    this.iIK = "";
    this.iIL = new HashMap();
    this.iIM = 0;
    this.iIN = false;
    this.mURL = paramString;
    this.iIy = paramInt;
    AppMethodBeat.o(132870);
  }
  
  private void a(CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    try
    {
      AppMethodBeat.i(132880);
      this.iIt = true;
      this.iIH = paramCronetTaskResult.statusCode;
      this.iII = paramCronetTaskResult.data;
      this.iIJ = paramCronetTaskResult.errorMsg;
      this.mErrorCode = paramCronetTaskResult.errorCode;
      this.iIK = paramCronetTaskResult.statusText;
      this.iIL = paramCronetTaskResult.getHeaderMapList();
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
  
  private void aPu()
  {
    try
    {
      AppMethodBeat.i(132881);
      Object localObject1 = new CronetLogic.CronetRequestParams();
      ((CronetLogic.CronetRequestParams)localObject1).url = this.mURL;
      ((CronetLogic.CronetRequestParams)localObject1).followRedirect = false;
      ((CronetLogic.CronetRequestParams)localObject1).bodyData = this.iIA;
      ((CronetLogic.CronetRequestParams)localObject1).method = this.cgz;
      ((CronetLogic.CronetRequestParams)localObject1).useMemoryCache = this.iIC;
      ((CronetLogic.CronetRequestParams)localObject1).useHttp2 = this.iID;
      ((CronetLogic.CronetRequestParams)localObject1).useQuic = this.iIE;
      ((CronetLogic.CronetRequestParams)localObject1).makeRequestHeader(this.iIv);
      ((CronetLogic.CronetRequestParams)localObject1).taskType = this.iIG;
      if (this.iIM != 0)
      {
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams = new CronetLogic.DefaultHttpTaskParams();
        ((CronetLogic.CronetRequestParams)localObject1).defaultHttpTaskParams.reportId = this.iIM;
      }
      switch (this.iIG)
      {
      }
      for (;;)
      {
        ((CronetLogic.CronetRequestParams)localObject1).useNewdns = this.iIN;
        localObject1 = CronetLogic.startCronetDefaultHttpTask((CronetLogic.CronetRequestParams)localObject1, this);
        for (;;)
        {
          this.iIu = ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId;
          try
          {
            wait(this.iIw + this.iIx);
            if (!this.iIt) {
              CronetLogic.cancelCronetTask(this.iIu);
            }
            aPv();
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
              ae.e("MicroMsg.CronetConnect", "createAndStartCronetRequest " + localException.getLocalizedMessage());
            }
          }
        }
      }
    }
    finally {}
  }
  
  private void aPv()
  {
    AppMethodBeat.i(132882);
    Object localObject = new HashMap();
    ((Map)localObject).putAll(this.iIL);
    this.iIL.clear();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry != null) && (localEntry.getKey() != null))
      {
        String str = (String)localEntry.getKey();
        this.iIL.put(str.toLowerCase(), localEntry.getValue());
      }
    }
    AppMethodBeat.o(132882);
  }
  
  public final void IX(String paramString)
  {
    AppMethodBeat.i(132872);
    this.iIv.put("Referer", paramString);
    AppMethodBeat.o(132872);
  }
  
  public final void a(CronetLogic.CronetTaskCallback paramCronetTaskCallback)
  {
    this.iIF = paramCronetTaskCallback;
  }
  
  public final String aPo()
  {
    return this.iIz;
  }
  
  public final int aPp()
  {
    return this.iIy;
  }
  
  public final void aPq()
  {
    this.iIB = false;
  }
  
  public final void aPr()
  {
    this.iIG = 2;
  }
  
  public final void aPs()
  {
    this.iID = true;
  }
  
  public final void aPt()
  {
    this.iIM = 1500;
  }
  
  public final void connect()
  {
    AppMethodBeat.i(193568);
    if (("".equals(this.iIu)) && (this.iIG == 2)) {
      aPu();
    }
    AppMethodBeat.o(193568);
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
        ae.e("MicroMsg.CronetConnect", "getContentLength content-length " + localException.getLocalizedMessage());
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
    AppMethodBeat.i(224423);
    String str = getHeaderField("content-type");
    AppMethodBeat.o(224423);
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
    List localList = (List)this.iIL.get(paramString.toLowerCase());
    if (localList == null)
    {
      ae.w("MicroMsg.CronetConnect", "getHeaderField %s is null", new Object[] { paramString });
      AppMethodBeat.o(132878);
      return "";
    }
    ae.i("MicroMsg.CronetConnect", "getHeaderField field %s, value %s ", new Object[] { paramString, localList.get(0) });
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
      ae.e("MicroMsg.CronetConnect", "getHeaderFieldInt field " + paramString + " " + localException.getLocalizedMessage());
      AppMethodBeat.o(132874);
    }
    return paramInt;
  }
  
  public final Map<String, List<String>> getHeaderFields()
  {
    return this.iIL;
  }
  
  public final String getHost()
  {
    return "";
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(132877);
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.iII);
    AppMethodBeat.o(132877);
    return localByteArrayInputStream;
  }
  
  public final int getResponseCode()
  {
    AppMethodBeat.i(132876);
    if ((this.iIt) && (this.iIH != -1))
    {
      i = this.iIH;
      AppMethodBeat.o(132876);
      return i;
    }
    if ("".equals(this.iIu)) {
      aPu();
    }
    int i = this.iIH;
    AppMethodBeat.o(132876);
    return i;
  }
  
  public final String getResponseMessage()
  {
    return this.iIK;
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
    AppMethodBeat.i(193571);
    if (this.iIF != null)
    {
      this.iIL = CronetLogic.getHeaderList(paramResponseHeader);
      paramInt = this.iIF.onCronetReceiveHeader(paramResponseHeader, paramInt);
      AppMethodBeat.o(193571);
      return paramInt;
    }
    AppMethodBeat.o(193571);
    return 0;
  }
  
  public final void onCronetTaskCompleted(String paramString, CronetLogic.CronetTaskResult paramCronetTaskResult)
  {
    AppMethodBeat.i(132879);
    ae.i("MicroMsg.CronetConnect", "receive callback, status %d, error %d, msg %s", new Object[] { Integer.valueOf(paramCronetTaskResult.statusCode), Integer.valueOf(paramCronetTaskResult.errorCode), paramCronetTaskResult.errorMsg });
    a(paramCronetTaskResult);
    if (this.iIF != null) {
      this.iIF.onCronetTaskCompleted(paramString, paramCronetTaskResult);
    }
    AppMethodBeat.o(132879);
  }
  
  public final void onDownloadProgressChanged(String paramString, CronetLogic.CronetDownloadProgress paramCronetDownloadProgress)
  {
    AppMethodBeat.i(193570);
    if (this.iIF != null) {
      this.iIF.onDownloadProgressChanged(paramString, paramCronetDownloadProgress);
    }
    AppMethodBeat.o(193570);
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    this.iIw = paramInt;
  }
  
  public final void setReadTimeout(int paramInt)
  {
    this.iIx = paramInt;
  }
  
  public final void setRequestMethod(String paramString)
  {
    this.cgz = paramString;
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(132871);
    this.iIv.put(paramString1, paramString2);
    AppMethodBeat.o(132871);
  }
  
  public final void setSavePath(String paramString)
  {
    this.mSavePath = paramString;
  }
  
  public final void setUseCaches(boolean paramBoolean)
  {
    this.iIC = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.x
 * JD-Core Version:    0.7.0.1
 */