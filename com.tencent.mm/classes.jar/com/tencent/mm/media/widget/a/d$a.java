package com.tencent.mm.media.widget.a;

import a.l;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "data", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/hardware/Camera;", "onPreviewFrame", "com/tencent/mm/media/widget/camera/CommonCamera1$setPreviewCallbackImpl$1$1"})
final class d$a
  implements Camera.PreviewCallback
{
  d$a(d paramd) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(13195);
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length != 0) {
        break label40;
      }
    }
    label40:
    for (int i = 1; i != 0; i = 0)
    {
      ab.e(this.faH.TAG, "onPreviewFrame, frame data is null!!");
      AppMethodBeat.o(13195);
      return;
    }
    if (this.faH.fas.size() <= 0)
    {
      paramCamera = this.faH.eoH;
      if (paramCamera != null)
      {
        paramCamera.addCallbackBuffer(paramArrayOfByte);
        AppMethodBeat.o(13195);
        return;
      }
      AppMethodBeat.o(13195);
      return;
    }
    paramCamera = paramArrayOfByte;
    Object localObject;
    long l1;
    if (!d.a(this.faH))
    {
      paramCamera = paramArrayOfByte;
      if (this.faH.fas.size() > 0)
      {
        paramCamera = paramArrayOfByte;
        if (this.faH.fav != null)
        {
          paramCamera = this.faH.fav;
          if ((paramCamera != null) && (paramCamera.x == this.faH.eZN.mnr))
          {
            paramCamera = this.faH.fav;
            if ((paramCamera != null) && (paramCamera.y == this.faH.eZN.mns)) {
              break label578;
            }
          }
          paramCamera = com.tencent.mm.plugin.mmsight.model.a.j.oJp;
          i = this.faH.eZN.mnr;
          localObject = this.faH.fav;
          if (localObject == null) {
            a.f.b.j.ebi();
          }
          paramCamera = paramCamera.f(Integer.valueOf(i * ((Point)localObject).y * 3 / 2));
          d.b(this.faH).kH(1L);
          l1 = bo.yB();
          i = this.faH.eZN.mnr;
          int j = this.faH.eZN.mns;
          localObject = this.faH.fav;
          if (localObject == null) {
            a.f.b.j.ebi();
          }
          SightVideoJNI.cropCameraData(paramArrayOfByte, paramCamera, i, j, ((Point)localObject).y);
          localObject = this.faH.fav;
          if (localObject == null) {
            a.f.b.j.ebi();
          }
          if (((Point)localObject).x >= this.faH.eZN.mnr) {
            break label646;
          }
          localObject = com.tencent.mm.plugin.mmsight.model.a.j.oJp;
          Point localPoint = this.faH.fav;
          if (localPoint == null) {
            a.f.b.j.ebi();
          }
          i = localPoint.x;
          localPoint = this.faH.fav;
          if (localPoint == null) {
            a.f.b.j.ebi();
          }
          localObject = ((com.tencent.mm.plugin.mmsight.model.a.j)localObject).f(Integer.valueOf(i * localPoint.y * 3 / 2));
          i = this.faH.eZN.mnr;
          localPoint = this.faH.fav;
          if (localPoint == null) {
            a.f.b.j.ebi();
          }
          j = localPoint.x;
          localPoint = this.faH.fav;
          if (localPoint == null) {
            a.f.b.j.ebi();
          }
          SightVideoJNI.cropCameraDataLongEdge(paramCamera, (byte[])localObject, i, j, localPoint.y);
          com.tencent.mm.plugin.mmsight.model.a.j.oJp.O(paramCamera);
          paramCamera = (Camera)localObject;
        }
      }
    }
    label646:
    for (;;)
    {
      long l2 = bo.av(l1);
      d.c(this.faH).kH(l2);
      localObject = this.faH;
      a.f.b.j.p(paramCamera, "curFrameData");
      boolean bool = d.a((d)localObject, paramCamera);
      l1 = bo.av(l1);
      paramCamera = paramArrayOfByte;
      if (bool)
      {
        d.d(this.faH).kH(l1);
        paramCamera = paramArrayOfByte;
      }
      for (;;)
      {
        paramArrayOfByte = this.faH.eoH;
        if (paramArrayOfByte == null) {
          break;
        }
        paramArrayOfByte.addCallbackBuffer(paramCamera);
        AppMethodBeat.o(13195);
        return;
        label578:
        l1 = bo.yB();
        bool = d.a(this.faH, paramArrayOfByte);
        l1 = bo.av(l1);
        if (bool) {
          d.d(this.faH).kH(l1);
        }
        paramCamera = paramArrayOfByte;
        if (bool) {
          paramCamera = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(paramArrayOfByte.length));
        }
      }
      AppMethodBeat.o(13195);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.d.a
 * JD-Core Version:    0.7.0.1
 */