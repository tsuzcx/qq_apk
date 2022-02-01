package com.tencent.luggage.game.g;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s.a.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.p;

public class a
{
  public static void a(a parama, Runnable paramRunnable)
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
    AppMethodBeat.i(194662);
    if ((paramc.Dl() != null) && (paramc.Q(com.tencent.luggage.game.d.a.a.a.class) != null)) {
      if (((b)paramc.Q(b.class) != null) && ((paramc.iGU instanceof o)))
      {
        int i;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramc = paramc.au(Activity.class);
          if (paramc != null)
          {
            paramc = ak.bd(paramc);
            if (paramc != null)
            {
              i = paramc.getStableInsetTop();
              if (i > 0)
              {
                i = g.uk(i);
                AppMethodBeat.o(194662);
                return i;
              }
            }
          }
        }
        else
        {
          i = p.jm(paramc.getContext());
          if (i > 0)
          {
            i = g.uk(i);
            AppMethodBeat.o(194662);
            return i;
          }
        }
      }
      else
      {
        ad.printErrStackTrace("MicroMsg.WAGameCommonUtil", new com.tencent.luggage.game.d.a.a.c(), "hy: not game service", new Object[0]);
      }
    }
    AppMethodBeat.o(194662);
    return 0;
  }
  
  public static final class a
  {
    volatile boolean done = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.g.a
 * JD-Core Version:    0.7.0.1
 */