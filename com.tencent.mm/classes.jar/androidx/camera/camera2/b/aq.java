package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.view.Surface;
import androidx.camera.camera2.b.a.a.b;
import androidx.camera.camera2.b.a.a.d;
import androidx.camera.camera2.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class aq
  extends am.a
{
  private final List<am.a> cQ;
  
  aq(List<am.a> paramList)
  {
    AppMethodBeat.i(197325);
    this.cQ = new ArrayList();
    this.cQ.addAll(paramList);
    AppMethodBeat.o(197325);
  }
  
  public final void a(am paramam)
  {
    AppMethodBeat.i(197357);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((am.a)localIterator.next()).a(paramam);
    }
    AppMethodBeat.o(197357);
  }
  
  public final void a(am paramam, Surface paramSurface)
  {
    AppMethodBeat.i(197334);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((am.a)localIterator.next()).a(paramam, paramSurface);
    }
    AppMethodBeat.o(197334);
  }
  
  public final void b(am paramam)
  {
    AppMethodBeat.i(197339);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((am.a)localIterator.next()).b(paramam);
    }
    AppMethodBeat.o(197339);
  }
  
  final void c(am paramam)
  {
    AppMethodBeat.i(197372);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((am.a)localIterator.next()).c(paramam);
    }
    AppMethodBeat.o(197372);
  }
  
  public final void d(am paramam)
  {
    AppMethodBeat.i(197362);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((am.a)localIterator.next()).d(paramam);
    }
    AppMethodBeat.o(197362);
  }
  
  public final void g(am paramam)
  {
    AppMethodBeat.i(197343);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((am.a)localIterator.next()).g(paramam);
    }
    AppMethodBeat.o(197343);
  }
  
  public final void h(am paramam)
  {
    AppMethodBeat.i(197347);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((am.a)localIterator.next()).h(paramam);
    }
    AppMethodBeat.o(197347);
  }
  
  public final void i(am paramam)
  {
    AppMethodBeat.i(197367);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((am.a)localIterator.next()).i(paramam);
    }
    AppMethodBeat.o(197367);
  }
  
  static final class a
    extends am.a
  {
    private final CameraCaptureSession.StateCallback EF;
    
    private a(CameraCaptureSession.StateCallback paramStateCallback)
    {
      this.EF = paramStateCallback;
    }
    
    a(List<CameraCaptureSession.StateCallback> paramList) {}
    
    public final void a(am paramam)
    {
      AppMethodBeat.i(197633);
      this.EF.onConfigured(paramam.hE().hR());
      AppMethodBeat.o(197633);
    }
    
    public final void a(am paramam, Surface paramSurface)
    {
      AppMethodBeat.i(197608);
      a.b.a(this.EF, paramam.hE().hR(), paramSurface);
      AppMethodBeat.o(197608);
    }
    
    public final void b(am paramam)
    {
      AppMethodBeat.i(197617);
      this.EF.onReady(paramam.hE().hR());
      AppMethodBeat.o(197617);
    }
    
    final void c(am paramam) {}
    
    public final void d(am paramam)
    {
      AppMethodBeat.i(197638);
      this.EF.onConfigureFailed(paramam.hE().hR());
      AppMethodBeat.o(197638);
    }
    
    public final void g(am paramam)
    {
      AppMethodBeat.i(197622);
      this.EF.onActive(paramam.hE().hR());
      AppMethodBeat.o(197622);
    }
    
    public final void h(am paramam)
    {
      AppMethodBeat.i(197627);
      a.d.a(this.EF, paramam.hE().hR());
      AppMethodBeat.o(197627);
    }
    
    public final void i(am paramam)
    {
      AppMethodBeat.i(197643);
      this.EF.onClosed(paramam.hE().hR());
      AppMethodBeat.o(197643);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.aq
 * JD-Core Version:    0.7.0.1
 */