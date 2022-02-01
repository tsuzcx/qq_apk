package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.cg;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.ak.n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public r()
  {
    AppMethodBeat.i(151228);
    b.a locala = new b.a();
    locala.hQF = new cgi();
    locala.hQG = new cgj();
    locala.uri = "/cgi-bin/micromsg-bin/openimsync";
    locala.funcId = 810;
    this.rr = locala.aDS();
    ((cgi)this.rr.hQD.hQJ).dvk = 2097152;
    ae.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(151228);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(151229);
    g.ajS();
    byte[] arrayOfByte = bu.aSx(bu.nullAsNil((String)g.ajR().ajA().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((cgi)this.rr.hQD.hQJ).HsC = localSKBuiltinBuffer_t;
    this.callback = paramf;
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
    ae.i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151230);
      return;
    }
    paramString = (cgi)this.rr.hQD.hQJ;
    paramq = (cgj)this.rr.hQE.hQJ;
    if ((paramq.HsD != null) && (paramq.HsD.nIE.size() > 0))
    {
      ae.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", new Object[] { Integer.valueOf(paramq.HsD.nIE.size()) });
      paramArrayOfByte = paramq.HsD.nIE.iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject1 = (zx)paramArrayOfByte.next();
        Object localObject2;
        if (((zx)localObject1).Gru == 400)
        {
          localObject2 = new cfp();
          for (;;)
          {
            try
            {
              ((cfp)localObject2).parseFrom(((zx)localObject1).Grv.getBufferToBytes());
              ae.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", new Object[] { ((cfp)localObject2).iKt });
              localObject1 = s.a((cfp)localObject2);
              ae.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { ((aw)localObject1).field_username, ((aw)localObject1).field_nickname, ((aw)localObject1).field_conRemark, Integer.valueOf(((an)localObject1).getSource()), Integer.valueOf(((aw)localObject1).eQV), ((aw)localObject1).field_openImAppid, ((aw)localObject1).eRy, Integer.valueOf(((aw)localObject1).eRx), Integer.valueOf(((aw)localObject1).field_type), ((aw)localObject1).field_descWordingId });
              ((l)g.ab(l.class)).azF().am((an)localObject1);
              if (!((an)localObject1).adB()) {
                break label607;
              }
              ((l)g.ab(l.class)).azL().aVg(((aw)localObject1).field_username);
              ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).bB(((cfp)localObject2).app_id, ((cfp)localObject2).Hss);
              s.b((cfp)localObject2);
              g.ajS();
              localObject2 = ((l)g.ab(l.class)).azG().arE(((aw)localObject1).field_username);
              if ((localObject2 == null) || (bu.isNullOrNil(((cg)localObject2).field_encryptUsername))) {
                break;
              }
              String str = ((cg)localObject2).field_conRemark;
              ((com.tencent.mm.plugin.messenger.foundation.a.r)g.ab(com.tencent.mm.plugin.messenger.foundation.a.r.class)).ak(((aw)localObject1).field_username, str);
              g.ajS();
              ((l)g.ab(l.class)).azG().arF(((aw)localObject1).field_username);
              ((an)localObject1).tm(((cg)localObject2).field_conRemark);
              ((l)g.ab(l.class)).azF().am((an)localObject1);
            }
            catch (IOException localIOException1)
            {
              ae.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", new Object[] { localIOException1 });
            }
            break;
            label607:
            ((l)g.ab(l.class)).azL().aVh(localIOException1.field_username);
          }
        }
        if (localIOException1.Gru == 402)
        {
          localObject2 = new adt();
          try
          {
            ((adt)localObject2).parseFrom(localIOException1.Grv.getBufferToBytes());
            ae.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", new Object[] { ((adt)localObject2).iKt });
            ((l)g.ab(l.class)).azL().aUY(((adt)localObject2).iKt);
            x.Aq(((adt)localObject2).iKt);
          }
          catch (IOException localIOException2)
          {
            ae.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", new Object[] { localIOException2 });
          }
        }
        else if (localIOException2.Gru == 403)
        {
          try
          {
            localObject2 = new cfj();
            ((cfj)localObject2).parseFrom(localIOException2.Grv.getBufferToBytes());
            ae.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", new Object[] { ((cfj)localObject2).iKu });
            com.tencent.mm.openim.room.a.a.a((cfj)localObject2, -1, ((cfj)localObject2).Hsb);
          }
          catch (IOException localIOException3)
          {
            ae.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", new Object[] { localIOException3 });
          }
        }
        else if (localIOException3.Gru == 404)
        {
          localObject2 = new cfp();
          try
          {
            ((cfp)localObject2).parseFrom(localIOException3.Grv.getBufferToBytes());
            ae.i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", new Object[] { ((cfp)localObject2).iKt });
            g.ajQ().gDv.a(new h(((cfp)localObject2).iKt, "", ""), 0);
          }
          catch (IOException localIOException4)
          {
            ae.e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", new Object[] { localIOException4 });
          }
        }
      }
    }
    paramArrayOfByte = paramq.HsC.getBuffer().toByteArray();
    g.ajS();
    paramArrayOfByte = ad.l(bu.aSx(bu.nullAsNil((String)g.ajR().ajA().get(8195, null))), paramArrayOfByte);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      g.ajS();
      g.ajR().ajA().set(8195, bu.cH(paramArrayOfByte));
    }
    paramInt1 = paramq.sjK;
    if ((paramString.dvk & paramInt1) == 0)
    {
      ae.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd end");
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
    return n.b.hRi;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.r
 * JD-Core Version:    0.7.0.1
 */