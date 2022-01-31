package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.mm.sdk.platformtools.y;

final class a$6
  implements Runnable
{
  a$6(a parama, double paramDouble) {}
  
  public final void run()
  {
    y.d("MicroMsg.FaceReflectCam", "reset ratio");
    this.jXz.jXp.setAspectRatio(this.jXD);
    y.d("MicroMsg.FaceReflectCam", "after reset ratio=" + this.jXz.jXp.getmAspectRatio());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.6
 * JD-Core Version:    0.7.0.1
 */