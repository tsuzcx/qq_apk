package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.v;
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
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private f callback;
  public com.tencent.mm.network.q hRG;
  
  public a(LinkedList<abj> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(21370);
    this.hRG = new a();
    final k.a locala = (k.a)this.hRG.getReqObj();
    final boolean bool = this.hRG.isSingleSession();
    locala.FGs = com.tencent.mm.plugin.backup.b.d.bHZ();
    locala.FGr.FST = paramLinkedList.size();
    locala.FGr.FSU = paramLinkedList;
    locala.FGr.FSV = com.tencent.mm.compatible.deviceinfo.q.aaK();
    locala.FGr.FSW = v.aAC();
    locala.FGr.Scene = 2;
    locala.FGr.nIX = 0L;
    locala.FGr.FSX = paramString1;
    locala.FGr.FSY = paramString2;
    locala.setPassKey(locala.FGs);
    if (!bool) {
      locala.FGt = locala.FGs;
    }
    locala.setReqPackControl(new l.a()
    {
      public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21368);
        long l = locala.getUin();
        if ((b.fnF()) && (l == 0L)) {
          l = com.tencent.mm.protocal.d.FFG;
        }
        for (;;)
        {
          ac localac = locala.getRsaInfo();
          byte[] arrayOfByte1;
          if (paramAnonymousInt1 == 1000)
          {
            arrayOfByte1 = locala.getPassKey();
            if (!localac.fkq()) {
              arrayOfByte1 = new byte[0];
            }
            if (bool) {
              break label343;
            }
            arrayOfByte1 = locala.FGt;
            locala.setPassKey(locala.FGt);
          }
          label343:
          for (;;)
          {
            if (bu.cF(arrayOfByte1))
            {
              ae.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              AppMethodBeat.o(21368);
              return false;
            }
            byte[] arrayOfByte2 = locala.toProtoBuf();
            int i = 0;
            paramAnonymousInt1 = i;
            if (!bu.cF(paramAnonymousArrayOfByte2))
            {
              paramAnonymousInt1 = i;
              if (!bu.cF(arrayOfByte2)) {
                paramAnonymousInt1 = MMProtocalJni.genSignature((int)l, paramAnonymousArrayOfByte2, arrayOfByte2);
              }
            }
            i = 0;
            paramAnonymousArrayOfByte2 = arrayOfByte2;
            if (!bool)
            {
              paramAnonymousArrayOfByte2 = UtilsJni.AesGcmEncryptWithCompress(arrayOfByte1, arrayOfByte2);
              i = 13;
              ae.d("MicroMsg.BackupCreateQRCodeOfflineScene", "not single session , use aes gcm encrypt");
            }
            ae.i("MicroMsg.BackupCreateQRCodeOfflineScene", "start to encode ,entype is %d", new Object[] { Integer.valueOf(i) });
            if (MMProtocalJni.pack(paramAnonymousArrayOfByte2, paramAnonymousPByteArray, arrayOfByte1, i, paramAnonymousArrayOfByte1, locala.getDeviceID(), (int)l, locala.getFuncId(), localac.ver, localac.FHi.getBytes(), localac.FHj.getBytes(), paramAnonymousInt1, paramAnonymousInt2, locala.getRouteInfo(), 0))
            {
              ae.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2) });
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
    int i = dispatch(parame, this.hRG, this);
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
    ae.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(21372);
      return;
    }
    ae.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { ((k.b)paramq.getRespObj()).FGu.FTa });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21372);
  }
  
  public static final class a
    extends l
  {
    private final k.a nBE;
    private final k.b nBF;
    
    public a()
    {
      AppMethodBeat.i(21369);
      this.nBE = new k.a();
      this.nBF = new k.b();
      AppMethodBeat.o(21369);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.nBE;
    }
    
    public final l.e getRespObj()
    {
      return this.nBF;
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