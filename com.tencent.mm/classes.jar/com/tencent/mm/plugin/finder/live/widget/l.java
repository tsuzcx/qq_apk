package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMoreOptionEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setVisible", "", "visible", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public l(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361070);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.mJe.setOnClickListener(new l..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(361070);
  }
  
  private static final void a(l paraml, View paramView)
  {
    AppMethodBeat.i(361080);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paraml);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMoreOptionEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paraml, "this$0");
    paramView = j.Dob;
    localObject1 = q.s.Dve;
    localObject2 = j.Dob;
    paramView.a((q.s)localObject1, j.a(q.r.Duf));
    paraml.CwG.tO(4);
    paramView = (com.tencent.mm.plugin.finder.live.plugin.s)paraml.CwG.getPlugin(com.tencent.mm.plugin.finder.live.plugin.s.class);
    if (paramView != null)
    {
      paramView.CWg = ((kotlin.g.a.a)new a(paraml));
      paramView.mJe.setVisibility(0);
      paramView.CWd.animate().translationY(0.0F).setDuration(200L).setListener(null).start();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMoreOptionEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361080);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(361093);
    ViewGroup localViewGroup = this.mJe;
    if (paramBoolean)
    {
      Object localObject2;
      if (this.mJe.getVisibility() != 0)
      {
        localObject1 = j.Dob;
        localObject2 = q.t.Dwq;
        j localj = j.Dob;
        ((j)localObject1).a((q.t)localObject2, j.a(q.r.Duf));
      }
      Object localObject1 = this.CwG.getBuContext();
      i = j;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
        com.tencent.mm.plugin.finder.live.component.statecomponent.b.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject1, 1, 0, null, 12);
        localObject1 = ah.aiuX;
      }
    }
    for (int i = j;; i = 8)
    {
      localViewGroup.setVisibility(i);
      AppMethodBeat.o(361093);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.l
 * JD-Core Version:    0.7.0.1
 */