package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b
{
  Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> bax;
  SparseArray<Map<BitmapType, com.github.henryye.nativeiv.bitmap.b>> bay;
  
  public b()
  {
    AppMethodBeat.i(127329);
    this.bax = new HashMap(3);
    this.bay = new SparseArray();
    this.bax.put(BitmapType.Native, new com.github.henryye.nativeiv.bitmap.b()
    {
      public final boolean a(c paramAnonymousc)
      {
        return false;
      }
      
      public final void destroy() {}
      
      public final IBitmap sM()
      {
        AppMethodBeat.i(127326);
        c.b localb = new c.b();
        AppMethodBeat.o(127326);
        return localb;
      }
    });
    this.bax.put(BitmapType.Legacy, new com.github.henryye.nativeiv.bitmap.b()
    {
      public final boolean a(c paramAnonymousc)
      {
        return true;
      }
      
      public final void destroy() {}
      
      public final IBitmap<Bitmap> sM()
      {
        AppMethodBeat.i(127327);
        LegacyBitmap localLegacyBitmap = new LegacyBitmap();
        AppMethodBeat.o(127327);
        return localLegacyBitmap;
      }
    });
    this.bax.put(BitmapType.Undefined, new com.github.henryye.nativeiv.bitmap.b()
    {
      public final boolean a(c paramAnonymousc)
      {
        return true;
      }
      
      public final void destroy() {}
      
      public final IBitmap sM()
      {
        AppMethodBeat.i(127328);
        c.a locala = new c.a();
        AppMethodBeat.o(127328);
        return locala;
      }
    });
    AppMethodBeat.o(127329);
  }
  
  static IBitmap a(c paramc, Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> paramMap)
  {
    AppMethodBeat.i(127331);
    if (((com.github.henryye.nativeiv.bitmap.b)paramMap.get(BitmapType.Native)).a(paramc))
    {
      paramc = ((com.github.henryye.nativeiv.bitmap.b)paramMap.get(BitmapType.Native)).sM();
      AppMethodBeat.o(127331);
      return paramc;
    }
    if (((com.github.henryye.nativeiv.bitmap.b)paramMap.get(BitmapType.Legacy)).a(paramc))
    {
      paramc = ((com.github.henryye.nativeiv.bitmap.b)paramMap.get(BitmapType.Legacy)).sM();
      AppMethodBeat.o(127331);
      return paramc;
    }
    paramc = ((com.github.henryye.nativeiv.bitmap.b)paramMap.get(BitmapType.Undefined)).sM();
    AppMethodBeat.o(127331);
    return paramc;
  }
  
  static void b(Map<BitmapType, com.github.henryye.nativeiv.bitmap.b> paramMap)
  {
    AppMethodBeat.i(127330);
    if (paramMap == null)
    {
      AppMethodBeat.o(127330);
      return;
    }
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext()) {
      ((com.github.henryye.nativeiv.bitmap.b)paramMap.next()).destroy();
    }
    AppMethodBeat.o(127330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.github.henryye.nativeiv.b
 * JD-Core Version:    0.7.0.1
 */