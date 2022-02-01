package com.tencent.mm.loader.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class d
{
  public static d icC = new d(null);
  protected final SharedPreferences sp;
  
  protected d(SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences == null)
    {
      this.sp = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      return;
    }
    this.sp = paramSharedPreferences;
  }
  
  public final String aA(String paramString1, String paramString2)
  {
    return this.sp.getString(paramString1, paramString2);
  }
  
  public final SharedPreferences aLJ()
  {
    return this.sp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.j.d
 * JD-Core Version:    0.7.0.1
 */