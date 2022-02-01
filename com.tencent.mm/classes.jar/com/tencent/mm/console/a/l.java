package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.z.c;

public final class l
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(20192);
    b.a(new l(), new String[] { "//pay" });
    AppMethodBeat.o(20192);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20191);
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(20191);
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
        AppMethodBeat.o(20191);
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
              if (paramString.equals("forcenewcashier"))
              {
                i = 3;
                continue;
                if (paramString.equals("fackchatting"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("resethbguide")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    d.Q(paramContext, "wallet", ".pwd.ui.WalletUniversalPayOrderUI");
    AppMethodBeat.o(20191);
    return true;
    g.ajC().ajl().set(al.a.ICu, Integer.valueOf(1));
    AppMethodBeat.o(20191);
    return true;
    c.aht().b(al.a.ICh, true);
    AppMethodBeat.o(20191);
    return true;
    if (paramArrayOfString.length >= 3)
    {
      i = bt.getInt(paramArrayOfString[2], 0);
      g.ajC().ajl().set(al.a.ICA, Integer.valueOf(i));
    }
    AppMethodBeat.o(20191);
    return true;
    ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).doRedPacketPreviewLoading(paramContext, "");
    AppMethodBeat.o(20191);
    return true;
    g.ajC().ajl().set(al.a.ICJ, Integer.valueOf(0));
    g.ajC().ajl().set(al.a.ICK, Integer.valueOf(0));
    AppMethodBeat.o(20191);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.a.l
 * JD-Core Version:    0.7.0.1
 */