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
  private final TextView abf;
  private ax abg;
  private ax abh;
  private ax abi;
  private ax abj;
  private ax abk;
  private ax abl;
  final m abm;
  Typeface abn;
  boolean abo;
  int mStyle = 0;
  
  l(TextView paramTextView)
  {
    this.abf = paramTextView;
    this.abm = new m(this.abf);
  }
  
  private static ax a(Context paramContext, g paramg, int paramInt)
  {
    paramContext = paramg.r(paramContext, paramInt);
    if (paramContext != null)
    {
      paramg = new ax();
      paramg.SS = true;
      paramg.AW = paramContext;
      return paramg;
    }
    return null;
  }
  
  private void a(Context paramContext, az paramaz)
  {
    int i = 12;
    this.mStyle = paramaz.getInt(2, this.mStyle);
    if ((paramaz.hasValue(10)) || (paramaz.hasValue(12)))
    {
      this.abn = null;
      if (paramaz.hasValue(12)) {
        if (!paramContext.isRestricted()) {
          paramContext = new f.a()
          {
            public final void b(Typeface paramAnonymousTypeface)
            {
              l locall = l.this;
              Object localObject = this.abp;
              if (locall.abo)
              {
                locall.abn = paramAnonymousTypeface;
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
      this.abn = paramaz.a(i, this.mStyle, paramContext);
      if (this.abn != null) {
        break label141;
      }
      bool = true;
      this.abo = bool;
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
    if (this.abn == null)
    {
      paramContext = paramaz.getString(i);
      if (paramContext != null) {
        this.abn = Typeface.create(paramContext, this.mStyle);
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
    this.abo = false;
    switch (paramaz.getInt(1, 1))
    {
    default: 
      return;
    case 1: 
      this.abn = Typeface.SANS_SERIF;
      return;
    case 2: 
      this.abn = Typeface.SERIF;
      return;
    }
    this.abn = Typeface.MONOSPACE;
  }
  
  private void a(Drawable paramDrawable, ax paramax)
  {
    if ((paramDrawable != null) && (paramax != null)) {
      g.a(paramDrawable, paramax, this.abf.getDrawableState());
    }
  }
  
  private void e(int paramInt, float paramFloat)
  {
    this.abm.e(paramInt, paramFloat);
  }
  
  @SuppressLint({"NewApi"})
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.abf.getContext();
    Object localObject1 = g.hg();
    Object localObject2 = az.a(localContext, paramAttributeSet, a.a.AppCompatTextHelper, paramInt, 0);
    int k = ((az)localObject2).getResourceId(0, -1);
    if (((az)localObject2).hasValue(3)) {
      this.abg = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(3, 0));
    }
    if (((az)localObject2).hasValue(1)) {
      this.abh = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(1, 0));
    }
    if (((az)localObject2).hasValue(4)) {
      this.abi = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(4, 0));
    }
    if (((az)localObject2).hasValue(2)) {
      this.abj = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(2, 0));
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (((az)localObject2).hasValue(5)) {
        this.abk = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(5, 0));
      }
      if (((az)localObject2).hasValue(6)) {
        this.abl = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(6, 0));
      }
    }
    ((az)localObject2).aoo.recycle();
    boolean bool3 = this.abf.getTransformationMethod() instanceof PasswordTransformationMethod;
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
        if (localaz2.hasValue(11))
        {
          i = 1;
          bool1 = localaz2.getBoolean(11, false);
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
      localaz2.aoo.recycle();
      localObject1 = localObject4;
    }
    localaz1 = az.a(localContext, paramAttributeSet, a.a.TextAppearance, paramInt, 0);
    j = i;
    bool2 = bool1;
    if (!bool3)
    {
      j = i;
      bool2 = bool1;
      if (localaz1.hasValue(11))
      {
        j = 1;
        bool2 = localaz1.getBoolean(11, false);
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
      this.abf.setTextSize(0, 0.0F);
    }
    a(localContext, localaz1);
    localaz1.aoo.recycle();
    if (localObject4 != null) {
      this.abf.setTextColor(localObject4);
    }
    if (localObject5 != null) {
      this.abf.setHintTextColor((ColorStateList)localObject5);
    }
    if (localObject6 != null) {
      this.abf.setLinkTextColor((ColorStateList)localObject6);
    }
    if ((!bool3) && (j != 0)) {
      setAllCaps(bool2);
    }
    if (this.abn != null) {
      this.abf.setTypeface(this.abn, this.mStyle);
    }
    this.abm.a(paramAttributeSet, paramInt);
    if ((b.IG) && (this.abm.abu != 0))
    {
      localObject1 = this.abm.abz;
      if (localObject1.length > 0)
      {
        if (this.abf.getAutoSizeStepGranularity() == -1.0F) {
          break label887;
        }
        this.abf.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.abm.abx), Math.round(this.abm.aby), Math.round(this.abm.abw), 0);
      }
    }
    for (;;)
    {
      paramAttributeSet = az.a(localContext, paramAttributeSet, a.a.AppCompatTextView);
      paramInt = paramAttributeSet.getDimensionPixelSize(9, -1);
      i = paramAttributeSet.getDimensionPixelSize(10, -1);
      j = paramAttributeSet.getDimensionPixelSize(8, -1);
      paramAttributeSet.aoo.recycle();
      if (paramInt != -1) {
        q.c(this.abf, paramInt);
      }
      if (i != -1) {
        q.d(this.abf, i);
      }
      if (j != -1) {
        q.e(this.abf, j);
      }
      return;
      label887:
      this.abf.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
    }
  }
  
  final void hk()
  {
    Drawable[] arrayOfDrawable;
    if ((this.abg != null) || (this.abh != null) || (this.abi != null) || (this.abj != null))
    {
      arrayOfDrawable = this.abf.getCompoundDrawables();
      a(arrayOfDrawable[0], this.abg);
      a(arrayOfDrawable[1], this.abh);
      a(arrayOfDrawable[2], this.abi);
      a(arrayOfDrawable[3], this.abj);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.abk != null) || (this.abl != null)))
    {
      arrayOfDrawable = this.abf.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.abk);
      a(arrayOfDrawable[2], this.abl);
    }
  }
  
  final void hl()
  {
    if (!b.IG) {
      this.abm.hp();
    }
  }
  
  final void setAllCaps(boolean paramBoolean)
  {
    this.abf.setAllCaps(paramBoolean);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.abm.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    this.abm.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    this.abm.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  final void setTextSize(int paramInt, float paramFloat)
  {
    if ((!b.IG) && (!this.abm.hr())) {
      e(paramInt, paramFloat);
    }
  }
  
  final void t(Context paramContext, int paramInt)
  {
    az localaz = az.a(paramContext, paramInt, a.a.TextAppearance);
    if (localaz.hasValue(11)) {
      setAllCaps(localaz.getBoolean(11, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localaz.hasValue(3)))
    {
      ColorStateList localColorStateList = localaz.getColorStateList(3);
      if (localColorStateList != null) {
        this.abf.setTextColor(localColorStateList);
      }
    }
    if ((localaz.hasValue(0)) && (localaz.getDimensionPixelSize(0, -1) == 0)) {
      this.abf.setTextSize(0, 0.0F);
    }
    a(paramContext, localaz);
    localaz.aoo.recycle();
    if (this.abn != null) {
      this.abf.setTypeface(this.abn, this.mStyle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.l
 * JD-Core Version:    0.7.0.1
 */