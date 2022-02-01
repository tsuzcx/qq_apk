package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.arc;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter;", "", "()V", "TAG", "", "isChangeTab", "", "reportedData", "", "Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "kotlin.jvm.PlatformType", "", "videoDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getData", "feedId", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "notifyChangeTab", "", "notifyDecodeStart", "(Ljava/lang/Long;)V", "notifyFirstVideoFrameRendered", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPause", "notifyVideoPlay", "RecordData", "plugin-finder_release"})
public final class f
{
  public static final ConcurrentHashMap<Long, a> vdY;
  public static final Set<a> vdZ;
  private static boolean vea;
  public static final f veb;
  
  static
  {
    AppMethodBeat.i(250552);
    veb = new f();
    vdY = new ConcurrentHashMap();
    vdZ = Collections.synchronizedSet((Set)new HashSet());
    AppMethodBeat.o(250552);
  }
  
  public static a EZ(long paramLong)
  {
    AppMethodBeat.i(250550);
    a locala2 = (a)vdY.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      ((Map)vdY).put(Long.valueOf(paramLong), locala1);
    }
    AppMethodBeat.o(250550);
    return locala1;
  }
  
  public static void dnO()
  {
    vea = true;
  }
  
  public static List<arc> dnP()
  {
    AppMethodBeat.i(250551);
    LinkedList localLinkedList = new LinkedList();
    ??? = vdZ;
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
        arc localarc = new arc();
        localarc.scene = 1;
        localarc.LCO = locala.vei;
        if (locala.vef > 0L)
        {
          l1 = locala.vef;
          if ((l1 <= 0L) || (locala.vee <= 0L)) {
            break label396;
          }
          i = (int)(l1 - locala.vee);
          localarc.LCS = i;
          if (locala.vef <= 0L) {
            break label292;
          }
          l1 = locala.vef;
          if (locala.veg <= 0L) {
            break label311;
          }
          l2 = locala.veg;
          break label376;
          localarc.LCT = i;
          localLinkedList.add(localarc);
          Log.i("FinderHotspotChangeReporter", "finderFluencyInfo: scene = " + localarc.scene + ", hot = " + localarc.LCO + ", downloadToDecodeMs = " + localarc.LCS + ',' + " decodeToFirstFrameMs = " + localarc.LCT);
        }
      }
      if (locala.ved > 0L)
      {
        l1 = locala.ved;
        continue;
        label292:
        if (locala.vec > 0L)
        {
          l1 = locala.vec;
          continue;
          label311:
          if (locala.ved > 0L)
          {
            l2 = locala.ved;
            break label376;
            label330:
            localObject3 = x.SXb;
            vdZ.clear();
            List localList = (List)localObject1;
            AppMethodBeat.o(250551);
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
    AppMethodBeat.i(250548);
    Object localObject;
    int i;
    if (paramLong != null)
    {
      paramLong.longValue();
      localObject = EZ(paramLong.longValue());
      if (((a)localObject).vee != 0L) {
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
        ((a)localObject).vee = cl.aWA();
        if (localObject != null) {}
      }
      else
      {
        localObject = (f)this;
        vdY.remove(paramLong);
        ((f)localObject).h(paramLong);
        paramLong = x.SXb;
      }
      AppMethodBeat.o(250548);
      return;
      AppMethodBeat.o(250548);
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
    AppMethodBeat.i(250549);
    Object localObject;
    if (paramLong != null)
    {
      paramLong.longValue();
      localObject = EZ(paramLong.longValue());
      if (((a)localObject).vec != 0L) {
        break label113;
      }
      i = 1;
      if (i == 0) {
        break label118;
      }
      label41:
      if (localObject != null)
      {
        ((a)localObject).vec = cl.aWA();
        if (!vea) {
          break label124;
        }
      }
    }
    label113:
    label118:
    label124:
    for (int i = j;; i = 2)
    {
      ((a)localObject).vei = i;
      vea = false;
      if (localObject == null)
      {
        localObject = (f)this;
        vdY.remove(paramLong);
        ((f)localObject).i(paramLong);
        paramLong = x.SXb;
      }
      AppMethodBeat.o(250549);
      return;
      AppMethodBeat.o(250549);
      return;
      i = 0;
      break;
      localObject = null;
      break label41;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "", "()V", "changeHotpotType", "", "getChangeHotpotType", "()I", "setChangeHotpotType", "(I)V", "firstVideoFrameRendered", "", "getFirstVideoFrameRendered", "()J", "setFirstVideoFrameRendered", "(J)V", "videoDecodeStart", "getVideoDecodeStart", "setVideoDecodeStart", "videoDownloadStart", "getVideoDownloadStart", "setVideoDownloadStart", "videoFirstFrame", "getVideoFirstFrame", "setVideoFirstFrame", "videoPause", "getVideoPause", "setVideoPause", "videoPlay", "getVideoPlay", "setVideoPlay", "plugin-finder_release"})
  public static final class a
  {
    public long vec;
    public long ved;
    public long vee;
    public long vef;
    public long veg;
    public long veh;
    int vei = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.f
 * JD-Core Version:    0.7.0.1
 */