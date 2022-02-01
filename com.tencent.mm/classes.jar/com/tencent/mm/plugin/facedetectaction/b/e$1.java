package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.e.a.4;
import com.tencent.mm.plugin.facedetect.e.a.5;
import com.tencent.mm.sdk.platformtools.aq;

final class e$1
  implements Runnable
{
  e$1(e parame, int paramInt, VideoTransPara paramVideoTransPara, byte[][] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(104223);
    Object localObject = a.cvw();
    int i = this.liC;
    ((a)localObject).rus.postToWorker(new a.4((a)localObject, i));
    localObject = a.cvw();
    float f = this.rxS.fps;
    ((a)localObject).rus.postToWorker(new a.5((a)localObject, f));
    localObject = this.rxU;
    byte[][] arrayOfByte = this.rxT;
    d.rxC.ad(new e.2((e)localObject, arrayOfByte));
    AppMethodBeat.o(104223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.1
 * JD-Core Version:    0.7.0.1
 */