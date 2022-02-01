package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.r;
import com.tencent.mm.plugin.finder.live.report.s.bi;
import com.tencent.mm.plugin.finder.live.s;
import com.tencent.mm.plugin.finder.live.view.adapter.x.a;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.plugin.finder.live.widget.ak;
import com.tencent.mm.plugin.finder.live.widget.ak.c;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "entranceRoot", "Landroid/view/ViewGroup;", "shoppingWidgetRoot", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "shoppingWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget;", "canClearScreen", "", "onPortraitDelayAction", "", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "delayMs", "", "onShoppingBubbleClick", "onShoppingBubbleClickImpl", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "updateBubbleLayout", "Companion", "plugin-finder_release"})
public final class cj
  extends d
{
  public static final a ywZ;
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final ak ywX;
  private final ViewGroup ywY;
  
  static
  {
    AppMethodBeat.i(265556);
    ywZ = new a((byte)0);
    AppMethodBeat.o(265556);
  }
  
  public cj(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup2, paramb);
    AppMethodBeat.i(265555);
    this.ywY = paramViewGroup2;
    this.kCL = paramb;
    this.TAG = "Finder.LiveShoppingBubblePlugin";
    paramViewGroup2 = paramViewGroup1.getContext();
    p.j(paramViewGroup2, "entranceRoot.context");
    this.ywX = new ak(paramViewGroup2, paramViewGroup1, this.ywY, this.kCL);
    this.ywX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(273657);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        cj.d(this.yxa);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(273657);
      }
    });
    AppMethodBeat.o(265555);
  }
  
  private final void dCy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(265546);
    final bu localbu = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziK;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    label181:
    Object localObject5;
    if ((localbu instanceof f))
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", ((f)localbu).zaO);
        this.kCL.statusChange(b.c.kAl, (Bundle)localObject1);
        AppMethodBeat.o(265546);
        return;
      }
      localObject3 = this.TAG;
      localObject4 = new StringBuilder("shopping bubble click, productId:").append(((f)localbu).zaO).append(",buy appId:");
      localObject1 = ((f)localbu).zaT;
      if (localObject1 != null)
      {
        localObject1 = ((ahj)localObject1).appid;
        localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append(',').append("buy path:");
        localObject1 = ((f)localbu).zaT;
        if (localObject1 == null) {
          break label314;
        }
        localObject1 = ((ahj)localObject1).path;
        localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append(",detail appId:");
        localObject1 = ((f)localbu).zaU;
        if (localObject1 == null) {
          break label320;
        }
      }
      label314:
      label320:
      for (localObject1 = ((ahj)localObject1).appid;; localObject1 = null)
      {
        localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append(" detail path:");
        localObject5 = ((f)localbu).zaU;
        localObject1 = localObject2;
        if (localObject5 != null) {
          localObject1 = ((ahj)localObject5).path;
        }
        Log.i((String)localObject3, (String)localObject1);
        localObject1 = r.xWC;
        r.c(getBuContext(), (f)localbu, (kotlin.g.a.m)new c(this, localbu));
        AppMethodBeat.o(265546);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label181;
      }
    }
    if ((localbu instanceof com.tencent.mm.plugin.finder.live.view.convert.e))
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putLong("PARAM_FINDER_LIVE_BUBBLE_ADID", ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI);
        this.kCL.statusChange(b.c.kAl, (Bundle)localObject1);
        AppMethodBeat.o(265546);
        return;
      }
      localObject3 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaJ;
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Boolean)com.tencent.mm.plugin.finder.storage.d.dXY().aSr()).booleanValue())
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgJ = null;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgK.clear();
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgJ;
        int i;
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            if (i != 1) {
              break label745;
            }
            Log.i(this.TAG, "get uxInfo from outsize:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgJ);
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgJ;
          }
        }
        for (;;)
        {
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          localObject4 = this.ylc.getContext();
          p.j(localObject4, "vg.context");
          localObject3 = ((ch)localObject3).RHW;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = "";
          }
          com.tencent.mm.plugin.finder.live.utils.a.B((Context)localObject4, (String)localObject2, (String)localObject3);
          if (this.kCL.getLiveRole() == 0)
          {
            localObject4 = com.tencent.mm.plugin.finder.live.report.m.yCt;
            localObject5 = s.bi.yLP;
            long l1 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI;
            localObject1 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaJ;
            if (localObject1 != null)
            {
              localObject2 = ((ch)localObject1).RHW;
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            long l2 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI;
            localObject3 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).jDL;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            ((com.tencent.mm.plugin.finder.live.report.m)localObject4).a((s.bi)localObject5, null, String.valueOf(l1), (String)localObject1, String.valueOf(l2), (String)localObject2);
          }
          AppMethodBeat.o(265546);
          return;
          i = 0;
          break;
          label745:
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgK.containsKey(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI)))
          {
            localObject1 = (String)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgK.get(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI));
            if (localObject1 != null)
            {
              if (((CharSequence)localObject1).length() > 0) {}
              for (i = 1;; i = 0)
              {
                if (i != 1) {
                  break label942;
                }
                Log.i(this.TAG, "get uxInfo from cgi-getShowShopSelf,adid:" + ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI + ",uxinfo:" + (String)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgK.get(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI)));
                localObject1 = (String)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgK.get(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI));
                break;
              }
            }
          }
          label942:
          localObject4 = this.TAG;
          localObject5 = new StringBuilder("get uxInfo from promotingProduct,adid:").append(((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI).append(",uxinfo:");
          localObject2 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).jDL;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          Log.i((String)localObject4, (String)localObject1);
          localObject2 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).jDL;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
      }
    }
    AppMethodBeat.o(265546);
  }
  
  public final void a(Bundle paramBundle, Object paramObject, final long paramLong)
  {
    AppMethodBeat.i(265554);
    if (paramBundle != null)
    {
      paramObject = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = paramObject;
      if (paramObject != null) {}
    }
    else
    {
      paramBundle = "";
    }
    switch (paramBundle.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(265554);
      return;
      if (paramBundle.equals("PORTRAIT_ACTION_BUBBLE_CLICK")) {
        com.tencent.mm.ae.d.a(paramLong, (Runnable)new b(this, paramLong));
      }
    }
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void dCz()
  {
    AppMethodBeat.i(265548);
    if (this.kiF.getVisibility() == 0) {
      this.ywX.dCz();
    }
    AppMethodBeat.o(265548);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(265552);
    p.k(paramc, "status");
    switch (ck.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      break;
    }
    label40:
    label81:
    label598:
    label730:
    label1378:
    for (;;)
    {
      AppMethodBeat.o(265552);
      return;
      Object localObject2 = this.ywX;
      paramBundle = getBuContext();
      bu localbu;
      if (paramBundle != null)
      {
        paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramBundle.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
        if (paramc != null)
        {
          paramc = paramc.ziK;
          if (paramc == null) {
            break label320;
          }
          ((ak)localObject2).xYp = paramBundle;
          localbu = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramBundle.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziK;
          if (!(localbu instanceof f)) {
            break label868;
          }
          Log.i(((ak)localObject2).TAG, "update shopping bubble, productId:" + ((f)localbu).zaO + ", promoting:" + ((f)localbu).zaV + ", platformName:" + ((f)localbu).zaM + ",platformId:" + ((f)localbu).yiH + ",seq:" + ((f)localbu).zaW + '!');
          if (((f)localbu).zaV != 1) {
            break label822;
          }
          paramBundle = ((f)localbu).zaY;
          if (paramBundle.zaO != 0L)
          {
            paramc = paramBundle.zaP;
            p.j(paramc, "data.img_urls");
            if (!Util.isNullOrNil((String)kotlin.a.j.lp((List)paramc))) {
              break label322;
            }
          }
        }
      }
      Object localObject1;
      Object localObject3;
      Object localObject4;
      label489:
      long l1;
      for (;;)
      {
        if (((ak)localObject2).kCL.getLiveRole() == 0)
        {
          com.tencent.mm.plugin.finder.live.report.m.a(com.tencent.mm.plugin.finder.live.report.m.yCt, s.bi.yLO, null, String.valueOf(((f)localbu).zaO));
          AppMethodBeat.o(265552);
          return;
          paramc = null;
          break label81;
          break;
          ((ak)localObject2).yZo.setVisibility(0);
          paramc = ((ak)localObject2).zrd;
          if (paramc != null) {
            paramc.setVisibility(8);
          }
          ((ak)localObject2).yZm.setVisibility(0);
          ((ak)localObject2).ybl.setVisibility(0);
          paramc = t.ztT;
          paramc = t.dJi();
          localObject1 = paramBundle.zaP;
          p.j(localObject1, "data.img_urls");
          localObject1 = new com.tencent.mm.plugin.finder.loader.e((String)kotlin.a.j.lp((List)localObject1));
          localObject3 = ((ak)localObject2).yZl;
          localObject4 = t.ztT;
          paramc.a(localObject1, (ImageView)localObject3, t.a(t.a.zug));
          if (paramBundle.zaV != 1) {
            break label730;
          }
          ((ak)localObject2).zqZ.setVisibility(0);
          ((ak)localObject2).zra.setVisibility(0);
          ((ak)localObject2).ybl.setVisibility(0);
          localObject1 = ((ak)localObject2).zrb;
          paramc = paramBundle.title;
          if (paramc == null) {
            break label753;
          }
          paramc = (CharSequence)paramc;
          ((NeatTextView)localObject1).aL(paramc);
          paramc = com.tencent.mm.plugin.finder.live.view.adapter.x.yZD;
          x.a.a(((ak)localObject2).yZo, paramBundle.zaS, paramBundle.zaR);
          ((ak)localObject2).yZH.setVisibility(0);
          ((ak)localObject2).yZH.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(((ak)localObject2).yZH.getContext(), (CharSequence)paramBundle.zaM));
          paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if (!com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
            break label763;
          }
          ((ak)localObject2).zrc.setVisibility(8);
          if (paramBundle.zaW <= 0) {
            break label775;
          }
          ((ak)localObject2).yZm.setText((CharSequence)String.valueOf(paramBundle.zaW));
          ((ak)localObject2).LU(paramBundle.zaO);
          ((ak)localObject2).dIG();
          localObject1 = paramBundle.zaU;
          paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if (com.tencent.mm.plugin.finder.live.utils.a.dEC())
          {
            l1 = paramBundle.zaO;
            paramc = ((ak)localObject2).ybY;
            if (paramc == null) {
              break label802;
            }
            paramc = paramc.getTag();
            if ((paramc instanceof Long)) {
              break label807;
            }
          }
        }
      }
      for (;;)
      {
        paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if ((!com.tencent.mm.plugin.finder.live.utils.a.NJ(paramBundle.yiH)) || (localObject1 == null)) {
          break label276;
        }
        Log.i(((ak)localObject2).TAG, "prerender bubble " + paramBundle.zaO);
        paramc = s.xWG;
        paramBundle = ((ak)localObject2).xYp;
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        s.a(paramc, paramBundle, com.tencent.mm.plugin.finder.live.utils.a.a((ahj)localObject1));
        break label276;
        break label40;
        ((ak)localObject2).zqZ.setVisibility(8);
        ((ak)localObject2).zra.setVisibility(8);
        break label459;
        label753:
        paramc = (CharSequence)"";
        break label489;
        label763:
        ((ak)localObject2).zrc.setVisibility(0);
        break label573;
        ((ak)localObject2).yZm.setText((CharSequence)"");
        ((ak)localObject2).yZm.setVisibility(8);
        break label598;
        paramc = null;
        break label648;
        if (l1 == ((Long)paramc).longValue()) {
          break;
        }
      }
      ((ak)localObject2).dIF();
      if (((ak)localObject2).kCL.getLiveRole() == 0) {
        com.tencent.mm.plugin.finder.live.report.m.a(com.tencent.mm.plugin.finder.live.report.m.yCt, s.bi.yLW, null, String.valueOf(((f)localbu).zaO));
      }
      AppMethodBeat.o(265552);
      return;
      label868:
      if ((localbu instanceof com.tencent.mm.plugin.finder.live.view.convert.e))
      {
        Log.i(((ak)localObject2).TAG, "update shopping bubble," + ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI + ", productId:" + ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).title + ", promoting:" + ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).promoting);
        long l2;
        if (((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).promoting == 1)
        {
          localObject3 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaN;
          if ((((bcq)localObject3).zaI == 0L) || (Util.isNullOrNil(((bcq)localObject3).zaK)))
          {
            Log.i(((ak)localObject2).TAG, "showShoppingBubble ad_id:" + ((bcq)localObject3).zaI + ", imgUrl:" + ((bcq)localObject3).zaK);
            if (((ak)localObject2).kCL.getLiveRole() == 0)
            {
              localObject2 = com.tencent.mm.plugin.finder.live.report.m.yCt;
              localObject3 = s.bi.yLO;
              l1 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI;
              paramc = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaJ;
              if (paramc != null)
              {
                paramBundle = paramc.RHW;
                paramc = paramBundle;
                if (paramBundle != null) {}
              }
              else
              {
                paramc = "";
              }
              l2 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI;
              localObject1 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).jDL;
              paramBundle = (Bundle)localObject1;
              if (localObject1 == null) {
                paramBundle = "";
              }
              ((com.tencent.mm.plugin.finder.live.report.m)localObject2).a((s.bi)localObject3, null, String.valueOf(l1), paramc, String.valueOf(l2), paramBundle);
              AppMethodBeat.o(265552);
            }
          }
          else
          {
            ((ak)localObject2).yZo.setVisibility(8);
            ((ak)localObject2).yZH.setVisibility(8);
            ((ak)localObject2).yZm.setVisibility(8);
            paramc = ((ak)localObject2).zrd;
            if (paramc != null) {
              paramc.setVisibility(0);
            }
            paramc = ((ak)localObject2).zrf;
            if (paramc != null) {
              paramc.setOnClickListener(null);
            }
            paramc = t.ztT;
            paramc = t.dJi();
            paramBundle = new com.tencent.mm.plugin.finder.loader.e(((bcq)localObject3).zaK);
            localObject1 = ((ak)localObject2).yZl;
            localObject4 = t.ztT;
            paramc.a(paramBundle, (ImageView)localObject1, t.a(t.a.zug));
            if (((bcq)localObject3).promoting != 1) {
              break label1355;
            }
            ((ak)localObject2).zqZ.setVisibility(0);
            ((ak)localObject2).zra.setVisibility(0);
          }
          for (;;)
          {
            paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            if (!com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
              break label1378;
            }
            ((ak)localObject2).ybl.setVisibility(8);
            ((ak)localObject2).zrb.aL((CharSequence)"");
            ((ak)localObject2).yZo.setText((CharSequence)"");
            ((ak)localObject2).zrc.setVisibility(8);
            ((ak)localObject2).LU(((bcq)localObject3).zaI);
            ((ak)localObject2).dIG();
            break label1028;
            break;
            ((ak)localObject2).zqZ.setVisibility(8);
            ((ak)localObject2).zra.setVisibility(8);
          }
          ((ak)localObject2).ybl.setVisibility(0);
          localObject4 = ((ak)localObject2).zrb;
          paramBundle = ((bcq)localObject3).zaM;
          paramc = paramBundle;
          if (paramBundle == null) {
            paramc = "";
          }
          localObject1 = ((bcq)localObject3).title;
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          ak.a((NeatTextView)localObject4, paramc, paramBundle);
          paramBundle = ((ak)localObject2).zre;
          if (paramBundle != null)
          {
            paramc = ((bcq)localObject3).desc;
            if (paramc != null)
            {
              paramc = (CharSequence)paramc;
              paramBundle.setText(paramc);
            }
          }
          else
          {
            paramBundle = ((ak)localObject2).zrf;
            if (paramBundle != null)
            {
              paramc = ((bcq)localObject3).zaL;
              if (paramc == null) {
                break label1546;
              }
            }
          }
          for (paramc = (CharSequence)paramc;; paramc = (CharSequence)"")
          {
            paramBundle.setText(paramc);
            paramc = ((ak)localObject2).zrf;
            if (paramc != null) {
              paramc.setOnClickListener((View.OnClickListener)new ak.c((ak)localObject2, (bcq)localObject3));
            }
            ((ak)localObject2).zrc.setVisibility(0);
            break;
            paramc = (CharSequence)"";
            break label1461;
          }
        }
        if (((ak)localObject2).kCL.getLiveRole() == 0)
        {
          localObject3 = com.tencent.mm.plugin.finder.live.report.m.yCt;
          localObject4 = s.bi.yLW;
          l1 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI;
          paramc = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaJ;
          if (paramc != null)
          {
            paramBundle = paramc.RHW;
            paramc = paramBundle;
            if (paramBundle != null) {}
          }
          else
          {
            paramc = "";
          }
          l2 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).zaI;
          localObject1 = ((com.tencent.mm.plugin.finder.live.view.convert.e)localbu).jDL;
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          ((com.tencent.mm.plugin.finder.live.report.m)localObject3).a((s.bi)localObject4, null, String.valueOf(l1), paramc, String.valueOf(l2), paramBundle);
        }
        ((ak)localObject2).dIF();
      }
    }
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(265553);
    Object localObject = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)localObject).ZM())
    {
      this.kiF.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(265553);
      return;
    }
    if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) && (paramInt == 0))
    {
      localObject = ah.yhC;
      localObject = ah.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((an)localObject).aj((View)this.ywY, paramInt);
        AppMethodBeat.o(265553);
        return;
      }
      AppMethodBeat.o(265553);
      return;
    }
    super.tU(paramInt);
    AppMethodBeat.o(265553);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$Companion;", "", "()V", "PORTRAIT_ACTION_BUBBLE_CLICK", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(cj paramcj, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(267968);
      if (!this.yxa.isFinished())
      {
        cj.b(this.yxa);
        AppMethodBeat.o(267968);
        return;
      }
      Log.i(cj.c(this.yxa), "onShoppingBubbleClickImpl delayMs:" + paramLong + ",isFinished!");
      AppMethodBeat.o(267968);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.m<Boolean, g, kotlin.x>
  {
    c(cj paramcj, bu parambu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cj
 * JD-Core Version:    0.7.0.1
 */