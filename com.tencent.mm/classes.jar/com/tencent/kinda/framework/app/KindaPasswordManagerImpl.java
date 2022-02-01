package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaPasswordManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pwd.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class KindaPasswordManagerImpl
  implements KindaPasswordManager
{
  private final String KEY_PROCESS_ID = "process_id";
  private final String TAG = "KindaPasswordManagerImpl";
  
  public void startResetPasswordImpl(final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2, boolean paramBoolean)
  {
    AppMethodBeat.i(18459);
    final Context localContext = KindaContext.get();
    if (!(localContext instanceof MMActivity))
    {
      if (localContext.getClass() != null) {
        Log.e("KindaPasswordManagerImpl", "Fail to start ResetPasswordImpl due to incompatible context(%s)", new Object[] { localContext.getClass().getName() });
      }
      AppMethodBeat.o(18459);
      return;
    }
    Object localObject = (MMActivity)localContext;
    ((MMActivity)localObject).getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet.pwd.a.class.hashCode());
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isFromKinda", true);
    localBundle.putBoolean("isDomesticUser", paramBoolean);
    com.tencent.mm.wallet_core.a.a((Activity)localObject, com.tencent.mm.plugin.wallet.pwd.a.class, localBundle, null);
    localObject = com.tencent.mm.wallet_core.a.by((Activity)localObject);
    if (!(localObject instanceof com.tencent.mm.plugin.wallet.pwd.a))
    {
      Log.e("KindaPasswordManagerImpl", "Fail to get correct wallet process in ResetPasswordImpl, expect ForgotPwdProcess got %s", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(18459);
      return;
    }
    ((com.tencent.mm.plugin.wallet.pwd.a)localObject).HHO = new a.a()
    {
      public void run(int paramAnonymousInt)
      {
        AppMethodBeat.i(18458);
        KindaContext.popToContext(localContext);
        if (paramAnonymousInt == 0)
        {
          paramVoidCallback1.call();
          AppMethodBeat.o(18458);
          return;
        }
        paramVoidCallback2.call();
        AppMethodBeat.o(18458);
      }
    };
    AppMethodBeat.o(18459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaPasswordManagerImpl
 * JD-Core Version:    0.7.0.1
 */