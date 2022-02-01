package com.tencent.mm.plugin.finder.nearby.live.play;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/PlayAudioTipsViewAdapter;", "", "view", "Landroid/view/View;", "pos", "", "isLeftPos", "", "(Landroid/view/View;IZ)V", "audio_tips_cl", "kotlin.jvm.PlatformType", "getAudio_tips_cl", "()Landroid/view/View;", "left_audio_tips_cl", "getLeft_audio_tips_cl", "left_audio_tips_iv", "getLeft_audio_tips_iv", "left_audio_tips_tv", "getLeft_audio_tips_tv", "right_audio_tips_cl", "getRight_audio_tips_cl", "right_audio_tips_iv", "getRight_audio_tips_iv", "right_audio_tips_tv", "getRight_audio_tips_tv", "dismissAudioTips", "", "isShowTextTips", "showAudioTips", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final a ELj;
  final boolean EKv;
  final View ELk;
  final View ELl;
  final View ELm;
  final View ELn;
  final View ELo;
  final View ELp;
  final View ELq;
  
  static
  {
    AppMethodBeat.i(340919);
    ELj = new a((byte)0);
    AppMethodBeat.o(340919);
  }
  
  public h(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(340900);
    this.EKv = paramBoolean;
    this.ELk = paramView.findViewById(e.e.audio_tips_cl);
    this.ELl = paramView.findViewById(e.e.left_audio_tips_cl);
    this.ELm = paramView.findViewById(e.e.left_audio_tips_iv);
    this.ELn = paramView.findViewById(e.e.left_audio_tips_tv);
    this.ELo = paramView.findViewById(e.e.right_audio_tips_cl);
    this.ELp = paramView.findViewById(e.e.right_audio_tips_iv);
    this.ELq = paramView.findViewById(e.e.right_audio_tips_tv);
    AppMethodBeat.o(340900);
  }
  
  static boolean eFo()
  {
    AppMethodBeat.i(340909);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adeh, 10);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adeh, Integer.valueOf(i - 1));
    if (i >= 0)
    {
      AppMethodBeat.o(340909);
      return true;
    }
    AppMethodBeat.o(340909);
    return false;
  }
  
  public final void eFn()
  {
    AppMethodBeat.i(340923);
    View localView = this.ELk;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(340923);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/PlayAudioTipsViewAdapter$Companion;", "", "()V", "AUDIO_TIPS_COUNT_DEFAULT", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.h
 * JD-Core Version:    0.7.0.1
 */