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
  private BitmapType aQe;
  private a aQj;
  private IImageDecodeService.b aQk;
  private int mMaxHeight;
  private int mMaxWidth;
  
  public c()
  {
    AppMethodBeat.i(127336);
    this.mMaxWidth = 2048;
    this.mMaxHeight = 2048;
    this.aQj = new a();
    a locala = this.aQj;
    BitmapType localBitmapType = BitmapType.Native;
    com.github.henryye.nativeiv.comm.a locala1 = new com.github.henryye.nativeiv.comm.a();
    locala.aQa.put(localBitmapType, locala1);
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
    ((com.github.henryye.nativeiv.api.a)localObject1).aQy = paramb.rq();
    paramObject = paramb.a(paramObject, paramImageDecodeConfig);
    if ((paramObject.inputStream == null) || (!TextUtils.isEmpty(paramObject.errorMsg)))
    {
      ((com.github.henryye.nativeiv.api.a)localObject1).aQz = paramObject.errorMsg;
      this.aQk.a(paramString, IImageDecodeService.b.a.aQB, (com.github.henryye.nativeiv.api.a)localObject1);
      AppMethodBeat.o(127338);
      return null;
    }
    localInputStream = paramObject.inputStream;
    localb = new b(this.aQj, (com.github.henryye.nativeiv.api.a)localObject1);
    localb.aQe = this.aQe;
    localb.aQg = this.aQk;
    if (localb.aQf != null) {
      localb.aQf.recycle();
    }
    if (localInputStream != null) {}
    for (paramObject = com.github.henryye.nativeiv.c.d.g(localInputStream); paramObject == null; paramObject = null)
    {
      this.aQk.a(paramString, IImageDecodeService.b.a.aQC, (com.github.henryye.nativeiv.api.a)localObject1);
      AppMethodBeat.o(127338);
      return null;
    }
    if (paramObject.aQW == com.github.henryye.nativeiv.bitmap.c.aQU)
    {
      this.aQk.a(paramString, IImageDecodeService.b.a.aQE, (com.github.henryye.nativeiv.api.a)localObject1);
      AppMethodBeat.o(127338);
      return null;
    }
    l = paramObject.aQX;
    ((com.github.henryye.nativeiv.api.a)localObject1).mHeight = paramObject.aQY;
    ((com.github.henryye.nativeiv.api.a)localObject1).mWidth = l;
    if ((paramObject.aQX > this.mMaxWidth) || (paramObject.aQY > this.mMaxHeight))
    {
      this.aQk.a(paramString, IImageDecodeService.b.a.aQF, (com.github.henryye.nativeiv.api.a)localObject1);
      AppMethodBeat.o(127338);
      return null;
    }
    localObject1 = paramObject.aQW;
    Object localObject2;
    if (localInputStream != null)
    {
      if (localb.aQe == null) {
        break label503;
      }
      paramObject = localb.aQi;
      i = localb.hashCode();
      paramb = localb.aQe;
      localObject2 = (Map)paramObject.aQb.get(i);
      if ((localObject2 == null) || (((Map)localObject2).get(paramb) == null)) {
        break label463;
      }
      paramObject = ((com.github.henryye.nativeiv.bitmap.b)((Map)localObject2).get(paramb)).ro();
      localb.aQf = paramObject;
      label403:
      j = 0;
    }
    for (;;)
    {
      try
      {
        localb.aQf.decodeInputStream(localInputStream, paramImageDecodeConfig, (com.github.henryye.nativeiv.bitmap.c)localObject1);
        paramObject = localb.aQf.provide();
        if (paramObject == null) {
          continue;
        }
        i = 1;
      }
      catch (IOException paramObject)
      {
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decodeInputStream", new Object[0]);
        localb.aQg.a(paramString, IImageDecodeService.b.a.aQG, localb.aQh);
        j = 1;
        i = 0;
        continue;
      }
      catch (OutOfMemoryError paramObject)
      {
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decodeInputStream", new Object[0]);
        localb.aQg.a(paramString, IImageDecodeService.b.a.aQH, localb.aQh);
        j = 1;
        i = 0;
        continue;
      }
      catch (Throwable paramObject)
      {
        label463:
        label503:
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decode image exception", new Object[0]);
        localb.aQg.a(paramString, IImageDecodeService.b.a.aQK, localb.aQh);
        i = 0;
        continue;
        try
        {
          j = localInputStream.available();
          l = j;
          if ((i == 0) && (localb.aQf.getType() == BitmapType.Native))
          {
            com.github.henryye.nativeiv.a.b.i("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
            localb.aQf = ((com.github.henryye.nativeiv.bitmap.b)localb.aQi.aQa.get(BitmapType.Legacy)).ro();
          }
        }
        catch (IOException paramObject)
        {
          try
          {
            localb.aQf.decodeInputStream(localInputStream, paramImageDecodeConfig, (com.github.henryye.nativeiv.bitmap.c)localObject1);
            localb.aQh.aQw = l;
            localb.aQh.aQx = localb.aQf.getDecodeTime();
            localb.aQg.a(paramString, IImageDecodeService.b.a.aQA, localb.aQh);
            if (localb.aQf.getType() == BitmapType.Legacy) {
              localb.aQg.a(paramString, IImageDecodeService.b.a.aQI, localb.aQh);
            }
            if (localb.aQf.provide() == null)
            {
              localb.aQf.recycle();
              localb.aQf = null;
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
            localb.aQg.a(paramString, IImageDecodeService.b.a.aQG, localb.aQh);
            continue;
          }
          catch (OutOfMemoryError paramObject)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decodeInputStream", new Object[0]);
            localb.aQg.a(paramString, IImageDecodeService.b.a.aQH, localb.aQh);
            continue;
          }
          catch (Throwable paramObject)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decode image exception", new Object[0]);
            localb.aQg.a(paramString, IImageDecodeService.b.a.aQK, localb.aQh);
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
      paramString = localb.aQf;
      AppMethodBeat.o(127338);
      return paramString;
      if (paramObject.aQa.get(paramb) != null)
      {
        paramObject = ((com.github.henryye.nativeiv.bitmap.b)paramObject.aQa.get(paramb)).ro();
        break;
      }
      paramObject = null;
      break;
      localObject2 = localb.aQi;
      i = localb.hashCode();
      paramObject = (Map)((a)localObject2).aQb.get(i);
      if (paramObject == null) {
        continue;
      }
      paramObject = a.a((com.github.henryye.nativeiv.bitmap.c)localObject1, paramObject);
      paramb = paramObject;
      if (paramObject == null) {
        paramb = a.a((com.github.henryye.nativeiv.bitmap.c)localObject1, ((a)localObject2).aQa);
      }
      localb.aQf = paramb;
      break label403;
      i = 0;
    }
  }
  
  public final void a(IImageDecodeService.b paramb)
  {
    this.aQk = paramb;
  }
  
  public final void ba(int paramInt1, int paramInt2)
  {
    this.mMaxWidth = paramInt1;
    this.mMaxHeight = paramInt2;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(127337);
    a locala = this.aQj;
    int i = 0;
    while (i < locala.aQb.size())
    {
      int j = locala.aQb.keyAt(i);
      a.b((Map)locala.aQb.get(j));
      i += 1;
    }
    a.b(locala.aQa);
    AppMethodBeat.o(127337);
  }
  
  public final void forceSetUseType(BitmapType paramBitmapType)
  {
    this.aQe = paramBitmapType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.c
 * JD-Core Version:    0.7.0.1
 */