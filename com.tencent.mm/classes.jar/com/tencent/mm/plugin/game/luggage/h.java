package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  private static HashMap<String, a> gsk;
  private static HashMap<String, com.tencent.luggage.d.p> uet;
  private static LinkedList<String> ueu;
  
  static
  {
    AppMethodBeat.i(83024);
    uet = new HashMap();
    gsk = new HashMap();
    ueu = new LinkedList();
    AppMethodBeat.o(83024);
  }
  
  public static void a(Class<? extends a> paramClass, final String paramString, final a parama)
  {
    AppMethodBeat.i(83020);
    if ((!ak.foC()) && (!ak.foD()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action_id", 1);
      localBundle.putString("preload_url", paramString);
      localBundle.putSerializable("webcore_impl_class", paramClass);
      b.b(localBundle, b.class, new d() {});
      AppMethodBeat.o(83020);
      return;
    }
    if (ueu.contains(paramString))
    {
      ae.i("MicroMsg.PreloadGameWebCoreHelp", "preload ing, return");
      parama.BK();
      AppMethodBeat.o(83020);
      return;
    }
    ueu.add(paramString);
    com.tencent.mm.ipcinvoker.p.x(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83017);
        com.tencent.luggage.d.p localp = new com.tencent.luggage.d.p(ak.getContext(), this.uew);
        h.uet.put(paramString, localp);
        h.bTx().remove(paramString);
        if (!TextUtils.isEmpty(paramString))
        {
          ae.i("MicroMsg.PreloadGameWebCoreHelp", "loadUrl: %s", new Object[] { paramString });
          localp.loadUrl(paramString);
        }
        if (parama != null) {
          parama.BK();
        }
        AppMethodBeat.o(83017);
      }
    });
    AppMethodBeat.o(83020);
  }
  
  public static com.tencent.luggage.d.p amr(String paramString)
  {
    AppMethodBeat.i(83022);
    paramString = (com.tencent.luggage.d.p)uet.get(paramString);
    AppMethodBeat.o(83022);
    return paramString;
  }
  
  public static com.tencent.luggage.d.p av(Context paramContext, String paramString)
  {
    AppMethodBeat.i(83021);
    paramString = (com.tencent.luggage.d.p)uet.remove(paramString);
    if (paramString != null) {
      paramString.setContext(paramContext);
    }
    AppMethodBeat.o(83021);
    return paramString;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(83023);
    if ((ak.foC()) || (ak.foD()))
    {
      localObject = uet.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.luggage.d.p)((Iterator)localObject).next()).destroy();
      }
      uet.clear();
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
    public abstract void BK();
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h
 * JD-Core Version:    0.7.0.1
 */