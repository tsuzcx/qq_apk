package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class CustomSmileyPreviewUI$13
  implements View.OnClickListener
{
  CustomSmileyPreviewUI$13(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108802);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "emoji is hevc %s", new Object[] { Boolean.valueOf(CustomSmileyPreviewUI.f(this.xRd).isHevc) });
    a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(108802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.13
 * JD-Core Version:    0.7.0.1
 */