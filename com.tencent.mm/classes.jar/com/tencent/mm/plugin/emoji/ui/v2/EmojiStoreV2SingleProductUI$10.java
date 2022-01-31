package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.zg;

final class EmojiStoreV2SingleProductUI$10
  implements a.a
{
  EmojiStoreV2SingleProductUI$10(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final void uk(int paramInt)
  {
    AppMethodBeat.i(53754);
    if ((EmojiStoreV2SingleProductUI.h(this.lrz) != null) && (EmojiStoreV2SingleProductUI.c(this.lrz) != null))
    {
      zg localzg = EmojiStoreV2SingleProductUI.c(this.lrz).uA(paramInt);
      if (localzg != null) {
        try
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("Select_Conv_User", EmojiStoreV2SingleProductUI.i(this.lrz));
          localIntent.putExtra("extra_object", localzg.toByteArray());
          localIntent.putExtra("scene", EmojiStoreV2SingleProductUI.j(this.lrz));
          localIntent.putExtra("searchID", EmojiStoreV2SingleProductUI.k(this.lrz));
          localIntent.putExtra("add_source", 5);
          localIntent.putExtra("entrance_scene", 29);
          localIntent.setClass(this.lrz.getContext(), EmojiStoreV2SingleProductDialogUI.class);
          this.lrz.startActivityForResult(localIntent, 5001);
          this.lrz.overridePendingTransition(2131034217, 2131034222);
          h.qsU.e(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductUI.j(this.lrz)), Integer.valueOf(0), localzg.Md5, Long.valueOf(EmojiStoreV2SingleProductUI.k(this.lrz)), localzg.wQg, localzg.ProductID, Integer.valueOf(29) });
          AppMethodBeat.o(53754);
          return;
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(53754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.10
 * JD-Core Version:    0.7.0.1
 */