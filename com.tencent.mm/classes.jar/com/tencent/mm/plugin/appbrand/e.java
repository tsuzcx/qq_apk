package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static final Iterator<c> gOS;
  private static final Map<String, e.b> gOT;
  private static final Map<String, e.d> gOU;
  private static final i<String, c> gOV;
  private static final i<String, e.a> gOW;
  
  static
  {
    AppMethodBeat.i(90971);
    gOS = new e.1();
    gOT = new HashMap();
    gOU = new HashMap();
    gOV = new i();
    gOW = new i();
    AppMethodBeat.o(90971);
  }
  
  public static void a(String paramString, e.b paramb)
  {
    AppMethodBeat.i(90969);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90969);
      return;
    }
    gOT.put(paramString, paramb);
    AppMethodBeat.o(90969);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(90956);
    if ((TextUtils.isEmpty(paramString)) || (paramc == null))
    {
      AppMethodBeat.o(90956);
      return;
    }
    gOV.s(paramString, paramc);
    AppMethodBeat.o(90956);
  }
  
  public static void a(String paramString, e.d paramd)
  {
    AppMethodBeat.i(90968);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90968);
      return;
    }
    gOU.put(paramString, paramd);
    AppMethodBeat.o(90968);
  }
  
  public static void b(String paramString, c paramc)
  {
    AppMethodBeat.i(90963);
    if ((paramc == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(90963);
      return;
    }
    gOV.t(paramString, paramc);
    AppMethodBeat.o(90963);
  }
  
  private static Iterator<c> xO(String paramString)
  {
    AppMethodBeat.i(90957);
    paramString = gOV.br(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      AppMethodBeat.o(90957);
      return paramString;
    }
    paramString = gOS;
    AppMethodBeat.o(90957);
    return paramString;
  }
  
  public static void xP(String paramString)
  {
    AppMethodBeat.i(90958);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90958);
      return;
    }
    paramString = xO(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onCreate();
    }
    AppMethodBeat.o(90958);
  }
  
  public static void xQ(String paramString)
  {
    AppMethodBeat.i(90959);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90959);
      return;
    }
    paramString = xO(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onDestroy();
    }
    AppMethodBeat.o(90959);
  }
  
  public static void xR(String paramString)
  {
    AppMethodBeat.i(90960);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90960);
      return;
    }
    Iterator localIterator = xO(paramString);
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(xX(paramString));
    }
    AppMethodBeat.o(90960);
  }
  
  public static void xS(String paramString)
  {
    AppMethodBeat.i(90961);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90961);
      return;
    }
    paramString = xO(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onResume();
    }
    AppMethodBeat.o(90961);
  }
  
  public static void xT(String paramString)
  {
    AppMethodBeat.i(90962);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90962);
      return;
    }
    paramString = xO(paramString);
    while (paramString.hasNext()) {
      paramString.next();
    }
    AppMethodBeat.o(90962);
  }
  
  public static boolean xU(String paramString)
  {
    AppMethodBeat.i(90964);
    paramString = gOW.br(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        if (((e.a)paramString.next()).asZ())
        {
          AppMethodBeat.o(90964);
          return true;
        }
      }
    }
    AppMethodBeat.o(90964);
    return false;
  }
  
  public static void xV(String paramString)
  {
    AppMethodBeat.i(90965);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90965);
      return;
    }
    gOV.bs(paramString);
    gOW.bs(paramString);
    AppMethodBeat.o(90965);
  }
  
  public static void xW(String paramString)
  {
    AppMethodBeat.i(90966);
    a(paramString, e.d.gPg);
    AppMethodBeat.o(90966);
  }
  
  public static e.d xX(String paramString)
  {
    AppMethodBeat.i(90967);
    paramString = (e.d)gOU.get(paramString);
    if (paramString == null)
    {
      paramString = e.d.gPg;
      AppMethodBeat.o(90967);
      return paramString;
    }
    AppMethodBeat.o(90967);
    return paramString;
  }
  
  public static e.b xY(String paramString)
  {
    AppMethodBeat.i(90970);
    e.b localb = (e.b)gOT.get(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = e.b.gOX;
    }
    AppMethodBeat.o(90970);
    return paramString;
  }
  
  public static class c
  {
    public void a(e.d paramd) {}
    
    public void onCreate() {}
    
    public void onDestroy() {}
    
    public void onResume() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e
 * JD-Core Version:    0.7.0.1
 */