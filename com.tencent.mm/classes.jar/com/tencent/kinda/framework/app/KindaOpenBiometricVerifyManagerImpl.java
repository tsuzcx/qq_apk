package com.tencent.kinda.framework.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaOpenBiometricVerifyManager;
import com.tencent.kinda.gen.SelectBioType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class KindaOpenBiometricVerifyManagerImpl
  implements KindaOpenBiometricVerifyManager
{
  private static final String TAG = "KindaOpenBiometricVerifyManagerImpl";
  
  public void openBiometricVerify(String paramString, boolean paramBoolean, SelectBioType paramSelectBioType)
  {
    AppMethodBeat.i(144373);
    Object localObject = KindaContext.get();
    if (localObject == null)
    {
      ab.e("KindaOpenBiometricVerifyManagerImpl", "Fail to start KindaOpenBiometricVerifyManagerImpl due to context is null!");
      AppMethodBeat.o(144373);
      return;
    }
    if (!(localObject instanceof MMActivity))
    {
      ab.e("KindaOpenBiometricVerifyManagerImpl", "Fail to start KindaOpenBiometricVerifyManagerImpl due to incompatible context(%s)", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(144373);
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
        break label223;
      }
      ab.i("KindaOpenBiometricVerifyManagerImpl", "The Extras data in current kinda Activity is null!");
    }
    for (;;)
    {
      s.cRG();
      paramString = s.cRH().cUt();
      if ((paramString == null) || (!paramString.cUd())) {
        break label250;
      }
      ab.i("KindaOpenBiometricVerifyManagerImpl", "WalletSwitchConfig.isSupportTouchPay return that the user has opened fingerprint (biometric) payment in WeChat.");
      ((i)g.E(i.class)).g((MMActivity)localObject);
      AppMethodBeat.o(144373);
      return;
      if (paramSelectBioType != SelectBioType.FACEID) {
        break;
      }
      ((MMActivity)localObject).getIntent().putExtra("selectBioType", 2);
      break;
      label223:
      ab.i("KindaOpenBiometricVerifyManagerImpl", "The Extras data in current kinda Activity is " + paramString.toString());
    }
    label250:
    ab.i("KindaOpenBiometricVerifyManagerImpl", "WalletSwitchConfig.isSupportTouchPay return that the user has not opened fingerprint (biometric) payment in WeChat. Send a message to call the bind query.");
    paramString = new vf();
    paramString.cLJ.scene = 1;
    paramString.cLJ.cLL = true;
    paramString.cLJ.cLM = true;
    paramString.cLK.cLC = new KindaOpenBiometricVerifyManagerImpl.1(this, (MMActivity)localObject);
    a.ymk.a(paramString, Looper.myLooper());
    AppMethodBeat.o(144373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaOpenBiometricVerifyManagerImpl
 * JD-Core Version:    0.7.0.1
 */