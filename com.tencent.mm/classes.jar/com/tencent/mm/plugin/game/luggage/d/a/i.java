package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.ui.widget.MMWebView;

public final class i
  extends a
{
  public i()
  {
    super(7);
  }
  
  public final void a(Context paramContext, g paramg, bzp parambzp)
  {
    AppMethodBeat.i(83114);
    if (paramg.getWebView() != null) {
      paramg.getWebView().reload();
    }
    AppMethodBeat.o(83114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.i
 * JD-Core Version:    0.7.0.1
 */