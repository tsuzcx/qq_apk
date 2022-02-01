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
  private static final Map<String, List<a>> gej;
  private static List<a> mPL;
  private static final e mPM;
  
  static
  {
    AppMethodBeat.i(121621);
    gej = new ConcurrentHashMap();
    mPL = new LinkedList();
    mPM = new e() {};
    AppMethodBeat.o(121621);
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(121618);
    if (mPL.contains(parama))
    {
      AppMethodBeat.o(121618);
      return false;
    }
    Object localObject;
    e locale;
    f localf;
    if ((gej.isEmpty()) && (mPL.isEmpty()))
    {
      localObject = c.mPK;
      locale = mPM;
      localf = ((com.tencent.mm.ipcinvoker.d.d)localObject).geo;
      localObject = ((com.tencent.mm.ipcinvoker.d.d)localObject).cZV;
      if ((localObject != null) && (((String)localObject).length() != 0) && (locale != null)) {
        break label102;
      }
    }
    for (;;)
    {
      boolean bool = mPL.add(parama);
      AppMethodBeat.o(121618);
      return bool;
      label102:
      Bundle localBundle = new Bundle();
      localBundle.putString("Token", f.bd(locale));
      localBundle.putString("Event", (String)localObject);
      h.a(localf.gdR, localBundle, f.a.class, locale);
    }
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(121619);
    boolean bool = mPL.remove(parama);
    Object localObject;
    f localf;
    if ((gej.isEmpty()) && (mPL.isEmpty()))
    {
      localObject = c.mPK;
      parama = mPM;
      localf = ((com.tencent.mm.ipcinvoker.d.d)localObject).geo;
      localObject = ((com.tencent.mm.ipcinvoker.d.d)localObject).cZV;
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
      localBundle.putString("Token", f.bd(parama));
      localBundle.putString("Event", (String)localObject);
      h.a(localf.gdR, localBundle, f.b.class, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.d
 * JD-Core Version:    0.7.0.1
 */