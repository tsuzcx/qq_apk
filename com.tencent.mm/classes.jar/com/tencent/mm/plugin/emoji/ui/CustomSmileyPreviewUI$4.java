package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.Log;

final class CustomSmileyPreviewUI$4
  implements View.OnClickListener
{
  CustomSmileyPreviewUI$4(CustomSmileyPreviewUI paramCustomSmileyPreviewUI, long paramLong, akd paramakd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(256415);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onClick: %s, %s, %s", new Object[] { Long.valueOf(this.uIr), this.uIs.SuT, Integer.valueOf(this.uIs.vhF) });
    CustomSmileyPreviewUI.w(this.uIo);
    paramView = new Intent();
    paramView.putExtra("feed_object_id", this.uIr);
    paramView.putExtra("feed_object_nonceId", this.uIs.SuT);
    paramView.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", this.uIs.vhF * 1000L);
    paramView.putExtra("KEY_VIDEO_SEEK_MODE", 2);
    ((ak)h.ag(ak.class)).enterFinderShareFeedUI(this.uIo, paramView);
    a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(256415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.4
 * JD-Core Version:    0.7.0.1
 */