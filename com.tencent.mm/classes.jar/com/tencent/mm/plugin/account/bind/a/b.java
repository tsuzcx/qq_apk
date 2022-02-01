package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.ac;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ch;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.Set;

public final class b
  extends q
  implements m
{
  private i callback;
  private String dOX;
  private String dOZ;
  public long jkB;
  public final d rr;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109745);
    this.jkB = 0L;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new mj();
    ((d.a)localObject).iLO = new mk();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bindqq";
    ((d.a)localObject).funcId = 144;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    this.jkB = paramLong;
    localObject = (mj)this.rr.iLK.iLR;
    ((mj)localObject).KQu = new p(paramLong).intValue();
    ((mj)localObject).KQi = "";
    ((mj)localObject).KQv = "";
    ((mj)localObject).KQw = "";
    ((mj)localObject).KQx = "";
    ((mj)localObject).KQz = new dqi().bhy("");
    ((mj)localObject).KQy = 1;
    if (paramBoolean == true) {}
    for (paramString1 = com.tencent.mm.kernel.g.aAf().azh().e(paramLong, paramString3);; paramString1 = com.tencent.mm.kernel.g.aAf().azh().a(paramLong, Util.getFullPasswordMD5(paramString1), true))
    {
      ((mj)localObject).KNX = new SKBuiltinBuffer_t().setBuffer(paramString1);
      String str = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(47, null));
      ((mj)localObject).KQA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(str));
      Log.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(Util.getLength(paramString1)), paramString3, paramString2, paramString4, str });
      AppMethodBeat.o(109745);
      return;
    }
  }
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramString3, paramString4, 1, paramBoolean);
    AppMethodBeat.i(109746);
    this.dOX = paramString5;
    this.dOZ = paramString6;
    paramString1 = (mj)this.rr.iLK.iLR;
    paramString1.KPU = paramString5;
    paramString1.KPV = paramString6;
    AppMethodBeat.o(109746);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(109747);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(109747);
    return i;
  }
  
  public final int getType()
  {
    return 144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109748);
    params = (mj)this.rr.iLK.iLR;
    paramArrayOfByte = (mk)this.rr.iLL.iLR;
    Object localObject = com.tencent.mm.platformtools.z.a(paramArrayOfByte.KLb);
    if (!Util.isNullOrNil((byte[])localObject)) {}
    for (boolean bool1 = com.tencent.mm.kernel.g.aAf().azh().a(new p(params.KQu).longValue(), (byte[])localObject);; bool1 = false)
    {
      if ((bool1) && (com.tencent.mm.kernel.g.aAc())) {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oou, Boolean.TRUE);
      }
      Log.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool1), Integer.valueOf(Util.getLength((byte[])localObject)), paramArrayOfByte.KQw });
      boolean bool2;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramInt1 = com.tencent.mm.kernel.g.aAh().azQ().getInt(9, 0);
        com.tencent.mm.kernel.g.aAh().azQ().set(9, Integer.valueOf(params.KQu));
        if (paramInt1 != 0)
        {
          if (com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ogq, "").equals(String.valueOf(paramInt1))) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogq, com.tencent.mm.model.z.aTY());
          }
          localObject = ch.iFO.aWo().iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (String.valueOf(paramInt1).equals(ch.iFO.getString(str, "login_user_name"))) {
              ch.iFO.l(str, "login_user_name", str);
            }
          }
        }
        if (params.KQy == 1) {
          com.tencent.mm.kernel.g.aAh().azQ().set(17, Integer.valueOf(paramArrayOfByte.KEi));
        }
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW();
        String str = paramArrayOfByte.KQD;
        if (paramArrayOfByte.KQC == 1)
        {
          bool2 = true;
          ((com.tencent.mm.plugin.messenger.foundation.a.a.l)localObject).bO(str, bool2);
          paramInt1 = params.KQu;
          if (paramInt1 != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().eJ(new p(paramInt1) + "@qqim", 3);
          }
          c.e(paramInt1, 3);
          com.tencent.mm.kernel.g.aAh().azQ().set(32, params.KQi);
          com.tencent.mm.kernel.g.aAh().azQ().set(33, params.KQv);
          localObject = Util.encodeHexString(com.tencent.mm.kernel.g.aAf().azh().Aj(new p(params.KQu).longValue()));
          Log.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[] { Boolean.valueOf(bool1), Util.secPrint((String)localObject) });
          com.tencent.mm.kernel.g.aAh().azQ().set(72, localObject);
          com.tencent.mm.kernel.g.aAh().azQ().set(46, Util.encodeHexString(com.tencent.mm.platformtools.z.a(paramArrayOfByte.KLh)));
          localObject = Util.encodeHexString(com.tencent.mm.platformtools.z.a(params.KQA));
          com.tencent.mm.kernel.g.aAh().azQ().set(47, localObject);
          com.tencent.mm.kernel.g.aAh().hqB.set(18, localObject);
          com.tencent.mm.kernel.g.aAh().azQ().set(-1535680990, paramArrayOfByte.KQE);
        }
      }
      for (;;)
      {
        paramInt1 = paramInt3;
        if (params.KQy == 3)
        {
          paramInt1 = paramInt3;
          if (paramInt3 == -3)
          {
            paramInt1 = 10000;
            Log.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
        AppMethodBeat.o(109748);
        return;
        bool2 = false;
        break;
        if (paramInt2 == 4)
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(32, "");
          com.tencent.mm.kernel.g.aAh().azQ().set(33, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.b
 * JD-Core Version:    0.7.0.1
 */