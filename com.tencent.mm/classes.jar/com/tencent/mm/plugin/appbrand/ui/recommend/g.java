package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.apc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
{
  public static void a(long paramLong, apc paramapc)
  {
    AppMethodBeat.i(138150);
    int i;
    ArrayList localArrayList;
    if ((paramapc == null) || (paramapc.xfg == null))
    {
      i = 0;
      b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", "doReportCgiGet costTime:%d, list size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(1043);
      localIDKey.SetKey(0);
      localIDKey.SetValue(1L);
      localArrayList = new ArrayList();
      localArrayList.add(localIDKey);
      if (paramapc != null) {
        break label223;
      }
      paramapc = new IDKey();
      paramapc.SetID(1043);
      paramapc.SetKey(1);
      paramapc.SetValue(1L);
      localArrayList.add(paramapc);
    }
    for (;;)
    {
      paramapc = new IDKey();
      paramapc.SetID(1043);
      paramapc.SetKey(5);
      paramapc.SetValue(1L);
      localArrayList.add(paramapc);
      paramapc = new IDKey();
      paramapc.SetID(1043);
      paramapc.SetKey(hF(paramLong));
      paramapc.SetValue(1L);
      localArrayList.add(paramapc);
      h.qsU.b(localArrayList, true);
      r(localArrayList);
      AppMethodBeat.o(138150);
      return;
      i = paramapc.xfg.size();
      break;
      label223:
      if ((paramapc.xfg == null) || (paramapc.xfg.size() == 0))
      {
        paramapc = new IDKey();
        paramapc.SetID(1043);
        paramapc.SetKey(2);
        paramapc.SetValue(1L);
        localArrayList.add(paramapc);
      }
      else
      {
        paramapc = new IDKey();
        paramapc.SetID(1043);
        paramapc.SetKey(3);
        paramapc.SetValue(1L);
        localArrayList.add(paramapc);
      }
    }
  }
  
  private static int hF(long paramLong)
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
  
  public static void pK(int paramInt)
  {
    AppMethodBeat.i(138151);
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
      h.qsU.b(localArrayList, true);
      r(localArrayList);
      AppMethodBeat.o(138151);
      return;
      localIDKey.SetKey(20);
    }
  }
  
  private static void r(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(138152);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idkeyGroupStat:  id:1043");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      IDKey localIDKey = (IDKey)paramArrayList.next();
      localStringBuilder.append(", key:" + localIDKey.GetKey() + " value:" + localIDKey.GetValue());
    }
    b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", localStringBuilder.toString());
    AppMethodBeat.o(138152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.g
 * JD-Core Version:    0.7.0.1
 */