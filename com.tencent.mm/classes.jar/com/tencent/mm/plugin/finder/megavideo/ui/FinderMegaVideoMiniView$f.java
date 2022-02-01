package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView$addInternalVideoView$1", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView$MiniViewLifeCycle;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView;", "isFirstTimePlay", "", "()Z", "setFirstTimePlay", "(Z)V", "onPlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMegaVideoMiniView$f
  extends FinderMegaVideoMiniView.b
{
  private boolean Bub = true;
  
  FinderMegaVideoMiniView$f(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, int paramInt, float paramFloat, boolean paramBoolean, FinderMegaVideoMiniView paramFinderMegaVideoMiniView)
  {
    super(paramFinderMegaVideoMiniView);
  }
  
  public final void egu()
  {
    AppMethodBeat.i(341995);
    if (this.Bub)
    {
      d.uiThread((a)new a(this.EAA, this.EAB, this.Bud, this.EAC));
      this.Bub = false;
    }
    AppMethodBeat.o(341995);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, int paramInt, float paramFloat, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.FinderMegaVideoMiniView.f
 * JD-Core Version:    0.7.0.1
 */