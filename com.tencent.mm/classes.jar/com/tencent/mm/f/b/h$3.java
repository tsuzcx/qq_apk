package com.tencent.mm.f.b;

import com.tencent.mm.ah.j.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.y;

final class h$3
  implements j.a
{
  h$3(h paramh) {}
  
  public final void onError()
  {
    h.i(this.bDP).zE();
    y.e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + h.a(this.bDP));
    q.oC(h.a(this.bDP));
    if (this.bDP.bDL != null) {
      this.bDP.bDL.onError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.h.3
 * JD-Core Version:    0.7.0.1
 */