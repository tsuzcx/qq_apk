package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.frameset.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.surface.view.SurfaceAppContainer;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameDynamicFrameSetPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "entranceRoot", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "currentFrameSetParamList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetLayoutParam;", "Lkotlin/collections/ArrayList;", "getCurrentFrameSetParamList", "()Ljava/util/ArrayList;", "setCurrentFrameSetParamList", "(Ljava/util/ArrayList;)V", "filteredFrameSetList", "getFilteredFrameSetList", "setFilteredFrameSetList", "framePluginList", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameDynamicFramePlugin;", "getFramePluginList", "setFramePluginList", "idsMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getIdsMap", "()Ljava/util/HashMap;", "setIdsMap", "(Ljava/util/HashMap;)V", "lastCheckTime", "", "getLastCheckTime", "()J", "setLastCheckTime", "(J)V", "lastFrameGameData", "getLastFrameGameData", "()Ljava/lang/String;", "setLastFrameGameData", "(Ljava/lang/String;)V", "lastUpdateGameDataTime", "getLastUpdateGameDataTime", "setLastUpdateGameDataTime", "loadDataCount", "getLoadDataCount", "()I", "setLoadDataCount", "(I)V", "pluginsMap", "getPluginsMap", "setPluginsMap", "surfaceMgr", "Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr;", "getSurfaceMgr", "()Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr;", "setSurfaceMgr", "(Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr;)V", "canClearScreen", "", "checkFrameSetRoot", "", "checkFrameSetVisible", "frameSetParamList", "game_frameset_visibility", "checkVisible", "createFrameView", "Landroid/widget/FrameLayout;", "frameSetParam", "dispatchGameData", "gameDataJson", "getFinderLiveFrameSetLayoutParam", "id", "getFrameSetParentId", "hidePlugins", "loadFrameSetData", "mount", "notifyGameData", "gameData", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameData;", "pause", "resume", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateFrameView", "layoutParam", "Landroid/widget/RelativeLayout$LayoutParams;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class an
  extends b
{
  private final ViewGroup CZa;
  private ArrayList<com.tencent.mm.plugin.finder.live.model.frameset.b> CZc;
  private ArrayList<com.tencent.mm.plugin.finder.live.model.frameset.b> CZd;
  private ArrayList<am> CZe;
  private HashMap<String, Integer> CZf;
  private HashMap<String, am> CZg;
  public c CZh;
  private String CZi;
  private int CZj;
  private long CZk;
  private final String TAG;
  private long lastCheckTime;
  private final com.tencent.mm.live.b.b nfT;
  
  public an(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355880);
    this.CZa = paramViewGroup;
    this.nfT = paramb;
    this.TAG = "MicroMsg.FinderLiveGameDynamicFrameSetPlugin";
    this.CZc = new ArrayList();
    this.CZd = new ArrayList();
    this.CZe = new ArrayList();
    this.CZf = new HashMap();
    this.CZg = new HashMap();
    eqh();
    AppMethodBeat.o(355880);
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams, com.tencent.mm.plugin.finder.live.model.frameset.b paramb)
  {
    AppMethodBeat.i(355926);
    s.u(paramLayoutParams, "layoutParam");
    s.u(paramb, "frameSetParam");
    paramLayoutParams.width = paramb.width;
    paramLayoutParams.height = paramb.height;
    paramLayoutParams.leftMargin = paramb.uLf;
    paramLayoutParams.rightMargin = paramb.uLg;
    paramLayoutParams.topMargin = paramb.CMA;
    paramLayoutParams.bottomMargin = paramb.CMB;
    Object localObject = paramLayoutParams.getRules();
    label90:
    int k;
    if (localObject != null)
    {
      if (localObject.length != 0) {
        break label313;
      }
      i = 1;
      if (i != 0) {
        break label318;
      }
      i = 1;
      if (i != 0)
      {
        k = localObject.length - 1;
        if (k < 0) {}
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (Build.VERSION.SDK_INT >= 17) {
        paramLayoutParams.removeRule(i);
      }
      if (j > k)
      {
        if (paramb.CMC) {
          paramLayoutParams.addRule(10);
        }
        if (paramb.CMD) {
          paramLayoutParams.addRule(9);
        }
        if (paramb.CME) {
          paramLayoutParams.addRule(11);
        }
        if (paramb.CMF) {
          paramLayoutParams.addRule(12);
        }
        if (paramb.CMG) {
          paramLayoutParams.addRule(20);
        }
        if (paramb.CMH) {
          paramLayoutParams.addRule(21);
        }
        if (paramb.CMI) {
          paramLayoutParams.addRule(13);
        }
        if (paramb.CMK) {
          paramLayoutParams.addRule(15);
        }
        if (paramb.CMJ) {
          paramLayoutParams.addRule(14);
        }
        if ((!TextUtils.isEmpty((CharSequence)paramb.CMM)) && (this.CZf.containsKey(paramb.CMM)))
        {
          localObject = this.CZf.get(paramb.CMM);
          if (localObject == null)
          {
            paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(355926);
            throw paramLayoutParams;
            label313:
            i = 0;
            break;
            label318:
            i = 0;
            break label90;
          }
          paramLayoutParams.addRule(6, ((Integer)localObject).intValue());
        }
        if ((!TextUtils.isEmpty((CharSequence)paramb.CMN)) && (this.CZf.containsKey(paramb.CMN)))
        {
          localObject = this.CZf.get(paramb.CMN);
          if (localObject == null)
          {
            paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(355926);
            throw paramLayoutParams;
          }
          paramLayoutParams.addRule(8, ((Integer)localObject).intValue());
        }
        if ((!TextUtils.isEmpty((CharSequence)paramb.CMO)) && (this.CZf.containsKey(paramb.CMO)))
        {
          localObject = this.CZf.get(paramb.CMO);
          if (localObject == null)
          {
            paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(355926);
            throw paramLayoutParams;
          }
          paramLayoutParams.addRule(5, ((Integer)localObject).intValue());
        }
        if ((!TextUtils.isEmpty((CharSequence)paramb.CMP)) && (this.CZf.containsKey(paramb.CMP)))
        {
          localObject = this.CZf.get(paramb.CMP);
          if (localObject == null)
          {
            paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(355926);
            throw paramLayoutParams;
          }
          paramLayoutParams.addRule(7, ((Integer)localObject).intValue());
        }
        if ((!TextUtils.isEmpty((CharSequence)paramb.CMQ)) && (this.CZf.containsKey(paramb.CMQ)))
        {
          localObject = this.CZf.get(paramb.CMQ);
          if (localObject == null)
          {
            paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(355926);
            throw paramLayoutParams;
          }
          paramLayoutParams.addRule(3, ((Integer)localObject).intValue());
        }
        if ((!TextUtils.isEmpty((CharSequence)paramb.CMR)) && (this.CZf.containsKey(paramb.CMR)))
        {
          localObject = this.CZf.get(paramb.CMR);
          if (localObject == null)
          {
            paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(355926);
            throw paramLayoutParams;
          }
          paramLayoutParams.addRule(2, ((Integer)localObject).intValue());
        }
        if ((!TextUtils.isEmpty((CharSequence)paramb.CMS)) && (this.CZf.containsKey(paramb.CMS)))
        {
          localObject = this.CZf.get(paramb.CMS);
          if (localObject == null)
          {
            paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(355926);
            throw paramLayoutParams;
          }
          paramLayoutParams.addRule(0, ((Integer)localObject).intValue());
        }
        if ((!TextUtils.isEmpty((CharSequence)paramb.CMT)) && (this.CZf.containsKey(paramb.CMT)))
        {
          localObject = this.CZf.get(paramb.CMT);
          if (localObject == null)
          {
            paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(355926);
            throw paramLayoutParams;
          }
          paramLayoutParams.addRule(1, ((Integer)localObject).intValue());
        }
        if ((!TextUtils.isEmpty((CharSequence)paramb.CMU)) && (this.CZf.containsKey(paramb.CMU)))
        {
          localObject = this.CZf.get(paramb.CMU);
          if (localObject == null)
          {
            paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(355926);
            throw paramLayoutParams;
          }
          paramLayoutParams.addRule(16, ((Integer)localObject).intValue());
        }
        if ((!TextUtils.isEmpty((CharSequence)paramb.CMV)) && (this.CZf.containsKey(paramb.CMV)))
        {
          paramb = this.CZf.get(paramb.CMV);
          if (paramb == null)
          {
            paramLayoutParams = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(355926);
            throw paramLayoutParams;
          }
          paramLayoutParams.addRule(17, ((Integer)paramb).intValue());
        }
        AppMethodBeat.o(355926);
        return;
      }
    }
  }
  
  private final com.tencent.mm.plugin.finder.live.model.frameset.b awS(String paramString)
  {
    AppMethodBeat.i(355903);
    Iterator localIterator = this.CZd.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.live.model.frameset.b localb = (com.tencent.mm.plugin.finder.live.model.frameset.b)localIterator.next();
      if (paramString.equals(localb.id))
      {
        AppMethodBeat.o(355903);
        return localb;
      }
    }
    AppMethodBeat.o(355903);
    return null;
  }
  
  private final void awT(String paramString)
  {
    AppMethodBeat.i(355938);
    Log.i(this.TAG, "notifyGameData");
    Object localObject = this.CZh;
    if (localObject != null)
    {
      localObject = ((c)localObject).CMX;
      if (localObject != null) {
        ((com.tencent.mm.plugin.surface.c.f)localObject).bdb(paramString);
      }
    }
    AppMethodBeat.o(355938);
  }
  
  private final void eqh()
  {
    AppMethodBeat.i(355891);
    this.CZj += 1;
    Object localObject = com.tencent.mm.plugin.finder.live.model.frameset.a.CMr;
    localObject = com.tencent.mm.plugin.finder.live.model.frameset.a.emZ();
    if ((((ArrayList)localObject).isEmpty()) || (((ArrayList)localObject).size() == 0))
    {
      Log.e(this.TAG, "loadFrameSetData frameSetParamList is empty");
      super.tO(8);
      AppMethodBeat.o(355891);
      return;
    }
    com.tencent.mm.plugin.finder.live.model.frameset.a locala = com.tencent.mm.plugin.finder.live.model.frameset.a.CMr;
    localObject = com.tencent.mm.plugin.finder.live.model.frameset.a.i(eqi(), (ArrayList)localObject);
    if ((((ArrayList)localObject).isEmpty()) || (((ArrayList)localObject).size() == 0))
    {
      Log.e(this.TAG, "loadFrameSetData filteredFrameSetList is empty， parentId:%s", new Object[] { eqi() });
      super.tO(8);
      AppMethodBeat.o(355891);
      return;
    }
    this.CZc.clear();
    this.CZc.addAll((Collection)localObject);
    AppMethodBeat.o(355891);
  }
  
  public final void a(bgz parambgz)
  {
    AppMethodBeat.i(356049);
    s.u(parambgz, "gameData");
    parambgz = parambgz.ZQv;
    if (parambgz == null) {}
    long l;
    for (parambgz = null;; parambgz = parambgz.toString("UTF-8"))
    {
      l = System.currentTimeMillis();
      if ((s.p(this.CZi, parambgz)) || (parambgz == null)) {
        break;
      }
      this.CZi = parambgz;
      awT(parambgz);
      this.CZk = l;
      AppMethodBeat.o(356049);
      return;
    }
    if ((parambgz != null) && (l - this.CZk > 10000L))
    {
      awT(parambgz);
      this.CZk = l;
      AppMethodBeat.o(356049);
      return;
    }
    if (parambgz != null)
    {
      Log.v(this.TAG, "skip same game data");
      AppMethodBeat.o(356049);
      return;
    }
    Log.v(this.TAG, "game data is invalid");
    AppMethodBeat.o(356049);
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(356027);
    bgz localbgz = ((e)business(e.class)).Edj;
    if (localbgz == null)
    {
      super.tO(8);
      Log.e(this.TAG, "liveGameData is null");
      AppMethodBeat.o(356027);
      return;
    }
    if (!localbgz.ZQx)
    {
      Log.e(this.TAG, "liveGameData updated is false");
      AppMethodBeat.o(356027);
      return;
    }
    int i = localbgz.ZQw;
    if (localbgz.ZQw == 0)
    {
      Log.e(this.TAG, "game_frameset_visibility is 0");
      super.tO(8);
      AppMethodBeat.o(356027);
      return;
    }
    Log.i(this.TAG, "liveGameData game_frameset_visibility:%d, origin game_frameset_visibility:%d", new Object[] { Integer.valueOf(localbgz.ZQw), Integer.valueOf(i) });
    if ((this.CZc.isEmpty()) || (this.CZc.size() == 0))
    {
      Log.e(this.TAG, "filteredFrameSetList is empty， parentId:%s", new Object[] { eqi() });
      super.tO(8);
      if (this.CZj < 5) {
        eqh();
      }
      AppMethodBeat.o(356027);
      return;
    }
    this.CZj = 0;
    if (this.CZh == null)
    {
      super.tO(8);
      Log.e(this.TAG, "surfaceMgr is null");
      AppMethodBeat.o(356027);
      return;
    }
    Object localObject1 = this.CZh;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject1 = ((e)business(e.class)).mIC;
        localObject2 = this.CZh;
        if (localObject2 != null)
        {
          localObject3 = this.mJe.getContext();
          s.s(localObject3, "root.context");
          ((c)localObject2).a(this, (Context)localObject3, (String)localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN);
        }
      }
      localObject1 = this.CZh;
      if (localObject1 != null) {
        break label363;
      }
    }
    label363:
    for (localObject1 = null;; localObject1 = ((c)localObject1).CMX)
    {
      if (localObject1 != null) {
        break label371;
      }
      super.tO(8);
      Log.e(this.TAG, "getFrameSetRoot is null");
      AppMethodBeat.o(356027);
      return;
      localObject1 = ((c)localObject1).CMX;
      break;
    }
    label371:
    Object localObject2 = this.CZc;
    i = localbgz.ZQw;
    localObject1 = new ArrayList();
    Object localObject4 = new ArrayList();
    Object localObject3 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (com.tencent.mm.plugin.finder.live.model.frameset.b)((Iterator)localObject3).next();
      if ((((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).CMz & i) == 0)
      {
        ((ArrayList)localObject1).add(localObject5);
        Log.i(this.TAG, "frameset id:%s is invisible, remove it", new Object[] { ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).id });
      }
      else
      {
        localObject5 = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).id;
        s.checkNotNull(localObject5);
        ((ArrayList)localObject4).add(localObject5);
      }
    }
    ((ArrayList)localObject2).removeAll((Collection)localObject1);
    localObject3 = ((Iterable)localObject1).iterator();
    Object localObject6;
    Object localObject7;
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (com.tencent.mm.plugin.finder.live.model.frameset.b)((Iterator)localObject3).next();
      localObject6 = (Map)this.CZg;
      localObject7 = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).id;
      if (localObject6 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(356027);
        throw ((Throwable)localObject1);
      }
      localObject6 = (am)kotlin.g.b.an.hJ(localObject6).remove(localObject7);
      if (localObject6 != null) {
        ((am)localObject6).unMount();
      }
      localObject7 = (Collection)this.CZe;
      if (localObject7 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(356027);
        throw ((Throwable)localObject1);
      }
      kotlin.g.b.an.hA(localObject7).remove(localObject6);
      localObject6 = (Map)this.CZf;
      localObject7 = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).id;
      if (localObject6 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(356027);
        throw ((Throwable)localObject1);
      }
      kotlin.g.b.an.hJ(localObject6).remove(localObject7);
      Log.i(this.TAG, "remove frame plugin id:%s from invisible removeList", new Object[] { ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).id });
    }
    ((ArrayList)localObject1).clear();
    localObject3 = new ArrayList();
    Object localObject5 = ((Iterable)this.CZd).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (com.tencent.mm.plugin.finder.live.model.frameset.b)((Iterator)localObject5).next();
      if (p.a((Iterable)localObject4, ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject6).id))
      {
        localObject6 = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject6).id;
        s.checkNotNull(localObject6);
        ((ArrayList)localObject3).add(localObject6);
      }
      else
      {
        ((ArrayList)localObject1).add(localObject6);
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (com.tencent.mm.plugin.finder.live.model.frameset.b)((Iterator)localObject1).next();
      localObject5 = (Map)this.CZg;
      localObject6 = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject4).id;
      if (localObject5 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(356027);
        throw ((Throwable)localObject1);
      }
      localObject5 = (am)kotlin.g.b.an.hJ(localObject5).remove(localObject6);
      if (localObject5 != null) {
        ((am)localObject5).unMount();
      }
      localObject6 = (Collection)this.CZe;
      if (localObject6 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(356027);
        throw ((Throwable)localObject1);
      }
      kotlin.g.b.an.hA(localObject6).remove(localObject5);
      localObject5 = (Map)this.CZf;
      localObject6 = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject4).id;
      if (localObject5 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(356027);
        throw ((Throwable)localObject1);
      }
      kotlin.g.b.an.hJ(localObject5).remove(localObject6);
      this.CZd.remove(localObject4);
      this.CZc.remove(localObject4);
      Log.i(this.TAG, "remove frame plugin id:%s from not contains currentFrameSetParamList", new Object[] { ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject4).id });
    }
    this.CZd.clear();
    this.CZd.addAll((Collection)localObject2);
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject4 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (com.tencent.mm.plugin.finder.live.model.frameset.b)((Iterator)localObject4).next();
        if (Build.VERSION.SDK_INT >= 17)
        {
          s.u(localObject5, "frameSetParam");
          localObject1 = this.CZa.getContext();
          s.s(localObject1, "entranceRoot.context");
          localObject6 = new SurfaceAppContainer((Context)localObject1, null, 6, (byte)0);
          localObject1 = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).id;
          s.checkNotNull(localObject1);
          ((SurfaceAppContainer)localObject6).bde((String)localObject1);
          i = View.generateViewId();
          ((SurfaceAppContainer)localObject6).setId(i);
          localObject1 = this.CZf;
          localObject7 = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).id;
          s.checkNotNull(localObject7);
          ((HashMap)localObject1).put(localObject7, Integer.valueOf(i));
          localObject1 = new RelativeLayout.LayoutParams(((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).width, ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).height);
          ((SurfaceAppContainer)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.CZa.addView((View)localObject6);
          a((RelativeLayout.LayoutParams)localObject1, (com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5);
          ((SurfaceAppContainer)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = this.CZh;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((c)localObject1).CMX)
          {
            s.checkNotNull(localObject1);
            SurfaceAppContainer.a((SurfaceAppContainer)localObject6, (com.tencent.mm.plugin.surface.c.f)localObject1);
            ((SurfaceAppContainer)localObject6).bringToFront();
            localObject1 = new am((ViewGroup)localObject6, this.nfT);
            ((am)localObject1).CZb = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5);
            localObject6 = this.CZg;
            localObject5 = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject5).id;
            s.checkNotNull(localObject5);
            ((HashMap)localObject6).put(localObject5, localObject1);
            this.CZe.add(localObject1);
            break;
          }
        }
      }
    }
    if (!((Collection)localObject3).isEmpty())
    {
      i = 1;
      if (i != 0) {
        localObject1 = ((Iterable)localObject3).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1524;
        }
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = (am)this.CZg.get(localObject3);
        if (localObject4 != null)
        {
          localObject4 = ((am)localObject4).CZa.getLayoutParams();
          if (localObject4 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(356027);
            throw ((Throwable)localObject1);
            i = 0;
            break;
          }
          localObject4 = (RelativeLayout.LayoutParams)localObject4;
          localObject3 = awS((String)localObject3);
          if (localObject3 != null) {
            a((RelativeLayout.LayoutParams)localObject4, (com.tencent.mm.plugin.finder.live.model.frameset.b)localObject3);
          }
        }
      }
    }
    label1524:
    Log.i(this.TAG, "framePluginList size :%d", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
    localObject1 = ((Iterable)this.CZe).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (am)((Iterator)localObject1).next();
      Log.i(this.TAG, "plugin hasCode:%d", new Object[] { Integer.valueOf(((am)localObject2).hashCode()) });
      ((am)localObject2).eoD();
    }
    if (this.CZd.size() > 0)
    {
      tO(0);
      a(localbgz);
      AppMethodBeat.o(356027);
      return;
    }
    Log.e(this.TAG, "check currentFrameSetParamList empty");
    tO(8);
    AppMethodBeat.o(356027);
  }
  
  public final boolean eoI()
  {
    AppMethodBeat.i(355947);
    boolean bool = super.eoI();
    AppMethodBeat.o(355947);
    return bool;
  }
  
  public String eqi()
  {
    return "";
  }
  
  public final void eqj()
  {
    AppMethodBeat.i(356044);
    Iterator localIterator = ((Iterable)this.CZe).iterator();
    while (localIterator.hasNext()) {
      ((am)localIterator.next()).tO(8);
    }
    AppMethodBeat.o(356044);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355960);
    super.mount();
    AppMethodBeat.o(355960);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(355976);
    super.resume();
    Object localObject = this.CZh;
    if (localObject != null)
    {
      localObject = ((c)localObject).CMX;
      if (localObject != null) {
        ((com.tencent.mm.plugin.surface.c.f)localObject).pause();
      }
    }
    AppMethodBeat.o(355976);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(355970);
    super.resume();
    Object localObject = this.CZh;
    if (localObject != null)
    {
      localObject = ((c)localObject).CMX;
      if (localObject != null) {
        ((com.tencent.mm.plugin.surface.c.f)localObject).resume();
      }
    }
    AppMethodBeat.o(355970);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355984);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355984);
      return;
      long l = System.currentTimeMillis();
      if ((l - this.lastCheckTime > 3000L) && (this.CZe.size() == 0))
      {
        this.lastCheckTime = l;
        d.a(1000L, (kotlin.g.a.a)new b(this));
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(355953);
    super.tO(paramInt);
    AppMethodBeat.o(355953);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355994);
    super.unMount();
    this.CZc.clear();
    this.CZd.clear();
    this.CZf.clear();
    Object localObject = ((Iterable)this.CZe).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    this.CZe.clear();
    this.CZg.clear();
    localObject = this.CZh;
    if (localObject != null) {
      ((c)localObject).unMount();
    }
    AppMethodBeat.o(355994);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(an paraman)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.an
 * JD-Core Version:    0.7.0.1
 */