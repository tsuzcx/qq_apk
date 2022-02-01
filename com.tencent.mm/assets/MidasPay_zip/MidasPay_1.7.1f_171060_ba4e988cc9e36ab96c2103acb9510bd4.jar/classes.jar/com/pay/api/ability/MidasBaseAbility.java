package com.pay.api.ability;

import android.os.Bundle;
import com.pay.api.request.APBaseRequest;

public abstract class MidasBaseAbility
  extends APBaseRequest
  implements IMidasAbility
{
  public static final String BUNDLE_PREFIX = "__midas_ability_baseReq__";
  public String configs;
  public String offerId;
  public String openId;
  public String openKey;
  public String others;
  public String pf;
  public String pfKey;
  public String postBack;
  public String sessionId;
  public String sessionType;
  
  public void fromBundle(Bundle paramBundle)
  {
    this.offerId = paramBundle.getString("__midas_ability_baseReq__offerId");
    this.openId = paramBundle.getString("__midas_ability_baseReq__openId");
    this.openKey = paramBundle.getString("__midas_ability_baseReq__openKey");
    this.sessionId = paramBundle.getString("__midas_ability_baseReq__sessionId");
    this.sessionType = paramBundle.getString("__midas_ability_baseReq__sessionType");
    this.pf = paramBundle.getString("__midas_ability_baseReq__pf");
    this.pfKey = paramBundle.getString("__midas_ability_baseReq__pfKey");
    this.configs = paramBundle.getString("__midas_ability_baseReq__configs");
    this.postBack = paramBundle.getString("__midas_ability_baseReq__postBack");
    this.others = paramBundle.getString("__midas_ability_baseReq__others");
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("__midas_ability_baseReq__ClassSimpleName", getClass().getSimpleName());
    localBundle.putString("__midas_ability_baseReq__offerId", this.offerId);
    localBundle.putString("__midas_ability_baseReq__openId", this.openId);
    localBundle.putString("__midas_ability_baseReq__openKey", this.openKey);
    localBundle.putString("__midas_ability_baseReq__sessionId", this.sessionId);
    localBundle.putString("__midas_ability_baseReq__sessionType", this.sessionType);
    localBundle.putString("__midas_ability_baseReq__pf", this.pf);
    localBundle.putString("__midas_ability_baseReq__pfKey", this.pfKey);
    localBundle.putString("__midas_ability_baseReq__configs", this.configs);
    localBundle.putString("__midas_ability_baseReq__postBack", this.postBack);
    localBundle.putString("__midas_ability_baseReq__others", this.others);
    return localBundle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("offerId=");
    localStringBuilder.append(this.offerId);
    localStringBuilder.append("|openKey=******|openKey=");
    localStringBuilder.append(this.openKey);
    localStringBuilder.append("|sessionId=");
    localStringBuilder.append(this.sessionId);
    localStringBuilder.append("|sessionType=");
    localStringBuilder.append(this.sessionType);
    localStringBuilder.append("|pf=");
    localStringBuilder.append(this.pf);
    localStringBuilder.append("|pfKey=");
    localStringBuilder.append(this.pfKey);
    localStringBuilder.append("|configs=");
    localStringBuilder.append(this.configs);
    localStringBuilder.append("|postBack=");
    localStringBuilder.append(this.postBack);
    localStringBuilder.append("|others=");
    localStringBuilder.append(this.others);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.api.ability.MidasBaseAbility
 * JD-Core Version:    0.7.0.1
 */