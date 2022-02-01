package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ak;

public final class b$a
{
  public static int tIQ;
  
  static
  {
    AppMethodBeat.i(111810);
    tIQ = 0;
    Context localContext = ak.getContext();
    tIQ = a.iu(localContext) - a.ax(localContext, 2131165550) * 2 - a.ax(localContext, 2131165508) - a.ax(localContext, 2131165550);
    AppMethodBeat.o(111810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */