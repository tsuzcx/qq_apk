package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.protocal.protobuf.lt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.Set;

public final class b
  extends n
  implements k
{
  private f callback;
  private String dxq;
  private String dxs;
  public long ipu;
  public final com.tencent.mm.ak.b rr;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109745);
    this.ipu = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ls();
    ((b.a)localObject).hQG = new lt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindqq";
    ((b.a)localObject).funcId = 144;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    this.ipu = paramLong;
    localObject = (ls)this.rr.hQD.hQJ;
    ((ls)localObject).FWI = new p(paramLong).intValue();
    ((ls)localObject).FWw = "";
    ((ls)localObject).FWJ = "";
    ((ls)localObject).FWK = "";
    ((ls)localObject).FWL = "";
    ((ls)localObject).FWN = new cxn().aQV("");
    ((ls)localObject).FWM = 1;
    if (paramBoolean == true) {}
    for (paramString1 = g.ajP().aiR().e(paramLong, paramString3);; paramString1 = g.ajP().aiR().a(paramLong, bu.aSw(paramString1), true))
    {
      ((ls)localObject).FUo = new SKBuiltinBuffer_t().setBuffer(paramString1);
      String str = bu.nullAsNil((String)g.ajR().ajA().get(47, null));
      ((ls)localObject).FWO = new SKBuiltinBuffer_t().setBuffer(bu.aSx(str));
      ae.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(bu.cG(paramString1)), paramString3, paramString2, paramString4, str });
      AppMethodBeat.o(109745);
      return;
    }
  }
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramString3, paramString4, 1, paramBoolean);
    AppMethodBeat.i(109746);
    this.dxq = paramString5;
    this.dxs = paramString6;
    paramString1 = (ls)this.rr.hQD.hQJ;
    paramString1.FWj = paramString5;
    paramString1.FWk = paramString6;
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
    paramq = (ls)this.rr.hQD.hQJ;
    paramArrayOfByte = (lt)this.rr.hQE.hQJ;
    Object localObject = com.tencent.mm.platformtools.z.a(paramArrayOfByte.FRu);
    if (!bu.cF((byte[])localObject)) {}
    for (boolean bool1 = g.ajP().aiR().a(new p(paramq.FWI).longValue(), (byte[])localObject);; bool1 = false)
    {
      ae.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool1), Integer.valueOf(bu.cG((byte[])localObject)), paramArrayOfByte.FWK });
      boolean bool2;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramInt1 = g.ajR().ajA().getInt(9, 0);
        g.ajR().ajA().set(9, Integer.valueOf(paramq.FWI));
        if (paramInt1 != 0)
        {
          if (g.ajR().ajA().get(am.a.IXT, "").equals(String.valueOf(paramInt1))) {
            g.ajR().ajA().set(am.a.IXT, v.aAC());
          }
          localObject = cd.hLa.aCQ().iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (String.valueOf(paramInt1).equals(cd.hLa.getString(str, "login_user_name"))) {
              cd.hLa.l(str, "login_user_name", str);
            }
          }
        }
        if (paramq.FWM == 1) {
          g.ajR().ajA().set(17, Integer.valueOf(paramArrayOfByte.FKM));
        }
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO();
        String str = paramArrayOfByte.FWR;
        if (paramArrayOfByte.FWQ == 1)
        {
          bool2 = true;
          ((com.tencent.mm.plugin.messenger.foundation.a.a.l)localObject).bz(str, bool2);
          paramInt1 = paramq.FWI;
          if (paramInt1 != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().ev(new p(paramInt1) + "@qqim", 3);
          }
          c.e(paramInt1, 3);
          g.ajR().ajA().set(32, paramq.FWw);
          g.ajR().ajA().set(33, paramq.FWJ);
          localObject = bu.cH(g.ajP().aiR().sd(new p(paramq.FWI).longValue()));
          ae.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[] { Boolean.valueOf(bool1), bu.aSM((String)localObject) });
          g.ajR().ajA().set(72, localObject);
          g.ajR().ajA().set(46, bu.cH(com.tencent.mm.platformtools.z.a(paramArrayOfByte.FRA)));
          localObject = bu.cH(com.tencent.mm.platformtools.z.a(paramq.FWO));
          g.ajR().ajA().set(47, localObject);
          g.ajR().gDO.set(18, localObject);
          g.ajR().ajA().set(-1535680990, paramArrayOfByte.FWS);
        }
      }
      for (;;)
      {
        paramInt1 = paramInt3;
        if (paramq.FWM == 3)
        {
          paramInt1 = paramInt3;
          if (paramInt3 == -3)
          {
            paramInt1 = 10000;
            ae.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
        AppMethodBeat.o(109748);
        return;
        bool2 = false;
        break;
        if (paramInt2 == 4)
        {
          g.ajR().ajA().set(32, "");
          g.ajR().ajA().set(33, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.b
 * JD-Core Version:    0.7.0.1
 */