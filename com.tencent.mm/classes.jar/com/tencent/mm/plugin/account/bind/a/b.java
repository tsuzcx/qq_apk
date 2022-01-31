package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.ju;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.Set;

public final class b
  extends m
  implements com.tencent.mm.network.k
{
  private f callback;
  private String cxl;
  private String cxn;
  public long fQd;
  public final com.tencent.mm.ai.b rr;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(13320);
    this.fQd = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ju();
    ((b.a)localObject).fsY = new jv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindqq";
    ((b.a)localObject).funcId = 144;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    this.fQd = paramLong;
    localObject = (ju)this.rr.fsV.fta;
    ((ju)localObject).wwi = new p(paramLong).intValue();
    ((ju)localObject).wvW = "";
    ((ju)localObject).wwj = "";
    ((ju)localObject).wwk = "";
    ((ju)localObject).wwl = "";
    ((ju)localObject).wwn = new bwc().aoF("");
    ((ju)localObject).wwm = 1;
    if (paramBoolean == true) {}
    for (paramString1 = g.RJ().QN().d(paramLong, paramString3);; paramString1 = g.RJ().QN().a(paramLong, bo.apP(paramString1), true))
    {
      ((ju)localObject).wuh = new SKBuiltinBuffer_t().setBuffer(paramString1);
      String str = bo.nullAsNil((String)g.RL().Ru().get(47, null));
      ((ju)localObject).wwo = new SKBuiltinBuffer_t().setBuffer(bo.apQ(str));
      ab.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(bo.cf(paramString1)), paramString3, paramString2, paramString4, str });
      AppMethodBeat.o(13320);
      return;
    }
  }
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    this(paramLong, paramString1, paramString2, paramString3, paramString4, 1, paramBoolean);
    AppMethodBeat.i(13321);
    this.cxl = paramString5;
    this.cxn = paramString6;
    paramString1 = (ju)this.rr.fsV.fta;
    paramString1.wvL = paramString5;
    paramString1.wvM = paramString6;
    AppMethodBeat.o(13321);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(13322);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(13322);
    return i;
  }
  
  public final int getType()
  {
    return 144;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13323);
    paramq = (ju)this.rr.fsV.fta;
    paramArrayOfByte = (jv)this.rr.fsW.fta;
    Object localObject = aa.a(paramArrayOfByte.wrN);
    if (!bo.ce((byte[])localObject)) {}
    for (boolean bool1 = g.RJ().QN().a(new p(paramq.wwi).longValue(), (byte[])localObject);; bool1 = false)
    {
      ab.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool1), Integer.valueOf(bo.cf((byte[])localObject)), paramArrayOfByte.wwk });
      boolean bool2;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramInt1 = g.RL().Ru().getInt(9, 0);
        g.RL().Ru().set(9, Integer.valueOf(paramq.wwi));
        if (paramInt1 != 0)
        {
          if (g.RL().Ru().get(ac.a.yJS, "").equals(String.valueOf(paramInt1))) {
            g.RL().Ru().set(ac.a.yJS, r.Zn());
          }
          localObject = bx.fnO.abf().iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (String.valueOf(paramInt1).equals(bx.fnO.getString(str, "login_user_name"))) {
              bx.fnO.n(str, "login_user_name", str);
            }
          }
        }
        if (paramq.wwm == 1) {
          g.RL().Ru().set(17, Integer.valueOf(paramArrayOfByte.wmz));
        }
        localObject = ((j)g.E(j.class)).YI();
        String str = paramArrayOfByte.wwr;
        if (paramArrayOfByte.wwq == 1)
        {
          bool2 = true;
          ((com.tencent.mm.plugin.messenger.foundation.a.a.k)localObject).aZ(str, bool2);
          paramInt1 = paramq.wwi;
          if (paramInt1 != 0) {
            ((j)g.E(j.class)).YI().cO(new p(paramInt1) + "@qqim", 3);
          }
          com.tencent.mm.ah.b.d(paramInt1, 3);
          g.RL().Ru().set(32, paramq.wvW);
          g.RL().Ru().set(33, paramq.wwj);
          localObject = bo.cg(g.RJ().QN().gD(new p(paramq.wwi).longValue()));
          ab.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[] { Boolean.valueOf(bool1), bo.aqg((String)localObject) });
          g.RL().Ru().set(72, localObject);
          g.RL().Ru().set(46, bo.cg(aa.a(paramArrayOfByte.wrT)));
          localObject = bo.cg(aa.a(paramq.wwo));
          g.RL().Ru().set(47, localObject);
          g.RL().eHM.set(18, localObject);
          g.RL().Ru().set(-1535680990, paramArrayOfByte.wws);
        }
      }
      for (;;)
      {
        paramInt1 = paramInt3;
        if (paramq.wwm == 3)
        {
          paramInt1 = paramInt3;
          if (paramInt3 == -3)
          {
            paramInt1 = 10000;
            ab.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
          }
        }
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
        AppMethodBeat.o(13323);
        return;
        bool2 = false;
        break;
        if (paramInt2 == 4)
        {
          g.RL().Ru().set(32, "");
          g.RL().Ru().set(33, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.b
 * JD-Core Version:    0.7.0.1
 */