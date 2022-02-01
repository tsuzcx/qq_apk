package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaRealNameManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifySuccessUI;
import com.tencent.mm.plugin.wallet_core.id_verify.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.g;

public class KindaRealNameManagerImpl
  implements KindaRealNameManager
{
  private final String KEY_PROCESS_ID = "process_id";
  private final String TAG = "KindaRealNameManagerImpl";
  
  public void reportRealnameAction(int paramInt)
  {
    AppMethodBeat.i(264195);
    g.d(paramInt, Util.nowSecond(), 1012);
    AppMethodBeat.o(264195);
  }
  
  public void startRealNameImpl(final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18504);
    paramITransmitKvData = KindaContext.get();
    if (!(paramITransmitKvData instanceof MMActivity))
    {
      Log.e("KindaRealNameManagerImpl", "Fail to start KindaRealNameManagerImpl due to incompatible context(%s)", new Object[] { paramITransmitKvData.getClass().getName() });
      AppMethodBeat.o(18504);
      return;
    }
    paramITransmitKvData = (MMActivity)paramITransmitKvData;
    paramITransmitKvData.getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.id_verify.a.class.hashCode());
    Bundle localBundle = new Bundle();
    localBundle.putString("realname_verify_process_jump_activity", ".id_verify.SwitchRealnameVerifyModeUI");
    localBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
    localBundle.putInt("real_name_verify_mode", 0);
    localBundle.putInt("entry_scene", 2);
    localBundle.putBoolean("process_finish_stay_orgpage", false);
    localBundle.putBoolean("is_from_new_cashier", true);
    localBundle.putString("start_activity_class", paramITransmitKvData.getClass().getName());
    com.tencent.mm.wallet_core.a.a(paramITransmitKvData, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle, null);
    paramITransmitKvData = com.tencent.mm.wallet_core.a.bF(paramITransmitKvData);
    if (!(paramITransmitKvData instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      Log.e("KindaRealNameManagerImpl", "Fail to get correct wallet process in KindaRealNameManagerImpl, expect RealNameVerifyProcess got %s", new Object[] { paramITransmitKvData.getClass().getName() });
      AppMethodBeat.o(18504);
      return;
    }
    ((com.tencent.mm.plugin.wallet_core.id_verify.a)paramITransmitKvData).OIW = new a.a()
    {
      public void run(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(18503);
        if ((paramAnonymousActivity instanceof WcPayRealnameVerifySuccessUI))
        {
          paramVoidCallback1.call();
          AppMethodBeat.o(18503);
          return;
        }
        paramVoidCallback2.call();
        AppMethodBeat.o(18503);
      }
    };
    AppMethodBeat.o(18504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaRealNameManagerImpl
 * JD-Core Version:    0.7.0.1
 */