package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.plugin.appbrand.api.c;

@e(c.class)
public abstract interface f
  extends a
{
  public abstract String Ur(String paramString);
  
  public abstract Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4);
  
  public abstract void a(z paramz);
  
  public abstract <T extends Parcelable> void a(String paramString, T paramT);
  
  public abstract void b(z paramz);
  
  public abstract void bui();
  
  public abstract void buj();
  
  public abstract void buk();
  
  public abstract void c(z paramz);
  
  public abstract Pair<String, Integer> vN(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.f
 * JD-Core Version:    0.7.0.1
 */