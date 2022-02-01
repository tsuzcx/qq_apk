package com.tencent.kinda.framework.app;

import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KRealNameService;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.i;

public class KindaRealNameServiceImpl
  implements KRealNameService
{
  private static final String TAG = "MicroMsg.KindaRealNameServiceImpl";
  
  public void checkRealnameLicenseImpl(int paramInt, final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2, final VoidCallback paramVoidCallback3, final VoidCallback paramVoidCallback4)
  {
    AppMethodBeat.i(18508);
    i locali = new i(KindaContext.get(), null);
    new a.a()
    {
      public void onRequesting()
      {
        AppMethodBeat.i(18506);
        paramVoidCallback3.call();
        AppMethodBeat.o(18506);
      }
      
      public void onResponsed()
      {
        AppMethodBeat.i(18507);
        paramVoidCallback4.call();
        AppMethodBeat.o(18507);
      }
      
      public boolean run(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(18505);
        if (paramAnonymousInt1 == 0) {
          if (paramAnonymousBoolean) {
            paramVoidCallback1.call();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(18505);
          return true;
          paramVoidCallback2.call();
          continue;
          Log.e("MicroMsg.KindaRealNameServiceImpl", "WalletGetDisclaimerCallback resultCode=%d,errMsg=%s,errcode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
          paramVoidCallback1.call();
        }
      }
    };
    paramVoidCallback1 = KindaContext.get();
    if ((paramVoidCallback1 instanceof MMActivity)) {}
    for (paramVoidCallback1 = (MMActivity)paramVoidCallback1;; paramVoidCallback1 = null)
    {
      u.iiw();
      u.b(paramVoidCallback1, locali, 1);
      AppMethodBeat.o(18508);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaRealNameServiceImpl
 * JD-Core Version:    0.7.0.1
 */