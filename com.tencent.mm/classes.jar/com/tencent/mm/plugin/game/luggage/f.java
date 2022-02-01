package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
{
  private static HashMap<String, a> fWm;
  private static HashMap<String, k> sWR;
  private static LinkedList<String> sWS;
  
  static
  {
    AppMethodBeat.i(83024);
    sWR = new HashMap();
    fWm = new HashMap();
    sWS = new LinkedList();
    AppMethodBeat.o(83024);
  }
  
  public static void a(Class<? extends com.tencent.luggage.webview.a> paramClass, final String paramString, final a parama)
  {
    AppMethodBeat.i(83020);
    if ((!ai.eVd()) && (!ai.eVe()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action_id", 1);
      localBundle.putString("preload_url", paramString);
      localBundle.putSerializable("webcore_impl_class", paramClass);
      a.b(localBundle, b.class, new d() {});
      AppMethodBeat.o(83020);
      return;
    }
    if (sWS.contains(paramString))
    {
      ac.i("MicroMsg.PreloadGameWebCoreHelp", "preload ing, return");
      parama.Am();
      AppMethodBeat.o(83020);
      return;
    }
    sWS.add(paramString);
    p.z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83017);
        k localk = new k(ai.getContext(), this.sWU);
        f.sWR.put(paramString, localk);
        f.bNK().remove(paramString);
        if (!TextUtils.isEmpty(paramString))
        {
          ac.i("MicroMsg.PreloadGameWebCoreHelp", "loadUrl: %s", new Object[] { paramString });
          localk.loadUrl(paramString);
        }
        if (parama != null) {
          parama.Am();
        }
        AppMethodBeat.o(83017);
      }
    });
    AppMethodBeat.o(83020);
  }
  
  public static k agW(String paramString)
  {
    AppMethodBeat.i(83022);
    paramString = (k)sWR.get(paramString);
    AppMethodBeat.o(83022);
    return paramString;
  }
  
  public static k ar(Context paramContext, String paramString)
  {
    AppMethodBeat.i(83021);
    paramString = (k)sWR.remove(paramString);
    if (paramString != null) {
      paramString.setContext(paramContext);
    }
    AppMethodBeat.o(83021);
    return paramString;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(83023);
    if ((ai.eVd()) || (ai.eVe()))
    {
      localObject = sWR.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((k)((Iterator)localObject).next()).destroy();
      }
      sWR.clear();
      AppMethodBeat.o(83023);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("action_id", 2);
    a.b((Parcelable)localObject, b.class, null);
    AppMethodBeat.o(83023);
  }
  
  public static abstract interface a
  {
    public abstract void Am();
  }
  
  static class b
    implements b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f
 * JD-Core Version:    0.7.0.1
 */