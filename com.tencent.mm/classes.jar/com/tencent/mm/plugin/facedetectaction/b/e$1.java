package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.e.a.4;
import com.tencent.mm.plugin.facedetect.e.a.5;
import com.tencent.mm.sdk.platformtools.ai;

final class e$1
  implements Runnable
{
  e$1(e parame, int paramInt, VideoTransPara paramVideoTransPara, byte[][] paramArrayOfByte) {}
  
  public final void run()
  {
    Object localObject = a.aPj();
    int i = this.gAv;
    ((a)localObject).jSL.O(new a.4((a)localObject, i));
    localObject = a.aPj();
    float f = this.jWv.fps;
    ((a)localObject).jSL.O(new a.5((a)localObject, f));
    localObject = this.jWx;
    byte[][] arrayOfByte = this.jWw;
    d.jWf.H(new e.2((e)localObject, arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.1
 * JD-Core Version:    0.7.0.1
 */