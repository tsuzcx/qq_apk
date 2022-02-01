package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class f
{
  public HashMap<Long, a> rDC;
  
  public f()
  {
    AppMethodBeat.i(23649);
    this.rDC = new HashMap();
    AppMethodBeat.o(23649);
  }
  
  private void Dd(long paramLong)
  {
    AppMethodBeat.i(23657);
    b localb = ad.cKL().anI(String.valueOf(paramLong));
    if (localb == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23657);
      return;
    }
    a locala = new a();
    locala.rDD = paramLong;
    locala.rDF = localb.field_authBuf;
    locala.sessionKey = localb.field_sessionKey;
    locala.rDE = localb.field_sessionBuf;
    locala.brandName = localb.field_brandName;
    locala.mURL = localb.field_url;
    locala.dHO = 0;
    locala.rDG = false;
    this.rDC.put(Long.valueOf(paramLong), locala);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(23657);
  }
  
  public final boolean CW(long paramLong)
  {
    AppMethodBeat.i(23650);
    if (CX(paramLong) == 2)
    {
      AppMethodBeat.o(23650);
      return true;
    }
    AppMethodBeat.o(23650);
    return false;
  }
  
  public final int CX(long paramLong)
  {
    AppMethodBeat.i(23651);
    if (this.rDC.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((a)this.rDC.get(Long.valueOf(paramLong))).dHO;
      AppMethodBeat.o(23651);
      return i;
    }
    AppMethodBeat.o(23651);
    return 0;
  }
  
  public final a CY(long paramLong)
  {
    AppMethodBeat.i(23652);
    if (!this.rDC.containsKey(Long.valueOf(paramLong))) {
      Dd(paramLong);
    }
    a locala = (a)this.rDC.get(Long.valueOf(paramLong));
    AppMethodBeat.o(23652);
    return locala;
  }
  
  public final a CZ(long paramLong)
  {
    AppMethodBeat.i(23653);
    if (this.rDC.containsKey(Long.valueOf(paramLong)))
    {
      locala = (a)this.rDC.get(Long.valueOf(paramLong));
      AppMethodBeat.o(23653);
      return locala;
    }
    a locala = new a();
    locala.rDD = paramLong;
    locala.rDF = null;
    locala.sessionKey = null;
    locala.rDE = null;
    locala.brandName = null;
    locala.mURL = null;
    locala.dHO = 0;
    locala.rDG = false;
    locala.phx = 0L;
    this.rDC.put(Long.valueOf(paramLong), locala);
    AppMethodBeat.o(23653);
    return locala;
  }
  
  public final boolean Da(long paramLong)
  {
    AppMethodBeat.i(23654);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = CY(paramLong);
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23654);
      return false;
    }
    locala.rDG = true;
    AppMethodBeat.o(23654);
    return true;
  }
  
  public final boolean Db(long paramLong)
  {
    AppMethodBeat.i(23655);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = CY(paramLong);
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23655);
      return false;
    }
    locala.rDG = false;
    AppMethodBeat.o(23655);
    return true;
  }
  
  public final boolean Dc(long paramLong)
  {
    AppMethodBeat.i(23656);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = CY(paramLong);
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23656);
      return false;
    }
    boolean bool = locala.rDG;
    AppMethodBeat.o(23656);
    return bool;
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
        Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        AppMethodBeat.o(23659);
        return;
        bool = false;
        break;
      }
    }
    a locala2 = (a)this.rDC.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      locala1.rDD = paramLong;
    }
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      this.rDC.put(Long.valueOf(paramLong), locala1);
      AppMethodBeat.o(23659);
      return;
      locala1.rDF = paramArrayOfByte;
      continue;
      locala1.sessionKey = paramArrayOfByte;
      continue;
      locala1.rDE = paramArrayOfByte;
    }
  }
  
  public final byte[] r(long paramLong, int paramInt)
  {
    AppMethodBeat.i(23658);
    if (paramLong < 0L)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
      AppMethodBeat.o(23658);
      return null;
    }
    a locala = (a)this.rDC.get(Long.valueOf(paramLong));
    Object localObject = locala;
    if (locala == null)
    {
      Dd(paramLong);
      localObject = (a)this.rDC.get(Long.valueOf(paramLong));
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
      localObject = ((a)localObject).rDF;
      continue;
      localObject = ((a)localObject).sessionKey;
      continue;
      localObject = ((a)localObject).rDE;
    }
  }
  
  public static final class a
  {
    public String brandName;
    public int dHO;
    public String mURL;
    public long phx;
    public long rDD;
    public byte[] rDE;
    public byte[] rDF;
    public boolean rDG;
    public byte[] sessionKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.f
 * JD-Core Version:    0.7.0.1
 */