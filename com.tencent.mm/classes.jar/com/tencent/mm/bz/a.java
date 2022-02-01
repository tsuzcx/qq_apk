package com.tencent.mm.bz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static final Map<Integer, Integer> RzS;
  
  static
  {
    AppMethodBeat.i(32071);
    RzS = new HashMap();
    AppMethodBeat.o(32071);
  }
  
  public static void are(int paramInt)
  {
    AppMethodBeat.i(32068);
    int i = Util.nullAsNil((Integer)RzS.get(Integer.valueOf(paramInt)));
    RzS.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
    AppMethodBeat.o(32068);
  }
  
  public static void bsq(String paramString)
  {
    AppMethodBeat.i(32070);
    paramString = paramString + hol();
    Iterator localIterator = RzS.entrySet().iterator();
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
    RzS.clear();
    if (localStringBuilder.length() > 0)
    {
      Log.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
      cg.K(10, localStringBuilder.toString());
    }
    Log.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(paramString + hol())));
    try
    {
      bh.beI();
      c.aHp().i(66819, Long.valueOf(Util.nowSecond()));
      AppMethodBeat.o(32070);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.PostTaskFMessageCardStat", "e:" + paramString.getMessage());
      AppMethodBeat.o(32070);
    }
  }
  
  public static String hol()
  {
    AppMethodBeat.i(32069);
    StringBuilder localStringBuilder = new StringBuilder("[a=");
    if (bh.beI() == null) {}
    for (String str = "0";; str = "1")
    {
      str = str + " ";
      if (bh.beI() != null) {
        break;
      }
      AppMethodBeat.o(32069);
      return str;
    }
    localStringBuilder = new StringBuilder().append(str).append("c=");
    bh.beI();
    if (c.aHp() == null)
    {
      str = "0";
      str = str + " ";
      localStringBuilder = new StringBuilder().append(str).append("u=");
      if (!bh.aHB()) {
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
    bh.beI();
    if (Util.secondsToNow(Util.nullAs((Long)c.aHp().b(66819, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bsq("");
      }
      AppMethodBeat.o(32067);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bz.a
 * JD-Core Version:    0.7.0.1
 */