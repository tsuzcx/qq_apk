package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.VoidBoolCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.sdk.b.c;

class KindaFingerprintImpl$1
  extends c<ki>
{
  KindaFingerprintImpl$1(KindaFingerprintImpl paramKindaFingerprintImpl)
  {
    AppMethodBeat.i(160755);
    this.__eventId = ki.class.getName().hashCode();
    AppMethodBeat.o(160755);
  }
  
  public boolean callback(ki paramki)
  {
    AppMethodBeat.i(18426);
    if ((paramki != null) && (KindaFingerprintImpl.access$000(this.this$0) != null)) {
      KindaFingerprintImpl.access$000(this.this$0).call(false);
    }
    AppMethodBeat.o(18426);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaFingerprintImpl.1
 * JD-Core Version:    0.7.0.1
 */