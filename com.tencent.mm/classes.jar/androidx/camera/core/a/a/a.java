package androidx.camera.core.a.a;

import android.media.ImageWriter;
import android.os.Build.VERSION;
import android.view.Surface;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a
{
  private static Method Qw;
  
  static
  {
    AppMethodBeat.i(199145);
    try
    {
      Qw = ImageWriter.class.getMethod("newInstance", new Class[] { Surface.class, Integer.TYPE, Integer.TYPE });
      AppMethodBeat.o(199145);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AppMethodBeat.o(199145);
    }
  }
  
  public static ImageWriter b(Surface paramSurface, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    AppMethodBeat.i(199139);
    if (Build.VERSION.SDK_INT >= 26) {}
    try
    {
      paramSurface = (ImageWriter)f.checkNotNull(Qw.invoke(null, new Object[] { paramSurface, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(199139);
      return paramSurface;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramSurface = new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", localIllegalAccessException);
      AppMethodBeat.o(199139);
      throw paramSurface;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label59:
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.camera.core.a.a.a
 * JD-Core Version:    0.7.0.1
 */