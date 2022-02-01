package coil.memory;

import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.core.g.z;
import coil.util.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/RequestService;", "", "logger", "Lcoil/util/Logger;", "(Lcoil/util/Logger;)V", "hardwareBitmapService", "Lcoil/memory/HardwareBitmapService;", "errorResult", "Lcoil/request/ErrorResult;", "request", "Lcoil/request/ImageRequest;", "throwable", "", "isConfigValidForHardware", "", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "isConfigValidForHardwareAllocation", "size", "Lcoil/size/Size;", "isConfigValidForTransformations", "options", "Lcoil/decode/Options;", "isOnline", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final q.a coD;
  public static final Bitmap.Config[] coF;
  public final coil.util.k cli;
  public final g coE;
  
  static
  {
    AppMethodBeat.i(188316);
    coD = new q.a((byte)0);
    Bitmap.Config[] arrayOfConfig;
    if (Build.VERSION.SDK_INT >= 26)
    {
      arrayOfConfig = new Bitmap.Config[2];
      arrayOfConfig[0] = Bitmap.Config.ARGB_8888;
      arrayOfConfig[1] = Bitmap.Config.RGBA_F16;
    }
    for (;;)
    {
      coF = arrayOfConfig;
      AppMethodBeat.o(188316);
      return;
      arrayOfConfig = new Bitmap.Config[1];
      arrayOfConfig[0] = Bitmap.Config.ARGB_8888;
    }
  }
  
  public q(coil.util.k paramk)
  {
    AppMethodBeat.i(188278);
    this.cli = paramk;
    paramk = g.cok;
    if ((Build.VERSION.SDK_INT < 26) || (f.coj)) {
      paramk = (g)new h(false);
    }
    for (;;)
    {
      this.coE = paramk;
      AppMethodBeat.o(188278);
      return;
      if ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)) {
        paramk = (g)k.coo;
      } else {
        paramk = (g)new h(true);
      }
    }
  }
  
  public static boolean a(coil.j.h paramh, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(188302);
    s.u(paramh, "request");
    s.u(paramConfig, "requestedConfig");
    if (!a.b(paramConfig))
    {
      AppMethodBeat.o(188302);
      return true;
    }
    if (!paramh.col)
    {
      AppMethodBeat.o(188302);
      return false;
    }
    paramh = paramh.com;
    if ((paramh instanceof coil.target.c))
    {
      paramh = ((coil.target.c)paramh).getView();
      if ((z.ay(paramh)) && (!paramh.isHardwareAccelerated())) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(188302);
        return false;
      }
    }
    AppMethodBeat.o(188302);
    return true;
  }
  
  public static coil.j.f b(coil.j.h paramh, Throwable paramThrowable)
  {
    AppMethodBeat.i(188287);
    s.u(paramh, "request");
    s.u(paramThrowable, "throwable");
    if ((paramThrowable instanceof coil.j.k)) {}
    for (Drawable localDrawable = coil.util.g.a(paramh, paramh.cpF, paramh.cpE, paramh.cld.cpn);; localDrawable = coil.util.g.a(paramh, paramh.cpD, paramh.cpC, paramh.cld.cpm))
    {
      paramh = new coil.j.f(localDrawable, paramh, paramThrowable);
      AppMethodBeat.o(188287);
      return paramh;
    }
  }
  
  public static boolean g(coil.j.h paramh)
  {
    AppMethodBeat.i(188308);
    if ((paramh.cot.isEmpty()) || (kotlin.a.k.contains(coF, paramh.bitmapConfig)))
    {
      AppMethodBeat.o(188308);
      return true;
    }
    AppMethodBeat.o(188308);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.memory.q
 * JD-Core Version:    0.7.0.1
 */