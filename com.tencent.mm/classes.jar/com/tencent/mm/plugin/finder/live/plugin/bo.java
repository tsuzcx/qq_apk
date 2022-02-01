package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.c.a.a.a.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.component.t.b;
import com.tencent.mm.plugin.finder.live.component.t.c;
import com.tencent.mm.plugin.finder.live.component.u;
import com.tencent.mm.plugin.finder.live.component.v;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.at;
import com.tencent.mm.plugin.finder.live.report.s.au;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "anchorShowingLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$ShowingLocation;", "getAnchorShowingLocation", "()Landroidx/lifecycle/MutableLiveData;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "canClearScreen", "", "getAnchorLuckyMoneyBottom", "", "onMicUserChanged", "", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "register", "refPoint", "Landroid/graphics/PointF;", "sdkUserId", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unregister", "updateLotteryStatus", "showingLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "updateRedPacket", "watchLotteryBubbleShowingLocation", "Companion", "ShowingLocation", "plugin-finder_release"})
public final class bo
  extends d
{
  public static final a yuj;
  private final ConcurrentHashMap<String, o<t.b, t.c>> cDe;
  private final com.tencent.mm.live.c.b kCL;
  public final r<b> yui;
  
  static
  {
    AppMethodBeat.i(263607);
    yuj = new a((byte)0);
    AppMethodBeat.o(263607);
  }
  
  public bo(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(263606);
    this.kCL = paramb;
    this.cDe = new ConcurrentHashMap();
    this.yui = new r();
    AppMethodBeat.o(263606);
  }
  
  private final void a(PointF paramPointF, String paramString)
  {
    AppMethodBeat.i(263591);
    Log.i("FinderLiveLuckyMoneyBubblePlugin", "register sdkUserId:".concat(String.valueOf(paramString)));
    if (this.cDe.containsKey(paramString))
    {
      AppMethodBeat.o(263591);
      return;
    }
    if (p.h(paramString, ((c)business(c.class)).kvP.Tzp)) {}
    Object localObject2;
    Object localObject3;
    for (Object localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.data.h(paramString, null, null, null, 0, "", null, false, 0, null, null, 0, 0, false, null, 0L, null, 262016);; localObject1 = ((f)business(f.class)).aDb(paramString))
    {
      Log.i("FinderLiveLuckyMoneyBubblePlugin", "register bindMicUser:".concat(String.valueOf(localObject1)));
      if (localObject1 == null) {
        break label278;
      }
      localObject2 = getBuContext();
      localObject3 = this.kCL;
      ah localah = ah.yhC;
      localObject1 = new u((com.tencent.mm.plugin.finder.live.model.context.a)localObject2, (com.tencent.mm.live.c.b)localObject3, ah.getFinderLiveAssistant(), (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1);
      localObject2 = this.kiF;
      localObject3 = this.kiF.getContext();
      if (localObject3 != null) {
        break;
      }
      paramPointF = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(263591);
      throw paramPointF;
    }
    paramPointF = new v((ViewGroup)localObject2, (MMActivity)localObject3, (t.b)localObject1, paramPointF);
    ((u)localObject1).a((t.c)paramPointF);
    ((Map)this.cDe).put(paramString, new o(localObject1, paramPointF));
    if (paramString.equals(((c)business(c.class)).kvP.Tzp)) {
      paramPointF.ybX = this.yui;
    }
    AppMethodBeat.o(263591);
    return;
    label278:
    AppMethodBeat.o(263591);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(263603);
    p.k(paramLinkedHashMap, "micUserMap");
    Object localObject3 = new ArrayList();
    Object localObject4;
    for (;;)
    {
      String str;
      synchronized ((Map)this.cDe)
      {
        localObject4 = ((Map)???).entrySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        str = (String)((Map.Entry)localObject5).getKey();
        if (str.equals(((c)business(c.class)).kvP.Tzp)) {
          continue;
        }
        ??? = ((f)business(f.class)).zhm;
        p.j(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      }
      synchronized ((Iterable)???)
      {
        Iterator localIterator = ???.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ??? = localIterator.next();
            paramBoolean = Util.isEqual(str, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).ktR);
            if (paramBoolean)
            {
              if (??? != null) {
                break;
              }
              Log.i("FinderLiveLuckyMoneyBubblePlugin", "old mic " + (o)((Map.Entry)localObject5).getValue() + " removed");
              ((ArrayList)localObject3).add(str);
              break;
              paramLinkedHashMap = finally;
              AppMethodBeat.o(263603);
              throw paramLinkedHashMap;
            }
          }
        }
        ??? = null;
      }
    }
    ??? = x.aazN;
    ??? = ((Iterable)localObject3).iterator();
    while (((Iterator)???).hasNext())
    {
      ??? = (String)((Iterator)???).next();
      p.k(???, "sdkUserId");
      Log.i("FinderLiveLuckyMoneyBubblePlugin", "unregister sdkUserId:".concat(String.valueOf(???)));
      localObject4 = (o)this.cDe.get(???);
      if (localObject4 != null)
      {
        p.j(localObject4, "map[sdkUserId] ?: return");
        localObject3 = (t.b)((o)localObject4).Mx;
        localObject4 = (t.c)((o)localObject4).My;
        ((t.b)localObject3).onDetach();
        ((t.c)localObject4).release();
        this.cDe.remove(???);
      }
    }
    ??? = ((f)business(f.class)).zhm;
    p.j(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    float f1;
    label639:
    do
    {
      do
      {
        for (;;)
        {
          synchronized ((Iterable)???)
          {
            ??? = ((Iterable)???).iterator();
            if (!((Iterator)???).hasNext()) {
              break label746;
            }
            localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)???).next();
            localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).ktR;
            if (localObject3 == null) {
              continue;
            }
            if (this.cDe.get(localObject3) != null) {
              break;
            }
            Log.i("FinderLiveLuckyMoneyBubblePlugin", "new mic user:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).nickname + " micId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).sessionId + " sdkUserId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).ktR + " added");
            localObject4 = (Rect)paramLinkedHashMap.get(localObject3);
            if (localObject4 != null)
            {
              f1 = ((Rect)localObject4).left;
              localObject4 = (Rect)paramLinkedHashMap.get(localObject3);
              if (localObject4 == null) {
                break label639;
              }
              f2 = ((Rect)localObject4).top;
              a(new PointF(f1, f2), (String)localObject3);
            }
          }
          f1 = 0.0F;
          continue;
          f2 = 0.0F;
        }
        localObject4 = (o)this.cDe.get(localObject3);
      } while (localObject4 == null);
      localObject4 = (t.c)((o)localObject4).My;
    } while (localObject4 == null);
    Object localObject5 = (Rect)paramLinkedHashMap.get(localObject3);
    if (localObject5 != null)
    {
      f1 = ((Rect)localObject5).left;
      label702:
      localObject3 = (Rect)paramLinkedHashMap.get(localObject3);
      if (localObject3 == null) {
        break label765;
      }
    }
    label746:
    label765:
    for (float f2 = ((Rect)localObject3).top;; f2 = 0.0F)
    {
      ((t.c)localObject4).c(new PointF(f1, f2));
      break;
      paramLinkedHashMap = x.aazN;
      AppMethodBeat.o(263603);
      return;
      f1 = 0.0F;
      break label702;
    }
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void dBY()
  {
    boolean bool = true;
    AppMethodBeat.i(263594);
    Object localObject1 = "";
    Object localObject3 = ((Map)this.cDe).entrySet().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject3).next();
      if (!((t.b)((o)((Map.Entry)localObject2).getValue()).Mx).dxC()) {
        break label265;
      }
      localObject2 = ((t.b)((o)((Map.Entry)localObject2).getValue()).Mx).dxD();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      i = 1;
    }
    label258:
    label265:
    for (;;)
    {
      break;
      if (i != 0)
      {
        tU(0);
        localObject2 = m.yCt;
        localObject3 = s.au.yJR;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label232;
        }
        localObject1 = s.at.yJO;
        label150:
        if (i == 0) {
          break label239;
        }
        i = 0;
        label156:
        p.k(localObject3, "type");
        p.k(localObject1, "src");
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
          break label258;
        }
        if (localObject3 != s.au.yJR) {
          break label250;
        }
        if ((!m.yCs) && (i == 0)) {
          ((m)localObject2).a((s.au)localObject3, (s.at)localObject1);
        }
        if (i != 0) {
          break label245;
        }
      }
      for (;;)
      {
        m.yCs = bool;
        AppMethodBeat.o(263594);
        return;
        tU(8);
        break;
        label232:
        localObject1 = s.at.yJP;
        break label150;
        label239:
        i = 8;
        break label156;
        label245:
        bool = false;
      }
      label250:
      ((m)localObject2).a((s.au)localObject3, (s.at)localObject1);
      AppMethodBeat.o(263594);
      return;
    }
  }
  
  public final float dBZ()
  {
    AppMethodBeat.i(263598);
    Object localObject = ((c)business(c.class)).kvP.Tzp;
    if (localObject == null)
    {
      AppMethodBeat.o(263598);
      return 0.0F;
    }
    localObject = (o)this.cDe.get(localObject);
    if (localObject != null)
    {
      localObject = (t.c)((o)localObject).My;
      if (localObject != null)
      {
        float f = ((t.c)localObject).dxG();
        AppMethodBeat.o(263598);
        return f;
      }
    }
    AppMethodBeat.o(263598);
    return 0.0F;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(263590);
    p.k(paramc, "status");
    switch (bp.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    Object localObject;
    do
    {
      do
      {
        AppMethodBeat.o(263590);
        return;
        localObject = new PointF(0.0F, aw.fromDPToPix(this.kiF.getContext(), 136));
        paramBundle = ((c)business(c.class)).kvP.Tzp;
        paramc = paramBundle;
        if (paramBundle == null) {
          paramc = "";
        }
        a((PointF)localObject, paramc);
        paramc = (bk)getPlugin(bk.class);
        if (paramc != null)
        {
          paramc = paramc.ytM;
          if (paramc != null)
          {
            paramBundle = this.kiF.getContext();
            if (paramBundle == null)
            {
              paramc = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(263590);
              throw paramc;
            }
            paramc.a((androidx.lifecycle.l)paramBundle, (s)new c(this));
            AppMethodBeat.o(263590);
            return;
          }
        }
        AppMethodBeat.o(263590);
        return;
        paramc = u.ybO;
        long l = ((c)business(c.class)).liveInfo.liveId;
        ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveLuckyMoneyStorage().Ls(l);
        AppMethodBeat.o(263590);
        return;
      } while (paramBundle == null);
      paramc = paramBundle.getString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID");
    } while (paramc == null);
    paramBundle = ((Map)this.cDe).entrySet().iterator();
    while (paramBundle.hasNext())
    {
      localObject = (t.b)((o)((Map.Entry)paramBundle.next()).getValue()).Mx;
      p.j(paramc, "sendId");
      ((t.b)localObject).aBV(paramc);
    }
    AppMethodBeat.o(263590);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(263596);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)locala).ZM())
    {
      this.kiF.setVisibility(8);
      Log.w("FinderLiveLuckyMoneyBubblePlugin", "setVisible return for isTeenMode");
      AppMethodBeat.o(263596);
      return;
    }
    super.tU(paramInt);
    AppMethodBeat.o(263596);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$ShowingLocation;", "", "(Ljava/lang/String;I)V", "GONE", "DEFAULT_LOCATION", "TRANSLATED_LOCATION", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(291854);
      b localb1 = new b("GONE", 0);
      yuk = localb1;
      b localb2 = new b("DEFAULT_LOCATION", 1);
      yul = localb2;
      b localb3 = new b("TRANSLATED_LOCATION", 2);
      yum = localb3;
      yun = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(291854);
    }
    
    private b() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "showingLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class c<T>
    implements s<bk.b>
  {
    c(bo parambo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bo
 * JD-Core Version:    0.7.0.1
 */