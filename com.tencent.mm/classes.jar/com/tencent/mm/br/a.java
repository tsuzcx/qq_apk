package com.tencent.mm.br;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static final Map<Integer, Integer> whb;
  
  static
  {
    AppMethodBeat.i(28267);
    whb = new HashMap();
    AppMethodBeat.o(28267);
  }
  
  public static void My(int paramInt)
  {
    AppMethodBeat.i(28264);
    int i = bo.g((Integer)whb.get(Integer.valueOf(paramInt)));
    whb.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
    AppMethodBeat.o(28264);
  }
  
  public static void ani(String paramString)
  {
    AppMethodBeat.i(28266);
    paramString = paramString + dpV();
    Iterator localIterator = whb.entrySet().iterator();
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
    whb.clear();
    if (localStringBuilder.length() > 0)
    {
      ab.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
      bv.v(10, localStringBuilder.toString());
    }
    ab.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(paramString + dpV())));
    try
    {
      aw.aaz();
      c.Ru().set(66819, Long.valueOf(bo.aox()));
      AppMethodBeat.o(28266);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.PostTaskFMessageCardStat", "e:" + paramString.getMessage());
      AppMethodBeat.o(28266);
    }
  }
  
  public static String dpV()
  {
    AppMethodBeat.i(28265);
    StringBuilder localStringBuilder = new StringBuilder("[a=");
    if (aw.aaz() == null) {}
    for (String str = "0";; str = "1")
    {
      str = str + " ";
      if (aw.aaz() != null) {
        break;
      }
      AppMethodBeat.o(28265);
      return str;
    }
    localStringBuilder = new StringBuilder().append(str).append("c=");
    aw.aaz();
    if (c.Ru() == null)
    {
      str = "0";
      str = str + " ";
      localStringBuilder = new StringBuilder().append(str).append("u=");
      if (!aw.RG()) {
        break label157;
      }
    }
    label157:
    for (str = "1";; str = "0")
    {
      str = str + "]";
      AppMethodBeat.o(28265);
      return str;
      str = "1";
      break;
    }
  }
  
  public static void run()
  {
    AppMethodBeat.i(28263);
    aw.aaz();
    if (bo.gz(bo.a((Long)c.Ru().get(66819, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ani("");
      }
      AppMethodBeat.o(28263);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.br.a
 * JD-Core Version:    0.7.0.1
 */