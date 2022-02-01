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
  private static final Iterator<c> jyV;
  private static final Map<String, b> jyW;
  private static final Map<String, h.d> jyX;
  private static final com.tencent.mm.plugin.appbrand.y.h<String, c> jyY;
  private static final com.tencent.mm.plugin.appbrand.y.h<String, h.a> jyZ;
  
  static
  {
    AppMethodBeat.i(140582);
    jyV = new Iterator()
    {
      public final boolean hasNext()
      {
        return false;
      }
    };
    jyW = new HashMap();
    jyX = new HashMap();
    jyY = new com.tencent.mm.plugin.appbrand.y.h();
    jyZ = new com.tencent.mm.plugin.appbrand.y.h();
    AppMethodBeat.o(140582);
  }
  
  private static Iterator<c> KL(String paramString)
  {
    AppMethodBeat.i(140568);
    paramString = jyY.cF(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      AppMethodBeat.o(140568);
      return paramString;
    }
    paramString = jyV;
    AppMethodBeat.o(140568);
    return paramString;
  }
  
  public static void KM(String paramString)
  {
    AppMethodBeat.i(140569);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140569);
      return;
    }
    paramString = KL(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onCreate();
    }
    AppMethodBeat.o(140569);
  }
  
  public static void KN(String paramString)
  {
    AppMethodBeat.i(140570);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140570);
      return;
    }
    paramString = KL(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onDestroy();
    }
    AppMethodBeat.o(140570);
  }
  
  public static void KO(String paramString)
  {
    AppMethodBeat.i(201173);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(201173);
      return;
    }
    paramString = KL(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).aWf();
    }
    AppMethodBeat.o(201173);
  }
  
  public static void KP(String paramString)
  {
    AppMethodBeat.i(140571);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140571);
      return;
    }
    Iterator localIterator = KL(paramString);
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(KU(paramString));
    }
    AppMethodBeat.o(140571);
  }
  
  public static void KQ(String paramString)
  {
    AppMethodBeat.i(140572);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140572);
      return;
    }
    paramString = KL(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onResume();
    }
    AppMethodBeat.o(140572);
  }
  
  public static void KR(String paramString)
  {
    AppMethodBeat.i(140573);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140573);
      return;
    }
    paramString = KL(paramString);
    while (paramString.hasNext()) {
      paramString.next();
    }
    AppMethodBeat.o(140573);
  }
  
  public static void KS(String paramString)
  {
    AppMethodBeat.i(140576);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140576);
      return;
    }
    jyY.cG(paramString);
    jyZ.cG(paramString);
    AppMethodBeat.o(140576);
  }
  
  public static void KT(String paramString)
  {
    AppMethodBeat.i(140577);
    a(paramString, h.d.jzj);
    AppMethodBeat.o(140577);
  }
  
  public static h.d KU(String paramString)
  {
    AppMethodBeat.i(140578);
    paramString = (h.d)jyX.get(paramString);
    if (paramString == null)
    {
      paramString = h.d.jzj;
      AppMethodBeat.o(140578);
      return paramString;
    }
    AppMethodBeat.o(140578);
    return paramString;
  }
  
  public static b KV(String paramString)
  {
    AppMethodBeat.i(140581);
    b localb = (b)jyW.get(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = b.jza;
    }
    AppMethodBeat.o(140581);
    return paramString;
  }
  
  public static void a(String paramString, h.a parama)
  {
    AppMethodBeat.i(182832);
    jyZ.j(paramString, parama);
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
    jyW.put(paramString, paramb);
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
    jyY.j(paramString, paramc);
    AppMethodBeat.o(140567);
  }
  
  public static void a(String paramString, h.d paramd)
  {
    AppMethodBeat.i(140579);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140579);
      return;
    }
    jyX.put(paramString, paramd);
    AppMethodBeat.o(140579);
  }
  
  public static void b(String paramString, h.a parama)
  {
    AppMethodBeat.i(182833);
    jyZ.D(paramString, parama);
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
    jyY.D(paramString, paramc);
    AppMethodBeat.o(140574);
  }
  
  public static boolean b(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(182834);
    paramString = jyZ.cF(paramString);
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
      jza = new b("INIT", 0);
      jzb = new b("ON_CREATE", 1);
      jzc = new b("ON_RESUME", 2);
      jzd = new b("ON_PAUSE", 3);
      jze = new b("ON_STOP", 4);
      jzf = new b("ON_DESTROY", 5);
      jzg = new b[] { jza, jzb, jzc, jzd, jze, jzf };
      AppMethodBeat.o(140563);
    }
    
    private b() {}
  }
  
  public static abstract class c
  {
    public void a(h.d paramd) {}
    
    public void aWf() {}
    
    public void onCreate() {}
    
    public void onDestroy() {}
    
    public void onResume() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h
 * JD-Core Version:    0.7.0.1
 */