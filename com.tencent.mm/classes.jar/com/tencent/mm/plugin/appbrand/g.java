package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
{
  private static final Iterator<g.c> iCQ;
  private static final Map<String, b> iCR;
  private static final Map<String, d> iCS;
  private static final h<String, g.c> iCT;
  private static final h<String, g.a> iCU;
  
  static
  {
    AppMethodBeat.i(140582);
    iCQ = new g.1();
    iCR = new HashMap();
    iCS = new HashMap();
    iCT = new h();
    iCU = new h();
    AppMethodBeat.o(140582);
  }
  
  private static Iterator<g.c> CU(String paramString)
  {
    AppMethodBeat.i(140568);
    paramString = iCT.cD(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      AppMethodBeat.o(140568);
      return paramString;
    }
    paramString = iCQ;
    AppMethodBeat.o(140568);
    return paramString;
  }
  
  public static void CV(String paramString)
  {
    AppMethodBeat.i(140569);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140569);
      return;
    }
    paramString = CU(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).onCreate();
    }
    AppMethodBeat.o(140569);
  }
  
  public static void CW(String paramString)
  {
    AppMethodBeat.i(140570);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140570);
      return;
    }
    paramString = CU(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).onDestroy();
    }
    AppMethodBeat.o(140570);
  }
  
  public static void CX(String paramString)
  {
    AppMethodBeat.i(194794);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(194794);
      return;
    }
    paramString = CU(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).aLD();
    }
    AppMethodBeat.o(194794);
  }
  
  public static void CY(String paramString)
  {
    AppMethodBeat.i(140571);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140571);
      return;
    }
    Iterator localIterator = CU(paramString);
    while (localIterator.hasNext()) {
      ((g.c)localIterator.next()).a(Dd(paramString));
    }
    AppMethodBeat.o(140571);
  }
  
  public static void CZ(String paramString)
  {
    AppMethodBeat.i(140572);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140572);
      return;
    }
    paramString = CU(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).onResume();
    }
    AppMethodBeat.o(140572);
  }
  
  public static void Da(String paramString)
  {
    AppMethodBeat.i(140573);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140573);
      return;
    }
    paramString = CU(paramString);
    while (paramString.hasNext()) {
      paramString.next();
    }
    AppMethodBeat.o(140573);
  }
  
  public static void Db(String paramString)
  {
    AppMethodBeat.i(140576);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140576);
      return;
    }
    iCT.cE(paramString);
    iCU.cE(paramString);
    AppMethodBeat.o(140576);
  }
  
  public static void Dc(String paramString)
  {
    AppMethodBeat.i(140577);
    a(paramString, d.iDe);
    AppMethodBeat.o(140577);
  }
  
  public static d Dd(String paramString)
  {
    AppMethodBeat.i(140578);
    paramString = (d)iCS.get(paramString);
    if (paramString == null)
    {
      paramString = d.iDe;
      AppMethodBeat.o(140578);
      return paramString;
    }
    AppMethodBeat.o(140578);
    return paramString;
  }
  
  public static b De(String paramString)
  {
    AppMethodBeat.i(140581);
    b localb = (b)iCR.get(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = b.iCV;
    }
    AppMethodBeat.o(140581);
    return paramString;
  }
  
  public static void a(String paramString, g.a parama)
  {
    AppMethodBeat.i(182832);
    iCU.h(paramString, parama);
    AppMethodBeat.o(182832);
  }
  
  public static void a(String paramString, b paramb)
  {
    AppMethodBeat.i(140580);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140580);
      return;
    }
    iCR.put(paramString, paramb);
    AppMethodBeat.o(140580);
  }
  
  public static void a(String paramString, g.c paramc)
  {
    AppMethodBeat.i(140567);
    if ((TextUtils.isEmpty(paramString)) || (paramc == null))
    {
      AppMethodBeat.o(140567);
      return;
    }
    iCT.h(paramString, paramc);
    AppMethodBeat.o(140567);
  }
  
  public static void a(String paramString, d paramd)
  {
    AppMethodBeat.i(140579);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140579);
      return;
    }
    iCS.put(paramString, paramd);
    AppMethodBeat.o(140579);
  }
  
  public static void b(String paramString, g.a parama)
  {
    AppMethodBeat.i(182833);
    iCU.B(paramString, parama);
    AppMethodBeat.o(182833);
  }
  
  public static void b(String paramString, g.c paramc)
  {
    AppMethodBeat.i(140574);
    if ((paramc == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(140574);
      return;
    }
    iCT.B(paramString, paramc);
    AppMethodBeat.o(140574);
  }
  
  public static boolean b(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(182834);
    paramString = iCU.cD(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        if (((g.a)paramString.next()).onNewIntent(paramIntent))
        {
          AppMethodBeat.o(182834);
          return true;
        }
      }
    }
    AppMethodBeat.o(182834);
    return false;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(140563);
      iCV = new b("INIT", 0);
      iCW = new b("ON_CREATE", 1);
      iCX = new b("ON_RESUME", 2);
      iCY = new b("ON_PAUSE", 3);
      iCZ = new b("ON_STOP", 4);
      iDa = new b("ON_DESTROY", 5);
      iDb = new b[] { iCV, iCW, iCX, iCY, iCZ, iDa };
      AppMethodBeat.o(140563);
    }
    
    private b() {}
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(140566);
      iDc = new d("CLOSE", 0);
      iDd = new d("BACK", 1);
      iDe = new d("HIDE", 2);
      iDf = new d("HANG", 3);
      iDg = new d("HOME_PRESSED", 4);
      iDh = new d("RECENT_APPS_PRESSED", 5);
      iDi = new d("LAUNCH_NATIVE_PAGE", 6);
      iDj = new d("LAUNCH_MINI_PROGRAM", 7);
      iDk = new d[] { iDc, iDd, iDe, iDf, iDg, iDh, iDi, iDj };
      AppMethodBeat.o(140566);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g
 * JD-Core Version:    0.7.0.1
 */