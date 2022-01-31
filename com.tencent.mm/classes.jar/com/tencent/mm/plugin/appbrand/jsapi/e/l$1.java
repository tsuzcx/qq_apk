package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Message;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;

final class l$1
  extends c
{
  l$1(l paraml) {}
  
  public final void enter()
  {
    AppMethodBeat.i(93829);
    super.enter();
    ((a)e.q(a.class)).c("gcj02", this.hNo.hNj, this.hNo.fPG);
    if (this.hNo.hNk != null) {
      this.hNo.hNk.Cc("StateNotListening");
    }
    AppMethodBeat.o(93829);
  }
  
  public final String getName()
  {
    AppMethodBeat.i(93827);
    String str = this.hNo.mName + "$StateListening";
    AppMethodBeat.o(93827);
    return str;
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(93828);
    if (1 == paramMessage.what)
    {
      this.hNo.b(this.hNo.hNm);
      AppMethodBeat.o(93828);
      return true;
    }
    boolean bool = super.k(paramMessage);
    AppMethodBeat.o(93828);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.l.1
 * JD-Core Version:    0.7.0.1
 */