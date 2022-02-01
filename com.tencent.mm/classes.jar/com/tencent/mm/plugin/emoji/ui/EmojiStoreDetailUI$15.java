package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;

final class EmojiStoreDetailUI$15
  implements View.OnClickListener
{
  EmojiStoreDetailUI$15(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108993);
    ad.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + ac.eFu());
    paramView = this.oDQ.getString(2131758243) + ac.eFu();
    Intent localIntent = new Intent();
    localIntent.putExtra("title", this.oDQ.getString(2131758313));
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("neverGetA8Key", true);
    d.b(this.oDQ, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(108993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.15
 * JD-Core Version:    0.7.0.1
 */