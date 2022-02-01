package com.tencent.kinda.framework.app;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.kinda.framework.R.string;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KDeviceService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.model.b;
import com.tencent.mm.plugin.soter.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.g.a;

public class KindaDeviceServiceImpl
  implements KDeviceService
{
  private static final String TAG = "KindaDeviceServiceImpl";
  private byte _hellAccFlag_;
  private com.tencent.mm.plugin.fingerprint.c.a mgr;
  
  public KindaDeviceServiceImpl()
  {
    AppMethodBeat.i(18416);
    this.mgr = ((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class));
    AppMethodBeat.o(18416);
  }
  
  public void invokePhoneCall(String paramString)
  {
    AppMethodBeat.i(18424);
    Log.i("KindaDeviceServiceImpl", "invokePhoneCall, phoneNumber: %s", new Object[] { paramString });
    Object localObject = new Intent("android.intent.action.DIAL");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    try
    {
      Context localContext1 = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localContext1, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/kinda/framework/app/KindaDeviceServiceImpl", "invokePhoneCall", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext1.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localContext1, "com/tencent/kinda/framework/app/KindaDeviceServiceImpl", "invokePhoneCall", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(18424);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(1589L, 5L, 1L);
      Log.printErrStackTrace("KindaDeviceServiceImpl", localActivityNotFoundException, "invokePhoneCall: The device may not have a phone App installed! ", new Object[0]);
      Context localContext2 = KindaContext.get();
      if (localContext2 == null)
      {
        Log.e("KindaDeviceServiceImpl", "KindaDeviceServiceImpl invokePhoneCall() KindaContext.get() return null! case 9");
        AppMethodBeat.o(18424);
        return;
      }
      localObject = new g.a(localContext2);
      ((g.a)localObject).bDE(localContext2.getString(R.string.wallet_card_unable_call, new Object[] { paramString }));
      ((g.a)localObject).Xdm = true;
      ((g.a)localObject).aEX(R.string.wallet_dialog_confirm);
      ((g.a)localObject).show();
      AppMethodBeat.o(18424);
    }
  }
  
  public boolean isDeviceOpenBiometricVerification()
  {
    AppMethodBeat.i(18417);
    if (this.mgr == null)
    {
      Log.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceOpenBiometricVerification, mgr == null, return false.");
      AppMethodBeat.o(18417);
      return false;
    }
    boolean bool1 = this.mgr.ftw();
    boolean bool2 = this.mgr.ftE();
    Log.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceOpenBiometricVerification, isDeviceHasFingerPrint: " + bool1 + ", isDeviceHasFaceID: " + bool2);
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(18417);
      return true;
    }
    AppMethodBeat.o(18417);
    return false;
  }
  
  public boolean isDeviceSupportFaceId()
  {
    AppMethodBeat.i(18419);
    if (this.mgr == null)
    {
      Log.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, mgr == null, return false.");
      AppMethodBeat.o(18419);
      return false;
    }
    boolean bool = this.mgr.ftD();
    Log.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, return: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(18419);
    return bool;
  }
  
  public boolean isDeviceSupportTouchId()
  {
    AppMethodBeat.i(18418);
    if (this.mgr == null)
    {
      Log.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFP, mgr == null, return false.");
      AppMethodBeat.o(18418);
      return false;
    }
    boolean bool = this.mgr.ftv();
    Log.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFP, return".concat(String.valueOf(bool)));
    AppMethodBeat.o(18418);
    return bool;
  }
  
  public boolean isRoot()
  {
    AppMethodBeat.i(18420);
    if (this.mgr == null)
    {
      Log.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isRoot, mgr == null, return false.");
      AppMethodBeat.o(18420);
      return false;
    }
    boolean bool = this.mgr.isRoot();
    Log.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isRoot, return: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(18420);
    return bool;
  }
  
  public String soterCpuId()
  {
    AppMethodBeat.i(18421);
    String str = b.htz().RZY;
    Log.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.soterCpuId, return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18421);
    return str;
  }
  
  public String soterUid()
  {
    AppMethodBeat.i(18422);
    String str = b.htz().mXG;
    Log.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18422);
    return str;
  }
  
  public void updateBiometricVerificationState(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(18423);
    if (paramInt == 0) {
      if (this.mgr.ftv())
      {
        this.mgr.vu(paramBoolean);
        this.mgr.vv(false);
      }
    }
    for (;;)
    {
      Log.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.updateBiometricVerificationState, soterOpenType: " + paramInt + ", biometricVerificationState: " + paramBoolean);
      AppMethodBeat.o(18423);
      return;
      if (this.mgr.ftD())
      {
        this.mgr.vv(paramBoolean);
        this.mgr.vu(false);
        continue;
        if ((paramInt == 1) && (this.mgr.ftv()))
        {
          this.mgr.vu(paramBoolean);
          this.mgr.vv(false);
        }
        else if ((paramInt == 2) && (this.mgr.ftD()))
        {
          this.mgr.vv(paramBoolean);
          this.mgr.vu(false);
        }
      }
    }
  }
  
  public boolean useLastestTouchInfo()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaDeviceServiceImpl
 * JD-Core Version:    0.7.0.1
 */