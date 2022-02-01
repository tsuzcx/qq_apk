package com.tencent.map.tools.net.adapter;

import android.content.Context;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetConfig;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.mapsdk.internal.kz;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class URLNetImpl
  implements NetAdapter
{
  private NetAdapter mProxy;
  
  public URLNetImpl()
  {
    AppMethodBeat.i(210978);
    this.mProxy = new kz();
    AppMethodBeat.o(210978);
  }
  
  public boolean cancel()
  {
    AppMethodBeat.i(180934);
    boolean bool = this.mProxy.cancel();
    AppMethodBeat.o(180934);
    return bool;
  }
  
  public NetResponse doGet(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(210985);
    paramNetRequest = this.mProxy.doGet(paramNetRequest);
    AppMethodBeat.o(210985);
    return paramNetRequest;
  }
  
  public NetResponse doPost(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(210990);
    paramNetRequest = this.mProxy.doPost(paramNetRequest);
    AppMethodBeat.o(210990);
    return paramNetRequest;
  }
  
  public NetResponse doRequest(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(211013);
    paramNetRequest = this.mProxy.doRequest(paramNetRequest);
    AppMethodBeat.o(211013);
    return paramNetRequest;
  }
  
  public List<HttpProxyRule> getProxyRuleList()
  {
    AppMethodBeat.i(211010);
    List localList = this.mProxy.getProxyRuleList();
    AppMethodBeat.o(211010);
    return localList;
  }
  
  public String getSecretKey()
  {
    AppMethodBeat.i(211006);
    String str = this.mProxy.getSecretKey();
    AppMethodBeat.o(211006);
    return str;
  }
  
  public void initNet(Context paramContext, NetConfig paramNetConfig)
  {
    AppMethodBeat.i(210980);
    this.mProxy.initNet(paramContext, paramNetConfig);
    AppMethodBeat.o(210980);
  }
  
  public boolean isForceHttps()
  {
    AppMethodBeat.i(210999);
    boolean bool = this.mProxy.isForceHttps();
    AppMethodBeat.o(210999);
    return bool;
  }
  
  public boolean isLogEnable()
  {
    AppMethodBeat.i(211003);
    boolean bool = this.mProxy.isLogEnable();
    AppMethodBeat.o(211003);
    return bool;
  }
  
  public NetResponse openStream(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(211017);
    paramNetRequest = this.mProxy.openStream(paramNetRequest);
    AppMethodBeat.o(211017);
    return paramNetRequest;
  }
  
  public void setProxyAdapter(NetAdapter paramNetAdapter)
  {
    this.mProxy = paramNetAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.adapter.URLNetImpl
 * JD-Core Version:    0.7.0.1
 */