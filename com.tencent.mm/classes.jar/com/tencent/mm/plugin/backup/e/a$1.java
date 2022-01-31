package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.l.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$1
  implements l.a
{
  a$1(a parama, k.a parama1) {}
  
  public final boolean a(PByteArray paramPByteArray, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2)
  {
    AppMethodBeat.i(17310);
    long l = this.jCm.getUin();
    if ((b.dsf()) && (l == 0L)) {
      l = d.whG;
    }
    for (;;)
    {
      aa localaa = this.jCm.getRsaInfo();
      if (paramInt1 == 1000)
      {
        byte[] arrayOfByte1 = this.jCm.getPassKey();
        if (!localaa.dqH()) {
          arrayOfByte1 = new byte[0];
        }
        if (bo.ce(arrayOfByte1))
        {
          ab.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramInt1) });
          AppMethodBeat.o(17310);
          return false;
        }
        byte[] arrayOfByte2 = this.jCm.toProtoBuf();
        int i = 0;
        paramInt1 = i;
        if (!bo.ce(paramArrayOfByte2))
        {
          paramInt1 = i;
          if (!bo.ce(arrayOfByte2)) {
            paramInt1 = MMProtocalJni.genSignature((int)l, paramArrayOfByte2, arrayOfByte2);
          }
        }
        if (MMProtocalJni.pack(arrayOfByte2, paramPByteArray, arrayOfByte1, 0, paramArrayOfByte1, this.jCm.getDeviceID(), (int)l, this.jCm.getFuncId(), localaa.ver, localaa.wiZ.getBytes(), localaa.wja.getBytes(), paramInt1, paramInt2, this.jCm.getRouteInfo()))
        {
          ab.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramPByteArray.value.length), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(17310);
          return true;
        }
      }
      AppMethodBeat.o(17310);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a.1
 * JD-Core Version:    0.7.0.1
 */