package com.tencent.luggage.game.g;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.am;

public class a
{
  public static void a(a.a parama, Runnable paramRunnable)
  {
    AppMethodBeat.i(130704);
    if (parama == null)
    {
      parama = new IllegalStateException();
      AppMethodBeat.o(130704);
      throw parama;
    }
    if (parama.done)
    {
      AppMethodBeat.o(130704);
      return;
    }
    int i = 0;
    try
    {
      if (!parama.done)
      {
        i = 1;
        parama.done = true;
      }
      if (i != 0) {
        paramRunnable.run();
      }
      AppMethodBeat.o(130704);
      return;
    }
    finally
    {
      AppMethodBeat.o(130704);
    }
  }
  
  public static int b(com.tencent.luggage.sdk.b.a.c.c paramc)
  {
    AppMethodBeat.i(190419);
    if ((paramc.En() != null) && (paramc.Q(com.tencent.luggage.game.d.a.a.a.class) != null)) {
      if (((b)paramc.Q(b.class) != null) && ((paramc.jzX instanceof o)))
      {
        int i;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramc = paramc.au(Activity.class);
          if (paramc != null)
          {
            paramc = am.bh(paramc);
            if (paramc != null)
            {
              i = paramc.getStableInsetTop();
              if (i > 0)
              {
                i = g.vH(i);
                AppMethodBeat.o(190419);
                return i;
              }
            }
          }
        }
        else
        {
          i = n.B(paramc.getContext(), 0);
          if (i > 0)
          {
            i = g.vH(i);
            AppMethodBeat.o(190419);
            return i;
          }
        }
      }
      else
      {
        ad.printErrStackTrace("MicroMsg.WAGameCommonUtil", new com.tencent.luggage.game.d.a.a.c(), "hy: not game service", new Object[0]);
      }
    }
    AppMethodBeat.o(190419);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.g.a
 * JD-Core Version:    0.7.0.1
 */