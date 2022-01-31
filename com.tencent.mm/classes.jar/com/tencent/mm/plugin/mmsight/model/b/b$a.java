package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;

final class b$a
  extends ah
{
  public b$a(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    byte[] arrayOfByte;
    int i;
    long l;
    label152:
    int j;
    int k;
    boolean bool;
    if (paramMessage.what == 1)
    {
      arrayOfByte = (byte[])paramMessage.obj;
      if (paramMessage.arg1 != 1) {
        break label504;
      }
      i = 1;
      l = paramMessage.arg2;
      if (b.c(this.mkW) != null)
      {
        if (b.d(this.mkW) == null) {
          b.a(this.mkW, b.e(this.mkW).SP());
        }
        if (b.f(this.mkW) != null)
        {
          if (b.g(this.mkW) == null)
          {
            if ((b.h(this.mkW) != 90) && (b.h(this.mkW) != 270)) {
              break label509;
            }
            b.a(this.mkW, c.b(b.f(this.mkW), 360 - b.h(this.mkW)));
            b.a(this.mkW, Bitmap.createScaledBitmap(b.f(this.mkW), b.d(this.mkW).x, b.d(this.mkW).y, true));
            paramMessage = ByteBuffer.allocateDirect(b.f(this.mkW).getRowBytes() * b.f(this.mkW).getHeight());
            paramMessage.position(0);
            b.f(this.mkW).copyPixelsToBuffer(paramMessage);
            paramMessage.position(0);
            b.a(this.mkW, new byte[paramMessage.remaining()]);
            paramMessage.get(b.g(this.mkW));
          }
          SightVideoJNI.blendYuvFrame(arrayOfByte, b.g(this.mkW), b.d(this.mkW).x, b.d(this.mkW).y);
        }
        paramMessage = b.c(this.mkW);
        j = b.d(this.mkW).x;
        k = b.d(this.mkW).y;
        if ((i != 0) || (arrayOfByte == null)) {
          break label582;
        }
        if ((j != paramMessage.eIB) || (k != paramMessage.eIC)) {
          break label545;
        }
        bool = false;
        label357:
        y.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramMessage.eIB), Integer.valueOf(paramMessage.eIC), Long.valueOf(l) });
        if (paramMessage.eIN == null) {
          paramMessage.eIN = new byte[paramMessage.eIB * paramMessage.eIC * 3 >> 1];
        }
        if ((paramMessage.eID != 19) || (bool)) {
          break label551;
        }
        System.arraycopy(arrayOfByte, 0, paramMessage.eIN, 0, arrayOfByte.length);
        label474:
        paramMessage.eIE += 1;
        paramMessage.b(paramMessage.eIN, false, l);
      }
    }
    for (;;)
    {
      j.mji.z(arrayOfByte);
      return;
      label504:
      i = 0;
      break;
      label509:
      if (b.h(this.mkW) != 180) {
        break label152;
      }
      b.a(this.mkW, c.b(b.f(this.mkW), 180.0F));
      break label152;
      label545:
      bool = true;
      break label357;
      label551:
      MP4MuxerJNI.yuv420pTo420XXAndScale(arrayOfByte, 2, paramMessage.eIN, paramMessage.eIO, j, k, j, k, paramMessage.eIB, paramMessage.eIC);
      break label474;
      label582:
      paramMessage.b(paramMessage.eIN, true, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.b.a
 * JD-Core Version:    0.7.0.1
 */