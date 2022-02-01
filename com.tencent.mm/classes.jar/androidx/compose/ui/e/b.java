package androidx.compose.ui.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Region.Op;
import androidx.compose.ui.d.e;
import androidx.compose.ui.d.g;
import androidx.compose.ui.n.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "()V", "dstRect", "Landroid/graphics/Rect;", "getDstRect", "()Landroid/graphics/Rect;", "dstRect$delegate", "Lkotlin/Lazy;", "internalCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "getSrcRect", "srcRect$delegate", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawLines", "points", "", "stepBy", "", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "", "drawRawPoints", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "scale", "sx", "sy", "skew", "translate", "dx", "dy", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements u
{
  public Canvas avB;
  private final kotlin.j avC;
  private final kotlin.j avD;
  
  public b()
  {
    AppMethodBeat.i(206023);
    this.avB = c.sC();
    this.avC = k.a(o.aiuH, (a)b.b.avF);
    this.avD = k.a(o.aiuH, (a)b.a.avE);
    AppMethodBeat.o(206023);
  }
  
  private static Region.Op cz(int paramInt)
  {
    AppMethodBeat.i(206028);
    Object localObject = y.awI;
    if (y.C(paramInt, y.tn()))
    {
      localObject = Region.Op.DIFFERENCE;
      AppMethodBeat.o(206028);
      return localObject;
    }
    localObject = Region.Op.INTERSECT;
    AppMethodBeat.o(206028);
    return localObject;
  }
  
  public final void A(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206055);
    this.avB.translate(paramFloat1, paramFloat2);
    AppMethodBeat.o(206055);
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, am paramam)
  {
    AppMethodBeat.i(206088);
    s.u(paramam, "paint");
    this.avB.drawRoundRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramam.sE());
    AppMethodBeat.o(206088);
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    AppMethodBeat.i(206067);
    this.avB.clipRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, cz(paramInt));
    AppMethodBeat.o(206067);
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, am paramam)
  {
    AppMethodBeat.i(206082);
    s.u(paramam, "paint");
    this.avB.drawRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramam.sE());
    AppMethodBeat.o(206082);
  }
  
  public final void a(long paramLong, float paramFloat, am paramam)
  {
    AppMethodBeat.i(206092);
    s.u(paramam, "paint");
    this.avB.drawCircle(e.F(paramLong), e.G(paramLong), paramFloat, paramam.sE());
    AppMethodBeat.o(206092);
  }
  
  public final void a(g paramg, int paramInt)
  {
    AppMethodBeat.i(206120);
    u.a.a(this, paramg, paramInt);
    AppMethodBeat.o(206120);
  }
  
  public final void a(g paramg, am paramam)
  {
    AppMethodBeat.i(206048);
    s.u(paramg, "bounds");
    s.u(paramam, "paint");
    this.avB.saveLayer(paramg.left, paramg.top, paramg.right, paramg.bottom, paramam.sE(), 31);
    AppMethodBeat.o(206048);
  }
  
  public final void a(af paramaf, long paramLong1, long paramLong2, long paramLong3, long paramLong4, am paramam)
  {
    AppMethodBeat.i(206106);
    s.u(paramaf, "image");
    s.u(paramam, "paint");
    Canvas localCanvas = this.avB;
    paramaf = f.b(paramaf);
    Rect localRect = (Rect)this.avC.getValue();
    localRect.left = androidx.compose.ui.n.j.bf(paramLong1);
    localRect.top = androidx.compose.ui.n.j.bg(paramLong1);
    localRect.right = (androidx.compose.ui.n.j.bf(paramLong1) + l.bi(paramLong2));
    localRect.bottom = (androidx.compose.ui.n.j.bg(paramLong1) + l.bj(paramLong2));
    Object localObject = ah.aiuX;
    localObject = (Rect)this.avD.getValue();
    ((Rect)localObject).left = androidx.compose.ui.n.j.bf(paramLong3);
    ((Rect)localObject).top = androidx.compose.ui.n.j.bg(paramLong3);
    ((Rect)localObject).right = (androidx.compose.ui.n.j.bf(paramLong3) + l.bi(paramLong4));
    ((Rect)localObject).bottom = (androidx.compose.ui.n.j.bg(paramLong3) + l.bj(paramLong4));
    ah localah = ah.aiuX;
    localCanvas.drawBitmap(paramaf, localRect, (Rect)localObject, paramam.sE());
    AppMethodBeat.o(206106);
  }
  
  public final void a(ao paramao, int paramInt)
  {
    AppMethodBeat.i(206074);
    s.u(paramao, "path");
    Canvas localCanvas = this.avB;
    if ((paramao instanceof j))
    {
      localCanvas.clipPath(((j)paramao).avN, cz(paramInt));
      AppMethodBeat.o(206074);
      return;
    }
    paramao = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    AppMethodBeat.o(206074);
    throw paramao;
  }
  
  public final void a(ao paramao, am paramam)
  {
    AppMethodBeat.i(206097);
    s.u(paramao, "path");
    s.u(paramam, "paint");
    Canvas localCanvas = this.avB;
    if ((paramao instanceof j))
    {
      localCanvas.drawPath(((j)paramao).avN, paramam.sE());
      AppMethodBeat.o(206097);
      return;
    }
    paramao = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    AppMethodBeat.o(206097);
    throw paramao;
  }
  
  public final void b(Canvas paramCanvas)
  {
    AppMethodBeat.i(206033);
    s.u(paramCanvas, "<set-?>");
    this.avB = paramCanvas;
    AppMethodBeat.o(206033);
  }
  
  public final void b(g paramg, am paramam)
  {
    AppMethodBeat.i(206125);
    u.a.a(this, paramg, paramam);
    AppMethodBeat.o(206125);
  }
  
  public final void c(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206062);
    s.u(paramArrayOfFloat, "matrix");
    s.u(paramArrayOfFloat, "$this$isIdentity");
    int i = 0;
    int k = i + 1;
    int m;
    label129:
    label514:
    for (int j = 0;; j = m)
    {
      m = j + 1;
      label64:
      label72:
      Matrix localMatrix;
      if (i == j)
      {
        f1 = 1.0F;
        if (paramArrayOfFloat[(j + i * 4)] != f1) {
          break label257;
        }
        j = 1;
        if (j != 0) {
          break label263;
        }
        i = 0;
        if (i != 0) {
          break label500;
        }
        localMatrix = new Matrix();
        s.u(localMatrix, "$this$setFrom");
        s.u(paramArrayOfFloat, "matrix");
        if (paramArrayOfFloat[2] != 0.0F) {
          break label281;
        }
        i = 1;
        label112:
        if (i == 0) {
          break label323;
        }
        if (paramArrayOfFloat[6] != 0.0F) {
          break label287;
        }
        i = 1;
        if (i == 0) {
          break label323;
        }
        if (paramArrayOfFloat[10] != 1.0F) {
          break label293;
        }
        i = 1;
        label146:
        if (i == 0) {
          break label323;
        }
        if (paramArrayOfFloat[14] != 0.0F) {
          break label299;
        }
        i = 1;
        label163:
        if (i == 0) {
          break label323;
        }
        if (paramArrayOfFloat[8] != 0.0F) {
          break label305;
        }
        i = 1;
        label180:
        if (i == 0) {
          break label323;
        }
        if (paramArrayOfFloat[9] != 0.0F) {
          break label311;
        }
        i = 1;
        label197:
        if (i == 0) {
          break label323;
        }
        if (paramArrayOfFloat[11] != 0.0F) {
          break label317;
        }
        i = 1;
        label214:
        if (i == 0) {
          break label323;
        }
      }
      label263:
      label281:
      label287:
      label293:
      label299:
      label305:
      label311:
      label317:
      label323:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label329;
        }
        paramArrayOfFloat = (Throwable)new IllegalArgumentException("Android does not support arbitrary transforms".toString());
        AppMethodBeat.o(206062);
        throw paramArrayOfFloat;
        f1 = 0.0F;
        break;
        j = 0;
        break label64;
        if (m <= 3) {
          break label514;
        }
        if (k <= 3) {
          break label507;
        }
        i = 1;
        break label72;
        i = 0;
        break label112;
        i = 0;
        break label129;
        i = 0;
        break label146;
        i = 0;
        break label163;
        i = 0;
        break label180;
        i = 0;
        break label197;
        i = 0;
        break label214;
      }
      label329:
      float f1 = paramArrayOfFloat[0];
      float f2 = paramArrayOfFloat[1];
      float f3 = paramArrayOfFloat[2];
      float f4 = paramArrayOfFloat[3];
      float f5 = paramArrayOfFloat[4];
      float f6 = paramArrayOfFloat[5];
      float f7 = paramArrayOfFloat[6];
      float f8 = paramArrayOfFloat[7];
      float f9 = paramArrayOfFloat[8];
      float f10 = paramArrayOfFloat[12];
      float f11 = paramArrayOfFloat[13];
      float f12 = paramArrayOfFloat[15];
      paramArrayOfFloat[0] = f1;
      paramArrayOfFloat[1] = f5;
      paramArrayOfFloat[2] = f10;
      paramArrayOfFloat[3] = f2;
      paramArrayOfFloat[4] = f6;
      paramArrayOfFloat[5] = f11;
      paramArrayOfFloat[6] = f4;
      paramArrayOfFloat[7] = f8;
      paramArrayOfFloat[8] = f12;
      localMatrix.setValues(paramArrayOfFloat);
      paramArrayOfFloat[0] = f1;
      paramArrayOfFloat[1] = f2;
      paramArrayOfFloat[2] = f3;
      paramArrayOfFloat[3] = f4;
      paramArrayOfFloat[4] = f5;
      paramArrayOfFloat[5] = f6;
      paramArrayOfFloat[6] = f7;
      paramArrayOfFloat[7] = f8;
      paramArrayOfFloat[8] = f9;
      this.avB.concat(localMatrix);
      label500:
      AppMethodBeat.o(206062);
      return;
      label507:
      i = k;
      break;
    }
  }
  
  public final void restore()
  {
    AppMethodBeat.i(206045);
    this.avB.restore();
    AppMethodBeat.o(206045);
  }
  
  public final void sA()
  {
    AppMethodBeat.i(206113);
    w localw = w.awD;
    w.a(this.avB, true);
    AppMethodBeat.o(206113);
  }
  
  public final void sB()
  {
    AppMethodBeat.i(206116);
    w localw = w.awD;
    w.a(this.avB, false);
    AppMethodBeat.o(206116);
  }
  
  public final void sz()
  {
    AppMethodBeat.i(206039);
    this.avB.save();
    AppMethodBeat.o(206039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.b
 * JD-Core Version:    0.7.0.1
 */