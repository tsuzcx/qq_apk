package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity.a;

final class a$3
  implements MMActivity.a
{
  a$3(a parama, b.a parama1) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131403);
    if (paramInt1 != (this.hWm.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(131403);
      return;
    }
    if (paramInt2 == -1)
    {
      if (this.hWl != null)
      {
        this.hWl.a(1, null, null);
        AppMethodBeat.o(131403);
      }
    }
    else if (this.hWl != null) {
      this.hWl.a(2, null, null);
    }
    AppMethodBeat.o(131403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a.3
 * JD-Core Version:    0.7.0.1
 */