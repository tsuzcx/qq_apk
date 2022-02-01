package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.e.aj;
import androidx.compose.ui.e.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/RenderNodeMatrixCache;", "", "()V", "inverseMatrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "isDirty", "", "isInverseDirty", "matrixCache", "newAndroidMatrixCache", "Landroid/graphics/Matrix;", "newInverseAndroidMatrixCache", "oldAndroidMatrixCache", "oldInverseAndroidMatrixCache", "getInverseMatrix", "renderNode", "Landroidx/compose/ui/platform/DeviceRenderNode;", "getInverseMatrix-GrdbGEg", "(Landroidx/compose/ui/platform/DeviceRenderNode;)[F", "getMatrix", "getMatrix-GrdbGEg", "invalidate", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ak
{
  private boolean aCf = true;
  private Matrix aUT;
  private Matrix aUU;
  private float[] aUV;
  private Matrix aUW;
  private Matrix aUX;
  private float[] aUY;
  private boolean aUZ = true;
  
  public final float[] a(v paramv)
  {
    AppMethodBeat.i(206744);
    s.u(paramv, "renderNode");
    Object localObject2 = this.aUV;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = aj.tF();
      this.aUV = ((float[])localObject1);
    }
    if (!this.aCf)
    {
      AppMethodBeat.o(206744);
      return localObject1;
    }
    Matrix localMatrix = this.aUU;
    localObject2 = localMatrix;
    if (localMatrix == null)
    {
      localObject2 = new Matrix();
      this.aUU = ((Matrix)localObject2);
    }
    paramv.a((Matrix)localObject2);
    if (!s.p(this.aUT, localObject2))
    {
      g.a((float[])localObject1, (Matrix)localObject2);
      if (this.aUT != null) {
        break label126;
      }
      this.aUT = new Matrix((Matrix)localObject2);
    }
    for (;;)
    {
      this.aCf = false;
      AppMethodBeat.o(206744);
      return localObject1;
      label126:
      paramv = this.aUT;
      s.checkNotNull(paramv);
      paramv.set((Matrix)localObject2);
    }
  }
  
  public final float[] b(v paramv)
  {
    AppMethodBeat.i(206749);
    s.u(paramv, "renderNode");
    Object localObject2 = this.aUY;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = aj.tF();
      this.aUY = ((float[])localObject1);
    }
    if (!this.aUZ)
    {
      AppMethodBeat.o(206749);
      return localObject1;
    }
    Matrix localMatrix = this.aUX;
    localObject2 = localMatrix;
    if (localMatrix == null)
    {
      localObject2 = new Matrix();
      this.aUX = ((Matrix)localObject2);
    }
    paramv.b((Matrix)localObject2);
    if (!s.p(this.aUW, localObject2))
    {
      g.a((float[])localObject1, (Matrix)localObject2);
      if (this.aUW != null) {
        break label126;
      }
      this.aUW = new Matrix((Matrix)localObject2);
    }
    for (;;)
    {
      this.aUZ = false;
      AppMethodBeat.o(206749);
      return localObject1;
      label126:
      paramv = this.aUW;
      s.checkNotNull(paramv);
      paramv.set((Matrix)localObject2);
    }
  }
  
  public final void invalidate()
  {
    this.aCf = true;
    this.aUZ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.ak
 * JD-Core Version:    0.7.0.1
 */