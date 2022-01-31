package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class l$7
  implements Runnable
{
  l$7(l paraml, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    l locall = this.mjO;
    byte[] arrayOfByte = this.gBR;
    if (arrayOfByte != null) {}
    try
    {
      if (arrayOfByte.length == 0)
      {
        y.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, data is null");
        locall.mjF = false;
        return;
      }
      if (bk.bl(locall.thumbPath))
      {
        y.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, thumbpath is null");
        locall.mjF = false;
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb error: %s", new Object[] { localException.getMessage() });
      locall.mjF = false;
      return;
    }
    int i;
    int j;
    label140:
    Object localObject1;
    Object localObject2;
    int k;
    label281:
    float f;
    if ((locall.jWo == 0) || (locall.jWo == 180))
    {
      i = locall.mjy;
      if ((locall.jWo != 0) && (locall.jWo != 180)) {
        break label464;
      }
      j = locall.mjz;
      localObject1 = new YuvImage(localException, 17, i, j, null);
      localObject2 = new Rect(0, 0, i, j);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ((YuvImage)localObject1).compressToJpeg((Rect)localObject2, 100, localByteArrayOutputStream);
      localObject1 = localByteArrayOutputStream.toByteArray();
      localObject2 = MMBitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
      localObject1 = localObject2;
      if (locall.mfr != null)
      {
        localObject1 = localObject2;
        if (Math.min(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight()) > locall.mfr.ejZ)
        {
          j = ((Bitmap)localObject2).getWidth();
          k = ((Bitmap)localObject2).getHeight();
          if (locall.mfr.ejZ <= 0) {
            break label473;
          }
          i = locall.mfr.ejZ;
          if (j >= k) {
            break label485;
          }
          f = j * 1.0F / i;
          k = (int)(k / f);
          j = i;
          i = k;
          label308:
          localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, j, i, true);
        }
      }
      if ((locall.fwq) && (locall.mjI != 180)) {
        break label503;
      }
      j = locall.jWo;
      i = j;
      if (locall.mjI == 180)
      {
        j += 180;
        i = j;
        if (j > 360) {
          i = j - 360;
        }
      }
      localObject1 = c.b((Bitmap)localObject1, i);
    }
    for (;;)
    {
      c.a((Bitmap)localObject1, 60, Bitmap.CompressFormat.JPEG, locall.thumbPath, true);
      y.i("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", new Object[] { locall.thumbPath, Integer.valueOf(locall.jWo), Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
      return;
      i = locall.mjz;
      break;
      label464:
      j = locall.mjy;
      break label140;
      label473:
      i = locall.mfr.width;
      break label281;
      label485:
      f = k * 1.0F / i;
      j = (int)(j / f);
      break label308;
      label503:
      if (Math.abs(locall.jWo - locall.mjI) == 0)
      {
        localObject2 = c.b((Bitmap)localObject1, 180.0F);
        ((Bitmap)localObject1).recycle();
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l.7
 * JD-Core Version:    0.7.0.1
 */