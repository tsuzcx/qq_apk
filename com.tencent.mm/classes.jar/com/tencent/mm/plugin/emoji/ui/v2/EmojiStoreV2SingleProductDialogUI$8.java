package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class EmojiStoreV2SingleProductDialogUI$8
  implements Runnable
{
  EmojiStoreV2SingleProductDialogUI$8(EmojiStoreV2SingleProductDialogUI paramEmojiStoreV2SingleProductDialogUI) {}
  
  public final void run()
  {
    EmojiStoreV2SingleProductDialogUI.g(this.jif).setVisibility(8);
    EmojiStoreV2SingleProductDialogUI.h(this.jif).setVisibility(0);
    EmojiStoreV2SingleProductDialogUI.a(this.jif, i.getEmojiStorageMgr().uBb.acC(EmojiStoreV2SingleProductDialogUI.a(this.jif).jnU));
    if ((EmojiStoreV2SingleProductDialogUI.i(this.jif) != null) && ((EmojiStoreV2SingleProductDialogUI.i(this.jif).field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo)) {
      EmojiStoreV2SingleProductDialogUI.h(this.jif).h(((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(EmojiStoreV2SingleProductDialogUI.i(this.jif)), "");
    }
    for (;;)
    {
      EmojiStoreV2SingleProductDialogUI.k(this.jif);
      EmojiStoreV2SingleProductDialogUI.l(this.jif).setEnabled(true);
      EmojiStoreV2SingleProductDialogUI.l(this.jif).setTextColor(this.jif.getResources().getColor(f.b.green_text_color));
      return;
      EmojiStoreV2SingleProductDialogUI.h(this.jif).setImageFilePath(EmojiStoreV2SingleProductDialogUI.j(this.jif));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.8
 * JD-Core Version:    0.7.0.1
 */