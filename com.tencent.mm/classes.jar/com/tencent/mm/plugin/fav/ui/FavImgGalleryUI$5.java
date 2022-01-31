package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

final class FavImgGalleryUI$5
  implements MMGestureGallery.c
{
  FavImgGalleryUI$5(FavImgGalleryUI paramFavImgGalleryUI) {}
  
  public final void bxv()
  {
    AppMethodBeat.i(74004);
    if ((!this.mwu.isFinishing()) && (!this.mwu.activityHasDestroyed()))
    {
      v.b localb = v.aae().z("basescanui@datacenter", true);
      localb.i("key_basescanui_screen_x", Integer.valueOf(FavImgGalleryUI.a(this.mwu).getXDown()));
      localb.i("key_basescanui_screen_y", Integer.valueOf(FavImgGalleryUI.a(this.mwu).getYDown()));
      FavImgGalleryUI.b(this.mwu);
    }
    AppMethodBeat.o(74004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.5
 * JD-Core Version:    0.7.0.1
 */