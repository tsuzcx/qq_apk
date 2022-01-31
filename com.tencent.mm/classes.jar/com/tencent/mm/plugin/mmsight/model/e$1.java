package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.plugin.base.model.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class e$1
  implements Camera.PreviewCallback
{
  e$1(e parame) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!this.mhf.mgO)
    {
      y.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", new Object[] { paramArrayOfByte, this.mhf.dwJ });
      this.mhf.mgO = true;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      y.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
      e.a(this.mhf);
      return;
    }
    paramCamera = this.mhf.mgL;
    if (paramCamera.hRI == 0)
    {
      paramCamera.hRH += 1;
      paramCamera.hRG = bk.ZR(m.yU());
    }
    paramCamera.hRI += 1;
    int i;
    long l1;
    byte[] arrayOfByte;
    label370:
    long l2;
    int j;
    if (paramCamera.hRI >= 90)
    {
      i = 0;
      paramCamera.hRI = i;
      if ((e.b(this.mhf)) || (this.mhf.mgN == null) || (this.mhf.mgN.size() <= 0)) {
        break label934;
      }
      if (this.mhf.mgH == null) {
        break label576;
      }
      paramCamera = j.mji.f(Integer.valueOf(this.mhf.mgw.jSV * this.mhf.mgH.y * 3 / 2));
      e.c(this.mhf).fj(1L);
      l1 = bk.UZ();
      SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, this.mhf.mgw.jSV, this.mhf.mgw.jSW, this.mhf.mgH.y);
      if (this.mhf.mgH.x >= this.mhf.mgw.jSV) {
        break label931;
      }
      arrayOfByte = j.mji.f(Integer.valueOf(this.mhf.mgH.x * this.mhf.mgH.y * 3 / 2));
      SightVideoJNI.cropCameraDataLongEdge(paramCamera, arrayOfByte, this.mhf.mgw.jSV, this.mhf.mgH.x, this.mhf.mgH.y);
      j.mji.z(paramCamera);
      paramCamera = arrayOfByte;
      l2 = bk.cp(l1);
      e.d(this.mhf).fj(l2);
      if (!this.mhf.mhe)
      {
        l1 = bk.UZ();
        i = this.mhf.mgH.x;
        j = this.mhf.mgH.y;
        if ((this.mhf.jXx.rotate == 270) || (this.mhf.jXx.rotate == 90)) {
          bool1 = true;
        }
        SightVideoJNI.mirrorCameraData(paramCamera, i, j, bool1);
        l2 = bk.cp(l1);
        e.e(this.mhf).fj(l2);
      }
      bool1 = e.a(this.mhf, paramCamera);
      l1 = bk.cp(l1);
      if (bool1) {
        e.f(this.mhf).fj(l1);
      }
    }
    for (;;)
    {
      e.b(this.mhf, paramCamera);
      if (e.g(this.mhf) == e.a.mhg) {
        e.h(this.mhf).fj(1L);
      }
      for (;;)
      {
        this.mhf.dwJ.addCallbackBuffer(paramArrayOfByte);
        return;
        i = paramCamera.hRI;
        break;
        label576:
        l1 = bk.UZ();
        if (!this.mhf.mhe)
        {
          i = this.mhf.mgw.jSV;
          j = this.mhf.mgw.jSW;
          if (this.mhf.jXx.rotate != 270)
          {
            bool1 = bool2;
            if (this.mhf.jXx.rotate != 90) {}
          }
          else
          {
            bool1 = true;
          }
          SightVideoJNI.mirrorCameraData(paramArrayOfByte, i, j, bool1);
          l2 = bk.cp(l1);
          e.e(this.mhf).fj(l2);
        }
        label749:
        e locale;
        if ((this.mhf.mgK) && (this.mhf.mgJ != null))
        {
          SightVideoJNI.paddingYuvData16(paramArrayOfByte, this.mhf.mgJ, this.mhf.mgG.x, this.mhf.mgF.y, this.mhf.mgG.y);
          paramCamera = this.mhf.mgJ;
          bool1 = e.a(this.mhf, paramCamera);
          l1 = bk.cp(l1);
          if (bool1) {
            e.f(this.mhf).fj(l1);
          }
          if (this.mhf.mgK)
          {
            arrayOfByte = paramArrayOfByte;
            if (this.mhf.mgJ != null) {}
          }
          else
          {
            arrayOfByte = paramArrayOfByte;
            if (bool1) {
              arrayOfByte = j.mji.f(Integer.valueOf(paramArrayOfByte.length));
            }
          }
          if ((this.mhf.mgK) && (this.mhf.mgJ != null))
          {
            locale = this.mhf;
            if (!bool1) {
              break label893;
            }
          }
        }
        label893:
        for (paramArrayOfByte = j.mji.f(Integer.valueOf(this.mhf.mgJ.length));; paramArrayOfByte = this.mhf.mgJ)
        {
          locale.mgJ = paramArrayOfByte;
          paramArrayOfByte = arrayOfByte;
          break;
          paramCamera = paramArrayOfByte;
          break label749;
        }
        if (e.g(this.mhf) == e.a.mhh) {
          e.i(this.mhf).fj(1L);
        }
      }
      label931:
      break label370;
      label934:
      arrayOfByte = paramArrayOfByte;
      paramCamera = paramArrayOfByte;
      paramArrayOfByte = arrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.e.1
 * JD-Core Version:    0.7.0.1
 */