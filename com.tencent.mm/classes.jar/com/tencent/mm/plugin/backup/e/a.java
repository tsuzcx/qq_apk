package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
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
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  public s iMO;
  
  public a(LinkedList<adi> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(21370);
    this.iMO = new a.a();
    final k.a locala = (k.a)this.iMO.getReqObj();
    final boolean bool = this.iMO.isSingleSession();
    locala.KzD = com.tencent.mm.plugin.backup.b.d.ceQ();
    locala.KzC.KMC = paramLinkedList.size();
    locala.KzC.KMD = paramLinkedList;
    locala.KzC.KME = com.tencent.mm.compatible.deviceinfo.q.aoJ();
    locala.KzC.KMF = z.aTY();
    locala.KzC.Scene = 2;
    locala.KzC.oTS = 0L;
    locala.KzC.KMG = paramString1;
    locala.KzC.KMH = paramString2;
    locala.setPassKey(locala.KzD);
    if (!bool) {
      locala.KzE = locala.KzD;
    }
    locala.setReqPackControl(new l.a()
    {
      public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21368);
        long l = locala.getUin();
        if ((CrashReportFactory.hasDebuger()) && (l == 0L)) {
          l = com.tencent.mm.protocal.d.KyN;
        }
        for (;;)
        {
          ac localac = locala.getRsaInfo();
          byte[] arrayOfByte1;
          if (paramAnonymousInt1 == 1000)
          {
            arrayOfByte1 = locala.getPassKey();
            if (!localac.gtU()) {
              arrayOfByte1 = new byte[0];
            }
            if (bool) {
              break label343;
            }
            arrayOfByte1 = locala.KzE;
            locala.setPassKey(locala.KzE);
          }
          label343:
          for (;;)
          {
            if (Util.isNullOrNil(arrayOfByte1))
            {
              Log.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              AppMethodBeat.o(21368);
              return false;
            }
            byte[] arrayOfByte2 = locala.toProtoBuf();
            int i = 0;
            paramAnonymousInt1 = i;
            if (!Util.isNullOrNil(paramAnonymousArrayOfByte2))
            {
              paramAnonymousInt1 = i;
              if (!Util.isNullOrNil(arrayOfByte2)) {
                paramAnonymousInt1 = MMProtocalJni.genSignature((int)l, paramAnonymousArrayOfByte2, arrayOfByte2);
              }
            }
            i = 0;
            paramAnonymousArrayOfByte2 = arrayOfByte2;
            if (!bool)
            {
              paramAnonymousArrayOfByte2 = UtilsJni.AesGcmEncryptWithCompress(arrayOfByte1, arrayOfByte2);
              i = 13;
              Log.d("MicroMsg.BackupCreateQRCodeOfflineScene", "not single session , use aes gcm encrypt");
            }
            Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "start to encode ,entype is %d", new Object[] { Integer.valueOf(i) });
            if (MMProtocalJni.pack(paramAnonymousArrayOfByte2, paramAnonymousPByteArray, arrayOfByte1, i, paramAnonymousArrayOfByte1, locala.getDeviceID(), (int)l, locala.getFuncId(), localac.ver, localac.KAw.getBytes(), localac.KAx.getBytes(), paramAnonymousInt1, paramAnonymousInt2, locala.getRouteInfo(), 0))
            {
              Log.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2) });
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
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(21371);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
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
    Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { ((k.b)params.getRespObj()).KzF.KMJ });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a
 * JD-Core Version:    0.7.0.1
 */