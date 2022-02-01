package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
{
  private static final Iterator<g.c> jcQ;
  private static final Map<String, b> jcR;
  private static final Map<String, d> jcS;
  private static final h<String, g.c> jcT;
  private static final h<String, g.a> jcU;
  
  static
  {
    AppMethodBeat.i(140582);
    jcQ = new Iterator()
    {
      public final boolean hasNext()
      {
        return false;
      }
    };
    jcR = new HashMap();
    jcS = new HashMap();
    jcT = new h();
    jcU = new h();
    AppMethodBeat.o(140582);
  }
  
  private static Iterator<g.c> GX(String paramString)
  {
    AppMethodBeat.i(140568);
    paramString = jcT.cC(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      AppMethodBeat.o(140568);
      return paramString;
    }
    paramString = jcQ;
    AppMethodBeat.o(140568);
    return paramString;
  }
  
  public static void GY(String paramString)
  {
    AppMethodBeat.i(140569);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140569);
      return;
    }
    paramString = GX(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).onCreate();
    }
    AppMethodBeat.o(140569);
  }
  
  public static void GZ(String paramString)
  {
    AppMethodBeat.i(140570);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140570);
      return;
    }
    paramString = GX(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).onDestroy();
    }
    AppMethodBeat.o(140570);
  }
  
  public static void Ha(String paramString)
  {
    AppMethodBeat.i(200932);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(200932);
      return;
    }
    paramString = GX(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).aSu();
    }
    AppMethodBeat.o(200932);
  }
  
  public static void Hb(String paramString)
  {
    AppMethodBeat.i(140571);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140571);
      return;
    }
    Iterator localIterator = GX(paramString);
    while (localIterator.hasNext()) {
      ((g.c)localIterator.next()).a(Hg(paramString));
    }
    AppMethodBeat.o(140571);
  }
  
  public static void Hc(String paramString)
  {
    AppMethodBeat.i(140572);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140572);
      return;
    }
    paramString = GX(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).onResume();
    }
    AppMethodBeat.o(140572);
  }
  
  public static void Hd(String paramString)
  {
    AppMethodBeat.i(140573);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140573);
      return;
    }
    paramString = GX(paramString);
    while (paramString.hasNext()) {
      paramString.next();
    }
    AppMethodBeat.o(140573);
  }
  
  public static void He(String paramString)
  {
    AppMethodBeat.i(140576);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140576);
      return;
    }
    jcT.cD(paramString);
    jcU.cD(paramString);
    AppMethodBeat.o(140576);
  }
  
  public static void Hf(String paramString)
  {
    AppMethodBeat.i(140577);
    a(paramString, d.jde);
    AppMethodBeat.o(140577);
  }
  
  public static d Hg(String paramString)
  {
    AppMethodBeat.i(140578);
    paramString = (d)jcS.get(paramString);
    if (paramString == null)
    {
      paramString = d.jde;
      AppMethodBeat.o(140578);
      return paramString;
    }
    AppMethodBeat.o(140578);
    return paramString;
  }
  
  public static b Hh(String paramString)
  {
    AppMethodBeat.i(140581);
    b localb = (b)jcR.get(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = b.jcV;
    }
    AppMethodBeat.o(140581);
    return paramString;
  }
  
  public static void a(String paramString, g.a parama)
  {
    AppMethodBeat.i(182832);
    jcU.h(paramString, parama);
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
    jcR.put(paramString, paramb);
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
    jcT.h(paramString, paramc);
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
    jcS.put(paramString, paramd);
    AppMethodBeat.o(140579);
  }
  
  public static void b(String paramString, g.a parama)
  {
    AppMethodBeat.i(182833);
    jcU.B(paramString, parama);
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
    jcT.B(paramString, paramc);
    AppMethodBeat.o(140574);
  }
  
  public static boolean b(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(182834);
    paramString = jcU.cC(paramString);
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
      jcV = new b("INIT", 0);
      jcW = new b("ON_CREATE", 1);
      jcX = new b("ON_RESUME", 2);
      jcY = new b("ON_PAUSE", 3);
      jcZ = new b("ON_STOP", 4);
      jda = new b("ON_DESTROY", 5);
      jdb = new b[] { jcV, jcW, jcX, jcY, jcZ, jda };
      AppMethodBeat.o(140563);
    }
    
    private b() {}
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(140566);
      jdc = new d("CLOSE", 0);
      jdd = new d("BACK", 1);
      jde = new d("HIDE", 2);
      jdf = new d("HANG", 3);
      jdg = new d("HOME_PRESSED", 4);
      jdh = new d("RECENT_APPS_PRESSED", 5);
      jdi = new d("LAUNCH_NATIVE_PAGE", 6);
      jdj = new d("LAUNCH_MINI_PROGRAM", 7);
      jdk = new d[] { jdc, jdd, jde, jdf, jdg, jdh, jdi, jdj };
      AppMethodBeat.o(140566);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g
 * JD-Core Version:    0.7.0.1
 */