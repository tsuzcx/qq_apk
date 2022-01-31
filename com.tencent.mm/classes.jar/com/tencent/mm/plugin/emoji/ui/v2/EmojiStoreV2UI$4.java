package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class EmojiStoreV2UI$4
  implements Runnable
{
  EmojiStoreV2UI$4(EmojiStoreV2UI paramEmojiStoreV2UI) {}
  
  public final void run()
  {
    Intent localIntent = aa.bZt();
    aa.ac(localIntent);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsInitToSearch", true);
    d.b(this.jjl.mController.uMN, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
    if (EmojiStoreV2UI.b(this.jjl) == 0) {}
    for (int i = 0;; i = 1)
    {
      h.nFQ.f(13054, new Object[] { Integer.valueOf(i), Integer.valueOf(0), "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI.4
 * JD-Core Version:    0.7.0.1
 */