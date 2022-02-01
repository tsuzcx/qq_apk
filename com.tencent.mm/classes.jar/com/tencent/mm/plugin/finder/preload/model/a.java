package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "", "()V", "findSpecStepMap", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "getFindSpecStepMap", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "hotMediaSet", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadObjectInfo;", "getHotMediaSet", "()Ljava/util/concurrent/ConcurrentHashMap;", "setHotMediaSet", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "isMoovFailReady2DownloadAll", "", "()Z", "setMoovFailReady2DownloadAll", "(Z)V", "isOpenMultiBitRateDownload", "isSecondPreload", "setSecondPreload", "maxPreloadBitRate", "", "getMaxPreloadBitRate", "()J", "setMaxPreloadBitRate", "(J)V", "maxPreloadBytes", "getMaxPreloadBytes", "setMaxPreloadBytes", "maxPreloadPercent", "", "getMaxPreloadPercent", "()I", "setMaxPreloadPercent", "(I)V", "maxPreloadTaskCount", "getMaxPreloadTaskCount", "setMaxPreloadTaskCount", "nextCount", "getNextCount", "setNextCount", "playConcurrentCount", "getPlayConcurrentCount", "setPlayConcurrentCount", "preloadConcurrentCount", "getPreloadConcurrentCount", "setPreloadConcurrentCount", "preloadId", "getPreloadId", "setPreloadId", "prevCount", "getPrevCount", "setPrevCount", "startPreloadPercent", "getStartPreloadPercent", "setStartPreloadPercent", "startPreloadSecs", "getStartPreloadSecs", "setStartPreloadSecs", "findTargetSpec", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "maxBitRate", "initConfig", "query", "", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "isPreload", "storePreloadInfo", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "updatePreloadInfo", "feedSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "Detail", "plugin-finder_release"})
public final class a
{
  private static final boolean sus;
  public static final a sut;
  public boolean sub;
  public int suc;
  public int sud;
  public int sue;
  public long suf;
  public int sug;
  public int suh;
  public int sui;
  public int suj;
  public int suk;
  public long sul;
  public long sun;
  private ConcurrentHashMap<String, ard> suo;
  public final h<String, String> sup;
  public final boolean suq;
  public boolean sur;
  
  static
  {
    AppMethodBeat.i(166482);
    sut = new a((byte)0);
    sus = d.pi(4);
    AppMethodBeat.o(166482);
  }
  
  public a()
  {
    AppMethodBeat.i(166481);
    this.suc = 1;
    this.sud = 4;
    this.sue = d.h.a.cm(30.000002F);
    this.suf = 2097152L;
    this.sug = 1;
    this.suh = 1;
    this.sui = 4;
    this.suj = d.h.a.cm(0.0F);
    this.suo = new ConcurrentHashMap();
    this.sup = new h(300);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.suq = com.tencent.mm.plugin.finder.storage.b.cIB();
    AppMethodBeat.o(166481);
  }
  
  private static o<app, String> a(bvz parambvz, long paramLong)
  {
    AppMethodBeat.i(203539);
    String str;
    Object localObject2;
    Object localObject1;
    label44:
    int i;
    if (sus)
    {
      str = "h265";
      localObject2 = "step#1";
      localObject1 = parambvz.spec;
      p.g(localObject1, "media.spec");
      Object localObject3 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label389;
      }
      localObject1 = ((Iterator)localObject3).next();
      Object localObject4 = (app)localObject1;
      if ((!n.H(((app)localObject4).suu, str, true)) || (((app)localObject4).GGJ >= paramLong)) {
        break label384;
      }
      i = 1;
      label97:
      if (i == 0) {
        break label387;
      }
      label101:
      localObject3 = (app)localObject1;
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label424;
      }
      localObject2 = "step#2";
      localObject1 = parambvz.spec;
      p.g(localObject1, "media.spec");
      localObject1 = (List)localObject1;
      localObject3 = ((List)localObject1).listIterator(((List)localObject1).size());
      while (((ListIterator)localObject3).hasPrevious())
      {
        localObject1 = ((ListIterator)localObject3).previous();
        if (n.H(((app)localObject1).suu, str, true))
        {
          label193:
          localObject3 = (app)localObject1;
          localObject1 = localObject3;
          if (localObject3 != null) {
            break label424;
          }
          parambvz = parambvz.spec;
          p.g(parambvz, "media.spec");
          localObject2 = ((Iterable)parambvz).iterator();
          label231:
          if (!((Iterator)localObject2).hasNext()) {
            break label412;
          }
          localObject1 = ((Iterator)localObject2).next();
          localObject3 = (app)localObject1;
          localObject4 = ((app)localObject3).suu;
          if (!p.i(str, "h265")) {
            break label401;
          }
          parambvz = "h264";
          label278:
          if ((!n.H((String)localObject4, parambvz, true)) || (((app)localObject3).GGJ >= paramLong)) {
            break label407;
          }
          i = 1;
          label301:
          if (i == 0) {
            break label410;
          }
          parambvz = (bvz)localObject1;
          label308:
          localObject1 = (app)parambvz;
          if (localObject1 != null) {
            break label417;
          }
          parambvz = "step#4";
          localObject1 = new app();
          ((app)localObject1).dEk = r.sJw.detail;
          ((app)localObject1).suu = str;
          ((app)localObject1).GGI = 2097152;
        }
      }
    }
    for (;;)
    {
      parambvz = new o(localObject1, parambvz);
      AppMethodBeat.o(203539);
      return parambvz;
      str = "h264";
      break;
      label384:
      i = 0;
      break label97;
      label387:
      break label44;
      label389:
      localObject1 = null;
      break label101;
      localObject1 = null;
      break label193;
      label401:
      parambvz = "h265";
      break label278;
      label407:
      i = 0;
      break label301;
      label410:
      break label231;
      label412:
      parambvz = null;
      break label308;
      label417:
      parambvz = "step#3";
      continue;
      label424:
      parambvz = (bvz)localObject2;
    }
  }
  
  public final List<b> a(bvz parambvz, boolean paramBoolean)
  {
    AppMethodBeat.i(203538);
    p.h(parambvz, "media");
    boolean bool = this.suq;
    LinkedList localLinkedList = new LinkedList();
    String str = parambvz.mediaId;
    o localo = a(parambvz, this.sul);
    app localapp = (app)localo.first;
    int i;
    Object localObject1;
    Object localObject2;
    label166:
    int j;
    label206:
    label230:
    m localm;
    long l;
    label367:
    Object localObject3;
    float f;
    if (n.H(localapp.suu, "h265", true))
    {
      i = 2;
      if ((paramBoolean) && (bool))
      {
        localObject1 = c.sLt;
        localObject2 = parambvz.mediaId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = ((Iterable)d.a.j.a((Iterable)c.ajB((String)localObject1), (Comparator)new c())).iterator();
      }
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (((z)localObject1).cEK())
          {
            localObject1 = (z)localObject1;
            if (localObject1 != null)
            {
              localObject2 = (CharSequence)((z)localObject1).field_fileFormat;
              if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
                break label807;
              }
              j = 1;
              if (j == 0)
              {
                localObject2 = localapp.dEk;
                if (localObject2 == null) {
                  break label813;
                }
                j = localObject2.hashCode();
                if (j > ((z)localObject1).field_fileFormat.hashCode())
                {
                  ae.w("Finder.MediaPreloadModel", "[query] continue to use high fileFormat, [" + parambvz.mediaId + "] change[" + localapp.dEk + "->" + ((z)localObject1).field_fileFormat + ']');
                  localapp.dEk = ((z)localObject1).field_fileFormat;
                }
              }
            }
            if (!bool) {
              localapp.dEk = r.sJH.detail;
            }
            localm = new m(parambvz, a.aiD(localapp.dEk), i, null, 8);
            if (localapp.GGI <= 0) {
              break label819;
            }
            l = localapp.GGI;
            localObject2 = localapp.dEk;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject3 = localapp.suu;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localLinkedList.add(new b(1, l, (String)localObject1, (String)localObject2, localm, (byte)0));
            if ((!bool) || (this.sue <= 0)) {
              break label832;
            }
            this.sur = true;
            localObject1 = (ard)((Map)this.suo).get(str);
            if (localObject1 == null) {
              break label827;
            }
            f = ((ard)localObject1).GHX;
            label479:
            i = Math.min(100, d.h.a.cm(Math.max(1.0F, f * this.sue)));
            if ((ard)((Map)this.suo).get(str) != null)
            {
              localObject2 = localapp.dEk;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localObject3 = localapp.suu;
              localObject2 = localObject3;
              if (localObject3 == null) {
                localObject2 = "";
              }
              localLinkedList.add(new b(i, 2097152L, (String)localObject1, (String)localObject2, localm, (byte)0));
            }
          }
        }
      }
    }
    for (;;)
    {
      this.sup.put(localm.aeM(), localo.second);
      localObject1 = new StringBuilder("[query] isPreload=").append(paramBoolean).append(" isSecondPreload=").append(this.sur).append(" mid=").append(str).append(" stage=[").append((String)localo.second).append(':').append(localLinkedList.size()).append("] target").append(b.a(localapp)).append(" details=").append(localLinkedList).append(", allSpec=");
      parambvz = parambvz.spec;
      p.g(parambvz, "media.spec");
      localObject2 = (Iterable)parambvz;
      parambvz = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (app)((Iterator)localObject2).next();
        p.g(localObject3, "it");
        parambvz.add(b.a((app)localObject3));
      }
      i = 1;
      break;
      localObject1 = null;
      break label166;
      label807:
      j = 0;
      break label206;
      label813:
      j = 0;
      break label230;
      label819:
      l = 2097152L;
      break label367;
      label827:
      f = 0.0F;
      break label479;
      label832:
      this.sur = false;
    }
    ae.i("Finder.MediaPreloadModel", (List)parambvz);
    parambvz = (List)localLinkedList;
    AppMethodBeat.o(203538);
    return parambvz;
  }
  
  public final void a(arc paramarc, HashMap<Long, FinderObject> paramHashMap)
  {
    AppMethodBeat.i(203537);
    p.h(paramarc, "info");
    p.h(paramHashMap, "feedSet");
    this.sun = paramarc.sun;
    Object localObject1 = paramarc.GHV;
    Object localObject2;
    if (localObject1 != null)
    {
      this.suc = ((arb)localObject1).suc;
      this.sud = ((arb)localObject1).sud;
      this.sue = d.h.a.cm(((arb)localObject1).GHR * 100.0F);
      this.sul = ((arb)localObject1).GHQ;
      this.suf = ((arb)localObject1).GHS;
      this.sug = d.k.j.lw(1, ((arb)localObject1).GHT);
      this.suh = d.k.j.lw(1, ((arb)localObject1).suh);
      this.sui = ((arb)localObject1).sui;
      this.suj = d.h.a.cm(((arb)localObject1).GHU * 100.0F);
      this.suk = ((arb)localObject1).suk;
      this.sub = false;
      localObject1 = paramarc.GHW;
      if (localObject1 != null)
      {
        Iterator localIterator1 = ((Iterable)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          ard localard = (ard)localIterator1.next();
          localObject1 = (FinderObject)paramHashMap.get(Long.valueOf(localard.duw));
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 != null)
            {
              localObject1 = ((FinderObjectDesc)localObject1).media;
              if (localObject1 != null)
              {
                Iterator localIterator2 = ((Iterable)localObject1).iterator();
                while (localIterator2.hasNext())
                {
                  localObject1 = (FinderMedia)localIterator2.next();
                  Map localMap = (Map)this.suo;
                  p.g(localObject1, "it");
                  localObject2 = i.a((FinderMedia)localObject1).mediaId;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  p.g(localard, "hot");
                  localMap.put(localObject1, localard);
                }
              }
            }
          }
        }
      }
    }
    ae.i("Finder.MediaPreloadModel", "[updatePreloadInfo]\nisSupportH265=" + sus + '\n' + "[prev:next]Count=" + this.suc + ':' + this.sud + '\n' + "maxPreloadPercent=" + this.sue + '\n' + "maxPreloadBitRate=" + this.sul + ", maxPreloadBytes=" + bu.sL(this.suf) + '\n' + "maxPreloadTaskCount=" + this.sug + '\n' + "[preload:play]ConcurrentCount=" + this.suh + ':' + this.sui + '\n' + "[startPreloadSecs:startPreloadPercent]=" + this.suk + ':' + this.suj + '\n' + "isOpenMultiBitRateDownload=" + this.suq + '\n' + "hotFeed=" + this.suo.size() + '\n');
    if (paramarc != null)
    {
      paramHashMap = new LinkedList((Collection)paramarc.GHW);
      paramarc.GHW.clear();
      localObject1 = paramarc.toByteArray();
      localObject2 = g.ajR();
      p.g(localObject2, "MMKernel.storage()");
      ((e)localObject2).ajA().set(am.a.JbY, bu.cH((byte[])localObject1));
      ae.i("Finder.MediaPreloadModel", "[storePreloadInfo] buffer size=" + bu.sL(localObject1.length));
      paramarc.GHW.addAll((Collection)paramHashMap);
      AppMethodBeat.o(203537);
      return;
    }
    AppMethodBeat.o(203537);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Companion;", "", "()V", "CODING_H264", "", "CODING_H265", "TAG", "_2M", "", "defaultMaxPreloadTaskCount", "", "defaultNextCount", "defaultPlayConcurrentCount", "defaultPreloadConcurrentCount", "defaultPreloadMinSize", "defaultPreloadPercent", "", "defaultPrevCount", "defaultStartPreloadPercent", "defaultStartPreloadSecs", "isSupportH265", "", "getFinderMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "fileFormat", "plugin-finder_release"})
  public static final class a
  {
    public static r aiD(String paramString)
    {
      AppMethodBeat.i(203530);
      if (p.i(paramString, r.sJw.detail))
      {
        paramString = r.sJw;
        AppMethodBeat.o(203530);
        return paramString;
      }
      if (p.i(paramString, r.sJx.detail))
      {
        paramString = r.sJx;
        AppMethodBeat.o(203530);
        return paramString;
      }
      if (p.i(paramString, r.sJy.detail))
      {
        paramString = r.sJy;
        AppMethodBeat.o(203530);
        return paramString;
      }
      if (p.i(paramString, r.sJz.detail))
      {
        paramString = r.sJz;
        AppMethodBeat.o(203530);
        return paramString;
      }
      if (p.i(paramString, r.sJA.detail))
      {
        paramString = r.sJA;
        AppMethodBeat.o(203530);
        return paramString;
      }
      if (p.i(paramString, r.sJB.detail))
      {
        paramString = r.sJB;
        AppMethodBeat.o(203530);
        return paramString;
      }
      if (p.i(paramString, r.sJC.detail))
      {
        paramString = r.sJC;
        AppMethodBeat.o(203530);
        return paramString;
      }
      if (p.i(paramString, r.sJD.detail))
      {
        paramString = r.sJD;
        AppMethodBeat.o(203530);
        return paramString;
      }
      if (p.i(paramString, r.sJE.detail))
      {
        paramString = r.sJE;
        AppMethodBeat.o(203530);
        return paramString;
      }
      if (p.i(paramString, r.sJF.detail))
      {
        paramString = r.sJF;
        AppMethodBeat.o(203530);
        return paramString;
      }
      if (p.i(paramString, r.sJG.detail))
      {
        paramString = r.sJG;
        AppMethodBeat.o(203530);
        return paramString;
      }
      paramString = r.sJH;
      AppMethodBeat.o(203530);
      return paramString;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "", "preloadPercent", "", "preloadMinSize", "", "fileFormat", "", "codingFormat", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocalDefault", "", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Z)V", "getCodingFormat", "()Ljava/lang/String;", "getFileFormat", "()Z", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getPreloadMinSize", "()J", "getPreloadPercent", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-finder_release"})
  public static final class b
  {
    private static final b sux;
    public static final a suy;
    public final String dEk;
    public final int fLN;
    public final long preloadMinSize;
    public final String suu;
    public final m suv;
    private final boolean suw;
    
    static
    {
      AppMethodBeat.i(203533);
      suy = new a((byte)0);
      sux = new b(0, 0L, "", "", new m(new bvz(), r.sJH, 0, null, 12), (byte)0);
      AppMethodBeat.o(203533);
    }
    
    private b(int paramInt, long paramLong, String paramString1, String paramString2, m paramm)
    {
      AppMethodBeat.i(203532);
      this.fLN = paramInt;
      this.preloadMinSize = paramLong;
      this.dEk = paramString1;
      this.suu = paramString2;
      this.suv = paramm;
      this.suw = false;
      AppMethodBeat.o(203532);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203535);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.fLN != paramObject.fLN) || (this.preloadMinSize != paramObject.preloadMinSize) || (!p.i(this.dEk, paramObject.dEk)) || (!p.i(this.suu, paramObject.suu)) || (!p.i(this.suv, paramObject.suv)) || (this.suw != paramObject.suw)) {}
        }
      }
      else
      {
        AppMethodBeat.o(203535);
        return true;
      }
      AppMethodBeat.o(203535);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203531);
      String str = this.fLN + "%:" + this.preloadMinSize + ':' + this.dEk;
      AppMethodBeat.o(203531);
      return str;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail$Companion;", "", "()V", "NIL", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "getNIL", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(203536);
      int i = d.b.a.a((Comparable)Integer.valueOf(((z)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((z)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(203536);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.a
 * JD-Core Version:    0.7.0.1
 */