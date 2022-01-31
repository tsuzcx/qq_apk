package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import java.util.List;

final class BannerActView$1
  implements View.OnClickListener
{
  BannerActView$1(BannerActView paramBannerActView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43127);
    this.oyg.setVisibility(8);
    b.dX(BannerActView.a(this.oyg));
    if ((BannerActView.a(this.oyg) != null) && (BannerActView.a(this.oyg).size() > 0))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", ((a)BannerActView.a(this.oyg).get(0)).ume);
      d.b(this.oyg.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(43127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.BannerActView.1
 * JD-Core Version:    0.7.0.1
 */