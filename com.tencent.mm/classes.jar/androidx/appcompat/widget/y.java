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
  private static final ThreadLocal<TypedValue> iw;
  static final int[] wo;
  static final int[] wp;
  static final int[] wq;
  static final int[] wr;
  static final int[] ws;
  static final int[] wt;
  static final int[] wv;
  static final int[] ww;
  private static final int[] wx;
  
  static
  {
    AppMethodBeat.i(242013);
    iw = new ThreadLocal();
    wp = new int[] { -16842910 };
    wq = new int[] { 16842908 };
    wr = new int[] { 16843518 };
    ws = new int[] { 16842919 };
    wo = new int[] { 16842912 };
    wt = new int[] { 16842913 };
    wv = new int[] { -16842919, -16842908 };
    ww = new int[0];
    wx = new int[1];
    AppMethodBeat.o(242013);
  }
  
  public static int t(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(242008);
    wx[0] = paramInt;
    paramContext = ac.a(paramContext, null, wx);
    try
    {
      paramInt = paramContext.m(0, 0);
      return paramInt;
    }
    finally
    {
      paramContext.wA.recycle();
      AppMethodBeat.o(242008);
    }
  }
  
  public static ColorStateList u(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(242010);
    wx[0] = paramInt;
    paramContext = ac.a(paramContext, null, wx);
    try
    {
      ColorStateList localColorStateList = paramContext.getColorStateList(0);
      return localColorStateList;
    }
    finally
    {
      paramContext.wA.recycle();
      AppMethodBeat.o(242010);
    }
  }
  
  public static int v(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(242012);
    Object localObject = u(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful()))
    {
      paramInt = ((ColorStateList)localObject).getColorForState(wp, ((ColorStateList)localObject).getDefaultColor());
      AppMethodBeat.o(242012);
      return paramInt;
    }
    TypedValue localTypedValue = (TypedValue)iw.get();
    localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      iw.set(localObject);
    }
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    float f = ((TypedValue)localObject).getFloat();
    paramInt = t(paramContext, paramInt);
    paramInt = b.C(paramInt, Math.round(f * Color.alpha(paramInt)));
    AppMethodBeat.o(242012);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.y
 * JD-Core Version:    0.7.0.1
 */