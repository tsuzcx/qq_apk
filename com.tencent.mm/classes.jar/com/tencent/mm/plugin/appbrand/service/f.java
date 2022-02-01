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
  public abstract String KJ(String paramString);
  
  public abstract Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4);
  
  public abstract <T extends Parcelable> void a(String paramString, T paramT);
  
  public abstract void aYx();
  
  public abstract void aYy();
  
  public abstract void aYz();
  
  public abstract Pair<String, Integer> rO(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.f
 * JD-Core Version:    0.7.0.1
 */