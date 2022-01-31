package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;

final class CustomSmileyPreviewUI$5
  implements View.OnClickListener
{
  CustomSmileyPreviewUI$5(CustomSmileyPreviewUI paramCustomSmileyPreviewUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    if (bk.bl(this.eRY)) {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.eRY);
    d.b(this.jcf, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.5
 * JD-Core Version:    0.7.0.1
 */