package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.exdevice.f.f;
import com.tencent.mm.plugin.exdevice.f.g;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
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
    AppMethodBeat.i(23150);
    ac.i("MicroMsg.exdevice.ExDeviceCmdInit", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    AppMethodBeat.o(23150);
  }
  
  public final void a(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(23152);
    ac.i("MicroMsg.exdevice.ExDeviceCmdInit", "------initResponse------ errorCode = %d, errMsg = %s, filter = %s, challenge = %s, initScene = %d, second = %d", new Object[] { Integer.valueOf(paramInt1), paramString, b.bd(paramArrayOfByte1), b.bd(paramArrayOfByte2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    g localg = new g();
    localg.pAX = aJ(0, "ok");
    paramString = u.axw();
    long l;
    label159:
    label196:
    int i;
    if (!bs.isNullOrNil(paramString))
    {
      paramString = ah.dg(paramString).toLowerCase();
      ac.i("MicroMsg.exdevice.Util", "user md5 : [%s]", new Object[] { paramString });
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.exdevice.Util", "get hash code failed, value is null or nill");
        l = 0L;
        paramString = new int[] { (int)(l >> 32 & 0xFFFFFFFF), (int)(l & 0xFFFFFFFF) };
        localg.pAK = paramString[0];
        localg.pAL = paramString[1];
        if (!bs.cv(paramArrayOfByte2))
        {
          if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
            break label532;
          }
          paramInt1 = 0;
          localg.pAM = paramInt1;
        }
        if (!bs.cv(paramArrayOfByte1))
        {
          if ((paramArrayOfByte1[0] & 0x4) != 0) {
            localg.ncW = com.tencent.mm.protocal.d.DHX;
          }
          if ((paramArrayOfByte1[0] & 0x8) != 0) {
            localg.pAR = com.tencent.mm.protocal.d.DIa;
          }
          if ((paramArrayOfByte1[0] & 0x2) != 0) {
            localg.pAQ = 2;
          }
          if ((paramArrayOfByte1[0] & 0x10) != 0) {
            localg.pAS = ((int)bs.aNx());
          }
          if ((paramArrayOfByte1[0] & 0x20) != 0)
          {
            paramString = TimeZone.getDefault();
            i = paramString.getRawOffset() / 1000;
            if ((!paramString.useDaylightTime()) || (!paramString.inDaylightTime(new Date(System.currentTimeMillis())))) {
              break label555;
            }
          }
        }
      }
    }
    label532:
    label555:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      int j = i / 3600 + paramInt1;
      ac.i("MicroMsg.exdevice.Util", "getTimeZone, rawSecond = %d, dt = %d, re = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(j) });
      localg.pAT = j;
      if ((paramArrayOfByte1[0] & 0x40) != 0) {
        localg.pAU = b.cic();
      }
      if ((paramArrayOfByte1[0] & 0x1) != 0) {
        localg.pAP = u.axy();
      }
      localg.pAN = paramInt2;
      localg.pAO = paramInt3;
      this.pwt = localg;
      this.pwr = 20003;
      AppMethodBeat.o(23152);
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
      ac.i("MicroMsg.exdevice.Util", "get int hashcode value = %d, long hashcode = %d", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
      break;
      paramString = null;
      break label159;
      paramString = new CRC32();
      paramString.update(paramArrayOfByte2);
      paramInt1 = (int)paramString.getValue();
      break label196;
    }
  }
  
  protected final a bb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23151);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ac.e("MicroMsg.exdevice.ExDeviceCmdInit", "data is null");
      AppMethodBeat.o(23151);
      return null;
    }
    f localf = new f();
    try
    {
      localf.parseFrom(paramArrayOfByte);
      ac.i("MicroMsg.exdevice.ExDeviceCmdInit", "------Init Request parse is ok------ ");
      this.pwu = localf;
      AppMethodBeat.o(23151);
      return localf;
    }
    catch (IOException paramArrayOfByte)
    {
      ac.e("MicroMsg.exdevice.ExDeviceCmdInit", "pase error : " + paramArrayOfByte.getMessage());
      ac.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdInit", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(23151);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.e
 * JD-Core Version:    0.7.0.1
 */