package com.tencent.mm.bt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.by;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static final Map<Integer, Integer> Cpc;
  
  static
  {
    AppMethodBeat.i(32071);
    Cpc = new HashMap();
    AppMethodBeat.o(32071);
  }
  
  public static void Vt(int paramInt)
  {
    AppMethodBeat.i(32068);
    int i = bt.l((Integer)Cpc.get(Integer.valueOf(paramInt)));
    Cpc.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
    AppMethodBeat.o(32068);
  }
  
  public static void aDd(String paramString)
  {
    AppMethodBeat.i(32070);
    paramString = paramString + eBk();
    Iterator localIterator = Cpc.entrySet().iterator();
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
    Cpc.clear();
    if (localStringBuilder.length() > 0)
    {
      ad.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
      by.E(10, localStringBuilder.toString());
    }
    ad.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(paramString + eBk())));
    try
    {
      az.arV();
      c.afk().set(66819, Long.valueOf(bt.aGK()));
      AppMethodBeat.o(32070);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.PostTaskFMessageCardStat", "e:" + paramString.getMessage());
      AppMethodBeat.o(32070);
    }
  }
  
  public static String eBk()
  {
    AppMethodBeat.i(32069);
    StringBuilder localStringBuilder = new StringBuilder("[a=");
    if (az.arV() == null) {}
    for (String str = "0";; str = "1")
    {
      str = str + " ";
      if (az.arV() != null) {
        break;
      }
      AppMethodBeat.o(32069);
      return str;
    }
    localStringBuilder = new StringBuilder().append(str).append("c=");
    az.arV();
    if (c.afk() == null)
    {
      str = "0";
      str = str + " ";
      localStringBuilder = new StringBuilder().append(str).append("u=");
      if (!az.afw()) {
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
    az.arV();
    if (bt.lZ(bt.a((Long)c.afk().get(66819, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aDd("");
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