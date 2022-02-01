package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.c.c;
import com.tencent.mm.sticker.loader.h;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class CustomSmileyPreviewUI$16
  implements c
{
  CustomSmileyPreviewUI$16(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void a(int paramInt, final cqv paramcqv)
  {
    AppMethodBeat.i(108808);
    if (paramcqv == null) {}
    for (String str = "";; str = paramcqv.LensId)
    {
      Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onResult: %s", new Object[] { str });
      this.uIo.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108807);
          if (paramcqv != null)
          {
            CustomSmileyPreviewUI.h(CustomSmileyPreviewUI.16.this.uIo).setVisibility(0);
            h localh = h.VbF;
            h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(paramcqv)).c(CustomSmileyPreviewUI.i(CustomSmileyPreviewUI.16.this.uIo));
            CustomSmileyPreviewUI.j(CustomSmileyPreviewUI.16.this.uIo).setText(paramcqv.CMP);
            if (Util.isNullOrNil(paramcqv.TdN.CMP)) {
              break label160;
            }
            CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.16.this.uIo).setVisibility(0);
            CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.16.this.uIo).setText(paramcqv.TdN.CMP);
          }
          for (;;)
          {
            CustomSmileyPreviewUI.m(CustomSmileyPreviewUI.16.this.uIo).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(108806);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymous2View);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$9$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                com.tencent.mm.plugin.emojicapture.api.b.z(CustomSmileyPreviewUI.16.this.uIo, CustomSmileyPreviewUI.b(CustomSmileyPreviewUI.16.this.uIo).getMd5(), CustomSmileyPreviewUI.l(CustomSmileyPreviewUI.16.this.uIo));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$9$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(108806);
              }
            });
            AppMethodBeat.o(108807);
            return;
            label160:
            CustomSmileyPreviewUI.k(CustomSmileyPreviewUI.16.this.uIo).setVisibility(8);
          }
        }
      });
      AppMethodBeat.o(108808);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.16
 * JD-Core Version:    0.7.0.1
 */