package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.al;

final class i$4
  implements Runnable
{
  i$4(String paramString, g paramg, aca paramaca, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(74122);
    i.a(this.bZZ, this.msL, this.mxT);
    al.d(this.bZt);
    AppMethodBeat.o(74122);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(74123);
    String str = super.toString() + "|sendFavFile";
    AppMethodBeat.o(74123);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i.4
 * JD-Core Version:    0.7.0.1
 */