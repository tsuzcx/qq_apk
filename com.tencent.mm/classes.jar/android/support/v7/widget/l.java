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
  private final TextView akW;
  private ax akX;
  private ax akY;
  private ax akZ;
  private ax ala;
  private ax alb;
  private ax alc;
  final m ald;
  Typeface ale;
  boolean alf;
  int mStyle = 0;
  
  l(TextView paramTextView)
  {
    this.akW = paramTextView;
    this.ald = new m(this.akW);
  }
  
  private static ax a(Context paramContext, g paramg, int paramInt)
  {
    paramContext = paramg.s(paramContext, paramInt);
    if (paramContext != null)
    {
      paramg = new ax();
      paramg.acG = true;
      paramg.Kh = paramContext;
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
      this.ale = null;
      if (paramaz.hasValue(11)) {
        if (!paramContext.isRestricted()) {
          paramContext = new f.a()
          {
            public final void D(int paramAnonymousInt) {}
            
            public final void a(Typeface paramAnonymousTypeface)
            {
              l locall = l.this;
              Object localObject = this.alg;
              if (locall.alf)
              {
                locall.ale = paramAnonymousTypeface;
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
      this.ale = paramaz.a(i, this.mStyle, paramContext);
      if (this.ale != null) {
        break label141;
      }
      bool = true;
      this.alf = bool;
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
    if (this.ale == null)
    {
      paramContext = paramaz.getString(i);
      if (paramContext != null) {
        this.ale = Typeface.create(paramContext, this.mStyle);
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
    this.alf = false;
    switch (paramaz.getInt(1, 1))
    {
    default: 
      return;
    case 1: 
      this.ale = Typeface.SANS_SERIF;
      return;
    case 2: 
      this.ale = Typeface.SERIF;
      return;
    }
    this.ale = Typeface.MONOSPACE;
  }
  
  private void a(Drawable paramDrawable, ax paramax)
  {
    if ((paramDrawable != null) && (paramax != null)) {
      g.a(paramDrawable, paramax, this.akW.getDrawableState());
    }
  }
  
  private void e(int paramInt, float paramFloat)
  {
    this.ald.e(paramInt, paramFloat);
  }
  
  @SuppressLint({"NewApi"})
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.akW.getContext();
    Object localObject1 = g.jb();
    Object localObject2 = az.a(localContext, paramAttributeSet, a.a.AppCompatTextHelper, paramInt, 0);
    int k = ((az)localObject2).getResourceId(0, -1);
    if (((az)localObject2).hasValue(3)) {
      this.akX = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(3, 0));
    }
    if (((az)localObject2).hasValue(1)) {
      this.akY = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(1, 0));
    }
    if (((az)localObject2).hasValue(4)) {
      this.akZ = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(4, 0));
    }
    if (((az)localObject2).hasValue(2)) {
      this.ala = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(2, 0));
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (((az)localObject2).hasValue(5)) {
        this.alb = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(5, 0));
      }
      if (((az)localObject2).hasValue(6)) {
        this.alc = a(localContext, (g)localObject1, ((az)localObject2).getResourceId(6, 0));
      }
    }
    ((az)localObject2).ayA.recycle();
    boolean bool3 = this.akW.getTransformationMethod() instanceof PasswordTransformationMethod;
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
      localaz2.ayA.recycle();
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
      this.akW.setTextSize(0, 0.0F);
    }
    a(localContext, localaz1);
    localaz1.ayA.recycle();
    if (localObject4 != null) {
      this.akW.setTextColor(localObject4);
    }
    if (localObject5 != null) {
      this.akW.setHintTextColor((ColorStateList)localObject5);
    }
    if (localObject6 != null) {
      this.akW.setLinkTextColor((ColorStateList)localObject6);
    }
    if ((!bool3) && (j != 0)) {
      setAllCaps(bool2);
    }
    if (this.ale != null) {
      this.akW.setTypeface(this.ale, this.mStyle);
    }
    this.ald.a(paramAttributeSet, paramInt);
    if ((b.Sp) && (this.ald.all != 0))
    {
      localObject1 = this.ald.alq;
      if (localObject1.length > 0)
      {
        if (this.akW.getAutoSizeStepGranularity() == -1.0F) {
          break label887;
        }
        this.akW.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.ald.alo), Math.round(this.ald.alp), Math.round(this.ald.aln), 0);
      }
    }
    for (;;)
    {
      paramAttributeSet = az.a(localContext, paramAttributeSet, a.a.AppCompatTextView);
      paramInt = paramAttributeSet.getDimensionPixelSize(6, -1);
      i = paramAttributeSet.getDimensionPixelSize(8, -1);
      j = paramAttributeSet.getDimensionPixelSize(9, -1);
      paramAttributeSet.ayA.recycle();
      if (paramInt != -1) {
        q.e(this.akW, paramInt);
      }
      if (i != -1) {
        q.f(this.akW, i);
      }
      if (j != -1) {
        q.g(this.akW, j);
      }
      return;
      label887:
      this.akW.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
    }
  }
  
  final void jf()
  {
    Drawable[] arrayOfDrawable;
    if ((this.akX != null) || (this.akY != null) || (this.akZ != null) || (this.ala != null))
    {
      arrayOfDrawable = this.akW.getCompoundDrawables();
      a(arrayOfDrawable[0], this.akX);
      a(arrayOfDrawable[1], this.akY);
      a(arrayOfDrawable[2], this.akZ);
      a(arrayOfDrawable[3], this.ala);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.alb != null) || (this.alc != null)))
    {
      arrayOfDrawable = this.akW.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.alb);
      a(arrayOfDrawable[2], this.alc);
    }
  }
  
  final void jg()
  {
    if (!b.Sp) {
      this.ald.jk();
    }
  }
  
  final void setAllCaps(boolean paramBoolean)
  {
    this.akW.setAllCaps(paramBoolean);
  }
  
  final void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ald.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  final void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    this.ald.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  final void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    this.ald.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  final void setTextSize(int paramInt, float paramFloat)
  {
    if ((!b.Sp) && (!this.ald.jm())) {
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
        this.akW.setTextColor(localColorStateList);
      }
    }
    if ((localaz.hasValue(0)) && (localaz.getDimensionPixelSize(0, -1) == 0)) {
      this.akW.setTextSize(0, 0.0F);
    }
    a(paramContext, localaz);
    localaz.ayA.recycle();
    if (this.ale != null) {
      this.akW.setTypeface(this.ale, this.mStyle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.l
 * JD-Core Version:    0.7.0.1
 */