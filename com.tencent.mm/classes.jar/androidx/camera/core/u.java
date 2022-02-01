package androidx.camera.core;

import android.os.Handler;
import androidx.camera.core.a.f;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.as;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.bl.b;
import androidx.camera.core.impl.q.a;
import androidx.camera.core.impl.r.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class u
  implements f<t>
{
  public static final ac.a<r.a> GW;
  public static final ac.a<q.a> GX;
  public static final ac.a<bl.b> GY;
  static final ac.a<Executor> GZ;
  static final ac.a<Handler> Ha;
  static final ac.a<Integer> Hb;
  static final ac.a<q> Hc;
  final av Hd;
  
  static
  {
    AppMethodBeat.i(198560);
    GW = ac.a.a("camerax.core.appConfig.cameraFactoryProvider", r.a.class, null);
    GX = ac.a.a("camerax.core.appConfig.deviceSurfaceManagerProvider", q.a.class, null);
    GY = ac.a.a("camerax.core.appConfig.useCaseConfigFactoryProvider", bl.b.class, null);
    GZ = ac.a.a("camerax.core.appConfig.cameraExecutor", Executor.class, null);
    Ha = ac.a.a("camerax.core.appConfig.schedulerHandler", Handler.class, null);
    Hb = ac.a.a("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE, null);
    Hc = ac.a.a("camerax.core.appConfig.availableCamerasLimiter", q.class, null);
    AppMethodBeat.o(198560);
  }
  
  public u(av paramav)
  {
    this.Hd = paramav;
  }
  
  public final ac hx()
  {
    return this.Hd;
  }
  
  public static final class a
  {
    public final at He;
    
    public a()
    {
      this(at.ku());
      AppMethodBeat.i(198579);
      AppMethodBeat.o(198579);
    }
    
    private a(at paramat)
    {
      AppMethodBeat.i(198586);
      this.He = paramat;
      paramat = (Class)paramat.b(f.Qo, null);
      if ((paramat != null) && (!paramat.equals(t.class)))
      {
        paramat = new IllegalArgumentException("Invalid target class configuration for " + this + ": " + paramat);
        AppMethodBeat.o(198586);
        throw paramat;
      }
      this.He.c(f.Qo, t.class);
      if (this.He.b(f.Qn, null) == null)
      {
        paramat = t.class.getCanonicalName() + "-" + UUID.randomUUID();
        this.He.c(f.Qn, paramat);
      }
      AppMethodBeat.o(198586);
    }
  }
  
  public static abstract interface b
  {
    public abstract u getCameraXConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.u
 * JD-Core Version:    0.7.0.1
 */