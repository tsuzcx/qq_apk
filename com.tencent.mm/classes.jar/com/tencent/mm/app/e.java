package com.tencent.mm.app;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.compatible.e.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.aj;

final class e
  implements i.a
{
  private volatile Bitmap cLa = null;
  com.tencent.mm.ak.e cLb;
  
  public final Bitmap Ky()
  {
    AppMethodBeat.i(19433);
    if (this.cLa == null) {}
    try
    {
      if (this.cLa == null) {
        this.cLa = a.decodeResource(aj.getContext().getResources(), 2131690013);
      }
      Bitmap localBitmap = this.cLa;
      AppMethodBeat.o(19433);
      return localBitmap;
    }
    finally
    {
      AppMethodBeat.o(19433);
    }
  }
  
  public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(19435);
    paramString = c.e(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(19435);
    return paramString;
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(19431);
    if ((parami instanceof e.a)) {
      p.auq().a((e.a)parami);
    }
    AppMethodBeat.o(19431);
  }
  
  public final Bitmap ew(String paramString)
  {
    AppMethodBeat.i(19432);
    paramString = c.a(paramString, false, -1, null);
    AppMethodBeat.o(19432);
    return paramString;
  }
  
  public final Bitmap ex(String paramString)
  {
    AppMethodBeat.i(19434);
    if (this.cLb == null) {
      this.cLb = p.auq();
    }
    paramString = com.tencent.mm.ak.e.vT(paramString);
    AppMethodBeat.o(19434);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.e
 * JD-Core Version:    0.7.0.1
 */