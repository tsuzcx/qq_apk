package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.sdk.platformtools.ab;

final class FavoriteFileDetailUI$10
  implements View.OnClickListener
{
  FavoriteFileDetailUI$10(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74332);
    m.a(m.a.mtA, FavoriteFileDetailUI.b(this.mAf));
    paramView = FavoriteFileDetailUI.a(this.mAf).wTC;
    String str = b.c(FavoriteFileDetailUI.a(this.mAf));
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramView.fiO);
    localIntent.putExtra("StreamWording", paramView.fiR);
    localIntent.putExtra("StremWebUrl", paramView.fiS);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KThumUrl", paramView.fiT);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(this.mAf).field_id);
    localIntent.putExtra("KMediaVideoTime", paramView.wUJ);
    localIntent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(this.mAf).title);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramView.fiU);
    localIntent.putExtra("KSta_StremVideoPublishId", paramView.fiV);
    localIntent.putExtra("KSta_SourceType", 1);
    localIntent.putExtra("KSta_Scene", m.b.mtK.value);
    localIntent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(this.mAf).field_fromUser);
    localIntent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(this.mAf).field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(this.mAf).cGU);
    if (((a)com.tencent.mm.kernel.g.E(a.class)).a(a.a.lRW, 0) > 0)
    {
      d.b(this.mAf, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ab.i("MicroMsg.FavoriteFileDetailUI", "use new stream video play UI");
      AppMethodBeat.o(74332);
      return;
    }
    d.b(this.mAf, "sns", ".ui.VideoAdPlayerUI", localIntent);
    AppMethodBeat.o(74332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.10
 * JD-Core Version:    0.7.0.1
 */