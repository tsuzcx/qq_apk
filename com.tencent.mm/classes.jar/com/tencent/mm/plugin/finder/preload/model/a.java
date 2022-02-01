package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.a.j;
import d.g.b.p;
import d.k.h;
import d.l;
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
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "", "()V", "hotMediaSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadObjectInfo;", "getHotMediaSet", "()Ljava/util/concurrent/ConcurrentHashMap;", "setHotMediaSet", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "isMoovFailReady2DownloadAll", "", "()Z", "setMoovFailReady2DownloadAll", "(Z)V", "isOpenMultiBitRateDownload", "isSecondPreload", "setSecondPreload", "maxPreloadBitRate", "", "getMaxPreloadBitRate", "()J", "setMaxPreloadBitRate", "(J)V", "maxPreloadBytes", "getMaxPreloadBytes", "setMaxPreloadBytes", "maxPreloadPercent", "", "getMaxPreloadPercent", "()I", "setMaxPreloadPercent", "(I)V", "maxPreloadTaskCount", "getMaxPreloadTaskCount", "setMaxPreloadTaskCount", "nextCount", "getNextCount", "setNextCount", "playConcurrentCount", "getPlayConcurrentCount", "setPlayConcurrentCount", "preloadConcurrentCount", "getPreloadConcurrentCount", "setPreloadConcurrentCount", "preloadId", "getPreloadId", "setPreloadId", "prevCount", "getPrevCount", "setPrevCount", "startPreloadPercent", "getStartPreloadPercent", "setStartPreloadPercent", "startPreloadSecs", "getStartPreloadSecs", "setStartPreloadSecs", "findTargetSpec", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "maxBitRate", "query", "", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "isPreload", "storePreloadInfo", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "updatePreloadInfo", "feedSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "Detail", "plugin-finder_release"})
public final class a
{
  private static final boolean slt;
  public static final a slu;
  public boolean sle;
  public int slf;
  public int slg;
  public int slh;
  public long sli;
  public int slj;
  public int slk;
  public int sll;
  public int slm;
  public int sln;
  private long slo;
  public long slp;
  private ConcurrentHashMap<String, aqo> slq;
  public final boolean slr;
  public boolean sls;
  
  static
  {
    AppMethodBeat.i(166482);
    slu = new a((byte)0);
    slt = d.pf(4);
    AppMethodBeat.o(166482);
  }
  
  public a()
  {
    AppMethodBeat.i(166481);
    this.slf = 1;
    this.slg = 4;
    this.slh = d.h.a.co(30.000002F);
    this.sli = 2097152L;
    this.slj = 1;
    this.slk = 1;
    this.sll = 4;
    this.slm = d.h.a.co(0.0F);
    this.slq = new ConcurrentHashMap();
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.slr = com.tencent.mm.plugin.finder.storage.b.cGE();
    AppMethodBeat.o(166481);
  }
  
  private static o<apc, String> a(bvf parambvf, long paramLong)
  {
    AppMethodBeat.i(203054);
    String str2;
    String str1;
    Object localObject1;
    label44:
    int i;
    if (slt)
    {
      str2 = "h265";
      str1 = "step#1";
      localObject1 = parambvf.spec;
      p.g(localObject1, "media.spec");
      Object localObject2 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label382;
      }
      localObject1 = ((Iterator)localObject2).next();
      Object localObject3 = (apc)localObject1;
      if ((!n.H(((apc)localObject3).slv, str2, true)) || (((apc)localObject3).GnD >= paramLong)) {
        break label377;
      }
      i = 1;
      label97:
      if (i == 0) {
        break label380;
      }
      label101:
      localObject2 = (apc)localObject1;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label405;
      }
      str1 = "step#2";
      localObject1 = parambvf.spec;
      p.g(localObject1, "media.spec");
      localObject1 = (List)localObject1;
      localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
      while (((ListIterator)localObject2).hasPrevious())
      {
        localObject1 = ((ListIterator)localObject2).previous();
        if (n.H(((apc)localObject1).slv, str2, true))
        {
          label193:
          localObject2 = (apc)localObject1;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label405;
          }
          str1 = "step#3";
          parambvf = parambvf.spec;
          p.g(parambvf, "media.spec");
          parambvf = (List)parambvf;
          localObject2 = parambvf.listIterator(parambvf.size());
          label244:
          if (!((ListIterator)localObject2).hasPrevious()) {
            break label400;
          }
          localObject1 = ((ListIterator)localObject2).previous();
          localObject3 = ((apc)localObject1).slv;
          if (!p.i(str2, "h265")) {
            break label394;
          }
          parambvf = "h264";
          label287:
          if (!n.H((String)localObject3, parambvf, true)) {
            break label398;
          }
          parambvf = (bvf)localObject1;
          label300:
          parambvf = (apc)parambvf;
          localObject1 = parambvf;
          if (parambvf != null) {
            break label405;
          }
          parambvf = "step#4";
          localObject1 = new apc();
          ((apc)localObject1).dDf = r.syF.detail;
          ((apc)localObject1).slv = str2;
          ((apc)localObject1).GnC = 2097152;
        }
      }
    }
    for (;;)
    {
      parambvf = new o(localObject1, parambvf);
      AppMethodBeat.o(203054);
      return parambvf;
      str2 = "h264";
      break;
      label377:
      i = 0;
      break label97;
      label380:
      break label44;
      label382:
      localObject1 = null;
      break label101;
      localObject1 = null;
      break label193;
      label394:
      parambvf = "h265";
      break label287;
      label398:
      break label244;
      label400:
      parambvf = null;
      break label300;
      label405:
      parambvf = str1;
    }
  }
  
  public final List<b> a(bvf parambvf, boolean paramBoolean)
  {
    AppMethodBeat.i(203053);
    p.h(parambvf, "media");
    boolean bool = this.slr;
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = parambvf.mediaId;
    Object localObject3 = a(parambvf, this.slo);
    apc localapc = (apc)((o)localObject3).first;
    int i;
    Object localObject1;
    label160:
    int j;
    label200:
    long l;
    label348:
    float f;
    if (n.H(localapc.slv, "h265", true))
    {
      i = 2;
      Object localObject4;
      if ((paramBoolean) && (bool))
      {
        localObject1 = c.sAv;
        localObject1 = parambvf.mediaId;
        p.g(localObject1, "media.mediaId");
        localObject4 = ((Iterable)j.a((Iterable)c.aiE((String)localObject1), (Comparator)new c())).iterator();
      }
      for (;;)
      {
        if (((Iterator)localObject4).hasNext())
        {
          localObject1 = ((Iterator)localObject4).next();
          if (((y)localObject1).cCX())
          {
            localObject1 = (y)localObject1;
            if (localObject1 != null)
            {
              localObject4 = (CharSequence)((y)localObject1).field_fileFormat;
              if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
                break label723;
              }
              j = 1;
              if ((j == 0) && (localapc.dDf.hashCode() > ((y)localObject1).field_fileFormat.hashCode()))
              {
                ad.w("Finder.MediaPreloadModel", "[query] continue to use high fileFormat, [" + parambvf.mediaId + "] change[" + localapc.dDf + "->" + ((y)localObject1).field_fileFormat + ']');
                localapc.dDf = ((y)localObject1).field_fileFormat;
              }
            }
            if (!bool) {
              localapc.dDf = r.syQ.detail;
            }
            localObject1 = new m(parambvf, a.ahG(localapc.dDf), i, null, 8);
            if (localapc.GnC <= 0) {
              break label729;
            }
            l = localapc.GnC;
            localObject4 = localapc.dDf;
            p.g(localObject4, "targetSpec.fileFormat");
            String str = localapc.slv;
            p.g(str, "targetSpec.codingFormat");
            localLinkedList.add(new b(1, l, (String)localObject4, str, (m)localObject1, (byte)0));
            if ((!bool) || (this.slh <= 0)) {
              break label742;
            }
            this.sls = true;
            localObject4 = (aqo)this.slq.get(localObject2);
            if (localObject4 == null) {
              break label737;
            }
            f = ((aqo)localObject4).GoH;
            label443:
            i = Math.min(100, d.h.a.co(Math.max(1.0F, f * this.slh)));
            if ((aqo)this.slq.get(localObject2) != null)
            {
              localObject4 = localapc.dDf;
              p.g(localObject4, "targetSpec.fileFormat");
              str = localapc.slv;
              p.g(str, "targetSpec.codingFormat");
              localLinkedList.add(new b(i, 2097152L, (String)localObject4, str, (m)localObject1, (byte)0));
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = new StringBuilder("[query] isPreload=").append(paramBoolean).append(" mid=").append((String)localObject2).append(" stage=[").append((String)((o)localObject3).second).append(':').append(localLinkedList.size()).append("] target").append(b.a(localapc)).append(" details=").append(localLinkedList).append(", allSpec=");
      parambvf = parambvf.spec;
      p.g(parambvf, "media.spec");
      localObject2 = (Iterable)parambvf;
      parambvf = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (apc)((Iterator)localObject2).next();
        p.g(localObject3, "it");
        parambvf.add(b.a((apc)localObject3));
      }
      i = 1;
      break;
      localObject1 = null;
      break label160;
      label723:
      j = 0;
      break label200;
      label729:
      l = 2097152L;
      break label348;
      label737:
      f = 0.0F;
      break label443;
      label742:
      this.sls = false;
    }
    ad.i("Finder.MediaPreloadModel", (List)parambvf);
    parambvf = (List)localLinkedList;
    AppMethodBeat.o(203053);
    return parambvf;
  }
  
  public final void a(aqn paramaqn, HashMap<Long, FinderObject> paramHashMap)
  {
    AppMethodBeat.i(203052);
    p.h(paramaqn, "info");
    p.h(paramHashMap, "feedSet");
    this.slp = paramaqn.slp;
    Object localObject1 = paramaqn.GoF;
    Object localObject2;
    if (localObject1 != null)
    {
      this.slf = ((aqm)localObject1).slf;
      this.slg = ((aqm)localObject1).slg;
      this.slh = d.h.a.co(((aqm)localObject1).GoB * 100.0F);
      this.slo = ((aqm)localObject1).GoA;
      this.sli = ((aqm)localObject1).GoC;
      this.slj = h.lp(1, ((aqm)localObject1).GoD);
      this.slk = h.lp(1, ((aqm)localObject1).slk);
      this.sll = ((aqm)localObject1).sll;
      this.slm = d.h.a.co(((aqm)localObject1).GoE * 100.0F);
      this.sln = ((aqm)localObject1).sln;
      this.sle = false;
      localObject1 = paramaqn.GoG;
      p.g(localObject1, "info.objectInfos");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aqo)((Iterator)localObject1).next();
        Object localObject3 = (FinderObject)paramHashMap.get(Long.valueOf(((aqo)localObject2).dtq));
        if (localObject3 != null)
        {
          localObject3 = ((FinderObject)localObject3).objectDesc;
          if (localObject3 != null)
          {
            localObject3 = ((FinderObjectDesc)localObject3).media;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                Object localObject4 = (FinderMedia)((Iterator)localObject3).next();
                Map localMap = (Map)this.slq;
                p.g(localObject4, "it");
                localObject4 = i.a((FinderMedia)localObject4).mediaId;
                p.g(localObject4, "it.toLocal().mediaId");
                p.g(localObject2, "hot");
                localMap.put(localObject4, localObject2);
              }
            }
          }
        }
      }
    }
    ad.i("Finder.MediaPreloadModel", "[updatePreloadInfo]\nisSupportH265=" + slt + '\n' + "[prev:next]Count=" + this.slf + ':' + this.slg + '\n' + "maxPreloadPercent=" + this.slh + '\n' + "maxPreloadBitRate=" + bt.sy(this.slo) + "maxPreloadBytes=" + bt.sy(this.sli) + '\n' + "maxPreloadTaskCount=" + this.slj + '\n' + "[preload:play]ConcurrentCount=" + this.slk + ':' + this.sll + '\n' + "[startPreloadSecs:startPreloadPercent]=" + this.sln + ':' + this.slm + '\n' + "isOpenMultiBitRateDownload=" + this.slr + '\n' + "hotFeed=" + this.slq.size() + '\n');
    if (paramaqn != null)
    {
      paramHashMap = new LinkedList((Collection)paramaqn.GoG);
      paramaqn.GoG.clear();
      localObject1 = paramaqn.toByteArray();
      localObject2 = g.ajC();
      p.g(localObject2, "MMKernel.storage()");
      ((e)localObject2).ajl().set(al.a.IHv, bt.cE((byte[])localObject1));
      ad.i("Finder.MediaPreloadModel", "[storePreloadInfo] buffer size=" + bt.sy(localObject1.length));
      paramaqn.GoG.addAll((Collection)paramHashMap);
      AppMethodBeat.o(203052);
      return;
    }
    AppMethodBeat.o(203052);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Companion;", "", "()V", "CODING_H264", "", "CODING_H265", "TAG", "_2M", "", "defaultMaxPreloadTaskCount", "", "defaultNextCount", "defaultPlayConcurrentCount", "defaultPreloadConcurrentCount", "defaultPreloadMinSize", "defaultPreloadPercent", "", "defaultPrevCount", "defaultStartPreloadPercent", "defaultStartPreloadSecs", "isSupportH265", "", "getFinderMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "fileFormat", "plugin-finder_release"})
  public static final class a
  {
    public static r ahG(String paramString)
    {
      AppMethodBeat.i(203045);
      if (p.i(paramString, r.syF.detail))
      {
        paramString = r.syF;
        AppMethodBeat.o(203045);
        return paramString;
      }
      if (p.i(paramString, r.syG.detail))
      {
        paramString = r.syG;
        AppMethodBeat.o(203045);
        return paramString;
      }
      if (p.i(paramString, r.syH.detail))
      {
        paramString = r.syH;
        AppMethodBeat.o(203045);
        return paramString;
      }
      if (p.i(paramString, r.syI.detail))
      {
        paramString = r.syI;
        AppMethodBeat.o(203045);
        return paramString;
      }
      if (p.i(paramString, r.syJ.detail))
      {
        paramString = r.syJ;
        AppMethodBeat.o(203045);
        return paramString;
      }
      if (p.i(paramString, r.syK.detail))
      {
        paramString = r.syK;
        AppMethodBeat.o(203045);
        return paramString;
      }
      if (p.i(paramString, r.syL.detail))
      {
        paramString = r.syL;
        AppMethodBeat.o(203045);
        return paramString;
      }
      if (p.i(paramString, r.syM.detail))
      {
        paramString = r.syM;
        AppMethodBeat.o(203045);
        return paramString;
      }
      if (p.i(paramString, r.syN.detail))
      {
        paramString = r.syN;
        AppMethodBeat.o(203045);
        return paramString;
      }
      if (p.i(paramString, r.syO.detail))
      {
        paramString = r.syO;
        AppMethodBeat.o(203045);
        return paramString;
      }
      if (p.i(paramString, r.syP.detail))
      {
        paramString = r.syP;
        AppMethodBeat.o(203045);
        return paramString;
      }
      paramString = r.syQ;
      AppMethodBeat.o(203045);
      return paramString;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "", "preloadPercent", "", "preloadMinSize", "", "fileFormat", "", "codingFormat", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocalDefault", "", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Z)V", "getCodingFormat", "()Ljava/lang/String;", "getFileFormat", "()Z", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getPreloadMinSize", "()J", "getPreloadPercent", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-finder_release"})
  public static final class b
  {
    private static final b sly;
    public static final a slz;
    public final String dDf;
    public final int fJK;
    public final long preloadMinSize;
    public final String slv;
    public final m slw;
    private final boolean slx;
    
    static
    {
      AppMethodBeat.i(203048);
      slz = new a((byte)0);
      sly = new b(0, 0L, "", "", new m(new bvf(), r.syQ, 0, null, 12), (byte)0);
      AppMethodBeat.o(203048);
    }
    
    private b(int paramInt, long paramLong, String paramString1, String paramString2, m paramm)
    {
      AppMethodBeat.i(203047);
      this.fJK = paramInt;
      this.preloadMinSize = paramLong;
      this.dDf = paramString1;
      this.slv = paramString2;
      this.slw = paramm;
      this.slx = false;
      AppMethodBeat.o(203047);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203050);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.fJK != paramObject.fJK) || (this.preloadMinSize != paramObject.preloadMinSize) || (!p.i(this.dDf, paramObject.dDf)) || (!p.i(this.slv, paramObject.slv)) || (!p.i(this.slw, paramObject.slw)) || (this.slx != paramObject.slx)) {}
        }
      }
      else
      {
        AppMethodBeat.o(203050);
        return true;
      }
      AppMethodBeat.o(203050);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203046);
      String str = this.fJK + "%:" + this.preloadMinSize + ':' + this.dDf;
      AppMethodBeat.o(203046);
      return str;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail$Companion;", "", "()V", "NIL", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "getNIL", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(203051);
      int i = d.b.a.a((Comparable)Integer.valueOf(((y)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((y)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(203051);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.a
 * JD-Core Version:    0.7.0.1
 */