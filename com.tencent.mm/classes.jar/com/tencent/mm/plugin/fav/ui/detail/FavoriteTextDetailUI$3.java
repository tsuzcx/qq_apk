package com.tencent.mm.plugin.fav.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.MenuItem;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class FavoriteTextDetailUI$3
  implements n.d
{
  FavoriteTextDetailUI$3(FavoriteTextDetailUI paramFavoriteTextDetailUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      return;
    } while ((FavoriteTextDetailUI.c(this.kgq) == null) || (FavoriteTextDetailUI.a(this.kgq) == null) || (FavoriteTextDetailUI.a(this.kgq).field_favProto == null));
    FavoriteTextDetailUI.c(this.kgq).setText(FavoriteTextDetailUI.a(this.kgq).field_favProto.desc);
    h.bC(this.kgq.mController.uMN, this.kgq.mController.uMN.getString(n.i.app_copy_ok));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.3
 * JD-Core Version:    0.7.0.1
 */