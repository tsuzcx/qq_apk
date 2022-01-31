package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class b$l$3
  implements Runnable
{
  b$l$3(b.l paraml, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(77347);
    b.l locall = this.fqQ;
    Object localObject = this.fqR;
    if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
    {
      ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", new Object[] { localObject });
      localObject = (b.i)b.b(locall.fqH).remove(locall.acL());
      if (localObject != null)
      {
        ((b.i)localObject).acH();
        b.a(locall.fqH).remove(localObject);
      }
      AppMethodBeat.o(77347);
      return;
    }
    ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", new Object[] { localObject });
    locall.w((Bitmap)localObject);
    AppMethodBeat.o(77347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.l.3
 * JD-Core Version:    0.7.0.1
 */