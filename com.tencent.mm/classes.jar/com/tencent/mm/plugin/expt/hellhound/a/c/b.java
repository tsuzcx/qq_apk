package com.tencent.mm.plugin.expt.hellhound.a.c;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.p;
import com.tencent.mm.kernel.d;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class b
{
  private static int mbd = 0;
  
  private static c<String, Integer> T(LinkedList<cdy> paramLinkedList)
  {
    AppMethodBeat.i(73463);
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        cdy localcdy = (cdy)paramLinkedList.next();
        if (localcdy != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feedId", localcdy.feedId);
          localJSONObject.put("viewLikeCount", localcdy.lPs);
          localJSONObject.put("viewCommentCount", localcdy.xOB);
          localJSONObject.put("feedheight", localcdy.height);
          localcdy.xOA = new BigDecimal(localcdy.xOA).setScale(2, 4).doubleValue();
          localJSONObject.put("realShowTime", localcdy.xOA);
          localcdy.xOz = new BigDecimal(localcdy.xOz).setScale(2, 4).doubleValue();
          localJSONObject.put("stayTimeRelative", localcdy.xOz);
          localJSONObject.put("realScreenHeight", localcdy.iiX - localcdy.qZo - localcdy.xOw - localcdy.xOv);
          localJSONArray.put(localJSONObject);
          continue;
          AppMethodBeat.o(73463);
        }
      }
    }
    catch (Exception paramLinkedList)
    {
      ab.printErrStackTrace("HellTimelineReport", paramLinkedList, "habbyge-mali, reportTimeline-_feedList2JsonV2-crash", new Object[0]);
    }
    for (;;)
    {
      return null;
      int i = localJSONArray.length();
      if (i > 0)
      {
        paramLinkedList = a.C(localJSONArray.toString(), Integer.valueOf(i));
        AppMethodBeat.o(73463);
        return paramLinkedList;
      }
      ab.e("HellTimelineReport", "habbyge-mali, _feedList2JsonV2 jsonArray Empty !!!!");
    }
  }
  
  private static List<p> a(p paramp)
  {
    AppMethodBeat.i(73464);
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = paramp.Ff().getBytes();
    if (localObject3.length <= 5120)
    {
      paramp.cSa = 0;
      paramp.cSb = 1;
      localArrayList.add(paramp);
      AppMethodBeat.o(73464);
      return localArrayList;
    }
    Object localObject1 = paramp.cRX;
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(73464);
        return null;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        ab.printErrStackTrace("HellTimelineReport", localException, "habbyge-mali, _spliteLogIfBigger7K-timeline-Exception", new Object[0]);
        localObject2 = null;
      }
      int n = localObject2.length();
      double d = Math.ceil(localObject3.length / 5120.0D);
      int i1 = n / (int)d;
      int i2 = n % (int)d;
      int i = (int)d;
      int j = i;
      if (i2 > 0) {
        j = i + 1;
      }
      int k = 0;
      i = 0;
      int m = 0;
      while (m < d)
      {
        localObject3 = new p();
        ((p)localObject3).cRR = paramp.cRR;
        ((p)localObject3).fh(paramp.cRS);
        ((p)localObject3).fi(paramp.cRT);
        ((p)localObject3).cRU = paramp.cRU;
        ((p)localObject3).cRV = paramp.cRV;
        ((p)localObject3).cRW = paramp.cRW;
        ((p)localObject3).cRZ = paramp.cRZ;
        JSONArray localJSONArray = new JSONArray();
        i = m * i1;
        while ((i < (m + 1) * i1) && (i < n - i2))
        {
          localJSONArray.put(localObject2.opt(i));
          i += 1;
        }
        ((p)localObject3).cRX = localJSONArray.toString();
        ((p)localObject3).cRY = localJSONArray.length();
        ((p)localObject3).cSa = k;
        ((p)localObject3).cSb = j;
        localArrayList.add(localObject3);
        m += 1;
        k += 1;
      }
      if (i2 > 0)
      {
        localObject3 = new p();
        ((p)localObject3).cRR = paramp.cRR;
        ((p)localObject3).fh(paramp.cRS);
        ((p)localObject3).fi(paramp.cRT);
        ((p)localObject3).cRU = paramp.cRU;
        ((p)localObject3).cRV = paramp.cRV;
        ((p)localObject3).cRW = paramp.cRW;
        ((p)localObject3).cRZ = paramp.cRZ;
        paramp = new JSONArray();
        while (i < n)
        {
          paramp.put(localObject2.opt(i));
          i += 1;
        }
        ((p)localObject3).cRX = paramp.toString();
        ((p)localObject3).cRY = paramp.length();
        ((p)localObject3).cSa = k;
        ((p)localObject3).cSb = j;
        localArrayList.add(localObject3);
      }
      AppMethodBeat.o(73464);
    }
    return localArrayList;
  }
  
  static void a(cfg paramcfg)
  {
    AppMethodBeat.i(73462);
    if (paramcfg == null)
    {
      AppMethodBeat.o(73462);
      return;
    }
    ab.i("HellTimelineReport", "habbyge-mali, reportTimelineV2");
    Object localObject1 = T(paramcfg.xPJ);
    if (localObject1 == null)
    {
      AppMethodBeat.o(73462);
      return;
    }
    ab.i("HellTimelineReport", "habbyge-mali, reportTimelineV2 YES");
    Object localObject2 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
    p localp1 = new p();
    localp1.cRR = Process.myPid();
    p localp2 = localp1.fh(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName).fi(paramcfg.czq);
    localp2.cRU = paramcfg.xPG;
    localp2.cRV = paramcfg.xPH;
    localp2.cRW = paramcfg.xPI;
    localp2.cRX = ((String)localObject2);
    localp2.cRY = ((Integer)((c)localObject1).get(1)).intValue();
    int i = mbd;
    mbd = i + 1;
    localp2.cRZ = i;
    localObject1 = a(localp1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(73462);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (p)((Iterator)localObject1).next();
      ((p)localObject2).cRX = ((p)localObject2).cRX.replace(",", "#");
      ((p)localObject2).ake();
    }
    if (paramcfg != null)
    {
      long l1 = paramcfg.xPH;
      long l2 = paramcfg.xPI;
      if (Math.abs(paramcfg.xPG - (l1 + l2)) > 50L) {
        break label350;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(932L, 87L, 1L, false);
      ab.i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-timeline前台时长(停留+滚动)-准确");
    }
    double d1;
    for (;;)
    {
      localObject1 = paramcfg.xPJ.iterator();
      for (d1 = 0.0D; ((Iterator)localObject1).hasNext(); d1 = ((cdy)((Iterator)localObject1).next()).xOz + d1) {}
      label350:
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(932L, 88L, 1L, false);
      ab.i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-timeline前台时长(停留+滚动)-不准确");
    }
    double d2 = Math.abs(paramcfg.xPH - d1);
    if (d2 <= 50.0D)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(932L, 89L, 1L, false);
      ab.i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-feed停留分时时长-准确: " + paramcfg.xPH + " - " + d1 + " = " + d2);
      AppMethodBeat.o(73462);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(932L, 90L, 1L, false);
    ab.i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-feed停留分时时长-不准确: ".concat(String.valueOf(d2)));
    AppMethodBeat.o(73462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.b
 * JD-Core Version:    0.7.0.1
 */