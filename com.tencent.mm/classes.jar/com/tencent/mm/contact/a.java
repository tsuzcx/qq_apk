package com.tencent.mm.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  public static void a(an paraman, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(116828);
    an localan = paraman;
    if (paraman == null) {
      localan = ((l)g.ab(l.class)).azF().BH(paramString);
    }
    if ((localan != null) && ((int)localan.ght > 0) && (c.lO(localan.field_type)))
    {
      localan.tS(h(paramArrayList));
      g(localan);
      ((l)g.ab(l.class)).azF().am(localan);
    }
    AppMethodBeat.o(116828);
  }
  
  public static String[] a(an paraman, String paramString)
  {
    AppMethodBeat.i(116825);
    if (paramString != null)
    {
      paraman = paramString.split(d(paraman));
      AppMethodBeat.o(116825);
      return paraman;
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
  
  public static String d(an paraman)
  {
    if (paraman == null) {
      return ",";
    }
    if (paraman.eRz == 0) {
      return ",";
    }
    return "，";
  }
  
  public static String[] e(an paraman)
  {
    AppMethodBeat.i(116824);
    if (paraman == null)
    {
      AppMethodBeat.o(116824);
      return null;
    }
    if (paraman.eRu != null)
    {
      paraman = paraman.eRu.split(d(paraman));
      AppMethodBeat.o(116824);
      return paraman;
    }
    AppMethodBeat.o(116824);
    return null;
  }
  
  public static int f(an paraman)
  {
    AppMethodBeat.i(116829);
    paraman = e(paraman);
    if (paraman == null)
    {
      AppMethodBeat.o(116829);
      return 0;
    }
    if (paraman.length >= 5)
    {
      AppMethodBeat.o(116829);
      return 5;
    }
    int i = paraman.length;
    AppMethodBeat.o(116829);
    return i;
  }
  
  public static void g(an paraman)
  {
    AppMethodBeat.i(116830);
    if (paraman != null) {
      paraman.VR();
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
 * Qualified Name:     com.tencent.mm.contact.a
 * JD-Core Version:    0.7.0.1
 */