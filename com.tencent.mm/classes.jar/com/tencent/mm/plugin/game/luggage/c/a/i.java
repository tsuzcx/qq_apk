package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.ui.widget.MMWebView;

public final class i
  extends a
{
  public i()
  {
    super(7);
  }
  
  public final void a(Context paramContext, e parame, bcz parambcz)
  {
    AppMethodBeat.i(135909);
    if (parame.getWebView() != null) {
      parame.getWebView().reload();
    }
    AppMethodBeat.o(135909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.i
 * JD-Core Version:    0.7.0.1
 */