package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import java.util.HashMap;

public final class f
{
  public HashMap<Long, a> oZl;
  
  public f()
  {
    AppMethodBeat.i(23649);
    this.oZl = new HashMap();
    AppMethodBeat.o(23649);
  }
  
  private void oY(long paramLong)
  {
    AppMethodBeat.i(23657);
    b localb = com.tencent.mm.plugin.exdevice.model.ad.bZG().UQ(String.valueOf(paramLong));
    if (localb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23657);
      return;
    }
    a locala = new a();
    locala.oZm = paramLong;
    locala.oZo = localb.field_authBuf;
    locala.sessionKey = localb.field_sessionKey;
    locala.oZn = localb.field_sessionBuf;
    locala.dfM = localb.field_brandName;
    locala.mURL = localb.field_url;
    locala.dgF = 0;
    locala.oZp = false;
    this.oZl.put(Long.valueOf(paramLong), locala);
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
    a locala2 = (a)this.oZl.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      locala1.oZm = paramLong;
    }
    switch (paramInt)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      this.oZl.put(Long.valueOf(paramLong), locala1);
      AppMethodBeat.o(23659);
      return;
      locala1.oZo = paramArrayOfByte;
      continue;
      locala1.sessionKey = paramArrayOfByte;
      continue;
      locala1.oZn = paramArrayOfByte;
    }
  }
  
  public final boolean oR(long paramLong)
  {
    AppMethodBeat.i(23650);
    if (oS(paramLong) == 2)
    {
      AppMethodBeat.o(23650);
      return true;
    }
    AppMethodBeat.o(23650);
    return false;
  }
  
  public final int oS(long paramLong)
  {
    AppMethodBeat.i(23651);
    if (this.oZl.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((a)this.oZl.get(Long.valueOf(paramLong))).dgF;
      AppMethodBeat.o(23651);
      return i;
    }
    AppMethodBeat.o(23651);
    return 0;
  }
  
  public final a oT(long paramLong)
  {
    AppMethodBeat.i(23652);
    if (!this.oZl.containsKey(Long.valueOf(paramLong))) {
      oY(paramLong);
    }
    a locala = (a)this.oZl.get(Long.valueOf(paramLong));
    AppMethodBeat.o(23652);
    return locala;
  }
  
  public final a oU(long paramLong)
  {
    AppMethodBeat.i(23653);
    if (this.oZl.containsKey(Long.valueOf(paramLong)))
    {
      locala = (a)this.oZl.get(Long.valueOf(paramLong));
      AppMethodBeat.o(23653);
      return locala;
    }
    a locala = new a();
    locala.oZm = paramLong;
    locala.oZo = null;
    locala.sessionKey = null;
    locala.oZn = null;
    locala.dfM = null;
    locala.mURL = null;
    locala.dgF = 0;
    locala.oZp = false;
    locala.mNN = 0L;
    this.oZl.put(Long.valueOf(paramLong), locala);
    AppMethodBeat.o(23653);
    return locala;
  }
  
  public final boolean oV(long paramLong)
  {
    AppMethodBeat.i(23654);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = oT(paramLong);
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23654);
      return false;
    }
    locala.oZp = true;
    AppMethodBeat.o(23654);
    return true;
  }
  
  public final boolean oW(long paramLong)
  {
    AppMethodBeat.i(23655);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = oT(paramLong);
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23655);
      return false;
    }
    locala.oZp = false;
    AppMethodBeat.o(23655);
    return true;
  }
  
  public final boolean oX(long paramLong)
  {
    AppMethodBeat.i(23656);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = oT(paramLong);
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23656);
      return false;
    }
    boolean bool = locala.oZp;
    AppMethodBeat.o(23656);
    return bool;
  }
  
  public final byte[] t(long paramLong, int paramInt)
  {
    AppMethodBeat.i(23658);
    if (paramLong < 0L)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
      AppMethodBeat.o(23658);
      return null;
    }
    a locala = (a)this.oZl.get(Long.valueOf(paramLong));
    Object localObject = locala;
    if (locala == null)
    {
      oY(paramLong);
      localObject = (a)this.oZl.get(Long.valueOf(paramLong));
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
      localObject = ((a)localObject).oZo;
      continue;
      localObject = ((a)localObject).sessionKey;
      continue;
      localObject = ((a)localObject).oZn;
    }
  }
  
  public static final class a
  {
    public String dfM;
    public int dgF;
    public long mNN;
    public String mURL;
    public long oZm;
    public byte[] oZn;
    public byte[] oZo;
    public boolean oZp;
    public byte[] sessionKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.f
 * JD-Core Version:    0.7.0.1
 */