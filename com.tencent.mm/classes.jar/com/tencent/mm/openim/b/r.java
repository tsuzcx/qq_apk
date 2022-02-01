package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwp;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cn;
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
    locala.iLN = new cwp();
    locala.iLO = new cwq();
    locala.uri = "/cgi-bin/micromsg-bin/openimsync";
    locala.funcId = 810;
    this.rr = locala.aXF();
    ((cwp)this.rr.iLK.iLR).dML = 2097152;
    Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(151228);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(151229);
    com.tencent.mm.kernel.g.aAi();
    byte[] arrayOfByte = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((cwp)this.rr.iLK.iLR).MBy = localSKBuiltinBuffer_t;
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
    paramString = (cwp)this.rr.iLK.iLR;
    params = (cwq)this.rr.iLL.iLR;
    if ((params.MBz != null) && (params.MBz.oTA.size() > 0))
    {
      Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", new Object[] { Integer.valueOf(params.MBz.oTA.size()) });
      paramArrayOfByte = params.MBz.oTA.iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject1 = (abn)paramArrayOfByte.next();
        Object localObject2;
        if (((abn)localObject1).Lms == 400)
        {
          localObject2 = new cvw();
          for (;;)
          {
            try
            {
              ((cvw)localObject2).parseFrom(((abn)localObject1).Lmt.getBufferToBytes());
              Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", new Object[] { ((cvw)localObject2).jGZ });
              localObject1 = s.a((cvw)localObject2);
              Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { ((ax)localObject1).field_username, ((ax)localObject1).field_nickname, ((ax)localObject1).field_conRemark, Integer.valueOf(((as)localObject1).getSource()), Integer.valueOf(((ax)localObject1).fuA), ((ax)localObject1).field_openImAppid, ((ax)localObject1).fvb, Integer.valueOf(((ax)localObject1).fva), Integer.valueOf(((ax)localObject1).field_type), ((ax)localObject1).field_descWordingId });
              ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().ao((as)localObject1);
              if (!((as)localObject1).arE()) {
                break label607;
              }
              ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bke(((ax)localObject1).field_username);
              ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).bM(((cvw)localObject2).app_id, ((cvw)localObject2).MBp);
              s.b((cvw)localObject2);
              com.tencent.mm.kernel.g.aAi();
              localObject2 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSO().aEZ(((ax)localObject1).field_username);
              if ((localObject2 == null) || (Util.isNullOrNil(((cn)localObject2).field_encryptUsername))) {
                break;
              }
              String str = ((cn)localObject2).field_conRemark;
              ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.r.class)).am(((ax)localObject1).field_username, str);
              com.tencent.mm.kernel.g.aAi();
              ((l)com.tencent.mm.kernel.g.af(l.class)).aSO().aFa(((ax)localObject1).field_username);
              ((as)localObject1).BD(((cn)localObject2).field_conRemark);
              ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().ao((as)localObject1);
            }
            catch (IOException localIOException1)
            {
              Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", new Object[] { localIOException1 });
            }
            break;
            label607:
            ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bkf(localIOException1.field_username);
          }
        }
        if (localIOException1.Lms == 402)
        {
          localObject2 = new afw();
          try
          {
            ((afw)localObject2).parseFrom(localIOException1.Lmt.getBufferToBytes());
            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", new Object[] { ((afw)localObject2).jGZ });
            ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjW(((afw)localObject2).jGZ);
            ab.IV(((afw)localObject2).jGZ);
          }
          catch (IOException localIOException2)
          {
            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", new Object[] { localIOException2 });
          }
        }
        else if (localIOException2.Lms == 403)
        {
          try
          {
            localObject2 = new cvq();
            ((cvq)localObject2).parseFrom(localIOException2.Lmt.getBufferToBytes());
            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", new Object[] { ((cvq)localObject2).jHa });
            com.tencent.mm.openim.room.a.a.a((cvq)localObject2, -1, ((cvq)localObject2).MAZ);
          }
          catch (IOException localIOException3)
          {
            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", new Object[] { localIOException3 });
          }
        }
        else if (localIOException3.Lms == 404)
        {
          localObject2 = new cvw();
          try
          {
            ((cvw)localObject2).parseFrom(localIOException3.Lmt.getBufferToBytes());
            Log.i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", new Object[] { ((cvw)localObject2).jGZ });
            com.tencent.mm.kernel.g.aAg().hqi.a(new h(((cvw)localObject2).jGZ, "", ""), 0);
          }
          catch (IOException localIOException4)
          {
            Log.e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", new Object[] { localIOException4 });
          }
        }
      }
    }
    paramArrayOfByte = params.MBy.getBuffer().toByteArray();
    com.tencent.mm.kernel.g.aAi();
    paramArrayOfByte = ad.l(Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(8195, null))), paramArrayOfByte);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(8195, Util.encodeHexString(paramArrayOfByte));
    }
    paramInt1 = params.tUC;
    if ((paramString.dML & paramInt1) == 0)
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
    return q.b.iMq;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.r
 * JD-Core Version:    0.7.0.1
 */