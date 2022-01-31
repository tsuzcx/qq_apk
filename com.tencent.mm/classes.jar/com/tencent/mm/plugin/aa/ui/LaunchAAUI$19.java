package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class LaunchAAUI$19
  implements View.OnClickListener
{
  LaunchAAUI$19(LaunchAAUI paramLaunchAAUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40840);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.val$url);
    d.b(this.grm.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(40840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.19
 * JD-Core Version:    0.7.0.1
 */