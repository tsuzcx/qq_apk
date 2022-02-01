package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  private static HashMap<String, p> ItY;
  private static LinkedList<String> ItZ;
  private static HashMap<String, a> mnT;
  
  static
  {
    AppMethodBeat.i(83024);
    ItY = new HashMap();
    mnT = new HashMap();
    ItZ = new LinkedList();
    AppMethodBeat.o(83024);
  }
  
  public static void a(Class<? extends com.tencent.luggage.webview.a> paramClass, final String paramString, final a parama)
  {
    AppMethodBeat.i(83020);
    if ((!MMApplicationContext.isToolsProcess()) && (!MMApplicationContext.isToolsMpProcess()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action_id", 1);
      localBundle.putString("preload_url", paramString);
      localBundle.putSerializable("webcore_impl_class", paramClass);
      b.b(localBundle, c.class, new f() {});
      AppMethodBeat.o(83020);
      return;
    }
    if (ItY.containsKey(paramString))
    {
      Log.i("MicroMsg.PreloadGameWebCoreHelp", "preload page[%s] exists, return", new Object[] { paramString });
      parama.callback();
      AppMethodBeat.o(83020);
      return;
    }
    if (ItZ.contains(paramString))
    {
      Log.i("MicroMsg.PreloadGameWebCoreHelp", "preload ing, return");
      parama.callback();
      AppMethodBeat.o(83020);
      return;
    }
    ItZ.add(paramString);
    s.D(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83017);
        p localp = new p(MMApplicationContext.getContext(), h.this);
        h.ItY.put(paramString, localp);
        h.dhT().remove(paramString);
        if (!TextUtils.isEmpty(paramString))
        {
          Log.i("MicroMsg.PreloadGameWebCoreHelp", "loadUrl: %s", new Object[] { paramString });
          localp.loadUrl(paramString);
        }
        if (parama != null) {
          parama.callback();
        }
        AppMethodBeat.o(83017);
      }
    });
    AppMethodBeat.o(83020);
  }
  
  public static void a(String paramString, b paramb)
  {
    AppMethodBeat.i(276957);
    if ((!MMApplicationContext.isToolsProcess()) && (!MMApplicationContext.isToolsMpProcess()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action_id", 3);
      localBundle.putString("preload_url", paramString);
      b.b(localBundle, c.class, new f() {});
      AppMethodBeat.o(276957);
      return;
    }
    if (aFZ(paramString) != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramb.at(bool, aGa(paramString));
      AppMethodBeat.o(276957);
      return;
    }
  }
  
  public static p aFZ(String paramString)
  {
    AppMethodBeat.i(83022);
    paramString = (p)ItY.get(paramString);
    AppMethodBeat.o(83022);
    return paramString;
  }
  
  private static boolean aGa(String paramString)
  {
    AppMethodBeat.i(276966);
    paramString = (p)ItY.get(paramString);
    if ((paramString != null) && (paramString.aoE() != null) && (((com.tencent.mm.plugin.game.luggage.page.h)paramString.aoE()).fEO()))
    {
      AppMethodBeat.o(276966);
      return true;
    }
    AppMethodBeat.o(276966);
    return false;
  }
  
  public static p aT(Context paramContext, String paramString)
  {
    AppMethodBeat.i(83021);
    paramString = (p)ItY.remove(paramString);
    if (paramString != null)
    {
      paramString.setContext(paramContext);
      paramString.aoD();
    }
    AppMethodBeat.o(83021);
    return paramString;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(83023);
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      localObject = ItY.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        p localp = (p)((Iterator)localObject).next();
        localp.aoD();
        localp.aoF();
      }
      ItY.clear();
      AppMethodBeat.o(83023);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("action_id", 2);
    b.b((Parcelable)localObject, c.class, null);
    AppMethodBeat.o(83023);
  }
  
  public static void remove(String paramString)
  {
    AppMethodBeat.i(276961);
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      paramString = (p)ItY.remove(paramString);
      if (paramString != null)
      {
        paramString.aoD();
        paramString.aoF();
      }
      AppMethodBeat.o(276961);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("action_id", 2);
    localBundle.putString("preload_url", paramString);
    b.b(localBundle, c.class, null);
    AppMethodBeat.o(276961);
  }
  
  public static abstract interface a
  {
    public abstract void callback();
  }
  
  public static abstract interface b
  {
    public abstract void at(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class c
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h
 * JD-Core Version:    0.7.0.1
 */