package com.tencent.mm.plugin.exdevice.service;

import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.y;

public final class x
  implements m
{
  private h jzl;
  
  public x(h paramh)
  {
    this.jzl = paramh;
  }
  
  public final long a(p paramp)
  {
    try
    {
      long l = this.jzl.a(paramp);
      return l;
    }
    catch (RemoteException paramp)
    {
      y.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startTask failed!!! %s", new Object[] { paramp.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramp, "", new Object[0]);
    }
    return -1L;
  }
  
  public final boolean a(long paramLong, int paramInt, k paramk)
  {
    u.aMm().dW(paramLong);
    try
    {
      boolean bool = this.jzl.a(paramLong, paramInt, paramk);
      return bool;
    }
    catch (RemoteException paramk)
    {
      y.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startChannel failed!!! %s", new Object[] { paramk.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramk, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean a(long paramLong, k paramk)
  {
    try
    {
      boolean bool = this.jzl.b(paramLong, 0, paramk);
      return bool;
    }
    catch (RemoteException paramk)
    {
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramk, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean a(i parami)
  {
    try
    {
      boolean bool = this.jzl.a(parami);
      return bool;
    }
    catch (RemoteException parami)
    {
      y.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "registOnDeviceRequest failed!!! %s", new Object[] { parami.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", parami, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean a(j paramj)
  {
    try
    {
      boolean bool = this.jzl.d(0, paramj);
      return bool;
    }
    catch (RemoteException paramj)
    {
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean a(s params)
  {
    try
    {
      boolean bool = this.jzl.a(params);
      return bool;
    }
    catch (RemoteException params)
    {
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", params, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, q paramq)
  {
    y.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "ranging, uuid = %s, op = %s", new Object[] { paramString, String.valueOf(paramBoolean) });
    try
    {
      paramBoolean = this.jzl.a(paramString, paramBoolean, paramq);
      return paramBoolean;
    }
    catch (RemoteException paramString)
    {
      y.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.ranging failed!!!(%s)", new Object[] { paramString.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramString, "", new Object[0]);
    }
    return false;
  }
  
  public final long[] aMa()
  {
    try
    {
      long[] arrayOfLong = this.jzl.aMa();
      return arrayOfLong;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "getDeviceList failed!!! %s", new Object[] { localRemoteException.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", localRemoteException, "", new Object[0]);
    }
    return null;
  }
  
  public final boolean b(int paramInt, j paramj)
  {
    try
    {
      boolean bool = this.jzl.b(paramInt, paramj);
      return bool;
    }
    catch (RemoteException paramj)
    {
      y.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "scan failed!!! %s", new Object[] { paramj.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean b(long paramLong, byte[] paramArrayOfByte, t paramt)
  {
    try
    {
      boolean bool = this.jzl.b(paramLong, paramArrayOfByte, paramt);
      return bool;
    }
    catch (RemoteException paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramArrayOfByte, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean b(j paramj)
  {
    try
    {
      boolean bool = this.jzl.e(0, paramj);
      return bool;
    }
    catch (RemoteException paramj)
    {
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean b(n paramn)
  {
    try
    {
      this.jzl.a(paramn);
      return true;
    }
    catch (RemoteException paramn)
    {
      y.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.registExDeviceInvokerHandler failed!!, %s", new Object[] { paramn.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramn, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean c(int paramInt, j paramj)
  {
    try
    {
      boolean bool = this.jzl.c(paramInt, paramj);
      return bool;
    }
    catch (RemoteException paramj)
    {
      y.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopScan failed!!! %s", new Object[] { paramj.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramj, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean dZ(long paramLong)
  {
    u.aMm().dW(paramLong);
    try
    {
      boolean bool = this.jzl.dZ(paramLong);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopChannel failed!!! %s", new Object[] { localRemoteException.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", localRemoteException, "", new Object[0]);
    }
    return false;
  }
  
  public final boolean ec(long paramLong)
  {
    try
    {
      boolean bool = this.jzl.ec(paramLong);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", localRemoteException, "", new Object[0]);
    }
    return false;
  }
  
  public final void setChannelSessionKey(long paramLong, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "------setChannelSessionKey------ deviceId = %d", new Object[] { Long.valueOf(paramLong) });
    try
    {
      this.jzl.setChannelSessionKey(paramLong, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", paramArrayOfByte, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.x
 * JD-Core Version:    0.7.0.1
 */