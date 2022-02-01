package com.tencent.mm.plugin.appbrand.jsapi.c;

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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "add", "", "canvasId", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "background", "canvasId2VirtualElementIdOrNull", "foreground", "foregroundCount", "get", "remove", "Companion", "Entity", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a rRf;
  private static final HashMap<String, a> rRg;
  final String appId;
  public final ConcurrentHashMap<Integer, b> evG;
  
  static
  {
    AppMethodBeat.i(50490);
    rRf = new a((byte)0);
    rRg = new HashMap();
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
        a.a locala = a.rRf;
        a.a.aav(this.rRh.appId);
        AppMethodBeat.o(50483);
      }
    });
    this.evG = new ConcurrentHashMap();
    AppMethodBeat.o(50489);
  }
  
  public static final a aau(String paramString)
  {
    AppMethodBeat.i(50491);
    paramString = a.aau(paramString);
    AppMethodBeat.o(50491);
    return paramString;
  }
  
  public final void AG(int paramInt)
  {
    AppMethodBeat.i(50487);
    b localb = (b)this.evG.get(Integer.valueOf(paramInt));
    if (localb != null) {
      localb.foreground = true;
    }
    AppMethodBeat.o(50487);
  }
  
  public final void AH(int paramInt)
  {
    AppMethodBeat.i(327975);
    b localb = (b)this.evG.get(Integer.valueOf(paramInt));
    if (localb != null) {
      localb.foreground = false;
    }
    AppMethodBeat.o(327975);
  }
  
  public final void a(int paramInt, MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(327973);
    s.u(paramMagicBrushView, "view");
    ((Map)this.evG).put(Integer.valueOf(paramInt), new b(paramMagicBrushView));
    AppMethodBeat.o(327973);
  }
  
  public final int crR()
  {
    int i = 0;
    AppMethodBeat.i(50488);
    Object localObject = (Map)this.evG;
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
    AppMethodBeat.i(327981);
    this.evG.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(327981);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Companion;", "", "()V", "holder", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "Lkotlin/collections/HashMap;", "instance", "appId", "release", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a aau(String paramString)
    {
      AppMethodBeat.i(50484);
      s.u(paramString, "appId");
      synchronized (a.crS())
      {
        a locala = (a)a.crS().get(paramString);
        if (locala != null)
        {
          AppMethodBeat.o(50484);
          return locala;
        }
        locala = new a(paramString);
        ((Map)a.crS()).put(paramString, locala);
        AppMethodBeat.o(50484);
        return locala;
      }
    }
    
    public static a aav(String paramString)
    {
      AppMethodBeat.i(50485);
      s.u(paramString, "appId");
      synchronized (a.crS())
      {
        paramString = (a)a.crS().remove(paramString);
        AppMethodBeat.o(50485);
        return paramString;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "(Lcom/tencent/magicbrush/ui/MagicBrushView;)V", "foreground", "", "getForeground", "()Z", "setForeground", "(Z)V", "getView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    boolean foreground;
    public final MagicBrushView rRi;
    
    public b(MagicBrushView paramMagicBrushView)
    {
      AppMethodBeat.i(50486);
      this.rRi = paramMagicBrushView;
      AppMethodBeat.o(50486);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.a
 * JD-Core Version:    0.7.0.1
 */