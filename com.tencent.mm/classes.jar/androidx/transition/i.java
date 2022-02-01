package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  static final Matrix cfz;
  
  static
  {
    AppMethodBeat.i(201533);
    cfz = new Matrix()
    {
      private static void LQ()
      {
        AppMethodBeat.i(201349);
        IllegalStateException localIllegalStateException = new IllegalStateException("Matrix can not be modified");
        AppMethodBeat.o(201349);
        throw localIllegalStateException;
      }
      
      public final boolean postConcat(Matrix paramAnonymousMatrix)
      {
        AppMethodBeat.i(201543);
        LQ();
        AppMethodBeat.o(201543);
        return false;
      }
      
      public final boolean postRotate(float paramAnonymousFloat)
      {
        AppMethodBeat.i(201524);
        LQ();
        AppMethodBeat.o(201524);
        return false;
      }
      
      public final boolean postRotate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
      {
        AppMethodBeat.i(201514);
        LQ();
        AppMethodBeat.o(201514);
        return false;
      }
      
      public final boolean postScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(201504);
        LQ();
        AppMethodBeat.o(201504);
        return false;
      }
      
      public final boolean postScale(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(201497);
        LQ();
        AppMethodBeat.o(201497);
        return false;
      }
      
      public final boolean postSkew(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(201537);
        LQ();
        AppMethodBeat.o(201537);
        return false;
      }
      
      public final boolean postSkew(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(201530);
        LQ();
        AppMethodBeat.o(201530);
        return false;
      }
      
      public final boolean postTranslate(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(201490);
        LQ();
        AppMethodBeat.o(201490);
        return false;
      }
      
      public final boolean preConcat(Matrix paramAnonymousMatrix)
      {
        AppMethodBeat.i(201482);
        LQ();
        AppMethodBeat.o(201482);
        return false;
      }
      
      public final boolean preRotate(float paramAnonymousFloat)
      {
        AppMethodBeat.i(201460);
        LQ();
        AppMethodBeat.o(201460);
        return false;
      }
      
      public final boolean preRotate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
      {
        AppMethodBeat.i(201452);
        LQ();
        AppMethodBeat.o(201452);
        return false;
      }
      
      public final boolean preScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(201446);
        LQ();
        AppMethodBeat.o(201446);
        return false;
      }
      
      public final boolean preScale(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(201440);
        LQ();
        AppMethodBeat.o(201440);
        return false;
      }
      
      public final boolean preSkew(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(201471);
        LQ();
        AppMethodBeat.o(201471);
        return false;
      }
      
      public final boolean preSkew(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(201467);
        LQ();
        AppMethodBeat.o(201467);
        return false;
      }
      
      public final boolean preTranslate(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(201432);
        LQ();
        AppMethodBeat.o(201432);
        return false;
      }
      
      public final void reset()
      {
        AppMethodBeat.i(201364);
        LQ();
        AppMethodBeat.o(201364);
      }
      
      public final void set(Matrix paramAnonymousMatrix)
      {
        AppMethodBeat.i(201356);
        LQ();
        AppMethodBeat.o(201356);
      }
      
      public final boolean setConcat(Matrix paramAnonymousMatrix1, Matrix paramAnonymousMatrix2)
      {
        AppMethodBeat.i(201425);
        LQ();
        AppMethodBeat.o(201425);
        return false;
      }
      
      public final boolean setPolyToPoly(float[] paramAnonymousArrayOfFloat1, int paramAnonymousInt1, float[] paramAnonymousArrayOfFloat2, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(201556);
        LQ();
        AppMethodBeat.o(201556);
        return false;
      }
      
      public final boolean setRectToRect(RectF paramAnonymousRectF1, RectF paramAnonymousRectF2, Matrix.ScaleToFit paramAnonymousScaleToFit)
      {
        AppMethodBeat.i(201548);
        LQ();
        AppMethodBeat.o(201548);
        return false;
      }
      
      public final void setRotate(float paramAnonymousFloat)
      {
        AppMethodBeat.i(201396);
        LQ();
        AppMethodBeat.o(201396);
      }
      
      public final void setRotate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
      {
        AppMethodBeat.i(201388);
        LQ();
        AppMethodBeat.o(201388);
      }
      
      public final void setScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(201383);
        LQ();
        AppMethodBeat.o(201383);
      }
      
      public final void setScale(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(201375);
        LQ();
        AppMethodBeat.o(201375);
      }
      
      public final void setSinCos(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(201408);
        LQ();
        AppMethodBeat.o(201408);
      }
      
      public final void setSinCos(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(201403);
        LQ();
        AppMethodBeat.o(201403);
      }
      
      public final void setSkew(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(201420);
        LQ();
        AppMethodBeat.o(201420);
      }
      
      public final void setSkew(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(201414);
        LQ();
        AppMethodBeat.o(201414);
      }
      
      public final void setTranslate(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(201370);
        LQ();
        AppMethodBeat.o(201370);
      }
      
      public final void setValues(float[] paramAnonymousArrayOfFloat)
      {
        AppMethodBeat.i(201562);
        LQ();
        AppMethodBeat.o(201562);
      }
    };
    AppMethodBeat.o(201533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.transition.i
 * JD-Core Version:    0.7.0.1
 */