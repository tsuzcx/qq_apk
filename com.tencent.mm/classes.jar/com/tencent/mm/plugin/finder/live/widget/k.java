package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.h;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.report.s.g;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBattleAnchorTipWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "appliedBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "appliedProgressBar", "appliedTipGroup", "applyTipGroup", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "hideAppliedBattleTip", "", "actionCallback", "Lkotlin/Function0;", "hideApplyBattleTip", "onBattleAcceptFail", "onBattleAcceptSucc", "reset", "setVisible", "visiblity", "", "showAppliedBattileTip", "showAppliedProgressBar", "showApplyBattleTip", "plugin-finder_release"})
public final class k
{
  private final String TAG;
  final com.tencent.mm.live.c.b kCL;
  final ViewGroup kiF;
  final com.tencent.mm.plugin.finder.live.plugin.d xYq;
  final View zmd;
  final View zme;
  public final View zmf;
  public final View zmg;
  
  public k(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, com.tencent.mm.plugin.finder.live.plugin.d paramd)
  {
    AppMethodBeat.i(287371);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "FinderLiveBattleAnchorTipWidget";
    this.zmd = this.kiF.findViewById(b.f.finder_live_battle_apply);
    this.zme = this.kiF.findViewById(b.f.finder_live_battle_applied);
    this.zmf = this.kiF.findViewById(b.f.finder_live_battle_applied_btn);
    this.zmg = this.kiF.findViewById(b.f.finder_live_battle_applied_loading_bar);
    paramViewGroup = this.zmd;
    p.j(paramViewGroup, "applyTipGroup");
    paramViewGroup.setTranslationX(-ax.au(this.kiF.getContext()).x / 2.0F);
    paramViewGroup = this.zme;
    p.j(paramViewGroup, "appliedTipGroup");
    paramViewGroup.setTranslationX(ax.au(this.kiF.getContext()).x / 2.0F);
    this.zmf.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268281);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveBattleAnchorTipWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        b.b.a(this.zmh.kCL, b.c.kBF);
        paramAnonymousView = com.tencent.mm.plugin.finder.live.report.k.yBj;
        localObject = s.c.yEH;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.putOpt("type", Integer.valueOf(s.g.yFh.type));
        paramAnonymousView = ((f)this.zmh.xYq.getBuContext().business(f.class)).zhz;
        if (paramAnonymousView != null) {}
        for (paramAnonymousView = paramAnonymousView.yeu;; paramAnonymousView = null)
        {
          localJSONObject.putOpt("result", paramAnonymousView);
          com.tencent.mm.plugin.finder.live.report.k.a((s.c)localObject, localJSONObject.toString());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveBattleAnchorTipWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268281);
          return;
        }
      }
    });
    AppMethodBeat.o(287371);
  }
  
  public final void S(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(287368);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, parama));
    AppMethodBeat.o(287368);
  }
  
  public final void T(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(287369);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, parama));
    AppMethodBeat.o(287369);
  }
  
  public final void dAT()
  {
    AppMethodBeat.i(287366);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(287366);
  }
  
  public final void dAU()
  {
    AppMethodBeat.i(287367);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(287367);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(287370);
    S(null);
    T(null);
    tU(8);
    AppMethodBeat.o(287370);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(287365);
    this.kiF.setVisibility(paramInt);
    AppMethodBeat.o(287365);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(k paramk, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(k paramk, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.k
 * JD-Core Version:    0.7.0.1
 */