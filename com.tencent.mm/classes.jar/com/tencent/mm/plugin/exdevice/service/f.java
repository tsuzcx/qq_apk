package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class f
{
  public HashMap<Long, a> vjm;
  
  public f()
  {
    AppMethodBeat.i(23649);
    this.vjm = new HashMap();
    AppMethodBeat.o(23649);
  }
  
  private void Jr(long paramLong)
  {
    AppMethodBeat.i(23657);
    b localb = ae.cZx().avH(String.valueOf(paramLong));
    if (localb == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23657);
      return;
    }
    a locala = new a();
    locala.vjn = paramLong;
    locala.vjp = localb.field_authBuf;
    locala.sessionKey = localb.field_sessionKey;
    locala.vjo = localb.field_sessionBuf;
    locala.fzM = localb.field_brandName;
    locala.mURL = localb.field_url;
    locala.fAF = 0;
    locala.vjq = false;
    this.vjm.put(Long.valueOf(paramLong), locala);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(23657);
  }
  
  public final boolean Jk(long paramLong)
  {
    AppMethodBeat.i(23650);
    if (Jl(paramLong) == 2)
    {
      AppMethodBeat.o(23650);
      return true;
    }
    AppMethodBeat.o(23650);
    return false;
  }
  
  public final int Jl(long paramLong)
  {
    AppMethodBeat.i(23651);
    if (this.vjm.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((a)this.vjm.get(Long.valueOf(paramLong))).fAF;
      AppMethodBeat.o(23651);
      return i;
    }
    AppMethodBeat.o(23651);
    return 0;
  }
  
  public final a Jm(long paramLong)
  {
    AppMethodBeat.i(23652);
    if (!this.vjm.containsKey(Long.valueOf(paramLong))) {
      Jr(paramLong);
    }
    a locala = (a)this.vjm.get(Long.valueOf(paramLong));
    AppMethodBeat.o(23652);
    return locala;
  }
  
  public final a Jn(long paramLong)
  {
    AppMethodBeat.i(23653);
    if (this.vjm.containsKey(Long.valueOf(paramLong)))
    {
      locala = (a)this.vjm.get(Long.valueOf(paramLong));
      AppMethodBeat.o(23653);
      return locala;
    }
    a locala = new a();
    locala.vjn = paramLong;
    locala.vjp = null;
    locala.sessionKey = null;
    locala.vjo = null;
    locala.fzM = null;
    locala.mURL = null;
    locala.fAF = 0;
    locala.vjq = false;
    locala.sjI = 0L;
    this.vjm.put(Long.valueOf(paramLong), locala);
    AppMethodBeat.o(23653);
    return locala;
  }
  
  public final boolean Jo(long paramLong)
  {
    AppMethodBeat.i(23654);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = Jm(paramLong);
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23654);
      return false;
    }
    locala.vjq = true;
    AppMethodBeat.o(23654);
    return true;
  }
  
  public final boolean Jp(long paramLong)
  {
    AppMethodBeat.i(23655);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = Jm(paramLong);
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23655);
      return false;
    }
    locala.vjq = false;
    AppMethodBeat.o(23655);
    return true;
  }
  
  public final boolean Jq(long paramLong)
  {
    AppMethodBeat.i(23656);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = Jm(paramLong);
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23656);
      return false;
    }
    boolean bool = locala.vjq;
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
    a locala2 = (a)this.vjm.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      locala1.vjn = paramLong;
    }
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      this.vjm.put(Long.valueOf(paramLong), locala1);
      AppMethodBeat.o(23659);
      return;
      locala1.vjp = paramArrayOfByte;
      continue;
      locala1.sessionKey = paramArrayOfByte;
      continue;
      locala1.vjo = paramArrayOfByte;
    }
  }
  
  public final byte[] t(long paramLong, int paramInt)
  {
    AppMethodBeat.i(23658);
    if (paramLong < 0L)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
      AppMethodBeat.o(23658);
      return null;
    }
    a locala = (a)this.vjm.get(Long.valueOf(paramLong));
    Object localObject = locala;
    if (locala == null)
    {
      Jr(paramLong);
      localObject = (a)this.vjm.get(Long.valueOf(paramLong));
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
      localObject = ((a)localObject).vjp;
      continue;
      localObject = ((a)localObject).sessionKey;
      continue;
      localObject = ((a)localObject).vjo;
    }
  }
  
  public static final class a
  {
    public int fAF;
    public String fzM;
    public String mURL;
    public byte[] sessionKey;
    public long sjI;
    public long vjn;
    public byte[] vjo;
    public byte[] vjp;
    public boolean vjq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.f
 * JD-Core Version:    0.7.0.1
 */