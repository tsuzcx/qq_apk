package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.h;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract.Presenter;
import com.tencent.mm.plugin.finder.report.f.b;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerData;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;)V", "msgButtonLen", "", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.finder.model.aw>
{
  private final FinderLotteryListContract.Presenter ALe;
  private int ALf;
  
  public ax(FinderLotteryListContract.Presenter paramPresenter)
  {
    AppMethodBeat.i(350303);
    this.ALe = paramPresenter;
    AppMethodBeat.o(350303);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.model.aw paramaw, com.tencent.mm.view.recyclerview.j paramj, ax paramax, View paramView)
  {
    AppMethodBeat.i(350339);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramaw);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramax);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramaw, "$item");
    s.u(paramj, "$holder");
    s.u(paramax, "this$0");
    localObject1 = d.FAy;
    if (((Number)d.eTo().bmg()).intValue() <= 0)
    {
      aa.makeText(paramView.getContext(), (CharSequence)paramView.getContext().getResources().getString(p.h.Cgw), 0).show();
      a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350339);
      return;
    }
    localObject1 = paramaw.EDj.username;
    paramView = com.tencent.mm.plugin.finder.report.f.FnM;
    localObject2 = com.tencent.mm.plugin.finder.report.f.eMn();
    String str = z.bAW();
    s.s(str, "getMyFinderUsername()");
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = "";
    }
    ((f.b)localObject2).ak(str, paramView, "");
    paramView = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
    localObject1 = paramj.context;
    s.s(localObject1, "holder.context");
    localObject2 = paramaw.EDj;
    str = ((FinderLiveLotteryListLoader)paramax.ALe.CNJ).Bhk;
    long l = ((FinderLiveLotteryListLoader)paramax.ALe.CNJ).hKN;
    paramaw = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    paramaw = paramaw.el(paramj);
    if (paramaw == null) {}
    for (paramaw = null;; paramaw = paramaw.fou())
    {
      paramView.a((Context)localObject1, 1, (bjb)localObject2, str, l, paramaw, true);
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.h.Dsz, "");
      a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderLotteryWinnersConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350339);
      return;
    }
  }
  
  private static final void fw(View paramView)
  {
    AppMethodBeat.i(350317);
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
    localRect.inset(-i, -i);
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(350317);
      throw paramView;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, paramView));
    AppMethodBeat.o(350317);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(350370);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    com.tencent.mm.ui.aw.a((Paint)((TextView)paramj.UH(p.e.finder_profile_send_msg_btn_tv)).getPaint(), 0.8F);
    paramRecyclerView = paramj.UH(p.e.sendMsgBtn);
    paramRecyclerView.post(new ax..ExternalSyntheticLambda1(paramRecyclerView));
    AppMethodBeat.o(350370);
  }
  
  public final int getLayoutId()
  {
    return p.f.Cev;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ax
 * JD-Core Version:    0.7.0.1
 */