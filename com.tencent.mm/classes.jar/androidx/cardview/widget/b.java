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
    AppMethodBeat.i(188152);
    paramd = (f)paramd.eV();
    AppMethodBeat.o(188152);
    return paramd;
  }
  
  public final float a(d paramd)
  {
    AppMethodBeat.i(188131);
    float f = j(paramd).yW;
    AppMethodBeat.o(188131);
    return f;
  }
  
  public final void a(d paramd, float paramFloat)
  {
    AppMethodBeat.i(188128);
    paramd = j(paramd);
    if (paramFloat != paramd.yT)
    {
      paramd.yT = paramFloat;
      paramd.c(null);
      paramd.invalidateSelf();
    }
    AppMethodBeat.o(188128);
  }
  
  public final void a(d paramd, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(188126);
    paramd.j(new f(paramColorStateList, paramFloat1));
    paramContext = paramd.eW();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    b(paramd, paramFloat3);
    AppMethodBeat.o(188126);
  }
  
  public final void a(d paramd, ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(188146);
    paramd = j(paramd);
    paramd.b(paramColorStateList);
    paramd.invalidateSelf();
    AppMethodBeat.o(188146);
  }
  
  public final float b(d paramd)
  {
    AppMethodBeat.i(292430);
    float f = j(paramd).yT;
    AppMethodBeat.o(292430);
    return f * 2.0F;
  }
  
  public final void b(d paramd, float paramFloat)
  {
    AppMethodBeat.i(188130);
    j(paramd).a(paramFloat, paramd.getUseCompatPadding(), paramd.getPreventCornerOverlap());
    f(paramd);
    AppMethodBeat.o(188130);
  }
  
  public final float c(d paramd)
  {
    AppMethodBeat.i(188134);
    float f = j(paramd).yT;
    AppMethodBeat.o(188134);
    return f * 2.0F;
  }
  
  public final void c(d paramd, float paramFloat)
  {
    AppMethodBeat.i(188137);
    paramd.eW().setElevation(paramFloat);
    AppMethodBeat.o(188137);
  }
  
  public final float d(d paramd)
  {
    AppMethodBeat.i(292716);
    float f = j(paramd).yT;
    AppMethodBeat.o(292716);
    return f;
  }
  
  public final float e(d paramd)
  {
    AppMethodBeat.i(188139);
    float f = paramd.eW().getElevation();
    AppMethodBeat.o(188139);
    return f;
  }
  
  public final void f(d paramd)
  {
    AppMethodBeat.i(188140);
    if (!paramd.getUseCompatPadding())
    {
      paramd.c(0, 0, 0, 0);
      AppMethodBeat.o(188140);
      return;
    }
    float f1 = j(paramd).yW;
    float f2 = j(paramd).yT;
    int i = (int)Math.ceil(g.b(f1, f2, paramd.getPreventCornerOverlap()));
    int j = (int)Math.ceil(g.a(f1, f2, paramd.getPreventCornerOverlap()));
    paramd.c(i, j, i, j);
    AppMethodBeat.o(188140);
  }
  
  public final void g(d paramd)
  {
    AppMethodBeat.i(188143);
    b(paramd, j(paramd).yW);
    AppMethodBeat.o(188143);
  }
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(188144);
    b(paramd, j(paramd).yW);
    AppMethodBeat.o(188144);
  }
  
  public final ColorStateList i(d paramd)
  {
    AppMethodBeat.i(188150);
    paramd = j(paramd).yZ;
    AppMethodBeat.o(188150);
    return paramd;
  }
  
  public final void initStatic() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.cardview.widget.b
 * JD-Core Version:    0.7.0.1
 */