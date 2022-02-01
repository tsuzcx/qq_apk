package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  private m mDE;
  private n mDF;
  private o mDG;
  private k mDH;
  private l mDI;
  private j mDJ;
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(127674);
    if (paramc != null)
    {
      Iterator localIterator = paramc.mDK.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        h.aGY().b(localInteger.intValue(), paramc);
      }
      paramc.activity = null;
    }
    AppMethodBeat.o(127674);
  }
  
  public final boolean a(Activity paramActivity, ad paramad)
  {
    AppMethodBeat.i(127673);
    if ((paramad.type == 0) || (paramad.action == 0))
    {
      AppMethodBeat.o(127673);
      return false;
    }
    switch (paramad.type)
    {
    default: 
      Log.e("MicroMsg.BaseErrorHelper", "Unkown error type");
      AppMethodBeat.o(127673);
      return false;
    case 1: 
      if (this.mDE == null) {
        this.mDE = new m(paramActivity);
      }
      this.mDE.a(paramad);
    }
    for (;;)
    {
      AppMethodBeat.o(127673);
      return true;
      if (this.mDF == null) {
        this.mDF = new n(paramActivity);
      }
      this.mDF.a(paramad);
      continue;
      if (this.mDG == null) {
        this.mDG = new o(paramActivity);
      }
      this.mDG.a(paramad);
      continue;
      if (this.mDH == null) {
        this.mDH = new k(paramActivity);
      }
      this.mDH.a(paramad);
      continue;
      if (this.mDI == null) {
        this.mDI = new l(paramActivity);
      }
      this.mDI.a(paramad);
      continue;
      if (this.mDJ == null) {
        this.mDJ = new j(paramActivity);
      }
      this.mDJ.a(paramad);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(127675);
    a(this.mDE);
    a(this.mDF);
    a(this.mDG);
    a(this.mDH);
    a(this.mDI);
    a(this.mDJ);
    AppMethodBeat.o(127675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.b
 * JD-Core Version:    0.7.0.1
 */