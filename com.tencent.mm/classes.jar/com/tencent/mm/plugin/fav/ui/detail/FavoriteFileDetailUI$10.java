package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.sdk.platformtools.ac;

final class FavoriteFileDetailUI$10
  implements View.OnClickListener
{
  FavoriteFileDetailUI$10(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(107125);
    m.a(m.a.qIU, FavoriteFileDetailUI.b(this.qQl));
    paramView = FavoriteFileDetailUI.a(this.qQl).EAf;
    String str = com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.a(this.qQl));
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramView.hjV);
    localIntent.putExtra("StreamWording", paramView.hjY);
    localIntent.putExtra("StremWebUrl", paramView.hjZ);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KThumUrl", paramView.hka);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(this.qQl).field_id);
    localIntent.putExtra("KMediaVideoTime", paramView.EBs);
    localIntent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(this.qQl).title);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramView.hkb);
    localIntent.putExtra("KSta_StremVideoPublishId", paramView.hkc);
    localIntent.putExtra("KSta_SourceType", 1);
    localIntent.putExtra("KSta_Scene", m.b.qJe.value);
    localIntent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(this.qQl).field_fromUser);
    localIntent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(this.qQl).field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(this.qQl).dvs);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMG, 0) > 0)
    {
      d.b(this.qQl, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ac.i("MicroMsg.FavoriteFileDetailUI", "use new stream video play UI");
      AppMethodBeat.o(107125);
      return;
    }
    d.b(this.qQl, "sns", ".ui.VideoAdPlayerUI", localIntent);
    AppMethodBeat.o(107125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.10
 * JD-Core Version:    0.7.0.1
 */