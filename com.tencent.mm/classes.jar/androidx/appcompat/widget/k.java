package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.a.j;
import androidx.core.content.a.f.a;
import androidx.core.widget.b;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

class k
{
  int mStyle;
  private aa rA;
  final l rB;
  Typeface rC;
  boolean rD;
  private final TextView ru;
  private aa rv;
  private aa rw;
  private aa rx;
  private aa ry;
  private aa rz;
  
  k(TextView paramTextView)
  {
    AppMethodBeat.i(241057);
    this.mStyle = 0;
    this.ru = paramTextView;
    this.rB = new l(this.ru);
    AppMethodBeat.o(241057);
  }
  
  private static aa a(Context paramContext, f paramf, int paramInt)
  {
    AppMethodBeat.i(241069);
    paramContext = paramf.q(paramContext, paramInt);
    if (paramContext != null)
    {
      paramf = new aa();
      paramf.jG = true;
      paramf.jE = paramContext;
      AppMethodBeat.o(241069);
      return paramf;
    }
    AppMethodBeat.o(241069);
    return null;
  }
  
  private void a(Context paramContext, ac paramac)
  {
    boolean bool = true;
    AppMethodBeat.i(241063);
    this.mStyle = paramac.getInt(a.j.TextAppearance_android_textStyle, this.mStyle);
    if ((paramac.aC(a.j.TextAppearance_android_fontFamily)) || (paramac.aC(a.j.TextAppearance_fontFamily)))
    {
      this.rC = null;
      int i;
      if (paramac.aC(a.j.TextAppearance_fontFamily))
      {
        i = a.j.TextAppearance_fontFamily;
        if (!paramContext.isRestricted()) {
          paramContext = new f.a()
          {
            public final void a(Typeface paramAnonymousTypeface)
            {
              AppMethodBeat.i(241053);
              k localk = k.this;
              Object localObject = this.rE;
              if (localk.rD)
              {
                localk.rC = paramAnonymousTypeface;
                localObject = (TextView)((WeakReference)localObject).get();
                if (localObject != null) {
                  ((TextView)localObject).setTypeface(paramAnonymousTypeface, localk.mStyle);
                }
              }
              AppMethodBeat.o(241053);
            }
            
            public final void au(int paramAnonymousInt) {}
          };
        }
      }
      for (;;)
      {
        try
        {
          this.rC = paramac.a(i, this.mStyle, paramContext);
          if (this.rC != null) {
            continue;
          }
          this.rD = bool;
        }
        catch (UnsupportedOperationException paramContext)
        {
          continue;
        }
        catch (Resources.NotFoundException paramContext)
        {
          continue;
        }
        if (this.rC == null)
        {
          paramContext = paramac.getString(i);
          if (paramContext != null) {
            this.rC = Typeface.create(paramContext, this.mStyle);
          }
        }
        AppMethodBeat.o(241063);
        return;
        i = a.j.TextAppearance_android_fontFamily;
        break;
        bool = false;
      }
    }
    if (paramac.aC(a.j.TextAppearance_android_typeface))
    {
      this.rD = false;
      switch (paramac.getInt(a.j.TextAppearance_android_typeface, 1))
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(241063);
      return;
      this.rC = Typeface.SANS_SERIF;
      AppMethodBeat.o(241063);
      return;
      this.rC = Typeface.SERIF;
      AppMethodBeat.o(241063);
      return;
      this.rC = Typeface.MONOSPACE;
    }
  }
  
  private void a(Drawable paramDrawable, aa paramaa)
  {
    AppMethodBeat.i(241067);
    if ((paramDrawable != null) && (paramaa != null)) {
      f.a(paramDrawable, paramaa, this.ru.getDrawableState());
    }
    AppMethodBeat.o(241067);
  }
  
  private void b(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(241076);
    this.rB.b(paramInt, paramFloat);
    AppMethodBeat.o(241076);
  }
  
  @SuppressLint({"NewApi"})
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(241061);
    Context localContext = this.ru.getContext();
    Object localObject1 = f.dq();
    Object localObject2 = ac.a(localContext, paramAttributeSet, a.j.AppCompatTextHelper, paramInt, 0);
    int i = ((ac)localObject2).r(a.j.AppCompatTextHelper_android_textAppearance, -1);
    if (((ac)localObject2).aC(a.j.AppCompatTextHelper_android_drawableLeft)) {
      this.rv = a(localContext, (f)localObject1, ((ac)localObject2).r(a.j.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((ac)localObject2).aC(a.j.AppCompatTextHelper_android_drawableTop)) {
      this.rw = a(localContext, (f)localObject1, ((ac)localObject2).r(a.j.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((ac)localObject2).aC(a.j.AppCompatTextHelper_android_drawableRight)) {
      this.rx = a(localContext, (f)localObject1, ((ac)localObject2).r(a.j.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((ac)localObject2).aC(a.j.AppCompatTextHelper_android_drawableBottom)) {
      this.ry = a(localContext, (f)localObject1, ((ac)localObject2).r(a.j.AppCompatTextHelper_android_drawableBottom, 0));
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (((ac)localObject2).aC(a.j.AppCompatTextHelper_android_drawableStart)) {
        this.rz = a(localContext, (f)localObject1, ((ac)localObject2).r(a.j.AppCompatTextHelper_android_drawableStart, 0));
      }
      if (((ac)localObject2).aC(a.j.AppCompatTextHelper_android_drawableEnd)) {
        this.rA = a(localContext, (f)localObject1, ((ac)localObject2).r(a.j.AppCompatTextHelper_android_drawableEnd, 0));
      }
    }
    ((ac)localObject2).wA.recycle();
    boolean bool3 = this.ru.getTransformationMethod() instanceof PasswordTransformationMethod;
    Object localObject3;
    boolean bool1;
    label338:
    Object localObject4;
    if (i != -1)
    {
      localObject3 = ac.a(localContext, i, a.j.TextAppearance);
      if ((!bool3) && (((ac)localObject3).aC(a.j.TextAppearance_textAllCaps)))
      {
        bool1 = ((ac)localObject3).c(a.j.TextAppearance_textAllCaps, false);
        i = 1;
        a(localContext, (ac)localObject3);
        if (Build.VERSION.SDK_INT < 23) {
          if (((ac)localObject3).aC(a.j.TextAppearance_android_textColor))
          {
            localObject2 = ((ac)localObject3).getColorStateList(a.j.TextAppearance_android_textColor);
            if (((ac)localObject3).aC(a.j.TextAppearance_android_textColorHint))
            {
              localObject4 = ((ac)localObject3).getColorStateList(a.j.TextAppearance_android_textColorHint);
              label359:
              if (((ac)localObject3).aC(a.j.TextAppearance_android_textColorLink))
              {
                localObject1 = ((ac)localObject3).getColorStateList(a.j.TextAppearance_android_textColorLink);
                label380:
                ((ac)localObject3).wA.recycle();
                localObject3 = localObject1;
                localObject1 = localObject4;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ac localac = ac.a(localContext, paramAttributeSet, a.j.TextAppearance, paramInt, 0);
      int j = i;
      boolean bool2 = bool1;
      if (!bool3)
      {
        j = i;
        bool2 = bool1;
        if (localac.aC(a.j.TextAppearance_textAllCaps))
        {
          bool2 = localac.c(a.j.TextAppearance_textAllCaps, false);
          j = 1;
        }
      }
      localObject4 = localObject2;
      Object localObject5 = localObject1;
      Object localObject6 = localObject3;
      if (Build.VERSION.SDK_INT < 23)
      {
        if (localac.aC(a.j.TextAppearance_android_textColor)) {
          localObject2 = localac.getColorStateList(a.j.TextAppearance_android_textColor);
        }
        if (localac.aC(a.j.TextAppearance_android_textColorHint)) {
          localObject1 = localac.getColorStateList(a.j.TextAppearance_android_textColorHint);
        }
        localObject4 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject3;
        if (localac.aC(a.j.TextAppearance_android_textColorLink))
        {
          localObject6 = localac.getColorStateList(a.j.TextAppearance_android_textColorLink);
          localObject5 = localObject1;
          localObject4 = localObject2;
        }
      }
      if ((Build.VERSION.SDK_INT >= 28) && (localac.aC(a.j.TextAppearance_android_textSize)) && (localac.p(a.j.TextAppearance_android_textSize, -1) == 0)) {
        this.ru.setTextSize(0, 0.0F);
      }
      a(localContext, localac);
      localac.wA.recycle();
      if (localObject4 != null) {
        this.ru.setTextColor((ColorStateList)localObject4);
      }
      if (localObject5 != null) {
        this.ru.setHintTextColor(localObject5);
      }
      if (localObject6 != null) {
        this.ru.setLinkTextColor((ColorStateList)localObject6);
      }
      if ((!bool3) && (j != 0)) {
        setAllCaps(bool2);
      }
      if (this.rC != null) {
        this.ru.setTypeface(this.rC, this.mStyle);
      }
      this.rB.a(paramAttributeSet, paramInt);
      if ((b.PX) && (this.rB.rJ != 0))
      {
        localObject1 = this.rB.rO;
        if (localObject1.length > 0)
        {
          if (this.ru.getAutoSizeStepGranularity() == -1.0F) {
            break label877;
          }
          this.ru.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.rB.rM), Math.round(this.rB.rN), Math.round(this.rB.rL), 0);
        }
      }
      for (;;)
      {
        paramAttributeSet = ac.a(localContext, paramAttributeSet, a.j.AppCompatTextView);
        paramInt = paramAttributeSet.p(a.j.AppCompatTextView_firstBaselineToTopHeight, -1);
        i = paramAttributeSet.p(a.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        j = paramAttributeSet.p(a.j.AppCompatTextView_lineHeight, -1);
        paramAttributeSet.wA.recycle();
        if (paramInt != -1) {
          i.b(this.ru, paramInt);
        }
        if (i != -1) {
          i.c(this.ru, i);
        }
        if (j != -1) {
          i.d(this.ru, j);
        }
        AppMethodBeat.o(241061);
        return;
        label877:
        this.ru.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
      }
      localObject1 = null;
      break label380;
      localObject4 = null;
      break label359;
      localObject2 = null;
      break label338;
      localObject1 = null;
      localObject4 = null;
      localObject2 = null;
      break label380;
      i = 0;
      bool1 = false;
      break;
      localObject3 = null;
      localObject1 = null;
      localObject2 = null;
      i = 0;
      bool1 = false;
    }
  }
  
  final void du()
  {
    AppMethodBeat.i(241066);
    Drawable[] arrayOfDrawable;
    if ((this.rv != null) || (this.rw != null) || (this.rx != null) || (this.ry != null))
    {
      arrayOfDrawable = this.ru.getCompoundDrawables();
      a(arrayOfDrawable[0], this.rv);
      a(arrayOfDrawable[1], this.rw);
      a(arrayOfDrawable[2], this.rx);
      a(arrayOfDrawable[3], this.ry);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.rz != null) || (this.rA != null)))
    {
      arrayOfDrawable = this.ru.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.rz);
      a(arrayOfDrawable[2], this.rA);
    }
    AppMethodBeat.o(241066);
  }
  
  final void dv()
  {
    AppMethodBeat.i(241072);
    if (!b.PX) {
      this.rB.dz();
    }
    AppMethodBeat.o(241072);
  }
  
  final void s(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(241064);
    ac localac = ac.a(paramContext, paramInt, a.j.TextAppearance);
    if (localac.aC(a.j.TextAppearance_textAllCaps)) {
      setAllCaps(localac.c(a.j.TextAppearance_textAllCaps, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localac.aC(a.j.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localac.getColorStateList(a.j.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        this.ru.setTextColor(localColorStateList);
      }
    }
    if ((localac.aC(a.j.TextAppearance_android_textSize)) && (localac.p(a.j.TextAppearance_android_textSize, -1) == 0)) {
      this.ru.setTextSize(0, 0.0F);
    }
    a(paramContext, localac);
    localac.wA.recycle();
    if (this.rC != null) {
      this.ru.setTypeface(this.rC, this.mStyle);
    }
    AppMethodBeat.o(241064);
  }
  
  final void setAllCaps(boolean paramBoolean)
  {
    AppMethodBeat.i(241065);
    this.ru.setAllCaps(paramBoolean);
    AppMethodBeat.o(241065);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241079);
    this.rB.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(241079);
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(241080);
    this.rB.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    AppMethodBeat.o(241080);
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    AppMethodBeat.i(241078);
    this.rB.setAutoSizeTextTypeWithDefaults(paramInt);
    AppMethodBeat.o(241078);
  }
  
  final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(241073);
    if ((!b.PX) && (!this.rB.dB())) {
      b(paramInt, paramFloat);
    }
    AppMethodBeat.o(241073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.k
 * JD-Core Version:    0.7.0.1
 */