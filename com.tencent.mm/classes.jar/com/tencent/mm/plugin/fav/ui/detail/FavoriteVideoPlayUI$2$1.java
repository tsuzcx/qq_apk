package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.vfs.e;

final class FavoriteVideoPlayUI$2$1
  implements n.c
{
  FavoriteVideoPlayUI$2$1(FavoriteVideoPlayUI.2 param2) {}
  
  public final void a(l paraml)
  {
    if (FavoriteVideoPlayUI.a(this.kgE.kgD))
    {
      if (e.bK(FavoriteVideoPlayUI.b(this.kgE.kgD))) {
        paraml.add(0, 1, 0, this.kgE.kgD.getString(n.i.favorite_share_with_friend));
      }
      paraml.add(0, 2, 0, this.kgE.kgD.getString(n.i.save_video_to_local));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.2.1
 * JD-Core Version:    0.7.0.1
 */