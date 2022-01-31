package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f.a;
import com.tencent.mm.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.Reference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class b$c$1
  extends h<String, Reference<Bitmap>>
{
  private final Map<Reference<Bitmap>, Integer> fqC;
  
  b$c$1(b.c paramc)
  {
    super(31457280);
    AppMethodBeat.i(77324);
    this.fqC = new ConcurrentHashMap();
    AppMethodBeat.o(77324);
  }
  
  public final void a(f.a<String, Reference<Bitmap>> parama)
  {
    AppMethodBeat.i(77326);
    ab.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear(OnClearListener)");
    super.a(parama);
    this.fqC.clear();
    AppMethodBeat.o(77326);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(77325);
    ab.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
    super.clear();
    this.fqC.clear();
    AppMethodBeat.o(77325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.c.1
 * JD-Core Version:    0.7.0.1
 */