package androidx.camera.core;

import android.os.Handler;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.a.a.a;
import androidx.camera.core.impl.a.a.b;
import androidx.camera.core.impl.a.b.c;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.aa;
import androidx.camera.core.impl.ab;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.an.a;
import androidx.camera.core.impl.h;
import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ar
  extends ad
{
  private final h Cc;
  final aa HI;
  final am IN;
  private String IT;
  boolean IY;
  private final Size IZ;
  private final an.a Im;
  final Surface Ja;
  private final Handler Jb;
  final ab Jc;
  private final ad Jd;
  final Object mLock;
  
  ar(int paramInt1, int paramInt2, int paramInt3, Handler paramHandler, ab paramab, aa paramaa, ad paramad, String paramString)
  {
    super(new Size(paramInt1, paramInt2), paramInt3);
    AppMethodBeat.i(198337);
    this.mLock = new Object();
    this.Im = new ar..ExternalSyntheticLambda0(this);
    this.IY = false;
    this.IZ = new Size(paramInt1, paramInt2);
    this.Jb = paramHandler;
    paramHandler = a.b(this.Jb);
    this.IN = new am(paramInt1, paramInt2, paramInt3, 2);
    this.IN.a(this.Im, paramHandler);
    this.Ja = this.IN.getSurface();
    this.Cc = this.IN.Cc;
    this.HI = paramaa;
    this.HI.c(this.IZ);
    this.Jc = paramab;
    this.Jd = paramad;
    this.IT = paramString;
    e.a(paramad.kf(), new c()
    {
      public final void onFailure(Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(198587);
        al.U("ProcessingSurfaceTextur");
        AppMethodBeat.o(198587);
      }
    }, b.kP());
    e.d(this.Mj).a(new ar..ExternalSyntheticLambda1(this), b.kP());
    AppMethodBeat.o(198337);
  }
  
  private void release()
  {
    AppMethodBeat.i(198344);
    synchronized (this.mLock)
    {
      if (this.IY)
      {
        AppMethodBeat.o(198344);
        return;
      }
      this.IN.close();
      this.Ja.release();
      this.Jd.close();
      this.IY = true;
      AppMethodBeat.o(198344);
      return;
    }
  }
  
  final h jo()
  {
    AppMethodBeat.i(198398);
    synchronized (this.mLock)
    {
      if (this.IY)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("ProcessingSurface already released!");
        AppMethodBeat.o(198398);
        throw localIllegalStateException;
      }
    }
    h localh = this.Cc;
    AppMethodBeat.o(198398);
    return localh;
  }
  
  public final f<Surface> jq()
  {
    AppMethodBeat.i(198387);
    synchronized (this.mLock)
    {
      f localf = e.v(this.Ja);
      AppMethodBeat.o(198387);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.ar
 * JD-Core Version:    0.7.0.1
 */