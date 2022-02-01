package com.tencent.mm.app;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.compatible.e.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ai;

final class e
  implements i.a
{
  private volatile Bitmap cIi = null;
  com.tencent.mm.aj.e cIj;
  
  public final Bitmap Kj()
  {
    AppMethodBeat.i(19433);
    if (this.cIi == null) {}
    try
    {
      if (this.cIi == null) {
        this.cIi = a.decodeResource(ai.getContext().getResources(), 2131690013);
      }
      Bitmap localBitmap = this.cIi;
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
      p.aBh().a((e.a)parami);
    }
    AppMethodBeat.o(19431);
  }
  
  public final Bitmap el(String paramString)
  {
    AppMethodBeat.i(19432);
    paramString = c.a(paramString, false, -1, null);
    AppMethodBeat.o(19432);
    return paramString;
  }
  
  public final Bitmap em(String paramString)
  {
    AppMethodBeat.i(19434);
    if (this.cIj == null) {
      this.cIj = p.aBh();
    }
    paramString = com.tencent.mm.aj.e.zZ(paramString);
    AppMethodBeat.o(19434);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.e
 * JD-Core Version:    0.7.0.1
 */