package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaRealNameManager;
import com.tencent.kinda.gen.VoidBoolCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifySuccessUI;
import com.tencent.mm.plugin.wallet_core.id_verify.a.a;
import com.tencent.mm.plugin.wallet_core.ui.w;
import com.tencent.mm.plugin.wallet_core.ui.w.a;
import com.tencent.mm.plugin.wallet_core.ui.w.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.i;

public class KindaRealNameManagerImpl
  implements KindaRealNameManager
{
  public static final int REQUEST_CODE_AGREEMENTS = 911;
  private final String KEY_PROCESS_ID;
  private final String TAG;
  private w mPrivacyDutyHelper;
  private final IListener privacyDutyIListener;
  
  public KindaRealNameManagerImpl()
  {
    AppMethodBeat.i(226360);
    this.TAG = "KindaRealNameManagerImpl";
    this.KEY_PROCESS_ID = "process_id";
    this.privacyDutyIListener = new KindaRealNameManagerImpl.1(this, f.hfK);
    AppMethodBeat.o(226360);
  }
  
  private void resetPrivacyDutyHelper()
  {
    AppMethodBeat.i(226363);
    if (this.mPrivacyDutyHelper != null)
    {
      this.mPrivacyDutyHelper.hBY = false;
      this.mPrivacyDutyHelper.onPause();
      this.mPrivacyDutyHelper = null;
      this.privacyDutyIListener.dead();
    }
    AppMethodBeat.o(226363);
  }
  
  public void callPrivacyDutyPageImpl(final VoidBoolCallback paramVoidBoolCallback)
  {
    AppMethodBeat.i(226371);
    Log.i("KindaRealNameManagerImpl", "callPrivacyDutyPageImpl");
    final Context localContext = KindaContext.get();
    if (!(localContext instanceof MMActivity))
    {
      Log.e("KindaRealNameManagerImpl", "Fail to start callPrivacyDutyPageImpl due to incompatible context(%s)", new Object[] { localContext.getClass().getName() });
      paramVoidBoolCallback.call(false);
      AppMethodBeat.o(226371);
      return;
    }
    this.mPrivacyDutyHelper = new w();
    this.mPrivacyDutyHelper.VTP = new w.b()
    {
      public Context getContext()
      {
        return localContext;
      }
      
      public int getShowAgreenRequestCode()
      {
        return 911;
      }
    };
    this.mPrivacyDutyHelper.onResume();
    this.mPrivacyDutyHelper.VTO = true;
    this.mPrivacyDutyHelper.a(new w.a()
    {
      public void agree()
      {
        AppMethodBeat.i(226377);
        paramVoidBoolCallback.call(true);
        KindaRealNameManagerImpl.access$100(KindaRealNameManagerImpl.this);
        AppMethodBeat.o(226377);
      }
      
      public void cancel()
      {
        AppMethodBeat.i(226379);
        paramVoidBoolCallback.call(false);
        KindaRealNameManagerImpl.access$100(KindaRealNameManagerImpl.this);
        AppMethodBeat.o(226379);
      }
      
      public void nothing()
      {
        AppMethodBeat.i(226381);
        paramVoidBoolCallback.call(true);
        KindaRealNameManagerImpl.access$100(KindaRealNameManagerImpl.this);
        AppMethodBeat.o(226381);
      }
    }, true);
    this.privacyDutyIListener.alive();
    AppMethodBeat.o(226371);
  }
  
  public void reportRealnameAction(int paramInt)
  {
    AppMethodBeat.i(226368);
    i.f(paramInt, Util.nowSecond(), 1012);
    AppMethodBeat.o(226368);
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
    paramITransmitKvData = com.tencent.mm.wallet_core.a.cm(paramITransmitKvData);
    if (!(paramITransmitKvData instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      Log.e("KindaRealNameManagerImpl", "Fail to get correct wallet process in KindaRealNameManagerImpl, expect RealNameVerifyProcess got %s", new Object[] { paramITransmitKvData.getClass().getName() });
      AppMethodBeat.o(18504);
      return;
    }
    ((com.tencent.mm.plugin.wallet_core.id_verify.a)paramITransmitKvData).VyI = new a.a()
    {
      public void run(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(226374);
        if ((paramAnonymousActivity instanceof WcPayRealnameVerifySuccessUI))
        {
          paramVoidCallback1.call();
          AppMethodBeat.o(226374);
          return;
        }
        paramVoidCallback2.call();
        AppMethodBeat.o(226374);
      }
    };
    AppMethodBeat.o(18504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaRealNameManagerImpl
 * JD-Core Version:    0.7.0.1
 */