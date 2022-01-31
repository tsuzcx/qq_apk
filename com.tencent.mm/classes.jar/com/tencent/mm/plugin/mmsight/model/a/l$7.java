package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.ByteArrayOutputStream;

final class l$7
  implements Runnable
{
  l$7(l paraml, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(76600);
    l locall = this.oJt;
    Object localObject1 = this.fdr;
    if (localObject1 != null) {}
    try
    {
      if (localObject1.length == 0)
      {
        ab.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, data is null");
        locall.fcp = false;
        AppMethodBeat.o(76600);
        return;
      }
      if (bo.isNullOrNil(locall.thumbPath))
      {
        ab.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, thumbpath is null");
        locall.fcp = false;
        AppMethodBeat.o(76600);
        return;
      }
      int i;
      int j;
      label127:
      Object localObject2;
      int k;
      label268:
      float f;
      if ((locall.fcn == 0) || (locall.fcn == 180))
      {
        i = locall.fck;
        if ((locall.fcn != 0) && (locall.fcn != 180)) {
          break label456;
        }
        j = locall.fcl;
        localObject1 = new YuvImage((byte[])localObject1, 17, i, j, null);
        localObject2 = new Rect(0, 0, i, j);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ((YuvImage)localObject1).compressToJpeg((Rect)localObject2, 100, localByteArrayOutputStream);
        localObject1 = localByteArrayOutputStream.toByteArray();
        localObject2 = MMBitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
        localObject1 = localObject2;
        if (locall.fcu != null)
        {
          localObject1 = localObject2;
          if (Math.min(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight()) > locall.fcu.fAg)
          {
            j = ((Bitmap)localObject2).getWidth();
            k = ((Bitmap)localObject2).getHeight();
            if (locall.fcu.fAg <= 0) {
              break label465;
            }
            i = locall.fcu.fAg;
            if (j >= k) {
              break label477;
            }
            f = j * 1.0F / i;
            k = (int)(k / f);
            j = i;
            i = k;
            label295:
            localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, j, i, true);
          }
        }
        if ((locall.fcx) && (locall.fcy != 180)) {
          break label495;
        }
        j = locall.fcn;
        i = j;
        if (locall.fcy == 180)
        {
          j += 180;
          i = j;
          if (j > 360) {
            i = j - 360;
          }
        }
        localObject1 = d.b((Bitmap)localObject1, i);
      }
      for (;;)
      {
        d.a((Bitmap)localObject1, 60, Bitmap.CompressFormat.JPEG, locall.thumbPath, true);
        ab.i("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", new Object[] { locall.thumbPath, Integer.valueOf(locall.fcn), Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        AppMethodBeat.o(76600);
        return;
        i = locall.fcl;
        break;
        label456:
        j = locall.fck;
        break label127;
        label465:
        i = locall.fcu.width;
        break label268;
        label477:
        f = k * 1.0F / i;
        j = (int)(j / f);
        break label295;
        label495:
        if (Math.abs(locall.fcn - locall.fcy) == 0)
        {
          localObject2 = d.b((Bitmap)localObject1, 180.0F);
          ab.i("MicroMsg.MMSightFFMpegRecorder", "bitmap recycle %s", new Object[] { localObject1.toString() });
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb error: %s", new Object[] { localException.getMessage() });
      locall.fcp = false;
      AppMethodBeat.o(76600);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l.7
 * JD-Core Version:    0.7.0.1
 */