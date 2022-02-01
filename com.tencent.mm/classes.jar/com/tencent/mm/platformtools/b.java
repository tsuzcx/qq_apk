package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  private m hTH;
  private n hTI;
  private o hTJ;
  private k hTK;
  private l hTL;
  private j hTM;
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(127674);
    if (paramc != null)
    {
      Iterator localIterator = paramc.hTN.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        g.aeS().b(localInteger.intValue(), paramc);
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
    if (this.hTM == null) {
      this.hTM = new j(paramActivity);
    }
    if (this.hTM.a(paramad))
    {
      AppMethodBeat.o(127673);
      return true;
    }
    switch (paramad.type)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BaseErrorHelper", "Unkown error type");
    }
    for (;;)
    {
      AppMethodBeat.o(127673);
      return false;
      if (this.hTH == null) {
        this.hTH = new m(paramActivity);
      }
      this.hTH.a(paramad);
      continue;
      if (this.hTI == null) {
        this.hTI = new n(paramActivity);
      }
      this.hTI.a(paramad);
      continue;
      if (this.hTJ == null) {
        this.hTJ = new o(paramActivity);
      }
      this.hTJ.a(paramad);
      continue;
      if (this.hTK == null) {
        this.hTK = new k(paramActivity);
      }
      this.hTK.a(paramad);
      continue;
      if (this.hTL == null) {
        this.hTL = new l(paramActivity);
      }
      this.hTL.a(paramad);
      continue;
      if (this.hTM == null) {
        this.hTM = new j(paramActivity);
      }
      this.hTM.a(paramad);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(127675);
    a(this.hTH);
    a(this.hTI);
    a(this.hTJ);
    a(this.hTK);
    a(this.hTL);
    a(this.hTM);
    AppMethodBeat.o(127675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.b
 * JD-Core Version:    0.7.0.1
 */