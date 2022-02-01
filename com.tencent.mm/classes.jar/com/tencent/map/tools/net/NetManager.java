package com.tencent.map.tools.net;

import android.content.Context;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    private HttpCanceler mCanceler;
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
      this.mRequestId = System.nanoTime();
      AppMethodBeat.o(180920);
    }
    
    private NetResponse onRequestFinish(NetResponse paramNetResponse)
    {
      return paramNetResponse;
    }
    
    private void onRequestStart(String paramString, NetRequestBuilder paramNetRequestBuilder) {}
    
    public NetRequestBuilder canceler(HttpCanceler paramHttpCanceler)
    {
      this.mCanceler = paramHttpCanceler;
      return this;
    }
    
    public NetResponse doGet()
    {
      AppMethodBeat.i(172913);
      onRequestStart("doGet", this);
      NetResponse localNetResponse = onRequestFinish(NetManager.this.doGet(this.mUrl, this.mUserAgent, this.mRetryNum, this.mTimeout, this.mHeaders, this.mCanceler));
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
      NetResponse localNetResponse = onRequestFinish(NetManager.this.doPostNoBuffer(this.mUrl, this.mUserAgent, this.mPostData));
      AppMethodBeat.o(172911);
      return localNetResponse;
    }
    
    public void doRangePost()
    {
      AppMethodBeat.i(172912);
      onRequestStart("doRangePost", this);
      NetManager.this.doRangePost(this.mUrl, this.mPostData, this.mToken, this.mNonce, this.mTimestamp, this.mStartTag, this.mCanceler);
      AppMethodBeat.o(172912);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.tools.net.NetManager
 * JD-Core Version:    0.7.0.1
 */