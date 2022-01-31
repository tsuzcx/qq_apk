package com.tencent.mm.plugin.game.luggage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.f;
import com.tencent.luggage.d.f.a;
import com.tencent.luggage.d.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.c;

final class LuggageGameWebViewUI$2
  implements Runnable
{
  LuggageGameWebViewUI$2(LuggageGameWebViewUI paramLuggageGameWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(135810);
    if ((this.njn.isFinishing()) || (this.njn.activityHasDestroyed()))
    {
      AppMethodBeat.o(135810);
      return;
    }
    c localc = LuggageGameWebViewUI.c(this.njn);
    String str = this.gjT;
    Bundle localBundle = this.njn.getIntent().getExtras();
    e locale = localc.byS.j(str, localBundle);
    localc.byO.addView(locale.getContentView(), 0);
    localc.byP.add(locale);
    locale.g(str, localBundle);
    locale.ub();
    localc.uh();
    AppMethodBeat.o(135810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */