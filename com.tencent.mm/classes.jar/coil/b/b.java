package coil.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/bitmap/BitmapPool;", "", "clear", "", "get", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "getDirty", "getDirtyOrNull", "getOrNull", "put", "bitmap", "trimMemory", "level", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public static final b.a clF = b.a.clG;
  
  public abstract Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract Bitmap d(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract void n(Bitmap paramBitmap);
  
  public abstract void trimMemory(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     coil.b.b
 * JD-Core Version:    0.7.0.1
 */