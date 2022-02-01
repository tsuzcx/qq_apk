package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  private m itM;
  private n itN;
  private o itO;
  private k itP;
  private l itQ;
  private j itR;
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(127674);
    if (paramc != null)
    {
      Iterator localIterator = paramc.itS.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        g.agi().b(localInteger.intValue(), paramc);
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
    if (this.itR == null) {
      this.itR = new j(paramActivity);
    }
    if (this.itR.a(paramad))
    {
      AppMethodBeat.o(127673);
      return true;
    }
    switch (paramad.type)
    {
    default: 
      ac.e("MicroMsg.BaseErrorHelper", "Unkown error type");
    }
    for (;;)
    {
      AppMethodBeat.o(127673);
      return false;
      if (this.itM == null) {
        this.itM = new m(paramActivity);
      }
      this.itM.a(paramad);
      continue;
      if (this.itN == null) {
        this.itN = new n(paramActivity);
      }
      this.itN.a(paramad);
      continue;
      if (this.itO == null) {
        this.itO = new o(paramActivity);
      }
      this.itO.a(paramad);
      continue;
      if (this.itP == null) {
        this.itP = new k(paramActivity);
      }
      this.itP.a(paramad);
      continue;
      if (this.itQ == null) {
        this.itQ = new l(paramActivity);
      }
      this.itQ.a(paramad);
      continue;
      if (this.itR == null) {
        this.itR = new j(paramActivity);
      }
      this.itR.a(paramad);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(127675);
    a(this.itM);
    a(this.itN);
    a(this.itO);
    a(this.itP);
    a(this.itQ);
    a(this.itR);
    AppMethodBeat.o(127675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.b
 * JD-Core Version:    0.7.0.1
 */