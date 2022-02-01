package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.protocal.protobuf.deb;

public abstract interface JsApiAuthorize$AuthorizeTask$a
{
  public abstract void a(MMAuthScopeRiskInfo paramMMAuthScopeRiskInfo);
  
  public abstract void au(int paramInt, String paramString);
  
  public abstract void b(deb paramdeb);
  
  public abstract void onSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.a
 * JD-Core Version:    0.7.0.1
 */