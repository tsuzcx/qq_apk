package androidx.camera.camera2.b;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build.VERSION;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.b.a.h;
import androidx.camera.core.al;
import androidx.camera.core.ax;
import androidx.camera.core.impl.a.a.b;
import androidx.camera.core.impl.a.b.c;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.ao;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.bb;
import androidx.camera.core.impl.bb.b;
import androidx.camera.core.impl.bk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;

final class aj
{
  final bb Cj;
  private ad Dm;
  
  aj(final h paramh)
  {
    AppMethodBeat.i(197392);
    Object localObject = new a();
    final SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    paramh = (StreamConfigurationMap)paramh.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (paramh == null)
    {
      al.T("MeteringRepeating");
      paramh = new Size(0, 0);
    }
    for (;;)
    {
      "MerteringSession SurfaceTexture size: ".concat(String.valueOf(paramh));
      al.O("MeteringRepeating");
      localSurfaceTexture.setDefaultBufferSize(paramh.getWidth(), paramh.getHeight());
      paramh = new Surface(localSurfaceTexture);
      localObject = bb.b.b((bk)localObject);
      ((bb.b)localObject).aW(1);
      this.Dm = new ao(paramh);
      e.a(e.d(this.Dm.Mj), new c()
      {
        public final void onFailure(Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(197467);
          paramAnonymousThrowable = new IllegalStateException("Future should never fail. Did it get completed by GC?", paramAnonymousThrowable);
          AppMethodBeat.o(197467);
          throw paramAnonymousThrowable;
        }
      }, b.kP());
      ((bb.b)localObject).b(this.Dm);
      this.Cj = ((bb.b)localObject).ky();
      AppMethodBeat.o(197392);
      return;
      if (Build.VERSION.SDK_INT < 23) {}
      for (paramh = paramh.getOutputSizes(SurfaceTexture.class);; paramh = paramh.getOutputSizes(34))
      {
        if (paramh != null) {
          break label209;
        }
        al.T("MeteringRepeating");
        paramh = new Size(0, 0);
        break;
      }
      label209:
      paramh = (Size)Collections.min(Arrays.asList(paramh), aj..ExternalSyntheticLambda0.INSTANCE);
    }
  }
  
  final void clear()
  {
    AppMethodBeat.i(197416);
    al.O("MeteringRepeating");
    if (this.Dm != null) {
      this.Dm.close();
    }
    this.Dm = null;
    AppMethodBeat.o(197416);
  }
  
  static final class a
    implements bk<ax>
  {
    private final ac Dp;
    
    a()
    {
      AppMethodBeat.i(197880);
      at localat = at.ku();
      localat.c(bk.NH, new p());
      this.Dp = localat;
      AppMethodBeat.o(197880);
    }
    
    public final ac hx()
    {
      return this.Dp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.aj
 * JD-Core Version:    0.7.0.1
 */