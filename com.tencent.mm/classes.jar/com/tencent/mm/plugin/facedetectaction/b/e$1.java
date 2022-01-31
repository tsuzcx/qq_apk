package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.e.a.4;
import com.tencent.mm.plugin.facedetect.e.a.5;
import com.tencent.mm.sdk.platformtools.al;

final class e$1
  implements Runnable
{
  e$1(e parame, int paramInt, VideoTransPara paramVideoTransPara, byte[][] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(701);
    Object localObject = a.bvo();
    int i = this.hXH;
    ((a)localObject).mnh.ac(new a.4((a)localObject, i));
    localObject = a.bvo();
    float f = this.mqM.fps;
    ((a)localObject).mnh.ac(new a.5((a)localObject, f));
    localObject = this.mqO;
    byte[][] arrayOfByte = this.mqN;
    d.mqx.O(new e.2((e)localObject, arrayOfByte));
    AppMethodBeat.o(701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.1
 * JD-Core Version:    0.7.0.1
 */