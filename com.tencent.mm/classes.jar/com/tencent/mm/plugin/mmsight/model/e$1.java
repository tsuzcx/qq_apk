package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.base.model.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class e$1
  implements Camera.PreviewCallback
{
  e$1(e parame) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(76468);
    if (!this.oHp.oHh)
    {
      ab.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", new Object[] { paramArrayOfByte, this.oHp.eoH });
      this.oHp.oHh = true;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      ab.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
      AppMethodBeat.o(76468);
      return;
    }
    paramCamera = this.oHp.oHf;
    if (paramCamera.jLj == 0)
    {
      paramCamera.jLi += 1;
      paramCamera.jLh = bo.apV(m.Lr());
    }
    paramCamera.jLj += 1;
    int i;
    long l1;
    byte[] arrayOfByte;
    label367:
    long l2;
    int j;
    boolean bool;
    if (paramCamera.jLj >= 90)
    {
      i = 0;
      paramCamera.jLj = i;
      if ((e.a(this.oHp)) || (this.oHp.fas == null) || (this.oHp.fas.size() <= 0)) {
        break label944;
      }
      if (this.oHp.fav == null) {
        break label584;
      }
      paramCamera = j.oJp.f(Integer.valueOf(this.oHp.eZN.mnr * this.oHp.fav.y * 3 / 2));
      e.b(this.oHp).kH(1L);
      l1 = bo.yB();
      SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, this.oHp.eZN.mnr, this.oHp.eZN.mns, this.oHp.fav.y);
      if (this.oHp.fav.x >= this.oHp.eZN.mnr) {
        break label941;
      }
      arrayOfByte = j.oJp.f(Integer.valueOf(this.oHp.fav.x * this.oHp.fav.y * 3 / 2));
      SightVideoJNI.cropCameraDataLongEdge(paramCamera, arrayOfByte, this.oHp.eZN.mnr, this.oHp.fav.x, this.oHp.fav.y);
      j.oJp.O(paramCamera);
      paramCamera = arrayOfByte;
      l2 = bo.av(l1);
      e.c(this.oHp).kH(l2);
      if (!this.oHp.eZK)
      {
        l1 = bo.yB();
        i = this.oHp.fav.x;
        j = this.oHp.fav.y;
        if ((this.oHp.fau.rotate != 270) && (this.oHp.fau.rotate != 90)) {
          break label578;
        }
        bool = true;
        label458:
        SightVideoJNI.mirrorCameraData(paramCamera, i, j, bool);
        l2 = bo.av(l1);
        e.d(this.oHp).kH(l2);
      }
      bool = e.a(this.oHp, paramCamera);
      l1 = bo.av(l1);
      if (bool) {
        e.e(this.oHp).kH(l1);
      }
    }
    for (;;)
    {
      e.b(this.oHp, paramCamera);
      if (e.f(this.oHp) == e.a.oHq) {
        e.g(this.oHp).kH(1L);
      }
      for (;;)
      {
        this.oHp.eoH.addCallbackBuffer(paramArrayOfByte);
        AppMethodBeat.o(76468);
        return;
        i = paramCamera.jLj;
        break;
        label578:
        bool = false;
        break label458;
        label584:
        l1 = bo.yB();
        label656:
        label753:
        e locale;
        if (!this.oHp.eZK)
        {
          i = this.oHp.eZN.mnr;
          j = this.oHp.eZN.mns;
          if ((this.oHp.fau.rotate == 270) || (this.oHp.fau.rotate == 90))
          {
            bool = true;
            SightVideoJNI.mirrorCameraData(paramArrayOfByte, i, j, bool);
            l2 = bo.av(l1);
            e.d(this.oHp).kH(l2);
          }
        }
        else
        {
          if ((!this.oHp.oHe) || (this.oHp.oHd == null)) {
            break label898;
          }
          SightVideoJNI.paddingYuvData16(paramArrayOfByte, this.oHp.oHd, this.oHp.oHb.x, this.oHp.oHa.y, this.oHp.oHb.y);
          paramCamera = this.oHp.oHd;
          bool = e.a(this.oHp, paramCamera);
          l1 = bo.av(l1);
          if (bool) {
            e.e(this.oHp).kH(l1);
          }
          if (this.oHp.oHe)
          {
            arrayOfByte = paramArrayOfByte;
            if (this.oHp.oHd != null) {}
          }
          else
          {
            arrayOfByte = paramArrayOfByte;
            if (bool) {
              arrayOfByte = j.oJp.f(Integer.valueOf(paramArrayOfByte.length));
            }
          }
          if ((this.oHp.oHe) && (this.oHp.oHd != null))
          {
            locale = this.oHp;
            if (!bool) {
              break label903;
            }
          }
        }
        label898:
        label903:
        for (paramArrayOfByte = j.oJp.f(Integer.valueOf(this.oHp.oHd.length));; paramArrayOfByte = this.oHp.oHd)
        {
          locale.oHd = paramArrayOfByte;
          paramArrayOfByte = arrayOfByte;
          break;
          bool = false;
          break label656;
          paramCamera = paramArrayOfByte;
          break label753;
        }
        if (e.f(this.oHp) == e.a.oHr) {
          e.h(this.oHp).kH(1L);
        }
      }
      label941:
      break label367;
      label944:
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