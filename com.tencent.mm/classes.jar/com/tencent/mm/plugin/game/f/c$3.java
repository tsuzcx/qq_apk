package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;

final class c$3
  implements com.tencent.mm.av.a.c.h
{
  c$3(float paramFloat, ik paramik) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(42494);
    if ((paramb.bitmap != null) && (!paramb.bitmap.isRecycled()) && (this.uGR > 0.0F))
    {
      paramString = com.tencent.mm.sdk.platformtools.h.a(paramb.bitmap, true, paramb.bitmap.getWidth() * this.uGR);
      if (paramString != null)
      {
        AppMethodBeat.o(42494);
        return paramString;
      }
    }
    AppMethodBeat.o(42494);
    return null;
  }
  
  public final void b(String paramString, View paramView) {}
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(42495);
    this.uGQ.dvW.EN = 2;
    this.uGQ.dvW.url = paramString;
    a.IvT.l(this.uGQ);
    if (paramb == null)
    {
      AppMethodBeat.o(42495);
      return;
    }
    int i = paramb.from;
    if ((paramb.status == 0) && (paramb.bitmap != null))
    {
      if (i == 2)
      {
        g.yxI.idkeyStat(858L, 13L, 1L, false);
        AppMethodBeat.o(42495);
      }
    }
    else if (i == 2) {
      g.yxI.idkeyStat(858L, 14L, 1L, false);
    }
    AppMethodBeat.o(42495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.c.3
 * JD-Core Version:    0.7.0.1
 */