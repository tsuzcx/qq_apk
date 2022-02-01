package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.finder.cgi.p;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.a.j;
import d.g.b.k;
import d.k.h;
import d.n.n;
import d.o;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "", "()V", "hotMediaSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadObjectInfo;", "getHotMediaSet", "()Ljava/util/concurrent/ConcurrentHashMap;", "setHotMediaSet", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "isMoovFailReady2DownloadAll", "", "()Z", "setMoovFailReady2DownloadAll", "(Z)V", "localConfig", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$LocalConfig;", "getLocalConfig", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$LocalConfig;", "setLocalConfig", "(Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$LocalConfig;)V", "maxConcurrentCount", "", "getMaxConcurrentCount", "()I", "setMaxConcurrentCount", "(I)V", "maxPreloadBitRate", "", "getMaxPreloadBitRate", "()J", "setMaxPreloadBitRate", "(J)V", "maxPreloadBytes", "getMaxPreloadBytes", "setMaxPreloadBytes", "maxPreloadPercent", "getMaxPreloadPercent", "setMaxPreloadPercent", "nextCount", "getNextCount", "setNextCount", "preloadId", "getPreloadId", "setPreloadId", "prevCount", "getPrevCount", "setPrevCount", "findTargetSpec", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "maxBitRate", "query", "", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "isCareCache", "storePreloadInfo", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "updatePreloadInfo", "feedSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Companion", "Detail", "LocalConfig", "plugin-finder_release"})
public final class a
{
  private static final boolean rvN;
  public static final a.a rvO;
  public a.c rvD;
  public boolean rvE;
  public int rvF;
  public int rvG;
  private int rvH;
  public int rvI;
  private long rvJ;
  public long rvK;
  public long rvL;
  private ConcurrentHashMap<String, anc> rvM;
  
  static
  {
    AppMethodBeat.i(166482);
    rvO = new a.a((byte)0);
    rvN = d.oE(4);
    AppMethodBeat.o(166482);
  }
  
  public a()
  {
    AppMethodBeat.i(166481);
    this.rvM = new ConcurrentHashMap();
    AppMethodBeat.o(166481);
  }
  
  private final o<alw, String> a(bqs parambqs, long paramLong)
  {
    AppMethodBeat.i(202633);
    String str2;
    String str1;
    Object localObject1;
    label44:
    int i;
    if (rvN)
    {
      str2 = "h265";
      str1 = "step#1";
      localObject1 = parambqs.spec;
      k.g(localObject1, "media.spec");
      Object localObject2 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label390;
      }
      localObject1 = ((Iterator)localObject2).next();
      Object localObject3 = (alw)localObject1;
      if ((!n.I(((alw)localObject3).rvP, str2, true)) || (((alw)localObject3).EFp >= paramLong)) {
        break label384;
      }
      i = 1;
      label98:
      if (i == 0) {
        break label388;
      }
      label103:
      localObject2 = (alw)localObject1;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label413;
      }
      localObject3 = (a)this;
      str1 = "step#2";
      localObject1 = parambqs.spec;
      k.g(localObject1, "media.spec");
      localObject1 = (List)localObject1;
      localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
      while (((ListIterator)localObject2).hasPrevious())
      {
        localObject1 = ((ListIterator)localObject2).previous();
        if (n.I(((alw)localObject1).rvP, str2, true))
        {
          label201:
          localObject2 = (alw)localObject1;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label413;
          }
          str1 = "step#3";
          parambqs = parambqs.spec;
          k.g(parambqs, "media.spec");
          parambqs = (List)parambqs;
          localObject2 = parambqs.listIterator(parambqs.size());
          label251:
          if (!((ListIterator)localObject2).hasPrevious()) {
            break label408;
          }
          localObject1 = ((ListIterator)localObject2).previous();
          String str3 = ((alw)localObject1).rvP;
          if (!k.g(str2, "h265")) {
            break label402;
          }
          parambqs = "h264";
          label293:
          if (!n.I(str3, parambqs, true)) {
            break label406;
          }
          parambqs = (bqs)localObject1;
          label306:
          parambqs = (alw)parambqs;
          localObject1 = parambqs;
          if (parambqs != null) {
            break label413;
          }
          parambqs = "step#4";
          localObject1 = new alw();
          ((alw)localObject1).drn = m.rDS.detail;
          ((alw)localObject1).rvP = str2;
          ((alw)localObject1).EFo = ((int)((a)localObject3).rvJ);
        }
      }
    }
    for (;;)
    {
      parambqs = new o(localObject1, parambqs);
      AppMethodBeat.o(202633);
      return parambqs;
      str2 = "h264";
      break;
      label384:
      i = 0;
      break label98;
      label388:
      break label44;
      label390:
      localObject1 = null;
      break label103;
      localObject1 = null;
      break label201;
      label402:
      parambqs = "h265";
      break label293;
      label406:
      break label251;
      label408:
      parambqs = null;
      break label306;
      label413:
      parambqs = str1;
    }
  }
  
  public final List<a.b> a(bqs parambqs, boolean paramBoolean)
  {
    AppMethodBeat.i(202632);
    k.h(parambqs, "media");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    boolean bool = com.tencent.mm.plugin.finder.storage.b.cAk();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = parambqs.mediaId;
    Object localObject3 = a(parambqs, this.rvK);
    alw localalw = (alw)((o)localObject3).first;
    int i;
    Object localObject4;
    if (n.I(localalw.rvP, "h265", true))
    {
      i = 2;
      if ((paramBoolean) && (bool))
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        localObject1 = parambqs.mediaId;
        k.g(localObject1, "media.mediaId");
        localObject4 = ((Iterable)j.a((Iterable)com.tencent.mm.plugin.finder.storage.logic.c.aej((String)localObject1), (Comparator)new a.d())).iterator();
        for (;;)
        {
          if (((Iterator)localObject4).hasNext())
          {
            localObject1 = ((Iterator)localObject4).next();
            if (((w)localObject1).cwH())
            {
              label163:
              localObject1 = (w)localObject1;
              if (localObject1 != null)
              {
                localObject4 = (CharSequence)((w)localObject1).field_fileFormat;
                if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
                  break label708;
                }
              }
            }
          }
        }
      }
    }
    label708:
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        localObject4 = localalw.drn;
        str = ((w)localObject1).field_fileFormat;
        k.g(str, "it.field_fileFormat");
        if (((String)localObject4).compareTo(str) > 0)
        {
          ac.w("Finder.MediaPreloadModel", "[query] continue to use high fileFormat, [" + parambqs.mediaId + "] change[" + localalw.drn + "->" + ((w)localObject1).field_fileFormat + ']');
          localalw.drn = ((w)localObject1).field_fileFormat;
        }
      }
      if (!bool) {
        localalw.drn = m.rEd.detail;
      }
      localObject1 = new com.tencent.mm.plugin.finder.loader.l(parambqs, a.a.adK(localalw.drn), i, null, 8);
      long l = localalw.EFo;
      localObject4 = localalw.drn;
      k.g(localObject4, "targetSpec.fileFormat");
      String str = localalw.rvP;
      k.g(str, "targetSpec.codingFormat");
      localLinkedList.add(new a.b(1, l, (String)localObject4, str, (com.tencent.mm.plugin.finder.loader.l)localObject1, (byte)0));
      if (bool)
      {
        localObject4 = (anc)this.rvM.get(localObject2);
        if (localObject4 != null)
        {
          float f = this.rvH;
          i = Math.min(100, d.h.a.cj(((anc)localObject4).EGk * f));
          l = localalw.EFo;
          localObject4 = localalw.drn;
          k.g(localObject4, "targetSpec.fileFormat");
          str = localalw.rvP;
          k.g(str, "targetSpec.codingFormat");
          localLinkedList.add(new a.b(i, l, (String)localObject4, str, (com.tencent.mm.plugin.finder.loader.l)localObject1, (byte)0));
        }
      }
      localObject1 = new StringBuilder("[query] ").append(paramBoolean).append(" mid=").append((String)localObject2).append(" maxBitRate=").append(this.rvK).append(' ').append((String)((o)localObject3).second).append(" stage=").append(localLinkedList.size()).append(' ').append(b.a(localalw)).append(", ");
      parambqs = parambqs.spec;
      k.g(parambqs, "media.spec");
      localObject2 = (Iterable)parambqs;
      parambqs = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (alw)((Iterator)localObject2).next();
        k.g(localObject3, "it");
        parambqs.add(b.a((alw)localObject3));
      }
      i = 1;
      break;
      localObject1 = null;
      break label163;
    }
    ac.i("Finder.MediaPreloadModel", (List)parambqs);
    parambqs = (List)localLinkedList;
    AppMethodBeat.o(202632);
    return parambqs;
  }
  
  public final void a(anb paramanb, HashMap<Long, BaseFinderFeed> paramHashMap)
  {
    AppMethodBeat.i(202631);
    k.h(paramanb, "info");
    k.h(paramHashMap, "feedSet");
    this.rvL = paramanb.rvL;
    Object localObject1 = paramanb.EGi;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = new a.c();
      localObject1 = new ana();
      ((ana)localObject1).EGe = 0;
      ((ana)localObject1).EGg = ((int)((a.c)localObject2).rvU);
      ((ana)localObject1).EGf = (((a.c)localObject2).rvV / 100.0F);
      ((ana)localObject1).rvG = ((a.c)localObject2).rvX;
      ((ana)localObject1).rvF = ((a.c)localObject2).rvW;
    }
    for (;;)
    {
      localObject2 = this.rvD;
      Object localObject3;
      if (localObject2 != null)
      {
        this.rvF = ((a.c)localObject2).rvW;
        this.rvG = ((a.c)localObject2).rvX;
        this.rvH = d.h.a.cj(100.0F * ((a.c)localObject2).rvV);
        this.rvK = ((ana)localObject1).EGe;
        this.rvJ = ((a.c)localObject2).rvU;
        this.rvI = ((a.c)localObject2).rvY;
        this.rvE = false;
        if (paramanb != null)
        {
          localObject2 = paramanb.toByteArray();
          localObject3 = g.agR();
          k.g(localObject3, "MMKernel.storage()");
          ((e)localObject3).agA().set(ah.a.GUO, bs.cx((byte[])localObject2));
          ac.i("Finder.MediaPreloadModel", "[storePreloadInfo] buffer size=" + bs.qz(localObject2.length));
        }
        localObject2 = new StringBuilder();
        paramanb = paramanb.EGj;
        k.g(paramanb, "info.objectInfos");
        localObject3 = ((Iterable)paramanb).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label638;
        }
        localObject4 = (anc)((Iterator)localObject3).next();
        paramanb = (BaseFinderFeed)paramHashMap.get(Long.valueOf(((anc)localObject4).dig));
        if (paramanb == null) {
          break label535;
        }
      }
      Object localObject5;
      label535:
      for (paramanb = paramanb.feedObject;; paramanb = null)
      {
        if (paramanb == null) {
          break label540;
        }
        localObject5 = paramanb.getMediaList();
        if (localObject5 == null) {
          break label540;
        }
        localObject5 = ((Iterable)localObject5).iterator();
        bqs localbqs;
        for (int i = 0;; i = localbqs.spec.size() + i)
        {
          j = i;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localbqs = (bqs)((Iterator)localObject5).next();
          Map localMap = (Map)this.rvM;
          String str = localbqs.mediaId;
          k.g(str, "it.mediaId");
          k.g(localObject4, "hot");
          localMap.put(str, localObject4);
        }
        localObject2 = (a)this;
        ((a)localObject2).rvF = ((ana)localObject1).rvF;
        ((a)localObject2).rvG = ((ana)localObject1).rvG;
        ((a)localObject2).rvH = d.h.a.cj(100.0F * ((ana)localObject1).EGf);
        ((a)localObject2).rvK = ((ana)localObject1).EGe;
        ((a)localObject2).rvJ = ((ana)localObject1).EGg;
        ((a)localObject2).rvI = h.la(1, ((ana)localObject1).EGh);
        ((a)localObject2).rvE = false;
        break;
      }
      label540:
      int j = 0;
      Object localObject4 = ((StringBuilder)localObject2).append("feed=").append(com.tencent.mm.ac.c.pb(((anc)localObject4).dig) + " mid=");
      if (paramanb != null)
      {
        paramanb = paramanb.getFeedObject();
        if (paramanb != null) {
          localObject5 = p.qXG;
        }
      }
      for (paramanb = p.a(paramanb);; paramanb = null)
      {
        ((StringBuilder)localObject4).append(paramanb).append(" spec=").append(j).append("\n");
        break;
      }
      label638:
      paramanb = new StringBuilder("[updatePreloadInfo]\nisSupportH265=").append(rvN).append('\n').append("prevCount=").append(this.rvF).append("->").append(((ana)localObject1).rvF).append('\n').append("nextCount=").append(this.rvG).append("->").append(((ana)localObject1).rvG).append('\n').append("maxPreloadPercent=").append(this.rvH).append("->").append(((ana)localObject1).EGf * 100.0F).append('\n').append("maxPreloadBitRate=").append(this.rvK).append("->").append(((ana)localObject1).EGe).append('\n').append("maxPreloadBytes=").append(this.rvJ).append("->").append(((ana)localObject1).EGg).append('\n').append("maxConcurrentCount=").append(this.rvI).append("->").append(((ana)localObject1).EGh).append('\n').append("isUseLocal=");
      if (this.rvD != null) {}
      for (boolean bool = true;; bool = false)
      {
        paramanb = paramanb.append(bool).append('\n').append("isOpenMultiBitRateDownload=");
        paramHashMap = com.tencent.mm.plugin.finder.storage.b.rCU;
        paramanb = paramanb.append(com.tencent.mm.plugin.finder.storage.b.cAk()).append('\n').append("hotFeed=");
        localObject1 = (Map)this.rvM;
        paramHashMap = (Collection)new ArrayList(((Map)localObject1).size());
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          paramHashMap.add(com.tencent.mm.ac.c.pb(((anc)((Map.Entry)localObject3).getValue()).dig) + '=' + ((anc)((Map.Entry)localObject3).getValue()).EGk);
        }
      }
      ac.i("Finder.MediaPreloadModel", (List)paramHashMap + '\n' + localObject2);
      AppMethodBeat.o(202631);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail$Companion;", "", "()V", "NIL", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "getNIL", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "plugin-finder_release"})
  public static final class b$a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.a
 * JD-Core Version:    0.7.0.1
 */