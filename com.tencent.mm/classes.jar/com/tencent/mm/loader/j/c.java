package com.tencent.mm.loader.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ak;

public class c
{
  public static c hjF = new c(null);
  protected final SharedPreferences sp;
  
  protected c(SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences == null)
    {
      this.sp = ak.getContext().getSharedPreferences(ak.fow(), 0);
      return;
    }
    this.sp = paramSharedPreferences;
  }
  
  public final SharedPreferences atj()
  {
    return this.sp;
  }
  
  public final String ay(String paramString1, String paramString2)
  {
    return this.sp.getString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.j.c
 * JD-Core Version:    0.7.0.1
 */