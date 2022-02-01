package com.tencent.luggage.game.g;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.am;

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
    AppMethodBeat.i(220736);
    if ((paramc.Eq() != null) && (paramc.Q(com.tencent.luggage.game.d.a.a.a.class) != null)) {
      if (((b)paramc.Q(b.class) != null) && ((paramc.jDa instanceof o)))
      {
        int i;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramc = paramc.au(Activity.class);
          if (paramc != null)
          {
            paramc = am.bi(paramc);
            if (paramc != null)
            {
              i = paramc.getStableInsetTop();
              if (i > 0)
              {
                i = g.vM(i);
                AppMethodBeat.o(220736);
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
            i = g.vM(i);
            AppMethodBeat.o(220736);
            return i;
          }
        }
      }
      else
      {
        ae.printErrStackTrace("MicroMsg.WAGameCommonUtil", new com.tencent.luggage.game.d.a.a.c(), "hy: not game service", new Object[0]);
      }
    }
    AppMethodBeat.o(220736);
    return 0;
  }
  
  public static final class a
  {
    volatile boolean done = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.g.a
 * JD-Core Version:    0.7.0.1
 */