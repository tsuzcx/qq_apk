package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class b$a
{
  public static int mVP;
  
  static
  {
    AppMethodBeat.i(61717);
    mVP = 0;
    Context localContext = ah.getContext();
    mVP = a.gw(localContext) - a.ao(localContext, 2131427836) * 2 - a.ao(localContext, 2131427800) - a.ao(localContext, 2131427836);
    AppMethodBeat.o(61717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */