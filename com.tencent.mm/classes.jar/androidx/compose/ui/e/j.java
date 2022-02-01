package androidx.compose.ui.e;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Path.Op;
import android.graphics.RectF;
import androidx.compose.ui.d.a;
import androidx.compose.ui.d.e;
import androidx.compose.ui.d.g;
import androidx.compose.ui.d.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/AndroidPath;", "Landroidx/compose/ui/graphics/Path;", "internalPath", "Landroid/graphics/Path;", "(Landroid/graphics/Path;)V", "value", "Landroidx/compose/ui/graphics/PathFillType;", "fillType", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "getInternalPath", "()Landroid/graphics/Path;", "isConvex", "", "isConvex$annotations", "()V", "()Z", "isEmpty", "mMatrix", "Landroid/graphics/Matrix;", "radii", "", "rectF", "Landroid/graphics/RectF;", "_rectIsValid", "rect", "Landroidx/compose/ui/geometry/Rect;", "addArc", "", "oval", "startAngleDegrees", "", "sweepAngleDegrees", "addArcRad", "startAngleRadians", "sweepAngleRadians", "addOval", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "addRect", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "arcTo", "forceMoveTo", "close", "cubicTo", "x1", "y1", "x2", "y2", "x3", "y3", "getBounds", "lineTo", "x", "y", "moveTo", "op", "path1", "path2", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "quadraticBezierTo", "relativeCubicTo", "dx1", "dy1", "dx2", "dy2", "dx3", "dy3", "relativeLineTo", "dx", "dy", "relativeMoveTo", "relativeQuadraticBezierTo", "reset", "translate", "translate-k-4lQ0M", "(J)V", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements ao
{
  public final Path avN;
  private final RectF avO;
  private final float[] avP;
  private final Matrix avQ;
  
  private j(Path paramPath)
  {
    AppMethodBeat.i(206013);
    this.avN = paramPath;
    this.avO = new RectF();
    this.avP = new float[8];
    this.avQ = new Matrix();
    AppMethodBeat.o(206013);
  }
  
  public final void B(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206034);
    this.avN.moveTo(paramFloat1, paramFloat2);
    AppMethodBeat.o(206034);
  }
  
  public final void C(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206042);
    this.avN.rMoveTo(paramFloat1, paramFloat2);
    AppMethodBeat.o(206042);
  }
  
  public final void D(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206046);
    this.avN.lineTo(paramFloat1, paramFloat2);
    AppMethodBeat.o(206046);
  }
  
  public final void E(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206053);
    this.avN.rLineTo(paramFloat1, paramFloat2);
    AppMethodBeat.o(206053);
  }
  
  public final void a(ao paramao, long paramLong)
  {
    AppMethodBeat.i(206114);
    s.u(paramao, "path");
    Path localPath = this.avN;
    if ((paramao instanceof j))
    {
      localPath.addPath(((j)paramao).avN, e.F(paramLong), e.G(paramLong));
      AppMethodBeat.o(206114);
      return;
    }
    paramao = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    AppMethodBeat.o(206114);
    throw paramao;
  }
  
  public final boolean a(ao paramao1, ao paramao2, int paramInt)
  {
    AppMethodBeat.i(206130);
    s.u(paramao1, "path1");
    s.u(paramao2, "path2");
    Object localObject = as.axY;
    if (as.C(paramInt, as.tn())) {
      localObject = Path.Op.DIFFERENCE;
    }
    for (;;)
    {
      Path localPath = this.avN;
      if (!(paramao1 instanceof j)) {
        break;
      }
      paramao1 = ((j)paramao1).avN;
      if (!(paramao2 instanceof j)) {
        break label184;
      }
      boolean bool = localPath.op(paramao1, ((j)paramao2).avN, (Path.Op)localObject);
      AppMethodBeat.o(206130);
      return bool;
      localObject = as.axY;
      if (as.C(paramInt, as.tu()))
      {
        localObject = Path.Op.INTERSECT;
      }
      else
      {
        localObject = as.axY;
        if (as.C(paramInt, as.tL()))
        {
          localObject = Path.Op.REVERSE_DIFFERENCE;
        }
        else
        {
          localObject = as.axY;
          if (as.C(paramInt, as.tK())) {
            localObject = Path.Op.UNION;
          } else {
            localObject = Path.Op.XOR;
          }
        }
      }
    }
    paramao1 = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    AppMethodBeat.o(206130);
    throw paramao1;
    label184:
    paramao1 = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    AppMethodBeat.o(206130);
    throw paramao1;
  }
  
  public final void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(206058);
    this.avN.quadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    AppMethodBeat.o(206058);
  }
  
  public final void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    AppMethodBeat.i(206073);
    this.avN.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    AppMethodBeat.o(206073);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(206103);
    s.u(parami, "roundRect");
    this.avO.set(parami.left, parami.top, parami.right, parami.bottom);
    this.avP[0] = a.F(parami.avv);
    this.avP[1] = a.G(parami.avv);
    this.avP[2] = a.F(parami.avw);
    this.avP[3] = a.G(parami.avw);
    this.avP[4] = a.F(parami.avx);
    this.avP[5] = a.G(parami.avx);
    this.avP[6] = a.F(parami.avy);
    this.avP[7] = a.G(parami.avy);
    this.avN.addRoundRect(this.avO, this.avP, Path.Direction.CCW);
    AppMethodBeat.o(206103);
  }
  
  public final void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(206065);
    this.avN.rQuadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    AppMethodBeat.o(206065);
  }
  
  public final void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    AppMethodBeat.i(206081);
    this.avN.rCubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    AppMethodBeat.o(206081);
  }
  
  public final void c(g paramg)
  {
    int j = 1;
    AppMethodBeat.i(206094);
    s.u(paramg, "rect");
    if (!Float.isNaN(paramg.left)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalStateException("Rect.left is NaN".toString());
      AppMethodBeat.o(206094);
      throw paramg;
    }
    if (!Float.isNaN(paramg.top)) {}
    for (i = 1; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalStateException("Rect.top is NaN".toString());
      AppMethodBeat.o(206094);
      throw paramg;
    }
    if (!Float.isNaN(paramg.right)) {}
    for (i = 1; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalStateException("Rect.right is NaN".toString());
      AppMethodBeat.o(206094);
      throw paramg;
    }
    if (!Float.isNaN(paramg.bottom)) {}
    for (i = j; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalStateException("Rect.bottom is NaN".toString());
      AppMethodBeat.o(206094);
      throw paramg;
    }
    RectF localRectF = this.avO;
    s.u(paramg, "<this>");
    localRectF.set(new RectF(paramg.left, paramg.top, paramg.right, paramg.bottom));
    this.avN.addRect(this.avO, Path.Direction.CCW);
    AppMethodBeat.o(206094);
  }
  
  public final void cF(int paramInt)
  {
    AppMethodBeat.i(206027);
    Path localPath = this.avN;
    Object localObject = aq.axV;
    if (aq.C(paramInt, aq.tJ())) {}
    for (localObject = Path.FillType.EVEN_ODD;; localObject = Path.FillType.WINDING)
    {
      localPath.setFillType((Path.FillType)localObject);
      AppMethodBeat.o(206027);
      return;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(206118);
    this.avN.close();
    AppMethodBeat.o(206118);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(206141);
    boolean bool = this.avN.isEmpty();
    AppMethodBeat.o(206141);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(206123);
    this.avN.reset();
    AppMethodBeat.o(206123);
  }
  
  public final boolean sO()
  {
    AppMethodBeat.i(206136);
    boolean bool = this.avN.isConvex();
    AppMethodBeat.o(206136);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.j
 * JD-Core Version:    0.7.0.1
 */