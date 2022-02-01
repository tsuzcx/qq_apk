package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.be;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.NativeInfo;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ivIcon", "Landroid/widget/ImageView;", "moreLiveEntrance", "Landroid/view/View;", "showPromoteBanner", "", "txvContent", "Landroid/widget/TextView;", "canClearScreen", "checkMoreLiveEntranceVisible", "", "gotoMoreLive", "gotoMoreLiveImpl", "isPromoteBannerShow", "onPortraitAction", "actionInfo", "Landroid/os/Bundle;", "extraData", "", "setVisible", "visible", "", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bh
  extends b
{
  public static final a DgH;
  private static final String DgM;
  private View DgI;
  private TextView DgJ;
  private ImageView DgK;
  private boolean DgL;
  private final String TAG;
  private final com.tencent.mm.live.b.b ngl;
  
  static
  {
    AppMethodBeat.i(355189);
    DgH = new a((byte)0);
    DgM = "PORTRAIT_ACTION_MORE_LIVE";
    AppMethodBeat.o(355189);
  }
  
  public bh(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, bui parambui)
  {
    super(paramViewGroup, paramb, parambui);
    AppMethodBeat.i(355167);
    this.ngl = paramb;
    this.TAG = "FinderLiveMoreLiveEntrancePlugin";
    this.DgI = paramViewGroup.findViewById(p.e.BOS);
    this.DgJ = ((TextView)paramViewGroup.findViewById(p.e.CbI));
    this.DgK = ((ImageView)paramViewGroup.findViewById(p.e.CbJ));
    paramb = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramViewGroup = paramViewGroup.getContext();
    s.s(paramViewGroup, "root.context");
    com.tencent.mm.plugin.finder.accessibility.a.a(paramViewGroup, this.DgJ, 12.0F);
    AppMethodBeat.o(355167);
  }
  
  private static final void a(bh parambh, View paramView)
  {
    AppMethodBeat.i(355185);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambh, "this$0");
    boolean bool = parambh.isLandscape();
    Log.i(parambh.TAG, s.X("gotoMoreLive isLandscape:", Boolean.valueOf(bool)));
    if (bool) {
      b.a((b)parambh, DgM);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355185);
      return;
      parambh.err();
    }
  }
  
  private final void err()
  {
    Object localObject4 = null;
    AppMethodBeat.i(355178);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
    Object localObject2;
    label39:
    Object localObject5;
    Object localObject6;
    Object localObject3;
    label63:
    label85:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = this.reportObj;
      if (localObject2 != null) {
        break label323;
      }
      localObject2 = "";
      localObject5 = this.TAG;
      localObject6 = new StringBuilder("moreLiveEntrance click,tabId:");
      if (localObject1 != null) {
        break label341;
      }
      localObject3 = null;
      localObject6 = ((StringBuilder)localObject6).append(localObject3).append(",tabName:");
      if (localObject1 != null) {
        break label353;
      }
      localObject3 = localObject4;
      Log.i((String)localObject5, localObject3 + " contextId:" + (String)localObject2);
      localObject3 = k.Doi;
      localObject4 = q.be.DAH;
      if (localObject1 != null) {
        break label362;
      }
      i = 0;
      label125:
      ((k)localObject3).a((q.be)localObject4, i);
      localObject5 = new HashMap();
      localObject6 = (Map)localObject5;
      if (localObject1 != null) {
        break label370;
      }
      localObject3 = "";
    }
    for (;;)
    {
      ((Map)localObject6).put("tab_id", localObject3);
      ((Map)localObject5).put("liveid", String.valueOf(((f)business(f.class)).liveInfo.liveId));
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.s.akfj, (Map)localObject5);
      localObject3 = (com.tencent.d.a.b.a.e)h.az(com.tencent.d.a.b.a.e.class);
      localObject4 = this.mJe.getContext();
      s.s(localObject4, "root.context");
      localObject5 = new Intent();
      if (localObject1 != null) {
        ((Intent)localObject5).putExtra("nearby_live_target_square_page_params_key", ((bnn)localObject1).toByteArray());
      }
      ((Intent)localObject5).putExtra("key_context_id", (String)localObject2);
      localObject1 = ah.aiuX;
      ((com.tencent.d.a.b.a.e)localObject3).enterNearbyLiveMoreUI((Context)localObject4, (Intent)localObject5);
      AppMethodBeat.o(355178);
      return;
      localObject1 = ((FinderObject)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bip)localObject1).ZRS;
      break;
      label323:
      localObject2 = ((bui)localObject2).zIO;
      if (localObject2 == null)
      {
        localObject2 = "";
        break label39;
      }
      break label39;
      label341:
      localObject3 = Integer.valueOf(((bnn)localObject1).ZVZ);
      break label63;
      label353:
      localObject3 = ((bnn)localObject1).ZWa;
      break label85;
      label362:
      i = ((bnn)localObject1).ZVZ;
      break label125;
      label370:
      localObject4 = Integer.valueOf(((bnn)localObject1).ZVZ).toString();
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
    }
  }
  
  public final void c(Bundle paramBundle, Object paramObject)
  {
    AppMethodBeat.i(355254);
    if (paramBundle == null) {
      paramBundle = "";
    }
    for (;;)
    {
      if (s.p(paramBundle, DgM)) {
        err();
      }
      AppMethodBeat.o(355254);
      return;
      paramObject = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = paramObject;
      if (paramObject == null) {
        paramBundle = "";
      }
    }
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void erq()
  {
    boolean bool = false;
    AppMethodBeat.i(355236);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      tO(8);
      AppMethodBeat.o(355236);
      return;
    }
    localObject1 = (bq)getPlugin(bq.class);
    Object localObject2;
    Object localObject3;
    int j;
    if (localObject1 != null)
    {
      localObject2 = ((List)((bq)localObject1).DhG).iterator();
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((com.tencent.mm.plugin.finder.live.model.b)((Iterator)localObject2).next()).CDz.native_info;
        if ((localObject3 != null) && (((NativeInfo)localObject3).native_type == 9))
        {
          j = 1;
          label111:
          if (j == 0) {
            break label191;
          }
          label115:
          if (i == -1) {
            break label203;
          }
          i = 1;
          label122:
          if ((((com.tencent.mm.live.b.a)localObject1).mJe.getVisibility() != 0) && ((!((bq)localObject1).isLandscape()) || (i == 0))) {
            break label208;
          }
          i = 1;
          label147:
          if (i != 1) {
            break label213;
          }
        }
      }
    }
    label191:
    label203:
    label208:
    label213:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label218;
      }
      tO(8);
      this.DgL = true;
      Log.i(this.TAG, "showing the promote banner");
      AppMethodBeat.o(355236);
      return;
      j = 0;
      break label111;
      i += 1;
      break;
      i = -1;
      break label115;
      i = 0;
      break label122;
      i = 0;
      break label147;
    }
    label218:
    if (this.DgL)
    {
      tO(8);
      Log.i(this.TAG, "PromoteBanner is showed");
      AppMethodBeat.o(355236);
      return;
    }
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
    if (localObject1 == null)
    {
      localObject3 = null;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
      if (localObject1 != null) {
        break label438;
      }
      localObject1 = "";
      label293:
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eco;
      if (localObject2 != null) {
        break label499;
      }
      localObject2 = "";
    }
    for (;;)
    {
      Log.i(this.TAG, "#checkMoreLiveEntranceState tabId:" + localObject3 + " iconWording:" + (String)localObject1 + " iconUrl:" + (String)localObject2);
      if ((localObject3 != null) && (((Integer)localObject3).intValue() != 0)) {
        break label560;
      }
      tO(8);
      AppMethodBeat.o(355236);
      return;
      localObject1 = ((FinderObject)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject3 = null;
        break;
      }
      localObject1 = ((bip)localObject1).ZRS;
      if (localObject1 == null)
      {
        localObject3 = null;
        break;
      }
      localObject3 = Integer.valueOf(((bnn)localObject1).ZVZ);
      break;
      label438:
      localObject1 = ((FinderObject)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label293;
      }
      localObject1 = ((bip)localObject1).ZRS;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label293;
      }
      localObject2 = ((bnn)localObject1).ZWh;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label293;
      }
      localObject1 = "";
      break label293;
      label499:
      localObject2 = ((FinderObject)localObject2).liveInfo;
      if (localObject2 == null)
      {
        localObject2 = "";
      }
      else
      {
        localObject2 = ((bip)localObject2).ZRS;
        if (localObject2 == null)
        {
          localObject2 = "";
        }
        else
        {
          localObject4 = ((bnn)localObject2).icon_url;
          localObject2 = localObject4;
          if (localObject4 == null) {
            localObject2 = "";
          }
        }
      }
    }
    label560:
    Object localObject4 = aj.CGT;
    localObject4 = aj.egD();
    if (localObject4 == null)
    {
      localObject4 = null;
      Log.i(this.TAG, s.X("#checkMoreLiveEntranceState commentScene:", localObject4));
      if ((localObject4 != null) && (!((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).isFinderLiveSquareCommentScene(((Integer)localObject4).intValue())) && (!((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).isFinderLiveSquareMoreCommentScene(((Integer)localObject4).intValue())) && (((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).isEnableMoreEntrencePlugin(((Integer)localObject4).intValue()))) {
        if (((CharSequence)localObject1).length() != 0) {
          break label727;
        }
      }
    }
    label727:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label732;
      }
      tO(8);
      AppMethodBeat.o(355236);
      return;
      localObject4 = ((g)localObject4).Bwy;
      if (localObject4 == null)
      {
        localObject4 = null;
        break;
      }
      localObject4 = Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.j)localObject4).AJo);
      break;
    }
    label732:
    localObject4 = this.DgJ;
    if (localObject4 != null) {
      ((TextView)localObject4).setText((CharSequence)localObject1);
    }
    if (((CharSequence)localObject2).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label1020;
      }
      localObject1 = this.DgK;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      label790:
      if (this.mJe.getVisibility() != 0)
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("tab_id", ((Integer)localObject3).toString());
        ((HashMap)localObject1).put("liveid", String.valueOf(((f)business(f.class)).liveInfo.liveId));
        com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.t.Dwv, (Map)localObject1);
      }
      tO(0);
      k.Doi.a(q.be.DAG, ((Integer)localObject3).intValue());
      localObject1 = this.DgI;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new bh..ExternalSyntheticLambda0(this));
      }
      if (!isLandscape()) {
        break label1111;
      }
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = this.mJe.getContext();
      s.s(localObject1, "root.context");
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.n(getBuContext()))
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.o(getBuContext())) {}
      }
      else
      {
        bool = true;
      }
      i = com.tencent.mm.plugin.finder.live.utils.a.I((Context)localObject1, bool);
      localObject1 = this.DgI;
      if (localObject1 != null) {
        break label1092;
      }
    }
    label1092:
    for (localObject1 = null;; localObject1 = ((View)localObject1).getLayoutParams())
    {
      if (localObject1 != null) {
        break label1102;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(355236);
      throw ((Throwable)localObject1);
      i = 0;
      break;
      label1020:
      localObject1 = this.DgK;
      if (localObject1 != null)
      {
        localObject4 = p.ExI;
        localObject4 = p.eCl();
        localObject2 = new com.tencent.mm.plugin.finder.loader.b((String)localObject2);
        p localp = p.ExI;
        ((com.tencent.mm.loader.d)localObject4).a(localObject2, (ImageView)localObject1, p.a(p.a.ExM));
      }
      localObject1 = this.DgK;
      if (localObject1 == null) {
        break label790;
      }
      ((ImageView)localObject1).setVisibility(0);
      break label790;
    }
    label1102:
    ((ViewGroup.MarginLayoutParams)localObject1).setMarginEnd(i);
    label1111:
    AppMethodBeat.o(355236);
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(355245);
    if (((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      this.mJe.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(355245);
      return;
    }
    super.tO(paramInt);
    AppMethodBeat.o(355245);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin$Companion;", "", "()V", "PORTRAIT_ACTION_MORE_LIVE", "", "getPORTRAIT_ACTION_MORE_LIVE", "()Ljava/lang/String;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bh
 * JD-Core Version:    0.7.0.1
 */