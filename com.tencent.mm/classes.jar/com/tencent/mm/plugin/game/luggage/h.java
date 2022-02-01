package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  private static HashMap<String, a> hdu;
  private static HashMap<String, com.tencent.luggage.d.p> xws;
  private static LinkedList<String> xwt;
  
  static
  {
    AppMethodBeat.i(83024);
    xws = new HashMap();
    hdu = new HashMap();
    xwt = new LinkedList();
    AppMethodBeat.o(83024);
  }
  
  public static void a(Class<? extends a> paramClass, final String paramString, final a parama)
  {
    AppMethodBeat.i(83020);
    if ((!MMApplicationContext.isToolsProcess()) && (!MMApplicationContext.isToolsMpProcess()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action_id", 1);
      localBundle.putString("preload_url", paramString);
      localBundle.putSerializable("webcore_impl_class", paramClass);
      b.b(localBundle, b.class, new d() {});
      AppMethodBeat.o(83020);
      return;
    }
    if (xws.containsKey(paramString))
    {
      Log.i("MicroMsg.PreloadGameWebCoreHelp", "preload page[%s] exists, return", new Object[] { paramString });
      parama.callback();
      AppMethodBeat.o(83020);
      return;
    }
    if (xwt.contains(paramString))
    {
      Log.i("MicroMsg.PreloadGameWebCoreHelp", "preload ing, return");
      parama.callback();
      AppMethodBeat.o(83020);
      return;
    }
    xwt.add(paramString);
    com.tencent.mm.ipcinvoker.p.y(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83017);
        com.tencent.luggage.d.p localp = new com.tencent.luggage.d.p(MMApplicationContext.getContext(), this.xwv);
        h.xws.put(paramString, localp);
        h.cri().remove(paramString);
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
  
  public static com.tencent.luggage.d.p aI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(83021);
    paramString = (com.tencent.luggage.d.p)xws.remove(paramString);
    if (paramString != null)
    {
      paramString.setContext(paramContext);
      paramString.LF();
    }
    AppMethodBeat.o(83021);
    return paramString;
  }
  
  public static com.tencent.luggage.d.p azD(String paramString)
  {
    AppMethodBeat.i(83022);
    paramString = (com.tencent.luggage.d.p)xws.get(paramString);
    AppMethodBeat.o(83022);
    return paramString;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(83023);
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      localObject = xws.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.d.p localp = (com.tencent.luggage.d.p)((Iterator)localObject).next();
        localp.LF();
        localp.LH();
      }
      xws.clear();
      AppMethodBeat.o(83023);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("action_id", 2);
    b.b((Parcelable)localObject, b.class, null);
    AppMethodBeat.o(83023);
  }
  
  public static void remove(String paramString)
  {
    AppMethodBeat.i(186845);
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      paramString = (com.tencent.luggage.d.p)xws.remove(paramString);
      if (paramString != null)
      {
        paramString.LF();
        paramString.LH();
      }
      AppMethodBeat.o(186845);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("action_id", 2);
    localBundle.putString("preload_url", paramString);
    b.b(localBundle, b.class, null);
    AppMethodBeat.o(186845);
  }
  
  public static abstract interface a
  {
    public abstract void callback();
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h
 * JD-Core Version:    0.7.0.1
 */