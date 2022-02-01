package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class v$a
  implements TypeEvaluator<Matrix>
{
  final Matrix bpU;
  final float[] che;
  final float[] chf;
  
  v$a()
  {
    AppMethodBeat.i(201327);
    this.che = new float[9];
    this.chf = new float[9];
    this.bpU = new Matrix();
    AppMethodBeat.o(201327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.transition.v.a
 * JD-Core Version:    0.7.0.1
 */