package com.tencent.liteav.beauty;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.d.i;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends com.tencent.liteav.basic.module.a
  implements d
{
  protected Context a;
  protected boolean b;
  protected boolean c;
  protected int d;
  protected int e;
  protected int f;
  protected com.tencent.liteav.basic.d.a g;
  protected b h;
  protected b i;
  protected c.c j;
  e k;
  private boolean l;
  private long m;
  private long n;
  private long o;
  private Object p;
  private c.a q;
  
  public c(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(67059);
    this.b = true;
    this.c = false;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = null;
    this.i = new b();
    this.j = null;
    this.l = true;
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
    this.q = new c.a(this);
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
        i.a(3);
      }
    }
    for (;;)
    {
      this.a = paramContext;
      this.b = paramBoolean;
      this.h = new b(this.a, this.b);
      a.a().a(paramContext);
      AppMethodBeat.o(67059);
      return;
      TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_2");
      i.a(2);
      continue;
      TXCLog.e("TXCVideoPreprocessor", "getDeviceConfigurationInfo opengl Info failed!");
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(67068);
    if (this.j == null)
    {
      this.j = new c.c(null);
      this.n = 0L;
      this.o = System.currentTimeMillis();
    }
    if ((paramInt1 != this.j.b) || (paramInt2 != this.j.c) || (paramInt3 != this.j.f) || ((this.d > 0) && (this.d != this.j.h)) || ((this.e > 0) && (this.e != this.j.i)) || ((this.f > 0) && (this.f != this.j.j)) || ((this.g != null) && (((this.g.c > 0) && ((this.j.m == null) || (this.g.c != this.j.m.c))) || ((this.g.d > 0) && ((this.j.m == null) || (this.g.d != this.j.m.d))) || ((this.g.a >= 0) && ((this.j.m == null) || (this.g.a != this.j.m.a))) || ((this.g.b >= 0) && ((this.j.m == null) || (this.g.b != this.j.m.b))))) || (this.c != this.j.g) || (this.j.k != paramInt4))
    {
      TXCLog.i("TXCVideoPreprocessor", "Init sdk");
      TXCLog.i("TXCVideoPreprocessor", "Input widht " + paramInt1 + " height " + paramInt2);
      this.j.b = paramInt1;
      this.j.c = paramInt2;
      int i2 = paramInt1;
      int i1 = paramInt2;
      if (this.g != null)
      {
        i2 = paramInt1;
        i1 = paramInt2;
        if (this.g.a >= 0)
        {
          i2 = paramInt1;
          i1 = paramInt2;
          if (this.g.b >= 0)
          {
            i2 = paramInt1;
            i1 = paramInt2;
            if (this.g.c > 0)
            {
              i2 = paramInt1;
              i1 = paramInt2;
              if (this.g.d > 0)
              {
                TXCLog.i("TXCVideoPreprocessor", "set Crop Rect; init ");
                if (paramInt1 - this.g.a <= this.g.c) {
                  break label902;
                }
                paramInt1 = this.g.c;
                if (paramInt2 - this.g.b <= this.g.d) {
                  break label915;
                }
                paramInt2 = this.g.d;
                label516:
                this.g.c = paramInt1;
                this.g.d = paramInt2;
                i2 = this.g.c;
                i1 = this.g.d;
              }
            }
          }
        }
      }
      this.j.m = this.g;
      this.j.f = paramInt3;
      this.j.a = this.b;
      this.j.k = paramInt4;
      this.j.l = paramInt5;
      if (true == this.l)
      {
        this.j.h = this.d;
        this.j.i = this.e;
        label628:
        this.j.j = this.f;
        if (this.j.j <= 0) {
          this.j.j = 0;
        }
        if ((this.j.h <= 0) || (this.j.i <= 0))
        {
          if ((90 != this.j.j) && (270 != this.j.j)) {
            break label947;
          }
          this.j.h = i1;
          this.j.i = i2;
        }
        label720:
        if ((90 != this.j.j) && (270 != this.j.j)) {
          break label968;
        }
        this.j.d = this.j.i;
        this.j.e = this.j.h;
        label773:
        if (true != this.l)
        {
          this.j.h = this.d;
          this.j.i = this.e;
          if ((this.j.h <= 0) || (this.j.i <= 0))
          {
            if ((90 != this.j.j) && (270 != this.j.j)) {
              break label999;
            }
            this.j.h = i1;
          }
        }
      }
      for (this.j.i = i2;; this.j.i = i1)
      {
        this.j.g = this.c;
        if (a(this.j)) {
          break label1089;
        }
        TXCLog.e("TXCVideoPreprocessor", "init failed!");
        AppMethodBeat.o(67068);
        return false;
        label902:
        paramInt1 -= this.g.a;
        break;
        label915:
        paramInt2 -= this.g.b;
        break label516;
        this.j.h = 0;
        this.j.i = 0;
        break label628;
        label947:
        this.j.h = i2;
        this.j.i = i1;
        break label720;
        label968:
        this.j.d = this.j.h;
        this.j.e = this.j.i;
        break label773;
        label999:
        this.j.h = i2;
      }
    }
    if ((paramInt4 != this.j.k) || (paramInt5 != this.j.l))
    {
      this.j.k = paramInt4;
      this.i.k = paramInt4;
      this.j.l = paramInt5;
      this.i.l = paramInt5;
      this.h.a(paramInt5);
    }
    label1089:
    AppMethodBeat.o(67068);
    return true;
  }
  
  private boolean a(c.c paramc)
  {
    AppMethodBeat.i(67069);
    this.i.d = paramc.b;
    this.i.e = paramc.c;
    this.i.m = paramc.m;
    this.i.g = paramc.d;
    this.i.f = paramc.e;
    this.i.h = ((paramc.f + 360) % 360);
    this.i.b = paramc.h;
    this.i.c = paramc.i;
    this.i.a = paramc.j;
    this.i.j = paramc.a;
    this.i.i = paramc.g;
    this.i.k = paramc.k;
    this.i.l = paramc.l;
    if (this.h == null) {
      this.h = new b(this.a, paramc.a);
    }
    boolean bool = this.h.a(this.i);
    AppMethodBeat.o(67069);
    return bool;
  }
  
  private void c()
  {
    AppMethodBeat.i(146335);
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
    AppMethodBeat.o(146335);
  }
  
  private int m(int paramInt)
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
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    AppMethodBeat.i(67055);
    if (this.k != null)
    {
      com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
      localb.e = paramInt2;
      localb.f = paramInt3;
      if (this.j != null) {}
      for (paramInt2 = this.j.j;; paramInt2 = 0)
      {
        localb.j = paramInt2;
        if (this.j != null) {
          bool = this.j.g;
        }
        localb.i = bool;
        localb.a = paramInt1;
        paramInt1 = this.k.a(localb);
        AppMethodBeat.o(67055);
        return paramInt1;
      }
    }
    AppMethodBeat.o(67055);
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong)
  {
    try
    {
      AppMethodBeat.i(146337);
      a(paramInt2, paramInt3, m(paramInt4), paramInt5, paramInt6);
      this.h.b(this.i);
      paramInt1 = this.h.a(paramInt1, paramInt5, paramLong);
      AppMethodBeat.o(146337);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int a(com.tencent.liteav.basic.structs.b paramb, int paramInt1, int paramInt2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 302
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   12: putfield 78	com/tencent/liteav/beauty/c:m	J
    //   15: aload_0
    //   16: aload_1
    //   17: getfield 304	com/tencent/liteav/basic/structs/b:l	Lcom/tencent/liteav/basic/d/a;
    //   20: invokevirtual 307	com/tencent/liteav/beauty/c:a	(Lcom/tencent/liteav/basic/d/a;)V
    //   23: aload_0
    //   24: aload_1
    //   25: getfield 308	com/tencent/liteav/basic/structs/b:g	I
    //   28: aload_1
    //   29: getfield 309	com/tencent/liteav/basic/structs/b:h	I
    //   32: invokevirtual 312	com/tencent/liteav/beauty/c:a	(II)V
    //   35: aload_0
    //   36: aload_1
    //   37: getfield 283	com/tencent/liteav/basic/structs/b:i	Z
    //   40: invokevirtual 315	com/tencent/liteav/beauty/c:b	(Z)V
    //   43: aload_0
    //   44: aload_1
    //   45: getfield 282	com/tencent/liteav/basic/structs/b:j	I
    //   48: invokevirtual 316	com/tencent/liteav/beauty/c:a	(I)V
    //   51: aload_0
    //   52: aload_1
    //   53: getfield 319	com/tencent/liteav/basic/structs/b:c	[F
    //   56: invokevirtual 322	com/tencent/liteav/beauty/c:a	([F)V
    //   59: aload_0
    //   60: aload_1
    //   61: getfield 324	com/tencent/liteav/basic/structs/b:d	Z
    //   64: invokevirtual 326	com/tencent/liteav/beauty/c:a	(Z)V
    //   67: aload_1
    //   68: getfield 329	com/tencent/liteav/basic/structs/b:m	[B
    //   71: ifnull +44 -> 115
    //   74: aload_1
    //   75: getfield 284	com/tencent/liteav/basic/structs/b:a	I
    //   78: iconst_m1
    //   79: if_icmpne +36 -> 115
    //   82: aload_0
    //   83: aload_1
    //   84: getfield 329	com/tencent/liteav/basic/structs/b:m	[B
    //   87: aload_1
    //   88: getfield 280	com/tencent/liteav/basic/structs/b:e	I
    //   91: aload_1
    //   92: getfield 281	com/tencent/liteav/basic/structs/b:f	I
    //   95: aload_1
    //   96: getfield 282	com/tencent/liteav/basic/structs/b:j	I
    //   99: iload_2
    //   100: iload_3
    //   101: invokevirtual 332	com/tencent/liteav/beauty/c:a	([BIIIII)I
    //   104: istore_2
    //   105: ldc_w 302
    //   108: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: monitorexit
    //   113: iload_2
    //   114: ireturn
    //   115: aload_0
    //   116: aload_1
    //   117: getfield 284	com/tencent/liteav/basic/structs/b:a	I
    //   120: aload_1
    //   121: getfield 280	com/tencent/liteav/basic/structs/b:e	I
    //   124: aload_1
    //   125: getfield 281	com/tencent/liteav/basic/structs/b:f	I
    //   128: aload_1
    //   129: getfield 282	com/tencent/liteav/basic/structs/b:j	I
    //   132: iload_2
    //   133: iload_3
    //   134: lload 4
    //   136: invokevirtual 334	com/tencent/liteav/beauty/c:a	(IIIIIIJ)I
    //   139: istore_2
    //   140: ldc_w 302
    //   143: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: goto -35 -> 111
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	c
    //   0	154	1	paramb	com.tencent.liteav.basic.structs.b
    //   0	154	2	paramInt1	int
    //   0	154	3	paramInt2	int
    //   0	154	4	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   2	111	149	finally
    //   115	146	149	finally
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    try
    {
      AppMethodBeat.i(67061);
      a(paramInt1, paramInt2, m(paramInt3), paramInt4, paramInt5);
      this.h.b(this.i);
      paramInt1 = this.h.a(paramArrayOfByte, paramInt4);
      AppMethodBeat.o(67061);
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
      AppMethodBeat.i(67085);
      if (this.h != null) {
        this.h.a(paramFloat);
      }
      AppMethodBeat.o(67085);
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.f = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    AppMethodBeat.i(67056);
    c();
    com.tencent.liteav.basic.structs.b localb;
    if (this.k != null)
    {
      localb = new com.tencent.liteav.basic.structs.b();
      localb.e = paramInt2;
      localb.f = paramInt3;
      if (this.j == null) {
        break label111;
      }
    }
    label111:
    for (paramInt2 = this.j.j;; paramInt2 = 0)
    {
      localb.j = paramInt2;
      if (this.j != null) {
        bool = this.j.g;
      }
      localb.i = bool;
      localb.a = paramInt1;
      this.k.a(localb, paramLong);
      AppMethodBeat.o(67056);
      return;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(67086);
      if (this.h != null) {
        this.h.a(paramBitmap);
      }
      AppMethodBeat.o(67086);
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
    //   2: ldc_w 358
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
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
    //   28: ldc 99
    //   30: ldc_w 360
    //   33: invokestatic 173	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: ldc_w 358
    //   39: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: getfield 157	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   49: ifnull +15 -> 64
    //   52: aload_0
    //   53: getfield 157	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   56: aload_1
    //   57: fload_2
    //   58: fload_3
    //   59: fload 4
    //   61: invokevirtual 362	com/tencent/liteav/beauty/b:a	(Landroid/graphics/Bitmap;FFF)V
    //   64: ldc_w 358
    //   67: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -28 -> 42
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	c
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
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 364
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 157	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   12: ifnonnull +20 -> 32
    //   15: ldc 99
    //   17: ldc_w 366
    //   20: invokestatic 173	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 364
    //   26: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 157	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   36: aload_1
    //   37: invokevirtual 368	com/tencent/liteav/beauty/b:a	(Lcom/tencent/liteav/basic/c/a;)V
    //   40: ldc_w 364
    //   43: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -17 -> 29
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	c
    //   0	54	1	parama	com.tencent.liteav.basic.c.a
    // Exception table:
    //   from	to	target	type
    //   2	29	49	finally
    //   32	46	49	finally
  }
  
  public void a(com.tencent.liteav.basic.d.a parama)
  {
    try
    {
      AppMethodBeat.i(67067);
      this.g = parama;
      AppMethodBeat.o(67067);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void a(e parame)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(67066);
        if (this.h == null)
        {
          TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
          AppMethodBeat.o(67066);
          return;
        }
        this.k = parame;
        if (parame == null)
        {
          this.h.a(null);
          AppMethodBeat.o(67066);
          continue;
        }
        this.h.a(this);
      }
      finally {}
      AppMethodBeat.o(67066);
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
      AppMethodBeat.i(67076);
      if (this.h != null) {
        this.h.a(paramString);
      }
      AppMethodBeat.o(67076);
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(146336);
    if (this.h != null) {
      this.h.a(paramBoolean);
    }
    AppMethodBeat.o(146336);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(67057);
    if (this.k != null) {
      this.k.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    }
    AppMethodBeat.o(67057);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(67060);
    if (this.h != null) {
      this.h.a(paramArrayOfFloat);
    }
    AppMethodBeat.o(67060);
  }
  
  @TargetApi(18)
  public boolean a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(67078);
    if (Build.VERSION.SDK_INT < 18)
    {
      AppMethodBeat.o(67078);
      return false;
    }
    if (this.h != null) {
      this.h.a(paramString, paramBoolean);
    }
    AppMethodBeat.o(67078);
    return true;
  }
  
  public void b()
  {
    try
    {
      AppMethodBeat.i(67058);
      if (this.h != null) {
        this.h.a();
      }
      this.j = null;
      AppMethodBeat.o(67058);
      return;
    }
    finally {}
  }
  
  public void b(int paramInt)
  {
    try
    {
      AppMethodBeat.i(67071);
      if (this.h != null) {
        this.h.c(paramInt);
      }
      this.q.a("beautyStyle", paramInt);
      AppMethodBeat.o(67071);
      return;
    }
    finally {}
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(67077);
      this.c = paramBoolean;
      AppMethodBeat.o(67077);
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
    //   2: ldc_w 413
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: bipush 9
    //   11: if_icmple +49 -> 60
    //   14: ldc 99
    //   16: ldc_w 415
    //   19: invokestatic 173	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: bipush 9
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 157	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: getfield 157	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   36: iload_2
    //   37: invokevirtual 417	com/tencent/liteav/beauty/b:b	(I)V
    //   40: aload_0
    //   41: getfield 87	com/tencent/liteav/beauty/c:q	Lcom/tencent/liteav/beauty/c$a;
    //   44: ldc_w 419
    //   47: iload_2
    //   48: invokevirtual 411	com/tencent/liteav/beauty/c$a:a	(Ljava/lang/String;I)V
    //   51: ldc_w 413
    //   54: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: iload_1
    //   61: istore_2
    //   62: iload_1
    //   63: ifge -38 -> 25
    //   66: ldc 99
    //   68: ldc_w 421
    //   71: invokestatic 173	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	84	0	this	c
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
      AppMethodBeat.i(146340);
      if (this.h != null) {
        this.h.b(paramBoolean);
      }
      AppMethodBeat.o(146340);
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
    //   2: ldc_w 424
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: bipush 9
    //   11: if_icmple +49 -> 60
    //   14: ldc 99
    //   16: ldc_w 426
    //   19: invokestatic 173	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: bipush 9
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 157	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: getfield 157	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   36: iload_2
    //   37: invokevirtual 428	com/tencent/liteav/beauty/b:d	(I)V
    //   40: aload_0
    //   41: getfield 87	com/tencent/liteav/beauty/c:q	Lcom/tencent/liteav/beauty/c$a;
    //   44: ldc_w 430
    //   47: iload_2
    //   48: invokevirtual 411	com/tencent/liteav/beauty/c$a:a	(Ljava/lang/String;I)V
    //   51: ldc_w 424
    //   54: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: iload_1
    //   61: istore_2
    //   62: iload_1
    //   63: ifge -38 -> 25
    //   66: ldc 99
    //   68: ldc_w 432
    //   71: invokestatic 173	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	84	0	this	c
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
    //   2: ldc_w 433
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: bipush 9
    //   11: if_icmple +49 -> 60
    //   14: ldc 99
    //   16: ldc_w 435
    //   19: invokestatic 173	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: bipush 9
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 157	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: getfield 157	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   36: iload_2
    //   37: invokevirtual 437	com/tencent/liteav/beauty/b:f	(I)V
    //   40: aload_0
    //   41: getfield 87	com/tencent/liteav/beauty/c:q	Lcom/tencent/liteav/beauty/c$a;
    //   44: ldc_w 439
    //   47: iload_2
    //   48: invokevirtual 411	com/tencent/liteav/beauty/c$a:a	(Ljava/lang/String;I)V
    //   51: ldc_w 433
    //   54: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: iload_1
    //   61: istore_2
    //   62: iload_1
    //   63: ifge -38 -> 25
    //   66: ldc 99
    //   68: ldc_w 441
    //   71: invokestatic 173	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	84	0	this	c
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
    AppMethodBeat.i(67075);
    int i1;
    if (paramInt > 9)
    {
      TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
      i1 = 9;
    }
    for (;;)
    {
      if (this.h != null) {
        this.h.e(i1);
      }
      AppMethodBeat.o(67075);
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
      AppMethodBeat.i(67079);
      if (this.h != null) {
        this.h.g(paramInt);
      }
      this.q.a("eyeBigScale", paramInt);
      AppMethodBeat.o(67079);
      return;
    }
    finally {}
  }
  
  public void h(int paramInt)
  {
    try
    {
      AppMethodBeat.i(67080);
      if (this.h != null) {
        this.h.h(paramInt);
      }
      this.q.a("faceSlimLevel", paramInt);
      AppMethodBeat.o(67080);
      return;
    }
    finally {}
  }
  
  public void i(int paramInt)
  {
    AppMethodBeat.i(67081);
    if (this.h != null) {
      this.h.i(paramInt);
    }
    this.q.a("faceVLevel", paramInt);
    AppMethodBeat.o(67081);
  }
  
  public void j(int paramInt)
  {
    AppMethodBeat.i(67082);
    if (this.h != null) {
      this.h.j(paramInt);
    }
    this.q.a("faceShortLevel", paramInt);
    AppMethodBeat.o(67082);
  }
  
  public void k(int paramInt)
  {
    AppMethodBeat.i(67083);
    if (this.h != null) {
      this.h.k(paramInt);
    }
    this.q.a("chinLevel", paramInt);
    AppMethodBeat.o(67083);
  }
  
  public void l(int paramInt)
  {
    AppMethodBeat.i(67084);
    if (this.h != null) {
      this.h.l(paramInt);
    }
    this.q.a("noseSlimLevel", paramInt);
    AppMethodBeat.o(67084);
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(67087);
    super.setID(paramString);
    setStatusValue(3001, this.q.a());
    AppMethodBeat.o(67087);
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
    com.tencent.liteav.basic.d.a m = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.beauty.c
 * JD-Core Version:    0.7.0.1
 */