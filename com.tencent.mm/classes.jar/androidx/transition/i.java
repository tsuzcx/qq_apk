package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
{
  static final Matrix aqQ;
  
  static
  {
    AppMethodBeat.i(192415);
    aqQ = new Matrix()
    {
      private static void nn()
      {
        AppMethodBeat.i(192344);
        IllegalStateException localIllegalStateException = new IllegalStateException("Matrix can not be modified");
        AppMethodBeat.o(192344);
        throw localIllegalStateException;
      }
      
      public final boolean postConcat(Matrix paramAnonymousMatrix)
      {
        AppMethodBeat.i(192407);
        nn();
        AppMethodBeat.o(192407);
        return false;
      }
      
      public final boolean postRotate(float paramAnonymousFloat)
      {
        AppMethodBeat.i(192400);
        nn();
        AppMethodBeat.o(192400);
        return false;
      }
      
      public final boolean postRotate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
      {
        AppMethodBeat.i(192399);
        nn();
        AppMethodBeat.o(192399);
        return false;
      }
      
      public final boolean postScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(192396);
        nn();
        AppMethodBeat.o(192396);
        return false;
      }
      
      public final boolean postScale(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(192394);
        nn();
        AppMethodBeat.o(192394);
        return false;
      }
      
      public final boolean postSkew(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(192406);
        nn();
        AppMethodBeat.o(192406);
        return false;
      }
      
      public final boolean postSkew(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(192403);
        nn();
        AppMethodBeat.o(192403);
        return false;
      }
      
      public final boolean postTranslate(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(192392);
        nn();
        AppMethodBeat.o(192392);
        return false;
      }
      
      public final boolean preConcat(Matrix paramAnonymousMatrix)
      {
        AppMethodBeat.i(192390);
        nn();
        AppMethodBeat.o(192390);
        return false;
      }
      
      public final boolean preRotate(float paramAnonymousFloat)
      {
        AppMethodBeat.i(192382);
        nn();
        AppMethodBeat.o(192382);
        return false;
      }
      
      public final boolean preRotate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
      {
        AppMethodBeat.i(192381);
        nn();
        AppMethodBeat.o(192381);
        return false;
      }
      
      public final boolean preScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(192377);
        nn();
        AppMethodBeat.o(192377);
        return false;
      }
      
      public final boolean preScale(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(192372);
        nn();
        AppMethodBeat.o(192372);
        return false;
      }
      
      public final boolean preSkew(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(192386);
        nn();
        AppMethodBeat.o(192386);
        return false;
      }
      
      public final boolean preSkew(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(192385);
        nn();
        AppMethodBeat.o(192385);
        return false;
      }
      
      public final boolean preTranslate(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(192371);
        nn();
        AppMethodBeat.o(192371);
        return false;
      }
      
      public final void reset()
      {
        AppMethodBeat.i(192348);
        nn();
        AppMethodBeat.o(192348);
      }
      
      public final void set(Matrix paramAnonymousMatrix)
      {
        AppMethodBeat.i(192346);
        nn();
        AppMethodBeat.o(192346);
      }
      
      public final boolean setConcat(Matrix paramAnonymousMatrix1, Matrix paramAnonymousMatrix2)
      {
        AppMethodBeat.i(192369);
        nn();
        AppMethodBeat.o(192369);
        return false;
      }
      
      public final boolean setPolyToPoly(float[] paramAnonymousArrayOfFloat1, int paramAnonymousInt1, float[] paramAnonymousArrayOfFloat2, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(192409);
        nn();
        AppMethodBeat.o(192409);
        return false;
      }
      
      public final boolean setRectToRect(RectF paramAnonymousRectF1, RectF paramAnonymousRectF2, Matrix.ScaleToFit paramAnonymousScaleToFit)
      {
        AppMethodBeat.i(192408);
        nn();
        AppMethodBeat.o(192408);
        return false;
      }
      
      public final void setRotate(float paramAnonymousFloat)
      {
        AppMethodBeat.i(192359);
        nn();
        AppMethodBeat.o(192359);
      }
      
      public final void setRotate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
      {
        AppMethodBeat.i(192356);
        nn();
        AppMethodBeat.o(192356);
      }
      
      public final void setScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(192354);
        nn();
        AppMethodBeat.o(192354);
      }
      
      public final void setScale(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(192353);
        nn();
        AppMethodBeat.o(192353);
      }
      
      public final void setSinCos(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(192363);
        nn();
        AppMethodBeat.o(192363);
      }
      
      public final void setSinCos(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(192360);
        nn();
        AppMethodBeat.o(192360);
      }
      
      public final void setSkew(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(192366);
        nn();
        AppMethodBeat.o(192366);
      }
      
      public final void setSkew(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
      {
        AppMethodBeat.i(192365);
        nn();
        AppMethodBeat.o(192365);
      }
      
      public final void setTranslate(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(192349);
        nn();
        AppMethodBeat.o(192349);
      }
      
      public final void setValues(float[] paramAnonymousArrayOfFloat)
      {
        AppMethodBeat.i(192410);
        nn();
        AppMethodBeat.o(192410);
      }
    };
    AppMethodBeat.o(192415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.transition.i
 * JD-Core Version:    0.7.0.1
 */