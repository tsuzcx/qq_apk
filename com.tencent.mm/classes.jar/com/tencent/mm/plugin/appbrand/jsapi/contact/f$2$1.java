package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity.a;

final class f$2$1
  implements MMActivity.a
{
  f$2$1(f.2 param2) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131020);
    if (paramInt1 == 1)
    {
      if (this.hKS.hKR != null) {
        this.hKS.hKR.a(true, "ok", paramIntent);
      }
      this.hKS.hKI.aBk();
    }
    AppMethodBeat.o(131020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.f.2.1
 * JD-Core Version:    0.7.0.1
 */