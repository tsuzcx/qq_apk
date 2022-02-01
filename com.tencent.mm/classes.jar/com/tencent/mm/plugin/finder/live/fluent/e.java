package com.tencent.mm.plugin.finder.live.fluent;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.view.LiveVideoView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchLiveDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/IFinderFluentSwitchDirector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "switchInLiveDirector", "Lcom/tencent/mm/plugin/finder/live/fluent/director/live/SwitchInLiveDirector;", "switchOutLiveDirector", "Lcom/tencent/mm/plugin/finder/live/fluent/director/live/SwitchOutLiveDirector;", "getOutSwitchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchLiveParams;", "isDetach", "", "saveOutParams", "", "switchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "setInParams", "Lcom/tencent/mm/plugin/finder/live/fluent/params/FinderFluentSwitchInParams;", "setOutParams", "stopSwitchOut", "switchIn", "onAnimationEndCallback", "Lkotlin/Function0;", "switchInLiveFinish", "switchInLiveRoom", "renderView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "onFirstFrameRenderCallback", "switchOut", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements k
{
  private final com.tencent.mm.plugin.finder.live.fluent.director.live.c CCo;
  public final com.tencent.mm.plugin.finder.live.fluent.director.live.a CCp;
  private final Context context;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(352087);
    this.context = paramContext;
    this.CCo = new com.tencent.mm.plugin.finder.live.fluent.director.live.c(this.context);
    this.CCp = new com.tencent.mm.plugin.finder.live.fluent.director.live.a(this.context);
    AppMethodBeat.o(352087);
  }
  
  public final void a(LiveVideoView paramLiveVideoView, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(352121);
    s.u(paramLiveVideoView, "renderView");
    s.u(parama, "onFirstFrameRenderCallback");
    this.CCo.a(paramLiveVideoView, parama);
    AppMethodBeat.o(352121);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(352096);
    s.u(paramh, "switchParams");
    this.CCo.a(paramh);
    this.CCp.b(paramh);
    AppMethodBeat.o(352096);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.fluent.params.a parama)
  {
    AppMethodBeat.i(352136);
    s.u(parama, "switchParams");
    this.CCp.a(parama);
    AppMethodBeat.o(352136);
  }
  
  public final boolean aFA()
  {
    return this.CCo.CCX;
  }
  
  public final void aX(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(352105);
    s.u(parama, "onAnimationEndCallback");
    this.CCo.aX(parama);
    AppMethodBeat.o(352105);
  }
  
  public final void aY(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(352144);
    s.u(parama, "onAnimationEndCallback");
    this.CCp.aY(parama);
    AppMethodBeat.o(352144);
  }
  
  public final void ejn()
  {
    AppMethodBeat.i(352111);
    this.CCo.ejn();
    AppMethodBeat.o(352111);
  }
  
  public final f ejq()
  {
    AppMethodBeat.i(352152);
    f localf = (f)this.CCo.ejN();
    AppMethodBeat.o(352152);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.e
 * JD-Core Version:    0.7.0.1
 */