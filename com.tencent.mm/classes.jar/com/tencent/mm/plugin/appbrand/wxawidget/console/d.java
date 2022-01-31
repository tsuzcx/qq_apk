package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static final Map<String, List<a>> eEq;
  private static List<a> jxu;
  private static final e jxv;
  
  static
  {
    AppMethodBeat.i(11138);
    eEq = new ConcurrentHashMap();
    jxu = new LinkedList();
    jxv = new d.1();
    AppMethodBeat.o(11138);
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(11135);
    if (jxu.contains(parama))
    {
      AppMethodBeat.o(11135);
      return false;
    }
    Object localObject;
    e locale;
    com.tencent.mm.ipcinvoker.d locald;
    if ((eEq.isEmpty()) && (jxu.isEmpty()))
    {
      localObject = c.jxt;
      locale = jxv;
      locald = ((com.tencent.mm.ipcinvoker.d.d)localObject).eEF;
      localObject = ((com.tencent.mm.ipcinvoker.d.d)localObject).cnC;
      if ((localObject != null) && (((String)localObject).length() != 0) && (locale != null)) {
        break label105;
      }
    }
    for (;;)
    {
      boolean bool = jxu.add(parama);
      AppMethodBeat.o(11135);
      return bool;
      label105:
      Bundle localBundle = new Bundle();
      localBundle.putString("Token", com.tencent.mm.ipcinvoker.d.ae(locale));
      localBundle.putString("Event", (String)localObject);
      f.a(locald.eEf, localBundle, d.a.class, locale);
    }
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(11136);
    boolean bool = jxu.remove(parama);
    Object localObject;
    com.tencent.mm.ipcinvoker.d locald;
    if ((eEq.isEmpty()) && (jxu.isEmpty()))
    {
      localObject = c.jxt;
      parama = jxv;
      locald = ((com.tencent.mm.ipcinvoker.d.d)localObject).eEF;
      localObject = ((com.tencent.mm.ipcinvoker.d.d)localObject).cnC;
      if ((localObject != null) && (((String)localObject).length() != 0) && (parama != null)) {
        break label79;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(11136);
      return bool;
      label79:
      Bundle localBundle = new Bundle();
      localBundle.putString("Token", com.tencent.mm.ipcinvoker.d.ae(parama));
      localBundle.putString("Event", (String)localObject);
      f.a(locald.eEf, localBundle, d.b.class, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.d
 * JD-Core Version:    0.7.0.1
 */