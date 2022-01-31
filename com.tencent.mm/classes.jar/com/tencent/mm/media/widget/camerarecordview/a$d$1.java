package com.tencent.mm.media.widget.camerarecordview;

import a.f.a.b;
import a.l;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c;
import com.tencent.mm.media.widget.a.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class a$d$1
  implements Runnable
{
  a$d$1(a.d paramd, SurfaceTexture paramSurfaceTexture) {}
  
  public final void run()
  {
    AppMethodBeat.i(13230);
    a.d(this.fbf.fbe).a(this.fbg, this.fbf.fbe.fbc.Xn(), this.fbf.fbe.fbc.getResolutionLimit());
    if ((!a.d(this.fbf.fbe).WO()) && (!this.fbf.fbe.fbc.Xn()))
    {
      localObject = c.eZC;
      c.Vv();
    }
    Object localObject = this.fbf.evA;
    if (localObject != null) {
      ((b)localObject).S(Boolean.valueOf(a.d(this.fbf.fbe).WO()));
    }
    a.e(this.fbf.fbe);
    AppMethodBeat.o(13230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.a.d.1
 * JD-Core Version:    0.7.0.1
 */