package com.google.a.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.compose.runtime.an;
import androidx.compose.runtime.az;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.ui.d.l;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/google/accompanist/drawablepainter/DrawablePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "getCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "callback$delegate", "Lkotlin/Lazy;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "<set-?>", "", "invalidateTick", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "applyAlpha", "", "alpha", "", "applyColorFilter", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "applyLayoutDirection", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "onAbandoned", "", "onForgotten", "onRemembered", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawablepainter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends androidx.compose.ui.e.c.c
  implements az
{
  public static final int Ue = 8;
  private final an ajX;
  private final j cEV;
  private final Drawable drawable;
  
  public a(Drawable paramDrawable)
  {
    AppMethodBeat.i(208593);
    this.drawable = paramDrawable;
    this.ajX = bj.T(Integer.valueOf(0));
    this.cEV = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.drawable.setBounds(0, 0, this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
    AppMethodBeat.o(208593);
  }
  
  private final int Qk()
  {
    AppMethodBeat.i(208600);
    int i = ((Number)((bm)this.ajX).getValue()).intValue();
    AppMethodBeat.o(208600);
    return i;
  }
  
  public final boolean S(float paramFloat)
  {
    AppMethodBeat.i(208630);
    this.drawable.setAlpha(kotlin.k.k.bQ(kotlin.h.a.eH(255.0F * paramFloat), 0, 255));
    AppMethodBeat.o(208630);
    return true;
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(208640);
    s.u(parame, "<this>");
    androidx.compose.ui.e.u localu = parame.uG().uH();
    Qk();
    this.drawable.setBounds(0, 0, kotlin.h.a.eH(androidx.compose.ui.d.k.Q(parame.sf())), kotlin.h.a.eH(androidx.compose.ui.d.k.R(parame.sf())));
    try
    {
      localu.sz();
      this.drawable.draw(androidx.compose.ui.e.c.a(localu));
      return;
    }
    finally
    {
      localu.restore();
      AppMethodBeat.o(208640);
    }
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(208633);
    Drawable localDrawable = this.drawable;
    if (paramaa == null) {}
    for (paramaa = null;; paramaa = androidx.compose.ui.e.d.a(paramaa))
    {
      localDrawable.setColorFilter(paramaa);
      AppMethodBeat.o(208633);
      return true;
    }
  }
  
  public final boolean c(n paramn)
  {
    int i = 0;
    AppMethodBeat.i(208636);
    s.u(paramn, "layoutDirection");
    if (Build.VERSION.SDK_INT >= 23)
    {
      Drawable localDrawable = this.drawable;
      switch (a.$EnumSwitchMapping$0[paramn.ordinal()])
      {
      default: 
        paramn = new p();
        AppMethodBeat.o(208636);
        throw paramn;
      case 2: 
        i = 1;
      }
      boolean bool = localDrawable.setLayoutDirection(i);
      AppMethodBeat.o(208636);
      return bool;
    }
    AppMethodBeat.o(208636);
    return false;
  }
  
  public final void mJ()
  {
    AppMethodBeat.i(208617);
    this.drawable.setCallback((Drawable.Callback)this.cEV.getValue());
    this.drawable.setVisible(true, true);
    if ((this.drawable instanceof Animatable)) {
      ((Animatable)this.drawable).start();
    }
    AppMethodBeat.o(208617);
  }
  
  public final void mK()
  {
    AppMethodBeat.i(208624);
    if ((this.drawable instanceof Animatable)) {
      ((Animatable)this.drawable).stop();
    }
    this.drawable.setVisible(false, false);
    this.drawable.setCallback(null);
    AppMethodBeat.o(208624);
  }
  
  public final void mL()
  {
    AppMethodBeat.i(208619);
    mK();
    AppMethodBeat.o(208619);
  }
  
  public final long uM()
  {
    AppMethodBeat.i(208637);
    long l = l.z(this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
    AppMethodBeat.o(208637);
    return l;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/google/accompanist/drawablepainter/DrawablePainter$callback$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<1>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.a.a.a
 * JD-Core Version:    0.7.0.1
 */