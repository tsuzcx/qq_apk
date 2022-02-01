package androidx.camera.camera2.b;

import android.hardware.camera2.CameraDevice;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.b.a.a.b;
import androidx.camera.camera2.b.a.a.g;
import androidx.camera.core.impl.ad;
import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

final class ap
{
  final b EB;
  
  ap(b paramb)
  {
    this.EB = paramb;
  }
  
  public final Executor hI()
  {
    AppMethodBeat.i(197381);
    Executor localExecutor = this.EB.hI();
    AppMethodBeat.o(197381);
    return localExecutor;
  }
  
  final boolean stop()
  {
    AppMethodBeat.i(197374);
    boolean bool = this.EB.stop();
    AppMethodBeat.o(197374);
    return bool;
  }
  
  static final class a
  {
    private final ac AO;
    private final ScheduledExecutorService Ay;
    private final int EC;
    private final Set<String> EE;
    private final Handler Ej;
    private final Executor mExecutor;
    
    a(Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService, Handler paramHandler, ac paramac, int paramInt)
    {
      AppMethodBeat.i(197844);
      this.EE = new HashSet();
      this.mExecutor = paramExecutor;
      this.Ay = paramScheduledExecutorService;
      this.Ej = paramHandler;
      this.AO = paramac;
      this.EC = paramInt;
      if (Build.VERSION.SDK_INT < 23) {
        this.EE.add("force_close");
      }
      if ((this.EC == 2) || (Build.VERSION.SDK_INT <= 23)) {
        this.EE.add("deferrableSurface_close");
      }
      if (this.EC == 2) {
        this.EE.add("wait_for_request");
      }
      AppMethodBeat.o(197844);
    }
    
    final ap hM()
    {
      AppMethodBeat.i(197849);
      if (this.EE.isEmpty())
      {
        localap = new ap(new an(this.AO, this.mExecutor, this.Ay, this.Ej));
        AppMethodBeat.o(197849);
        return localap;
      }
      ap localap = new ap(new ao(this.EE, this.AO, this.mExecutor, this.Ay, this.Ej));
      AppMethodBeat.o(197849);
      return localap;
    }
  }
  
  static abstract interface b
  {
    public abstract g a(List<b> paramList, am.a parama);
    
    public abstract f<Void> a(CameraDevice paramCameraDevice, g paramg, List<ad> paramList);
    
    public abstract f<List<Surface>> a(List<ad> paramList, long paramLong);
    
    public abstract Executor hI();
    
    public abstract boolean stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.ap
 * JD-Core Version:    0.7.0.1
 */