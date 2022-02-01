package com.tencent.mm.bs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
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
  private static final Map<Integer, Integer> Kye;
  
  static
  {
    AppMethodBeat.i(32071);
    Kye = new HashMap();
    AppMethodBeat.o(32071);
  }
  
  public static void aiT(int paramInt)
  {
    AppMethodBeat.i(32068);
    int i = Util.nullAsNil((Integer)Kye.get(Integer.valueOf(paramInt)));
    Kye.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
    AppMethodBeat.o(32068);
  }
  
  public static void bfX(String paramString)
  {
    AppMethodBeat.i(32070);
    paramString = paramString + gsY();
    Iterator localIterator = Kye.entrySet().iterator();
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
    Kye.clear();
    if (localStringBuilder.length() > 0)
    {
      Log.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
      cf.I(10, localStringBuilder.toString());
    }
    Log.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(paramString + gsY())));
    try
    {
      bg.aVF();
      c.azQ().set(66819, Long.valueOf(Util.nowSecond()));
      AppMethodBeat.o(32070);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.PostTaskFMessageCardStat", "e:" + paramString.getMessage());
      AppMethodBeat.o(32070);
    }
  }
  
  public static String gsY()
  {
    AppMethodBeat.i(32069);
    StringBuilder localStringBuilder = new StringBuilder("[a=");
    if (bg.aVF() == null) {}
    for (String str = "0";; str = "1")
    {
      str = str + " ";
      if (bg.aVF() != null) {
        break;
      }
      AppMethodBeat.o(32069);
      return str;
    }
    localStringBuilder = new StringBuilder().append(str).append("c=");
    bg.aVF();
    if (c.azQ() == null)
    {
      str = "0";
      str = str + " ";
      localStringBuilder = new StringBuilder().append(str).append("u=");
      if (!bg.aAc()) {
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
    bg.aVF();
    if (Util.secondsToNow(Util.nullAs((Long)c.azQ().get(66819, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bfX("");
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