package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.ui.widget.MMWebView;

public final class i
  extends a
{
  public i()
  {
    super(7);
  }
  
  public final void a(Context paramContext, g paramg, coq paramcoq)
  {
    AppMethodBeat.i(83114);
    if (paramg.ITd != null) {
      paramg.ITd.reload();
    }
    AppMethodBeat.o(83114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.i
 * JD-Core Version:    0.7.0.1
 */