package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.f.f;
import com.tencent.mm.plugin.exdevice.f.g;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
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
    Log.i("MicroMsg.exdevice.ExDeviceCmdInit", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    AppMethodBeat.o(23150);
  }
  
  public final void a(int paramInt1, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(23152);
    Log.i("MicroMsg.exdevice.ExDeviceCmdInit", "------initResponse------ errorCode = %d, errMsg = %s, filter = %s, challenge = %s, initScene = %d, second = %d", new Object[] { Integer.valueOf(paramInt1), paramString, b.bK(paramArrayOfByte1), b.bK(paramArrayOfByte2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    g localg = new g();
    localg.ytL = bh(0, "ok");
    paramString = z.bAM();
    long l;
    label159:
    label196:
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = MD5Util.getMD5String(paramString).toLowerCase();
      Log.i("MicroMsg.exdevice.Util", "user md5 : [%s]", new Object[] { paramString });
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.exdevice.Util", "get hash code failed, value is null or nill");
        l = 0L;
        paramString = new int[] { (int)(l >> 32 & 0xFFFFFFFF), (int)(l & 0xFFFFFFFF) };
        localg.ytz = paramString[0];
        localg.ytA = paramString[1];
        if (!Util.isNullOrNil(paramArrayOfByte2))
        {
          if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
            break label532;
          }
          paramInt1 = 0;
          localg.ytB = paramInt1;
        }
        if (!Util.isNullOrNil(paramArrayOfByte1))
        {
          if ((paramArrayOfByte1[0] & 0x4) != 0) {
            localg.vgX = com.tencent.mm.protocal.d.Yxb;
          }
          if ((paramArrayOfByte1[0] & 0x8) != 0) {
            localg.ytG = com.tencent.mm.protocal.d.Yxe;
          }
          if ((paramArrayOfByte1[0] & 0x2) != 0) {
            localg.ytF = 2;
          }
          if ((paramArrayOfByte1[0] & 0x10) != 0) {
            localg.crm = ((int)Util.nowSecond());
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
      Log.i("MicroMsg.exdevice.Util", "getTimeZone, rawSecond = %d, dt = %d, re = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(j) });
      localg.ytH = j;
      if ((paramArrayOfByte1[0] & 0x40) != 0) {
        localg.ytI = b.dHq();
      }
      if ((paramArrayOfByte1[0] & 0x1) != 0) {
        localg.ytE = z.bAO();
      }
      localg.ytC = paramInt2;
      localg.ytD = paramInt3;
      this.yoS = localg;
      this.yoQ = 20003;
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
      Log.i("MicroMsg.exdevice.Util", "get int hashcode value = %d, long hashcode = %d", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
      break;
      paramString = null;
      break label159;
      paramString = new CRC32();
      paramString.update(paramArrayOfByte2);
      paramInt1 = (int)paramString.getValue();
      break label196;
    }
  }
  
  protected final a bI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23151);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.exdevice.ExDeviceCmdInit", "data is null");
      AppMethodBeat.o(23151);
      return null;
    }
    f localf = new f();
    try
    {
      localf.parseFrom(paramArrayOfByte);
      Log.i("MicroMsg.exdevice.ExDeviceCmdInit", "------Init Request parse is ok------ ");
      this.yoT = localf;
      AppMethodBeat.o(23151);
      return localf;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.exdevice.ExDeviceCmdInit", "pase error : " + paramArrayOfByte.getMessage());
      Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdInit", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(23151);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.e
 * JD-Core Version:    0.7.0.1
 */