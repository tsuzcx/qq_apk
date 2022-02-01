package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b$a
{
  public static int BLO;
  
  static
  {
    AppMethodBeat.i(111810);
    BLO = 0;
    Context localContext = MMApplicationContext.getContext();
    BLO = a.kr(localContext) - a.aY(localContext, o.b.SearchLargePadding) * 2 - a.aY(localContext, o.b.NormalAvatarSize) - a.aY(localContext, o.b.SearchLargePadding);
    AppMethodBeat.o(111810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */