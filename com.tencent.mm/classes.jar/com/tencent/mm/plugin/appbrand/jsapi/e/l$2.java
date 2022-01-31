package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Message;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;

final class l$2
  extends c
{
  l$2(l paraml) {}
  
  public final void enter()
  {
    AppMethodBeat.i(93831);
    super.enter();
    ((a)e.q(a.class)).b("gcj02", this.hNo.hNj, this.hNo.fPG);
    if (this.hNo.hNk != null) {
      this.hNo.hNk.Cc("StateListening");
    }
    AppMethodBeat.o(93831);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(93832);
    super.exit();
    ((a)e.q(a.class)).c("gcj02", this.hNo.hNj, this.hNo.fPG);
    AppMethodBeat.o(93832);
  }
  
  public final String getName()
  {
    AppMethodBeat.i(93830);
    String str = this.hNo.mName + "$StateNotListening";
    AppMethodBeat.o(93830);
    return str;
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(93833);
    if (2 == paramMessage.what)
    {
      this.hNo.b(this.hNo.hNl);
      AppMethodBeat.o(93833);
      return true;
    }
    if (3 == paramMessage.what)
    {
      this.hNo.b(this.hNo.hNn);
      AppMethodBeat.o(93833);
      return true;
    }
    boolean bool = super.k(paramMessage);
    AppMethodBeat.o(93833);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.l.2
 * JD-Core Version:    0.7.0.1
 */