package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aca;

final class l$4
  implements Runnable
{
  l$4(boolean paramBoolean, String paramString, g paramg, aca paramaca) {}
  
  public final void run()
  {
    AppMethodBeat.i(74193);
    if ((this.myB) || (l.dA(this.fXK))) {
      b.a(this.msL, this.mxT, this.myB);
    }
    AppMethodBeat.o(74193);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(74194);
    String str = super.toString() + "|getBigImg";
    AppMethodBeat.o(74194);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l.4
 * JD-Core Version:    0.7.0.1
 */