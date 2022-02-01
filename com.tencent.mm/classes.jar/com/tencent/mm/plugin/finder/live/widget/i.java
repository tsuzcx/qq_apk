package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.h;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.m;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "firstShow", "", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "initView", "", "isVisible", "jumpToCreateLotteryImpl", "jumpToCreateLotttery", "lotteryEntranceLogic", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "setVisible", "visible", "showCard", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a ElW;
  public static final String ElX;
  public final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private boolean ElK;
  public final String TAG;
  public final ViewGroup mJe;
  public final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(361074);
    ElW = new i.a((byte)0);
    ElX = "PORTRAIT_ACTION_GOTO_CREATE_LOTTERY";
    AppMethodBeat.o(361074);
  }
  
  public i(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361036);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.TAG = "Finder.FinderLiveAnchorLotteryEntranceWidget";
    this.ElK = true;
    paramb = this.mJe.findViewById(p.e.BNv);
    paramViewGroup = paramb;
    if (paramb == null) {
      paramViewGroup = (View)this.mJe;
    }
    paramViewGroup.setOnClickListener(new i..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(361036);
  }
  
  private static final void a(i parami, View paramView)
  {
    AppMethodBeat.i(361069);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    parami.ezV();
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361069);
  }
  
  private final void ezW()
  {
    AppMethodBeat.i(361051);
    ap localap = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
    Object localObject;
    if (localap != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject != null) {
        break label61;
      }
      localObject = "";
    }
    for (;;)
    {
      localap.a((String)localObject, null, (ad.a)new i.b(this));
      AppMethodBeat.o(361051);
      return;
      label61:
      localObject = ((m)localObject).Bhm;
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        localObject = ((bjc)localObject).id;
        if (localObject == null) {
          localObject = "";
        }
      }
    }
  }
  
  private final void ezX()
  {
    AppMethodBeat.i(361060);
    if (this.CwG.isLandscape())
    {
      com.tencent.mm.plugin.finder.live.plugin.b.a(this.CwG, ElX);
      AppMethodBeat.o(361060);
      return;
    }
    ezY();
    AppMethodBeat.o(361060);
  }
  
  public final void ezV()
  {
    Object localObject2 = null;
    AppMethodBeat.i(361091);
    if (this.nfT.getLiveRole() == 1) {
      j.Dob.a(q.h.Dsq, "");
    }
    Object localObject1 = j.Dob;
    Object localObject3 = q.s.DuV;
    j localj = j.Dob;
    ((j)localObject1).a((q.s)localObject3, j.a(q.r.Duf));
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject3 != null) {
        break label170;
      }
      label97:
      Log.i(this.TAG, "lotteryEntranceLogic lotteryStatus:" + localObject1 + ",bubbleFinish:" + localObject2);
      if (s.p(localObject2, Boolean.FALSE)) {
        if (localObject1 != null) {
          break label181;
        }
      }
    }
    label170:
    label181:
    while (((Integer)localObject1).intValue() != 1)
    {
      if (localObject1 != null) {
        break label199;
      }
      ezX();
      AppMethodBeat.o(361091);
      return;
      localObject1 = Integer.valueOf(((m)localObject1).CBc);
      break;
      localObject2 = Boolean.valueOf(((m)localObject3).EbX);
      break label97;
    }
    for (;;)
    {
      ezW();
      AppMethodBeat.o(361091);
      return;
      label199:
      if (((Integer)localObject1).intValue() != 2) {
        break;
      }
    }
  }
  
  public final void ezY()
  {
    Object localObject2 = null;
    AppMethodBeat.i(361102);
    String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("jumpToCreateLotteryImpl root.context is activity:").append(this.mJe.getContext() instanceof Activity).append(",liveId:");
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
    label172:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject3, localObject1 + ",objectId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN + ",nonceId:" + str);
      if (!(this.mJe.getContext() instanceof Activity)) {
        break label460;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
      if (localObject1 != null) {
        break label326;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label460;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
      if ((localObject1 == null) || (((bip)localObject1).liveId != 0L)) {
        break label337;
      }
      i = 1;
      label208:
      if ((i != 0) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN == 0L)) {
        break label460;
      }
      localObject1 = (CharSequence)str;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label342;
      }
      i = 1;
    }
    label326:
    label337:
    label342:
    Intent localIntent;
    for (;;)
    {
      if (i == 0)
      {
        if (((e)this.CwG.business(e.class)).DUe) {
          com.tencent.mm.plugin.finder.live.report.k.Doi.Pl(1);
        }
        localObject1 = this.mJe.getContext();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(361102);
          throw ((Throwable)localObject1);
          localObject1 = Long.valueOf(((bip)localObject1).liveId);
          break;
          localObject1 = Long.valueOf(((bip)localObject1).liveId);
          break label172;
          i = 0;
          break label208;
          i = 0;
          continue;
        }
        localObject3 = (Activity)localObject1;
        localObject4 = (com.tencent.mm.plugin.f)h.ax(com.tencent.mm.plugin.f.class);
        localIntent = new Intent();
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
        if (localObject1 != null) {
          break label467;
        }
      }
    }
    label460:
    label467:
    for (localObject1 = localObject2;; localObject1 = Long.valueOf(((bip)localObject1).liveId))
    {
      localIntent.putExtra("KEY_PARAMS_LIVE_ID", ((Long)localObject1).longValue());
      localIntent.putExtra("KEY_PARAMS_OBJECT_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN);
      localIntent.putExtra("KEY_PARAMS_NONCE_ID", str);
      localObject1 = ah.aiuX;
      ((com.tencent.mm.plugin.f)localObject4).i((Activity)localObject3, localIntent);
      AppMethodBeat.o(361102);
      return;
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(361109);
    if (((this.mJe.getVisibility() != 0) || (this.ElK)) && (paramInt == 0))
    {
      this.ElK = false;
      j localj1 = j.Dob;
      q.t localt = q.t.Dwh;
      j localj2 = j.Dob;
      localj1.a(localt, j.a(q.r.Duf));
    }
    this.mJe.setVisibility(paramInt);
    AppMethodBeat.o(361109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.i
 * JD-Core Version:    0.7.0.1
 */