package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aca;

final class l$7
  implements Runnable
{
  l$7(boolean paramBoolean, String paramString, g paramg, aca paramaca) {}
  
  public final void run()
  {
    AppMethodBeat.i(74199);
    if ((this.myB) || (l.dA(this.fXK))) {
      b.a(this.msL, this.mxT, this.myB);
    }
    AppMethodBeat.o(74199);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(74200);
    String str = super.toString() + "|reDownload";
    AppMethodBeat.o(74200);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.l.7
 * JD-Core Version:    0.7.0.1
 */