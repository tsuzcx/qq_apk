package com.tencent.liteav.beauty;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.structs.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  extends com.tencent.liteav.basic.module.a
  implements e
{
  protected Context a;
  protected boolean b;
  protected boolean c;
  protected int d;
  protected int e;
  protected int f;
  protected com.tencent.liteav.basic.opengl.a g;
  protected c h;
  protected b i;
  protected c j;
  f k;
  private d l;
  private long m;
  private long n;
  private long o;
  private Object p;
  private d.a q;
  
  public d(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(234939);
    this.b = true;
    this.c = false;
    this.d = 0;
    this.e = 0;
    this.f = 1;
    this.g = null;
    this.i = new b();
    this.j = null;
    this.l = d.c;
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
    this.q = new d.a(this);
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    TXCLog.i("TXCVideoPreprocessor", "TXCVideoPreprocessor version: VideoPreprocessor-v1.1");
    localObject = ((ActivityManager)localObject).getDeviceConfigurationInfo();
    if (localObject != null)
    {
      TXCLog.i("TXCVideoPreprocessor", "opengl es version " + ((ConfigurationInfo)localObject).reqGlEsVersion);
      TXCLog.i("TXCVideoPreprocessor", "set GLContext ".concat(String.valueOf(paramBoolean)));
      if (((ConfigurationInfo)localObject).reqGlEsVersion > 131072)
      {
        TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_3");
        TXCOpenGlUtils.a(3);
      }
    }
    for (;;)
    {
      this.a = paramContext;
      this.b = paramBoolean;
      this.h = new c(this.a, this.b);
      a.a().a(paramContext);
      AppMethodBeat.o(234939);
      return;
      TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_2");
      TXCOpenGlUtils.a(2);
      continue;
      TXCLog.e("TXCVideoPreprocessor", "getDeviceConfigurationInfo opengl Info failed!");
    }
  }
  
  private int A(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 1: 
      return 90;
    case 2: 
      return 180;
    }
    return 270;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(234969);
    if (this.j == null)
    {
      this.j = new c(null);
      this.n = 0L;
      this.o = System.currentTimeMillis();
    }
    label465:
    int i1;
    if ((paramInt1 != this.j.b) || (paramInt2 != this.j.c) || (paramInt3 != this.j.d) || ((this.d > 0) && (this.d != this.j.f)) || ((this.e > 0) && (this.e != this.j.g)) || ((this.g != null) && (((this.g.c > 0) && ((this.j.j == null) || (this.g.c != this.j.j.c))) || ((this.g.d > 0) && ((this.j.j == null) || (this.g.d != this.j.j.d))) || ((this.g.a >= 0) && ((this.j.j == null) || (this.g.a != this.j.j.a))) || ((this.g.b >= 0) && ((this.j.j == null) || (this.g.b != this.j.j.b))))) || (this.c != this.j.e) || (this.j.h != paramInt4))
    {
      TXCLog.i("TXCVideoPreprocessor", "Init sdk");
      TXCLog.i("TXCVideoPreprocessor", "Input widht " + paramInt1 + " height " + paramInt2);
      this.j.b = paramInt1;
      this.j.c = paramInt2;
      if ((this.g == null) || (this.g.a < 0) || (this.g.b < 0) || (this.g.c <= 0) || (this.g.d <= 0)) {
        break label943;
      }
      TXCLog.i("TXCVideoPreprocessor", "set Crop Rect; init ");
      if (paramInt1 - this.g.a > this.g.c)
      {
        paramInt1 = this.g.c;
        if (paramInt2 - this.g.b <= this.g.d) {
          break label734;
        }
        paramInt2 = this.g.d;
        this.g.c = paramInt1;
        this.g.d = paramInt2;
        i1 = this.g.c;
      }
    }
    for (int i2 = this.g.d;; i2 = paramInt2)
    {
      this.j.j = this.g;
      this.j.d = paramInt3;
      this.j.a = this.b;
      this.j.h = paramInt4;
      this.j.i = paramInt5;
      this.j.f = this.d;
      this.j.g = this.e;
      if ((this.j.f <= 0) || (this.j.g <= 0))
      {
        if ((90 == this.j.d) || (270 == this.j.d))
        {
          this.j.f = i2;
          this.j.g = i1;
        }
      }
      else
      {
        label632:
        if (this.l != d.a) {
          break label787;
        }
        if ((90 != this.j.d) && (270 != this.j.d)) {
          break label768;
        }
        paramInt1 = this.j.g;
        paramInt2 = this.j.f;
      }
      for (;;)
      {
        this.j.e = this.c;
        if (a(this.j, paramInt1, paramInt2)) {
          break label936;
        }
        TXCLog.e("TXCVideoPreprocessor", "init failed!");
        AppMethodBeat.o(234969);
        return false;
        paramInt1 -= this.g.a;
        break;
        label734:
        paramInt2 -= this.g.b;
        break label465;
        this.j.f = i1;
        this.j.g = i2;
        break label632;
        label768:
        paramInt1 = this.j.f;
        paramInt2 = this.j.g;
        continue;
        label787:
        paramInt1 = i1;
        paramInt2 = i2;
        if (this.l != d.b)
        {
          com.tencent.liteav.basic.util.e locale = b(i1, i2, this.j.d, this.j.f, this.j.g);
          paramInt1 = (locale.a + 7) / 8 * 8;
          paramInt2 = (locale.b + 7) / 8 * 8;
        }
      }
      if ((paramInt4 != this.j.h) || (paramInt5 != this.j.i))
      {
        this.j.h = paramInt4;
        this.i.k = paramInt4;
        this.j.i = paramInt5;
        this.i.l = paramInt5;
        this.h.b(paramInt5);
      }
      label936:
      AppMethodBeat.o(234969);
      return true;
      label943:
      i1 = paramInt1;
    }
  }
  
  private boolean a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234971);
    this.i.d = paramc.b;
    this.i.e = paramc.c;
    this.i.m = paramc.j;
    this.i.g = paramInt1;
    this.i.f = paramInt2;
    this.i.h = ((paramc.d + 360) % 360);
    this.i.b = paramc.f;
    this.i.c = paramc.g;
    this.i.a = 0;
    this.i.j = paramc.a;
    this.i.i = paramc.e;
    this.i.k = paramc.h;
    this.i.l = paramc.i;
    if (this.h == null)
    {
      this.h = new c(this.a, paramc.a);
      this.h.a(this.f);
    }
    boolean bool = this.h.a(this.i);
    AppMethodBeat.o(234971);
    return bool;
  }
  
  private com.tencent.liteav.basic.util.e b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(234970);
    if ((paramInt3 == 90) || (paramInt3 == 270))
    {
      paramInt3 = paramInt4;
      paramInt4 = paramInt5;
    }
    for (;;)
    {
      int i1 = Math.min(paramInt4, paramInt3);
      int i2 = Math.min(paramInt1, paramInt2);
      paramInt5 = 0;
      while (paramInt5 < 3)
      {
        int i3 = new int[] { 720, 1080, 1280 }[paramInt5];
        if ((i1 <= i3) && (i2 >= i3))
        {
          float f1 = 1.0F * i3 / i1;
          locale = new com.tencent.liteav.basic.util.e((int)(paramInt4 * f1), (int)(paramInt3 * f1));
          AppMethodBeat.o(234970);
          return locale;
        }
        paramInt5 += 1;
      }
      com.tencent.liteav.basic.util.e locale = new com.tencent.liteav.basic.util.e(paramInt1, paramInt2);
      AppMethodBeat.o(234970);
      return locale;
      paramInt3 = paramInt5;
    }
  }
  
  private void c()
  {
    AppMethodBeat.i(234934);
    if (this.m != 0L) {
      setStatusValue(3002, Long.valueOf(System.currentTimeMillis() - this.m));
    }
    this.n += 1L;
    long l1 = System.currentTimeMillis();
    if (l1 > this.o + 2000L)
    {
      setStatusValue(3003, Double.valueOf(this.n * 1000.0D / (l1 - this.o)));
      this.n = 0L;
      this.o = l1;
    }
    AppMethodBeat.o(234934);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    AppMethodBeat.i(234924);
    if (this.k != null)
    {
      b localb = new b();
      localb.e = paramInt2;
      localb.f = paramInt3;
      localb.j = 0;
      if (this.j != null) {
        bool = this.j.e;
      }
      localb.i = bool;
      localb.a = paramInt1;
      paramInt1 = this.k.a(localb);
      AppMethodBeat.o(234924);
      return paramInt1;
    }
    AppMethodBeat.o(234924);
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong)
  {
    try
    {
      AppMethodBeat.i(234948);
      a(paramInt2, paramInt3, A(paramInt4), paramInt5, paramInt6);
      this.h.b(this.i);
      paramInt1 = this.h.a(paramInt1, paramInt5, paramLong);
      AppMethodBeat.o(234948);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int a(b paramb, int paramInt1, int paramInt2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 331
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   12: putfield 85	com/tencent/liteav/beauty/d:m	J
    //   15: aload_0
    //   16: aload_1
    //   17: getfield 333	com/tencent/liteav/basic/structs/b:l	Lcom/tencent/liteav/basic/opengl/a;
    //   20: invokevirtual 336	com/tencent/liteav/beauty/d:a	(Lcom/tencent/liteav/basic/opengl/a;)V
    //   23: aload_0
    //   24: aload_1
    //   25: getfield 337	com/tencent/liteav/basic/structs/b:g	I
    //   28: aload_1
    //   29: getfield 338	com/tencent/liteav/basic/structs/b:h	I
    //   32: invokevirtual 340	com/tencent/liteav/beauty/d:a	(II)V
    //   35: aload_0
    //   36: aload_1
    //   37: getfield 312	com/tencent/liteav/basic/structs/b:i	Z
    //   40: invokevirtual 343	com/tencent/liteav/beauty/d:b	(Z)V
    //   43: aload_0
    //   44: aload_1
    //   45: getfield 346	com/tencent/liteav/basic/structs/b:c	[F
    //   48: invokevirtual 349	com/tencent/liteav/beauty/d:a	([F)V
    //   51: aload_0
    //   52: aload_1
    //   53: getfield 351	com/tencent/liteav/basic/structs/b:d	Z
    //   56: invokevirtual 353	com/tencent/liteav/beauty/d:a	(Z)V
    //   59: aload_1
    //   60: getfield 356	com/tencent/liteav/basic/structs/b:m	[B
    //   63: ifnull +44 -> 107
    //   66: aload_1
    //   67: getfield 313	com/tencent/liteav/basic/structs/b:a	I
    //   70: iconst_m1
    //   71: if_icmpne +36 -> 107
    //   74: aload_0
    //   75: aload_1
    //   76: getfield 356	com/tencent/liteav/basic/structs/b:m	[B
    //   79: aload_1
    //   80: getfield 308	com/tencent/liteav/basic/structs/b:e	I
    //   83: aload_1
    //   84: getfield 309	com/tencent/liteav/basic/structs/b:f	I
    //   87: aload_1
    //   88: getfield 311	com/tencent/liteav/basic/structs/b:j	I
    //   91: iload_2
    //   92: iload_3
    //   93: invokevirtual 359	com/tencent/liteav/beauty/d:a	([BIIIII)I
    //   96: istore_2
    //   97: ldc_w 331
    //   100: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_2
    //   106: ireturn
    //   107: aload_0
    //   108: aload_1
    //   109: getfield 313	com/tencent/liteav/basic/structs/b:a	I
    //   112: aload_1
    //   113: getfield 308	com/tencent/liteav/basic/structs/b:e	I
    //   116: aload_1
    //   117: getfield 309	com/tencent/liteav/basic/structs/b:f	I
    //   120: aload_1
    //   121: getfield 311	com/tencent/liteav/basic/structs/b:j	I
    //   124: iload_2
    //   125: iload_3
    //   126: lload 4
    //   128: invokevirtual 361	com/tencent/liteav/beauty/d:a	(IIIIIIJ)I
    //   131: istore_2
    //   132: ldc_w 331
    //   135: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: goto -35 -> 103
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	d
    //   0	146	1	paramb	b
    //   0	146	2	paramInt1	int
    //   0	146	3	paramInt2	int
    //   0	146	4	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   2	103	141	finally
    //   107	138	141	finally
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    try
    {
      AppMethodBeat.i(234947);
      a(paramInt1, paramInt2, A(paramInt3), paramInt4, paramInt5);
      this.h.b(this.i);
      paramInt1 = this.h.a(paramArrayOfByte, paramInt4);
      AppMethodBeat.o(234947);
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public Object a()
  {
    try
    {
      Object localObject1 = this.p;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void a(float paramFloat)
  {
    try
    {
      AppMethodBeat.i(235002);
      if (this.h != null) {
        this.h.a(paramFloat);
      }
      AppMethodBeat.o(235002);
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(234972);
    if (paramInt != this.f)
    {
      this.f = paramInt;
      if (this.h != null) {
        this.h.a(this.f);
      }
    }
    AppMethodBeat.o(234972);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.d = paramInt1;
      this.e = paramInt2;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    boolean bool = false;
    AppMethodBeat.i(234927);
    c();
    if (this.k != null)
    {
      b localb = new b();
      localb.e = paramInt2;
      localb.f = paramInt3;
      localb.j = 0;
      if (this.j != null) {
        bool = this.j.e;
      }
      localb.i = bool;
      localb.a = paramInt1;
      this.k.a(localb, paramLong);
    }
    AppMethodBeat.o(234927);
  }
  
  public void a(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(235003);
      if (this.h != null) {
        this.h.a(paramBitmap);
      }
      AppMethodBeat.o(235003);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 386
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: fload_2
    //   9: fconst_0
    //   10: fcmpg
    //   11: iflt +17 -> 28
    //   14: fload_3
    //   15: fconst_0
    //   16: fcmpg
    //   17: iflt +11 -> 28
    //   20: fload 4
    //   22: f2d
    //   23: dconst_0
    //   24: dcmpg
    //   25: ifge +20 -> 45
    //   28: ldc 106
    //   30: ldc_w 388
    //   33: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: ldc_w 386
    //   39: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: getfield 164	com/tencent/liteav/beauty/d:h	Lcom/tencent/liteav/beauty/c;
    //   49: ifnull +15 -> 64
    //   52: aload_0
    //   53: getfield 164	com/tencent/liteav/beauty/d:h	Lcom/tencent/liteav/beauty/c;
    //   56: aload_1
    //   57: fload_2
    //   58: fload_3
    //   59: fload 4
    //   61: invokevirtual 390	com/tencent/liteav/beauty/c:a	(Landroid/graphics/Bitmap;FFF)V
    //   64: ldc_w 386
    //   67: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -28 -> 42
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	d
    //   0	78	1	paramBitmap	Bitmap
    //   0	78	2	paramFloat1	float
    //   0	78	3	paramFloat2	float
    //   0	78	4	paramFloat3	float
    // Exception table:
    //   from	to	target	type
    //   2	8	73	finally
    //   28	42	73	finally
    //   45	64	73	finally
    //   64	70	73	finally
  }
  
  /* Error */
  public void a(com.tencent.liteav.basic.c.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 392
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 164	com/tencent/liteav/beauty/d:h	Lcom/tencent/liteav/beauty/c;
    //   12: ifnonnull +20 -> 32
    //   15: ldc 106
    //   17: ldc_w 394
    //   20: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 392
    //   26: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 164	com/tencent/liteav/beauty/d:h	Lcom/tencent/liteav/beauty/c;
    //   36: aload_1
    //   37: invokevirtual 396	com/tencent/liteav/beauty/c:a	(Lcom/tencent/liteav/basic/c/b;)V
    //   40: ldc_w 392
    //   43: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -17 -> 29
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	d
    //   0	54	1	paramb	com.tencent.liteav.basic.c.b
    // Exception table:
    //   from	to	target	type
    //   2	29	49	finally
    //   32	46	49	finally
  }
  
  public void a(com.tencent.liteav.basic.opengl.a parama)
  {
    try
    {
      this.g = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(234953);
      this.l = paramd;
      TXCLog.i("TXCVideoPreprocessor", "set Process SDK performance ".concat(String.valueOf(paramd)));
      AppMethodBeat.o(234953);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public void a(f paramf)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(234963);
        if (this.h == null)
        {
          TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
          AppMethodBeat.o(234963);
          return;
        }
        this.k = paramf;
        if (paramf == null)
        {
          this.h.a(null);
          AppMethodBeat.o(234963);
          continue;
        }
        this.h.a(this);
      }
      finally {}
      AppMethodBeat.o(234963);
    }
  }
  
  public void a(Object paramObject)
  {
    try
    {
      this.p = paramObject;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      AppMethodBeat.i(234979);
      if (this.h != null) {
        this.h.a(paramString);
      }
      AppMethodBeat.o(234979);
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(234945);
    if (this.h != null) {
      this.h.a(paramBoolean);
    }
    AppMethodBeat.o(234945);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(234930);
    if (this.k != null) {
      this.k.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    }
    AppMethodBeat.o(234930);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(234943);
    if (this.h != null) {
      this.h.a(paramArrayOfFloat);
    }
    AppMethodBeat.o(234943);
  }
  
  @TargetApi(18)
  public boolean a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(234981);
    if (Build.VERSION.SDK_INT < 18)
    {
      AppMethodBeat.o(234981);
      return false;
    }
    if (this.h != null) {
      this.h.a(paramString, paramBoolean);
    }
    AppMethodBeat.o(234981);
    return true;
  }
  
  public void b()
  {
    try
    {
      AppMethodBeat.i(234973);
      if (this.h != null) {
        this.h.a();
      }
      this.j = null;
      AppMethodBeat.o(234973);
      return;
    }
    finally {}
  }
  
  public void b(int paramInt)
  {
    try
    {
      AppMethodBeat.i(234974);
      if (this.h != null) {
        this.h.d(paramInt);
      }
      this.q.a("beautyStyle", paramInt);
      AppMethodBeat.o(234974);
      return;
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 446
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: bipush 9
    //   11: if_icmple +49 -> 60
    //   14: ldc 106
    //   16: ldc_w 448
    //   19: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: bipush 9
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 164	com/tencent/liteav/beauty/d:h	Lcom/tencent/liteav/beauty/c;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: getfield 164	com/tencent/liteav/beauty/d:h	Lcom/tencent/liteav/beauty/c;
    //   36: iload_2
    //   37: invokevirtual 450	com/tencent/liteav/beauty/c:c	(I)V
    //   40: aload_0
    //   41: getfield 94	com/tencent/liteav/beauty/d:q	Lcom/tencent/liteav/beauty/d$a;
    //   44: ldc_w 452
    //   47: iload_2
    //   48: invokevirtual 445	com/tencent/liteav/beauty/d$a:a	(Ljava/lang/String;I)V
    //   51: ldc_w 446
    //   54: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: iload_1
    //   61: istore_2
    //   62: iload_1
    //   63: ifge -38 -> 25
    //   66: ldc 106
    //   68: ldc_w 454
    //   71: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -51 -> 25
    //   79: astore_3
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_3
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	d
    //   0	84	1	paramInt	int
    //   24	52	2	i1	int
    //   79	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	79	finally
    //   14	22	79	finally
    //   25	40	79	finally
    //   40	57	79	finally
    //   66	74	79	finally
  }
  
  public void c(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(234980);
      if (this.h != null) {
        this.h.b(paramBoolean);
      }
      AppMethodBeat.o(234980);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void d(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 457
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: bipush 9
    //   11: if_icmple +49 -> 60
    //   14: ldc 106
    //   16: ldc_w 459
    //   19: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: bipush 9
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 164	com/tencent/liteav/beauty/d:h	Lcom/tencent/liteav/beauty/c;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: getfield 164	com/tencent/liteav/beauty/d:h	Lcom/tencent/liteav/beauty/c;
    //   36: iload_2
    //   37: invokevirtual 461	com/tencent/liteav/beauty/c:e	(I)V
    //   40: aload_0
    //   41: getfield 94	com/tencent/liteav/beauty/d:q	Lcom/tencent/liteav/beauty/d$a;
    //   44: ldc_w 463
    //   47: iload_2
    //   48: invokevirtual 445	com/tencent/liteav/beauty/d$a:a	(Ljava/lang/String;I)V
    //   51: ldc_w 457
    //   54: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: iload_1
    //   61: istore_2
    //   62: iload_1
    //   63: ifge -38 -> 25
    //   66: ldc 106
    //   68: ldc_w 465
    //   71: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -51 -> 25
    //   79: astore_3
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_3
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	d
    //   0	84	1	paramInt	int
    //   24	52	2	i1	int
    //   79	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	79	finally
    //   14	22	79	finally
    //   25	40	79	finally
    //   40	57	79	finally
    //   66	74	79	finally
  }
  
  /* Error */
  public void e(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 466
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: bipush 9
    //   11: if_icmple +49 -> 60
    //   14: ldc 106
    //   16: ldc_w 468
    //   19: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: bipush 9
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 164	com/tencent/liteav/beauty/d:h	Lcom/tencent/liteav/beauty/c;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: getfield 164	com/tencent/liteav/beauty/d:h	Lcom/tencent/liteav/beauty/c;
    //   36: iload_2
    //   37: invokevirtual 470	com/tencent/liteav/beauty/c:g	(I)V
    //   40: aload_0
    //   41: getfield 94	com/tencent/liteav/beauty/d:q	Lcom/tencent/liteav/beauty/d$a;
    //   44: ldc_w 472
    //   47: iload_2
    //   48: invokevirtual 445	com/tencent/liteav/beauty/d$a:a	(Ljava/lang/String;I)V
    //   51: ldc_w 466
    //   54: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: iload_1
    //   61: istore_2
    //   62: iload_1
    //   63: ifge -38 -> 25
    //   66: ldc 106
    //   68: ldc_w 474
    //   71: invokestatic 180	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -51 -> 25
    //   79: astore_3
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_3
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	d
    //   0	84	1	paramInt	int
    //   24	52	2	i1	int
    //   79	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	79	finally
    //   14	22	79	finally
    //   25	40	79	finally
    //   40	57	79	finally
    //   66	74	79	finally
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(234978);
    int i1;
    if (paramInt > 9)
    {
      TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
      i1 = 9;
    }
    for (;;)
    {
      if (this.h != null) {
        this.h.f(i1);
      }
      AppMethodBeat.o(234978);
      return;
      i1 = paramInt;
      if (paramInt < 0)
      {
        TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
        i1 = 0;
      }
    }
  }
  
  public void g(int paramInt)
  {
    try
    {
      AppMethodBeat.i(234982);
      if (this.h != null) {
        this.h.h(paramInt);
      }
      this.q.a("eyeBigScale", paramInt);
      AppMethodBeat.o(234982);
      return;
    }
    finally {}
  }
  
  public void h(int paramInt)
  {
    try
    {
      AppMethodBeat.i(234983);
      if (this.h != null) {
        this.h.j(paramInt);
      }
      this.q.a("faceSlimLevel", paramInt);
      AppMethodBeat.o(234983);
      return;
    }
    finally {}
  }
  
  public void i(int paramInt)
  {
    try
    {
      AppMethodBeat.i(234984);
      if (this.h != null) {
        this.h.k(paramInt);
      }
      this.q.a("faceNarrowLevel", paramInt);
      AppMethodBeat.o(234984);
      return;
    }
    finally {}
  }
  
  public void j(int paramInt)
  {
    AppMethodBeat.i(234985);
    if (this.h != null) {
      this.h.i(paramInt);
    }
    this.q.a("faceVLevel", paramInt);
    AppMethodBeat.o(234985);
  }
  
  public void k(int paramInt)
  {
    AppMethodBeat.i(234986);
    if (this.h != null) {
      this.h.l(paramInt);
    }
    this.q.a("faceShortLevel", paramInt);
    AppMethodBeat.o(234986);
  }
  
  public void l(int paramInt)
  {
    AppMethodBeat.i(234987);
    if (this.h != null) {
      this.h.m(paramInt);
    }
    this.q.a("chinLevel", paramInt);
    AppMethodBeat.o(234987);
  }
  
  public void m(int paramInt)
  {
    AppMethodBeat.i(234988);
    if (this.h != null) {
      this.h.n(paramInt);
    }
    this.q.a("noseSlimLevel", paramInt);
    AppMethodBeat.o(234988);
  }
  
  public void n(int paramInt)
  {
    AppMethodBeat.i(234989);
    if (this.h != null) {
      this.h.o(paramInt);
    }
    this.q.a("eyeLightenLevel", paramInt);
    AppMethodBeat.o(234989);
  }
  
  public void o(int paramInt)
  {
    AppMethodBeat.i(234990);
    if (this.h != null) {
      this.h.p(paramInt);
    }
    this.q.a("toothWhitenLevel", paramInt);
    AppMethodBeat.o(234990);
  }
  
  public void p(int paramInt)
  {
    AppMethodBeat.i(234991);
    if (this.h != null) {
      this.h.q(paramInt);
    }
    this.q.a("wrinkleRemoveLevel", paramInt);
    AppMethodBeat.o(234991);
  }
  
  public void q(int paramInt)
  {
    AppMethodBeat.i(234992);
    if (this.h != null) {
      this.h.r(paramInt);
    }
    this.q.a("pounchRemoveLevel", paramInt);
    AppMethodBeat.o(234992);
  }
  
  public void r(int paramInt)
  {
    AppMethodBeat.i(234993);
    if (this.h != null) {
      this.h.s(paramInt);
    }
    this.q.a("smileLinesRemoveLevel", paramInt);
    AppMethodBeat.o(234993);
  }
  
  public void s(int paramInt)
  {
    AppMethodBeat.i(234994);
    if (this.h != null) {
      this.h.t(paramInt);
    }
    this.q.a("foreheadLevel", paramInt);
    AppMethodBeat.o(234994);
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(235004);
    super.setID(paramString);
    setStatusValue(3001, this.q.a());
    AppMethodBeat.o(235004);
  }
  
  public void t(int paramInt)
  {
    AppMethodBeat.i(234995);
    if (this.h != null) {
      this.h.u(paramInt);
    }
    this.q.a("eyeDistanceLevel", paramInt);
    AppMethodBeat.o(234995);
  }
  
  public void u(int paramInt)
  {
    AppMethodBeat.i(234996);
    if (this.h != null) {
      this.h.v(paramInt);
    }
    this.q.a("eyeAngleLevel", paramInt);
    AppMethodBeat.o(234996);
  }
  
  public void v(int paramInt)
  {
    AppMethodBeat.i(234997);
    if (this.h != null) {
      this.h.w(paramInt);
    }
    this.q.a("mouthShapeLevel", paramInt);
    AppMethodBeat.o(234997);
  }
  
  public void w(int paramInt)
  {
    AppMethodBeat.i(234998);
    if (this.h != null) {
      this.h.x(paramInt);
    }
    this.q.a("noseWingLevel", paramInt);
    AppMethodBeat.o(234998);
  }
  
  public void x(int paramInt)
  {
    AppMethodBeat.i(234999);
    if (this.h != null) {
      this.h.y(paramInt);
    }
    this.q.a("nosePositionLevel", paramInt);
    AppMethodBeat.o(234999);
  }
  
  public void y(int paramInt)
  {
    AppMethodBeat.i(235000);
    if (this.h != null) {
      this.h.z(paramInt);
    }
    this.q.a("lipsThicknessLevel", paramInt);
    AppMethodBeat.o(235000);
  }
  
  public void z(int paramInt)
  {
    AppMethodBeat.i(235001);
    if (this.h != null) {
      this.h.A(paramInt);
    }
    this.q.a("faceBeautyLevel", paramInt);
    AppMethodBeat.o(235001);
  }
  
  static class b
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j;
    public int k = 5;
    public int l = 0;
    com.tencent.liteav.basic.opengl.a m = null;
  }
  
  static class c
  {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public boolean e = false;
    public int f;
    public int g;
    public int h = 5;
    public int i = 0;
    public com.tencent.liteav.basic.opengl.a j = null;
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(234554);
      a = new d("MODE_SAME_AS_OUTPUT", 0);
      b = new d("MODE_SAME_AS_INPUT", 1);
      c = new d("MODE_THRESHOLD", 2);
      d = new d[] { a, b, c };
      AppMethodBeat.o(234554);
    }
    
    private d() {}
  }
  
  public static class f
  {
    public Bitmap a;
    public float b;
    public float c;
    public float d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.d
 * JD-Core Version:    0.7.0.1
 */