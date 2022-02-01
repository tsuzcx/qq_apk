package com.tencent.magicbrush.ui;

import androidx.annotation.Keep;
import com.tencent.magicbrush.utils.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/ui/MBViewManager;", "", "()V", "idGenerator", "", "listeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "viewContainer", "Ljava/util/HashMap;", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "Lkotlin/collections/HashMap;", "add", "", "view", "add$lib_magicbrush_nano_release", "fromId", "addListener", "l", "addSurfaceListenerForAllViews", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "clear", "clear$lib_magicbrush_nano_release", "find", "virtualElementId", "findOrNull", "forEach", "fn", "Lkotlin/Function1;", "remove", "remove$lib_magicbrush_nano_release", "removeListener", "toString", "", "Listener", "lib-magicbrush-nano_release"})
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
    p.k(paramMagicBrushView, "view");
    add$lib_magicbrush_nano_release(paramMagicBrushView, -1);
    AppMethodBeat.o(140242);
  }
  
  public final void add$lib_magicbrush_nano_release(MagicBrushView paramMagicBrushView, int paramInt)
  {
    AppMethodBeat.i(205346);
    p.k(paramMagicBrushView, "view");
    aa.d locald = new aa.d();
    int i = paramInt;
    if (paramInt < 0) {}
    try
    {
      i = this.idGenerator;
      this.idGenerator = (i + 1);
      locald.aaBA = i;
      ((Map)this.viewContainer).put(Integer.valueOf(locald.aaBA), paramMagicBrushView);
      x localx = x.aazN;
      paramMagicBrushView.setVirtualElementId$lib_magicbrush_nano_release(locald.aaBA);
      this.listeners.b((b)new b(paramMagicBrushView));
      AppMethodBeat.o(205346);
      return;
    }
    finally
    {
      AppMethodBeat.o(205346);
    }
  }
  
  public final void addListener(a parama)
  {
    AppMethodBeat.i(140238);
    p.k(parama, "l");
    this.listeners.add(parama);
    AppMethodBeat.o(140238);
  }
  
  public final void addSurfaceListenerForAllViews(MagicBrushView.c paramc)
  {
    AppMethodBeat.i(162121);
    p.k(paramc, "l");
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
        p.iCn();
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
  
  public final void forEach(b<? super MagicBrushView, x> paramb)
  {
    AppMethodBeat.i(182582);
    p.k(paramb, "fn");
    Object localObject1 = (List)new ArrayList();
    try
    {
      Object localObject2 = this.viewContainer.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MagicBrushView localMagicBrushView = (MagicBrushView)((Iterator)localObject2).next();
        p.j(localMagicBrushView, "v");
        ((List)localObject1).add(localMagicBrushView);
      }
      localObject2 = x.aazN;
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
    p.k(paramMagicBrushView, "view");
    int i;
    try
    {
      i = paramMagicBrushView.getVirtualElementId();
      if (!this.viewContainer.containsKey(Integer.valueOf(i)))
      {
        paramMagicBrushView = String.format("VirtualElementId error. current [%s] request [%d]", Arrays.copyOf(new Object[] { toString(), Integer.valueOf(i) }, 2));
        p.j(paramMagicBrushView, "java.lang.String.format(this, *args)");
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
    p.k(parama, "l");
    this.listeners.remove(parama);
    AppMethodBeat.o(140239);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140246);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ViewManager(").append(hashCode()).append(")");
    try
    {
      Set localSet = this.viewContainer.keySet();
      p.j(localSet, "viewContainer.keys");
      ((StringBuilder)localObject1).append(j.s((Collection)localSet));
      localObject1 = ((StringBuilder)localObject1).toString();
      p.j(localObject1, "result.toString()");
      AppMethodBeat.o(140246);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(140246);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "", "onViewAdd", "", "v", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "onViewRemove", "lib-magicbrush-nano_release"})
  public static abstract interface a
  {
    public abstract void a(MagicBrushView paramMagicBrushView);
    
    public abstract void b(MagicBrushView paramMagicBrushView);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "invoke"})
  static final class b
    extends q
    implements b<MBViewManager.a, x>
  {
    b(MagicBrushView paramMagicBrushView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/magicbrush/ui/MBViewManager$addSurfaceListenerForAllViews$1", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "onViewAdd", "", "v", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "lib-magicbrush-nano_release"})
  public static final class c
    implements MBViewManager.a
  {
    c(MagicBrushView.c paramc) {}
    
    public final void a(MagicBrushView paramMagicBrushView)
    {
      AppMethodBeat.i(162120);
      p.k(paramMagicBrushView, "v");
      p.k(paramMagicBrushView, "v");
      AppMethodBeat.o(162120);
    }
    
    public final void b(MagicBrushView paramMagicBrushView)
    {
      AppMethodBeat.i(162119);
      p.k(paramMagicBrushView, "v");
      paramMagicBrushView.a(this.cPF);
      AppMethodBeat.o(162119);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "invoke"})
  static final class d
    extends q
    implements b<MBViewManager.a, x>
  {
    d(MagicBrushView paramMagicBrushView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.ui.MBViewManager
 * JD-Core Version:    0.7.0.1
 */