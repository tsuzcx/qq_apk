package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.f.a.b.a.f;
import com.tencent.mm.sdk.platformtools.y;

public final class e$a
  implements e.b
{
  private String btt;
  private String juL;
  private String juM;
  private String mURL;
  
  public e$a(e parame, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.juL = paramString1;
    this.btt = paramString2;
    this.mURL = paramString3;
    this.juM = paramString4;
    y.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[] { paramString1, paramString2 });
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((this.btt == null) || (!this.btt.equals(paramString))) {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[] { this.btt, paramString, Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      return;
      if ((paramBoolean) && (paramArrayOfByte != null)) {
        try
        {
          ad.aLW();
          if (!e.c(this.btt, this.juL, paramArrayOfByte))
          {
            y.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
            return;
          }
        }
        catch (Exception paramString)
        {
          y.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
        }
      }
    }
  }
  
  public final void d(String paramString, int paramInt, long paramLong)
  {
    if ((this.btt == null) || (!this.btt.equals(paramString)))
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[] { this.btt, paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      return;
    }
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    switch (paramInt)
    {
    case 3: 
    default: 
      y.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      e.c(this.juL, this.mURL, -1, this.juM);
      return;
    case 2: 
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[] { paramString });
      e.c(this.juL, this.mURL, 2, this.juM);
      paramString = new f();
      paramString.hVw = f.hWz;
      paramString.hVx = 2;
      ad.aLW().n(this.btt, b.bi(paramString));
      return;
    case 1: 
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[] { paramString });
      e.c(this.juL, this.mURL, 1, this.juM);
      return;
    case 4: 
      e.c(this.juL, this.mURL, 4, this.juM);
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[] { paramString });
      return;
    }
    e.c(this.juL, this.mURL, 0, this.juM);
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[] { paramString });
  }
  
  public final void n(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((this.btt == null) || (!this.btt.equals(paramString2))) {
      y.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[] { this.btt, paramString2, Boolean.valueOf(paramBoolean) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.a
 * JD-Core Version:    0.7.0.1
 */