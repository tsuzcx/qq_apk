package com.tencent.mm.aj.a;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import androidx.compose.ui.d.l;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.u;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.h.a;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/painter/DrawablePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "applyAlpha", "", "alpha", "", "applyColorFilter", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "applyLayoutDirection", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b
  extends androidx.compose.ui.e.c.c
{
  private final Drawable drawable;
  
  public b(Drawable paramDrawable)
  {
    AppMethodBeat.i(238720);
    this.drawable = paramDrawable;
    this.drawable.setBounds(0, 0, this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
    AppMethodBeat.o(238720);
  }
  
  public final boolean S(float paramFloat)
  {
    AppMethodBeat.i(238742);
    this.drawable.setAlpha(kotlin.k.k.bQ(a.eH(255.0F * paramFloat), 0, 255));
    AppMethodBeat.o(238742);
    return true;
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(238735);
    s.u(parame, "<this>");
    u localu = parame.uG().uH();
    this.drawable.setBounds(0, 0, a.eH(androidx.compose.ui.d.k.Q(parame.sf())), a.eH(androidx.compose.ui.d.k.R(parame.sf())));
    try
    {
      localu.sz();
      this.drawable.draw(androidx.compose.ui.e.c.a(localu));
      return;
    }
    finally
    {
      localu.restore();
      AppMethodBeat.o(238735);
    }
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(238750);
    Drawable localDrawable = this.drawable;
    if (paramaa == null) {}
    for (paramaa = null;; paramaa = androidx.compose.ui.e.d.a(paramaa))
    {
      localDrawable.setColorFilter(paramaa);
      AppMethodBeat.o(238750);
      return true;
    }
  }
  
  public final boolean c(n paramn)
  {
    int i = 0;
    AppMethodBeat.i(238759);
    s.u(paramn, "layoutDirection");
    if (Build.VERSION.SDK_INT >= 23)
    {
      Drawable localDrawable = this.drawable;
      switch (a.$EnumSwitchMapping$0[paramn.ordinal()])
      {
      default: 
        paramn = new p();
        AppMethodBeat.o(238759);
        throw paramn;
      case 2: 
        i = 1;
      }
      boolean bool = localDrawable.setLayoutDirection(i);
      AppMethodBeat.o(238759);
      return bool;
    }
    AppMethodBeat.o(238759);
    return false;
  }
  
  public final long uM()
  {
    AppMethodBeat.i(238726);
    long l = l.z(this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
    AppMethodBeat.o(238726);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.a.b
 * JD-Core Version:    0.7.0.1
 */