package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaRealNameManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class KindaRealNameManagerImpl
  implements KindaRealNameManager
{
  private final String KEY_PROCESS_ID = "process_id";
  private final String TAG = "KindaRealNameManagerImpl";
  
  public void startRealNameImpl(VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(144397);
    Object localObject = KindaContext.get();
    if (!(localObject instanceof MMActivity))
    {
      ab.e("KindaRealNameManagerImpl", "Fail to start KindaRealNameManagerImpl due to incompatible context(%s)", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(144397);
      return;
    }
    localObject = (MMActivity)localObject;
    ((MMActivity)localObject).getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.id_verify.a.class.hashCode());
    Bundle localBundle = new Bundle();
    localBundle.putString("realname_verify_process_jump_activity", ".id_verify.SwitchRealnameVerifyModeUI");
    localBundle.putString("realname_verify_process_jump_plugin", "wallet_core");
    localBundle.putInt("real_name_verify_mode", 0);
    localBundle.putInt("entry_scene", 2);
    localBundle.putBoolean("process_finish_stay_orgpage", false);
    localBundle.putBoolean("is_from_new_cashier", true);
    com.tencent.mm.wallet_core.a.a((Activity)localObject, com.tencent.mm.plugin.wallet_core.id_verify.a.class, localBundle, null);
    localObject = com.tencent.mm.wallet_core.a.aM((Activity)localObject);
    if (!(localObject instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      ab.e("KindaRealNameManagerImpl", "Fail to get correct wallet process in KindaRealNameManagerImpl, expect RealNameVerifyProcess got %s", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(144397);
      return;
    }
    ((com.tencent.mm.plugin.wallet_core.id_verify.a)localObject).ucu = new KindaRealNameManagerImpl.1(this, paramVoidCallback1, paramVoidCallback2);
    AppMethodBeat.o(144397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaRealNameManagerImpl
 * JD-Core Version:    0.7.0.1
 */