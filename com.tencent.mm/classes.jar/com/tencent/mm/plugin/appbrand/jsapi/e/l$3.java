package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;

final class l$3
  extends c
{
  l$3(l paraml) {}
  
  public final void enter()
  {
    AppMethodBeat.i(93836);
    super.enter();
    if (this.hNo.hNk != null) {
      this.hNo.hNk.Cc("StateSuspend");
    }
    AppMethodBeat.o(93836);
  }
  
  public final String getName()
  {
    AppMethodBeat.i(93834);
    String str = this.hNo.mName + "$StateSuspend";
    AppMethodBeat.o(93834);
    return str;
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(93835);
    if (2 == paramMessage.what)
    {
      this.hNo.b(this.hNo.hNl);
      AppMethodBeat.o(93835);
      return true;
    }
    if (4 == paramMessage.what)
    {
      this.hNo.b(this.hNo.hNm);
      AppMethodBeat.o(93835);
      return true;
    }
    boolean bool = super.k(paramMessage);
    AppMethodBeat.o(93835);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.l.3
 * JD-Core Version:    0.7.0.1
 */