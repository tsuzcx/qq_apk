package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;

@e(Dr=c.class)
public abstract interface g
  extends a
{
  public abstract String UC(String paramString);
  
  public abstract Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4);
  
  public abstract void a(ab paramab);
  
  public abstract <T extends Parcelable> void a(String paramString, T paramT);
  
  public abstract void b(ab paramab);
  
  public abstract void c(ab paramab);
  
  public abstract void cew();
  
  public abstract void cex();
  
  public abstract void cey();
  
  public abstract p zk(int paramInt);
  
  public abstract Pair<String, Integer> zl(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.g
 * JD-Core Version:    0.7.0.1
 */