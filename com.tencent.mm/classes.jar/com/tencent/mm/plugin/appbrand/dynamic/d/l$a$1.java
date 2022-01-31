package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.modelappbrand.t;

final class l$a$1
  implements t
{
  l$a$1(l.a parama, Bundle paramBundle, c paramc) {}
  
  public final void b(boolean paramBoolean, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(10854);
    this.hoP.putBoolean("ret", paramBoolean);
    this.hoP.putString("reason", paramString);
    this.hoP.putBundle("data", paramBundle);
    this.eEg.ad(this.hoP);
    AppMethodBeat.o(10854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.l.a.1
 * JD-Core Version:    0.7.0.1
 */