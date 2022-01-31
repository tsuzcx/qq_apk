package com.tencent.c.a.a;

import android.content.Context;
import android.telephony.TelephonyManager;

final class b
{
  static b.a bte;
  Integer btf = null;
  String btg = null;
  
  public b(Context paramContext)
  {
    try
    {
      am(paramContext);
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null) {
        this.btf = Integer.valueOf(localTelephonyManager.getNetworkType());
      }
      this.btg = s.aw(paramContext);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static b.a am(Context paramContext)
  {
    try
    {
      if (bte == null) {
        bte = new b.a(paramContext.getApplicationContext(), (byte)0);
      }
      paramContext = bte;
      return paramContext;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */