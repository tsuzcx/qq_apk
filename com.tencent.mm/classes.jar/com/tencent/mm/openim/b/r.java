package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.dfa;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.protocal.protobuf.dfz;
import com.tencent.mm.protocal.protobuf.dga;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.co;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public r()
  {
    AppMethodBeat.i(151228);
    d.a locala = new d.a();
    locala.lBU = new dfz();
    locala.lBV = new dga();
    locala.uri = "/cgi-bin/micromsg-bin/openimsync";
    locala.funcId = 810;
    this.rr = locala.bgN();
    ((dfz)d.b.b(this.rr.lBR)).fFT = 2097152;
    Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(151228);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151229);
    com.tencent.mm.kernel.h.aHH();
    byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(8195, null)));
    eae localeae = new eae();
    localeae.dc(arrayOfByte);
    ((dfz)d.b.b(this.rr.lBR)).TNf = localeae;
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151229);
    return i;
  }
  
  public final int getType()
  {
    return 810;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151230);
    Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151230);
      return;
    }
    paramString = (dfz)d.b.b(this.rr.lBR);
    params = (dga)d.c.b(this.rr.lBS);
    if ((params.TNg != null) && (params.TNg.rVy.size() > 0))
    {
      Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", new Object[] { Integer.valueOf(params.TNg.rVy.size()) });
      paramArrayOfByte = params.TNg.rVy.iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject1 = (abu)paramArrayOfByte.next();
        Object localObject2;
        if (((abu)localObject1).SnG == 400)
        {
          localObject2 = new dfg();
          for (;;)
          {
            try
            {
              ((dfg)localObject2).parseFrom(((abu)localObject1).SnH.Tkb.UH);
              Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", new Object[] { ((dfg)localObject2).myd });
              localObject1 = s.b((dfg)localObject2);
              Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { ((ax)localObject1).field_username, ((ax)localObject1).field_nickname, ((ax)localObject1).field_conRemark, Integer.valueOf(((as)localObject1).getSource()), Integer.valueOf(((ax)localObject1).sex), ((ax)localObject1).field_openImAppid, ((ax)localObject1).hDA, Integer.valueOf(((ax)localObject1).hDz), Integer.valueOf(((ax)localObject1).field_type), ((ax)localObject1).field_descWordingId });
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().au((as)localObject1);
              if (!((as)localObject1).ayn()) {
                break label615;
              }
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwD(((ax)localObject1).field_username);
              ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bQ(((dfg)localObject2).app_id, ((dfg)localObject2).TMW);
              s.c((dfg)localObject2);
              s.a((dfg)localObject2);
              com.tencent.mm.kernel.h.aHH();
              localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbM().aPj(((ax)localObject1).field_username);
              if ((localObject2 == null) || (Util.isNullOrNil(((co)localObject2).field_encryptUsername))) {
                break;
              }
              String str = ((co)localObject2).field_conRemark;
              ((u)com.tencent.mm.kernel.h.ae(u.class)).ar(((ax)localObject1).field_username, str);
              com.tencent.mm.kernel.h.aHH();
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbM().aPk(((ax)localObject1).field_username);
              ((as)localObject1).Ir(((co)localObject2).field_conRemark);
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().au((as)localObject1);
            }
            catch (IOException localIOException1)
            {
              Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", new Object[] { localIOException1 });
            }
            break;
            label615:
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwE(localIOException1.field_username);
          }
        }
        if (localIOException1.SnG == 402)
        {
          localObject2 = new agf();
          try
          {
            ((agf)localObject2).parseFrom(localIOException1.SnH.Tkb.UH);
            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", new Object[] { ((agf)localObject2).myd });
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwv(((agf)localObject2).myd);
            ab.Qo(((agf)localObject2).myd);
          }
          catch (IOException localIOException2)
          {
            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", new Object[] { localIOException2 });
          }
        }
        else if (localIOException2.SnG == 403)
        {
          try
          {
            localObject2 = new dfa();
            ((dfa)localObject2).parseFrom(localIOException2.SnH.Tkb.UH);
            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", new Object[] { ((dfa)localObject2).mye });
            com.tencent.mm.openim.room.a.a.a((dfa)localObject2, -1, ((dfa)localObject2).TMG);
          }
          catch (IOException localIOException3)
          {
            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", new Object[] { localIOException3 });
          }
        }
        else if (localIOException3.SnG == 404)
        {
          localObject2 = new dfg();
          try
          {
            ((dfg)localObject2).parseFrom(localIOException3.SnH.Tkb.UH);
            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", new Object[] { ((dfg)localObject2).myd });
            com.tencent.mm.kernel.h.aHF().kcd.a(new h(((dfg)localObject2).myd, "", ""), 0);
          }
          catch (IOException localIOException4)
          {
            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", new Object[] { localIOException4 });
          }
        }
      }
    }
    paramArrayOfByte = params.TNf.Tkb.toByteArray();
    com.tencent.mm.kernel.h.aHH();
    paramArrayOfByte = ad.n(Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(8195, null))), paramArrayOfByte);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(8195, Util.encodeHexString(paramArrayOfByte));
    }
    paramInt1 = params.xFI;
    if ((paramString.fFT & paramInt1) == 0)
    {
      Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd end");
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
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.lCx;
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