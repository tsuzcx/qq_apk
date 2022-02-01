package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b$a
{
  public static int wZP;
  
  static
  {
    AppMethodBeat.i(111810);
    wZP = 0;
    Context localContext = MMApplicationContext.getContext();
    wZP = a.jn(localContext) - a.aG(localContext, 2131165568) * 2 - a.aG(localContext, 2131165526) - a.aG(localContext, 2131165568);
    AppMethodBeat.o(111810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */