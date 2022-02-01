package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "add", "", "canvasId", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "background", "canvasId2VirtualElementIdOrNull", "foreground", "foregroundCount", "get", "remove", "Companion", "Entity", "plugin-appbrand-integration_release"})
public final class a
{
  private static final HashMap<String, a> kIM;
  public static final a kIN;
  final String appId;
  public final ConcurrentHashMap<Integer, b> cpF;
  
  static
  {
    AppMethodBeat.i(50490);
    kIN = new a((byte)0);
    kIM = new HashMap();
    AppMethodBeat.o(50490);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(50489);
    this.appId = paramString;
    g.a(this.appId, (g.c)new g.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(50483);
        a.a locala = a.kIN;
        a.a.PB(this.kIO.appId);
        AppMethodBeat.o(50483);
      }
    });
    this.cpF = new ConcurrentHashMap();
    AppMethodBeat.o(50489);
  }
  
  public static final a PA(String paramString)
  {
    AppMethodBeat.i(50491);
    paramString = a.PA(paramString);
    AppMethodBeat.o(50491);
    return paramString;
  }
  
  public final void a(int paramInt, MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(189091);
    p.h(paramMagicBrushView, "view");
    ((Map)this.cpF).put(Integer.valueOf(paramInt), new b(paramMagicBrushView));
    AppMethodBeat.o(189091);
  }
  
  public final int bjX()
  {
    int i = 0;
    AppMethodBeat.i(50488);
    Object localObject = (Map)this.cpF;
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
    AppMethodBeat.i(189093);
    this.cpF.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(189093);
  }
  
  public final void ta(int paramInt)
  {
    AppMethodBeat.i(50487);
    b localb = (b)this.cpF.get(Integer.valueOf(paramInt));
    if (localb != null)
    {
      localb.foreground = true;
      AppMethodBeat.o(50487);
      return;
    }
    AppMethodBeat.o(50487);
  }
  
  public final void tb(int paramInt)
  {
    AppMethodBeat.i(189092);
    b localb = (b)this.cpF.get(Integer.valueOf(paramInt));
    if (localb != null)
    {
      localb.foreground = false;
      AppMethodBeat.o(189092);
      return;
    }
    AppMethodBeat.o(189092);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Companion;", "", "()V", "holder", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "Lkotlin/collections/HashMap;", "instance", "appId", "release", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static a PA(String paramString)
    {
      AppMethodBeat.i(50484);
      p.h(paramString, "appId");
      synchronized (a.bjY())
      {
        a locala = (a)a.bjY().get(paramString);
        if (locala != null)
        {
          AppMethodBeat.o(50484);
          return locala;
        }
        locala = new a(paramString);
        ((Map)a.bjY()).put(paramString, locala);
        AppMethodBeat.o(50484);
        return locala;
      }
    }
    
    public static a PB(String paramString)
    {
      AppMethodBeat.i(50485);
      p.h(paramString, "appId");
      synchronized (a.bjY())
      {
        paramString = (a)a.bjY().remove(paramString);
        AppMethodBeat.o(50485);
        return paramString;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "(Lcom/tencent/magicbrush/ui/MagicBrushView;)V", "foreground", "", "getForeground", "()Z", "setForeground", "(Z)V", "getView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "plugin-appbrand-integration_release"})
  public static final class b
  {
    boolean foreground;
    public final MagicBrushView kIP;
    
    public b(MagicBrushView paramMagicBrushView)
    {
      AppMethodBeat.i(50486);
      this.kIP = paramMagicBrushView;
      AppMethodBeat.o(50486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a
 * JD-Core Version:    0.7.0.1
 */