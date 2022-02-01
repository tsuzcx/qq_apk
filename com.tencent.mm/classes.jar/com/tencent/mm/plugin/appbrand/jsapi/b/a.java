package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "add", "", "canvasId", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "background", "canvasId2VirtualElementIdOrNull", "foreground", "foregroundCount", "get", "remove", "Companion", "Entity", "plugin-appbrand-integration_release"})
public final class a
{
  private static final HashMap<String, a> lQN;
  public static final a lQO;
  final String appId;
  public final ConcurrentHashMap<Integer, b> cCB;
  
  static
  {
    AppMethodBeat.i(50490);
    lQO = new a((byte)0);
    lQN = new HashMap();
    AppMethodBeat.o(50490);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(50489);
    this.appId = paramString;
    h.a(this.appId, (h.c)new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(50483);
        a.a locala = a.lQO;
        a.a.ZK(this.lQP.appId);
        AppMethodBeat.o(50483);
      }
    });
    this.cCB = new ConcurrentHashMap();
    AppMethodBeat.o(50489);
  }
  
  public static final a ZJ(String paramString)
  {
    AppMethodBeat.i(50491);
    paramString = a.ZJ(paramString);
    AppMethodBeat.o(50491);
    return paramString;
  }
  
  public final void a(int paramInt, MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(228343);
    p.h(paramMagicBrushView, "view");
    ((Map)this.cCB).put(Integer.valueOf(paramInt), new b(paramMagicBrushView));
    AppMethodBeat.o(228343);
  }
  
  public final int bGc()
  {
    int i = 0;
    AppMethodBeat.i(50488);
    Object localObject = (Map)this.cCB;
    if (((Map)localObject).isEmpty())
    {
      AppMethodBeat.o(50488);
      return 0;
    }
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((b)((Map.Entry)((Iterator)localObject).next()).getValue()).foreground) {
        i += 1;
      }
    }
    AppMethodBeat.o(50488);
    return i;
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(228345);
    this.cCB.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(228345);
  }
  
  public final void wZ(int paramInt)
  {
    AppMethodBeat.i(50487);
    b localb = (b)this.cCB.get(Integer.valueOf(paramInt));
    if (localb != null)
    {
      localb.foreground = true;
      AppMethodBeat.o(50487);
      return;
    }
    AppMethodBeat.o(50487);
  }
  
  public final void xa(int paramInt)
  {
    AppMethodBeat.i(228344);
    b localb = (b)this.cCB.get(Integer.valueOf(paramInt));
    if (localb != null)
    {
      localb.foreground = false;
      AppMethodBeat.o(228344);
      return;
    }
    AppMethodBeat.o(228344);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Companion;", "", "()V", "holder", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "Lkotlin/collections/HashMap;", "instance", "appId", "release", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static a ZJ(String paramString)
    {
      AppMethodBeat.i(50484);
      p.h(paramString, "appId");
      synchronized (a.bGd())
      {
        a locala = (a)a.bGd().get(paramString);
        if (locala != null)
        {
          AppMethodBeat.o(50484);
          return locala;
        }
        locala = new a(paramString);
        ((Map)a.bGd()).put(paramString, locala);
        AppMethodBeat.o(50484);
        return locala;
      }
    }
    
    public static a ZK(String paramString)
    {
      AppMethodBeat.i(50485);
      p.h(paramString, "appId");
      synchronized (a.bGd())
      {
        paramString = (a)a.bGd().remove(paramString);
        AppMethodBeat.o(50485);
        return paramString;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "(Lcom/tencent/magicbrush/ui/MagicBrushView;)V", "foreground", "", "getForeground", "()Z", "setForeground", "(Z)V", "getView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "plugin-appbrand-integration_release"})
  public static final class b
  {
    boolean foreground;
    public final MagicBrushView lQQ;
    
    public b(MagicBrushView paramMagicBrushView)
    {
      AppMethodBeat.i(50486);
      this.lQQ = paramMagicBrushView;
      AppMethodBeat.o(50486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.a
 * JD-Core Version:    0.7.0.1
 */