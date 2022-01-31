package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class EmojiStoreV2DesignerUI$11
  implements d.a
{
  EmojiStoreV2DesignerUI$11(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void pQ(int paramInt)
  {
    ut localut;
    if ((EmojiStoreV2DesignerUI.f(this.jgP) != null) && (EmojiStoreV2DesignerUI.g(this.jgP) != null))
    {
      localut = EmojiStoreV2DesignerUI.g(this.jgP).qf(paramInt);
      if (localut != null) {
        h.nFQ.f(12787, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localut.jnU, Long.valueOf(EmojiStoreV2DesignerUI.h(this.jgP)), localut.sRs, localut.syc, Integer.valueOf(6) });
      }
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_object", localut.toByteArray());
      localIntent.putExtra("add_source", 5);
      localIntent.putExtra("entrance_scene", 6);
      localIntent.setClass(this.jgP.mController.uMN, EmojiStoreV2SingleProductDialogUI.class);
      this.jgP.startActivity(localIntent);
      this.jgP.overridePendingTransition(f.a.pop_in, f.a.pop_out);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.11
 * JD-Core Version:    0.7.0.1
 */