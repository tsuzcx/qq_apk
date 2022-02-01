package com.tencent.kinda.framework.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaOpenBiometricVerifyManager;
import com.tencent.kinda.gen.SelectBioType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public class KindaOpenBiometricVerifyManagerImpl
  implements KindaOpenBiometricVerifyManager
{
  private static final String TAG = "KindaOpenBiometricVerifyManagerImpl";
  
  public void openBiometricVerify(String paramString, boolean paramBoolean, SelectBioType paramSelectBioType)
  {
    AppMethodBeat.i(18457);
    Object localObject = KindaContext.get();
    if (localObject == null)
    {
      ad.e("KindaOpenBiometricVerifyManagerImpl", "Fail to start KindaOpenBiometricVerifyManagerImpl due to context is null!");
      AppMethodBeat.o(18457);
      return;
    }
    if (!(localObject instanceof MMActivity))
    {
      ad.e("KindaOpenBiometricVerifyManagerImpl", "Fail to start KindaOpenBiometricVerifyManagerImpl due to incompatible context(%s)", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(18457);
      return;
    }
    localObject = (MMActivity)localObject;
    ((MMActivity)localObject).getIntent().putExtra("isFromKinda", true);
    ((MMActivity)localObject).getIntent().putExtra("kindaPayPwd", paramString);
    if (paramBoolean)
    {
      ((MMActivity)localObject).getIntent().putExtra("bSupportFaceAndTouch", true);
      if (paramSelectBioType == SelectBioType.TOUCHID) {
        ((MMActivity)localObject).getIntent().putExtra("selectBioType", 1);
      }
    }
    else
    {
      paramString = ((MMActivity)localObject).getIntent().getExtras();
      if (paramString != null) {
        break label227;
      }
      ad.i("KindaOpenBiometricVerifyManagerImpl", "The Extras data in current kinda Activity is null!");
    }
    for (;;)
    {
      s.dZT();
      paramString = s.dZU().ecN();
      if ((paramString == null) || (!paramString.ecu())) {
        break label254;
      }
      ad.i("KindaOpenBiometricVerifyManagerImpl", "WalletSwitchConfig.isSupportTouchPay return that the user has opened fingerprint (biometric) payment in WeChat.");
      ((h)g.ab(h.class)).h((MMActivity)localObject);
      AppMethodBeat.o(18457);
      return;
      if (paramSelectBioType != SelectBioType.FACEID) {
        break;
      }
      ((MMActivity)localObject).getIntent().putExtra("selectBioType", 2);
      break;
      label227:
      ad.i("KindaOpenBiometricVerifyManagerImpl", "The Extras data in current kinda Activity is " + paramString.toString());
    }
    label254:
    ad.i("KindaOpenBiometricVerifyManagerImpl", "WalletSwitchConfig.isSupportTouchPay return that the user has not opened fingerprint (biometric) payment in WeChat. Send a message to call the bind query.");
    paramString = new xf();
    paramString.dCH.scene = 1;
    paramString.dCH.dCJ = true;
    paramString.dCH.dCK = true;
    paramString.dCI.dCz = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18456);
        ((h)g.ab(h.class)).h(this.val$activity);
        AppMethodBeat.o(18456);
      }
    };
    a.ESL.a(paramString, Looper.myLooper());
    AppMethodBeat.o(18457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaOpenBiometricVerifyManagerImpl
 * JD-Core Version:    0.7.0.1
 */