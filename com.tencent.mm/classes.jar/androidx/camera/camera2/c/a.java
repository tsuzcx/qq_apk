package androidx.camera.camera2.c;

import androidx.c.a.b;
import androidx.c.a.b.a;
import androidx.camera.camera2.a.a.a;
import androidx.camera.camera2.b.f.c;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.as;
import androidx.camera.core.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

public final class a
{
  b.a<Void> BL;
  private final androidx.camera.camera2.b.f Bo;
  public final f.c EN;
  private boolean FZ;
  private a.a Ga;
  final Executor mExecutor;
  private boolean mIsActive;
  final Object mLock;
  
  public a(androidx.camera.camera2.b.f paramf, Executor paramExecutor)
  {
    AppMethodBeat.i(197304);
    this.mIsActive = false;
    this.FZ = false;
    this.mLock = new Object();
    this.Ga = new a.a();
    this.EN = new a..ExternalSyntheticLambda2(this);
    this.Bo = paramf;
    this.mExecutor = paramExecutor;
    AppMethodBeat.o(197304);
  }
  
  private void f(b.a<Void> parama)
  {
    AppMethodBeat.i(197308);
    this.FZ = true;
    b.a locala = null;
    if (this.BL != null) {
      locala = this.BL;
    }
    this.BL = parama;
    if (this.mIsActive) {
      iq();
    }
    if (locala != null) {
      locala.h(new k.a("Camera2CameraControl was updated with new options."));
    }
    AppMethodBeat.o(197308);
  }
  
  private void iq()
  {
    AppMethodBeat.i(197313);
    this.Bo.gv();
    this.FZ = false;
    AppMethodBeat.o(197313);
  }
  
  public final com.google.b.b.a.f<Void> a(c paramc)
  {
    AppMethodBeat.i(197425);
    synchronized (this.mLock)
    {
      Iterator localIterator = paramc.ke().iterator();
      if (localIterator.hasNext())
      {
        ac.a locala = (ac.a)localIterator.next();
        this.Ga.zH.c(locala, paramc.b(locala));
      }
    }
    paramc = e.d(b.a(new a..ExternalSyntheticLambda1(this)));
    AppMethodBeat.o(197425);
    return paramc;
  }
  
  public final com.google.b.b.a.f<Void> in()
  {
    AppMethodBeat.i(197438);
    synchronized (this.mLock)
    {
      this.Ga = new a.a();
      ??? = e.d(b.a(new a..ExternalSyntheticLambda0(this)));
      AppMethodBeat.o(197438);
      return ???;
    }
  }
  
  public final androidx.camera.camera2.a.a ip()
  {
    AppMethodBeat.i(197453);
    synchronized (this.mLock)
    {
      if (this.BL != null) {
        this.Ga.zH.c(androidx.camera.camera2.a.a.zG, Integer.valueOf(this.BL.hashCode()));
      }
      androidx.camera.camera2.a.a locala = this.Ga.fV();
      AppMethodBeat.o(197453);
      return locala;
    }
  }
  
  public final void setActive(boolean paramBoolean)
  {
    AppMethodBeat.i(197463);
    this.mExecutor.execute(new a..ExternalSyntheticLambda5(this, paramBoolean));
    AppMethodBeat.o(197463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.c.a
 * JD-Core Version:    0.7.0.1
 */