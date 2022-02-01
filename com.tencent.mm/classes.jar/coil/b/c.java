package coil.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/bitmap/BitmapPoolStrategy;", "", "get", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "put", "", "bitmap", "removeLast", "stringify", "", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public static final c.a clH = c.a.clI;
  
  public abstract Bitmap ME();
  
  public abstract Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract String c(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract void n(Bitmap paramBitmap);
  
  public abstract String o(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.b.c
 * JD-Core Version:    0.7.0.1
 */