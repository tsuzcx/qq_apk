package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

final class EmojiStoreDetailUI$16
  implements View.OnClickListener
{
  EmojiStoreDetailUI$16(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + x.cqJ());
    paramView = this.jeK.getString(f.h.emoji_complaints_doc) + x.cqJ();
    Intent localIntent = new Intent();
    localIntent.putExtra("title", this.jeK.getString(f.h.emoji_store_complaints));
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("neverGetA8Key", true);
    d.b(this.jeK, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.16
 * JD-Core Version:    0.7.0.1
 */