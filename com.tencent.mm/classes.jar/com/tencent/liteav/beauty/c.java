package com.tencent.liteav.beauty;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.log.TXCLog;

public class c
  extends com.tencent.liteav.basic.module.a
  implements d
{
  protected Context a;
  protected boolean b = true;
  protected boolean c = false;
  protected int d = 0;
  protected int e = 0;
  protected int f = 0;
  protected com.tencent.liteav.basic.d.a g = null;
  protected b h;
  protected c.b i = new c.b();
  protected c.c j = null;
  e k;
  private boolean l = false;
  private long m = 0L;
  private long n = 0L;
  private long o = 0L;
  private c.a p = new c.a(this);
  
  public c(Context paramContext, boolean paramBoolean)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    TXCLog.i("TXCVideoPreprocessor", "TXCVideoPreprocessor version: VideoPreprocessor-v1.1");
    localObject = ((ActivityManager)localObject).getDeviceConfigurationInfo();
    if (localObject != null)
    {
      TXCLog.i("TXCVideoPreprocessor", "opengl es version " + ((ConfigurationInfo)localObject).reqGlEsVersion);
      TXCLog.i("TXCVideoPreprocessor", "set GLContext " + paramBoolean);
      if (((ConfigurationInfo)localObject).reqGlEsVersion > 131072)
      {
        TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_3");
        f.a(3);
      }
    }
    for (;;)
    {
      this.a = paramContext;
      this.b = paramBoolean;
      this.h = new b(this.a, this.b);
      a.a().a(paramContext);
      return;
      TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_2");
      f.a(2);
      continue;
      TXCLog.e("TXCVideoPreprocessor", "getDeviceConfigurationInfo opengl Info failed!");
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.j == null)
    {
      this.j = new c.c(null);
      this.n = 0L;
      this.o = System.currentTimeMillis();
    }
    if ((paramInt1 != this.j.b) || (paramInt2 != this.j.c) || (paramInt3 != this.j.f) || ((this.d > 0) && (this.d != this.j.h)) || ((this.e > 0) && (this.e != this.j.i)) || ((this.f > 0) && (this.f != this.j.j)) || ((this.g != null) && (((this.g.c > 0) && ((this.j.m == null) || (this.g.c != this.j.m.c))) || ((this.g.d > 0) && ((this.j.m == null) || (this.g.d != this.j.m.d))) || ((this.g.a >= 0) && ((this.j.m == null) || (this.g.a != this.j.m.a))) || ((this.g.b >= 0) && ((this.j.m == null) || (this.g.b != this.j.m.b))))) || (this.c != this.j.g))
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
                  break label880;
                }
                paramInt1 = this.g.c;
                if (paramInt2 - this.g.b <= this.g.d) {
                  break label893;
                }
                paramInt2 = this.g.d;
                label499:
                this.g.c = paramInt1;
                this.g.d = paramInt2;
                i2 = this.g.c;
                i1 = this.g.d;
                this.j.m = this.g;
              }
            }
          }
        }
      }
      this.j.f = paramInt3;
      this.j.a = this.b;
      this.j.k = paramInt4;
      this.j.l = paramInt5;
      if (true == this.l)
      {
        this.j.h = this.d;
        this.j.i = this.e;
        label611:
        this.j.j = this.f;
        if (this.j.j <= 0) {
          this.j.j = 0;
        }
        if ((this.j.h <= 0) || (this.j.i <= 0))
        {
          if ((90 != this.j.j) && (270 != this.j.j)) {
            break label925;
          }
          this.j.h = i1;
          this.j.i = i2;
        }
        label703:
        if ((90 != this.j.j) && (270 != this.j.j)) {
          break label946;
        }
        this.j.d = this.j.i;
        this.j.e = this.j.h;
        label756:
        if (true != this.l)
        {
          this.j.h = this.d;
          this.j.i = this.e;
          if ((this.j.h <= 0) || (this.j.i <= 0))
          {
            if ((90 != this.j.j) && (270 != this.j.j)) {
              break label977;
            }
            this.j.h = i1;
          }
        }
      }
      for (this.j.i = i2;; this.j.i = i1)
      {
        this.j.g = this.c;
        if (a(this.j)) {
          break label1067;
        }
        TXCLog.e("TXCVideoPreprocessor", "init failed!");
        return false;
        label880:
        paramInt1 -= this.g.a;
        break;
        label893:
        paramInt2 -= this.g.b;
        break label499;
        this.j.h = 0;
        this.j.i = 0;
        break label611;
        label925:
        this.j.h = i2;
        this.j.i = i1;
        break label703;
        label946:
        this.j.d = this.j.h;
        this.j.e = this.j.i;
        break label756;
        label977:
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
    label1067:
    return true;
  }
  
  private boolean a(c.c paramc)
  {
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
    return this.h.a(this.i);
  }
  
  private void b()
  {
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
    int i1 = 0;
    boolean bool = false;
    com.tencent.liteav.basic.f.c localc;
    if (this.k != null)
    {
      localc = new com.tencent.liteav.basic.f.c();
      localc.d = paramInt2;
      localc.e = paramInt3;
      if (this.j == null) {
        break label100;
      }
    }
    label100:
    for (paramInt2 = this.j.j;; paramInt2 = 0)
    {
      localc.i = paramInt2;
      if (this.j != null) {
        bool = this.j.g;
      }
      localc.h = bool;
      localc.a = paramInt1;
      i1 = this.k.a(localc);
      return i1;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    try
    {
      a(paramInt2, paramInt3, m(paramInt4), paramInt5, paramInt6);
      this.h.b(this.i);
      paramInt1 = this.h.a(paramInt1, paramInt5);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a(com.tencent.liteav.basic.f.c paramc, int paramInt1, int paramInt2)
  {
    try
    {
      this.m = System.currentTimeMillis();
      a(paramc.j);
      a(paramc.f, paramc.g);
      a(paramc.h);
      a(paramc.i);
      a(paramc.c);
      paramInt1 = a(paramc.a, paramc.d, paramc.e, paramc.i, paramInt1, paramInt2);
      return paramInt1;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    try
    {
      a(paramInt1, paramInt2, m(paramInt3), paramInt4, paramInt5);
      this.h.b(this.i);
      paramInt1 = this.h.a(paramArrayOfByte, paramInt4);
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void a()
  {
    try
    {
      if (this.h != null) {
        this.h.a();
      }
      this.j = null;
      return;
    }
    finally {}
  }
  
  public void a(float paramFloat)
  {
    try
    {
      if (this.h != null) {
        this.h.a(paramFloat);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
    b();
    com.tencent.liteav.basic.f.c localc;
    if (this.k != null)
    {
      localc = new com.tencent.liteav.basic.f.c();
      localc.d = paramInt2;
      localc.e = paramInt3;
      if (this.j == null) {
        break label99;
      }
    }
    label99:
    for (paramInt2 = this.j.j;; paramInt2 = 0)
    {
      localc.i = paramInt2;
      if (this.j != null) {
        bool = this.j.g;
      }
      localc.h = bool;
      localc.a = paramInt1;
      this.k.a(localc, paramLong);
      return;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    try
    {
      if (this.h != null) {
        this.h.a(paramBitmap);
      }
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F) || (paramFloat3 < 0.0D)) {}
    for (;;)
    {
      try
      {
        TXCLog.e("TXCVideoPreprocessor", "WaterMark param is Error!");
        return;
      }
      finally {}
      if (this.h != null) {
        this.h.a(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
      }
    }
  }
  
  /* Error */
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 139	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   6: ifnonnull +14 -> 20
    //   9: ldc 87
    //   11: ldc_w 326
    //   14: invokestatic 153	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 139	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   24: aload_1
    //   25: invokevirtual 328	com/tencent/liteav/beauty/b:a	(Lcom/tencent/liteav/basic/c/a;)V
    //   28: goto -11 -> 17
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	c
    //   0	36	1	parama	com.tencent.liteav.basic.c.a
    // Exception table:
    //   from	to	target	type
    //   2	17	31	finally
    //   20	28	31	finally
  }
  
  public void a(com.tencent.liteav.basic.d.a parama)
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
  
  /* Error */
  public void a(d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 139	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   6: ifnonnull +14 -> 20
    //   9: ldc 87
    //   11: ldc_w 326
    //   14: invokestatic 153	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 139	com/tencent/liteav/beauty/c:h	Lcom/tencent/liteav/beauty/b;
    //   24: aload_1
    //   25: invokevirtual 331	com/tencent/liteav/beauty/b:a	(Lcom/tencent/liteav/beauty/d;)V
    //   28: goto -11 -> 17
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	c
    //   0	36	1	paramd	d
    // Exception table:
    //   from	to	target	type
    //   2	17	31	finally
    //   20	28	31	finally
  }
  
  public void a(e parame)
  {
    for (;;)
    {
      try
      {
        if (this.h == null)
        {
          TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
          return;
        }
        this.k = parame;
        if (parame == null) {
          this.h.a(null);
        } else {
          this.h.a(this);
        }
      }
      finally {}
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.h != null) {
        this.h.a(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean)
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
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (this.k != null) {
      this.k.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    }
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if (this.h != null) {
      this.h.a(paramArrayOfFloat);
    }
  }
  
  @TargetApi(18)
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 18) {
      return false;
    }
    if (this.h != null) {
      this.h.a(paramString, paramBoolean);
    }
    return true;
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (this.h != null) {
        this.h.c(paramInt);
      }
      this.p.a("beautyStyle", paramInt);
      return;
    }
    finally {}
  }
  
  public void c(int paramInt)
  {
    if (paramInt > 9) {}
    for (;;)
    {
      try
      {
        TXCLog.e("TXCVideoPreprocessor", "Beauty value too large! set max value 9");
        i1 = 9;
        if (this.h != null) {
          this.h.b(i1);
        }
        this.p.a("beautyLevel", i1);
        return;
      }
      finally {}
      int i1 = paramInt;
      if (paramInt < 0)
      {
        TXCLog.e("TXCVideoPreprocessor", "Beauty < 0; set 0");
        i1 = 0;
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (paramInt > 9) {}
    for (;;)
    {
      try
      {
        TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
        i1 = 9;
        if (this.h != null) {
          this.h.d(i1);
        }
        this.p.a("whiteLevel", i1);
        return;
      }
      finally {}
      int i1 = paramInt;
      if (paramInt < 0)
      {
        TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
        i1 = 0;
      }
    }
  }
  
  public void e(int paramInt)
  {
    if (paramInt > 9) {}
    for (;;)
    {
      try
      {
        TXCLog.e("TXCVideoPreprocessor", "Ruddy value too large! set max value 9");
        i1 = 9;
        if (this.h != null) {
          this.h.f(i1);
        }
        this.p.a("ruddyLevel", i1);
        return;
      }
      finally {}
      int i1 = paramInt;
      if (paramInt < 0)
      {
        TXCLog.e("TXCVideoPreprocessor", "Ruddy < 0; set 0");
        i1 = 0;
      }
    }
  }
  
  public void f(int paramInt)
  {
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
      if (this.h != null) {
        this.h.g(paramInt);
      }
      this.p.a("eyeBigScale", paramInt);
      return;
    }
    finally {}
  }
  
  public void h(int paramInt)
  {
    try
    {
      if (this.h != null) {
        this.h.h(paramInt);
      }
      this.p.a("faceSlimLevel", paramInt);
      return;
    }
    finally {}
  }
  
  public void i(int paramInt)
  {
    if (this.h != null) {
      this.h.i(paramInt);
    }
    this.p.a("faceVLevel", paramInt);
  }
  
  public void j(int paramInt)
  {
    if (this.h != null) {
      this.h.j(paramInt);
    }
    this.p.a("faceShortLevel", paramInt);
  }
  
  public void k(int paramInt)
  {
    if (this.h != null) {
      this.h.k(paramInt);
    }
    this.p.a("chinLevel", paramInt);
  }
  
  public void l(int paramInt)
  {
    if (this.h != null) {
      this.h.l(paramInt);
    }
    this.p.a("noseSlimLevel", paramInt);
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    setStatusValue(3001, this.p.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.beauty.c
 * JD-Core Version:    0.7.0.1
 */