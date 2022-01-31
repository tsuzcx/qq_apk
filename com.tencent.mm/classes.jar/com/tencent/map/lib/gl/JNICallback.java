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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hi;
import com.tencent.tencentmap.mapsdk.maps.a.it;
import java.util.Arrays;
import java.util.Hashtable;

public class JNICallback
{
  public JNICallback.j a;
  private it b;
  private JNICallback.a c;
  private JNICallback.h d;
  private JNICallback.i e;
  private JNICallback.e f;
  private JNICallback.d g;
  private JNICallback.k h;
  private JNICallback.b i;
  private JNICallback.c j;
  private JNICallback.l k;
  private JNICallback.g l;
  private JNICallback.f m;
  private hi n;
  private Hashtable<Long, Paint> o;
  private Hashtable<Long, PointF> p;
  private Bitmap q;
  
  public JNICallback(it paramit, JNICallback.a parama, JNICallback.h paramh, JNICallback.e parame, JNICallback.g paramg, hi paramhi, JNICallback.i parami)
  {
    AppMethodBeat.i(147030);
    this.o = new Hashtable();
    this.p = new Hashtable();
    this.q = null;
    this.a = null;
    this.b = paramit;
    this.c = parama;
    this.d = paramh;
    this.e = parami;
    this.f = parame;
    this.l = paramg;
    this.n = paramhi;
    this.q = Bitmap.createBitmap(800, 400, Bitmap.Config.ALPHA_8);
    this.a = new JNICallback.j(null);
    AppMethodBeat.o(147030);
  }
  
  private Bitmap a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98036);
    if (this.q == null) {
      this.q = Bitmap.createBitmap(800, 400, Bitmap.Config.ALPHA_8);
    }
    if (this.q == null)
    {
      AppMethodBeat.o(98036);
      return null;
    }
    this.a.a(paramArrayOfByte);
    paramArrayOfByte = a(paramInt);
    this.q.eraseColor(0);
    Canvas localCanvas = new Canvas(this.q);
    float f1 = (paramArrayOfByte.descent() + paramArrayOfByte.ascent()) / 2.0F;
    paramArrayOfByte.setFakeBoldText(this.a.e);
    localCanvas.drawText(paramString, 400.0F, 200.0F - f1, paramArrayOfByte);
    paramString = this.q;
    AppMethodBeat.o(98036);
    return paramString;
  }
  
  private Paint a(int paramInt)
  {
    AppMethodBeat.i(98035);
    Paint localPaint2 = d();
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
    AppMethodBeat.o(98035);
    return localPaint1;
  }
  
  private PointF a(String paramString, int paramInt)
  {
    AppMethodBeat.i(98037);
    float f1 = a(paramInt).measureText(paramString);
    PointF localPointF = e();
    paramString = localPointF;
    if (localPointF == null)
    {
      paramString = new PointF();
      a(paramString);
    }
    paramString.x = (1.0F + f1);
    paramString.y = (paramInt + 2);
    AppMethodBeat.o(98037);
    return paramString;
  }
  
  private IconImageInfo a(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98038);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(98038);
      return null;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      if (paramInt == 1)
      {
        paramArrayOfByte = this.b.a(paramArrayOfByte);
        AppMethodBeat.o(98038);
        return paramArrayOfByte;
      }
      paramArrayOfByte = this.b.b(paramArrayOfByte);
      AppMethodBeat.o(98038);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(98038);
    }
    return null;
  }
  
  private void a(Paint paramPaint)
  {
    AppMethodBeat.i(98032);
    if (this.o != null) {
      this.o.put(Long.valueOf(Thread.currentThread().getId()), paramPaint);
    }
    AppMethodBeat.o(98032);
  }
  
  private void a(PointF paramPointF)
  {
    AppMethodBeat.i(98034);
    if (this.p != null) {
      this.p.put(Long.valueOf(Thread.currentThread().getId()), paramPointF);
    }
    AppMethodBeat.o(98034);
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(98039);
    if (this.c != null)
    {
      d.a("Engine callback download:".concat(String.valueOf(paramString)));
      this.c.d(paramString);
    }
    AppMethodBeat.o(98039);
  }
  
  private void a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98040);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(98040);
      return;
    }
    new JNICallback.1(this, paramString, paramArrayOfByte).execute(new Void[0]);
    AppMethodBeat.o(98040);
  }
  
  private Paint d()
  {
    AppMethodBeat.i(147033);
    if (this.o == null)
    {
      AppMethodBeat.o(147033);
      return null;
    }
    Paint localPaint = (Paint)this.o.get(Long.valueOf(Thread.currentThread().getId()));
    AppMethodBeat.o(147033);
    return localPaint;
  }
  
  private PointF e()
  {
    AppMethodBeat.i(147034);
    if (this.p == null)
    {
      AppMethodBeat.o(147034);
      return null;
    }
    PointF localPointF = (PointF)this.p.get(Long.valueOf(Thread.currentThread().getId()));
    AppMethodBeat.o(147034);
    return localPointF;
  }
  
  public Object a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    AppMethodBeat.i(98029);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramString = null;
      byte[] arrayOfByte;
      for (;;)
      {
        AppMethodBeat.o(98029);
        return paramString;
        paramString = a(paramInt2, paramString, paramArrayOfByte);
        continue;
        paramString = a(paramString, paramInt2);
        continue;
        a(paramString);
        paramString = null;
        continue;
        paramString = a(paramInt2, paramArrayOfByte);
        continue;
        a(paramString, paramArrayOfByte);
        paramString = null;
        continue;
        if (this.e == null) {
          break;
        }
        this.e.h(paramInt2);
        paramString = null;
        continue;
        if (this.n == null) {
          break;
        }
        this.n.a(paramString);
        paramString = null;
        continue;
        if (this.f == null) {
          break;
        }
        this.f.y();
        paramString = null;
        continue;
        if (this.g == null) {
          break;
        }
        paramString = this.g.a(paramArrayOfByte);
        AppMethodBeat.o(98029);
        return paramString;
        if (this.l == null) {
          break;
        }
        paramString = this.l;
        if (paramInt2 > 0) {
          bool = true;
        }
        paramString.b(bool);
        paramString = null;
        continue;
        if (this.h == null) {
          break;
        }
        paramString = this.h.a(paramArrayOfByte);
        AppMethodBeat.o(98029);
        return paramString;
        if (this.i == null) {
          break;
        }
        paramString = this.i.a(paramArrayOfByte);
        AppMethodBeat.o(98029);
        return paramString;
        if (this.j == null) {
          break;
        }
        arrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 0, 12);
        paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 12, paramArrayOfByte.length);
        this.j.a(paramString, arrayOfByte, paramArrayOfByte);
        paramString = null;
      }
      if (this.k != null)
      {
        arrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 0, 12);
        paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, 12, paramArrayOfByte.length);
        this.k.a(paramString, arrayOfByte, paramArrayOfByte);
      }
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(98028);
    this.q = null;
    this.a = null;
    if (this.o != null)
    {
      this.o.clear();
      this.o = null;
    }
    if (this.p != null)
    {
      this.p.clear();
      this.p = null;
    }
    this.b = null;
    this.c = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.k = null;
    AppMethodBeat.o(98028);
  }
  
  public void a(JNICallback.b paramb)
  {
    this.i = paramb;
  }
  
  public void a(JNICallback.c paramc)
  {
    this.j = paramc;
  }
  
  public void a(JNICallback.d paramd)
  {
    this.g = paramd;
  }
  
  public void a(JNICallback.f paramf)
  {
    this.m = paramf;
  }
  
  public void a(JNICallback.k paramk)
  {
    this.h = paramk;
  }
  
  public void a(JNICallback.l paraml)
  {
    this.k = paraml;
  }
  
  public void b()
  {
    AppMethodBeat.i(147031);
    if (this.d != null) {
      this.d.q();
    }
    AppMethodBeat.o(147031);
  }
  
  public int c()
  {
    AppMethodBeat.i(147032);
    if (this.m != null)
    {
      int i1 = this.m.getEGLContextHash();
      AppMethodBeat.o(147032);
      return i1;
    }
    AppMethodBeat.o(147032);
    return 0;
  }
  
  public static class IconImageInfo
  {
    public float anchorPointX1;
    public float anchorPointY1;
    public Bitmap bitmap;
    public float scale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.gl.JNICallback
 * JD-Core Version:    0.7.0.1
 */