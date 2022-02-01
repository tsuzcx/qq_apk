package com.tencent.mm.plugin.luckymoney.model;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;

final class s$5
  implements a.a
{
  s$5(AtomicInteger paramAtomicInteger, Handler.Callback paramCallback) {}
  
  public final void onComplete(boolean paramBoolean)
  {
    AppMethodBeat.i(163574);
    Log.d("MicroMsg.LuckyMoneyEnvelopePreview", "load ok : %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.KsS.incrementAndGet();
    Message localMessage = Message.obtain();
    localMessage.arg1 = this.KsS.get();
    this.KsT.handleMessage(localMessage);
    AppMethodBeat.o(163574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s.5
 * JD-Core Version:    0.7.0.1
 */