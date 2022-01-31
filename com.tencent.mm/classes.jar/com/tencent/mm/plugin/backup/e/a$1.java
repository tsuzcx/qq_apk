package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.a;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bk;

final class a$1
  implements k.a
{
  a$1(a parama, j.a parama1) {}
  
  public final boolean a(PByteArray paramPByteArray, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2)
  {
    long l = this.hIM.spE;
    if ((b.cqk()) && (l == 0L)) {
      l = d.soZ;
    }
    for (;;)
    {
      com.tencent.mm.protocal.y localy = this.hIM.spM;
      if (paramInt1 == 1000)
      {
        byte[] arrayOfByte = this.hIM.spL;
        if (!localy.cpk()) {
          arrayOfByte = new byte[0];
        }
        if (bk.bE(arrayOfByte))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramInt1) });
          return false;
        }
        if (MMProtocalJni.pack(this.hIM.HG(), paramPByteArray, arrayOfByte, paramArrayOfByte1, this.hIM.spH, (int)l, 1000, localy.ver, localy.sqr.getBytes(), localy.sqs.getBytes(), paramArrayOfByte2, paramInt2, this.hIM.ecM))
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramPByteArray.value.length), Integer.valueOf(paramInt2) });
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a.1
 * JD-Core Version:    0.7.0.1
 */