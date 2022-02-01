package com.tencent.mm.plugin.finder.video;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "countdownContainer", "countdownText", "Landroid/widget/TextView;", "countdownTimer", "com/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1", "Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1;", "cancelCountdown", "", "setVisibility", "visibility", "", "startCountdown", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  implements v
{
  public static final y.a GrA;
  private final ViewGroup GrB;
  private final com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  final ViewGroup GrD;
  final TextView GrE;
  final b GrF;
  
  static
  {
    AppMethodBeat.i(335311);
    GrA = new y.a((byte)0);
    AppMethodBeat.o(335311);
  }
  
  public y(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(335286);
    this.GrB = paramViewGroup;
    this.GrC = parama;
    paramViewGroup = this.GrB.findViewById(l.e.countdown_container);
    s.s(paramViewGroup, "layout.findViewById(R.id.countdown_container)");
    this.GrD = ((ViewGroup)paramViewGroup);
    paramViewGroup = this.GrB.findViewById(l.e.countdown_text);
    s.s(paramViewGroup, "layout.findViewById(R.id.countdown_text)");
    this.GrE = ((TextView)paramViewGroup);
    this.GrF = new b(this);
    AppMethodBeat.o(335286);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(335320);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(335320);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(335337);
    s.u(this, "this");
    AppMethodBeat.o(335337);
  }
  
  public final String name()
  {
    AppMethodBeat.i(335327);
    String str = v.a.b(this);
    AppMethodBeat.o(335327);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(335332);
    s.u(this, "this");
    AppMethodBeat.o(335332);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(335343);
    s.u(this, "this");
    AppMethodBeat.o(335343);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(335349);
    s.u(this, "this");
    AppMethodBeat.o(335349);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(335360);
    s.u(this, "this");
    AppMethodBeat.o(335360);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(335366);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(335366);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(335374);
    s.u(this, "this");
    AppMethodBeat.o(335374);
  }
  
  public final void release()
  {
    AppMethodBeat.i(335379);
    s.u(this, "this");
    AppMethodBeat.o(335379);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(335383);
    s.u(this, "this");
    AppMethodBeat.o(335383);
  }
  
  public final void setVisibility(int paramInt) {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/RecordCountdownPlugin$countdownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends CountDownTimer
  {
    b(y paramy)
    {
      super(1000L);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(334663);
      y.a(this.GrG).setVisibility(8);
      a.b.a(y.b(this.GrG), a.c.NOi);
      AppMethodBeat.o(334663);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(334674);
      y.c(this.GrG).setText((CharSequence)String.valueOf(kotlin.h.a.eH((float)paramLong / 1000.0F)));
      AppMethodBeat.o(334674);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.y
 * JD-Core Version:    0.7.0.1
 */