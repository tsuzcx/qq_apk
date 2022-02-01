package com.tencent.kinda.framework.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.kinda.gen.KDeviceService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class KindaDeviceServiceImpl
  implements KDeviceService
{
  private static final String TAG = "KindaDeviceServiceImpl";
  private byte _hellAccFlag_;
  private com.tencent.mm.plugin.fingerprint.d.a mgr;
  
  public KindaDeviceServiceImpl()
  {
    AppMethodBeat.i(18416);
    this.mgr = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
    AppMethodBeat.o(18416);
  }
  
  public void invokePhoneCall(String paramString)
  {
    AppMethodBeat.i(18424);
    ad.i("KindaDeviceServiceImpl", "invokePhoneCall %s", new Object[] { paramString });
    Object localObject = new Intent("android.intent.action.DIAL");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString = aj.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/kinda/framework/app/KindaDeviceServiceImpl", "invokePhoneCall", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/kinda/framework/app/KindaDeviceServiceImpl", "invokePhoneCall", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(18424);
  }
  
  public boolean isDeviceOpenBiometricVerification()
  {
    AppMethodBeat.i(18417);
    if (this.mgr == null)
    {
      ad.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceOpenBiometricVerification, mgr == null, return false.");
      AppMethodBeat.o(18417);
      return false;
    }
    boolean bool1 = this.mgr.ctT();
    boolean bool2 = this.mgr.cub();
    ad.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceOpenBiometricVerification, isDeviceHasFingerPrint: " + bool1 + ", isDeviceHasFaceID: " + bool2);
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
      ad.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, mgr == null, return false.");
      AppMethodBeat.o(18419);
      return false;
    }
    boolean bool = this.mgr.cua();
    ad.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, return: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(18419);
    return bool;
  }
  
  public boolean isDeviceSupportTouchId()
  {
    AppMethodBeat.i(18418);
    if (this.mgr == null)
    {
      ad.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFP, mgr == null, return false.");
      AppMethodBeat.o(18418);
      return false;
    }
    boolean bool = this.mgr.ctS();
    ad.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFP, return".concat(String.valueOf(bool)));
    AppMethodBeat.o(18418);
    return bool;
  }
  
  public boolean isRoot()
  {
    AppMethodBeat.i(18420);
    if (this.mgr == null)
    {
      ad.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isRoot, mgr == null, return false.");
      AppMethodBeat.o(18420);
      return false;
    }
    ad.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isRoot, return: false");
    AppMethodBeat.o(18420);
    return false;
  }
  
  public String soterCpuId()
  {
    AppMethodBeat.i(18421);
    String str = d.dEQ().yaF;
    ad.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.soterCpuId, return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18421);
    return str;
  }
  
  public String soterUid()
  {
    AppMethodBeat.i(18422);
    String str = d.dEQ().yaG;
    ad.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18422);
    return str;
  }
  
  public void updateBiometricVerificationState(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(18423);
    if (paramInt == 0) {
      if (this.mgr.ctS())
      {
        this.mgr.lp(paramBoolean);
        this.mgr.lq(false);
      }
    }
    for (;;)
    {
      ad.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.updateBiometricVerificationState, soterOpenType: " + paramInt + ", biometricVerificationState: " + paramBoolean);
      AppMethodBeat.o(18423);
      return;
      if (this.mgr.cua())
      {
        this.mgr.lq(paramBoolean);
        this.mgr.lp(false);
        continue;
        if ((paramInt == 1) && (this.mgr.ctS()))
        {
          this.mgr.lp(paramBoolean);
          this.mgr.lq(false);
        }
        else if ((paramInt == 2) && (this.mgr.cua()))
        {
          this.mgr.lq(paramBoolean);
          this.mgr.lp(false);
        }
      }
    }
  }
  
  public boolean useLastestTouchInfo()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaDeviceServiceImpl
 * JD-Core Version:    0.7.0.1
 */