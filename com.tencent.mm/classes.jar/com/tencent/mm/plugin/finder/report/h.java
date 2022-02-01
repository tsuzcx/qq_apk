package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter;", "", "()V", "TAG", "", "isChangeTab", "", "reportedData", "", "Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "kotlin.jvm.PlatformType", "", "videoDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getData", "feedId", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "notifyChangeTab", "", "notifyDecodeStart", "(Ljava/lang/Long;)V", "notifyFirstVideoFrameRendered", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPause", "notifyVideoPlay", "RecordData", "plugin-finder_release"})
public final class h
{
  public static final ConcurrentHashMap<Long, a> zVa;
  public static final Set<a> zVb;
  private static boolean zVc;
  public static final h zVd;
  
  static
  {
    AppMethodBeat.i(266712);
    zVd = new h();
    zVa = new ConcurrentHashMap();
    zVb = Collections.synchronizedSet((Set)new HashSet());
    AppMethodBeat.o(266712);
  }
  
  public static a Mj(long paramLong)
  {
    AppMethodBeat.i(266710);
    a locala2 = (a)zVa.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      ((Map)zVa).put(Long.valueOf(paramLong), locala1);
    }
    AppMethodBeat.o(266710);
    return locala1;
  }
  
  public static void dPo()
  {
    zVc = true;
  }
  
  public static List<asy> dPp()
  {
    AppMethodBeat.i(266711);
    LinkedList localLinkedList = new LinkedList();
    ??? = zVb;
    p.j(???, "reportedData");
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
        asy localasy = new asy();
        localasy.scene = 1;
        localasy.SGa = locala.zVk;
        if (locala.zVh > 0L)
        {
          l1 = locala.zVh;
          if ((l1 <= 0L) || (locala.zVg <= 0L)) {
            break label396;
          }
          i = (int)(l1 - locala.zVg);
          localasy.SGe = i;
          if (locala.zVh <= 0L) {
            break label292;
          }
          l1 = locala.zVh;
          if (locala.zVi <= 0L) {
            break label311;
          }
          l2 = locala.zVi;
          break label376;
          localasy.SGf = i;
          localLinkedList.add(localasy);
          Log.i("FinderHotspotChangeReporter", "finderFluencyInfo: scene = " + localasy.scene + ", hot = " + localasy.SGa + ", downloadToDecodeMs = " + localasy.SGe + ',' + " decodeToFirstFrameMs = " + localasy.SGf);
        }
      }
      if (locala.zVf > 0L)
      {
        l1 = locala.zVf;
        continue;
        label292:
        if (locala.zVe > 0L)
        {
          l1 = locala.zVe;
          continue;
          label311:
          if (locala.zVf > 0L)
          {
            l2 = locala.zVf;
            break label376;
            label330:
            localObject3 = x.aazN;
            zVb.clear();
            List localList = (List)localObject1;
            AppMethodBeat.o(266711);
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
  
  public final void h(Long paramLong)
  {
    AppMethodBeat.i(266708);
    Object localObject;
    int i;
    if (paramLong != null)
    {
      paramLong.longValue();
      localObject = Mj(paramLong.longValue());
      if (((a)localObject).zVg != 0L) {
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
        ((a)localObject).zVg = cm.bfE();
        if (localObject != null) {}
      }
      else
      {
        localObject = (h)this;
        zVa.remove(paramLong);
        ((h)localObject).h(paramLong);
        paramLong = x.aazN;
      }
      AppMethodBeat.o(266708);
      return;
      AppMethodBeat.o(266708);
      return;
      label86:
      i = 0;
      break;
      label91:
      localObject = null;
    }
  }
  
  public final void i(Long paramLong)
  {
    int j = 1;
    AppMethodBeat.i(266709);
    Object localObject;
    if (paramLong != null)
    {
      paramLong.longValue();
      localObject = Mj(paramLong.longValue());
      if (((a)localObject).zVe != 0L) {
        break label113;
      }
      i = 1;
      if (i == 0) {
        break label118;
      }
      label41:
      if (localObject != null)
      {
        ((a)localObject).zVe = cm.bfE();
        if (!zVc) {
          break label124;
        }
      }
    }
    label113:
    label118:
    label124:
    for (int i = j;; i = 2)
    {
      ((a)localObject).zVk = i;
      zVc = false;
      if (localObject == null)
      {
        localObject = (h)this;
        zVa.remove(paramLong);
        ((h)localObject).i(paramLong);
        paramLong = x.aazN;
      }
      AppMethodBeat.o(266709);
      return;
      AppMethodBeat.o(266709);
      return;
      i = 0;
      break;
      localObject = null;
      break label41;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "", "()V", "changeHotpotType", "", "getChangeHotpotType", "()I", "setChangeHotpotType", "(I)V", "firstVideoFrameRendered", "", "getFirstVideoFrameRendered", "()J", "setFirstVideoFrameRendered", "(J)V", "videoDecodeStart", "getVideoDecodeStart", "setVideoDecodeStart", "videoDownloadStart", "getVideoDownloadStart", "setVideoDownloadStart", "videoFirstFrame", "getVideoFirstFrame", "setVideoFirstFrame", "videoPause", "getVideoPause", "setVideoPause", "videoPlay", "getVideoPlay", "setVideoPlay", "plugin-finder_release"})
  public static final class a
  {
    public long zVe;
    public long zVf;
    public long zVg;
    public long zVh;
    public long zVi;
    public long zVj;
    int zVk = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.h
 * JD-Core Version:    0.7.0.1
 */