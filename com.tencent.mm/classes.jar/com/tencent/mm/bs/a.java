package com.tencent.mm.bs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static final Map<Integer, Integer> Ywt;
  
  static
  {
    AppMethodBeat.i(32071);
    Ywt = new HashMap();
    AppMethodBeat.o(32071);
  }
  
  public static void axl(int paramInt)
  {
    AppMethodBeat.i(32068);
    int i = Util.nullAsNil((Integer)Ywt.get(Integer.valueOf(paramInt)));
    Ywt.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
    AppMethodBeat.o(32068);
  }
  
  public static void bsh(String paramString)
  {
    AppMethodBeat.i(32070);
    paramString = paramString + iPf();
    Iterator localIterator = Ywt.entrySet().iterator();
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
    Ywt.clear();
    if (localStringBuilder.length() > 0)
    {
      Log.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
      ch.P(10, localStringBuilder.toString());
    }
    Log.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(paramString + iPf())));
    try
    {
      bh.bCz();
      c.ban().B(66819, Long.valueOf(Util.nowSecond()));
      AppMethodBeat.o(32070);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.PostTaskFMessageCardStat", "e:" + paramString.getMessage());
      AppMethodBeat.o(32070);
    }
  }
  
  public static String iPf()
  {
    AppMethodBeat.i(32069);
    StringBuilder localStringBuilder = new StringBuilder("[a=");
    if (bh.bCz() == null) {}
    for (String str = "0";; str = "1")
    {
      str = str + " ";
      if (bh.bCz() != null) {
        break;
      }
      AppMethodBeat.o(32069);
      return str;
    }
    localStringBuilder = new StringBuilder().append(str).append("c=");
    bh.bCz();
    if (c.ban() == null)
    {
      str = "0";
      str = str + " ";
      localStringBuilder = new StringBuilder().append(str).append("u=");
      if (!bh.baz()) {
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
    bh.bCz();
    if (Util.secondsToNow(Util.nullAs((Long)c.ban().d(66819, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bsh("");
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