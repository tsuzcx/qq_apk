package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.e.m;

final class j$9
  implements View.OnClickListener
{
  j$9(j paramj, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(56154);
    paramView = new Intent();
    paramView.setClass(this.sWY.activity, e.m.class);
    ad.d("MicroMsg.TrackMapUI", "click url %s", new Object[] { this.sXa });
    paramView.putExtra("rawUrl", this.sXa);
    paramView.putExtra("showShare", false);
    d.e(this.sWY.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(56154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.9
 * JD-Core Version:    0.7.0.1
 */