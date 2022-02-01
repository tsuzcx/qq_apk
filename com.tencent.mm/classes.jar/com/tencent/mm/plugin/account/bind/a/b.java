package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ac;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ci;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.ma;
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
  private String fIi;
  private String fIk;
  public long maC;
  public final com.tencent.mm.an.d rr;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109745);
    this.maC = 0L;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new lz();
    ((d.a)localObject).lBV = new ma();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bindqq";
    ((d.a)localObject).funcId = 144;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    this.maC = paramLong;
    localObject = (lz)d.b.b(this.rr.lBR);
    ((lz)localObject).RRs = new p(paramLong).intValue();
    ((lz)localObject).RRg = "";
    ((lz)localObject).RRt = "";
    ((lz)localObject).RRu = "";
    ((lz)localObject).RRv = "";
    ((lz)localObject).RRx = new eaf().btQ("");
    ((lz)localObject).RRw = 1;
    if (paramBoolean == true) {}
    for (paramString1 = h.aHE().aGC().f(paramLong, paramString3);; paramString1 = h.aHE().aGC().a(paramLong, Util.getFullPasswordMD5(paramString1), true))
    {
      ((lz)localObject).ROR = new eae().dc(paramString1);
      String str = Util.nullAsNil((String)h.aHG().aHp().b(47, null));
      ((lz)localObject).RRy = new eae().dc(Util.decodeHexString(str));
      Log.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(Util.getLength(paramString1)), paramString3, paramString2, paramString4, str });
      AppMethodBeat.o(109745);
      return;
    }
  }
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramString3, paramString4, 1, paramBoolean);
    AppMethodBeat.i(109746);
    this.fIi = paramString5;
    this.fIk = paramString6;
    paramString1 = (lz)d.b.b(this.rr.lBR);
    paramString1.RQS = paramString5;
    paramString1.RQT = paramString6;
    AppMethodBeat.o(109746);
  }
  
  public final int doScene(g paramg, i parami)
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
    params = (lz)d.b.b(this.rr.lBR);
    paramArrayOfByte = (ma)d.c.b(this.rr.lBS);
    Object localObject = com.tencent.mm.platformtools.z.a(paramArrayOfByte.RLX);
    if (!Util.isNullOrNil((byte[])localObject)) {}
    for (boolean bool1 = h.aHE().aGC().a(new p(params.RRs).longValue(), (byte[])localObject);; bool1 = false)
    {
      if ((bool1) && (h.aHB())) {
        h.aHG().aHp().set(ar.a.VDS, Boolean.TRUE);
      }
      Log.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool1), Integer.valueOf(Util.getLength((byte[])localObject)), paramArrayOfByte.RRu });
      boolean bool2;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramInt1 = h.aHG().aHp().getInt(9, 0);
        h.aHG().aHp().i(9, Integer.valueOf(params.RRs));
        if (paramInt1 != 0)
        {
          if (h.aHG().aHp().get(ar.a.VuG, "").equals(String.valueOf(paramInt1))) {
            h.aHG().aHp().set(ar.a.VuG, com.tencent.mm.model.z.bcZ());
          }
          localObject = ci.lvQ.bfs().iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (String.valueOf(paramInt1).equals(ci.lvQ.getString(str, "login_user_name"))) {
              ci.lvQ.o(str, "login_user_name", str);
            }
          }
        }
        if (params.RRw == 1) {
          h.aHG().aHp().i(17, Integer.valueOf(paramArrayOfByte.RFA));
        }
        localObject = ((n)h.ae(n.class)).bbU();
        String str = paramArrayOfByte.RRB;
        if (paramArrayOfByte.RRA == 1)
        {
          bool2 = true;
          ((l)localObject).bV(str, bool2);
          paramInt1 = params.RRs;
          if (paramInt1 != 0) {
            ((n)h.ae(n.class)).bbU().fk(new p(paramInt1) + "@qqim", 3);
          }
          com.tencent.mm.am.d.f(paramInt1, 3);
          h.aHG().aHp().i(32, params.RRg);
          h.aHG().aHp().i(33, params.RRt);
          localObject = Util.encodeHexString(h.aHE().aGC().Gr(new p(params.RRs).longValue()));
          Log.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[] { Boolean.valueOf(bool1), Util.secPrint((String)localObject) });
          h.aHG().aHp().i(72, localObject);
          h.aHG().aHp().i(46, Util.encodeHexString(com.tencent.mm.platformtools.z.a(paramArrayOfByte.RMd)));
          localObject = Util.encodeHexString(com.tencent.mm.platformtools.z.a(params.RRy));
          h.aHG().aHp().i(47, localObject);
          h.aHG().kcw.i(18, localObject);
          h.aHG().aHp().i(-1535680990, paramArrayOfByte.RRC);
        }
      }
      for (;;)
      {
        paramInt1 = paramInt3;
        if (params.RRw == 3)
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
          h.aHG().aHp().i(32, "");
          h.aHG().aHp().i(33, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.b
 * JD-Core Version:    0.7.0.1
 */