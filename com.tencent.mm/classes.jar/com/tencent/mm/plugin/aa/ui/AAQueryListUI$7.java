package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.br.d;

final class AAQueryListUI$7
  implements a.a
{
  AAQueryListUI$7(AAQueryListUI paramAAQueryListUI) {}
  
  public final void Vx()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", AAQueryListUI.m(this.eXG));
    d.b(this.eXG, "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.7
 * JD-Core Version:    0.7.0.1
 */