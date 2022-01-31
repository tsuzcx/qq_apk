package com.tencent.map.lib.gl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.tencent.map.lib.d;
import com.tencent.tencentmap.mapsdk.a.ih;
import com.tencent.tencentmap.mapsdk.a.jr;
import java.util.Arrays;
import java.util.Hashtable;

public class JNICallback
{
  public JNICallback.i a = null;
  private jr b;
  private JNICallback.a c;
  private JNICallback.h d;
  private JNICallback.e e;
  private JNICallback.d f;
  private JNICallback.j g;
  private JNICallback.b h;
  private JNICallback.c i;
  private JNICallback.k j;
  private JNICallback.g k;
  private JNICallback.f l;
  private Hashtable<Long, Paint> m = new Hashtable();
  private Hashtable<Long, PointF> n = new Hashtable();
  private Bitmap o = null;
  
  public JNICallback(jr paramjr, JNICallback.a parama, JNICallback.h paramh, JNICallback.e parame, JNICallback.g paramg)
  {
    this.b = paramjr;
    this.c = parama;
    this.d = paramh;
    this.e = parame;
    this.k = paramg;
    this.o = Bitmap.createBitmap(800, 400, Bitmap.Config.ALPHA_8);
    this.a = new JNICallback.i(null);
  }
  
  private Bitmap a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (this.o == null) {
      this.o = Bitmap.createBitmap(800, 400, Bitmap.Config.ALPHA_8);
    }
    if (this.o == null) {
      return null;
    }
    this.a.a(paramArrayOfByte);
    paramArrayOfByte = a(paramInt);
    this.o.eraseColor(0);
    Canvas localCanvas = new Canvas(this.o);
    float f1 = (paramArrayOfByte.descent() + paramArrayOfByte.ascent()) / 2.0F;
    paramArrayOfByte.setFakeBoldText(this.a.e);
    localCanvas.drawText(paramString, 400.0F, 200.0F - f1, paramArrayOfByte);
    return this.o;
  }
  
  private Paint a(int paramInt)
  {
    Paint localPaint2 = c();
    Paint localPaint1 = localPaint2;
    if (localPaint2 == null)
    {
      localPaint1 = new Paint();
      localPaint1.setTypeface(Typeface.DEFAULT);
      localPaint1.setAntiAlias(true);
      localPaint1.setStyle(Paint.Style.FILL);
      localPaint1.setTextAlign(Paint.Align.CENTER);
      localPaint1.setLinearText(true);
      a(localPaint1);
    }
    localPaint1.setTextAlign(Paint.Align.CENTER);
    localPaint1.setTextSize(paramInt);
    return localPaint1;
  }
  
  private PointF a(String paramString, int paramInt)
  {
    float f1 = a(paramInt).measureText(paramString);
    PointF localPointF = d();
    paramString = localPointF;
    if (localPointF == null)
    {
      paramString = new PointF();
      a(paramString);
    }
    paramString.x = (1.0F + f1);
    paramString.y = (paramInt + 2);
    return paramString;
  }
  
  private JNICallback.IconImageInfo a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      if (paramInt == 1) {
        return this.b.a(paramArrayOfByte);
      }
      paramArrayOfByte = this.b.b(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  private void a(Paint paramPaint)
  {
    if (this.m != null) {
      this.m.put(Long.valueOf(Thread.currentThread().getId()), paramPaint);
    }
  }
  
  private void a(PointF paramPointF)
  {
    if (this.n != null) {
      this.n.put(Long.valueOf(Thread.currentThread().getId()), paramPointF);
    }
  }
  
  private void a(String paramString)
  {
    if (this.c != null)
    {
      d.a("Engine callback download:" + paramString);
      this.c.c(paramString);
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    new JNICallback.1(this, paramString, paramArrayOfByte).execute(new Void[0]);
  }
  
  private Paint c()
  {
    if (this.m == null) {
      return null;
    }
    return (Paint)this.m.get(Long.valueOf(Thread.currentThread().getId()));
  }
  
  private PointF d()
  {
    if (this.n == null) {
      return null;
    }
    return (PointF)this.n.get(Long.valueOf(Thread.currentThread().getId()));
  }
  
  public Object a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return null;
      return a(paramInt2, paramString, paramArrayOfByte);
      return a(paramString, paramInt2);
      a(paramString);
      return null;
      return a(paramInt2, paramArrayOfByte);
      a(paramString, paramArrayOfByte);
      return null;
      if (this.d != null)
      {
        this.d.g(paramInt2);
        return null;
        ih.a().a(paramString);
        return null;
        if (this.e != null)
        {
          this.e.B();
          return null;
          if (this.f != null)
          {
            return this.f.a(paramArrayOfByte);
            if (this.k != null)
            {
              paramString = this.k;
              if (paramInt2 > 0) {
                bool = true;
              }
              paramString.b(bool);
              return null;
              if (this.g != null)
              {
                return this.g.a(paramArrayOfByte);
                if (this.h != null)
                {
                  return this.h.a(paramArrayOfByte);
                  if (this.i != null)
                  {
                    byte[] arrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 0, 12);
                    paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 12, paramArrayOfByte.length);
                    this.i.a(paramString, arrayOfByte, paramArrayOfByte);
                    return null;
                    if (this.j != null)
                    {
                      arrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 0, 12);
                      paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 12, paramArrayOfByte.length);
                      this.j.a(paramString, arrayOfByte, paramArrayOfByte);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.o = null;
    this.a = null;
    if (this.m != null)
    {
      this.m.clear();
      this.m = null;
    }
    if (this.n != null)
    {
      this.n.clear();
      this.n = null;
    }
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.j = null;
  }
  
  public void a(JNICallback.b paramb)
  {
    this.h = paramb;
  }
  
  public void a(JNICallback.c paramc)
  {
    this.i = paramc;
  }
  
  public void a(JNICallback.d paramd)
  {
    this.f = paramd;
  }
  
  public void a(JNICallback.f paramf)
  {
    this.l = paramf;
  }
  
  public void a(JNICallback.j paramj)
  {
    this.g = paramj;
  }
  
  public void a(JNICallback.k paramk)
  {
    this.j = paramk;
  }
  
  public int b()
  {
    if (this.l != null) {
      return this.l.getGLContext();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.gl.JNICallback
 * JD-Core Version:    0.7.0.1
 */