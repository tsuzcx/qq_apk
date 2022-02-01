package com.tencent.mm.app;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.compatible.e.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.ak;

final class e
  implements j.a
{
  private volatile Bitmap cUb = null;
  com.tencent.mm.aj.e cUc;
  
  public final Bitmap LT()
  {
    AppMethodBeat.i(19433);
    if (this.cUb == null) {}
    try
    {
      if (this.cUb == null) {
        this.cUb = a.decodeResource(ak.getContext().getResources(), 2131690013);
      }
      Bitmap localBitmap = this.cUb;
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
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(19431);
    if ((paramj instanceof e.a)) {
      p.aEA().a((e.a)paramj);
    }
    AppMethodBeat.o(19431);
  }
  
  public final Bitmap fl(String paramString)
  {
    AppMethodBeat.i(19432);
    paramString = c.a(paramString, false, -1, null);
    AppMethodBeat.o(19432);
    return paramString;
  }
  
  public final Bitmap fm(String paramString)
  {
    AppMethodBeat.i(19434);
    if (this.cUc == null) {
      this.cUc = p.aEA();
    }
    paramString = com.tencent.mm.aj.e.DA(paramString);
    AppMethodBeat.o(19434);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.e
 * JD-Core Version:    0.7.0.1
 */