package coil.memory;

import android.graphics.Bitmap;
import coil.b.d;
import coil.util.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/StrongMemoryCache;", "", "maxSize", "", "getMaxSize", "()I", "size", "getSize", "clearMemory", "", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "set", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "trimMemory", "level", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface r
{
  public static final a coG = a.coH;
  
  public abstract n.a a(MemoryCache.Key paramKey);
  
  public abstract void a(MemoryCache.Key paramKey, Bitmap paramBitmap, boolean paramBoolean);
  
  public abstract void trimMemory(int paramInt);
  
  @Metadata(d1={""}, d2={"Lcoil/memory/StrongMemoryCache$Companion;", "", "()V", "invoke", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "maxSize", "", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(188269);
      coH = new a();
      AppMethodBeat.o(188269);
    }
    
    public static r a(u paramu, d paramd, int paramInt, k paramk)
    {
      AppMethodBeat.i(188258);
      s.u(paramu, "weakMemoryCache");
      s.u(paramd, "referenceCounter");
      if (paramInt > 0)
      {
        paramu = (r)new o(paramu, paramd, paramInt, paramk);
        AppMethodBeat.o(188258);
        return paramu;
      }
      if ((paramu instanceof p))
      {
        paramu = (r)new e(paramu);
        AppMethodBeat.o(188258);
        return paramu;
      }
      paramu = (r)b.cof;
      AppMethodBeat.o(188258);
      return paramu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.r
 * JD-Core Version:    0.7.0.1
 */