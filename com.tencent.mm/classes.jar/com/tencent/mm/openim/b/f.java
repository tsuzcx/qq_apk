package com.tencent.mm.openim.b;

import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.openim.room.a.a.1;
import com.tencent.mm.openim.room.a.a.2;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.ahw;
import com.tencent.mm.protocal.c.ahx;
import com.tencent.mm.protocal.c.baz;
import com.tencent.mm.protocal.c.bbc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
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
  private final com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private final String ePP;
  private final int version;
  
  public f(String paramString, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ahw();
    ((b.a)localObject).ecI = new ahx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
    ((b.a)localObject).ecG = 942;
    this.dmK = ((b.a)localObject).Kt();
    this.ePP = paramString;
    this.version = paramInt;
    localObject = (ahw)this.dmK.ecE.ecN;
    ((ahw)localObject).ePR = paramString;
    ((ahw)localObject).tfn = paramInt;
    y.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePP, Integer.valueOf(this.version) });
    if (paramInt3 == 0)
    {
      paramArrayOfByte = (ahx)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().io(this.ePP);
      long l = paramArrayOfByte.tfo;
      y.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", new Object[] { Integer.valueOf(paramArrayOfByte.tfo), Integer.valueOf(this.version) });
      if (this.version < (0xFFFFFFFF & l))
      {
        ((u)localObject).Fk(paramArrayOfByte.tfo);
        u.ctP();
        label181:
        com.tencent.mm.openim.room.a.c localc;
        bd localbd;
        i locali;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label306:
        Iterator localIterator;
        if (paramArrayOfByte.tfp == null)
        {
          paramq = null;
          if (paramq != null) {
            break label544;
          }
          paramInt1 = -1;
          y.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          ((u)localObject).t(com.tencent.mm.model.q.Gj(), com.tencent.mm.openim.room.a.b.c.ae(paramq));
          ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().a((com.tencent.mm.sdk.e.c)localObject);
          localObject = paramArrayOfByte.tfp;
          localc = new com.tencent.mm.openim.room.a.c();
          if (localObject == null) {
            break label912;
          }
          paramq = ((baz)localObject).svR;
          localbd = ((j)g.r(j.class)).Fw();
          locali = o.Kh();
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          if (paramq != null) {
            break label555;
          }
          paramInt1 = -1;
          y.i("OpenIMChatRoomContactLogic", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 < 0) {
            break label912;
          }
          if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
            break label566;
          }
          paramInt1 = 0;
          localc.dmY = paramInt1;
          localIterator = paramq.iterator();
        }
        for (;;)
        {
          label354:
          if (!localIterator.hasNext()) {
            break label772;
          }
          bbc localbbc = (bbc)localIterator.next();
          if ((((baz)localObject).txe == 0) && (!bk.bl(localbbc.userName)) && (!bk.bl(localbbc.sQg)))
          {
            paramArrayOfByte = locali.kp(localbbc.userName);
            paramq = paramArrayOfByte;
            if (paramArrayOfByte == null)
            {
              paramq = new h();
              paramq.username = localbbc.userName;
            }
            paramq.ebT = localbbc.sQf;
            paramq.ebS = localbbc.sQg;
            paramq.cCq = 3;
            if (bk.bl(localbbc.sQf)) {
              break label632;
            }
          }
          label544:
          label555:
          label566:
          label632:
          for (boolean bool = true;; bool = false)
          {
            paramq.bK(bool);
            localLinkedList2.add(paramq);
            paramq = localbd.abl(localbbc.userName);
            if (paramq != null) {
              break label638;
            }
            y.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
            break label354;
            paramq = paramArrayOfByte.tfp.svR;
            break;
            paramInt1 = paramq.size();
            break label181;
            paramInt1 = paramq.size();
            break label306;
            bool = WXHardCoderJNI.hcUpdateChatroomEnable;
            int i = WXHardCoderJNI.hcUpdateChatroomDelay;
            int j = WXHardCoderJNI.hcUpdateChatroomCPU;
            int k = WXHardCoderJNI.hcUpdateChatroomIO;
            if (WXHardCoderJNI.hcUpdateChatroomThr) {}
            for (paramInt1 = g.DS().crd();; paramInt1 = 0)
            {
              paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
              break;
            }
          }
          label638:
          if (paramq.Bf())
          {
            paramq.dk(localbbc.aVr);
            localLinkedList1.add(new Pair(localbbc.userName, paramq));
          }
          if (!bk.bl(localbbc.appId)) {
            paramq.dt(localbbc.appId);
          }
          if (!bk.bl(localbbc.txg)) {
            paramq.ds(localbbc.txg);
          }
          localbd.U(paramq);
          if (!bk.bl(localbbc.appId)) {
            ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).r(localbbc.appId, x.fB(ae.getContext()), localbbc.txg);
          }
        }
        label772:
        y.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
        if (!localLinkedList2.isEmpty())
        {
          localc.jH(1);
          new am(g.DS().mnU.getLooper(), new a.1(localLinkedList2, localc, locali), true).S(100L, 100L);
        }
        if (!localLinkedList1.isEmpty())
        {
          localc.jH(2);
          new am(g.DS().mnU.getLooper(), new a.2(localLinkedList1, localc, localbd), true).S(100L, 100L);
        }
      }
    }
    label912:
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 942;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.f
 * JD-Core Version:    0.7.0.1
 */