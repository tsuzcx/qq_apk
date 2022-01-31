package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectView$1
  implements b
{
  FaceDetectView$1(FaceDetectView paramFaceDetectView) {}
  
  public final void a(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(617);
    ab.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    if ((FaceDetectView.a(this.mpb)) || (FaceDetectView.b(this.mpb)))
    {
      ab.w("MicroMsg.FaceDetectView", "hy: already end or paused");
      AppMethodBeat.o(617);
      return;
    }
    if ((FaceDetectView.c(this.mpb) != null) && (FaceDetectView.c(this.mpb).buO()))
    {
      ab.e("MicroMsg.FaceDetectView", "hy: motion eat result");
      FaceDetectView.a(this.mpb, FaceDetectView.c(this.mpb).buR());
      AppMethodBeat.o(617);
      return;
    }
    this.mpb.ht(false);
    FaceDetectView.a(this.mpb, true);
    FaceDetectView localFaceDetectView = this.mpb;
    Object localObject;
    if (paramCharSequence != null)
    {
      localObject = paramCharSequence.toString();
      FaceDetectView.a(localFaceDetectView, (String)localObject);
      if (FaceDetectView.d(this.mpb) != null)
      {
        localObject = FaceDetectView.d(this.mpb);
        if (paramCharSequence == null) {
          break label220;
        }
      }
    }
    label220:
    for (paramCharSequence = paramCharSequence.toString();; paramCharSequence = this.mpb.getContext().getString(2131299529))
    {
      ((a)localObject).U(paramInt, paramCharSequence);
      AppMethodBeat.o(617);
      return;
      localObject = this.mpb.getContext().getString(2131299529);
      break;
    }
  }
  
  public final void c(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    AppMethodBeat.i(618);
    int i = paramFaceCharacteristicsResult.errCode;
    String str = paramFaceCharacteristicsResult.errMsg;
    ab.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", new Object[] { Integer.valueOf(i), str });
    if ((FaceDetectView.a(this.mpb)) || (FaceDetectView.b(this.mpb)))
    {
      ab.w("MicroMsg.FaceDetectView", "hy: already end");
      AppMethodBeat.o(618);
      return;
    }
    if ((FaceDetectView.c(this.mpb) != null) && (FaceDetectView.c(this.mpb).a(paramFaceCharacteristicsResult)))
    {
      ab.e("MicroMsg.FaceDetectView", "hy: motion eat result");
      FaceDetectView.a(this.mpb, FaceDetectView.c(this.mpb).buR());
      AppMethodBeat.o(618);
      return;
    }
    FaceDetectView.e(this.mpb);
    if (!FaceDetectView.f(this.mpb))
    {
      AppMethodBeat.o(618);
      return;
    }
    if ((!FaceDetectView.g(this.mpb)) && ((paramFaceCharacteristicsResult.errCode == 10) || (paramFaceCharacteristicsResult.errCode == 11)))
    {
      AppMethodBeat.o(618);
      return;
    }
    FaceDetectView.a(this.mpb, FaceCharacteristicsResult.vC(i));
    FaceDetectView localFaceDetectView = this.mpb;
    if (str != null) {}
    for (paramFaceCharacteristicsResult = str;; paramFaceCharacteristicsResult = "")
    {
      FaceDetectView.a(localFaceDetectView, paramFaceCharacteristicsResult);
      AppMethodBeat.o(618);
      return;
    }
  }
  
  public final void d(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    AppMethodBeat.i(619);
    ab.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", new Object[] { paramFaceCharacteristicsResult.toString() });
    if ((FaceDetectView.a(this.mpb)) || (FaceDetectView.b(this.mpb)))
    {
      ab.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
      AppMethodBeat.o(619);
      return;
    }
    if ((FaceDetectView.c(this.mpb) != null) && (FaceDetectView.c(this.mpb).b(paramFaceCharacteristicsResult)))
    {
      ab.e("MicroMsg.FaceDetectView", "hy: motion eat result");
      FaceDetectView.a(this.mpb, FaceDetectView.c(this.mpb).buR());
      AppMethodBeat.o(619);
      return;
    }
    FaceDetectView.a(this.mpb, false);
    if (((FaceDetectView.c(this.mpb) != null) && (FaceDetectView.c(this.mpb).buN())) || (FaceDetectView.f(this.mpb)))
    {
      FaceDetectView.h(this.mpb);
      FaceDetectView.e(this.mpb);
    }
    AppMethodBeat.o(619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView.1
 * JD-Core Version:    0.7.0.1
 */