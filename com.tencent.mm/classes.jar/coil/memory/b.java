package coil.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/EmptyStrongMemoryCache;", "Lcoil/memory/StrongMemoryCache;", "()V", "maxSize", "", "getMaxSize", "()I", "size", "getSize", "clearMemory", "", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "set", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "trimMemory", "level", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b
  implements r
{
  public static final b cof;
  
  static
  {
    AppMethodBeat.i(188265);
    cof = new b();
    AppMethodBeat.o(188265);
  }
  
  public final n.a a(MemoryCache.Key paramKey)
  {
    AppMethodBeat.i(188272);
    s.u(paramKey, "key");
    AppMethodBeat.o(188272);
    return null;
  }
  
  public final void a(MemoryCache.Key paramKey, Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(188279);
    s.u(paramKey, "key");
    s.u(paramBitmap, "bitmap");
    AppMethodBeat.o(188279);
  }
  
  public final void trimMemory(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.b
 * JD-Core Version:    0.7.0.1
 */