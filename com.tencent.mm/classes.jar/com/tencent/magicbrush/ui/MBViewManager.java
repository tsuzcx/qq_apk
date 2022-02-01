package com.tencent.magicbrush.ui;

import android.support.annotation.Keep;
import com.tencent.magicbrush.utils.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/ui/MBViewManager;", "", "()V", "idGenerator", "", "listeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "viewContainer", "Ljava/util/HashMap;", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "Lkotlin/collections/HashMap;", "add", "", "view", "add$lib_magicbrush_nano_release", "addListener", "l", "addSurfaceListenerForAllViews", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "clear", "clear$lib_magicbrush_nano_release", "find", "virtualElementId", "findOrNull", "forEach", "fn", "Lkotlin/Function1;", "remove", "remove$lib_magicbrush_nano_release", "removeListener", "toString", "", "Listener", "lib-magicbrush-nano_release"})
@Keep
public final class MBViewManager
{
  private int idGenerator;
  private final c<a> listeners;
  private final HashMap<Integer, MagicBrushView> viewContainer;
  
  public MBViewManager()
  {
    AppMethodBeat.i(140247);
    this.viewContainer = new HashMap();
    this.listeners = new c();
    AppMethodBeat.o(140247);
  }
  
  public final void add$lib_magicbrush_nano_release(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(140242);
    p.h(paramMagicBrushView, "view");
    y.d locald = new y.d();
    try
    {
      int i = this.idGenerator;
      this.idGenerator = (i + 1);
      locald.MLT = i;
      ((Map)this.viewContainer).put(Integer.valueOf(locald.MLT), paramMagicBrushView);
      z localz = z.MKo;
      paramMagicBrushView.setVirtualElementId$lib_magicbrush_nano_release(locald.MLT);
      this.listeners.b((b)new b(paramMagicBrushView));
      AppMethodBeat.o(140242);
      return;
    }
    finally
    {
      AppMethodBeat.o(140242);
    }
  }
  
  public final void addListener(a parama)
  {
    AppMethodBeat.i(140238);
    p.h(parama, "l");
    this.listeners.add(parama);
    AppMethodBeat.o(140238);
  }
  
  public final void addSurfaceListenerForAllViews(MagicBrushView.c paramc)
  {
    AppMethodBeat.i(162121);
    p.h(paramc, "l");
    this.listeners.add(new c(paramc));
    AppMethodBeat.o(162121);
  }
  
  public final void clear$lib_magicbrush_nano_release()
  {
    try
    {
      AppMethodBeat.i(140244);
      this.viewContainer.clear();
      this.listeners.clear();
      AppMethodBeat.o(140244);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final MagicBrushView find(int paramInt)
  {
    try
    {
      AppMethodBeat.i(140241);
      Object localObject1 = this.viewContainer.get(Integer.valueOf(paramInt));
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = (MagicBrushView)localObject1;
      AppMethodBeat.o(140241);
      return localObject1;
    }
    finally {}
  }
  
  public final MagicBrushView findOrNull(int paramInt)
  {
    try
    {
      AppMethodBeat.i(140240);
      MagicBrushView localMagicBrushView = (MagicBrushView)this.viewContainer.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(140240);
      return localMagicBrushView;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void forEach(b<? super MagicBrushView, z> paramb)
  {
    AppMethodBeat.i(182582);
    p.h(paramb, "fn");
    Object localObject1 = (List)new ArrayList();
    try
    {
      Object localObject2 = this.viewContainer.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MagicBrushView localMagicBrushView = (MagicBrushView)((Iterator)localObject2).next();
        p.g(localMagicBrushView, "v");
        ((List)localObject1).add(localMagicBrushView);
      }
      localObject2 = z.MKo;
    }
    finally
    {
      AppMethodBeat.o(182582);
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramb.invoke(((Iterator)localObject1).next());
    }
    AppMethodBeat.o(182582);
  }
  
  public final void remove$lib_magicbrush_nano_release(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(140243);
    p.h(paramMagicBrushView, "view");
    int i;
    try
    {
      i = paramMagicBrushView.getVirtualElementId();
      if (!this.viewContainer.containsKey(Integer.valueOf(i)))
      {
        paramMagicBrushView = String.format("VirtualElementId error. current [%s] request [%d]", Arrays.copyOf(new Object[] { toString(), Integer.valueOf(i) }, 2));
        p.g(paramMagicBrushView, "java.lang.String.format(this, *args)");
        paramMagicBrushView = (Throwable)new IllegalStateException(paramMagicBrushView.toString());
        AppMethodBeat.o(140243);
        throw paramMagicBrushView;
      }
    }
    finally
    {
      AppMethodBeat.o(140243);
    }
    this.viewContainer.remove(Integer.valueOf(i));
    this.listeners.b((b)new d(paramMagicBrushView));
    AppMethodBeat.o(140243);
  }
  
  public final void removeListener(a parama)
  {
    AppMethodBeat.i(140239);
    p.h(parama, "l");
    c localc = this.listeners;
    synchronized (localc.listeners)
    {
      localc.listeners.remove(parama);
      AppMethodBeat.o(140239);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140246);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ViewManager(").append(hashCode()).append(")");
    try
    {
      Set localSet = this.viewContainer.keySet();
      p.g(localSet, "viewContainer.keys");
      ((StringBuilder)localObject1).append(j.r((Collection)localSet));
      localObject1 = ((StringBuilder)localObject1).toString();
      p.g(localObject1, "result.toString()");
      AppMethodBeat.o(140246);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(140246);
    }
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "", "onViewAdd", "", "v", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "onViewRemove", "lib-magicbrush-nano_release"})
  public static abstract interface a
  {
    public abstract void a(MagicBrushView paramMagicBrushView);
    
    public abstract void b(MagicBrushView paramMagicBrushView);
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "invoke"})
  static final class b
    extends q
    implements b<MBViewManager.a, z>
  {
    b(MagicBrushView paramMagicBrushView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"com/tencent/magicbrush/ui/MBViewManager$addSurfaceListenerForAllViews$1", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "onViewAdd", "", "v", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "lib-magicbrush-nano_release"})
  public static final class c
    implements MBViewManager.a
  {
    c(MagicBrushView.c paramc) {}
    
    public final void a(MagicBrushView paramMagicBrushView)
    {
      AppMethodBeat.i(162120);
      p.h(paramMagicBrushView, "v");
      p.h(paramMagicBrushView, "v");
      AppMethodBeat.o(162120);
    }
    
    public final void b(MagicBrushView paramMagicBrushView)
    {
      AppMethodBeat.i(162119);
      p.h(paramMagicBrushView, "v");
      paramMagicBrushView.a(this.cAd);
      AppMethodBeat.o(162119);
    }
  }
  
  @l(gfx={1, 1, 13}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "invoke"})
  static final class d
    extends q
    implements b<MBViewManager.a, z>
  {
    d(MagicBrushView paramMagicBrushView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.MBViewManager
 * JD-Core Version:    0.7.0.1
 */