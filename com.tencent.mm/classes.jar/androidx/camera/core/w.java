package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.aa;
import androidx.camera.core.impl.am;
import androidx.camera.core.impl.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

final class w
  implements aa
{
  private final aa Hg;
  private final aa Hh;
  private final int Hi;
  an Hj = null;
  private af Hk = null;
  final Executor mExecutor;
  
  w(aa paramaa1, int paramInt, aa paramaa2, Executor paramExecutor)
  {
    this.Hg = paramaa1;
    this.Hh = paramaa2;
    this.mExecutor = paramExecutor;
    this.Hi = paramInt;
  }
  
  public final void a(Surface paramSurface, int paramInt)
  {
    AppMethodBeat.i(198582);
    this.Hh.a(paramSurface, paramInt);
    AppMethodBeat.o(198582);
  }
  
  public final void a(am paramam)
  {
    AppMethodBeat.i(198591);
    com.google.b.b.a.f localf = paramam.aV(((Integer)paramam.js().get(0)).intValue());
    androidx.core.f.f.checkArgument(localf.isDone());
    try
    {
      this.Hk = ((ag)localf.get()).it();
      this.Hg.a(paramam);
      AppMethodBeat.o(198591);
      return;
    }
    catch (InterruptedException paramam)
    {
      paramam = new IllegalArgumentException("Can not successfully extract ImageProxy from the ImageProxyBundle.");
      AppMethodBeat.o(198591);
      throw paramam;
    }
    catch (ExecutionException paramam)
    {
      label74:
      break label74;
    }
  }
  
  public final void c(Size paramSize)
  {
    AppMethodBeat.i(198596);
    this.Hj = new b(ImageReader.newInstance(paramSize.getWidth(), paramSize.getHeight(), 35, this.Hi));
    this.Hg.a(this.Hj.getSurface(), 35);
    this.Hg.c(paramSize);
    this.Hh.c(paramSize);
    this.Hj.a(new w..ExternalSyntheticLambda0(this), androidx.camera.core.impl.a.a.b.kP());
    AppMethodBeat.o(198596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.w
 * JD-Core Version:    0.7.0.1
 */