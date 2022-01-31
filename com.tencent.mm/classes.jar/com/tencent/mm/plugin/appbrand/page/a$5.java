package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.n.a;

final class a$5
  implements n.a
{
  a$5(a parama, String paramString1, String paramString2, long paramLong) {}
  
  private void ce(boolean paramBoolean)
  {
    AppMethodBeat.i(140864);
    this.iuH.a(this.val$name, this.cad, paramBoolean, this.dZo, System.currentTimeMillis());
    AppMethodBeat.o(140864);
  }
  
  public final void bU(String paramString)
  {
    AppMethodBeat.i(140863);
    ce(false);
    AppMethodBeat.o(140863);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(140862);
    ce(true);
    AppMethodBeat.o(140862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.5
 * JD-Core Version:    0.7.0.1
 */