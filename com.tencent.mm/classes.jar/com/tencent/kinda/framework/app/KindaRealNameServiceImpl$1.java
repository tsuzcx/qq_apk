package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.ab;

class KindaRealNameServiceImpl$1
  implements a.a
{
  KindaRealNameServiceImpl$1(KindaRealNameServiceImpl paramKindaRealNameServiceImpl, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2, VoidCallback paramVoidCallback3, VoidCallback paramVoidCallback4) {}
  
  public void onRequesting()
  {
    AppMethodBeat.i(144399);
    this.val$requestingCallback.call();
    AppMethodBeat.o(144399);
  }
  
  public void onResponsed()
  {
    AppMethodBeat.i(144400);
    this.val$responsedCallback.call();
    AppMethodBeat.o(144400);
  }
  
  public boolean run(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(144398);
    if (paramInt1 == 0) {
      if (paramBoolean) {
        this.val$acceptCallback.call();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(144398);
      return true;
      this.val$denyCallback.call();
      continue;
      ab.e("MicroMsg.KindaRealNameServiceImpl", "WalletGetDisclaimerCallback resultCode=%d,errMsg=%s,errcode=%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
      this.val$acceptCallback.call();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaRealNameServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */