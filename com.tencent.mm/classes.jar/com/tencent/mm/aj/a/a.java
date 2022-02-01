package com.tencent.mm.aj.a;

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
import androidx.compose.ui.e.u;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/painter/AnimationPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "callback", "com/tencent/mm/mm_compose/painter/AnimationPainter$callback$1", "Lcom/tencent/mm/mm_compose/painter/AnimationPainter$callback$1;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "<set-?>", "", "invalidateTick", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "playing", "", "applyAlpha", "alpha", "", "applyColorFilter", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "applyLayoutDirection", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "onAbandoned", "", "onForgotten", "onRemembered", "play", "realStartPlay", "realStopPlay", "stop", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends androidx.compose.ui.e.c.c
  implements az
{
  public static final int Ue = 8;
  private final an ajX;
  private boolean cJs;
  private final Drawable drawable;
  private final b ogo;
  
  public a(Drawable paramDrawable)
  {
    AppMethodBeat.i(238729);
    this.drawable = paramDrawable;
    this.ajX = bj.T(Integer.valueOf(0));
    this.ogo = new b(this);
    this.drawable.setBounds(0, 0, this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
    AppMethodBeat.o(238729);
  }
  
  private final int Qk()
  {
    AppMethodBeat.i(238738);
    int i = ((Number)((bm)this.ajX).getValue()).intValue();
    AppMethodBeat.o(238738);
    return i;
  }
  
  public final boolean S(float paramFloat)
  {
    AppMethodBeat.i(238783);
    this.drawable.setAlpha(kotlin.k.k.bQ(kotlin.h.a.eH(255.0F * paramFloat), 0, 255));
    AppMethodBeat.o(238783);
    return true;
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(238765);
    s.u(parame, "<this>");
    u localu = parame.uG().uH();
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
      AppMethodBeat.o(238765);
    }
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(238790);
    Drawable localDrawable = this.drawable;
    if (paramaa == null) {}
    for (paramaa = null;; paramaa = androidx.compose.ui.e.d.a(paramaa))
    {
      localDrawable.setColorFilter(paramaa);
      AppMethodBeat.o(238790);
      return true;
    }
  }
  
  public final boolean c(n paramn)
  {
    int i = 0;
    AppMethodBeat.i(238797);
    s.u(paramn, "layoutDirection");
    if (Build.VERSION.SDK_INT >= 23)
    {
      Drawable localDrawable = this.drawable;
      switch (a.$EnumSwitchMapping$0[paramn.ordinal()])
      {
      default: 
        paramn = new p();
        AppMethodBeat.o(238797);
        throw paramn;
      case 2: 
        i = 1;
      }
      boolean bool = localDrawable.setLayoutDirection(i);
      AppMethodBeat.o(238797);
      return bool;
    }
    AppMethodBeat.o(238797);
    return false;
  }
  
  public final void mJ()
  {
    AppMethodBeat.i(238768);
    if (this.cJs)
    {
      this.drawable.setCallback((Drawable.Callback)this.ogo);
      this.drawable.setVisible(true, true);
      if ((this.drawable instanceof Animatable)) {
        ((Animatable)this.drawable).start();
      }
    }
    AppMethodBeat.o(238768);
  }
  
  public final void mK()
  {
    AppMethodBeat.i(238776);
    if (this.cJs)
    {
      if ((this.drawable instanceof Animatable)) {
        ((Animatable)this.drawable).stop();
      }
      this.drawable.setVisible(false, false);
      this.drawable.setCallback(null);
    }
    AppMethodBeat.o(238776);
  }
  
  public final void mL()
  {
    AppMethodBeat.i(238780);
    mK();
    AppMethodBeat.o(238780);
  }
  
  public final long uM()
  {
    AppMethodBeat.i(238762);
    long l = l.z(this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
    AppMethodBeat.o(238762);
    return l;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/mm_compose/painter/AnimationPainter$callback$1", "Landroid/graphics/drawable/Drawable$Callback;", "invalidateDrawable", "", "who", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "time", "", "unscheduleDrawable", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Drawable.Callback
  {
    b(a parama) {}
    
    public final void invalidateDrawable(Drawable paramDrawable)
    {
      AppMethodBeat.i(238740);
      s.u(paramDrawable, "who");
      paramDrawable = this.ogp;
      a.a(paramDrawable, a.a(paramDrawable) + 1);
      AppMethodBeat.o(238740);
    }
    
    public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
    {
      AppMethodBeat.i(238749);
      s.u(paramDrawable, "who");
      s.u(paramRunnable, "what");
      c.Ql().postAtTime(paramRunnable, paramLong);
      AppMethodBeat.o(238749);
    }
    
    public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
    {
      AppMethodBeat.i(238760);
      s.u(paramDrawable, "who");
      s.u(paramRunnable, "what");
      c.Ql().removeCallbacks(paramRunnable);
      AppMethodBeat.o(238760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.a.a
 * JD-Core Version:    0.7.0.1
 */