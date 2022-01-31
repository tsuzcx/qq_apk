package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class FavSearchUI$11$1
  implements q.a
{
  FavSearchUI$11$1(FavSearchUI.11 param11, a.b paramb) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(74081);
    this.mxD.mxx.hideVKB();
    if (paramBoolean)
    {
      p localp = h.b(this.mxD.mxx.getContext(), this.mxD.mxx.getString(2131299734), false, null);
      i.a(this.mxD.mxx.getContext(), FavSearchUI.j(this.mxD.mxx), paramString, this.mxC.muk, new FavSearchUI.11.1.1(this, localp));
    }
    AppMethodBeat.o(74081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.11.1
 * JD-Core Version:    0.7.0.1
 */