package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.model.aq;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract.Presenter;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.report.d.b;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerData;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;)V", "msgButtonLen", "", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class az
  extends e<aq>
{
  private int tED;
  final FinderLotteryListContract.Presenter tEE;
  
  public az(FinderLotteryListContract.Presenter paramPresenter)
  {
    AppMethodBeat.i(243171);
    this.tEE = paramPresenter;
    AppMethodBeat.o(243171);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243169);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    ao.a((Paint)((TextView)paramh.Mn(2131301455)).getPaint(), 0.8F);
    paramRecyclerView = paramh.Mn(2131307600);
    paramRecyclerView.post((Runnable)new b(paramRecyclerView));
    AppMethodBeat.o(243169);
  }
  
  public final int getLayoutId()
  {
    return 2131494429;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(az paramaz, aq paramaq, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243167);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      localObject1 = this.tEG.uOC.username;
      paramView = d.vdp;
      Object localObject2 = d.dnK();
      String str = z.aUg();
      p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
      if (localObject1 == null) {}
      for (paramView = "";; paramView = (View)localObject1)
      {
        ((d.b)localObject2).ah(str, paramView, "");
        paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject2 = this.tzq.getContext();
        p.g(localObject2, "holder.context");
        paramView = this.tEF.tEE.uWg;
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader");
          AppMethodBeat.o(243167);
          throw paramView;
        }
        str = ((FinderLiveLotteryListLoader)paramView).tWb;
        paramView = this.tEF.tEE.uWg;
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader");
          AppMethodBeat.o(243167);
          throw paramView;
        }
        long l = ((FinderLiveLotteryListLoader)paramView).hFK;
        paramView = FinderReporterUIC.wzC;
        paramView = this.tzq.getContext();
        p.g(paramView, "holder.context");
        paramView = FinderReporterUIC.a.fH(paramView);
        if (paramView != null) {}
        for (paramView = paramView.dIx();; paramView = null)
        {
          com.tencent.mm.plugin.finder.utils.a.a((Context)localObject2, 1, (String)localObject1, str, l, paramView);
          paramView = k.vkd;
          k.a(s.f.vny, "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(243167);
          return;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(243168);
      Object localObject1 = new Rect();
      this.tEH.getHitRect((Rect)localObject1);
      Object localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      int i = ((Context)localObject2).getResources().getDimensionPixelOffset(2131165314);
      ((Rect)localObject1).inset(-i, -i);
      localObject2 = this.tEH;
      p.g(localObject2, "sendMsgBtn");
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(243168);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, this.tEH));
      AppMethodBeat.o(243168);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.az
 * JD-Core Version:    0.7.0.1
 */