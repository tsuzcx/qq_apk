package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class b$1
  implements Runnable
{
  b$1(b paramb, String paramString1, b.i parami, String paramString2, b.l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(77315);
    Object localObject = this.fqv.qw(this.cbQ);
    if (localObject != null)
    {
      this.fqt.w((Bitmap)localObject);
      ab.d("MicroMsg.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", new Object[] { this.val$url, localObject });
      AppMethodBeat.o(77315);
      return;
    }
    localObject = this.fqu.acL();
    b.a(this.fqv).put(this.fqt, localObject);
    b.b(this.fqv).put(localObject, this.fqt);
    this.fqt.acG();
    localObject = this.fqu;
    b.d(((b.l)localObject).fqH).post(new b.l.2((b.l)localObject));
    AppMethodBeat.o(77315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.1
 * JD-Core Version:    0.7.0.1
 */