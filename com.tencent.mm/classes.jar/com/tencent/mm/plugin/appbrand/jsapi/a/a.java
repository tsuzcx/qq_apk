package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "add", "", "canvasId", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "background", "canvasId2VirtualElementIdOrNull", "foreground", "foregroundCount", "get", "remove", "Companion", "Entity", "plugin-appbrand-integration_release"})
public final class a
{
  private static final HashMap<String, a> knM;
  public static final a knN;
  final String appId;
  public final ConcurrentHashMap<Integer, b> cfp;
  
  static
  {
    AppMethodBeat.i(50490);
    knN = new a((byte)0);
    knM = new HashMap();
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
        a.a locala = a.knN;
        a.a.Mf(this.knO.appId);
        AppMethodBeat.o(50483);
      }
    });
    this.cfp = new ConcurrentHashMap();
    AppMethodBeat.o(50489);
  }
  
  public static final a Me(String paramString)
  {
    AppMethodBeat.i(50491);
    paramString = a.Me(paramString);
    AppMethodBeat.o(50491);
    return paramString;
  }
  
  public final void a(int paramInt, MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(187160);
    k.h(paramMagicBrushView, "view");
    ((Map)this.cfp).put(Integer.valueOf(paramInt), new b(paramMagicBrushView));
    AppMethodBeat.o(187160);
  }
  
  public final int bgt()
  {
    int i = 0;
    AppMethodBeat.i(50488);
    Object localObject = (Map)this.cfp;
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
    AppMethodBeat.i(187162);
    this.cfp.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(187162);
  }
  
  public final void sy(int paramInt)
  {
    AppMethodBeat.i(50487);
    Object localObject = this.cfp.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      k.fOy();
    }
    ((b)localObject).foreground = true;
    AppMethodBeat.o(50487);
  }
  
  public final void sz(int paramInt)
  {
    AppMethodBeat.i(187161);
    Object localObject = this.cfp.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      k.fOy();
    }
    ((b)localObject).foreground = false;
    AppMethodBeat.o(187161);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Companion;", "", "()V", "holder", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "Lkotlin/collections/HashMap;", "instance", "appId", "release", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static a Me(String paramString)
    {
      AppMethodBeat.i(50484);
      k.h(paramString, "appId");
      synchronized (a.bgu())
      {
        a locala = (a)a.bgu().get(paramString);
        if (locala != null)
        {
          AppMethodBeat.o(50484);
          return locala;
        }
        locala = new a(paramString);
        ((Map)a.bgu()).put(paramString, locala);
        AppMethodBeat.o(50484);
        return locala;
      }
    }
    
    public static a Mf(String paramString)
    {
      AppMethodBeat.i(50485);
      k.h(paramString, "appId");
      synchronized (a.bgu())
      {
        paramString = (a)a.bgu().remove(paramString);
        AppMethodBeat.o(50485);
        return paramString;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "(Lcom/tencent/magicbrush/ui/MagicBrushView;)V", "foreground", "", "getForeground", "()Z", "setForeground", "(Z)V", "getView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "plugin-appbrand-integration_release"})
  public static final class b
  {
    boolean foreground;
    public final MagicBrushView knP;
    
    public b(MagicBrushView paramMagicBrushView)
    {
      AppMethodBeat.i(50486);
      this.knP = paramMagicBrushView;
      AppMethodBeat.o(50486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a
 * JD-Core Version:    0.7.0.1
 */