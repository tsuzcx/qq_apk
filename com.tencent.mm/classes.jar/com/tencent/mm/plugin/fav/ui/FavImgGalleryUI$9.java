package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.e;

final class FavImgGalleryUI$9
  implements n.d
{
  FavImgGalleryUI$9(FavImgGalleryUI paramFavImgGalleryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(74008);
    Object localObject = FavImgGalleryUI.f(this.mwu).vX(FavImgGalleryUI.e(this.mwu));
    if (localObject == null)
    {
      AppMethodBeat.o(74008);
      return;
    }
    localObject = b.b(((f)localObject).cuL);
    if (!e.cN((String)localObject))
    {
      ab.w("MicroMsg.FavImgGalleryUI", "file not exists");
      AppMethodBeat.o(74008);
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74008);
      return;
      h.i(FavImgGalleryUI.g(this.mwu), 1, 0);
      if (r.aoY((String)localObject))
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Select_Conv_Type", 3);
        paramMenuItem.putExtra("select_is_ret", true);
        d.b(this.mwu, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
        AppMethodBeat.o(74008);
        return;
      }
      b.c((String)localObject, this.mwu);
      AppMethodBeat.o(74008);
      return;
      b.d((String)localObject, this.mwu);
      h.i(FavImgGalleryUI.g(this.mwu), 0, 0);
      AppMethodBeat.o(74008);
      return;
      FavImgGalleryUI.a((String)localObject, this.mwu.getString(2131299818), this.mwu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.9
 * JD-Core Version:    0.7.0.1
 */