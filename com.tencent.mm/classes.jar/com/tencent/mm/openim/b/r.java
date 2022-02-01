package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abk;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.protocal.protobuf.cax;
import com.tencent.mm.protocal.protobuf.cay;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bz;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private final com.tencent.mm.ak.b rr;
  
  public r()
  {
    AppMethodBeat.i(151228);
    b.a locala = new b.a();
    locala.hvt = new cax();
    locala.hvu = new cay();
    locala.uri = "/cgi-bin/micromsg-bin/openimsync";
    locala.funcId = 810;
    this.rr = locala.aAz();
    ((cax)this.rr.hvr.hvw).hLw = 2097152;
    ac.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(151228);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(151229);
    com.tencent.mm.kernel.g.agS();
    byte[] arrayOfByte = bs.aLu(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((cax)this.rr.hvr.hvw).Fpq = localSKBuiltinBuffer_t;
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151229);
    return i;
  }
  
  public final int getType()
  {
    return 810;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151230);
    ac.i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151230);
      return;
    }
    paramString = (cax)this.rr.hvr.hvw;
    paramq = (cay)this.rr.hvs.hvw;
    if ((paramq.Fpr != null) && (paramq.Fpr.ncM.size() > 0))
    {
      ac.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", new Object[] { Integer.valueOf(paramq.Fpr.ncM.size()) });
      paramArrayOfByte = paramq.Fpr.ncM.iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject1 = (xv)paramArrayOfByte.next();
        Object localObject2;
        if (((xv)localObject1).ErL == 400)
        {
          localObject2 = new cae();
          for (;;)
          {
            try
            {
              ((cae)localObject2).parseFrom(((xv)localObject1).ErM.getBufferToBytes());
              ac.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", new Object[] { ((cae)localObject2).iod });
              localObject1 = s.a((cae)localObject2);
              ac.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { ((av)localObject1).field_username, ((av)localObject1).field_nickname, ((av)localObject1).field_conRemark, Integer.valueOf(((ai)localObject1).getSource()), Integer.valueOf(((av)localObject1).exL), ((av)localObject1).field_openImAppid, ((av)localObject1).eyp, Integer.valueOf(((av)localObject1).eyo), Integer.valueOf(((av)localObject1).field_type), ((av)localObject1).field_descWordingId });
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().af((ai)localObject1);
              if (!((ai)localObject1).aaN()) {
                break label607;
              }
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNO(((av)localObject1).field_username);
              ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bA(((cae)localObject2).app_id, ((cae)localObject2).Fpg);
              s.b((cae)localObject2);
              com.tencent.mm.kernel.g.agS();
              localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awC().alK(((av)localObject1).field_username);
              if ((localObject2 == null) || (bs.isNullOrNil(((bz)localObject2).field_encryptUsername))) {
                break;
              }
              String str = ((bz)localObject2).field_conRemark;
              ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).aI(((av)localObject1).field_username, str);
              com.tencent.mm.kernel.g.agS();
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awC().alL(((av)localObject1).field_username);
              ((ai)localObject1).qh(((bz)localObject2).field_conRemark);
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().af((ai)localObject1);
            }
            catch (IOException localIOException1)
            {
              ac.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", new Object[] { localIOException1 });
            }
            break;
            label607:
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNP(localIOException1.field_username);
          }
        }
        if (localIOException1.ErL == 402)
        {
          localObject2 = new abk();
          try
          {
            ((abk)localObject2).parseFrom(localIOException1.ErM.getBufferToBytes());
            ac.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", new Object[] { ((abk)localObject2).iod });
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNG(((abk)localObject2).iod);
            w.wJ(((abk)localObject2).iod);
          }
          catch (IOException localIOException2)
          {
            ac.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", new Object[] { localIOException2 });
          }
        }
        else if (localIOException2.ErL == 403)
        {
          try
          {
            localObject2 = new bzy();
            ((bzy)localObject2).parseFrom(localIOException2.ErM.getBufferToBytes());
            ac.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", new Object[] { ((bzy)localObject2).ioe });
            com.tencent.mm.openim.room.a.a.a((bzy)localObject2, -1, ((bzy)localObject2).FoO);
          }
          catch (IOException localIOException3)
          {
            ac.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", new Object[] { localIOException3 });
          }
        }
        else if (localIOException3.ErL == 404)
        {
          localObject2 = new cae();
          try
          {
            ((cae)localObject2).parseFrom(localIOException3.ErM.getBufferToBytes());
            ac.i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", new Object[] { ((cae)localObject2).iod });
            com.tencent.mm.kernel.g.agQ().ghe.a(new h(((cae)localObject2).iod, "", ""), 0);
          }
          catch (IOException localIOException4)
          {
            ac.e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", new Object[] { localIOException4 });
          }
        }
      }
    }
    paramArrayOfByte = paramq.Fpq.getBuffer().toByteArray();
    com.tencent.mm.kernel.g.agS();
    paramArrayOfByte = ad.k(bs.aLu(bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(8195, null))), paramArrayOfByte);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(8195, bs.cx(paramArrayOfByte));
    }
    paramInt1 = paramq.qXl;
    if ((paramString.hLw & paramInt1) == 0)
    {
      ac.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd end");
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(151230);
      return;
    }
    doScene(dispatcher(), this.callback);
    AppMethodBeat.o(151230);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.r
 * JD-Core Version:    0.7.0.1
 */