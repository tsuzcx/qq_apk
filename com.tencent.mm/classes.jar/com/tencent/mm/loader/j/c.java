package com.tencent.mm.loader.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.aj;

public class c
{
  public static c hgR = new c(null);
  protected final SharedPreferences sp;
  
  protected c(SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences == null)
    {
      this.sp = aj.getContext().getSharedPreferences(aj.fkC(), 0);
      return;
    }
    this.sp = paramSharedPreferences;
  }
  
  public final SharedPreferences asU()
  {
    return this.sp;
  }
  
  public final String ax(String paramString1, String paramString2)
  {
    return this.sp.getString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.j.c
 * JD-Core Version:    0.7.0.1
 */