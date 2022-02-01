package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import java.util.HashMap;

public final class f
{
  public HashMap<Long, a> qgb;
  
  public f()
  {
    AppMethodBeat.i(23649);
    this.qgb = new HashMap();
    AppMethodBeat.o(23649);
  }
  
  private void uI(long paramLong)
  {
    AppMethodBeat.i(23657);
    b localb = com.tencent.mm.plugin.exdevice.model.ad.clt().acI(String.valueOf(paramLong));
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23657);
      return;
    }
    a locala = new a();
    locala.qgc = paramLong;
    locala.qge = localb.field_authBuf;
    locala.sessionKey = localb.field_sessionKey;
    locala.qgd = localb.field_sessionBuf;
    locala.doD = localb.field_brandName;
    locala.mURL = localb.field_url;
    locala.dpw = 0;
    locala.qgf = false;
    this.qgb.put(Long.valueOf(paramLong), locala);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(23657);
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23659);
    if ((paramLong < 0L) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      boolean bool;
      if (paramArrayOfByte == null)
      {
        bool = true;
        if (paramArrayOfByte != null) {
          break label82;
        }
      }
      label82:
      for (paramInt = -1;; paramInt = paramArrayOfByte.length)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        AppMethodBeat.o(23659);
        return;
        bool = false;
        break;
      }
    }
    a locala2 = (a)this.qgb.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      locala1.qgc = paramLong;
    }
    switch (paramInt)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      this.qgb.put(Long.valueOf(paramLong), locala1);
      AppMethodBeat.o(23659);
      return;
      locala1.qge = paramArrayOfByte;
      continue;
      locala1.sessionKey = paramArrayOfByte;
      continue;
      locala1.qgd = paramArrayOfByte;
    }
  }
  
  public final byte[] u(long paramLong, int paramInt)
  {
    AppMethodBeat.i(23658);
    if (paramLong < 0L)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
      AppMethodBeat.o(23658);
      return null;
    }
    a locala = (a)this.qgb.get(Long.valueOf(paramLong));
    Object localObject = locala;
    if (locala == null)
    {
      uI(paramLong);
      localObject = (a)this.qgb.get(Long.valueOf(paramLong));
    }
    if (localObject == null)
    {
      AppMethodBeat.o(23658);
      return null;
    }
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(23658);
      return localObject;
      localObject = ((a)localObject).qge;
      continue;
      localObject = ((a)localObject).sessionKey;
      continue;
      localObject = ((a)localObject).qgd;
    }
  }
  
  public final boolean uB(long paramLong)
  {
    AppMethodBeat.i(23650);
    if (uC(paramLong) == 2)
    {
      AppMethodBeat.o(23650);
      return true;
    }
    AppMethodBeat.o(23650);
    return false;
  }
  
  public final int uC(long paramLong)
  {
    AppMethodBeat.i(23651);
    if (this.qgb.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((a)this.qgb.get(Long.valueOf(paramLong))).dpw;
      AppMethodBeat.o(23651);
      return i;
    }
    AppMethodBeat.o(23651);
    return 0;
  }
  
  public final a uD(long paramLong)
  {
    AppMethodBeat.i(23652);
    if (!this.qgb.containsKey(Long.valueOf(paramLong))) {
      uI(paramLong);
    }
    a locala = (a)this.qgb.get(Long.valueOf(paramLong));
    AppMethodBeat.o(23652);
    return locala;
  }
  
  public final a uE(long paramLong)
  {
    AppMethodBeat.i(23653);
    if (this.qgb.containsKey(Long.valueOf(paramLong)))
    {
      locala = (a)this.qgb.get(Long.valueOf(paramLong));
      AppMethodBeat.o(23653);
      return locala;
    }
    a locala = new a();
    locala.qgc = paramLong;
    locala.qge = null;
    locala.sessionKey = null;
    locala.qgd = null;
    locala.doD = null;
    locala.mURL = null;
    locala.dpw = 0;
    locala.qgf = false;
    locala.nQV = 0L;
    this.qgb.put(Long.valueOf(paramLong), locala);
    AppMethodBeat.o(23653);
    return locala;
  }
  
  public final boolean uF(long paramLong)
  {
    AppMethodBeat.i(23654);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = uD(paramLong);
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23654);
      return false;
    }
    locala.qgf = true;
    AppMethodBeat.o(23654);
    return true;
  }
  
  public final boolean uG(long paramLong)
  {
    AppMethodBeat.i(23655);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = uD(paramLong);
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23655);
      return false;
    }
    locala.qgf = false;
    AppMethodBeat.o(23655);
    return true;
  }
  
  public final boolean uH(long paramLong)
  {
    AppMethodBeat.i(23656);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = uD(paramLong);
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23656);
      return false;
    }
    boolean bool = locala.qgf;
    AppMethodBeat.o(23656);
    return bool;
  }
  
  public static final class a
  {
    public String doD;
    public int dpw;
    public String mURL;
    public long nQV;
    public long qgc;
    public byte[] qgd;
    public byte[] qge;
    public boolean qgf;
    public byte[] sessionKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.f
 * JD-Core Version:    0.7.0.1
 */