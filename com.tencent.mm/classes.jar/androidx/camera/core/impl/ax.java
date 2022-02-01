package androidx.camera.core.impl;

import androidx.camera.core.a.g;
import androidx.camera.core.ap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ax
  implements g, al, bk<ap>
{
  public static final ac.a<aj> MX;
  public static final ac.a<aa> MY;
  private final av Hd;
  
  static
  {
    AppMethodBeat.i(198881);
    MX = ac.a.a("camerax.core.preview.imageInfoProcessor", aj.class, null);
    MY = ac.a.a("camerax.core.preview.captureProcessor", aa.class, null);
    AppMethodBeat.o(198881);
  }
  
  public ax(av paramav)
  {
    this.Hd = paramav;
  }
  
  public final ac hx()
  {
    return this.Hd;
  }
  
  public final int ki()
  {
    AppMethodBeat.i(198892);
    int i = ((Integer)b(MH)).intValue();
    AppMethodBeat.o(198892);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.ax
 * JD-Core Version:    0.7.0.1
 */