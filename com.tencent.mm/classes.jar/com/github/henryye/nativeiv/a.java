package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.b;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a
{
  Map<BitmapType, b> aQa;
  SparseArray<Map<BitmapType, b>> aQb;
  
  public a()
  {
    AppMethodBeat.i(127329);
    this.aQa = new HashMap(3);
    this.aQb = new SparseArray();
    this.aQa.put(BitmapType.Native, new b()
    {
      public final boolean a(c paramAnonymousc)
      {
        return false;
      }
      
      public final void destroy() {}
      
      public final IBitmap ro()
      {
        AppMethodBeat.i(127326);
        b.b localb = new b.b();
        AppMethodBeat.o(127326);
        return localb;
      }
    });
    this.aQa.put(BitmapType.Legacy, new b()
    {
      public final boolean a(c paramAnonymousc)
      {
        return true;
      }
      
      public final void destroy() {}
      
      public final IBitmap<Bitmap> ro()
      {
        AppMethodBeat.i(127327);
        LegacyBitmap localLegacyBitmap = new LegacyBitmap();
        AppMethodBeat.o(127327);
        return localLegacyBitmap;
      }
    });
    this.aQa.put(BitmapType.Undefined, new b()
    {
      public final boolean a(c paramAnonymousc)
      {
        return true;
      }
      
      public final void destroy() {}
      
      public final IBitmap ro()
      {
        AppMethodBeat.i(127328);
        b.a locala = new b.a();
        AppMethodBeat.o(127328);
        return locala;
      }
    });
    AppMethodBeat.o(127329);
  }
  
  static IBitmap a(c paramc, Map<BitmapType, b> paramMap)
  {
    AppMethodBeat.i(127331);
    if (((b)paramMap.get(BitmapType.Native)).a(paramc))
    {
      paramc = ((b)paramMap.get(BitmapType.Native)).ro();
      AppMethodBeat.o(127331);
      return paramc;
    }
    if (((b)paramMap.get(BitmapType.Legacy)).a(paramc))
    {
      paramc = ((b)paramMap.get(BitmapType.Legacy)).ro();
      AppMethodBeat.o(127331);
      return paramc;
    }
    paramc = ((b)paramMap.get(BitmapType.Undefined)).ro();
    AppMethodBeat.o(127331);
    return paramc;
  }
  
  static void b(Map<BitmapType, b> paramMap)
  {
    AppMethodBeat.i(127330);
    if (paramMap == null)
    {
      AppMethodBeat.o(127330);
      return;
    }
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext()) {
      ((b)paramMap.next()).destroy();
    }
    AppMethodBeat.o(127330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.a
 * JD-Core Version:    0.7.0.1
 */