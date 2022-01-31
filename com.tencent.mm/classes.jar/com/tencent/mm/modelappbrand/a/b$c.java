package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

public final class b$c
  implements b.j
{
  final f<String, Reference<Bitmap>> fqB;
  
  public b$c()
  {
    AppMethodBeat.i(77329);
    this.fqB = new b.c.1(this);
    AppMethodBeat.o(77329);
  }
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(77331);
    if ((bo.isNullOrNil(paramString)) || (paramBitmap == null))
    {
      AppMethodBeat.o(77331);
      return;
    }
    ab.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", new Object[] { paramString, paramBitmap });
    this.fqB.put(paramString, new SoftReference(paramBitmap));
    AppMethodBeat.o(77331);
  }
  
  public final Bitmap lK(String paramString)
  {
    AppMethodBeat.i(77330);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77330);
      return null;
    }
    Object localObject = (Reference)this.fqB.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(77330);
      return null;
    }
    localObject = (Bitmap)((Reference)localObject).get();
    if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
    {
      this.fqB.remove(paramString);
      AppMethodBeat.o(77330);
      return null;
    }
    AppMethodBeat.o(77330);
    return localObject;
  }
  
  public final void t(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77332);
    ab.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", new Object[] { paramBitmap });
    if (paramBitmap != null) {
      paramBitmap.isRecycled();
    }
    AppMethodBeat.o(77332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.c
 * JD-Core Version:    0.7.0.1
 */