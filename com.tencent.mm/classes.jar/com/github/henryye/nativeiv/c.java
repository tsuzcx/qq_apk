package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.a;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class c
{
  private static final Object baw;
  b baA;
  BitmapType bar;
  IBitmap bax;
  IImageDecodeService.b bay;
  a baz;
  
  static
  {
    AppMethodBeat.i(127335);
    baw = new Object();
    AppMethodBeat.o(127335);
  }
  
  public c(b paramb, a parama)
  {
    AppMethodBeat.i(127334);
    this.bar = null;
    this.bax = new a();
    this.baA = paramb;
    this.baz = parama;
    AppMethodBeat.o(127334);
  }
  
  private void sQ()
  {
    AppMethodBeat.i(219796);
    if (this.bax != null) {
      this.bax.recycle();
    }
    AppMethodBeat.o(219796);
  }
  
  public final void a(com.github.henryye.nativeiv.bitmap.b<Bitmap> paramb)
  {
    AppMethodBeat.i(219797);
    BitmapType localBitmapType = BitmapType.Legacy;
    synchronized (baw)
    {
      if (this.bax.getType() == localBitmapType) {
        sQ();
      }
      b localb = this.baA;
      int i = hashCode();
      Map localMap = (Map)localb.bau.get(i);
      Object localObject1 = localMap;
      if (localMap == null) {
        localObject1 = new HashMap(2);
      }
      ((Map)localObject1).put(localBitmapType, paramb);
      localb.bau.append(i, localObject1);
      AppMethodBeat.o(219797);
      return;
    }
  }
  
  public final void forceSetUseType(BitmapType paramBitmapType)
  {
    this.bar = paramBitmapType;
  }
  
  public final com.github.henryye.nativeiv.bitmap.d h(InputStream paramInputStream)
  {
    AppMethodBeat.i(219794);
    sQ();
    if (paramInputStream != null)
    {
      paramInputStream = i(paramInputStream);
      AppMethodBeat.o(219794);
      return paramInputStream;
    }
    AppMethodBeat.o(219794);
    return null;
  }
  
  protected com.github.henryye.nativeiv.bitmap.d i(InputStream paramInputStream)
  {
    AppMethodBeat.i(219795);
    paramInputStream = com.github.henryye.nativeiv.c.d.k(paramInputStream);
    AppMethodBeat.o(219795);
    return paramInputStream;
  }
  
  static final class a
    implements IBitmap<Object>
  {
    public final void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, com.github.henryye.nativeiv.bitmap.c paramc)
    {
      AppMethodBeat.i(127332);
      paramInputStream = new IOException("Stub");
      AppMethodBeat.o(127332);
      throw paramInputStream;
    }
    
    public final long getDecodeTime()
    {
      return 0L;
    }
    
    public final BitmapType getType()
    {
      return BitmapType.Undefined;
    }
    
    public final Object provide()
    {
      return null;
    }
    
    public final void recycle() {}
  }
  
  static final class b
    implements IBitmap<NativeBitmapStruct>
  {
    public final void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, com.github.henryye.nativeiv.bitmap.c paramc)
    {
      AppMethodBeat.i(127333);
      if (paramInputStream == null)
      {
        paramInputStream = new IOException("Null input stream");
        AppMethodBeat.o(127333);
        throw paramInputStream;
      }
      AppMethodBeat.o(127333);
    }
    
    public final long getDecodeTime()
    {
      return 0L;
    }
    
    public final BitmapType getType()
    {
      return BitmapType.Native;
    }
    
    public final void recycle() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.henryye.nativeiv.c
 * JD-Core Version:    0.7.0.1
 */