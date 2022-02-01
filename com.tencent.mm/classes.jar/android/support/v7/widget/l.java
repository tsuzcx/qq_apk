package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.a.f.a;
import android.support.v4.widget.b;
import android.support.v4.widget.q;
import android.support.v7.a.a.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

final class l
{
  private final TextView alj;
  private ax alk;
  private ax all;
  private ax alm;
  private ax aln;
  private ax alo;
  private ax alp;
  final m alq;
  Typeface alr;
  boolean als;
  int mStyle = 0;
  
  l(TextView paramTextView)
  {
    this.alj = paramTextView;
    this.alq = new m(this.alj);
  }
  
  private static ax a(Context paramContext, g paramg, int paramInt)
  {
    paramContext = paramg.s(paramContext, paramInt);
    if (paramContext != null)
    {
      paramg = new ax();
      paramg.acT = true;
      paramg.Kr = paramContext;
      return paramg;
    }
    return null;
  }
  
  private void a(Context paramContext, az paramaz)
  {
    int i = 11;
    this.mStyle = paramaz.getInt(2, this.mStyle);
    if ((paramaz.hasValue(10)) || (paramaz.hasValue(11)))
    {
      this.alr = null;
      if (paramaz.hasValue(11)) {
        if (!paramContext.isRestricted()) {
          paramContext = new f.a()
          {
            public final void D(int paramAnonymousInt) {}
            
            public final void a(Typeface paramAnonymousTypeface)
            {
              l locall = l.this;
              Object localObject = this.alt;
              if (locall.als)
              {
                locall.alr = paramAnonymousTypeface;
                localObject = (TextView)((WeakReference)localObject).get();
                if (localObject != null) {
                  ((TextView)localObject).setTypeface(paramAnonymousTypeface, locall.mStyle);
                }
              }
            }
          };
        }
      }
    }
    try
    {
      this.alr = paramaz.a(i, this.mStyle, paramContext);
      if (this.alr != null) {
        break label141;
      }
      bool = true;
      this.als = bool;
    }
    catch (UnsupportedOperationException paramContext)
    {
      break label105;
    }
    catch (Resources.NotFoundException paramContext)
    {
      label105:
      break label105;
    }
    if (this.alr == null)
    {
      paramContext = paramaz.getString(i);
      if (paramContext != null) {
        this.alr = Typeface.create(paramContext, this.mStyle);
      }
    }
    label141:
    while (!paramaz.hasValue(1)) {
      for (;;)
      {
        return;
        i = 10;
        continue;
        boolean bool = false;
      }
    }
    this.als = false;
    switch (paramaz.getInt(1, 1))
    {
    default: 
      return;
    case 1: 
      this.alr = Typeface.SANS_SERIF;
      return;
    case 2: 
      this.alr = Typeface.SERIF;
      return;
    }
    this.alr = Typeface.MONOSPACE;
  }
  
  private void a(Drawable paramDrawable, ax paramax)
  {
    if ((paramDrawable != null) && (paramax != null)) {
      g.a(paramDrawable, paramax, this.alj.getDrawableState());
    }
  }
  
  private void e(int paramInt, float paramFloat)
  {
    this.alq.e(paramInt, paramFloat);
  }
  
  @SuppressLint({"NewApi"})
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.alj.getContext();
    Object localObject1 = g.jk();
    Object localObject2 = az.a(localContext, paramAttributeSet, a.a.AppCompatTextHelper, paramInt, 0);
    int k = ((az)localObject2).getResourceId(0, -1);
    if (((az)localObject2).hasValue(3)) {
      this.alk = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(3, 0));
    }
    if (((az)localObject2).hasValue(1)) {
      this.all = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(1, 0));
    }
    if (((az)localObject2).hasValue(4)) {
      this.alm = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(4, 0));
    }
    if (((az)localObject2).hasValue(2)) {
      this.aln = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(2, 0));
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (((az)localObject2).hasValue(5)) {
        this.alo = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(5, 0));
      }
      if (((az)localObject2).hasValue(6)) {
        this.alp = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(6, 0));
      }
    }
    ((az)localObject2).ayy.recycle();
    boolean bool3 = this.alj.getTransformationMethod() instanceof PasswordTransformationMethod;
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    int j = 0;
    Object localObject7 = null;
    localObject2 = null;
    az localaz1 = null;
    Object localObject4 = null;
    localObject1 = null;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject6 = null;
    if (k != -1)
    {
      az localaz2 = az.a(localContext, k, a.a.TextAppearance);
      i = j;
      bool1 = bool2;
      if (!bool3)
      {
        i = j;
        bool1 = bool2;
        if (localaz2.hasValue(12))
        {
          i = 1;
          bool1 = localaz2.getBoolean(12, false);
        }
      }
      a(localContext, localaz2);
      localObject2 = localObject7;
      localObject3 = localObject6;
      if (Build.VERSION.SDK_INT < 23)
      {
        localObject1 = localaz1;
        if (localaz2.hasValue(3)) {
          localObject1 = localaz2.getColorStateList(3);
        }
        if (localaz2.hasValue(4)) {
          localObject5 = localaz2.getColorStateList(4);
        }
        localObject2 = localObject1;
        localObject4 = localObject5;
        localObject3 = localObject6;
        if (localaz2.hasValue(5))
        {
          localObject3 = localaz2.getColorStateList(5);
          localObject4 = localObject5;
          localObject2 = localObject1;
        }
      }
      localaz2.ayy.recycle();
      localObject1 = localObject4;
    }
    localaz1 = az.a(localContext, paramAttributeSet, a.a.TextAppearance, paramInt, 0);
    j = i;
    bool2 = bool1;
    if (!bool3)
    {
      j = i;
      bool2 = bool1;
      if (localaz1.hasValue(12))
      {
        j = 1;
        bool2 = localaz1.getBoolean(12, false);
      }
    }
    localObject4 = localObject2;
    localObject5 = localObject1;
    localObject6 = localObject3;
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localaz1.hasValue(3)) {
        localObject2 = localaz1.getColorStateList(3);
      }
      if (localaz1.hasValue(4)) {
        localObject1 = localaz1.getColorStateList(4);
      }
      localObject4 = localObject2;
      localObject5 = localObject1;
      localObject6 = localObject3;
      if (localaz1.hasValue(5))
      {
        localObject6 = localaz1.getColorStateList(5);
        localObject5 = localObject1;
        localObject4 = localObject2;
      }
    }
    if ((Build.VERSION.SDK_INT >= 28) && (localaz1.hasValue(0)) && (localaz1.getDimensionPixelSize(0, -1) == 0)) {
      this.alj.setTextSize(0, 0.0F);
    }
    a(localContext, localaz1);
    localaz1.ayy.recycle();
    if (localObject4 != null) {
      this.alj.setTextColor(localObject4);
    }
    if (localObject5 != null) {
      this.alj.setHintTextColor((ColorStateList)localObject5);
    }
    if (localObject6 != null) {
      this.alj.setLinkTextColor((ColorStateList)localObject6);
    }
    if ((!bool3) && (j != 0)) {
      setAllCaps(bool2);
    }
    if (this.alr != null) {
      this.alj.setTypeface(this.alr, this.mStyle);
    }
    this.alq.a(paramAttributeSet, paramInt);
    if ((b.SC) && (this.alq.aly != 0))
    {
      localObject1 = this.alq.alD;
      if (localObject1.length > 0)
      {
        if (this.alj.getAutoSizeStepGranularity() == -1.0F) {
          break label887;
        }
        this.alj.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.alq.alB), Math.round(this.alq.alC), Math.round(this.alq.alA), 0);
      }
    }
    for (;;)
    {
      paramAttributeSet = az.a(localContext, paramAttributeSet, a.a.AppCompatTextView);
      paramInt = paramAttributeSet.getDimensionPixelSize(6, -1);
      i = paramAttributeSet.getDimensionPixelSize(8, -1);
      j = paramAttributeSet.getDimensionPixelSize(9, -1);
      paramAttributeSet.ayy.recycle();
      if (paramInt != -1) {
        q.e(this.alj, paramInt);
      }
      if (i != -1) {
        q.f(this.alj, i);
      }
      if (j != -1) {
        q.g(this.alj, j);
      }
      return;
      label887:
      this.alj.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
    }
  }
  
  final void jo()
  {
    Drawable[] arrayOfDrawable;
    if ((this.alk != null) || (this.all != null) || (this.alm != null) || (this.aln != null))
    {
      arrayOfDrawable = this.alj.getCompoundDrawables();
      a(arrayOfDrawable[0], this.alk);
      a(arrayOfDrawable[1], this.all);
      a(arrayOfDrawable[2], this.alm);
      a(arrayOfDrawable[3], this.aln);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.alo != null) || (this.alp != null)))
    {
      arrayOfDrawable = this.alj.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.alo);
      a(arrayOfDrawable[2], this.alp);
    }
  }
  
  final void jp()
  {
    if (!b.SC) {
      this.alq.jt();
    }
  }
  
  final void setAllCaps(boolean paramBoolean)
  {
    this.alj.setAllCaps(paramBoolean);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.alq.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    this.alq.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    this.alq.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  final void setTextSize(int paramInt, float paramFloat)
  {
    if ((!b.SC) && (!this.alq.jv())) {
      e(paramInt, paramFloat);
    }
  }
  
  final void u(Context paramContext, int paramInt)
  {
    az localaz = az.a(paramContext, paramInt, a.a.TextAppearance);
    if (localaz.hasValue(12)) {
      setAllCaps(localaz.getBoolean(12, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localaz.hasValue(3)))
    {
      ColorStateList localColorStateList = localaz.getColorStateList(3);
      if (localColorStateList != null) {
        this.alj.setTextColor(localColorStateList);
      }
    }
    if ((localaz.hasValue(0)) && (localaz.getDimensionPixelSize(0, -1) == 0)) {
      this.alj.setTextSize(0, 0.0F);
    }
    a(paramContext, localaz);
    localaz.ayy.recycle();
    if (this.alr != null) {
      this.alj.setTypeface(this.alr, this.mStyle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.l
 * JD-Core Version:    0.7.0.1
 */