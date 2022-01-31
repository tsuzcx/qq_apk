package com.tencent.mm.plugin.bottle.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.ui.base.p;

final class BottleConversationUI$2$2
  implements bf.a
{
  BottleConversationUI$2$2(BottleConversationUI.2 param2) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(18555);
    boolean bool = BottleConversationUI.f(this.jSp.jSo);
    AppMethodBeat.o(18555);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(18556);
    if (BottleConversationUI.g(this.jSp.jSo) != null)
    {
      BottleConversationUI.g(this.jSp.jSo).dismiss();
      BottleConversationUI.a(this.jSp.jSo, null);
    }
    AppMethodBeat.o(18556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.2.2
 * JD-Core Version:    0.7.0.1
 */