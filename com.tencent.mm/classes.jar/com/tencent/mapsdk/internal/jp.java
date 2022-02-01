package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicInteger;

public class jp
  extends jh
{
  public static final int a = 10;
  private static final kt.a g;
  private static final kt.g<kt.i<Bitmap>> h;
  protected final AtomicInteger b;
  protected Bitmap c;
  protected byte[] d;
  public int e;
  public String f;
  
  static
  {
    AppMethodBeat.i(224278);
    kt.a locala = new kt.a(Bitmap.Config.ARGB_8888);
    g = locala;
    h = kt.a(locala);
    AppMethodBeat.o(224278);
  }
  
  public jp()
  {
    AppMethodBeat.i(224210);
    this.b = new AtomicInteger();
    AppMethodBeat.o(224210);
  }
  
  public jp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(224220);
    this.b = new AtomicInteger();
    this.c = paramBitmap;
    i();
    h();
    AppMethodBeat.o(224220);
  }
  
  public jp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224229);
    this.b = new AtomicInteger();
    this.d = paramArrayOfByte;
    if (paramArrayOfByte != null) {
      a(paramArrayOfByte);
    }
    AppMethodBeat.o(224229);
  }
  
  public static void a(kt.a parama)
  {
    kt.a locala = g;
    if (parama != null)
    {
      locala.a = parama.a;
      locala.b = parama.b;
      locala.c = parama.c;
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(224250);
    if ((this.c == null) && (this.d != null)) {
      this.e = this.d.length;
    }
    if ((this.c != null) && (!this.c.isRecycled()))
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.e = this.c.getAllocationByteCount();
        AppMethodBeat.o(224250);
        return;
      }
      this.e = this.c.getByteCount();
    }
    AppMethodBeat.o(224250);
  }
  
  private void i()
  {
    AppMethodBeat.i(224260);
    if ((this.c != null) && (!this.c.isRecycled())) {
      this.f = gv.a(this.c);
    }
    AppMethodBeat.o(224260);
  }
  
  private String j()
  {
    return this.f;
  }
  
  public final int a()
  {
    return this.e;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224345);
    f();
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    int k;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      this.d = paramArrayOfByte;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
      if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
      {
        AppMethodBeat.o(224345);
        return;
      }
      g.a = localOptions.outWidth;
      g.b = localOptions.outHeight;
      i = 0;
      j = 0;
      localObject1 = null;
      if ((j == 0) && (i < 20))
      {
        localObject2 = (kt.i)h.a();
        if (localObject2 == null) {
          break label274;
        }
        localObject2 = (Bitmap)((kt.i)localObject2).a;
        localObject1 = localObject2;
        k = j;
        if (!((Bitmap)localObject2).isRecycled())
        {
          localObject1 = localObject2;
          k = j;
          if (((Bitmap)localObject2).getWidth() == localOptions.outWidth)
          {
            localObject1 = localObject2;
            k = j;
            if (((Bitmap)localObject2).getHeight() == localOptions.outHeight)
            {
              k = 1;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      localObject2 = new BitmapFactory.Options();
      if (j != 0) {
        ((BitmapFactory.Options)localObject2).inBitmap = localObject1;
      }
      ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      ((BitmapFactory.Options)localObject2).inMutable = true;
      this.c = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject2);
      this.d = null;
      i();
      h();
      AppMethodBeat.o(224345);
      return;
      label274:
      k = j;
    }
  }
  
  public final byte[] b()
  {
    AppMethodBeat.i(224328);
    byte[] arrayOfByte;
    if (this.d != null)
    {
      arrayOfByte = this.d;
      AppMethodBeat.o(224328);
      return arrayOfByte;
    }
    if ((this.c != null) && (!this.c.isRecycled())) {}
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      kb.a(localByteArrayOutputStream);
    }
    finally
    {
      try
      {
        if (this.c.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream))
        {
          arrayOfByte = localByteArrayOutputStream.toByteArray();
          kb.a(localByteArrayOutputStream);
          AppMethodBeat.o(224328);
          return arrayOfByte;
        }
        kb.a(localByteArrayOutputStream);
        AppMethodBeat.o(224328);
        return new byte[0];
      }
      finally {}
      localObject1 = finally;
      localByteArrayOutputStream = null;
    }
    AppMethodBeat.o(224328);
    throw localObject1;
  }
  
  /* Error */
  public final Bitmap c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 187
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 67	com/tencent/mapsdk/internal/jp:c	Landroid/graphics/Bitmap;
    //   11: ifnonnull +11 -> 22
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 75	com/tencent/mapsdk/internal/jp:d	[B
    //   19: invokevirtual 77	com/tencent/mapsdk/internal/jp:a	([B)V
    //   22: aload_0
    //   23: getfield 67	com/tencent/mapsdk/internal/jp:c	Landroid/graphics/Bitmap;
    //   26: ifnull +24 -> 50
    //   29: aload_0
    //   30: getfield 67	com/tencent/mapsdk/internal/jp:c	Landroid/graphics/Bitmap;
    //   33: invokevirtual 93	android/graphics/Bitmap:isRecycled	()Z
    //   36: ifeq +14 -> 50
    //   39: aconst_null
    //   40: astore_1
    //   41: ldc 187
    //   43: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: areturn
    //   50: aload_0
    //   51: getfield 67	com/tencent/mapsdk/internal/jp:c	Landroid/graphics/Bitmap;
    //   54: astore_1
    //   55: ldc 187
    //   57: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -14 -> 46
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	jp
    //   40	15	1	localBitmap	Bitmap
    //   63	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	63	finally
    //   22	39	63	finally
    //   41	46	63	finally
    //   50	60	63	finally
  }
  
  public final void d()
  {
    AppMethodBeat.i(224302);
    if ((this.c != null) && (!this.c.isRecycled()))
    {
      int i = this.b.decrementAndGet();
      kl.f("BD").a(new Object[] { "decrement refCount:" + i + " id = " + this.f });
    }
    AppMethodBeat.o(224302);
  }
  
  public final void e()
  {
    AppMethodBeat.i(224309);
    if ((this.c != null) && (!this.c.isRecycled()))
    {
      int i = this.b.incrementAndGet();
      kl.f("BD").a(new Object[] { "increment refCount:" + i + " id = " + this.f });
    }
    AppMethodBeat.o(224309);
  }
  
  public boolean f()
  {
    AppMethodBeat.i(224356);
    if ((this.c != null) && (!this.c.isRecycled()) && (this.b.decrementAndGet() <= 0))
    {
      this.c.recycle();
      kl.f("BD").a(new Object[] { "recycle out" });
    }
    this.d = null;
    if ((this.c == null) || (this.c.isRecycled()))
    {
      AppMethodBeat.o(224356);
      return true;
    }
    AppMethodBeat.o(224356);
    return false;
  }
  
  public final boolean g()
  {
    AppMethodBeat.i(224367);
    if (this.c != null)
    {
      boolean bool = this.c.isRecycled();
      AppMethodBeat.o(224367);
      return bool;
    }
    if ((this.d == null) || (this.d.length == 0))
    {
      AppMethodBeat.o(224367);
      return true;
    }
    AppMethodBeat.o(224367);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(224381);
    String str = "BitmapData{id='" + this.f + '\'' + '}';
    AppMethodBeat.o(224381);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jp
 * JD-Core Version:    0.7.0.1
 */