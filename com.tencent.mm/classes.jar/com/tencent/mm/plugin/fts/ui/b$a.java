package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class b$a
{
  public static int txZ;
  
  static
  {
    AppMethodBeat.i(111810);
    txZ = 0;
    Context localContext = aj.getContext();
    txZ = a.ip(localContext) - a.ax(localContext, 2131165550) * 2 - a.ax(localContext, 2131165508) - a.ax(localContext, 2131165550);
    AppMethodBeat.o(111810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */