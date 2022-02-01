package androidx.compose.ui.e.c;

import androidx.compose.ui.d.h;
import androidx.compose.ui.d.k;
import androidx.compose.ui.d.l;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.am;
import androidx.compose.ui.e.b.d;
import androidx.compose.ui.e.i;
import androidx.compose.ui.n.n;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/painter/Painter;", "", "()V", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "drawLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "useLayer", "", "applyAlpha", "applyColorFilter", "applyLayoutDirection", "configureAlpha", "configureColorFilter", "configureLayoutDirection", "rtl", "obtainPaint", "draw", "size", "draw-x_KDEd0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/ui/graphics/ColorFilter;)V", "onDraw", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
{
  private am aAE;
  private boolean aAF;
  private final b<androidx.compose.ui.e.b.e, ah> aAG = (b)new a(this);
  private n agm = n.beP;
  private float alpha = 1.0F;
  private aa auz;
  
  private final am uN()
  {
    am localam2 = this.aAE;
    am localam1 = localam2;
    if (localam2 == null)
    {
      localam1 = i.sN();
      this.aAE = localam1;
    }
    return localam1;
  }
  
  protected boolean S(float paramFloat)
  {
    return false;
  }
  
  public final void a(androidx.compose.ui.e.b.e parame, long paramLong, float paramFloat, aa paramaa)
  {
    s.u(parame, "$receiver");
    int i;
    label43:
    Object localObject;
    label73:
    float f1;
    label129:
    float f2;
    am localam;
    if (this.alpha == paramFloat)
    {
      i = 1;
      if (i == 0)
      {
        if (!S(paramFloat))
        {
          if (paramFloat != 1.0F) {
            break label350;
          }
          i = 1;
          if (i == 0) {
            break label356;
          }
          localObject = this.aAE;
          if (localObject != null) {
            ((am)localObject).setAlpha(paramFloat);
          }
          this.aAF = false;
        }
        this.alpha = paramFloat;
      }
      if (!s.p(this.auz, paramaa))
      {
        if (!c(paramaa))
        {
          if (paramaa != null) {
            break label375;
          }
          localObject = this.aAE;
          if (localObject != null) {
            ((am)localObject).b(null);
          }
          this.aAF = false;
        }
        this.auz = paramaa;
      }
      paramaa = parame.getLayoutDirection();
      if (this.agm != paramaa)
      {
        c(paramaa);
        this.agm = paramaa;
      }
      f1 = k.Q(parame.sf()) - k.Q(paramLong);
      f2 = k.R(parame.sf()) - k.R(paramLong);
      parame.uG().uI().d(0.0F, 0.0F, f1, f2);
      if ((paramFloat > 0.0F) && (k.Q(paramLong) > 0.0F) && (k.R(paramLong) > 0.0F))
      {
        if (!this.aAF) {
          break label404;
        }
        paramaa = androidx.compose.ui.d.e.avo;
        localObject = h.h(androidx.compose.ui.d.e.su(), l.z(k.Q(paramLong), k.R(paramLong)));
        paramaa = parame.uG().uH();
        localam = uN();
      }
    }
    for (;;)
    {
      label404:
      try
      {
        paramaa.a((androidx.compose.ui.d.g)localObject, localam);
        b(parame);
        paramaa.restore();
        return;
      }
      finally
      {
        label350:
        label356:
        label375:
        paramaa.restore();
      }
      i = 0;
      break;
      i = 0;
      break label43;
      uN().setAlpha(paramFloat);
      this.aAF = true;
      break label73;
      uN().b(paramaa);
      this.aAF = true;
      break label129;
    }
  }
  
  protected abstract void b(androidx.compose.ui.e.b.e parame);
  
  protected boolean c(aa paramaa)
  {
    return false;
  }
  
  protected boolean c(n paramn)
  {
    s.u(paramn, "layoutDirection");
    return false;
  }
  
  public abstract long uM();
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements b<androidx.compose.ui.e.b.e, ah>
  {
    a(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.c.c
 * JD-Core Version:    0.7.0.1
 */