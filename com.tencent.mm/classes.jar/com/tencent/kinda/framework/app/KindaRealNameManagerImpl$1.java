package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.a.a;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;

class KindaRealNameManagerImpl$1
  implements a.a
{
  KindaRealNameManagerImpl$1(KindaRealNameManagerImpl paramKindaRealNameManagerImpl, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2) {}
  
  public void run(Activity paramActivity)
  {
    AppMethodBeat.i(144396);
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      this.val$successCallback.call();
      AppMethodBeat.o(144396);
      return;
    }
    this.val$cancelCallback.call();
    AppMethodBeat.o(144396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaRealNameManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */