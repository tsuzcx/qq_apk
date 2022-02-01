package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.n;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import org.apache.commons.c.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/Finder18054CacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/viewmodel/Finder18054CacheVM$Item;", "isRestored", "", "limitCount", "", "getLimitCount", "()I", "limitCount$delegate", "Lkotlin/Lazy;", "storeLimitCount", "getStoreLimitCount", "addCache", "", "scene", "feedId", "", "checkValid", "key", "restoreCache", "storeCache", "Companion", "Item", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends n<PluginFinder>
{
  public static final a.a GJT;
  public final ConcurrentHashMap<String, a.b> BvD;
  public boolean GJU;
  public final j GJV;
  private final int GJW;
  
  static
  {
    AppMethodBeat.i(337257);
    GJT = new a.a((byte)0);
    AppMethodBeat.o(337257);
  }
  
  public a()
  {
    AppMethodBeat.i(337203);
    this.GJV = k.cm((kotlin.g.a.a)a.c.GJX);
    this.GJW = 300;
    this.BvD = new ConcurrentHashMap();
    AppMethodBeat.o(337203);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(337232);
    s.u(parama, "this$0");
    try
    {
      localObject1 = Result.Companion;
      localObject1 = av.GiL;
      localObject1 = new u(av.Ub(9));
      if (!((u)localObject1).isDirectory()) {
        ((u)localObject1).diJ();
      }
      if (!((u)localObject1).jKS()) {
        ((u)localObject1).jKY();
      }
      localObject1 = s.X(com.tencent.mm.vfs.ah.v(((u)localObject1).jKT()), "/18054.ext");
      y.deleteFile((String)localObject1);
      Object localObject2 = parama.BvD.values();
      s.s(localObject2, "cache.values");
      localObject2 = p.a((Iterable)localObject2, (Comparator)new a.d());
      parama = new ArrayList((Collection)((List)localObject2).subList(0, Math.min(parama.GJW, ((List)localObject2).size())));
      localObject2 = (Serializable)parama;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(512);
      g.a((Serializable)localObject2, localByteArrayOutputStream);
      localObject2 = localByteArrayOutputStream.toByteArray();
      int i = y.f((String)localObject1, (byte[])localObject2, localObject2.length);
      Log.i("Finder.18054CacheVM", "[storeCache] ret=" + i + " store cache[" + parama.size() + "].");
      parama = Result.constructor-impl(kotlin.ah.aiuX);
    }
    finally
    {
      for (;;)
      {
        Object localObject1 = Result.Companion;
        parama = Result.constructor-impl(ResultKt.createFailure(parama));
      }
    }
    parama = Result.exceptionOrNull-impl(parama);
    if (parama != null) {
      Log.printErrStackTrace("Finder.18054CacheVM", parama, "", new Object[0]);
    }
    AppMethodBeat.o(337232);
  }
  
  public static String ay(int paramInt, long paramLong)
  {
    AppMethodBeat.i(337215);
    String str = paramInt + '-' + d.hF(paramLong);
    AppMethodBeat.o(337215);
    return str;
  }
  
  private static final void b(a parama)
  {
    AppMethodBeat.i(337248);
    s.u(parama, "this$0");
    try
    {
      localObject = Result.Companion;
      localObject = av.GiL;
      localObject = y.bi(s.X(com.tencent.mm.vfs.ah.v(new u(av.Ub(9)).jKT()), "/18054.ext"), 0, -1);
      if (localObject != null) {
        break label89;
      }
      parama = null;
      parama = Result.constructor-impl(parama);
    }
    finally
    {
      for (;;)
      {
        localObject = Result.Companion;
        parama = Result.constructor-impl(ResultKt.createFailure(parama));
      }
      localObject = g.aj(new ByteArrayInputStream((byte[])localObject));
      if (!(localObject instanceof List)) {
        break label241;
      }
    }
    parama = Result.exceptionOrNull-impl(parama);
    if (parama != null) {
      Log.printErrStackTrace("Finder.18054CacheVM", parama, "", new Object[0]);
    }
    AppMethodBeat.o(337248);
    return;
    label89:
    if (localObject == null)
    {
      parama = new IllegalArgumentException("The byte[] must not be null");
      AppMethodBeat.o(337248);
      throw parama;
    }
    label241:
    for (Object localObject = (List)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          a.b localb = (a.b)((Iterator)localObject).next();
          ((Map)parama.BvD).put(ay(localb.scene, localb.time), localb);
        }
      }
      Log.i("Finder.18054CacheVM", s.X("[restoreCache] cacheSize=", Integer.valueOf(parama.BvD.size())));
      parama = kotlin.ah.aiuX;
      break;
    }
  }
  
  public final void fmK()
  {
    AppMethodBeat.i(337277);
    h.ahAA.g(new a..ExternalSyntheticLambda1(this), "Finder.18054CacheVM");
    AppMethodBeat.o(337277);
  }
  
  public final void fmL()
  {
    AppMethodBeat.i(337282);
    h.ahAA.g(new a..ExternalSyntheticLambda0(this), "Finder.18054CacheVM");
    AppMethodBeat.o(337282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.a
 * JD-Core Version:    0.7.0.1
 */