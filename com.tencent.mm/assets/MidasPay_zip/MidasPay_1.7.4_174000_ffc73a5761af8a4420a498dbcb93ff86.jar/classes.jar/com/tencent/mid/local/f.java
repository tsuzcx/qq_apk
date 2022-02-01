package com.tencent.mid.local;

import android.content.Context;
import android.provider.Settings.System;

public class f
  extends g
{
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean a()
  {
    return i.a(this.a, "android.permission.WRITE_SETTINGS");
  }
  
  protected String b()
  {
    try
    {
      i.a("read mid from Settings.System");
      String str = Settings.System.getString(this.a.getContentResolver(), e());
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.tencent.mid.local.f
 * JD-Core Version:    0.7.0.1
 */