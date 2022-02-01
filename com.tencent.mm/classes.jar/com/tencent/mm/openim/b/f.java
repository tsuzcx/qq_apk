package com.tencent.mm.openim.b;

import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.room.a.a.1;
import com.tencent.mm.openim.room.a.a.2;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bey;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private final String dvs;
  private final com.tencent.mm.al.b rr;
  private final int version;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(151193);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bey();
    ((b.a)localObject).hNN = new bez();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
    ((b.a)localObject).funcId = 942;
    this.rr = ((b.a)localObject).aDC();
    this.dvs = paramString;
    this.version = paramInt;
    localObject = (bey)this.rr.hNK.hNQ;
    ((bey)localObject).iHB = paramString;
    ((bey)localObject).GAW = paramInt;
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(151193);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(151195);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151195);
    return i;
  }
  
  public final int getType()
  {
    return 942;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151194);
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dvs, Integer.valueOf(this.version) });
    if (paramInt3 == 0)
    {
      paramArrayOfByte = (bez)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AO(this.dvs);
      long l = paramArrayOfByte.GAX;
      ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", new Object[] { Integer.valueOf(paramArrayOfByte.GAX), Integer.valueOf(this.version) });
      if (this.version < (0xFFFFFFFF & l))
      {
        ((ab)localObject).aaN(paramArrayOfByte.GAX);
        label182:
        com.tencent.mm.openim.room.a.c localc;
        bp localbp;
        j localj;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label307:
        Iterator localIterator;
        if (paramArrayOfByte.GAY == null)
        {
          paramq = null;
          if (paramq != null) {
            break label545;
          }
          paramInt1 = -1;
          ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          ((ab)localObject).B(u.aAm(), com.tencent.mm.openim.room.a.b.c.aF(paramq));
          ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().replace((com.tencent.mm.sdk.e.c)localObject);
          localObject = paramArrayOfByte.GAY;
          localc = new com.tencent.mm.openim.room.a.c();
          if (localObject == null) {
            break label913;
          }
          paramq = ((cer)localObject).Fvu;
          localbp = ((l)g.ab(l.class)).azp();
          localj = p.aEx();
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          if (paramq != null) {
            break label556;
          }
          paramInt1 = -1;
          ad.i("OpenIMChatRoomContactLogic", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 < 0) {
            break label913;
          }
          if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
            break label567;
          }
          paramInt1 = 0;
          localc.fKU = paramInt1;
          localIterator = paramq.iterator();
        }
        for (;;)
        {
          label355:
          if (!localIterator.hasNext()) {
            break label773;
          }
          ceu localceu = (ceu)localIterator.next();
          if ((((cer)localObject).GYP == 0) && (!bt.isNullOrNil(localceu.userName)) && (!bt.isNullOrNil(localceu.Gbz)))
          {
            paramArrayOfByte = localj.Dj(localceu.userName);
            paramq = paramArrayOfByte;
            if (paramArrayOfByte == null)
            {
              paramq = new i();
              paramq.username = localceu.userName;
            }
            paramq.hMX = localceu.Gby;
            paramq.hMW = localceu.Gbz;
            paramq.ePj = 3;
            if (bt.isNullOrNil(localceu.Gby)) {
              break label633;
            }
          }
          label545:
          label556:
          label567:
          label633:
          for (boolean bool = true;; bool = false)
          {
            paramq.eB(bool);
            localLinkedList2.add(paramq);
            paramq = localbp.Bf(localceu.userName);
            if (paramq != null) {
              break label639;
            }
            ad.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
            break label355;
            paramq = paramArrayOfByte.GAY.Fvu;
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
            for (paramInt1 = g.ajF().fkS();; paramInt1 = 0)
            {
              paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
              break;
            }
          }
          label639:
          if (paramq.adj())
          {
            paramq.sT(localceu.bVF);
            localLinkedList1.add(new Pair(localceu.userName, paramq));
          }
          if (!bt.isNullOrNil(localceu.appId)) {
            paramq.tc(localceu.appId);
          }
          if (!bt.isNullOrNil(localceu.GYR)) {
            paramq.tb(localceu.GYR);
          }
          localbp.af(paramq);
          if (!bt.isNullOrNil(localceu.appId)) {
            ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).s(localceu.appId, ac.iM(aj.getContext()), localceu.GYR);
          }
        }
        label773:
        ad.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
        if (!localLinkedList2.isEmpty())
        {
          localc.qI(1);
          new av(g.ajF().IdO.getLooper(), new a.1(localLinkedList2, localc, localj), true).az(100L, 100L);
        }
        if (!localLinkedList1.isEmpty())
        {
          localc.qI(2);
          new av(g.ajF().IdO.getLooper(), new a.2(localLinkedList1, localc, localbp), true).az(100L, 100L);
        }
      }
    }
    label913:
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.f
 * JD-Core Version:    0.7.0.1
 */