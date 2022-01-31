package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavSelectUI$4
  implements q.a
{
  FavSelectUI$4(FavSelectUI paramFavSelectUI, a.b paramb) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(74106);
    this.mxN.hideVKB();
    if (paramBoolean)
    {
      final p localp = h.b(this.mxN.getContext(), this.mxN.getString(2131299734), false, null);
      i.a(this.mxN.getContext(), FavSelectUI.b(this.mxN), paramString, this.mxC.muk, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74105);
          if (localp != null) {
            localp.dismiss();
          }
          b.l(FavSelectUI.4.this.mxN, FavSelectUI.4.this.mxN.getString(2131299674));
          al.p(new FavSelectUI.4.1.1(this), 1800L);
          AppMethodBeat.o(74105);
        }
      });
    }
    AppMethodBeat.o(74106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSelectUI.4
 * JD-Core Version:    0.7.0.1
 */