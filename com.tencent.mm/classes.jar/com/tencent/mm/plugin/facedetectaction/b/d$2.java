package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.e.a.3;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  implements Runnable
{
  d$2(d paramd, byte[][] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    d.a(this.jWr, new e(d.a(this.jWr), d.b(this.jWr), d.c(this.jWr), d.d(this.jWr), d.e(this.jWr)));
    d.g(this.jWr).jWu = new d.2.1(this);
    Object localObject1 = d.g(this.jWr);
    byte[][] arrayOfByte = this.jWs;
    int k = this.gpo;
    int m = this.gpp;
    VideoTransPara localVideoTransPara;
    int n;
    int i1;
    Object localObject2;
    int j;
    int i;
    if ((arrayOfByte != null) && (k > 0) && (m > 0))
    {
      y.i("MicroMsg.FaceCheckVideoRecordMgr", "recordAllPostDetectFrames, width: %s, height: %s, frames.size: %s, cameraFrameWidth: %s, cameraFrameHeight: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(arrayOfByte.length), Integer.valueOf(((e)localObject1).jWp), Integer.valueOf(((e)localObject1).jWq) });
      localVideoTransPara = new VideoTransPara();
      localVideoTransPara.isDefault = true;
      localVideoTransPara.width = k;
      localVideoTransPara.height = m;
      localVideoTransPara.fps = 30;
      localVideoTransPara.videoBitrate = 12000000;
      localVideoTransPara.ejN = 10;
      localVideoTransPara.ejM = 64000;
      localVideoTransPara.ejO = 2;
      localVideoTransPara.ejP = 1;
      localVideoTransPara.audioSampleRate = 16000;
      localVideoTransPara.duration = 15;
      n = arrayOfByte.length;
      i1 = localVideoTransPara.fps;
      localVideoTransPara.videoBitrate = 3686400;
      if (((e)localObject1).jWj > 0.0F) {
        localVideoTransPara.videoBitrate = ((int)(localVideoTransPara.videoBitrate * ((e)localObject1).jWj));
      }
      y.i("MicroMsg.FaceCheckVideoRecordMgr", "final video bitrate: %s", new Object[] { Integer.valueOf(localVideoTransPara.videoBitrate) });
      if ((((e)localObject1).jWp == k) && (((e)localObject1).jWq == m)) {
        break label563;
      }
      y.e("MicroMsg.FaceCheckVideoRecordMgr", "camera frame size and sdk output size not match!!!");
      if ((arrayOfByte == null) || (arrayOfByte[0] == null)) {
        break label563;
      }
      localObject2 = arrayOfByte[0];
      y.i("MicroMsg.FaceCheckVideoRecordMgr", "first frame size: %s", new Object[] { Integer.valueOf(localObject2.length) });
      if ((localObject2.length == k * m * 3 / 2) || (localObject2.length != ((e)localObject1).jWp * ((e)localObject1).jWq * 3 / 2)) {
        break label563;
      }
      j = ((e)localObject1).jWp;
      i = ((e)localObject1).jWq;
    }
    for (;;)
    {
      localObject2 = a.aPj();
      int i2 = ((e)localObject1).orientation;
      localObject1 = new e.1((e)localObject1, n * i1, localVideoTransPara, arrayOfByte);
      y.i("MicroMsg.FaceVideoRecorder", "initRecorderForActionVerify");
      y.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d, param: %s", new Object[] { Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(false), Integer.valueOf(0), localVideoTransPara });
      ((a)localObject2).jSY.b(((a)localObject2).eMh, localVideoTransPara);
      ((a)localObject2).jSL.O(new a.3((a)localObject2, i2, i, j, k, m, (Runnable)localObject1));
      return;
      label563:
      i = m;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d.2
 * JD-Core Version:    0.7.0.1
 */