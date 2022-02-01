package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  public int errCode = -1;
  public String errMsg = "";
  public int retryCount = 0;
  public boolean wFM = false;
  public c wFV;
  
  public static e b(c paramc)
  {
    AppMethodBeat.i(64402);
    e locale = new e();
    locale.wFV = paramc;
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
    String str = MMApplicationContext.getContext().getString(2131766337);
    if (paramc.errCode == 10308) {
      str = MMApplicationContext.getContext().getString(2131766338);
    }
    for (;;)
    {
      locale.errMsg = str;
      break;
      if (paramc.errCode == 2007)
      {
        p.wFK.wFM = true;
        locale.wFM = true;
      }
      else if (paramc.errCode == 2005)
      {
        str = MMApplicationContext.getContext().getString(2131766339);
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