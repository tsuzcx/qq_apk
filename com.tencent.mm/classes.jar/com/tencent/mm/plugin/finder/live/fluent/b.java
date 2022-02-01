package com.tencent.mm.plugin.finder.live.fluent;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.view.LiveVideoView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchImageDirector;", "Lcom/tencent/mm/plugin/finder/live/fluent/IFinderFluentSwitchDirector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "switchInImageDirector", "Lcom/tencent/mm/plugin/finder/live/fluent/director/image/SwitchInImageDirector;", "switchOutImageDirector", "Lcom/tencent/mm/plugin/finder/live/fluent/director/image/SwitchOutImageDirector;", "getOutLivePlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "getOutSwitchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchImageParams;", "isDetach", "", "saveOutParams", "", "switchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "setInParams", "Lcom/tencent/mm/plugin/finder/live/fluent/params/FinderFluentSwitchInParams;", "setOutParams", "stopSwitchOut", "switchIn", "onAnimationEndCallback", "Lkotlin/Function0;", "switchInLiveFinish", "switchInLiveRoom", "renderView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "onFirstFrameRenderCallback", "switchOut", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements k
{
  public final com.tencent.mm.plugin.finder.live.fluent.director.image.b CCi;
  private final com.tencent.mm.plugin.finder.live.fluent.director.image.a CCj;
  private final Context context;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(352061);
    this.context = paramContext;
    this.CCi = new com.tencent.mm.plugin.finder.live.fluent.director.image.b(this.context);
    this.CCj = new com.tencent.mm.plugin.finder.live.fluent.director.image.a(this.context);
    AppMethodBeat.o(352061);
  }
  
  public final void a(LiveVideoView paramLiveVideoView, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(352089);
    s.u(paramLiveVideoView, "renderView");
    s.u(parama, "onFirstFrameRenderCallback");
    this.CCi.a(paramLiveVideoView, parama);
    AppMethodBeat.o(352089);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(352069);
    s.u(paramh, "switchParams");
    this.CCi.a(paramh);
    this.CCj.b(paramh);
    AppMethodBeat.o(352069);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.fluent.params.a parama)
  {
    AppMethodBeat.i(352102);
    s.u(parama, "switchParams");
    this.CCj.a(parama);
    AppMethodBeat.o(352102);
  }
  
  public final boolean aFA()
  {
    return this.CCi.CCX;
  }
  
  public final void aX(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(352075);
    s.u(parama, "onAnimationEndCallback");
    this.CCi.aX(parama);
    AppMethodBeat.o(352075);
  }
  
  public final void aY(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(352109);
    s.u(parama, "onAnimationEndCallback");
    this.CCj.aY(parama);
    AppMethodBeat.o(352109);
  }
  
  public final void ejn()
  {
    AppMethodBeat.i(352083);
    this.CCi.ejn();
    AppMethodBeat.o(352083);
  }
  
  public final c ejo()
  {
    AppMethodBeat.i(352120);
    c localc = (c)this.CCi.ejN();
    AppMethodBeat.o(352120);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.b
 * JD-Core Version:    0.7.0.1
 */