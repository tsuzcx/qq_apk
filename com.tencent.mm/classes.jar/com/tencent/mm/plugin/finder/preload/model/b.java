package com.tencent.mm.plugin.finder.preload.model;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bbp;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "", "()V", "assignSpec", "", "getAssignSpec", "()Ljava/lang/String;", "setAssignSpec", "(Ljava/lang/String;)V", "canPreCreatedPlayer", "", "getCanPreCreatedPlayer", "()Z", "setCanPreCreatedPlayer", "(Z)V", "findSpecStepMap", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "", "getFindSpecStepMap", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "hotMediaSet", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadObjectInfo;", "getHotMediaSet", "()Ljava/util/concurrent/ConcurrentHashMap;", "setHotMediaSet", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "hotMegaVideoMediaSet", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFinderPreloadObjectInfo;", "getHotMegaVideoMediaSet", "setHotMegaVideoMediaSet", "isMoovFailReady2DownloadAll", "setMoovFailReady2DownloadAll", "isOpenMultiBitRateDownload", "isSecondPreload", "setSecondPreload", "maxBufferLength", "", "getMaxBufferLength", "()I", "setMaxBufferLength", "(I)V", "maxPreloadBitRate", "getMaxPreloadBitRate", "()J", "setMaxPreloadBitRate", "(J)V", "maxPreloadBytes", "getMaxPreloadBytes", "setMaxPreloadBytes", "maxPreloadPercent", "getMaxPreloadPercent", "setMaxPreloadPercent", "maxPreloadTaskCount", "getMaxPreloadTaskCount", "setMaxPreloadTaskCount", "megaVideoMaxBitrate", "getMegaVideoMaxBitrate", "setMegaVideoMaxBitrate", "megaVideoNextCount", "getMegaVideoNextCount", "setMegaVideoNextCount", "megaVideoPrevCount", "getMegaVideoPrevCount", "setMegaVideoPrevCount", "minBufferLength", "getMinBufferLength", "setMinBufferLength", "minCurrentFeedBufferLength", "getMinCurrentFeedBufferLength", "setMinCurrentFeedBufferLength", "nextCount", "getNextCount", "setNextCount", "playConcurrentCount", "getPlayConcurrentCount", "setPlayConcurrentCount", "preloadConcurrentCount", "getPreloadConcurrentCount", "setPreloadConcurrentCount", "preloadGlobalInfoFetcher", "Lcom/tencent/mm/plugin/finder/preload/PreloadGlobalInfoFetcher;", "getPreloadGlobalInfoFetcher", "()Lcom/tencent/mm/plugin/finder/preload/PreloadGlobalInfoFetcher;", "setPreloadGlobalInfoFetcher", "(Lcom/tencent/mm/plugin/finder/preload/PreloadGlobalInfoFetcher;)V", "preloadId", "getPreloadId", "setPreloadId", "prevCount", "getPrevCount", "setPrevCount", "reportMap", "startPreloadPercent", "getStartPreloadPercent", "setStartPreloadPercent", "startPreloadSecs", "getStartPreloadSecs", "setStartPreloadSecs", "findSpecInternal", "reqFormat", "maxBitRate", "specList", "Ljava/util/LinkedList;", "specType", "findTargetMedia", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedId", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "findTargetSpec", "isPreload", "commentScene", "getDefaultSpec", "isReport", "getSupportHdrSpecList", "initConfig", "onExitFinder", "", "queryPreloadDetail", "", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "source", "reportWithoutSpec", "defaultFileFormatV2", "targetFileFormat", "sortSpecList", "storePreloadInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "tranToH265IfEnable", "spec", "step", "updatePreloadInfo", "feedSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "Detail", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final boolean EVI;
  public static final a EVg;
  public final boolean EVA;
  public boolean EVB;
  public int EVC;
  public int EVD;
  public int EVE;
  private boolean EVF;
  private String EVG;
  public final ConcurrentHashMap<Long, Object> EVH;
  public com.tencent.mm.plugin.finder.preload.h EVh;
  public boolean EVi;
  public int EVj;
  public int EVk;
  public int EVl;
  public long EVm;
  public int EVn;
  public int EVo;
  public int EVp;
  public int EVq;
  public int EVr;
  public long EVs;
  public long EVt;
  public long EVu;
  public int EVv;
  public int EVw;
  private ConcurrentHashMap<String, btd> EVx;
  private ConcurrentHashMap<String, dnp> EVy;
  public final com.tencent.mm.b.h<String, kotlin.u<boz, String, Long>> EVz;
  
  static
  {
    AppMethodBeat.i(166482);
    EVg = new a((byte)0);
    EVI = com.tencent.mm.modelcontrol.e.wb(4);
    AppMethodBeat.o(166482);
  }
  
  public b()
  {
    AppMethodBeat.i(166481);
    this.EVh = new com.tencent.mm.plugin.finder.preload.h();
    this.EVj = 1;
    this.EVk = 4;
    this.EVl = kotlin.h.a.eH(30.000002F);
    this.EVm = 2097152L;
    this.EVn = 1;
    this.EVo = 1;
    this.EVp = 4;
    this.EVq = kotlin.h.a.eH(0.0F);
    this.EVv = 1;
    this.EVw = 2;
    this.EVx = new ConcurrentHashMap();
    this.EVy = new ConcurrentHashMap();
    this.EVz = new com.tencent.mm.b.h(300);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.EVA = com.tencent.mm.plugin.finder.storage.d.eRL();
    this.EVG = "";
    this.EVH = new ConcurrentHashMap();
    AppMethodBeat.o(166481);
  }
  
  private final kotlin.u<boz, String, Long> a(long paramLong, dji paramdji, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(346339);
    long l = this.EVs;
    if (EVI) {}
    Object localObject;
    for (String str = "h265";; str = "h264")
    {
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVh.aXc();
      localObject = paramdji.aaPs;
      s.s(localObject, "media.hdr_spec");
      localObject = a(str, l, aP((LinkedList)localObject), "HDR");
      if (localObject != null) {
        break label183;
      }
      localObject = (b)this;
      LinkedList localLinkedList = paramdji.spec;
      s.s(localLinkedList, "media.spec");
      localObject = ((b)localObject).a(str, l, aQ(localLinkedList), "SDR");
      if (localObject != null) {
        break;
      }
      localObject = (b)this;
      localLinkedList = paramdji.spec;
      s.s(localLinkedList, "media.spec");
      paramdji = ((b)localObject).a(str, localLinkedList, paramBoolean, paramLong, paramInt, paramdji);
      AppMethodBeat.o(346339);
      return paramdji;
    }
    AppMethodBeat.o(346339);
    return localObject;
    label183:
    AppMethodBeat.o(346339);
    return localObject;
  }
  
  private final kotlin.u<boz, String, Long> a(boz paramboz, String paramString, List<? extends boz> paramList, long paramLong)
  {
    AppMethodBeat.i(346391);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.eVf().bmg()).intValue() != 1) || (!EVI) || (!TextUtils.isEmpty((CharSequence)this.EVG)))
    {
      paramboz = new kotlin.u(paramboz, paramString, Long.valueOf(paramLong));
      AppMethodBeat.o(346391);
      return paramboz;
    }
    localObject = paramboz.hVy;
    String str = paramboz.hVy;
    if (s.p(str, com.tencent.mm.plugin.finder.storage.v.FLa.detail)) {
      if (paramList.isEmpty()) {
        paramboz.hVy = com.tencent.mm.plugin.finder.storage.v.FLc.detail;
      }
    }
    for (;;)
    {
      Log.i("Finder.MediaPreloadModel", "[tranToH265IfEnable] oldFormat:" + localObject + " , newFormat:" + paramboz.hVy);
      paramboz = new kotlin.u(paramboz, s.X(paramString, "+"), Long.valueOf(paramLong));
      AppMethodBeat.o(346391);
      return paramboz;
      paramboz.hVy = com.tencent.mm.plugin.finder.storage.v.FLa.detail;
      continue;
      if (s.p(str, com.tencent.mm.plugin.finder.storage.v.FLb.detail)) {
        paramboz.hVy = com.tencent.mm.plugin.finder.storage.v.FLc.detail;
      } else if (s.p(str, com.tencent.mm.plugin.finder.storage.v.FLd.detail)) {
        paramboz.hVy = com.tencent.mm.plugin.finder.storage.v.FLe.detail;
      } else if (s.p(str, com.tencent.mm.plugin.finder.storage.v.FLf.detail)) {
        paramboz.hVy = com.tencent.mm.plugin.finder.storage.v.FLg.detail;
      } else if (s.p(str, com.tencent.mm.plugin.finder.storage.v.FLh.detail)) {
        paramboz.hVy = com.tencent.mm.plugin.finder.storage.v.FLi.detail;
      } else if (s.p(str, com.tencent.mm.plugin.finder.storage.v.FLj.detail)) {
        paramboz.hVy = com.tencent.mm.plugin.finder.storage.v.FLk.detail;
      }
    }
  }
  
  private final kotlin.u<boz, String, Long> a(String paramString1, long paramLong, LinkedList<boz> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(346355);
    Object localObject1 = "step#0";
    Object localObject2;
    int i;
    if (!TextUtils.isEmpty((CharSequence)this.EVG))
    {
      localObject2 = ((Iterable)paramLinkedList).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        paramString1 = ((Iterator)localObject2).next();
        if ((s.p(((boz)paramString1).hVy, this.EVG)) && (!TextUtils.isEmpty((CharSequence)this.EVG)))
        {
          i = 1;
          label87:
          if (i == 0) {
            break label140;
          }
          label92:
          paramString1 = (boz)paramString1;
        }
      }
    }
    for (;;)
    {
      paramString2 = paramString2 + '.' + (String)localObject1;
      if (paramString1 != null) {
        break label554;
      }
      AppMethodBeat.o(346355);
      return null;
      i = 0;
      break label87;
      label140:
      break;
      paramString1 = null;
      break label92;
      localObject2 = "step#1";
      Object localObject3 = ((Iterable)paramLinkedList).iterator();
      label164:
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = ((Iterator)localObject3).next();
        boz localboz = (boz)localObject1;
        if ((n.T(localboz.EVK, paramString1, true)) && (localboz.ZPI < paramLong))
        {
          i = 1;
          label217:
          if (i == 0) {
            break label489;
          }
          label222:
          localObject1 = (boz)localObject1;
          if (localObject1 != null) {
            break label544;
          }
          localObject2 = "step#2";
          localObject1 = (List)paramLinkedList;
          localObject3 = ((List)localObject1).listIterator(((List)localObject1).size());
          while (((ListIterator)localObject3).hasPrevious())
          {
            localObject1 = ((ListIterator)localObject3).previous();
            if (n.T(((boz)localObject1).EVK, paramString1, true))
            {
              label297:
              localObject1 = (boz)localObject1;
              if (localObject1 != null) {
                break label534;
              }
              localObject3 = ((Iterable)paramLinkedList).iterator();
              label321:
              if (!((Iterator)localObject3).hasNext()) {
                break label517;
              }
              localObject2 = ((Iterator)localObject3).next();
              localboz = (boz)localObject2;
              String str = localboz.EVK;
              if (!s.p(paramString1, "h265")) {
                break label503;
              }
              localObject1 = "h264";
              label369:
              if ((!n.T(str, (String)localObject1, true)) || (localboz.ZPI >= paramLong)) {
                break label511;
              }
              i = 1;
              if (i == 0) {
                break label515;
              }
            }
          }
        }
      }
      label394:
      for (localObject1 = localObject2;; localObject1 = null)
      {
        localObject1 = (boz)localObject1;
        if (localObject1 != null) {
          break label523;
        }
        localObject1 = "step#4";
        Log.w("Finder.MediaPreloadModel", "findSpecInternal return null for " + paramString2 + ":[" + paramString1 + " : " + paramLong + " : " + paramLinkedList + ']');
        paramString1 = null;
        break;
        i = 0;
        break label217;
        label489:
        break label164;
        localObject1 = null;
        break label222;
        localObject1 = null;
        break label297;
        label503:
        localObject1 = "h265";
        break label369;
        label511:
        i = 0;
        break label394;
        break label321;
      }
      label515:
      label517:
      label523:
      paramString1 = (String)localObject1;
      localObject1 = "step#3";
      continue;
      label534:
      paramString1 = (String)localObject1;
      localObject1 = localObject2;
      continue;
      label544:
      paramString1 = (String)localObject1;
      localObject1 = localObject2;
    }
    label554:
    paramString1 = a(paramString1, paramString2, (List)paramLinkedList, paramLong);
    AppMethodBeat.o(346355);
    return paramString1;
  }
  
  private final kotlin.u<boz, String, Long> a(String paramString, LinkedList<boz> paramLinkedList, boolean paramBoolean, long paramLong, int paramInt, dji paramdji)
  {
    AppMethodBeat.i(346364);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.d.eUR().bmg()).intValue();
    Object localObject2;
    if (i == 1) {
      if (s.p(paramString, "h265"))
      {
        localObject2 = ((Iterable)paramLinkedList).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (s.p(((boz)localObject1).hVy, com.tencent.mm.plugin.finder.storage.v.FLc.detail))
          {
            if (localObject1 == null) {
              break label200;
            }
            localObject1 = com.tencent.mm.plugin.finder.storage.v.FLc.detail;
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = new boz();
      ((boz)localObject2).hVy = ((String)localObject1);
      ((boz)localObject2).EVK = paramString;
      ((boz)localObject2).ZMg = 2097152;
      if (paramBoolean)
      {
        paramString = ((boz)localObject2).hVy;
        s.checkNotNull(paramString);
        s.s(paramString, "spec.fileFormat!!");
        a(paramInt, i, paramLong, paramdji, paramString);
      }
      paramString = a((boz)localObject2, "step#default", (List)paramLinkedList, this.EVs);
      AppMethodBeat.o(346364);
      return paramString;
      localObject1 = null;
      break;
      label200:
      if (s.p(paramString, "h264"))
      {
        localObject2 = ((Iterable)paramLinkedList).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!s.p(((boz)localObject1).hVy, com.tencent.mm.plugin.finder.storage.v.FLb.detail));
        for (;;)
        {
          if (localObject1 == null) {
            break label282;
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.v.FLb.detail;
          break;
          localObject1 = null;
        }
      }
      label282:
      localObject1 = com.tencent.mm.plugin.finder.storage.v.FLa.detail;
      continue;
      localObject1 = com.tencent.mm.plugin.finder.storage.v.FLa.detail;
    }
  }
  
  private final void a(int paramInt1, int paramInt2, long paramLong, dji paramdji, String paramString)
  {
    AppMethodBeat.i(346402);
    JSONObject localJSONObject;
    if ((paramInt2 != 0) && (!this.EVH.containsKey(Long.valueOf(paramLong))))
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("commentScene", paramInt1);
      localJSONObject.put("feedId", com.tencent.mm.ae.d.hF(paramLong));
      localJSONObject.put("targetFileFormat", paramString);
      localJSONObject.put("isSupportH265", EVI);
      localJSONObject.put("media", paramdji.mediaId);
      paramString = paramdji.spec;
      s.s(paramString, "media.spec");
      Object localObject = (Iterable)paramString;
      paramString = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        boz localboz = (boz)((Iterator)localObject).next();
        s.s(localboz, "it");
        paramString.add(c.a(localboz));
      }
      localJSONObject.put("spec", (List)paramString);
      if (paramdji.aaPc != 3) {
        break label280;
      }
    }
    label280:
    for (boolean bool = true;; bool = false)
    {
      localJSONObject.put("isLongVideo", bool);
      e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "SpecError", false, null, false, (kotlin.g.a.a)new d(localJSONObject), 28);
      ((Map)this.EVH).put(Long.valueOf(paramLong), this);
      AppMethodBeat.o(346402);
      return;
    }
  }
  
  private static LinkedList<boz> aP(LinkedList<boz> paramLinkedList)
  {
    AppMethodBeat.i(346371);
    LinkedList localLinkedList = new LinkedList();
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("Finder.MediaPreloadModel", "getSupportHdrSpecList return for version:" + Build.VERSION.SDK_INT + '.');
      AppMethodBeat.o(346371);
      return localLinkedList;
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      boz localboz = (boz)paramLinkedList.next();
      Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.eYm().bmg()).intValue() == 1) && (s.p(localboz.hVy, com.tencent.mm.plugin.finder.storage.v.FLz.detail)))
      {
        localObject = a.EVb;
        if (a.eHK())
        {
          localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (com.tencent.mm.plugin.finder.storage.d.eRf()) {}
        }
        else
        {
          localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eYm().bmg()).intValue() != 1) {
            break label171;
          }
        }
        localLinkedList.add(localboz);
      }
      label171:
      if (s.p(localboz.hVy, com.tencent.mm.plugin.finder.storage.v.FLA.detail))
      {
        localObject = a.EVb;
        if (a.eHL())
        {
          localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (com.tencent.mm.plugin.finder.storage.d.eRe()) {}
        }
        else
        {
          localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eYm().bmg()).intValue() != 1) {
            continue;
          }
        }
        localLinkedList.add(localboz);
      }
    }
    if (localLinkedList.isEmpty()) {
      Log.w("Finder.MediaPreloadModel", "getSupportHdrSpecList is empty for no support hdr.");
    }
    AppMethodBeat.o(346371);
    return localLinkedList;
  }
  
  private static LinkedList<boz> aQ(LinkedList<boz> paramLinkedList)
  {
    AppMethodBeat.i(346380);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = ((Iterable)paramLinkedList).iterator();
    Object localObject1;
    Object localObject3;
    int i;
    label82:
    label86:
    label103:
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      localObject3 = (boz)localObject1;
      if ((s.p(((boz)localObject3).hVy, com.tencent.mm.plugin.finder.storage.v.FLa.detail)) && (s.p(((boz)localObject3).EVK, "h265")))
      {
        i = 1;
        if (i == 0) {
          break label283;
        }
        localObject2 = (boz)localObject1;
        localObject3 = ((Iterable)paramLinkedList).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label295;
        }
        localObject1 = ((Iterator)localObject3).next();
        localObject4 = (boz)localObject1;
        if ((!s.p(((boz)localObject4).hVy, com.tencent.mm.plugin.finder.storage.v.FLc.detail)) || (!s.p(((boz)localObject4).EVK, "h265"))) {
          break label290;
        }
        i = 1;
        label160:
        if (i == 0) {
          break label293;
        }
        label164:
        localObject1 = (boz)localObject1;
        if ((localObject2 == null) || (localObject1 == null)) {
          break label344;
        }
        localLinkedList.add(localObject1);
        localLinkedList.add(localObject2);
        localObject3 = (Iterable)paramLinkedList;
        paramLinkedList = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
      }
    }
    label283:
    label290:
    label293:
    label295:
    label303:
    for (;;)
    {
      label217:
      if (!((Iterator)localObject3).hasNext()) {
        break label305;
      }
      localObject4 = ((Iterator)localObject3).next();
      boz localboz = (boz)localObject4;
      if ((!s.p(localboz, localObject2)) && (!s.p(localboz, localObject1))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label303;
        }
        paramLinkedList.add(localObject4);
        break label217;
        i = 0;
        break label82;
        break;
        localObject1 = null;
        break label86;
        i = 0;
        break label160;
        break label103;
        localObject1 = null;
        break label164;
      }
    }
    label305:
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localLinkedList.add((boz)paramLinkedList.next());
      continue;
      label344:
      localLinkedList.addAll((Collection)paramLinkedList);
    }
    AppMethodBeat.o(346380);
    return localLinkedList;
  }
  
  public final com.tencent.mm.plugin.finder.loader.v a(long paramLong, dji paramdji)
  {
    AppMethodBeat.i(346461);
    s.u(paramdji, "media");
    long l = System.currentTimeMillis();
    Object localObject1 = a(paramLong, paramdji, false, 0);
    Object localObject2 = (boz)((kotlin.u)localObject1).bsC;
    if (n.T(((boz)localObject2).EVK, "h265", true)) {}
    com.tencent.mm.plugin.finder.loader.v localv;
    boz localboz;
    for (int i = 2;; i = 1)
    {
      localv = new com.tencent.mm.plugin.finder.loader.v(paramdji, a.azm(((boz)localObject2).hVy), i, null, 8);
      this.EVz.put(localv.aUt(), localObject1);
      localObject1 = new StringBuilder("[findTargetMedia] feedId=").append(com.tencent.mm.ae.d.hF(paramLong)).append(" stage=").append((String)((kotlin.u)localObject1).bsD).append(" target").append(c.a((boz)localObject2)).append(" sdrSpec=");
      localObject2 = paramdji.spec;
      s.s(localObject2, "media.spec");
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localboz = (boz)((Iterator)localObject3).next();
        s.s(localboz, "it");
        ((Collection)localObject2).add(c.a(localboz));
      }
    }
    localObject1 = ((StringBuilder)localObject1).append((List)localObject2).append(" hdrSpec=");
    localObject2 = paramdji.aaPs;
    s.s(localObject2, "media.hdr_spec");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localboz = (boz)((Iterator)localObject3).next();
      s.s(localboz, "it");
      ((Collection)localObject2).add(c.a(localboz));
    }
    localObject1 = ((StringBuilder)localObject1).append((List)localObject2).append(" hlsSpec=");
    paramdji = paramdji.aaPr;
    s.s(paramdji, "media.hls_spec");
    localObject2 = (Iterable)paramdji;
    paramdji = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bbp)((Iterator)localObject2).next();
      s.s(localObject3, "it");
      s.u(localObject3, "<this>");
      paramdji.add("Spec[" + ((bbp)localObject3).EVK + ' ' + ((bbp)localObject3).hVy + ' ' + Util.getSizeKB(((bbp)localObject3).ZMg) + ']');
    }
    Log.i("Finder.MediaPreloadModel", (List)paramdji + " maxBitRate:" + this.EVs + " Cost=" + (System.currentTimeMillis() - l) + ' ');
    AppMethodBeat.o(346461);
    return localv;
  }
  
  public final List<b> a(int paramInt1, long paramLong, dji paramdji, int paramInt2)
  {
    AppMethodBeat.i(346452);
    s.u(paramdji, "media");
    long l = System.currentTimeMillis();
    boolean bool = this.EVA;
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = paramdji.mediaId;
    kotlin.u localu;
    boz localboz;
    int i;
    label90:
    Object localObject2;
    Object localObject3;
    label182:
    int j;
    label222:
    label246:
    com.tencent.mm.plugin.finder.loader.v localv;
    label384:
    float f;
    if (localObject1 == null)
    {
      localObject1 = "";
      localu = a(paramLong, paramdji, true, paramInt1);
      localboz = (boz)localu.bsC;
      if (!n.T(localboz.EVK, "h265", true)) {
        break label863;
      }
      i = 2;
      if (bool)
      {
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        localObject3 = paramdji.mediaId;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject3 = ((Iterable)p.a((Iterable)com.tencent.mm.plugin.finder.storage.logic.e.aAO((String)localObject2), (Comparator)new c())).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = ((Iterator)localObject3).next();
        } while (!((az)localObject2).eDx());
        localObject2 = (az)localObject2;
        if (localObject2 != null)
        {
          localObject3 = (CharSequence)((az)localObject2).field_fileFormat;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label875;
          }
          j = 1;
          if (j == 0)
          {
            localObject3 = localboz.hVy;
            if (localObject3 == null) {
              break label881;
            }
            j = localObject3.hashCode();
            if (j > ((az)localObject2).field_fileFormat.hashCode())
            {
              Log.w("Finder.MediaPreloadModel", "[query] continue to use high fileFormat, [" + paramdji.mediaId + "] change[" + localboz.hVy + "->" + ((az)localObject2).field_fileFormat + ']');
              localboz.hVy = ((az)localObject2).field_fileFormat;
            }
          }
        }
      }
      if (!bool) {
        localboz.hVy = com.tencent.mm.plugin.finder.storage.v.FLB.detail;
      }
      localv = new com.tencent.mm.plugin.finder.loader.v(paramdji, a.azm(localboz.hVy), i, null, 8);
      if (localboz.ZMg <= 0) {
        break label887;
      }
      paramLong = localboz.ZMg;
      localObject3 = localboz.hVy;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      String str = localboz.EVK;
      localObject3 = str;
      if (str == null) {
        localObject3 = "";
      }
      localLinkedList.add(new b(1, paramLong, (String)localObject2, (String)localObject3, localv, (byte)0));
      if ((!bool) || (this.EVl <= 0) || (paramInt2 == 1000)) {
        break label969;
      }
      if (paramdji.aaPc != 3) {
        break label904;
      }
      localObject2 = (dnp)this.EVy.get(localObject1);
      if (localObject2 != null) {
        break label894;
      }
      f = 0.0F;
      label499:
      j = Math.min(100, kotlin.h.a.eH(Math.max(1.0F, f * this.EVl)));
      if (paramdji.aaPc != 3) {
        break label945;
      }
      if (this.EVy.get(localObject1) == null) {
        break label939;
      }
      i = 1;
      label545:
      if (i != 0)
      {
        this.EVB = true;
        localObject3 = localboz.hVy;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        str = localboz.EVK;
        localObject3 = str;
        if (str == null) {
          localObject3 = "";
        }
        localLinkedList.add(new b(j, 2097152L, (String)localObject2, (String)localObject3, localv, (byte)0));
      }
    }
    for (;;)
    {
      this.EVz.put(localv.aUt(), localu);
      localObject1 = new StringBuilder("[queryPreloadDetail] Cost=").append(System.currentTimeMillis() - l).append(" source = ").append(paramInt2).append(", commentScene=").append(paramInt1).append(" isSecondPreload=").append(this.EVB).append(" mid=").append((String)localObject1).append(" stage=[").append((String)localu.bsD).append(':').append(localLinkedList.size()).append("] target").append(c.a(localboz)).append(" details=").append(localLinkedList).append(", allSpec=");
      paramdji = paramdji.spec;
      s.s(paramdji, "media.spec");
      localObject2 = (Iterable)paramdji;
      paramdji = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (boz)((Iterator)localObject2).next();
        s.s(localObject3, "it");
        paramdji.add(c.a((boz)localObject3));
      }
      break;
      label863:
      i = 1;
      break label90;
      localObject2 = null;
      break label182;
      label875:
      j = 0;
      break label222;
      label881:
      j = 0;
      break label246;
      label887:
      paramLong = 2097152L;
      break label384;
      label894:
      f = ((dnp)localObject2).aaaZ;
      break label499;
      label904:
      localObject2 = (btd)this.EVx.get(localObject1);
      if (localObject2 == null)
      {
        f = 0.0F;
        break label499;
      }
      f = ((btd)localObject2).aaaZ;
      break label499;
      label939:
      i = 0;
      break label545;
      label945:
      if (this.EVx.get(localObject1) != null)
      {
        i = 1;
        break label545;
      }
      i = 0;
      break label545;
      label969:
      this.EVB = false;
    }
    Log.i("Finder.MediaPreloadModel", (List)paramdji);
    paramdji = (List)localLinkedList;
    AppMethodBeat.o(346452);
    return paramdji;
  }
  
  public final void a(btc parambtc, HashMap<Long, FinderObject> paramHashMap)
  {
    AppMethodBeat.i(346434);
    s.u(parambtc, "info");
    s.u(paramHashMap, "feedSet");
    this.EVt = parambtc.EVt;
    Object localObject1 = parambtc.aaaW;
    if (localObject1 != null)
    {
      this.EVj = ((btb)localObject1).EVj;
      this.EVk = ((btb)localObject1).EVk;
      this.EVl = kotlin.h.a.eH(100.0F * ((btb)localObject1).aaaN);
      this.EVs = ((btb)localObject1).aaaM;
      this.EVm = ((btb)localObject1).aaaO;
      this.EVn = k.qu(1, ((btb)localObject1).aaaP);
      this.EVo = k.qu(1, ((btb)localObject1).EVo);
      this.EVp = ((btb)localObject1).EVp;
      this.EVq = kotlin.h.a.eH(100.0F * ((btb)localObject1).aaaQ);
      this.EVr = ((btb)localObject1).EVr;
      this.EVi = false;
      this.EVu = ((btb)localObject1).aaaR;
      this.EVv = ((btb)localObject1).EVv;
      this.EVw = ((btb)localObject1).EVw;
      this.EVC = ((btb)localObject1).aaaS;
      this.EVD = ((btb)localObject1).aaaT;
      this.EVE = ((btb)localObject1).aaaU;
      this.EVF = ((btb)localObject1).aaaV;
      localObject1 = parambtc.aaaX;
      Iterator localIterator1;
      Object localObject3;
      Iterator localIterator2;
      Object localObject4;
      Object localObject2;
      if (localObject1 != null)
      {
        localIterator1 = ((Iterable)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          localObject3 = (btd)localIterator1.next();
          localObject1 = (FinderObject)paramHashMap.get(Long.valueOf(((btd)localObject3).feedId));
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 != null)
            {
              localObject1 = ((FinderObjectDesc)localObject1).media;
              if (localObject1 != null)
              {
                localIterator2 = ((Iterable)localObject1).iterator();
                while (localIterator2.hasNext())
                {
                  localObject1 = (FinderMedia)localIterator2.next();
                  localObject4 = (Map)this.EVx;
                  s.s(localObject1, "it");
                  localObject2 = i.c((FinderMedia)localObject1).mediaId;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  s.s(localObject3, "hot");
                  ((Map)localObject4).put(localObject1, localObject3);
                }
                localObject1 = ah.aiuX;
              }
            }
          }
        }
        localObject1 = ah.aiuX;
      }
      localObject1 = parambtc.aaaY;
      if (localObject1 != null)
      {
        localIterator1 = ((Iterable)localObject1).iterator();
        if (localIterator1.hasNext())
        {
          localObject3 = (dnp)localIterator1.next();
          localIterator2 = ((Map)paramHashMap).entrySet().iterator();
          label646:
          label779:
          label784:
          label788:
          for (;;)
          {
            label485:
            int i;
            if (localIterator2.hasNext())
            {
              localObject1 = ((FinderObject)((Map.Entry)localIterator2.next()).getValue()).attachmentList;
              if (localObject1 != null)
              {
                localObject1 = ((atr)localObject1).ZEi;
                if (localObject1 != null)
                {
                  localObject2 = ((Iterable)localObject1).iterator();
                  for (;;)
                  {
                    if (((Iterator)localObject2).hasNext())
                    {
                      localObject1 = ((Iterator)localObject2).next();
                      localObject4 = (atq)localObject1;
                      av localav = av.GiL;
                      s.s(localObject4, "it");
                      if (av.a((atq)localObject4))
                      {
                        label594:
                        localObject1 = (atq)localObject1;
                        if (localObject1 == null) {
                          break;
                        }
                        localObject1 = ((atq)localObject1).ZEf;
                        if (localObject1 == null) {
                          break;
                        }
                        localObject1 = ((byx)localObject1).ZXx;
                        if (localObject1 == null) {
                          break;
                        }
                        if (((dne)localObject1).id != ((dnp)localObject3).feedId) {
                          break label779;
                        }
                        i = 1;
                        if (i == 0) {
                          break label784;
                        }
                      }
                    }
                  }
                }
              }
            }
            else
            {
              for (;;)
              {
                if (localObject1 == null) {
                  break label788;
                }
                localObject1 = ((dne)localObject1).aaUt;
                if (localObject1 != null)
                {
                  localObject1 = ((dnh)localObject1).media;
                  if (localObject1 != null)
                  {
                    localObject1 = (dnv)p.oL((List)localObject1);
                    if (localObject1 != null)
                    {
                      localObject4 = (Map)this.EVy;
                      localObject2 = i.a((dnv)localObject1).mediaId;
                      localObject1 = localObject2;
                      if (localObject2 == null) {
                        localObject1 = "";
                      }
                      s.s(localObject3, "info");
                      ((Map)localObject4).put(localObject1, localObject3);
                      localObject1 = ah.aiuX;
                      localObject1 = ah.aiuX;
                    }
                  }
                }
                localObject1 = ah.aiuX;
                localObject1 = ah.aiuX;
                break label485;
                break;
                localObject1 = null;
                break label594;
                i = 0;
                break label646;
                localObject1 = null;
              }
            }
          }
        }
        paramHashMap = ah.aiuX;
      }
      this.EVh.EUY = SystemClock.uptimeMillis();
      paramHashMap = ah.aiuX;
      paramHashMap = ah.aiuX;
    }
    paramHashMap = new StringBuilder();
    paramHashMap.append("[updatePreloadInfo]\nisSupportH265=").append(EVI).append("\n[prev:next]Count=").append(this.EVj).append(':').append(this.EVk).append("\nmaxPreloadPercent=").append(this.EVl).append("\nmaxPreloadBitRate=").append(this.EVs).append(", maxPreloadBytes=").append(Util.getSizeKB(this.EVm)).append("\nmaxPreloadTaskCount=").append(this.EVn).append("\n[preload:play]ConcurrentCount=").append(this.EVo).append(':').append(this.EVp).append("\n[startPreloadSecs:startPreloadPercent]=").append(this.EVr).append(':').append(this.EVq).append("\nisOpenMultiBitRateDownload=");
    paramHashMap.append(this.EVA).append("\nhotFeed=").append(this.EVx.size()).append("\nmegaVideo[prev:next]Count=").append(this.EVv).append(':').append(this.EVw).append("\nmegaVideoMaxBitrate=").append(this.EVu).append("\nhotMegaVideoMediaSet=").append(this.EVy.size()).append("\nminBufferLength=").append(this.EVC).append("\nmaxBufferLength=").append(this.EVD).append("\nminCurrentFeedBufferLength=").append(this.EVE).append("\ncanPreCreatedPlayer=").append(this.EVF).append('\n');
    Log.i("Finder.MediaPreloadModel", paramHashMap.toString());
    if (parambtc != null)
    {
      paramHashMap = new LinkedList((Collection)parambtc.aaaX);
      parambtc.aaaX.clear();
      localObject1 = parambtc.toByteArray();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcj, Util.encodeHexString((byte[])localObject1));
      Log.i("Finder.MediaPreloadModel", s.X("[storePreloadInfo] buffer size=", Util.getSizeKB(localObject1.length)));
      parambtc.aaaX.addAll((Collection)paramHashMap);
    }
    AppMethodBeat.o(346434);
  }
  
  public final void azl(String paramString)
  {
    AppMethodBeat.i(346412);
    s.u(paramString, "<set-?>");
    this.EVG = paramString;
    AppMethodBeat.o(346412);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Companion;", "", "()V", "CODING_H264", "", "CODING_H265", "SOURCE_TAB_PRELOAD", "", "TAG", "_2M", "", "defaultMaxPreloadTaskCount", "defaultNextCount", "defaultPlayConcurrentCount", "defaultPreloadConcurrentCount", "defaultPreloadMinSize", "defaultPreloadPercent", "", "defaultPrevCount", "defaultStartPreloadPercent", "defaultStartPreloadSecs", "isSupportH265", "", "getFinderMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "fileFormat", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static com.tencent.mm.plugin.finder.storage.v azm(String paramString)
    {
      AppMethodBeat.i(346320);
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLa.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLa;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLb.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLb;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLc.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLc;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLd.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLd;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLe.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLe;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLf.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLf;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLg.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLg;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLh.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLh;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLi.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLi;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLj.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLj;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLk.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLk;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLl.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLl;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLm.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLm;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLn.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLn;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLo.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLo;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLp.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLp;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLq.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLq;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLr.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLr;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLs.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLs;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLt.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLt;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLu.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLu;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLv.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLv;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLw.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLw;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLx.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLx;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLy.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLy;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLA.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLA;
        AppMethodBeat.o(346320);
        return paramString;
      }
      if (s.p(paramString, com.tencent.mm.plugin.finder.storage.v.FLz.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.v.FLz;
        AppMethodBeat.o(346320);
        return paramString;
      }
      paramString = com.tencent.mm.plugin.finder.storage.v.FLB;
      AppMethodBeat.o(346320);
      return paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "", "preloadPercent", "", "preloadMinSize", "", "fileFormat", "", "codingFormat", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocalDefault", "", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Z)V", "getCodingFormat", "()Ljava/lang/String;", "getFileFormat", "()Z", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getPreloadMinSize", "()J", "getPreloadPercent", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final a EVJ;
    private static final b EVM;
    public final com.tencent.mm.plugin.finder.loader.v EEv;
    public final String EVK;
    private final boolean EVL;
    public final String hVy;
    public final int lxn;
    public final long preloadMinSize;
    
    static
    {
      AppMethodBeat.i(346335);
      EVJ = new a((byte)0);
      EVM = new b(0, 0L, "", "", new com.tencent.mm.plugin.finder.loader.v(new dji(), com.tencent.mm.plugin.finder.storage.v.FLB, 0, null, 12), (byte)0);
      AppMethodBeat.o(346335);
    }
    
    private b(int paramInt, long paramLong, String paramString1, String paramString2, com.tencent.mm.plugin.finder.loader.v paramv)
    {
      AppMethodBeat.i(346326);
      this.lxn = paramInt;
      this.preloadMinSize = paramLong;
      this.hVy = paramString1;
      this.EVK = paramString2;
      this.EEv = paramv;
      this.EVL = false;
      AppMethodBeat.o(346326);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(346357);
      if (this == paramObject)
      {
        AppMethodBeat.o(346357);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(346357);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.lxn != paramObject.lxn)
      {
        AppMethodBeat.o(346357);
        return false;
      }
      if (this.preloadMinSize != paramObject.preloadMinSize)
      {
        AppMethodBeat.o(346357);
        return false;
      }
      if (!s.p(this.hVy, paramObject.hVy))
      {
        AppMethodBeat.o(346357);
        return false;
      }
      if (!s.p(this.EVK, paramObject.EVK))
      {
        AppMethodBeat.o(346357);
        return false;
      }
      if (!s.p(this.EEv, paramObject.EEv))
      {
        AppMethodBeat.o(346357);
        return false;
      }
      if (this.EVL != paramObject.EVL)
      {
        AppMethodBeat.o(346357);
        return false;
      }
      AppMethodBeat.o(346357);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(346341);
      String str = this.lxn + "%:" + this.preloadMinSize + ':' + this.hVy;
      AppMethodBeat.o(346341);
      return str;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail$Companion;", "", "()V", "NIL", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "getNIL", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class c<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(346312);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((az)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((az)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(346312);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    d(JSONObject paramJSONObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.b
 * JD-Core Version:    0.7.0.1
 */