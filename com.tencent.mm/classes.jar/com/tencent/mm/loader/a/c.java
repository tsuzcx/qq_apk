package com.tencent.mm.loader.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;

public class c
{
  public static c dOS = new c(null);
  public final SharedPreferences dnD;
  
  public c(SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences == null)
    {
      this.dnD = ae.getContext().getSharedPreferences(ae.cqR(), 0);
      return;
    }
    this.dnD = paramSharedPreferences;
  }
  
  public final String L(String paramString1, String paramString2)
  {
    return this.dnD.getString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.a.c
 * JD-Core Version:    0.7.0.1
 */