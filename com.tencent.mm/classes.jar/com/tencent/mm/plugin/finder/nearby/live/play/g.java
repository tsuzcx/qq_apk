package com.tencent.mm.plugin.finder.nearby.live.play;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/PlayAudioTipsViewAdapter;", "", "view", "Landroid/view/View;", "pos", "", "isLeftPos", "", "(Landroid/view/View;IZ)V", "audio_tips_cl", "kotlin.jvm.PlatformType", "getAudio_tips_cl", "()Landroid/view/View;", "left_audio_tips_cl", "getLeft_audio_tips_cl", "left_audio_tips_iv", "getLeft_audio_tips_iv", "left_audio_tips_tv", "getLeft_audio_tips_tv", "right_audio_tips_cl", "getRight_audio_tips_cl", "right_audio_tips_iv", "getRight_audio_tips_iv", "right_audio_tips_tv", "getRight_audio_tips_tv", "dismissAudioTips", "", "isShowTextTips", "showAudioTips", "Companion", "plugin-finder-nearby_release"})
public final class g
{
  public static final a zFW;
  final View zFP;
  final View zFQ;
  final View zFR;
  final View zFS;
  final View zFT;
  final View zFU;
  final View zFV;
  final boolean zFf;
  
  static
  {
    AppMethodBeat.i(203591);
    zFW = new a((byte)0);
    AppMethodBeat.o(203591);
  }
  
  public g(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(203590);
    this.zFf = paramBoolean;
    this.zFP = paramView.findViewById(b.f.audio_tips_cl);
    this.zFQ = paramView.findViewById(b.f.left_audio_tips_cl);
    this.zFR = paramView.findViewById(b.f.left_audio_tips_iv);
    this.zFS = paramView.findViewById(b.f.left_audio_tips_tv);
    this.zFT = paramView.findViewById(b.f.right_audio_tips_cl);
    this.zFU = paramView.findViewById(b.f.right_audio_tips_iv);
    this.zFV = paramView.findViewById(b.f.right_audio_tips_tv);
    AppMethodBeat.o(203590);
  }
  
  static boolean dLY()
  {
    AppMethodBeat.i(203588);
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.VBL, 10);
    localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBL, Integer.valueOf(i - 1));
    if (i >= 0)
    {
      AppMethodBeat.o(203588);
      return true;
    }
    AppMethodBeat.o(203588);
    return false;
  }
  
  public final void dLX()
  {
    AppMethodBeat.i(203585);
    View localView = this.zFP;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(203585);
      return;
    }
    AppMethodBeat.o(203585);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/PlayAudioTipsViewAdapter$Companion;", "", "()V", "AUDIO_TIPS_COUNT_DEFAULT", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.g
 * JD-Core Version:    0.7.0.1
 */