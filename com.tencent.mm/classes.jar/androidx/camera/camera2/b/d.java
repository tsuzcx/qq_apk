package androidx.camera.camera2.b;

import androidx.camera.camera2.b.a.b.f;
import androidx.camera.camera2.b.a.c.c;
import androidx.camera.camera2.b.a.h;
import androidx.camera.core.al;
import androidx.camera.core.impl.az;
import androidx.camera.core.impl.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements g
{
  private final boolean zR;
  private final int zS;
  private final c zT;
  
  public d(String paramString, h paramh)
  {
    AppMethodBeat.i(197517);
    boolean bool = false;
    int i = -1;
    try
    {
      int j = Integer.parseInt(paramString);
      i = j;
      bool = true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        new StringBuilder("Camera id is not an integer: ").append(paramString).append(", unable to create CamcorderProfileProvider");
        al.R("Camera2CamcorderProfileProvider");
      }
    }
    this.zR = bool;
    this.zS = i;
    this.zT = new c((androidx.camera.camera2.b.a.b.d)f.d(paramh).f(androidx.camera.camera2.b.a.b.d.class));
    AppMethodBeat.o(197517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.d
 * JD-Core Version:    0.7.0.1
 */