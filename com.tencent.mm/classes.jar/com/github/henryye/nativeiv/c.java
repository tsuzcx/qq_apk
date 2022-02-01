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
  private static final Object cDQ;
  BitmapType cDL;
  IBitmap cDR;
  IImageDecodeService.b cDS;
  a cDT;
  b cDU;
  
  static
  {
    AppMethodBeat.i(127335);
    cDQ = new Object();
    AppMethodBeat.o(127335);
  }
  
  public c(b paramb, a parama)
  {
    AppMethodBeat.i(127334);
    this.cDL = null;
    this.cDR = new a();
    this.cDU = paramb;
    this.cDT = parama;
    AppMethodBeat.o(127334);
  }
  
  private void Qh()
  {
    AppMethodBeat.i(208240);
    if (this.cDR != null) {
      this.cDR.recycle();
    }
    AppMethodBeat.o(208240);
  }
  
  public final void a(com.github.henryye.nativeiv.bitmap.b<Bitmap> paramb)
  {
    AppMethodBeat.i(208245);
    BitmapType localBitmapType = BitmapType.Legacy;
    synchronized (cDQ)
    {
      if (this.cDR.getType() == localBitmapType) {
        Qh();
      }
      b localb = this.cDU;
      int i = hashCode();
      Map localMap = (Map)localb.cDO.get(i);
      Object localObject1 = localMap;
      if (localMap == null) {
        localObject1 = new HashMap(2);
      }
      ((Map)localObject1).put(localBitmapType, paramb);
      localb.cDO.append(i, localObject1);
      AppMethodBeat.o(208245);
      return;
    }
  }
  
  public final void forceSetUseType(BitmapType paramBitmapType)
  {
    this.cDL = paramBitmapType;
  }
  
  public final com.github.henryye.nativeiv.bitmap.d p(InputStream paramInputStream)
  {
    AppMethodBeat.i(208242);
    Qh();
    if (paramInputStream != null)
    {
      paramInputStream = q(paramInputStream);
      AppMethodBeat.o(208242);
      return paramInputStream;
    }
    AppMethodBeat.o(208242);
    return null;
  }
  
  protected com.github.henryye.nativeiv.bitmap.d q(InputStream paramInputStream)
  {
    AppMethodBeat.i(208243);
    paramInputStream = com.github.henryye.nativeiv.c.d.s(paramInputStream);
    AppMethodBeat.o(208243);
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