package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/LiveStatisticsUtil;", "", "()V", "TAG", "", "cdnStatistics", "Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "getCdnStatistics", "()Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "setCdnStatistics", "(Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;)V", "trtcStatistics", "Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "getTrtcStatistics", "()Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "setTrtcStatistics", "(Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;)V", "doStatistic", "", "value", "", "cache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "reset", "statisticCDN", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "statisticTRTC", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  private static ac DJA;
  private static h DJB;
  public static final t DJz;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(351312);
    DJz = new t();
    TAG = "Finder.LiveStatisticsUtil";
    AppMethodBeat.o(351312);
  }
  
  private static void a(int paramInt, aa paramaa)
  {
    AppMethodBeat.i(351295);
    if (paramaa == null)
    {
      AppMethodBeat.o(351295);
      return;
    }
    paramaa.DJF.value = paramInt;
    if (!paramaa.ABD)
    {
      AppMethodBeat.o(351295);
      return;
    }
    Object localObject = paramaa.DJG;
    if (localObject != null)
    {
      if ((((e)localObject).oZt >= 2147483647) || (((e)localObject).DIm + paramInt >= 9223372036854775807L)) {
        break label174;
      }
      ((e)localObject).oZt += 1;
      ((e)localObject).DIm += paramInt;
      ((e)localObject).DIn = (((e)localObject).DIm / ((e)localObject).oZt);
    }
    for (;;)
    {
      localObject = paramaa.DJH;
      if (localObject == null) {
        break label193;
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
      if (locali.oZt >= 2147483647) {
        break;
      }
      locali.oZt += 1;
      AppMethodBeat.o(351295);
      return;
      label174:
      paramaa.ABD = false;
    }
    paramaa.ABD = false;
    AppMethodBeat.o(351295);
    return;
    label193:
    AppMethodBeat.o(351295);
  }
  
  public static void a(com.tencent.mm.live.core.core.model.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(351274);
    int i;
    Object localObject1;
    if (parame != null)
    {
      if (DJA == null) {
        DJA = new ac();
      }
      i = (int)parame.mNg;
      localObject1 = DJA;
      if (localObject1 != null) {
        break label264;
      }
      localObject1 = null;
      a(i, (aa)localObject1);
      i = parame.mNc;
      localObject1 = DJA;
      if (localObject1 != null) {
        break label272;
      }
      localObject1 = null;
      label63:
      a(i, (aa)localObject1);
      i = parame.upLoss;
      localObject1 = DJA;
      if (localObject1 != null) {
        break label280;
      }
      localObject1 = null;
      label83:
      a(i, (aa)localObject1);
      i = parame.downLoss;
      localObject1 = DJA;
      if (localObject1 != null) {
        break label288;
      }
      localObject1 = null;
      label103:
      a(i, (aa)localObject1);
      i = (int)(parame.sendBytes / 1000L);
      localObject1 = DJA;
      if (localObject1 != null) {
        break label296;
      }
      localObject1 = null;
      label128:
      a(i, (aa)localObject1);
      i = (int)(parame.receiveBytes / 1000L);
      localObject1 = DJA;
      if (localObject1 != null) {
        break label304;
      }
      localObject1 = null;
      label153:
      a(i, (aa)localObject1);
      i = parame.width;
      localObject1 = DJA;
      if (localObject1 != null) {
        break label312;
      }
      localObject1 = null;
      label173:
      a(i, (aa)localObject1);
      i = parame.height;
      localObject1 = DJA;
      if (localObject1 != null) {
        break label320;
      }
      localObject1 = null;
      label193:
      a(i, (aa)localObject1);
      i = parame.mMK;
      localObject1 = DJA;
      if (localObject1 != null) {
        break label328;
      }
      localObject1 = null;
      label213:
      a(i, (aa)localObject1);
      i = parame.mMM;
      localObject1 = DJA;
      if (localObject1 != null) {
        break label336;
      }
      localObject1 = null;
      label233:
      a(i, (aa)localObject1);
      i = parame.mMN;
      parame = DJA;
      if (parame != null) {
        break label344;
      }
    }
    label264:
    label272:
    label280:
    label288:
    label296:
    label304:
    label312:
    label320:
    label328:
    label336:
    label344:
    for (parame = localObject2;; parame = parame.DIu)
    {
      a(i, parame);
      AppMethodBeat.o(351274);
      return;
      localObject1 = ((ac)localObject1).DIs;
      break;
      localObject1 = ((ac)localObject1).DJI;
      break label63;
      localObject1 = ((ac)localObject1).DJJ;
      break label83;
      localObject1 = ((ac)localObject1).DJK;
      break label103;
      localObject1 = ((ac)localObject1).DJL;
      break label128;
      localObject1 = ((ac)localObject1).DJM;
      break label153;
      localObject1 = ((ac)localObject1).DIw;
      break label173;
      localObject1 = ((ac)localObject1).DIx;
      break label193;
      localObject1 = ((ac)localObject1).DIv;
      break label213;
      localObject1 = ((ac)localObject1).DIt;
      break label233;
    }
  }
  
  public static void b(com.tencent.mm.live.core.core.model.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(351285);
    int i;
    Object localObject1;
    if (parame != null)
    {
      if (DJB == null) {
        DJB = new h();
      }
      i = (int)parame.mNg;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label294;
      }
      localObject1 = null;
      a(i, (aa)localObject1);
      i = parame.width;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label302;
      }
      localObject1 = null;
      label63:
      a(i, (aa)localObject1);
      i = parame.height;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label310;
      }
      localObject1 = null;
      label83:
      a(i, (aa)localObject1);
      i = parame.mML;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label318;
      }
      localObject1 = null;
      label103:
      a(i, (aa)localObject1);
      i = parame.mMK;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label326;
      }
      localObject1 = null;
      label123:
      a(i, (aa)localObject1);
      i = parame.mMM;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label334;
      }
      localObject1 = null;
      label143:
      a(i, (aa)localObject1);
      i = parame.mMN;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label342;
      }
      localObject1 = null;
      label163:
      a(i, (aa)localObject1);
      i = parame.mMO;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label350;
      }
      localObject1 = null;
      label183:
      a(i, (aa)localObject1);
      i = parame.mMV;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label358;
      }
      localObject1 = null;
      label203:
      a(i, (aa)localObject1);
      i = parame.mMT;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label366;
      }
      localObject1 = null;
      label223:
      a(i, (aa)localObject1);
      i = parame.mMS;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label374;
      }
      localObject1 = null;
      label243:
      a(i, (aa)localObject1);
      i = parame.mMP;
      localObject1 = DJB;
      if (localObject1 != null) {
        break label382;
      }
      localObject1 = null;
      label263:
      a(i, (aa)localObject1);
      i = parame.mMR;
      parame = DJB;
      if (parame != null) {
        break label390;
      }
    }
    label390:
    for (parame = localObject2;; parame = parame.DIE)
    {
      a(i, parame);
      AppMethodBeat.o(351285);
      return;
      label294:
      localObject1 = ((h)localObject1).DIs;
      break;
      label302:
      localObject1 = ((h)localObject1).DIw;
      break label63;
      label310:
      localObject1 = ((h)localObject1).DIx;
      break label83;
      label318:
      localObject1 = ((h)localObject1).DIy;
      break label103;
      label326:
      localObject1 = ((h)localObject1).DIv;
      break label123;
      label334:
      localObject1 = ((h)localObject1).DIt;
      break label143;
      label342:
      localObject1 = ((h)localObject1).DIu;
      break label163;
      label350:
      localObject1 = ((h)localObject1).DIz;
      break label183;
      label358:
      localObject1 = ((h)localObject1).DIA;
      break label203;
      label366:
      localObject1 = ((h)localObject1).DIB;
      break label223;
      label374:
      localObject1 = ((h)localObject1).DIC;
      break label243;
      label382:
      localObject1 = ((h)localObject1).DID;
      break label263;
    }
  }
  
  public static h euz()
  {
    return DJB;
  }
  
  public static void reset()
  {
    DJA = null;
    DJB = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.t
 * JD-Core Version:    0.7.0.1
 */