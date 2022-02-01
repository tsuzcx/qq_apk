package com.tencent.map.tools.net;

import android.content.Context;
import com.tencent.map.tools.net.http.HttpProxyRule;
import java.util.List;

public abstract interface NetAdapter
{
  public abstract boolean cancel();
  
  public abstract NetResponse doGet(NetRequest paramNetRequest);
  
  public abstract NetResponse doPost(NetRequest paramNetRequest);
  
  public abstract NetResponse doRequest(NetRequest paramNetRequest);
  
  public abstract List<HttpProxyRule> getProxyRuleList();
  
  public abstract String getSecretKey();
  
  public abstract void initNet(Context paramContext, NetConfig paramNetConfig);
  
  public abstract boolean isForceHttps();
  
  public abstract boolean isLogEnable();
  
  public abstract NetResponse openStream(NetRequest paramNetRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.NetAdapter
 * JD-Core Version:    0.7.0.1
 */