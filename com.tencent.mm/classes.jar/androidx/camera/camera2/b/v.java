package androidx.camera.camera2.b;

import androidx.camera.core.al;
import androidx.camera.core.impl.t.a;
import androidx.camera.core.r;
import androidx.camera.core.r.a;
import androidx.camera.core.r.b;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

final class v
{
  private final androidx.camera.core.impl.v At;
  final x<r> Ca;
  
  v(androidx.camera.core.impl.v paramv)
  {
    AppMethodBeat.i(197882);
    this.At = paramv;
    this.Ca = new x();
    this.Ca.t(r.a(r.b.Gy, null));
    AppMethodBeat.o(197882);
  }
  
  private r hf()
  {
    AppMethodBeat.i(197885);
    if (this.At.jY())
    {
      localr = r.a(r.b.Gv, null);
      AppMethodBeat.o(197885);
      return localr;
    }
    r localr = r.a(r.b.Gu, null);
    AppMethodBeat.o(197885);
    return localr;
  }
  
  public final void a(t.a parama, r.a parama1)
  {
    AppMethodBeat.i(197891);
    r localr;
    switch (1.Cb[parama.ordinal()])
    {
    default: 
      parama = new IllegalStateException("Unknown internal camera state: ".concat(String.valueOf(parama)));
      AppMethodBeat.o(197891);
      throw parama;
    case 1: 
      localr = hf();
    }
    for (;;)
    {
      new StringBuilder("New public camera state ").append(localr).append(" from ").append(parama).append(" and ").append(parama1);
      al.O("CameraStateMachine");
      if (!Objects.equals((r)this.Ca.getValue(), localr))
      {
        "Publishing new public camera state ".concat(String.valueOf(localr));
        al.O("CameraStateMachine");
        this.Ca.t(localr);
      }
      AppMethodBeat.o(197891);
      return;
      localr = r.a(r.b.Gv, parama1);
      continue;
      localr = r.a(r.b.Gw, parama1);
      continue;
      localr = r.a(r.b.Gx, parama1);
      continue;
      localr = r.a(r.b.Gy, parama1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.v
 * JD-Core Version:    0.7.0.1
 */