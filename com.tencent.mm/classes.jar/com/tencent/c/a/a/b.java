package com.tencent.c.a.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  static b.a bUq;
  Integer bUr;
  String bUs;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(125746);
    this.bUr = null;
    this.bUs = null;
    try
    {
      aK(paramContext);
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null) {
        this.bUr = Integer.valueOf(localTelephonyManager.getNetworkType());
      }
      this.bUs = s.aU(paramContext);
      AppMethodBeat.o(125746);
      return;
    }
    catch (Throwable paramContext)
    {
      s.zV();
      AppMethodBeat.o(125746);
    }
  }
  
  private static b.a aK(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(125745);
      if (bUq == null) {
        bUq = new b.a(paramContext.getApplicationContext(), (byte)0);
      }
      paramContext = bUq;
      AppMethodBeat.o(125745);
      return paramContext;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.b
 * JD-Core Version:    0.7.0.1
 */