package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.cgi.bp;
import com.tencent.mm.plugin.finder.feed.model.j;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNoticeBubble;", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePromoteItem;", "context", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DIMISS_AFTER_RESERVE", "", "TAG", "", "root", "Landroid/view/ViewGroup;", "afterAddAnim", "", "getView", "Landroid/view/View;", "initView", "data", "", "onBubbleDel", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "delayMs", "refreshView", "Lcom/tencent/mm/plugin/finder/live/view/convert/PromoteLiveNoticeItem;", "updateView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bm
  implements cx
{
  private final long Dho;
  private final String TAG;
  private final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private final Context context;
  private ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  public bm(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(355317);
    this.context = paramContext;
    this.buContext = parama;
    this.nfT = paramb;
    this.TAG = "FinderLiveNoticeBubble";
    this.Dho = 5000L;
    paramContext = af.mU(this.context).inflate(p.f.CeK, null);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(355317);
      throw paramContext;
    }
    this.mJe = ((ViewGroup)paramContext);
    AppMethodBeat.o(355317);
  }
  
  private static final void a(bm parambm, com.tencent.mm.plugin.finder.live.view.convert.f paramf, View paramView)
  {
    AppMethodBeat.i(355351);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambm);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveNoticeBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parambm, "this$0");
    kotlin.g.b.s.u(paramf, "$data");
    kotlin.g.b.s.X("close promote, id:", paramf.DUK.hAR);
    com.tencent.e.f.h.jXD();
    paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
    com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(parambm.buContext, 2, 1);
    parambm = aj.CGT;
    parambm = aj.elk();
    if (parambm != null)
    {
      paramView = b.c.ndQ;
      localObject1 = new Bundle();
      localObject2 = new bla();
      ((bla)localObject2).id = paramf.DUI;
      ((bla)localObject2).type = 1;
      ((bla)localObject2).ZTU = new com.tencent.mm.bx.b(paramf.DUK.toByteArray());
      paramf = ah.aiuX;
      ((Bundle)localObject1).putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((bla)localObject2).toByteArray());
      paramf = ah.aiuX;
      parambm.statusChange(paramView, (Bundle)localObject1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveNoticeBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355351);
  }
  
  private static final void a(bm parambm, com.tencent.mm.plugin.finder.live.view.convert.f paramf, String paramString, bkk parambkk, int paramInt)
  {
    AppMethodBeat.i(355375);
    new StringBuilder("reserve notice, id:").append(paramf.DUK.hAR).append(", optype:").append(paramInt);
    com.tencent.e.f.h.jXD();
    Object localObject = j.BfL;
    localObject = j.Sv(paramString);
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = j.BfL;
        j.b(paramString, parambkk);
      }
      localObject = parambkk.hAR;
      kotlin.g.b.s.checkNotNull(localObject);
      kotlin.g.b.s.s(localObject, "liveNoticeInfo.noticeId!!");
      paramString = new bp(paramString, (String)localObject, paramInt, null, null, null, 48);
      com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
      parambkk.status = parambkk.status;
      parambm.a(paramf);
      AppMethodBeat.o(355375);
      return;
      ((bkk)localObject).status = parambkk.status;
    }
  }
  
  private static final void a(bm parambm, com.tencent.mm.ui.base.s params)
  {
    Object localObject = null;
    AppMethodBeat.i(355385);
    kotlin.g.b.s.u(parambm, "this$0");
    int i;
    if (params.jmw())
    {
      ViewGroup localViewGroup2 = parambm.mJe;
      ViewGroup localViewGroup1 = localViewGroup2;
      if (localViewGroup2 == null)
      {
        kotlin.g.b.s.bIx("root");
        localViewGroup1 = null;
      }
      i = localViewGroup1.getContext().getResources().getColor(p.b.Red);
      parambm = parambm.mJe;
      if (parambm != null) {
        break label106;
      }
      kotlin.g.b.s.bIx("root");
      parambm = localObject;
    }
    label106:
    for (;;)
    {
      params.a(4, i, (CharSequence)parambm.getContext().getResources().getString(p.h.finder_live_notice_unreserve));
      AppMethodBeat.o(355385);
      return;
    }
  }
  
  private final void a(com.tencent.mm.plugin.finder.live.view.convert.f paramf)
  {
    Object localObject2 = null;
    AppMethodBeat.i(355337);
    Object localObject3 = this.mJe;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    localObject1 = (TextView)((ViewGroup)localObject1).findViewById(p.e.BPv);
    localObject3 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.finder.utils.aw.a(paramf.DUK.startTime * 1000L, null, false, 6));
    localObject3 = this.mJe;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    TextView localTextView = (TextView)((ViewGroup)localObject1).findViewById(p.e.BPu);
    localObject3 = this.mJe;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    View localView = ((ViewGroup)localObject1).findViewById(p.e.BIb);
    localObject3 = this.mJe;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = null;
    }
    com.tencent.mm.ui.aw.a((Paint)((TextView)((ViewGroup)localObject1).findViewById(p.e.title)).getPaint(), 0.8F);
    localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.s(this.buContext))
    {
      localTextView.setVisibility(8);
      localView.setVisibility(4);
      AppMethodBeat.o(355337);
      return;
    }
    localTextView.setVisibility(0);
    localView.setVisibility(0);
    localView.setOnClickListener(new bm..ExternalSyntheticLambda0(this, paramf));
    if (paramf.DUK.status == 1)
    {
      localTextView.setText((CharSequence)this.context.getString(p.h.Crz));
      com.tencent.mm.ui.aw.a((Paint)localTextView.getPaint(), 0.8F);
      localTextView.setOnClickListener(new bm..ExternalSyntheticLambda1(paramf, this));
      AppMethodBeat.o(355337);
      return;
    }
    localTextView.setText((CharSequence)this.context.getString(p.h.CrA));
    localObject1 = this.mJe;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ViewGroup)localObject1).postDelayed(new bm..ExternalSyntheticLambda4(paramf), this.Dho);
      break;
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.view.convert.f paramf, bm parambm, View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(355412);
    Object localObject3 = new Object();
    Object localObject4 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject4).cH(paramf);
    ((com.tencent.mm.hellhoundlib.b.b)localObject4).cH(parambm);
    ((com.tencent.mm.hellhoundlib.b.b)localObject4).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveNoticeBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject3, ((com.tencent.mm.hellhoundlib.b.b)localObject4).aYj());
    kotlin.g.b.s.u(paramf, "$data");
    kotlin.g.b.s.u(parambm, "this$0");
    localObject3 = paramf.DUK;
    localObject4 = ((e)parambm.buContext.business(e.class)).mIC;
    if (((bkk)localObject3).status == 1)
    {
      ((bkk)localObject3).status = 0;
      localObject2 = parambm.mJe;
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("root");
        paramView = null;
      }
      localObject2 = paramView.getContext();
      paramView = parambm.mJe;
      if (paramView == null)
      {
        kotlin.g.b.s.bIx("root");
        paramView = localObject1;
      }
      for (;;)
      {
        paramView = aa.makeText((Context)localObject2, (CharSequence)paramView.getContext().getString(p.h.finder_live_notice_edu_toast_tips), 0);
        paramView.setGravity(17, 0, 0);
        paramView.show();
        a(parambm, paramf, (String)localObject4, (bkk)localObject3, 1);
        paramf = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
        com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(parambm.buContext, 3, 1);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveNoticeBubble", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(355412);
        return;
      }
    }
    paramView = parambm.mJe;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("root");
      paramView = (View)localObject2;
    }
    for (;;)
    {
      paramView = new com.tencent.mm.ui.widget.a.f(paramView.getContext(), 1, true);
      paramView.NE(true);
      paramView.Vtg = new bm..ExternalSyntheticLambda2(parambm);
      paramView.GAC = new bm..ExternalSyntheticLambda3((bkk)localObject3, parambm, paramf, (String)localObject4);
      paramView.dDn();
      break;
    }
  }
  
  private static final void a(bkk parambkk, bm parambm, com.tencent.mm.plugin.finder.live.view.convert.f paramf, String paramString, MenuItem paramMenuItem, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(355397);
    kotlin.g.b.s.u(parambkk, "$liveNoticeInfo");
    kotlin.g.b.s.u(parambm, "this$0");
    kotlin.g.b.s.u(paramf, "$data");
    kotlin.g.b.s.u(paramString, "$anchorUserNameStr");
    if (paramMenuItem.getItemId() == 4)
    {
      parambkk.status = 1;
      a(parambm, paramf, paramString, parambkk, 2);
      parambkk = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(parambm.buContext, 4, 1);
      paramf = parambm.mJe;
      parambkk = paramf;
      if (paramf == null)
      {
        kotlin.g.b.s.bIx("root");
        parambkk = null;
      }
      paramf = parambkk.getContext();
      parambkk = parambm.mJe;
      if (parambkk != null) {
        break label138;
      }
      kotlin.g.b.s.bIx("root");
      parambkk = localObject;
    }
    label138:
    for (;;)
    {
      aa.y(paramf, parambkk.getContext().getString(p.h.finder_cancel_succ), p.g.icons_filled_done);
      AppMethodBeat.o(355397);
      return;
    }
  }
  
  private static final void b(com.tencent.mm.plugin.finder.live.view.convert.f paramf)
  {
    AppMethodBeat.i(355361);
    kotlin.g.b.s.u(paramf, "$data");
    Object localObject = aj.CGT;
    localObject = aj.elk();
    if (localObject != null)
    {
      b.c localc = b.c.ndQ;
      Bundle localBundle = new Bundle();
      bla localbla = new bla();
      localbla.type = 1;
      localbla.ZTU = new com.tencent.mm.bx.b(paramf.DUK.toByteArray());
      localbla.id = paramf.DUI;
      paramf = ah.aiuX;
      localBundle.putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", localbla.toByteArray());
      paramf = ah.aiuX;
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).statusChange(localc, localBundle);
    }
    AppMethodBeat.o(355361);
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong) {}
  
  public final void eoK() {}
  
  public final void eoL() {}
  
  public final void fs(Object paramObject)
  {
    AppMethodBeat.i(355471);
    kotlin.g.b.s.u(paramObject, "data");
    if ((paramObject instanceof com.tencent.mm.plugin.finder.live.view.convert.f)) {
      a((com.tencent.mm.plugin.finder.live.view.convert.f)paramObject);
    }
    AppMethodBeat.o(355471);
  }
  
  public final void ft(Object paramObject)
  {
    AppMethodBeat.i(355481);
    kotlin.g.b.s.u(paramObject, "data");
    if ((paramObject instanceof com.tencent.mm.plugin.finder.live.view.convert.f))
    {
      a((com.tencent.mm.plugin.finder.live.view.convert.f)paramObject);
      paramObject = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(this.buContext, 1, 1);
    }
    AppMethodBeat.o(355481);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(355488);
    ViewGroup localViewGroup = this.mJe;
    Object localObject = localViewGroup;
    if (localViewGroup == null)
    {
      kotlin.g.b.s.bIx("root");
      localObject = null;
    }
    localObject = (View)localObject;
    AppMethodBeat.o(355488);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bm
 * JD-Core Version:    0.7.0.1
 */