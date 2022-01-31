package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class PoiHeaderView$1
  implements View.OnClickListener
{
  PoiHeaderView$1(PoiHeaderView paramPoiHeaderView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113468);
    Intent localIntent = new Intent();
    if (bo.isNullOrNil(PoiHeaderView.a(this.ocJ))) {}
    for (paramView = PoiHeaderView.b(this.ocJ);; paramView = PoiHeaderView.a(this.ocJ))
    {
      ab.d("MicroMsg.PoiHeaderView", "click url %s", new Object[] { paramView });
      localIntent.putExtra("rawUrl", paramView);
      localIntent.putExtra("showShare", false);
      d.f(this.ocJ.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(113468);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.PoiHeaderView.1
 * JD-Core Version:    0.7.0.1
 */