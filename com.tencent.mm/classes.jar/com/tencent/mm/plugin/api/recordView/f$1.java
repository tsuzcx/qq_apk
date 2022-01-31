package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.sdk.platformtools.ab;

final class f$1
  implements b
{
  f$1(f paramf) {}
  
  public final void f(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(76338);
    if (this.gOo.gNP.a(paramSurfaceTexture, this.gOo.gNQ, this.gOo.gNS, this.gOo.gNZ) < 0)
    {
      ab.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
      if (this.gOo.gOh != null) {
        this.gOo.gOh.aCL();
      }
    }
    if (this.gOo.gOb != -1) {
      this.gOo.asL();
    }
    this.gOo.gNP.bQM();
    this.gOo.asI();
    this.gOo.asT();
    if (this.gOo.gOl != null) {
      this.gOo.gOl.b(this.gOo.gNW.eZz);
    }
    ab.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
    AppMethodBeat.o(76338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f.1
 * JD-Core Version:    0.7.0.1
 */