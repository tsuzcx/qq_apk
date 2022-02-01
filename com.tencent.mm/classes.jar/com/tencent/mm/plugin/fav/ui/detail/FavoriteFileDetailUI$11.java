package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.sdk.platformtools.Log;

final class FavoriteFileDetailUI$11
  implements View.OnClickListener
{
  FavoriteFileDetailUI$11(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(107125);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    m.a(m.a.taN, FavoriteFileDetailUI.b(this.tie));
    paramView = FavoriteFileDetailUI.a(this.tie).Lwn;
    localObject = com.tencent.mm.plugin.fav.a.b.a(FavoriteFileDetailUI.a(this.tie));
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramView.iyZ);
    localIntent.putExtra("StreamWording", paramView.izc);
    localIntent.putExtra("StremWebUrl", paramView.izd);
    localIntent.putExtra("KBlockFav", true);
    localIntent.putExtra("KThumUrl", paramView.ize);
    localIntent.putExtra("KThumbPath", (String)localObject);
    localIntent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(this.tie).field_id);
    localIntent.putExtra("KMediaVideoTime", paramView.LxJ);
    localIntent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(this.tie).title);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramView.izf);
    localIntent.putExtra("KSta_StremVideoPublishId", paramView.izg);
    localIntent.putExtra("KSta_SourceType", 1);
    localIntent.putExtra("KSta_Scene", m.b.taX.value);
    localIntent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(this.tie).field_fromUser);
    localIntent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(this.tie).field_id);
    localIntent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(this.tie).ean);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOS, 0) > 0)
    {
      c.b(this.tie, "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      Log.i("MicroMsg.FavoriteFileDetailUI", "use new stream video play UI");
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(107125);
      return;
      c.b(this.tie, "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.11
 * JD-Core Version:    0.7.0.1
 */