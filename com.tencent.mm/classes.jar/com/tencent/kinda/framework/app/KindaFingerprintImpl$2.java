package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.VoidBinaryI32Callback;
import com.tencent.kinda.gen.VoidBoolCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.protocal.protobuf.fw;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

class KindaFingerprintImpl$2
  implements Runnable
{
  KindaFingerprintImpl$2(KindaFingerprintImpl paramKindaFingerprintImpl, ma paramma, VoidBinaryI32Callback paramVoidBinaryI32Callback, VoidCallback paramVoidCallback, VoidBoolCallback paramVoidBoolCallback, VoidStringCallback paramVoidStringCallback) {}
  
  public void run()
  {
    AppMethodBeat.i(144354);
    ab.i(this.this$0.TAG, "hy: FingerPrintAuthEvent callback");
    Object localObject = this.val$fpevent.cCb;
    if (localObject == null)
    {
      ab.i(this.this$0.TAG, "hy: FingerPrintAuthEvent callback, result == null");
      AppMethodBeat.o(144354);
      return;
    }
    int i = ((ma.b)localObject).errCode;
    ab.v(this.this$0.TAG, "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), ((ma.b)localObject).errMsg });
    fw localfw;
    if (i == 0)
    {
      ab.i(this.this$0.TAG, "hy: payInfo soterAuthReq: %s", new Object[] { ((ma.b)localObject).cCf });
      localfw = new fw();
      localfw.wsh = true;
      localfw.cwl = ((ma.b)localObject).cwl;
      localfw.cwm = ((ma.b)localObject).cwm;
      localfw.wsi = ((ma.b)localObject).cCf;
      KindaFingerprintImpl localKindaFingerprintImpl = this.this$0;
      i = localKindaFingerprintImpl.identify_num + 1;
      localKindaFingerprintImpl.identify_num = i;
      localfw.utd = i;
    }
    try
    {
      this.val$success.call(localfw.toByteArray(), ((ma.b)localObject).cwj);
      label186:
      a.Fu(0);
      AppMethodBeat.o(144354);
      return;
      if (i == 1)
      {
        ab.i(this.this$0.TAG, "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        localObject = this.this$0;
        ((KindaFingerprintImpl)localObject).identify_num += 1;
        this.val$fail.call();
        a.Fu(1);
        AppMethodBeat.o(144354);
        return;
      }
      if ((i == 10308) || (i == 2) || (i == 1001))
      {
        ab.i(this.this$0.TAG, "hy: FingerPrintAuthEvent callback, auth | fail max | common err | pipeline exception, should change to pwd!");
        this.val$change2Pwd.call(true);
        a.Fu(2);
        AppMethodBeat.o(144354);
        return;
      }
      if (i == 2009)
      {
        ab.i(this.this$0.TAG, "hy: FingerPrintAuthEvent callback, task fail err, should show dialog then change to pwd!");
        this.val$showErrThenChange2Pwd.call(((ma.b)localObject).errMsg);
        AppMethodBeat.o(144354);
        return;
      }
      ab.i(this.this$0.TAG, "hy: FingerPrintAuthEvent callback, other err, should change to pwd!");
      this.val$change2Pwd.call(false);
      a.Fu(2);
      AppMethodBeat.o(144354);
      return;
    }
    catch (IOException localIOException)
    {
      break label186;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaFingerprintImpl.2
 * JD-Core Version:    0.7.0.1
 */