package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.t.e;

final class f$a
{
  final int iTY;
  final int iTZ;
  private final int iUa;
  final int iUb;
  final int iUc;
  final int iUd;
  
  private f$a(f paramf, Context paramContext)
  {
    AppMethodBeat.i(133416);
    this.iTY = e.c(paramContext, 1.0F);
    this.iTZ = a.fromDPToPix(paramContext, 20);
    this.iUa = 0;
    this.iUb = a.fromDPToPix(paramContext, 12);
    this.iUc = a.m(paramContext, 2131689712);
    this.iUd = 2;
    AppMethodBeat.o(133416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.f.a
 * JD-Core Version:    0.7.0.1
 */