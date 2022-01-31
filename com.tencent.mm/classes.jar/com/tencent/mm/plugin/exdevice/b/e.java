package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bv.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.exdevice.e.f;
import com.tencent.mm.plugin.exdevice.e.g;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;
import java.util.zip.CRC32;

public final class e
  extends d
{
  public e(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramLong, paramInt1, paramInt2, paramArrayOfByte);
    y.i("MicroMsg.exdevice.ExDeviceCmdInit", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
  }
  
  public final void a(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.exdevice.ExDeviceCmdInit", "------initResponse------ errorCode = %d, errMsg = %s, filter = %s, challenge = %s, initScene = %d, second = %d", new Object[] { Integer.valueOf(paramInt1), paramString, b.aq(paramArrayOfByte1), b.aq(paramArrayOfByte2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    g localg = new g();
    localg.jxC = Z(0, "ok");
    paramString = q.Gj();
    long l;
    label153:
    label190:
    int i;
    if (!bk.bl(paramString))
    {
      paramString = ad.bB(paramString).toLowerCase();
      y.i("MicroMsg.exdevice.Util", "user md5 : [%s]", new Object[] { paramString });
      if (bk.bl(paramString))
      {
        y.e("MicroMsg.exdevice.Util", "get hash code failed, value is null or nill");
        l = 0L;
        paramString = new int[] { (int)(l >> 32 & 0xFFFFFFFF), (int)(l & 0xFFFFFFFF) };
        localg.jxp = paramString[0];
        localg.jxq = paramString[1];
        if (!bk.bE(paramArrayOfByte2))
        {
          if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
            break label520;
          }
          paramInt1 = 0;
          localg.jxr = paramInt1;
        }
        if (!bk.bE(paramArrayOfByte1))
        {
          if ((paramArrayOfByte1[0] & 0x4) != 0) {
            localg.hQd = com.tencent.mm.protocal.d.soV;
          }
          if ((paramArrayOfByte1[0] & 0x8) != 0) {
            localg.jxw = com.tencent.mm.protocal.d.soY;
          }
          if ((paramArrayOfByte1[0] & 0x2) != 0) {
            localg.jxv = 2;
          }
          if ((paramArrayOfByte1[0] & 0x10) != 0) {
            localg.jxx = ((int)bk.UX());
          }
          if ((paramArrayOfByte1[0] & 0x20) != 0)
          {
            paramString = TimeZone.getDefault();
            i = paramString.getRawOffset() / 1000;
            if ((!paramString.useDaylightTime()) || (!paramString.inDaylightTime(new Date(System.currentTimeMillis())))) {
              break label543;
            }
          }
        }
      }
    }
    label520:
    label543:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      int j = i / 3600 + paramInt1;
      y.i("MicroMsg.exdevice.Util", "getTimeZone, rawSecond = %d, dt = %d, re = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(j) });
      localg.jxy = j;
      if ((paramArrayOfByte1[0] & 0x40) != 0) {
        localg.jxz = b.aMW();
      }
      if ((paramArrayOfByte1[0] & 0x1) != 0) {
        localg.jxu = q.Gl();
      }
      localg.jxs = paramInt2;
      localg.jxt = paramInt3;
      this.jsX = localg;
      this.jsV = 20003;
      return;
      j = 0;
      paramInt1 = 0;
      paramString = paramString.toCharArray();
      if (paramString.length > 0)
      {
        i = 0;
        for (;;)
        {
          j = paramInt1;
          if (i >= paramString.length) {
            break;
          }
          paramInt1 = paramInt1 * 31 + paramString[i];
          i += 1;
        }
      }
      l = j & 0xFFFFFFFF;
      y.i("MicroMsg.exdevice.Util", "get int hashcode value = %d, long hashcode = %d", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
      break;
      paramString = null;
      break label153;
      paramString = new CRC32();
      paramString.update(paramArrayOfByte2);
      paramInt1 = (int)paramString.getValue();
      break label190;
    }
  }
  
  protected final a ao(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      y.e("MicroMsg.exdevice.ExDeviceCmdInit", "data is null");
      return null;
    }
    f localf = new f();
    try
    {
      localf.aH(paramArrayOfByte);
      y.i("MicroMsg.exdevice.ExDeviceCmdInit", "------Init Request parse is ok------ ");
      this.jsY = localf;
      return localf;
    }
    catch (IOException paramArrayOfByte)
    {
      y.e("MicroMsg.exdevice.ExDeviceCmdInit", "pase error : " + paramArrayOfByte.getMessage());
      y.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdInit", paramArrayOfByte, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.e
 * JD-Core Version:    0.7.0.1
 */