package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  private l jMA;
  private j jMB;
  private m jMw;
  private n jMx;
  private o jMy;
  private k jMz;
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(127674);
    if (paramc != null)
    {
      Iterator localIterator = paramc.jMC.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        g.azz().b(localInteger.intValue(), paramc);
      }
      paramc.activity = null;
    }
    AppMethodBeat.o(127674);
  }
  
  public final boolean a(Activity paramActivity, ae paramae)
  {
    AppMethodBeat.i(127673);
    if ((paramae.type == 0) || (paramae.action == 0))
    {
      AppMethodBeat.o(127673);
      return false;
    }
    switch (paramae.type)
    {
    default: 
      Log.e("MicroMsg.BaseErrorHelper", "Unkown error type");
      AppMethodBeat.o(127673);
      return false;
    case 1: 
      if (this.jMw == null) {
        this.jMw = new m(paramActivity);
      }
      this.jMw.a(paramae);
    }
    for (;;)
    {
      AppMethodBeat.o(127673);
      return true;
      if (this.jMx == null) {
        this.jMx = new n(paramActivity);
      }
      this.jMx.a(paramae);
      continue;
      if (this.jMy == null) {
        this.jMy = new o(paramActivity);
      }
      this.jMy.a(paramae);
      continue;
      if (this.jMz == null) {
        this.jMz = new k(paramActivity);
      }
      this.jMz.a(paramae);
      continue;
      if (this.jMA == null) {
        this.jMA = new l(paramActivity);
      }
      this.jMA.a(paramae);
      continue;
      if (this.jMB == null) {
        this.jMB = new j(paramActivity);
      }
      this.jMB.a(paramae);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(127675);
    a(this.jMw);
    a(this.jMx);
    a(this.jMy);
    a(this.jMz);
    a(this.jMA);
    a(this.jMB);
    AppMethodBeat.o(127675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.b
 * JD-Core Version:    0.7.0.1
 */