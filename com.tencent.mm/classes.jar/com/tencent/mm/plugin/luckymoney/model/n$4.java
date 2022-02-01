package com.tencent.mm.plugin.luckymoney.model;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.atomic.AtomicInteger;

final class n$4
  implements a.a
{
  n$4(AtomicInteger paramAtomicInteger, Handler.Callback paramCallback) {}
  
  public final void iB(boolean paramBoolean)
  {
    AppMethodBeat.i(163573);
    ac.d("MicroMsg.LuckyMoneyEnvelopePreview", "load ok : %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.umu.incrementAndGet();
    Message localMessage = Message.obtain();
    localMessage.arg1 = this.umu.get();
    this.umv.handleMessage(localMessage);
    AppMethodBeat.o(163573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.n.4
 * JD-Core Version:    0.7.0.1
 */