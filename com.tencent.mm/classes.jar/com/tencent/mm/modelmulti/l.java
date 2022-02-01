package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.io;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class l
{
  public static boolean aGj()
  {
    AppMethodBeat.i(132584);
    g.agS();
    if (bs.nullAsNil((String)g.agR().agA().get(8195, null)).length() > 0)
    {
      g.agS();
      if (bs.m((Integer)g.agR().agA().get(15, null)) != 0) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(132584);
      return bool;
    }
  }
  
  public static void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    AppMethodBeat.i(132585);
    v.b localb = new v.b();
    PByteArray localPByteArray2 = new PByteArray();
    PByteArray localPByteArray1 = new PByteArray();
    PInt localPInt2 = new PInt();
    Object localObject = new PInt();
    PInt localPInt1 = new PInt(0);
    PInt localPInt3 = new PInt(255);
    try
    {
      bool1 = MMProtocalJni.unpack(localPByteArray1, paramArrayOfByte1, paramArrayOfByte2, localPByteArray2, localPInt2, (PInt)localObject, localPInt1, localPInt3);
      ac.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack ret:" + bool1 + ", noticeid:" + bool1, new Object[] { Integer.valueOf(localPInt1.value) });
      if (localPInt1.value != 0)
      {
        paramArrayOfByte2 = new io();
        paramArrayOfByte2.djO.djP = localPInt1.value;
        boolean bool2 = com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte2);
        ac.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool2) });
        localPInt1.value = 0;
      }
      if (((PInt)localObject).value == 13)
      {
        g.agS();
        paramArrayOfByte2 = g.agQ().mp(3);
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
        ac.i("MicroMsg.NewSyncMgr", i + "]");
        if (bool1) {
          break label357;
        }
        ac.e("MicroMsg.NewSyncMgr", "unpack push resp failed");
        AppMethodBeat.o(132585);
        return;
        i = paramArrayOfByte2.length;
        break;
      }
      label357:
      localb.setHeadExtFlags(localPInt3.value);
      if (localPInt2.value == -13)
      {
        localb.setRetCode(localPInt2.value);
        ac.e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
        AppMethodBeat.o(132585);
        return;
      }
      i = localb.fromProtoBuf(localPByteArray1.value);
      ac.d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
      localb.setRetCode(i);
      localb.setBufferSize(paramArrayOfByte1.length);
      g.agS();
      paramArrayOfByte1 = bs.aLu(bs.nullAsNil((String)g.agR().agA().get(8195, null)));
      paramArrayOfByte2 = z.a(localb.DJr.Eki);
      g.agS();
      g.agP().cM(localb.DJr.ndj, localb.DJr.Fnm);
      com.tencent.mm.kernel.a.mn(localb.DJr.ndj);
      if ((bs.cv(paramArrayOfByte2)) || (!ad.l(paramArrayOfByte1, paramArrayOfByte2)))
      {
        ac.e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
        AppMethodBeat.o(132585);
        return;
      }
      ((com.tencent.mm.plugin.zero.b.b)g.ab(com.tencent.mm.plugin.zero.b.b.class)).aGm().a(localb, paramInt, paramLong);
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        boolean bool1;
        ac.e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", new Object[] { paramArrayOfByte1 });
        ac.printErrStackTrace("MicroMsg.NewSyncMgr", paramArrayOfByte1, "", new Object[0]);
      }
    }
    if (localPInt1.value != 0)
    {
      paramArrayOfByte1 = new io();
      paramArrayOfByte1.djO.djP = localPInt1.value;
      bool1 = com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte1);
      ac.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool1) });
      localPInt1.value = 0;
    }
    AppMethodBeat.o(132585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.l
 * JD-Core Version:    0.7.0.1
 */