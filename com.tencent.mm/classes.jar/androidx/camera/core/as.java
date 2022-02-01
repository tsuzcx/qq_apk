package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.impl.an;
import androidx.camera.core.impl.an.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class as
  implements an
{
  private boolean BU;
  private int Ie;
  private final an In;
  private final aa.a Jf;
  private final Object mLock;
  private final Surface mSurface;
  
  as(an paraman)
  {
    AppMethodBeat.i(198298);
    this.mLock = new Object();
    this.Ie = 0;
    this.BU = false;
    this.Jf = new as..ExternalSyntheticLambda0(this);
    this.In = paraman;
    this.mSurface = paraman.getSurface();
    AppMethodBeat.o(198298);
  }
  
  private ag e(ag paramag)
  {
    AppMethodBeat.i(198303);
    if (paramag != null)
    {
      this.Ie += 1;
      paramag = new av(paramag);
      paramag.a(this.Jf);
      AppMethodBeat.o(198303);
      return paramag;
    }
    AppMethodBeat.o(198303);
    return null;
  }
  
  public final void a(an.a parama, Executor paramExecutor)
  {
    AppMethodBeat.i(198411);
    synchronized (this.mLock)
    {
      this.In.a(new as..ExternalSyntheticLambda1(this, parama), paramExecutor);
      AppMethodBeat.o(198411);
      return;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(198349);
    synchronized (this.mLock)
    {
      if (this.mSurface != null) {
        this.mSurface.release();
      }
      this.In.close();
      AppMethodBeat.o(198349);
      return;
    }
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(198365);
    synchronized (this.mLock)
    {
      int i = this.In.getHeight();
      AppMethodBeat.o(198365);
      return i;
    }
  }
  
  public final Surface getSurface()
  {
    AppMethodBeat.i(198402);
    synchronized (this.mLock)
    {
      Surface localSurface = this.In.getSurface();
      AppMethodBeat.o(198402);
      return localSurface;
    }
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(198374);
    synchronized (this.mLock)
    {
      int i = this.In.getWidth();
      AppMethodBeat.o(198374);
      return i;
    }
  }
  
  public final ag iu()
  {
    AppMethodBeat.i(198332);
    synchronized (this.mLock)
    {
      ag localag = e(this.In.iu());
      AppMethodBeat.o(198332);
      return localag;
    }
  }
  
  public final ag iv()
  {
    AppMethodBeat.i(198336);
    synchronized (this.mLock)
    {
      ag localag = e(this.In.iv());
      AppMethodBeat.o(198336);
      return localag;
    }
  }
  
  public final int iw()
  {
    AppMethodBeat.i(198385);
    synchronized (this.mLock)
    {
      int i = this.In.iw();
      AppMethodBeat.o(198385);
      return i;
    }
  }
  
  public final int ix()
  {
    AppMethodBeat.i(198395);
    synchronized (this.mLock)
    {
      int i = this.In.ix();
      AppMethodBeat.o(198395);
      return i;
    }
  }
  
  public final void iy()
  {
    AppMethodBeat.i(198419);
    synchronized (this.mLock)
    {
      this.In.iy();
      AppMethodBeat.o(198419);
      return;
    }
  }
  
  final void jr()
  {
    AppMethodBeat.i(198355);
    synchronized (this.mLock)
    {
      this.BU = true;
      this.In.iy();
      if (this.Ie == 0) {
        close();
      }
      AppMethodBeat.o(198355);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.as
 * JD-Core Version:    0.7.0.1
 */