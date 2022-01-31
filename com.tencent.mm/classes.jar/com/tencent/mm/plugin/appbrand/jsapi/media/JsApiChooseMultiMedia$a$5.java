package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

final class JsApiChooseMultiMedia$a$5
  implements d.b
{
  JsApiChooseMultiMedia$a$5(CountDownLatch paramCountDownLatch) {}
  
  public final void mP(String paramString)
  {
    AppMethodBeat.i(131234);
    ab.d("MicroMsg.JsApiChooseMultiMedia", "remux onFinish.");
    this.val$latch.countDown();
    AppMethodBeat.o(131234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.a.5
 * JD-Core Version:    0.7.0.1
 */