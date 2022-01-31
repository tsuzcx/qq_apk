package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class EmojiStoreV2SingleProductUI$10
  implements d.a
{
  EmojiStoreV2SingleProductUI$10(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final void pQ(int paramInt)
  {
    ut localut;
    if ((EmojiStoreV2SingleProductUI.h(this.jiI) != null) && (EmojiStoreV2SingleProductUI.c(this.jiI) != null))
    {
      localut = EmojiStoreV2SingleProductUI.c(this.jiI).qf(paramInt);
      if (localut == null) {}
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.i(this.jiI));
      localIntent.putExtra("extra_object", localut.toByteArray());
      localIntent.putExtra("scene", EmojiStoreV2SingleProductUI.j(this.jiI));
      localIntent.putExtra("searchID", EmojiStoreV2SingleProductUI.k(this.jiI));
      localIntent.putExtra("add_source", 5);
      localIntent.putExtra("entrance_scene", 29);
      localIntent.setClass(this.jiI.mController.uMN, EmojiStoreV2SingleProductDialogUI.class);
      this.jiI.startActivityForResult(localIntent, 5001);
      this.jiI.overridePendingTransition(f.a.pop_in, f.a.pop_out);
      h.nFQ.f(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductUI.j(this.jiI)), Integer.valueOf(0), localut.jnU, Long.valueOf(EmojiStoreV2SingleProductUI.k(this.jiI)), localut.sRs, localut.syc, Integer.valueOf(29) });
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.10
 * JD-Core Version:    0.7.0.1
 */