package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice.StateCallback;
import androidx.camera.camera2.a.a;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.bb;
import androidx.camera.core.impl.bb.b;
import androidx.camera.core.impl.bb.d;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.z;
import androidx.camera.core.impl.z.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class p
  implements bb.d
{
  static final p BV;
  
  static
  {
    AppMethodBeat.i(197916);
    BV = new p();
    AppMethodBeat.o(197916);
  }
  
  public final void a(bk<?> parambk, bb.b paramb)
  {
    AppMethodBeat.i(197930);
    bb localbb = parambk.kF();
    Object localObject = av.kw();
    int i = bb.kx().Ne.LW;
    if (localbb != null)
    {
      i = localbb.Ne.LW;
      localObject = localbb.Na.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramb.a((CameraDevice.StateCallback)((Iterator)localObject).next());
      }
      localObject = localbb.Nb.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramb.a((CameraCaptureSession.StateCallback)((Iterator)localObject).next());
      }
      localObject = localbb.Ne.Bs;
      paramb.Nf.h((Collection)localObject);
      localObject = localbb.Ne.LV;
    }
    for (;;)
    {
      paramb.i((ac)localObject);
      parambk = new a(parambk);
      paramb.aW(parambk.aD(i));
      localObject = new t.b();
      paramb.a((CameraDevice.StateCallback)parambk.Dp.b(a.zC, localObject));
      localObject = new s.b();
      paramb.a((CameraCaptureSession.StateCallback)parambk.Dp.b(a.zD, localObject));
      paramb.b(y.b(parambk.a(new j.b())));
      localObject = at.ku();
      ((at)localObject).c(a.zF, parambk.a(androidx.camera.camera2.a.c.fX()));
      paramb.j((ac)localObject);
      paramb.j(parambk.fT());
      AppMethodBeat.o(197930);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.p
 * JD-Core Version:    0.7.0.1
 */