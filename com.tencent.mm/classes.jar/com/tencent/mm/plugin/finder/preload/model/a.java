package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.finder.cgi.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.a.j;
import d.g.b.k;
import d.n.n;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "", "()V", "hotMediaSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadObjectInfo;", "getHotMediaSet", "()Ljava/util/concurrent/ConcurrentHashMap;", "setHotMediaSet", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "isMoovFailReady2DownloadAll", "", "()Z", "setMoovFailReady2DownloadAll", "(Z)V", "localConfig", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$LocalConfig;", "getLocalConfig", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$LocalConfig;", "setLocalConfig", "(Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$LocalConfig;)V", "maxConcurrentCount", "", "getMaxConcurrentCount", "()I", "setMaxConcurrentCount", "(I)V", "maxPreloadBitRate", "", "getMaxPreloadBitRate", "()J", "setMaxPreloadBitRate", "(J)V", "maxPreloadBytes", "getMaxPreloadBytes", "setMaxPreloadBytes", "maxPreloadPercent", "getMaxPreloadPercent", "setMaxPreloadPercent", "nextCount", "getNextCount", "setNextCount", "preloadId", "getPreloadId", "setPreloadId", "prevCount", "getPrevCount", "setPrevCount", "findTargetSpec", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "maxBitRate", "query", "", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "isCareCache", "storePreloadInfo", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "updatePreloadInfo", "feedSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Companion", "Detail", "LocalConfig", "plugin-finder_release"})
public final class a
{
  private static final boolean KTV;
  public static final a qEC;
  public int Dmf;
  public long Dmj;
  public c KTO;
  public boolean KTP;
  private int KTQ;
  public int KTR;
  private long KTS;
  public long KTT;
  private ConcurrentHashMap<String, akq> KTU;
  public int wAk;
  
  static
  {
    AppMethodBeat.i(166482);
    qEC = new a((byte)0);
    KTV = d.nQ(4);
    AppMethodBeat.o(166482);
  }
  
  public a()
  {
    AppMethodBeat.i(166481);
    this.KTU = new ConcurrentHashMap();
    AppMethodBeat.o(166481);
  }
  
  private final o<ajt, String> a(bmd parambmd, long paramLong)
  {
    AppMethodBeat.i(198706);
    String str2;
    String str1;
    Object localObject1;
    label44:
    int i;
    if (KTV)
    {
      str2 = "h265";
      str1 = "step#1";
      localObject1 = parambmd.spec;
      k.g(localObject1, "media.spec");
      Object localObject2 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label390;
      }
      localObject1 = ((Iterator)localObject2).next();
      Object localObject3 = (ajt)localObject1;
      if ((!n.I(((ajt)localObject3).KTW, str2, true)) || (((ajt)localObject3).DlI >= paramLong)) {
        break label384;
      }
      i = 1;
      label98:
      if (i == 0) {
        break label388;
      }
      label103:
      localObject2 = (ajt)localObject1;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label413;
      }
      localObject3 = (a)this;
      str1 = "step#2";
      localObject1 = parambmd.spec;
      k.g(localObject1, "media.spec");
      localObject1 = (List)localObject1;
      localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
      while (((ListIterator)localObject2).hasPrevious())
      {
        localObject1 = ((ListIterator)localObject2).previous();
        if (n.I(((ajt)localObject1).KTW, str2, true))
        {
          label201:
          localObject2 = (ajt)localObject1;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label413;
          }
          str1 = "step#3";
          parambmd = parambmd.spec;
          k.g(parambmd, "media.spec");
          parambmd = (List)parambmd;
          localObject2 = parambmd.listIterator(parambmd.size());
          label251:
          if (!((ListIterator)localObject2).hasPrevious()) {
            break label408;
          }
          localObject1 = ((ListIterator)localObject2).previous();
          String str3 = ((ajt)localObject1).KTW;
          if (!k.g(str2, "h265")) {
            break label402;
          }
          parambmd = "h264";
          label293:
          if (!n.I(str3, parambmd, true)) {
            break label406;
          }
          parambmd = (bmd)localObject1;
          label306:
          parambmd = (ajt)parambmd;
          localObject1 = parambmd;
          if (parambmd != null) {
            break label413;
          }
          parambmd = "step#4";
          localObject1 = new ajt();
          ((ajt)localObject1).DkS = com.tencent.mm.plugin.finder.storage.h.KWP.detail;
          ((ajt)localObject1).KTW = str2;
          ((ajt)localObject1).DlH = ((int)((a)localObject3).KTS);
        }
      }
    }
    for (;;)
    {
      parambmd = new o(localObject1, parambmd);
      AppMethodBeat.o(198706);
      return parambmd;
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
      parambmd = "h265";
      break label293;
      label406:
      break label251;
      label408:
      parambmd = null;
      break label306;
      label413:
      parambmd = str1;
    }
  }
  
  public final List<b> a(bmd parambmd, boolean paramBoolean)
  {
    AppMethodBeat.i(198705);
    k.h(parambmd, "media");
    Object localObject1 = b.qJA;
    boolean bool = b.fUN();
    LinkedList localLinkedList = new LinkedList();
    String str1 = parambmd.mediaId;
    o localo = a(parambmd, this.KTT);
    ajt localajt = (ajt)localo.first;
    int i;
    Object localObject2;
    if (n.I(localajt.KTW, "h265", true))
    {
      i = 2;
      if ((paramBoolean) && (bool))
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
        localObject1 = parambmd.mediaId;
        k.g(localObject1, "media.mediaId");
        localObject2 = ((Iterable)j.a((Iterable)com.tencent.mm.plugin.finder.storage.logic.c.aVB((String)localObject1), (Comparator)new d())).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = ((Iterator)localObject2).next();
            if (((r)localObject1).cnn())
            {
              label163:
              localObject1 = (r)localObject1;
              if (localObject1 != null)
              {
                localObject2 = (CharSequence)((r)localObject1).field_fileFormat;
                if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
                  break label719;
                }
              }
            }
          }
        }
      }
    }
    label719:
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        localObject2 = localajt.DkS;
        String str2 = ((r)localObject1).field_fileFormat;
        k.g(str2, "it.field_fileFormat");
        if (((String)localObject2).compareTo(str2) > 0)
        {
          ad.w("Finder.MediaPreloadModel", "[query] continue to use high fileFormat, [" + parambmd.mediaId + "] change[" + localajt.DkS + "->" + ((r)localObject1).field_fileFormat + ']');
          localajt.DkS = ((r)localObject1).field_fileFormat;
        }
      }
      if (!bool) {
        localajt.DkS = com.tencent.mm.plugin.finder.storage.h.KXa.detail;
      }
      parambmd = new com.tencent.mm.plugin.finder.loader.l(parambmd, a.aVr(localajt.DkS), i, null, 8);
      long l = localajt.DlH;
      localObject1 = localajt.DkS;
      k.g(localObject1, "targetSpec.fileFormat");
      localObject2 = localajt.KTW;
      k.g(localObject2, "targetSpec.codingFormat");
      localLinkedList.add(new b(1, l, (String)localObject1, (String)localObject2, parambmd, (byte)0));
      if (bool)
      {
        localObject1 = (akq)this.KTU.get(str1);
        if ((localObject1 != null) && (((akq)localObject1).Dmm > 1.0F))
        {
          float f = this.KTQ;
          i = d.h.a.bU(d.k.h.ar(1.0F, ((akq)localObject1).Dmm * f));
          l = localajt.DlH;
          localObject1 = localajt.DkS;
          k.g(localObject1, "targetSpec.fileFormat");
          localObject2 = localajt.KTW;
          k.g(localObject2, "targetSpec.codingFormat");
          localLinkedList.add(new b(i, l, (String)localObject1, (String)localObject2, parambmd, (byte)0));
        }
      }
      parambmd = new StringBuilder("[query] mid=").append(str1).append(" maxBitRate=").append(this.KTT).append(' ').append((String)localo.second).append(" stageSize=").append(localLinkedList.size()).append(' ');
      k.h(localajt, "$this$print");
      ad.i("Finder.MediaPreloadModel", new StringBuilder("Spec[").append(localajt.KTW).append(' ').append(localajt.DkS).append(" firstLoad=").append(bt.mK(localajt.DlH)).append(" bitRate=").append(bt.mK(localajt.DlI)).append(']').toString() + ", isCareCache=" + paramBoolean);
      parambmd = (List)localLinkedList;
      AppMethodBeat.o(198705);
      return parambmd;
      i = 1;
      break;
      localObject1 = null;
      break label163;
    }
  }
  
  public final void a(akp paramakp, HashMap<Long, BaseFinderFeed> paramHashMap)
  {
    AppMethodBeat.i(198704);
    k.h(paramakp, "info");
    k.h(paramHashMap, "feedSet");
    this.Dmj = paramakp.Dmj;
    Object localObject1 = paramakp.Dmk;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = new c();
      localObject1 = new ako();
      ((ako)localObject1).Dmg = 0;
      ((ako)localObject1).Dmi = ((int)((c)localObject2).KUa);
      ((ako)localObject1).Dmh = (((c)localObject2).KUb / 100.0F);
      ((ako)localObject1).wAk = ((c)localObject2).KUd;
      ((ako)localObject1).Dmf = ((c)localObject2).KUc;
    }
    for (;;)
    {
      localObject2 = this.KTO;
      Object localObject3;
      if (localObject2 != null)
      {
        this.Dmf = ((c)localObject2).KUc;
        this.wAk = ((c)localObject2).KUd;
        this.KTQ = d.h.a.bU(100.0F * ((c)localObject2).KUb);
        this.KTT = ((ako)localObject1).Dmg;
        this.KTS = ((c)localObject2).KUa;
        this.KTR = ((c)localObject2).KUe;
        this.KTP = false;
        if (paramakp != null)
        {
          localObject2 = paramakp.toByteArray();
          localObject3 = g.afB();
          k.g(localObject3, "MMKernel.storage()");
          ((e)localObject3).afk().set(ae.a.LBc, bt.cy((byte[])localObject2));
          ad.i("Finder.MediaPreloadModel", "[storePreloadInfo] buffer size=" + bt.mK(localObject2.length));
        }
        localObject2 = new StringBuilder();
        paramakp = paramakp.Dml;
        k.g(paramakp, "info.objectInfos");
        localObject3 = ((Iterable)paramakp).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label638;
        }
        localObject4 = (akq)((Iterator)localObject3).next();
        paramakp = (BaseFinderFeed)paramHashMap.get(Long.valueOf(((akq)localObject4).feedId));
        if (paramakp == null) {
          break label535;
        }
      }
      Object localObject5;
      int i;
      label535:
      for (paramakp = paramakp.feedObject;; paramakp = null)
      {
        if (paramakp == null) {
          break label540;
        }
        localObject5 = paramakp.getMediaList();
        if (localObject5 == null) {
          break label540;
        }
        localObject5 = ((Iterable)localObject5).iterator();
        bmd localbmd;
        for (i = 0;; i = localbmd.spec.size() + i)
        {
          j = i;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localbmd = (bmd)((Iterator)localObject5).next();
          Map localMap = (Map)this.KTU;
          String str = localbmd.mediaId;
          k.g(str, "it.mediaId");
          k.g(localObject4, "hot");
          localMap.put(str, localObject4);
        }
        localObject2 = (a)this;
        ((a)localObject2).Dmf = ((ako)localObject1).Dmf;
        ((a)localObject2).wAk = ((ako)localObject1).wAk;
        ((a)localObject2).KTQ = d.h.a.bU(100.0F * ((ako)localObject1).Dmh);
        ((a)localObject2).KTT = ((ako)localObject1).Dmg;
        ((a)localObject2).KTS = ((ako)localObject1).Dmi;
        ((a)localObject2).KTR = d.k.h.kK(1, ((ako)localObject1).Lya);
        ((a)localObject2).KTP = false;
        break;
      }
      label540:
      int j = 0;
      Object localObject4 = ((StringBuilder)localObject2).append("feed=").append(com.tencent.mm.ad.c.ly(((akq)localObject4).feedId) + " mid=");
      if (paramakp != null)
      {
        paramakp = paramakp.getFeedObject();
        if (paramakp != null) {
          localObject5 = i.qoK;
        }
      }
      for (paramakp = i.h(paramakp);; paramakp = null)
      {
        ((StringBuilder)localObject4).append(paramakp).append(" spec=").append(j).append("\n");
        break;
      }
      label638:
      paramakp = new StringBuilder("[updatePreloadInfo]\nprevCount=").append(this.Dmf).append("->").append(((ako)localObject1).Dmf).append('\n').append("nextCount=").append(this.wAk).append("->").append(((ako)localObject1).wAk).append('\n').append("maxPreloadPercent=").append(this.KTQ).append("->").append(((ako)localObject1).Dmh * 100.0F).append('\n').append("maxPreloadBitRate=").append(this.KTT).append("->").append(((ako)localObject1).Dmg).append('\n').append("maxPreloadBytes=").append(this.KTS).append("->").append(((ako)localObject1).Dmi).append('\n').append("maxConcurrentCount=").append(this.KTR).append("->").append(((ako)localObject1).Lya).append('\n').append("isUseLocal=");
      boolean bool;
      if (this.KTO != null)
      {
        bool = true;
        paramakp = paramakp.append(bool).append('\n').append("isOpenMultiBitRateDownload=");
        paramHashMap = b.qJA;
        paramakp = paramakp.append(b.fUN()).append('\n').append("hotFeed=");
        localObject1 = (Map)this.KTU;
        paramHashMap = (Map)new LinkedHashMap();
        localObject1 = ((Map)localObject1).entrySet().iterator();
      }
      label930:
      label1009:
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1011;
        }
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if (((akq)((Map.Entry)localObject3).getValue()).Dmm > 1.0F) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1009;
          }
          paramHashMap.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
          break label930;
          bool = false;
          break;
        }
      }
      label1011:
      localObject1 = (Collection)new ArrayList(paramHashMap.size());
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject3 = (Map.Entry)paramHashMap.next();
        ((Collection)localObject1).add(com.tencent.mm.ad.c.ly(((akq)((Map.Entry)localObject3).getValue()).feedId) + '=' + ((akq)((Map.Entry)localObject3).getValue()).Dmm);
      }
      ad.i("Finder.MediaPreloadModel", (List)localObject1 + '\n' + localObject2);
      AppMethodBeat.o(198704);
      return;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Companion;", "", "()V", "CODING_H264", "", "CODING_H265", "TAG", "_2M", "", "isSupportH265", "", "getFinderMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "fileFormat", "plugin-finder_release"})
  public static final class a
  {
    public static com.tencent.mm.plugin.finder.storage.h aVr(String paramString)
    {
      AppMethodBeat.i(198697);
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWP.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWP;
        AppMethodBeat.o(198697);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWQ.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWQ;
        AppMethodBeat.o(198697);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWR.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWR;
        AppMethodBeat.o(198697);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWS.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWS;
        AppMethodBeat.o(198697);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWT.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWT;
        AppMethodBeat.o(198697);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWU.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWU;
        AppMethodBeat.o(198697);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWV.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWV;
        AppMethodBeat.o(198697);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWW.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWW;
        AppMethodBeat.o(198697);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWX.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWX;
        AppMethodBeat.o(198697);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWY.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWY;
        AppMethodBeat.o(198697);
        return paramString;
      }
      if (k.g(paramString, com.tencent.mm.plugin.finder.storage.h.KWZ.detail))
      {
        paramString = com.tencent.mm.plugin.finder.storage.h.KWZ;
        AppMethodBeat.o(198697);
        return paramString;
      }
      paramString = com.tencent.mm.plugin.finder.storage.h.KXa;
      AppMethodBeat.o(198697);
      return paramString;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "", "preloadPercent", "", "preloadMinSize", "", "fileFormat", "", "codingFormat", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocalDefault", "", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Z)V", "getCodingFormat", "()Ljava/lang/String;", "getFileFormat", "()Z", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getPreloadMinSize", "()J", "getPreloadPercent", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "plugin-finder_release"})
  public static final class b
  {
    private static final b KTY;
    public static final a KTZ;
    public final String DkS;
    public final String KTW;
    private final boolean KTX;
    public final int foh;
    public final long preloadMinSize;
    public final com.tencent.mm.plugin.finder.loader.l qUh;
    
    static
    {
      AppMethodBeat.i(198700);
      KTZ = new a((byte)0);
      KTY = new b(0, 0L, "", "", new com.tencent.mm.plugin.finder.loader.l(new bmd(), com.tencent.mm.plugin.finder.storage.h.KXa, 0, null, 12), (byte)0);
      AppMethodBeat.o(198700);
    }
    
    private b(int paramInt, long paramLong, String paramString1, String paramString2, com.tencent.mm.plugin.finder.loader.l paraml)
    {
      AppMethodBeat.i(198699);
      this.foh = paramInt;
      this.preloadMinSize = paramLong;
      this.DkS = paramString1;
      this.KTW = paramString2;
      this.qUh = paraml;
      this.KTX = false;
      AppMethodBeat.o(198699);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(198702);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.foh != paramObject.foh) || (this.preloadMinSize != paramObject.preloadMinSize) || (!k.g(this.DkS, paramObject.DkS)) || (!k.g(this.KTW, paramObject.KTW)) || (!k.g(this.qUh, paramObject.qUh)) || (this.KTX != paramObject.KTX)) {}
        }
      }
      else
      {
        AppMethodBeat.o(198702);
        return true;
      }
      AppMethodBeat.o(198702);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(198698);
      String str = this.foh + "%:" + this.preloadMinSize + "bytes:format=" + this.DkS + ':' + this.KTW + " isLocalDefault=" + this.KTX;
      AppMethodBeat.o(198698);
      return str;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail$Companion;", "", "()V", "NIL", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "getNIL", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "plugin-finder_release"})
    public static final class a {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$LocalConfig;", "", "()V", "defaultMaxConcurrentCount", "", "getDefaultMaxConcurrentCount", "()I", "defaultNextCount", "getDefaultNextCount", "defaultPreloadMinSize", "", "getDefaultPreloadMinSize", "()J", "defaultPreloadPercent", "getDefaultPreloadPercent", "defaultPrevCount", "getDefaultPrevCount", "toPreloadGlobalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadGlobalInfo;", "plugin-finder_release"})
  public static final class c
  {
    final long KUa = 2097152L;
    public final int KUb = 1;
    public final int KUc = 1;
    public final int KUd = 4;
    public final int KUe = 2;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class d<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(198703);
      int i = d.b.a.a((Comparable)((r)paramT1).field_fileFormat, (Comparable)((r)paramT2).field_fileFormat);
      AppMethodBeat.o(198703);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.a
 * JD-Core Version:    0.7.0.1
 */