package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.c;

public final class l
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(16147);
    b.a(new l(), new String[] { "//pay" });
    AppMethodBeat.o(16147);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(16146);
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(16146);
      return true;
    }
    paramString = paramArrayOfString[1];
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(16146);
        return false;
        if (paramString.equals("dorder"))
        {
          i = 0;
          continue;
          if (paramString.equals("sethassource"))
          {
            i = 1;
            continue;
            if (paramString.equals("dot"))
            {
              i = 2;
              continue;
              if (paramString.equals("forcenewcashier")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    d.H(paramContext, "wallet", ".pwd.ui.WalletUniversalPayOrderUI");
    AppMethodBeat.o(16146);
    return true;
    g.RL().Ru().set(ac.a.yJl, Integer.valueOf(1));
    AppMethodBeat.o(16146);
    return true;
    c.PJ().b(ac.a.yIY, true);
    AppMethodBeat.o(16146);
    return true;
    if (paramArrayOfString.length >= 3)
    {
      i = bo.getInt(paramArrayOfString[2], 0);
      g.RL().Ru().set(ac.a.yJq, Integer.valueOf(i));
    }
    AppMethodBeat.o(16146);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.a.l
 * JD-Core Version:    0.7.0.1
 */