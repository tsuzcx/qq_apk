package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.l;
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
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private g callback;
  public com.tencent.mm.network.q gVZ;
  
  public a(LinkedList<yf> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(21370);
    this.gVZ = new a();
    final k.a locala = (k.a)this.gVZ.getReqObj();
    final boolean bool = this.gVZ.isSingleSession();
    locala.Cqv = com.tencent.mm.plugin.backup.b.d.bvX();
    locala.Cqu.CCF = paramLinkedList.size();
    locala.Cqu.CCG = paramLinkedList;
    locala.Cqu.CCH = com.tencent.mm.compatible.deviceinfo.q.Xd();
    locala.Cqu.CCI = u.aqG();
    locala.Cqu.Scene = 2;
    locala.Cqu.mBe = 0L;
    locala.Cqu.CCJ = paramString1;
    locala.Cqu.CCK = paramString2;
    locala.setPassKey(locala.Cqv);
    if (!bool) {
      locala.Cqw = locala.Cqv;
    }
    locala.setReqPackControl(new l.a()
    {
      public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21368);
        long l = locala.getUin();
        if ((b.eEQ()) && (l == 0L)) {
          l = com.tencent.mm.protocal.d.CpJ;
        }
        for (;;)
        {
          ac localac = locala.getRsaInfo();
          byte[] arrayOfByte1;
          if (paramAnonymousInt1 == 1000)
          {
            arrayOfByte1 = locala.getPassKey();
            if (!localac.eCb()) {
              arrayOfByte1 = new byte[0];
            }
            if (bool) {
              break label342;
            }
            arrayOfByte1 = locala.Cqw;
            locala.setPassKey(locala.Cqw);
          }
          label342:
          for (;;)
          {
            if (bt.cw(arrayOfByte1))
            {
              ad.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              AppMethodBeat.o(21368);
              return false;
            }
            byte[] arrayOfByte2 = locala.toProtoBuf();
            int i = 0;
            paramAnonymousInt1 = i;
            if (!bt.cw(paramAnonymousArrayOfByte2))
            {
              paramAnonymousInt1 = i;
              if (!bt.cw(arrayOfByte2)) {
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
            if (MMProtocalJni.pack(paramAnonymousArrayOfByte2, paramAnonymousPByteArray, arrayOfByte1, i, paramAnonymousArrayOfByte1, locala.getDeviceID(), (int)l, locala.getFuncId(), localac.ver, localac.Crl.getBytes(), localac.Crm.getBytes(), paramAnonymousInt1, paramAnonymousInt2, locala.getRouteInfo()))
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
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(21371);
    this.callback = paramg;
    int i = dispatch(parame, this.gVZ, this);
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
    ad.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { ((k.b)paramq.getRespObj()).Cqx.CCM });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21372);
  }
  
  public static final class a
    extends l
  {
    private final k.a mtK;
    private final k.b mtL;
    
    public a()
    {
      AppMethodBeat.i(21369);
      this.mtK = new k.a();
      this.mtL = new k.b();
      AppMethodBeat.o(21369);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.mtK;
    }
    
    public final l.e getRespObj()
    {
      return this.mtL;
    }
    
    public final int getType()
    {
      return 1000;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/bakchatcreateqrcodeoffline";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a
 * JD-Core Version:    0.7.0.1
 */