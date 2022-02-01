package com.tencent.mm.plugin.finder.live.widget;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.i;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.q.i;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBattleAnchorTipWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "appliedBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "appliedBtnTv", "Landroid/widget/TextView;", "appliedPkTv", "appliedProgressBar", "appliedTipGroup", "appliedTv", "applyPkTv", "applyTipGroup", "applyTv", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "hideAppliedBattleTip", "", "actionCallback", "Lkotlin/Function0;", "hideApplyBattleTip", "onBattleAcceptFail", "onBattleAcceptSucc", "reset", "setVisible", "visiblity", "", "showAppliedBattileTip", "showAppliedProgressBar", "showApplyBattleTip", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  private final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  final View EmB;
  final View EmC;
  public final View EmD;
  public final View EmE;
  private final TextView EmF;
  private final TextView EmG;
  private final TextView EmH;
  private final TextView EmI;
  private final TextView EmJ;
  private final String TAG;
  final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public q(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(362166);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "FinderLiveBattleAnchorTipWidget";
    this.EmB = this.mJe.findViewById(p.e.BGV);
    this.EmC = this.mJe.findViewById(p.e.BGQ);
    this.EmD = this.mJe.findViewById(p.e.BGR);
    this.EmE = this.mJe.findViewById(p.e.BGS);
    this.EmF = ((TextView)this.mJe.findViewById(p.e.BGW));
    this.EmG = ((TextView)this.mJe.findViewById(p.e.BGX));
    this.EmH = ((TextView)this.mJe.findViewById(p.e.BGU));
    this.EmI = ((TextView)this.mJe.findViewById(p.e.BGT));
    this.EmJ = ((TextView)this.mJe.findViewById(p.e.BGR));
    this.EmB.setTranslationX(-bf.bf(this.mJe.getContext()).x / 2.0F);
    this.EmC.setTranslationX(bf.bf(this.mJe.getContext()).x / 2.0F);
    this.EmD.setOnClickListener(new q..ExternalSyntheticLambda0(this));
    paramViewGroup = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramViewGroup = this.mJe.getContext();
    s.s(paramViewGroup, "root.context");
    float f = com.tencent.mm.plugin.finder.accessibility.a.g(paramViewGroup, 16.0F);
    this.EmF.setTextSize(1, f);
    this.EmG.setTextSize(1, f);
    this.EmH.setTextSize(1, f);
    this.EmI.setTextSize(1, f);
    paramViewGroup = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramViewGroup = this.mJe.getContext();
    s.s(paramViewGroup, "root.context");
    f = com.tencent.mm.plugin.finder.accessibility.a.g(paramViewGroup, 14.0F);
    this.EmJ.setTextSize(1, f);
    AppMethodBeat.o(362166);
  }
  
  private static final void a(q paramq, View paramView)
  {
    AppMethodBeat.i(362175);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramq);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveBattleAnchorTipWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramq, "this$0");
    b.b.a(paramq.nfT, b.c.nff);
    paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
    localObject1 = com.tencent.mm.plugin.finder.live.report.q.c.DrF;
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).putOpt("type", Integer.valueOf(q.i.DsG.type));
    paramq = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramq.CwG.getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfK;
    if (paramq == null) {}
    for (paramq = null;; paramq = paramq.CES)
    {
      ((JSONObject)localObject2).putOpt("result", paramq);
      paramq = ah.aiuX;
      paramView.a((com.tencent.mm.plugin.finder.live.report.q.c)localObject1, ((JSONObject)localObject2).toString());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveBattleAnchorTipWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362175);
      return;
    }
  }
  
  public final void bq(final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(362218);
    d.uiThread((kotlin.g.a.a)new b(this, parama));
    AppMethodBeat.o(362218);
  }
  
  public final void br(final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(362228);
    d.uiThread((kotlin.g.a.a)new a(this, parama));
    AppMethodBeat.o(362228);
  }
  
  public final void epK()
  {
    AppMethodBeat.i(362198);
    d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(362198);
  }
  
  public final void epL()
  {
    AppMethodBeat.i(362209);
    d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(362209);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(362235);
    bq(null);
    br(null);
    tO(8);
    AppMethodBeat.o(362235);
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(362188);
    this.mJe.setVisibility(paramInt);
    AppMethodBeat.o(362188);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(q paramq, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(q paramq, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(q paramq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.q
 * JD-Core Version:    0.7.0.1
 */