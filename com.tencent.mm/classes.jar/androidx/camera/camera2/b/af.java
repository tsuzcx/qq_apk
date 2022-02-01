package androidx.camera.camera2.b;

import androidx.c.a.b.a;
import androidx.camera.camera2.b.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class af
{
  final f By;
  final ag CQ;
  b.a<Integer> CR;
  f.c CS;
  private final Executor mExecutor;
  boolean mIsActive;
  
  af(f paramf, h paramh, Executor paramExecutor)
  {
    AppMethodBeat.i(197439);
    this.mIsActive = false;
    this.By = paramf;
    this.CQ = new ag(paramh);
    this.mExecutor = paramExecutor;
    AppMethodBeat.o(197439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.af
 * JD-Core Version:    0.7.0.1
 */