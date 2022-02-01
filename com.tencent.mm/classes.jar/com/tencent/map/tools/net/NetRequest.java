package com.tencent.map.tools.net;

import android.text.TextUtils;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.map.tools.net.http.HttpProxy;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.map.tools.net.processor.Processor;
import com.tencent.mapsdk.internal.lm;
import com.tencent.mapsdk.internal.ln;
import com.tencent.mapsdk.internal.lo;
import com.tencent.mapsdk.internal.lq;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NetRequest
{
  public HttpCanceler canceler;
  private File mCacheFile;
  private boolean mForceHttps;
  private boolean mIsLogEnable;
  private NetAdapter mNetAdapter;
  public NetMethod mNetMethod;
  private List<HttpProxyRule> mProxyRules;
  public final long mRequestId;
  private String mSecretKey;
  public final Map<String, String> mapHeaders;
  public byte[] postData;
  public final Set<Processor> processors;
  public HttpProxy proxy;
  public final Set<String> respHeaders;
  public int retryMethod;
  public int timeout;
  public String url;
  
  public NetRequest()
  {
    AppMethodBeat.i(210995);
    this.mRequestId = System.nanoTime();
    this.mapHeaders = new HashMap();
    this.respHeaders = new HashSet();
    this.processors = new HashSet();
    this.mForceHttps = true;
    AppMethodBeat.o(210995);
  }
  
  public NetRequest(NetMethod paramNetMethod, String paramString)
  {
    AppMethodBeat.i(211005);
    this.mRequestId = System.nanoTime();
    this.mapHeaders = new HashMap();
    this.respHeaders = new HashSet();
    this.processors = new HashSet();
    this.mForceHttps = true;
    this.mNetMethod = paramNetMethod;
    this.url = paramString;
    AppMethodBeat.o(211005);
  }
  
  private NetResponse doGet()
  {
    AppMethodBeat.i(211009);
    setNetMethod(NetMethod.GET);
    NetResponse localNetResponse = this.mNetAdapter.doRequest(this);
    AppMethodBeat.o(211009);
    return localNetResponse;
  }
  
  private NetResponse doPost()
  {
    AppMethodBeat.i(211015);
    setNetMethod(NetMethod.POST);
    NetResponse localNetResponse = this.mNetAdapter.doRequest(this);
    AppMethodBeat.o(211015);
    return localNetResponse;
  }
  
  private NetResponse doRequest()
  {
    AppMethodBeat.i(211020);
    NetResponse localNetResponse = this.mNetAdapter.doRequest(this);
    AppMethodBeat.o(211020);
    return localNetResponse;
  }
  
  private NetResponse doStream()
  {
    AppMethodBeat.i(211023);
    setNetMethod(NetMethod.GET);
    NetResponse localNetResponse = this.mNetAdapter.openStream(this);
    AppMethodBeat.o(211023);
    return localNetResponse;
  }
  
  public NetRequest addProcessor(Processor paramProcessor)
  {
    AppMethodBeat.i(211218);
    this.processors.add(paramProcessor);
    AppMethodBeat.o(211218);
    return this;
  }
  
  public NetRequest setCanceler(HttpCanceler paramHttpCanceler)
  {
    this.canceler = paramHttpCanceler;
    return this;
  }
  
  public NetRequest setMapHeaders(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211156);
    this.mapHeaders.put(paramString1, paramString2);
    AppMethodBeat.o(211156);
    return this;
  }
  
  public NetRequest setMapHeaders(Map<String, String> paramMap)
  {
    AppMethodBeat.i(211147);
    if (paramMap == null)
    {
      AppMethodBeat.o(211147);
      return this;
    }
    this.mapHeaders.putAll(paramMap);
    AppMethodBeat.o(211147);
    return this;
  }
  
  public NetRequest setNetMethod(NetMethod paramNetMethod)
  {
    this.mNetMethod = paramNetMethod;
    return this;
  }
  
  public NetRequest setNonce(String paramString)
  {
    AppMethodBeat.i(211195);
    if (!TextUtils.isEmpty(paramString)) {
      this.mapHeaders.put("nonce", paramString);
    }
    AppMethodBeat.o(211195);
    return this;
  }
  
  public NetRequest setPostData(byte[] paramArrayOfByte)
  {
    this.postData = paramArrayOfByte;
    return this;
  }
  
  public NetRequest setRespHeaders(String... paramVarArgs)
  {
    AppMethodBeat.i(211167);
    this.respHeaders.addAll(Arrays.asList((Object[])paramVarArgs.clone()));
    AppMethodBeat.o(211167);
    return this;
  }
  
  public NetRequest setRetryMethod(int paramInt)
  {
    this.retryMethod = paramInt;
    return this;
  }
  
  public NetRequest setStart(String paramString)
  {
    AppMethodBeat.i(211212);
    if (!TextUtils.isEmpty(paramString)) {
      this.mapHeaders.put("Range", "bytes=" + paramString + "-");
    }
    AppMethodBeat.o(211212);
    return this;
  }
  
  public NetRequest setTimeStamp(String paramString)
  {
    AppMethodBeat.i(211202);
    if (!TextUtils.isEmpty(paramString)) {
      this.mapHeaders.put("timestamp", paramString);
    }
    AppMethodBeat.o(211202);
    return this;
  }
  
  public NetRequest setTimeout(int paramInt)
  {
    this.timeout = paramInt;
    return this;
  }
  
  public NetRequest setToken(String paramString)
  {
    AppMethodBeat.i(211189);
    if (!TextUtils.isEmpty(paramString)) {
      this.mapHeaders.put("Sign", paramString);
    }
    AppMethodBeat.o(211189);
    return this;
  }
  
  public NetRequest setUrl(String paramString)
  {
    this.url = paramString;
    return this;
  }
  
  public NetRequest setUserAgent(String paramString)
  {
    AppMethodBeat.i(211116);
    if (!TextUtils.isEmpty(paramString)) {
      this.mapHeaders.put("User-Agent", paramString);
    }
    AppMethodBeat.o(211116);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(211226);
    String str = "NetRequest{mRequestId=" + this.mRequestId + ", mNetMethod=" + this.mNetMethod + ", url='" + this.url + '\'' + ", postData=" + Arrays.toString(this.postData) + ", retryMethod=" + this.retryMethod + ", mapHeaders=" + this.mapHeaders + ", respHeaders=" + this.respHeaders + ", processorSet=" + this.processors + ", canceler=" + this.canceler + ", timeout=" + this.timeout + ", proxy=" + this.proxy + '}';
    AppMethodBeat.o(211226);
    return str;
  }
  
  public static class NetRequestBuilder
  {
    private final NetRequest mNetRequest;
    
    NetRequestBuilder(NetAdapter paramNetAdapter, String paramString)
    {
      this(paramNetAdapter, paramString, null);
    }
    
    NetRequestBuilder(NetAdapter paramNetAdapter, String paramString, NetRequest paramNetRequest)
    {
      AppMethodBeat.i(210982);
      if (paramNetRequest == null) {}
      for (this.mNetRequest = new NetRequest().setTimeout(10000).setRetryMethod(1);; this.mNetRequest = paramNetRequest)
      {
        NetRequest.access$002(this.mNetRequest, paramNetAdapter);
        NetRequest.access$102(this.mNetRequest, paramString);
        NetRequest.access$202(this.mNetRequest, paramNetAdapter.getProxyRuleList());
        NetRequest.access$302(this.mNetRequest, paramNetAdapter.isLogEnable());
        AppMethodBeat.o(210982);
        return;
      }
    }
    
    /* Error */
    private NetResponse onRequestFinish(NetResponse paramNetResponse)
    {
      // Byte code:
      //   0: ldc 69
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: ifnull +140 -> 146
      //   9: aload_0
      //   10: getfield 35	com/tencent/map/tools/net/NetRequest$NetRequestBuilder:mNetRequest	Lcom/tencent/map/tools/net/NetRequest;
      //   13: invokestatic 73	com/tencent/map/tools/net/NetRequest:access$400	(Lcom/tencent/map/tools/net/NetRequest;)Ljava/io/File;
      //   16: astore 5
      //   18: aload 5
      //   20: ifnull +79 -> 99
      //   23: aconst_null
      //   24: astore_3
      //   25: aconst_null
      //   26: astore 4
      //   28: aload_3
      //   29: astore_2
      //   30: aload 5
      //   32: invokevirtual 78	java/io/File:isFile	()Z
      //   35: ifeq +40 -> 75
      //   38: aload_3
      //   39: astore_2
      //   40: aload 5
      //   42: invokevirtual 81	java/io/File:exists	()Z
      //   45: ifeq +11 -> 56
      //   48: aload_3
      //   49: astore_2
      //   50: aload 5
      //   52: invokevirtual 84	java/io/File:delete	()Z
      //   55: pop
      //   56: aload_3
      //   57: astore_2
      //   58: aload 5
      //   60: invokevirtual 88	java/io/File:getParentFile	()Ljava/io/File;
      //   63: invokevirtual 91	java/io/File:mkdirs	()Z
      //   66: pop
      //   67: aload_3
      //   68: astore_2
      //   69: aload 5
      //   71: invokevirtual 94	java/io/File:createNewFile	()Z
      //   74: pop
      //   75: aload_3
      //   76: astore_2
      //   77: new 96	java/io/FileOutputStream
      //   80: dup
      //   81: aload 5
      //   83: invokespecial 99	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   86: astore_3
      //   87: aload_1
      //   88: getfield 105	com/tencent/map/tools/net/NetResponse:data	[B
      //   91: aload_3
      //   92: invokestatic 111	com/tencent/map/tools/net/NetUtil:writeBytesWithoutClose	([BLjava/io/OutputStream;)V
      //   95: aload_3
      //   96: invokestatic 115	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
      //   99: ldc 69
      //   101: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   104: aload_1
      //   105: areturn
      //   106: astore_2
      //   107: aload 4
      //   109: astore_3
      //   110: aload_2
      //   111: astore 4
      //   113: aload_3
      //   114: astore_2
      //   115: aload_3
      //   116: invokestatic 115	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
      //   119: aload_3
      //   120: astore_2
      //   121: aload_1
      //   122: aload 4
      //   124: invokevirtual 119	com/tencent/map/tools/net/NetResponse:exception	(Ljava/lang/Exception;)V
      //   127: aload_3
      //   128: invokestatic 115	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
      //   131: goto -32 -> 99
      //   134: astore_1
      //   135: aload_2
      //   136: invokestatic 115	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
      //   139: ldc 69
      //   141: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   144: aload_1
      //   145: athrow
      //   146: new 101	com/tencent/map/tools/net/NetResponse
      //   149: dup
      //   150: aload_0
      //   151: getfield 35	com/tencent/map/tools/net/NetRequest$NetRequestBuilder:mNetRequest	Lcom/tencent/map/tools/net/NetRequest;
      //   154: invokespecial 122	com/tencent/map/tools/net/NetResponse:<init>	(Lcom/tencent/map/tools/net/NetRequest;)V
      //   157: astore_1
      //   158: aload_1
      //   159: bipush 156
      //   161: putfield 126	com/tencent/map/tools/net/NetResponse:errorCode	I
      //   164: aload_1
      //   165: ldc 128
      //   167: invokevirtual 134	java/lang/String:getBytes	()[B
      //   170: putfield 137	com/tencent/map/tools/net/NetResponse:errorData	[B
      //   173: ldc 69
      //   175: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   178: aload_1
      //   179: areturn
      //   180: astore_1
      //   181: aload_3
      //   182: astore_2
      //   183: goto -48 -> 135
      //   186: astore 4
      //   188: goto -75 -> 113
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	191	0	this	NetRequestBuilder
      //   0	191	1	paramNetResponse	NetResponse
      //   29	48	2	localObject1	Object
      //   106	5	2	localException1	java.lang.Exception
      //   114	69	2	localObject2	Object
      //   24	158	3	localObject3	Object
      //   26	97	4	localObject4	Object
      //   186	1	4	localException2	java.lang.Exception
      //   16	66	5	localFile	File
      // Exception table:
      //   from	to	target	type
      //   30	38	106	java/lang/Exception
      //   40	48	106	java/lang/Exception
      //   50	56	106	java/lang/Exception
      //   58	67	106	java/lang/Exception
      //   69	75	106	java/lang/Exception
      //   77	87	106	java/lang/Exception
      //   30	38	134	finally
      //   40	48	134	finally
      //   50	56	134	finally
      //   58	67	134	finally
      //   69	75	134	finally
      //   77	87	134	finally
      //   115	119	134	finally
      //   121	127	134	finally
      //   87	95	180	finally
      //   87	95	186	java/lang/Exception
    }
    
    private void onRequestStart(String paramString, NetRequestBuilder paramNetRequestBuilder)
    {
      AppMethodBeat.i(210988);
      paramNetRequestBuilder.addProcessor(new lo(this.mNetRequest.mIsLogEnable));
      paramNetRequestBuilder.addProcessor(lm.a(this.mNetRequest.mForceHttps));
      paramNetRequestBuilder.addProcessor(ln.a(this.mNetRequest.mProxyRules));
      paramNetRequestBuilder.addProcessor(lq.a(this.mNetRequest.mSecretKey));
      AppMethodBeat.o(210988);
    }
    
    public NetRequestBuilder addProcessor(Processor paramProcessor)
    {
      AppMethodBeat.i(211040);
      this.mNetRequest.addProcessor(paramProcessor);
      AppMethodBeat.o(211040);
      return this;
    }
    
    public NetRequestBuilder canceler(HttpCanceler paramHttpCanceler)
    {
      this.mNetRequest.canceler = paramHttpCanceler;
      return this;
    }
    
    public NetResponse doGet()
    {
      AppMethodBeat.i(211046);
      onRequestStart("doGet", this);
      NetResponse localNetResponse = onRequestFinish(NetRequest.access$700(this.mNetRequest));
      AppMethodBeat.o(211046);
      return localNetResponse;
    }
    
    public NetResponse doPost()
    {
      AppMethodBeat.i(211043);
      onRequestStart("doPost", this);
      NetResponse localNetResponse = onRequestFinish(NetRequest.access$600(this.mNetRequest));
      AppMethodBeat.o(211043);
      return localNetResponse;
    }
    
    NetResponse doRequest()
    {
      AppMethodBeat.i(211053);
      onRequestStart("doRequest", this);
      NetResponse localNetResponse = onRequestFinish(NetRequest.access$800(this.mNetRequest));
      AppMethodBeat.o(211053);
      return localNetResponse;
    }
    
    public NetResponse doStream()
    {
      AppMethodBeat.i(211056);
      onRequestStart("doStream", this);
      NetResponse localNetResponse = onRequestFinish(NetRequest.access$900(this.mNetRequest));
      AppMethodBeat.o(211056);
      return localNetResponse;
    }
    
    public NetResponse downloadTo(File paramFile)
    {
      AppMethodBeat.i(211050);
      onRequestStart("downloadTo[" + paramFile + "]", this);
      paramFile = file(paramFile).doGet();
      AppMethodBeat.o(211050);
      return paramFile;
    }
    
    public NetRequestBuilder file(File paramFile)
    {
      AppMethodBeat.i(211031);
      NetRequest.access$402(this.mNetRequest, paramFile);
      AppMethodBeat.o(211031);
      return this;
    }
    
    public NetRequestBuilder forceHttps(boolean paramBoolean)
    {
      AppMethodBeat.i(211032);
      NetRequest.access$502(this.mNetRequest, paramBoolean);
      AppMethodBeat.o(211032);
      return this;
    }
    
    public NetRequest getNetRequest()
    {
      return this.mNetRequest;
    }
    
    public NetRequestBuilder gzip()
    {
      AppMethodBeat.i(211036);
      header("Accept-Encoding", "gzip");
      AppMethodBeat.o(211036);
      return this;
    }
    
    public NetRequestBuilder header(String paramString1, String paramString2)
    {
      AppMethodBeat.i(211018);
      this.mNetRequest.setMapHeaders(paramString1, paramString2);
      AppMethodBeat.o(211018);
      return this;
    }
    
    public NetRequestBuilder header(HashMap<String, String> paramHashMap)
    {
      AppMethodBeat.i(211014);
      this.mNetRequest.setMapHeaders(paramHashMap);
      AppMethodBeat.o(211014);
      return this;
    }
    
    public NetRequestBuilder nonce(String paramString)
    {
      AppMethodBeat.i(211025);
      this.mNetRequest.setNonce(paramString);
      AppMethodBeat.o(211025);
      return this;
    }
    
    public NetRequestBuilder postData(byte[] paramArrayOfByte)
    {
      this.mNetRequest.postData = paramArrayOfByte;
      return this;
    }
    
    public NetRequestBuilder proxy(HttpProxy paramHttpProxy)
    {
      this.mNetRequest.proxy = paramHttpProxy;
      return this;
    }
    
    public NetRequestBuilder retryNum(int paramInt)
    {
      this.mNetRequest.retryMethod = paramInt;
      return this;
    }
    
    public NetRequestBuilder startTag(String paramString)
    {
      AppMethodBeat.i(211029);
      this.mNetRequest.setStart(paramString);
      AppMethodBeat.o(211029);
      return this;
    }
    
    public NetRequestBuilder timeOut(int paramInt)
    {
      this.mNetRequest.timeout = paramInt;
      return this;
    }
    
    public NetRequestBuilder timestamp(String paramString)
    {
      AppMethodBeat.i(211028);
      this.mNetRequest.setTimeStamp(paramString);
      AppMethodBeat.o(211028);
      return this;
    }
    
    public String toString()
    {
      AppMethodBeat.i(211064);
      String str = "NetRequestBuilder{, mRequestId=" + this.mNetRequest.mRequestId + ", mNetRequest=" + this.mNetRequest + '}';
      AppMethodBeat.o(211064);
      return str;
    }
    
    public NetRequestBuilder token(String paramString)
    {
      AppMethodBeat.i(211022);
      this.mNetRequest.setToken(paramString);
      AppMethodBeat.o(211022);
      return this;
    }
    
    public NetRequestBuilder url(String paramString)
    {
      this.mNetRequest.url = paramString;
      return this;
    }
    
    public NetRequestBuilder userAgent(String paramString)
    {
      AppMethodBeat.i(211002);
      this.mNetRequest.setUserAgent(paramString);
      AppMethodBeat.o(211002);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.NetRequest
 * JD-Core Version:    0.7.0.1
 */