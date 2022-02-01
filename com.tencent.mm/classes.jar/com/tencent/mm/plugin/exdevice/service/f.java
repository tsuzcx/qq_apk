package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;

public final class f
{
  public HashMap<Long, a> pCw;
  
  public f()
  {
    AppMethodBeat.i(23649);
    this.pCw = new HashMap();
    AppMethodBeat.o(23649);
  }
  
  private void sK(long paramLong)
  {
    AppMethodBeat.i(23657);
    b localb = ad.cgP().Zc(String.valueOf(paramLong));
    if (localb == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23657);
      return;
    }
    a locala = new a();
    locala.pCx = paramLong;
    locala.pCz = localb.field_authBuf;
    locala.sessionKey = localb.field_sessionKey;
    locala.pCy = localb.field_sessionBuf;
    locala.ddh = localb.field_brandName;
    locala.mURL = localb.field_url;
    locala.dea = 0;
    locala.pCA = false;
    this.pCw.put(Long.valueOf(paramLong), locala);
    ac.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[] { Long.valueOf(paramLong) });
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
        ac.e("MicroMsg.exdevice.ExdeviceInfoManager", "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        AppMethodBeat.o(23659);
        return;
        bool = false;
        break;
      }
    }
    a locala2 = (a)this.pCw.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      locala1.pCx = paramLong;
    }
    switch (paramInt)
    {
    default: 
      ac.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      this.pCw.put(Long.valueOf(paramLong), locala1);
      AppMethodBeat.o(23659);
      return;
      locala1.pCz = paramArrayOfByte;
      continue;
      locala1.sessionKey = paramArrayOfByte;
      continue;
      locala1.pCy = paramArrayOfByte;
    }
  }
  
  public final boolean sD(long paramLong)
  {
    AppMethodBeat.i(23650);
    if (sE(paramLong) == 2)
    {
      AppMethodBeat.o(23650);
      return true;
    }
    AppMethodBeat.o(23650);
    return false;
  }
  
  public final int sE(long paramLong)
  {
    AppMethodBeat.i(23651);
    if (this.pCw.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((a)this.pCw.get(Long.valueOf(paramLong))).dea;
      AppMethodBeat.o(23651);
      return i;
    }
    AppMethodBeat.o(23651);
    return 0;
  }
  
  public final a sF(long paramLong)
  {
    AppMethodBeat.i(23652);
    if (!this.pCw.containsKey(Long.valueOf(paramLong))) {
      sK(paramLong);
    }
    a locala = (a)this.pCw.get(Long.valueOf(paramLong));
    AppMethodBeat.o(23652);
    return locala;
  }
  
  public final a sG(long paramLong)
  {
    AppMethodBeat.i(23653);
    if (this.pCw.containsKey(Long.valueOf(paramLong)))
    {
      locala = (a)this.pCw.get(Long.valueOf(paramLong));
      AppMethodBeat.o(23653);
      return locala;
    }
    a locala = new a();
    locala.pCx = paramLong;
    locala.pCz = null;
    locala.sessionKey = null;
    locala.pCy = null;
    locala.ddh = null;
    locala.mURL = null;
    locala.dea = 0;
    locala.pCA = false;
    locala.npZ = 0L;
    this.pCw.put(Long.valueOf(paramLong), locala);
    AppMethodBeat.o(23653);
    return locala;
  }
  
  public final boolean sH(long paramLong)
  {
    AppMethodBeat.i(23654);
    ac.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = sF(paramLong);
    if (locala == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23654);
      return false;
    }
    locala.pCA = true;
    AppMethodBeat.o(23654);
    return true;
  }
  
  public final boolean sI(long paramLong)
  {
    AppMethodBeat.i(23655);
    ac.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = sF(paramLong);
    if (locala == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23655);
      return false;
    }
    locala.pCA = false;
    AppMethodBeat.o(23655);
    return true;
  }
  
  public final boolean sJ(long paramLong)
  {
    AppMethodBeat.i(23656);
    ac.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = sF(paramLong);
    if (locala == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23656);
      return false;
    }
    boolean bool = locala.pCA;
    AppMethodBeat.o(23656);
    return bool;
  }
  
  public final byte[] u(long paramLong, int paramInt)
  {
    AppMethodBeat.i(23658);
    if (paramLong < 0L)
    {
      ac.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
      AppMethodBeat.o(23658);
      return null;
    }
    a locala = (a)this.pCw.get(Long.valueOf(paramLong));
    Object localObject = locala;
    if (locala == null)
    {
      sK(paramLong);
      localObject = (a)this.pCw.get(Long.valueOf(paramLong));
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
      localObject = ((a)localObject).pCz;
      continue;
      localObject = ((a)localObject).sessionKey;
      continue;
      localObject = ((a)localObject).pCy;
    }
  }
  
  public static final class a
  {
    public String ddh;
    public int dea;
    public String mURL;
    public long npZ;
    public boolean pCA;
    public long pCx;
    public byte[] pCy;
    public byte[] pCz;
    public byte[] sessionKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.f
 * JD-Core Version:    0.7.0.1
 */