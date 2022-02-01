package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class or$b
{
  private static final int b = 900;
  private static final int c = 180;
  Bitmap a;
  private TextPaint d;
  private int e;
  private int f;
  private int g;
  private HashMap<String, Integer> h;
  
  private or$b()
  {
    AppMethodBeat.i(221617);
    this.a = null;
    this.d = null;
    this.e = 900;
    this.f = 180;
    this.g = -1;
    this.h = new HashMap();
    AppMethodBeat.o(221617);
  }
  
  private int a(Rect paramRect, String paramString, int paramInt1, Typeface paramTypeface, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221627);
    if (paramRect == null)
    {
      AppMethodBeat.o(221627);
      return paramInt3;
    }
    int k = Math.abs(paramRect.height());
    int m = Math.abs(paramRect.width());
    paramRect = new Rect(0, 0, 0, 0);
    a(paramInt2, paramInt1, paramTypeface);
    int n = (int)Math.ceil(1.0F / gw.m());
    int j = paramInt2 / 2;
    paramTypeface = a(paramString, j, paramRect);
    paramInt1 = paramTypeface[0];
    int i = paramTypeface[1];
    if ((paramInt1 <= m) && (i <= k))
    {
      i = j + n;
      for (;;)
      {
        paramInt1 = j;
        if (i >= paramInt2) {
          break;
        }
        paramTypeface = a(paramString, i, paramRect);
        int i1 = paramTypeface[0];
        int i2 = paramTypeface[1];
        paramInt1 = j;
        if (i1 > m) {
          break;
        }
        paramInt1 = j;
        if (i2 > k) {
          break;
        }
        j = i;
        i += n;
      }
    }
    paramInt1 = j - n;
    if (paramInt1 >= paramInt3)
    {
      paramTypeface = a(paramString, paramInt1, paramRect);
      i = paramTypeface[0];
      j = paramTypeface[1];
      if ((i > m) || (j > k)) {}
    }
    for (;;)
    {
      i = paramInt1;
      if (paramInt1 < paramInt3) {
        i = paramInt3;
      }
      if (i > paramInt2) {}
      for (;;)
      {
        AppMethodBeat.o(221627);
        return paramInt2;
        paramInt1 -= n;
        break;
        paramInt2 = i;
      }
      paramInt1 = paramInt3;
    }
  }
  
  private static String a(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(221701);
    paramString1 = paramString1 + "_" + paramString2 + "_" + paramInt;
    AppMethodBeat.o(221701);
    return paramString1;
  }
  
  private void a()
  {
    AppMethodBeat.i(221655);
    if ((this.a != null) && (!this.a.isRecycled()))
    {
      this.a.recycle();
      this.a = null;
    }
    AppMethodBeat.o(221655);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(221692);
    if (this.d != null) {
      this.d.setTextSize(paramInt);
    }
    AppMethodBeat.o(221692);
  }
  
  private void a(int paramInt1, int paramInt2, Typeface paramTypeface)
  {
    AppMethodBeat.i(221682);
    if (this.d == null)
    {
      this.d = new TextPaint(65);
      this.d.setStyle(Paint.Style.FILL);
      this.d.setTextAlign(Paint.Align.CENTER);
    }
    this.d.setColor(paramInt2);
    this.d.setTextSize(paramInt1);
    this.d.setTypeface(paramTypeface);
    AppMethodBeat.o(221682);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, Typeface paramTypeface)
  {
    AppMethodBeat.i(221671);
    if (this.a == null) {}
    try
    {
      this.a = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.ARGB_8888);
      a(paramInt1, paramInt2, paramTypeface);
      paramTypeface = new Rect();
      this.d.getTextBounds(paramString, 0, paramString.length(), paramTypeface);
      paramInt1 = Math.abs(paramTypeface.width());
      paramInt2 = Math.abs(paramTypeface.height());
      if ((paramInt1 > this.e) || (paramInt2 > this.f))
      {
        this.e = Math.max(paramInt1, this.e);
        this.f = Math.max(paramInt2, this.f);
        this.a = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.ARGB_8888);
      }
      this.a.eraseColor(0);
      new Canvas(this.a).drawText(paramString, this.e / 2.0F, this.f / 2.0F - (this.d.descent() + this.d.ascent()) / 2.0F, this.d);
      AppMethodBeat.o(221671);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      AppMethodBeat.o(221671);
    }
  }
  
  private int[] a(String paramString, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(221635);
    a(paramInt);
    this.d.getTextBounds(paramString, 0, paramString.length(), paramRect);
    paramInt = Math.abs(paramRect.width());
    int i = Math.abs(paramRect.height());
    AppMethodBeat.o(221635);
    return new int[] { paramInt, i };
  }
  
  private Object[] a(String paramString1, String paramString2, int paramInt1, int paramInt2, Typeface paramTypeface)
  {
    AppMethodBeat.i(221648);
    paramString1 = paramString1 + "_" + paramString2 + "_" + paramInt1;
    int i = paramInt1;
    if (paramInt1 > 180) {
      i = 180;
    }
    if ((i == this.g) || (this.a == null)) {}
    try
    {
      this.a = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.ARGB_8888);
      a(i, paramInt2, paramTypeface);
      paramTypeface = new Rect();
      this.d.getTextBounds(paramString2, 0, paramString2.length(), paramTypeface);
      paramInt1 = Math.abs(paramTypeface.width());
      paramInt2 = Math.abs(paramTypeface.height());
      if ((paramInt1 > this.e) || (paramInt2 > this.f))
      {
        this.e = Math.max(paramInt1, this.e);
        this.f = Math.max(paramInt2, this.f);
        this.a = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.ARGB_8888);
      }
      this.a.eraseColor(0);
      new Canvas(this.a).drawText(paramString2, this.e / 2.0F, this.f / 2.0F - (this.d.descent() + this.d.ascent()) / 2.0F, this.d);
    }
    catch (OutOfMemoryError paramString2)
    {
      label259:
      break label259;
    }
    this.g = i;
    paramString2 = this.a;
    AppMethodBeat.o(221648);
    return new Object[] { paramString1, paramString2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.or.b
 * JD-Core Version:    0.7.0.1
 */