package com.tencent.mm.modelmulti;

import com.tencent.mm.h.a.hj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class k
{
  public static boolean Pj()
  {
    g.DQ();
    if (bk.pm((String)g.DP().Dz().get(8195, null)).length() > 0)
    {
      g.DQ();
      if (bk.g((Integer)g.DP().Dz().get(15, null)) != 0) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    s.b localb = new s.b();
    PByteArray localPByteArray2 = new PByteArray();
    PByteArray localPByteArray1 = new PByteArray();
    PInt localPInt2 = new PInt();
    PInt localPInt4 = new PInt();
    PInt localPInt1 = new PInt(0);
    PInt localPInt3 = new PInt(255);
    try
    {
      bool1 = MMProtocalJni.unpack(localPByteArray1, paramArrayOfByte1, paramArrayOfByte2, localPByteArray2, localPInt2, localPInt4, localPInt1, localPInt3);
      y.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack ret[%b], noticeid[%d]", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(localPInt1.value) });
      if (localPInt1.value != 0)
      {
        paramArrayOfByte2 = new hj();
        paramArrayOfByte2.bPm.bPn = localPInt1.value;
        boolean bool2 = com.tencent.mm.sdk.b.a.udP.m(paramArrayOfByte2);
        y.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool2) });
        localPInt1.value = 0;
      }
      if (!bool1)
      {
        y.e("MicroMsg.NewSyncMgr", "unpack push resp failed");
        return;
      }
      localb.spO = localPInt3.value;
      if (localPInt2.value == -13)
      {
        localb.spN = localPInt2.value;
        y.e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
        return;
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      boolean bool1;
      y.e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", new Object[] { paramArrayOfByte1 });
      y.printErrStackTrace("MicroMsg.NewSyncMgr", paramArrayOfByte1, "", new Object[0]);
      while (localPInt1.value != 0)
      {
        paramArrayOfByte1 = new hj();
        paramArrayOfByte1.bPm.bPn = localPInt1.value;
        bool1 = com.tencent.mm.sdk.b.a.udP.m(paramArrayOfByte1);
        y.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool1) });
        localPInt1.value = 0;
        return;
        int i = localb.A(localPByteArray1.value);
        y.d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
        localb.spN = i;
        localb.bufferSize = paramArrayOfByte1.length;
        g.DQ();
        paramArrayOfByte1 = bk.ZM(bk.pm((String)g.DP().Dz().get(8195, null)));
        paramArrayOfByte2 = aa.a(localb.sqj.sIi);
        g.DQ();
        g.DN().be(localb.sqj.hQq, localb.sqj.tvw);
        com.tencent.mm.kernel.a.hv(localb.sqj.hQq);
        if ((bk.bE(paramArrayOfByte2)) || (!com.tencent.mm.protocal.z.h(paramArrayOfByte1, paramArrayOfByte2)))
        {
          y.e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
          return;
        }
        ((b)g.r(b.class)).Pm().a(localb, paramInt, paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelmulti.k
 * JD-Core Version:    0.7.0.1
 */