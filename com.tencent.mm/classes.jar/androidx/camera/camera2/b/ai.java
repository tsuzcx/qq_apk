package androidx.camera.camera2.b;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.a.a.a;
import androidx.camera.camera2.b.a.b.h;
import androidx.camera.camera2.b.a.c.f;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.z.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ai
  extends k
{
  static final ai Dk;
  private final f Dl;
  
  static
  {
    AppMethodBeat.i(197403);
    Dk = new ai(new f());
    AppMethodBeat.o(197403);
  }
  
  private ai(f paramf)
  {
    this.Dl = paramf;
  }
  
  public final void a(bk<?> parambk, z.a parama)
  {
    AppMethodBeat.i(197420);
    super.a(parambk, parama);
    if (!(parambk instanceof androidx.camera.core.impl.ai))
    {
      parambk = new IllegalArgumentException("config is not ImageCaptureConfig");
      AppMethodBeat.o(197420);
      throw parambk;
    }
    parambk = (androidx.camera.core.impl.ai)parambk;
    a.a locala = new a.a();
    if (parambk.a(androidx.camera.core.impl.ai.Mx))
    {
      int i = parambk.kj();
      if ((androidx.camera.camera2.b.a.b.k)h.f(androidx.camera.camera2.b.a.b.k.class) != null) {
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      parama.j(locala.fV());
      AppMethodBeat.o(197420);
      return;
      locala.a(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.TRUE);
      continue;
      locala.a(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.FALSE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.ai
 * JD-Core Version:    0.7.0.1
 */