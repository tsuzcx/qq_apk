package androidx.camera.camera2.b;

import android.content.Context;
import android.hardware.camera2.CaptureRequest;
import android.view.Display;
import androidx.camera.camera2.a.a.a;
import androidx.camera.camera2.b.a.b.h;
import androidx.camera.camera2.b.a.b.o;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.al;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.bb.b;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.bl;
import androidx.camera.core.impl.bl.a;
import androidx.camera.core.impl.z.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  implements bl
{
  final ae BW;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(197909);
    this.BW = ae.N(paramContext);
    AppMethodBeat.o(197909);
  }
  
  public final ac a(bl.a parama)
  {
    AppMethodBeat.i(197922);
    at localat = at.ku();
    Object localObject1 = new bb.b();
    Object localObject2;
    switch (1.BX[parama.ordinal()])
    {
    default: 
      if ((parama == bl.a.NN) && ((o)h.f(o.class) != null))
      {
        localObject2 = new a.a();
        ((a.a)localObject2).a(CaptureRequest.TONEMAP_MODE, Integer.valueOf(2));
        ((bb.b)localObject1).j(((a.a)localObject2).fV());
      }
      localat.c(bk.NF, ((bb.b)localObject1).ky());
      localat.c(bk.NH, p.BV);
      localObject1 = new z.a();
      switch (1.BX[parama.ordinal()])
      {
      default: 
        label176:
        localat.c(bk.NG, ((z.a)localObject1).kc());
        localObject2 = bk.NI;
        if (parama != bl.a.NM) {}
        break;
      }
      break;
    }
    for (localObject1 = ai.Dk;; localObject1 = k.Bx)
    {
      localat.c((ac.a)localObject2, localObject1);
      if (parama == bl.a.NN) {
        localat.c(al.MM, this.BW.hq());
      }
      int i = this.BW.hp().getRotation();
      localat.c(al.MJ, Integer.valueOf(i));
      parama = av.l(localat);
      AppMethodBeat.o(197922);
      return parama;
      ((bb.b)localObject1).aW(1);
      break;
      ((bb.b)localObject1).aW(3);
      break;
      ((z.a)localObject1).LW = 2;
      break label176;
      ((z.a)localObject1).LW = 1;
      break label176;
      ((z.a)localObject1).LW = 3;
      break label176;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.q
 * JD-Core Version:    0.7.0.1
 */