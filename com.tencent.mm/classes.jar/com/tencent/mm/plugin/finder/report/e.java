package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter;", "", "()V", "TAG", "", "isChangeTab", "", "reportedData", "", "Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "kotlin.jvm.PlatformType", "", "videoDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getData", "feedId", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "notifyChangeTab", "", "notifyDecodeStart", "(Ljava/lang/Long;)V", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPause", "notifyVideoPlay", "RecordData", "plugin-finder_release"})
public final class e
{
  public static final ConcurrentHashMap<Long, a> sxL;
  public static final Set<a> sxM;
  private static boolean sxN;
  public static final e sxO;
  
  static
  {
    AppMethodBeat.i(203758);
    sxO = new e();
    sxL = new ConcurrentHashMap();
    sxM = Collections.synchronizedSet((Set)new HashSet());
    AppMethodBeat.o(203758);
  }
  
  public static void cFk()
  {
    sxN = true;
  }
  
  public static List<anj> cFl()
  {
    AppMethodBeat.i(203757);
    LinkedList localLinkedList = new LinkedList();
    ??? = sxM;
    p.g(???, "reportedData");
    label396:
    for (;;)
    {
      Object localObject3;
      a locala;
      long l1;
      int i;
      long l2;
      synchronized ((Iterable)???)
      {
        localObject3 = ((Iterable)???).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label330;
        }
        locala = (a)((Iterator)localObject3).next();
        anj localanj = new anj();
        localanj.scene = 1;
        localanj.GFo = locala.sxU;
        if (locala.sxS > 0L)
        {
          l1 = locala.sxS;
          if ((l1 <= 0L) || (locala.sxR <= 0L)) {
            break label396;
          }
          i = (int)(l1 - locala.sxR);
          localanj.GFs = i;
          if (locala.sxS <= 0L) {
            break label292;
          }
          l1 = locala.sxS;
          if (locala.sxT <= 0L) {
            break label311;
          }
          l2 = locala.sxT;
          break label376;
          localanj.GFt = i;
          localLinkedList.add(localanj);
          ae.i("FinderHotspotChangeReporter", "finderFluencyInfo: scene = " + localanj.scene + ", hot = " + localanj.GFo + ", downloadToDecodeMs = " + localanj.GFs + ',' + " decodeToFirstFrameMs = " + localanj.GFt);
        }
      }
      if (locala.sxQ > 0L)
      {
        l1 = locala.sxQ;
        continue;
        label292:
        if (locala.sxP > 0L)
        {
          l1 = locala.sxP;
          continue;
          label311:
          if (locala.sxQ > 0L)
          {
            l2 = locala.sxQ;
            break label376;
            label330:
            localObject3 = z.Nhr;
            sxM.clear();
            List localList = (List)localObject1;
            AppMethodBeat.o(203757);
            return localList;
          }
          else
          {
            l2 = 0L;
          }
        }
        else
        {
          l1 = 0L;
          continue;
        }
      }
      else
      {
        l1 = 0L;
        continue;
      }
      label376:
      if ((l1 > 0L) && (l2 > 0L))
      {
        i = (int)(l2 - l1);
        continue;
        i = 0;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public static a wG(long paramLong)
  {
    AppMethodBeat.i(203756);
    a locala2 = (a)sxL.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      ((Map)sxL).put(Long.valueOf(paramLong), locala1);
    }
    AppMethodBeat.o(203756);
    return locala1;
  }
  
  public final void e(Long paramLong)
  {
    AppMethodBeat.i(203754);
    Object localObject;
    int i;
    if (paramLong != null)
    {
      paramLong.longValue();
      localObject = wG(paramLong.longValue());
      if (((a)localObject).sxR != 0L) {
        break label86;
      }
      i = 1;
      if (i == 0) {
        break label91;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((a)localObject).sxR = ch.aDc();
        if (localObject != null) {}
      }
      else
      {
        localObject = (e)this;
        sxL.remove(paramLong);
        ((e)localObject).e(paramLong);
        paramLong = z.Nhr;
      }
      AppMethodBeat.o(203754);
      return;
      AppMethodBeat.o(203754);
      return;
      label86:
      i = 0;
      break;
      label91:
      localObject = null;
    }
  }
  
  public final void f(Long paramLong)
  {
    int j = 1;
    AppMethodBeat.i(203755);
    Object localObject;
    if (paramLong != null)
    {
      paramLong.longValue();
      localObject = wG(paramLong.longValue());
      if (((a)localObject).sxP != 0L) {
        break label113;
      }
      i = 1;
      if (i == 0) {
        break label118;
      }
      label41:
      if (localObject != null)
      {
        ((a)localObject).sxP = ch.aDc();
        if (!sxN) {
          break label124;
        }
      }
    }
    label113:
    label118:
    label124:
    for (int i = j;; i = 2)
    {
      ((a)localObject).sxU = i;
      sxN = false;
      if (localObject == null)
      {
        localObject = (e)this;
        sxL.remove(paramLong);
        ((e)localObject).f(paramLong);
        paramLong = z.Nhr;
      }
      AppMethodBeat.o(203755);
      return;
      AppMethodBeat.o(203755);
      return;
      i = 0;
      break;
      localObject = null;
      break label41;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "", "()V", "changeHotpotType", "", "getChangeHotpotType", "()I", "setChangeHotpotType", "(I)V", "videoDecodeStart", "", "getVideoDecodeStart", "()J", "setVideoDecodeStart", "(J)V", "videoDownloadStart", "getVideoDownloadStart", "setVideoDownloadStart", "videoFirstFrame", "getVideoFirstFrame", "setVideoFirstFrame", "videoPause", "getVideoPause", "setVideoPause", "videoPlay", "getVideoPlay", "setVideoPlay", "plugin-finder_release"})
  public static final class a
  {
    public long sxP;
    public long sxQ;
    public long sxR;
    public long sxS;
    public long sxT;
    int sxU = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.e
 * JD-Core Version:    0.7.0.1
 */