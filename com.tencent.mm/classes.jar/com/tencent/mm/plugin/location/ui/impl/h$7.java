package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.e.l;

final class h$7
  implements View.OnClickListener
{
  h$7(h paramh, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(113700);
    paramView = new Intent();
    paramView.setClass(this.ohE.activity, e.l.class);
    ab.d("MicroMsg.TrackMapUI", "click url %s", new Object[] { this.ohG });
    paramView.putExtra("rawUrl", this.ohG);
    paramView.putExtra("showShare", false);
    d.f(this.ohE.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(113700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.7
 * JD-Core Version:    0.7.0.1
 */