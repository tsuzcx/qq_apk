package com.github.henryye.nativeiv;

import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class b
{
  private static final Object aQd;
  BitmapType aQe;
  IBitmap aQf;
  IImageDecodeService.b aQg;
  com.github.henryye.nativeiv.api.a aQh;
  a aQi;
  
  static
  {
    AppMethodBeat.i(127335);
    aQd = new Object();
    AppMethodBeat.o(127335);
  }
  
  public b(a parama, com.github.henryye.nativeiv.api.a parama1)
  {
    AppMethodBeat.i(127334);
    this.aQe = null;
    this.aQf = new a();
    this.aQi = parama;
    this.aQh = parama1;
    AppMethodBeat.o(127334);
  }
  
  static final class a
    implements IBitmap<Object>
  {
    public final void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
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
    public final void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.b
 * JD-Core Version:    0.7.0.1
 */