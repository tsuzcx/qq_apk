package com.tencent.mm.bs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.by;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static final Map<Integer, Integer> DHu;
  
  static
  {
    AppMethodBeat.i(32071);
    DHu = new HashMap();
    AppMethodBeat.o(32071);
  }
  
  public static void XC(int paramInt)
  {
    AppMethodBeat.i(32068);
    int i = bs.m((Integer)DHu.get(Integer.valueOf(paramInt)));
    DHu.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
    AppMethodBeat.o(32068);
  }
  
  public static void aIu(String paramString)
  {
    AppMethodBeat.i(32070);
    paramString = paramString + eQE();
    Iterator localIterator = DHu.entrySet().iterator();
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
    DHu.clear();
    if (localStringBuilder.length() > 0)
    {
      ac.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
      by.F(10, localStringBuilder.toString());
    }
    ac.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(paramString + eQE())));
    try
    {
      az.ayM();
      c.agA().set(66819, Long.valueOf(bs.aNx()));
      AppMethodBeat.o(32070);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.PostTaskFMessageCardStat", "e:" + paramString.getMessage());
      AppMethodBeat.o(32070);
    }
  }
  
  public static String eQE()
  {
    AppMethodBeat.i(32069);
    StringBuilder localStringBuilder = new StringBuilder("[a=");
    if (az.ayM() == null) {}
    for (String str = "0";; str = "1")
    {
      str = str + " ";
      if (az.ayM() != null) {
        break;
      }
      AppMethodBeat.o(32069);
      return str;
    }
    localStringBuilder = new StringBuilder().append(str).append("c=");
    az.ayM();
    if (c.agA() == null)
    {
      str = "0";
      str = str + " ";
      localStringBuilder = new StringBuilder().append(str).append("u=");
      if (!az.agM()) {
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
    az.ayM();
    if (bs.pN(bs.a((Long)c.agA().get(66819, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aIu("");
      }
      AppMethodBeat.o(32067);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bs.a
 * JD-Core Version:    0.7.0.1
 */