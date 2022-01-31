package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.d.a;
import com.tencent.mm.ipcinvoker.d.b;
import com.tencent.mm.ipcinvoker.d.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final Map<String, List<a>> dGN = new ConcurrentHashMap();
  private static List<a> hEh = new LinkedList();
  private static final e hEi = new d.1();
  
  public static boolean a(a parama)
  {
    if (hEh.contains(parama)) {
      return false;
    }
    Object localObject;
    e locale;
    com.tencent.mm.ipcinvoker.d locald;
    if ((dGN.isEmpty()) && (hEh.isEmpty()))
    {
      localObject = c.hEg;
      locale = hEi;
      locald = ((com.tencent.mm.ipcinvoker.d.d)localObject).dHc;
      localObject = ((com.tencent.mm.ipcinvoker.d.d)localObject).bGt;
      if ((localObject != null) && (((String)localObject).length() != 0) && (locale != null)) {
        break label79;
      }
    }
    for (;;)
    {
      return hEh.add(parama);
      label79:
      Bundle localBundle = new Bundle();
      localBundle.putString("Token", com.tencent.mm.ipcinvoker.d.V(locale));
      localBundle.putString("Event", (String)localObject);
      f.a(locald.dGD, localBundle, d.a.class, locale);
    }
  }
  
  public static boolean b(a parama)
  {
    boolean bool = hEh.remove(parama);
    Object localObject;
    com.tencent.mm.ipcinvoker.d locald;
    if ((dGN.isEmpty()) && (hEh.isEmpty()))
    {
      localObject = c.hEg;
      parama = hEi;
      locald = ((com.tencent.mm.ipcinvoker.d.d)localObject).dHc;
      localObject = ((com.tencent.mm.ipcinvoker.d.d)localObject).bGt;
      if ((localObject != null) && (((String)localObject).length() != 0) && (parama != null)) {}
    }
    else
    {
      return bool;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("Token", com.tencent.mm.ipcinvoker.d.V(parama));
    localBundle.putString("Event", (String)localObject);
    f.a(locald.dGD, localBundle, d.b.class, null);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.d
 * JD-Core Version:    0.7.0.1
 */