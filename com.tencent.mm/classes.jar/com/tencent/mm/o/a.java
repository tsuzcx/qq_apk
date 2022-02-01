package com.tencent.mm.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  public static void a(am paramam, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(116828);
    am localam = paramam;
    if (paramam == null) {
      localam = ((l)g.ab(l.class)).azp().Bf(paramString);
    }
    if ((localam != null) && ((int)localam.gfj > 0) && (b.lM(localam.field_type)))
    {
      localam.tx(h(paramArrayList));
      g(localam);
      ((l)g.ab(l.class)).azp().af(localam);
    }
    AppMethodBeat.o(116828);
  }
  
  public static String[] a(am paramam, String paramString)
  {
    AppMethodBeat.i(116825);
    if (paramString != null)
    {
      paramam = paramString.split(d(paramam));
      AppMethodBeat.o(116825);
      return paramam;
    }
    AppMethodBeat.o(116825);
    return null;
  }
  
  public static String[] aj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116826);
    if (paramString1 != null)
    {
      paramString1 = paramString1.split(paramString2);
      AppMethodBeat.o(116826);
      return paramString1;
    }
    AppMethodBeat.o(116826);
    return null;
  }
  
  public static String d(am paramam)
  {
    if (paramam == null) {
      return ",";
    }
    if (paramam.ePO == 0) {
      return ",";
    }
    return "，";
  }
  
  public static String[] e(am paramam)
  {
    AppMethodBeat.i(116824);
    if (paramam == null)
    {
      AppMethodBeat.o(116824);
      return null;
    }
    if (paramam.ePJ != null)
    {
      paramam = paramam.ePJ.split(d(paramam));
      AppMethodBeat.o(116824);
      return paramam;
    }
    AppMethodBeat.o(116824);
    return null;
  }
  
  public static int f(am paramam)
  {
    AppMethodBeat.i(116829);
    paramam = e(paramam);
    if (paramam == null)
    {
      AppMethodBeat.o(116829);
      return 0;
    }
    if (paramam.length >= 5)
    {
      AppMethodBeat.o(116829);
      return 5;
    }
    int i = paramam.length;
    AppMethodBeat.o(116829);
    return i;
  }
  
  public static void g(am paramam)
  {
    AppMethodBeat.i(116830);
    if (paramam != null) {
      paramam.VJ();
    }
    AppMethodBeat.o(116830);
  }
  
  public static String h(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(116827);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(116827);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next()).append("，");
    }
    paramArrayList = localStringBuffer.toString();
    AppMethodBeat.o(116827);
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.o.a
 * JD-Core Version:    0.7.0.1
 */