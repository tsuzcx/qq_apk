package com.tencent.mm.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  public static void a(af paramaf, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(116828);
    af localaf = paramaf;
    if (paramaf == null) {
      localaf = ((k)g.ab(k.class)).apM().aHY(paramString);
    }
    if ((localaf != null) && ((int)localaf.fId > 0) && (b.ls(localaf.field_type)))
    {
      localaf.nH(g(paramArrayList));
      g(localaf);
      ((k)g.ab(k.class)).apM().ae(localaf);
    }
    AppMethodBeat.o(116828);
  }
  
  public static String[] a(af paramaf, String paramString)
  {
    AppMethodBeat.i(116825);
    if (paramString != null)
    {
      paramaf = paramString.split(d(paramaf));
      AppMethodBeat.o(116825);
      return paramaf;
    }
    AppMethodBeat.o(116825);
    return null;
  }
  
  public static String[] af(String paramString1, String paramString2)
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
  
  public static String d(af paramaf)
  {
    if (paramaf == null) {
      return ",";
    }
    if (paramaf.evT == 0) {
      return ",";
    }
    return "，";
  }
  
  public static String[] e(af paramaf)
  {
    AppMethodBeat.i(116824);
    if (paramaf == null)
    {
      AppMethodBeat.o(116824);
      return null;
    }
    if (paramaf.evO != null)
    {
      paramaf = paramaf.evO.split(d(paramaf));
      AppMethodBeat.o(116824);
      return paramaf;
    }
    AppMethodBeat.o(116824);
    return null;
  }
  
  public static int f(af paramaf)
  {
    AppMethodBeat.i(116829);
    paramaf = e(paramaf);
    if (paramaf == null)
    {
      AppMethodBeat.o(116829);
      return 0;
    }
    if (paramaf.length >= 5)
    {
      AppMethodBeat.o(116829);
      return 5;
    }
    int i = paramaf.length;
    AppMethodBeat.o(116829);
    return i;
  }
  
  public static String g(ArrayList<String> paramArrayList)
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
  
  public static void g(af paramaf)
  {
    AppMethodBeat.i(116830);
    if (paramaf != null) {
      paramaf.SA();
    }
    AppMethodBeat.o(116830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.n.a
 * JD-Core Version:    0.7.0.1
 */