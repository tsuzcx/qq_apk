package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.d.a.a.a.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.ai.b;
import com.tencent.mm.plugin.finder.live.component.ai.c;
import com.tencent.mm.plugin.finder.live.component.ak;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bh;
import com.tencent.mm.plugin.finder.live.report.q.bi;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "anchorShowingLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$ShowingLocation;", "getAnchorShowingLocation", "()Landroidx/lifecycle/MutableLiveData;", "dataObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "canClearScreen", "", "getAnchorLuckyMoneyBottom", "", "mount", "", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "register", "refPoint", "Landroid/graphics/PointF;", "sdkUserId", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "unregister", "unwatchLotteryBubbleShowingLocation", "updateLotteryStatus", "showingLocation", "updateRedPacket", "watchLotteryBubbleShowingLocation", "Companion", "ShowingLocation", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bc
  extends b
{
  public static final bc.a DeF;
  private static final float DeH;
  public final x<b> DeG;
  private y<ba.b> Dek;
  private final ConcurrentHashMap<String, r<ai.b, ai.c>> evG;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(355103);
    DeF = new bc.a((byte)0);
    DeH = MMApplicationContext.getContext().getResources().getDimension(p.c.Edge_2A);
    AppMethodBeat.o(355103);
  }
  
  public bc(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355071);
    this.nfT = paramb;
    this.evG = new ConcurrentHashMap();
    this.DeG = new x();
    AppMethodBeat.o(355071);
  }
  
  private final void a(PointF paramPointF, String paramString)
  {
    AppMethodBeat.i(355080);
    Log.i("FinderLiveLuckyMoneyBubblePlugin", s.X("register sdkUserId:", paramString));
    if (this.evG.containsKey(paramString))
    {
      AppMethodBeat.o(355080);
      return;
    }
    if (s.p(paramString, ((f)business(f.class)).mZr.aaOw)) {}
    Object localObject2;
    Object localObject3;
    for (Object localObject1 = new com.tencent.mm.plugin.finder.live.viewmodel.data.h(paramString, null, null, null, 0, "", null, false, 0, null, null, 0, 0, false, null, 0L, null, false, 1048448);; localObject1 = ((j)business(j.class)).ayt(paramString))
    {
      Log.i("FinderLiveLuckyMoneyBubblePlugin", s.X("register bindMicUser:", localObject1));
      if (localObject1 == null) {
        break label267;
      }
      localObject2 = getBuContext();
      localObject3 = this.nfT;
      com.tencent.mm.plugin.finder.live.model.aj localaj = com.tencent.mm.plugin.finder.live.model.aj.CGT;
      localObject1 = new com.tencent.mm.plugin.finder.live.component.aj((com.tencent.mm.plugin.finder.live.model.context.a)localObject2, (com.tencent.mm.live.b.b)localObject3, com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant(), (com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject1);
      localObject2 = this.mJe;
      localObject3 = this.mJe.getContext();
      if (localObject3 != null) {
        break;
      }
      paramPointF = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(355080);
      throw paramPointF;
    }
    paramPointF = new ak((ViewGroup)localObject2, (MMActivity)localObject3, (ai.b)localObject1, paramPointF);
    ((com.tencent.mm.plugin.finder.live.component.aj)localObject1).a((ai.c)paramPointF);
    ((Map)this.evG).put(paramString, new r(localObject1, paramPointF));
    if (paramString.equals(((f)business(f.class)).mZr.aaOw)) {
      paramPointF.CAq = this.DeG;
    }
    label267:
    AppMethodBeat.o(355080);
  }
  
  private static final void a(bc parambc, ba.b paramb)
  {
    AppMethodBeat.i(355093);
    s.u(parambc, "this$0");
    Object localObject;
    if (paramb == null)
    {
      localObject = null;
      Log.i("FinderLiveLuckyMoneyBubblePlugin", s.X("watchLotteryBubbleShowingLocation: ", localObject));
      if (paramb != null)
      {
        localObject = ((f)parambc.business(f.class)).mZr.aaOw;
        Log.i("FinderLiveLuckyMoneyBubblePlugin", "updateLotteryStatus createUserId:" + localObject + ", showingLocation:" + paramb.name());
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label163;
        }
      }
    }
    label163:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        parambc = (r)parambc.evG.get(localObject);
        if (parambc != null)
        {
          parambc = (ai.c)parambc.bsD;
          if (parambc != null) {
            parambc.a(paramb);
          }
        }
      }
      AppMethodBeat.o(355093);
      return;
      localObject = paramb.name();
      break;
    }
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(355170);
    s.u(paramLinkedHashMap, "micUserMap");
    Log.i("FinderLiveLuckyMoneyBubblePlugin", "onMicUserChanged: map.size:" + this.evG.size() + ", audienceLinkMicUserList.size:" + ((j)business(j.class)).Efw.size() + ", micUserMap:" + paramLinkedHashMap);
    Object localObject3 = new ArrayList();
    Object localObject4;
    for (;;)
    {
      String str;
      synchronized ((Map)this.evG)
      {
        localObject4 = ((Map)???).entrySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        str = (String)((Map.Entry)localObject5).getKey();
        if (str.equals(((f)business(f.class)).mZr.aaOw)) {
          continue;
        }
        ??? = ((j)business(j.class)).Efw;
        s.s(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
      }
      synchronized ((Iterable)???)
      {
        Iterator localIterator = ???.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ??? = localIterator.next();
            paramBoolean = Util.isEqual(str, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)???).mXL);
            if (paramBoolean)
            {
              if (??? != null) {
                break;
              }
              Log.i("FinderLiveLuckyMoneyBubblePlugin", "old mic " + ((Map.Entry)localObject5).getValue() + " removed, sdkUserID:" + str);
              ((ArrayList)localObject3).add(str);
              break;
              paramLinkedHashMap = finally;
              AppMethodBeat.o(355170);
              throw paramLinkedHashMap;
            }
          }
        }
        ??? = null;
      }
    }
    ??? = ah.aiuX;
    ??? = ((Iterable)localObject3).iterator();
    while (((Iterator)???).hasNext())
    {
      ??? = (String)((Iterator)???).next();
      s.u(???, "sdkUserId");
      Log.i("FinderLiveLuckyMoneyBubblePlugin", s.X("unregister sdkUserId:", ???));
      localObject4 = (r)this.evG.get(???);
      if (localObject4 != null)
      {
        localObject3 = (ai.b)((r)localObject4).bsC;
        localObject4 = (ai.c)((r)localObject4).bsD;
        ((ai.b)localObject3).onDetach();
        ((ai.c)localObject4).release();
        this.evG.remove(???);
      }
    }
    ??? = ((j)business(j.class)).Efw;
    s.s(???, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    float f1;
    label689:
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
              break label866;
            }
            localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)???).next();
            localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).mXL;
            if (localObject3 == null) {
              continue;
            }
            if (this.evG.get(localObject3) != null) {
              break;
            }
            Log.i("FinderLiveLuckyMoneyBubblePlugin", "new mic user:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).nickname + " micId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).sessionId + " sdkUserId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).mXL + " added");
            localObject4 = (Rect)paramLinkedHashMap.get(localObject3);
            if (localObject4 == null)
            {
              f1 = 0.0F;
              localObject4 = (Rect)paramLinkedHashMap.get(localObject3);
              if (localObject4 != null) {
                break label689;
              }
              f2 = 0.0F;
              a(new PointF(f1, f2), (String)localObject3);
            }
          }
          f1 = ((Rect)localObject4).left;
          continue;
          f2 = ((Rect)localObject4).top;
        }
        Log.i("FinderLiveLuckyMoneyBubblePlugin", "update mic user:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).nickname + " micId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).sessionId + " sdkUserId:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject4).mXL);
        localObject4 = (r)this.evG.get(localObject3);
      } while (localObject4 == null);
      localObject4 = (ai.c)((r)localObject4).bsD;
    } while (localObject4 == null);
    Object localObject5 = (Rect)paramLinkedHashMap.get(localObject3);
    if (localObject5 == null)
    {
      f1 = 0.0F;
      label806:
      localObject3 = (Rect)paramLinkedHashMap.get(localObject3);
      if (localObject3 != null) {
        break label855;
      }
    }
    label855:
    for (float f2 = 0.0F;; f2 = ((Rect)localObject3).top)
    {
      ((ai.c)localObject4).b(new PointF(f1, f2));
      break;
      f1 = ((Rect)localObject5).left;
      break label806;
    }
    label866:
    paramLinkedHashMap = ah.aiuX;
    AppMethodBeat.o(355170);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void eqX()
  {
    boolean bool = true;
    AppMethodBeat.i(355137);
    Object localObject1 = "";
    Object localObject3 = ((Map)this.evG).entrySet().iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject3).next();
      if (!((ai.b)((r)((Map.Entry)localObject2).getValue()).bsC).eiE()) {
        break label265;
      }
      localObject2 = ((ai.b)((r)((Map.Entry)localObject2).getValue()).bsC).eiF();
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
        tO(0);
        localObject2 = k.Doi;
        localObject3 = q.bi.DAU;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label232;
        }
        localObject1 = q.bh.DAR;
        label150:
        if (i == 0) {
          break label239;
        }
        i = 0;
        label156:
        s.u(localObject3, "type");
        s.u(localObject1, "src");
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
          break label258;
        }
        if (localObject3 != q.bi.DAU) {
          break label250;
        }
        if ((!k.Dpo) && (i == 0)) {
          ((k)localObject2).a((q.bi)localObject3, (q.bh)localObject1);
        }
        if (i != 0) {
          break label245;
        }
      }
      for (;;)
      {
        k.Dpo = bool;
        AppMethodBeat.o(355137);
        return;
        tO(8);
        break;
        label232:
        localObject1 = q.bh.DAS;
        break label150;
        label239:
        i = 8;
        break label156;
        label245:
        bool = false;
      }
      label250:
      ((k)localObject2).a((q.bi)localObject3, (q.bh)localObject1);
      AppMethodBeat.o(355137);
      return;
    }
  }
  
  public final float eqY()
  {
    AppMethodBeat.i(355153);
    Object localObject = ((f)business(f.class)).mZr.aaOw;
    if (localObject == null)
    {
      AppMethodBeat.o(355153);
      return 0.0F;
    }
    localObject = (r)this.evG.get(localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(355153);
      return 0.0F;
    }
    localObject = (ai.c)((r)localObject).bsD;
    if (localObject == null)
    {
      AppMethodBeat.o(355153);
      return 0.0F;
    }
    float f = ((ai.c)localObject).eiI();
    AppMethodBeat.o(355153);
    return f;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355177);
    super.mount();
    Object localObject1 = new bc..ExternalSyntheticLambda0(this);
    Object localObject2 = (ba)getPlugin(ba.class);
    if (localObject2 != null)
    {
      localObject2 = ((ba)localObject2).Deh;
      if (localObject2 != null)
      {
        Context localContext = this.mJe.getContext();
        if (localContext == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(355177);
          throw ((Throwable)localObject1);
        }
        ((x)localObject2).a((q)localContext, (y)localObject1);
      }
    }
    localObject2 = ah.aiuX;
    this.Dek = ((y)localObject1);
    AppMethodBeat.o(355177);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355126);
    s.u(paramc, "status");
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355126);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      PointF localPointF = new PointF(0.0F, com.tencent.mm.plugin.finder.live.utils.a.euM() + DeH);
      paramBundle = ((f)business(f.class)).mZr.aaOw;
      paramc = paramBundle;
      if (paramBundle == null) {
        paramc = "";
      }
      a(localPointF, paramc);
      AppMethodBeat.o(355126);
      return;
      paramc = com.tencent.mm.plugin.finder.live.component.aj.CzY;
      long l = ((f)business(f.class)).liveInfo.liveId;
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveLuckyMoneyStorage().oz(l);
      AppMethodBeat.o(355126);
      return;
      if (paramBundle != null)
      {
        paramc = paramBundle.getString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID");
        if (paramc != null)
        {
          paramBundle = ((Map)this.evG).entrySet().iterator();
          while (paramBundle.hasNext()) {
            ((ai.b)((r)((Map.Entry)paramBundle.next()).getValue()).bsC).awr(paramc);
          }
        }
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(355144);
    if (((d)com.tencent.mm.kernel.h.ax(d.class)).aBu())
    {
      this.mJe.setVisibility(8);
      Log.w("FinderLiveLuckyMoneyBubblePlugin", "setVisible return for isTeenMode");
      AppMethodBeat.o(355144);
      return;
    }
    super.tO(paramInt);
    AppMethodBeat.o(355144);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355181);
    super.unMount();
    y localy = this.Dek;
    if (localy != null)
    {
      Object localObject = (ba)getPlugin(ba.class);
      if (localObject != null)
      {
        localObject = ((ba)localObject).Deh;
        if (localObject != null) {
          ((x)localObject).b(localy);
        }
      }
    }
    this.Dek = null;
    AppMethodBeat.o(355181);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLuckyMoneyBubblePlugin$ShowingLocation;", "", "(Ljava/lang/String;I)V", "GONE", "DEFAULT_LOCATION", "TRANSLATED_LOCATION", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(354095);
      DeI = new b("GONE", 0);
      DeJ = new b("DEFAULT_LOCATION", 1);
      DeK = new b("TRANSLATED_LOCATION", 2);
      DeL = new b[] { DeI, DeJ, DeK };
      AppMethodBeat.o(354095);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bc
 * JD-Core Version:    0.7.0.1
 */