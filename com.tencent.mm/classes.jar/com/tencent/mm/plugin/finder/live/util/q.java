package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.d;
import java.util.Iterator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/LiveStatisticsUtil;", "", "()V", "TAG", "", "cdnStatistics", "Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "getCdnStatistics", "()Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "setCdnStatistics", "(Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;)V", "trtcStatistics", "Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "getTrtcStatistics", "()Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "setTrtcStatistics", "(Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;)V", "doStatistic", "", "value", "", "cache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "reset", "statisticCDN", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "statisticTRTC", "plugin-finder-base_release"})
public final class q
{
  private static final String TAG = "Finder.LiveStatisticsUtil";
  private static z yQP;
  private static h yQQ;
  public static final q yQR;
  
  static
  {
    AppMethodBeat.i(258966);
    yQR = new q();
    TAG = "Finder.LiveStatisticsUtil";
    AppMethodBeat.o(258966);
  }
  
  private static void a(int paramInt, x paramx)
  {
    AppMethodBeat.i(258964);
    if (paramx == null)
    {
      AppMethodBeat.o(258964);
      return;
    }
    paramx.yQV.value = paramInt;
    if (!paramx.xcp)
    {
      AppMethodBeat.o(258964);
      return;
    }
    Object localObject = paramx.yQW;
    if (localObject != null)
    {
      if ((((e)localObject).mgw >= 2147483647) || (((e)localObject).yPF + paramInt >= 9223372036854775807L)) {
        break label174;
      }
      ((e)localObject).mgw += 1;
      ((e)localObject).yPF += paramInt;
      ((e)localObject).yPG = (((e)localObject).yPF / ((e)localObject).mgw);
    }
    for (;;)
    {
      localObject = paramx.yQX;
      if (localObject == null) {
        break label199;
      }
      localObject = ((Iterable)localObject).iterator();
      i locali;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        locali = (i)((Iterator)localObject).next();
      } while (paramInt >= locali.value);
      if (locali.mgw >= 2147483647) {
        break;
      }
      locali.mgw += 1;
      AppMethodBeat.o(258964);
      return;
      label174:
      paramx.xcp = false;
    }
    paramx.xcp = false;
    AppMethodBeat.o(258964);
    return;
    AppMethodBeat.o(258964);
    return;
    label199:
    AppMethodBeat.o(258964);
  }
  
  public static void a(d paramd)
  {
    Object localObject2 = null;
    AppMethodBeat.i(258961);
    if (paramd != null)
    {
      if (yQP == null) {
        yQP = new z();
      }
      int i = (int)paramd.kmb;
      Object localObject1 = yQP;
      if (localObject1 != null)
      {
        localObject1 = ((z)localObject1).yPN;
        a(i, (x)localObject1);
        i = paramd.klX;
        localObject1 = yQP;
        if (localObject1 == null) {
          break label304;
        }
        localObject1 = ((z)localObject1).yQY;
        label69:
        a(i, (x)localObject1);
        i = paramd.upLoss;
        localObject1 = yQP;
        if (localObject1 == null) {
          break label309;
        }
        localObject1 = ((z)localObject1).yQZ;
        label92:
        a(i, (x)localObject1);
        i = paramd.downLoss;
        localObject1 = yQP;
        if (localObject1 == null) {
          break label314;
        }
        localObject1 = ((z)localObject1).yRa;
        label115:
        a(i, (x)localObject1);
        i = (int)(paramd.sendBytes / 1000L);
        localObject1 = yQP;
        if (localObject1 == null) {
          break label319;
        }
        localObject1 = ((z)localObject1).yRb;
        label143:
        a(i, (x)localObject1);
        i = (int)(paramd.receiveBytes / 1000L);
        localObject1 = yQP;
        if (localObject1 == null) {
          break label324;
        }
        localObject1 = ((z)localObject1).yRc;
        label171:
        a(i, (x)localObject1);
        i = paramd.width;
        localObject1 = yQP;
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = ((z)localObject1).yPR;
        label194:
        a(i, (x)localObject1);
        i = paramd.height;
        localObject1 = yQP;
        if (localObject1 == null) {
          break label334;
        }
        localObject1 = ((z)localObject1).yPS;
        label217:
        a(i, (x)localObject1);
        i = paramd.klF;
        localObject1 = yQP;
        if (localObject1 == null) {
          break label339;
        }
        localObject1 = ((z)localObject1).yPQ;
        label240:
        a(i, (x)localObject1);
        i = paramd.klH;
        localObject1 = yQP;
        if (localObject1 == null) {
          break label344;
        }
      }
      label304:
      label309:
      label314:
      label319:
      label324:
      label329:
      label334:
      label339:
      label344:
      for (localObject1 = ((z)localObject1).yPO;; localObject1 = null)
      {
        a(i, (x)localObject1);
        i = paramd.klI;
        localObject1 = yQP;
        paramd = localObject2;
        if (localObject1 != null) {
          paramd = ((z)localObject1).yPP;
        }
        a(i, paramd);
        AppMethodBeat.o(258961);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label69;
        localObject1 = null;
        break label92;
        localObject1 = null;
        break label115;
        localObject1 = null;
        break label143;
        localObject1 = null;
        break label171;
        localObject1 = null;
        break label194;
        localObject1 = null;
        break label217;
        localObject1 = null;
        break label240;
      }
    }
    AppMethodBeat.o(258961);
  }
  
  public static void b(d paramd)
  {
    Object localObject2 = null;
    AppMethodBeat.i(258963);
    int i;
    if (paramd != null)
    {
      if (yQQ == null) {
        yQQ = new h();
      }
      i = (int)paramd.kmb;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label312;
      }
      localObject1 = ((h)localObject1).yPN;
      a(i, (x)localObject1);
      i = paramd.width;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label317;
      }
      localObject1 = ((h)localObject1).yPR;
      label69:
      a(i, (x)localObject1);
      i = paramd.height;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label322;
      }
      localObject1 = ((h)localObject1).yPS;
      label92:
      a(i, (x)localObject1);
      i = paramd.klF;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label327;
      }
      localObject1 = ((h)localObject1).yPQ;
      label115:
      a(i, (x)localObject1);
      i = paramd.klH;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label332;
      }
      localObject1 = ((h)localObject1).yPO;
      label138:
      a(i, (x)localObject1);
      i = paramd.klI;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label337;
      }
      localObject1 = ((h)localObject1).yPP;
      label161:
      a(i, (x)localObject1);
      i = paramd.klJ;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label342;
      }
      localObject1 = ((h)localObject1).yPT;
      label184:
      a(i, (x)localObject1);
      i = paramd.klQ;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label347;
      }
      localObject1 = ((h)localObject1).yPU;
      label207:
      a(i, (x)localObject1);
      i = paramd.klO;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label352;
      }
      localObject1 = ((h)localObject1).yPV;
      label230:
      a(i, (x)localObject1);
      i = paramd.klN;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label357;
      }
      localObject1 = ((h)localObject1).yPW;
      label253:
      a(i, (x)localObject1);
      i = paramd.klK;
      localObject1 = yQQ;
      if (localObject1 == null) {
        break label362;
      }
    }
    label312:
    label317:
    label322:
    label327:
    label332:
    label337:
    label342:
    label347:
    label352:
    label357:
    label362:
    for (Object localObject1 = ((h)localObject1).yPX;; localObject1 = null)
    {
      a(i, (x)localObject1);
      i = paramd.klM;
      localObject1 = yQQ;
      paramd = localObject2;
      if (localObject1 != null) {
        paramd = ((h)localObject1).yPY;
      }
      a(i, paramd);
      AppMethodBeat.o(258963);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label69;
      localObject1 = null;
      break label92;
      localObject1 = null;
      break label115;
      localObject1 = null;
      break label138;
      localObject1 = null;
      break label161;
      localObject1 = null;
      break label184;
      localObject1 = null;
      break label207;
      localObject1 = null;
      break label230;
      localObject1 = null;
      break label253;
    }
  }
  
  public static h dEx()
  {
    return yQQ;
  }
  
  public static void reset()
  {
    yQP = null;
    yQQ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.q
 * JD-Core Version:    0.7.0.1
 */