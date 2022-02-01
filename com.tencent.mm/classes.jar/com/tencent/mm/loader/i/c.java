package com.tencent.mm.loader.i;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class c
{
  public static c nsL = new c(null);
  protected final SharedPreferences sp;
  
  protected c(SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences == null)
    {
      this.sp = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      return;
    }
    this.sp = paramSharedPreferences;
  }
  
  public final String aM(String paramString1, String paramString2)
  {
    return this.sp.getString(paramString1, paramString2);
  }
  
  public final SharedPreferences bnD()
  {
    return this.sp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.i.c
 * JD-Core Version:    0.7.0.1
 */