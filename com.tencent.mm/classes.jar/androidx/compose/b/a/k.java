package androidx.compose.b.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.ui.d.l;
import androidx.compose.ui.e.at;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/RippleHostView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bounded", "", "Ljava/lang/Boolean;", "lastRippleStateChangeTimeMillis", "", "Ljava/lang/Long;", "onInvalidateRipple", "Lkotlin/Function0;", "", "resetRippleRunnable", "Ljava/lang/Runnable;", "ripple", "Landroidx/compose/material/ripple/UnprojectedRipple;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "Landroidx/compose/ui/geometry/Size;", "radius", "", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "addRipple-KOepWvA", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;ZJIJFLkotlin/jvm/functions/Function0;)V", "createRipple", "disposeRipple", "invalidateDrawable", "who", "Landroid/graphics/drawable/Drawable;", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDrawableState", "removeRipple", "setRippleState", "pressed", "updateRippleProperties", "updateRippleProperties-biQXAtU", "(JIJF)V", "Companion", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends View
{
  public static final k.a akH;
  private static final int[] akM;
  private static final int[] akN;
  q akI;
  Boolean akJ;
  private Long akK;
  private Runnable akL;
  a<ah> aka;
  
  static
  {
    AppMethodBeat.i(201887);
    akH = new k.a((byte)0);
    akM = new int[] { 16842919, 16842910 };
    akN = new int[0];
    AppMethodBeat.o(201887);
  }
  
  public k(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(201850);
    AppMethodBeat.o(201850);
  }
  
  public final void a(long paramLong1, int paramInt, long paramLong2, float paramFloat)
  {
    AppMethodBeat.i(201932);
    q localq = this.akI;
    if (localq == null)
    {
      AppMethodBeat.o(201932);
      return;
    }
    localq.bw(paramInt);
    localq.d(paramLong2, paramFloat);
    Rect localRect = at.f(l.V(paramLong1));
    setLeft(localRect.left);
    setTop(localRect.top);
    setRight(localRect.right);
    setBottom(localRect.bottom);
    localq.setBounds(localRect);
    AppMethodBeat.o(201932);
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(201922);
    s.u(paramDrawable, "who");
    paramDrawable = this.aka;
    if (paramDrawable != null) {
      paramDrawable.invoke();
    }
    AppMethodBeat.o(201922);
  }
  
  public final void nG()
  {
    AppMethodBeat.i(201936);
    this.aka = null;
    Object localObject;
    if (this.akL != null)
    {
      removeCallbacks(this.akL);
      localObject = this.akL;
      s.checkNotNull(localObject);
      ((Runnable)localObject).run();
    }
    for (;;)
    {
      localObject = this.akI;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(201936);
      return;
      localObject = this.akI;
      if (localObject != null) {
        ((q)localObject).setState(akN);
      }
    }
    ((q)localObject).setVisible(false, false);
    unscheduleDrawable((Drawable)localObject);
    AppMethodBeat.o(201936);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201896);
    setMeasuredDimension(0, 0);
    AppMethodBeat.o(201896);
  }
  
  public final void refreshDrawableState() {}
  
  final void setRippleState(boolean paramBoolean)
  {
    AppMethodBeat.i(201943);
    long l2 = AnimationUtils.currentAnimationTimeMillis();
    Object localObject = this.akL;
    if (localObject != null)
    {
      removeCallbacks((Runnable)localObject);
      ((Runnable)localObject).run();
    }
    localObject = this.akK;
    if (localObject == null) {}
    for (long l1 = 0L; (!paramBoolean) && (l2 - l1 < 5L); l1 = ((Long)localObject).longValue())
    {
      this.akL = ((Runnable)new b(this));
      postDelayed(this.akL, 50L);
      this.akK = Long.valueOf(l2);
      AppMethodBeat.o(201943);
      return;
    }
    if (paramBoolean) {}
    for (localObject = akM;; localObject = akN)
    {
      q localq = this.akI;
      if (localq == null) {
        break;
      }
      localq.setState((int[])localObject);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    implements Runnable
  {
    b(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(201759);
      q localq = k.b(this.akO);
      if (localq != null) {
        localq.setState(k.nH());
      }
      k.c(this.akO);
      AppMethodBeat.o(201759);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.k
 * JD-Core Version:    0.7.0.1
 */