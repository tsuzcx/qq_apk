package com.tencent.mm.plugin.flutter.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.w.a.a.b;
import io.flutter.embedding.engine.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class a
  extends b
{
  private Stack<Integer> rdG;
  
  public a()
  {
    AppMethodBeat.i(148857);
    this.rdG = new Stack();
    AppMethodBeat.o(148857);
  }
  
  private Bundle W(Map<String, ?> paramMap)
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
      } else if (cZ(localObject)) {
        localBundle.putBundle(str, W((Map)localObject));
      }
    }
    AppMethodBeat.o(148866);
    return localBundle;
  }
  
  private void a(Context paramContext, com.tencent.mm.w.c paramc)
  {
    AppMethodBeat.i(148869);
    String str1 = (String)paramc.qa("entry");
    String str2 = (String)paramc.qa("plugin");
    Intent localIntent = new Intent();
    if (paramc.qa("arguments") != null) {
      localIntent.putExtras(W((Map)paramc.qa("arguments")));
    }
    int i;
    if (bt.isNullOrNil(str2))
    {
      if (paramc.qb("requestCode"))
      {
        str2 = (String)paramc.qa("name");
        localIntent.putExtra("_name", str2);
        i = ((Integer)paramc.qa("requestCode")).intValue();
        d.c(paramContext, str1, localIntent, ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().de(str2, i));
        AppMethodBeat.o(148869);
        return;
      }
      d.e(paramContext, str1, localIntent);
      AppMethodBeat.o(148869);
      return;
    }
    if (paramc.qb("requestCode"))
    {
      String str3 = (String)paramc.qa("name");
      localIntent.putExtra("_name", str3);
      i = ((Integer)paramc.qa("requestCode")).intValue();
      d.b(paramContext, str2, str1, localIntent, ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().de(str3, i));
      AppMethodBeat.o(148869);
      return;
    }
    d.b(paramContext, str2, str1, localIntent);
    AppMethodBeat.o(148869);
  }
  
  private static boolean cZ(Object paramObject)
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
  
  public final void c(String paramString, com.tencent.mm.w.c paramc)
  {
    AppMethodBeat.i(148862);
    ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().rdu.IYk.aPN(paramString);
    paramc.callback.run();
    AppMethodBeat.o(148862);
  }
  
  public final void create()
  {
    AppMethodBeat.i(148858);
    this.rdG.clear();
    AppMethodBeat.o(148858);
  }
  
  public final void d(String paramString, com.tencent.mm.w.c paramc)
  {
    AppMethodBeat.i(148864);
    paramString = new com.tencent.mm.plugin.flutter.a.c().aag(paramString);
    this.rdG.push(Integer.valueOf(paramString.rds));
    if (paramc.context != null)
    {
      paramc = (com.tencent.mm.plugin.flutter.ui.a)paramc.context;
      if (paramString.rds == 2)
      {
        paramc.lx(true);
        AppMethodBeat.o(148864);
        return;
      }
      paramc.lx(false);
    }
    AppMethodBeat.o(148864);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(148859);
    this.rdG.clear();
    AppMethodBeat.o(148859);
  }
  
  public final void k(com.tencent.mm.w.c paramc)
  {
    AppMethodBeat.i(148860);
    a(paramc.context, paramc);
    paramc.callback.run();
    AppMethodBeat.o(148860);
  }
  
  public final void l(com.tencent.mm.w.c paramc)
  {
    AppMethodBeat.i(148861);
    a(paramc.context, paramc);
    paramc.callback.run();
    AppMethodBeat.o(148861);
  }
  
  public final void m(com.tencent.mm.w.c paramc)
  {
    AppMethodBeat.i(148865);
    paramc = (com.tencent.mm.plugin.flutter.ui.a)paramc.context;
    if (!this.rdG.isEmpty())
    {
      this.rdG.pop();
      if (!this.rdG.isEmpty())
      {
        if (((Integer)this.rdG.peek()).intValue() != 2)
        {
          paramc.lx(false);
          AppMethodBeat.o(148865);
        }
      }
      else
      {
        paramc.lx(true);
        AppMethodBeat.o(148865);
        return;
      }
    }
    paramc.lx(true);
    AppMethodBeat.o(148865);
  }
  
  public final void qc(String paramString)
  {
    AppMethodBeat.i(148863);
    if (new com.tencent.mm.plugin.flutter.a.c().aag(paramString).rds == 1)
    {
      ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().cuK();
      AppMethodBeat.o(148863);
      return;
    }
    if (((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().rdv != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((PluginFlutter)g.ad(PluginFlutter.class)).getFlutterEngineMgr().rdv.cuN();
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