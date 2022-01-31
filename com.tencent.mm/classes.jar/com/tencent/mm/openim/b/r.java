package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public r()
  {
    AppMethodBeat.i(78884);
    b.a locala = new b.a();
    locala.fsX = new biw();
    locala.fsY = new bix();
    locala.uri = "/cgi-bin/micromsg-bin/openimsync";
    locala.funcId = 810;
    this.rr = locala.ado();
    ((biw)this.rr.fsV.fta).fHY = 2097152;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(78884);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(78885);
    g.RM();
    byte[] arrayOfByte = bo.apQ(bo.nullAsNil((String)g.RL().Ru().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((biw)this.rr.fsV.fta).xxw = localSKBuiltinBuffer_t;
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78885);
    return i;
  }
  
  public final int getType()
  {
    return 810;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78886);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78886);
      return;
    }
    paramString = (biw)this.rr.fsV.fta;
    paramq = (bix)this.rr.fsW.fta;
    if ((paramq.xxx != null) && (paramq.xxx.jJv.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", new Object[] { Integer.valueOf(paramq.xxx.jJv.size()) });
      paramArrayOfByte = paramq.xxx.jJv.iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject1 = (ud)paramArrayOfByte.next();
        Object localObject2;
        if (((ud)localObject1).wMC == 400)
        {
          localObject2 = new bid();
          try
          {
            ((bid)localObject2).parseFrom(((ud)localObject1).wMD.getBufferToBytes());
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", new Object[] { ((bid)localObject2).gfL });
            localObject1 = s.a((bid)localObject2);
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { ((aq)localObject1).field_username, ((aq)localObject1).field_nickname, ((aq)localObject1).field_conRemark, Integer.valueOf(((ad)localObject1).getSource()), Integer.valueOf(((aq)localObject1).dqC), ((aq)localObject1).field_openImAppid, ((aq)localObject1).dre, Integer.valueOf(((aq)localObject1).drd), Integer.valueOf(((aq)localObject1).field_type), ((aq)localObject1).field_descWordingId });
            ((j)g.E(j.class)).YA().X((ad)localObject1);
            if (((ad)localObject1).Oa()) {
              ((j)g.E(j.class)).YF().arN(((aq)localObject1).field_username);
            }
            ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).bc(((bid)localObject2).app_id, ((bid)localObject2).xxm);
            s.b((bid)localObject2);
            g.RM();
            localObject2 = ((j)g.E(j.class)).YB().TM(((aq)localObject1).field_username);
            if ((localObject2 == null) || (bo.isNullOrNil(((bv)localObject2).field_encryptUsername))) {
              continue;
            }
            String str = ((bv)localObject2).field_conRemark;
            ((com.tencent.mm.openim.a.a)g.E(com.tencent.mm.openim.a.a.class)).al(((aq)localObject1).field_username, str);
            g.RM();
            ((j)g.E(j.class)).YB().TN(((aq)localObject1).field_username);
            ((ad)localObject1).jn(((bv)localObject2).field_conRemark);
            ((j)g.E(j.class)).YA().X((ad)localObject1);
          }
          catch (IOException localIOException1)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", new Object[] { localIOException1 });
          }
        }
        else if (localIOException1.wMC == 402)
        {
          localObject2 = new xe();
          try
          {
            ((xe)localObject2).parseFrom(localIOException1.wMD.getBufferToBytes());
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", new Object[] { ((xe)localObject2).gfL });
            ((j)g.E(j.class)).YF().arF(((xe)localObject2).gfL);
            t.nW(((xe)localObject2).gfL);
          }
          catch (IOException localIOException2)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", new Object[] { localIOException2 });
          }
        }
        else if (localIOException2.wMC == 403)
        {
          try
          {
            localObject2 = new bhx();
            ((bhx)localObject2).parseFrom(localIOException2.wMD.getBufferToBytes());
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", new Object[] { ((bhx)localObject2).gfM });
            com.tencent.mm.openim.room.a.a.b((bhx)localObject2);
          }
          catch (IOException localIOException3)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", new Object[] { localIOException3 });
          }
        }
        else if (localIOException3.wMC == 404)
        {
          localObject2 = new bid();
          try
          {
            ((bid)localObject2).parseFrom(localIOException3.wMD.getBufferToBytes());
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", new Object[] { ((bid)localObject2).gfL });
            g.RK().eHt.a(new h(((bid)localObject2).gfL, "", ""), 0);
          }
          catch (IOException localIOException4)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", new Object[] { localIOException4 });
          }
        }
      }
    }
    paramArrayOfByte = paramq.xxw.getBuffer().toByteArray();
    g.RM();
    paramArrayOfByte = com.tencent.mm.protocal.ab.j(bo.apQ(bo.nullAsNil((String)g.RL().Ru().get(8195, null))), paramArrayOfByte);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      g.RM();
      g.RL().Ru().set(8195, bo.cg(paramArrayOfByte));
    }
    paramInt1 = paramq.xxy;
    if ((paramString.fHY & paramInt1) == 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd end");
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(78886);
      return;
    }
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(78886);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.openim.b.r
 * JD-Core Version:    0.7.0.1
 */