package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;

final class f$d$4$2
  implements View.OnCreateContextMenuListener
{
  f$d$4$2(f.d.4 param4, f.c paramc) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = b.b(this.kia.khL.bNH);
    boolean bool1 = e.bK(paramView);
    boolean bool2 = o.Za(paramView);
    if ((!this.kia.khM) && (bool1) && (!bool2))
    {
      paramContextMenu.add(0, 0, 0, this.khZ.khY.khK.mContext.getString(n.i.favorite_share_with_friend));
      paramContextMenu.add(0, 1, 0, this.khZ.khY.khK.mContext.getString(n.i.favorite_post_to_sns));
      paramContextMenu.add(0, 2, 0, this.khZ.khY.khK.mContext.getString(n.i.favorite_save_image));
    }
    for (;;)
    {
      paramContextMenu.add(0, 4, 0, this.khZ.khY.khK.mContext.getString(n.i.favorite_go_detail));
      return;
      if ((this.kia.khM) && (bool1) && (!bool2))
      {
        paramContextMenu.add(0, 0, 0, this.khZ.khY.khK.mContext.getString(n.i.favorite_share_with_friend));
        paramContextMenu.add(0, 2, 0, this.khZ.khY.khK.mContext.getString(n.i.save_video_to_local));
      }
      else
      {
        y.d("MicroMsg.MediaHistoryGalleryAdapter", "openPopupMenu, isVideo:%s, exist:%s, isGif:%s", new Object[] { Boolean.valueOf(this.kia.khM), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d.4.2
 * JD-Core Version:    0.7.0.1
 */