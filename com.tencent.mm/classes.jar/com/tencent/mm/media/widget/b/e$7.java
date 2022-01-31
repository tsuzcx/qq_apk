package com.tencent.mm.media.widget.b;

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

final class e$7
  implements Runnable
{
  e$7(e parame, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(152050);
    e locale = this.fdq;
    Object localObject1 = this.fdr;
    if (localObject1 != null) {}
    try
    {
      if (localObject1.length == 0)
      {
        ab.e("MicroMsg.X264YUVMP4MuxRecorder", "saveVideoThumbImpl, data is null");
        locale.fcp = false;
        AppMethodBeat.o(152050);
        return;
      }
      if (bo.isNullOrNil(locale.thumbPath))
      {
        ab.e("MicroMsg.X264YUVMP4MuxRecorder", "saveVideoThumbImpl, thumbpath is null");
        locale.fcp = false;
        AppMethodBeat.o(152050);
        return;
      }
      int i;
      int j;
      label131:
      Object localObject2;
      int k;
      label272:
      float f;
      if ((locale.fcn == 90) || (locale.fcn == 270))
      {
        i = locale.fck;
        if ((locale.fcn != 90) && (locale.fcn != 270)) {
          break label460;
        }
        j = locale.fcl;
        localObject1 = new YuvImage((byte[])localObject1, 17, i, j, null);
        localObject2 = new Rect(0, 0, i, j);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ((YuvImage)localObject1).compressToJpeg((Rect)localObject2, 100, localByteArrayOutputStream);
        localObject1 = localByteArrayOutputStream.toByteArray();
        localObject2 = MMBitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
        localObject1 = localObject2;
        if (locale.fcu != null)
        {
          localObject1 = localObject2;
          if (Math.min(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight()) > locale.fcu.fAg)
          {
            j = ((Bitmap)localObject2).getWidth();
            k = ((Bitmap)localObject2).getHeight();
            if (locale.fcu.fAg <= 0) {
              break label469;
            }
            i = locale.fcu.fAg;
            if (j >= k) {
              break label481;
            }
            f = j * 1.0F / i;
            k = (int)(k / f);
            j = i;
            i = k;
            label299:
            localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, j, i, true);
          }
        }
        if ((locale.fcx) && (locale.fcy != 180)) {
          break label499;
        }
        j = locale.fcn;
        i = j;
        if (locale.fcy == 180)
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
        d.a((Bitmap)localObject1, 60, Bitmap.CompressFormat.JPEG, locale.thumbPath, true);
        ab.i("MicroMsg.X264YUVMP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", new Object[] { locale.thumbPath, Integer.valueOf(locale.fcn), Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        AppMethodBeat.o(152050);
        return;
        i = locale.fcl;
        break;
        label460:
        j = locale.fck;
        break label131;
        label469:
        i = locale.fcu.width;
        break label272;
        label481:
        f = k * 1.0F / i;
        j = (int)(j / f);
        break label299;
        label499:
        if (Math.abs(locale.fcn - locale.fcy) == 0)
        {
          localObject2 = d.b((Bitmap)localObject1, 180.0F);
          ab.i("MicroMsg.X264YUVMP4MuxRecorder", "bitmap recycle %s", new Object[] { localObject1.toString() });
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.X264YUVMP4MuxRecorder", "saveVideoThumb error: %s", new Object[] { localException.getMessage() });
      locale.fcp = false;
      AppMethodBeat.o(152050);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e.7
 * JD-Core Version:    0.7.0.1
 */