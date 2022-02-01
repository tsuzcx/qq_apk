package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  private m iMP;
  private n iMQ;
  private o iMR;
  private k iMS;
  private l iMT;
  private j iMU;
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(127674);
    if (paramc != null)
    {
      Iterator localIterator = paramc.iMV.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        g.aiU().b(localInteger.intValue(), paramc);
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
    if (this.iMU == null) {
      this.iMU = new j(paramActivity);
    }
    if (this.iMU.a(paramae))
    {
      AppMethodBeat.o(127673);
      return true;
    }
    switch (paramae.type)
    {
    default: 
      ad.e("MicroMsg.BaseErrorHelper", "Unkown error type");
    }
    for (;;)
    {
      AppMethodBeat.o(127673);
      return false;
      if (this.iMP == null) {
        this.iMP = new m(paramActivity);
      }
      this.iMP.a(paramae);
      continue;
      if (this.iMQ == null) {
        this.iMQ = new n(paramActivity);
      }
      this.iMQ.a(paramae);
      continue;
      if (this.iMR == null) {
        this.iMR = new o(paramActivity);
      }
      this.iMR.a(paramae);
      continue;
      if (this.iMS == null) {
        this.iMS = new k(paramActivity);
      }
      this.iMS.a(paramae);
      continue;
      if (this.iMT == null) {
        this.iMT = new l(paramActivity);
      }
      this.iMT.a(paramae);
      continue;
      if (this.iMU == null) {
        this.iMU = new j(paramActivity);
      }
      this.iMU.a(paramae);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(127675);
    a(this.iMP);
    a(this.iMQ);
    a(this.iMR);
    a(this.iMS);
    a(this.iMT);
    a(this.iMU);
    AppMethodBeat.o(127675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.platformtools.b
 * JD-Core Version:    0.7.0.1
 */