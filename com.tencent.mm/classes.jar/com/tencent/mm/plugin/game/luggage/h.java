package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  private static HashMap<String, a> gpP;
  private static HashMap<String, com.tencent.luggage.d.p> tTB;
  private static LinkedList<String> tTC;
  
  static
  {
    AppMethodBeat.i(83024);
    tTB = new HashMap();
    gpP = new HashMap();
    tTC = new LinkedList();
    AppMethodBeat.o(83024);
  }
  
  public static void a(Class<? extends a> paramClass, final String paramString, final a parama)
  {
    AppMethodBeat.i(83020);
    if ((!aj.fkI()) && (!aj.fkJ()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action_id", 1);
      localBundle.putString("preload_url", paramString);
      localBundle.putSerializable("webcore_impl_class", paramClass);
      b.b(localBundle, b.class, new d() {});
      AppMethodBeat.o(83020);
      return;
    }
    if (tTC.contains(paramString))
    {
      ad.i("MicroMsg.PreloadGameWebCoreHelp", "preload ing, return");
      parama.BJ();
      AppMethodBeat.o(83020);
      return;
    }
    tTC.add(paramString);
    com.tencent.mm.ipcinvoker.p.z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83017);
        com.tencent.luggage.d.p localp = new com.tencent.luggage.d.p(aj.getContext(), this.tTE);
        h.tTB.put(paramString, localp);
        h.bSk().remove(paramString);
        if (!TextUtils.isEmpty(paramString))
        {
          ad.i("MicroMsg.PreloadGameWebCoreHelp", "loadUrl: %s", new Object[] { paramString });
          localp.loadUrl(paramString);
        }
        if (parama != null) {
          parama.BJ();
        }
        AppMethodBeat.o(83017);
      }
    });
    AppMethodBeat.o(83020);
  }
  
  public static com.tencent.luggage.d.p alt(String paramString)
  {
    AppMethodBeat.i(83022);
    paramString = (com.tencent.luggage.d.p)tTB.get(paramString);
    AppMethodBeat.o(83022);
    return paramString;
  }
  
  public static com.tencent.luggage.d.p at(Context paramContext, String paramString)
  {
    AppMethodBeat.i(83021);
    paramString = (com.tencent.luggage.d.p)tTB.remove(paramString);
    if (paramString != null) {
      paramString.setContext(paramContext);
    }
    AppMethodBeat.o(83021);
    return paramString;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(83023);
    if ((aj.fkI()) || (aj.fkJ()))
    {
      localObject = tTB.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.luggage.d.p)((Iterator)localObject).next()).destroy();
      }
      tTB.clear();
      AppMethodBeat.o(83023);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("action_id", 2);
    b.b((Parcelable)localObject, b.class, null);
    AppMethodBeat.o(83023);
  }
  
  public static abstract interface a
  {
    public abstract void BJ();
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h
 * JD-Core Version:    0.7.0.1
 */