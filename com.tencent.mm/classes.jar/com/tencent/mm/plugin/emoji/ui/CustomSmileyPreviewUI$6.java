package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.sdk.platformtools.Log;

final class CustomSmileyPreviewUI$6
  implements View.OnClickListener
{
  CustomSmileyPreviewUI$6(CustomSmileyPreviewUI paramCustomSmileyPreviewUI, long paramLong, ank paramank) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(270357);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.emoji.CustomSmileyPreviewUI", "onClick: %s, %s, %s", new Object[] { Long.valueOf(this.xRf), this.xRg.ZuM, Integer.valueOf(this.xRg.crm) });
    CustomSmileyPreviewUI.z(this.xRd);
    paramView = new Intent();
    paramView.putExtra("feed_object_id", this.xRf);
    paramView.putExtra("feed_object_nonceId", this.xRg.ZuM);
    paramView.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", this.xRg.crm * 1000L);
    paramView.putExtra("KEY_VIDEO_SEEK_MODE", 2);
    ((cn)h.az(cn.class)).enterFinderShareFeedUI(this.xRd, paramView);
    a.a(this, "com/tencent/mm/plugin/emoji/ui/CustomSmileyPreviewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(270357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.6
 * JD-Core Version:    0.7.0.1
 */