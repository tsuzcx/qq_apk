package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.List;

final class f$d$4$3
  implements n.d
{
  f$d$4$3(f.d.4 param4, f.c paramc, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    String str = b.b(this.kia.khL.bNH);
    switch (paramMenuItem.getItemId())
    {
    case 3: 
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        return;
        paramMenuItem = new ArrayList();
        paramMenuItem.add(this.kia.khL);
        this.khZ.khY.khK.khF.bv(paramMenuItem);
        return;
        h.f(this.kia.khL.khA.field_localId, 0, 0);
        b.d(str, this.khZ.khY.khK.mContext);
        return;
        if (bk.bl(str))
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MediaHistoryGalleryAdapter", "save image fail, path is null");
          return;
        }
        if (this.kia.khM) {
          break;
        }
      } while (q.a(str, this.khZ.khY.khK.mContext, n.i.cropimage_saved));
      Toast.makeText(this.khZ.khY.khK.mContext, this.khZ.khY.khK.mContext.getString(n.i.favorite_save_fail), 1).show();
      return;
      paramMenuItem = u.of(str);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MediaHistoryGalleryAdapter", "save video now video path %s out path %s", new Object[] { str, paramMenuItem });
      if (bk.bl(paramMenuItem))
      {
        Toast.makeText(this.khZ.khY.khK.mContext, this.khZ.khY.khK.mContext.getString(n.i.video_file_save_failed), 1).show();
        return;
      }
      Toast.makeText(this.khZ.khY.khK.mContext, this.khZ.khY.khK.mContext.getString(n.i.video_file_saved, new Object[] { paramMenuItem }), 1).show();
      l.a(paramMenuItem, this.khZ.khY.khK.mContext);
      return;
    }
    this.khZ.khY.khK.khf.index = (this.khZ.khY.khK.getItemCount() - this.ffJ);
    ((com.tencent.mm.plugin.fav.a.y)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.fav.a.y.class)).a(this.khZ.khY.khK.mContext, this.kia.khL.khA, this.khZ.khY.khK.khf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d.4.3
 * JD-Core Version:    0.7.0.1
 */