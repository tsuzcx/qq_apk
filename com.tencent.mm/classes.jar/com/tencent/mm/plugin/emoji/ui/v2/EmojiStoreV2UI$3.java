package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aj;

final class EmojiStoreV2UI$3
  implements Runnable
{
  EmojiStoreV2UI$3(EmojiStoreV2UI paramEmojiStoreV2UI) {}
  
  public final void run()
  {
    AppMethodBeat.i(109390);
    Intent localIntent = aj.ipS();
    if (EmojiStoreV2UI.f(this.xYY) == 17)
    {
      i = 50;
      aj.f(localIntent, i);
      localIntent.putExtra("ftsneedkeyboard", true);
      localIntent.putExtra("key_load_js_without_delay", true);
      localIntent.putExtra("ftsInitToSearch", true);
      localIntent.putExtra("ftsNeedShowCamera", false);
      c.b(this.xYY.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
      if (EmojiStoreV2UI.b(this.xYY) != 0) {
        break label132;
      }
    }
    label132:
    for (int i = 0;; i = 1)
    {
      h.OAn.b(13054, new Object[] { Integer.valueOf(i), Integer.valueOf(0), "" });
      AppMethodBeat.o(109390);
      return;
      i = 24;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI.3
 * JD-Core Version:    0.7.0.1
 */