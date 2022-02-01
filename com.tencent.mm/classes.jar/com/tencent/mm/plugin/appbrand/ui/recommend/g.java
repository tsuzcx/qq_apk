package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bdh;
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
  
  public static void a(long paramLong, bdh parambdh)
  {
    AppMethodBeat.i(49297);
    int i;
    ArrayList localArrayList;
    if ((parambdh == null) || (parambdh.ETz == null))
    {
      i = 0;
      b.i("MicroMsg.Recommend.AppBrandRecommendIdkeyReport", "doReportCgiGet costTime:%d, list size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(1043);
      localIDKey.SetKey(0);
      localIDKey.SetValue(1L);
      localArrayList = new ArrayList();
      localArrayList.add(localIDKey);
      if (parambdh != null) {
        break label223;
      }
      parambdh = new IDKey();
      parambdh.SetID(1043);
      parambdh.SetKey(1);
      parambdh.SetValue(1L);
      localArrayList.add(parambdh);
    }
    for (;;)
    {
      parambdh = new IDKey();
      parambdh.SetID(1043);
      parambdh.SetKey(5);
      parambdh.SetValue(1L);
      localArrayList.add(parambdh);
      parambdh = new IDKey();
      parambdh.SetID(1043);
      parambdh.SetKey(qY(paramLong));
      parambdh.SetValue(1L);
      localArrayList.add(parambdh);
      h.wUl.b(localArrayList, true);
      G(localArrayList);
      AppMethodBeat.o(49297);
      return;
      i = parambdh.ETz.size();
      break;
      label223:
      if ((parambdh.ETz == null) || (parambdh.ETz.size() == 0))
      {
        parambdh = new IDKey();
        parambdh.SetID(1043);
        parambdh.SetKey(2);
        parambdh.SetValue(1L);
        localArrayList.add(parambdh);
      }
      else
      {
        parambdh = new IDKey();
        parambdh.SetID(1043);
        parambdh.SetKey(3);
        parambdh.SetValue(1L);
        localArrayList.add(parambdh);
      }
    }
  }
  
  private static int qY(long paramLong)
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
  
  public static void va(int paramInt)
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
      h.wUl.b(localArrayList, true);
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