package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.ejc;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter;", "", "()V", "TAG", "", "isChangeTab", "", "reportedData", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "Lkotlin/collections/HashSet;", "getReportedData", "()Ljava/util/HashSet;", "videoDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getData", "feedId", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "notifyChangeTab", "", "notifyDecodeStart", "(Ljava/lang/Long;)V", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPause", "notifyVideoPlay", "RecordData", "plugin-finder_release"})
public final class y
{
  public static final ConcurrentHashMap<Long, a> LjS;
  public static final HashSet<a> LjT;
  private static boolean LjU;
  public static final y LjV;
  
  static
  {
    AppMethodBeat.i(221526);
    LjV = new y();
    LjS = new ConcurrentHashMap();
    LjT = new HashSet();
    AppMethodBeat.o(221526);
  }
  
  public static a FS(long paramLong)
  {
    AppMethodBeat.i(221524);
    a locala2 = (a)LjS.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      ((Map)LjS).put(Long.valueOf(paramLong), locala1);
    }
    AppMethodBeat.o(221524);
    return locala1;
  }
  
  public static void bFl()
  {
    LjU = true;
  }
  
  public static List<ejc> bMX()
  {
    AppMethodBeat.i(221525);
    Object localObject = new LinkedList();
    Iterator localIterator = ((Iterable)LjT).iterator();
    a locala;
    ejc localejc;
    long l1;
    if (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      localejc = new ejc();
      localejc.scene = 1;
      localejc.Oet = locala.LjZ;
      if (locala.LjY > 0L) {
        l1 = locala.LjY;
      }
    }
    for (;;)
    {
      label90:
      int i;
      if ((l1 > 0L) && (locala.soj > 0L))
      {
        i = (int)(l1 - locala.soj);
        label115:
        localejc.Oex = i;
        if (locala.LjY <= 0L) {
          break label280;
        }
        l1 = locala.LjY;
      }
      for (;;)
      {
        label137:
        long l2;
        if (locala.sok > 0L) {
          l2 = locala.sok;
        }
        for (;;)
        {
          label153:
          if ((l1 > 0L) && (l2 > 0L)) {}
          for (i = (int)(l2 - l1);; i = 0)
          {
            localejc.Oey = i;
            ((LinkedList)localObject).add(localejc);
            ad.i("FinderHotspotChangeReporter", "finderFluencyInfo: scene = " + localejc.scene + ", hot = " + localejc.Oet + ", downloadToDecodeMs = " + localejc.Oex + ',' + " decodeToFirstFrameMs = " + localejc.Oey);
            break;
            if (locala.LjX <= 0L) {
              break label354;
            }
            l1 = locala.LjX;
            break label90;
            i = 0;
            break label115;
            label280:
            if (locala.LjW <= 0L) {
              break label349;
            }
            l1 = locala.LjW;
            break label137;
            if (locala.LjX <= 0L) {
              break label344;
            }
            l2 = locala.LjX;
            break label153;
          }
          LjT.clear();
          localObject = (List)localObject;
          AppMethodBeat.o(221525);
          return localObject;
          label344:
          l2 = 0L;
        }
        label349:
        l1 = 0L;
      }
      label354:
      l1 = 0L;
    }
  }
  
  public final void i(Long paramLong)
  {
    AppMethodBeat.i(221522);
    Object localObject;
    int i;
    if (paramLong != null)
    {
      paramLong.longValue();
      localObject = FS(paramLong.longValue());
      if (((a)localObject).soj != 0L) {
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
        ((a)localObject).soj = cf.aCM();
        if (localObject != null) {}
      }
      else
      {
        localObject = (y)this;
        LjS.remove(paramLong);
        ((y)localObject).i(paramLong);
        paramLong = z.MKo;
      }
      AppMethodBeat.o(221522);
      return;
      AppMethodBeat.o(221522);
      return;
      label86:
      i = 0;
      break;
      label91:
      localObject = null;
    }
  }
  
  public final void j(Long paramLong)
  {
    int j = 1;
    AppMethodBeat.i(221523);
    Object localObject;
    if (paramLong != null)
    {
      paramLong.longValue();
      localObject = FS(paramLong.longValue());
      if (((a)localObject).LjW != 0L) {
        break label113;
      }
      i = 1;
      if (i == 0) {
        break label118;
      }
      label41:
      if (localObject != null)
      {
        ((a)localObject).LjW = cf.aCM();
        if (!LjU) {
          break label124;
        }
      }
    }
    label113:
    label118:
    label124:
    for (int i = j;; i = 2)
    {
      ((a)localObject).LjZ = i;
      LjU = false;
      if (localObject == null)
      {
        localObject = (y)this;
        LjS.remove(paramLong);
        ((y)localObject).j(paramLong);
        paramLong = z.MKo;
      }
      AppMethodBeat.o(221523);
      return;
      AppMethodBeat.o(221523);
      return;
      i = 0;
      break;
      localObject = null;
      break label41;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "", "()V", "changeHotpotType", "", "getChangeHotpotType", "()I", "setChangeHotpotType", "(I)V", "videoDecodeStart", "", "getVideoDecodeStart", "()J", "setVideoDecodeStart", "(J)V", "videoDownloadStart", "getVideoDownloadStart", "setVideoDownloadStart", "videoFirstFrame", "getVideoFirstFrame", "setVideoFirstFrame", "videoPause", "getVideoPause", "setVideoPause", "videoPlay", "getVideoPlay", "setVideoPlay", "plugin-finder_release"})
  public static final class a
  {
    public long LjW;
    public long LjX;
    public long LjY;
    int LjZ = 2;
    public long soj;
    public long sok;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.y
 * JD-Core Version:    0.7.0.1
 */