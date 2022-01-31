package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectView$1
  implements b
{
  FaceDetectView$1(FaceDetectView paramFaceDetectView) {}
  
  public final void a(int paramInt, CharSequence paramCharSequence)
  {
    y.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    if ((FaceDetectView.a(this.jUI)) || (FaceDetectView.b(this.jUI))) {
      y.w("MicroMsg.FaceDetectView", "hy: already end or paused");
    }
    do
    {
      return;
      if ((FaceDetectView.c(this.jUI) != null) && (FaceDetectView.c(this.jUI).aOK()))
      {
        y.e("MicroMsg.FaceDetectView", "hy: motion eat result");
        FaceDetectView.a(this.jUI, FaceDetectView.c(this.jUI).aON());
        return;
      }
      this.jUI.fQ(false);
      FaceDetectView.a(this.jUI, true);
      FaceDetectView localFaceDetectView = this.jUI;
      if (paramCharSequence == null) {
        break;
      }
      localObject = paramCharSequence.toString();
      FaceDetectView.a(localFaceDetectView, (String)localObject);
    } while (FaceDetectView.d(this.jUI) == null);
    Object localObject = FaceDetectView.d(this.jUI);
    if (paramCharSequence != null) {}
    for (paramCharSequence = paramCharSequence.toString();; paramCharSequence = this.jUI.getContext().getString(a.i.face_compare_fail))
    {
      ((a)localObject).J(paramInt, paramCharSequence);
      return;
      localObject = this.jUI.getContext().getString(a.i.face_compare_fail);
      break;
    }
  }
  
  public final void c(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    int i = paramFaceCharacteristicsResult.errCode;
    String str = paramFaceCharacteristicsResult.aox;
    y.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", new Object[] { Integer.valueOf(i), str });
    if ((FaceDetectView.a(this.jUI)) || (FaceDetectView.b(this.jUI))) {
      y.w("MicroMsg.FaceDetectView", "hy: already end");
    }
    do
    {
      return;
      if ((FaceDetectView.c(this.jUI) != null) && (FaceDetectView.c(this.jUI).a(paramFaceCharacteristicsResult)))
      {
        y.e("MicroMsg.FaceDetectView", "hy: motion eat result");
        FaceDetectView.a(this.jUI, FaceDetectView.c(this.jUI).aON());
        return;
      }
      FaceDetectView.e(this.jUI);
    } while ((!FaceDetectView.f(this.jUI)) || ((!FaceDetectView.g(this.jUI)) && ((paramFaceCharacteristicsResult.errCode == 10) || (paramFaceCharacteristicsResult.errCode == 11))));
    FaceDetectView.a(this.jUI, FaceCharacteristicsResult.qH(i));
    FaceDetectView localFaceDetectView = this.jUI;
    if (str != null) {}
    for (paramFaceCharacteristicsResult = str;; paramFaceCharacteristicsResult = "")
    {
      FaceDetectView.a(localFaceDetectView, paramFaceCharacteristicsResult);
      return;
    }
  }
  
  public final void d(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    y.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", new Object[] { paramFaceCharacteristicsResult.toString() });
    if ((FaceDetectView.a(this.jUI)) || (FaceDetectView.b(this.jUI))) {
      y.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
    }
    do
    {
      return;
      if ((FaceDetectView.c(this.jUI) != null) && (FaceDetectView.c(this.jUI).b(paramFaceCharacteristicsResult)))
      {
        y.e("MicroMsg.FaceDetectView", "hy: motion eat result");
        FaceDetectView.a(this.jUI, FaceDetectView.c(this.jUI).aON());
        return;
      }
      FaceDetectView.a(this.jUI, false);
    } while (((FaceDetectView.c(this.jUI) == null) || (!FaceDetectView.c(this.jUI).aOJ())) && (!FaceDetectView.f(this.jUI)));
    FaceDetectView.h(this.jUI);
    FaceDetectView.e(this.jUI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView.1
 * JD-Core Version:    0.7.0.1
 */