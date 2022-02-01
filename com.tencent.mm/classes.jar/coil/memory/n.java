package coil.memory;

import android.graphics.Bitmap;
import coil.b.b;
import coil.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/memory/RealMemoryCache;", "Lcoil/memory/MemoryCache;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "(Lcoil/memory/StrongMemoryCache;Lcoil/memory/WeakMemoryCache;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/bitmap/BitmapPool;)V", "getBitmapPool", "()Lcoil/bitmap/BitmapPool;", "maxSize", "", "getMaxSize", "()I", "getReferenceCounter", "()Lcoil/bitmap/BitmapReferenceCounter;", "size", "getSize", "getStrongMemoryCache", "()Lcoil/memory/StrongMemoryCache;", "getWeakMemoryCache", "()Lcoil/memory/WeakMemoryCache;", "clear", "", "get", "Landroid/graphics/Bitmap;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "set", "bitmap", "Value", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements MemoryCache
{
  public final u clU;
  public final b clr;
  public final d cnQ;
  public final r cnR;
  
  public n(r paramr, u paramu, d paramd, b paramb)
  {
    AppMethodBeat.i(188296);
    this.cnR = paramr;
    this.clU = paramu;
    this.cnQ = paramd;
    this.clr = paramb;
    AppMethodBeat.o(188296);
  }
  
  @Metadata(d1={""}, d2={"Lcoil/memory/RealMemoryCache$Value;", "", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "isSampled", "", "()Z", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract boolean MU();
    
    public abstract Bitmap getBitmap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.n
 * JD-Core Version:    0.7.0.1
 */