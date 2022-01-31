package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vfs.e;

final class FavoriteVideoPlayUI$2
  implements View.OnLongClickListener
{
  FavoriteVideoPlayUI$2(FavoriteVideoPlayUI paramFavoriteVideoPlayUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(74460);
    paramView.getTag();
    paramView = new l(this.mBr.getContext());
    paramView.sao = new FavoriteVideoPlayUI.2.1(this);
    paramView.sap = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(74459);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(74459);
          return;
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("Select_Conv_Type", 3);
          paramAnonymousMenuItem.putExtra("select_is_ret", true);
          paramAnonymousMenuItem.putExtra("mutil_select_is_ret", true);
          if (e.cN(FavoriteVideoPlayUI.b(FavoriteVideoPlayUI.2.this.mBr))) {
            paramAnonymousMenuItem.putExtra("image_path", FavoriteVideoPlayUI.b(FavoriteVideoPlayUI.2.this.mBr));
          }
          for (;;)
          {
            paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 1);
            d.b(FavoriteVideoPlayUI.2.this.mBr.getContext(), ".ui.transmit.SelectConversationUI", paramAnonymousMenuItem, 1);
            if (FavoriteVideoPlayUI.d(FavoriteVideoPlayUI.2.this.mBr) != 0) {
              break;
            }
            h.i(FavoriteVideoPlayUI.2.this.mBr.getIntent().getLongExtra("key_detail_info_id", 0L), 1, 0);
            AppMethodBeat.o(74459);
            return;
            paramAnonymousMenuItem.putExtra("image_path", FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.2.this.mBr));
          }
          FavoriteVideoPlayUI.f(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.2.this.mBr), FavoriteVideoPlayUI.2.this.mBr);
        }
      }
    };
    paramView.cwt();
    AppMethodBeat.o(74460);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.2
 * JD-Core Version:    0.7.0.1
 */