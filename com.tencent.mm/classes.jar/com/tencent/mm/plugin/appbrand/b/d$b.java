package com.tencent.mm.plugin.appbrand.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$b
  extends g
{
  d$b(d paramd, i parami, com.tencent.mm.plugin.appbrand.i parami1)
  {
    super(parami, parami1);
  }
  
  final void aws()
  {
    AppMethodBeat.i(86849);
    if (this.gYv.dui() == this)
    {
      d.a(this.gYv, this.gYv.gYp);
      this.gYv.a(d.a.gYG);
    }
    AppMethodBeat.o(86849);
  }
  
  public final void enter()
  {
    AppMethodBeat.i(86847);
    super.enter();
    AppMethodBeat.o(86847);
  }
  
  public final void exit()
  {
    AppMethodBeat.i(86848);
    super.exit();
    AppMethodBeat.o(86848);
  }
  
  public final String getName()
  {
    AppMethodBeat.i(86845);
    AppMethodBeat.o(86845);
    return "|Background";
  }
  
  public final boolean k(Message paramMessage)
  {
    AppMethodBeat.i(86846);
    switch (d.7.gYy[d.a.no(paramMessage.what).ordinal()])
    {
    default: 
      boolean bool = super.k(paramMessage);
      AppMethodBeat.o(86846);
      return bool;
    case 4: 
      d.a(this.gYv, this.gYv.gYm);
      AppMethodBeat.o(86846);
      return true;
    }
    super.np(16);
    AppMethodBeat.o(86846);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d.b
 * JD-Core Version:    0.7.0.1
 */