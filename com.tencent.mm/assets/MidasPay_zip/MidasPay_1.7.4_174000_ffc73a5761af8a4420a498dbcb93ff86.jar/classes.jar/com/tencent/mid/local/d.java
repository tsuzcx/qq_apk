package com.tencent.mid.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

class d
  extends g
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected String b()
  {
    try
    {
      i.a("read mid from sharedPreferences");
      String str = PreferenceManager.getDefaultSharedPreferences(this.a).getString(e(), null);
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.tencent.mid.local.d
 * JD-Core Version:    0.7.0.1
 */