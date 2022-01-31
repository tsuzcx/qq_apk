package com.tencent.mm.app;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ah;

final class c
  implements i.a
{
  private volatile Bitmap bXF = null;
  d bXG;
  
  public final Bitmap AY()
  {
    AppMethodBeat.i(15370);
    if (this.bXF == null) {}
    try
    {
      if (this.bXF == null) {
        this.bXF = a.decodeResource(ah.getContext().getResources(), 2131231207);
      }
      Bitmap localBitmap = this.bXF;
      AppMethodBeat.o(15370);
      return localBitmap;
    }
    finally
    {
      AppMethodBeat.o(15370);
    }
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(15368);
    if ((parami instanceof d.a)) {
      o.acQ().a((d.a)parami);
    }
    AppMethodBeat.o(15368);
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(15372);
    paramString = b.d(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(15372);
    return paramString;
  }
  
  public final Bitmap dt(String paramString)
  {
    AppMethodBeat.i(15369);
    paramString = b.b(paramString, false, -1);
    AppMethodBeat.o(15369);
    return paramString;
  }
  
  public final Bitmap du(String paramString)
  {
    AppMethodBeat.i(15371);
    if (this.bXG == null) {
      this.bXG = o.acQ();
    }
    paramString = d.qY(paramString);
    AppMethodBeat.o(15371);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.app.c
 * JD-Core Version:    0.7.0.1
 */