package com.tencent.kinda.framework.app;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pwd.a.a;

class KindaPasswordManagerImpl$1
  implements a.a
{
  KindaPasswordManagerImpl$1(KindaPasswordManagerImpl paramKindaPasswordManagerImpl, Context paramContext, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2) {}
  
  public void run(int paramInt)
  {
    AppMethodBeat.i(144374);
    KindaContext.popToContext(this.val$context);
    if (paramInt == 0)
    {
      this.val$successCallback.call();
      AppMethodBeat.o(144374);
      return;
    }
    this.val$cancelCallback.call();
    AppMethodBeat.o(144374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaPasswordManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */