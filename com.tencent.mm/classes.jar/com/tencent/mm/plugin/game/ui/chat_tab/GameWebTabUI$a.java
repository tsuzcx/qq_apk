package com.tencent.mm.plugin.game.ui.chat_tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.gamelife.e.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

class GameWebTabUI$a
  implements b<IPCInteger, IPCInteger>
{
  private k.a utD;
  private d<IPCInteger> uup;
  
  private GameWebTabUI$a()
  {
    AppMethodBeat.i(206938);
    this.utD = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(206937);
        if (((paramAnonymousm.obj instanceof a)) && (GameWebTabUI.a.a(GameWebTabUI.a.this) != null))
        {
          int i = ((c)g.ab(c.class)).daD();
          GameWebTabUI.a.a(GameWebTabUI.a.this).be(new IPCInteger(i));
        }
        AppMethodBeat.o(206937);
      }
    };
    AppMethodBeat.o(206938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.a
 * JD-Core Version:    0.7.0.1
 */