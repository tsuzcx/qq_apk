package coil.memory;

import android.graphics.Bitmap;
import coil.util.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/ForwardingStrongMemoryCache;", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "(Lcoil/memory/WeakMemoryCache;)V", "maxSize", "", "getMaxSize", "()I", "size", "getSize", "clearMemory", "", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "set", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "trimMemory", "level", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e
  implements r
{
  private final u clU;
  
  public e(u paramu)
  {
    AppMethodBeat.i(188273);
    this.clU = paramu;
    AppMethodBeat.o(188273);
  }
  
  public final n.a a(MemoryCache.Key paramKey)
  {
    AppMethodBeat.i(188280);
    s.u(paramKey, "key");
    AppMethodBeat.o(188280);
    return null;
  }
  
  public final void a(MemoryCache.Key paramKey, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(188292);
    s.u(paramKey, "key");
    s.u(paramBitmap, "bitmap");
    this.clU.a(paramKey, paramBitmap, paramBoolean, a.t(paramBitmap));
    AppMethodBeat.o(188292);
  }
  
  public final void trimMemory(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.e
 * JD-Core Version:    0.7.0.1
 */