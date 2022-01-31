package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KDeviceService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;

public class KindaDeviceServiceImpl
  implements KDeviceService
{
  private static final String TAG = "KindaDeviceServiceImpl";
  private l mgr;
  
  public KindaDeviceServiceImpl()
  {
    AppMethodBeat.i(144344);
    this.mgr = ((l)g.E(l.class));
    AppMethodBeat.o(144344);
  }
  
  public boolean isDeviceOpenBiometricVerification()
  {
    AppMethodBeat.i(144345);
    if (this.mgr == null)
    {
      ab.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceOpenBiometricVerification, mgr == null, return false.");
      AppMethodBeat.o(144345);
      return false;
    }
    boolean bool1 = this.mgr.bzb();
    boolean bool2 = this.mgr.bzo();
    ab.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceOpenBiometricVerification, isDeviceHasFingerPrint: " + bool1 + ", isDeviceHasFaceID: " + bool2);
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(144345);
      return true;
    }
    AppMethodBeat.o(144345);
    return false;
  }
  
  public boolean isDeviceSupportFaceId()
  {
    AppMethodBeat.i(144347);
    if (this.mgr == null)
    {
      ab.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, mgr == null, return false.");
      AppMethodBeat.o(144347);
      return false;
    }
    boolean bool = this.mgr.bzn();
    ab.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFaceId, return".concat(String.valueOf(bool)));
    AppMethodBeat.o(144347);
    return bool;
  }
  
  public boolean isDeviceSupportTouchId()
  {
    AppMethodBeat.i(144346);
    if (this.mgr == null)
    {
      ab.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFP, mgr == null, return false.");
      AppMethodBeat.o(144346);
      return false;
    }
    boolean bool = this.mgr.bza();
    ab.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isDeviceSupportFP, return".concat(String.valueOf(bool)));
    AppMethodBeat.o(144346);
    return bool;
  }
  
  public boolean isRoot()
  {
    AppMethodBeat.i(156544);
    if (this.mgr == null)
    {
      ab.w("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isRoot, mgr == null, return false.");
      AppMethodBeat.o(156544);
      return false;
    }
    ab.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.isRoot, returnfalse");
    AppMethodBeat.o(156544);
    return false;
  }
  
  public String soterCpuId()
  {
    AppMethodBeat.i(144348);
    String str = d.cyc().son;
    AppMethodBeat.o(144348);
    return str;
  }
  
  public String soterUid()
  {
    AppMethodBeat.i(144349);
    String str = d.cyc().kbP;
    AppMethodBeat.o(144349);
    return str;
  }
  
  public void updateBiometricVerificationState(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(156545);
    if (paramInt == 0) {
      if (this.mgr.bza())
      {
        this.mgr.hH(paramBoolean);
        this.mgr.hI(false);
      }
    }
    for (;;)
    {
      ab.i("KindaDeviceServiceImpl", "KindaDeviceServiceImpl.updateBiometricVerificationState, soterOpenType: " + paramInt + ", biometricVerificationState: " + paramBoolean);
      AppMethodBeat.o(156545);
      return;
      if (this.mgr.bzn())
      {
        this.mgr.hI(paramBoolean);
        this.mgr.hH(false);
        continue;
        if ((paramInt == 1) && (this.mgr.bza()))
        {
          this.mgr.hH(paramBoolean);
          this.mgr.hI(false);
        }
        else if ((paramInt == 2) && (this.mgr.bzn()))
        {
          this.mgr.hI(paramBoolean);
          this.mgr.hH(false);
        }
      }
    }
  }
  
  public boolean useLastestTouchInfo()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaDeviceServiceImpl
 * JD-Core Version:    0.7.0.1
 */