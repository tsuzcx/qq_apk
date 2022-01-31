package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class PoiHeaderView$1
  implements View.OnClickListener
{
  PoiHeaderView$1(PoiHeaderView paramPoiHeaderView) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    if (bk.bl(PoiHeaderView.a(this.lFw))) {}
    for (paramView = PoiHeaderView.b(this.lFw);; paramView = PoiHeaderView.a(this.lFw))
    {
      y.d("MicroMsg.PoiHeaderView", "click url %s", new Object[] { paramView });
      localIntent.putExtra("rawUrl", paramView);
      localIntent.putExtra("showShare", false);
      d.e(this.lFw.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiHeaderView.1
 * JD-Core Version:    0.7.0.1
 */