package com.tencent.mm.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  public static void a(au paramau, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(116828);
    au localau = paramau;
    if (paramau == null) {
      localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    }
    if ((localau != null) && ((int)localau.maN > 0) && (d.rs(localau.field_type)))
    {
      localau.BB(m(paramArrayList));
      h(localau);
      ((n)h.ax(n.class)).bzA().aA(localau);
    }
    AppMethodBeat.o(116828);
  }
  
  public static String[] a(au paramau, String paramString)
  {
    AppMethodBeat.i(116825);
    if (paramString != null)
    {
      paramau = paramString.split(e(paramau));
      AppMethodBeat.o(116825);
      return paramau;
    }
    AppMethodBeat.o(116825);
    return null;
  }
  
  public static String[] av(String paramString1, String paramString2)
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
  
  public static String e(au paramau)
  {
    if (paramau == null) {
      return ",";
    }
    if (paramau.kaw == 0) {
      return ",";
    }
    return "，";
  }
  
  public static String[] f(au paramau)
  {
    AppMethodBeat.i(116824);
    if (paramau == null)
    {
      AppMethodBeat.o(116824);
      return null;
    }
    if (paramau.kar != null)
    {
      paramau = paramau.kar.split(e(paramau));
      AppMethodBeat.o(116824);
      return paramau;
    }
    AppMethodBeat.o(116824);
    return null;
  }
  
  public static int g(au paramau)
  {
    AppMethodBeat.i(116829);
    paramau = f(paramau);
    if (paramau == null)
    {
      AppMethodBeat.o(116829);
      return 0;
    }
    if (paramau.length >= 5)
    {
      AppMethodBeat.o(116829);
      return 5;
    }
    int i = paramau.length;
    AppMethodBeat.o(116829);
    return i;
  }
  
  public static void h(au paramau)
  {
    AppMethodBeat.i(116830);
    if (paramau != null) {
      paramau.aJC();
    }
    AppMethodBeat.o(116830);
  }
  
  public static String m(ArrayList<String> paramArrayList)
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