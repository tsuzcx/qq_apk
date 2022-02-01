package androidx.compose.ui.e;

import android.graphics.Shader;
import androidx.compose.ui.d.k;
import androidx.compose.ui.d.k.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "()V", "createdSize", "Landroidx/compose/ui/geometry/Size;", "J", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "applyTo", "", "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "createShader", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class aw
  extends s
{
  private Shader avJ;
  private long ayl;
  
  public aw()
  {
    super((byte)0);
    k.a locala = k.avA;
    this.ayl = k.sw();
  }
  
  public abstract Shader X(long paramLong);
  
  public final void a(long paramLong, am paramam, float paramFloat)
  {
    kotlin.g.b.s.u(paramam, "p");
    Shader localShader = this.avJ;
    if ((localShader == null) || (!k.e(this.ayl, paramLong)))
    {
      localShader = X(paramLong);
      this.avJ = localShader;
      this.ayl = paramLong;
    }
    paramLong = paramam.sF();
    z.a locala = z.awK;
    if (!z.e(paramLong, z.tv()))
    {
      locala = z.awK;
      paramam.W(z.tv());
    }
    if (!kotlin.g.b.s.p(paramam.sK(), localShader)) {
      paramam.a(localShader);
    }
    if (paramam.getAlpha() == paramFloat) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramam.setAlpha(paramFloat);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.aw
 * JD-Core Version:    0.7.0.1
 */