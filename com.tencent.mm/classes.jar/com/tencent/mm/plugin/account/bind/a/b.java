package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.protocal.protobuf.lt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.Set;

public final class b
  extends n
  implements k
{
  private f callback;
  private String dwl;
  private String dwn;
  public long imA;
  public final com.tencent.mm.al.b rr;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109745);
    this.imA = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ls();
    ((b.a)localObject).hNN = new lt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindqq";
    ((b.a)localObject).funcId = 144;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    this.imA = paramLong;
    localObject = (ls)this.rr.hNK.hNQ;
    ((ls)localObject).FEn = new p(paramLong).intValue();
    ((ls)localObject).FEb = "";
    ((ls)localObject).FEo = "";
    ((ls)localObject).FEp = "";
    ((ls)localObject).FEq = "";
    ((ls)localObject).FEs = new cwt().aPy("");
    ((ls)localObject).FEr = 1;
    if (paramBoolean == true) {}
    for (paramString1 = g.ajA().aiC().e(paramLong, paramString3);; paramString1 = g.ajA().aiC().a(paramLong, bt.aQZ(paramString1), true))
    {
      ((ls)localObject).FBT = new SKBuiltinBuffer_t().setBuffer(paramString1);
      String str = bt.nullAsNil((String)g.ajC().ajl().get(47, null));
      ((ls)localObject).FEt = new SKBuiltinBuffer_t().setBuffer(bt.aRa(str));
      ad.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(bt.cD(paramString1)), paramString3, paramString2, paramString4, str });
      AppMethodBeat.o(109745);
      return;
    }
  }
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramString3, paramString4, 1, paramBoolean);
    AppMethodBeat.i(109746);
    this.dwl = paramString5;
    this.dwn = paramString6;
    paramString1 = (ls)this.rr.hNK.hNQ;
    paramString1.FDO = paramString5;
    paramString1.FDP = paramString6;
    AppMethodBeat.o(109746);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(109747);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(109747);
    return i;
  }
  
  public final int getType()
  {
    return 144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109748);
    paramq = (ls)this.rr.hNK.hNQ;
    paramArrayOfByte = (lt)this.rr.hNL.hNQ;
    Object localObject = com.tencent.mm.platformtools.z.a(paramArrayOfByte.FyW);
    if (!bt.cC((byte[])localObject)) {}
    for (boolean bool1 = g.ajA().aiC().a(new p(paramq.FEn).longValue(), (byte[])localObject);; bool1 = false)
    {
      ad.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool1), Integer.valueOf(bt.cD((byte[])localObject)), paramArrayOfByte.FEp });
      boolean bool2;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramInt1 = g.ajC().ajl().getInt(9, 0);
        g.ajC().ajl().set(9, Integer.valueOf(paramq.FEn));
        if (paramInt1 != 0)
        {
          if (g.ajC().ajl().get(al.a.IDt, "").equals(String.valueOf(paramInt1))) {
            g.ajC().ajl().set(al.a.IDt, u.aAm());
          }
          localObject = cb.hIi.aCA().iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (String.valueOf(paramInt1).equals(cb.hIi.getString(str, "login_user_name"))) {
              cb.hIi.l(str, "login_user_name", str);
            }
          }
        }
        if (paramq.FEr == 1) {
          g.ajC().ajl().set(17, Integer.valueOf(paramArrayOfByte.Fso));
        }
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy();
        String str = paramArrayOfByte.FEw;
        if (paramArrayOfByte.FEv == 1)
        {
          bool2 = true;
          ((com.tencent.mm.plugin.messenger.foundation.a.a.l)localObject).bv(str, bool2);
          paramInt1 = paramq.FEn;
          if (paramInt1 != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().eo(new p(paramInt1) + "@qqim", 3);
          }
          c.e(paramInt1, 3);
          g.ajC().ajl().set(32, paramq.FEb);
          g.ajC().ajl().set(33, paramq.FEo);
          localObject = bt.cE(g.ajA().aiC().rQ(new p(paramq.FEn).longValue()));
          ad.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[] { Boolean.valueOf(bool1), bt.aRp((String)localObject) });
          g.ajC().ajl().set(72, localObject);
          g.ajC().ajl().set(46, bt.cE(com.tencent.mm.platformtools.z.a(paramArrayOfByte.Fzc)));
          localObject = bt.cE(com.tencent.mm.platformtools.z.a(paramq.FEt));
          g.ajC().ajl().set(47, localObject);
          g.ajC().gBh.set(18, localObject);
          g.ajC().ajl().set(-1535680990, paramArrayOfByte.FEx);
        }
      }
      for (;;)
      {
        paramInt1 = paramInt3;
        if (paramq.FEr == 3)
        {
          paramInt1 = paramInt3;
          if (paramInt3 == -3)
          {
            paramInt1 = 10000;
            ad.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
        AppMethodBeat.o(109748);
        return;
        bool2 = false;
        break;
        if (paramInt2 == 4)
        {
          g.ajC().ajl().set(32, "");
          g.ajC().ajl().set(33, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.b
 * JD-Core Version:    0.7.0.1
 */