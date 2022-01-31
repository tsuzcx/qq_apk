package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.a.f;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class e$a
  implements e.b
{
  private String bUD;
  private String lEk;
  private String lEl;
  private String mURL;
  
  public e$a(e parame, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(19211);
    this.lEk = paramString1;
    this.bUD = paramString2;
    this.mURL = paramString3;
    this.lEl = paramString4;
    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(19211);
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(19213);
    if ((this.bUD == null) || (!this.bUD.equals(paramString)))
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[] { this.bUD, paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(19213);
      return;
    }
    if ((paramBoolean) && (paramArrayOfByte != null)) {
      try
      {
        ad.bqj();
        if (!e.c(this.bUD, this.lEk, paramArrayOfByte))
        {
          ab.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
          AppMethodBeat.o(19213);
          return;
        }
        AppMethodBeat.o(19213);
        return;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
      }
    }
    AppMethodBeat.o(19213);
  }
  
  public final void c(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(19214);
    if ((this.bUD == null) || (!this.bUD.equals(paramString)))
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[] { this.bUD, paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      AppMethodBeat.o(19214);
      return;
    }
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    switch (paramInt)
    {
    case 3: 
    default: 
      ab.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      e.c(this.lEk, this.mURL, -1, this.lEl);
      AppMethodBeat.o(19214);
      return;
    case 2: 
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[] { paramString });
      e.c(this.lEk, this.mURL, 2, this.lEl);
      paramString = new f();
      paramString.jPq = f.jQs;
      paramString.jPr = 2;
      ad.bqj().u(this.bUD, b.bG(paramString));
      AppMethodBeat.o(19214);
      return;
    case 1: 
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[] { paramString });
      e.c(this.lEk, this.mURL, 1, this.lEl);
      AppMethodBeat.o(19214);
      return;
    case 4: 
      e.c(this.lEk, this.mURL, 4, this.lEl);
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[] { paramString });
      AppMethodBeat.o(19214);
      return;
    }
    e.c(this.lEk, this.mURL, 0, this.lEl);
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[] { paramString });
    AppMethodBeat.o(19214);
  }
  
  public final void p(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(19212);
    if ((this.bUD == null) || (!this.bUD.equals(paramString2)))
    {
      ab.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[] { this.bUD, paramString2, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(19212);
      return;
    }
    AppMethodBeat.o(19212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.a
 * JD-Core Version:    0.7.0.1
 */