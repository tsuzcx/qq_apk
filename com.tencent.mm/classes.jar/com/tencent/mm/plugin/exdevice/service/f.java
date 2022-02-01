package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class f
{
  public HashMap<Long, a> yvk;
  
  public f()
  {
    AppMethodBeat.i(23649);
    this.yvk = new HashMap();
    AppMethodBeat.o(23649);
  }
  
  private void lH(long paramLong)
  {
    AppMethodBeat.i(23657);
    b localb = ah.dFO().apH(String.valueOf(paramLong));
    if (localb == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23657);
      return;
    }
    a locala = new a();
    locala.yvl = paramLong;
    locala.yvn = localb.field_authBuf;
    locala.sessionKey = localb.field_sessionKey;
    locala.yvm = localb.field_sessionBuf;
    locala.hEy = localb.field_brandName;
    locala.mURL = localb.field_url;
    locala.hFs = 0;
    locala.yvo = false;
    this.yvk.put(Long.valueOf(paramLong), locala);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(23657);
  }
  
  public final byte[] C(long paramLong, int paramInt)
  {
    AppMethodBeat.i(23658);
    if (paramLong < 0L)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
      AppMethodBeat.o(23658);
      return null;
    }
    a locala = (a)this.yvk.get(Long.valueOf(paramLong));
    Object localObject = locala;
    if (locala == null)
    {
      lH(paramLong);
      localObject = (a)this.yvk.get(Long.valueOf(paramLong));
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
      localObject = ((a)localObject).yvn;
      continue;
      localObject = ((a)localObject).sessionKey;
      continue;
      localObject = ((a)localObject).yvm;
    }
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
    a locala2 = (a)this.yvk.get(Long.valueOf(paramLong));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      locala1.yvl = paramLong;
    }
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      this.yvk.put(Long.valueOf(paramLong), locala1);
      AppMethodBeat.o(23659);
      return;
      locala1.yvn = paramArrayOfByte;
      continue;
      locala1.sessionKey = paramArrayOfByte;
      continue;
      locala1.yvm = paramArrayOfByte;
    }
  }
  
  public final boolean lA(long paramLong)
  {
    AppMethodBeat.i(23650);
    if (lB(paramLong) == 2)
    {
      AppMethodBeat.o(23650);
      return true;
    }
    AppMethodBeat.o(23650);
    return false;
  }
  
  public final int lB(long paramLong)
  {
    AppMethodBeat.i(23651);
    if (this.yvk.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((a)this.yvk.get(Long.valueOf(paramLong))).hFs;
      AppMethodBeat.o(23651);
      return i;
    }
    AppMethodBeat.o(23651);
    return 0;
  }
  
  public final a lC(long paramLong)
  {
    AppMethodBeat.i(23652);
    if (!this.yvk.containsKey(Long.valueOf(paramLong))) {
      lH(paramLong);
    }
    a locala = (a)this.yvk.get(Long.valueOf(paramLong));
    AppMethodBeat.o(23652);
    return locala;
  }
  
  public final a lD(long paramLong)
  {
    AppMethodBeat.i(23653);
    if (this.yvk.containsKey(Long.valueOf(paramLong)))
    {
      locala = (a)this.yvk.get(Long.valueOf(paramLong));
      AppMethodBeat.o(23653);
      return locala;
    }
    a locala = new a();
    locala.yvl = paramLong;
    locala.yvn = null;
    locala.sessionKey = null;
    locala.yvm = null;
    locala.hEy = null;
    locala.mURL = null;
    locala.hFs = 0;
    locala.yvo = false;
    locala.vvH = 0L;
    this.yvk.put(Long.valueOf(paramLong), locala);
    AppMethodBeat.o(23653);
    return locala;
  }
  
  public final boolean lE(long paramLong)
  {
    AppMethodBeat.i(23654);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = lC(paramLong);
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23654);
      return false;
    }
    locala.yvo = true;
    AppMethodBeat.o(23654);
    return true;
  }
  
  public final boolean lF(long paramLong)
  {
    AppMethodBeat.i(23655);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = lC(paramLong);
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23655);
      return false;
    }
    locala.yvo = false;
    AppMethodBeat.o(23655);
    return true;
  }
  
  public final boolean lG(long paramLong)
  {
    AppMethodBeat.i(23656);
    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[] { Long.valueOf(paramLong) });
    a locala = lC(paramLong);
    if (locala == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
      AppMethodBeat.o(23656);
      return false;
    }
    boolean bool = locala.yvo;
    AppMethodBeat.o(23656);
    return bool;
  }
  
  public static final class a
  {
    public String hEy;
    public int hFs;
    public String mURL;
    public byte[] sessionKey;
    public long vvH;
    public long yvl;
    public byte[] yvm;
    public byte[] yvn;
    public boolean yvo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.f
 * JD-Core Version:    0.7.0.1
 */