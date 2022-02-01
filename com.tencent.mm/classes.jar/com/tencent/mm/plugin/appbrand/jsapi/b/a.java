package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "add", "", "canvasId", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "background", "canvasId2VirtualElementIdOrNull", "foreground", "foregroundCount", "get", "remove", "Companion", "Entity", "plugin-appbrand-integration_release"})
public final class a
{
  private static final HashMap<String, a> oNi;
  public static final a oNj;
  final String appId;
  public final ConcurrentHashMap<Integer, a.b> cDe;
  
  static
  {
    AppMethodBeat.i(50490);
    oNj = new a((byte)0);
    oNi = new HashMap();
    AppMethodBeat.o(50490);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(50489);
    this.appId = paramString;
    k.a(this.appId, (k.c)new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(50483);
        a.a locala = a.oNj;
        a.a.ahy(this.oNk.appId);
        AppMethodBeat.o(50483);
      }
    });
    this.cDe = new ConcurrentHashMap();
    AppMethodBeat.o(50489);
  }
  
  public static final a ahx(String paramString)
  {
    AppMethodBeat.i(50491);
    paramString = a.ahx(paramString);
    AppMethodBeat.o(50491);
    return paramString;
  }
  
  public final void Ap(int paramInt)
  {
    AppMethodBeat.i(50487);
    a.b localb = (a.b)this.cDe.get(Integer.valueOf(paramInt));
    if (localb != null)
    {
      localb.foreground = true;
      AppMethodBeat.o(50487);
      return;
    }
    AppMethodBeat.o(50487);
  }
  
  public final void Aq(int paramInt)
  {
    AppMethodBeat.i(278657);
    a.b localb = (a.b)this.cDe.get(Integer.valueOf(paramInt));
    if (localb != null)
    {
      localb.foreground = false;
      AppMethodBeat.o(278657);
      return;
    }
    AppMethodBeat.o(278657);
  }
  
  public final void a(int paramInt, MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(278654);
    p.k(paramMagicBrushView, "view");
    ((Map)this.cDe).put(Integer.valueOf(paramInt), new a.b(paramMagicBrushView));
    AppMethodBeat.o(278654);
  }
  
  public final int bRM()
  {
    int i = 0;
    AppMethodBeat.i(50488);
    Object localObject = (Map)this.cDe;
    if (((Map)localObject).isEmpty())
    {
      AppMethodBeat.o(50488);
      return 0;
    }
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((a.b)((Map.Entry)((Iterator)localObject).next()).getValue()).foreground) {
        i += 1;
      }
    }
    AppMethodBeat.o(50488);
    return i;
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(278658);
    this.cDe.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(278658);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Companion;", "", "()V", "holder", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "Lkotlin/collections/HashMap;", "instance", "appId", "release", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static a ahx(String paramString)
    {
      AppMethodBeat.i(50484);
      p.k(paramString, "appId");
      synchronized (a.bRN())
      {
        a locala = (a)a.bRN().get(paramString);
        if (locala != null)
        {
          AppMethodBeat.o(50484);
          return locala;
        }
        locala = new a(paramString);
        ((Map)a.bRN()).put(paramString, locala);
        AppMethodBeat.o(50484);
        return locala;
      }
    }
    
    public static a ahy(String paramString)
    {
      AppMethodBeat.i(50485);
      p.k(paramString, "appId");
      synchronized (a.bRN())
      {
        paramString = (a)a.bRN().remove(paramString);
        AppMethodBeat.o(50485);
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.a
 * JD-Core Version:    0.7.0.1
 */