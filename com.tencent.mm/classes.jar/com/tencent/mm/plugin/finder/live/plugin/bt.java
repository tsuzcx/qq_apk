package com.tencent.mm.plugin.finder.live.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.a;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.live.widget.f;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExceptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "exceptionWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "initWidget", "", "anchorUserName", "showKickedMemberTip", "showPrivateCount", "plugin-finder_release"})
public final class bt
  extends d
{
  public final String TAG;
  final com.tencent.mm.live.c.b hOp;
  public f umS;
  
  public bt(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247138);
    this.hOp = paramb;
    this.TAG = "Finder.LiveVisitorExceptionPlugin";
    AppMethodBeat.o(247138);
  }
  
  public final void atI(String paramString)
  {
    AppMethodBeat.i(247137);
    if (this.umS == null) {
      this.umS = new f((View)this.hwr, paramString, getLiveData().uEu);
    }
    AppMethodBeat.o(247137);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ok", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public a(bt parambt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ok", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public b(bt parambt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bt
 * JD-Core Version:    0.7.0.1
 */