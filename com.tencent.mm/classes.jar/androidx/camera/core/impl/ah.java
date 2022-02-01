package androidx.camera.core.impl;

import androidx.camera.core.a.g;
import androidx.camera.core.ab;
import androidx.camera.core.ab.a;
import androidx.camera.core.ab.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah
  implements g, al, bk<ab>
{
  public static final ac.a<Integer> Mr;
  public static final ac.a<Integer> Ms;
  public static final ac.a<androidx.camera.core.ah> Mt;
  public static final ac.a<Integer> Mu;
  public static final ac.a<Boolean> Mv;
  public static final ac.a<Boolean> Mw;
  private final av Hd;
  
  static
  {
    AppMethodBeat.i(198655);
    Mr = ac.a.a("camerax.core.imageAnalysis.backpressureStrategy", ab.a.class, null);
    Ms = ac.a.a("camerax.core.imageAnalysis.imageQueueDepth", Integer.TYPE, null);
    Mt = ac.a.a("camerax.core.imageAnalysis.imageReaderProxyProvider", androidx.camera.core.ah.class, null);
    Mu = ac.a.a("camerax.core.imageAnalysis.outputImageFormat", ab.d.class, null);
    Mv = ac.a.a("camerax.core.imageAnalysis.onePixelShiftEnabled", Boolean.class, null);
    Mw = ac.a.a("camerax.core.imageAnalysis.outputImageRotationEnabled", Boolean.class, null);
    AppMethodBeat.o(198655);
  }
  
  public ah(av paramav)
  {
    this.Hd = paramav;
  }
  
  public final Boolean c(Boolean paramBoolean)
  {
    AppMethodBeat.i(198685);
    paramBoolean = (Boolean)b(Mv, paramBoolean);
    AppMethodBeat.o(198685);
    return paramBoolean;
  }
  
  public final ac hx()
  {
    return this.Hd;
  }
  
  public final int kg()
  {
    AppMethodBeat.i(198675);
    int i = ((Integer)b(Mu, Integer.valueOf(1))).intValue();
    AppMethodBeat.o(198675);
    return i;
  }
  
  public final androidx.camera.core.ah kh()
  {
    AppMethodBeat.i(198691);
    androidx.camera.core.ah localah = (androidx.camera.core.ah)b(Mt, null);
    AppMethodBeat.o(198691);
    return localah;
  }
  
  public final int ki()
  {
    return 35;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.ah
 * JD-Core Version:    0.7.0.1
 */