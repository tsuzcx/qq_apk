package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.VoidBoolCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.sdk.b.c;

class KindaFingerprintImpl$1
  extends c<jc>
{
  KindaFingerprintImpl$1(KindaFingerprintImpl paramKindaFingerprintImpl)
  {
    AppMethodBeat.i(144351);
    this.__eventId = jc.class.getName().hashCode();
    AppMethodBeat.o(144351);
  }
  
  public boolean callback(jc paramjc)
  {
    AppMethodBeat.i(144352);
    if ((paramjc != null) && (KindaFingerprintImpl.access$000(this.this$0) != null)) {
      KindaFingerprintImpl.access$000(this.this$0).call(false);
    }
    AppMethodBeat.o(144352);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaFingerprintImpl.1
 * JD-Core Version:    0.7.0.1
 */