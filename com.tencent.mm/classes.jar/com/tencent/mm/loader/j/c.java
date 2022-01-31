package com.tencent.mm.loader.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ah;

public class c
{
  public static c eQB = new c(null);
  protected final SharedPreferences sp;
  
  protected c(SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences == null)
    {
      this.sp = ah.getContext().getSharedPreferences(ah.dsP(), 0);
      return;
    }
    this.sp = paramSharedPreferences;
  }
  
  public final SharedPreferences Ul()
  {
    return this.sp;
  }
  
  public final String Y(String paramString1, String paramString2)
  {
    return this.sp.getString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.j.c
 * JD-Core Version:    0.7.0.1
 */