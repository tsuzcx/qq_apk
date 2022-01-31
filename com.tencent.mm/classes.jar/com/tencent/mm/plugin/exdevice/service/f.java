package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class f
{
  public HashMap<Long, f.a> jzb = new HashMap();
  
  private void dY(long paramLong)
  {
    b localb = ad.aLL().BF(String.valueOf(paramLong));
    if (localb == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    f.a locala = new f.a();
    locala.jzc = paramLong;
    locala.jze = localb.field_authBuf;
    locala.aYR = localb.field_sessionKey;
    locala.jzd = localb.field_sessionBuf;
    locala.bJw = localb.field_brandName;
    locala.mURL = localb.field_url;
    locala.bKp = 0;
    locala.jzf = false;
    this.jzb.put(Long.valueOf(paramLong), locala);
    y.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[] { Long.valueOf(paramLong) });
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramLong < 0L) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      boolean bool;
      if (paramArrayOfByte == null)
      {
        bool = true;
        if (paramArrayOfByte != null) {
          break label70;
        }
      }
      label70:
      for (paramInt = -1;; paramInt = paramArrayOfByte.length)
      {
        y.e("MicroMsg.exdevice.ExdeviceInfoManager", "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        return;
        bool = false;
        break;
      }
    }
    f.a locala2 = (f.a)this.jzb.get(Long.valueOf(paramLong));
    f.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new f.a();
      locala1.jzc = paramLong;
    }
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      this.jzb.put(Long.valueOf(paramLong), locala1);
      return;
      locala1.jze = paramArrayOfByte;
      continue;
      locala1.aYR = paramArrayOfByte;
      continue;
      locala1.jzd = paramArrayOfByte;
    }
  }
  
  public final boolean dR(long paramLong)
  {
    return dS(paramLong) == 2;
  }
  
  public final int dS(long paramLong)
  {
    if (this.jzb.containsKey(Long.valueOf(paramLong))) {
      return ((f.a)this.jzb.get(Long.valueOf(paramLong))).bKp;
    }
    return 0;
  }
  
  public final f.a dT(long paramLong)
  {
    if (!this.jzb.containsKey(Long.valueOf(paramLong))) {
      dY(paramLong);
    }
    return (f.a)this.jzb.get(Long.valueOf(paramLong));
  }
  
  public final f.a dU(long paramLong)
  {
    if (this.jzb.containsKey(Long.valueOf(paramLong))) {
      return (f.a)this.jzb.get(Long.valueOf(paramLong));
    }
    f.a locala = new f.a();
    locala.jzc = paramLong;
    locala.jze = null;
    locala.aYR = null;
    locala.jzd = null;
    locala.bJw = null;
    locala.mURL = null;
    locala.bKp = 0;
    locala.jzf = false;
    locala.hUQ = 0L;
    this.jzb.put(Long.valueOf(paramLong), locala);
    return locala;
  }
  
  public final boolean dV(long paramLong)
  {
    y.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    f.a locala = dT(paramLong);
    if (locala == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      return false;
    }
    locala.jzf = true;
    return true;
  }
  
  public final boolean dW(long paramLong)
  {
    y.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    f.a locala = dT(paramLong);
    if (locala == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      return false;
    }
    locala.jzf = false;
    return true;
  }
  
  public final boolean dX(long paramLong)
  {
    y.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[] { Long.valueOf(paramLong) });
    f.a locala = dT(paramLong);
    if (locala == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      return false;
    }
    return locala.jzf;
  }
  
  public final byte[] l(long paramLong, int paramInt)
  {
    if (paramLong < 0L) {
      y.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
    }
    Object localObject;
    do
    {
      return null;
      f.a locala = (f.a)this.jzb.get(Long.valueOf(paramLong));
      localObject = locala;
      if (locala == null)
      {
        dY(paramLong);
        localObject = (f.a)this.jzb.get(Long.valueOf(paramLong));
      }
    } while (localObject == null);
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = ((f.a)localObject).jze;
      continue;
      localObject = ((f.a)localObject).aYR;
      continue;
      localObject = ((f.a)localObject).jzd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.f
 * JD-Core Version:    0.7.0.1
 */