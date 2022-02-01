package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class h
{
  private static final Iterator<c> kzD;
  private static final Map<String, b> kzE;
  private static final Map<String, d> kzF;
  private static final com.tencent.mm.plugin.appbrand.ac.h<String, c> kzG;
  private static final com.tencent.mm.plugin.appbrand.ac.h<String, h.a> kzH;
  
  static
  {
    AppMethodBeat.i(140582);
    kzD = new Iterator()
    {
      public final boolean hasNext()
      {
        return false;
      }
    };
    kzE = new HashMap();
    kzF = new HashMap();
    kzG = new com.tencent.mm.plugin.appbrand.ac.h();
    kzH = new com.tencent.mm.plugin.appbrand.ac.h();
    AppMethodBeat.o(140582);
  }
  
  private static Iterator<c> TT(String paramString)
  {
    AppMethodBeat.i(140568);
    paramString = kzG.cM(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      AppMethodBeat.o(140568);
      return paramString;
    }
    paramString = kzD;
    AppMethodBeat.o(140568);
    return paramString;
  }
  
  public static void TU(String paramString)
  {
    AppMethodBeat.i(140569);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140569);
      return;
    }
    paramString = TT(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onCreate();
    }
    AppMethodBeat.o(140569);
  }
  
  public static void TV(String paramString)
  {
    AppMethodBeat.i(140570);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140570);
      return;
    }
    paramString = TT(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onDestroy();
    }
    AppMethodBeat.o(140570);
  }
  
  public static void TW(String paramString)
  {
    AppMethodBeat.i(221212);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(221212);
      return;
    }
    paramString = TT(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).bra();
    }
    AppMethodBeat.o(221212);
  }
  
  public static void TX(String paramString)
  {
    AppMethodBeat.i(140571);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140571);
      return;
    }
    Iterator localIterator = TT(paramString);
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(Uc(paramString));
    }
    AppMethodBeat.o(140571);
  }
  
  public static void TY(String paramString)
  {
    AppMethodBeat.i(140572);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140572);
      return;
    }
    paramString = TT(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onResume();
    }
    AppMethodBeat.o(140572);
  }
  
  public static void TZ(String paramString)
  {
    AppMethodBeat.i(140573);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140573);
      return;
    }
    paramString = TT(paramString);
    while (paramString.hasNext()) {
      paramString.next();
    }
    AppMethodBeat.o(140573);
  }
  
  public static void Ua(String paramString)
  {
    AppMethodBeat.i(140576);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140576);
      return;
    }
    kzG.cN(paramString);
    kzH.cN(paramString);
    AppMethodBeat.o(140576);
  }
  
  public static void Ub(String paramString)
  {
    AppMethodBeat.i(140577);
    a(paramString, d.kzR);
    AppMethodBeat.o(140577);
  }
  
  public static d Uc(String paramString)
  {
    AppMethodBeat.i(140578);
    paramString = (d)kzF.get(paramString);
    if (paramString == null)
    {
      paramString = d.kzR;
      AppMethodBeat.o(140578);
      return paramString;
    }
    AppMethodBeat.o(140578);
    return paramString;
  }
  
  public static b Ud(String paramString)
  {
    AppMethodBeat.i(140581);
    b localb = (b)kzE.get(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = b.kzI;
    }
    AppMethodBeat.o(140581);
    return paramString;
  }
  
  public static void a(String paramString, h.a parama)
  {
    AppMethodBeat.i(182832);
    kzH.r(paramString, parama);
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
    kzE.put(paramString, paramb);
    AppMethodBeat.o(140580);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(140567);
    if ((TextUtils.isEmpty(paramString)) || (paramc == null))
    {
      AppMethodBeat.o(140567);
      return;
    }
    kzG.r(paramString, paramc);
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
    kzF.put(paramString, paramd);
    AppMethodBeat.o(140579);
  }
  
  public static void b(String paramString, h.a parama)
  {
    AppMethodBeat.i(182833);
    kzH.J(paramString, parama);
    AppMethodBeat.o(182833);
  }
  
  public static void b(String paramString, c paramc)
  {
    AppMethodBeat.i(140574);
    if ((paramc == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(140574);
      return;
    }
    kzG.J(paramString, paramc);
    AppMethodBeat.o(140574);
  }
  
  public static boolean b(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(182834);
    paramString = kzH.cM(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        if (((h.a)paramString.next()).onNewIntent(paramIntent))
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
      kzI = new b("INIT", 0);
      kzJ = new b("ON_CREATE", 1);
      kzK = new b("ON_RESUME", 2);
      kzL = new b("ON_PAUSE", 3);
      kzM = new b("ON_STOP", 4);
      kzN = new b("ON_DESTROY", 5);
      kzO = new b[] { kzI, kzJ, kzK, kzL, kzM, kzN };
      AppMethodBeat.o(140563);
    }
    
    private b() {}
  }
  
  public static abstract class c
  {
    public void a(h.d paramd) {}
    
    public void bra() {}
    
    public void onCreate() {}
    
    public void onDestroy() {}
    
    public void onResume() {}
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(140566);
      kzP = new d("CLOSE", 0);
      kzQ = new d("BACK", 1);
      kzR = new d("HIDE", 2);
      kzS = new d("HANG", 3);
      kzT = new d("HOME_PRESSED", 4);
      kzU = new d("RECENT_APPS_PRESSED", 5);
      kzV = new d("LAUNCH_NATIVE_PAGE", 6);
      kzW = new d("LAUNCH_MINI_PROGRAM", 7);
      kzX = new d[] { kzP, kzQ, kzR, kzS, kzT, kzU, kzV, kzW };
      AppMethodBeat.o(140566);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h
 * JD-Core Version:    0.7.0.1
 */