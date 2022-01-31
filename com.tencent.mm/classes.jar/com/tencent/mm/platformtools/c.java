package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  private n gjc;
  private o gjd;
  private p gje;
  private l gjf;
  private m gjg;
  private k gjh;
  
  private static void a(d paramd)
  {
    AppMethodBeat.i(124516);
    if (paramd != null)
    {
      Iterator localIterator = paramd.gji.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        g.Rc().b(localInteger.intValue(), paramd);
      }
      paramd.activity = null;
    }
    AppMethodBeat.o(124516);
  }
  
  public final boolean a(Activity paramActivity, ag paramag)
  {
    AppMethodBeat.i(124515);
    if ((paramag.type == 0) || (paramag.action == 0))
    {
      AppMethodBeat.o(124515);
      return false;
    }
    if (this.gjh == null) {
      this.gjh = new k(paramActivity);
    }
    if (this.gjh.a(paramag))
    {
      AppMethodBeat.o(124515);
      return true;
    }
    switch (paramag.type)
    {
    default: 
      ab.e("MicroMsg.BaseErrorHelper", "Unkown error type");
    }
    for (;;)
    {
      AppMethodBeat.o(124515);
      return false;
      if (this.gjc == null) {
        this.gjc = new n(paramActivity);
      }
      this.gjc.a(paramag);
      continue;
      if (this.gjd == null) {
        this.gjd = new o(paramActivity);
      }
      this.gjd.a(paramag);
      continue;
      if (this.gje == null) {
        this.gje = new p(paramActivity);
      }
      this.gje.a(paramag);
      continue;
      if (this.gjf == null) {
        this.gjf = new l(paramActivity);
      }
      this.gjf.a(paramag);
      continue;
      if (this.gjg == null) {
        this.gjg = new m(paramActivity);
      }
      this.gjg.a(paramag);
      continue;
      if (this.gjh == null) {
        this.gjh = new k(paramActivity);
      }
      this.gjh.a(paramag);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(124517);
    a(this.gjc);
    a(this.gjd);
    a(this.gje);
    a(this.gjf);
    a(this.gjg);
    a(this.gjh);
    AppMethodBeat.o(124517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.platformtools.c
 * JD-Core Version:    0.7.0.1
 */