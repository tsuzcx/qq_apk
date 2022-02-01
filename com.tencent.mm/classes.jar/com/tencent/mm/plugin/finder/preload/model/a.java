package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cnt;
import com.tencent.mm.protocal.protobuf.cod;
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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "", "()V", "findSpecStepMap", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "getFindSpecStepMap", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "hotMediaSet", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadObjectInfo;", "getHotMediaSet", "()Ljava/util/concurrent/ConcurrentHashMap;", "setHotMediaSet", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "hotMegaVideoMediaSet", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFinderPreloadObjectInfo;", "getHotMegaVideoMediaSet", "setHotMegaVideoMediaSet", "isMoovFailReady2DownloadAll", "", "()Z", "setMoovFailReady2DownloadAll", "(Z)V", "isOpenMultiBitRateDownload", "isSecondPreload", "setSecondPreload", "maxPreloadBitRate", "", "getMaxPreloadBitRate", "()J", "setMaxPreloadBitRate", "(J)V", "maxPreloadBytes", "getMaxPreloadBytes", "setMaxPreloadBytes", "maxPreloadPercent", "", "getMaxPreloadPercent", "()I", "setMaxPreloadPercent", "(I)V", "maxPreloadTaskCount", "getMaxPreloadTaskCount", "setMaxPreloadTaskCount", "megaVideoMaxBitrate", "getMegaVideoMaxBitrate", "setMegaVideoMaxBitrate", "megaVideoNextCount", "getMegaVideoNextCount", "setMegaVideoNextCount", "megaVideoPrevCount", "getMegaVideoPrevCount", "setMegaVideoPrevCount", "nextCount", "getNextCount", "setNextCount", "playConcurrentCount", "getPlayConcurrentCount", "setPlayConcurrentCount", "preloadConcurrentCount", "getPreloadConcurrentCount", "setPreloadConcurrentCount", "preloadId", "getPreloadId", "setPreloadId", "prevCount", "getPrevCount", "setPrevCount", "reportMap", "startPreloadPercent", "getStartPreloadPercent", "setStartPreloadPercent", "startPreloadSecs", "getStartPreloadSecs", "setStartPreloadSecs", "findTargetMedia", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedId", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "findTargetSpec", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "isPreload", "initConfig", "onExitFinder", "", "queryPreloadDetail", "", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "reportWithoutSpec", "defaultFileFormatV2", "targetFileFormat", "storePreloadInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "tranToH265IfEnable", "spec", "step", "specList", "updatePreloadInfo", "feedSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "Detail", "plugin-finder_release"})
public final class a
{
  private static final boolean uUG;
  public static final a uUH;
  private ConcurrentHashMap<String, bax> uUA;
  private ConcurrentHashMap<String, cnt> uUB;
  public final h<String, String> uUC;
  public final boolean uUD;
  public boolean uUE;
  public final ConcurrentHashMap<Long, Object> uUF;
  public boolean uUl;
  public int uUm;
  public int uUn;
  public int uUo;
  public long uUp;
  public int uUq;
  public int uUr;
  public int uUs;
  public int uUt;
  public int uUu;
  public long uUv;
  public long uUw;
  public long uUx;
  public int uUy;
  public int uUz;
  
  static
  {
    AppMethodBeat.i(166482);
    uUH = new a((byte)0);
    uUG = com.tencent.mm.modelcontrol.e.sX(4);
    AppMethodBeat.o(166482);
  }
  
  public a()
  {
    AppMethodBeat.i(166481);
    this.uUm = 1;
    this.uUn = 4;
    this.uUo = kotlin.h.a.cR(30.000002F);
    this.uUp = 2097152L;
    this.uUq = 1;
    this.uUr = 1;
    this.uUs = 4;
    this.uUt = kotlin.h.a.cR(0.0F);
    this.uUy = 1;
    this.uUz = 2;
    this.uUA = new ConcurrentHashMap();
    this.uUB = new ConcurrentHashMap();
    this.uUC = new h(300);
    c localc = c.vCb;
    this.uUD = c.dsh();
    this.uUF = new ConcurrentHashMap();
    AppMethodBeat.o(166481);
  }
  
  private static o<ayh, String> a(ayh paramayh, String paramString, List<? extends ayh> paramList)
  {
    AppMethodBeat.i(249549);
    Object localObject = c.vCb;
    if ((((Number)c.dvS().value()).intValue() != 1) || (!uUG))
    {
      paramList = new StringBuilder("[tranToH265IfEnable] config:");
      localObject = c.vCb;
      if (((Number)c.dvS().value()).intValue() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("Finder.MediaPreloadModel", bool + " , isSupportH265:" + uUG);
        paramayh = new o(paramayh, paramString);
        AppMethodBeat.o(249549);
        return paramayh;
      }
    }
    paramString = paramayh.dVY;
    localObject = paramayh.dVY;
    if (p.j(localObject, x.vEp.detail)) {
      if (paramList.isEmpty()) {
        paramayh.dVY = x.vEr.detail;
      }
    }
    for (;;)
    {
      Log.i("Finder.MediaPreloadModel", "[tranToH265IfEnable] oldFormat:" + paramString + " , newFormat:" + paramayh.dVY);
      paramayh = new o(paramayh, "step#5");
      AppMethodBeat.o(249549);
      return paramayh;
      paramayh.dVY = x.vEp.detail;
      continue;
      if (p.j(localObject, x.vEq.detail)) {
        paramayh.dVY = x.vEr.detail;
      } else if (p.j(localObject, x.vEs.detail)) {
        paramayh.dVY = x.vEt.detail;
      } else if (p.j(localObject, x.vEu.detail)) {
        paramayh.dVY = x.vEv.detail;
      } else if (p.j(localObject, x.vEw.detail)) {
        paramayh.dVY = x.vEx.detail;
      } else if (p.j(localObject, x.vEy.detail)) {
        paramayh.dVY = x.vEz.detail;
      }
    }
  }
  
  private final o<ayh, String> b(cjl paramcjl)
  {
    AppMethodBeat.i(249548);
    long l;
    String str1;
    label30:
    Object localObject2;
    Object localObject1;
    label61:
    int i;
    if (paramcjl.MoL == 3)
    {
      l = this.uUx;
      if (!uUG) {
        break label490;
      }
      str1 = "h265";
      localObject2 = "step#1";
      localObject1 = paramcjl.spec;
      p.g(localObject1, "media.spec");
      Object localObject3 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label503;
      }
      localObject1 = ((Iterator)localObject3).next();
      ayh localayh = (ayh)localObject1;
      if ((!n.I(localayh.uUI, str1, true)) || (localayh.LGa >= l)) {
        break label498;
      }
      i = 1;
      label114:
      if (i == 0) {
        break label501;
      }
      label118:
      localObject3 = (ayh)localObject1;
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label580;
      }
      localObject2 = "step#2";
      localObject1 = paramcjl.spec;
      p.g(localObject1, "media.spec");
      localObject1 = (List)localObject1;
      localObject3 = ((List)localObject1).listIterator(((List)localObject1).size());
      while (((ListIterator)localObject3).hasPrevious())
      {
        localObject1 = ((ListIterator)localObject3).previous();
        if (n.I(((ayh)localObject1).uUI, str1, true))
        {
          label212:
          localObject3 = (ayh)localObject1;
          localObject1 = localObject3;
          if (localObject3 != null) {
            break label580;
          }
          localObject1 = paramcjl.spec;
          p.g(localObject1, "media.spec");
          localObject3 = ((Iterable)localObject1).iterator();
          label254:
          if (!((Iterator)localObject3).hasNext()) {
            break label528;
          }
          localObject2 = ((Iterator)localObject3).next();
          localayh = (ayh)localObject2;
          String str2 = localayh.uUI;
          if (!p.j(str1, "h265")) {
            break label515;
          }
          localObject1 = "h264";
          label303:
          if ((!n.I(str2, (String)localObject1, true)) || (localayh.LGa >= l)) {
            break label523;
          }
          i = 1;
          label327:
          if (i == 0) {
            break label526;
          }
          localObject1 = localObject2;
          label335:
          localObject1 = (ayh)localObject1;
          if (localObject1 != null) {
            break label572;
          }
          localObject2 = "step#4";
          localObject1 = c.vCb;
          if (((Number)c.dvH().value()).longValue() != 0L)
          {
            localObject1 = paramcjl.spec;
            p.g(localObject1, "media.spec");
            if (((Collection)localObject1).isEmpty()) {
              break label534;
            }
            i = 1;
            label403:
            if (i == 0) {
              break label539;
            }
          }
          localObject1 = x.vEp.detail;
          label415:
          localObject3 = new ayh();
          ((ayh)localObject3).dVY = ((String)localObject1);
          ((ayh)localObject3).uUI = str1;
          ((ayh)localObject3).LEL = 2097152;
          localObject1 = localObject3;
        }
      }
    }
    label515:
    label523:
    label526:
    label528:
    label534:
    label539:
    label572:
    label580:
    for (;;)
    {
      paramcjl = paramcjl.spec;
      p.g(paramcjl, "media.spec");
      paramcjl = a((ayh)localObject1, (String)localObject2, (List)paramcjl);
      AppMethodBeat.o(249548);
      return paramcjl;
      l = this.uUv;
      break;
      label490:
      str1 = "h264";
      break label30;
      label498:
      i = 0;
      break label114;
      label501:
      break label61;
      label503:
      localObject1 = null;
      break label118;
      localObject1 = null;
      break label212;
      localObject1 = "h265";
      break label303;
      i = 0;
      break label327;
      break label254;
      localObject1 = null;
      break label335;
      i = 0;
      break label403;
      if (p.j(str1, "h265"))
      {
        localObject1 = x.vEr.detail;
        break label415;
      }
      localObject1 = x.vEq.detail;
      break label415;
      localObject2 = "step#3";
    }
  }
  
  public final s a(long paramLong, cjl paramcjl)
  {
    int i = 1;
    AppMethodBeat.i(249547);
    p.h(paramcjl, "media");
    long l = System.currentTimeMillis();
    Object localObject1 = b(paramcjl);
    Object localObject2 = (ayh)((o)localObject1).first;
    if (n.I(((ayh)localObject2).uUI, "h265", true)) {
      i = 2;
    }
    s locals = new s(paramcjl, a.aus(((ayh)localObject2).dVY), i, null, 8);
    this.uUC.put(locals.auA(), ((o)localObject1).second);
    localObject1 = new StringBuilder("[findTargetMedia] feedId=").append(com.tencent.mm.ac.d.zs(paramLong)).append(" stage=").append((String)((o)localObject1).second).append(' ').append("target").append(b.a((ayh)localObject2)).append(" allSpec=");
    paramcjl = paramcjl.spec;
    p.g(paramcjl, "media.spec");
    localObject2 = (Iterable)paramcjl;
    paramcjl = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ayh localayh = (ayh)((Iterator)localObject2).next();
      p.g(localayh, "it");
      paramcjl.add(b.a(localayh));
    }
    Log.i("Finder.MediaPreloadModel", (List)paramcjl + " Cost=" + (System.currentTimeMillis() - l) + ' ');
    AppMethodBeat.o(249547);
    return locals;
  }
  
  public final List<b> a(cjl paramcjl)
  {
    AppMethodBeat.i(249546);
    p.h(paramcjl, "media");
    long l2 = System.currentTimeMillis();
    boolean bool = this.uUD;
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = paramcjl.mediaId;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      p.g(localObject1, "media.mediaId ?: \"\"");
      o localo = b(paramcjl);
      ayh localayh = (ayh)localo.first;
      int i;
      Object localObject2;
      Object localObject3;
      label182:
      int j;
      label222:
      label246:
      s locals;
      long l1;
      label382:
      float f;
      if (n.I(localayh.uUI, "h265", true))
      {
        i = 2;
        if (bool)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          localObject3 = paramcjl.mediaId;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject3 = ((Iterable)kotlin.a.j.a((Iterable)com.tencent.mm.plugin.finder.storage.logic.d.avI((String)localObject2), (Comparator)new c())).iterator();
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = ((Iterator)localObject3).next();
          } while (!((at)localObject2).dkO());
          localObject2 = (at)localObject2;
          if (localObject2 != null)
          {
            localObject3 = (CharSequence)((at)localObject2).field_fileFormat;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label836;
            }
            j = 1;
            if (j == 0)
            {
              localObject3 = localayh.dVY;
              if (localObject3 == null) {
                break label842;
              }
              j = localObject3.hashCode();
              if (j > ((at)localObject2).field_fileFormat.hashCode())
              {
                Log.w("Finder.MediaPreloadModel", "[query] continue to use high fileFormat, [" + paramcjl.mediaId + "] change[" + localayh.dVY + "->" + ((at)localObject2).field_fileFormat + ']');
                localayh.dVY = ((at)localObject2).field_fileFormat;
              }
            }
          }
        }
        if (!bool) {
          localayh.dVY = x.vEA.detail;
        }
        locals = new s(paramcjl, a.aus(localayh.dVY), i, null, 8);
        if (localayh.LEL <= 0) {
          break label848;
        }
        l1 = localayh.LEL;
        localObject3 = localayh.dVY;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        String str = localayh.uUI;
        localObject3 = str;
        if (str == null) {
          localObject3 = "";
        }
        localLinkedList.add(new b(1, l1, (String)localObject2, (String)localObject3, locals, (byte)0));
        if ((!bool) || (this.uUo <= 0)) {
          break label921;
        }
        if (paramcjl.MoL != 3) {
          break label861;
        }
        localObject2 = (cnt)this.uUB.get(localObject1);
        if (localObject2 == null) {
          break label856;
        }
        f = ((cnt)localObject2).LKC;
        label492:
        j = Math.min(100, kotlin.h.a.cR(Math.max(1.0F, f * this.uUo)));
        if (paramcjl.MoL != 3) {
          break label899;
        }
        if (this.uUB.get(localObject1) == null) {
          break label894;
        }
        i = 1;
        label535:
        if (i != 0)
        {
          this.uUE = true;
          localObject3 = localayh.dVY;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          str = localayh.uUI;
          localObject3 = str;
          if (str == null) {
            localObject3 = "";
          }
          localLinkedList.add(new b(j, 2097152L, (String)localObject2, (String)localObject3, locals, (byte)0));
        }
      }
      for (;;)
      {
        this.uUC.put(locals.auA(), localo.second);
        localObject1 = new StringBuilder("[queryPreloadDetail] Cost=").append(System.currentTimeMillis() - l2).append(" isSecondPreload=").append(this.uUE).append(" mid=").append((String)localObject1).append(" stage=[").append((String)localo.second).append(':').append(localLinkedList.size()).append("] target").append(b.a(localayh)).append(" details=").append(localLinkedList).append(", allSpec=");
        paramcjl = paramcjl.spec;
        p.g(paramcjl, "media.spec");
        localObject2 = (Iterable)paramcjl;
        paramcjl = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ayh)((Iterator)localObject2).next();
          p.g(localObject3, "it");
          paramcjl.add(b.a((ayh)localObject3));
        }
        i = 1;
        break;
        localObject2 = null;
        break label182;
        label836:
        j = 0;
        break label222;
        label842:
        j = 0;
        break label246;
        label848:
        l1 = 2097152L;
        break label382;
        label856:
        f = 0.0F;
        break label492;
        label861:
        localObject2 = (bax)this.uUA.get(localObject1);
        if (localObject2 != null)
        {
          f = ((bax)localObject2).LKC;
          break label492;
        }
        f = 0.0F;
        break label492;
        label894:
        i = 0;
        break label535;
        label899:
        if (this.uUA.get(localObject1) != null)
        {
          i = 1;
          break label535;
        }
        i = 0;
        break label535;
        label921:
        this.uUE = false;
      }
      Log.i("Finder.MediaPreloadModel", (List)paramcjl);
      paramcjl = (List)localLinkedList;
      AppMethodBeat.o(249546);
      return paramcjl;
    }
  }
  
  public final void a(baw parambaw, HashMap<Long, FinderObject> paramHashMap)
  {
    AppMethodBeat.i(249545);
    p.h(parambaw, "info");
    p.h(paramHashMap, "feedSet");
    this.uUw = parambaw.uUw;
    Object localObject1 = parambaw.LKz;
    Object localObject2;
    if (localObject1 != null)
    {
      this.uUm = ((bav)localObject1).uUm;
      this.uUn = ((bav)localObject1).uUn;
      this.uUo = kotlin.h.a.cR(((bav)localObject1).LKu * 100.0F);
      this.uUv = ((bav)localObject1).LKt;
      this.uUp = ((bav)localObject1).LKv;
      this.uUq = kotlin.k.j.mZ(1, ((bav)localObject1).LKw);
      this.uUr = kotlin.k.j.mZ(1, ((bav)localObject1).uUr);
      this.uUs = ((bav)localObject1).uUs;
      this.uUt = kotlin.h.a.cR(((bav)localObject1).LKx * 100.0F);
      this.uUu = ((bav)localObject1).uUu;
      this.uUl = false;
      this.uUx = ((bav)localObject1).LKy;
      this.uUy = ((bav)localObject1).uUy;
      this.uUz = ((bav)localObject1).uUz;
      localObject1 = parambaw.LKA;
      Iterator localIterator1;
      Object localObject3;
      Iterator localIterator2;
      Map localMap;
      if (localObject1 != null)
      {
        localIterator1 = ((Iterable)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          localObject3 = (bax)localIterator1.next();
          localObject1 = (FinderObject)paramHashMap.get(Long.valueOf(((bax)localObject3).feedId));
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
                  localMap = (Map)this.uUA;
                  p.g(localObject1, "it");
                  localObject2 = com.tencent.mm.plugin.finder.storage.data.j.a((FinderMedia)localObject1).mediaId;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  p.g(localObject3, "hot");
                  localMap.put(localObject1, localObject3);
                }
              }
            }
          }
        }
      }
      localObject1 = parambaw.LKB;
      if (localObject1 != null)
      {
        localIterator1 = ((Iterable)localObject1).iterator();
        if (localIterator1.hasNext())
        {
          localObject3 = (cnt)localIterator1.next();
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
              localObject1 = ((aoq)localObject1).LAM;
              if (localObject1 == null) {
                continue;
              }
              localObject1 = (aop)kotlin.a.j.kt((List)localObject1);
              if (localObject1 == null) {
                continue;
              }
              localObject1 = ((aop)localObject1).LAL;
              if (localObject1 == null) {
                continue;
              }
              localObject1 = ((bei)localObject1).LIA;
              if (localObject1 == null) {
                continue;
              }
              if (((cng)localObject1).id != ((cnt)localObject3).feedId) {
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
              localObject1 = ((cng)localObject1).MtG;
              if (localObject1 == null) {
                break label436;
              }
              localObject1 = ((cnl)localObject1).media;
              if (localObject1 == null) {
                break label436;
              }
              localObject1 = (cod)kotlin.a.j.kt((List)localObject1);
              if (localObject1 == null) {
                break label436;
              }
              localMap = (Map)this.uUB;
              localObject2 = com.tencent.mm.plugin.finder.storage.data.j.a((cod)localObject1).mediaId;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              p.g(localObject3, "info");
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
    Log.i("Finder.MediaPreloadModel", "[updatePreloadInfo]\nisSupportH265=" + uUG + '\n' + "[prev:next]Count=" + this.uUm + ':' + this.uUn + '\n' + "maxPreloadPercent=" + this.uUo + '\n' + "maxPreloadBitRate=" + this.uUv + ", maxPreloadBytes=" + Util.getSizeKB(this.uUp) + '\n' + "maxPreloadTaskCount=" + this.uUq + '\n' + "[preload:play]ConcurrentCount=" + this.uUr + ':' + this.uUs + '\n' + "[startPreloadSecs:startPreloadPercent]=" + this.uUu + ':' + this.uUt + '\n' + "isOpenMultiBitRateDownload=" + this.uUD + '\n' + "hotFeed=" + this.uUA.size() + '\n' + "megaVideo[prev:next]Count=" + this.uUy + ':' + this.uUz + '\n' + "megaVideoMaxBitrate=" + this.uUx + '\n' + "hotMegaVideoMediaSet=" + this.uUB.size() + '\n');
    if (parambaw != null)
    {
      paramHashMap = new LinkedList((Collection)parambaw.LKA);
      parambaw.LKA.clear();
      localObject1 = parambaw.toByteArray();
      localObject2 = g.aAh();
      p.g(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject2).azQ().set(ar.a.OkZ, Util.encodeHexString((byte[])localObject1));
      Log.i("Finder.MediaPreloadModel", "[storePreloadInfo] buffer size=" + Util.getSizeKB(localObject1.length));
      parambaw.LKA.addAll((Collection)paramHashMap);
      AppMethodBeat.o(249545);
      return;
    }
    AppMethodBeat.o(249545);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Companion;", "", "()V", "CODING_H264", "", "CODING_H265", "TAG", "_2M", "", "defaultMaxPreloadTaskCount", "", "defaultNextCount", "defaultPlayConcurrentCount", "defaultPreloadConcurrentCount", "defaultPreloadMinSize", "defaultPreloadPercent", "", "defaultPrevCount", "defaultStartPreloadPercent", "defaultStartPreloadSecs", "isSupportH265", "", "getFinderMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "fileFormat", "plugin-finder_release"})
  public static final class a
  {
    public static x aus(String paramString)
    {
      AppMethodBeat.i(249538);
      if (p.j(paramString, x.vEp.detail))
      {
        paramString = x.vEp;
        AppMethodBeat.o(249538);
        return paramString;
      }
      if (p.j(paramString, x.vEq.detail))
      {
        paramString = x.vEq;
        AppMethodBeat.o(249538);
        return paramString;
      }
      if (p.j(paramString, x.vEr.detail))
      {
        paramString = x.vEr;
        AppMethodBeat.o(249538);
        return paramString;
      }
      if (p.j(paramString, x.vEs.detail))
      {
        paramString = x.vEs;
        AppMethodBeat.o(249538);
        return paramString;
      }
      if (p.j(paramString, x.vEt.detail))
      {
        paramString = x.vEt;
        AppMethodBeat.o(249538);
        return paramString;
      }
      if (p.j(paramString, x.vEu.detail))
      {
        paramString = x.vEu;
        AppMethodBeat.o(249538);
        return paramString;
      }
      if (p.j(paramString, x.vEv.detail))
      {
        paramString = x.vEv;
        AppMethodBeat.o(249538);
        return paramString;
      }
      if (p.j(paramString, x.vEw.detail))
      {
        paramString = x.vEw;
        AppMethodBeat.o(249538);
        return paramString;
      }
      if (p.j(paramString, x.vEx.detail))
      {
        paramString = x.vEx;
        AppMethodBeat.o(249538);
        return paramString;
      }
      if (p.j(paramString, x.vEy.detail))
      {
        paramString = x.vEy;
        AppMethodBeat.o(249538);
        return paramString;
      }
      if (p.j(paramString, x.vEz.detail))
      {
        paramString = x.vEz;
        AppMethodBeat.o(249538);
        return paramString;
      }
      paramString = x.vEA;
      AppMethodBeat.o(249538);
      return paramString;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "", "preloadPercent", "", "preloadMinSize", "", "fileFormat", "", "codingFormat", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocalDefault", "", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Z)V", "getCodingFormat", "()Ljava/lang/String;", "getFileFormat", "()Z", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getPreloadMinSize", "()J", "getPreloadPercent", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-finder_release"})
  public static final class b
  {
    private static final b uUK;
    public static final a uUL;
    public final String dVY;
    public final int gqZ;
    public final long preloadMinSize;
    public final s uPf;
    public final String uUI;
    private final boolean uUJ;
    
    static
    {
      AppMethodBeat.i(249541);
      uUL = new a((byte)0);
      uUK = new b(0, 0L, "", "", new s(new cjl(), x.vEA, 0, null, 12), (byte)0);
      AppMethodBeat.o(249541);
    }
    
    private b(int paramInt, long paramLong, String paramString1, String paramString2, s params)
    {
      AppMethodBeat.i(249540);
      this.gqZ = paramInt;
      this.preloadMinSize = paramLong;
      this.dVY = paramString1;
      this.uUI = paramString2;
      this.uPf = params;
      this.uUJ = false;
      AppMethodBeat.o(249540);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(249543);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.gqZ != paramObject.gqZ) || (this.preloadMinSize != paramObject.preloadMinSize) || (!p.j(this.dVY, paramObject.dVY)) || (!p.j(this.uUI, paramObject.uUI)) || (!p.j(this.uPf, paramObject.uPf)) || (this.uUJ != paramObject.uUJ)) {}
        }
      }
      else
      {
        AppMethodBeat.o(249543);
        return true;
      }
      AppMethodBeat.o(249543);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(249539);
      String str = this.gqZ + "%:" + this.preloadMinSize + ':' + this.dVY;
      AppMethodBeat.o(249539);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail$Companion;", "", "()V", "NIL", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "getNIL", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(249544);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((at)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((at)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(249544);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.a
 * JD-Core Version:    0.7.0.1
 */