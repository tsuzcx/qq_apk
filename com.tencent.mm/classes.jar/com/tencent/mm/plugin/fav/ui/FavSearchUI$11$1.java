package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

final class FavSearchUI$11$1
  implements q.a
{
  FavSearchUI$11$1(FavSearchUI.11 param11, a.b paramb) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.kcS.kcM.XM();
    if (paramBoolean)
    {
      p localp = h.b(this.kcS.kcM.mController.uMN, this.kcS.kcM.getString(n.i.favorite_forward_tips), false, null);
      i.a(this.kcS.kcM.mController.uMN, FavSearchUI.j(this.kcS.kcM), paramString, this.kcR.jZN, new FavSearchUI.11.1.1(this, localp));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.11.1
 * JD-Core Version:    0.7.0.1
 */