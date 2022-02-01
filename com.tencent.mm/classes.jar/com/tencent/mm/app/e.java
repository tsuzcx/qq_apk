package com.tencent.mm.app;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.am.d;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class e
  implements j.a
{
  private volatile Bitmap fcd = null;
  f fce;
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(19431);
    if ((paramj instanceof f.a)) {
      q.bhz().a((f.a)paramj);
    }
    AppMethodBeat.o(19431);
  }
  
  public final Bitmap aaC()
  {
    AppMethodBeat.i(19433);
    if (this.fcd == null) {}
    try
    {
      if (this.fcd == null) {
        this.fcd = a.decodeResource(MMApplicationContext.getContext().getResources(), R.k.default_avatar);
      }
      Bitmap localBitmap = this.fcd;
      AppMethodBeat.o(19433);
      return localBitmap;
    }
    finally
    {
      AppMethodBeat.o(19433);
    }
  }
  
  public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(19435);
    paramString = d.f(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(19435);
    return paramString;
  }
  
  public final Bitmap gJ(String paramString)
  {
    AppMethodBeat.i(19432);
    paramString = d.a(paramString, false, -1, null);
    AppMethodBeat.o(19432);
    return paramString;
  }
  
  public final Bitmap gK(String paramString)
  {
    AppMethodBeat.i(19434);
    if (this.fce == null) {
      this.fce = q.bhz();
    }
    paramString = f.TF(paramString);
    AppMethodBeat.o(19434);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.e
 * JD-Core Version:    0.7.0.1
 */