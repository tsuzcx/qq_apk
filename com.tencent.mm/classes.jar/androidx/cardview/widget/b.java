package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  implements e
{
  private static f j(d paramd)
  {
    AppMethodBeat.i(192430);
    paramd = (f)paramd.le();
    AppMethodBeat.o(192430);
    return paramd;
  }
  
  public final float a(d paramd)
  {
    AppMethodBeat.i(192469);
    float f = j(paramd).Rl;
    AppMethodBeat.o(192469);
    return f;
  }
  
  public final void a(d paramd, float paramFloat)
  {
    AppMethodBeat.i(192448);
    paramd = j(paramd);
    if (paramFloat != paramd.Ri)
    {
      paramd.Ri = paramFloat;
      paramd.g(null);
      paramd.invalidateSelf();
    }
    AppMethodBeat.o(192448);
  }
  
  public final void a(d paramd, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(192439);
    paramd.k(new f(paramColorStateList, paramFloat1));
    paramContext = paramd.lf();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    b(paramd, paramFloat3);
    AppMethodBeat.o(192439);
  }
  
  public final void a(d paramd, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(192568);
    paramd = j(paramd);
    paramd.b(paramColorStateList);
    paramd.invalidateSelf();
    AppMethodBeat.o(192568);
  }
  
  public final float b(d paramd)
  {
    AppMethodBeat.i(192501);
    float f = j(paramd).Ri;
    AppMethodBeat.o(192501);
    return f * 2.0F;
  }
  
  public final void b(d paramd, float paramFloat)
  {
    AppMethodBeat.i(192460);
    j(paramd).a(paramFloat, paramd.getUseCompatPadding(), paramd.getPreventCornerOverlap());
    f(paramd);
    AppMethodBeat.o(192460);
  }
  
  public final float c(d paramd)
  {
    AppMethodBeat.i(192489);
    float f = j(paramd).Ri;
    AppMethodBeat.o(192489);
    return f * 2.0F;
  }
  
  public final void c(d paramd, float paramFloat)
  {
    AppMethodBeat.i(192511);
    paramd.lf().setElevation(paramFloat);
    AppMethodBeat.o(192511);
  }
  
  public final float d(d paramd)
  {
    AppMethodBeat.i(369494);
    float f = j(paramd).Ri;
    AppMethodBeat.o(369494);
    return f;
  }
  
  public final float e(d paramd)
  {
    AppMethodBeat.i(192522);
    float f = paramd.lf().getElevation();
    AppMethodBeat.o(192522);
    return f;
  }
  
  public final void f(d paramd)
  {
    AppMethodBeat.i(192532);
    if (!paramd.getUseCompatPadding())
    {
      paramd.e(0, 0, 0, 0);
      AppMethodBeat.o(192532);
      return;
    }
    float f1 = j(paramd).Rl;
    float f2 = j(paramd).Ri;
    int i = (int)Math.ceil(g.e(f1, f2, paramd.getPreventCornerOverlap()));
    int j = (int)Math.ceil(g.d(f1, f2, paramd.getPreventCornerOverlap()));
    paramd.e(i, j, i, j);
    AppMethodBeat.o(192532);
  }
  
  public final void g(d paramd)
  {
    AppMethodBeat.i(192544);
    b(paramd, j(paramd).Rl);
    AppMethodBeat.o(192544);
  }
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(192556);
    b(paramd, j(paramd).Rl);
    AppMethodBeat.o(192556);
  }
  
  public final ColorStateList i(d paramd)
  {
    AppMethodBeat.i(192579);
    paramd = j(paramd).Ro;
    AppMethodBeat.o(192579);
    return paramd;
  }
  
  public final void initStatic() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.cardview.widget.b
 * JD-Core Version:    0.7.0.1
 */