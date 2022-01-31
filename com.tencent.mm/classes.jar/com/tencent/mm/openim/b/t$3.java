package com.tencent.mm.openim.b;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;

final class t$3
  implements g
{
  t$3(t paramt, t.a parama) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(78892);
    if ((paramb.status == 0) && (paramb.bitmap != null) && (!paramb.bitmap.isRecycled())) {
      this.gga.bitmap = paramb.bitmap;
    }
    AppMethodBeat.o(78892);
  }
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.b.t.3
 * JD-Core Version:    0.7.0.1
 */