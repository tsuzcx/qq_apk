package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.Set;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private String dkA;
  private String dky;
  public long hTj;
  public final com.tencent.mm.ak.b rr;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109745);
    this.hTj = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new li();
    ((b.a)localObject).hvu = new lj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindqq";
    ((b.a)localObject).funcId = 144;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    this.hTj = paramLong;
    localObject = (li)this.rr.hvr.hvw;
    ((li)localObject).DYR = new p(paramLong).intValue();
    ((li)localObject).DYF = "";
    ((li)localObject).DYS = "";
    ((li)localObject).DYT = "";
    ((li)localObject).DYU = "";
    ((li)localObject).DYW = new crm().aJV("");
    ((li)localObject).DYV = 1;
    if (paramBoolean == true) {}
    for (paramString1 = com.tencent.mm.kernel.g.agP().afQ().e(paramLong, paramString3);; paramString1 = com.tencent.mm.kernel.g.agP().afQ().a(paramLong, bs.aLt(paramString1), true))
    {
      ((li)localObject).DWx = new SKBuiltinBuffer_t().setBuffer(paramString1);
      String str = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(47, null));
      ((li)localObject).DYX = new SKBuiltinBuffer_t().setBuffer(bs.aLu(str));
      ac.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(bs.cw(paramString1)), paramString3, paramString2, paramString4, str });
      AppMethodBeat.o(109745);
      return;
    }
  }
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramString3, paramString4, 1, paramBoolean);
    AppMethodBeat.i(109746);
    this.dky = paramString5;
    this.dkA = paramString6;
    paramString1 = (li)this.rr.hvr.hvw;
    paramString1.DYs = paramString5;
    paramString1.DYt = paramString6;
    AppMethodBeat.o(109746);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    paramq = (li)this.rr.hvr.hvw;
    paramArrayOfByte = (lj)this.rr.hvs.hvw;
    Object localObject = com.tencent.mm.platformtools.z.a(paramArrayOfByte.DTC);
    if (!bs.cv((byte[])localObject)) {}
    for (boolean bool1 = com.tencent.mm.kernel.g.agP().afQ().a(new p(paramq.DYR).longValue(), (byte[])localObject);; bool1 = false)
    {
      ac.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool1), Integer.valueOf(bs.cw((byte[])localObject)), paramArrayOfByte.DYT });
      boolean bool2;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramInt1 = com.tencent.mm.kernel.g.agR().agA().getInt(9, 0);
        com.tencent.mm.kernel.g.agR().agA().set(9, Integer.valueOf(paramq.DYR));
        if (paramInt1 != 0)
        {
          if (com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQW, "").equals(String.valueOf(paramInt1))) {
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQW, u.axw());
          }
          localObject = ca.hpQ.azx().iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (String.valueOf(paramInt1).equals(ca.hpQ.getString(str, "login_user_name"))) {
              ca.hpQ.m(str, "login_user_name", str);
            }
          }
        }
        if (paramq.DYV == 1) {
          com.tencent.mm.kernel.g.agR().agA().set(17, Integer.valueOf(paramArrayOfByte.DNj));
        }
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ();
        String str = paramArrayOfByte.DZa;
        if (paramArrayOfByte.DYZ == 1)
        {
          bool2 = true;
          ((com.tencent.mm.plugin.messenger.foundation.a.a.k)localObject).bp(str, bool2);
          paramInt1 = paramq.DYR;
          if (paramInt1 != 0) {
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().dX(new p(paramInt1) + "@qqim", 3);
          }
          c.e(paramInt1, 3);
          com.tencent.mm.kernel.g.agR().agA().set(32, paramq.DYF);
          com.tencent.mm.kernel.g.agR().agA().set(33, paramq.DYS);
          localObject = bs.cx(com.tencent.mm.kernel.g.agP().afQ().pR(new p(paramq.DYR).longValue()));
          ac.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[] { Boolean.valueOf(bool1), bs.aLJ((String)localObject) });
          com.tencent.mm.kernel.g.agR().agA().set(72, localObject);
          com.tencent.mm.kernel.g.agR().agA().set(46, bs.cx(com.tencent.mm.platformtools.z.a(paramArrayOfByte.DTI)));
          localObject = bs.cx(com.tencent.mm.platformtools.z.a(paramq.DYX));
          com.tencent.mm.kernel.g.agR().agA().set(47, localObject);
          com.tencent.mm.kernel.g.agR().ghx.set(18, localObject);
          com.tencent.mm.kernel.g.agR().agA().set(-1535680990, paramArrayOfByte.DZb);
        }
      }
      for (;;)
      {
        paramInt1 = paramInt3;
        if (paramq.DYV == 3)
        {
          paramInt1 = paramInt3;
          if (paramInt3 == -3)
          {
            paramInt1 = 10000;
            ac.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
        AppMethodBeat.o(109748);
        return;
        bool2 = false;
        break;
        if (paramInt2 == 4)
        {
          com.tencent.mm.kernel.g.agR().agA().set(32, "");
          com.tencent.mm.kernel.g.agR().agA().set(33, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.b
 * JD-Core Version:    0.7.0.1
 */