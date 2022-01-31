package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xy;

final class FavoriteFileDetailUI$7
  implements View.OnClickListener
{
  FavoriteFileDetailUI$7(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    m.a(m.a.jZi, FavoriteFileDetailUI.b(this.kfu));
    paramView = FavoriteFileDetailUI.a(this.kfu).sVG;
    String str = b.c(FavoriteFileDetailUI.a(this.kfu));
    Intent localIntent = new Intent();
    localIntent.putExtra("IsAd", false);
    localIntent.putExtra("KStremVideoUrl", paramView.dSP);
    localIntent.putExtra("StreamWording", paramView.dSS);
    localIntent.putExtra("StremWebUrl", paramView.dST);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KThumUrl", paramView.dSU);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(this.kfu).field_id);
    localIntent.putExtra("KMediaVideoTime", paramView.sWK);
    localIntent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(this.kfu).title);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramView.dSV);
    localIntent.putExtra("KSta_StremVideoPublishId", paramView.dSW);
    localIntent.putExtra("KSta_SourceType", 1);
    localIntent.putExtra("KSta_Scene", m.b.jZs.value);
    localIntent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(this.kfu).field_fromUser);
    localIntent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(this.kfu).field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(this.kfu).bYN);
    d.b(this.kfu, "sns", ".ui.VideoAdPlayerUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.7
 * JD-Core Version:    0.7.0.1
 */