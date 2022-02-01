package androidx.compose.ui.e;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"setFrom", "", "Landroid/graphics/Matrix;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "ui-graphics_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final void a(float[] paramArrayOfFloat, Matrix paramMatrix)
  {
    AppMethodBeat.i(205977);
    s.u(paramArrayOfFloat, "$this$setFrom");
    s.u(paramMatrix, "matrix");
    paramMatrix.getValues(paramArrayOfFloat);
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    float f5 = paramArrayOfFloat[4];
    float f6 = paramArrayOfFloat[5];
    float f7 = paramArrayOfFloat[6];
    float f8 = paramArrayOfFloat[7];
    float f9 = paramArrayOfFloat[8];
    paramArrayOfFloat[0] = f1;
    paramArrayOfFloat[1] = f4;
    paramArrayOfFloat[2] = 0.0F;
    paramArrayOfFloat[3] = f7;
    paramArrayOfFloat[4] = f2;
    paramArrayOfFloat[5] = f5;
    paramArrayOfFloat[6] = 0.0F;
    paramArrayOfFloat[7] = f8;
    paramArrayOfFloat[8] = 0.0F;
    paramArrayOfFloat[9] = 0.0F;
    paramArrayOfFloat[10] = 1.0F;
    paramArrayOfFloat[11] = 0.0F;
    paramArrayOfFloat[12] = f3;
    paramArrayOfFloat[13] = f6;
    paramArrayOfFloat[14] = 0.0F;
    paramArrayOfFloat[15] = f9;
    AppMethodBeat.o(205977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.g
 * JD-Core Version:    0.7.0.1
 */