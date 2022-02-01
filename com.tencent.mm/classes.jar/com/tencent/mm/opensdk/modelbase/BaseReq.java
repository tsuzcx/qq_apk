package com.tencent.mm.opensdk.modelbase;

import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.a;

public abstract class BaseReq
{
  public String openId;
  public String transaction;
  
  public abstract boolean checkArgs();
  
  public void fromBundle(Bundle paramBundle)
  {
    this.transaction = a.a(paramBundle, "_wxapi_basereq_transaction");
    this.openId = a.a(paramBundle, "_wxapi_basereq_openid");
  }
  
  public abstract int getType();
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putInt("_wxapi_command_type", getType());
    paramBundle.putString("_wxapi_basereq_transaction", this.transaction);
    paramBundle.putString("_wxapi_basereq_openid", this.openId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbase.BaseReq
 * JD-Core Version:    0.7.0.1
 */