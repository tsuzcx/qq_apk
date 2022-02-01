package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.l.a;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.network.q hON;
  
  public a(LinkedList<aba> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(21370);
    this.hON = new a.a();
    final k.a locala = (k.a)this.hON.getReqObj();
    final boolean bool = this.hON.isSingleSession();
    locala.FnU = com.tencent.mm.plugin.backup.b.d.bHb();
    locala.FnT.FAx = paramLinkedList.size();
    locala.FnT.FAy = paramLinkedList;
    locala.FnT.FAz = com.tencent.mm.compatible.deviceinfo.q.aaB();
    locala.FnT.FAA = u.aAm();
    locala.FnT.Scene = 2;
    locala.FnT.nDC = 0L;
    locala.FnT.FAB = paramString1;
    locala.FnT.FAC = paramString2;
    locala.setPassKey(locala.FnU);
    if (!bool) {
      locala.FnV = locala.FnU;
    }
    locala.setReqPackControl(new l.a()
    {
      public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21368);
        long l = locala.getUin();
        if ((b.fjN()) && (l == 0L)) {
          l = com.tencent.mm.protocal.d.Fni;
        }
        for (;;)
        {
          ac localac = locala.getRsaInfo();
          byte[] arrayOfByte1;
          if (paramAnonymousInt1 == 1000)
          {
            arrayOfByte1 = locala.getPassKey();
            if (!localac.fgA()) {
              arrayOfByte1 = new byte[0];
            }
            if (bool) {
              break label343;
            }
            arrayOfByte1 = locala.FnV;
            locala.setPassKey(locala.FnV);
          }
          label343:
          for (;;)
          {
            if (bt.cC(arrayOfByte1))
            {
              ad.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              AppMethodBeat.o(21368);
              return false;
            }
            byte[] arrayOfByte2 = locala.toProtoBuf();
            int i = 0;
            paramAnonymousInt1 = i;
            if (!bt.cC(paramAnonymousArrayOfByte2))
            {
              paramAnonymousInt1 = i;
              if (!bt.cC(arrayOfByte2)) {
                paramAnonymousInt1 = MMProtocalJni.genSignature((int)l, paramAnonymousArrayOfByte2, arrayOfByte2);
              }
            }
            i = 0;
            paramAnonymousArrayOfByte2 = arrayOfByte2;
            if (!bool)
            {
              paramAnonymousArrayOfByte2 = UtilsJni.AesGcmEncryptWithCompress(arrayOfByte1, arrayOfByte2);
              i = 13;
              ad.d("MicroMsg.BackupCreateQRCodeOfflineScene", "not single session , use aes gcm encrypt");
            }
            ad.i("MicroMsg.BackupCreateQRCodeOfflineScene", "start to encode ,entype is %d", new Object[] { Integer.valueOf(i) });
            if (MMProtocalJni.pack(paramAnonymousArrayOfByte2, paramAnonymousPByteArray, arrayOfByte1, i, paramAnonymousArrayOfByte1, locala.getDeviceID(), (int)l, locala.getFuncId(), localac.ver, localac.FoK.getBytes(), localac.FoL.getBytes(), paramAnonymousInt1, paramAnonymousInt2, locala.getRouteInfo(), 0))
            {
              ad.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2) });
              AppMethodBeat.o(21368);
              return true;
            }
            AppMethodBeat.o(21368);
            return false;
          }
        }
      }
    });
    AppMethodBeat.o(21370);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(21371);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(21371);
    return i;
  }
  
  public final int getType()
  {
    return 1000;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21372);
    ad.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(21372);
      return;
    }
    ad.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { ((k.b)paramq.getRespObj()).FnW.FAE });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a
 * JD-Core Version:    0.7.0.1
 */