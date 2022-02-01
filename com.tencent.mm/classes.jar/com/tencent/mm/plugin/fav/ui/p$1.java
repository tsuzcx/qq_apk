package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;

final class p$1
  implements Runnable
{
  p$1(List paramList, p.a parama, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(107055);
    b.dk(this.qLL);
    if (this.qOR != null) {
      this.qOR.cqF();
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107053);
        p.1.this.qLa.dismiss();
        AppMethodBeat.o(107053);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(107054);
        String str = super.toString() + "|batchDelFavItems";
        AppMethodBeat.o(107054);
        return str;
      }
    });
    AppMethodBeat.o(107055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.p.1
 * JD-Core Version:    0.7.0.1
 */