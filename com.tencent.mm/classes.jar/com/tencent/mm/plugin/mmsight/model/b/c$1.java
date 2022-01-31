package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.a.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.nio.Buffer;
import java.nio.ByteBuffer;

final class c$1
  implements h
{
  c$1(c paramc) {}
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(76697);
    if (c.a(this.oKf) == null) {
      c.a(this.oKf, c.b(this.oKf).amc());
    }
    Object localObject;
    int i;
    if (c.c(this.oKf) != null)
    {
      localObject = c.c(this.oKf).bQF();
      if (localObject != null)
      {
        i = ((Bitmap)localObject).getRowBytes() * ((Bitmap)localObject).getHeight();
        ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(i);
        localByteBuffer.position(0);
        ((Bitmap)localObject).copyPixelsToBuffer(localByteBuffer);
        localByteBuffer.position(0);
        if (c.d(this.oKf) == null) {
          c.a(this.oKf, new byte[i]);
        }
        localByteBuffer.get(c.d(this.oKf));
        SightVideoJNI.blendYuvFrame(paramArrayOfByte, c.d(this.oKf), c.a(this.oKf).x, c.a(this.oKf).y);
      }
    }
    int j;
    int k;
    if (c.e(this.oKf) != null)
    {
      if (c.d(this.oKf) == null)
      {
        if ((c.f(this.oKf) == 90) || (c.f(this.oKf) == 270))
        {
          c.a(this.oKf, d.b(c.e(this.oKf), 360 - c.f(this.oKf)));
          c.a(this.oKf, Bitmap.createScaledBitmap(c.e(this.oKf), c.a(this.oKf).x, c.a(this.oKf).y, true));
          localObject = ByteBuffer.allocateDirect(c.e(this.oKf).getRowBytes() * c.e(this.oKf).getHeight());
          ((ByteBuffer)localObject).position(0);
          c.e(this.oKf).copyPixelsToBuffer((Buffer)localObject);
          ((ByteBuffer)localObject).position(0);
          c.a(this.oKf, new byte[((ByteBuffer)localObject).remaining()]);
          ((ByteBuffer)localObject).get(c.d(this.oKf));
        }
      }
      else {
        SightVideoJNI.blendYuvFrame(paramArrayOfByte, c.d(this.oKf), c.a(this.oKf).x, c.a(this.oKf).y);
      }
    }
    else if (c.g(this.oKf) != null)
    {
      localObject = c.g(this.oKf);
      i = c.a(this.oKf).x;
      j = c.a(this.oKf).y;
      k = c.b(this.oKf).amd();
      if (paramArrayOfByte != null) {
        if ((i != ((g)localObject).eRu) || (j != ((g)localObject).eRv)) {
          break label674;
        }
      }
    }
    label674:
    for (boolean bool = false;; bool = true)
    {
      ab.d("MicroMsg.MMSightRemuxX264Encoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((g)localObject).eRu), Integer.valueOf(((g)localObject).eRv), Long.valueOf(paramLong) });
      MP4MuxerJNI.writeYuvDataForSegmentLock(paramArrayOfByte, i, j, ((g)localObject).eRu, ((g)localObject).eRv, k, ((g)localObject).gNA, ((g)localObject).gNB);
      ((g)localObject).frameCount += 1;
      j.oJp.O(paramArrayOfByte);
      if ((paramBoolean) && (c.g(this.oKf) != null))
      {
        paramArrayOfByte = c.g(this.oKf);
        if (paramArrayOfByte.oKm != null) {
          paramArrayOfByte.oKm.fZn = true;
        }
      }
      AppMethodBeat.o(76697);
      return;
      if (c.f(this.oKf) != 180) {
        break;
      }
      c.a(this.oKf, d.b(c.e(this.oKf), 180.0F));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.c.1
 * JD-Core Version:    0.7.0.1
 */