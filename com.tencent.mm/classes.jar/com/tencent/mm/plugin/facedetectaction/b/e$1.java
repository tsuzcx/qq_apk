package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.e.a.4;
import com.tencent.mm.plugin.facedetect.e.a.5;
import com.tencent.mm.sdk.platformtools.ap;

final class e$1
  implements Runnable
{
  e$1(e parame, int paramInt, VideoTransPara paramVideoTransPara, byte[][] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(104223);
    Object localObject = a.ctV();
    int i = this.leQ;
    ((a)localObject).rmn.postToWorker(new a.4((a)localObject, i));
    localObject = a.ctV();
    float f = this.rpO.fps;
    ((a)localObject).rmn.postToWorker(new a.5((a)localObject, f));
    localObject = this.rpQ;
    byte[][] arrayOfByte = this.rpP;
    d.rpy.af(new e.2((e)localObject, arrayOfByte));
    AppMethodBeat.o(104223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.1
 * JD-Core Version:    0.7.0.1
 */