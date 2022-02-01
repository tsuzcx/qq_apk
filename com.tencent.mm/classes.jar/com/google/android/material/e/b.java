package com.google.android.material.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.core.content.a.f;
import androidx.core.content.a.f.c;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  public final ColorStateList dvK;
  public final ColorStateList dwl;
  public final ColorStateList dwm;
  public final int dwn;
  public final boolean dwo;
  public final ColorStateList dwp;
  public final float dwq;
  public final float dwr;
  private final int dws;
  private boolean dwt;
  private Typeface dwu;
  public final String fontFamily;
  public final float shadowRadius;
  public final float textSize;
  public final int typeface;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(209027);
    this.dwt = false;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, a.k.TextAppearance);
    this.textSize = localTypedArray.getDimension(a.k.TextAppearance_android_textSize, 0.0F);
    this.dvK = a.b(paramContext, localTypedArray, a.k.TextAppearance_android_textColor);
    this.dwl = a.b(paramContext, localTypedArray, a.k.TextAppearance_android_textColorHint);
    this.dwm = a.b(paramContext, localTypedArray, a.k.TextAppearance_android_textColorLink);
    this.dwn = localTypedArray.getInt(a.k.TextAppearance_android_textStyle, 0);
    this.typeface = localTypedArray.getInt(a.k.TextAppearance_android_typeface, 1);
    paramInt = a.k.TextAppearance_fontFamily;
    int i = a.k.TextAppearance_android_fontFamily;
    if (localTypedArray.hasValue(paramInt)) {}
    for (;;)
    {
      this.dws = localTypedArray.getResourceId(paramInt, 0);
      this.fontFamily = localTypedArray.getString(paramInt);
      this.dwo = localTypedArray.getBoolean(a.k.TextAppearance_textAllCaps, false);
      this.dwp = a.b(paramContext, localTypedArray, a.k.TextAppearance_android_shadowColor);
      this.dwq = localTypedArray.getFloat(a.k.TextAppearance_android_shadowDx, 0.0F);
      this.dwr = localTypedArray.getFloat(a.k.TextAppearance_android_shadowDy, 0.0F);
      this.shadowRadius = localTypedArray.getFloat(a.k.TextAppearance_android_shadowRadius, 0.0F);
      localTypedArray.recycle();
      AppMethodBeat.o(209027);
      return;
      paramInt = i;
    }
  }
  
  private void WR()
  {
    AppMethodBeat.i(209067);
    if (this.dwu == null) {
      this.dwu = Typeface.create(this.fontFamily, this.dwn);
    }
    if (this.dwu == null) {
      switch (this.typeface)
      {
      default: 
        this.dwu = Typeface.DEFAULT;
      }
    }
    for (;;)
    {
      if (this.dwu != null) {
        this.dwu = Typeface.create(this.dwu, this.dwn);
      }
      AppMethodBeat.o(209067);
      return;
      this.dwu = Typeface.SANS_SERIF;
      continue;
      this.dwu = Typeface.SERIF;
      continue;
      this.dwu = Typeface.MONOSPACE;
    }
  }
  
  private void a(Context paramContext, final TextPaint paramTextPaint, final f.c paramc)
  {
    AppMethodBeat.i(209056);
    if (this.dwt)
    {
      a(paramTextPaint, this.dwu);
      AppMethodBeat.o(209056);
      return;
    }
    WR();
    if (paramContext.isRestricted())
    {
      this.dwt = true;
      a(paramTextPaint, this.dwu);
      AppMethodBeat.o(209056);
      return;
    }
    try
    {
      f.a(paramContext, this.dws, new f.c()
      {
        public final void as(int paramAnonymousInt)
        {
          AppMethodBeat.i(209063);
          b.c(b.this);
          b.b(b.this);
          paramc.as(paramAnonymousInt);
          AppMethodBeat.o(209063);
        }
        
        public final void b(Typeface paramAnonymousTypeface)
        {
          AppMethodBeat.i(209054);
          b.a(b.this, Typeface.create(paramAnonymousTypeface, b.this.dwn));
          b.this.a(paramTextPaint, paramAnonymousTypeface);
          b.b(b.this);
          paramc.b(paramAnonymousTypeface);
          AppMethodBeat.o(209054);
        }
      });
      AppMethodBeat.o(209056);
      return;
    }
    catch (UnsupportedOperationException paramContext)
    {
      AppMethodBeat.o(209056);
      return;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("Error loading font ").append(this.fontFamily);
      AppMethodBeat.o(209056);
      return;
    }
    catch (Resources.NotFoundException paramContext)
    {
      label83:
      break label83;
    }
  }
  
  private Typeface aQ(Context paramContext)
  {
    AppMethodBeat.i(209037);
    if (this.dwt)
    {
      paramContext = this.dwu;
      AppMethodBeat.o(209037);
      return paramContext;
    }
    if (!paramContext.isRestricted()) {}
    try
    {
      this.dwu = f.x(paramContext, this.dws);
      if (this.dwu != null) {
        this.dwu = Typeface.create(this.dwu, this.dwn);
      }
      label65:
      WR();
      this.dwt = true;
      paramContext = this.dwu;
      AppMethodBeat.o(209037);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        new StringBuilder("Error loading font ").append(this.fontFamily);
      }
    }
    catch (UnsupportedOperationException paramContext)
    {
      break label65;
    }
    catch (Resources.NotFoundException paramContext)
    {
      break label65;
    }
  }
  
  public final void a(TextPaint paramTextPaint, Typeface paramTypeface)
  {
    AppMethodBeat.i(209143);
    paramTextPaint.setTypeface(paramTypeface);
    int i = this.dwn;
    i = (paramTypeface.getStyle() ^ 0xFFFFFFFF) & i;
    boolean bool;
    if ((i & 0x1) != 0)
    {
      bool = true;
      paramTextPaint.setFakeBoldText(bool);
      if ((i & 0x2) == 0) {
        break label79;
      }
    }
    label79:
    for (float f = -0.25F;; f = 0.0F)
    {
      paramTextPaint.setTextSkewX(f);
      paramTextPaint.setTextSize(this.textSize);
      AppMethodBeat.o(209143);
      return;
      bool = false;
      break;
    }
  }
  
  public final void b(Context paramContext, TextPaint paramTextPaint, f.c paramc)
  {
    AppMethodBeat.i(209119);
    c(paramContext, paramTextPaint, paramc);
    float f1;
    float f2;
    float f3;
    if (this.dvK != null)
    {
      i = this.dvK.getColorForState(paramTextPaint.drawableState, this.dvK.getDefaultColor());
      paramTextPaint.setColor(i);
      f1 = this.shadowRadius;
      f2 = this.dwq;
      f3 = this.dwr;
      if (this.dwp == null) {
        break label118;
      }
    }
    label118:
    for (int i = this.dwp.getColorForState(paramTextPaint.drawableState, this.dwp.getDefaultColor());; i = 0)
    {
      paramTextPaint.setShadowLayer(f1, f2, f3, i);
      AppMethodBeat.o(209119);
      return;
      i = -16777216;
      break;
    }
  }
  
  public final void c(Context paramContext, TextPaint paramTextPaint, f.c paramc)
  {
    AppMethodBeat.i(209129);
    if (c.dwy)
    {
      a(paramTextPaint, aQ(paramContext));
      AppMethodBeat.o(209129);
      return;
    }
    a(paramContext, paramTextPaint, paramc);
    if (!this.dwt) {
      a(paramTextPaint, this.dwu);
    }
    AppMethodBeat.o(209129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.e.b
 * JD-Core Version:    0.7.0.1
 */