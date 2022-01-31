package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;

final class EmojiStoreDetailUI$16
  implements View.OnClickListener
{
  EmojiStoreDetailUI$16(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(53433);
    ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + aa.dsG());
    paramView = this.lnA.getString(2131299127) + aa.dsG();
    Intent localIntent = new Intent();
    localIntent.putExtra("title", this.lnA.getString(2131299187));
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("neverGetA8Key", true);
    d.b(this.lnA, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(53433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.16
 * JD-Core Version:    0.7.0.1
 */