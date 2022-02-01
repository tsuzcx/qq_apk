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
  private static final Map<String, List<a>> jZc;
  private static List<a> rHu;
  private static final e rHv;
  
  static
  {
    AppMethodBeat.i(121621);
    jZc = new ConcurrentHashMap();
    rHu = new LinkedList();
    rHv = new e() {};
    AppMethodBeat.o(121621);
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(121618);
    if (rHu.contains(parama))
    {
      AppMethodBeat.o(121618);
      return false;
    }
    Object localObject;
    e locale;
    h localh;
    if ((jZc.isEmpty()) && (rHu.isEmpty()))
    {
      localObject = c.rHt;
      locale = rHv;
      localh = ((com.tencent.mm.ipcinvoker.d.d)localObject).jZj;
      localObject = ((com.tencent.mm.ipcinvoker.d.d)localObject).event;
      if ((localObject != null) && (((String)localObject).length() != 0) && (locale != null)) {
        break label102;
      }
    }
    for (;;)
    {
      boolean bool = rHu.add(parama);
      AppMethodBeat.o(121618);
      return bool;
      label102:
      Bundle localBundle = new Bundle();
      localBundle.putString("Token", h.bo(locale));
      localBundle.putString("Event", (String)localObject);
      j.a(localh.jYH, localBundle, h.a.class, locale);
    }
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(121619);
    boolean bool = rHu.remove(parama);
    Object localObject;
    h localh;
    if ((jZc.isEmpty()) && (rHu.isEmpty()))
    {
      localObject = c.rHt;
      parama = rHv;
      localh = ((com.tencent.mm.ipcinvoker.d.d)localObject).jZj;
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
      localBundle.putString("Token", h.bo(parama));
      localBundle.putString("Event", (String)localObject);
      j.a(localh.jYH, localBundle, h.b.class, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.d
 * JD-Core Version:    0.7.0.1
 */