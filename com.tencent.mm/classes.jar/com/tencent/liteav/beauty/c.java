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
  protected int g;
  protected com.tencent.liteav.basic.d.a h;
  protected b i;
  protected b j;
  protected c k;
  e l;
  private boolean m;
  private long n;
  private long o;
  private long p;
  private Object q;
  private c.a r;
  
  public c(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(15215);
    this.b = true;
    this.c = false;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 1;
    this.h = null;
    this.j = new b();
    this.k = null;
    this.m = false;
    this.n = 0L;
    this.o = 0L;
    this.p = 0L;
    this.r = new c.a(this);
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
      this.i = new b(this.a, this.b);
      a.a().a(paramContext);
      AppMethodBeat.o(15215);
      return;
      TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_2");
      i.a(2);
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
    AppMethodBeat.i(15224);
    if (this.k == null)
    {
      this.k = new c(null);
      this.o = 0L;
      this.p = System.currentTimeMillis();
    }
    if ((paramInt1 != this.k.b) || (paramInt2 != this.k.c) || (paramInt3 != this.k.f) || ((this.d > 0) && (this.d != this.k.h)) || ((this.e > 0) && (this.e != this.k.i)) || ((this.f > 0) && (this.f != this.k.j)) || ((this.h != null) && (((this.h.c > 0) && ((this.k.m == null) || (this.h.c != this.k.m.c))) || ((this.h.d > 0) && ((this.k.m == null) || (this.h.d != this.k.m.d))) || ((this.h.a >= 0) && ((this.k.m == null) || (this.h.a != this.k.m.a))) || ((this.h.b >= 0) && ((this.k.m == null) || (this.h.b != this.k.m.b))))) || (this.c != this.k.g) || (this.k.k != paramInt4))
    {
      TXCLog.i("TXCVideoPreprocessor", "Init sdk");
      TXCLog.i("TXCVideoPreprocessor", "Input widht " + paramInt1 + " height " + paramInt2);
      this.k.b = paramInt1;
      this.k.c = paramInt2;
      int i2 = paramInt1;
      int i1 = paramInt2;
      if (this.h != null)
      {
        i2 = paramInt1;
        i1 = paramInt2;
        if (this.h.a >= 0)
        {
          i2 = paramInt1;
          i1 = paramInt2;
          if (this.h.b >= 0)
          {
            i2 = paramInt1;
            i1 = paramInt2;
            if (this.h.c > 0)
            {
              i2 = paramInt1;
              i1 = paramInt2;
              if (this.h.d > 0)
              {
                TXCLog.i("TXCVideoPreprocessor", "set Crop Rect; init ");
                if (paramInt1 - this.h.a <= this.h.c) {
                  break label904;
                }
                paramInt1 = this.h.c;
                if (paramInt2 - this.h.b <= this.h.d) {
                  break label917;
                }
                paramInt2 = this.h.d;
                label517:
                this.h.c = paramInt1;
                this.h.d = paramInt2;
                i2 = this.h.c;
                i1 = this.h.d;
              }
            }
          }
        }
      }
      this.k.m = this.h;
      this.k.f = paramInt3;
      this.k.a = this.b;
      this.k.k = paramInt4;
      this.k.l = paramInt5;
      if (true == this.m)
      {
        this.k.h = this.d;
        this.k.i = this.e;
        label629:
        this.k.j = this.f;
        if (this.k.j <= 0) {
          this.k.j = 0;
        }
        if ((this.k.h <= 0) || (this.k.i <= 0))
        {
          if ((90 != this.k.j) && (270 != this.k.j)) {
            break label949;
          }
          this.k.h = i1;
          this.k.i = i2;
        }
        label721:
        if ((90 != this.k.j) && (270 != this.k.j)) {
          break label970;
        }
        this.k.d = this.k.i;
        this.k.e = this.k.h;
        label774:
        if (true != this.m)
        {
          this.k.h = this.d;
          this.k.i = this.e;
          if ((this.k.h <= 0) || (this.k.i <= 0))
          {
            if ((90 != this.k.j) && (270 != this.k.j)) {
              break label1001;
            }
            this.k.h = i1;
          }
        }
      }
      for (this.k.i = i2;; this.k.i = i1)
      {
        this.k.g = this.c;
        if (a(this.k)) {
          break label1091;
        }
        TXCLog.e("TXCVideoPreprocessor", "init failed!");
        AppMethodBeat.o(15224);
        return false;
        label904:
        paramInt1 -= this.h.a;
        break;
        label917:
        paramInt2 -= this.h.b;
        break label517;
        this.k.h = 0;
        this.k.i = 0;
        break label629;
        label949:
        this.k.h = i2;
        this.k.i = i1;
        break label721;
        label970:
        this.k.d = this.k.h;
        this.k.e = this.k.i;
        break label774;
        label1001:
        this.k.h = i2;
      }
    }
    if ((paramInt4 != this.k.k) || (paramInt5 != this.k.l))
    {
      this.k.k = paramInt4;
      this.j.k = paramInt4;
      this.k.l = paramInt5;
      this.j.l = paramInt5;
      this.i.b(paramInt5);
    }
    label1091:
    AppMethodBeat.o(15224);
    return true;
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(15225);
    this.j.d = paramc.b;
    this.j.e = paramc.c;
    this.j.m = paramc.m;
    this.j.g = paramc.d;
    this.j.f = paramc.e;
    this.j.h = ((paramc.f + 360) % 360);
    this.j.b = paramc.h;
    this.j.c = paramc.i;
    this.j.a = paramc.j;
    this.j.j = paramc.a;
    this.j.i = paramc.g;
    this.j.k = paramc.k;
    this.j.l = paramc.l;
    if (this.i == null)
    {
      this.i = new b(this.a, paramc.a);
      this.i.a(this.g);
    }
    boolean bool = this.i.a(this.j);
    AppMethodBeat.o(15225);
    return bool;
  }
  
  private void c()
  {
    AppMethodBeat.i(15214);
    if (this.n != 0L) {
      setStatusValue(3002, Long.valueOf(System.currentTimeMillis() - this.n));
    }
    this.o += 1L;
    long l1 = System.currentTimeMillis();
    if (l1 > this.p + 2000L)
    {
      setStatusValue(3003, Double.valueOf(this.o * 1000.0D / (l1 - this.p)));
      this.o = 0L;
      this.p = l1;
    }
    AppMethodBeat.o(15214);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    AppMethodBeat.i(15211);
    if (this.l != null)
    {
      com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
      localb.e = paramInt2;
      localb.f = paramInt3;
      if (this.k != null) {}
      for (paramInt2 = this.k.j;; paramInt2 = 0)
      {
        localb.j = paramInt2;
        if (this.k != null) {
          bool = this.k.g;
        }
        localb.i = bool;
        localb.a = paramInt1;
        paramInt1 = this.l.a(localb);
        AppMethodBeat.o(15211);
        return paramInt1;
      }
    }
    AppMethodBeat.o(15211);
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong)
  {
    try
    {
      AppMethodBeat.i(15219);
      a(paramInt2, paramInt3, A(paramInt4), paramInt5, paramInt6);
      this.i.b(this.j);
      paramInt1 = this.i.a(paramInt1, paramInt5, paramLong);
      AppMethodBeat.o(15219);
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
    //   2: sipush 15220
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   12: putfield 82	com/tencent/liteav/beauty/c:n	J
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
    //   37: getfield 285	com/tencent/liteav/basic/structs/b:i	Z
    //   40: invokevirtual 315	com/tencent/liteav/beauty/c:c	(Z)V
    //   43: aload_0
    //   44: aload_1
    //   45: getfield 284	com/tencent/liteav/basic/structs/b:j	I
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
    //   75: getfield 286	com/tencent/liteav/basic/structs/b:a	I
    //   78: iconst_m1
    //   79: if_icmpne +36 -> 115
    //   82: aload_0
    //   83: aload_1
    //   84: getfield 329	com/tencent/liteav/basic/structs/b:m	[B
    //   87: aload_1
    //   88: getfield 282	com/tencent/liteav/basic/structs/b:e	I
    //   91: aload_1
    //   92: getfield 283	com/tencent/liteav/basic/structs/b:f	I
    //   95: aload_1
    //   96: getfield 284	com/tencent/liteav/basic/structs/b:j	I
    //   99: iload_2
    //   100: iload_3
    //   101: invokevirtual 332	com/tencent/liteav/beauty/c:a	([BIIIII)I
    //   104: istore_2
    //   105: sipush 15220
    //   108: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: monitorexit
    //   113: iload_2
    //   114: ireturn
    //   115: aload_0
    //   116: aload_1
    //   117: getfield 286	com/tencent/liteav/basic/structs/b:a	I
    //   120: aload_1
    //   121: getfield 282	com/tencent/liteav/basic/structs/b:e	I
    //   124: aload_1
    //   125: getfield 283	com/tencent/liteav/basic/structs/b:f	I
    //   128: aload_1
    //   129: getfield 284	com/tencent/liteav/basic/structs/b:j	I
    //   132: iload_2
    //   133: iload_3
    //   134: lload 4
    //   136: invokevirtual 334	com/tencent/liteav/beauty/c:a	(IIIIIIJ)I
    //   139: istore_2
    //   140: sipush 15220
    //   143: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(15218);
      a(paramInt1, paramInt2, A(paramInt3), paramInt4, paramInt5);
      this.i.b(this.j);
      paramInt1 = this.i.a(paramArrayOfByte, paramInt4);
      AppMethodBeat.o(15218);
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
      Object localObject1 = this.q;
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
      AppMethodBeat.i(15255);
      if (this.i != null) {
        this.i.a(paramFloat);
      }
      AppMethodBeat.o(15255);
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
    AppMethodBeat.i(15212);
    c();
    com.tencent.liteav.basic.structs.b localb;
    if (this.l != null)
    {
      localb = new com.tencent.liteav.basic.structs.b();
      localb.e = paramInt2;
      localb.f = paramInt3;
      if (this.k == null) {
        break label111;
      }
    }
    label111:
    for (paramInt2 = this.k.j;; paramInt2 = 0)
    {
      localb.j = paramInt2;
      if (this.k != null) {
        bool = this.k.g;
      }
      localb.i = bool;
      localb.a = paramInt1;
      this.l.a(localb, paramLong);
      AppMethodBeat.o(15212);
      return;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(15256);
      if (this.i != null) {
        this.i.a(paramBitmap);
      }
      AppMethodBeat.o(15256);
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
    //   2: sipush 15221
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
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
    //   28: ldc 103
    //   30: ldc_w 355
    //   33: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: sipush 15221
    //   39: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: getfield 161	com/tencent/liteav/beauty/c:i	Lcom/tencent/liteav/beauty/b;
    //   49: ifnull +15 -> 64
    //   52: aload_0
    //   53: getfield 161	com/tencent/liteav/beauty/c:i	Lcom/tencent/liteav/beauty/b;
    //   56: aload_1
    //   57: fload_2
    //   58: fload_3
    //   59: fload 4
    //   61: invokevirtual 357	com/tencent/liteav/beauty/b:a	(Landroid/graphics/Bitmap;FFF)V
    //   64: sipush 15221
    //   67: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: sipush 15223
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 161	com/tencent/liteav/beauty/c:i	Lcom/tencent/liteav/beauty/b;
    //   12: ifnonnull +20 -> 32
    //   15: ldc 103
    //   17: ldc_w 360
    //   20: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: sipush 15223
    //   26: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 161	com/tencent/liteav/beauty/c:i	Lcom/tencent/liteav/beauty/b;
    //   36: aload_1
    //   37: invokevirtual 362	com/tencent/liteav/beauty/b:a	(Lcom/tencent/liteav/basic/c/a;)V
    //   40: sipush 15223
    //   43: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      this.h = parama;
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
        AppMethodBeat.i(15222);
        if (this.i == null)
        {
          TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
          AppMethodBeat.o(15222);
          return;
        }
        this.l = parame;
        if (parame == null)
        {
          this.i.a(null);
          AppMethodBeat.o(15222);
          continue;
        }
        this.i.a(this);
      }
      finally {}
      AppMethodBeat.o(15222);
    }
  }
  
  public void a(Object paramObject)
  {
    try
    {
      this.q = paramObject;
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
      AppMethodBeat.i(15233);
      if (this.i != null) {
        this.i.a(paramString);
      }
      AppMethodBeat.o(15233);
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(15217);
    if (this.i != null) {
      this.i.a(paramBoolean);
    }
    AppMethodBeat.o(15217);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(15213);
    if (this.l != null) {
      this.l.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    }
    AppMethodBeat.o(15213);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(15216);
    if (this.i != null) {
      this.i.a(paramArrayOfFloat);
    }
    AppMethodBeat.o(15216);
  }
  
  @TargetApi(18)
  public boolean a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(15235);
    if (Build.VERSION.SDK_INT < 18)
    {
      AppMethodBeat.o(15235);
      return false;
    }
    if (this.i != null) {
      this.i.a(paramString, paramBoolean);
    }
    AppMethodBeat.o(15235);
    return true;
  }
  
  public void b()
  {
    try
    {
      AppMethodBeat.i(15227);
      if (this.i != null) {
        this.i.a();
      }
      this.k = null;
      AppMethodBeat.o(15227);
      return;
    }
    finally {}
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(15226);
    if (paramInt != this.g)
    {
      this.g = paramInt;
      if (this.i != null) {
        this.i.a(this.g);
      }
    }
    AppMethodBeat.o(15226);
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.m = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(int paramInt)
  {
    try
    {
      AppMethodBeat.i(15228);
      if (this.i != null) {
        this.i.d(paramInt);
      }
      this.r.a("beautyStyle", paramInt);
      AppMethodBeat.o(15228);
      return;
    }
    finally {}
  }
  
  public void c(boolean paramBoolean)
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
  public void d(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 15229
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: bipush 9
    //   11: if_icmple +49 -> 60
    //   14: ldc 103
    //   16: ldc_w 398
    //   19: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: bipush 9
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 161	com/tencent/liteav/beauty/c:i	Lcom/tencent/liteav/beauty/b;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: getfield 161	com/tencent/liteav/beauty/c:i	Lcom/tencent/liteav/beauty/b;
    //   36: iload_2
    //   37: invokevirtual 400	com/tencent/liteav/beauty/b:c	(I)V
    //   40: aload_0
    //   41: getfield 91	com/tencent/liteav/beauty/c:r	Lcom/tencent/liteav/beauty/c$a;
    //   44: ldc_w 402
    //   47: iload_2
    //   48: invokevirtual 396	com/tencent/liteav/beauty/c$a:a	(Ljava/lang/String;I)V
    //   51: sipush 15229
    //   54: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: iload_1
    //   61: istore_2
    //   62: iload_1
    //   63: ifge -38 -> 25
    //   66: ldc 103
    //   68: ldc_w 404
    //   71: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public void d(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(15234);
      if (this.i != null) {
        this.i.b(paramBoolean);
      }
      AppMethodBeat.o(15234);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void e(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 15230
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: bipush 9
    //   11: if_icmple +49 -> 60
    //   14: ldc 103
    //   16: ldc_w 408
    //   19: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: bipush 9
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 161	com/tencent/liteav/beauty/c:i	Lcom/tencent/liteav/beauty/b;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: getfield 161	com/tencent/liteav/beauty/c:i	Lcom/tencent/liteav/beauty/b;
    //   36: iload_2
    //   37: invokevirtual 410	com/tencent/liteav/beauty/b:e	(I)V
    //   40: aload_0
    //   41: getfield 91	com/tencent/liteav/beauty/c:r	Lcom/tencent/liteav/beauty/c$a;
    //   44: ldc_w 412
    //   47: iload_2
    //   48: invokevirtual 396	com/tencent/liteav/beauty/c$a:a	(Ljava/lang/String;I)V
    //   51: sipush 15230
    //   54: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: iload_1
    //   61: istore_2
    //   62: iload_1
    //   63: ifge -38 -> 25
    //   66: ldc 103
    //   68: ldc_w 414
    //   71: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  public void f(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 15231
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: bipush 9
    //   11: if_icmple +49 -> 60
    //   14: ldc 103
    //   16: ldc_w 416
    //   19: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: bipush 9
    //   24: istore_2
    //   25: aload_0
    //   26: getfield 161	com/tencent/liteav/beauty/c:i	Lcom/tencent/liteav/beauty/b;
    //   29: ifnull +11 -> 40
    //   32: aload_0
    //   33: getfield 161	com/tencent/liteav/beauty/c:i	Lcom/tencent/liteav/beauty/b;
    //   36: iload_2
    //   37: invokevirtual 418	com/tencent/liteav/beauty/b:g	(I)V
    //   40: aload_0
    //   41: getfield 91	com/tencent/liteav/beauty/c:r	Lcom/tencent/liteav/beauty/c$a;
    //   44: ldc_w 420
    //   47: iload_2
    //   48: invokevirtual 396	com/tencent/liteav/beauty/c$a:a	(Ljava/lang/String;I)V
    //   51: sipush 15231
    //   54: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: iload_1
    //   61: istore_2
    //   62: iload_1
    //   63: ifge -38 -> 25
    //   66: ldc 103
    //   68: ldc_w 422
    //   71: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(15232);
    int i1;
    if (paramInt > 9)
    {
      TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
      i1 = 9;
    }
    for (;;)
    {
      if (this.i != null) {
        this.i.f(i1);
      }
      AppMethodBeat.o(15232);
      return;
      i1 = paramInt;
      if (paramInt < 0)
      {
        TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
        i1 = 0;
      }
    }
  }
  
  public void h(int paramInt)
  {
    try
    {
      AppMethodBeat.i(15236);
      if (this.i != null) {
        this.i.h(paramInt);
      }
      this.r.a("eyeBigScale", paramInt);
      AppMethodBeat.o(15236);
      return;
    }
    finally {}
  }
  
  public void i(int paramInt)
  {
    try
    {
      AppMethodBeat.i(15237);
      if (this.i != null) {
        this.i.i(paramInt);
      }
      this.r.a("faceSlimLevel", paramInt);
      AppMethodBeat.o(15237);
      return;
    }
    finally {}
  }
  
  public void j(int paramInt)
  {
    AppMethodBeat.i(15238);
    if (this.i != null) {
      this.i.j(paramInt);
    }
    this.r.a("faceVLevel", paramInt);
    AppMethodBeat.o(15238);
  }
  
  public void k(int paramInt)
  {
    AppMethodBeat.i(15239);
    if (this.i != null) {
      this.i.k(paramInt);
    }
    this.r.a("faceShortLevel", paramInt);
    AppMethodBeat.o(15239);
  }
  
  public void l(int paramInt)
  {
    AppMethodBeat.i(15240);
    if (this.i != null) {
      this.i.l(paramInt);
    }
    this.r.a("chinLevel", paramInt);
    AppMethodBeat.o(15240);
  }
  
  public void m(int paramInt)
  {
    AppMethodBeat.i(15241);
    if (this.i != null) {
      this.i.m(paramInt);
    }
    this.r.a("noseSlimLevel", paramInt);
    AppMethodBeat.o(15241);
  }
  
  public void n(int paramInt)
  {
    AppMethodBeat.i(15242);
    if (this.i != null) {
      this.i.n(paramInt);
    }
    this.r.a("eyeLightenLevel", paramInt);
    AppMethodBeat.o(15242);
  }
  
  public void o(int paramInt)
  {
    AppMethodBeat.i(15243);
    if (this.i != null) {
      this.i.o(paramInt);
    }
    this.r.a("toothWhitenLevel", paramInt);
    AppMethodBeat.o(15243);
  }
  
  public void p(int paramInt)
  {
    AppMethodBeat.i(15244);
    if (this.i != null) {
      this.i.p(paramInt);
    }
    this.r.a("wrinkleRemoveLevel", paramInt);
    AppMethodBeat.o(15244);
  }
  
  public void q(int paramInt)
  {
    AppMethodBeat.i(15245);
    if (this.i != null) {
      this.i.q(paramInt);
    }
    this.r.a("pounchRemoveLevel", paramInt);
    AppMethodBeat.o(15245);
  }
  
  public void r(int paramInt)
  {
    AppMethodBeat.i(15246);
    if (this.i != null) {
      this.i.r(paramInt);
    }
    this.r.a("smileLinesRemoveLevel", paramInt);
    AppMethodBeat.o(15246);
  }
  
  public void s(int paramInt)
  {
    AppMethodBeat.i(15247);
    if (this.i != null) {
      this.i.s(paramInt);
    }
    this.r.a("foreheadLevel", paramInt);
    AppMethodBeat.o(15247);
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(15257);
    super.setID(paramString);
    setStatusValue(3001, this.r.a());
    AppMethodBeat.o(15257);
  }
  
  public void t(int paramInt)
  {
    AppMethodBeat.i(15248);
    if (this.i != null) {
      this.i.t(paramInt);
    }
    this.r.a("eyeDistanceLevel", paramInt);
    AppMethodBeat.o(15248);
  }
  
  public void u(int paramInt)
  {
    AppMethodBeat.i(15249);
    if (this.i != null) {
      this.i.u(paramInt);
    }
    this.r.a("eyeAngleLevel", paramInt);
    AppMethodBeat.o(15249);
  }
  
  public void v(int paramInt)
  {
    AppMethodBeat.i(15250);
    if (this.i != null) {
      this.i.v(paramInt);
    }
    this.r.a("mouthShapeLevel", paramInt);
    AppMethodBeat.o(15250);
  }
  
  public void w(int paramInt)
  {
    AppMethodBeat.i(15251);
    if (this.i != null) {
      this.i.w(paramInt);
    }
    this.r.a("noseWingLevel", paramInt);
    AppMethodBeat.o(15251);
  }
  
  public void x(int paramInt)
  {
    AppMethodBeat.i(15252);
    if (this.i != null) {
      this.i.x(paramInt);
    }
    this.r.a("nosePositionLevel", paramInt);
    AppMethodBeat.o(15252);
  }
  
  public void y(int paramInt)
  {
    AppMethodBeat.i(15253);
    if (this.i != null) {
      this.i.y(paramInt);
    }
    this.r.a("lipsThicknessLevel", paramInt);
    AppMethodBeat.o(15253);
  }
  
  public void z(int paramInt)
  {
    AppMethodBeat.i(15254);
    if (this.i != null) {
      this.i.z(paramInt);
    }
    this.r.a("faceBeautyLevel", paramInt);
    AppMethodBeat.o(15254);
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
  
  static class c
  {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g = false;
    public int h;
    public int i;
    public int j;
    public int k = 5;
    public int l = 0;
    public com.tencent.liteav.basic.d.a m = null;
  }
  
  public static class e
  {
    public Bitmap a;
    public float b;
    public float c;
    public float d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.c
 * JD-Core Version:    0.7.0.1
 */