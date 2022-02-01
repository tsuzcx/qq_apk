package coil.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.StatFs;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcoil/util/Utils;", "", "()V", "CACHE_DIRECTORY_NAME", "", "DEFAULT_BITMAP_CONFIG", "Landroid/graphics/Bitmap$Config;", "getDEFAULT_BITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "DEFAULT_MEMORY_CLASS_MEGABYTES", "", "DISK_CACHE_PERCENTAGE", "", "LOW_MEMORY_MULTIPLIER", "MAX_DISK_CACHE_SIZE_BYTES", "", "MIN_DISK_CACHE_SIZE_BYTES", "REQUEST_TYPE_ENQUEUE", "REQUEST_TYPE_EXECUTE", "STANDARD_MULTIPLIER", "calculateAllocationByteCount", "width", "height", "config", "calculateAvailableMemorySize", "context", "Landroid/content/Context;", "percentage", "calculateDiskCacheSize", "cacheDirectory", "Ljava/io/File;", "getDefaultAvailableMemoryPercentage", "getDefaultBitmapPoolPercentage", "getDefaultCacheDirectory", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m cqA;
  
  static
  {
    AppMethodBeat.i(188171);
    cqA = new m();
    AppMethodBeat.o(188171);
  }
  
  public static Bitmap.Config Nk()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return Bitmap.Config.HARDWARE;
    }
    return Bitmap.Config.ARGB_8888;
  }
  
  public static double Nl()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return 0.0D;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return 0.5D;
    }
    return 0.25D;
  }
  
  public static long a(Context paramContext, double paramDouble)
  {
    AppMethodBeat.i(188146);
    s.u(paramContext, "context");
    try
    {
      localObject = a.a(paramContext, ActivityManager.class);
      if (localObject != null) {
        break label95;
      }
      paramContext = (Throwable)new IllegalStateException(("System service of type " + ActivityManager.class + " was not found.").toString());
      AppMethodBeat.o(188146);
      throw paramContext;
    }
    catch (Exception paramContext)
    {
      i = 256;
    }
    long l = (i * paramDouble * 1024.0D * 1024.0D);
    AppMethodBeat.o(188146);
    return l;
    label95:
    Object localObject = (ActivityManager)localObject;
    if ((paramContext.getApplicationInfo().flags & 0x100000) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = ((ActivityManager)localObject).getLargeMemoryClass();
        break;
      }
      i = ((ActivityManager)localObject).getMemoryClass();
      break;
    }
  }
  
  public static File aC(Context paramContext)
  {
    AppMethodBeat.i(188124);
    s.u(paramContext, "context");
    paramContext = new File(paramContext.getCacheDir(), "image_cache");
    paramContext.mkdirs();
    AppMethodBeat.o(188124);
    return paramContext;
  }
  
  public static double aD(Context paramContext)
  {
    AppMethodBeat.i(188155);
    s.u(paramContext, "context");
    double d;
    try
    {
      paramContext = a.a(paramContext, ActivityManager.class);
      if (paramContext == null)
      {
        paramContext = (Throwable)new IllegalStateException(("System service of type " + ActivityManager.class + " was not found.").toString());
        AppMethodBeat.o(188155);
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      d = 0.2D;
    }
    for (;;)
    {
      AppMethodBeat.o(188155);
      return d;
      paramContext = (ActivityManager)paramContext;
      if (Build.VERSION.SDK_INT >= 19)
      {
        boolean bool = paramContext.isLowRamDevice();
        if (!bool) {
          break label114;
        }
      }
      label114:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label119;
        }
        d = 0.15D;
        break;
      }
      label119:
      d = 0.2D;
    }
  }
  
  public static int f(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      i = 1;
    }
    for (;;)
    {
      return i * (paramInt1 * paramInt2);
      i = j;
      if (paramConfig != Bitmap.Config.RGB_565)
      {
        i = j;
        if (paramConfig != Bitmap.Config.ARGB_4444) {
          if ((Build.VERSION.SDK_INT >= 26) && (paramConfig == Bitmap.Config.RGBA_F16)) {
            i = 8;
          } else {
            i = 4;
          }
        }
      }
    }
  }
  
  public static long q(File paramFile)
  {
    AppMethodBeat.i(188137);
    s.u(paramFile, "cacheDirectory");
    try
    {
      paramFile = new StatFs(paramFile.getAbsolutePath());
      double d;
      if (Build.VERSION.SDK_INT >= 18)
      {
        l = paramFile.getBlockCountLong();
        d = l;
        if (Build.VERSION.SDK_INT < 18) {
          break label94;
        }
      }
      label94:
      int i;
      for (long l = paramFile.getBlockSizeLong();; l = i)
      {
        l = k.B((l * (0.02D * d)), 10485760L, 262144000L);
        AppMethodBeat.o(188137);
        return l;
        l = paramFile.getBlockCount();
        break;
        i = paramFile.getBlockSize();
      }
      return 10485760L;
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(188137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.util.m
 * JD-Core Version:    0.7.0.1
 */