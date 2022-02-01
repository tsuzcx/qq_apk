package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import androidx.core.graphics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y
{
  private static final ThreadLocal<TypedValue> jr;
  static final int[] xk;
  static final int[] xl;
  static final int[] xm;
  static final int[] xn;
  static final int[] xo;
  static final int[] xp;
  static final int[] xq;
  static final int[] xr;
  private static final int[] xs;
  
  static
  {
    AppMethodBeat.i(199953);
    jr = new ThreadLocal();
    xl = new int[] { -16842910 };
    xm = new int[] { 16842908 };
    xn = new int[] { 16843518 };
    xo = new int[] { 16842919 };
    xk = new int[] { 16842912 };
    xp = new int[] { 16842913 };
    xq = new int[] { -16842919, -16842908 };
    xr = new int[0];
    xs = new int[1];
    AppMethodBeat.o(199953);
  }
  
  public static int t(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199886);
    xs[0] = paramInt;
    paramContext = ac.a(paramContext, null, xs);
    try
    {
      paramInt = paramContext.r(0, 0);
      return paramInt;
    }
    finally
    {
      paramContext.xv.recycle();
      AppMethodBeat.o(199886);
    }
  }
  
  public static ColorStateList u(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199925);
    xs[0] = paramInt;
    paramContext = ac.a(paramContext, null, xs);
    try
    {
      ColorStateList localColorStateList = paramContext.getColorStateList(0);
      return localColorStateList;
    }
    finally
    {
      paramContext.xv.recycle();
      AppMethodBeat.o(199925);
    }
  }
  
  public static int v(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199939);
    Object localObject = u(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful()))
    {
      paramInt = ((ColorStateList)localObject).getColorForState(xl, ((ColorStateList)localObject).getDefaultColor());
      AppMethodBeat.o(199939);
      return paramInt;
    }
    TypedValue localTypedValue = (TypedValue)jr.get();
    localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      jr.set(localObject);
    }
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    float f = ((TypedValue)localObject).getFloat();
    paramInt = t(paramContext, paramInt);
    paramInt = b.ax(paramInt, Math.round(f * Color.alpha(paramInt)));
    AppMethodBeat.o(199939);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.y
 * JD-Core Version:    0.7.0.1
 */