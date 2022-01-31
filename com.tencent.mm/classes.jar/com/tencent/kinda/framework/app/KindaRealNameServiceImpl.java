package com.tencent.kinda.framework.app;

import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KRealNameService;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;

public class KindaRealNameServiceImpl
  implements KRealNameService
{
  private static final String TAG = "MicroMsg.KindaRealNameServiceImpl";
  
  public void checkRealnameLicenseImpl(int paramInt, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2, VoidCallback paramVoidCallback3, VoidCallback paramVoidCallback4)
  {
    AppMethodBeat.i(144401);
    i locali = new i(KindaContext.get(), null);
    new KindaRealNameServiceImpl.1(this, paramVoidCallback1, paramVoidCallback2, paramVoidCallback3, paramVoidCallback4);
    paramVoidCallback1 = KindaContext.get();
    if ((paramVoidCallback1 instanceof MMActivity)) {}
    for (paramVoidCallback1 = (MMActivity)paramVoidCallback1;; paramVoidCallback1 = null)
    {
      t.cTI();
      t.b(paramVoidCallback1, locali, 1);
      AppMethodBeat.o(144401);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaRealNameServiceImpl
 * JD-Core Version:    0.7.0.1
 */