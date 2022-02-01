package com.tencent.mm.plugin.finder.live.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.widget.o;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExceptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "exceptionWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "initWidget", "", "anchorUserName", "showKickedMemberTip", "showPrivateCount", "plugin-finder_release"})
public final class db
  extends d
{
  public final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  public o ymj;
  
  public db(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(290084);
    this.kCL = paramb;
    this.TAG = "Finder.LiveVisitorExceptionPlugin";
    AppMethodBeat.o(290084);
  }
  
  public final void aCl(String paramString)
  {
    AppMethodBeat.i(290083);
    if (this.ymj == null) {
      this.ymj = new o((View)this.kiF, paramString, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGE());
    }
    AppMethodBeat.o(290083);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ok", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public a(db paramdb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ok", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public b(db paramdb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.db
 * JD-Core Version:    0.7.0.1
 */