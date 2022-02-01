package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  private m iPJ;
  private n iPK;
  private o iPL;
  private k iPM;
  private l iPN;
  private j iPO;
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(127674);
    if (paramc != null)
    {
      Iterator localIterator = paramc.iPP.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        g.ajj().b(localInteger.intValue(), paramc);
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
    if (this.iPO == null) {
      this.iPO = new j(paramActivity);
    }
    if (this.iPO.a(paramae))
    {
      AppMethodBeat.o(127673);
      return true;
    }
    switch (paramae.type)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BaseErrorHelper", "Unkown error type");
    }
    for (;;)
    {
      AppMethodBeat.o(127673);
      return false;
      if (this.iPJ == null) {
        this.iPJ = new m(paramActivity);
      }
      this.iPJ.a(paramae);
      continue;
      if (this.iPK == null) {
        this.iPK = new n(paramActivity);
      }
      this.iPK.a(paramae);
      continue;
      if (this.iPL == null) {
        this.iPL = new o(paramActivity);
      }
      this.iPL.a(paramae);
      continue;
      if (this.iPM == null) {
        this.iPM = new k(paramActivity);
      }
      this.iPM.a(paramae);
      continue;
      if (this.iPN == null) {
        this.iPN = new l(paramActivity);
      }
      this.iPN.a(paramae);
      continue;
      if (this.iPO == null) {
        this.iPO = new j(paramActivity);
      }
      this.iPO.a(paramae);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(127675);
    a(this.iPJ);
    a(this.iPK);
    a(this.iPL);
    a(this.iPM);
    a(this.iPN);
    a(this.iPO);
    AppMethodBeat.o(127675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.b
 * JD-Core Version:    0.7.0.1
 */