package com.google.android.material.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import androidx.core.content.a.f;
import androidx.core.content.a.f.a;
import androidx.core.f.g;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  public final ColorStateList bCI;
  public final ColorStateList bDk;
  public final ColorStateList bDl;
  public final int bDm;
  public final boolean bDn;
  public final ColorStateList bDo;
  public final float bDp;
  public final float bDq;
  private final int bDr;
  private boolean bDs;
  private Typeface bDt;
  public final String fontFamily;
  public final float shadowRadius;
  public final float textSize;
  public final int typeface;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(238730);
    this.bDs = false;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, a.k.TextAppearance);
    this.textSize = localTypedArray.getDimension(a.k.TextAppearance_android_textSize, 0.0F);
    this.bCI = a.b(paramContext, localTypedArray, a.k.TextAppearance_android_textColor);
    this.bDk = a.b(paramContext, localTypedArray, a.k.TextAppearance_android_textColorHint);
    this.bDl = a.b(paramContext, localTypedArray, a.k.TextAppearance_android_textColorLink);
    this.bDm = localTypedArray.getInt(a.k.TextAppearance_android_textStyle, 0);
    this.typeface = localTypedArray.getInt(a.k.TextAppearance_android_typeface, 1);
    paramInt = a.k.TextAppearance_fontFamily;
    int i = a.k.TextAppearance_android_fontFamily;
    if (localTypedArray.hasValue(paramInt)) {}
    for (;;)
    {
      this.bDr = localTypedArray.getResourceId(paramInt, 0);
      this.fontFamily = localTypedArray.getString(paramInt);
      this.bDn = localTypedArray.getBoolean(a.k.TextAppearance_textAllCaps, false);
      this.bDo = a.b(paramContext, localTypedArray, a.k.TextAppearance_android_shadowColor);
      this.bDp = localTypedArray.getFloat(a.k.TextAppearance_android_shadowDx, 0.0F);
      this.bDq = localTypedArray.getFloat(a.k.TextAppearance_android_shadowDy, 0.0F);
      this.shadowRadius = localTypedArray.getFloat(a.k.TextAppearance_android_shadowRadius, 0.0F);
      localTypedArray.recycle();
      AppMethodBeat.o(238730);
      return;
      paramInt = i;
    }
  }
  
  private void a(Context paramContext, final TextPaint paramTextPaint, final f.a parama)
  {
    AppMethodBeat.i(238733);
    if (this.bDs)
    {
      a(paramTextPaint, this.bDt);
      AppMethodBeat.o(238733);
      return;
    }
    xu();
    if (paramContext.isRestricted())
    {
      this.bDs = true;
      a(paramTextPaint, this.bDt);
      AppMethodBeat.o(238733);
      return;
    }
    try
    {
      i = this.bDr;
      paramTextPaint = new f.a()
      {
        public final void a(Typeface paramAnonymousTypeface)
        {
          AppMethodBeat.i(238698);
          b.a(b.this, Typeface.create(paramAnonymousTypeface, b.this.bDm));
          b.this.a(paramTextPaint, paramAnonymousTypeface);
          b.b(b.this);
          parama.a(paramAnonymousTypeface);
          AppMethodBeat.o(238698);
        }
        
        public final void au(int paramAnonymousInt)
        {
          AppMethodBeat.i(238701);
          b.c(b.this);
          b.b(b.this);
          parama.au(paramAnonymousInt);
          AppMethodBeat.o(238701);
        }
      };
      g.checkNotNull(paramTextPaint);
      if (paramContext.isRestricted())
      {
        paramTextPaint.a(-4, null);
        AppMethodBeat.o(238733);
        return;
      }
    }
    catch (UnsupportedOperationException paramContext)
    {
      int i;
      AppMethodBeat.o(238733);
      return;
      f.a(paramContext, i, new TypedValue(), 0, paramTextPaint, false);
      AppMethodBeat.o(238733);
      return;
    }
    catch (Exception paramContext)
    {
      new StringBuilder("Error loading font ").append(this.fontFamily);
      AppMethodBeat.o(238733);
      return;
    }
    catch (Resources.NotFoundException paramContext)
    {
      label101:
      break label101;
    }
  }
  
  private Typeface af(Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(238732);
    if (this.bDs)
    {
      paramContext = this.bDt;
      AppMethodBeat.o(238732);
      return paramContext;
    }
    if (!paramContext.isRestricted()) {}
    for (;;)
    {
      try
      {
        i = this.bDr;
        if (!paramContext.isRestricted()) {
          continue;
        }
        paramContext = localObject;
        this.bDt = paramContext;
        if (this.bDt != null) {
          this.bDt = Typeface.create(this.bDt, this.bDm);
        }
      }
      catch (Exception paramContext)
      {
        int i;
        new StringBuilder("Error loading font ").append(this.fontFamily);
        continue;
      }
      catch (UnsupportedOperationException paramContext)
      {
        continue;
      }
      catch (Resources.NotFoundException paramContext)
      {
        continue;
      }
      xu();
      this.bDs = true;
      paramContext = this.bDt;
      AppMethodBeat.o(238732);
      return paramContext;
      paramContext = f.a(paramContext, i, new TypedValue(), 0, null, false);
    }
  }
  
  private void xu()
  {
    AppMethodBeat.i(238734);
    if (this.bDt == null) {
      this.bDt = Typeface.create(this.fontFamily, this.bDm);
    }
    if (this.bDt == null) {
      switch (this.typeface)
      {
      default: 
        this.bDt = Typeface.DEFAULT;
      }
    }
    for (;;)
    {
      if (this.bDt != null) {
        this.bDt = Typeface.create(this.bDt, this.bDm);
      }
      AppMethodBeat.o(238734);
      return;
      this.bDt = Typeface.SANS_SERIF;
      continue;
      this.bDt = Typeface.SERIF;
      continue;
      this.bDt = Typeface.MONOSPACE;
    }
  }
  
  public final void a(TextPaint paramTextPaint, Typeface paramTypeface)
  {
    AppMethodBeat.i(238738);
    paramTextPaint.setTypeface(paramTypeface);
    int i = this.bDm;
    i = (paramTypeface.getStyle() ^ 0xFFFFFFFF) & i;
    boolean bool;
    if ((i & 0x1) != 0)
    {
      bool = true;
      paramTextPaint.setFakeBoldText(bool);
      if ((i & 0x2) == 0) {
        break label80;
      }
    }
    label80:
    for (float f = -0.25F;; f = 0.0F)
    {
      paramTextPaint.setTextSkewX(f);
      paramTextPaint.setTextSize(this.textSize);
      AppMethodBeat.o(238738);
      return;
      bool = false;
      break;
    }
  }
  
  public final void b(Context paramContext, TextPaint paramTextPaint, f.a parama)
  {
    AppMethodBeat.i(238735);
    c(paramContext, paramTextPaint, parama);
    float f1;
    float f2;
    float f3;
    if (this.bCI != null)
    {
      i = this.bCI.getColorForState(paramTextPaint.drawableState, this.bCI.getDefaultColor());
      paramTextPaint.setColor(i);
      f1 = this.shadowRadius;
      f2 = this.bDp;
      f3 = this.bDq;
      if (this.bDo == null) {
        break label118;
      }
    }
    label118:
    for (int i = this.bDo.getColorForState(paramTextPaint.drawableState, this.bDo.getDefaultColor());; i = 0)
    {
      paramTextPaint.setShadowLayer(f1, f2, f3, i);
      AppMethodBeat.o(238735);
      return;
      i = -16777216;
      break;
    }
  }
  
  public final void c(Context paramContext, TextPaint paramTextPaint, f.a parama)
  {
    AppMethodBeat.i(238737);
    if (c.bDx)
    {
      a(paramTextPaint, af(paramContext));
      AppMethodBeat.o(238737);
      return;
    }
    a(paramContext, paramTextPaint, parama);
    if (!this.bDs) {
      a(paramTextPaint, this.bDt);
    }
    AppMethodBeat.o(238737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.e.b
 * JD-Core Version:    0.7.0.1
 */