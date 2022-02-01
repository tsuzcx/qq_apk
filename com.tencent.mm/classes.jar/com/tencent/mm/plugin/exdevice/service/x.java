package com.tencent.mm.plugin.exdevice.service;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  implements m
{
  private h yvF;
  
  public x(h paramh)
  {
    this.yvF = paramh;
  }
  
  public final long a(p paramp)
  {
    AppMethodBeat.i(23706);
    try
    {
      long l = this.yvF.a(paramp);
      AppMethodBeat.o(23706);
      return l;
    }
    catch (RemoteException paramp)
    {
      Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startTask failed!!! %s", new Object[] { paramp.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramp, "", new Object[0]);
      AppMethodBeat.o(23706);
    }
    return -1L;
  }
  
  public final boolean a(long paramLong, int paramInt, k paramk)
  {
    AppMethodBeat.i(23704);
    u.dGD().lF(paramLong);
    try
    {
      boolean bool = this.yvF.a(paramLong, paramInt, paramk);
      AppMethodBeat.o(23704);
      return bool;
    }
    catch (RemoteException paramk)
    {
      Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startChannel failed!!! %s", new Object[] { paramk.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramk, "", new Object[0]);
      AppMethodBeat.o(23704);
    }
    return false;
  }
  
  public final boolean a(long paramLong, k paramk)
  {
    AppMethodBeat.i(23713);
    try
    {
      boolean bool = this.yvF.b(paramLong, 0, paramk);
      AppMethodBeat.o(23713);
      return bool;
    }
    catch (RemoteException paramk)
    {
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramk, "", new Object[0]);
      AppMethodBeat.o(23713);
    }
    return false;
  }
  
  public final boolean a(i parami)
  {
    AppMethodBeat.i(23707);
    try
    {
      boolean bool = this.yvF.a(parami);
      AppMethodBeat.o(23707);
      return bool;
    }
    catch (RemoteException parami)
    {
      Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "registOnDeviceRequest failed!!! %s", new Object[] { parami.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", parami, "", new Object[0]);
      AppMethodBeat.o(23707);
    }
    return false;
  }
  
  public final boolean a(j paramj)
  {
    AppMethodBeat.i(23711);
    try
    {
      boolean bool = this.yvF.d(0, paramj);
      AppMethodBeat.o(23711);
      return bool;
    }
    catch (RemoteException paramj)
    {
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
      AppMethodBeat.o(23711);
    }
    return false;
  }
  
  public final boolean a(s params)
  {
    AppMethodBeat.i(23715);
    try
    {
      boolean bool = this.yvF.a(params);
      AppMethodBeat.o(23715);
      return bool;
    }
    catch (RemoteException params)
    {
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", params, "", new Object[0]);
      AppMethodBeat.o(23715);
    }
    return false;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, q paramq)
  {
    AppMethodBeat.i(23709);
    Log.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    try
    {
      paramBoolean = this.yvF.a(paramString, paramBoolean, paramq);
      AppMethodBeat.o(23709);
      return paramBoolean;
    }
    catch (RemoteException paramString)
    {
      Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.ranging failed!!!(%s)", new Object[] { paramString.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramString, "", new Object[0]);
      AppMethodBeat.o(23709);
    }
    return false;
  }
  
  public final boolean b(int paramInt, j paramj)
  {
    AppMethodBeat.i(23701);
    try
    {
      boolean bool = this.yvF.b(paramInt, paramj);
      AppMethodBeat.o(23701);
      return bool;
    }
    catch (RemoteException paramj)
    {
      Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "scan failed!!! %s", new Object[] { paramj.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
      AppMethodBeat.o(23701);
    }
    return false;
  }
  
  public final boolean b(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    AppMethodBeat.i(23716);
    try
    {
      boolean bool = this.yvF.b(paramLong, paramArrayOfByte, paramt);
      AppMethodBeat.o(23716);
      return bool;
    }
    catch (RemoteException paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(23716);
    }
    return false;
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(23712);
    try
    {
      boolean bool = this.yvF.e(0, paramj);
      AppMethodBeat.o(23712);
      return bool;
    }
    catch (RemoteException paramj)
    {
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
      AppMethodBeat.o(23712);
    }
    return false;
  }
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(23710);
    try
    {
      this.yvF.a(paramn);
      AppMethodBeat.o(23710);
      return true;
    }
    catch (RemoteException paramn)
    {
      Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.registExDeviceInvokerHandler failed!!, %s", new Object[] { paramn.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramn, "", new Object[0]);
      AppMethodBeat.o(23710);
    }
    return false;
  }
  
  public final boolean c(int paramInt, j paramj)
  {
    AppMethodBeat.i(23702);
    try
    {
      boolean bool = this.yvF.c(paramInt, paramj);
      AppMethodBeat.o(23702);
      return bool;
    }
    catch (RemoteException paramj)
    {
      Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopScan failed!!! %s", new Object[] { paramj.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
      AppMethodBeat.o(23702);
    }
    return false;
  }
  
  public final long[] dGg()
  {
    AppMethodBeat.i(23703);
    try
    {
      long[] arrayOfLong = this.yvF.dGg();
      AppMethodBeat.o(23703);
      return arrayOfLong;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "getDeviceList failed!!! %s", new Object[] { localRemoteException.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(23703);
    }
    return null;
  }
  
  public final boolean lI(long paramLong)
  {
    AppMethodBeat.i(23705);
    u.dGD().lF(paramLong);
    try
    {
      boolean bool = this.yvF.lI(paramLong);
      AppMethodBeat.o(23705);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopChannel failed!!! %s", new Object[] { localRemoteException.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(23705);
    }
    return false;
  }
  
  public final boolean lL(long paramLong)
  {
    AppMethodBeat.i(23714);
    try
    {
      boolean bool = this.yvF.lL(paramLong);
      AppMethodBeat.o(23714);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", localRemoteException, "", new Object[0]);
      AppMethodBeat.o(23714);
    }
    return false;
  }
  
  public final void setChannelSessionKey(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23708);
    Log.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "------setChannelSessionKey------ deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    try
    {
      this.yvF.setChannelSessionKey(paramLong, paramArrayOfByte);
      AppMethodBeat.o(23708);
      return;
    }
    catch (RemoteException paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(23708);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.x
 * JD-Core Version:    0.7.0.1
 */