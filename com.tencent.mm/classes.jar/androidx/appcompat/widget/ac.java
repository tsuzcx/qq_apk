package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.a.a.a;
import androidx.core.content.a.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac
{
  private final Context mContext;
  private TypedValue qN;
  public final TypedArray wA;
  
  private ac(Context paramContext, TypedArray paramTypedArray)
  {
    this.mContext = paramContext;
    this.wA = paramTypedArray;
  }
  
  public static ac a(Context paramContext, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(242046);
    paramContext = new ac(paramContext, paramContext.obtainStyledAttributes(paramInt, paramArrayOfInt));
    AppMethodBeat.o(242046);
    return paramContext;
  }
  
  public static ac a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(242043);
    paramContext = new ac(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt));
    AppMethodBeat.o(242043);
    return paramContext;
  }
  
  public static ac a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242044);
    paramContext = new ac(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2));
    AppMethodBeat.o(242044);
    return paramContext;
  }
  
  public final Typeface a(int paramInt1, int paramInt2, f.a parama)
  {
    AppMethodBeat.i(242049);
    paramInt1 = this.wA.getResourceId(paramInt1, 0);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(242049);
      return null;
    }
    if (this.qN == null) {
      this.qN = new TypedValue();
    }
    parama = androidx.core.content.a.f.a(this.mContext, paramInt1, this.qN, paramInt2, parama);
    AppMethodBeat.o(242049);
    return parama;
  }
  
  public final Drawable aA(int paramInt)
  {
    AppMethodBeat.i(242048);
    if (this.wA.hasValue(paramInt))
    {
      paramInt = this.wA.getResourceId(paramInt, 0);
      if (paramInt != 0)
      {
        Drawable localDrawable = f.dq().b(this.mContext, paramInt, true);
        AppMethodBeat.o(242048);
        return localDrawable;
      }
    }
    AppMethodBeat.o(242048);
    return null;
  }
  
  public final float aB(int paramInt)
  {
    AppMethodBeat.i(242059);
    float f = this.wA.getDimension(paramInt, 0.0F);
    AppMethodBeat.o(242059);
    return f;
  }
  
  public final boolean aC(int paramInt)
  {
    AppMethodBeat.i(242065);
    boolean bool = this.wA.hasValue(paramInt);
    AppMethodBeat.o(242065);
    return bool;
  }
  
  public final float c(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(242055);
    paramFloat = this.wA.getFloat(paramInt, paramFloat);
    AppMethodBeat.o(242055);
    return paramFloat;
  }
  
  public final boolean c(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(242053);
    paramBoolean = this.wA.getBoolean(paramInt, paramBoolean);
    AppMethodBeat.o(242053);
    return paramBoolean;
  }
  
  public final ColorStateList getColorStateList(int paramInt)
  {
    AppMethodBeat.i(242057);
    if (this.wA.hasValue(paramInt))
    {
      int i = this.wA.getResourceId(paramInt, 0);
      if (i != 0)
      {
        localColorStateList = a.l(this.mContext, i);
        if (localColorStateList != null)
        {
          AppMethodBeat.o(242057);
          return localColorStateList;
        }
      }
    }
    ColorStateList localColorStateList = this.wA.getColorStateList(paramInt);
    AppMethodBeat.o(242057);
    return localColorStateList;
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(242047);
    if (this.wA.hasValue(paramInt))
    {
      int i = this.wA.getResourceId(paramInt, 0);
      if (i != 0)
      {
        localDrawable = a.m(this.mContext, i);
        AppMethodBeat.o(242047);
        return localDrawable;
      }
    }
    Drawable localDrawable = this.wA.getDrawable(paramInt);
    AppMethodBeat.o(242047);
    return localDrawable;
  }
  
  public final int getInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242054);
    paramInt1 = this.wA.getInt(paramInt1, paramInt2);
    AppMethodBeat.o(242054);
    return paramInt1;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(242052);
    String str = this.wA.getString(paramInt);
    AppMethodBeat.o(242052);
    return str;
  }
  
  public final CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(242050);
    CharSequence localCharSequence = this.wA.getText(paramInt);
    AppMethodBeat.o(242050);
    return localCharSequence;
  }
  
  public final int m(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242056);
    paramInt1 = this.wA.getColor(paramInt1, paramInt2);
    AppMethodBeat.o(242056);
    return paramInt1;
  }
  
  public final int n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242058);
    paramInt1 = this.wA.getInteger(paramInt1, paramInt2);
    AppMethodBeat.o(242058);
    return paramInt1;
  }
  
  public final int o(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242060);
    paramInt1 = this.wA.getDimensionPixelOffset(paramInt1, paramInt2);
    AppMethodBeat.o(242060);
    return paramInt1;
  }
  
  public final int p(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242061);
    paramInt1 = this.wA.getDimensionPixelSize(paramInt1, paramInt2);
    AppMethodBeat.o(242061);
    return paramInt1;
  }
  
  public final int q(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242062);
    paramInt1 = this.wA.getLayoutDimension(paramInt1, paramInt2);
    AppMethodBeat.o(242062);
    return paramInt1;
  }
  
  public final int r(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242064);
    paramInt1 = this.wA.getResourceId(paramInt1, paramInt2);
    AppMethodBeat.o(242064);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ac
 * JD-Core Version:    0.7.0.1
 */