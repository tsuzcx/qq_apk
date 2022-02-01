package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.protocal.protobuf.csf;
import java.util.LinkedList;

abstract interface JsApiLogin$LoginTask$a
{
  public abstract void a(LinkedList<csf> paramLinkedList, String paramString1, String paramString2, String paramString3);
  
  public abstract void ad(int paramInt, String paramString);
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.a
 * JD-Core Version:    0.7.0.1
 */