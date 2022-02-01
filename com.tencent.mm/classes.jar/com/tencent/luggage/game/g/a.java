package com.tencent.luggage.game.g;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ay;

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
  
  public static int b(com.tencent.luggage.sdk.b.a.d.d paramd)
  {
    AppMethodBeat.i(220105);
    if ((paramd.aqZ() != null) && (paramd.aa(com.tencent.luggage.game.d.a.a.a.class) != null)) {
      if (((b)paramd.aa(b.class) != null) && ((paramd.qwF instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o)))
      {
        int i;
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramd = paramd.aQ(Activity.class);
          if (paramd != null)
          {
            paramd = ay.bY(paramd);
            if (paramd != null)
            {
              i = paramd.getStableInsetTop();
              if (i > 0)
              {
                i = i.DA(i);
                AppMethodBeat.o(220105);
                return i;
              }
            }
          }
        }
        else
        {
          i = com.tencent.mm.compatible.util.o.I(paramd.getContext(), 0);
          if (i > 0)
          {
            i = i.DA(i);
            AppMethodBeat.o(220105);
            return i;
          }
        }
      }
      else
      {
        Log.printErrStackTrace("MicroMsg.WAGameCommonUtil", new com.tencent.luggage.game.d.a.a.d(), "hy: not game service", new Object[0]);
      }
    }
    AppMethodBeat.o(220105);
    return 0;
  }
  
  public static final class a
  {
    volatile boolean done = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.g.a
 * JD-Core Version:    0.7.0.1
 */