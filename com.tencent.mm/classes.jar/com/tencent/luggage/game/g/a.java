package com.tencent.luggage.game.g;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ap;

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
  
  public static int b(com.tencent.luggage.sdk.b.a.c.d paramd)
  {
    AppMethodBeat.i(222892);
    if ((paramd.NP() != null) && (paramd.S(com.tencent.luggage.game.d.a.a.a.class) != null)) {
      if (((b)paramd.S(b.class) != null) && ((paramd.kEb instanceof o)))
      {
        int i;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramd = paramd.ay(Activity.class);
          if (paramd != null)
          {
            paramd = ap.bo(paramd);
            if (paramd != null)
            {
              i = paramd.getStableInsetTop();
              if (i > 0)
              {
                i = g.zB(i);
                AppMethodBeat.o(222892);
                return i;
              }
            }
          }
        }
        else
        {
          i = n.D(paramd.getContext(), 0);
          if (i > 0)
          {
            i = g.zB(i);
            AppMethodBeat.o(222892);
            return i;
          }
        }
      }
      else
      {
        Log.printErrStackTrace("MicroMsg.WAGameCommonUtil", new com.tencent.luggage.game.d.a.a.d(), "hy: not game service", new Object[0]);
      }
    }
    AppMethodBeat.o(222892);
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