package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ak;

final class FavoriteFileDetailUI$1
  implements View.OnClickListener
{
  FavoriteFileDetailUI$1(FavoriteFileDetailUI paramFavoriteFileDetailUI, String paramString) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(74321);
    paramView = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_snsad_statextstr", FavoriteFileDetailUI.a(this.mAf).cGU);
    paramView.putExtra("jsapiargs", localBundle);
    paramView.putExtra("rawUrl", this.mAe);
    paramView.putExtra("useJs", true);
    new ak(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74320);
        d.b(FavoriteFileDetailUI.1.this.mAf, "webview", ".ui.tools.WebViewUI", paramView);
        FavoriteFileDetailUI.1.this.mAf.finish();
        AppMethodBeat.o(74320);
      }
    });
    AppMethodBeat.o(74321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.1
 * JD-Core Version:    0.7.0.1
 */