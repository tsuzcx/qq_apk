package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import androidx.camera.core.impl.a.k;
import androidx.camera.core.impl.an;
import androidx.camera.core.impl.an.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class b
  implements an
{
  private final ImageReader Gf;
  
  b(ImageReader paramImageReader)
  {
    this.Gf = paramImageReader;
  }
  
  private static boolean a(RuntimeException paramRuntimeException)
  {
    AppMethodBeat.i(198457);
    boolean bool = "ImageReaderContext is not initialized".equals(paramRuntimeException.getMessage());
    AppMethodBeat.o(198457);
    return bool;
  }
  
  public final void a(an.a parama, Executor paramExecutor)
  {
    try
    {
      AppMethodBeat.i(198512);
      parama = new b..ExternalSyntheticLambda0(this, paramExecutor, parama);
      this.Gf.setOnImageAvailableListener(parama, k.kO());
      AppMethodBeat.o(198512);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void close()
  {
    try
    {
      AppMethodBeat.i(198482);
      this.Gf.close();
      AppMethodBeat.o(198482);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int getHeight()
  {
    try
    {
      AppMethodBeat.i(198488);
      int i = this.Gf.getHeight();
      AppMethodBeat.o(198488);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Surface getSurface()
  {
    try
    {
      AppMethodBeat.i(198508);
      Surface localSurface = this.Gf.getSurface();
      AppMethodBeat.o(198508);
      return localSurface;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int getWidth()
  {
    try
    {
      AppMethodBeat.i(198493);
      int i = this.Gf.getWidth();
      AppMethodBeat.o(198493);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final ag iu()
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(198475);
        try
        {
          Object localObject1 = this.Gf.acquireLatestImage();
          if (localObject1 == null)
          {
            AppMethodBeat.o(198475);
            localObject1 = localObject3;
            return localObject1;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          Object localObject2;
          if (a(localRuntimeException))
          {
            localObject2 = null;
            continue;
          }
          AppMethodBeat.o(198475);
          throw localObject2;
        }
        a locala = new a(localImage);
      }
      finally {}
      AppMethodBeat.o(198475);
    }
  }
  
  public final ag iv()
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(198478);
        try
        {
          Object localObject1 = this.Gf.acquireNextImage();
          if (localObject1 == null)
          {
            AppMethodBeat.o(198478);
            localObject1 = localObject3;
            return localObject1;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          Object localObject2;
          if (a(localRuntimeException))
          {
            localObject2 = null;
            continue;
          }
          AppMethodBeat.o(198478);
          throw localObject2;
        }
        a locala = new a(localImage);
      }
      finally {}
      AppMethodBeat.o(198478);
    }
  }
  
  public final int iw()
  {
    try
    {
      AppMethodBeat.i(198497);
      int i = this.Gf.getImageFormat();
      AppMethodBeat.o(198497);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int ix()
  {
    try
    {
      AppMethodBeat.i(198501);
      int i = this.Gf.getMaxImages();
      AppMethodBeat.o(198501);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void iy()
  {
    try
    {
      AppMethodBeat.i(198515);
      this.Gf.setOnImageAvailableListener(null, null);
      AppMethodBeat.o(198515);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.b
 * JD-Core Version:    0.7.0.1
 */