package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.protocal.protobuf.bhn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  private static void G(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(49299);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idkeyGroupStat:  id:1043");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      IDKey localIDKey = (IDKey)paramArrayList.next();
      localStringBuilder.append(", key:" + localIDKey.GetKey() + " value:" + localIDKey.GetValue());
    }
    b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", localStringBuilder.toString());
    AppMethodBeat.o(49299);
  }
  
  public static void a(long paramLong, bhn parambhn)
  {
    AppMethodBeat.i(49297);
    int i;
    ArrayList localArrayList;
    if ((parambhn == null) || (parambhn.GCT == null))
    {
      i = 0;
      b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", "doReportCgiGet costTime:%d, list size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(1043);
      localIDKey.SetKey(0);
      localIDKey.SetValue(1L);
      localArrayList = new ArrayList();
      localArrayList.add(localIDKey);
      if (parambhn != null) {
        break label223;
      }
      parambhn = new IDKey();
      parambhn.SetID(1043);
      parambhn.SetKey(1);
      parambhn.SetValue(1L);
      localArrayList.add(parambhn);
    }
    for (;;)
    {
      parambhn = new IDKey();
      parambhn.SetID(1043);
      parambhn.SetKey(5);
      parambhn.SetValue(1L);
      localArrayList.add(parambhn);
      parambhn = new IDKey();
      parambhn.SetID(1043);
      parambhn.SetKey(sX(paramLong));
      parambhn.SetValue(1L);
      localArrayList.add(parambhn);
      com.tencent.mm.plugin.report.service.g.yhR.b(localArrayList, true);
      G(localArrayList);
      AppMethodBeat.o(49297);
      return;
      i = parambhn.GCT.size();
      break;
      label223:
      if ((parambhn.GCT == null) || (parambhn.GCT.size() == 0))
      {
        parambhn = new IDKey();
        parambhn.SetID(1043);
        parambhn.SetKey(2);
        parambhn.SetValue(1L);
        localArrayList.add(parambhn);
      }
      else
      {
        parambhn = new IDKey();
        parambhn.SetID(1043);
        parambhn.SetKey(3);
        parambhn.SetValue(1L);
        localArrayList.add(parambhn);
      }
    }
  }
  
  private static int sX(long paramLong)
  {
    if (paramLong <= 1L) {
      return 6;
    }
    if ((1L < paramLong) && (paramLong <= 3L)) {
      return 7;
    }
    if ((3L < paramLong) && (paramLong <= 5L)) {
      return 8;
    }
    if ((5L < paramLong) && (paramLong <= 10L)) {
      return 9;
    }
    if ((10L < paramLong) && (paramLong <= 20L)) {
      return 10;
    }
    return 11;
  }
  
  public static void vF(int paramInt)
  {
    AppMethodBeat.i(49298);
    b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", "doReportDataSource");
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1043);
    localIDKey.SetKey(18);
    localIDKey.SetValue(1L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey);
    localIDKey = new IDKey();
    localIDKey.SetID(1043);
    if (paramInt == 1) {
      localIDKey.SetKey(19);
    }
    for (;;)
    {
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      com.tencent.mm.plugin.report.service.g.yhR.b(localArrayList, true);
      G(localArrayList);
      AppMethodBeat.o(49298);
      return;
      localIDKey.SetKey(20);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.g
 * JD-Core Version:    0.7.0.1
 */