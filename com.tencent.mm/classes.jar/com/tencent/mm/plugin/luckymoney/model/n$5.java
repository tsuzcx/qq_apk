package com.tencent.mm.plugin.luckymoney.model;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.atomic.AtomicInteger;

final class n$5
  implements a.a
{
  n$5(AtomicInteger paramAtomicInteger, Handler.Callback paramCallback) {}
  
  public final void ib(boolean paramBoolean)
  {
    AppMethodBeat.i(163574);
    ad.d("MicroMsg.LuckyMoneyEnvelopePreview", "load ok : %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tef.incrementAndGet();
    Message localMessage = Message.obtain();
    localMessage.arg1 = this.tef.get();
    this.teg.handleMessage(localMessage);
    AppMethodBeat.o(163574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.n.5
 * JD-Core Version:    0.7.0.1
 */