package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;

final class a$10
  implements Runnable
{
  a$10(a parama, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    SightVideoJNI.mirrorCameraData(this.val$data, a.i(this.jTm), a.j(this.jTm), false);
    if (a.g(this.jTm).bjp() != null) {
      a.g(this.jTm).bjp().M(this.val$data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.10
 * JD-Core Version:    0.7.0.1
 */