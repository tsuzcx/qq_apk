package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class e
{
  public boolean ByJ = false;
  public c ByS;
  public int errCode = -1;
  public String errMsg = "";
  public int retryCount = 0;
  
  public static e b(c paramc)
  {
    AppMethodBeat.i(64402);
    e locale = new e();
    locale.ByS = paramc;
    switch (paramc.errCode)
    {
    default: 
    case 0: 
    case 2002: 
      for (;;)
      {
        AppMethodBeat.o(64402);
        return locale;
        locale.errCode = 0;
        continue;
        locale.errCode = 1;
      }
    }
    locale.errCode = 2;
    String str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
    if (paramc.errCode == 10308) {
      str = MMApplicationContext.getContext().getString(a.i.soter_on_error_max_trial);
    }
    for (;;)
    {
      locale.errMsg = str;
      break;
      if (paramc.errCode == 2007)
      {
        p.ByH.ByJ = true;
        locale.ByJ = true;
      }
      else if (paramc.errCode == 2005)
      {
        str = MMApplicationContext.getContext().getString(a.i.soter_on_sensor_error);
      }
    }
  }
  
  public final boolean canRetry()
  {
    return this.errCode == 1;
  }
  
  public final boolean isSuccess()
  {
    return this.errCode == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.e
 * JD-Core Version:    0.7.0.1
 */