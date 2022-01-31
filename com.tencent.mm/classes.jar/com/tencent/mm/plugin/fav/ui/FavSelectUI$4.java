package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavSelectUI$4
  implements q.a
{
  FavSelectUI$4(FavSelectUI paramFavSelectUI, a.b paramb) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.kdd.XM();
    if (paramBoolean)
    {
      final p localp = h.b(this.kdd.mController.uMN, this.kdd.getString(n.i.favorite_forward_tips), false, null);
      i.a(this.kdd.mController.uMN, FavSelectUI.b(this.kdd), paramString, this.kcR.jZN, new Runnable()
      {
        public final void run()
        {
          if (localp != null) {
            localp.dismiss();
          }
          b.h(FavSelectUI.4.this.kdd, FavSelectUI.4.this.kdd.getString(n.i.fav_finish_sent));
          ai.l(new FavSelectUI.4.1.1(this), 1800L);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSelectUI.4
 * JD-Core Version:    0.7.0.1
 */