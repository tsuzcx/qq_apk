package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.adk;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cf;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.al.n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public r()
  {
    AppMethodBeat.i(151228);
    b.a locala = new b.a();
    locala.hNM = new cfo();
    locala.hNN = new cfp();
    locala.uri = "/cgi-bin/micromsg-bin/openimsync";
    locala.funcId = 810;
    this.rr = locala.aDC();
    ((cfo)this.rr.hNK.hNQ).duf = 2097152;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(151228);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(151229);
    g.ajD();
    byte[] arrayOfByte = bt.aRa(bt.nullAsNil((String)g.ajC().ajl().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((cfo)this.rr.hNK.hNQ).GZb = localSKBuiltinBuffer_t;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151230);
      return;
    }
    paramString = (cfo)this.rr.hNK.hNQ;
    paramq = (cfp)this.rr.hNL.hNQ;
    if ((paramq.GZc != null) && (paramq.GZc.nDj.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", new Object[] { Integer.valueOf(paramq.GZc.nDj.size()) });
      paramArrayOfByte = paramq.GZc.nDj.iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject1 = (zu)paramArrayOfByte.next();
        Object localObject2;
        if (((zu)localObject1).FYU == 400)
        {
          localObject2 = new cev();
          for (;;)
          {
            try
            {
              ((cev)localObject2).parseFrom(((zu)localObject1).FYV.getBufferToBytes());
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", new Object[] { ((cev)localObject2).iHA });
              localObject1 = s.a((cev)localObject2);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { ((aw)localObject1).field_username, ((aw)localObject1).field_nickname, ((aw)localObject1).field_conRemark, Integer.valueOf(((am)localObject1).getSource()), Integer.valueOf(((aw)localObject1).ePk), ((aw)localObject1).field_openImAppid, ((aw)localObject1).ePN, Integer.valueOf(((aw)localObject1).ePM), Integer.valueOf(((aw)localObject1).field_type), ((aw)localObject1).field_descWordingId });
              ((l)g.ab(l.class)).azp().af((am)localObject1);
              if (!((am)localObject1).adq()) {
                break label607;
              }
              ((l)g.ab(l.class)).azv().aTF(((aw)localObject1).field_username);
              ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bB(((cev)localObject2).app_id, ((cev)localObject2).GYR);
              s.b((cev)localObject2);
              g.ajD();
              localObject2 = ((l)g.ab(l.class)).azq().aqz(((aw)localObject1).field_username);
              if ((localObject2 == null) || (bt.isNullOrNil(((cf)localObject2).field_encryptUsername))) {
                break;
              }
              String str = ((cf)localObject2).field_conRemark;
              ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).aL(((aw)localObject1).field_username, str);
              g.ajD();
              ((l)g.ab(l.class)).azq().aqA(((aw)localObject1).field_username);
              ((am)localObject1).sR(((cf)localObject2).field_conRemark);
              ((l)g.ab(l.class)).azp().af((am)localObject1);
            }
            catch (IOException localIOException1)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", new Object[] { localIOException1 });
            }
            break;
            label607:
            ((l)g.ab(l.class)).azv().aTG(localIOException1.field_username);
          }
        }
        if (localIOException1.FYU == 402)
        {
          localObject2 = new adk();
          try
          {
            ((adk)localObject2).parseFrom(localIOException1.FYV.getBufferToBytes());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", new Object[] { ((adk)localObject2).iHA });
            ((l)g.ab(l.class)).azv().aTx(((adk)localObject2).iHA);
            w.zG(((adk)localObject2).iHA);
          }
          catch (IOException localIOException2)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", new Object[] { localIOException2 });
          }
        }
        else if (localIOException2.FYU == 403)
        {
          try
          {
            localObject2 = new cep();
            ((cep)localObject2).parseFrom(localIOException2.FYV.getBufferToBytes());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", new Object[] { ((cep)localObject2).iHB });
            com.tencent.mm.openim.room.a.a.a((cep)localObject2, -1, ((cep)localObject2).GYA);
          }
          catch (IOException localIOException3)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", new Object[] { localIOException3 });
          }
        }
        else if (localIOException3.FYU == 404)
        {
          localObject2 = new cev();
          try
          {
            ((cev)localObject2).parseFrom(localIOException3.FYV.getBufferToBytes());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", new Object[] { ((cev)localObject2).iHA });
            g.ajB().gAO.a(new h(((cev)localObject2).iHA, "", ""), 0);
          }
          catch (IOException localIOException4)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", new Object[] { localIOException4 });
          }
        }
      }
    }
    paramArrayOfByte = paramq.GZb.getBuffer().toByteArray();
    g.ajD();
    paramArrayOfByte = com.tencent.mm.protocal.ad.k(bt.aRa(bt.nullAsNil((String)g.ajC().ajl().get(8195, null))), paramArrayOfByte);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      g.ajD();
      g.ajC().ajl().set(8195, bt.cE(paramArrayOfByte));
    }
    paramInt1 = paramq.saU;
    if ((paramString.duf & paramInt1) == 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd end");
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
    return n.b.hOp;
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