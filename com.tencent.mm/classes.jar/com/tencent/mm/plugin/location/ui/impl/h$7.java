package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.j;

final class h$7
  implements View.OnClickListener
{
  h$7(h paramh, String paramString) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.lKp.activity, e.j.class);
    y.d("MicroMsg.TrackMapUI", "click url %s", new Object[] { this.lKr });
    paramView.putExtra("rawUrl", this.lKr);
    paramView.putExtra("showShare", false);
    d.e(this.lKp.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.7
 * JD-Core Version:    0.7.0.1
 */