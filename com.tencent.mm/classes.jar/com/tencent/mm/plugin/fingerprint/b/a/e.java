package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.sdk.platformtools.ai;

public final class e
{
  public int errCode = -1;
  public String errMsg = "";
  public int retryCount = 0;
  public boolean skL = false;
  public c skU;
  
  public static e b(c paramc)
  {
    AppMethodBeat.i(64402);
    e locale = new e();
    locale.skU = paramc;
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
    String str = ai.getContext().getString(2131764095);
    if (paramc.errCode == 10308) {
      str = ai.getContext().getString(2131764096);
    }
    for (;;)
    {
      locale.errMsg = str;
      break;
      if (paramc.errCode == 2007)
      {
        p.skJ.skL = true;
        locale.skL = true;
      }
      else if (paramc.errCode == 2005)
      {
        str = ai.getContext().getString(2131764097);
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