package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class k
{
  private static final Iterator<k.c> nsP;
  private static final Map<String, k.b> nsQ;
  private static final Map<String, d> nsR;
  private static final h<String, k.c> nsS;
  private static final h<String, k.a> nsT;
  
  static
  {
    AppMethodBeat.i(140582);
    nsP = new k.1();
    nsQ = new HashMap();
    nsR = new HashMap();
    nsS = new h();
    nsT = new h();
    AppMethodBeat.o(140582);
  }
  
  public static void a(String paramString, k.a parama)
  {
    AppMethodBeat.i(182832);
    nsT.k(paramString, parama);
    AppMethodBeat.o(182832);
  }
  
  public static void a(String paramString, k.b paramb)
  {
    AppMethodBeat.i(140580);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140580);
      return;
    }
    nsQ.put(paramString, paramb);
    AppMethodBeat.o(140580);
  }
  
  public static void a(String paramString, k.c paramc)
  {
    AppMethodBeat.i(140567);
    if ((TextUtils.isEmpty(paramString)) || (paramc == null))
    {
      AppMethodBeat.o(140567);
      return;
    }
    nsS.k(paramString, paramc);
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
    nsR.put(paramString, paramd);
    AppMethodBeat.o(140579);
  }
  
  private static Iterator<k.c> abD(String paramString)
  {
    AppMethodBeat.i(140568);
    paramString = nsS.cN(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      AppMethodBeat.o(140568);
      return paramString;
    }
    paramString = nsP;
    AppMethodBeat.o(140568);
    return paramString;
  }
  
  public static void abE(String paramString)
  {
    AppMethodBeat.i(140569);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140569);
      return;
    }
    paramString = abD(paramString);
    while (paramString.hasNext()) {
      ((k.c)paramString.next()).onCreate();
    }
    AppMethodBeat.o(140569);
  }
  
  public static void abF(String paramString)
  {
    AppMethodBeat.i(140570);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140570);
      return;
    }
    paramString = abD(paramString);
    while (paramString.hasNext()) {
      ((k.c)paramString.next()).onDestroy();
    }
    AppMethodBeat.o(140570);
  }
  
  public static void abG(String paramString)
  {
    AppMethodBeat.i(210457);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(210457);
      return;
    }
    paramString = abD(paramString);
    while (paramString.hasNext()) {
      ((k.c)paramString.next()).bBQ();
    }
    AppMethodBeat.o(210457);
  }
  
  public static void abH(String paramString)
  {
    AppMethodBeat.i(140571);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140571);
      return;
    }
    Iterator localIterator = abD(paramString);
    while (localIterator.hasNext()) {
      ((k.c)localIterator.next()).a(abM(paramString));
    }
    AppMethodBeat.o(140571);
  }
  
  public static void abI(String paramString)
  {
    AppMethodBeat.i(140572);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140572);
      return;
    }
    paramString = abD(paramString);
    while (paramString.hasNext()) {
      ((k.c)paramString.next()).onResume();
    }
    AppMethodBeat.o(140572);
  }
  
  public static void abJ(String paramString)
  {
    AppMethodBeat.i(140573);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140573);
      return;
    }
    paramString = abD(paramString);
    while (paramString.hasNext()) {
      paramString.next();
    }
    AppMethodBeat.o(140573);
  }
  
  public static void abK(String paramString)
  {
    AppMethodBeat.i(140576);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140576);
      return;
    }
    nsS.cO(paramString);
    nsT.cO(paramString);
    AppMethodBeat.o(140576);
  }
  
  public static void abL(String paramString)
  {
    AppMethodBeat.i(140577);
    a(paramString, d.ntd);
    AppMethodBeat.o(140577);
  }
  
  public static d abM(String paramString)
  {
    AppMethodBeat.i(140578);
    paramString = (d)nsR.get(paramString);
    if (paramString == null)
    {
      paramString = d.ntd;
      AppMethodBeat.o(140578);
      return paramString;
    }
    AppMethodBeat.o(140578);
    return paramString;
  }
  
  public static k.b abN(String paramString)
  {
    AppMethodBeat.i(140581);
    k.b localb = (k.b)nsQ.get(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = k.b.nsU;
    }
    AppMethodBeat.o(140581);
    return paramString;
  }
  
  public static void b(String paramString, k.a parama)
  {
    AppMethodBeat.i(182833);
    nsT.D(paramString, parama);
    AppMethodBeat.o(182833);
  }
  
  public static void b(String paramString, k.c paramc)
  {
    AppMethodBeat.i(140574);
    if ((paramc == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(140574);
      return;
    }
    nsS.D(paramString, paramc);
    AppMethodBeat.o(140574);
  }
  
  public static boolean b(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(182834);
    paramString = nsT.cN(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        if (((k.a)paramString.next()).onNewIntent(paramIntent))
        {
          AppMethodBeat.o(182834);
          return true;
        }
      }
    }
    AppMethodBeat.o(182834);
    return false;
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(140566);
      ntb = new d("CLOSE", 0);
      ntc = new d("BACK", 1);
      ntd = new d("HIDE", 2);
      nte = new d("HANG", 3);
      ntf = new d("HOME_PRESSED", 4);
      ntg = new d("RECENT_APPS_PRESSED", 5);
      nth = new d("LAUNCH_NATIVE_PAGE", 6);
      nti = new d("LAUNCH_MINI_PROGRAM", 7);
      ntj = new d[] { ntb, ntc, ntd, nte, ntf, ntg, nth, nti };
      AppMethodBeat.o(140566);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k
 * JD-Core Version:    0.7.0.1
 */