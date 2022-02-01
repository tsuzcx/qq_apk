package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class FavoriteFileDetailUI$1
  implements View.OnClickListener
{
  FavoriteFileDetailUI$1(FavoriteFileDetailUI paramFavoriteFileDetailUI, String paramString) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(107114);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = new Intent();
    localObject = new Bundle();
    ((Bundle)localObject).putString("key_snsad_statextstr", FavoriteFileDetailUI.a(this.tie).ean);
    paramView.putExtra("jsapiargs", (Bundle)localObject);
    paramView.putExtra("rawUrl", this.tic);
    paramView.putExtra("useJs", true);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107113);
        c.b(FavoriteFileDetailUI.1.this.tie, "webview", ".ui.tools.WebViewUI", paramView);
        FavoriteFileDetailUI.1.this.tie.finish();
        AppMethodBeat.o(107113);
      }
    });
    a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteFileDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(107114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.1
 * JD-Core Version:    0.7.0.1
 */