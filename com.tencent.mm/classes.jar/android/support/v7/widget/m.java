package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.a.b.a;
import android.support.v7.a.a.j;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

class m
{
  final o aaA;
  Typeface aaB;
  boolean aaC;
  final TextView aav;
  private av aaw;
  private av aax;
  private av aay;
  private av aaz;
  int mStyle = 0;
  
  m(TextView paramTextView)
  {
    this.aav = paramTextView;
    this.aaA = new o(this.aav);
  }
  
  protected static av a(Context paramContext, h paramh, int paramInt)
  {
    paramContext = paramh.n(paramContext, paramInt);
    if (paramContext != null)
    {
      paramh = new av();
      paramh.alX = true;
      paramh.alV = paramContext;
      return paramh;
    }
    return null;
  }
  
  private void a(Context paramContext, ax paramax)
  {
    this.mStyle = paramax.getInt(a.j.TextAppearance_android_textStyle, this.mStyle);
    if ((paramax.hasValue(a.j.TextAppearance_android_fontFamily)) || (paramax.hasValue(a.j.TextAppearance_fontFamily)))
    {
      this.aaB = null;
      if (paramax.hasValue(a.j.TextAppearance_fontFamily))
      {
        i = a.j.TextAppearance_fontFamily;
        if (!paramContext.isRestricted()) {
          paramContext = new b.a()
          {
            public final void b(Typeface paramAnonymousTypeface)
            {
              m localm = m.this;
              Object localObject = this.aaD;
              if (localm.aaC)
              {
                localm.aaB = paramAnonymousTypeface;
                localObject = (TextView)((WeakReference)localObject).get();
                if (localObject != null) {
                  ((TextView)localObject).setTypeface(paramAnonymousTypeface, localm.mStyle);
                }
              }
            }
          };
        }
      }
    }
    try
    {
      j = this.mStyle;
      k = paramax.alZ.getResourceId(i, 0);
      if (k != 0) {
        break label163;
      }
      paramContext = null;
      this.aaB = paramContext;
      if (this.aaB != null) {
        break label241;
      }
      bool = true;
      this.aaC = bool;
    }
    catch (UnsupportedOperationException paramContext)
    {
      break label126;
    }
    catch (Resources.NotFoundException paramContext)
    {
      label126:
      break label126;
    }
    if (this.aaB == null)
    {
      paramContext = paramax.getString(i);
      if (paramContext != null) {
        this.aaB = Typeface.create(paramContext, this.mStyle);
      }
    }
    label163:
    label241:
    while (!paramax.hasValue(a.j.TextAppearance_android_typeface)) {
      for (;;)
      {
        int j;
        int k;
        boolean bool;
        return;
        int i = a.j.TextAppearance_android_fontFamily;
        continue;
        if (paramax.ZQ == null) {
          paramax.ZQ = new TypedValue();
        }
        Context localContext = paramax.mContext;
        TypedValue localTypedValue = paramax.ZQ;
        if (localContext.isRestricted())
        {
          paramContext = null;
        }
        else
        {
          Resources localResources = localContext.getResources();
          localResources.getValue(k, localTypedValue, true);
          paramContext = android.support.v4.content.a.b.a(localContext, localResources, localTypedValue, k, j, paramContext);
          continue;
          bool = false;
        }
      }
    }
    this.aaC = false;
    switch (paramax.getInt(a.j.TextAppearance_android_typeface, 1))
    {
    default: 
      return;
    case 1: 
      this.aaB = Typeface.SANS_SERIF;
      return;
    case 2: 
      this.aaB = Typeface.SERIF;
      return;
    }
    this.aaB = Typeface.MONOSPACE;
  }
  
  static m d(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new n(paramTextView);
    }
    return new m(paramTextView);
  }
  
  final void a(Drawable paramDrawable, av paramav)
  {
    if ((paramDrawable != null) && (paramav != null)) {
      h.a(paramDrawable, paramav, this.aav.getDrawableState());
    }
  }
  
  @SuppressLint({"NewApi"})
  void b(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.aav.getContext();
    Object localObject1 = h.gi();
    Object localObject2 = ax.a(localContext, paramAttributeSet, a.j.AppCompatTextHelper, paramInt, 0);
    int k = ((ax)localObject2).getResourceId(a.j.AppCompatTextHelper_android_textAppearance, -1);
    if (((ax)localObject2).hasValue(a.j.AppCompatTextHelper_android_drawableLeft)) {
      this.aaw = a(localContext, (h)localObject1, ((ax)localObject2).getResourceId(a.j.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((ax)localObject2).hasValue(a.j.AppCompatTextHelper_android_drawableTop)) {
      this.aax = a(localContext, (h)localObject1, ((ax)localObject2).getResourceId(a.j.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((ax)localObject2).hasValue(a.j.AppCompatTextHelper_android_drawableRight)) {
      this.aay = a(localContext, (h)localObject1, ((ax)localObject2).getResourceId(a.j.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((ax)localObject2).hasValue(a.j.AppCompatTextHelper_android_drawableBottom)) {
      this.aaz = a(localContext, (h)localObject1, ((ax)localObject2).getResourceId(a.j.AppCompatTextHelper_android_drawableBottom, 0));
    }
    ((ax)localObject2).alZ.recycle();
    boolean bool3 = this.aav.getTransformationMethod() instanceof PasswordTransformationMethod;
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    int j = 0;
    Object localObject7 = null;
    localObject2 = null;
    ax localax1 = null;
    Object localObject4 = null;
    localObject1 = null;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject6 = null;
    if (k != -1)
    {
      ax localax2 = ax.a(localContext, k, a.j.TextAppearance);
      i = j;
      bool1 = bool2;
      if (!bool3)
      {
        i = j;
        bool1 = bool2;
        if (localax2.hasValue(a.j.TextAppearance_textAllCaps))
        {
          i = 1;
          bool1 = localax2.getBoolean(a.j.TextAppearance_textAllCaps, false);
        }
      }
      a(localContext, localax2);
      localObject2 = localObject7;
      localObject3 = localObject6;
      if (Build.VERSION.SDK_INT < 23)
      {
        localObject1 = localax1;
        if (localax2.hasValue(a.j.TextAppearance_android_textColor)) {
          localObject1 = localax2.getColorStateList(a.j.TextAppearance_android_textColor);
        }
        if (localax2.hasValue(a.j.TextAppearance_android_textColorHint)) {
          localObject5 = localax2.getColorStateList(a.j.TextAppearance_android_textColorHint);
        }
        localObject2 = localObject1;
        localObject4 = localObject5;
        localObject3 = localObject6;
        if (localax2.hasValue(a.j.TextAppearance_android_textColorLink))
        {
          localObject3 = localax2.getColorStateList(a.j.TextAppearance_android_textColorLink);
          localObject4 = localObject5;
          localObject2 = localObject1;
        }
      }
      localax2.alZ.recycle();
      localObject1 = localObject4;
    }
    localax1 = ax.a(localContext, paramAttributeSet, a.j.TextAppearance, paramInt, 0);
    j = i;
    bool2 = bool1;
    if (!bool3)
    {
      j = i;
      bool2 = bool1;
      if (localax1.hasValue(a.j.TextAppearance_textAllCaps))
      {
        j = 1;
        bool2 = localax1.getBoolean(a.j.TextAppearance_textAllCaps, false);
      }
    }
    localObject4 = localObject2;
    localObject5 = localObject1;
    localObject6 = localObject3;
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localax1.hasValue(a.j.TextAppearance_android_textColor)) {
        localObject2 = localax1.getColorStateList(a.j.TextAppearance_android_textColor);
      }
      if (localax1.hasValue(a.j.TextAppearance_android_textColorHint)) {
        localObject1 = localax1.getColorStateList(a.j.TextAppearance_android_textColorHint);
      }
      localObject4 = localObject2;
      localObject5 = localObject1;
      localObject6 = localObject3;
      if (localax1.hasValue(a.j.TextAppearance_android_textColorLink))
      {
        localObject6 = localax1.getColorStateList(a.j.TextAppearance_android_textColorLink);
        localObject5 = localObject1;
        localObject4 = localObject2;
      }
    }
    a(localContext, localax1);
    localax1.alZ.recycle();
    if (localObject4 != null) {
      this.aav.setTextColor(localObject4);
    }
    if (localObject5 != null) {
      this.aav.setHintTextColor((ColorStateList)localObject5);
    }
    if (localObject6 != null) {
      this.aav.setLinkTextColor((ColorStateList)localObject6);
    }
    if ((!bool3) && (j != 0)) {
      setAllCaps(bool2);
    }
    if (this.aaB != null) {
      this.aav.setTypeface(this.aaB, this.mStyle);
    }
    localObject1 = this.aaA;
    float f2 = -1.0F;
    float f3 = -1.0F;
    float f1 = -1.0F;
    paramAttributeSet = ((o)localObject1).mContext.obtainStyledAttributes(paramAttributeSet, a.j.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizeTextType)) {
      ((o)localObject1).aaJ = paramAttributeSet.getInt(a.j.AppCompatTextView_autoSizeTextType, 0);
    }
    if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizeStepGranularity)) {
      f1 = paramAttributeSet.getDimension(a.j.AppCompatTextView_autoSizeStepGranularity, -1.0F);
    }
    if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizeMinTextSize)) {
      f2 = paramAttributeSet.getDimension(a.j.AppCompatTextView_autoSizeMinTextSize, -1.0F);
    }
    if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizeMaxTextSize)) {
      f3 = paramAttributeSet.getDimension(a.j.AppCompatTextView_autoSizeMaxTextSize, -1.0F);
    }
    if (paramAttributeSet.hasValue(a.j.AppCompatTextView_autoSizePresetSizes))
    {
      paramInt = paramAttributeSet.getResourceId(a.j.AppCompatTextView_autoSizePresetSizes, 0);
      if (paramInt > 0)
      {
        localObject2 = paramAttributeSet.getResources().obtainTypedArray(paramInt);
        i = ((TypedArray)localObject2).length();
        localObject3 = new int[i];
        if (i > 0)
        {
          paramInt = 0;
          while (paramInt < i)
          {
            localObject3[paramInt] = ((TypedArray)localObject2).getDimensionPixelSize(paramInt, -1);
            paramInt += 1;
          }
          ((o)localObject1).aaO = o.e((int[])localObject3);
          ((o)localObject1).go();
        }
        ((TypedArray)localObject2).recycle();
      }
    }
    paramAttributeSet.recycle();
    if (((o)localObject1).gs()) {
      if (((o)localObject1).aaJ == 1)
      {
        if (!((o)localObject1).aaP)
        {
          paramAttributeSet = ((o)localObject1).mContext.getResources().getDisplayMetrics();
          float f4 = f2;
          if (f2 == -1.0F) {
            f4 = TypedValue.applyDimension(2, 12.0F, paramAttributeSet);
          }
          f2 = f3;
          if (f3 == -1.0F) {
            f2 = TypedValue.applyDimension(2, 112.0F, paramAttributeSet);
          }
          f3 = f1;
          if (f1 == -1.0F) {
            f3 = 1.0F;
          }
          ((o)localObject1).f(f4, f2, f3);
        }
        ((o)localObject1).gp();
      }
    }
    for (;;)
    {
      if ((android.support.v4.widget.b.IY) && (this.aaA.aaJ != 0))
      {
        paramAttributeSet = this.aaA.aaO;
        if (paramAttributeSet.length > 0)
        {
          if (this.aav.getAutoSizeStepGranularity() == -1.0F) {
            break;
          }
          this.aav.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.aaA.aaM), Math.round(this.aaA.aaN), Math.round(this.aaA.aaL), 0);
        }
      }
      return;
      ((o)localObject1).aaJ = 0;
    }
    this.aav.setAutoSizeTextTypeUniformWithPresetSizes(paramAttributeSet, 0);
  }
  
  void gm()
  {
    if ((this.aaw != null) || (this.aax != null) || (this.aay != null) || (this.aaz != null))
    {
      Drawable[] arrayOfDrawable = this.aav.getCompoundDrawables();
      a(arrayOfDrawable[0], this.aaw);
      a(arrayOfDrawable[1], this.aax);
      a(arrayOfDrawable[2], this.aay);
      a(arrayOfDrawable[3], this.aaz);
    }
  }
  
  final void gn()
  {
    if (!android.support.v4.widget.b.IY) {
      this.aaA.gq();
    }
  }
  
  final void p(Context paramContext, int paramInt)
  {
    ax localax = ax.a(paramContext, paramInt, a.j.TextAppearance);
    if (localax.hasValue(a.j.TextAppearance_textAllCaps)) {
      setAllCaps(localax.getBoolean(a.j.TextAppearance_textAllCaps, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localax.hasValue(a.j.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localax.getColorStateList(a.j.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        this.aav.setTextColor(localColorStateList);
      }
    }
    a(paramContext, localax);
    localax.alZ.recycle();
    if (this.aaB != null) {
      this.aav.setTypeface(this.aaB, this.mStyle);
    }
  }
  
  final void setAllCaps(boolean paramBoolean)
  {
    this.aav.setAllCaps(paramBoolean);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    o localo = this.aaA;
    if (localo.gs())
    {
      DisplayMetrics localDisplayMetrics = localo.mContext.getResources().getDisplayMetrics();
      localo.f(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (localo.gp()) {
        localo.gq();
      }
    }
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    o localo = this.aaA;
    if (localo.gs())
    {
      int j = paramArrayOfInt.length;
      if (j > 0)
      {
        int[] arrayOfInt2 = new int[j];
        int[] arrayOfInt1;
        if (paramInt == 0)
        {
          arrayOfInt1 = Arrays.copyOf(paramArrayOfInt, j);
          localo.aaO = o.e(arrayOfInt1);
          if (!localo.go()) {
            throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(paramArrayOfInt));
          }
        }
        else
        {
          DisplayMetrics localDisplayMetrics = localo.mContext.getResources().getDisplayMetrics();
          for (;;)
          {
            arrayOfInt1 = arrayOfInt2;
            if (i >= j) {
              break;
            }
            arrayOfInt2[i] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[i], localDisplayMetrics));
            i += 1;
          }
        }
      }
      else
      {
        localo.aaP = false;
      }
      if (localo.gp()) {
        localo.gq();
      }
    }
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    o localo = this.aaA;
    if (localo.gs()) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Unknown auto-size text type: " + paramInt);
      case 0: 
        localo.aaJ = 0;
        localo.aaM = -1.0F;
        localo.aaN = -1.0F;
        localo.aaL = -1.0F;
        localo.aaO = new int[0];
        localo.aaK = false;
      }
    }
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = localo.mContext.getResources().getDisplayMetrics();
      localo.f(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
    } while (!localo.gp());
    localo.gq();
  }
  
  final void setTextSize(int paramInt, float paramFloat)
  {
    if ((!android.support.v4.widget.b.IY) && (!this.aaA.gr())) {
      this.aaA.d(paramInt, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.m
 * JD-Core Version:    0.7.0.1
 */