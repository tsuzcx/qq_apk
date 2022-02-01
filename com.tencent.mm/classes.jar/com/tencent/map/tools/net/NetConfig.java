package com.tencent.map.tools.net;

import android.os.Bundle;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class NetConfig
{
  private AdapterType mAdapterType = AdapterType.URL;
  private Bundle mArguments;
  private boolean mForceHttps = true;
  private boolean mIsLogEnable = false;
  private List<HttpProxyRule> mProxyRuleList;
  private String mSecretKey;
  
  public static NetConfig create()
  {
    AppMethodBeat.i(211027);
    NetConfig localNetConfig = new NetConfig();
    AppMethodBeat.o(211027);
    return localNetConfig;
  }
  
  public AdapterType getAdapterType()
  {
    return this.mAdapterType;
  }
  
  public Bundle getArguments()
  {
    return this.mArguments;
  }
  
  public List<HttpProxyRule> getProxyRuleList()
  {
    return this.mProxyRuleList;
  }
  
  public String getSecretKey()
  {
    return this.mSecretKey;
  }
  
  public boolean isForceHttps()
  {
    return this.mForceHttps;
  }
  
  public boolean isLogEnable()
  {
    return this.mIsLogEnable;
  }
  
  public NetConfig setAdapterType(AdapterType paramAdapterType)
  {
    this.mAdapterType = paramAdapterType;
    return this;
  }
  
  public NetConfig setArguments(Bundle paramBundle)
  {
    this.mArguments = paramBundle;
    return this;
  }
  
  public NetConfig setForceHttps(boolean paramBoolean)
  {
    this.mForceHttps = paramBoolean;
    return this;
  }
  
  public NetConfig setLogEnable(boolean paramBoolean)
  {
    this.mIsLogEnable = paramBoolean;
    return this;
  }
  
  public NetConfig setProxyRuleList(List<HttpProxyRule> paramList)
  {
    this.mProxyRuleList = paramList;
    return this;
  }
  
  public NetConfig setSecretKey(String paramString)
  {
    this.mSecretKey = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.NetConfig
 * JD-Core Version:    0.7.0.1
 */