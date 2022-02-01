package com.github.henryye.nativeiv;

import android.text.TextUtils;
import android.util.SparseArray;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.b.b.a;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class c
  implements IImageDecodeService.a
{
  private BitmapType aPo;
  private a aPt;
  private IImageDecodeService.b aPu;
  private int mMaxHeight;
  private int mMaxWidth;
  
  public c()
  {
    AppMethodBeat.i(127336);
    this.mMaxWidth = 2048;
    this.mMaxHeight = 2048;
    this.aPt = new a();
    a locala = this.aPt;
    BitmapType localBitmapType = BitmapType.Native;
    com.github.henryye.nativeiv.comm.a locala1 = new com.github.henryye.nativeiv.comm.a();
    locala.aPk.put(localBitmapType, locala1);
    AppMethodBeat.o(127336);
  }
  
  public final IBitmap a(String paramString, Object paramObject, com.github.henryye.nativeiv.b.b paramb, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(127338);
    localObject1 = new com.github.henryye.nativeiv.api.a();
    i = this.mMaxWidth;
    ((com.github.henryye.nativeiv.api.a)localObject1).mMaxHeight = this.mMaxHeight;
    ((com.github.henryye.nativeiv.api.a)localObject1).mMaxWidth = i;
    ((com.github.henryye.nativeiv.api.a)localObject1).mPath = paramString;
    ((com.github.henryye.nativeiv.api.a)localObject1).aPI = paramb.rg();
    paramObject = paramb.a(paramObject, paramImageDecodeConfig);
    if ((paramObject.inputStream == null) || (!TextUtils.isEmpty(paramObject.errorMsg)))
    {
      ((com.github.henryye.nativeiv.api.a)localObject1).aPJ = paramObject.errorMsg;
      this.aPu.a(paramString, IImageDecodeService.b.a.aPL, (com.github.henryye.nativeiv.api.a)localObject1);
      AppMethodBeat.o(127338);
      return null;
    }
    localInputStream = paramObject.inputStream;
    localb = new b(this.aPt, (com.github.henryye.nativeiv.api.a)localObject1);
    localb.aPo = this.aPo;
    localb.aPq = this.aPu;
    if (localb.aPp != null) {
      localb.aPp.recycle();
    }
    if (localInputStream != null) {}
    for (paramObject = com.github.henryye.nativeiv.c.d.g(localInputStream); paramObject == null; paramObject = null)
    {
      this.aPu.a(paramString, IImageDecodeService.b.a.aPM, (com.github.henryye.nativeiv.api.a)localObject1);
      AppMethodBeat.o(127338);
      return null;
    }
    if (paramObject.aQg == com.github.henryye.nativeiv.bitmap.c.aQe)
    {
      this.aPu.a(paramString, IImageDecodeService.b.a.aPO, (com.github.henryye.nativeiv.api.a)localObject1);
      AppMethodBeat.o(127338);
      return null;
    }
    l = paramObject.aQh;
    ((com.github.henryye.nativeiv.api.a)localObject1).mHeight = paramObject.aQi;
    ((com.github.henryye.nativeiv.api.a)localObject1).mWidth = l;
    if ((paramObject.aQh > this.mMaxWidth) || (paramObject.aQi > this.mMaxHeight))
    {
      this.aPu.a(paramString, IImageDecodeService.b.a.aPP, (com.github.henryye.nativeiv.api.a)localObject1);
      AppMethodBeat.o(127338);
      return null;
    }
    localObject1 = paramObject.aQg;
    Object localObject2;
    if (localInputStream != null)
    {
      if (localb.aPo == null) {
        break label503;
      }
      paramObject = localb.aPs;
      i = localb.hashCode();
      paramb = localb.aPo;
      localObject2 = (Map)paramObject.aPl.get(i);
      if ((localObject2 == null) || (((Map)localObject2).get(paramb) == null)) {
        break label463;
      }
      paramObject = ((com.github.henryye.nativeiv.bitmap.b)((Map)localObject2).get(paramb)).re();
      localb.aPp = paramObject;
      label403:
      j = 0;
    }
    for (;;)
    {
      try
      {
        localb.aPp.decodeInputStream(localInputStream, paramImageDecodeConfig, (com.github.henryye.nativeiv.bitmap.c)localObject1);
        paramObject = localb.aPp.provide();
        if (paramObject == null) {
          continue;
        }
        i = 1;
      }
      catch (IOException paramObject)
      {
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decodeInputStream", new Object[0]);
        localb.aPq.a(paramString, IImageDecodeService.b.a.aPQ, localb.aPr);
        j = 1;
        i = 0;
        continue;
      }
      catch (OutOfMemoryError paramObject)
      {
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decodeInputStream", new Object[0]);
        localb.aPq.a(paramString, IImageDecodeService.b.a.aPR, localb.aPr);
        j = 1;
        i = 0;
        continue;
      }
      catch (Throwable paramObject)
      {
        label463:
        label503:
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decode image exception", new Object[0]);
        localb.aPq.a(paramString, IImageDecodeService.b.a.aPU, localb.aPr);
        i = 0;
        continue;
        try
        {
          j = localInputStream.available();
          l = j;
          if ((i == 0) && (localb.aPp.getType() == BitmapType.Native))
          {
            com.github.henryye.nativeiv.a.b.i("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
            localb.aPp = ((com.github.henryye.nativeiv.bitmap.b)localb.aPs.aPk.get(BitmapType.Legacy)).re();
          }
        }
        catch (IOException paramObject)
        {
          try
          {
            localb.aPp.decodeInputStream(localInputStream, paramImageDecodeConfig, (com.github.henryye.nativeiv.bitmap.c)localObject1);
            localb.aPr.aPG = l;
            localb.aPr.aPH = localb.aPp.getDecodeTime();
            localb.aPq.a(paramString, IImageDecodeService.b.a.aPK, localb.aPr);
            if (localb.aPp.getType() == BitmapType.Legacy) {
              localb.aPq.a(paramString, IImageDecodeService.b.a.aPS, localb.aPr);
            }
            if (localb.aPp.provide() == null)
            {
              localb.aPp.recycle();
              localb.aPp = null;
            }
            com.github.henryye.nativeiv.c.b.b(localInputStream);
            continue;
            paramObject = paramObject;
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "", new Object[0]);
            l = 0L;
          }
          catch (IOException paramObject)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: IOException when use legacy", new Object[0]);
            localb.aPq.a(paramString, IImageDecodeService.b.a.aPQ, localb.aPr);
            continue;
          }
          catch (OutOfMemoryError paramObject)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decodeInputStream", new Object[0]);
            localb.aPq.a(paramString, IImageDecodeService.b.a.aPR, localb.aPr);
            continue;
          }
          catch (Throwable paramObject)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decode image exception", new Object[0]);
            localb.aPq.a(paramString, IImageDecodeService.b.a.aPU, localb.aPr);
            continue;
          }
        }
        paramObject = null;
        continue;
      }
      if (j == 0) {
        continue;
      }
      com.github.henryye.nativeiv.c.b.b(localInputStream);
      paramString = localb.aPp;
      AppMethodBeat.o(127338);
      return paramString;
      if (paramObject.aPk.get(paramb) != null)
      {
        paramObject = ((com.github.henryye.nativeiv.bitmap.b)paramObject.aPk.get(paramb)).re();
        break;
      }
      paramObject = null;
      break;
      localObject2 = localb.aPs;
      i = localb.hashCode();
      paramObject = (Map)((a)localObject2).aPl.get(i);
      if (paramObject == null) {
        continue;
      }
      paramObject = a.a((com.github.henryye.nativeiv.bitmap.c)localObject1, paramObject);
      paramb = paramObject;
      if (paramObject == null) {
        paramb = a.a((com.github.henryye.nativeiv.bitmap.c)localObject1, ((a)localObject2).aPk);
      }
      localb.aPp = paramb;
      break label403;
      i = 0;
    }
  }
  
  public final void a(IImageDecodeService.b paramb)
  {
    this.aPu = paramb;
  }
  
  public final void ba(int paramInt1, int paramInt2)
  {
    this.mMaxWidth = paramInt1;
    this.mMaxHeight = paramInt2;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(127337);
    a locala = this.aPt;
    int i = 0;
    while (i < locala.aPl.size())
    {
      int j = locala.aPl.keyAt(i);
      a.b((Map)locala.aPl.get(j));
      i += 1;
    }
    a.b(locala.aPk);
    AppMethodBeat.o(127337);
  }
  
  public final void forceSetUseType(BitmapType paramBitmapType)
  {
    this.aPo = paramBitmapType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.c
 * JD-Core Version:    0.7.0.1
 */