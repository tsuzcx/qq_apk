package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.engine.jni.models.IconImageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class w
{
  private static final int f = -16711681;
  private static final int g = 16711680;
  private static final int h = -256;
  private static final int i = 255;
  public bd a;
  public nt b;
  public float c;
  public Lock d;
  public Lock e;
  private WeakReference<Context> j;
  private np k;
  private gq l;
  
  public w(Context paramContext, bd parambd, nt paramnt, np paramnp)
  {
    AppMethodBeat.i(223216);
    this.c = 1.0F;
    this.d = new ReentrantLock();
    this.e = new ReentrantLock();
    this.j = new WeakReference(paramContext);
    this.a = parambd;
    this.b = paramnt;
    this.k = paramnp;
    this.c = ha.a(paramContext);
    if (parambd.b() != null) {
      this.l = ((sj)parambd.b()).aB.d;
    }
    AppMethodBeat.o(223216);
  }
  
  private static int a(int paramInt)
  {
    return (0xFF0000 & paramInt) >> 16 | (paramInt & 0xFF) << 16 | 0xFF00FFFF & paramInt & 0xFFFFFF00;
  }
  
  public static boolean a(File paramFile, String paramString, byte[] paramArrayOfByte, Lock paramLock)
  {
    AppMethodBeat.i(223279);
    if ((gz.a(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(223279);
      return false;
    }
    Object localObject = paramString + "_" + Arrays.hashCode(paramArrayOfByte);
    try
    {
      if (!paramFile.exists()) {
        paramFile.mkdirs();
      }
      localObject = new File(paramFile, (String)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      ((File)localObject).createNewFile();
      ka.a((File)localObject, paramArrayOfByte);
      paramArrayOfByte = Util.getMD5String(paramArrayOfByte);
      try
      {
        boolean bool = paramArrayOfByte.equals(kq.a((File)localObject));
        if (!bool)
        {
          AppMethodBeat.o(223279);
          return false;
        }
      }
      catch (FileNotFoundException paramArrayOfByte)
      {
        paramArrayOfByte = new File(paramFile, paramString);
        paramFile = new File(paramFile, paramString + ".bak");
        if ((paramFile.exists()) && (!paramFile.delete()))
        {
          paramFile.deleteOnExit();
          AppMethodBeat.o(223279);
          return false;
        }
        try
        {
          paramLock.lock();
          if ((paramArrayOfByte.exists()) && (!paramArrayOfByte.renameTo(paramFile)))
          {
            if (!((File)localObject).delete()) {
              ((File)localObject).deleteOnExit();
            }
            return false;
          }
          if (!((File)localObject).renameTo(paramArrayOfByte))
          {
            paramFile.renameTo(paramArrayOfByte);
            if (!((File)localObject).delete()) {
              ((File)localObject).deleteOnExit();
            }
            return false;
          }
          if (!paramFile.delete()) {
            paramFile.deleteOnExit();
          }
          return true;
        }
        finally
        {
          paramLock.unlock();
          AppMethodBeat.o(223279);
        }
      }
      return false;
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(223279);
    }
  }
  
  private boolean a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(223248);
    if (this.b == null)
    {
      AppMethodBeat.o(223248);
      return false;
    }
    boolean bool = a(new File(this.b.c()), paramString, paramArrayOfByte, this.d);
    AppMethodBeat.o(223248);
    return bool;
  }
  
  private IconImageInfo b(String paramString)
  {
    AppMethodBeat.i(223235);
    IconImageInfo localIconImageInfo = new IconImageInfo();
    localIconImageInfo.scale = this.c;
    localIconImageInfo.anchorPointX1 = 0.5F;
    localIconImageInfo.anchorPointY1 = 0.5F;
    localIconImageInfo.bitmap = a(paramString, Bitmap.Config.RGB_565);
    AppMethodBeat.o(223235);
    return localIconImageInfo;
  }
  
  private boolean b(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(223262);
    if (this.b == null)
    {
      AppMethodBeat.o(223262);
      return false;
    }
    boolean bool = a(new File(this.b.e()), paramString, paramArrayOfByte, this.e);
    AppMethodBeat.o(223262);
    return bool;
  }
  
  private static Bitmap c(String paramString)
  {
    AppMethodBeat.i(223289);
    paramString = paramString.substring(14);
    if (gz.a(paramString))
    {
      AppMethodBeat.o(223289);
      return null;
    }
    paramString = paramString.split(", ");
    if ((paramString == null) || (paramString.length < 5))
    {
      AppMethodBeat.o(223289);
      return null;
    }
    int m = Integer.parseInt(paramString[0]);
    int n = Integer.parseInt(paramString[1]);
    long l1 = Long.parseLong(paramString[2]);
    long l2 = Long.parseLong(paramString[3]);
    float f1 = Float.parseFloat(paramString[4]);
    if ((m < 0) || (n < 0))
    {
      AppMethodBeat.o(223289);
      return null;
    }
    paramString = new Paint();
    paramString.setAntiAlias(true);
    paramString.setStrokeWidth(f1);
    paramString.setStyle(Paint.Style.STROKE);
    paramString.setColor(a((int)l2));
    Bitmap localBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(a((int)l1));
    RectF localRectF = new RectF();
    localRectF.left = 0.0F;
    localRectF.top = 0.0F;
    localRectF.right = m;
    localRectF.bottom = n;
    localCanvas.drawRoundRect(localRectF, m >> 3, n >> 3, paramString);
    AppMethodBeat.o(223289);
    return localBitmap;
  }
  
  private bd d()
  {
    return this.a;
  }
  
  public final Bitmap a(String paramString, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(223355);
    if ((!new File(paramString).exists()) || (this.j == null) || (this.j.get() == null))
    {
      AppMethodBeat.o(223355);
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = paramConfig;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      AppMethodBeat.o(223355);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      AppMethodBeat.o(223355);
    }
    return null;
  }
  
  public final IconImageInfo a(String paramString)
  {
    Paint localPaint = null;
    AppMethodBeat.i(223314);
    if (this.k == null)
    {
      AppMethodBeat.o(223314);
      return null;
    }
    localIconImageInfo = new IconImageInfo();
    localIconImageInfo.anchorPointX1 = 0.5F;
    localIconImageInfo.anchorPointY1 = 0.5F;
    if (paramString.startsWith("drawRoundRect"))
    {
      localIconImageInfo.scale = 1.0F;
      Object localObject1 = paramString.substring(14);
      if (gz.a((String)localObject1)) {
        localObject1 = localPaint;
      }
      for (;;)
      {
        localIconImageInfo.bitmap = ((Bitmap)localObject1);
        if ((localIconImageInfo.bitmap == null) && (this.l != null)) {
          this.l.a().a(System.currentTimeMillis(), paramString);
        }
        AppMethodBeat.o(223314);
        return localIconImageInfo;
        Object localObject3 = ((String)localObject1).split(", ");
        localObject1 = localPaint;
        if (localObject3 != null)
        {
          localObject1 = localPaint;
          if (localObject3.length >= 5)
          {
            int m = Integer.parseInt(localObject3[0]);
            int n = Integer.parseInt(localObject3[1]);
            long l1 = Long.parseLong(localObject3[2]);
            long l2 = Long.parseLong(localObject3[3]);
            float f1 = Float.parseFloat(localObject3[4]);
            localObject1 = localPaint;
            if (m >= 0)
            {
              localObject1 = localPaint;
              if (n >= 0)
              {
                localPaint = new Paint();
                localPaint.setAntiAlias(true);
                localPaint.setStrokeWidth(f1);
                localPaint.setStyle(Paint.Style.STROKE);
                localPaint.setColor(a((int)l2));
                localObject1 = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
                localObject3 = new Canvas((Bitmap)localObject1);
                ((Canvas)localObject3).drawColor(a((int)l1));
                RectF localRectF = new RectF();
                localRectF.left = 0.0F;
                localRectF.top = 0.0F;
                localRectF.right = m;
                localRectF.bottom = n;
                ((Canvas)localObject3).drawRoundRect(localRectF, m >> 3, n >> 3, localPaint);
              }
            }
          }
        }
      }
    }
    try
    {
      this.e.lock();
      this.k.a(paramString, localIconImageInfo);
      return null;
    }
    finally
    {
      try
      {
        this.e.unlock();
        if (localIconImageInfo.bitmap == null) {
          paramString.equals("compass.png");
        }
        if ((localIconImageInfo.bitmap == null) && (this.l != null)) {
          this.l.a().a(System.currentTimeMillis(), paramString);
        }
        AppMethodBeat.o(223314);
        return localIconImageInfo;
      }
      catch (Exception localException)
      {
        if ((localIconImageInfo.bitmap != null) || (this.l == null)) {
          break label482;
        }
        this.l.a().a(System.currentTimeMillis(), paramString);
        AppMethodBeat.o(223314);
      }
      localObject2 = finally;
      this.e.unlock();
      AppMethodBeat.o(223314);
    }
  }
  
  public final void a()
  {
    AppMethodBeat.i(223324);
    this.d.lock();
    AppMethodBeat.o(223324);
  }
  
  public final void b()
  {
    AppMethodBeat.i(223332);
    this.d.unlock();
    AppMethodBeat.o(223332);
  }
  
  public final void c()
  {
    AppMethodBeat.i(223341);
    sc localsc = this.a.f();
    localsc.a(new sc.97(localsc, ""));
    AppMethodBeat.o(223341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.w
 * JD-Core Version:    0.7.0.1
 */