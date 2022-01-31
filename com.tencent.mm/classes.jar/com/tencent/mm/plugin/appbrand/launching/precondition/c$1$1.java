package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(132057);
    ab.i("MicroMsg.AppBrand.Precondition.FromClientPreconditionProcess", "finish(), before send result, ui finishing %b, ui destroyed %b", new Object[] { Boolean.valueOf(this.inX.inW.isFinishing()), Boolean.valueOf(this.inX.inW.aHv()) });
    ResultReceiver localResultReceiver = (ResultReceiver)c.a(this.inX.inW).getParcelableExtra("extra_result_receiver");
    if (localResultReceiver != null) {
      localResultReceiver.send(-1, Bundle.EMPTY);
    }
    c.b(this.inX.inW);
    AppMethodBeat.o(132057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.c.1.1
 * JD-Core Version:    0.7.0.1
 */