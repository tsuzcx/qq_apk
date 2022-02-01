package androidx.compose.b.a;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/UnprojectedRipple;", "Landroid/graphics/drawable/RippleDrawable;", "bounded", "", "(Z)V", "projected", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "rippleRadius", "", "Ljava/lang/Integer;", "calculateRippleColor", "color", "alpha", "", "calculateRippleColor-5vOe2sY", "(JF)J", "getDirtyBounds", "Landroid/graphics/Rect;", "isProjected", "setColor", "", "setColor-DxMtmZc", "(JF)V", "trySetRadius", "radius", "Companion", "MRadiusHelper", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
final class q
  extends RippleDrawable
{
  public static final q.a ale;
  private static Method ali;
  private static boolean alj;
  private final boolean ajS;
  private z alf;
  private Integer alg;
  private boolean alh;
  
  static
  {
    AppMethodBeat.i(201849);
    ale = new q.a((byte)0);
    AppMethodBeat.o(201849);
  }
  
  public q(boolean paramBoolean) {}
  
  private static long e(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(201845);
    float f = paramFloat;
    if (Build.VERSION.SDK_INT < 28) {
      f = paramFloat * 2.0F;
    }
    paramLong = z.g(paramLong, f);
    AppMethodBeat.o(201845);
    return paramLong;
  }
  
  public final void bw(int paramInt)
  {
    AppMethodBeat.i(201888);
    Object localObject = this.alg;
    if (localObject == null)
    {
      this.alg = Integer.valueOf(paramInt);
      if (Build.VERSION.SDK_INT >= 23) {
        break label112;
      }
    }
    for (;;)
    {
      try
      {
        if (!alj)
        {
          alj = true;
          ali = RippleDrawable.class.getDeclaredMethod("setMaxRadius", new Class[] { Integer.TYPE });
        }
        localObject = ali;
        if (localObject != null)
        {
          ((Method)localObject).invoke(this, new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(201888);
          return;
          if (((Integer)localObject).intValue() != paramInt) {
            break;
          }
        }
        AppMethodBeat.o(201888);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(201888);
        return;
      }
      label112:
      b.alk.a((RippleDrawable)this, paramInt);
    }
  }
  
  public final void d(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(201855);
    paramLong = e(paramLong, paramFloat);
    z localz = this.alf;
    if (localz == null) {}
    for (boolean bool = false;; bool = z.e(localz.value, paramLong))
    {
      if (!bool)
      {
        this.alf = z.ad(paramLong);
        setColor(ColorStateList.valueOf(ab.ai(paramLong)));
      }
      AppMethodBeat.o(201855);
      return;
    }
  }
  
  public final Rect getDirtyBounds()
  {
    AppMethodBeat.i(201875);
    if (!this.ajS) {
      this.alh = true;
    }
    Rect localRect = super.getDirtyBounds();
    s.s(localRect, "super.getDirtyBounds()");
    this.alh = false;
    AppMethodBeat.o(201875);
    return localRect;
  }
  
  public final boolean isProjected()
  {
    return this.alh;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/UnprojectedRipple$MRadiusHelper;", "", "()V", "setRadius", "", "ripple", "Landroid/graphics/drawable/RippleDrawable;", "radius", "", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    public static final b alk;
    
    static
    {
      AppMethodBeat.i(201835);
      alk = new b();
      AppMethodBeat.o(201835);
    }
    
    public final void a(RippleDrawable paramRippleDrawable, int paramInt)
    {
      AppMethodBeat.i(201842);
      s.u(paramRippleDrawable, "ripple");
      paramRippleDrawable.setRadius(paramInt);
      AppMethodBeat.o(201842);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.q
 * JD-Core Version:    0.7.0.1
 */