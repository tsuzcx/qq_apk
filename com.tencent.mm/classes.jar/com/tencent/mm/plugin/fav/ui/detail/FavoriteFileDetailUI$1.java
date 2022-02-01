package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ao;

final class FavoriteFileDetailUI$1
  implements View.OnClickListener
{
  FavoriteFileDetailUI$1(FavoriteFileDetailUI paramFavoriteFileDetailUI, String paramString) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(107114);
    paramView = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_snsad_statextstr", FavoriteFileDetailUI.a(this.qQl).dvs);
    paramView.putExtra("jsapiargs", localBundle);
    paramView.putExtra("rawUrl", this.qQk);
    paramView.putExtra("useJs", true);
    new ao(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107113);
        d.b(FavoriteFileDetailUI.1.this.qQl, "webview", ".ui.tools.WebViewUI", paramView);
        FavoriteFileDetailUI.1.this.qQl.finish();
        AppMethodBeat.o(107113);
      }
    });
    AppMethodBeat.o(107114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.1
 * JD-Core Version:    0.7.0.1
 */