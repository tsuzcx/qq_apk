package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.a;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class c
{
  private static final Object aJU;
  BitmapType aJO;
  IBitmap aJV;
  IImageDecodeService.b aJW;
  a aJX;
  b aJY;
  
  static
  {
    AppMethodBeat.i(127335);
    aJU = new Object();
    AppMethodBeat.o(127335);
  }
  
  public c(b paramb, a parama)
  {
    AppMethodBeat.i(127334);
    this.aJO = null;
    this.aJV = new c.a();
    this.aJY = paramb;
    this.aJX = parama;
    AppMethodBeat.o(127334);
  }
  
  private void qE()
  {
    AppMethodBeat.i(219688);
    if (this.aJV != null) {
      this.aJV.recycle();
    }
    AppMethodBeat.o(219688);
  }
  
  public final void a(com.github.henryye.nativeiv.bitmap.b<Bitmap> paramb)
  {
    AppMethodBeat.i(219693);
    BitmapType localBitmapType = BitmapType.Legacy;
    synchronized (aJU)
    {
      if (this.aJV.getType() == localBitmapType) {
        qE();
      }
      b localb = this.aJY;
      int i = hashCode();
      Map localMap = (Map)localb.aJS.get(i);
      Object localObject1 = localMap;
      if (localMap == null) {
        localObject1 = new HashMap(2);
      }
      ((Map)localObject1).put(localBitmapType, paramb);
      localb.aJS.append(i, localObject1);
      AppMethodBeat.o(219693);
      return;
    }
  }
  
  public final com.github.henryye.nativeiv.bitmap.d f(InputStream paramInputStream)
  {
    AppMethodBeat.i(219684);
    qE();
    if (paramInputStream != null)
    {
      paramInputStream = g(paramInputStream);
      AppMethodBeat.o(219684);
      return paramInputStream;
    }
    AppMethodBeat.o(219684);
    return null;
  }
  
  public final void forceSetUseType(BitmapType paramBitmapType)
  {
    this.aJO = paramBitmapType;
  }
  
  protected com.github.henryye.nativeiv.bitmap.d g(InputStream paramInputStream)
  {
    AppMethodBeat.i(219686);
    paramInputStream = com.github.henryye.nativeiv.c.d.i(paramInputStream);
    AppMethodBeat.o(219686);
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.github.henryye.nativeiv.c
 * JD-Core Version:    0.7.0.1
 */