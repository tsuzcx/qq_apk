package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.e;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.h.a;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final Map<String, List<a>> mza;
  private static List<a> uSJ;
  private static final e uSK;
  
  static
  {
    AppMethodBeat.i(121621);
    mza = new ConcurrentHashMap();
    uSJ = new LinkedList();
    uSK = new e() {};
    AppMethodBeat.o(121621);
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(121618);
    if (uSJ.contains(parama))
    {
      AppMethodBeat.o(121618);
      return false;
    }
    Object localObject;
    e locale;
    h localh;
    if ((mza.isEmpty()) && (uSJ.isEmpty()))
    {
      localObject = c.uSI;
      locale = uSK;
      localh = ((com.tencent.mm.ipcinvoker.d.d)localObject).mzh;
      localObject = ((com.tencent.mm.ipcinvoker.d.d)localObject).event;
      if ((localObject != null) && (((String)localObject).length() != 0) && (locale != null)) {
        break label102;
      }
    }
    for (;;)
    {
      boolean bool = uSJ.add(parama);
      AppMethodBeat.o(121618);
      return bool;
      label102:
      Bundle localBundle = new Bundle();
      localBundle.putString("Token", h.cI(locale));
      localBundle.putString("Event", (String)localObject);
      j.a(localh.myC, localBundle, h.a.class, locale);
    }
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(121619);
    boolean bool = uSJ.remove(parama);
    Object localObject;
    h localh;
    if ((mza.isEmpty()) && (uSJ.isEmpty()))
    {
      localObject = c.uSI;
      parama = uSK;
      localh = ((com.tencent.mm.ipcinvoker.d.d)localObject).mzh;
      localObject = ((com.tencent.mm.ipcinvoker.d.d)localObject).event;
      if ((localObject != null) && (((String)localObject).length() != 0) && (parama != null)) {
        break label77;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(121619);
      return bool;
      label77:
      Bundle localBundle = new Bundle();
      localBundle.putString("Token", h.cI(parama));
      localBundle.putString("Event", (String)localObject);
      j.a(localh.myC, localBundle, h.b.class, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.d
 * JD-Core Version:    0.7.0.1
 */