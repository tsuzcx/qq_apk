package com.tencent.mm.app;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class g
  implements j.a
{
  private volatile Bitmap hfN = null;
  AvatarStorage hfO;
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(19431);
    if ((paramj instanceof AvatarStorage.a)) {
      q.bFp().a((AvatarStorage.a)paramj);
    }
    AppMethodBeat.o(19431);
  }
  
  public final Bitmap aCj()
  {
    AppMethodBeat.i(19433);
    if (this.hfN == null) {}
    try
    {
      if (this.hfN == null) {
        this.hfN = a.decodeResource(MMApplicationContext.getContext().getResources(), R.k.default_avatar);
      }
      Bitmap localBitmap = this.hfN;
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
  
  public final Bitmap ik(String paramString)
  {
    AppMethodBeat.i(19434);
    if (this.hfO == null) {
      this.hfO = q.bFp();
    }
    paramString = AvatarStorage.LH(paramString);
    AppMethodBeat.o(19434);
    return paramString;
  }
  
  public final Bitmap loadBitmap(String paramString)
  {
    AppMethodBeat.i(19432);
    paramString = d.a(paramString, false, -1, null);
    AppMethodBeat.o(19432);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.g
 * JD-Core Version:    0.7.0.1
 */