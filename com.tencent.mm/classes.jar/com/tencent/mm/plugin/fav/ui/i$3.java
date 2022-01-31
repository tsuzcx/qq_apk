package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.al;

final class i$3
  implements Runnable
{
  i$3(aca paramaca, Context paramContext, String paramString, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(74120);
    if (this.mxT.dataType == 15) {
      i.a(this.val$context, this.bZZ, this.mxT);
    }
    for (;;)
    {
      al.d(this.bZt);
      AppMethodBeat.o(74120);
      return;
      i.b(this.val$context, this.bZZ, this.mxT);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(74121);
    String str = super.toString() + "|sendFavVideo";
    AppMethodBeat.o(74121);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i.3
 * JD-Core Version:    0.7.0.1
 */