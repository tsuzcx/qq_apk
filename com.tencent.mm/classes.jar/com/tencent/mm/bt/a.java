package com.tencent.mm.bt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static final Map<Integer, Integer> FmB;
  
  static
  {
    AppMethodBeat.i(32071);
    FmB = new HashMap();
    AppMethodBeat.o(32071);
  }
  
  public static void Zy(int paramInt)
  {
    AppMethodBeat.i(32068);
    int i = bt.n((Integer)FmB.get(Integer.valueOf(paramInt)));
    FmB.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
    AppMethodBeat.o(32068);
  }
  
  public static void aNX(String paramString)
  {
    AppMethodBeat.i(32070);
    paramString = paramString + ffI();
    Iterator localIterator = FmB.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry != null) && (localEntry.getKey() != null) && (localEntry.getValue() != null) && (((Integer)localEntry.getValue()).intValue() != 0))
      {
        localStringBuilder.append(localEntry.getKey());
        localStringBuilder.append('=');
        localStringBuilder.append(localEntry.getValue());
        localStringBuilder.append(',');
      }
    }
    FmB.clear();
    if (localStringBuilder.length() > 0)
    {
      ad.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
      bz.F(10, localStringBuilder.toString());
    }
    ad.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(paramString + ffI())));
    try
    {
      ba.aBQ();
      c.ajl().set(66819, Long.valueOf(bt.aQJ()));
      AppMethodBeat.o(32070);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.PostTaskFMessageCardStat", "e:" + paramString.getMessage());
      AppMethodBeat.o(32070);
    }
  }
  
  public static String ffI()
  {
    AppMethodBeat.i(32069);
    StringBuilder localStringBuilder = new StringBuilder("[a=");
    if (ba.aBQ() == null) {}
    for (String str = "0";; str = "1")
    {
      str = str + " ";
      if (ba.aBQ() != null) {
        break;
      }
      AppMethodBeat.o(32069);
      return str;
    }
    localStringBuilder = new StringBuilder().append(str).append("c=");
    ba.aBQ();
    if (c.ajl() == null)
    {
      str = "0";
      str = str + " ";
      localStringBuilder = new StringBuilder().append(str).append("u=");
      if (!ba.ajx()) {
        break label157;
      }
    }
    label157:
    for (str = "1";; str = "0")
    {
      str = str + "]";
      AppMethodBeat.o(32069);
      return str;
      str = "1";
      break;
    }
  }
  
  public static void run()
  {
    AppMethodBeat.i(32067);
    ba.aBQ();
    if (bt.rM(bt.a((Long)c.ajl().get(66819, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aNX("");
      }
      AppMethodBeat.o(32067);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bt.a
 * JD-Core Version:    0.7.0.1
 */