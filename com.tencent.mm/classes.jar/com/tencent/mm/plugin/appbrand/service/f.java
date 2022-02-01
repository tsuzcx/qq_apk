package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.a.c;

@e(c.class)
public abstract interface f
  extends a
{
  public abstract String Hx(String paramString);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4);
  
  public abstract <T extends Parcelable> void a(String paramString, T paramT);
  
  public abstract void aVd();
  
  public abstract void aVe();
  
  public abstract void aVf();
  
  public abstract Pair<String, Integer> ro(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.f
 * JD-Core Version:    0.7.0.1
 */