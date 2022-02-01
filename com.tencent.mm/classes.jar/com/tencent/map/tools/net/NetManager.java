package com.tencent.map.tools.net;

import android.content.Context;
import com.tencent.map.tools.net.adapter.AbsNetImpl;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;

public class NetManager
{
  private static final boolean DEBUG = false;
  private static final String TAG = "NetManager";
  private static NetManager sInstance;
  private NetAdapter mAdapter;
  private boolean mInited;
  
  private NetManager()
  {
    AppMethodBeat.i(172916);
    this.mInited = false;
    AppMethodBeat.o(172916);
  }
  
  public static NetManager getInstance()
  {
    try
    {
      AppMethodBeat.i(172915);
      if (sInstance == null) {
        sInstance = new NetManager();
      }
      NetManager localNetManager = sInstance;
      AppMethodBeat.o(172915);
      return localNetManager;
    }
    finally {}
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(180921);
    if ((this.mInited) || (this.mAdapter == null))
    {
      AppMethodBeat.o(180921);
      return;
    }
    this.mAdapter.initNet(paramContext.getApplicationContext());
    this.mInited = true;
    AppMethodBeat.o(180921);
  }
  
  public NetRequestBuilder builder()
  {
    AppMethodBeat.i(172920);
    NetRequestBuilder localNetRequestBuilder = new NetRequestBuilder();
    if ((this.mAdapter instanceof AbsNetImpl)) {
      NetRequestBuilder.access$002(localNetRequestBuilder, ((AbsNetImpl)this.mAdapter).isForceHttps());
    }
    AppMethodBeat.o(172920);
    return localNetRequestBuilder;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(172921);
    if (this.mAdapter == null)
    {
      AppMethodBeat.o(172921);
      return null;
    }
    paramString1 = this.mAdapter.doGet(paramString1, paramString2, paramInt1, paramInt2, paramHashMap, paramHttpCanceler);
    AppMethodBeat.o(172921);
    return paramString1;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(172922);
    if (this.mAdapter == null)
    {
      AppMethodBeat.o(172922);
      return null;
    }
    paramString1 = this.mAdapter.doPost(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2, paramHashMap, paramHttpCanceler);
    AppMethodBeat.o(172922);
    return paramString1;
  }
  
  public NetResponse doPostNoBuffer(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(172923);
    if (this.mAdapter == null)
    {
      AppMethodBeat.o(172923);
      return null;
    }
    paramString1 = this.mAdapter.doPostNoBuffer(paramString1, paramString2, paramArrayOfByte);
    AppMethodBeat.o(172923);
    return paramString1;
  }
  
  public void doRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(172924);
    if (this.mAdapter != null) {
      this.mAdapter.doRangePost(paramString1, paramArrayOfByte, paramString2, paramString3, paramString4, paramString5, paramHttpCanceler);
    }
    AppMethodBeat.o(172924);
  }
  
  public void setAdapter(Context paramContext, NetAdapter paramNetAdapter)
  {
    AppMethodBeat.i(172919);
    if (paramNetAdapter == null)
    {
      AppMethodBeat.o(172919);
      return;
    }
    if (this.mAdapter != paramNetAdapter)
    {
      this.mInited = false;
      this.mAdapter = paramNetAdapter;
      init(paramContext);
    }
    AppMethodBeat.o(172919);
  }
  
  public class NetRequestBuilder
  {
    private File mCacheFile;
    private HttpCanceler mCanceler;
    private boolean mForceHttps;
    private HashMap<String, String> mHeaders;
    private String mNonce;
    private byte[] mPostData;
    private long mRequestId;
    private int mRetryNum;
    private String mStartTag;
    private int mTimeout;
    private String mTimestamp;
    private String mToken;
    private String mUrl;
    private String mUserAgent;
    
    NetRequestBuilder()
    {
      AppMethodBeat.i(180920);
      this.mUserAgent = "QQ Map Mobile";
      this.mRetryNum = 1;
      this.mTimeout = 10000;
      this.mForceHttps = true;
      this.mRequestId = System.nanoTime();
      AppMethodBeat.o(180920);
    }
    
    /* Error */
    private NetResponse onRequestFinish(NetResponse paramNetResponse)
    {
      // Byte code:
      //   0: ldc 75
      //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: astore_2
      //   7: aload_1
      //   8: ifnull +102 -> 110
      //   11: aload_1
      //   12: astore_2
      //   13: aload_0
      //   14: getfield 77	com/tencent/map/tools/net/NetManager$NetRequestBuilder:mCacheFile	Ljava/io/File;
      //   17: ifnull +93 -> 110
      //   20: aconst_null
      //   21: astore_3
      //   22: aconst_null
      //   23: astore 4
      //   25: aload_3
      //   26: astore_2
      //   27: aload_0
      //   28: getfield 77	com/tencent/map/tools/net/NetManager$NetRequestBuilder:mCacheFile	Ljava/io/File;
      //   31: invokevirtual 83	java/io/File:isFile	()Z
      //   34: ifeq +48 -> 82
      //   37: aload_3
      //   38: astore_2
      //   39: aload_0
      //   40: getfield 77	com/tencent/map/tools/net/NetManager$NetRequestBuilder:mCacheFile	Ljava/io/File;
      //   43: invokevirtual 86	java/io/File:exists	()Z
      //   46: ifeq +13 -> 59
      //   49: aload_3
      //   50: astore_2
      //   51: aload_0
      //   52: getfield 77	com/tencent/map/tools/net/NetManager$NetRequestBuilder:mCacheFile	Ljava/io/File;
      //   55: invokevirtual 89	java/io/File:delete	()Z
      //   58: pop
      //   59: aload_3
      //   60: astore_2
      //   61: aload_0
      //   62: getfield 77	com/tencent/map/tools/net/NetManager$NetRequestBuilder:mCacheFile	Ljava/io/File;
      //   65: invokevirtual 93	java/io/File:getParentFile	()Ljava/io/File;
      //   68: invokevirtual 96	java/io/File:mkdirs	()Z
      //   71: pop
      //   72: aload_3
      //   73: astore_2
      //   74: aload_0
      //   75: getfield 77	com/tencent/map/tools/net/NetManager$NetRequestBuilder:mCacheFile	Ljava/io/File;
      //   78: invokevirtual 99	java/io/File:createNewFile	()Z
      //   81: pop
      //   82: aload_3
      //   83: astore_2
      //   84: new 101	java/io/FileOutputStream
      //   87: dup
      //   88: aload_0
      //   89: getfield 77	com/tencent/map/tools/net/NetManager$NetRequestBuilder:mCacheFile	Ljava/io/File;
      //   92: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   95: astore_3
      //   96: aload_1
      //   97: getfield 109	com/tencent/map/tools/net/NetResponse:data	[B
      //   100: aload_3
      //   101: invokestatic 115	com/tencent/map/tools/net/NetUtil:writeBytesWithoutClose	([BLjava/io/OutputStream;)V
      //   104: aload_3
      //   105: invokestatic 119	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
      //   108: aload_1
      //   109: astore_2
      //   110: ldc 75
      //   112: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   115: aload_2
      //   116: areturn
      //   117: astore_3
      //   118: aload 4
      //   120: astore_1
      //   121: aload_1
      //   122: astore_2
      //   123: aload_1
      //   124: invokestatic 119	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
      //   127: aload_1
      //   128: astore_2
      //   129: new 106	com/tencent/map/tools/net/NetResponse
      //   132: dup
      //   133: aload_3
      //   134: invokespecial 122	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
      //   137: astore_3
      //   138: aload_1
      //   139: invokestatic 119	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
      //   142: aload_3
      //   143: astore_2
      //   144: goto -34 -> 110
      //   147: astore_1
      //   148: aload_2
      //   149: invokestatic 119	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
      //   152: ldc 75
      //   154: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   157: aload_1
      //   158: athrow
      //   159: astore_1
      //   160: aload_3
      //   161: astore_2
      //   162: goto -14 -> 148
      //   165: astore_2
      //   166: aload_3
      //   167: astore_1
      //   168: aload_2
      //   169: astore_3
      //   170: goto -49 -> 121
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	173	0	this	NetRequestBuilder
      //   0	173	1	paramNetResponse	NetResponse
      //   6	156	2	localObject1	Object
      //   165	4	2	localException1	java.lang.Exception
      //   21	84	3	localFileOutputStream	java.io.FileOutputStream
      //   117	17	3	localException2	java.lang.Exception
      //   137	33	3	localObject2	Object
      //   23	96	4	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   27	37	117	java/lang/Exception
      //   39	49	117	java/lang/Exception
      //   51	59	117	java/lang/Exception
      //   61	72	117	java/lang/Exception
      //   74	82	117	java/lang/Exception
      //   84	96	117	java/lang/Exception
      //   27	37	147	finally
      //   39	49	147	finally
      //   51	59	147	finally
      //   61	72	147	finally
      //   74	82	147	finally
      //   84	96	147	finally
      //   123	127	147	finally
      //   129	138	147	finally
      //   96	104	159	finally
      //   96	104	165	java/lang/Exception
    }
    
    private void onRequestStart(String paramString, NetRequestBuilder paramNetRequestBuilder) {}
    
    private String urlChecking(String paramString)
    {
      AppMethodBeat.i(193591);
      String str = paramString;
      if (this.mForceHttps)
      {
        str = paramString;
        if (paramString.startsWith("http://")) {
          str = paramString.replaceFirst("http://", "https://");
        }
      }
      AppMethodBeat.o(193591);
      return str;
    }
    
    public NetRequestBuilder canceler(HttpCanceler paramHttpCanceler)
    {
      this.mCanceler = paramHttpCanceler;
      return this;
    }
    
    public NetResponse doGet()
    {
      AppMethodBeat.i(172913);
      onRequestStart("doGet", this);
      NetResponse localNetResponse = onRequestFinish(NetManager.this.doGet(urlChecking(this.mUrl), this.mUserAgent, this.mRetryNum, this.mTimeout, this.mHeaders, this.mCanceler));
      AppMethodBeat.o(172913);
      return localNetResponse;
    }
    
    public NetResponse doPost()
    {
      AppMethodBeat.i(172910);
      onRequestStart("doPost", this);
      NetResponse localNetResponse = onRequestFinish(NetManager.this.doPost(this.mUrl, this.mUserAgent, this.mPostData, this.mRetryNum, this.mTimeout, this.mHeaders, this.mCanceler));
      AppMethodBeat.o(172910);
      return localNetResponse;
    }
    
    public NetResponse doPostNoBuffer()
    {
      AppMethodBeat.i(172911);
      onRequestStart("doPostNoBuffer", this);
      NetResponse localNetResponse = onRequestFinish(NetManager.this.doPostNoBuffer(urlChecking(this.mUrl), this.mUserAgent, this.mPostData));
      AppMethodBeat.o(172911);
      return localNetResponse;
    }
    
    public void doRangePost()
    {
      AppMethodBeat.i(172912);
      onRequestStart("doRangePost", this);
      NetManager.this.doRangePost(urlChecking(this.mUrl), this.mPostData, this.mToken, this.mNonce, this.mTimestamp, this.mStartTag, this.mCanceler);
      AppMethodBeat.o(172912);
    }
    
    public NetResponse downloadTo(File paramFile)
    {
      AppMethodBeat.i(193592);
      onRequestStart("downloadTo[" + paramFile + "]", this);
      paramFile = file(paramFile).doGet();
      AppMethodBeat.o(193592);
      return paramFile;
    }
    
    public NetRequestBuilder file(File paramFile)
    {
      this.mCacheFile = paramFile;
      return this;
    }
    
    public NetRequestBuilder forceHttps(boolean paramBoolean)
    {
      this.mForceHttps = paramBoolean;
      return this;
    }
    
    public NetRequestBuilder header(HashMap<String, String> paramHashMap)
    {
      this.mHeaders = paramHashMap;
      return this;
    }
    
    public NetRequestBuilder nonce(String paramString)
    {
      this.mNonce = paramString;
      return this;
    }
    
    public NetRequestBuilder postData(byte[] paramArrayOfByte)
    {
      this.mPostData = paramArrayOfByte;
      return this;
    }
    
    public NetRequestBuilder retryNum(int paramInt)
    {
      this.mRetryNum = paramInt;
      return this;
    }
    
    public NetRequestBuilder startTag(String paramString)
    {
      this.mStartTag = paramString;
      return this;
    }
    
    public NetRequestBuilder timeOut(int paramInt)
    {
      this.mTimeout = paramInt;
      return this;
    }
    
    public NetRequestBuilder timestamp(String paramString)
    {
      this.mTimestamp = paramString;
      return this;
    }
    
    public String toString()
    {
      AppMethodBeat.i(172914);
      StringBuilder localStringBuilder = new StringBuilder("NetRequestBuilder{");
      localStringBuilder.append("mUrl='").append(this.mUrl).append('\'');
      localStringBuilder.append(", mUserAgent='").append(this.mUserAgent).append('\'');
      localStringBuilder.append(", mPostData=");
      if (this.mPostData == null) {
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append(", mRetryNum=").append(this.mRetryNum);
        localStringBuilder.append(", mTimeout=").append(this.mTimeout);
        localStringBuilder.append(", mHeaders=").append(this.mHeaders);
        localStringBuilder.append(", mCanceler=").append(this.mCanceler);
        localStringBuilder.append(", mToken='").append(this.mToken).append('\'');
        localStringBuilder.append(", mNonce='").append(this.mNonce).append('\'');
        localStringBuilder.append(", mTimestamp='").append(this.mTimestamp).append('\'');
        localStringBuilder.append(", mStartTag='").append(this.mStartTag).append('\'');
        localStringBuilder.append('}');
        String str = localStringBuilder.toString();
        AppMethodBeat.o(172914);
        return str;
        localStringBuilder.append('[');
        int i = 0;
        if (i < this.mPostData.length)
        {
          if (i == 0) {}
          for (str = "";; str = ", ")
          {
            localStringBuilder.append(str).append(this.mPostData[i]);
            i += 1;
            break;
          }
        }
        localStringBuilder.append(']');
      }
    }
    
    public NetRequestBuilder token(String paramString)
    {
      this.mToken = paramString;
      return this;
    }
    
    public NetRequestBuilder url(String paramString)
    {
      this.mUrl = paramString;
      return this;
    }
    
    public NetRequestBuilder userAgent(String paramString)
    {
      this.mUserAgent = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.tools.net.NetManager
 * JD-Core Version:    0.7.0.1
 */