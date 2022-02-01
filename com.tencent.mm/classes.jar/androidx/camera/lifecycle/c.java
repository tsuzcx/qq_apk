package androidx.camera.lifecycle;

import android.content.Context;
import androidx.c.a.b.a;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.u;
import androidx.camera.core.q;
import androidx.camera.core.t;
import androidx.camera.core.u.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements b
{
  private static final c QN;
  public final LifecycleCameraRepository QM;
  private u.b QO;
  private com.google.b.b.a.f<t> QP;
  private com.google.b.b.a.f<Void> QQ;
  public t QR;
  public Context mContext;
  private final Object mLock;
  
  static
  {
    AppMethodBeat.i(197274);
    QN = new c();
    AppMethodBeat.o(197274);
  }
  
  private c()
  {
    AppMethodBeat.i(197256);
    this.mLock = new Object();
    this.QO = null;
    this.QQ = e.v(null);
    this.QM = new LifecycleCameraRepository();
    AppMethodBeat.o(197256);
  }
  
  public static com.google.b.b.a.f<c> U(Context paramContext)
  {
    AppMethodBeat.i(197245);
    androidx.core.f.f.checkNotNull(paramContext);
    paramContext = e.a(QN.V(paramContext), new c..ExternalSyntheticLambda0(paramContext), androidx.camera.core.impl.a.a.b.kP());
    AppMethodBeat.o(197245);
    return paramContext;
  }
  
  private com.google.b.b.a.f<t> V(Context paramContext)
  {
    AppMethodBeat.i(197251);
    synchronized (this.mLock)
    {
      if (this.QP != null)
      {
        paramContext = this.QP;
        AppMethodBeat.o(197251);
        return paramContext;
      }
      this.QP = androidx.c.a.b.a(new c..ExternalSyntheticLambda1(this, new t(paramContext, this.QO)));
      paramContext = this.QP;
      AppMethodBeat.o(197251);
      return paramContext;
    }
  }
  
  public final boolean a(q paramq)
  {
    AppMethodBeat.i(197289);
    try
    {
      paramq.b(this.QR.GA.jW());
      AppMethodBeat.o(197289);
      return true;
    }
    catch (IllegalArgumentException paramq)
    {
      AppMethodBeat.o(197289);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.lifecycle.c
 * JD-Core Version:    0.7.0.1
 */