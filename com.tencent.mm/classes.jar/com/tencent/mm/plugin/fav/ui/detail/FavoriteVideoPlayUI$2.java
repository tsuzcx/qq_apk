package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.vfs.e;

final class FavoriteVideoPlayUI$2
  implements View.OnLongClickListener
{
  FavoriteVideoPlayUI$2(FavoriteVideoPlayUI paramFavoriteVideoPlayUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    paramView.getTag();
    paramView = new j(this.kgD.mController.uMN);
    paramView.phH = new FavoriteVideoPlayUI.2.1(this);
    paramView.phI = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          return;
        case 1: 
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
          paramAnonymousMenuItem.putExtra("select_is_ret", true);
          paramAnonymousMenuItem.putExtra("mutil_select_is_ret", true);
          if (e.bK(FavoriteVideoPlayUI.b(FavoriteVideoPlayUI.2.this.kgD))) {
            paramAnonymousMenuItem.putExtra("image_path", FavoriteVideoPlayUI.b(FavoriteVideoPlayUI.2.this.kgD));
          }
          for (;;)
          {
            paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 1);
            d.c(FavoriteVideoPlayUI.2.this.kgD.mController.uMN, ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
            if (FavoriteVideoPlayUI.d(FavoriteVideoPlayUI.2.this.kgD) != 0) {
              break;
            }
            h.f(FavoriteVideoPlayUI.2.this.kgD.getIntent().getLongExtra("key_detail_info_id", 0L), 1, 0);
            return;
            paramAnonymousMenuItem.putExtra("image_path", FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.2.this.kgD));
          }
        }
        FavoriteVideoPlayUI.f(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.2.this.kgD), FavoriteVideoPlayUI.2.this.kgD);
      }
    };
    paramView.bJQ();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.2
 * JD-Core Version:    0.7.0.1
 */