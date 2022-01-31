package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class FavoriteFileDetailUI$10
  implements View.OnClickListener
{
  FavoriteFileDetailUI$10(FavoriteFileDetailUI paramFavoriteFileDetailUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(this.kfu).field_id), Long.valueOf(FavoriteFileDetailUI.b(this.kfu).field_localId) });
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.kfx);
    paramView.putExtra("is_favorite_item", true);
    paramView.putExtra("fav_local_id", FavoriteFileDetailUI.b(this.kfu).field_localId);
    paramView.putExtra("geta8key_scene", 14);
    paramView.putExtra("geta8key_scene", 14);
    d.b(this.kfu.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.10
 * JD-Core Version:    0.7.0.1
 */