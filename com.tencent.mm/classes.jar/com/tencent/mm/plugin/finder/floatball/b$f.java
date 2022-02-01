package com.tencent.mm.plugin.finder.floatball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/floatball/FinderVideoPassiveMiniViewHelper$initVideoView$1", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView$SimpleVideoPlayLifecycle;", "isFirstTimePlay", "", "()Z", "setFirstTimePlay", "(Z)V", "onPlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$f
  extends FinderMegaVideoMiniView.d
{
  private boolean Bub = true;
  
  b$f(b paramb, long paramLong, float paramFloat) {}
  
  public final void egu()
  {
    AppMethodBeat.i(330249);
    if (this.Bub)
    {
      d.uiThread((a)new a(this.BtX, this.Buc, this.Bud));
      this.Bub = false;
    }
    AppMethodBeat.o(330249);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(b paramb, long paramLong, float paramFloat)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.floatball.b.f
 * JD-Core Version:    0.7.0.1
 */