package androidx.camera.camera2.b;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.a.a.a;
import androidx.camera.camera2.c.c.a;
import androidx.camera.core.al;
import androidx.camera.core.impl.a.b.d;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.ae;
import androidx.camera.core.impl.bb;
import androidx.camera.core.impl.bc;
import androidx.camera.core.impl.bd;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

final class ak
  implements ab
{
  private static int DC;
  private static List<ad> Dw;
  private final bc AS;
  private final ScheduledExecutorService Ay;
  private final aa BS;
  private bb Cj;
  private androidx.camera.camera2.c.c DA;
  private androidx.camera.camera2.c.c DB;
  private int DD;
  private final i Dq;
  private List<ad> Dr;
  private o Ds;
  private bb Dt;
  private boolean Du;
  private a Dv;
  private volatile z Dx;
  volatile boolean Dy;
  private final ak.b Dz;
  final Executor mExecutor;
  
  static
  {
    AppMethodBeat.i(197530);
    Dw = new ArrayList();
    DC = 0;
    AppMethodBeat.o(197530);
  }
  
  ak(bc parambc, i parami, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(197436);
    this.Dr = new ArrayList();
    this.Du = false;
    this.Dx = null;
    this.Dy = false;
    this.DA = new c.a().ir();
    this.DB = new c.a().ir();
    this.DD = 0;
    this.BS = new aa();
    this.AS = parambc;
    this.Dq = parami;
    this.mExecutor = paramExecutor;
    this.Ay = paramScheduledExecutorService;
    this.Dv = a.DH;
    this.Dz = new ak.b(this.mExecutor);
    int i = DC;
    DC = i + 1;
    this.DD = i;
    new StringBuilder("New ProcessingCaptureSession (id=").append(this.DD).append(")");
    al.O("ProcessingCaptureSession");
    AppMethodBeat.o(197436);
  }
  
  private static void a(androidx.camera.camera2.c.c paramc1, androidx.camera.camera2.c.c paramc2)
  {
    AppMethodBeat.i(197470);
    a.a locala = new a.a();
    locala.a(paramc1);
    locala.a(paramc2);
    locala.fV();
    AppMethodBeat.o(197470);
  }
  
  private static void w(List<z> paramList)
  {
    AppMethodBeat.i(197451);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Iterator localIterator = ((z)paramList.next()).Bs.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).gB();
      }
    }
    AppMethodBeat.o(197451);
  }
  
  private static List<bd> x(List<ad> paramList)
  {
    AppMethodBeat.i(197462);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ad localad = (ad)paramList.next();
      androidx.core.f.f.checkArgument(localad instanceof bd, "Surface must be SessionProcessorSurface");
      localArrayList.add((bd)localad);
    }
    AppMethodBeat.o(197462);
    return localArrayList;
  }
  
  public final com.google.b.b.a.f<Void> a(bb parambb, CameraDevice paramCameraDevice, ap paramap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(197587);
    if (this.Dv == a.DH)
    {
      bool1 = true;
      androidx.core.f.f.checkArgument(bool1, "Invalid state state:" + this.Dv);
      if (Collections.unmodifiableList(parambb.Fs).isEmpty()) {
        break label182;
      }
    }
    label182:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      androidx.core.f.f.checkArgument(bool1, "SessionConfig contains no surfaces");
      new StringBuilder("open (id=").append(this.DD).append(")");
      al.O("ProcessingCaptureSession");
      this.Dr = Collections.unmodifiableList(parambb.Fs);
      parambb = d.c(ae.a(this.Dr, 5000L, this.mExecutor, this.Ay)).a(new ak..ExternalSyntheticLambda1(this, parambb, paramCameraDevice, paramap), this.mExecutor).a(new ak..ExternalSyntheticLambda0(this), this.mExecutor);
      AppMethodBeat.o(197587);
      return parambb;
      bool1 = false;
      break;
    }
  }
  
  public final com.google.b.b.a.f<Void> ab(boolean paramBoolean)
  {
    AppMethodBeat.i(197612);
    if (this.Dv == a.DL) {}
    for (boolean bool = true;; bool = false)
    {
      androidx.core.f.f.b(bool, "release() can only be called in CLOSED state");
      new StringBuilder("release (id=").append(this.DD).append(")");
      al.O("ProcessingCaptureSession");
      com.google.b.b.a.f localf = this.BS.ab(paramBoolean);
      AppMethodBeat.o(197612);
      return localf;
    }
  }
  
  public final void b(bb parambb)
  {
    AppMethodBeat.i(197664);
    new StringBuilder("setSessionConfig (id=").append(this.DD).append(")");
    al.O("ProcessingCaptureSession");
    this.Cj = parambb;
    if (parambb == null)
    {
      AppMethodBeat.o(197664);
      return;
    }
    this.Dz.Bs = parambb.Ne.Bs;
    if (this.Dv == a.DJ)
    {
      this.DA = c.a.c(parambb.Ne.LV).ir();
      a(this.DA, this.DB);
      if (!this.Du) {
        this.Du = true;
      }
    }
    AppMethodBeat.o(197664);
  }
  
  public final void close()
  {
    AppMethodBeat.i(197651);
    new StringBuilder("close (id=").append(this.DD).append(") state=").append(this.Dv);
    al.O("ProcessingCaptureSession");
    switch (3.DG[this.Dv.ordinal()])
    {
    case 1: 
    case 2: 
    case 4: 
    default: 
    case 3: 
      for (;;)
      {
        this.Dv = a.DL;
        this.BS.close();
        AppMethodBeat.o(197651);
        return;
        if (this.Ds != null) {
          this.Ds.BU = true;
        }
        this.Dv = a.DK;
      }
    }
    AppMethodBeat.o(197651);
  }
  
  public final bb gh()
  {
    return this.Cj;
  }
  
  public final List<z> hg()
  {
    AppMethodBeat.i(197631);
    if (this.Dx != null)
    {
      localList = Arrays.asList(new z[] { this.Dx });
      AppMethodBeat.o(197631);
      return localList;
    }
    List localList = Collections.emptyList();
    AppMethodBeat.o(197631);
    return localList;
  }
  
  public final void hi()
  {
    AppMethodBeat.i(197640);
    new StringBuilder("cancelIssuedCaptureRequests (id=").append(this.DD).append(")");
    al.O("ProcessingCaptureSession");
    if (this.Dx != null)
    {
      Iterator localIterator = this.Dx.Bs.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).gB();
      }
      this.Dx = null;
    }
    AppMethodBeat.o(197640);
  }
  
  public final void s(List<z> paramList)
  {
    AppMethodBeat.i(197602);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(197602);
      return;
    }
    int i;
    if (paramList.size() <= 1)
    {
      if (!paramList.isEmpty()) {
        break label58;
      }
      i = 0;
    }
    while (i == 0)
    {
      w(paramList);
      AppMethodBeat.o(197602);
      return;
      label58:
      localObject = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if (((z)((Iterator)localObject).next()).LW != 2)
          {
            i = 0;
            break;
          }
        }
      }
      i = 1;
    }
    if ((this.Dx != null) || (this.Dy))
    {
      w(paramList);
      AppMethodBeat.o(197602);
      return;
    }
    Object localObject = (z)paramList.get(0);
    new StringBuilder("issueCaptureRequests (id=").append(this.DD).append(") + state =").append(this.Dv);
    al.O("ProcessingCaptureSession");
    switch (3.DG[this.Dv.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(197602);
      return;
      this.Dx = ((z)localObject);
      AppMethodBeat.o(197602);
      return;
      this.Dy = true;
      this.DB = c.a.c(((z)localObject).LV).ir();
      a(this.DA, this.DB);
      new Object() {};
      AppMethodBeat.o(197602);
      return;
      new StringBuilder("Run issueCaptureRequests in wrong state, state = ").append(this.Dv);
      al.O("ProcessingCaptureSession");
      w(paramList);
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(197723);
      DH = new a("UNINITIALIZED", 0);
      DI = new a("SESSION_INITIALIZED", 1);
      DJ = new a("ON_CAPTURE_SESSION_STARTED", 2);
      DK = new a("ON_CAPTURE_SESSION_ENDED", 3);
      DL = new a("CLOSED", 4);
      DM = new a[] { DH, DI, DJ, DK, DL };
      AppMethodBeat.o(197723);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.ak
 * JD-Core Version:    0.7.0.1
 */