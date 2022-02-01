package androidx.camera.lifecycle;

import androidx.camera.core.a.c;
import androidx.camera.core.ax;
import androidx.camera.core.i;
import androidx.camera.core.impl.m;
import androidx.camera.core.impl.o;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.k;
import androidx.camera.core.n;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LifecycleCamera
  implements i, androidx.lifecycle.p
{
  private boolean IY;
  private final q QG;
  public final c QH;
  private boolean QI;
  private volatile boolean mIsActive;
  public final Object mLock;
  
  LifecycleCamera(q paramq, c paramc)
  {
    AppMethodBeat.i(197230);
    this.mLock = new Object();
    this.mIsActive = false;
    this.QI = false;
    this.IY = false;
    this.QG = paramq;
    this.QH = paramc;
    if (this.QG.getLifecycle().getCurrentState().d(j.b.bHj)) {
      this.QH.kW();
    }
    for (;;)
    {
      paramq.getLifecycle().addObserver(this);
      AppMethodBeat.o(197230);
      return;
      this.QH.kX();
    }
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(197386);
    c localc = this.QH;
    Object localObject = localc.mLock;
    m localm = paramm;
    if (paramm == null) {}
    try
    {
      localm = o.jV();
      if ((!localc.Qh.isEmpty()) && (!localc.AR.jS().equals(localm.jS())))
      {
        paramm = new IllegalStateException("Need to unbind all use cases before binding with extension enabled");
        AppMethodBeat.o(197386);
        throw paramm;
      }
    }
    finally
    {
      AppMethodBeat.o(197386);
    }
    localc.AR = localm;
    localc.Qc.a(localc.AR);
    AppMethodBeat.o(197386);
  }
  
  public final boolean f(ax paramax)
  {
    AppMethodBeat.i(197342);
    synchronized (this.mLock)
    {
      boolean bool = this.QH.kV().contains(paramax);
      AppMethodBeat.o(197342);
      return bool;
    }
  }
  
  public final q getLifecycleOwner()
  {
    synchronized (this.mLock)
    {
      q localq = this.QG;
      return localq;
    }
  }
  
  public final k iF()
  {
    AppMethodBeat.i(197371);
    androidx.camera.core.impl.p localp = this.QH.Qc.gO();
    AppMethodBeat.o(197371);
    return localp;
  }
  
  public final n iG()
  {
    AppMethodBeat.i(197379);
    s locals = this.QH.Qc.gK();
    AppMethodBeat.o(197379);
    return locals;
  }
  
  public final List<ax> kV()
  {
    AppMethodBeat.i(197355);
    synchronized (this.mLock)
    {
      List localList = Collections.unmodifiableList(this.QH.kV());
      AppMethodBeat.o(197355);
      return localList;
    }
  }
  
  public final void lb()
  {
    AppMethodBeat.i(197331);
    synchronized (this.mLock)
    {
      if (this.QI)
      {
        AppMethodBeat.o(197331);
        return;
      }
      onStop(this.QG);
      this.QI = true;
      AppMethodBeat.o(197331);
      return;
    }
  }
  
  public final void lc()
  {
    AppMethodBeat.i(197337);
    synchronized (this.mLock)
    {
      if (!this.QI)
      {
        AppMethodBeat.o(197337);
        return;
      }
      this.QI = false;
      if (this.QG.getLifecycle().getCurrentState().d(j.b.bHj)) {
        onStart(this.QG);
      }
      AppMethodBeat.o(197337);
      return;
    }
  }
  
  final void m(Collection<ax> paramCollection)
  {
    AppMethodBeat.i(197369);
    synchronized (this.mLock)
    {
      this.QH.k(paramCollection);
      AppMethodBeat.o(197369);
      return;
    }
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy(q arg1)
  {
    AppMethodBeat.i(197326);
    synchronized (this.mLock)
    {
      this.QH.l(this.QH.kV());
      AppMethodBeat.o(197326);
      return;
    }
  }
  
  @z(Ho=j.a.ON_START)
  public final void onStart(q arg1)
  {
    AppMethodBeat.i(197309);
    synchronized (this.mLock)
    {
      if ((!this.QI) && (!this.IY))
      {
        this.QH.kW();
        this.mIsActive = true;
      }
      AppMethodBeat.o(197309);
      return;
    }
  }
  
  @z(Ho=j.a.ON_STOP)
  public final void onStop(q arg1)
  {
    AppMethodBeat.i(197317);
    synchronized (this.mLock)
    {
      if ((!this.QI) && (!this.IY))
      {
        this.QH.kX();
        this.mIsActive = false;
      }
      AppMethodBeat.o(197317);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.lifecycle.LifecycleCamera
 * JD-Core Version:    0.7.0.1
 */