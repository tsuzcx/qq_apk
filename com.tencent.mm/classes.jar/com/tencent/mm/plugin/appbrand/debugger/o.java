package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cgk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o
{
  private static int fSM = -1;
  
  public static void a(a parama, int paramInt)
  {
    int i = (int)(System.currentTimeMillis() - parama.fRE);
    h.nFQ.f(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(parama.size), Integer.valueOf(paramInt), Integer.valueOf(1), "", bk.pm(parama.bGt), Integer.valueOf(aeL()), Integer.valueOf(aeM()) });
  }
  
  public static void a(cgk paramcgk, i parami)
  {
    if (parami != null)
    {
      int i = (int)(System.currentTimeMillis() - parami.fRE);
      h.nFQ.f(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(parami.size), Integer.valueOf(paramcgk.btq()), Integer.valueOf(0), "", "", Integer.valueOf(aeL()), Integer.valueOf(aeM()) });
    }
  }
  
  public static void a(String paramString, LinkedList<String> paramLinkedList, long paramLong, int paramInt1, int paramInt2)
  {
    String str2 = "";
    String str1;
    if (!paramString.equals("invokeHandler"))
    {
      str1 = str2;
      if (!paramString.equals("publishHandler")) {}
    }
    else
    {
      str1 = str2;
      if (paramLinkedList.size() > 0) {
        str1 = (String)paramLinkedList.get(0);
      }
    }
    int i = (int)(System.currentTimeMillis() - paramLong);
    h.nFQ.f(15190, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(2), paramString, str1, Integer.valueOf(aeL()), Integer.valueOf(aeM()) });
  }
  
  private static int aeL()
  {
    if (fSM >= 0) {
      return fSM;
    }
    int i = aq.getISPCode(ae.getContext());
    fSM = i;
    return i;
  }
  
  public static int aeM()
  {
    Context localContext = ae.getContext();
    int i = 5;
    if (!aq.isConnected(localContext)) {
      i = 0;
    }
    do
    {
      return i;
      if (aq.is2G(localContext)) {
        return 1;
      }
      if (aq.is3G(localContext)) {
        return 2;
      }
      if (aq.is4G(localContext)) {
        return 3;
      }
    } while (!aq.isWifi(localContext));
    return 4;
  }
  
  public static String sP(String paramString)
  {
    paramString = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o
 * JD-Core Version:    0.7.0.1
 */