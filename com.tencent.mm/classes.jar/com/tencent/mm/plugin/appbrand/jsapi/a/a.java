package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "add", "", "canvasId", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "background", "canvasId2VirtualElementIdOrNull", "foreground", "foregroundCount", "get", "remove", "Companion", "Entity", "plugin-appbrand-integration_release"})
public final class a
{
  private static final HashMap<String, a> kMb;
  public static final a kMc;
  final String appId;
  public final ConcurrentHashMap<Integer, b> cqi;
  
  static
  {
    AppMethodBeat.i(50490);
    kMc = new a((byte)0);
    kMb = new HashMap();
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
        a.a locala = a.kMc;
        a.a.Qj(this.kMd.appId);
        AppMethodBeat.o(50483);
      }
    });
    this.cqi = new ConcurrentHashMap();
    AppMethodBeat.o(50489);
  }
  
  public static final a Qi(String paramString)
  {
    AppMethodBeat.i(50491);
    paramString = a.Qi(paramString);
    AppMethodBeat.o(50491);
    return paramString;
  }
  
  public final void a(int paramInt, MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(223350);
    p.h(paramMagicBrushView, "view");
    ((Map)this.cqi).put(Integer.valueOf(paramInt), new b(paramMagicBrushView));
    AppMethodBeat.o(223350);
  }
  
  public final int bkG()
  {
    int i = 0;
    AppMethodBeat.i(50488);
    Object localObject = (Map)this.cqi;
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
    AppMethodBeat.i(223352);
    this.cqi.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(223352);
  }
  
  public final void td(int paramInt)
  {
    AppMethodBeat.i(50487);
    b localb = (b)this.cqi.get(Integer.valueOf(paramInt));
    if (localb != null)
    {
      localb.foreground = true;
      AppMethodBeat.o(50487);
      return;
    }
    AppMethodBeat.o(50487);
  }
  
  public final void te(int paramInt)
  {
    AppMethodBeat.i(223351);
    b localb = (b)this.cqi.get(Integer.valueOf(paramInt));
    if (localb != null)
    {
      localb.foreground = false;
      AppMethodBeat.o(223351);
      return;
    }
    AppMethodBeat.o(223351);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Companion;", "", "()V", "holder", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "Lkotlin/collections/HashMap;", "instance", "appId", "release", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static a Qi(String paramString)
    {
      AppMethodBeat.i(50484);
      p.h(paramString, "appId");
      synchronized (a.bkH())
      {
        a locala = (a)a.bkH().get(paramString);
        if (locala != null)
        {
          AppMethodBeat.o(50484);
          return locala;
        }
        locala = new a(paramString);
        ((Map)a.bkH()).put(paramString, locala);
        AppMethodBeat.o(50484);
        return locala;
      }
    }
    
    public static a Qj(String paramString)
    {
      AppMethodBeat.i(50485);
      p.h(paramString, "appId");
      synchronized (a.bkH())
      {
        paramString = (a)a.bkH().remove(paramString);
        AppMethodBeat.o(50485);
        return paramString;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "(Lcom/tencent/magicbrush/ui/MagicBrushView;)V", "foreground", "", "getForeground", "()Z", "setForeground", "(Z)V", "getView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "plugin-appbrand-integration_release"})
  public static final class b
  {
    boolean foreground;
    public final MagicBrushView kMe;
    
    public b(MagicBrushView paramMagicBrushView)
    {
      AppMethodBeat.i(50486);
      this.kMe = paramMagicBrushView;
      AppMethodBeat.o(50486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.a
 * JD-Core Version:    0.7.0.1
 */