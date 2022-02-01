package com.tencent.kinda.framework.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.kinda.gen.KDeviceService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

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
    ae.i("KindaDeviceServiceImpl", "invokePhoneCall %s", new Object[] { paramString });
    Object localObject = new Intent("android.intent.action.DIAL");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString = ak.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/kinda/framework/app/KindaDeviceServiceImpl", "invokePhoneCall", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/kinda/framework/app/KindaDeviceServiceImpl", "invokePhoneCall", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(18424);
  }
  
  public boolean isDeviceOpenBiometricVerification()
  {
    AppMethodBeat.i(18417);
    if (this.mgr == null)
    {
      ae.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceOpenBiometricVerification, mgr == null, return false.");
      AppMethodBeat.o(18417);
      return false;
    }
    boolean bool1 = this.mgr.cRZ();
    boolean bool2 = this.mgr.cSh();
    ae.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceOpenBiometricVerification, isDeviceHasFingerPrint: " + bool1 + ", isDeviceHasFaceID: " + bool2);
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
      ae.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, mgr == null, return false.");
      AppMethodBeat.o(18419);
      return false;
    }
    boolean bool = this.mgr.cSg();
    ae.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, return: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(18419);
    return bool;
  }
  
  public boolean isDeviceSupportTouchId()
  {
    AppMethodBeat.i(18418);
    if (this.mgr == null)
    {
      ae.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFP, mgr == null, return false.");
      AppMethodBeat.o(18418);
      return false;
    }
    boolean bool = this.mgr.cRY();
    ae.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFP, return".concat(String.valueOf(bool)));
    AppMethodBeat.o(18418);
    return bool;
  }
  
  public boolean isRoot()
  {
    AppMethodBeat.i(18420);
    if (this.mgr == null)
    {
      ae.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isRoot, mgr == null, return false.");
      AppMethodBeat.o(18420);
      return false;
    }
    ae.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isRoot, return: false");
    AppMethodBeat.o(18420);
    return false;
  }
  
  public String soterCpuId()
  {
    AppMethodBeat.i(18421);
    String str = d.ejm().AXb;
    ae.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.soterCpuId, return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18421);
    return str;
  }
  
  public String soterUid()
  {
    AppMethodBeat.i(18422);
    String str = d.ejm().AXc;
    ae.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18422);
    return str;
  }
  
  public void updateBiometricVerificationState(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(18423);
    if (paramInt == 0) {
      if (this.mgr.cRY())
      {
        this.mgr.mC(paramBoolean);
        this.mgr.mD(false);
      }
    }
    for (;;)
    {
      ae.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.updateBiometricVerificationState, soterOpenType: " + paramInt + ", biometricVerificationState: " + paramBoolean);
      AppMethodBeat.o(18423);
      return;
      if (this.mgr.cSg())
      {
        this.mgr.mD(paramBoolean);
        this.mgr.mC(false);
        continue;
        if ((paramInt == 1) && (this.mgr.cRY()))
        {
          this.mgr.mC(paramBoolean);
          this.mgr.mD(false);
        }
        else if ((paramInt == 2) && (this.mgr.cSg()))
        {
          this.mgr.mD(paramBoolean);
          this.mgr.mC(false);
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