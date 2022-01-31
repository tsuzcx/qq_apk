package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;

final class BindLinkedInUI$6
  implements View.OnClickListener
{
  BindLinkedInUI$6(BindLinkedInUI paramBindLinkedInUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = (String)g.DP().Dz().get(286723, null);
    if (!bk.bl(paramView))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView);
      localIntent.putExtra("geta8key_username", q.Gj());
      d.b(this.fbn, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.6
 * JD-Core Version:    0.7.0.1
 */