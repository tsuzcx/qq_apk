package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.webview.a;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
{
  private static HashMap<String, h> kMY = new HashMap();
  private static HashMap<String, i.a> kMZ = new HashMap();
  private static LinkedList<String> kNa = new LinkedList();
  
  public static h EI(String paramString)
  {
    return (h)kMY.get(paramString);
  }
  
  public static void a(Class<? extends a> paramClass, String paramString, i.a parama)
  {
    if (!ae.cqX())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action_id", 1);
      localBundle.putString("preload_url", paramString);
      localBundle.putSerializable("webcore_impl_class", paramClass);
      ToolsProcessIPCService.a(localBundle, i.b.class, new i.1(parama));
      return;
    }
    if (kNa.contains(paramString))
    {
      y.i("MicroMsg.PreloadGameWebCoreHelp", "preload ing, return");
      parama.pQ();
      return;
    }
    kNa.add(paramString);
    l.m(new i.2(paramClass, paramString, parama));
  }
  
  public static h ah(Context paramContext, String paramString)
  {
    paramString = (h)kMY.remove(paramString);
    if (paramString != null) {
      paramString.setContext(paramContext);
    }
    return paramString;
  }
  
  public static void destroy()
  {
    if (ae.cqX())
    {
      localObject = kMY.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((h)((Iterator)localObject).next()).destroy();
      }
      kMY.clear();
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("action_id", 2);
    ToolsProcessIPCService.a((Parcelable)localObject, i.b.class, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i
 * JD-Core Version:    0.7.0.1
 */