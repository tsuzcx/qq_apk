package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

public final class a
  implements IMBImageHandler
{
  private List<a.d> bKT;
  private a.d bKU;
  private boolean bKV;
  private ConcurrentLinkedQueue<String> bKW;
  public a.a bKX;
  private MBRuntime mbRuntime;
  
  public a(MBRuntime paramMBRuntime, com.tencent.magicbrush.handler.a parama)
  {
    AppMethodBeat.i(115971);
    this.bKV = false;
    this.bKW = null;
    this.bKX = null;
    if (parama == null)
    {
      paramMBRuntime = new IllegalArgumentException("DefaultImageHandlerImpl accept null parameter");
      AppMethodBeat.o(115971);
      throw paramMBRuntime;
    }
    this.mbRuntime = paramMBRuntime;
    this.bKT = new LinkedList();
    a(new a.c(this), false);
    a(new a.b(this), false);
    AppMethodBeat.o(115971);
  }
  
  private static int aa(float paramFloat)
  {
    float f;
    if (paramFloat >= 0.0F)
    {
      f = paramFloat;
      if (paramFloat <= 1.0F) {}
    }
    else
    {
      f = 0.92F;
    }
    return (int)(100.0F * f);
  }
  
  private static Bitmap.CompressFormat fL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Bitmap.CompressFormat.PNG;
    case 1: 
      return Bitmap.CompressFormat.WEBP;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  public final void a(a.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(115979);
    if (!paramBoolean)
    {
      this.bKT.add(paramd);
      AppMethodBeat.o(115979);
      return;
    }
    this.bKU = paramd;
    AppMethodBeat.o(115979);
  }
  
  public final String encodeToBase64(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(115974);
    if ((paramBitmap == null) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(115974);
      return null;
    }
    Bitmap.CompressFormat localCompressFormat = fL(paramInt);
    paramInt = aa(paramFloat);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = paramBitmap.compress(localCompressFormat, paramInt, localByteArrayOutputStream);
    try
    {
      localByteArrayOutputStream.close();
      if ((!bool) || (localByteArrayOutputStream.size() <= 0))
      {
        c.c.e("MagicBrush.DefaultImageHandlerImpl", "base64_encode Bitmap compress error.", new Object[0]);
        AppMethodBeat.o(115974);
        return null;
      }
    }
    catch (IOException paramBitmap)
    {
      for (;;)
      {
        c.c.e("MagicBrush.DefaultImageHandlerImpl", "base64_encode IOException e %s", new Object[] { paramBitmap.toString() });
        bool = false;
      }
      paramBitmap = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2);
      AppMethodBeat.o(115974);
    }
    return paramBitmap;
  }
  
  public final byte[] encodeToBuffer(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(115975);
    if ((paramBitmap == null) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(115975);
      return null;
    }
    Bitmap.CompressFormat localCompressFormat = fL(paramInt);
    paramInt = aa(paramFloat);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = paramBitmap.compress(localCompressFormat, paramInt, localByteArrayOutputStream);
    try
    {
      localByteArrayOutputStream.close();
      if ((!bool) || (localByteArrayOutputStream.size() <= 0))
      {
        c.c.e("MagicBrush.DefaultImageHandlerImpl", "encodeToBuffer Bitmap compress error.", new Object[0]);
        AppMethodBeat.o(115975);
        return null;
      }
    }
    catch (IOException paramBitmap)
    {
      for (;;)
      {
        c.c.e("MagicBrush.DefaultImageHandlerImpl", "encodeToBuffer IOException e %s", new Object[] { paramBitmap.toString() });
        bool = false;
      }
      paramBitmap = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(115975);
    }
    return paramBitmap;
  }
  
  public final Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115973);
    Bitmap localBitmap = com.tencent.magicbrush.b.a.yw().bLj.bP(paramInt1, paramInt2);
    AppMethodBeat.o(115973);
    return localBitmap;
  }
  
  public final void init() {}
  
  public final void loadBitmapAsync(String paramString)
  {
    AppMethodBeat.i(115978);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115978);
      return;
    }
    paramString = new a.e(this.mbRuntime, this, paramString);
    b.bLe.bLg.execute(paramString);
    AppMethodBeat.o(115978);
  }
  
  public final IBitmap loadBitmapSync(String paramString)
  {
    AppMethodBeat.i(115977);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115977);
      return null;
    }
    Object localObject1 = this.bKT.iterator();
    a.d locald;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      locald = (a.d)((Iterator)localObject1).next();
    } while (!locald.bL(paramString));
    for (;;)
    {
      if (locald == null) {
        locald = this.bKU;
      }
      for (;;)
      {
        if (locald == null)
        {
          c.c.e("MagicBrush.DefaultImageHandlerImpl", "No fit decoder found for %s", new Object[] { paramString });
          AppMethodBeat.o(115977);
          return null;
        }
        for (;;)
        {
          try {}catch (Exception localException)
          {
            a.a locala;
            c.c.e("MagicBrush.DefaultImageHandlerImpl", "ImageDecoder(%s) decode path[%s] error %s", new Object[] { locald, paramString, localException.toString() });
            paramString = null;
            continue;
            IBitmap localIBitmap = locala.a(paramString, localException);
            paramString = localIBitmap;
            continue;
          }
          try
          {
            if (this.bKV)
            {
              if (this.bKW == null) {
                this.bKW = new ConcurrentLinkedQueue();
              }
              this.bKW.add(paramString);
            }
            localObject1 = locald.bM(paramString);
            locala = ((a)locald.bKY).bKX;
            if (locala == null)
            {
              paramString = null;
              AppMethodBeat.o(115977);
              return paramString;
            }
          }
          finally
          {
            AppMethodBeat.o(115977);
          }
        }
      }
      locald = null;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(115972);
    try
    {
      if (this.bKX != null)
      {
        this.bKX.destroy();
        this.bKX = null;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(115972);
    }
  }
  
  public final void releaseBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(115976);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(115976);
      return;
    }
    c.c.i("MagicBrush.DefaultImageHandlerImpl", "recycle because releaseBitmap", new Object[0]);
    paramBitmap.recycle();
    AppMethodBeat.o(115976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.a
 * JD-Core Version:    0.7.0.1
 */