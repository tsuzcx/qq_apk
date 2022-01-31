package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bax;
import com.tencent.mm.protocal.c.bbd;
import com.tencent.mm.protocal.c.bbv;
import com.tencent.mm.protocal.c.bbw;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.protocal.c.td;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public q()
  {
    b.a locala = new b.a();
    locala.ecH = new bbv();
    locala.ecI = new bbw();
    locala.uri = "/cgi-bin/micromsg-bin/openimsync";
    locala.ecG = 810;
    this.dmK = locala.Kt();
    ((bbv)this.dmK.ecE.ecN).selector = 2097152;
    y.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  protected final int Ka()
  {
    return 20;
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    g.DQ();
    byte[] arrayOfByte = bk.ZM(bk.pm((String)g.DP().Dz().get(8195, null)));
    bmk localbmk = new bmk();
    localbmk.bs(arrayOfByte);
    ((bbv)this.dmK.ecE.ecN).txq = localbmk;
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramString = (bbv)this.dmK.ecE.ecN;
    paramq = (bbw)this.dmK.ecF.ecN;
    if ((paramq.txr != null) && (paramq.txr.hPT.size() > 0))
    {
      y.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", new Object[] { Integer.valueOf(paramq.txr.hPT.size()) });
      paramArrayOfByte = paramq.txr.hPT.iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject1 = (qv)paramArrayOfByte.next();
        Object localObject2;
        if (((qv)localObject1).sOA == 400)
        {
          localObject2 = new bbd();
          try
          {
            ((bbd)localObject2).aH(((qv)localObject1).sOB.tFM.oY);
            y.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", new Object[] { ((bbd)localObject2).ePQ });
            localObject1 = r.a((bbd)localObject2);
            y.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { ((ao)localObject1).field_username, ((ao)localObject1).field_nickname, ((ao)localObject1).field_conRemark, Integer.valueOf(((ad)localObject1).getSource()), Integer.valueOf(((ao)localObject1).sex), ((ao)localObject1).field_openImAppid, ((ao)localObject1).cCU, Integer.valueOf(((ao)localObject1).cCT), Integer.valueOf(((ao)localObject1).field_type), ((ao)localObject1).field_descWordingId });
            ((j)g.r(j.class)).Fw().U((ad)localObject1);
            if (((ad)localObject1).Bl()) {
              ((j)g.r(j.class)).FB().abB(((ao)localObject1).field_username);
            }
            ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).aJ(((bbd)localObject2).app_id, ((bbd)localObject2).txg);
            r.b((bbd)localObject2);
            g.DQ();
            localObject2 = ((j)g.r(j.class)).Fx().Id(((ao)localObject1).field_username);
            if ((localObject2 == null) || (bk.bl(((bv)localObject2).field_encryptUsername))) {
              continue;
            }
            String str = ((bv)localObject2).field_conRemark;
            ((com.tencent.mm.openim.a.a)g.r(com.tencent.mm.openim.a.a.class)).U(((ao)localObject1).field_username, str);
            g.DQ();
            ((j)g.r(j.class)).Fx().Ie(((ao)localObject1).field_username);
            ((ad)localObject1).df(((bv)localObject2).field_conRemark);
            ((j)g.r(j.class)).Fw().U((ad)localObject1);
          }
          catch (IOException localIOException1)
          {
            y.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", new Object[] { localIOException1 });
          }
        }
        else if (localIOException1.sOA == 402)
        {
          localObject2 = new td();
          try
          {
            ((td)localObject2).aH(localIOException1.sOB.tFM.oY);
            y.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", new Object[] { ((td)localObject2).ePQ });
            ((j)g.r(j.class)).FB().abu(((td)localObject2).ePQ);
            s.hn(((td)localObject2).ePQ);
          }
          catch (IOException localIOException2)
          {
            y.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", new Object[] { localIOException2 });
          }
        }
        else if (localIOException2.sOA == 403)
        {
          try
          {
            localObject2 = new bax();
            ((bax)localObject2).aH(localIOException2.sOB.tFM.oY);
            y.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", new Object[] { ((bax)localObject2).ePR });
            com.tencent.mm.openim.room.a.a.a((bax)localObject2);
          }
          catch (IOException localIOException3)
          {
            y.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", new Object[] { localIOException3 });
          }
        }
      }
    }
    paramArrayOfByte = paramq.txq.tFM.toByteArray();
    g.DQ();
    paramArrayOfByte = com.tencent.mm.protocal.z.g(bk.ZM(bk.pm((String)g.DP().Dz().get(8195, null))), paramArrayOfByte);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      g.DQ();
      g.DP().Dz().o(8195, bk.bG(paramArrayOfByte));
    }
    paramInt1 = paramq.txs;
    if ((paramString.selector & paramInt1) == 0)
    {
      y.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd end");
      this.dmL.onSceneEnd(0, 0, "", this);
      return;
    }
    a(this.edc, this.dmL);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 810;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.openim.b.q
 * JD-Core Version:    0.7.0.1
 */