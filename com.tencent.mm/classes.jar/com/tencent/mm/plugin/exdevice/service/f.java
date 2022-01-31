package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class f
{
  public HashMap<Long, a> lIA;
  
  public f()
  {
    AppMethodBeat.i(19581);
    this.lIA = new HashMap();
    AppMethodBeat.o(19581);
  }
  
  private void jq(long paramLong)
  {
    AppMethodBeat.i(19589);
    b localb = ad.bpY().LH(String.valueOf(paramLong));
    if (localb == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(19589);
      return;
    }
    a locala = new a();
    locala.lIB = paramLong;
    locala.lID = localb.field_authBuf;
    locala.sessionKey = localb.field_sessionKey;
    locala.lIC = localb.field_sessionBuf;
    locala.cqQ = localb.field_brandName;
    locala.mURL = localb.field_url;
    locala.crJ = 0;
    locala.lIE = false;
    this.lIA.put(Long.valueOf(paramLong), locala);
    ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(19589);
  }
  
  public final void b(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(19591);
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
        ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        AppMethodBeat.o(19591);
        return;
        bool = false;
        break;
      }
    }
    a locala2 = (a)this.lIA.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      locala1.lIB = paramLong;
    }
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      this.lIA.put(Long.valueOf(paramLong), locala1);
      AppMethodBeat.o(19591);
      return;
      locala1.lID = paramArrayOfByte;
      continue;
      locala1.sessionKey = paramArrayOfByte;
      continue;
      locala1.lIC = paramArrayOfByte;
    }
  }
  
  public final boolean jj(long paramLong)
  {
    AppMethodBeat.i(19582);
    if (jk(paramLong) == 2)
    {
      AppMethodBeat.o(19582);
      return true;
    }
    AppMethodBeat.o(19582);
    return false;
  }
  
  public final int jk(long paramLong)
  {
    AppMethodBeat.i(19583);
    if (this.lIA.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((a)this.lIA.get(Long.valueOf(paramLong))).crJ;
      AppMethodBeat.o(19583);
      return i;
    }
    AppMethodBeat.o(19583);
    return 0;
  }
  
  public final a jl(long paramLong)
  {
    AppMethodBeat.i(19584);
    if (!this.lIA.containsKey(Long.valueOf(paramLong))) {
      jq(paramLong);
    }
    a locala = (a)this.lIA.get(Long.valueOf(paramLong));
    AppMethodBeat.o(19584);
    return locala;
  }
  
  public final a jm(long paramLong)
  {
    AppMethodBeat.i(19585);
    if (this.lIA.containsKey(Long.valueOf(paramLong)))
    {
      locala = (a)this.lIA.get(Long.valueOf(paramLong));
      AppMethodBeat.o(19585);
      return locala;
    }
    a locala = new a();
    locala.lIB = paramLong;
    locala.lID = null;
    locala.sessionKey = null;
    locala.lIC = null;
    locala.cqQ = null;
    locala.mURL = null;
    locala.crJ = 0;
    locala.lIE = false;
    locala.jOK = 0L;
    this.lIA.put(Long.valueOf(paramLong), locala);
    AppMethodBeat.o(19585);
    return locala;
  }
  
  public final boolean jn(long paramLong)
  {
    AppMethodBeat.i(19586);
    ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = jl(paramLong);
    if (locala == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(19586);
      return false;
    }
    locala.lIE = true;
    AppMethodBeat.o(19586);
    return true;
  }
  
  public final boolean jo(long paramLong)
  {
    AppMethodBeat.i(19587);
    ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = jl(paramLong);
    if (locala == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(19587);
      return false;
    }
    locala.lIE = false;
    AppMethodBeat.o(19587);
    return true;
  }
  
  public final boolean jp(long paramLong)
  {
    AppMethodBeat.i(19588);
    ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = jl(paramLong);
    if (locala == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(19588);
      return false;
    }
    boolean bool = locala.lIE;
    AppMethodBeat.o(19588);
    return bool;
  }
  
  public final byte[] q(long paramLong, int paramInt)
  {
    AppMethodBeat.i(19590);
    if (paramLong < 0L)
    {
      ab.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
      AppMethodBeat.o(19590);
      return null;
    }
    a locala = (a)this.lIA.get(Long.valueOf(paramLong));
    Object localObject = locala;
    if (locala == null)
    {
      jq(paramLong);
      localObject = (a)this.lIA.get(Long.valueOf(paramLong));
    }
    if (localObject == null)
    {
      AppMethodBeat.o(19590);
      return null;
    }
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      AppMethodBeat.o(19590);
      return localObject;
      localObject = ((a)localObject).lID;
      continue;
      localObject = ((a)localObject).sessionKey;
      continue;
      localObject = ((a)localObject).lIC;
    }
  }
  
  public static final class a
  {
    public String cqQ;
    public int crJ;
    public long jOK;
    public long lIB;
    public byte[] lIC;
    public byte[] lID;
    public boolean lIE;
    public String mURL;
    public byte[] sessionKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.f
 * JD-Core Version:    0.7.0.1
 */