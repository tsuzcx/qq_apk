package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;

final class c$3
  implements g
{
  c$3(ha paramha) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(112295);
    this.nEe.cvX.vA = 2;
    this.nEe.cvX.url = paramString;
    a.ymk.l(this.nEe);
    if (paramb == null)
    {
      AppMethodBeat.o(112295);
      return;
    }
    int i = paramb.from;
    if ((paramb.status == 0) && (paramb.bitmap != null))
    {
      if (i == 2)
      {
        h.qsU.idkeyStat(858L, 13L, 1L, false);
        AppMethodBeat.o(112295);
      }
    }
    else if (i == 2) {
      h.qsU.idkeyStat(858L, 14L, 1L, false);
    }
    AppMethodBeat.o(112295);
  }
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.c.3
 * JD-Core Version:    0.7.0.1
 */