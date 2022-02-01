package com.tencent.mm.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  public static void a(ai paramai, String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(116828);
    ai localai = paramai;
    if (paramai == null) {
      localai = ((k)g.ab(k.class)).awB().aNt(paramString);
    }
    if ((localai != null) && ((int)localai.fLJ > 0) && (b.ln(localai.field_type)))
    {
      localai.qN(h(paramArrayList));
      g(localai);
      ((k)g.ab(k.class)).awB().af(localai);
    }
    AppMethodBeat.o(116828);
  }
  
  public static String[] a(ai paramai, String paramString)
  {
    AppMethodBeat.i(116825);
    if (paramString != null)
    {
      paramai = paramString.split(d(paramai));
      AppMethodBeat.o(116825);
      return paramai;
    }
    AppMethodBeat.o(116825);
    return null;
  }
  
  public static String[] ai(String paramString1, String paramString2)
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
  
  public static String d(ai paramai)
  {
    if (paramai == null) {
      return ",";
    }
    if (paramai.eyq == 0) {
      return ",";
    }
    return "，";
  }
  
  public static String[] e(ai paramai)
  {
    AppMethodBeat.i(116824);
    if (paramai == null)
    {
      AppMethodBeat.o(116824);
      return null;
    }
    if (paramai.eyl != null)
    {
      paramai = paramai.eyl.split(d(paramai));
      AppMethodBeat.o(116824);
      return paramai;
    }
    AppMethodBeat.o(116824);
    return null;
  }
  
  public static int f(ai paramai)
  {
    AppMethodBeat.i(116829);
    paramai = e(paramai);
    if (paramai == null)
    {
      AppMethodBeat.o(116829);
      return 0;
    }
    if (paramai.length >= 5)
    {
      AppMethodBeat.o(116829);
      return 5;
    }
    int i = paramai.length;
    AppMethodBeat.o(116829);
    return i;
  }
  
  public static void g(ai paramai)
  {
    AppMethodBeat.i(116830);
    if (paramai != null) {
      paramai.Tu();
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
 * Qualified Name:     com.tencent.mm.n.a
 * JD-Core Version:    0.7.0.1
 */