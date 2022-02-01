package coil;

import android.content.Context;
import coil.j.c;
import coil.j.e;
import coil.j.h;
import coil.j.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/ImageLoader;", "", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "getBitmapPool", "()Lcoil/bitmap/BitmapPool;", "defaults", "Lcoil/request/DefaultRequestOptions;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "memoryCache", "Lcoil/memory/MemoryCache;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newBuilder", "Lcoil/ImageLoader$Builder;", "shutdown", "", "Builder", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public static final b clc = b.clp;
  
  public abstract c MB();
  
  public abstract Object a(h paramh, kotlin.d.d<? super i> paramd);
  
  public abstract e f(h paramh);
  
  @Metadata(d1={""}, d2={"Lcoil/ImageLoader$Companion;", "", "()V", "invoke", "Lcoil/ImageLoader;", "context", "Landroid/content/Context;", "create", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    static
    {
      AppMethodBeat.i(187962);
      clp = new b();
      AppMethodBeat.o(187962);
    }
    
    public static d ay(Context paramContext)
    {
      AppMethodBeat.i(187956);
      s.u(paramContext, "context");
      paramContext = new d.a(paramContext).MC();
      AppMethodBeat.o(187956);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.d
 * JD-Core Version:    0.7.0.1
 */