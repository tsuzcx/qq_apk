package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class FreeWifiIntroductionUI$4
  implements View.OnClickListener
{
  FreeWifiIntroductionUI$4(FreeWifiIntroductionUI paramFreeWifiIntroductionUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21001);
    if (FreeWifiIntroductionUI.b(this.mNV) == 3) {}
    for (paramView = this.mNV.getString(2131301561);; paramView = this.mNV.getString(2131300178))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      d.b(this.mNV, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(21001);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.4
 * JD-Core Version:    0.7.0.1
 */