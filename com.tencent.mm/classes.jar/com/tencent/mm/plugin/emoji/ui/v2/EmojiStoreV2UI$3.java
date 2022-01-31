package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;

final class EmojiStoreV2UI$3
  implements Runnable
{
  EmojiStoreV2UI$3(EmojiStoreV2UI paramEmojiStoreV2UI) {}
  
  public final void run()
  {
    AppMethodBeat.i(53818);
    Intent localIntent = aa.cZp();
    if (EmojiStoreV2UI.f(this.lsd) == 17)
    {
      i = 50;
      aa.a(localIntent, i);
      localIntent.putExtra("ftsneedkeyboard", true);
      localIntent.putExtra("key_load_js_without_delay", true);
      localIntent.putExtra("ftsInitToSearch", true);
      d.b(this.lsd.getContext(), "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", localIntent);
      if (EmojiStoreV2UI.b(this.lsd) != 0) {
        break label124;
      }
    }
    label124:
    for (int i = 0;; i = 1)
    {
      h.qsU.e(13054, new Object[] { Integer.valueOf(i), Integer.valueOf(0), "" });
      AppMethodBeat.o(53818);
      return;
      i = 24;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI.3
 * JD-Core Version:    0.7.0.1
 */