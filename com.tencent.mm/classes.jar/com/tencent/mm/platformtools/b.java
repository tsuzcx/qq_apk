package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  private k pAk;
  private l pAl;
  private m pAm;
  private i pAn;
  private j pAo;
  private h pAp;
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(127674);
    if (paramc != null)
    {
      Iterator localIterator = paramc.pAq.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        com.tencent.mm.kernel.h.aZW().b(localInteger.intValue(), paramc);
      }
      paramc.activity = null;
    }
    AppMethodBeat.o(127674);
  }
  
  public final boolean a(Activity paramActivity, aa paramaa)
  {
    AppMethodBeat.i(127673);
    if ((paramaa.type == 0) || (paramaa.action == 0))
    {
      AppMethodBeat.o(127673);
      return false;
    }
    switch (paramaa.type)
    {
    default: 
      Log.e("MicroMsg.BaseErrorHelper", "Unkown error type");
      AppMethodBeat.o(127673);
      return false;
    case 1: 
      if (this.pAk == null) {
        this.pAk = new k(paramActivity);
      }
      this.pAk.a(paramaa);
    }
    for (;;)
    {
      AppMethodBeat.o(127673);
      return true;
      if (this.pAl == null) {
        this.pAl = new l(paramActivity);
      }
      this.pAl.a(paramaa);
      continue;
      if (this.pAm == null) {
        this.pAm = new m(paramActivity);
      }
      this.pAm.a(paramaa);
      continue;
      if (this.pAn == null) {
        this.pAn = new i(paramActivity);
      }
      this.pAn.a(paramaa);
      continue;
      if (this.pAo == null) {
        this.pAo = new j(paramActivity);
      }
      this.pAo.a(paramaa);
      continue;
      if (this.pAp == null) {
        this.pAp = new h(paramActivity);
      }
      this.pAp.a(paramaa);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(127675);
    a(this.pAk);
    a(this.pAl);
    a(this.pAm);
    a(this.pAn);
    a(this.pAo);
    a(this.pAp);
    AppMethodBeat.o(127675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.b
 * JD-Core Version:    0.7.0.1
 */