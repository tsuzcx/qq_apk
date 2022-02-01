package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.a.a.a;
import androidx.core.content.a.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac
{
  private final Context mContext;
  private TypedValue rK;
  public final TypedArray xv;
  
  private ac(Context paramContext, TypedArray paramTypedArray)
  {
    this.mContext = paramContext;
    this.xv = paramTypedArray;
  }
  
  public static ac a(Context paramContext, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199708);
    paramContext = new ac(paramContext, paramContext.obtainStyledAttributes(paramInt, paramArrayOfInt));
    AppMethodBeat.o(199708);
    return paramContext;
  }
  
  public static ac a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199691);
    paramContext = new ac(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt));
    AppMethodBeat.o(199691);
    return paramContext;
  }
  
  public static ac a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199700);
    paramContext = new ac(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2));
    AppMethodBeat.o(199700);
    return paramContext;
  }
  
  public final Typeface a(int paramInt1, int paramInt2, f.c paramc)
  {
    AppMethodBeat.i(199748);
    paramInt1 = this.xv.getResourceId(paramInt1, 0);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(199748);
      return null;
    }
    if (this.rK == null) {
      this.rK = new TypedValue();
    }
    paramc = androidx.core.content.a.f.a(this.mContext, paramInt1, this.rK, paramInt2, paramc);
    AppMethodBeat.o(199748);
    return paramc;
  }
  
  public final Drawable ax(int paramInt)
  {
    AppMethodBeat.i(199737);
    if (this.xv.hasValue(paramInt))
    {
      paramInt = this.xv.getResourceId(paramInt, 0);
      if (paramInt != 0)
      {
        Drawable localDrawable = f.ep().b(this.mContext, paramInt, true);
        AppMethodBeat.o(199737);
        return localDrawable;
      }
    }
    AppMethodBeat.o(199737);
    return null;
  }
  
  public final float ay(int paramInt)
  {
    AppMethodBeat.i(199827);
    float f = this.xv.getDimension(paramInt, 0.0F);
    AppMethodBeat.o(199827);
    return f;
  }
  
  public final boolean az(int paramInt)
  {
    AppMethodBeat.i(199876);
    boolean bool = this.xv.hasValue(paramInt);
    AppMethodBeat.o(199876);
    return bool;
  }
  
  public final float d(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(199787);
    paramFloat = this.xv.getFloat(paramInt, paramFloat);
    AppMethodBeat.o(199787);
    return paramFloat;
  }
  
  public final ColorStateList getColorStateList(int paramInt)
  {
    AppMethodBeat.i(199807);
    if (this.xv.hasValue(paramInt))
    {
      int i = this.xv.getResourceId(paramInt, 0);
      if (i != 0)
      {
        localColorStateList = a.l(this.mContext, i);
        if (localColorStateList != null)
        {
          AppMethodBeat.o(199807);
          return localColorStateList;
        }
      }
    }
    ColorStateList localColorStateList = this.xv.getColorStateList(paramInt);
    AppMethodBeat.o(199807);
    return localColorStateList;
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    AppMethodBeat.i(199730);
    if (this.xv.hasValue(paramInt))
    {
      int i = this.xv.getResourceId(paramInt, 0);
      if (i != 0)
      {
        localDrawable = a.m(this.mContext, i);
        AppMethodBeat.o(199730);
        return localDrawable;
      }
    }
    Drawable localDrawable = this.xv.getDrawable(paramInt);
    AppMethodBeat.o(199730);
    return localDrawable;
  }
  
  public final int getInt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199779);
    paramInt1 = this.xv.getInt(paramInt1, paramInt2);
    AppMethodBeat.o(199779);
    return paramInt1;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(199765);
    String str = this.xv.getString(paramInt);
    AppMethodBeat.o(199765);
    return str;
  }
  
  public final CharSequence getText(int paramInt)
  {
    AppMethodBeat.i(199755);
    CharSequence localCharSequence = this.xv.getText(paramInt);
    AppMethodBeat.o(199755);
    return localCharSequence;
  }
  
  public final boolean m(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(199774);
    paramBoolean = this.xv.getBoolean(paramInt, paramBoolean);
    AppMethodBeat.o(199774);
    return paramBoolean;
  }
  
  public final int r(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199795);
    paramInt1 = this.xv.getColor(paramInt1, paramInt2);
    AppMethodBeat.o(199795);
    return paramInt1;
  }
  
  public final int s(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199818);
    paramInt1 = this.xv.getInteger(paramInt1, paramInt2);
    AppMethodBeat.o(199818);
    return paramInt1;
  }
  
  public final int t(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199836);
    paramInt1 = this.xv.getDimensionPixelOffset(paramInt1, paramInt2);
    AppMethodBeat.o(199836);
    return paramInt1;
  }
  
  public final int u(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199844);
    paramInt1 = this.xv.getDimensionPixelSize(paramInt1, paramInt2);
    AppMethodBeat.o(199844);
    return paramInt1;
  }
  
  public final int v(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199855);
    paramInt1 = this.xv.getLayoutDimension(paramInt1, paramInt2);
    AppMethodBeat.o(199855);
    return paramInt1;
  }
  
  public final int w(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199865);
    paramInt1 = this.xv.getResourceId(paramInt1, paramInt2);
    AppMethodBeat.o(199865);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.ac
 * JD-Core Version:    0.7.0.1
 */