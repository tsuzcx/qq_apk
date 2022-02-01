package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b$a
{
  public static int HwK;
  
  static
  {
    AppMethodBeat.i(111810);
    HwK = 0;
    Context localContext = MMApplicationContext.getContext();
    HwK = a.ms(localContext) - a.br(localContext, p.b.SearchLargePadding) * 2 - a.br(localContext, p.b.NormalAvatarSize) - a.br(localContext, p.b.SearchLargePadding);
    AppMethodBeat.o(111810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */