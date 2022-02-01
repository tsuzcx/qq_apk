package androidx.compose.ui.e.b;

import androidx.compose.ui.d.k;
import androidx.compose.ui.d.l;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.u;
import androidx.compose.ui.n.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"DefaultDensity", "Landroidx/compose/ui/unit/Density;", "asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final androidx.compose.ui.n.d aAp;
  
  static
  {
    AppMethodBeat.i(206077);
    aAp = f.H(1.0F, 1.0F);
    AppMethodBeat.o(206077);
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/graphics/drawscope/CanvasDrawScopeKt$asDrawTransform$1", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "inset", "rotate", "degrees", "pivot", "rotate-Uv8p0NA", "(FJ)V", "scale", "scaleX", "scaleY", "scale-0AR0LA0", "(FFJ)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "translate", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    a(d paramd) {}
    
    private long sf()
    {
      AppMethodBeat.i(206050);
      long l = this.aAq.sf();
      AppMethodBeat.o(206050);
      return l;
    }
    
    public final void A(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(206076);
      this.aAq.uH().A(paramFloat1, paramFloat2);
      AppMethodBeat.o(206076);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
    {
      AppMethodBeat.i(206061);
      this.aAq.uH().a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt);
      AppMethodBeat.o(206061);
    }
    
    public final void a(ao paramao, int paramInt)
    {
      AppMethodBeat.i(206069);
      s.u(paramao, "path");
      this.aAq.uH().a(paramao, paramInt);
      AppMethodBeat.o(206069);
    }
    
    public final void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(206057);
      Object localObject = this.aAq.uH();
      d locald = this.aAq;
      long l = l.z(k.Q(sf()) - (paramFloat1 + paramFloat3), k.R(sf()) - (paramFloat2 + paramFloat4));
      if ((k.Q(l) >= 0.0F) && (k.R(l) >= 0.0F)) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = (Throwable)new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
        AppMethodBeat.o(206057);
        throw ((Throwable)localObject);
      }
      locald.ao(l);
      ((u)localObject).A(paramFloat1, paramFloat2);
      AppMethodBeat.o(206057);
    }
    
    public final void k(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(206083);
      s.u(paramArrayOfFloat, "matrix");
      this.aAq.uH().c(paramArrayOfFloat);
      AppMethodBeat.o(206083);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.b.b
 * JD-Core Version:    0.7.0.1
 */