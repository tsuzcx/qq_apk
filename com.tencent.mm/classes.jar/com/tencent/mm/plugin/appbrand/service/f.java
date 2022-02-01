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
  public abstract String Lj(String paramString);
  
  public abstract Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4);
  
  public abstract <T extends Parcelable> void a(String paramString, T paramT);
  
  public abstract void aYS();
  
  public abstract void aYT();
  
  public abstract void aYU();
  
  public abstract void aYV();
  
  public abstract Pair<String, Integer> rR(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.f
 * JD-Core Version:    0.7.0.1
 */