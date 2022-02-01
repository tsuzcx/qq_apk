package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

final class BindLinkedInUI$6
  implements View.OnClickListener
{
  BindLinkedInUI$6(BindLinkedInUI paramBindLinkedInUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109818);
    paramView = (String)g.agR().agA().get(286723, null);
    if (!bs.isNullOrNil(paramView))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView);
      localIntent.putExtra("geta8key_username", u.axw());
      d.b(this.iGq, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(109818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.6
 * JD-Core Version:    0.7.0.1
 */