package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.deviceinfo.q;
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
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class a
  extends p
  implements m
{
  private h callback;
  public s ouH;
  
  public a(LinkedList<afx> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(21370);
    this.ouH = new a.a();
    final k.a locala = (k.a)this.ouH.getReqObj();
    final boolean bool = this.ouH.isSingleSession();
    locala.YxW = com.tencent.mm.plugin.backup.b.d.cUN();
    locala.YxV.YKK = paramLinkedList.size();
    locala.YxV.YKL = paramLinkedList;
    locala.YxV.YKM = q.aPj();
    locala.YxV.YKN = z.bAM();
    locala.YxV.IJG = 2;
    locala.YxV.vhg = 0L;
    locala.YxV.YKO = paramString1;
    locala.YxV.YKP = paramString2;
    locala.setPassKey(locala.YxW);
    if (!bool) {
      locala.YxX = locala.YxW;
    }
    locala.setReqPackControl(new l.a()
    {
      public final boolean reqToBuf(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, byte[] paramAnonymousArrayOfByte3, int paramAnonymousInt2, boolean paramAnonymousBoolean, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(300762);
        long l = locala.getUin();
        if ((CrashReportFactory.hasDebuger()) && (l == 0L)) {
          l = com.tencent.mm.protocal.d.Yxg;
        }
        for (;;)
        {
          ac localac = locala.getRsaInfo();
          if (paramAnonymousInt1 == 1000)
          {
            paramAnonymousArrayOfByte1 = locala.getPassKey();
            if (!localac.iQg()) {
              paramAnonymousArrayOfByte1 = new byte[0];
            }
            if (bool) {
              break label334;
            }
            paramAnonymousArrayOfByte1 = locala.YxX;
            locala.setPassKey(locala.YxX);
          }
          label334:
          for (;;)
          {
            if (Util.isNullOrNil(paramAnonymousArrayOfByte1))
            {
              Log.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", new Object[] { Integer.valueOf(paramAnonymousInt1) });
              AppMethodBeat.o(300762);
              return false;
            }
            byte[] arrayOfByte = locala.toProtoBuf();
            paramAnonymousInt2 = 0;
            paramAnonymousInt1 = paramAnonymousInt2;
            if (!Util.isNullOrNil(paramAnonymousArrayOfByte3))
            {
              paramAnonymousInt1 = paramAnonymousInt2;
              if (!Util.isNullOrNil(arrayOfByte)) {
                paramAnonymousInt1 = MMProtocalJni.genSignature((int)l, paramAnonymousArrayOfByte3, arrayOfByte);
              }
            }
            paramAnonymousInt2 = 0;
            paramAnonymousArrayOfByte3 = arrayOfByte;
            if (!bool)
            {
              paramAnonymousArrayOfByte3 = UtilsJni.AesGcmEncryptWithCompress(paramAnonymousArrayOfByte1, arrayOfByte);
              paramAnonymousInt2 = 13;
              Log.d("MicroMsg.BackupCreateQRCodeOfflineScene", "not single session , use aes gcm encrypt");
            }
            Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "start to encode ,entype is %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
            if (MMProtocalJni.pack(paramAnonymousArrayOfByte3, paramAnonymousPByteArray, paramAnonymousArrayOfByte1, paramAnonymousInt2, paramAnonymousArrayOfByte2, locala.getDeviceID(), (int)l, locala.getFuncId(), localac.ver, localac.YyO.getBytes(), localac.YyP.getBytes(), paramAnonymousInt1, paramAnonymousInt3, locala.getRouteInfo(), 0))
            {
              Log.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt3) });
              AppMethodBeat.o(300762);
              return true;
            }
            AppMethodBeat.o(300762);
            return false;
          }
        }
      }
    });
    AppMethodBeat.o(21370);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(21371);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
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
    Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { ((k.b)params.getRespObj()).YxY.YKR });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a
 * JD-Core Version:    0.7.0.1
 */