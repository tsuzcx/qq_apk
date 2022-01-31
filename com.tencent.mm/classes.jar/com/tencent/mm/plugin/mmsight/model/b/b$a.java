package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.a.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;
import java.nio.ByteBuffer;

final class b$a
  extends ak
{
  public b$a(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(76693);
    byte[] arrayOfByte;
    int i;
    long l;
    int j;
    label286:
    int k;
    boolean bool;
    if (paramMessage.what == 1)
    {
      arrayOfByte = (byte[])paramMessage.obj;
      if (paramMessage.arg1 != 1) {
        break label643;
      }
      i = 1;
      l = paramMessage.arg2;
      if (b.c(this.oKb) != null)
      {
        if (b.d(this.oKb) == null) {
          b.a(this.oKb, b.e(this.oKb).amc());
        }
        if (b.f(this.oKb) != null)
        {
          paramMessage = b.f(this.oKb).bQF();
          if (paramMessage != null)
          {
            j = paramMessage.getRowBytes() * paramMessage.getHeight();
            ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(j);
            localByteBuffer.position(0);
            paramMessage.copyPixelsToBuffer(localByteBuffer);
            localByteBuffer.position(0);
            if (b.g(this.oKb) == null) {
              b.a(this.oKb, new byte[j]);
            }
            localByteBuffer.get(b.g(this.oKb));
            SightVideoJNI.blendYuvFrame(arrayOfByte, b.g(this.oKb), b.d(this.oKb).x, b.d(this.oKb).y);
          }
        }
        if (b.h(this.oKb) != null)
        {
          if (b.g(this.oKb) == null)
          {
            if ((b.i(this.oKb) != 90) && (b.i(this.oKb) != 270)) {
              break label648;
            }
            b.a(this.oKb, d.b(b.h(this.oKb), 360 - b.i(this.oKb)));
            b.a(this.oKb, Bitmap.createScaledBitmap(b.h(this.oKb), b.d(this.oKb).x, b.d(this.oKb).y, true));
            paramMessage = ByteBuffer.allocateDirect(b.h(this.oKb).getRowBytes() * b.h(this.oKb).getHeight());
            paramMessage.position(0);
            b.h(this.oKb).copyPixelsToBuffer(paramMessage);
            paramMessage.position(0);
            b.a(this.oKb, new byte[paramMessage.remaining()]);
            paramMessage.get(b.g(this.oKb));
          }
          SightVideoJNI.blendYuvFrame(arrayOfByte, b.g(this.oKb), b.d(this.oKb).x, b.d(this.oKb).y);
        }
        paramMessage = b.c(this.oKb);
        j = b.d(this.oKb).x;
        k = b.d(this.oKb).y;
        if ((i != 0) || (arrayOfByte == null)) {
          break label721;
        }
        if ((j != paramMessage.eRu) || (k != paramMessage.eRv)) {
          break label684;
        }
        bool = false;
        label491:
        ab.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramMessage.eRu), Integer.valueOf(paramMessage.eRv), Long.valueOf(l) });
        if (paramMessage.fYt == null) {
          paramMessage.fYt = new byte[paramMessage.eRu * paramMessage.eRv * 3 >> 1];
        }
        if ((paramMessage.eRx != 19) || (bool)) {
          break label690;
        }
        System.arraycopy(arrayOfByte, 0, paramMessage.fYt, 0, arrayOfByte.length);
        label608:
        paramMessage.fYp += 1;
        paramMessage.b(paramMessage.fYt, false, l);
      }
    }
    for (;;)
    {
      j.oJp.O(arrayOfByte);
      AppMethodBeat.o(76693);
      return;
      label643:
      i = 0;
      break;
      label648:
      if (b.i(this.oKb) != 180) {
        break label286;
      }
      b.a(this.oKb, d.b(b.h(this.oKb), 180.0F));
      break label286;
      label684:
      bool = true;
      break label491;
      label690:
      MP4MuxerJNI.yuv420pTo420XXAndScaleLock(arrayOfByte, 2, paramMessage.fYt, paramMessage.fYu, j, k, j, k, paramMessage.eRu, paramMessage.eRv);
      break label608;
      label721:
      paramMessage.b(paramMessage.fYt, true, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.b.a
 * JD-Core Version:    0.7.0.1
 */