package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity.a;

final class a$4
  implements MMActivity.a
{
  a$4(a parama, b.a parama1) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131404);
    if (paramInt1 != (this.hWm.hashCode() & 0xFFFF))
    {
      AppMethodBeat.o(131404);
      return;
    }
    if (paramInt2 == -1)
    {
      if (this.hWl != null) {
        this.hWl.a(1, null, null);
      }
      AppMethodBeat.o(131404);
      return;
    }
    if (paramInt2 == 2)
    {
      if (this.hWl != null) {
        if (paramIntent == null) {
          break label96;
        }
      }
      label96:
      for (paramIntent = paramIntent.getStringExtra("key_result_errmsg");; paramIntent = "")
      {
        this.hWl.a(2, paramIntent, null);
        AppMethodBeat.o(131404);
        return;
      }
    }
    if (this.hWl != null) {
      this.hWl.a(3, null, null);
    }
    AppMethodBeat.o(131404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a.4
 * JD-Core Version:    0.7.0.1
 */