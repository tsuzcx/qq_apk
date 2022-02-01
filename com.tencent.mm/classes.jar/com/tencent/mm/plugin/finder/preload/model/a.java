package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.bhg;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "", "()V", "findSpecStepMap", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "getFindSpecStepMap", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "hotMediaSet", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadObjectInfo;", "getHotMediaSet", "()Ljava/util/concurrent/ConcurrentHashMap;", "setHotMediaSet", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "hotMegaVideoMediaSet", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFinderPreloadObjectInfo;", "getHotMegaVideoMediaSet", "setHotMegaVideoMediaSet", "isMoovFailReady2DownloadAll", "", "()Z", "setMoovFailReady2DownloadAll", "(Z)V", "isOpenMultiBitRateDownload", "isSecondPreload", "setSecondPreload", "maxPreloadBitRate", "", "getMaxPreloadBitRate", "()J", "setMaxPreloadBitRate", "(J)V", "maxPreloadBytes", "getMaxPreloadBytes", "setMaxPreloadBytes", "maxPreloadPercent", "", "getMaxPreloadPercent", "()I", "setMaxPreloadPercent", "(I)V", "maxPreloadTaskCount", "getMaxPreloadTaskCount", "setMaxPreloadTaskCount", "megaVideoMaxBitrate", "getMegaVideoMaxBitrate", "setMegaVideoMaxBitrate", "megaVideoNextCount", "getMegaVideoNextCount", "setMegaVideoNextCount", "megaVideoPrevCount", "getMegaVideoPrevCount", "setMegaVideoPrevCount", "nextCount", "getNextCount", "setNextCount", "playConcurrentCount", "getPlayConcurrentCount", "setPlayConcurrentCount", "preloadConcurrentCount", "getPreloadConcurrentCount", "setPreloadConcurrentCount", "preloadId", "getPreloadId", "setPreloadId", "prevCount", "getPrevCount", "setPrevCount", "reportMap", "startPreloadPercent", "getStartPreloadPercent", "setStartPreloadPercent", "startPreloadSecs", "getStartPreloadSecs", "setStartPreloadSecs", "findTargetMedia", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedId", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "findTargetSpec", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "isPreload", "commentScene", "initConfig", "onExitFinder", "", "queryPreloadDetail", "", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "reportWithoutSpec", "defaultFileFormatV2", "targetFileFormat", "storePreloadInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "tranToH265IfEnable", "spec", "step", "specList", "updatePreloadInfo", "feedSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "Detail", "plugin-finder_release"})
public final class a
{
  private static final boolean zKW;
  public static final a zKX;
  public boolean zKB;
  public int zKC;
  public int zKD;
  public int zKE;
  public long zKF;
  public int zKG;
  public int zKH;
  public int zKI;
  public int zKJ;
  public int zKK;
  public long zKL;
  public long zKM;
  public long zKN;
  public int zKO;
  public int zKP;
  private ConcurrentHashMap<String, bhi> zKQ;
  private ConcurrentHashMap<String, cwk> zKR;
  public final com.tencent.mm.b.h<String, String> zKS;
  public final boolean zKT;
  public boolean zKU;
  public final ConcurrentHashMap<Long, Object> zKV;
  
  static
  {
    AppMethodBeat.i(166482);
    zKX = new a((byte)0);
    zKW = e.vW(4);
    AppMethodBeat.o(166482);
  }
  
  public a()
  {
    AppMethodBeat.i(166481);
    this.zKC = 1;
    this.zKD = 4;
    this.zKE = kotlin.h.a.dm(30.000002F);
    this.zKF = 2097152L;
    this.zKG = 1;
    this.zKH = 1;
    this.zKI = 4;
    this.zKJ = kotlin.h.a.dm(0.0F);
    this.zKO = 1;
    this.zKP = 2;
    this.zKQ = new ConcurrentHashMap();
    this.zKR = new ConcurrentHashMap();
    this.zKS = new com.tencent.mm.b.h(300);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.zKT = com.tencent.mm.plugin.finder.storage.d.dTw();
    this.zKV = new ConcurrentHashMap();
    AppMethodBeat.o(166481);
  }
  
  private final o<beb, String> a(long paramLong, csg paramcsg, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(287550);
    long l;
    Object localObject2;
    label29:
    Object localObject3;
    Object localObject1;
    label59:
    int i;
    if (paramcsg.TzR == 3)
    {
      l = this.zKN;
      if (!zKW) {
        break label510;
      }
      localObject2 = "h265";
      localObject3 = "step#1";
      localObject1 = paramcsg.spec;
      p.j(localObject1, "media.spec");
      Object localObject4 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject4).hasNext()) {
        break label524;
      }
      localObject1 = ((Iterator)localObject4).next();
      Object localObject5 = (beb)localObject1;
      if ((!n.L(((beb)localObject5).zKY, (String)localObject2, true)) || (((beb)localObject5).SKL >= l)) {
        break label518;
      }
      i = 1;
      label114:
      if (i == 0) {
        break label522;
      }
      label119:
      localObject1 = (beb)localObject1;
      if (localObject1 != null) {
        break label609;
      }
      localObject4 = (a)this;
      localObject1 = paramcsg.spec;
      p.j(localObject1, "media.spec");
      localObject1 = (List)localObject1;
      localObject3 = ((List)localObject1).listIterator(((List)localObject1).size());
      while (((ListIterator)localObject3).hasPrevious())
      {
        localObject1 = ((ListIterator)localObject3).previous();
        if (n.L(((beb)localObject1).zKY, (String)localObject2, true))
        {
          label210:
          localObject1 = (beb)localObject1;
          if (localObject1 != null) {
            break label601;
          }
          localObject1 = paramcsg.spec;
          p.j(localObject1, "media.spec");
          localObject5 = ((Iterable)localObject1).iterator();
          label248:
          if (!((Iterator)localObject5).hasNext()) {
            break label549;
          }
          localObject3 = ((Iterator)localObject5).next();
          beb localbeb = (beb)localObject3;
          String str = localbeb.zKY;
          if (!p.h(localObject2, "h265")) {
            break label536;
          }
          localObject1 = "h264";
          label296:
          if ((!n.L(str, (String)localObject1, true)) || (localbeb.SKL >= l)) {
            break label543;
          }
          i = 1;
          label322:
          if (i == 0) {
            break label547;
          }
          localObject1 = localObject3;
          label331:
          localObject1 = (beb)localObject1;
          if (localObject1 != null) {
            break label593;
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
          l = ((Number)com.tencent.mm.plugin.finder.storage.d.dWh().aSr()).longValue();
          if (l != 0L)
          {
            localObject1 = paramcsg.spec;
            p.j(localObject1, "media.spec");
            if (((Collection)localObject1).isEmpty()) {
              break label555;
            }
            i = 1;
            label399:
            if (i == 0) {
              break label561;
            }
          }
          localObject1 = u.AlA.detail;
          label412:
          if (paramBoolean) {
            ((a)localObject4).a(paramInt, l, paramLong, paramcsg, (String)localObject1);
          }
          localObject3 = new beb();
          ((beb)localObject3).fPD = ((String)localObject1);
          ((beb)localObject3).zKY = ((String)localObject2);
          ((beb)localObject3).SIw = 2097152;
          localObject2 = "step#4";
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      paramcsg = paramcsg.spec;
      p.j(paramcsg, "media.spec");
      paramcsg = a((beb)localObject1, (String)localObject2, (List)paramcsg);
      AppMethodBeat.o(287550);
      return paramcsg;
      l = this.zKL;
      break;
      label510:
      localObject2 = "h264";
      break label29;
      label518:
      i = 0;
      break label114;
      label522:
      break label59;
      label524:
      localObject1 = null;
      break label119;
      localObject1 = null;
      break label210;
      label536:
      localObject1 = "h265";
      break label296;
      label543:
      i = 0;
      break label322;
      label547:
      break label248;
      label549:
      localObject1 = null;
      break label331;
      label555:
      i = 0;
      break label399;
      label561:
      if (p.h(localObject2, "h265"))
      {
        localObject1 = u.AlC.detail;
        break label412;
      }
      localObject1 = u.AlB.detail;
      break label412;
      label593:
      localObject2 = "step#3";
      continue;
      label601:
      localObject2 = "step#2";
      continue;
      label609:
      localObject2 = localObject3;
    }
  }
  
  private static o<beb, String> a(beb parambeb, String paramString, List<? extends beb> paramList)
  {
    AppMethodBeat.i(287551);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if ((((Number)com.tencent.mm.plugin.finder.storage.d.dWu().aSr()).intValue() != 1) || (!zKW))
    {
      parambeb = new o(parambeb, paramString);
      AppMethodBeat.o(287551);
      return parambeb;
    }
    localObject = parambeb.fPD;
    String str = parambeb.fPD;
    if (p.h(str, u.AlA.detail)) {
      if (paramList.isEmpty()) {
        parambeb.fPD = u.AlC.detail;
      }
    }
    for (;;)
    {
      Log.i("Finder.MediaPreloadModel", "[tranToH265IfEnable] oldFormat:" + (String)localObject + " , newFormat:" + parambeb.fPD);
      parambeb = new o(parambeb, paramString + '+');
      AppMethodBeat.o(287551);
      return parambeb;
      parambeb.fPD = u.AlA.detail;
      continue;
      if (p.h(str, u.AlB.detail)) {
        parambeb.fPD = u.AlC.detail;
      } else if (p.h(str, u.AlD.detail)) {
        parambeb.fPD = u.AlE.detail;
      } else if (p.h(str, u.AlF.detail)) {
        parambeb.fPD = u.AlG.detail;
      } else if (p.h(str, u.AlH.detail)) {
        parambeb.fPD = u.AlI.detail;
      } else if (p.h(str, u.AlJ.detail)) {
        parambeb.fPD = u.AlK.detail;
      }
    }
  }
  
  private final void a(int paramInt, long paramLong1, long paramLong2, csg paramcsg, String paramString)
  {
    AppMethodBeat.i(287552);
    JSONObject localJSONObject;
    if ((paramLong1 != 0L) && (!this.zKV.containsKey(Long.valueOf(paramLong2))))
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("commentScene", paramInt);
      localJSONObject.put("feedId", com.tencent.mm.ae.d.Fw(paramLong2));
      localJSONObject.put("targetFileFormat", paramString);
      localJSONObject.put("isSupportH265", zKW);
      localJSONObject.put("media", paramcsg.mediaId);
      paramString = paramcsg.spec;
      p.j(paramString, "media.spec");
      Object localObject = (Iterable)paramString;
      paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        beb localbeb = (beb)((Iterator)localObject).next();
        p.j(localbeb, "it");
        paramString.add(b.a(localbeb));
      }
      localJSONObject.put("spec", (List)paramString);
      if (paramcsg.TzR != 3) {
        break label281;
      }
    }
    label281:
    for (boolean bool = true;; bool = false)
    {
      localJSONObject.put("isLongVideo", bool);
      f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "SpecError", false, false, (kotlin.g.a.a)new d(localJSONObject), 12);
      ((Map)this.zKV).put(Long.valueOf(paramLong2), this);
      AppMethodBeat.o(287552);
      return;
    }
  }
  
  public final aa a(long paramLong, csg paramcsg)
  {
    AppMethodBeat.i(287549);
    p.k(paramcsg, "media");
    long l = System.currentTimeMillis();
    Object localObject1 = a(paramLong, paramcsg, false, 0);
    Object localObject2 = (beb)((o)localObject1).Mx;
    if (n.L(((beb)localObject2).zKY, "h265", true)) {}
    aa localaa;
    for (int i = 2;; i = 1)
    {
      localaa = new aa(paramcsg, a.aDI(((beb)localObject2).fPD), i, null, 8);
      this.zKS.put(localaa.aBv(), ((o)localObject1).My);
      localObject1 = new StringBuilder("[findTargetMedia] feedId=").append(com.tencent.mm.ae.d.Fw(paramLong)).append(" stage=").append((String)((o)localObject1).My).append(' ').append("target").append(b.a((beb)localObject2)).append(" allSpec=");
      paramcsg = paramcsg.spec;
      p.j(paramcsg, "media.spec");
      localObject2 = (Iterable)paramcsg;
      paramcsg = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        beb localbeb = (beb)((Iterator)localObject2).next();
        p.j(localbeb, "it");
        paramcsg.add(b.a(localbeb));
      }
    }
    Log.i("Finder.MediaPreloadModel", (List)paramcsg + " Cost=" + (System.currentTimeMillis() - l) + ' ');
    AppMethodBeat.o(287549);
    return localaa;
  }
  
  public final List<b> a(int paramInt, long paramLong, csg paramcsg)
  {
    AppMethodBeat.i(287548);
    p.k(paramcsg, "media");
    long l = System.currentTimeMillis();
    boolean bool = this.zKT;
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = paramcsg.mediaId;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      p.j(localObject1, "media.mediaId ?: \"\"");
      o localo = a(paramLong, paramcsg, true, paramInt);
      beb localbeb = (beb)localo.Mx;
      int i;
      Object localObject2;
      Object localObject3;
      label189:
      int j;
      label229:
      label253:
      aa localaa;
      label391:
      float f;
      if (n.L(localbeb.zKY, "h265", true))
      {
        i = 2;
        if (bool)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          localObject3 = paramcsg.mediaId;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject3 = ((Iterable)j.a((Iterable)com.tencent.mm.plugin.finder.storage.logic.d.aEV((String)localObject2), (Comparator)new c())).iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = ((Iterator)localObject3).next();
          } while (!((av)localObject2).dKO());
          localObject2 = (av)localObject2;
          if (localObject2 != null)
          {
            localObject3 = (CharSequence)((av)localObject2).field_fileFormat;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label867;
            }
            j = 1;
            if (j == 0)
            {
              localObject3 = localbeb.fPD;
              if (localObject3 == null) {
                break label873;
              }
              j = localObject3.hashCode();
              if (j > ((av)localObject2).field_fileFormat.hashCode())
              {
                Log.w("Finder.MediaPreloadModel", "[query] continue to use high fileFormat, [" + paramcsg.mediaId + "] change[" + localbeb.fPD + "->" + ((av)localObject2).field_fileFormat + ']');
                localbeb.fPD = ((av)localObject2).field_fileFormat;
              }
            }
          }
        }
        if (!bool) {
          localbeb.fPD = u.AlL.detail;
        }
        localaa = new aa(paramcsg, a.aDI(localbeb.fPD), i, null, 8);
        if (localbeb.SIw <= 0) {
          break label879;
        }
        paramLong = localbeb.SIw;
        localObject3 = localbeb.fPD;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        String str = localbeb.zKY;
        localObject3 = str;
        if (str == null) {
          localObject3 = "";
        }
        localLinkedList.add(new b(1, paramLong, (String)localObject2, (String)localObject3, localaa, (byte)0));
        if ((!bool) || (this.zKE <= 0)) {
          break label957;
        }
        if (paramcsg.TzR != 3) {
          break label892;
        }
        localObject2 = (cwk)this.zKR.get(localObject1);
        if (localObject2 == null) {
          break label886;
        }
        f = ((cwk)localObject2).SRW;
        label502:
        j = Math.min(100, kotlin.h.a.dm(Math.max(1.0F, f * this.zKE)));
        if (paramcsg.TzR != 3) {
          break label933;
        }
        if (this.zKR.get(localObject1) == null) {
          break label927;
        }
        i = 1;
        label548:
        if (i != 0)
        {
          this.zKU = true;
          localObject3 = localbeb.fPD;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          str = localbeb.zKY;
          localObject3 = str;
          if (str == null) {
            localObject3 = "";
          }
          localLinkedList.add(new b(j, 2097152L, (String)localObject2, (String)localObject3, localaa, (byte)0));
        }
      }
      for (;;)
      {
        this.zKS.put(localaa.aBv(), localo.My);
        localObject1 = new StringBuilder("[queryPreloadDetail] Cost=").append(System.currentTimeMillis() - l).append(" commentScene=").append(paramInt).append(" isSecondPreload=").append(this.zKU).append(" mid=").append((String)localObject1).append(" stage=[").append((String)localo.My).append(':').append(localLinkedList.size()).append("] target").append(b.a(localbeb)).append(" details=").append(localLinkedList).append(", allSpec=");
        paramcsg = paramcsg.spec;
        p.j(paramcsg, "media.spec");
        localObject2 = (Iterable)paramcsg;
        paramcsg = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (beb)((Iterator)localObject2).next();
          p.j(localObject3, "it");
          paramcsg.add(b.a((beb)localObject3));
        }
        i = 1;
        break;
        localObject2 = null;
        break label189;
        label867:
        j = 0;
        break label229;
        label873:
        j = 0;
        break label253;
        label879:
        paramLong = 2097152L;
        break label391;
        label886:
        f = 0.0F;
        break label502;
        label892:
        localObject2 = (bhi)this.zKQ.get(localObject1);
        if (localObject2 != null)
        {
          f = ((bhi)localObject2).SRW;
          break label502;
        }
        f = 0.0F;
        break label502;
        label927:
        i = 0;
        break label548;
        label933:
        if (this.zKQ.get(localObject1) != null)
        {
          i = 1;
          break label548;
        }
        i = 0;
        break label548;
        label957:
        this.zKU = false;
      }
      Log.i("Finder.MediaPreloadModel", (List)paramcsg);
      paramcsg = (List)localLinkedList;
      AppMethodBeat.o(287548);
      return paramcsg;
    }
  }
  
  public final void a(bhh parambhh, HashMap<Long, FinderObject> paramHashMap)
  {
    AppMethodBeat.i(287547);
    p.k(parambhh, "info");
    p.k(paramHashMap, "feedSet");
    this.zKM = parambhh.zKM;
    Object localObject1 = parambhh.SRT;
    Object localObject2;
    if (localObject1 != null)
    {
      this.zKC = ((bhg)localObject1).zKC;
      this.zKD = ((bhg)localObject1).zKD;
      this.zKE = kotlin.h.a.dm(((bhg)localObject1).SRO * 100.0F);
      this.zKL = ((bhg)localObject1).SRN;
      this.zKF = ((bhg)localObject1).SRP;
      this.zKG = kotlin.k.i.ov(1, ((bhg)localObject1).SRQ);
      this.zKH = kotlin.k.i.ov(1, ((bhg)localObject1).zKH);
      this.zKI = ((bhg)localObject1).zKI;
      this.zKJ = kotlin.h.a.dm(((bhg)localObject1).SRR * 100.0F);
      this.zKK = ((bhg)localObject1).zKK;
      this.zKB = false;
      this.zKN = ((bhg)localObject1).SRS;
      this.zKO = ((bhg)localObject1).zKO;
      this.zKP = ((bhg)localObject1).zKP;
      localObject1 = parambhh.SRU;
      Iterator localIterator1;
      Object localObject3;
      Iterator localIterator2;
      Map localMap;
      if (localObject1 != null)
      {
        localIterator1 = ((Iterable)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          localObject3 = (bhi)localIterator1.next();
          localObject1 = (FinderObject)paramHashMap.get(Long.valueOf(((bhi)localObject3).feedId));
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
                  localMap = (Map)this.zKQ;
                  p.j(localObject1, "it");
                  localObject2 = com.tencent.mm.plugin.finder.storage.data.i.c((FinderMedia)localObject1).mediaId;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  p.j(localObject3, "hot");
                  localMap.put(localObject1, localObject3);
                }
              }
            }
          }
        }
      }
      localObject1 = parambhh.SRV;
      if (localObject1 != null)
      {
        localIterator1 = ((Iterable)localObject1).iterator();
        if (localIterator1.hasNext())
        {
          localObject3 = (cwk)localIterator1.next();
          localIterator2 = ((Map)paramHashMap).entrySet().iterator();
          label651:
          label656:
          label660:
          for (;;)
          {
            label436:
            int i;
            if (localIterator2.hasNext())
            {
              localObject1 = ((FinderObject)((Map.Entry)localIterator2.next()).getValue()).attachmentList;
              if (localObject1 == null) {
                continue;
              }
              localObject1 = ((apx)localObject1).SDm;
              if (localObject1 == null) {
                continue;
              }
              localObject1 = (apw)j.lp((List)localObject1);
              if (localObject1 == null) {
                continue;
              }
              localObject1 = ((apw)localObject1).SDl;
              if (localObject1 == null) {
                continue;
              }
              localObject1 = ((blj)localObject1).SPm;
              if (localObject1 == null) {
                continue;
              }
              if (((cvy)localObject1).id != ((cwk)localObject3).feedId) {
                break label651;
              }
              i = 1;
              label544:
              if (i == 0) {
                break label656;
              }
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label660;
              }
              localObject1 = ((cvy)localObject1).TEM;
              if (localObject1 == null) {
                break label436;
              }
              localObject1 = ((cwc)localObject1).media;
              if (localObject1 == null) {
                break label436;
              }
              localObject1 = (cwq)j.lp((List)localObject1);
              if (localObject1 == null) {
                break label436;
              }
              localMap = (Map)this.zKR;
              localObject2 = com.tencent.mm.plugin.finder.storage.data.i.a((cwq)localObject1).mediaId;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              p.j(localObject3, "info");
              localMap.put(localObject1, localObject3);
              break label436;
              break;
              i = 0;
              break label544;
              localObject1 = null;
            }
          }
        }
      }
    }
    Log.i("Finder.MediaPreloadModel", "[updatePreloadInfo]\nisSupportH265=" + zKW + '\n' + "[prev:next]Count=" + this.zKC + ':' + this.zKD + '\n' + "maxPreloadPercent=" + this.zKE + '\n' + "maxPreloadBitRate=" + this.zKL + ", maxPreloadBytes=" + Util.getSizeKB(this.zKF) + '\n' + "maxPreloadTaskCount=" + this.zKG + '\n' + "[preload:play]ConcurrentCount=" + this.zKH + ':' + this.zKI + '\n' + "[startPreloadSecs:startPreloadPercent]=" + this.zKK + ':' + this.zKJ + '\n' + "isOpenMultiBitRateDownload=" + this.zKT + '\n' + "hotFeed=" + this.zKQ.size() + '\n' + "megaVideo[prev:next]Count=" + this.zKO + ':' + this.zKP + '\n' + "megaVideoMaxBitrate=" + this.zKN + '\n' + "hotMegaVideoMediaSet=" + this.zKR.size() + '\n');
    if (parambhh != null)
    {
      paramHashMap = new LinkedList((Collection)parambhh.SRU);
      parambhh.SRU.clear();
      localObject1 = parambhh.toByteArray();
      localObject2 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      ((f)localObject2).aHp().set(ar.a.VzU, Util.encodeHexString((byte[])localObject1));
      Log.i("Finder.MediaPreloadModel", "[storePreloadInfo] buffer size=" + Util.getSizeKB(localObject1.length));
      parambhh.SRU.addAll((Collection)paramHashMap);
      AppMethodBeat.o(287547);
      return;
    }
    AppMethodBeat.o(287547);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Companion;", "", "()V", "CODING_H264", "", "CODING_H265", "TAG", "_2M", "", "defaultMaxPreloadTaskCount", "", "defaultNextCount", "defaultPlayConcurrentCount", "defaultPreloadConcurrentCount", "defaultPreloadMinSize", "defaultPreloadPercent", "", "defaultPrevCount", "defaultStartPreloadPercent", "defaultStartPreloadSecs", "isSupportH265", "", "getFinderMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "fileFormat", "plugin-finder_release"})
  public static final class a
  {
    public static u aDI(String paramString)
    {
      AppMethodBeat.i(272703);
      if (p.h(paramString, u.AlA.detail))
      {
        paramString = u.AlA;
        AppMethodBeat.o(272703);
        return paramString;
      }
      if (p.h(paramString, u.AlB.detail))
      {
        paramString = u.AlB;
        AppMethodBeat.o(272703);
        return paramString;
      }
      if (p.h(paramString, u.AlC.detail))
      {
        paramString = u.AlC;
        AppMethodBeat.o(272703);
        return paramString;
      }
      if (p.h(paramString, u.AlD.detail))
      {
        paramString = u.AlD;
        AppMethodBeat.o(272703);
        return paramString;
      }
      if (p.h(paramString, u.AlE.detail))
      {
        paramString = u.AlE;
        AppMethodBeat.o(272703);
        return paramString;
      }
      if (p.h(paramString, u.AlF.detail))
      {
        paramString = u.AlF;
        AppMethodBeat.o(272703);
        return paramString;
      }
      if (p.h(paramString, u.AlG.detail))
      {
        paramString = u.AlG;
        AppMethodBeat.o(272703);
        return paramString;
      }
      if (p.h(paramString, u.AlH.detail))
      {
        paramString = u.AlH;
        AppMethodBeat.o(272703);
        return paramString;
      }
      if (p.h(paramString, u.AlI.detail))
      {
        paramString = u.AlI;
        AppMethodBeat.o(272703);
        return paramString;
      }
      if (p.h(paramString, u.AlJ.detail))
      {
        paramString = u.AlJ;
        AppMethodBeat.o(272703);
        return paramString;
      }
      if (p.h(paramString, u.AlK.detail))
      {
        paramString = u.AlK;
        AppMethodBeat.o(272703);
        return paramString;
      }
      paramString = u.AlL;
      AppMethodBeat.o(272703);
      return paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "", "preloadPercent", "", "preloadMinSize", "", "fileFormat", "", "codingFormat", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocalDefault", "", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Z)V", "getCodingFormat", "()Ljava/lang/String;", "getFileFormat", "()Z", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getPreloadMinSize", "()J", "getPreloadPercent", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-finder_release"})
  public static final class b
  {
    private static final b zLa;
    public static final a zLb;
    public final String fPD;
    public final int iVi;
    public final long preloadMinSize;
    public final aa zBB;
    public final String zKY;
    private final boolean zKZ;
    
    static
    {
      AppMethodBeat.i(275213);
      zLb = new a((byte)0);
      zLa = new b(0, 0L, "", "", new aa(new csg(), u.AlL, 0, null, 12), (byte)0);
      AppMethodBeat.o(275213);
    }
    
    private b(int paramInt, long paramLong, String paramString1, String paramString2, aa paramaa)
    {
      AppMethodBeat.i(275212);
      this.iVi = paramInt;
      this.preloadMinSize = paramLong;
      this.fPD = paramString1;
      this.zKY = paramString2;
      this.zBB = paramaa;
      this.zKZ = false;
      AppMethodBeat.o(275212);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(275215);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.iVi != paramObject.iVi) || (this.preloadMinSize != paramObject.preloadMinSize) || (!p.h(this.fPD, paramObject.fPD)) || (!p.h(this.zKY, paramObject.zKY)) || (!p.h(this.zBB, paramObject.zBB)) || (this.zKZ != paramObject.zKZ)) {}
        }
      }
      else
      {
        AppMethodBeat.o(275215);
        return true;
      }
      AppMethodBeat.o(275215);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(275211);
      String str = this.iVi + "%:" + this.preloadMinSize + ':' + this.fPD;
      AppMethodBeat.o(275211);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail$Companion;", "", "()V", "NIL", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "getNIL", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(250211);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((av)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((av)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(250211);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<String>
  {
    d(JSONObject paramJSONObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.a
 * JD-Core Version:    0.7.0.1
 */