package com.tencent.mm.openim.b;

import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.room.a.a.1;
import com.tencent.mm.openim.room.a.a.2;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private final String gfK;
  private final com.tencent.mm.ai.b rr;
  private final int version;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(78849);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new amx();
    ((b.a)localObject).fsY = new amy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
    ((b.a)localObject).funcId = 942;
    this.rr = ((b.a)localObject).ado();
    this.gfK = paramString;
    this.version = paramInt;
    localObject = (amx)this.rr.fsV.fta;
    ((amx)localObject).gfM = paramString;
    ((amx)localObject).xdy = paramInt;
    ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(78849);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(78851);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78851);
    return i;
  }
  
  public final int getType()
  {
    return 942;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78850);
    ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.gfK, Integer.valueOf(this.version) });
    if (paramInt3 == 0)
    {
      paramArrayOfByte = (amy)((com.tencent.mm.ai.b)paramq).fsW.fta;
      Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oV(this.gfK);
      long l = paramArrayOfByte.xdz;
      ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", new Object[] { Integer.valueOf(paramArrayOfByte.xdz), Integer.valueOf(this.version) });
      if (this.version < (0xFFFFFFFF & l))
      {
        ((u)localObject).Nq(paramArrayOfByte.xdz);
        label182:
        com.tencent.mm.openim.room.a.c localc;
        bd localbd;
        i locali;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label307:
        Iterator localIterator;
        if (paramArrayOfByte.xdA == null)
        {
          paramq = null;
          if (paramq != null) {
            break label545;
          }
          paramInt1 = -1;
          ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          ((u)localObject).w(r.Zn(), com.tencent.mm.openim.room.a.b.c.am(paramq));
          ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().replace((com.tencent.mm.sdk.e.c)localObject);
          localObject = paramArrayOfByte.xdA;
          localc = new com.tencent.mm.openim.room.a.c();
          if (localObject == null) {
            break label913;
          }
          paramq = ((bhz)localObject).wpb;
          localbd = ((j)g.E(j.class)).YA();
          locali = o.adg();
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          if (paramq != null) {
            break label556;
          }
          paramInt1 = -1;
          ab.i("OpenIMChatRoomContactLogic", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 < 0) {
            break label913;
          }
          if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
            break label567;
          }
          paramInt1 = 0;
          localc.eez = paramInt1;
          localIterator = paramq.iterator();
        }
        for (;;)
        {
          label355:
          if (!localIterator.hasNext()) {
            break label773;
          }
          bic localbic = (bic)localIterator.next();
          if ((((bhz)localObject).xxk == 0) && (!bo.isNullOrNil(localbic.userName)) && (!bo.isNullOrNil(localbic.wOB)))
          {
            paramArrayOfByte = locali.rj(localbic.userName);
            paramq = paramArrayOfByte;
            if (paramArrayOfByte == null)
            {
              paramq = new h();
              paramq.username = localbic.userName;
            }
            paramq.fsl = localbic.wOA;
            paramq.fsk = localbic.wOB;
            paramq.dqB = 3;
            if (bo.isNullOrNil(localbic.wOA)) {
              break label633;
            }
          }
          label545:
          label556:
          label567:
          label633:
          for (boolean bool = true;; bool = false)
          {
            paramq.cM(bool);
            localLinkedList2.add(paramq);
            paramq = localbd.arw(localbic.userName);
            if (paramq != null) {
              break label639;
            }
            ab.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
            break label355;
            paramq = paramArrayOfByte.xdA.wpb;
            break;
            paramInt1 = paramq.size();
            break label182;
            paramInt1 = paramq.size();
            break label307;
            bool = WXHardCoderJNI.hcUpdateChatroomEnable;
            int i = WXHardCoderJNI.hcUpdateChatroomDelay;
            int j = WXHardCoderJNI.hcUpdateChatroomCPU;
            int k = WXHardCoderJNI.hcUpdateChatroomIO;
            if (WXHardCoderJNI.hcUpdateChatroomThr) {}
            for (paramInt1 = g.RO().dtc();; paramInt1 = 0)
            {
              paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
              break;
            }
          }
          label639:
          if (paramq.NV())
          {
            paramq.jp(localbic.blZ);
            localLinkedList1.add(new Pair(localbic.userName, paramq));
          }
          if (!bo.isNullOrNil(localbic.appId)) {
            paramq.jy(localbic.appId);
          }
          if (!bo.isNullOrNil(localbic.xxm)) {
            paramq.jx(localbic.xxm);
          }
          localbd.X(paramq);
          if (!bo.isNullOrNil(localbic.appId)) {
            ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).u(localbic.appId, aa.gP(ah.getContext()), localbic.xxm);
          }
        }
        label773:
        ab.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
        if (!localLinkedList2.isEmpty())
        {
          localc.mD(1);
          new ap(g.RO().oNc.getLooper(), new a.1(localLinkedList2, localc, locali), true).ag(100L, 100L);
        }
        if (!localLinkedList1.isEmpty())
        {
          localc.mD(2);
          new ap(g.RO().oNc.getLooper(), new a.2(localLinkedList1, localc, localbd), true).ag(100L, 100L);
        }
      }
    }
    label913:
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.b.f
 * JD-Core Version:    0.7.0.1
 */