package com.tencent.map.tools.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.tools.net.adapter.URLNetImpl;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.mapsdk.internal.kz;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class NetManager
{
  private static NetManager sInstance;
  private NetAdapter mAdapter;
  private boolean mGlobalForceHttps;
  private String mGlobalSecretKey;
  private boolean mInited;
  
  private NetManager()
  {
    AppMethodBeat.i(172916);
    this.mInited = false;
    this.mGlobalForceHttps = true;
    AppMethodBeat.o(172916);
  }
  
  private NetRequest.NetRequestBuilder builder(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(211044);
    paramNetRequest = new NetRequest.NetRequestBuilder(this.mAdapter, this.mGlobalSecretKey, paramNetRequest);
    AppMethodBeat.o(211044);
    return paramNetRequest;
  }
  
  static NetAdapter createAdapter(Context paramContext, NetConfig paramNetConfig)
  {
    AppMethodBeat.i(211030);
    NetConfig localNetConfig = paramNetConfig;
    if (paramNetConfig == null) {
      localNetConfig = NetConfig.create().setForceHttps(true).setAdapterType(AdapterType.URL);
    }
    paramNetConfig = 1.a;
    localNetConfig.getAdapterType().ordinal();
    paramNetConfig = new kz();
    paramNetConfig.initNet(paramContext, localNetConfig);
    AppMethodBeat.o(211030);
    return paramNetConfig;
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
  
  private void init()
  {
    AppMethodBeat.i(211038);
    if ((this.mInited) || (this.mAdapter == null))
    {
      AppMethodBeat.o(211038);
      return;
    }
    this.mInited = true;
    this.mGlobalForceHttps = this.mAdapter.isForceHttps();
    this.mGlobalSecretKey = this.mAdapter.getSecretKey();
    AppMethodBeat.o(211038);
  }
  
  public static void init(Context paramContext, NetConfig paramNetConfig)
  {
    AppMethodBeat.i(211034);
    paramContext = createAdapter(paramContext, paramNetConfig);
    getInstance().setAdapter(paramContext);
    AppMethodBeat.o(211034);
  }
  
  public boolean available()
  {
    return (this.mAdapter != null) && (this.mInited);
  }
  
  public NetRequest.NetRequestBuilder builder()
  {
    AppMethodBeat.i(211067);
    NetRequest.NetRequestBuilder localNetRequestBuilder = builder("");
    AppMethodBeat.o(211067);
    return localNetRequestBuilder;
  }
  
  public NetRequest.NetRequestBuilder builder(String paramString)
  {
    AppMethodBeat.i(211073);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.mGlobalSecretKey;
    }
    paramString = new NetRequest.NetRequestBuilder(this.mAdapter, str);
    paramString.forceHttps(this.mGlobalForceHttps);
    AppMethodBeat.o(211073);
    return paramString;
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(172921);
    paramString1 = builder().url(paramString1).retryNum(paramInt1).header(paramHashMap).userAgent(paramString2).timeOut(paramInt2).canceler(paramHttpCanceler).doGet();
    AppMethodBeat.o(172921);
    return paramString1;
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    AppMethodBeat.i(172922);
    paramString1 = builder().url(paramString1).userAgent(paramString2).postData(paramArrayOfByte).retryNum(paramInt1).header(paramHashMap).timeOut(paramInt2).canceler(paramHttpCanceler).doPost();
    AppMethodBeat.o(172922);
    return paramString1;
  }
  
  public NetResponse doRequest(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(211094);
    paramNetRequest = builder(paramNetRequest).doRequest();
    AppMethodBeat.o(211094);
    return paramNetRequest;
  }
  
  public NetResponse doStream(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(211101);
    paramNetRequest = builder(paramNetRequest).doStream();
    AppMethodBeat.o(211101);
    return paramNetRequest;
  }
  
  public void setAdapter(Context paramContext, NetAdapter paramNetAdapter)
  {
    AppMethodBeat.i(172919);
    if ((paramNetAdapter instanceof URLNetImpl)) {
      ((URLNetImpl)paramNetAdapter).setProxyAdapter(createAdapter(paramContext, NetConfig.create()));
    }
    setAdapter(paramNetAdapter);
    AppMethodBeat.o(172919);
  }
  
  void setAdapter(NetAdapter paramNetAdapter)
  {
    AppMethodBeat.i(211061);
    if (paramNetAdapter == null)
    {
      AppMethodBeat.o(211061);
      return;
    }
    if (this.mAdapter != paramNetAdapter)
    {
      this.mInited = false;
      this.mAdapter = paramNetAdapter;
      init();
    }
    AppMethodBeat.o(211061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.NetManager
 * JD-Core Version:    0.7.0.1
 */