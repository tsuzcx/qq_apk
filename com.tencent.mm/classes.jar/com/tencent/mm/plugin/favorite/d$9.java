package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.c.a.b;

final class d$9
  implements c.a.b
{
  d$9(g paramg, Context paramContext) {}
  
  public final void byw()
  {
    AppMethodBeat.i(20507);
    aca localaca = b.c(this.msP);
    if (localaca == null)
    {
      ab.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
      AppMethodBeat.o(20507);
      return;
    }
    if ((localaca.wTC != null) && ((!bo.isNullOrNil(localaca.wTC.fiO)) || (!bo.isNullOrNil(localaca.wTC.fiS))))
    {
      ab.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
      localIntent = new Intent();
      localIntent.putExtra("key_detail_info_id", this.msP.field_localId);
      localIntent.putExtra("key_detail_data_id", localaca.mBq);
      localIntent.putExtra("key_detail_can_delete", false);
      b.b(this.val$context, ".ui.detail.FavoriteFileDetailUI", localIntent);
      AppMethodBeat.o(20507);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", this.msP.field_localId);
    localIntent.putExtra("key_detail_fav_path", b.b(localaca));
    localIntent.putExtra("key_detail_fav_thumb_path", b.c(localaca));
    localIntent.putExtra("key_detail_fav_video_duration", localaca.duration);
    localIntent.putExtra("key_detail_statExtStr", localaca.cGU);
    localIntent.putExtra("show_share", false);
    b.b(this.val$context, ".ui.detail.FavoriteVideoPlayUI", localIntent);
    AppMethodBeat.o(20507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.d.9
 * JD-Core Version:    0.7.0.1
 */