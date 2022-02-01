package com.tencent.mm.plugin.flutter.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.flutter.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.sdk.platformtools.bu;
import io.flutter.embedding.engine.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class a
  extends b
{
  private Stack<Integer> ttu;
  
  public a()
  {
    AppMethodBeat.i(148857);
    this.ttu = new Stack();
    AppMethodBeat.o(148857);
  }
  
  private void a(Context paramContext, com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(148869);
    String str1 = (String)paramc.wM("entry");
    String str2 = (String)paramc.wM("plugin");
    Intent localIntent = new Intent();
    if (paramc.wM("arguments") != null) {
      localIntent.putExtras(ag((Map)paramc.wM("arguments")));
    }
    int i;
    if (bu.isNullOrNil(str2))
    {
      if (paramc.wN("requestCode"))
      {
        str2 = (String)paramc.wM("name");
        localIntent.putExtra("_name", str2);
        i = ((Integer)paramc.wM("requestCode")).intValue();
        d.c(paramContext, str1, localIntent, ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().dE(str2, i));
        AppMethodBeat.o(148869);
        return;
      }
      d.f(paramContext, str1, localIntent);
      AppMethodBeat.o(148869);
      return;
    }
    if (paramc.wN("requestCode"))
    {
      String str3 = (String)paramc.wM("name");
      localIntent.putExtra("_name", str3);
      i = ((Integer)paramc.wM("requestCode")).intValue();
      d.b(paramContext, str2, str1, localIntent, ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().dE(str3, i));
      AppMethodBeat.o(148869);
      return;
    }
    d.b(paramContext, str2, str1, localIntent);
    AppMethodBeat.o(148869);
  }
  
  private Bundle ag(Map<String, ?> paramMap)
  {
    AppMethodBeat.i(148866);
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if ((localObject instanceof Integer)) {
        localBundle.putInt(str, ((Integer)localObject).intValue());
      } else if ((localObject instanceof String)) {
        localBundle.putString(str, (String)localObject);
      } else if ((localObject instanceof Boolean)) {
        localBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
      } else if ((localObject instanceof Double)) {
        localBundle.putDouble(str, ((Double)localObject).doubleValue());
      } else if ((localObject instanceof Long)) {
        localBundle.putLong(str, ((Long)localObject).longValue());
      } else if ((localObject instanceof byte[])) {
        localBundle.putByteArray(str, (byte[])localObject);
      } else if ((localObject instanceof int[])) {
        localBundle.putIntArray(str, (int[])localObject);
      } else if ((localObject instanceof long[])) {
        localBundle.putLongArray(str, (long[])localObject);
      } else if ((localObject instanceof double[])) {
        localBundle.putDoubleArray(str, (double[])localObject);
      } else if (d(localObject, Integer.class)) {
        localBundle.putIntegerArrayList(str, (ArrayList)localObject);
      } else if (d(localObject, String.class)) {
        localBundle.putStringArrayList(str, (ArrayList)localObject);
      } else if (de(localObject)) {
        localBundle.putBundle(str, ag((Map)localObject));
      }
    }
    AppMethodBeat.o(148866);
    return localBundle;
  }
  
  private static boolean d(Object paramObject, Class<?> paramClass)
  {
    AppMethodBeat.i(148867);
    if (!(paramObject instanceof ArrayList))
    {
      AppMethodBeat.o(148867);
      return false;
    }
    paramObject = ((ArrayList)paramObject).iterator();
    while (paramObject.hasNext())
    {
      Object localObject = paramObject.next();
      if ((localObject != null) && (!paramClass.isInstance(localObject)))
      {
        AppMethodBeat.o(148867);
        return false;
      }
    }
    AppMethodBeat.o(148867);
    return true;
  }
  
  private static boolean de(Object paramObject)
  {
    AppMethodBeat.i(148868);
    if (!(paramObject instanceof Map))
    {
      AppMethodBeat.o(148868);
      return false;
    }
    paramObject = ((Map)paramObject).keySet().iterator();
    while (paramObject.hasNext())
    {
      Object localObject = paramObject.next();
      if ((localObject != null) && (!(localObject instanceof String)))
      {
        AppMethodBeat.o(148868);
        return false;
      }
    }
    AppMethodBeat.o(148868);
    return true;
  }
  
  public final void c(String paramString, com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(148862);
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().tti.MZr.bds(paramString);
    paramc.callback.run();
    AppMethodBeat.o(148862);
  }
  
  public final void create()
  {
    AppMethodBeat.i(148858);
    this.ttu.clear();
    AppMethodBeat.o(148858);
  }
  
  public final void d(String paramString, com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(148864);
    paramString = new com.tencent.mm.plugin.flutter.a.c().akr(paramString);
    this.ttu.push(Integer.valueOf(paramString.ttg));
    if (paramc.context != null)
    {
      paramc = (com.tencent.mm.plugin.flutter.ui.a)paramc.context;
      if (paramString.ttg == 2)
      {
        paramc.mK(true);
        AppMethodBeat.o(148864);
        return;
      }
      paramc.mK(false);
    }
    AppMethodBeat.o(148864);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(148859);
    this.ttu.clear();
    AppMethodBeat.o(148859);
  }
  
  public final void k(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(148860);
    a(paramc.context, paramc);
    paramc.callback.run();
    AppMethodBeat.o(148860);
  }
  
  public final void l(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(148861);
    a(paramc.context, paramc);
    paramc.callback.run();
    AppMethodBeat.o(148861);
  }
  
  public final void m(com.tencent.mm.flutter.c paramc)
  {
    AppMethodBeat.i(148865);
    paramc = (com.tencent.mm.plugin.flutter.ui.a)paramc.context;
    if (!this.ttu.isEmpty())
    {
      this.ttu.pop();
      if (!this.ttu.isEmpty())
      {
        if (((Integer)this.ttu.peek()).intValue() != 2)
        {
          paramc.mK(false);
          AppMethodBeat.o(148865);
        }
      }
      else
      {
        paramc.mK(true);
        AppMethodBeat.o(148865);
        return;
      }
    }
    paramc.mK(true);
    AppMethodBeat.o(148865);
  }
  
  public final void wO(String paramString)
  {
    AppMethodBeat.i(148863);
    if (new com.tencent.mm.plugin.flutter.a.c().akr(paramString).ttg == 1)
    {
      ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cSQ();
      AppMethodBeat.o(148863);
      return;
    }
    if (((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().ttj != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().ttj.cSV();
      }
      AppMethodBeat.o(148863);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b.a.a
 * JD-Core Version:    0.7.0.1
 */