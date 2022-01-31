package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mm.sdk.platformtools.y;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1) {}
  
  public final void run()
  {
    y.i("MicroMsg.AppBrand.Precondition.FromClientPreconditionProcess", "finish(), before send result, ui finishing %b, ui destroyed %b", new Object[] { Boolean.valueOf(this.gMA.gMz.isFinishing()), Boolean.valueOf(this.gMA.gMz.amb()) });
    ResultReceiver localResultReceiver = (ResultReceiver)d.a(this.gMA.gMz).getParcelableExtra("extra_result_receiver");
    if (localResultReceiver != null) {
      localResultReceiver.send(-1, Bundle.EMPTY);
    }
    d.b(this.gMA.gMz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.d.1.1
 * JD-Core Version:    0.7.0.1
 */