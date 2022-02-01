package com.tencent.mm.plugin.finder.video;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "countdownContainer", "countdownText", "Landroid/widget/TextView;", "countdownTimer", "com/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1", "Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1;", "cancelCountdown", "", "setVisibility", "visibility", "", "startCountdown", "Companion", "plugin-finder_release"})
public final class v
  implements t
{
  public static final v.a wgs;
  final ViewGroup wgn;
  final TextView wgo;
  final b wgp;
  private final ViewGroup wgq;
  private final d wgr;
  
  static
  {
    AppMethodBeat.i(254409);
    wgs = new v.a((byte)0);
    AppMethodBeat.o(254409);
  }
  
  public v(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(254408);
    this.wgq = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.wgq.findViewById(2131299260);
    p.g(paramViewGroup, "layout.findViewById(R.id.countdown_container)");
    this.wgn = ((ViewGroup)paramViewGroup);
    paramViewGroup = this.wgq.findViewById(2131299265);
    p.g(paramViewGroup, "layout.findViewById(R.id.countdown_text)");
    this.wgo = ((TextView)paramViewGroup);
    this.wgp = new b(this);
    AppMethodBeat.o(254408);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
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
    AppMethodBeat.i(254410);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(254410);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "plugin-finder_release"})
  public static final class b
    extends CountDownTimer
  {
    b(long paramLong)
    {
      super(1000L);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(254406);
      v.a(this.wgt).setVisibility(8);
      d.b.a(v.b(this.wgt), d.c.BUP);
      AppMethodBeat.o(254406);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(254407);
      v.c(this.wgt).setText((CharSequence)String.valueOf(a.cR((float)paramLong / 1000.0F)));
      AppMethodBeat.o(254407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.v
 * JD-Core Version:    0.7.0.1
 */