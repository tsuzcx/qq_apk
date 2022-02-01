package coil.f;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.SystemClock;
import androidx.l.a.a.b;
import androidx.l.a.a.b.a;
import coil.e.d;
import coil.size.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcoil/drawable/CrossfadeDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", "start", "end", "scale", "Lcoil/size/Scale;", "durationMillis", "", "fadeStart", "", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/size/Scale;IZ)V", "preferExactIntrinsicSize", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/size/Scale;IZZ)V", "callbacks", "", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "getDurationMillis", "()I", "getFadeStart", "()Z", "intrinsicHeight", "intrinsicWidth", "maxAlpha", "getPreferExactIntrinsicSize", "getScale", "()Lcoil/size/Scale;", "startTimeMillis", "", "state", "clearAnimationCallbacks", "", "computeIntrinsicDimension", "startSize", "endSize", "(Ljava/lang/Integer;Ljava/lang/Integer;)I", "draw", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "getColorFilter", "Landroid/graphics/ColorFilter;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "invalidateDrawable", "who", "isRunning", "markDone", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "onLevelChange", "level", "onStateChange", "", "registerAnimationCallback", "callback", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "setAlpha", "alpha", "setColorFilter", "colorFilter", "setTint", "tintColor", "setTintBlendMode", "blendMode", "Landroid/graphics/BlendMode;", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "stop", "unregisterAnimationCallback", "unscheduleDrawable", "updateBounds", "drawable", "targetBounds", "updateBounds$coil_base_release", "Companion", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends Drawable
  implements Drawable.Callback, b
{
  public static final a.a cnz;
  private final int WN;
  public final List<b.a> bPE;
  private final e cmi;
  private final boolean cmj;
  private long cmk;
  private final boolean cnA;
  private final int cnB;
  private final int cnC;
  private Drawable cnD;
  private final Drawable cnE;
  private int cnF;
  private int state;
  
  static
  {
    AppMethodBeat.i(187900);
    cnz = new a.a((byte)0);
    AppMethodBeat.o(187900);
  }
  
  public a(Drawable paramDrawable1, Drawable paramDrawable2, e parame, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(187865);
    this.cmi = parame;
    this.WN = paramInt;
    this.cmj = paramBoolean1;
    this.cnA = paramBoolean2;
    this.bPE = ((List)new ArrayList());
    Integer localInteger;
    if (paramDrawable1 == null)
    {
      parame = null;
      if (paramDrawable2 != null) {
        break label182;
      }
      localInteger = null;
      label68:
      this.cnB = b(parame, localInteger);
      if (paramDrawable1 != null) {
        break label194;
      }
      parame = null;
      label85:
      if (paramDrawable2 != null) {
        break label205;
      }
      localInteger = null;
      label92:
      this.cnC = b(parame, localInteger);
      if (paramDrawable1 != null) {
        break label217;
      }
      paramDrawable1 = null;
      label109:
      this.cnD = paramDrawable1;
      if (paramDrawable2 != null) {
        break label225;
      }
      paramDrawable1 = localObject;
      label121:
      this.cnE = paramDrawable1;
      this.cnF = 255;
      if (this.WN <= 0) {
        break label233;
      }
    }
    label182:
    label194:
    label205:
    label217:
    label225:
    label233:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label239;
      }
      paramDrawable1 = (Throwable)new IllegalArgumentException("durationMillis must be > 0.".toString());
      AppMethodBeat.o(187865);
      throw paramDrawable1;
      parame = Integer.valueOf(paramDrawable1.getIntrinsicWidth());
      break;
      localInteger = Integer.valueOf(paramDrawable2.getIntrinsicWidth());
      break label68;
      parame = Integer.valueOf(paramDrawable1.getIntrinsicHeight());
      break label85;
      localInteger = Integer.valueOf(paramDrawable2.getIntrinsicHeight());
      break label92;
      paramDrawable1 = paramDrawable1.mutate();
      break label109;
      paramDrawable1 = paramDrawable2.mutate();
      break label121;
    }
    label239:
    paramDrawable1 = this.cnD;
    if (paramDrawable1 != null) {
      paramDrawable1.setCallback((Drawable.Callback)this);
    }
    paramDrawable1 = this.cnE;
    if (paramDrawable1 != null) {
      paramDrawable1.setCallback((Drawable.Callback)this);
    }
    AppMethodBeat.o(187865);
  }
  
  private final void MQ()
  {
    AppMethodBeat.i(187893);
    this.state = 2;
    this.cnD = null;
    List localList = this.bPE;
    int i = 0;
    int k = localList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      ((b.a)localList.get(i)).Me();
      if (j > k)
      {
        AppMethodBeat.o(187893);
        return;
      }
      i = j;
    }
  }
  
  private void a(Drawable paramDrawable, Rect paramRect)
  {
    AppMethodBeat.i(187877);
    s.u(paramDrawable, "drawable");
    s.u(paramRect, "targetBounds");
    int k = paramDrawable.getIntrinsicWidth();
    int i = paramDrawable.getIntrinsicHeight();
    if ((k <= 0) || (i <= 0))
    {
      paramDrawable.setBounds(paramRect);
      AppMethodBeat.o(187877);
      return;
    }
    int m = paramRect.width();
    int j = paramRect.height();
    double d = d.b(k, i, m, j, this.cmi);
    k = kotlin.h.a.ah((m - k * d) / 2.0D);
    i = kotlin.h.a.ah((j - d * i) / 2.0D);
    paramDrawable.setBounds(paramRect.left + k, paramRect.top + i, paramRect.right - k, paramRect.bottom - i);
    AppMethodBeat.o(187877);
  }
  
  private final int b(Integer paramInteger1, Integer paramInteger2)
  {
    int j = -1;
    AppMethodBeat.i(187887);
    int i;
    if (!this.cnA)
    {
      if (paramInteger1 == null) {
        if (paramInteger2 != null) {
          break label65;
        }
      }
    }
    else
    {
      if (paramInteger1 != null) {
        break label76;
      }
      i = -1;
      label30:
      if (paramInteger2 != null) {
        break label84;
      }
    }
    for (;;)
    {
      i = Math.max(i, j);
      AppMethodBeat.o(187887);
      return i;
      if (paramInteger1.intValue() != -1) {
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(187887);
        return -1;
        label65:
        if (paramInteger2.intValue() != -1) {
          break;
        }
      }
      label76:
      i = paramInteger1.intValue();
      break label30;
      label84:
      j = paramInteger2.intValue();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(187907);
    s.u(paramCanvas, "canvas");
    int i;
    if (this.state == 0)
    {
      Drawable localDrawable1 = this.cnD;
      if (localDrawable1 != null)
      {
        localDrawable1.setAlpha(this.cnF);
        i = paramCanvas.save();
        try
        {
          localDrawable1.draw(paramCanvas);
          return;
        }
        finally
        {
          paramCanvas.restoreToCount(i);
          AppMethodBeat.o(187907);
        }
      }
      AppMethodBeat.o(187907);
      return;
    }
    if (this.state == 2)
    {
      Drawable localDrawable2 = this.cnE;
      if (localDrawable2 != null)
      {
        localDrawable2.setAlpha(this.cnF);
        i = paramCanvas.save();
        try
        {
          localDrawable2.draw(paramCanvas);
          return;
        }
        finally
        {
          paramCanvas.restoreToCount(i);
          AppMethodBeat.o(187907);
        }
      }
      AppMethodBeat.o(187907);
      return;
    }
    double d = (SystemClock.uptimeMillis() - this.cmk) / this.WN;
    int k = (int)(k.c(d, 0.0D, 1.0D) * this.cnF);
    if (this.cmj)
    {
      i = this.cnF - k;
      if (d < 1.0D) {
        break label324;
      }
    }
    label324:
    for (int j = 1;; j = 0)
    {
      Drawable localDrawable3;
      if (j == 0)
      {
        localDrawable3 = this.cnD;
        if (localDrawable3 != null)
        {
          localDrawable3.setAlpha(i);
          i = paramCanvas.save();
        }
      }
      try
      {
        localDrawable3.draw(paramCanvas);
        paramCanvas.restoreToCount(i);
        localDrawable3 = this.cnE;
        if (localDrawable3 != null)
        {
          localDrawable3.setAlpha(k);
          i = paramCanvas.save();
        }
      }
      finally
      {
        paramCanvas.restoreToCount(i);
        AppMethodBeat.o(187907);
      }
      try
      {
        localDrawable3.draw(paramCanvas);
        paramCanvas.restoreToCount(i);
        if (j == 0) {
          break label364;
        }
        MQ();
        AppMethodBeat.o(187907);
        return;
      }
      finally
      {
        paramCanvas.restoreToCount(i);
        AppMethodBeat.o(187907);
      }
      i = this.cnF;
      break;
    }
    label364:
    invalidateSelf();
    AppMethodBeat.o(187907);
  }
  
  public final int getAlpha()
  {
    return this.cnF;
  }
  
  public final ColorFilter getColorFilter()
  {
    AppMethodBeat.i(187947);
    switch (this.state)
    {
    }
    label111:
    do
    {
      do
      {
        AppMethodBeat.o(187947);
        return null;
        localObject = this.cnD;
      } while (localObject == null);
      localObject = ((Drawable)localObject).getColorFilter();
      AppMethodBeat.o(187947);
      return localObject;
      localObject = this.cnE;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((Drawable)localObject).getColorFilter())
      {
        if (localObject != null) {
          break label111;
        }
        localObject = this.cnD;
        if (localObject == null) {
          break;
        }
        localObject = ((Drawable)localObject).getColorFilter();
        AppMethodBeat.o(187947);
        return localObject;
      }
      AppMethodBeat.o(187947);
      return localObject;
      localObject = this.cnE;
    } while (localObject == null);
    Object localObject = ((Drawable)localObject).getColorFilter();
    AppMethodBeat.o(187947);
    return localObject;
  }
  
  public final int getIntrinsicHeight()
  {
    return this.cnC;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.cnB;
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(187937);
    Drawable localDrawable1 = this.cnD;
    Drawable localDrawable2 = this.cnE;
    int i;
    if (this.state == 0)
    {
      if (localDrawable1 == null)
      {
        AppMethodBeat.o(187937);
        return -2;
      }
      i = localDrawable1.getOpacity();
      AppMethodBeat.o(187937);
      return i;
    }
    if (this.state == 2)
    {
      if (localDrawable2 == null)
      {
        AppMethodBeat.o(187937);
        return -2;
      }
      i = localDrawable2.getOpacity();
      AppMethodBeat.o(187937);
      return i;
    }
    if ((localDrawable1 != null) && (localDrawable2 != null))
    {
      i = Drawable.resolveOpacity(localDrawable1.getOpacity(), localDrawable2.getOpacity());
      AppMethodBeat.o(187937);
      return i;
    }
    if (localDrawable1 != null)
    {
      i = localDrawable1.getOpacity();
      AppMethodBeat.o(187937);
      return i;
    }
    if (localDrawable2 != null)
    {
      i = localDrawable2.getOpacity();
      AppMethodBeat.o(187937);
      return i;
    }
    AppMethodBeat.o(187937);
    return -2;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(188012);
    s.u(paramDrawable, "who");
    invalidateSelf();
    AppMethodBeat.o(188012);
  }
  
  public final boolean isRunning()
  {
    return this.state == 1;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(187963);
    s.u(paramRect, "bounds");
    Drawable localDrawable = this.cnD;
    if (localDrawable != null) {
      a(localDrawable, paramRect);
    }
    localDrawable = this.cnE;
    if (localDrawable != null) {
      a(localDrawable, paramRect);
    }
    AppMethodBeat.o(187963);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    AppMethodBeat.i(187968);
    Drawable localDrawable = this.cnD;
    boolean bool1;
    if (localDrawable == null)
    {
      bool1 = false;
      localDrawable = this.cnE;
      if (localDrawable != null) {
        break label58;
      }
    }
    label58:
    for (boolean bool2 = false;; bool2 = localDrawable.setLevel(paramInt))
    {
      if ((!bool1) && (!bool2)) {
        break label68;
      }
      AppMethodBeat.o(187968);
      return true;
      bool1 = localDrawable.setLevel(paramInt);
      break;
    }
    label68:
    AppMethodBeat.o(187968);
    return false;
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(187977);
    s.u(paramArrayOfInt, "state");
    Drawable localDrawable = this.cnD;
    boolean bool1;
    if (localDrawable == null)
    {
      bool1 = false;
      localDrawable = this.cnE;
      if (localDrawable != null) {
        break label65;
      }
    }
    label65:
    for (boolean bool2 = false;; bool2 = localDrawable.setState(paramArrayOfInt))
    {
      if ((!bool1) && (!bool2)) {
        break label75;
      }
      AppMethodBeat.o(187977);
      return true;
      bool1 = localDrawable.setState(paramArrayOfInt);
      break;
    }
    label75:
    AppMethodBeat.o(187977);
    return false;
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(188026);
    s.u(paramDrawable, "who");
    s.u(paramRunnable, "what");
    scheduleSelf(paramRunnable, paramLong);
    AppMethodBeat.o(188026);
  }
  
  public final void setAlpha(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(187929);
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt <= 255) {
        i = 1;
      }
    }
    if (i == 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException(s.X("Invalid alpha: ", Integer.valueOf(paramInt)).toString());
      AppMethodBeat.o(187929);
      throw localThrowable;
    }
    this.cnF = paramInt;
    AppMethodBeat.o(187929);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(187957);
    Drawable localDrawable = this.cnD;
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramColorFilter);
    }
    localDrawable = this.cnE;
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramColorFilter);
    }
    AppMethodBeat.o(187957);
  }
  
  public final void setTint(int paramInt)
  {
    AppMethodBeat.i(188033);
    Drawable localDrawable = this.cnD;
    if (localDrawable != null) {
      localDrawable.setTint(paramInt);
    }
    localDrawable = this.cnE;
    if (localDrawable != null) {
      localDrawable.setTint(paramInt);
    }
    AppMethodBeat.o(188033);
  }
  
  public final void setTintBlendMode(BlendMode paramBlendMode)
  {
    AppMethodBeat.i(188060);
    Drawable localDrawable = this.cnD;
    if (localDrawable != null) {
      localDrawable.setTintBlendMode(paramBlendMode);
    }
    localDrawable = this.cnE;
    if (localDrawable != null) {
      localDrawable.setTintBlendMode(paramBlendMode);
    }
    AppMethodBeat.o(188060);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(188043);
    Drawable localDrawable = this.cnD;
    if (localDrawable != null) {
      localDrawable.setTintList(paramColorStateList);
    }
    localDrawable = this.cnE;
    if (localDrawable != null) {
      localDrawable.setTintList(paramColorStateList);
    }
    AppMethodBeat.o(188043);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(188052);
    Drawable localDrawable = this.cnD;
    if (localDrawable != null) {
      localDrawable.setTintMode(paramMode);
    }
    localDrawable = this.cnE;
    if (localDrawable != null) {
      localDrawable.setTintMode(paramMode);
    }
    AppMethodBeat.o(188052);
  }
  
  public final void start()
  {
    AppMethodBeat.i(188081);
    Object localObject = this.cnD;
    if ((localObject instanceof Animatable))
    {
      localObject = (Animatable)localObject;
      if (localObject != null) {
        ((Animatable)localObject).start();
      }
      localObject = this.cnE;
      if (!(localObject instanceof Animatable)) {
        break label92;
      }
    }
    label92:
    for (localObject = (Animatable)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((Animatable)localObject).start();
      }
      if (this.state == 0) {
        break label98;
      }
      AppMethodBeat.o(188081);
      return;
      localObject = null;
      break;
    }
    label98:
    this.state = 1;
    this.cmk = SystemClock.uptimeMillis();
    localObject = this.bPE;
    int i = 0;
    int k = ((List)localObject).size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      ((List)localObject).get(i);
      if (j > k)
      {
        invalidateSelf();
        AppMethodBeat.o(188081);
        return;
      }
      i = j;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(188088);
    Object localObject = this.cnD;
    if ((localObject instanceof Animatable))
    {
      localObject = (Animatable)localObject;
      if (localObject != null) {
        ((Animatable)localObject).stop();
      }
      localObject = this.cnE;
      if (!(localObject instanceof Animatable)) {
        break label84;
      }
    }
    label84:
    for (localObject = (Animatable)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((Animatable)localObject).stop();
      }
      if (this.state != 2) {
        MQ();
      }
      AppMethodBeat.o(188088);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    AppMethodBeat.i(188001);
    s.u(paramDrawable, "who");
    s.u(paramRunnable, "what");
    unscheduleSelf(paramRunnable);
    AppMethodBeat.o(188001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.f.a
 * JD-Core Version:    0.7.0.1
 */