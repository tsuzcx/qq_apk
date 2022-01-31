package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.d.k;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static HashMap<String, d.a> eyb;
  private static HashMap<String, k> nju;
  private static LinkedList<String> njv;
  
  static
  {
    AppMethodBeat.i(135839);
    nju = new HashMap();
    eyb = new HashMap();
    njv = new LinkedList();
    AppMethodBeat.o(135839);
  }
  
  public static k PR(String paramString)
  {
    AppMethodBeat.i(135837);
    paramString = (k)nju.get(paramString);
    AppMethodBeat.o(135837);
    return paramString;
  }
  
  public static void a(Class<? extends a> paramClass, String paramString, d.a parama)
  {
    AppMethodBeat.i(135835);
    if (!ah.dsW())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action_id", 1);
      localBundle.putString("preload_url", paramString);
      localBundle.putSerializable("webcore_impl_class", paramClass);
      ToolsProcessIPCService.a(localBundle, d.b.class, new d.1(parama));
      AppMethodBeat.o(135835);
      return;
    }
    if (njv.contains(paramString))
    {
      ab.i("MicroMsg.PreloadGameWebCoreHelp", "preload ing, return");
      parama.tU();
      AppMethodBeat.o(135835);
      return;
    }
    njv.add(paramString);
    l.q(new d.2(paramClass, paramString, parama));
    AppMethodBeat.o(135835);
  }
  
  public static k aq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(135836);
    paramString = (k)nju.remove(paramString);
    if (paramString != null) {
      paramString.setContext(paramContext);
    }
    AppMethodBeat.o(135836);
    return paramString;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(135838);
    if (ah.dsW())
    {
      localObject = nju.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((k)((Iterator)localObject).next()).destroy();
      }
      nju.clear();
      AppMethodBeat.o(135838);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("action_id", 2);
    ToolsProcessIPCService.a((Parcelable)localObject, d.b.class, null);
    AppMethodBeat.o(135838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d
 * JD-Core Version:    0.7.0.1
 */