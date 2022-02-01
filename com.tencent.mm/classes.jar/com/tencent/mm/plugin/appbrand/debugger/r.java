package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class r
{
  private static int kfh = -1;
  
  public static String OL(String paramString)
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
  
  public static void a(c paramc, int paramInt)
  {
    AppMethodBeat.i(147079);
    int i = (int)(System.currentTimeMillis() - paramc.kdZ);
    ((b)e.L(b.class)).f(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramc.size), Integer.valueOf(paramInt), Integer.valueOf(1), "", bu.nullAsNil(paramc.dmp), Integer.valueOf(bfD()), Integer.valueOf(bfE()) });
    AppMethodBeat.o(147079);
  }
  
  public static void a(eay parameay, l paraml)
  {
    AppMethodBeat.i(147078);
    if (paraml != null)
    {
      int i = (int)(System.currentTimeMillis() - paraml.kdZ);
      ((b)e.L(b.class)).f(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paraml.size), Integer.valueOf(parameay.computeSize()), Integer.valueOf(0), "", "", Integer.valueOf(bfD()), Integer.valueOf(bfE()) });
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
      ((b)e.L(b.class)).f(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(2), paramString, paramLinkedList, Integer.valueOf(bfD()), Integer.valueOf(bfE()) });
      AppMethodBeat.o(147080);
      return;
    }
  }
  
  private static int bfD()
  {
    AppMethodBeat.i(147082);
    if (kfh >= 0)
    {
      i = kfh;
      AppMethodBeat.o(147082);
      return i;
    }
    int i = az.getISPCode(ak.getContext());
    kfh = i;
    AppMethodBeat.o(147082);
    return i;
  }
  
  public static int bfE()
  {
    AppMethodBeat.i(147083);
    Context localContext = ak.getContext();
    int i = 5;
    if (!az.isConnected(localContext)) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(147083);
      return i;
      if (az.is2G(localContext)) {
        i = 1;
      } else if (az.is3G(localContext)) {
        i = 2;
      } else if (az.is4G(localContext)) {
        i = 3;
      } else if (az.isWifi(localContext)) {
        i = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.r
 * JD-Core Version:    0.7.0.1
 */