package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.l.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bs;

final class a$1
  implements l.a
{
  a$1(a parama, k.a parama1, boolean paramBoolean) {}
  
  public final boolean a(PByteArray paramPByteArray, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2)
  {
    AppMethodBeat.i(21368);
    long l = this.mVJ.getUin();
    if ((b.eUk()) && (l == 0L)) {
      l = d.DIb;
    }
    for (;;)
    {
      com.tencent.mm.protocal.ac localac = this.mVJ.getRsaInfo();
      byte[] arrayOfByte1;
      if (paramInt1 == 1000)
      {
        arrayOfByte1 = this.mVJ.getPassKey();
        if (!localac.eRw()) {
          arrayOfByte1 = new byte[0];
        }
        if (this.mVK) {
          break label342;
        }
        arrayOfByte1 = this.mVJ.DIO;
        this.mVJ.setPassKey(this.mVJ.DIO);
      }
      label342:
      for (;;)
      {
        if (bs.cv(arrayOfByte1))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramInt1) });
          AppMethodBeat.o(21368);
          return false;
        }
        byte[] arrayOfByte2 = this.mVJ.toProtoBuf();
        int i = 0;
        paramInt1 = i;
        if (!bs.cv(paramArrayOfByte2))
        {
          paramInt1 = i;
          if (!bs.cv(arrayOfByte2)) {
            paramInt1 = MMProtocalJni.genSignature((int)l, paramArrayOfByte2, arrayOfByte2);
          }
        }
        i = 0;
        paramArrayOfByte2 = arrayOfByte2;
        if (!this.mVK)
        {
          paramArrayOfByte2 = UtilsJni.AesGcmEncryptWithCompress(arrayOfByte1, arrayOfByte2);
          i = 13;
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BackupCreateQRCodeOfflineScene", "not single session , use aes gcm encrypt");
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupCreateQRCodeOfflineScene", "start to encode ,entype is %d", new Object[] { Integer.valueOf(i) });
        if (MMProtocalJni.pack(paramArrayOfByte2, paramPByteArray, arrayOfByte1, i, paramArrayOfByte1, this.mVJ.getDeviceID(), (int)l, this.mVJ.getFuncId(), localac.ver, localac.DJD.getBytes(), localac.DJE.getBytes(), paramInt1, paramInt2, this.mVJ.getRouteInfo()))
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramPByteArray.value.length), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(21368);
          return true;
        }
        AppMethodBeat.o(21368);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a.1
 * JD-Core Version:    0.7.0.1
 */