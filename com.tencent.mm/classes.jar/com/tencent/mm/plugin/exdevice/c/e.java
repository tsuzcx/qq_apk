package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.exdevice.f.f;
import com.tencent.mm.plugin.exdevice.f.g;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
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
    ad.i("MicroMsg.exdevice.ExDeviceCmdInit", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    AppMethodBeat.o(23150);
  }
  
  public final void a(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(23152);
    ad.i("MicroMsg.exdevice.ExDeviceCmdInit", "------initResponse------ errorCode = %d, errMsg = %s, filter = %s, challenge = %s, initScene = %d, second = %d", new Object[] { Integer.valueOf(paramInt1), paramString, b.bg(paramArrayOfByte1), b.bg(paramArrayOfByte2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    g localg = new g();
    localg.qeC = aM(0, "ok");
    paramString = u.aAm();
    long l;
    label159:
    label196:
    int i;
    if (!bt.isNullOrNil(paramString))
    {
      paramString = ai.ee(paramString).toLowerCase();
      ad.i("MicroMsg.exdevice.Util", "user md5 : [%s]", new Object[] { paramString });
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.exdevice.Util", "get hash code failed, value is null or nill");
        l = 0L;
        paramString = new int[] { (int)(l >> 32 & 0xFFFFFFFF), (int)(l & 0xFFFFFFFF) };
        localg.qep = paramString[0];
        localg.qeq = paramString[1];
        if (!bt.cC(paramArrayOfByte2))
        {
          if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
            break label532;
          }
          paramInt1 = 0;
          localg.qer = paramInt1;
        }
        if (!bt.cC(paramArrayOfByte1))
        {
          if ((paramArrayOfByte1[0] & 0x4) != 0) {
            localg.nDt = com.tencent.mm.protocal.d.Fne;
          }
          if ((paramArrayOfByte1[0] & 0x8) != 0) {
            localg.qew = com.tencent.mm.protocal.d.Fnh;
          }
          if ((paramArrayOfByte1[0] & 0x2) != 0) {
            localg.qev = 2;
          }
          if ((paramArrayOfByte1[0] & 0x10) != 0) {
            localg.qex = ((int)bt.aQJ());
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
      ad.i("MicroMsg.exdevice.Util", "getTimeZone, rawSecond = %d, dt = %d, re = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(j) });
      localg.qey = j;
      if ((paramArrayOfByte1[0] & 0x40) != 0) {
        localg.qez = b.cmG();
      }
      if ((paramArrayOfByte1[0] & 0x1) != 0) {
        localg.qeu = u.aAo();
      }
      localg.qes = paramInt2;
      localg.qet = paramInt3;
      this.pZY = localg;
      this.pZW = 20003;
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
      ad.i("MicroMsg.exdevice.Util", "get int hashcode value = %d, long hashcode = %d", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
      break;
      paramString = null;
      break label159;
      paramString = new CRC32();
      paramString.update(paramArrayOfByte2);
      paramInt1 = (int)paramString.getValue();
      break label196;
    }
  }
  
  protected final a be(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23151);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ad.e("MicroMsg.exdevice.ExDeviceCmdInit", "data is null");
      AppMethodBeat.o(23151);
      return null;
    }
    f localf = new f();
    try
    {
      localf.parseFrom(paramArrayOfByte);
      ad.i("MicroMsg.exdevice.ExDeviceCmdInit", "------Init Request parse is ok------ ");
      this.pZZ = localf;
      AppMethodBeat.o(23151);
      return localf;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.exdevice.ExDeviceCmdInit", "pase error : " + paramArrayOfByte.getMessage());
      ad.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdInit", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(23151);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.e
 * JD-Core Version:    0.7.0.1
 */