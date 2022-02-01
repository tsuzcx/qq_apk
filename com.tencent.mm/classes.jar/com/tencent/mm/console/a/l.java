package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

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
                  if (paramString.equals("resethbguide"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("kindatest")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    com.tencent.mm.br.c.ai(paramContext, "wallet", ".pwd.ui.WalletUniversalPayOrderUI");
    AppMethodBeat.o(20191);
    return true;
    h.baE().ban().set(at.a.acVd, Integer.valueOf(1));
    AppMethodBeat.o(20191);
    return true;
    com.tencent.mm.aa.c.aYo().b(at.a.acUP, true);
    AppMethodBeat.o(20191);
    return true;
    if (paramArrayOfString.length >= 3)
    {
      i = Util.getInt(paramArrayOfString[2], 0);
      h.baE().ban().set(at.a.acVk, Integer.valueOf(i));
    }
    AppMethodBeat.o(20191);
    return true;
    ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).doRedPacketPreviewLoading(paramContext, "");
    AppMethodBeat.o(20191);
    return true;
    h.baE().ban().set(at.a.acVt, Integer.valueOf(0));
    h.baE().ban().set(at.a.acVu, Integer.valueOf(0));
    AppMethodBeat.o(20191);
    return true;
    ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startUiTest();
    AppMethodBeat.o(20191);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.l
 * JD-Core Version:    0.7.0.1
 */