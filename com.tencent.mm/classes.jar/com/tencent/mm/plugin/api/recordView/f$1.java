package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements b
{
  f$1(f paramf) {}
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    if (this.fxk.fwO.a(paramSurfaceTexture, this.fxk.fwP, this.fxk.fwQ, this.fxk.fwX) < 0)
    {
      y.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
      if (this.fxk.fxf != null) {
        this.fxk.fxf.aiO();
      }
    }
    if (this.fxk.fwZ != -1) {
      this.fxk.Zc();
    }
    this.fxk.fwO.biJ();
    this.fxk.YZ();
    y.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f.1
 * JD-Core Version:    0.7.0.1
 */