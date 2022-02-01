package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.Log;

final class FavoriteFileDetailUI$14
  implements View.OnClickListener
{
  FavoriteFileDetailUI$14(FavoriteFileDetailUI paramFavoriteFileDetailUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(107128);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(this.tie).field_id), Long.valueOf(FavoriteFileDetailUI.b(this.tie).field_localId) });
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.tii);
    paramView.putExtra("is_favorite_item", true);
    paramView.putExtra("fav_local_id", FavoriteFileDetailUI.b(this.tie).field_localId);
    paramView.putExtra("geta8key_scene", 14);
    paramView.putExtra("geta8key_scene", 14);
    c.b(this.tie.cWv(), "webview", ".ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(107128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.14
 * JD-Core Version:    0.7.0.1
 */