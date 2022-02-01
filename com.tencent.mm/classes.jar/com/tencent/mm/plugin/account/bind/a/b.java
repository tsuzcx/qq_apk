package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.protocal.protobuf.ld;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.Set;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private String dmQ;
  private String dmS;
  public long hsH;
  public final com.tencent.mm.al.b rr;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109745);
    this.hsH = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new lc();
    ((b.a)localObject).gUV = new ld();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindqq";
    ((b.a)localObject).funcId = 144;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    this.hsH = paramLong;
    localObject = (lc)this.rr.gUS.gUX;
    ((lc)localObject).CGr = new p(paramLong).intValue();
    ((lc)localObject).CGf = "";
    ((lc)localObject).CGs = "";
    ((lc)localObject).CGt = "";
    ((lc)localObject).CGu = "";
    ((lc)localObject).CGw = new cmf().aEE("");
    ((lc)localObject).CGv = 1;
    if (paramBoolean == true) {}
    for (paramString1 = com.tencent.mm.kernel.g.afz().aeA().e(paramLong, paramString3);; paramString1 = com.tencent.mm.kernel.g.afz().aeA().a(paramLong, bt.aGc(paramString1), true))
    {
      ((lc)localObject).CDX = new SKBuiltinBuffer_t().setBuffer(paramString1);
      String str = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(47, null));
      ((lc)localObject).CGx = new SKBuiltinBuffer_t().setBuffer(bt.aGd(str));
      ad.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(bt.cx(paramString1)), paramString3, paramString2, paramString4, str });
      AppMethodBeat.o(109745);
      return;
    }
  }
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramString3, paramString4, 1, paramBoolean);
    AppMethodBeat.i(109746);
    this.dmQ = paramString5;
    this.dmS = paramString6;
    paramString1 = (lc)this.rr.gUS.gUX;
    paramString1.CFS = paramString5;
    paramString1.CFT = paramString6;
    AppMethodBeat.o(109746);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(109747);
    this.callback = paramg;
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
    paramq = (lc)this.rr.gUS.gUX;
    paramArrayOfByte = (ld)this.rr.gUT.gUX;
    Object localObject = com.tencent.mm.platformtools.z.a(paramArrayOfByte.CBe);
    if (!bt.cw((byte[])localObject)) {}
    for (boolean bool1 = com.tencent.mm.kernel.g.afz().aeA().a(new p(paramq.CGr).longValue(), (byte[])localObject);; bool1 = false)
    {
      ad.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool1), Integer.valueOf(bt.cx((byte[])localObject)), paramArrayOfByte.CGt });
      boolean bool2;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramInt1 = com.tencent.mm.kernel.g.afB().afk().getInt(9, 0);
        com.tencent.mm.kernel.g.afB().afk().set(9, Integer.valueOf(paramq.CGr));
        if (paramInt1 != 0)
        {
          if (com.tencent.mm.kernel.g.afB().afk().get(ae.a.Ftd, "").equals(String.valueOf(paramInt1))) {
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftd, u.aqG());
          }
          localObject = ca.gPq.asG().iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (String.valueOf(paramInt1).equals(ca.gPq.getString(str, "login_user_name"))) {
              ca.gPq.m(str, "login_user_name", str);
            }
          }
        }
        if (paramq.CGv == 1) {
          com.tencent.mm.kernel.g.afB().afk().set(17, Integer.valueOf(paramArrayOfByte.CuO));
        }
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU();
        String str = paramArrayOfByte.CGA;
        if (paramArrayOfByte.CGz == 1)
        {
          bool2 = true;
          ((com.tencent.mm.plugin.messenger.foundation.a.a.k)localObject).bi(str, bool2);
          paramInt1 = paramq.CGr;
          if (paramInt1 != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().dQ(new p(paramInt1) + "@qqim", 3);
          }
          c.e(paramInt1, 3);
          com.tencent.mm.kernel.g.afB().afk().set(32, paramq.CGf);
          com.tencent.mm.kernel.g.afB().afk().set(33, paramq.CGs);
          localObject = bt.cy(com.tencent.mm.kernel.g.afz().aeA().md(new p(paramq.CGr).longValue()));
          ad.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[] { Boolean.valueOf(bool1), bt.aGs((String)localObject) });
          com.tencent.mm.kernel.g.afB().afk().set(72, localObject);
          com.tencent.mm.kernel.g.afB().afk().set(46, bt.cy(com.tencent.mm.platformtools.z.a(paramArrayOfByte.CBk)));
          localObject = bt.cy(com.tencent.mm.platformtools.z.a(paramq.CGx));
          com.tencent.mm.kernel.g.afB().afk().set(47, localObject);
          com.tencent.mm.kernel.g.afB().gcR.set(18, localObject);
          com.tencent.mm.kernel.g.afB().afk().set(-1535680990, paramArrayOfByte.CGB);
        }
      }
      for (;;)
      {
        paramInt1 = paramInt3;
        if (paramq.CGv == 3)
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
          com.tencent.mm.kernel.g.afB().afk().set(32, "");
          com.tencent.mm.kernel.g.afB().afk().set(33, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.b
 * JD-Core Version:    0.7.0.1
 */