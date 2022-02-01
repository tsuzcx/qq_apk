package com.tencent.mm.openim.b;

import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.room.a.a.1;
import com.tencent.mm.openim.room.a.a.2;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.caa;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private final String djF;
  private final com.tencent.mm.ak.b rr;
  private final int version;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(151193);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bau();
    ((b.a)localObject).hvu = new bav();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
    ((b.a)localObject).funcId = 942;
    this.rr = ((b.a)localObject).aAz();
    this.djF = paramString;
    this.version = paramInt;
    localObject = (bau)this.rr.hvr.hvw;
    ((bau)localObject).ioe = paramString;
    ((bau)localObject).ERE = paramInt;
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(151193);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(151195);
    this.callback = paramg;
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
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.djF, Integer.valueOf(this.version) });
    if (paramInt3 == 0)
    {
      paramArrayOfByte = (bav)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xO(this.djF);
      long l = paramArrayOfByte.ERF;
      ac.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", new Object[] { Integer.valueOf(paramArrayOfByte.ERF), Integer.valueOf(this.version) });
      if (this.version < (0xFFFFFFFF & l))
      {
        ((x)localObject).YE(paramArrayOfByte.ERF);
        label182:
        com.tencent.mm.openim.room.a.c localc;
        bj localbj;
        j localj;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label307:
        Iterator localIterator;
        if (paramArrayOfByte.ERG == null)
        {
          paramq = null;
          if (paramq != null) {
            break label545;
          }
          paramInt1 = -1;
          ac.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          ((x)localObject).z(u.axw(), com.tencent.mm.openim.room.a.b.c.aE(paramq));
          ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().replace((com.tencent.mm.sdk.e.c)localObject);
          localObject = paramArrayOfByte.ERG;
          localc = new com.tencent.mm.openim.room.a.c();
          if (localObject == null) {
            break label913;
          }
          paramq = ((caa)localObject).DQg;
          localbj = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB();
          localj = p.aBw();
          localLinkedList1 = new LinkedList();
          localLinkedList2 = new LinkedList();
          if (paramq != null) {
            break label556;
          }
          paramInt1 = -1;
          ac.i("OpenIMChatRoomContactLogic", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          if (paramInt1 < 0) {
            break label913;
          }
          if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
            break label567;
          }
          paramInt1 = 0;
          localc.fsu = paramInt1;
          localIterator = paramq.iterator();
        }
        for (;;)
        {
          label355:
          if (!localIterator.hasNext()) {
            break label773;
          }
          cad localcad = (cad)localIterator.next();
          if ((((caa)localObject).Fpe == 0) && (!bs.isNullOrNil(localcad.userName)) && (!bs.isNullOrNil(localcad.Eug)))
          {
            paramArrayOfByte = localj.Ak(localcad.userName);
            paramq = paramArrayOfByte;
            if (paramArrayOfByte == null)
            {
              paramq = new i();
              paramq.username = localcad.userName;
            }
            paramq.huF = localcad.Euf;
            paramq.huE = localcad.Eug;
            paramq.exK = 3;
            if (bs.isNullOrNil(localcad.Euf)) {
              break label633;
            }
          }
          label545:
          label556:
          label567:
          label633:
          for (boolean bool = true;; bool = false)
          {
            paramq.ez(bool);
            localLinkedList2.add(paramq);
            paramq = localbj.aNt(localcad.userName);
            if (paramq != null) {
              break label639;
            }
            ac.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
            break label355;
            paramq = paramArrayOfByte.ERG.DQg;
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
            for (paramInt1 = com.tencent.mm.kernel.g.agU().eVl();; paramInt1 = 0)
            {
              paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
              break;
            }
          }
          label639:
          if (paramq.aaG())
          {
            paramq.qj(localcad.bLs);
            localLinkedList1.add(new Pair(localcad.userName, paramq));
          }
          if (!bs.isNullOrNil(localcad.appId)) {
            paramq.qs(localcad.appId);
          }
          if (!bs.isNullOrNil(localcad.Fpg)) {
            paramq.qr(localcad.Fpg);
          }
          localbj.af(paramq);
          if (!bs.isNullOrNil(localcad.appId)) {
            ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).t(localcad.appId, ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext()), localcad.Fpg);
          }
        }
        label773:
        ac.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
        if (!localLinkedList2.isEmpty())
        {
          localc.qg(1);
          new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new a.1(localLinkedList2, localc, localj), true).au(100L, 100L);
        }
        if (!localLinkedList1.isEmpty())
        {
          localc.qg(2);
          new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new a.2(localLinkedList1, localc, localbj), true).au(100L, 100L);
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