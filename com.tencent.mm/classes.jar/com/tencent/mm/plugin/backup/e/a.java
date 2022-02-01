package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.o;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.l.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  public s lCW;
  
  public a(LinkedList<adp> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(21370);
    this.lCW = new a();
    final k.a locala = (k.a)this.lCW.getReqObj();
    final boolean bool = this.lCW.isSingleSession();
    locala.RBt = com.tencent.mm.plugin.backup.b.d.csd();
    locala.RBs.RNw = paramLinkedList.size();
    locala.RBs.RNx = paramLinkedList;
    locala.RBs.RNy = com.tencent.mm.compatible.deviceinfo.q.auP();
    locala.RBs.RNz = z.bcZ();
    locala.RBs.CPw = 2;
    locala.RBs.rVQ = 0L;
    locala.RBs.RNA = paramString1;
    locala.RBs.RNB = paramString2;
    locala.setPassKey(locala.RBt);
    if (!bool) {
      locala.RBu = locala.RBt;
    }
    locala.setReqPackControl(new l.a()
    {
      public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(287050);
        long l = locala.getUin();
        if ((CrashReportFactory.hasDebuger()) && (l == 0L)) {
          l = com.tencent.mm.protocal.d.RAC;
        }
        for (;;)
        {
          ac localac = locala.getRsaInfo();
          byte[] arrayOfByte1;
          if (paramAnonymousInt1 == 1000)
          {
            arrayOfByte1 = locala.getPassKey();
            if (!localac.hpl()) {
              arrayOfByte1 = new byte[0];
            }
            if (bool) {
              break label339;
            }
            arrayOfByte1 = locala.RBu;
            locala.setPassKey(locala.RBu);
          }
          label339:
          for (;;)
          {
            if (Util.isNullOrNil(arrayOfByte1))
            {
              Log.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              AppMethodBeat.o(287050);
              return false;
            }
            byte[] arrayOfByte2 = locala.toProtoBuf();
            paramAnonymousInt3 = 0;
            paramAnonymousInt1 = paramAnonymousInt3;
            if (!Util.isNullOrNil(paramAnonymousArrayOfByte2))
            {
              paramAnonymousInt1 = paramAnonymousInt3;
              if (!Util.isNullOrNil(arrayOfByte2)) {
                paramAnonymousInt1 = MMProtocalJni.genSignature((int)l, paramAnonymousArrayOfByte2, arrayOfByte2);
              }
            }
            paramAnonymousInt3 = 0;
            paramAnonymousArrayOfByte2 = arrayOfByte2;
            if (!bool)
            {
              paramAnonymousArrayOfByte2 = UtilsJni.AesGcmEncryptWithCompress(arrayOfByte1, arrayOfByte2);
              paramAnonymousInt3 = 13;
              Log.d("MicroMsg.BackupCreateQRCodeOfflineScene", "not single session , use aes gcm encrypt");
            }
            Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "start to encode ,entype is %d", new Object[] { Integer.valueOf(paramAnonymousInt3) });
            if (MMProtocalJni.pack(paramAnonymousArrayOfByte2, paramAnonymousPByteArray, arrayOfByte1, paramAnonymousInt3, paramAnonymousArrayOfByte1, locala.getDeviceID(), (int)l, locala.getFuncId(), localac.ver, localac.RCm.getBytes(), localac.RCn.getBytes(), paramAnonymousInt1, paramAnonymousInt2, locala.getRouteInfo(), 0))
            {
              Log.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2) });
              AppMethodBeat.o(287050);
              return true;
            }
            AppMethodBeat.o(287050);
            return false;
          }
        }
      }
    });
    AppMethodBeat.o(21370);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(21371);
    this.callback = parami;
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(21371);
    return i;
  }
  
  public final int getType()
  {
    return 1000;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21372);
    Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(21372);
      return;
    }
    Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { ((k.b)params.getRespObj()).RBv.RND });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21372);
  }
  
  public static final class a
    extends o
  {
    private final k.b rOA;
    private final k.a rOz;
    
    public a()
    {
      AppMethodBeat.i(21369);
      this.rOz = new k.a();
      this.rOA = new k.b();
      AppMethodBeat.o(21369);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.rOz;
    }
    
    public final l.e getRespObj()
    {
      return this.rOA;
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