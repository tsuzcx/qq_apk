package coil.memory;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/memory/WeakMemoryCache;", "", "clearMemory", "", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "bitmap", "Landroid/graphics/Bitmap;", "set", "isSampled", "size", "", "trimMemory", "level", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface u
{
  public abstract n.a a(MemoryCache.Key paramKey);
  
  public abstract void a(MemoryCache.Key paramKey, Bitmap paramBitmap, boolean paramBoolean, int paramInt);
  
  public abstract boolean r(Bitmap paramBitmap);
  
  public abstract void trimMemory(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.u
 * JD-Core Version:    0.7.0.1
 */