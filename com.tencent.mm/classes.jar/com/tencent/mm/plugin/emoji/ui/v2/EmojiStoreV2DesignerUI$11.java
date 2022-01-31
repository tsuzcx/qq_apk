package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.zg;

final class EmojiStoreV2DesignerUI$11
  implements a.a
{
  EmojiStoreV2DesignerUI$11(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void uk(int paramInt)
  {
    AppMethodBeat.i(53589);
    if ((EmojiStoreV2DesignerUI.f(this.lpI) != null) && (EmojiStoreV2DesignerUI.g(this.lpI) != null))
    {
      zg localzg = EmojiStoreV2DesignerUI.g(this.lpI).uA(paramInt);
      if (localzg != null)
      {
        h.qsU.e(12787, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localzg.Md5, Long.valueOf(EmojiStoreV2DesignerUI.h(this.lpI)), localzg.wQg, localzg.ProductID, Integer.valueOf(6) });
        try
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("extra_object", localzg.toByteArray());
          localIntent.putExtra("add_source", 5);
          localIntent.putExtra("entrance_scene", 6);
          localIntent.setClass(this.lpI.getContext(), EmojiStoreV2SingleProductDialogUI.class);
          this.lpI.startActivityForResult(localIntent, 2004);
          this.lpI.overridePendingTransition(2131034217, 2131034222);
          AppMethodBeat.o(53589);
          return;
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(53589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.11
 * JD-Core Version:    0.7.0.1
 */