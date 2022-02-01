package com.github.henryye.nativeiv;

import android.text.TextUtils;
import android.util.SparseArray;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.b.b.a;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class a
  implements IImageDecodeService.a
{
  private int EK;
  private b aJN;
  private BitmapType aJO;
  private IImageDecodeService.b aJP;
  private volatile boolean aJQ;
  private int uJ;
  
  public a()
  {
    AppMethodBeat.i(219641);
    this.uJ = 2048;
    this.EK = 2048;
    this.aJN = new b();
    this.aJQ = false;
    b localb = this.aJN;
    BitmapType localBitmapType = BitmapType.Native;
    com.github.henryye.nativeiv.comm.a locala = new com.github.henryye.nativeiv.comm.a();
    localb.aJR.put(localBitmapType, locala);
    AppMethodBeat.o(219641);
  }
  
  public final IBitmap a(String paramString, Object paramObject, com.github.henryye.nativeiv.b.b paramb, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(219668);
    com.github.henryye.nativeiv.api.a locala = new com.github.henryye.nativeiv.api.a();
    int i = this.uJ;
    locala.EK = this.EK;
    locala.uJ = i;
    locala.mPath = paramString;
    locala.aKm = paramb.qG();
    for (;;)
    {
      InputStream localInputStream;
      c localc;
      com.github.henryye.nativeiv.bitmap.c localc1;
      int j;
      try
      {
        localObject1 = paramb.a(paramObject, paramImageDecodeConfig);
        if ((((b.a)localObject1).aFw == null) || (!TextUtils.isEmpty(((b.a)localObject1).errorMsg)))
        {
          locala.aKn = ((b.a)localObject1).errorMsg;
          this.aJP.a(paramString, IImageDecodeService.b.a.aKp, locala);
          AppMethodBeat.o(219668);
          return null;
        }
        localInputStream = ((b.a)localObject1).aFw;
        localc = a(this.aJN, locala);
        localc.aJO = this.aJO;
        localc.aJW = this.aJP;
        locald = localc.f(localInputStream);
        if (locald == null)
        {
          this.aJP.a(paramString, IImageDecodeService.b.a.aKq, locala);
          AppMethodBeat.o(219668);
          return null;
        }
        if (locald.aKM == com.github.henryye.nativeiv.bitmap.c.aKK)
        {
          this.aJP.a(paramString, IImageDecodeService.b.a.aKs, locala);
          AppMethodBeat.o(219668);
          return null;
        }
        localc1 = locald.aKM;
        if (localInputStream != null)
        {
          if (localc.aJO == null) {
            continue;
          }
          localObject1 = localc.aJY;
          i = localc.hashCode();
          localObject3 = localc.aJO;
          localObject4 = (Map)((b)localObject1).aJS.get(i);
          if ((localObject4 == null) || (((Map)localObject4).get(localObject3) == null)) {
            continue;
          }
          localObject1 = ((com.github.henryye.nativeiv.bitmap.b)((Map)localObject4).get(localObject3)).qD();
          localc.aJV = ((IBitmap)localObject1);
          j = 0;
        }
      }
      catch (Exception paramImageDecodeConfig)
      {
        Object localObject1;
        d locald;
        Object localObject3;
        Object localObject4;
        this.aJP.a(paramString, IImageDecodeService.b.a.aKz, locala);
        com.github.henryye.nativeiv.a.b.e("DefaultBitmapDecoder", "ImageDecoder(%s) decode path[%s] error %s", new Object[] { paramb, paramObject.toString(), paramImageDecodeConfig.toString() });
        AppMethodBeat.o(219668);
        return null;
      }
      try
      {
        localc.aJV.decodeInputStream(localInputStream, paramImageDecodeConfig, localc1);
        localObject1 = localc.aJV.provide();
        if (localObject1 == null) {
          break label597;
        }
        i = 1;
      }
      catch (IOException localIOException1)
      {
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", localIOException1, "hy: decodeInputStream", new Object[0]);
        localc.aJW.a(paramString, IImageDecodeService.b.a.aKu, localc.aJX);
        localc.aJV.recycle();
        j = 1;
        i = 0;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", localOutOfMemoryError, "hy: decodeInputStream", new Object[0]);
        localc.aJW.a(paramString, IImageDecodeService.b.a.aKv, localc.aJX);
        localc.aJV.recycle();
        j = 1;
        i = 0;
        continue;
      }
      catch (Throwable localThrowable)
      {
        label597:
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", localThrowable, "hy: decode image exception", new Object[0]);
        localc.aJW.a(paramString, IImageDecodeService.b.a.aKy, localc.aJX);
        localc.aJV.recycle();
        i = 0;
        continue;
      }
      if (j != 0)
      {
        com.github.henryye.nativeiv.c.b.b(localInputStream);
        if ((locald.width <= this.uJ) && (locald.height <= this.EK)) {
          break label1102;
        }
        this.aJP.a(paramString, IImageDecodeService.b.a.aKt, locala);
        localc.aJV.recycle();
        AppMethodBeat.o(219668);
        return null;
        if (((b)localObject1).aJR.get(localObject3) == null) {
          break label1128;
        }
        localObject1 = ((com.github.henryye.nativeiv.bitmap.b)((b)localObject1).aJR.get(localObject3)).qD();
        continue;
        localObject4 = localc.aJY;
        i = localc.hashCode();
        localObject1 = (Map)((b)localObject4).aJS.get(i);
        if (localObject1 == null) {
          break label1122;
        }
        localObject1 = b.a(localc1, (Map)localObject1);
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = b.a(localc1, ((b)localObject4).aJR);
        }
        localc.aJV = ((IBitmap)localObject3);
        continue;
        i = 0;
        continue;
      }
      try
      {
        j = localInputStream.available();
        long l = j;
        if ((i == 0) && (localc.aJV.getType() == BitmapType.Native))
        {
          com.github.henryye.nativeiv.a.b.i("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
          localc.aJV = ((com.github.henryye.nativeiv.bitmap.b)localc.aJY.aJR.get(BitmapType.Legacy)).qD();
        }
        try
        {
          localc.aJV.decodeInputStream(localInputStream, paramImageDecodeConfig, localc1);
          localc.aJX.aKk = l;
          localc.aJX.aKl = localc.aJV.getDecodeTime();
          localc.aJW.a(paramString, IImageDecodeService.b.a.aKo, localc.aJX);
          if (localc.aJV.getType() == BitmapType.Legacy) {
            localc.aJW.a(paramString, IImageDecodeService.b.a.aKw, localc.aJX);
          }
          if (localc.aJV.provide() == null)
          {
            localc.aJV.recycle();
            localc.aJV = null;
          }
          com.github.henryye.nativeiv.c.b.b(localInputStream);
          continue;
          label969:
          com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", localThrowable, "hy: get stream len failed!", new Object[0]);
          l = 0L;
        }
        catch (IOException paramImageDecodeConfig)
        {
          for (;;)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramImageDecodeConfig, "hy: IOException when use legacy", new Object[0]);
            localc.aJW.a(paramString, IImageDecodeService.b.a.aKu, localc.aJX);
          }
        }
        catch (OutOfMemoryError paramImageDecodeConfig)
        {
          for (;;)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramImageDecodeConfig, "hy: decodeInputStream", new Object[0]);
            localc.aJW.a(paramString, IImageDecodeService.b.a.aKv, localc.aJX);
          }
        }
        catch (Throwable paramImageDecodeConfig)
        {
          for (;;)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramImageDecodeConfig, "hy: decode image exception", new Object[0]);
            localc.aJW.a(paramString, IImageDecodeService.b.a.aKy, localc.aJX);
          }
        }
        label1102:
        paramImageDecodeConfig = localc.aJV;
        AppMethodBeat.o(219668);
        return paramImageDecodeConfig;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        break label969;
        Object localObject2 = null;
        continue;
        localObject2 = null;
      }
      catch (IOException localIOException2)
      {
        label1122:
        label1128:
        break label969;
      }
    }
  }
  
  protected c a(b paramb, com.github.henryye.nativeiv.api.a parama)
  {
    AppMethodBeat.i(219669);
    paramb = new c(paramb, parama);
    AppMethodBeat.o(219669);
    return paramb;
  }
  
  public final void a(IImageDecodeService.b paramb)
  {
    this.aJP = paramb;
  }
  
  public final void bc(int paramInt1, int paramInt2)
  {
    this.uJ = paramInt1;
    this.EK = paramInt2;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(219645);
    this.aJQ = true;
    b localb = this.aJN;
    int i = 0;
    while (i < localb.aJS.size())
    {
      int j = localb.aJS.keyAt(i);
      b.b((Map)localb.aJS.get(j));
      i += 1;
    }
    b.b(localb.aJR);
    AppMethodBeat.o(219645);
  }
  
  public final void forceSetUseType(BitmapType paramBitmapType)
  {
    this.aJO = paramBitmapType;
  }
  
  public final boolean isDestroyed()
  {
    return this.aJQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.github.henryye.nativeiv.a
 * JD-Core Version:    0.7.0.1
 */