package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class k
{
  public static boolean ail()
  {
    AppMethodBeat.i(58394);
    g.RM();
    if (bo.nullAsNil((String)g.RL().Ru().get(8195, null)).length() > 0)
    {
      g.RM();
      if (bo.g((Integer)g.RL().Ru().get(15, null)) != 0) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(58394);
      return bool;
    }
  }
  
  public static void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    AppMethodBeat.i(58395);
    t.b localb = new t.b();
    PByteArray localPByteArray2 = new PByteArray();
    PByteArray localPByteArray1 = new PByteArray();
    PInt localPInt2 = new PInt();
    Object localObject = new PInt();
    PInt localPInt1 = new PInt(0);
    PInt localPInt3 = new PInt(255);
    try
    {
      bool1 = MMProtocalJni.unpack(localPByteArray1, paramArrayOfByte1, paramArrayOfByte2, localPByteArray2, localPInt2, (PInt)localObject, localPInt1, localPInt3);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack ret:" + bool1 + ", noticeid:" + bool1, new Object[] { Integer.valueOf(localPInt1.value) });
      if (localPInt1.value != 0)
      {
        paramArrayOfByte2 = new hn();
        paramArrayOfByte2.cwF.cwG = localPInt1.value;
        boolean bool2 = com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte2);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool2) });
        localPInt1.value = 0;
      }
      if (((PInt)localObject).value == 13)
      {
        g.RM();
        paramArrayOfByte2 = g.RK().jN(3);
        localPByteArray1.value = UtilsJni.AesGcmDecryptWithUncompress(paramArrayOfByte2, localPByteArray1.value);
        localObject = new StringBuilder("summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession");
        if (paramArrayOfByte2 != null) {
          break label339;
        }
        i = -1;
        paramArrayOfByte2 = ((StringBuilder)localObject).append(i).append(" new pr[").append(localPByteArray1.value).append(": ");
        if (localPByteArray1.value != null) {
          break label346;
        }
      }
      label339:
      label346:
      for (int i = -1;; i = localPByteArray1.value.length)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NewSyncMgr", i + "]");
        if (bool1) {
          break label357;
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NewSyncMgr", "unpack push resp failed");
        AppMethodBeat.o(58395);
        return;
        i = paramArrayOfByte2.length;
        break;
      }
      label357:
      localb.setHeadExtFlags(localPInt3.value);
      if (localPInt2.value == -13)
      {
        localb.setRetCode(localPInt2.value);
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
        AppMethodBeat.o(58395);
        return;
      }
      i = localb.fromProtoBuf(localPByteArray1.value);
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
      localb.setRetCode(i);
      localb.setBufferSize(paramArrayOfByte1.length);
      g.RM();
      paramArrayOfByte1 = bo.apQ(bo.nullAsNil((String)g.RL().Ru().get(8195, null)));
      paramArrayOfByte2 = aa.a(localb.wiN.wFR);
      g.RM();
      g.RJ().ci(localb.wiN.jJS, localb.wiN.xvH);
      com.tencent.mm.kernel.a.jL(localb.wiN.jJS);
      if ((bo.ce(paramArrayOfByte2)) || (!com.tencent.mm.protocal.ab.k(paramArrayOfByte1, paramArrayOfByte2)))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
        AppMethodBeat.o(58395);
        return;
      }
      ((com.tencent.mm.plugin.zero.b.b)g.E(com.tencent.mm.plugin.zero.b.b.class)).aio().a(localb, paramInt, paramLong);
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        boolean bool1;
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", new Object[] { paramArrayOfByte1 });
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NewSyncMgr", paramArrayOfByte1, "", new Object[0]);
      }
    }
    if (localPInt1.value != 0)
    {
      paramArrayOfByte1 = new hn();
      paramArrayOfByte1.cwF.cwG = localPInt1.value;
      bool1 = com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte1);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool1) });
      localPInt1.value = 0;
    }
    AppMethodBeat.o(58395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelmulti.k
 * JD-Core Version:    0.7.0.1
 */