package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.f;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract.Presenter;
import com.tencent.mm.plugin.finder.report.d.b;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerData;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;)V", "msgButtonLen", "", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class bb
  extends e<as>
{
  private int xnf;
  final FinderLotteryListContract.Presenter xng;
  
  public bb(FinderLotteryListContract.Presenter paramPresenter)
  {
    AppMethodBeat.i(272437);
    this.xng = paramPresenter;
    AppMethodBeat.o(272437);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(272435);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    ar.a((Paint)((TextView)parami.RD(b.f.finder_profile_send_msg_btn_tv)).getPaint(), 0.8F);
    paramRecyclerView = parami.RD(b.f.sendMsgBtn);
    paramRecyclerView.post((Runnable)new b(paramRecyclerView));
    AppMethodBeat.o(272435);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_lottery_history_winner_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert$onBindViewHolder$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(bb parambb, as paramas, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(284987);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUP().aSr()).intValue() <= 0)
      {
        p.j(paramView, "it");
        localObject1 = paramView.getContext();
        paramView = paramView.getContext();
        p.j(paramView, "it.context");
        w.makeText((Context)localObject1, (CharSequence)paramView.getResources().getString(b.j.finder_cannot_send_msg_title), 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284987);
        return;
      }
      localObject1 = this.xni.zAU.username;
      paramView = com.tencent.mm.plugin.finder.report.d.zUg;
      Object localObject2 = com.tencent.mm.plugin.finder.report.d.dPh();
      String str = z.bdh();
      p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((d.b)localObject2).ae(str, paramView, "");
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject1 = this.xhb.getContext();
      p.j(localObject1, "holder.context");
      localObject2 = this.xni.zAU;
      paramView = this.xnh.xng.zMw;
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader");
        AppMethodBeat.o(284987);
        throw paramView;
      }
      str = ((FinderLiveLotteryListLoader)paramView).xHT;
      paramView = this.xnh.xng.zMw;
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader");
        AppMethodBeat.o(284987);
        throw paramView;
      }
      long l = ((FinderLiveLotteryListLoader)paramView).xbk;
      paramView = aj.Bnu;
      paramView = this.xhb.getContext();
      p.j(paramView, "holder.context");
      paramView = aj.a.fZ(paramView);
      if (paramView != null) {}
      for (paramView = paramView.ekY();; paramView = null)
      {
        com.tencent.mm.plugin.finder.utils.a.a((Context)localObject1, 1, (bak)localObject2, str, l, paramView, true);
        paramView = k.yBj;
        k.a(s.f.yFb, "");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284987);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(282364);
      Object localObject1 = new Rect();
      this.xnj.getHitRect((Rect)localObject1);
      Object localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      int i = ((Context)localObject2).getResources().getDimensionPixelOffset(b.d.Edge_A);
      ((Rect)localObject1).inset(-i, -i);
      localObject2 = this.xnj;
      p.j(localObject2, "sendMsgBtn");
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(282364);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, this.xnj));
      AppMethodBeat.o(282364);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bb
 * JD-Core Version:    0.7.0.1
 */