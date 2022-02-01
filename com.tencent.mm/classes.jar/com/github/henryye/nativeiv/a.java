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
  private b bau;
  private BitmapType bav;
  private IImageDecodeService.b baw;
  private int mMaxHeight;
  private int mMaxWidth;
  
  public a()
  {
    AppMethodBeat.i(209404);
    this.mMaxWidth = 2048;
    this.mMaxHeight = 2048;
    this.bau = new b();
    b localb = this.bau;
    BitmapType localBitmapType = BitmapType.Native;
    com.github.henryye.nativeiv.comm.a locala = new com.github.henryye.nativeiv.comm.a();
    localb.bax.put(localBitmapType, locala);
    AppMethodBeat.o(209404);
  }
  
  public final IBitmap a(String paramString, Object paramObject, com.github.henryye.nativeiv.b.b paramb, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(209406);
    com.github.henryye.nativeiv.api.a locala = new com.github.henryye.nativeiv.api.a();
    i = this.mMaxWidth;
    locala.mMaxHeight = this.mMaxHeight;
    locala.mMaxWidth = i;
    locala.mPath = paramString;
    locala.baS = paramb.sP();
    paramObject = paramb.a(paramObject, paramImageDecodeConfig);
    if ((paramObject.inputStream == null) || (!TextUtils.isEmpty(paramObject.errorMsg)))
    {
      locala.baT = paramObject.errorMsg;
      this.baw.a(paramString, IImageDecodeService.b.a.baV, locala);
      AppMethodBeat.o(209406);
      return null;
    }
    localInputStream = paramObject.inputStream;
    localc = a(this.bau, locala);
    localc.bav = this.bav;
    localc.baC = this.baw;
    d locald = localc.h(localInputStream);
    if (locald == null)
    {
      this.baw.a(paramString, IImageDecodeService.b.a.baW, locala);
      AppMethodBeat.o(209406);
      return null;
    }
    if (locald.bbr == com.github.henryye.nativeiv.bitmap.c.bbp)
    {
      this.baw.a(paramString, IImageDecodeService.b.a.baY, locala);
      AppMethodBeat.o(209406);
      return null;
    }
    localc1 = locald.bbr;
    Object localObject;
    if (localInputStream != null)
    {
      if (localc.bav == null) {
        break label445;
      }
      paramObject = localc.baE;
      i = localc.hashCode();
      paramb = localc.bav;
      localObject = (Map)paramObject.bay.get(i);
      if ((localObject == null) || (((Map)localObject).get(paramb) == null)) {
        break label405;
      }
      paramObject = ((com.github.henryye.nativeiv.bitmap.b)((Map)localObject).get(paramb)).sM();
      localc.baB = paramObject;
      label308:
      j = 0;
    }
    for (;;)
    {
      try
      {
        localc.baB.decodeInputStream(localInputStream, paramImageDecodeConfig, localc1);
        paramObject = localc.baB.provide();
        if (paramObject == null) {
          continue;
        }
        i = 1;
      }
      catch (IOException paramObject)
      {
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decodeInputStream", new Object[0]);
        localc.baC.a(paramString, IImageDecodeService.b.a.bba, localc.baD);
        j = 1;
        i = 0;
        continue;
      }
      catch (OutOfMemoryError paramObject)
      {
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decodeInputStream", new Object[0]);
        localc.baC.a(paramString, IImageDecodeService.b.a.bbb, localc.baD);
        j = 1;
        i = 0;
        continue;
      }
      catch (Throwable paramObject)
      {
        label405:
        label445:
        com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decode image exception", new Object[0]);
        localc.baC.a(paramString, IImageDecodeService.b.a.bbe, localc.baD);
        i = 0;
        continue;
        long l = 0L;
        try
        {
          j = localInputStream.available();
          l = j;
          if ((i == 0) && (localc.baB.getType() == BitmapType.Native))
          {
            com.github.henryye.nativeiv.a.b.i("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
            localc.baB = ((com.github.henryye.nativeiv.bitmap.b)localc.baE.bax.get(BitmapType.Legacy)).sM();
          }
        }
        catch (IOException paramObject)
        {
          try
          {
            localc.baB.decodeInputStream(localInputStream, paramImageDecodeConfig, localc1);
            localc.baD.baQ = l;
            localc.baD.baR = localc.baB.getDecodeTime();
            localc.baC.a(paramString, IImageDecodeService.b.a.baU, localc.baD);
            if (localc.baB.getType() == BitmapType.Legacy) {
              localc.baC.a(paramString, IImageDecodeService.b.a.bbc, localc.baD);
            }
            if (localc.baB.provide() == null)
            {
              localc.baB.recycle();
              localc.baB = null;
            }
            com.github.henryye.nativeiv.c.b.b(localInputStream);
            continue;
            paramObject = paramObject;
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: get stream len failed!", new Object[0]);
          }
          catch (IOException paramObject)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: IOException when use legacy", new Object[0]);
            localc.baC.a(paramString, IImageDecodeService.b.a.bba, localc.baD);
            continue;
          }
          catch (OutOfMemoryError paramObject)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decodeInputStream", new Object[0]);
            localc.baC.a(paramString, IImageDecodeService.b.a.bbb, localc.baD);
            continue;
          }
          catch (Throwable paramObject)
          {
            com.github.henryye.nativeiv.a.b.printStackTrace("Ni.BitmapWrapper", paramObject, "hy: decode image exception", new Object[0]);
            localc.baC.a(paramString, IImageDecodeService.b.a.bbe, localc.baD);
            continue;
          }
          paramString = localc.baB;
          AppMethodBeat.o(209406);
          return paramString;
        }
        catch (IllegalStateException paramObject)
        {
          continue;
        }
        paramObject = null;
        continue;
      }
      if (j == 0) {
        continue;
      }
      com.github.henryye.nativeiv.c.b.b(localInputStream);
      if ((locald.bbs <= this.mMaxWidth) && (locald.bbt <= this.mMaxHeight)) {
        continue;
      }
      this.baw.a(paramString, IImageDecodeService.b.a.baZ, locala);
      AppMethodBeat.o(209406);
      return null;
      if (paramObject.bax.get(paramb) != null)
      {
        paramObject = ((com.github.henryye.nativeiv.bitmap.b)paramObject.bax.get(paramb)).sM();
        break;
      }
      paramObject = null;
      break;
      localObject = localc.baE;
      i = localc.hashCode();
      paramObject = (Map)((b)localObject).bay.get(i);
      if (paramObject == null) {
        continue;
      }
      paramObject = b.a(localc1, paramObject);
      paramb = paramObject;
      if (paramObject == null) {
        paramb = b.a(localc1, ((b)localObject).bax);
      }
      localc.baB = paramb;
      break label308;
      i = 0;
    }
  }
  
  protected c a(b paramb, com.github.henryye.nativeiv.api.a parama)
  {
    AppMethodBeat.i(209407);
    paramb = new c(paramb, parama);
    AppMethodBeat.o(209407);
    return paramb;
  }
  
  public final void a(IImageDecodeService.b paramb)
  {
    this.baw = paramb;
  }
  
  public final void bc(int paramInt1, int paramInt2)
  {
    this.mMaxWidth = paramInt1;
    this.mMaxHeight = paramInt2;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(209405);
    b localb = this.bau;
    int i = 0;
    while (i < localb.bay.size())
    {
      int j = localb.bay.keyAt(i);
      b.b((Map)localb.bay.get(j));
      i += 1;
    }
    b.b(localb.bax);
    AppMethodBeat.o(209405);
  }
  
  public final void forceSetUseType(BitmapType paramBitmapType)
  {
    this.bav = paramBitmapType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.github.henryye.nativeiv.a
 * JD-Core Version:    0.7.0.1
 */