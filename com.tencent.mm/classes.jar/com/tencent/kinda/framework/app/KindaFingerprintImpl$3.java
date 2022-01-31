package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.VoidBinaryI32Callback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.faceid.auth.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.fw;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

class KindaFingerprintImpl$3
  implements a
{
  KindaFingerprintImpl$3(KindaFingerprintImpl paramKindaFingerprintImpl, VoidBinaryI32Callback paramVoidBinaryI32Callback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2) {}
  
  public void onAuthCancel()
  {
    AppMethodBeat.i(144357);
    ab.i(this.this$0.TAG, "face id auth cancel");
    if (this.val$cancel != null) {
      this.val$cancel.call();
    }
    AppMethodBeat.o(144357);
  }
  
  public void onAuthFail(int paramInt)
  {
    AppMethodBeat.i(144356);
    ab.i(this.this$0.TAG, "face id auth fail: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.this$0.identify_num) });
    if (this.val$fail != null) {
      this.val$fail.call();
    }
    KindaFingerprintImpl localKindaFingerprintImpl = this.this$0;
    localKindaFingerprintImpl.identify_num += 1;
    AppMethodBeat.o(144356);
  }
  
  public void onAuthSuccess(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144355);
    ab.i(this.this$0.TAG, "face id auth success");
    fw localfw = new fw();
    localfw.wsh = true;
    localfw.cwl = "";
    localfw.cwm = "";
    localfw.wsi = ((l)g.E(l.class)).byW();
    KindaFingerprintImpl localKindaFingerprintImpl = this.this$0;
    paramInt2 = localKindaFingerprintImpl.identify_num + 1;
    localKindaFingerprintImpl.identify_num = paramInt2;
    localfw.utd = paramInt2;
    try
    {
      this.val$success.call(localfw.toByteArray(), paramInt1);
      AppMethodBeat.o(144355);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(144355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaFingerprintImpl.3
 * JD-Core Version:    0.7.0.1
 */