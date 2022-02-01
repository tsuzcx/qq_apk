package com.tencent.mm.app;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class e
  implements j.a
{
  private volatile Bitmap dku = null;
  com.tencent.mm.aj.e dkv;
  
  public final Bitmap Wg()
  {
    AppMethodBeat.i(19433);
    if (this.dku == null) {}
    try
    {
      if (this.dku == null) {
        this.dku = a.decodeResource(MMApplicationContext.getContext().getResources(), 2131690042);
      }
      Bitmap localBitmap = this.dku;
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
      p.aYn().a((e.a)paramj);
    }
    AppMethodBeat.o(19431);
  }
  
  public final Bitmap fZ(String paramString)
  {
    AppMethodBeat.i(19432);
    paramString = c.a(paramString, false, -1, null);
    AppMethodBeat.o(19432);
    return paramString;
  }
  
  public final Bitmap ga(String paramString)
  {
    AppMethodBeat.i(19434);
    if (this.dkv == null) {
      this.dkv = p.aYn();
    }
    paramString = com.tencent.mm.aj.e.Mk(paramString);
    AppMethodBeat.o(19434);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.e
 * JD-Core Version:    0.7.0.1
 */