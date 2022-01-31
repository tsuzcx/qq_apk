package com.tencent.mm.plugin.exdevice.b;

import android.os.Message;
import com.tencent.mm.plugin.exdevice.i.e;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.c;
import com.tencent.mm.plugin.exdevice.service.i.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends i.a
{
  private static a jsQ = null;
  
  public static a aLf()
  {
    if (jsQ == null)
    {
      a locala = new a();
      jsQ = locala;
      return locala;
    }
    return jsQ;
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      i = -1;
      y.i("MicroMsg.exdevice.DeviceRequestManager", "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i) });
      if (paramInt1 != 0) {
        break label98;
      }
    }
    String str;
    label98:
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.g.a.k(paramLong, i);
      str = b.aq(paramArrayOfByte);
      if (str != null) {
        break label104;
      }
      y.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
      return;
      i = paramArrayOfByte.length;
      break;
    }
    label104:
    y.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", new Object[] { str });
    new a(paramInt1, paramLong, paramInt2, paramInt3, paramArrayOfByte).aLg();
  }
  
  private static final class a
    implements Runnable
  {
    private long hXu = -1L;
    private int jsR = -1;
    private int jsS = -1;
    private int jsT;
    private byte[] jsU = null;
    
    public a(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
    {
      this.hXu = paramLong;
      this.jsR = paramInt2;
      this.jsS = paramInt3;
      this.jsU = paramArrayOfByte;
      this.jsT = paramInt1;
    }
    
    public final void aLg()
    {
      if ((this.hXu == -1L) || (this.jsR == -1) || (this.jsS == -1))
      {
        y.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
        return;
      }
      switch (this.jsS)
      {
      default: 
        y.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", new Object[] { Integer.valueOf(this.jsS) });
        return;
      case 10001: 
        localObject = new e(this.jsT, this.hXu, this.jsR, this.jsS, this.jsU);
        u.aMn().a((ae)localObject);
        return;
      case 10002: 
        localObject = k.aLm();
        int i = this.jsT;
        f localf = new f(this.hXu, this.jsR, this.jsS, this.jsU);
        ((k)localObject).mHandler.obtainMessage(1, i, 0, localf).sendToTarget();
        return;
      }
      Object localObject = new com.tencent.mm.plugin.exdevice.i.f(this.jsT, this.hXu, this.jsR, this.jsS, this.jsU);
      u.aMn().a((ae)localObject);
    }
    
    public final void run()
    {
      aLg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.a
 * JD-Core Version:    0.7.0.1
 */