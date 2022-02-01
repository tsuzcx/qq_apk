package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class k
{
  private static final Iterator<c> qru;
  private static final Map<String, b> qrv;
  private static final Map<String, d> qrw;
  private static final j<String, c> qrx;
  private static final j<String, a> qry;
  
  static
  {
    AppMethodBeat.i(140582);
    qru = new k.1();
    qrv = new HashMap();
    qrw = new HashMap();
    qrx = new j();
    qry = new j();
    AppMethodBeat.o(140582);
  }
  
  private static Iterator<c> Uf(String paramString)
  {
    AppMethodBeat.i(140568);
    paramString = qrx.ej(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      AppMethodBeat.o(140568);
      return paramString;
    }
    paramString = qru;
    AppMethodBeat.o(140568);
    return paramString;
  }
  
  public static void Ug(String paramString)
  {
    AppMethodBeat.i(140569);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140569);
      return;
    }
    paramString = Uf(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onCreate();
    }
    AppMethodBeat.o(140569);
  }
  
  public static void Uh(String paramString)
  {
    AppMethodBeat.i(140570);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140570);
      return;
    }
    paramString = Uf(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onDestroy();
    }
    AppMethodBeat.o(140570);
  }
  
  public static void Ui(String paramString)
  {
    AppMethodBeat.i(316814);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(316814);
      return;
    }
    paramString = Uf(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).cbm();
    }
    AppMethodBeat.o(316814);
  }
  
  public static void Uj(String paramString)
  {
    AppMethodBeat.i(140571);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140571);
      return;
    }
    Iterator localIterator = Uf(paramString);
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(Uo(paramString));
    }
    AppMethodBeat.o(140571);
  }
  
  public static void Uk(String paramString)
  {
    AppMethodBeat.i(140572);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140572);
      return;
    }
    paramString = Uf(paramString);
    while (paramString.hasNext()) {
      ((c)paramString.next()).onResume();
    }
    AppMethodBeat.o(140572);
  }
  
  public static void Ul(String paramString)
  {
    AppMethodBeat.i(140573);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140573);
      return;
    }
    paramString = Uf(paramString);
    while (paramString.hasNext()) {
      paramString.next();
    }
    AppMethodBeat.o(140573);
  }
  
  public static void Um(String paramString)
  {
    AppMethodBeat.i(140576);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(140576);
      return;
    }
    qrx.ek(paramString);
    qry.ek(paramString);
    AppMethodBeat.o(140576);
  }
  
  public static void Un(String paramString)
  {
    AppMethodBeat.i(140577);
    a(paramString, d.qrI);
    AppMethodBeat.o(140577);
  }
  
  public static d Uo(String paramString)
  {
    AppMethodBeat.i(140578);
    paramString = (d)qrw.get(paramString);
    if (paramString == null)
    {
      paramString = d.qrI;
      AppMethodBeat.o(140578);
      return paramString;
    }
    AppMethodBeat.o(140578);
    return paramString;
  }
  
  public static b Up(String paramString)
  {
    AppMethodBeat.i(140581);
    b localb = (b)qrv.get(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = b.qrz;
    }
    AppMethodBeat.o(140581);
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(182832);
    qry.v(paramString, parama);
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
    qrv.put(paramString, paramb);
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
    qrx.v(paramString, paramc);
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
    qrw.put(paramString, paramd);
    AppMethodBeat.o(140579);
  }
  
  public static void b(String paramString, a parama)
  {
    AppMethodBeat.i(182833);
    qry.O(paramString, parama);
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
    qrx.O(paramString, paramc);
    AppMethodBeat.o(140574);
  }
  
  public static boolean b(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(182834);
    paramString = qry.ej(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        if (((a)paramString.next()).onNewIntent(paramIntent))
        {
          AppMethodBeat.o(182834);
          return true;
        }
      }
    }
    AppMethodBeat.o(182834);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract boolean onNewIntent(Intent paramIntent);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(140563);
      qrz = new b("INIT", 0);
      qrA = new b("ON_CREATE", 1);
      qrB = new b("ON_RESUME", 2);
      qrC = new b("ON_PAUSE", 3);
      qrD = new b("ON_STOP", 4);
      qrE = new b("ON_DESTROY", 5);
      qrF = new b[] { qrz, qrA, qrB, qrC, qrD, qrE };
      AppMethodBeat.o(140563);
    }
    
    private b() {}
  }
  
  public static abstract class c
  {
    public void a(k.d paramd) {}
    
    public void cbm() {}
    
    public void onCreate() {}
    
    public void onDestroy() {}
    
    public void onResume() {}
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(140566);
      qrG = new d("CLOSE", 0);
      qrH = new d("BACK", 1);
      qrI = new d("HIDE", 2);
      qrJ = new d("HANG", 3);
      qrK = new d("HOME_PRESSED", 4);
      qrL = new d("RECENT_APPS_PRESSED", 5);
      qrM = new d("LAUNCH_NATIVE_PAGE", 6);
      qrN = new d("LAUNCH_MINI_PROGRAM", 7);
      qrO = new d[] { qrG, qrH, qrI, qrJ, qrK, qrL, qrM, qrN };
      AppMethodBeat.o(140566);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k
 * JD-Core Version:    0.7.0.1
 */