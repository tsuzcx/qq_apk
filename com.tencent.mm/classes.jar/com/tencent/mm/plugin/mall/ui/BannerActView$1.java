package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import java.util.List;

final class BannerActView$1
  implements View.OnClickListener
{
  BannerActView$1(BannerActView paramBannerActView) {}
  
  public final void onClick(View paramView)
  {
    this.lYB.setVisibility(8);
    b.cU(BannerActView.a(this.lYB));
    if ((BannerActView.a(this.lYB) != null) && (BannerActView.a(this.lYB).size() > 0))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", ((a)BannerActView.a(this.lYB).get(0)).qzu);
      d.b(this.lYB.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.BannerActView.1
 * JD-Core Version:    0.7.0.1
 */