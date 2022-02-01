package com.tencent.mm.plugin.finder.replay;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.lifecycle.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.model.i.c;
import com.tencent.mm.plugin.finder.live.model.as.c;
import com.tencent.mm.plugin.finder.live.model.aw;
import com.tencent.mm.plugin.finder.live.report.q.bj;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.replay.model.c.a;
import com.tencent.mm.plugin.finder.replay.model.g;
import com.tencent.mm.plugin.finder.replay.widget.f.a;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.video.ab;
import com.tencent.mm.plugin.finder.video.v;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayService;", "", "()V", "value", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "curLiveContext", "getCurLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setCurLiveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "curPlayerWidget", "Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;", "getCurPlayerWidget", "()Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;", "setCurPlayerWidget", "(Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;)V", "innerReplayMiniView", "Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView;", "getInnerReplayMiniView", "()Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView;", "innerReplayMiniView$delegate", "Lkotlin/Lazy;", "liveMsgOffsetProcess", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveMsgOffsetProcess;", "logicConfig", "Lcom/tencent/mm/plugin/finder/replay/model/FinderLiveReplayLogicConfig;", "getLogicConfig", "()Lcom/tencent/mm/plugin/finder/replay/model/FinderLiveReplayLogicConfig;", "Lcom/tencent/mm/plugin/finder/replay/model/FinderReplayLiveData;", "replayData", "getReplayData", "()Lcom/tencent/mm/plugin/finder/replay/model/FinderReplayLiveData;", "setReplayData", "(Lcom/tencent/mm/plugin/finder/replay/model/FinderReplayLiveData;)V", "replayFullScreenView", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayFullScreenReplayUI;", "getReplayFullScreenView", "()Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayFullScreenReplayUI;", "setReplayFullScreenView", "(Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayFullScreenReplayUI;)V", "replayMiniWindowView", "getReplayMiniWindowView", "setReplayMiniWindowView", "(Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView;)V", "seiProcessViewCallback", "com/tencent/mm/plugin/finder/replay/FinderLiveReplayService$seiProcessViewCallback$2$1", "getSeiProcessViewCallback", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayService$seiProcessViewCallback$2$1;", "seiProcessViewCallback$delegate", "seiProcessViewCallbackProxyList", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/live/model/SeiProcessViewCallback;", "Lkotlin/collections/HashSet;", "videoPlayLifecycle", "com/tencent/mm/plugin/finder/replay/FinderLiveReplayService$videoPlayLifecycle$2$1", "getVideoPlayLifecycle", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayService$videoPlayLifecycle$2$1;", "videoPlayLifecycle$delegate", "videoViewCallback", "com/tencent/mm/plugin/finder/replay/FinderLiveReplayService$videoViewCallback$2$1", "getVideoViewCallback", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayService$videoViewCallback$2$1;", "videoViewCallback$delegate", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "initData", "", "liveId", "", "baseData", "Lcom/tencent/mm/protocal/protobuf/FinderReplayLiveBase;", "fromMiniView", "", "initMiniView", "liveInfo", "", "onVideoPlayEndLogic", "source", "", "onVideoStartToPlay", "offset", "playerGenerator", "Lkotlin/Pair;", "sourcePlayer", "registerSeiProcessViewCallbackProxy", "proxy", "release", "force", "selectLiveMsg", "setData", "buContext", "config", "setFullScreenUI", "replayPluginLayout", "setMsgOffsetProcess", "startReplayMiniUI", "intent", "Landroid/content/Intent;", "startReplayUI", "unregisterSeiProcessViewCallbackProxy", "updateMiniWindow", "sourceType", "micData", "Lorg/json/JSONObject;", "checkDiff", "validInfo", "prefix", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private static volatile k FkK;
  public static final a Fky;
  com.tencent.mm.plugin.finder.live.model.context.a CDN;
  private final com.tencent.mm.plugin.finder.replay.model.a FkA;
  com.tencent.mm.plugin.finder.replay.widget.e FkB;
  private com.tencent.mm.plugin.finder.replay.widget.b FkC;
  private final j FkD;
  private final j FkE;
  private final j FkF;
  private final j FkG;
  private HashSet<aw> FkH;
  com.tencent.mm.plugin.finder.replay.widget.c FkI;
  private b FkJ;
  com.tencent.mm.plugin.finder.replay.model.c Fkz;
  
  static
  {
    AppMethodBeat.i(332807);
    Fky = new a((byte)0);
    AppMethodBeat.o(332807);
  }
  
  public k()
  {
    AppMethodBeat.i(332635);
    this.FkA = new com.tencent.mm.plugin.finder.replay.model.a();
    this.FkD = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.FkE = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.FkF = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.FkG = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.FkH = new HashSet();
    AppMethodBeat.o(332635);
  }
  
  private static final void a(k paramk, Intent paramIntent)
  {
    AppMethodBeat.i(332759);
    com.tencent.mm.plugin.finder.replay.widget.b localb = paramk.FkC;
    Object localObject1;
    Object localObject2;
    long l;
    if (localb != null)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramk.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 != null) {
        break label133;
      }
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Point(bd.bs(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.float_ball_voip_view_video_width), bd.bs(MMApplicationContext.getContext(), com.tencent.mm.live.core.a.b.float_ball_voip_view_video_height));
      }
      localObject1 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)paramk.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (localObject1 != null) {
        break label156;
      }
      l = 0L;
      label91:
      paramk = (com.tencent.mm.plugin.finder.replay.viewmodel.c)paramk.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (paramk != null) {
        break label168;
      }
    }
    label133:
    label156:
    label168:
    for (boolean bool = false;; bool = paramk.eLX())
    {
      localb.a((Point)localObject2, l, bool, paramIntent.getIntExtra("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 0));
      AppMethodBeat.o(332759);
      return;
      localObject2 = com.tencent.mm.live.core.d.a.mWH;
      localObject1 = com.tencent.mm.live.core.d.a.em(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).videoWidth, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).videoHeight);
      break;
      l = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject1).getLiveInfo().liveId;
      break label91;
    }
  }
  
  private void a(com.tencent.mm.plugin.finder.replay.model.c paramc)
  {
    AppMethodBeat.i(332641);
    Log.i("FinderLiveReplayService", "set replayData:" + paramc.hashCode() + ',' + eLD());
    this.Fkz = paramc;
    AppMethodBeat.o(332641);
  }
  
  private final boolean aD(String paramString, long paramLong)
  {
    AppMethodBeat.i(332725);
    Object localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).liveInfo;
      if ((localObject == null) || (paramLong != ((bip)localObject).liveId)) {}
    }
    for (int i = 1; i == 0; i = 0)
    {
      Log.e("FinderLiveReplayService", paramString + " remote liveId:" + paramLong + ',' + eLD());
      AppMethodBeat.o(332725);
      return false;
    }
    AppMethodBeat.o(332725);
    return true;
  }
  
  private void ap(int paramInt, long paramLong)
  {
    AppMethodBeat.i(332708);
    b localb = this.FkJ;
    if (localb != null) {
      localb.ap(paramInt, paramLong);
    }
    AppMethodBeat.o(332708);
  }
  
  private static final void av(ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> paramArrayList)
  {
    AppMethodBeat.i(332743);
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    label74:
    while (localIterator.hasNext())
    {
      paramArrayList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localIterator.next()).BxG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo;
      if (paramArrayList == null) {}
      for (paramArrayList = null;; paramArrayList = paramArrayList.ZSm)
      {
        if (paramArrayList == null) {
          break label74;
        }
        paramArrayList.ZUI = 0L;
        break;
      }
    }
    AppMethodBeat.o(332743);
  }
  
  private final k.g.1 eLA()
  {
    AppMethodBeat.i(332661);
    k.g.1 local1 = (k.g.1)this.FkE.getValue();
    AppMethodBeat.o(332661);
    return local1;
  }
  
  private final k.f.1 eLB()
  {
    AppMethodBeat.i(332668);
    k.f.1 local1 = (k.f.1)this.FkF.getValue();
    AppMethodBeat.o(332668);
    return local1;
  }
  
  private void eLC()
  {
    String str = null;
    AppMethodBeat.i(332679);
    com.tencent.mm.plugin.finder.replay.widget.b localb = this.FkC;
    Object localObject = localb;
    if (localb == null) {
      localObject = eLz();
    }
    this.FkC = ((com.tencent.mm.plugin.finder.replay.widget.b)localObject);
    localb = this.FkC;
    com.tencent.mm.plugin.finder.live.viewmodel.data.business.e locale;
    if (localb != null)
    {
      localObject = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (localObject != null) {
        break label84;
      }
      localObject = null;
      locale = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (locale != null) {
        break label92;
      }
    }
    for (;;)
    {
      localb.ia((String)localObject, str);
      AppMethodBeat.o(332679);
      return;
      label84:
      localObject = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject).eyh();
      break;
      label92:
      str = locale.eyo();
    }
  }
  
  private final String eLD()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(332734);
    if (this.CDN == null)
    {
      localObject3 = new StringBuilder("data is null,liveId:");
      localObject1 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append("-playerWidget:");
        localObject3 = this.FkI;
        if (localObject3 == null) {
          break label195;
        }
        i = localObject3.hashCode();
        label86:
        localObject3 = ((StringBuilder)localObject1).append(i).append("-player:");
        localObject1 = this.FkI;
        if (localObject1 != null) {
          break label200;
        }
        localObject1 = localObject2;
        label115:
        if (localObject1 == null) {
          break label210;
        }
      }
      label195:
      label200:
      label210:
      for (i = localObject1.hashCode();; i = 0)
      {
        localObject1 = ((StringBuilder)localObject3).append(i).append("-layout:");
        localObject2 = this.FkB;
        i = j;
        if (localObject2 != null) {
          i = localObject2.hashCode();
        }
        localObject1 = i;
        AppMethodBeat.o(332734);
        return localObject1;
        localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject1).getLiveInfo().liveId);
        break;
        i = 0;
        break label86;
        localObject1 = ((com.tencent.mm.plugin.finder.replay.widget.c)localObject1).Fni;
        break label115;
      }
    }
    localObject2 = new StringBuilder("service liveId:");
    Object localObject1 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append("-playerWidget:");
      localObject2 = this.FkI;
      if (localObject2 == null) {
        break label387;
      }
      i = localObject2.hashCode();
      label278:
      localObject2 = ((StringBuilder)localObject1).append(i).append("-player:");
      localObject1 = this.FkI;
      if (localObject1 != null) {
        break label392;
      }
      localObject1 = localObject3;
      label307:
      if (localObject1 == null) {
        break label402;
      }
    }
    label387:
    label392:
    label402:
    for (int i = localObject1.hashCode();; i = 0)
    {
      localObject1 = ((StringBuilder)localObject2).append(i).append("-layout:");
      localObject2 = this.FkB;
      i = k;
      if (localObject2 != null) {
        i = localObject2.hashCode();
      }
      localObject1 = i;
      AppMethodBeat.o(332734);
      return localObject1;
      localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject1).getLiveInfo().liveId);
      break;
      i = 0;
      break label278;
      localObject1 = ((com.tencent.mm.plugin.finder.replay.widget.c)localObject1).Fni;
      break label307;
    }
  }
  
  private final com.tencent.mm.plugin.finder.replay.widget.b eLz()
  {
    AppMethodBeat.i(332653);
    com.tencent.mm.plugin.finder.replay.widget.b localb = (com.tencent.mm.plugin.finder.replay.widget.b)this.FkD.getValue();
    AppMethodBeat.o(332653);
    return localb;
  }
  
  private void h(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(332647);
    StringBuilder localStringBuilder = new StringBuilder("set curLiveContext:");
    if (parama != null) {}
    for (int i = parama.hashCode();; i = 0)
    {
      Log.i("FinderLiveReplayService", i + ',' + eLD());
      this.CDN = parama;
      AppMethodBeat.o(332647);
      return;
    }
  }
  
  public final void B(long paramLong, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(332907);
    Log.i("FinderLiveReplayService", "release force;" + paramBoolean + ", remote liveId:" + paramLong + ", " + eLD());
    Object localObject2;
    long l;
    int i;
    if ((paramBoolean) || (aD("release", paramLong)))
    {
      if ((paramBoolean) && (this.FkA.FlQ))
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = (com.tencent.mm.plugin.finder.replay.viewmodel.b)com.tencent.mm.ui.component.k.cn(cn.class).q(com.tencent.mm.plugin.finder.replay.viewmodel.b.class);
        localObject2 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
        if (localObject2 != null) {
          break label371;
        }
        l = 0L;
        localObject2 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
        if (localObject2 != null) {
          break label384;
        }
        i = 0;
        label144:
        ((com.tencent.mm.plugin.finder.replay.viewmodel.b)localObject1).X(l, i);
      }
      localObject1 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (localObject1 != null) {
        break label394;
      }
      l = 0L;
      label172:
      if ((paramLong != 0L) || (l > 0L))
      {
        localObject2 = new JSONObject();
        if (l > 0L) {
          break label414;
        }
        localObject1 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
        if (localObject1 != null) {
          break label404;
        }
        i = j;
      }
    }
    label221:
    for (Object localObject1 = Integer.valueOf(i * 1000);; localObject1 = Long.valueOf(l))
    {
      ((JSONObject)localObject2).put("duration", localObject1);
      localObject1 = (ce)h.ax(ce.class);
      String str = q.bj.DBi.event;
      localObject2 = ((JSONObject)localObject2).toString();
      s.s(localObject2, "this.toString()");
      ((ce)localObject1).hP(str, (String)localObject2);
      this.FkB = null;
      h(null);
      localObject1 = this.FkI;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.replay.widget.c)localObject1).release();
      }
      this.FkI = null;
      localObject1 = this.FkC;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.replay.widget.b)localObject1).release();
      }
      this.FkH.clear();
      localObject1 = (com.tencent.mm.plugin.finder.replay.viewmodel.a)business(com.tencent.mm.plugin.finder.replay.viewmodel.a.class);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.replay.viewmodel.a)localObject1).eLV();
      }
      AppMethodBeat.o(332907);
      return;
      label371:
      l = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject2).getLiveInfo().liveId;
      break;
      i = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject2).offset;
      break label144;
      l = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject1).eLY();
      break label172;
      i = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject1).offset;
      break label221;
    }
  }
  
  public final r<com.tencent.mm.plugin.finder.replay.widget.c, Boolean> a(long paramLong, com.tencent.mm.plugin.finder.replay.widget.c paramc)
  {
    AppMethodBeat.i(332850);
    Object localObject = paramc;
    if (paramLong != 0L)
    {
      localObject = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (localObject != null) {
        break label76;
      }
    }
    label76:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject).getLiveInfo().liveId)
    {
      localObject = paramc;
      if (paramLong == l) {
        localObject = this.FkI;
      }
      if (localObject == null) {
        break;
      }
      paramc = new r(localObject, Boolean.TRUE);
      AppMethodBeat.o(332850);
      return paramc;
    }
    paramc = MMApplicationContext.getContext();
    s.s(paramc, "getContext()");
    paramc = new com.tencent.mm.plugin.finder.replay.widget.c(paramc, paramLong);
    paramc.Fni.setVideoViewCallback((i.b)eLA());
    paramc.Fni.setLifecycle((ab)eLB());
    paramc.a((as.c)new c(this));
    paramc = new r(paramc, Boolean.FALSE);
    AppMethodBeat.o(332850);
    return paramc;
  }
  
  public final void a(long paramLong, bug parambug, boolean paramBoolean)
  {
    AppMethodBeat.i(332824);
    s.u(parambug, "baseData");
    if (paramBoolean)
    {
      parambug = this.FkC;
      if (parambug != null) {
        parambug.bfQ();
      }
      parambug = this.Fkz;
      if (parambug != null)
      {
        parambug.FlU = new r(Long.valueOf(paramLong), Boolean.TRUE);
        AppMethodBeat.o(332824);
      }
    }
    else
    {
      B(paramLong, true);
      com.tencent.mm.plugin.finder.replay.model.c localc = new com.tencent.mm.plugin.finder.replay.model.c();
      localc.a(parambug);
      localc.PV(parambug.aabZ);
      c.a locala = com.tencent.mm.plugin.finder.replay.model.c.FlS;
      localc.an(c.a.b(parambug));
      localc.FlU = null;
      av(localc.Ebx);
      parambug = ah.aiuX;
      a(localc);
    }
    AppMethodBeat.o(332824);
  }
  
  public final void a(aw paramaw)
  {
    AppMethodBeat.i(332888);
    s.u(paramaw, "proxy");
    Log.i("FinderLiveReplayService", s.X("registerSeiProcessViewCallbackProxy:", Integer.valueOf(paramaw.hashCode())));
    this.FkH.add(paramaw);
    AppMethodBeat.o(332888);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.finder.replay.model.a parama1)
  {
    Object localObject1 = null;
    AppMethodBeat.i(332837);
    s.u(parama, "buContext");
    s.u(parama1, "config");
    h(parama);
    Object localObject2 = this.FkA;
    s.u(parama1, "newConfig");
    ((com.tencent.mm.plugin.finder.replay.model.a)localObject2).FlP = parama1.FlP;
    ((com.tencent.mm.plugin.finder.replay.model.a)localObject2).FlQ = parama1.FlQ;
    label134:
    Object localObject3;
    int i;
    if (this.FkA.FlQ)
    {
      parama1 = com.tencent.mm.ui.component.k.aeZF;
      parama1 = (com.tencent.mm.plugin.finder.replay.viewmodel.b)com.tencent.mm.ui.component.k.cn(cn.class).q(com.tencent.mm.plugin.finder.replay.viewmodel.b.class);
      long l = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)parama.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).getLiveInfo().liveId;
      parama1 = (g)parama1.FmJ.get(Long.valueOf(l));
      if (parama1 == null)
      {
        parama1 = null;
        if (parama1 != null) {
          break label314;
        }
        parama = null;
        if (this.FkA.FlP) {
          eLC();
        }
        parama1 = this.FkC;
        if (parama1 != null) {
          parama1.x(this.CDN);
        }
        parama1 = (com.tencent.mm.plugin.finder.live.business.a)business(com.tencent.mm.plugin.finder.live.business.a.class);
        if (parama1 != null)
        {
          localObject2 = (aw)this.FkG.getValue();
          localObject3 = parama1.getTAG();
          if (localObject2 == null) {
            break label386;
          }
          i = localObject2.hashCode();
          label214:
          Log.i((String)localObject3, s.X("set SeiProcessViewCallback:", Integer.valueOf(i)));
          parama1.CuL = ((aw)localObject2);
        }
        localObject2 = new StringBuilder("setData:");
        parama1 = this.CDN;
        if (parama1 != null) {
          break label391;
        }
        parama1 = localObject1;
      }
    }
    for (;;)
    {
      Log.i("FinderLiveReplayService", parama1 + " logicConfig:" + this.FkA + ' ' + parama);
      AppMethodBeat.o(332837);
      return;
      parama1 = Integer.valueOf(parama1.offset);
      break;
      label314:
      i = ((Number)parama1).intValue();
      parama1 = "change offset:" + ((com.tencent.mm.plugin.finder.replay.viewmodel.c)parama.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).offset + " to " + i;
      ((com.tencent.mm.plugin.finder.replay.viewmodel.c)parama.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).wj(i);
      parama = parama1;
      break label134;
      parama = "";
      break label134;
      label386:
      i = 0;
      break label214;
      label391:
      localObject3 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)parama1.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      parama1 = localObject1;
      if (localObject3 != null) {
        parama1 = Long.valueOf(((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject3).getLiveInfo().liveId);
      }
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(332881);
    s.u(paramb, "liveMsgOffsetProcess");
    this.FkJ = paramb;
    AppMethodBeat.o(332881);
  }
  
  public final void a(com.tencent.mm.plugin.finder.replay.widget.e parame)
  {
    AppMethodBeat.i(332842);
    this.FkB = parame;
    if (parame == null)
    {
      parame = null;
      this.FkI = parame;
      parame = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (parame != null) {
        break label165;
      }
    }
    label165:
    for (long l = 0L;; l = parame.enterTime)
    {
      if (l <= 0L)
      {
        parame = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
        if (parame != null) {
          parame.enterTime = SystemClock.elapsedRealtime();
        }
      }
      parame = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (parame != null) {
        parame.a(com.tencent.mm.live.core.core.model.i.e.mOf);
      }
      parame = this.FkB;
      if (parame != null) {
        parame.setUIClickListener((f.a)new e(this));
      }
      Log.i("FinderLiveReplayService", s.X("setFullScreenUI:", eLD()));
      AppMethodBeat.o(332842);
      return;
      parame = (com.tencent.mm.plugin.finder.replay.plugin.d)parame.bf(com.tencent.mm.plugin.finder.replay.plugin.d.class);
      if (parame == null)
      {
        parame = null;
        break;
      }
      parame = parame.Fmd;
      break;
    }
  }
  
  public final void aH(Intent paramIntent)
  {
    Object localObject1 = null;
    AppMethodBeat.i(332866);
    s.u(paramIntent, "intent");
    eLC();
    Object localObject2 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
    int i;
    if ((localObject2 != null) && (((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject2).bex() == true))
    {
      i = 1;
      if (i == 0) {
        break label221;
      }
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject2).eyK() != true)) {
        break label208;
      }
      i = 1;
      label78:
      if (i != 0) {
        break label221;
      }
      localObject2 = new ImageView(MMApplicationContext.getContext());
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 != null) {
        break label213;
      }
    }
    label208:
    label213:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).DVR)
    {
      ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
      localObject1 = this.FkC;
      if (localObject1 != null)
      {
        localObject2 = (View)localObject2;
        s.u(localObject2, "view");
        ((com.tencent.mm.plugin.finder.replay.widget.b)localObject1).eMa().dc((View)localObject2);
      }
      a(this, paramIntent);
      paramIntent = this.FkC;
      if (paramIntent != null) {
        paramIntent.elR();
      }
      paramIntent = this.FkB;
      if (paramIntent != null) {
        paramIntent.dmh();
      }
      this.FkB = null;
      AppMethodBeat.o(332866);
      return;
      i = 0;
      break;
      i = 0;
      break label78;
    }
    label221:
    localObject2 = this.FkI;
    if (localObject2 == null)
    {
      paramIntent = (Intent)localObject1;
      if (paramIntent == null) {
        Log.e("FinderLiveReplayService", "startReplayMiniUI playerWidget is null," + eLD() + '!');
      }
      AppMethodBeat.o(332866);
      return;
    }
    a(this, paramIntent);
    paramIntent = ((com.tencent.mm.plugin.finder.replay.widget.c)localObject2).Fni.getVideoMediaInfo();
    label296:
    Object localObject3;
    if (paramIntent == null)
    {
      paramIntent = null;
      localObject1 = paramIntent;
      if (paramIntent == null) {
        localObject1 = new Size(0, 0);
      }
      paramIntent = this.FkC;
      if (paramIntent != null)
      {
        localObject3 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject3).a(com.tencent.mm.live.core.core.model.i.e.mOg);
        }
        localObject3 = (ViewGroup)paramIntent.eMa().mUL;
        paramIntent = (com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
        if ((paramIntent == null) || (paramIntent.mNQ != true)) {
          break label479;
        }
        i = 1;
        label381:
        if (i == 0) {
          break label484;
        }
      }
    }
    label479:
    label484:
    for (paramIntent = com.tencent.mm.pluginsdk.ui.i.e.XYM;; paramIntent = com.tencent.mm.pluginsdk.ui.i.e.XYN)
    {
      ((com.tencent.mm.plugin.finder.replay.widget.c)localObject2).a((ViewGroup)localObject3, null, (Size)localObject1, paramIntent, true);
      paramIntent = this.FkC;
      if (paramIntent != null) {
        paramIntent.elR();
      }
      paramIntent = this.FkB;
      if (paramIntent != null) {
        paramIntent.dmh();
      }
      this.FkB = null;
      paramIntent = ah.aiuX;
      break;
      paramIntent = paramIntent.ANK;
      if (paramIntent == null)
      {
        paramIntent = null;
        break label296;
      }
      paramIntent = paramIntent.eCF();
      if (paramIntent == null)
      {
        paramIntent = null;
        break label296;
      }
      paramIntent = i.a(paramIntent, true);
      break label296;
      i = 0;
      break label381;
    }
  }
  
  public final void b(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(332874);
    com.tencent.mm.plugin.finder.replay.widget.b localb = this.FkC;
    if (localb != null) {
      localb.b(paramInt, paramJSONObject, paramBoolean);
    }
    AppMethodBeat.o(332874);
  }
  
  public final void b(aw paramaw)
  {
    AppMethodBeat.i(332895);
    s.u(paramaw, "proxy");
    Log.i("FinderLiveReplayService", s.X("unregisterSeiProcessViewCallbackProxy:", Integer.valueOf(paramaw.hashCode())));
    this.FkH.remove(paramaw);
    AppMethodBeat.o(332895);
  }
  
  public final <T extends af> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(332817);
    s.u(paramClass, "bu");
    com.tencent.mm.plugin.finder.live.model.context.a locala = this.CDN;
    if (locala == null)
    {
      AppMethodBeat.o(332817);
      return null;
    }
    paramClass = locala.business(paramClass);
    AppMethodBeat.o(332817);
    return paramClass;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayService$Companion;", "", "()V", "TAG", "", "VIDEO_COMPLETE", "", "VIDEO_STOP", "sInstance", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayService;", "getInstance", "tryRelease", "", "tryUpdateMiniWindow", "sourceType", "micData", "Lorg/json/JSONObject;", "checkDiff", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean c(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
    {
      AppMethodBeat.i(332533);
      if (k.eLE() != null)
      {
        k localk = k.eLE();
        if (localk != null) {
          localk.b(paramInt, paramJSONObject, paramBoolean);
        }
        AppMethodBeat.o(332533);
        return true;
      }
      AppMethodBeat.o(332533);
      return false;
    }
    
    public static boolean eLG()
    {
      AppMethodBeat.i(332526);
      if (k.eLE() != null)
      {
        k localk = k.eLE();
        Object localObject;
        long l;
        if (localk != null)
        {
          localObject = k.eLE();
          if (localObject != null) {
            break label42;
          }
          l = 0L;
        }
        for (;;)
        {
          localk.B(l, true);
          AppMethodBeat.o(332526);
          return true;
          label42:
          localObject = (com.tencent.mm.plugin.finder.replay.viewmodel.c)((k)localObject).business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
          if (localObject == null) {
            l = 0L;
          } else {
            l = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject).getLiveInfo().liveId;
          }
        }
      }
      AppMethodBeat.o(332526);
      return false;
    }
    
    public final k eLF()
    {
      AppMethodBeat.i(332546);
      if (k.eLE() == null) {}
      try
      {
        if (k.eLE() == null)
        {
          localObject1 = k.Fky;
          k.b(new k());
        }
        Object localObject1 = ah.aiuX;
        localObject1 = k.eLE();
        s.checkNotNull(localObject1);
        AppMethodBeat.o(332546);
        return localObject1;
      }
      finally
      {
        AppMethodBeat.o(332546);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayMiniView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.replay.widget.b>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/replay/FinderLiveReplayService$playerGenerator$1", "Lcom/tencent/mm/plugin/finder/live/model/LiveSeiCallback$ReplayCallback;", "onAnchorInfoCallback", "", "params", "Landroid/os/Bundle;", "onLinkMicCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements as.c
  {
    c(k paramk) {}
    
    public final void ao(Bundle paramBundle)
    {
      AppMethodBeat.i(332512);
      s.u(paramBundle, "params");
      com.tencent.mm.plugin.finder.live.business.a locala = (com.tencent.mm.plugin.finder.live.business.a)this.FkL.business(com.tencent.mm.plugin.finder.live.business.a.class);
      if (locala != null)
      {
        e.g localg = e.g.mKv;
        locala.onLiveEventCallback(e.g.bda(), paramBundle);
      }
      AppMethodBeat.o(332512);
    }
    
    public final void ap(Bundle paramBundle)
    {
      AppMethodBeat.i(332508);
      s.u(paramBundle, "params");
      com.tencent.mm.plugin.finder.live.business.a locala = (com.tencent.mm.plugin.finder.live.business.a)this.FkL.business(com.tencent.mm.plugin.finder.live.business.a.class);
      if (locala != null)
      {
        e.g localg = e.g.mKv;
        locala.onLiveEventCallback(e.g.bcY(), paramBundle);
      }
      AppMethodBeat.o(332508);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/replay/FinderLiveReplayService$seiProcessViewCallback$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<1>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/replay/FinderLiveReplayService$setFullScreenUI$1", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;", "onCloseClick", "", "onOrientationClick", "onPlayBtnClick", "play", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements f.a
  {
    e(k paramk) {}
    
    public final void eLH()
    {
      AppMethodBeat.i(332511);
      Object localObject = this.FkL.FkB;
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.replay.widget.e)localObject).getUIContext() != null))
      {
        localObject = this.FkL;
        Intent localIntent = new Intent();
        localIntent.putExtra("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
        ah localah = ah.aiuX;
        ((k)localObject).aH(localIntent);
      }
      AppMethodBeat.o(332511);
    }
    
    public final void eqV()
    {
      AppMethodBeat.i(332507);
      k localk = this.FkL;
      com.tencent.mm.plugin.finder.replay.viewmodel.c localc = (com.tencent.mm.plugin.finder.replay.viewmodel.c)this.FkL.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (localc == null) {}
      for (long l = 0L;; l = localc.getLiveInfo().liveId)
      {
        localk.B(l, true);
        AppMethodBeat.o(332507);
        return;
      }
    }
    
    public final void tv(boolean paramBoolean)
    {
      AppMethodBeat.i(332515);
      com.tencent.mm.plugin.finder.replay.viewmodel.c localc = (com.tencent.mm.plugin.finder.replay.viewmodel.c)this.FkL.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (localc == null) {}
      for (int i = 0;; i = localc.offset)
      {
        Log.i("FinderLiveReplayService", "onPlayBtnClick start to play?:" + paramBoolean + ",offset:" + i);
        if (paramBoolean) {
          k.a(this.FkL, i);
        }
        AppMethodBeat.o(332515);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/replay/FinderLiveReplayService$videoPlayLifecycle$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<1>
  {
    f(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/finder/replay/FinderLiveReplayService$videoViewCallback$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<1>
  {
    g(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.k
 * JD-Core Version:    0.7.0.1
 */