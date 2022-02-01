package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q
{
  private static int jhp = -1;
  
  public static String GG(String paramString)
  {
    AppMethodBeat.i(147081);
    paramString = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(147081);
      return paramString;
    }
    AppMethodBeat.o(147081);
    return "";
  }
  
  public static void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(147079);
    int i = (int)(System.currentTimeMillis() - paramb.jgi);
    ((com.tencent.mm.plugin.appbrand.u.b)e.L(com.tencent.mm.plugin.appbrand.u.b.class)).f(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramb.size), Integer.valueOf(paramInt), Integer.valueOf(1), "", bt.nullAsNil(paramb.dcx), Integer.valueOf(aUt()), Integer.valueOf(aUu()) });
    AppMethodBeat.o(147079);
  }
  
  public static void a(dnw paramdnw, k paramk)
  {
    AppMethodBeat.i(147078);
    if (paramk != null)
    {
      int i = (int)(System.currentTimeMillis() - paramk.jgi);
      ((com.tencent.mm.plugin.appbrand.u.b)e.L(com.tencent.mm.plugin.appbrand.u.b.class)).f(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramk.size), Integer.valueOf(paramdnw.computeSize()), Integer.valueOf(0), "", "", Integer.valueOf(aUt()), Integer.valueOf(aUu()) });
    }
    AppMethodBeat.o(147078);
  }
  
  public static void a(String paramString, LinkedList<String> paramLinkedList, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147080);
    if (((paramString.equals("invokeHandler")) || (paramString.equals("publishHandler"))) && (paramLinkedList.size() > 0)) {}
    for (paramLinkedList = (String)paramLinkedList.get(0);; paramLinkedList = "")
    {
      int i = (int)(System.currentTimeMillis() - paramLong);
      ((com.tencent.mm.plugin.appbrand.u.b)e.L(com.tencent.mm.plugin.appbrand.u.b.class)).f(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(2), paramString, paramLinkedList, Integer.valueOf(aUt()), Integer.valueOf(aUu()) });
      AppMethodBeat.o(147080);
      return;
    }
  }
  
  private static int aUt()
  {
    AppMethodBeat.i(147082);
    if (jhp >= 0)
    {
      i = jhp;
      AppMethodBeat.o(147082);
      return i;
    }
    int i = ay.getISPCode(aj.getContext());
    jhp = i;
    AppMethodBeat.o(147082);
    return i;
  }
  
  public static int aUu()
  {
    AppMethodBeat.i(147083);
    Context localContext = aj.getContext();
    int i = 5;
    if (!ay.isConnected(localContext)) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(147083);
      return i;
      if (ay.is2G(localContext)) {
        i = 1;
      } else if (ay.is3G(localContext)) {
        i = 2;
      } else if (ay.is4G(localContext)) {
        i = 3;
      } else if (ay.isWifi(localContext)) {
        i = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.q
 * JD-Core Version:    0.7.0.1
 */