package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.modelappbrand.t;

final class h$a$1
  implements t
{
  h$a$1(h.a parama, Bundle paramBundle, c paramc) {}
  
  public final void b(boolean paramBoolean, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(10840);
    this.hoP.putBoolean("ret", paramBoolean);
    this.hoP.putString("reason", paramString);
    this.hoP.putBundle("data", paramBundle);
    this.eEg.ad(this.hoP);
    AppMethodBeat.o(10840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.h.a.1
 * JD-Core Version:    0.7.0.1
 */