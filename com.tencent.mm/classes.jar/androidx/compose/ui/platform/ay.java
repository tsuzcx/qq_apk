package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import androidx.compose.ui.e.aj;
import androidx.compose.ui.e.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ViewLayerMatrixCache;", "", "()V", "androidMatrixCache", "Landroid/graphics/Matrix;", "inverseAndroidMatrixCache", "inverseMatrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "isDirty", "", "isInverseDirty", "matrixCache", "getInverseMatrix", "view", "Landroid/view/View;", "getInverseMatrix-GrdbGEg", "(Landroid/view/View;)[F", "getMatrix", "getMatrix-GrdbGEg", "invalidate", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ay
{
  private boolean aCf = true;
  private float[] aUV;
  private float[] aUY;
  private boolean aUZ = true;
  private Matrix aVD;
  private Matrix aVE;
  
  public final void invalidate()
  {
    this.aCf = true;
    this.aUZ = true;
  }
  
  public final float[] v(View paramView)
  {
    AppMethodBeat.i(206892);
    s.u(paramView, "view");
    Object localObject2 = this.aUV;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = aj.tF();
      this.aUV = ((float[])localObject1);
    }
    if (!this.aCf)
    {
      AppMethodBeat.o(206892);
      return localObject1;
    }
    paramView = paramView.getMatrix();
    if (!s.p(this.aVD, paramView))
    {
      s.s(paramView, "new");
      g.a((float[])localObject1, paramView);
      if (this.aVD != null) {
        break label103;
      }
      this.aVD = new Matrix(paramView);
    }
    for (;;)
    {
      this.aCf = false;
      AppMethodBeat.o(206892);
      return localObject1;
      label103:
      localObject2 = this.aVD;
      s.checkNotNull(localObject2);
      ((Matrix)localObject2).set(paramView);
    }
  }
  
  public final float[] w(View paramView)
  {
    AppMethodBeat.i(206898);
    s.u(paramView, "view");
    Object localObject2 = this.aUY;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = aj.tF();
      this.aUY = ((float[])localObject1);
    }
    if (!this.aUZ)
    {
      AppMethodBeat.o(206898);
      return localObject1;
    }
    paramView = paramView.getMatrix();
    if (!s.p(this.aVE, paramView))
    {
      s.s(paramView, "new");
      g.a((float[])localObject1, paramView);
      aj.d((float[])localObject1);
      if (this.aVE != null) {
        break label107;
      }
      this.aVE = new Matrix(paramView);
    }
    for (;;)
    {
      this.aUZ = false;
      AppMethodBeat.o(206898);
      return localObject1;
      label107:
      localObject2 = this.aVE;
      s.checkNotNull(localObject2);
      ((Matrix)localObject2).set(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.ay
 * JD-Core Version:    0.7.0.1
 */