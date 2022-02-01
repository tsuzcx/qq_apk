package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.c;
import java.util.Iterator;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/LiveStatisticsUtil;", "", "()V", "TAG", "", "cdnStatistics", "Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "getCdnStatistics", "()Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "setCdnStatistics", "(Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;)V", "trtcStatistics", "Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "getTrtcStatistics", "()Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "setTrtcStatistics", "(Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;)V", "doStatistic", "", "value", "", "cache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "reset", "statisticCDN", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "statisticTRTC", "plugin-finder_release"})
public final class q
{
  private static final String TAG = "Finder.LiveStatisticsUtil";
  private static y uxh;
  private static h uxi;
  public static final q uxj;
  
  static
  {
    AppMethodBeat.i(247295);
    uxj = new q();
    TAG = "Finder.LiveStatisticsUtil";
    AppMethodBeat.o(247295);
  }
  
  private static void a(int paramInt, w paramw)
  {
    AppMethodBeat.i(247294);
    if (paramw == null)
    {
      AppMethodBeat.o(247294);
      return;
    }
    paramw.uxm.value = paramInt;
    if (!paramw.tuG)
    {
      AppMethodBeat.o(247294);
      return;
    }
    Object localObject = paramw.uxn;
    if (localObject != null)
    {
      if ((((e)localObject).hjI >= 2147483647) || (((e)localObject).uvZ + paramInt >= 9223372036854775807L)) {
        break label174;
      }
      ((e)localObject).hjI += 1;
      ((e)localObject).uvZ += paramInt;
      ((e)localObject).uwa = (((e)localObject).uvZ / ((e)localObject).hjI);
    }
    for (;;)
    {
      localObject = paramw.uxo;
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
      if (locali.hjI >= 2147483647) {
        break;
      }
      locali.hjI += 1;
      AppMethodBeat.o(247294);
      return;
      label174:
      paramw.tuG = false;
    }
    paramw.tuG = false;
    AppMethodBeat.o(247294);
    return;
    AppMethodBeat.o(247294);
    return;
    label199:
    AppMethodBeat.o(247294);
  }
  
  public static void a(c paramc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(247292);
    if (paramc != null)
    {
      if (uxh == null) {
        uxh = new y();
      }
      int i = (int)paramc.hze;
      Object localObject1 = uxh;
      if (localObject1 != null)
      {
        localObject1 = ((y)localObject1).uwg;
        a(i, (w)localObject1);
        i = paramc.hza;
        localObject1 = uxh;
        if (localObject1 == null) {
          break label304;
        }
        localObject1 = ((y)localObject1).uxp;
        label69:
        a(i, (w)localObject1);
        i = paramc.upLoss;
        localObject1 = uxh;
        if (localObject1 == null) {
          break label309;
        }
        localObject1 = ((y)localObject1).uxq;
        label92:
        a(i, (w)localObject1);
        i = paramc.downLoss;
        localObject1 = uxh;
        if (localObject1 == null) {
          break label314;
        }
        localObject1 = ((y)localObject1).uxr;
        label115:
        a(i, (w)localObject1);
        i = (int)(paramc.sendBytes / 1000L);
        localObject1 = uxh;
        if (localObject1 == null) {
          break label319;
        }
        localObject1 = ((y)localObject1).uxs;
        label143:
        a(i, (w)localObject1);
        i = (int)(paramc.receiveBytes / 1000L);
        localObject1 = uxh;
        if (localObject1 == null) {
          break label324;
        }
        localObject1 = ((y)localObject1).uxt;
        label171:
        a(i, (w)localObject1);
        i = paramc.width;
        localObject1 = uxh;
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = ((y)localObject1).uwk;
        label194:
        a(i, (w)localObject1);
        i = paramc.height;
        localObject1 = uxh;
        if (localObject1 == null) {
          break label334;
        }
        localObject1 = ((y)localObject1).uwl;
        label217:
        a(i, (w)localObject1);
        i = paramc.hyI;
        localObject1 = uxh;
        if (localObject1 == null) {
          break label339;
        }
        localObject1 = ((y)localObject1).uwj;
        label240:
        a(i, (w)localObject1);
        i = paramc.hyK;
        localObject1 = uxh;
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
      for (localObject1 = ((y)localObject1).uwh;; localObject1 = null)
      {
        a(i, (w)localObject1);
        i = paramc.hyL;
        localObject1 = uxh;
        paramc = localObject2;
        if (localObject1 != null) {
          paramc = ((y)localObject1).uwi;
        }
        a(i, paramc);
        AppMethodBeat.o(247292);
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
    AppMethodBeat.o(247292);
  }
  
  public static void b(c paramc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(247293);
    int i;
    if (paramc != null)
    {
      if (uxi == null) {
        uxi = new h();
      }
      i = (int)paramc.hze;
      localObject1 = uxi;
      if (localObject1 == null) {
        break label312;
      }
      localObject1 = ((h)localObject1).uwg;
      a(i, (w)localObject1);
      i = paramc.width;
      localObject1 = uxi;
      if (localObject1 == null) {
        break label317;
      }
      localObject1 = ((h)localObject1).uwk;
      label69:
      a(i, (w)localObject1);
      i = paramc.height;
      localObject1 = uxi;
      if (localObject1 == null) {
        break label322;
      }
      localObject1 = ((h)localObject1).uwl;
      label92:
      a(i, (w)localObject1);
      i = paramc.hyI;
      localObject1 = uxi;
      if (localObject1 == null) {
        break label327;
      }
      localObject1 = ((h)localObject1).uwj;
      label115:
      a(i, (w)localObject1);
      i = paramc.hyK;
      localObject1 = uxi;
      if (localObject1 == null) {
        break label332;
      }
      localObject1 = ((h)localObject1).uwh;
      label138:
      a(i, (w)localObject1);
      i = paramc.hyL;
      localObject1 = uxi;
      if (localObject1 == null) {
        break label337;
      }
      localObject1 = ((h)localObject1).uwi;
      label161:
      a(i, (w)localObject1);
      i = paramc.hyM;
      localObject1 = uxi;
      if (localObject1 == null) {
        break label342;
      }
      localObject1 = ((h)localObject1).uwm;
      label184:
      a(i, (w)localObject1);
      i = paramc.hyT;
      localObject1 = uxi;
      if (localObject1 == null) {
        break label347;
      }
      localObject1 = ((h)localObject1).uwn;
      label207:
      a(i, (w)localObject1);
      i = paramc.hyR;
      localObject1 = uxi;
      if (localObject1 == null) {
        break label352;
      }
      localObject1 = ((h)localObject1).uwo;
      label230:
      a(i, (w)localObject1);
      i = paramc.hyQ;
      localObject1 = uxi;
      if (localObject1 == null) {
        break label357;
      }
      localObject1 = ((h)localObject1).uwp;
      label253:
      a(i, (w)localObject1);
      i = paramc.hyN;
      localObject1 = uxi;
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
    for (Object localObject1 = ((h)localObject1).uwq;; localObject1 = null)
    {
      a(i, (w)localObject1);
      i = paramc.hyP;
      localObject1 = uxi;
      paramc = localObject2;
      if (localObject1 != null) {
        paramc = ((h)localObject1).uwr;
      }
      a(i, paramc);
      AppMethodBeat.o(247293);
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
  
  public static y din()
  {
    return uxh;
  }
  
  public static h dio()
  {
    return uxi;
  }
  
  public static void reset()
  {
    uxh = null;
    uxi = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.q
 * JD-Core Version:    0.7.0.1
 */