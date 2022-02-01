package com.tencent.mm.plugin.finder.video;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "countdownContainer", "countdownText", "Landroid/widget/TextView;", "countdownTimer", "com/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1", "Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1;", "cancelCountdown", "", "setVisibility", "visibility", "", "startCountdown", "Companion", "plugin-finder_release"})
public final class w
  implements u
{
  public static final a APm;
  final ViewGroup APh;
  final TextView APi;
  final b APj;
  private final ViewGroup APk;
  private final d APl;
  
  static
  {
    AppMethodBeat.i(281448);
    APm = new a((byte)0);
    AppMethodBeat.o(281448);
  }
  
  public w(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(281447);
    this.APk = paramViewGroup;
    this.APl = paramd;
    paramViewGroup = this.APk.findViewById(b.f.countdown_container);
    p.j(paramViewGroup, "layout.findViewById(R.id.countdown_container)");
    this.APh = ((ViewGroup)paramViewGroup);
    paramViewGroup = this.APk.findViewById(b.f.countdown_text);
    p.j(paramViewGroup, "layout.findViewById(R.id.countdown_text)");
    this.APi = ((TextView)paramViewGroup);
    this.APj = new b(this);
    AppMethodBeat.o(281447);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(281449);
    String str = getClass().getName();
    AppMethodBeat.o(281449);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(281451);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(281451);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin$Companion;", "", "()V", "COUNTDOWN_DURATION", "", "COUNTDOWN_INTERVAL", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "plugin-finder_release"})
  public static final class b
    extends CountDownTimer
  {
    b()
    {
      super(1000L);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(285152);
      w.a(this.APn).setVisibility(8);
      d.b.a(w.b(this.APn), d.c.HRC);
      AppMethodBeat.o(285152);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(285154);
      w.c(this.APn).setText((CharSequence)String.valueOf(a.dm((float)paramLong / 1000.0F)));
      AppMethodBeat.o(285154);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.w
 * JD-Core Version:    0.7.0.1
 */