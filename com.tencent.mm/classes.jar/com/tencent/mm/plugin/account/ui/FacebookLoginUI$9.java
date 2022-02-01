package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;

final class FacebookLoginUI$9
  implements bn.a
{
  FacebookLoginUI$9(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(127992);
    if (parame == null)
    {
      AppMethodBeat.o(127992);
      return;
    }
    parame = parame.aBZ();
    g.agP();
    int i = a.getUin();
    parame.a(new byte[0], new byte[0], new byte[0], i);
    AppMethodBeat.o(127992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.9
 * JD-Core Version:    0.7.0.1
 */