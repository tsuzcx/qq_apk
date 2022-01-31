package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$c
  extends h
{
  d$c(d paramd, i parami)
  {
    super(parami);
  }
  
  public final String getName()
  {
    AppMethodBeat.i(86850);
    AppMethodBeat.o(86850);
    return "|BackgroundKeepNoChange";
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(86851);
    switch (d.7.gYy[d.a.no(paramMessage.what).ordinal()])
    {
    default: 
      boolean bool = super.k(paramMessage);
      AppMethodBeat.o(86851);
      return bool;
    }
    d.a(this.gYv, this.gYv.gYm);
    AppMethodBeat.o(86851);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d.c
 * JD-Core Version:    0.7.0.1
 */