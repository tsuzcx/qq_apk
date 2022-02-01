package androidx.appcompat.widget;

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
import androidx.core.content.a.f.c;
import androidx.core.widget.b;
import androidx.core.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

class k
{
  int mStyle;
  final l sA;
  Typeface sB;
  boolean sC;
  private final TextView ss;
  private aa st;
  private aa su;
  private aa sv;
  private aa sx;
  private aa sy;
  private aa sz;
  
  k(TextView paramTextView)
  {
    AppMethodBeat.i(199899);
    this.mStyle = 0;
    this.ss = paramTextView;
    this.sA = new l(this.ss);
    AppMethodBeat.o(199899);
  }
  
  private static aa a(Context paramContext, f paramf, int paramInt)
  {
    AppMethodBeat.i(199928);
    paramContext = paramf.q(paramContext, paramInt);
    if (paramContext != null)
    {
      paramf = new aa();
      paramf.kB = true;
      paramf.kz = paramContext;
      AppMethodBeat.o(199928);
      return paramf;
    }
    AppMethodBeat.o(199928);
    return null;
  }
  
  private void a(Context paramContext, ac paramac)
  {
    boolean bool = true;
    AppMethodBeat.i(199911);
    this.mStyle = paramac.getInt(a.j.TextAppearance_android_textStyle, this.mStyle);
    if ((paramac.az(a.j.TextAppearance_android_fontFamily)) || (paramac.az(a.j.TextAppearance_fontFamily)))
    {
      this.sB = null;
      int i;
      if (paramac.az(a.j.TextAppearance_fontFamily))
      {
        i = a.j.TextAppearance_fontFamily;
        if (!paramContext.isRestricted()) {
          paramContext = new f.c()
          {
            public final void as(int paramAnonymousInt) {}
            
            public final void b(Typeface paramAnonymousTypeface)
            {
              AppMethodBeat.i(199355);
              k localk = k.this;
              Object localObject = this.sD;
              if (localk.sC)
              {
                localk.sB = paramAnonymousTypeface;
                localObject = (TextView)((WeakReference)localObject).get();
                if (localObject != null) {
                  ((TextView)localObject).setTypeface(paramAnonymousTypeface, localk.mStyle);
                }
              }
              AppMethodBeat.o(199355);
            }
          };
        }
      }
      for (;;)
      {
        try
        {
          this.sB = paramac.a(i, this.mStyle, paramContext);
          if (this.sB != null) {
            continue;
          }
          this.sC = bool;
        }
        catch (UnsupportedOperationException paramContext)
        {
          continue;
        }
        catch (Resources.NotFoundException paramContext)
        {
          continue;
        }
        if (this.sB == null)
        {
          paramContext = paramac.getString(i);
          if (paramContext != null) {
            this.sB = Typeface.create(paramContext, this.mStyle);
          }
        }
        AppMethodBeat.o(199911);
        return;
        i = a.j.TextAppearance_android_fontFamily;
        break;
        bool = false;
      }
    }
    if (paramac.az(a.j.TextAppearance_android_typeface))
    {
      this.sC = false;
      switch (paramac.getInt(a.j.TextAppearance_android_typeface, 1))
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(199911);
      return;
      this.sB = Typeface.SANS_SERIF;
      AppMethodBeat.o(199911);
      return;
      this.sB = Typeface.SERIF;
      AppMethodBeat.o(199911);
      return;
      this.sB = Typeface.MONOSPACE;
    }
  }
  
  private void a(Drawable paramDrawable, aa paramaa)
  {
    AppMethodBeat.i(199921);
    if ((paramDrawable != null) && (paramaa != null)) {
      f.a(paramDrawable, paramaa, this.ss.getDrawableState());
    }
    AppMethodBeat.o(199921);
  }
  
  private void c(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(199936);
    this.sA.c(paramInt, paramFloat);
    AppMethodBeat.o(199936);
  }
  
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(199961);
    Context localContext = this.ss.getContext();
    Object localObject1 = f.ep();
    Object localObject2 = ac.a(localContext, paramAttributeSet, a.j.AppCompatTextHelper, paramInt, 0);
    int i = ((ac)localObject2).w(a.j.AppCompatTextHelper_android_textAppearance, -1);
    if (((ac)localObject2).az(a.j.AppCompatTextHelper_android_drawableLeft)) {
      this.st = a(localContext, (f)localObject1, ((ac)localObject2).w(a.j.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((ac)localObject2).az(a.j.AppCompatTextHelper_android_drawableTop)) {
      this.su = a(localContext, (f)localObject1, ((ac)localObject2).w(a.j.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((ac)localObject2).az(a.j.AppCompatTextHelper_android_drawableRight)) {
      this.sv = a(localContext, (f)localObject1, ((ac)localObject2).w(a.j.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((ac)localObject2).az(a.j.AppCompatTextHelper_android_drawableBottom)) {
      this.sx = a(localContext, (f)localObject1, ((ac)localObject2).w(a.j.AppCompatTextHelper_android_drawableBottom, 0));
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (((ac)localObject2).az(a.j.AppCompatTextHelper_android_drawableStart)) {
        this.sy = a(localContext, (f)localObject1, ((ac)localObject2).w(a.j.AppCompatTextHelper_android_drawableStart, 0));
      }
      if (((ac)localObject2).az(a.j.AppCompatTextHelper_android_drawableEnd)) {
        this.sz = a(localContext, (f)localObject1, ((ac)localObject2).w(a.j.AppCompatTextHelper_android_drawableEnd, 0));
      }
    }
    ((ac)localObject2).xv.recycle();
    boolean bool3 = this.ss.getTransformationMethod() instanceof PasswordTransformationMethod;
    Object localObject3;
    boolean bool1;
    label338:
    Object localObject4;
    if (i != -1)
    {
      localObject3 = ac.a(localContext, i, a.j.TextAppearance);
      if ((!bool3) && (((ac)localObject3).az(a.j.TextAppearance_textAllCaps)))
      {
        bool1 = ((ac)localObject3).m(a.j.TextAppearance_textAllCaps, false);
        i = 1;
        a(localContext, (ac)localObject3);
        if (Build.VERSION.SDK_INT < 23) {
          if (((ac)localObject3).az(a.j.TextAppearance_android_textColor))
          {
            localObject2 = ((ac)localObject3).getColorStateList(a.j.TextAppearance_android_textColor);
            if (((ac)localObject3).az(a.j.TextAppearance_android_textColorHint))
            {
              localObject4 = ((ac)localObject3).getColorStateList(a.j.TextAppearance_android_textColorHint);
              label359:
              if (((ac)localObject3).az(a.j.TextAppearance_android_textColorLink))
              {
                localObject1 = ((ac)localObject3).getColorStateList(a.j.TextAppearance_android_textColorLink);
                label380:
                ((ac)localObject3).xv.recycle();
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
        if (localac.az(a.j.TextAppearance_textAllCaps))
        {
          bool2 = localac.m(a.j.TextAppearance_textAllCaps, false);
          j = 1;
        }
      }
      localObject4 = localObject2;
      Object localObject5 = localObject1;
      Object localObject6 = localObject3;
      if (Build.VERSION.SDK_INT < 23)
      {
        if (localac.az(a.j.TextAppearance_android_textColor)) {
          localObject2 = localac.getColorStateList(a.j.TextAppearance_android_textColor);
        }
        if (localac.az(a.j.TextAppearance_android_textColorHint)) {
          localObject1 = localac.getColorStateList(a.j.TextAppearance_android_textColorHint);
        }
        localObject4 = localObject2;
        localObject5 = localObject1;
        localObject6 = localObject3;
        if (localac.az(a.j.TextAppearance_android_textColorLink))
        {
          localObject6 = localac.getColorStateList(a.j.TextAppearance_android_textColorLink);
          localObject5 = localObject1;
          localObject4 = localObject2;
        }
      }
      if ((Build.VERSION.SDK_INT >= 28) && (localac.az(a.j.TextAppearance_android_textSize)) && (localac.u(a.j.TextAppearance_android_textSize, -1) == 0)) {
        this.ss.setTextSize(0, 0.0F);
      }
      a(localContext, localac);
      localac.xv.recycle();
      if (localObject4 != null) {
        this.ss.setTextColor((ColorStateList)localObject4);
      }
      if (localObject5 != null) {
        this.ss.setHintTextColor(localObject5);
      }
      if (localObject6 != null) {
        this.ss.setLinkTextColor((ColorStateList)localObject6);
      }
      if ((!bool3) && (j != 0)) {
        setAllCaps(bool2);
      }
      if (this.sB != null) {
        this.ss.setTypeface(this.sB, this.mStyle);
      }
      this.sA.a(paramAttributeSet, paramInt);
      if ((b.bwp) && (this.sA.sI != 0))
      {
        localObject1 = this.sA.sN;
        if (localObject1.length > 0)
        {
          if (this.ss.getAutoSizeStepGranularity() == -1.0F) {
            break label877;
          }
          this.ss.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.sA.sL), Math.round(this.sA.sM), Math.round(this.sA.sK), 0);
        }
      }
      for (;;)
      {
        paramAttributeSet = ac.a(localContext, paramAttributeSet, a.j.AppCompatTextView);
        paramInt = paramAttributeSet.u(a.j.AppCompatTextView_firstBaselineToTopHeight, -1);
        i = paramAttributeSet.u(a.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        j = paramAttributeSet.u(a.j.AppCompatTextView_lineHeight, -1);
        paramAttributeSet.xv.recycle();
        if (paramInt != -1) {
          j.c(this.ss, paramInt);
        }
        if (i != -1) {
          j.d(this.ss, i);
        }
        if (j != -1) {
          j.e(this.ss, j);
        }
        AppMethodBeat.o(199961);
        return;
        label877:
        this.ss.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
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
  
  final void et()
  {
    AppMethodBeat.i(199996);
    Drawable[] arrayOfDrawable;
    if ((this.st != null) || (this.su != null) || (this.sv != null) || (this.sx != null))
    {
      arrayOfDrawable = this.ss.getCompoundDrawables();
      a(arrayOfDrawable[0], this.st);
      a(arrayOfDrawable[1], this.su);
      a(arrayOfDrawable[2], this.sv);
      a(arrayOfDrawable[3], this.sx);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.sy != null) || (this.sz != null)))
    {
      arrayOfDrawable = this.ss.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.sy);
      a(arrayOfDrawable[2], this.sz);
    }
    AppMethodBeat.o(199996);
  }
  
  final void eu()
  {
    AppMethodBeat.i(200006);
    if (!b.bwp) {
      this.sA.ey();
    }
    AppMethodBeat.o(200006);
  }
  
  final void s(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199973);
    ac localac = ac.a(paramContext, paramInt, a.j.TextAppearance);
    if (localac.az(a.j.TextAppearance_textAllCaps)) {
      setAllCaps(localac.m(a.j.TextAppearance_textAllCaps, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localac.az(a.j.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localac.getColorStateList(a.j.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        this.ss.setTextColor(localColorStateList);
      }
    }
    if ((localac.az(a.j.TextAppearance_android_textSize)) && (localac.u(a.j.TextAppearance_android_textSize, -1) == 0)) {
      this.ss.setTextSize(0, 0.0F);
    }
    a(paramContext, localac);
    localac.xv.recycle();
    if (this.sB != null) {
      this.ss.setTypeface(this.sB, this.mStyle);
    }
    AppMethodBeat.o(199973);
  }
  
  final void setAllCaps(boolean paramBoolean)
  {
    AppMethodBeat.i(199981);
    this.ss.setAllCaps(paramBoolean);
    AppMethodBeat.o(199981);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200034);
    this.sA.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(200034);
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(200040);
    this.sA.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    AppMethodBeat.o(200040);
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    AppMethodBeat.i(200026);
    this.sA.setAutoSizeTextTypeWithDefaults(paramInt);
    AppMethodBeat.o(200026);
  }
  
  final void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(200017);
    if ((!b.bwp) && (!this.sA.eA())) {
      c(paramInt, paramFloat);
    }
    AppMethodBeat.o(200017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.k
 * JD-Core Version:    0.7.0.1
 */