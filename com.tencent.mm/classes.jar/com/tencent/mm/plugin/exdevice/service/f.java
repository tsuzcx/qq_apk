package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public final class f
{
  public HashMap<Long, a> qmG;
  
  public f()
  {
    AppMethodBeat.i(23649);
    this.qmG = new HashMap();
    AppMethodBeat.o(23649);
  }
  
  private void uZ(long paramLong)
  {
    AppMethodBeat.i(23657);
    b localb = ad.cmJ().adz(String.valueOf(paramLong));
    if (localb == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23657);
      return;
    }
    a locala = new a();
    locala.qmH = paramLong;
    locala.qmJ = localb.field_authBuf;
    locala.sessionKey = localb.field_sessionKey;
    locala.qmI = localb.field_sessionBuf;
    locala.dpI = localb.field_brandName;
    locala.mURL = localb.field_url;
    locala.dqB = 0;
    locala.qmK = false;
    this.qmG.put(Long.valueOf(paramLong), locala);
    ae.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[] { Long.valueOf(paramLong) });
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
        ae.e("MicroMsg.exdevice.ExdeviceInfoManager", "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        AppMethodBeat.o(23659);
        return;
        bool = false;
        break;
      }
    }
    a locala2 = (a)this.qmG.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      locala1.qmH = paramLong;
    }
    switch (paramInt)
    {
    default: 
      ae.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      this.qmG.put(Long.valueOf(paramLong), locala1);
      AppMethodBeat.o(23659);
      return;
      locala1.qmJ = paramArrayOfByte;
      continue;
      locala1.sessionKey = paramArrayOfByte;
      continue;
      locala1.qmI = paramArrayOfByte;
    }
  }
  
  public final byte[] u(long paramLong, int paramInt)
  {
    AppMethodBeat.i(23658);
    if (paramLong < 0L)
    {
      ae.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
      AppMethodBeat.o(23658);
      return null;
    }
    a locala = (a)this.qmG.get(Long.valueOf(paramLong));
    Object localObject = locala;
    if (locala == null)
    {
      uZ(paramLong);
      localObject = (a)this.qmG.get(Long.valueOf(paramLong));
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
      localObject = ((a)localObject).qmJ;
      continue;
      localObject = ((a)localObject).sessionKey;
      continue;
      localObject = ((a)localObject).qmI;
    }
  }
  
  public final boolean uS(long paramLong)
  {
    AppMethodBeat.i(23650);
    if (uT(paramLong) == 2)
    {
      AppMethodBeat.o(23650);
      return true;
    }
    AppMethodBeat.o(23650);
    return false;
  }
  
  public final int uT(long paramLong)
  {
    AppMethodBeat.i(23651);
    if (this.qmG.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((a)this.qmG.get(Long.valueOf(paramLong))).dqB;
      AppMethodBeat.o(23651);
      return i;
    }
    AppMethodBeat.o(23651);
    return 0;
  }
  
  public final a uU(long paramLong)
  {
    AppMethodBeat.i(23652);
    if (!this.qmG.containsKey(Long.valueOf(paramLong))) {
      uZ(paramLong);
    }
    a locala = (a)this.qmG.get(Long.valueOf(paramLong));
    AppMethodBeat.o(23652);
    return locala;
  }
  
  public final a uV(long paramLong)
  {
    AppMethodBeat.i(23653);
    if (this.qmG.containsKey(Long.valueOf(paramLong)))
    {
      locala = (a)this.qmG.get(Long.valueOf(paramLong));
      AppMethodBeat.o(23653);
      return locala;
    }
    a locala = new a();
    locala.qmH = paramLong;
    locala.qmJ = null;
    locala.sessionKey = null;
    locala.qmI = null;
    locala.dpI = null;
    locala.mURL = null;
    locala.dqB = 0;
    locala.qmK = false;
    locala.nWB = 0L;
    this.qmG.put(Long.valueOf(paramLong), locala);
    AppMethodBeat.o(23653);
    return locala;
  }
  
  public final boolean uW(long paramLong)
  {
    AppMethodBeat.i(23654);
    ae.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = uU(paramLong);
    if (locala == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23654);
      return false;
    }
    locala.qmK = true;
    AppMethodBeat.o(23654);
    return true;
  }
  
  public final boolean uX(long paramLong)
  {
    AppMethodBeat.i(23655);
    ae.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = uU(paramLong);
    if (locala == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23655);
      return false;
    }
    locala.qmK = false;
    AppMethodBeat.o(23655);
    return true;
  }
  
  public final boolean uY(long paramLong)
  {
    AppMethodBeat.i(23656);
    ae.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = uU(paramLong);
    if (locala == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23656);
      return false;
    }
    boolean bool = locala.qmK;
    AppMethodBeat.o(23656);
    return bool;
  }
  
  public static final class a
  {
    public String dpI;
    public int dqB;
    public String mURL;
    public long nWB;
    public long qmH;
    public byte[] qmI;
    public byte[] qmJ;
    public boolean qmK;
    public byte[] sessionKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.f
 * JD-Core Version:    0.7.0.1
 */