package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.ui.widget.MMWebView;

public final class i
  extends a
{
  public i()
  {
    super(7);
  }
  
  public final void a(Context paramContext, f paramf, bug parambug)
  {
    AppMethodBeat.i(83114);
    if (paramf.getWebView() != null) {
      paramf.getWebView().reload();
    }
    AppMethodBeat.o(83114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.i
 * JD-Core Version:    0.7.0.1
 */