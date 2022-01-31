package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q
{
  private static int hmm = -1;
  
  public static String AP(String paramString)
  {
    AppMethodBeat.i(101893);
    paramString = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(101893);
      return paramString;
    }
    AppMethodBeat.o(101893);
    return "";
  }
  
  public static void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(101891);
    int i = (int)(System.currentTimeMillis() - paramb.hlb);
    ((com.tencent.mm.plugin.appbrand.o.b)e.r(com.tencent.mm.plugin.appbrand.o.b.class)).e(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramb.size), Integer.valueOf(paramInt), Integer.valueOf(1), "", bo.nullAsNil(paramb.cnC), Integer.valueOf(azm()), Integer.valueOf(azn()) });
    AppMethodBeat.o(101891);
  }
  
  public static void a(ctv paramctv, k paramk)
  {
    AppMethodBeat.i(101890);
    if (paramk != null)
    {
      int i = (int)(System.currentTimeMillis() - paramk.hlb);
      ((com.tencent.mm.plugin.appbrand.o.b)e.r(com.tencent.mm.plugin.appbrand.o.b.class)).e(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramk.size), Integer.valueOf(paramctv.computeSize()), Integer.valueOf(0), "", "", Integer.valueOf(azm()), Integer.valueOf(azn()) });
    }
    AppMethodBeat.o(101890);
  }
  
  public static void a(String paramString, LinkedList<String> paramLinkedList, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101892);
    if (((paramString.equals("invokeHandler")) || (paramString.equals("publishHandler"))) && (paramLinkedList.size() > 0)) {}
    for (paramLinkedList = (String)paramLinkedList.get(0);; paramLinkedList = "")
    {
      int i = (int)(System.currentTimeMillis() - paramLong);
      ((com.tencent.mm.plugin.appbrand.o.b)e.r(com.tencent.mm.plugin.appbrand.o.b.class)).e(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(2), paramString, paramLinkedList, Integer.valueOf(azm()), Integer.valueOf(azn()) });
      AppMethodBeat.o(101892);
      return;
    }
  }
  
  private static int azm()
  {
    AppMethodBeat.i(101894);
    if (hmm >= 0)
    {
      i = hmm;
      AppMethodBeat.o(101894);
      return i;
    }
    int i = at.getISPCode(ah.getContext());
    hmm = i;
    AppMethodBeat.o(101894);
    return i;
  }
  
  public static int azn()
  {
    AppMethodBeat.i(101895);
    Context localContext = ah.getContext();
    int i = 5;
    if (!at.isConnected(localContext)) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(101895);
      return i;
      if (at.is2G(localContext)) {
        i = 1;
      } else if (at.is3G(localContext)) {
        i = 2;
      } else if (at.is4G(localContext)) {
        i = 3;
      } else if (at.isWifi(localContext)) {
        i = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.q
 * JD-Core Version:    0.7.0.1
 */