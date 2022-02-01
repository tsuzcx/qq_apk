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
  private static final Iterator<g.c> jvZ;
  private static final Map<String, b> jwa;
  private static final Map<String, d> jwb;
  private static final h<String, g.c> jwc;
  private static final h<String, g.a> jwd;
  
  static
  {
    AppMethodBeat.i(140582);
    jvZ = new g.1();
    jwa = new HashMap();
    jwb = new HashMap();
    jwc = new h();
    jwd = new h();
    AppMethodBeat.o(140582);
  }
  
  private static Iterator<g.c> Km(String paramString)
  {
    AppMethodBeat.i(140568);
    paramString = jwc.cE(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      AppMethodBeat.o(140568);
      return paramString;
    }
    paramString = jvZ;
    AppMethodBeat.o(140568);
    return paramString;
  }
  
  public static void Kn(String paramString)
  {
    AppMethodBeat.i(140569);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140569);
      return;
    }
    paramString = Km(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).onCreate();
    }
    AppMethodBeat.o(140569);
  }
  
  public static void Ko(String paramString)
  {
    AppMethodBeat.i(140570);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140570);
      return;
    }
    paramString = Km(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).onDestroy();
    }
    AppMethodBeat.o(140570);
  }
  
  public static void Kp(String paramString)
  {
    AppMethodBeat.i(187606);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(187606);
      return;
    }
    paramString = Km(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).aVG();
    }
    AppMethodBeat.o(187606);
  }
  
  public static void Kq(String paramString)
  {
    AppMethodBeat.i(140571);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140571);
      return;
    }
    Iterator localIterator = Km(paramString);
    while (localIterator.hasNext()) {
      ((g.c)localIterator.next()).a(Kv(paramString));
    }
    AppMethodBeat.o(140571);
  }
  
  public static void Kr(String paramString)
  {
    AppMethodBeat.i(140572);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140572);
      return;
    }
    paramString = Km(paramString);
    while (paramString.hasNext()) {
      ((g.c)paramString.next()).onResume();
    }
    AppMethodBeat.o(140572);
  }
  
  public static void Ks(String paramString)
  {
    AppMethodBeat.i(140573);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140573);
      return;
    }
    paramString = Km(paramString);
    while (paramString.hasNext()) {
      paramString.next();
    }
    AppMethodBeat.o(140573);
  }
  
  public static void Kt(String paramString)
  {
    AppMethodBeat.i(140576);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140576);
      return;
    }
    jwc.cF(paramString);
    jwd.cF(paramString);
    AppMethodBeat.o(140576);
  }
  
  public static void Ku(String paramString)
  {
    AppMethodBeat.i(140577);
    a(paramString, d.jwn);
    AppMethodBeat.o(140577);
  }
  
  public static d Kv(String paramString)
  {
    AppMethodBeat.i(140578);
    paramString = (d)jwb.get(paramString);
    if (paramString == null)
    {
      paramString = d.jwn;
      AppMethodBeat.o(140578);
      return paramString;
    }
    AppMethodBeat.o(140578);
    return paramString;
  }
  
  public static b Kw(String paramString)
  {
    AppMethodBeat.i(140581);
    b localb = (b)jwa.get(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = b.jwe;
    }
    AppMethodBeat.o(140581);
    return paramString;
  }
  
  public static void a(String paramString, g.a parama)
  {
    AppMethodBeat.i(182832);
    jwd.j(paramString, parama);
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
    jwa.put(paramString, paramb);
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
    jwc.j(paramString, paramc);
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
    jwb.put(paramString, paramd);
    AppMethodBeat.o(140579);
  }
  
  public static void b(String paramString, g.a parama)
  {
    AppMethodBeat.i(182833);
    jwd.D(paramString, parama);
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
    jwc.D(paramString, paramc);
    AppMethodBeat.o(140574);
  }
  
  public static boolean b(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(182834);
    paramString = jwd.cE(paramString);
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
      jwe = new b("INIT", 0);
      jwf = new b("ON_CREATE", 1);
      jwg = new b("ON_RESUME", 2);
      jwh = new b("ON_PAUSE", 3);
      jwi = new b("ON_STOP", 4);
      jwj = new b("ON_DESTROY", 5);
      jwk = new b[] { jwe, jwf, jwg, jwh, jwi, jwj };
      AppMethodBeat.o(140563);
    }
    
    private b() {}
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(140566);
      jwl = new d("CLOSE", 0);
      jwm = new d("BACK", 1);
      jwn = new d("HIDE", 2);
      jwo = new d("HANG", 3);
      jwp = new d("HOME_PRESSED", 4);
      jwq = new d("RECENT_APPS_PRESSED", 5);
      jwr = new d("LAUNCH_NATIVE_PAGE", 6);
      jws = new d("LAUNCH_MINI_PROGRAM", 7);
      jwt = new d[] { jwl, jwm, jwn, jwo, jwp, jwq, jwr, jws };
      AppMethodBeat.o(140566);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g
 * JD-Core Version:    0.7.0.1
 */