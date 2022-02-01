package com.tencent.mm.bs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static final Map<Integer, Integer> FEZ;
  
  static
  {
    AppMethodBeat.i(32071);
    FEZ = new HashMap();
    AppMethodBeat.o(32071);
  }
  
  public static void aPu(String paramString)
  {
    AppMethodBeat.i(32070);
    paramString = paramString + fjy();
    Iterator localIterator = FEZ.entrySet().iterator();
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
    FEZ.clear();
    if (localStringBuilder.length() > 0)
    {
      ae.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
      cb.F(10, localStringBuilder.toString());
    }
    ae.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(paramString + fjy())));
    try
    {
      bc.aCg();
      c.ajA().set(66819, Long.valueOf(bu.aRi()));
      AppMethodBeat.o(32070);
      return;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.PostTaskFMessageCardStat", "e:" + paramString.getMessage());
      AppMethodBeat.o(32070);
    }
  }
  
  public static void aae(int paramInt)
  {
    AppMethodBeat.i(32068);
    int i = bu.o((Integer)FEZ.get(Integer.valueOf(paramInt)));
    FEZ.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
    AppMethodBeat.o(32068);
  }
  
  public static String fjy()
  {
    AppMethodBeat.i(32069);
    StringBuilder localStringBuilder = new StringBuilder("[a=");
    if (bc.aCg() == null) {}
    for (String str = "0";; str = "1")
    {
      str = str + " ";
      if (bc.aCg() != null) {
        break;
      }
      AppMethodBeat.o(32069);
      return str;
    }
    localStringBuilder = new StringBuilder().append(str).append("c=");
    bc.aCg();
    if (c.ajA() == null)
    {
      str = "0";
      str = str + " ";
      localStringBuilder = new StringBuilder().append(str).append("u=");
      if (!bc.ajM()) {
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
    bc.aCg();
    if (bu.rZ(bu.a((Long)c.ajA().get(66819, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aPu("");
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