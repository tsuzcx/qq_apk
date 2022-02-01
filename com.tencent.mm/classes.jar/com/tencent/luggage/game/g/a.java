package com.tencent.luggage.game.g;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.as;

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
  
  public static int b(com.tencent.luggage.sdk.b.a.c.d paramd)
  {
    AppMethodBeat.i(246932);
    if ((paramd.QM() != null) && (paramd.R(com.tencent.luggage.game.d.a.a.a.class) != null)) {
      if (((b)paramd.R(b.class) != null) && ((paramd.nxr instanceof o)))
      {
        int i;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramd = paramd.ax(Activity.class);
          if (paramd != null)
          {
            paramd = as.bu(paramd);
            if (paramd != null)
            {
              i = paramd.getStableInsetTop();
              if (i > 0)
              {
                i = g.Dg(i);
                AppMethodBeat.o(246932);
                return i;
              }
            }
          }
        }
        else
        {
          i = n.F(paramd.getContext(), 0);
          if (i > 0)
          {
            i = g.Dg(i);
            AppMethodBeat.o(246932);
            return i;
          }
        }
      }
      else
      {
        Log.printErrStackTrace("MicroMsg.WAGameCommonUtil", new com.tencent.luggage.game.d.a.a.d(), "hy: not game service", new Object[0]);
      }
    }
    AppMethodBeat.o(246932);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.g.a
 * JD-Core Version:    0.7.0.1
 */