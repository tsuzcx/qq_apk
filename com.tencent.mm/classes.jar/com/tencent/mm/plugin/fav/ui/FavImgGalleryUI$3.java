package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

final class FavImgGalleryUI$3
  implements MMGestureGallery.c
{
  FavImgGalleryUI$3(FavImgGalleryUI paramFavImgGalleryUI) {}
  
  public final void aRg()
  {
    if ((!this.kbW.isFinishing()) && (!this.kbW.uMr))
    {
      u.b localb = u.Hc().v("basescanui@datacenter", true);
      localb.h("key_basescanui_screen_x", Integer.valueOf(FavImgGalleryUI.a(this.kbW).getXDown()));
      localb.h("key_basescanui_screen_y", Integer.valueOf(FavImgGalleryUI.a(this.kbW).getYDown()));
      FavImgGalleryUI.b(this.kbW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */