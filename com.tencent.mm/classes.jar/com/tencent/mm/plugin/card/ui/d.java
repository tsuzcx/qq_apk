package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.model.am;

public final class d
  implements a
{
  private c ksS;
  
  public d(c paramc)
  {
    this.ksS = paramc;
  }
  
  public final void aaK()
  {
    AppMethodBeat.i(88253);
    if (this.ksS != null) {
      this.ksS.a(null, null);
    }
    AppMethodBeat.o(88253);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(88251);
    if (this.ksS != null) {
      am.bcd().add(this.ksS);
    }
    AppMethodBeat.o(88251);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(88252);
    if (this.ksS != null)
    {
      am.bcd().remove(this.ksS);
      this.ksS.release();
      this.ksS = null;
    }
    AppMethodBeat.o(88252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.d
 * JD-Core Version:    0.7.0.1
 */