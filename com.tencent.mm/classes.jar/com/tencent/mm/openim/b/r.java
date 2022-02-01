package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bw;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private final com.tencent.mm.al.b rr;
  
  public r()
  {
    AppMethodBeat.i(151228);
    b.a locala = new b.a();
    locala.gUU = new bwf();
    locala.gUV = new bwg();
    locala.uri = "/cgi-bin/micromsg-bin/openimsync";
    locala.funcId = 810;
    this.rr = locala.atI();
    ((bwf)this.rr.gUS.gUX).hkT = 2097152;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(151228);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(151229);
    com.tencent.mm.kernel.g.afC();
    byte[] arrayOfByte = bt.aGd(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8195, null)));
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    localSKBuiltinBuffer_t.setBuffer(arrayOfByte);
    ((bwf)this.rr.gUS.gUX).DSU = localSKBuiltinBuffer_t;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151230);
      return;
    }
    paramString = (bwf)this.rr.gUS.gUX;
    paramq = (bwg)this.rr.gUT.gUX;
    if ((paramq.DSV != null) && (paramq.DSV.mAL.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", new Object[] { Integer.valueOf(paramq.DSV.mAL.size()) });
      paramArrayOfByte = paramq.DSV.mAL.iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject1 = (xd)paramArrayOfByte.next();
        Object localObject2;
        if (((xd)localObject1).CYY == 400)
        {
          localObject2 = new bvm();
          for (;;)
          {
            try
            {
              ((bvm)localObject2).parseFrom(((xd)localObject1).CYZ.getBufferToBytes());
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", new Object[] { ((bvm)localObject2).hNH });
              localObject1 = s.a((bvm)localObject2);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { ((au)localObject1).field_username, ((au)localObject1).field_nickname, ((au)localObject1).field_conRemark, Integer.valueOf(((af)localObject1).getSource()), Integer.valueOf(((au)localObject1).evp), ((au)localObject1).field_openImAppid, ((au)localObject1).evS, Integer.valueOf(((au)localObject1).evR), Integer.valueOf(((au)localObject1).field_type), ((au)localObject1).field_descWordingId });
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().ae((af)localObject1);
              if (!((af)localObject1).ZS()) {
                break label607;
              }
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIt(((au)localObject1).field_username);
              ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bs(((bvm)localObject2).app_id, ((bvm)localObject2).DSK);
              s.b((bvm)localObject2);
              com.tencent.mm.kernel.g.afC();
              localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apN().agQ(((au)localObject1).field_username);
              if ((localObject2 == null) || (bt.isNullOrNil(((bw)localObject2).field_encryptUsername))) {
                break;
              }
              String str = ((bw)localObject2).field_conRemark;
              ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).aA(((au)localObject1).field_username, str);
              com.tencent.mm.kernel.g.afC();
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apN().agR(((au)localObject1).field_username);
              ((af)localObject1).nb(((bw)localObject2).field_conRemark);
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().ae((af)localObject1);
            }
            catch (IOException localIOException1)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", new Object[] { localIOException1 });
            }
            break;
            label607:
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIu(localIOException1.field_username);
          }
        }
        if (localIOException1.CYY == 402)
        {
          localObject2 = new aal();
          try
          {
            ((aal)localObject2).parseFrom(localIOException1.CYZ.getBufferToBytes());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", new Object[] { ((aal)localObject2).hNH });
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIl(((aal)localObject2).hNH);
            w.sG(((aal)localObject2).hNH);
          }
          catch (IOException localIOException2)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", new Object[] { localIOException2 });
          }
        }
        else if (localIOException2.CYY == 403)
        {
          try
          {
            localObject2 = new bvg();
            ((bvg)localObject2).parseFrom(localIOException2.CYZ.getBufferToBytes());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", new Object[] { ((bvg)localObject2).hNI });
            com.tencent.mm.openim.room.a.a.b((bvg)localObject2);
          }
          catch (IOException localIOException3)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", new Object[] { localIOException3 });
          }
        }
        else if (localIOException3.CYY == 404)
        {
          localObject2 = new bvm();
          try
          {
            ((bvm)localObject2).parseFrom(localIOException3.CYZ.getBufferToBytes());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", new Object[] { ((bvm)localObject2).hNH });
            com.tencent.mm.kernel.g.afA().gcy.a(new h(((bvm)localObject2).hNH, "", ""), 0);
          }
          catch (IOException localIOException4)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", new Object[] { localIOException4 });
          }
        }
      }
    }
    paramArrayOfByte = paramq.DSU.getBuffer().toByteArray();
    com.tencent.mm.kernel.g.afC();
    paramArrayOfByte = com.tencent.mm.protocal.ad.k(bt.aGd(bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(8195, null))), paramArrayOfByte);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(8195, bt.cy(paramArrayOfByte));
    }
    paramInt1 = paramq.qys;
    if ((paramString.hkT & paramInt1) == 0)
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
    return n.b.gVB;
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