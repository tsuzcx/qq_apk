package com.tencent.mm.openim.b;

import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.room.a.a.1;
import com.tencent.mm.openim.room.a.a.2;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private final String dwx;
  private final b rr;
  private final int version;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(151193);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bfo();
    ((b.a)localObject).hQG = new bfp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
    ((b.a)localObject).funcId = 942;
    this.rr = ((b.a)localObject).aDS();
    this.dwx = paramString;
    this.version = paramInt;
    localObject = (bfo)this.rr.hQD.hQJ;
    ((bfo)localObject).iKu = paramString;
    ((bfo)localObject).GUw = paramInt;
    ae.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(151193);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dwx, Integer.valueOf(this.version) });
    if (paramInt3 == 0)
    {
      paramArrayOfByte = (bfp)((b)paramq).hQE.hQJ;
      Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().By(this.dwx);
      long l = paramArrayOfByte.GUx;
      ae.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", new Object[] { Integer.valueOf(paramArrayOfByte.GUx), Integer.valueOf(this.version) });
      if (this.version < (0xFFFFFFFF & l))
      {
        ((ac)localObject).abv(paramArrayOfByte.GUx);
        label182:
        com.tencent.mm.openim.room.a.c localc;
        bq localbq;
        j localj;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label307:
        Iterator localIterator;
        if (paramArrayOfByte.GUy == null)
        {
          paramq = null;
          if (paramq != null) {
            break label545;
          }
          paramInt1 = -1;
          ae.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          ((ac)localObject).C(v.aAC(), com.tencent.mm.openim.room.a.b.c.aF(paramq));
          ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().replace((com.tencent.mm.sdk.e.c)localObject);
          localObject = paramArrayOfByte.GUy;
          localc = new com.tencent.mm.openim.room.a.c();
          if (localObject == null) {
            break label913;
          }
          paramq = ((cfl)localObject).FNS;
          localbq = ((l)g.ab(l.class)).azF();
          localj = p.aEN();
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          if (paramq != null) {
            break label556;
          }
          paramInt1 = -1;
          ae.i("OpenIMChatRoomContactLogic", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 < 0) {
            break label913;
          }
          if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
            break label567;
          }
          paramInt1 = 0;
          localc.fMX = paramInt1;
          localIterator = paramq.iterator();
        }
        for (;;)
        {
          label355:
          if (!localIterator.hasNext()) {
            break label773;
          }
          cfo localcfo = (cfo)localIterator.next();
          if ((((cfl)localObject).Hsq == 0) && (!bu.isNullOrNil(localcfo.userName)) && (!bu.isNullOrNil(localcfo.Gug)))
          {
            paramArrayOfByte = localj.DL(localcfo.userName);
            paramq = paramArrayOfByte;
            if (paramArrayOfByte == null)
            {
              paramq = new i();
              paramq.username = localcfo.userName;
            }
            paramq.hPQ = localcfo.Guf;
            paramq.hPP = localcfo.Gug;
            paramq.eQU = 3;
            if (bu.isNullOrNil(localcfo.Guf)) {
              break label633;
            }
          }
          label545:
          label556:
          label567:
          label633:
          for (boolean bool = true;; bool = false)
          {
            paramq.eD(bool);
            localLinkedList2.add(paramq);
            paramq = localbq.BH(localcfo.userName);
            if (paramq != null) {
              break label639;
            }
            ae.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
            break label355;
            paramq = paramArrayOfByte.GUy.FNS;
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
            for (paramInt1 = g.ajU().foN();; paramInt1 = 0)
            {
              paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
              break;
            }
          }
          label639:
          if (paramq.adu())
          {
            paramq.to(localcfo.bVF);
            localLinkedList1.add(new Pair(localcfo.userName, paramq));
          }
          if (!bu.isNullOrNil(localcfo.appId)) {
            paramq.tx(localcfo.appId);
          }
          if (!bu.isNullOrNil(localcfo.Hss)) {
            paramq.tw(localcfo.Hss);
          }
          localbq.am(paramq);
          if (!bu.isNullOrNil(localcfo.appId)) {
            ((a)g.ab(a.class)).s(localcfo.appId, ad.iR(ak.getContext()), localcfo.Hss);
          }
        }
        label773:
        ae.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
        if (!localLinkedList2.isEmpty())
        {
          localc.qL(1);
          new aw(g.ajU().IxZ.getLooper(), new a.1(localLinkedList2, localc, localj), true).ay(100L, 100L);
        }
        if (!localLinkedList1.isEmpty())
        {
          localc.qL(2);
          new aw(g.ajU().IxZ.getLooper(), new a.2(localLinkedList1, localc, localbq), true).ay(100L, 100L);
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