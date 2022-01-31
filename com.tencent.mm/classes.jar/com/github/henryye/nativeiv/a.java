package com.github.henryye.nativeiv;

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
  public Map<BitmapType, b> auu;
  public SparseArray<Map<BitmapType, b>> auv;
  
  public a()
  {
    AppMethodBeat.i(115742);
    this.auu = new HashMap(2);
    this.auv = new SparseArray();
    this.auu.put(BitmapType.Native, new a.1(this));
    this.auu.put(BitmapType.Legacy, new a.2(this));
    this.auu.put(BitmapType.Undefined, new b()
    {
      public final boolean a(c paramAnonymousc)
      {
        return true;
      }
      
      public final void destroy() {}
      
      public final IBitmap mt()
      {
        AppMethodBeat.i(115741);
        b.a locala = new b.a();
        AppMethodBeat.o(115741);
        return locala;
      }
    });
    AppMethodBeat.o(115742);
  }
  
  public static IBitmap a(c paramc, Map<BitmapType, b> paramMap)
  {
    AppMethodBeat.i(115744);
    if (((b)paramMap.get(BitmapType.Native)).a(paramc))
    {
      paramc = ((b)paramMap.get(BitmapType.Native)).mt();
      AppMethodBeat.o(115744);
      return paramc;
    }
    if (((b)paramMap.get(BitmapType.Legacy)).a(paramc))
    {
      paramc = ((b)paramMap.get(BitmapType.Legacy)).mt();
      AppMethodBeat.o(115744);
      return paramc;
    }
    paramc = ((b)paramMap.get(BitmapType.Undefined)).mt();
    AppMethodBeat.o(115744);
    return paramc;
  }
  
  public static void b(Map<BitmapType, b> paramMap)
  {
    AppMethodBeat.i(115743);
    if (paramMap == null)
    {
      AppMethodBeat.o(115743);
      return;
    }
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext()) {
      ((b)paramMap.next()).destroy();
    }
    AppMethodBeat.o(115743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.a
 * JD-Core Version:    0.7.0.1
 */