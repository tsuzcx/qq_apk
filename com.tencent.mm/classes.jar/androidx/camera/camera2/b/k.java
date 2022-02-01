package androidx.camera.camera2.b;

import androidx.camera.camera2.a.a;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.z;
import androidx.camera.core.impl.z.a;
import androidx.camera.core.impl.z.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

class k
  implements z.b
{
  static final k Bx;
  
  static
  {
    AppMethodBeat.i(197603);
    Bx = new k();
    AppMethodBeat.o(197603);
  }
  
  public void a(bk<?> parambk, z.a parama)
  {
    AppMethodBeat.i(197619);
    z localz = parambk.kG();
    Object localObject = av.kw();
    int i = z.ka().LW;
    if (localz != null)
    {
      i = localz.LW;
      parama.h(localz.Bs);
      localObject = localz.LV;
    }
    parama.i((ac)localObject);
    parambk = new a(parambk);
    parama.LW = parambk.aD(i);
    parama.b(y.b(parambk.a(new j.b())));
    parama.j(parambk.fT());
    AppMethodBeat.o(197619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.k
 * JD-Core Version:    0.7.0.1
 */