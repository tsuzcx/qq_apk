package com.tencent.mm.plugin.exdevice.service;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class x
  implements m
{
  private h lIK;
  
  public x(h paramh)
  {
    this.lIK = paramh;
  }
  
  public final long a(p paramp)
  {
    AppMethodBeat.i(19638);
    try
    {
      long l = this.lIK.a(paramp);
      AppMethodBeat.o(19638);
      return l;
    }
    catch (RemoteException paramp)
    {
      ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startTask failed!!! %s", new Object[] { paramp.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramp, "", new Object[0]);
      AppMethodBeat.o(19638);
    }
    return -1L;
  }
  
  public final boolean a(long paramLong, int paramInt, k paramk)
  {
    AppMethodBeat.i(19636);
    u.bqz().jo(paramLong);
    try
    {
      boolean bool = this.lIK.a(paramLong, paramInt, paramk);
      AppMethodBeat.o(19636);
      return bool;
    }
    catch (RemoteException paramk)
    {
      ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startChannel failed!!! %s", new Object[] { paramk.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramk, "", new Object[0]);
      AppMethodBeat.o(19636);
    }
    return false;
  }
  
  public final boolean a(long paramLong, k paramk)
  {
    AppMethodBeat.i(19645);
    try
    {
      boolean bool = this.lIK.b(paramLong, 0, paramk);
      AppMethodBeat.o(19645);
      return bool;
    }
    catch (RemoteException paramk)
    {
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramk, "", new Object[0]);
      AppMethodBeat.o(19645);
    }
    return false;
  }
  
  public final boolean a(i parami)
  {
    AppMethodBeat.i(19639);
    try
    {
      boolean bool = this.lIK.a(parami);
      AppMethodBeat.o(19639);
      return bool;
    }
    catch (RemoteException parami)
    {
      ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "registOnDeviceRequest failed!!! %s", new Object[] { parami.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", parami, "", new Object[0]);
      AppMethodBeat.o(19639);
    }
    return false;
  }
  
  public final boolean a(j paramj)
  {
    AppMethodBeat.i(19643);
    try
    {
      boolean bool = this.lIK.d(0, paramj);
      AppMethodBeat.o(19643);
      return bool;
    }
    catch (RemoteException paramj)
    {
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
      AppMethodBeat.o(19643);
    }
    return false;
  }
  
  public final boolean a(s params)
  {
    AppMethodBeat.i(19647);
    try
    {
      boolean bool = this.lIK.a(params);
      AppMethodBeat.o(19647);
      return bool;
    }
    catch (RemoteException params)
    {
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", params, "", new Object[0]);
      AppMethodBeat.o(19647);
    }
    return false;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, q paramq)
  {
    AppMethodBeat.i(19641);
    ab.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    try
    {
      paramBoolean = this.lIK.a(paramString, paramBoolean, paramq);
      AppMethodBeat.o(19641);
      return paramBoolean;
    }
    catch (RemoteException paramString)
    {
      ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.ranging failed!!!(%s)", new Object[] { paramString.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(19641);
    }
    return false;
  }
  
  public final boolean b(int paramInt, j paramj)
  {
    AppMethodBeat.i(19633);
    try
    {
      boolean bool = this.lIK.b(paramInt, paramj);
      AppMethodBeat.o(19633);
      return bool;
    }
    catch (RemoteException paramj)
    {
      ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "scan failed!!! %s", new Object[] { paramj.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
      AppMethodBeat.o(19633);
    }
    return false;
  }
  
  public final boolean b(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    AppMethodBeat.i(19648);
    try
    {
      boolean bool = this.lIK.b(paramLong, paramArrayOfByte, paramt);
      AppMethodBeat.o(19648);
      return bool;
    }
    catch (RemoteException paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(19648);
    }
    return false;
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(19644);
    try
    {
      boolean bool = this.lIK.e(0, paramj);
      AppMethodBeat.o(19644);
      return bool;
    }
    catch (RemoteException paramj)
    {
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
      AppMethodBeat.o(19644);
    }
    return false;
  }
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(19642);
    try
    {
      this.lIK.a(paramn);
      AppMethodBeat.o(19642);
      return true;
    }
    catch (RemoteException paramn)
    {
      ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.registExDeviceInvokerHandler failed!!, %s", new Object[] { paramn.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramn, "", new Object[0]);
      AppMethodBeat.o(19642);
    }
    return false;
  }
  
  public final long[] bqn()
  {
    AppMethodBeat.i(19635);
    try
    {
      long[] arrayOfLong = this.lIK.bqn();
      AppMethodBeat.o(19635);
      return arrayOfLong;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "getDeviceList failed!!! %s", new Object[] { localRemoteException.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(19635);
    }
    return null;
  }
  
  public final boolean c(int paramInt, j paramj)
  {
    AppMethodBeat.i(19634);
    try
    {
      boolean bool = this.lIK.c(paramInt, paramj);
      AppMethodBeat.o(19634);
      return bool;
    }
    catch (RemoteException paramj)
    {
      ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopScan failed!!! %s", new Object[] { paramj.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
      AppMethodBeat.o(19634);
    }
    return false;
  }
  
  public final boolean jr(long paramLong)
  {
    AppMethodBeat.i(19637);
    u.bqz().jo(paramLong);
    try
    {
      boolean bool = this.lIK.jr(paramLong);
      AppMethodBeat.o(19637);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopChannel failed!!! %s", new Object[] { localRemoteException.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(19637);
    }
    return false;
  }
  
  public final boolean ju(long paramLong)
  {
    AppMethodBeat.i(19646);
    try
    {
      boolean bool = this.lIK.ju(paramLong);
      AppMethodBeat.o(19646);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(19646);
    }
    return false;
  }
  
  public final void setChannelSessionKey(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19640);
    ab.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "------setChannelSessionKey------ deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    try
    {
      this.lIK.setChannelSessionKey(paramLong, paramArrayOfByte);
      AppMethodBeat.o(19640);
      return;
    }
    catch (RemoteException paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(19640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.x
 * JD-Core Version:    0.7.0.1
 */