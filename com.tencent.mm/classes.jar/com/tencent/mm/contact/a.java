package com.tencent.mm.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  public static void a(as paramas, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(116828);
    as localas = paramas;
    if (paramas == null) {
      localas = ((n)h.ae(n.class)).bbL().RG(paramString);
    }
    if ((localas != null) && ((int)localas.jxt > 0) && (d.rk(localas.field_type)))
    {
      localas.IW(j(paramArrayList));
      g(localas);
      ((n)h.ae(n.class)).bbL().au(localas);
    }
    AppMethodBeat.o(116828);
  }
  
  public static String[] a(as paramas, String paramString)
  {
    AppMethodBeat.i(116825);
    if (paramString != null)
    {
      paramas = paramString.split(d(paramas));
      AppMethodBeat.o(116825);
      return paramas;
    }
    AppMethodBeat.o(116825);
    return null;
  }
  
  public static String[] aq(String paramString1, String paramString2)
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
  
  public static String d(as paramas)
  {
    if (paramas == null) {
      return ",";
    }
    if (paramas.hDB == 0) {
      return ",";
    }
    return "，";
  }
  
  public static String[] e(as paramas)
  {
    AppMethodBeat.i(116824);
    if (paramas == null)
    {
      AppMethodBeat.o(116824);
      return null;
    }
    if (paramas.hDw != null)
    {
      paramas = paramas.hDw.split(d(paramas));
      AppMethodBeat.o(116824);
      return paramas;
    }
    AppMethodBeat.o(116824);
    return null;
  }
  
  public static int f(as paramas)
  {
    AppMethodBeat.i(116829);
    paramas = e(paramas);
    if (paramas == null)
    {
      AppMethodBeat.o(116829);
      return 0;
    }
    if (paramas.length >= 5)
    {
      AppMethodBeat.o(116829);
      return 5;
    }
    int i = paramas.length;
    AppMethodBeat.o(116829);
    return i;
  }
  
  public static void g(as paramas)
  {
    AppMethodBeat.i(116830);
    if (paramas != null) {
      paramas.apy();
    }
    AppMethodBeat.o(116830);
  }
  
  public static String j(ArrayList<String> paramArrayList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.contact.a
 * JD-Core Version:    0.7.0.1
 */