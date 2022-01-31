package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

final class c$9
  implements b.a
{
  c$9(c paramc) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(113604);
    if (!paramBoolean)
    {
      if ((!c.A(this.ogD)) && (!com.tencent.mm.modelgeo.d.agR()))
      {
        c.B(this.ogD);
        h.a(this.ogD.activity, this.ogD.activity.getString(2131300538), this.ogD.activity.getString(2131297087), this.ogD.activity.getString(2131300996), this.ogD.activity.getString(2131296888), false, new c.9.1(this), null);
      }
      AppMethodBeat.o(113604);
      return false;
    }
    if ((c.g(this.ogD) == -85.0D) || (c.h(this.ogD) == -1000.0D))
    {
      ab.d("MicroMsg.MMPoiMapUI", "first get location");
      String str = (int)(1000000.0F * paramFloat2) + "," + (int)(1000000.0F * paramFloat1);
      g.RL().Ru().set(ac.a.yBl, str);
      c.c(this.ogD, paramFloat2);
      c.d(this.ogD, paramFloat1);
      c.a(this.ogD, paramFloat2);
      c.b(this.ogD, paramFloat1);
      c.a(this.ogD, c.g(this.ogD));
      c.b(this.ogD, c.h(this.ogD));
      c.k(this.ogD).l(c.i(this.ogD), c.j(this.ogD));
      this.ogD.ocL.getIController().animateTo(c.g(this.ogD), c.h(this.ogD), com.tencent.mm.plugin.location.ui.d.bLF());
      if (!c.q(this.ogD)) {
        c.m(this.ogD);
      }
    }
    AppMethodBeat.o(113604);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.9
 * JD-Core Version:    0.7.0.1
 */