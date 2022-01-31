package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c.a.b;

final class d$9
  implements c.a.b
{
  d$9(g paramg, Context paramContext) {}
  
  public final void aSe()
  {
    xv localxv = b.c(this.jYv);
    if (localxv == null)
    {
      y.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
      return;
    }
    if ((localxv.sVG != null) && ((!bk.bl(localxv.sVG.dSP)) || (!bk.bl(localxv.sVG.dST))))
    {
      y.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
      localIntent = new Intent();
      localIntent.putExtra("key_detail_info_id", this.jYv.field_localId);
      localIntent.putExtra("key_detail_data_id", localxv.kgC);
      localIntent.putExtra("key_detail_can_delete", false);
      b.a(this.val$context, ".ui.detail.FavoriteFileDetailUI", localIntent);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", this.jYv.field_localId);
    localIntent.putExtra("key_detail_fav_path", b.b(localxv));
    localIntent.putExtra("key_detail_fav_thumb_path", b.c(localxv));
    localIntent.putExtra("key_detail_fav_video_duration", localxv.duration);
    localIntent.putExtra("key_detail_statExtStr", localxv.bYN);
    localIntent.putExtra("show_share", false);
    b.a(this.val$context, ".ui.detail.FavoriteVideoPlayUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d.9
 * JD-Core Version:    0.7.0.1
 */