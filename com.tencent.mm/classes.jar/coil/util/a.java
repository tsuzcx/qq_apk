package coil.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"allocationByteCountCompat", "", "Landroid/graphics/Bitmap;", "getAllocationByteCountCompat", "(Landroid/graphics/Bitmap;)I", "bytesPerPixel", "Landroid/graphics/Bitmap$Config;", "getBytesPerPixel$annotations", "(Landroid/graphics/Bitmap$Config;)V", "getBytesPerPixel", "(Landroid/graphics/Bitmap$Config;)I", "isHardware", "", "(Landroid/graphics/Bitmap$Config;)Z", "safeConfig", "getSafeConfig", "(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;", "toDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "context", "Landroid/content/Context;", "toSoftware", "coil-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final boolean b(Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188108);
    s.u(paramConfig, "<this>");
    if ((Build.VERSION.SDK_INT >= 26) && (paramConfig == Bitmap.Config.HARDWARE))
    {
      AppMethodBeat.o(188108);
      return true;
    }
    AppMethodBeat.o(188108);
    return false;
  }
  
  public static final Bitmap.Config c(Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188130);
    if ((paramConfig == null) || (b(paramConfig)))
    {
      paramConfig = Bitmap.Config.ARGB_8888;
      AppMethodBeat.o(188130);
      return paramConfig;
    }
    AppMethodBeat.o(188130);
    return paramConfig;
  }
  
  public static final int t(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188097);
    s.u(paramBitmap, "<this>");
    if (!paramBitmap.isRecycled()) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramBitmap = (Throwable)new IllegalStateException(("Cannot obtain size for recycled bitmap: " + paramBitmap + " [" + paramBitmap.getWidth() + " x " + paramBitmap.getHeight() + "] + " + paramBitmap.getConfig()).toString());
      AppMethodBeat.o(188097);
      throw paramBitmap;
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 19) {
        i = paramBitmap.getAllocationByteCount();
      }
      for (;;)
      {
        AppMethodBeat.o(188097);
        return i;
        i = paramBitmap.getRowBytes();
        int j = paramBitmap.getHeight();
        i *= j;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        m localm = m.cqA;
        i = m.f(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
      }
    }
  }
  
  public static final Bitmap.Config u(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188120);
    s.u(paramBitmap, "<this>");
    paramBitmap = paramBitmap.getConfig();
    if (paramBitmap == null)
    {
      paramBitmap = Bitmap.Config.ARGB_8888;
      AppMethodBeat.o(188120);
      return paramBitmap;
    }
    AppMethodBeat.o(188120);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.util.a
 * JD-Core Version:    0.7.0.1
 */