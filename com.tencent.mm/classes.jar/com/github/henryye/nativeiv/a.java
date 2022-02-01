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
  private volatile boolean aMn;
  private b baq;
  private BitmapType bar;
  private IImageDecodeService.b bas;
  private int mMaxHeight;
  private int mMaxWidth;
  
  public a()
  {
    AppMethodBeat.i(219790);
    this.mMaxWidth = 2048;
    this.mMaxHeight = 2048;
    this.baq = new b();
    this.aMn = false;
    b localb = this.baq;
    BitmapType localBitmapType = BitmapType.Native;
    com.github.henryye.nativeiv.comm.a locala = new com.github.henryye.nativeiv.comm.a();
    localb.bat.put(localBitmapType, locala);
    AppMethodBeat.o(219790);
  }
  
  public final IBitmap a(String paramString, Object paramObject, com.github.henryye.nativeiv.b.b paramb, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(219792);
    com.github.henryye.nativeiv.api.a locala = new com.github.henryye.nativeiv.api.a();
    int i = this.mMaxWidth;
    locala.mMaxHeight = this.mMaxHeight;
    locala.mMaxWidth = i;
    locala.mPath = paramString;
    locala.baO = paramb.sS();
    for (;;)
    {
      InputStream localInputStream;
      c localc;
      com.github.henryye.nativeiv.bitmap.c localc1;
      int j;
      try
      {
        localObject1 = paramb.a(paramObject, paramImageDecodeConfig);
        if ((((b.a)localObject1).inputStream == null) || (!TextUtils.isEmpty(((b.a)localObject1).errorMsg)))
        {
          locala.baP = ((b.a)localObject1).errorMsg;
          this.bas.a(paramString, IImageDecodeService.b.a.baR, locala);
          AppMethodBeat.o(219792);
          return null;
        }
        localInputStream = ((b.a)localObject1).inputStream;
        localc = a(this.baq, locala);
        localc.bar = this.bar;
        localc.bay = this.bas;
        locald = localc.h(localInputStream);
        if (locald == null)
        {
          this.bas.a(paramString, IImageDecodeService.b.a.baS, locala);
          AppMethodBeat.o(219792);
          return null;
        }
        if (locald.bbo == com.github.henryye.nativeiv.bitmap.c.bbm)
        {
          this.bas.a(paramString, IImageDecodeService.b.a.baU, locala);
          AppMethodBeat.o(219792);
          return null;
        }
        localc1 = locald.bbo;
        if (localInputStream != null)
        {
          if (localc.bar == null) {
            continue;
          }
          localObject1 = localc.baA;
          i = localc.hashCode();
          localObject3 = localc.bar;
          localObject4 = (Map)((b)localObject1).bau.get(i);
          if ((localObject4 == null) || (((Map)localObject4).get(localObject3) == null)) {
            continue;
          }
          localObject1 = ((com.github.henryye.nativeiv.bitmap.b)((Map)localObject4).get(localObject3)).sP();
          localc.bax = ((IBitmap)localObject1);
          j = 0;
        }
      }
      catch (Exception paramImageDecodeConfig)
      {
        Object localObject1;
        d locald;
        Object localObject3;
        Object localObject4;
        this.bas.a(paramString, IImageDecodeService.b.a.bbb, locala);
        com.github.henryye.nativeiv.a.b.e("DefaultBitmapDecoder", "ImageDecoder(%s) decode path[%s] error %s", new Object[] { paramb, paramObject.toString(), paramImageDecodeConfig.toString() });
        AppMethodBeat.o(219792);
        return null;
      }
      try
      {
        localc.bax.decodeInputStream(localInputStream, paramImageDecodeConfig, localc1);
        localObject1 = localc.bax.provide();
        if (localObject1 == null) {
          break label597;
        }
        i = 1;
      }
      catch (IOException localIOException1)
      {
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", localIOException1, "hy: decodeInputStream", new Object[0]);
        localc.bay.a(paramString, IImageDecodeService.b.a.baW, localc.baz);
        localc.bax.recycle();
        j = 1;
        i = 0;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", localOutOfMemoryError, "hy: decodeInputStream", new Object[0]);
        localc.bay.a(paramString, IImageDecodeService.b.a.baX, localc.baz);
        localc.bax.recycle();
        j = 1;
        i = 0;
        continue;
      }
      catch (Throwable localThrowable)
      {
        label597:
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", localThrowable, "hy: decode image exception", new Object[0]);
        localc.bay.a(paramString, IImageDecodeService.b.a.bba, localc.baz);
        localc.bax.recycle();
        i = 0;
        continue;
      }
      if (j != 0)
      {
        com.github.henryye.nativeiv.c.b.b(localInputStream);
        if ((locald.width <= this.mMaxWidth) && (locald.height <= this.mMaxHeight)) {
          break label1102;
        }
        this.bas.a(paramString, IImageDecodeService.b.a.baV, locala);
        localc.bax.recycle();
        AppMethodBeat.o(219792);
        return null;
        if (((b)localObject1).bat.get(localObject3) == null) {
          break label1128;
        }
        localObject1 = ((com.github.henryye.nativeiv.bitmap.b)((b)localObject1).bat.get(localObject3)).sP();
        continue;
        localObject4 = localc.baA;
        i = localc.hashCode();
        localObject1 = (Map)((b)localObject4).bau.get(i);
        if (localObject1 == null) {
          break label1122;
        }
        localObject1 = b.a(localc1, (Map)localObject1);
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = b.a(localc1, ((b)localObject4).bat);
        }
        localc.bax = ((IBitmap)localObject3);
        continue;
        i = 0;
        continue;
      }
      try
      {
        j = localInputStream.available();
        long l = j;
        if ((i == 0) && (localc.bax.getType() == BitmapType.Native))
        {
          com.github.henryye.nativeiv.a.b.i("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
          localc.bax = ((com.github.henryye.nativeiv.bitmap.b)localc.baA.bat.get(BitmapType.Legacy)).sP();
        }
        try
        {
          localc.bax.decodeInputStream(localInputStream, paramImageDecodeConfig, localc1);
          localc.baz.baM = l;
          localc.baz.baN = localc.bax.getDecodeTime();
          localc.bay.a(paramString, IImageDecodeService.b.a.baQ, localc.baz);
          if (localc.bax.getType() == BitmapType.Legacy) {
            localc.bay.a(paramString, IImageDecodeService.b.a.baY, localc.baz);
          }
          if (localc.bax.provide() == null)
          {
            localc.bax.recycle();
            localc.bax = null;
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
            localc.bay.a(paramString, IImageDecodeService.b.a.baW, localc.baz);
          }
        }
        catch (OutOfMemoryError paramImageDecodeConfig)
        {
          for (;;)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramImageDecodeConfig, "hy: decodeInputStream", new Object[0]);
            localc.bay.a(paramString, IImageDecodeService.b.a.baX, localc.baz);
          }
        }
        catch (Throwable paramImageDecodeConfig)
        {
          for (;;)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramImageDecodeConfig, "hy: decode image exception", new Object[0]);
            localc.bay.a(paramString, IImageDecodeService.b.a.bba, localc.baz);
          }
        }
        label1102:
        paramImageDecodeConfig = localc.bax;
        AppMethodBeat.o(219792);
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
    AppMethodBeat.i(219793);
    paramb = new c(paramb, parama);
    AppMethodBeat.o(219793);
    return paramb;
  }
  
  public final void a(IImageDecodeService.b paramb)
  {
    this.bas = paramb;
  }
  
  public final void aW(int paramInt1, int paramInt2)
  {
    this.mMaxWidth = paramInt1;
    this.mMaxHeight = paramInt2;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(219791);
    this.aMn = true;
    b localb = this.baq;
    int i = 0;
    while (i < localb.bau.size())
    {
      int j = localb.bau.keyAt(i);
      b.b((Map)localb.bau.get(j));
      i += 1;
    }
    b.b(localb.bat);
    AppMethodBeat.o(219791);
  }
  
  public final void forceSetUseType(BitmapType paramBitmapType)
  {
    this.bar = paramBitmapType;
  }
  
  public final boolean isDestroyed()
  {
    return this.aMn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.a
 * JD-Core Version:    0.7.0.1
 */