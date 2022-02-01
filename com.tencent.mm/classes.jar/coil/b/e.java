package coil.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import coil.util.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/bitmap/EmptyBitmapPool;", "Lcoil/bitmap/BitmapPool;", "()V", "assertNotHardware", "", "config", "Landroid/graphics/Bitmap$Config;", "clear", "get", "Landroid/graphics/Bitmap;", "width", "", "height", "getDirty", "getDirtyOrNull", "getOrNull", "put", "bitmap", "trimMemory", "level", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements b
{
  private static void a(Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188161);
    if (!a.b(paramConfig)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramConfig = (Throwable)new IllegalArgumentException("Cannot create a mutable hardware bitmap.".toString());
      AppMethodBeat.o(188161);
      throw paramConfig;
    }
    AppMethodBeat.o(188161);
  }
  
  public final Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188177);
    s.u(paramConfig, "config");
    paramConfig = d(paramInt1, paramInt2, paramConfig);
    AppMethodBeat.o(188177);
    return paramConfig;
  }
  
  public final Bitmap d(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188185);
    s.u(paramConfig, "config");
    a(paramConfig);
    paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
    s.s(paramConfig, "createBitmap(width, height, config)");
    AppMethodBeat.o(188185);
    return paramConfig;
  }
  
  public final void n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188167);
    s.u(paramBitmap, "bitmap");
    paramBitmap.recycle();
    AppMethodBeat.o(188167);
  }
  
  public final void trimMemory(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.b.e
 * JD-Core Version:    0.7.0.1
 */