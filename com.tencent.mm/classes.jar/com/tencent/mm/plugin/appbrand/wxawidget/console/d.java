package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.f.a;
import com.tencent.mm.ipcinvoker.f.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final Map<String, List<a>> hno;
  private static List<a> oFF;
  private static final e oFG;
  
  static
  {
    AppMethodBeat.i(121621);
    hno = new ConcurrentHashMap();
    oFF = new LinkedList();
    oFG = new e() {};
    AppMethodBeat.o(121621);
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(121618);
    if (oFF.contains(parama))
    {
      AppMethodBeat.o(121618);
      return false;
    }
    Object localObject;
    e locale;
    f localf;
    if ((hno.isEmpty()) && (oFF.isEmpty()))
    {
      localObject = c.oFE;
      locale = oFG;
      localf = ((com.tencent.mm.ipcinvoker.d.d)localObject).hnu;
      localObject = ((com.tencent.mm.ipcinvoker.d.d)localObject).event;
      if ((localObject != null) && (((String)localObject).length() != 0) && (locale != null)) {
        break label102;
      }
    }
    for (;;)
    {
      boolean bool = oFF.add(parama);
      AppMethodBeat.o(121618);
      return bool;
      label102:
      Bundle localBundle = new Bundle();
      localBundle.putString("Token", f.bo(locale));
      localBundle.putString("Event", (String)localObject);
      h.a(localf.hmX, localBundle, f.a.class, locale);
    }
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(121619);
    boolean bool = oFF.remove(parama);
    Object localObject;
    f localf;
    if ((hno.isEmpty()) && (oFF.isEmpty()))
    {
      localObject = c.oFE;
      parama = oFG;
      localf = ((com.tencent.mm.ipcinvoker.d.d)localObject).hnu;
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
      localBundle.putString("Token", f.bo(parama));
      localBundle.putString("Event", (String)localObject);
      h.a(localf.hmX, localBundle, f.b.class, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.d
 * JD-Core Version:    0.7.0.1
 */