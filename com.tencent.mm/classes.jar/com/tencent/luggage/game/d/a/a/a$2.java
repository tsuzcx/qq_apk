package com.tencent.luggage.game.d.a.a;

import android.os.Looper;
import com.tencent.magicbrush.ui.MagicBrushView.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.a.j;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;
import java.util.Queue;

final class a$2
  extends MagicBrushView.d
{
  a$2(a parama) {}
  
  public final void aB(Object paramObject)
  {
    AppMethodBeat.i(162096);
    paramObject = this.ckh.En();
    if ((paramObject != null) && (paramObject.jwS != null))
    {
      paramObject.jwS.fP(true);
      Object localObject = paramObject.jwS.jKT;
      paramObject = new LinkedList(((d)localObject).jLh);
      ((d)localObject).jLh.clear();
      while (!paramObject.isEmpty())
      {
        localObject = (j)paramObject.poll();
        ap localap = ((j)localObject).mHandler;
        if (localap != null)
        {
          ((j)localObject).mHandler.removeCallbacks(((j)localObject).cAL);
          if (Looper.myLooper() == localap.getLooper()) {
            ((j)localObject).cAL.run();
          } else {
            ((j)localObject).aG(((j)localObject).result);
          }
        }
      }
    }
    AppMethodBeat.o(162096);
  }
  
  public final void b(Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(190402);
    paramObject = this.ckh.En();
    if ((paramObject != null) && (paramObject.jwS != null)) {
      paramObject.jwS.fP(false);
    }
    AppMethodBeat.o(190402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.2
 * JD-Core Version:    0.7.0.1
 */