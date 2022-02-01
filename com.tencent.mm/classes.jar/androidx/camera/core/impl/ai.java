package androidx.camera.core.impl;

import androidx.camera.core.a.e;
import androidx.camera.core.ad;
import androidx.camera.core.ah;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai
  implements e, al, bk<ad>
{
  public static final ac.a<aa> MA;
  public static final ac.a<Integer> MC;
  public static final ac.a<Integer> MD;
  public static final ac.a<Boolean> ME;
  public static final ac.a<Integer> MF;
  public static final ac.a<Integer> MG;
  public static final ac.a<ah> Mt;
  public static final ac.a<Integer> Mx;
  public static final ac.a<Integer> My;
  public static final ac.a<y> Mz;
  private final av Hd;
  
  static
  {
    AppMethodBeat.i(198650);
    Mx = ac.a.a("camerax.core.imageCapture.captureMode", Integer.TYPE, null);
    My = ac.a.a("camerax.core.imageCapture.flashMode", Integer.TYPE, null);
    Mz = ac.a.a("camerax.core.imageCapture.captureBundle", y.class, null);
    MA = ac.a.a("camerax.core.imageCapture.captureProcessor", aa.class, null);
    MC = ac.a.a("camerax.core.imageCapture.bufferFormat", Integer.class, null);
    MD = ac.a.a("camerax.core.imageCapture.maxCaptureStages", Integer.class, null);
    Mt = ac.a.a("camerax.core.imageCapture.imageReaderProxyProvider", ah.class, null);
    ME = ac.a.a("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE, null);
    MF = ac.a.a("camerax.core.imageCapture.flashType", Integer.TYPE, null);
    MG = ac.a.a("camerax.core.imageCapture.jpegCompressionQuality", Integer.TYPE, null);
    AppMethodBeat.o(198650);
  }
  
  public ai(av paramav)
  {
    this.Hd = paramav;
  }
  
  public final ac hx()
  {
    return this.Hd;
  }
  
  public final ah kh()
  {
    AppMethodBeat.i(198670);
    ah localah = (ah)b(Mt, null);
    AppMethodBeat.o(198670);
    return localah;
  }
  
  public final int ki()
  {
    AppMethodBeat.i(198663);
    int i = ((Integer)b(MH)).intValue();
    AppMethodBeat.o(198663);
    return i;
  }
  
  public final int kj()
  {
    AppMethodBeat.i(198659);
    int i = ((Integer)b(Mx)).intValue();
    AppMethodBeat.o(198659);
    return i;
  }
  
  public final int kk()
  {
    AppMethodBeat.i(198677);
    int i = ((Integer)b(MG)).intValue();
    AppMethodBeat.o(198677);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.ai
 * JD-Core Version:    0.7.0.1
 */