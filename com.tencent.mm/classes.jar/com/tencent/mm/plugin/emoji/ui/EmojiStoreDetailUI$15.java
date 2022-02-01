package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

final class EmojiStoreDetailUI$15
  implements View.OnClickListener
{
  EmojiStoreDetailUI$15(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108993);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    Log.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + LocaleUtil.getApplicationLanguage());
    paramView = this.rix.getString(2131758531) + LocaleUtil.getApplicationLanguage();
    localObject = new Intent();
    ((Intent)localObject).putExtra("title", this.rix.getString(2131758607));
    ((Intent)localObject).putExtra("rawUrl", paramView);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("neverGetA8Key", true);
    c.b(this.rix, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", (Intent)localObject);
    a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiStoreDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(108993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.15
 * JD-Core Version:    0.7.0.1
 */