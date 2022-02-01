package coil.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/EmptyWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "()V", "clearMemory", "", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "bitmap", "Landroid/graphics/Bitmap;", "set", "isSampled", "size", "", "trimMemory", "level", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements u
{
  public static final d coh;
  
  static
  {
    AppMethodBeat.i(188277);
    coh = new d();
    AppMethodBeat.o(188277);
  }
  
  public final n.a a(MemoryCache.Key paramKey)
  {
    AppMethodBeat.i(188286);
    s.u(paramKey, "key");
    AppMethodBeat.o(188286);
    return null;
  }
  
  public final void a(MemoryCache.Key paramKey, Bitmap paramBitmap, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(188301);
    s.u(paramKey, "key");
    s.u(paramBitmap, "bitmap");
    AppMethodBeat.o(188301);
  }
  
  public final boolean r(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188309);
    s.u(paramBitmap, "bitmap");
    AppMethodBeat.o(188309);
    return false;
  }
  
  public final void trimMemory(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.d
 * JD-Core Version:    0.7.0.1
 */