package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCharacteristics;
import androidx.c.a.b.a;
import androidx.camera.camera2.b.a.h;
import androidx.camera.core.impl.a.l;
import androidx.camera.core.k.a;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class ar
{
  final f Bo;
  final x<Integer> EG;
  private final boolean EH;
  b.a<Void> EI;
  boolean EJ;
  private final Executor mExecutor;
  boolean mIsActive;
  
  ar(f paramf, h paramh, Executor paramExecutor)
  {
    AppMethodBeat.i(197310);
    this.Bo = paramf;
    this.mExecutor = paramExecutor;
    paramf = (Boolean)paramh.a(CameraCharacteristics.FLASH_INFO_AVAILABLE);
    if ((paramf != null) && (paramf.booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      this.EH = bool;
      this.EG = new x(Integer.valueOf(0));
      paramf = new ar..ExternalSyntheticLambda0(this);
      this.Bo.b(paramf);
      AppMethodBeat.o(197310);
      return;
    }
  }
  
  static <T> void a(x<T> paramx, T paramT)
  {
    AppMethodBeat.i(197315);
    if (l.isMainThread())
    {
      paramx.setValue(paramT);
      AppMethodBeat.o(197315);
      return;
    }
    paramx.t(paramT);
    AppMethodBeat.o(197315);
  }
  
  final void a(b.a<Void> parama, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(197329);
    if (!this.EH)
    {
      if (parama != null) {
        parama.h(new IllegalStateException("No flash unit"));
      }
      AppMethodBeat.o(197329);
      return;
    }
    if (!this.mIsActive)
    {
      a(this.EG, Integer.valueOf(0));
      if (parama != null) {
        parama.h(new k.a("Camera is not active."));
      }
      AppMethodBeat.o(197329);
      return;
    }
    this.EJ = paramBoolean;
    this.Bo.X(paramBoolean);
    x localx = this.EG;
    if (paramBoolean) {
      i = 1;
    }
    a(localx, Integer.valueOf(i));
    if (this.EI != null) {
      this.EI.h(new k.a("There is a new enableTorch being set"));
    }
    this.EI = parama;
    AppMethodBeat.o(197329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.ar
 * JD-Core Version:    0.7.0.1
 */