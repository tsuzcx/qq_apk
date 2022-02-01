package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class b$a
{
  public static int rsE;
  
  static
  {
    AppMethodBeat.i(111810);
    rsE = 0;
    Context localContext = aj.getContext();
    rsE = a.hV(localContext) - a.ao(localContext, 2131165550) * 2 - a.ao(localContext, 2131165508) - a.ao(localContext, 2131165550);
    AppMethodBeat.o(111810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */