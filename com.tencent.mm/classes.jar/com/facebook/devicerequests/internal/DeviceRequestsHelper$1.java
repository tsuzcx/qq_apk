package com.facebook.devicerequests.internal;

import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DeviceRequestsHelper$1
  implements NsdManager.RegistrationListener
{
  DeviceRequestsHelper$1(String paramString1, String paramString2) {}
  
  public final void onRegistrationFailed(NsdServiceInfo paramNsdServiceInfo, int paramInt)
  {
    AppMethodBeat.i(96600);
    DeviceRequestsHelper.cleanUpAdvertisementService(this.val$userCode);
    AppMethodBeat.o(96600);
  }
  
  public final void onServiceRegistered(NsdServiceInfo paramNsdServiceInfo)
  {
    AppMethodBeat.i(96599);
    if (!this.val$nsdServiceName.equals(paramNsdServiceInfo.getServiceName())) {
      DeviceRequestsHelper.cleanUpAdvertisementService(this.val$userCode);
    }
    AppMethodBeat.o(96599);
  }
  
  public final void onServiceUnregistered(NsdServiceInfo paramNsdServiceInfo) {}
  
  public final void onUnregistrationFailed(NsdServiceInfo paramNsdServiceInfo, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.devicerequests.internal.DeviceRequestsHelper.1
 * JD-Core Version:    0.7.0.1
 */