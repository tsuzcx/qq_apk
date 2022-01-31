package com.tencent.mm.plugin.api.recordView;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.e.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

final class f$5
  implements e.b
{
  f$5(f paramf, boolean paramBoolean, MMSightRecordView.e parame) {}
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.fxn) {
      this.fxk.fwO.biP();
    }
    if ((paramArrayOfByte == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      y.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
      this.fxm.aiP();
      return;
    }
    label256:
    label402:
    label405:
    label419:
    for (;;)
    {
      Object localObject;
      try
      {
        if (!this.fxk.fwY) {
          break label402;
        }
        this.fxk.Zb();
        if (!this.fxk.fwO.mgZ) {
          break label302;
        }
        if (this.fxk.fxa.y >= paramInt1) {
          break label402;
        }
        localObject = new byte[this.fxk.fxa.x * this.fxk.fxa.y * 3 >> 1];
        SightVideoJNI.cropCameraDataLongEdge(paramArrayOfByte, (byte[])localObject, paramInt1, this.fxk.fxa.y, paramInt2);
        paramInt1 = this.fxk.fxa.y;
        paramInt2 = this.fxk.fxa.x;
        paramArrayOfByte = (byte[])localObject;
        paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
        localObject = new ByteArrayOutputStream();
        paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramInt1, paramInt2), 100, (OutputStream)localObject);
        paramArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
        localObject = MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (paramInt4 == 90) {
          break label405;
        }
        paramInt1 = paramInt3;
        if (paramInt4 != 270) {
          break label419;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        label246:
        y.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", paramArrayOfByte, "saveCaptureYuvDataToBitmap error: %s", new Object[] { paramArrayOfByte.getMessage() });
        this.fxm.aiP();
        return;
      }
      paramArrayOfByte = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, false);
      ((Bitmap)localObject).recycle();
      this.fxm.u(paramArrayOfByte);
      return;
      label302:
      if (this.fxk.fxa.x < paramInt2)
      {
        localObject = new byte[this.fxk.fxa.x * this.fxk.fxa.y * 3 >> 1];
        SightVideoJNI.cropCameraData(paramArrayOfByte, (byte[])localObject, paramInt1, paramInt2, this.fxk.fxa.x);
        paramInt1 = this.fxk.fxa.y;
        paramInt2 = this.fxk.fxa.x;
        paramArrayOfByte = (byte[])localObject;
      }
      else
      {
        do
        {
          paramArrayOfByte = c.b((Bitmap)localObject, paramInt1);
          break label256;
          break;
          paramInt1 = (paramInt3 - paramInt4 + 360) % 360;
          if (paramInt1 == 0) {
            break label246;
          }
        } while (paramInt1 != 360);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f.5
 * JD-Core Version:    0.7.0.1
 */