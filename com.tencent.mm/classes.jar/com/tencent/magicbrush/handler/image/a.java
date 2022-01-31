package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.magicbrush.a.d.f;
import com.tencent.magicbrush.a.e.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a
  implements b
{
  com.tencent.magicbrush.handler.a blW;
  private com.tencent.magicbrush.handler.b blX;
  private List<a.a> blY;
  private a.a blZ;
  private int bma = Runtime.getRuntime().availableProcessors() + 1;
  private ExecutorService bmb = null;
  public e.b bmc;
  private boolean bmd = false;
  private ConcurrentLinkedQueue<String> bme = null;
  
  public a(com.tencent.magicbrush.handler.a parama, com.tencent.magicbrush.handler.b paramb)
  {
    if ((parama == null) || (paramb == null)) {
      throw new IllegalArgumentException("DefaultImageHandlerImpl accept null parameter");
    }
    this.blW = parama;
    this.blX = paramb;
    this.blY = new LinkedList();
  }
  
  public final void a(a.a parama, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.blY.add(parama);
      return;
    }
    this.blZ = parama;
  }
  
  public Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    return com.tencent.magicbrush.b.a.qN().bml.aS(paramInt1, paramInt2);
  }
  
  public final void init()
  {
    int i = Math.max(this.bma, 5);
    this.bmb = Executors.newFixedThreadPool(i);
    if (this.bmc != null) {
      this.bmc.c(new Object[] { Integer.valueOf(i) });
    }
  }
  
  public final void loadBitmapAsync(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = new a.b(paramString, null, (byte)0);
      this.blW.g(paramString);
      return;
    }
    paramString = new a.c(this, paramString, (byte)0);
    this.bmb.execute(paramString);
  }
  
  public final IBitmap<NativeBitmapStruct> loadBitmapSync(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject1 = this.blY.iterator();
    a.a locala;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      locala = (a.a)((Iterator)localObject1).next();
    } while (!locala.bs(paramString));
    for (;;)
    {
      if (locala == null) {
        locala = this.blZ;
      }
      for (;;)
      {
        if (locala == null)
        {
          d.f.e("DefaultImageHandlerImpl", "No fit decoder found for %s", new Object[] { paramString });
          return null;
        }
        for (;;)
        {
          try {}catch (Exception localException)
          {
            d.f.e("DefaultImageHandlerImpl", "ImageDecoder(%s) decode path[%s] error %s", new Object[] { locala, paramString, localException.toString() });
            paramString = null;
            continue;
          }
          try
          {
            if (this.bmd)
            {
              if (this.bme == null) {
                this.bme = new ConcurrentLinkedQueue();
              }
              this.bme.add(paramString);
            }
            localObject1 = locala.bt(paramString);
            localObject1 = com.tencent.magicbrush.a.a.qE().a(paramString, (InputStream)localObject1);
            paramString = (String)localObject1;
            return paramString;
          }
          finally {}
        }
      }
      locala = null;
    }
  }
  
  public final void release()
  {
    try
    {
      Object localObject1 = this.bmb.shutdownNow();
      if (!((List)localObject1).isEmpty())
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Runnable localRunnable = (Runnable)((Iterator)localObject1).next();
          if ((localRunnable != null) && ((localRunnable instanceof a.c))) {
            a.c.a((a.c)localRunnable);
          }
        }
      }
    }
    finally {}
  }
  
  public void releaseBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    paramBitmap.recycle();
  }
  
  public final String toDataURL(Bitmap paramBitmap, String paramString, float paramFloat)
  {
    d.f.i("DefaultImageHandlerImpl", "toDataURL() called with: bitmap = [" + paramBitmap + "], type = [" + paramString + "], encoderOptions = [" + paramFloat + "]", new Object[0]);
    if ((paramBitmap == null) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0)) {
      return "data:,";
    }
    if ("image/webp".equals(paramString)) {
      paramString = Bitmap.CompressFormat.WEBP;
    }
    ByteArrayOutputStream localByteArrayOutputStream;
    for (;;)
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
      int i = (int)(100.0F * f);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      boolean bool = paramBitmap.compress(paramString, i, localByteArrayOutputStream);
      try
      {
        localByteArrayOutputStream.close();
        if ((!bool) || (localByteArrayOutputStream.size() <= 0))
        {
          d.f.e("DefaultImageHandlerImpl", "dataurl_encode Bitmap compress error.", new Object[0]);
          return "data:,";
          if (("image/jpeg".equals(paramString)) || ("image/jpg".equals(paramString)))
          {
            paramString = Bitmap.CompressFormat.JPEG;
            continue;
          }
          paramString = Bitmap.CompressFormat.PNG;
        }
      }
      catch (IOException paramBitmap)
      {
        for (;;)
        {
          d.f.e("DefaultImageHandlerImpl", "dataurl_encode IOException e %s", new Object[] { paramBitmap.toString() });
          bool = false;
        }
        paramBitmap = new StringBuilder();
        paramBitmap.append("data:image/");
        if (paramString != Bitmap.CompressFormat.PNG) {
          break label285;
        }
      }
    }
    paramBitmap.append("png");
    for (;;)
    {
      paramBitmap.append(";base64,");
      paramBitmap.append(Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
      return paramBitmap.toString();
      label285:
      if (paramString == Bitmap.CompressFormat.JPEG) {
        paramBitmap.append("jpeg");
      } else {
        paramBitmap.append("webp");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.a
 * JD-Core Version:    0.7.0.1
 */