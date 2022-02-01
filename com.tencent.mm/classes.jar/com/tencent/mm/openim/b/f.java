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
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.room.a.a.1;
import com.tencent.mm.openim.room.a.a.2;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private final String dlX;
  private final com.tencent.mm.al.b rr;
  private final int version;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(151193);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new axc();
    ((b.a)localObject).gUV = new axd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenimchatroommemberdetail";
    ((b.a)localObject).funcId = 942;
    this.rr = ((b.a)localObject).atI();
    this.dlX = paramString;
    this.version = paramInt;
    localObject = (axc)this.rr.gUS.gUX;
    ((axc)localObject).hNI = paramString;
    ((axc)localObject).Dwj = paramInt;
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "get roomname:%s, version=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(151193);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
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
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dlX, Integer.valueOf(this.version) });
    if (paramInt3 == 0)
    {
      paramArrayOfByte = (axd)((com.tencent.mm.al.b)paramq).gUT.gUX;
      Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tI(this.dlX);
      long l = paramArrayOfByte.Dwk;
      ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail svrVer:%d, localVer:%d", new Object[] { Integer.valueOf(paramArrayOfByte.Dwk), Integer.valueOf(this.version) });
      if (this.version < (0xFFFFFFFF & l))
      {
        ((w)localObject).Wu(paramArrayOfByte.Dwk);
        label182:
        com.tencent.mm.openim.room.a.c localc;
        bg localbg;
        j localj;
        LinkedList localLinkedList1;
        LinkedList localLinkedList2;
        label307:
        Iterator localIterator;
        if (paramArrayOfByte.Dwl == null)
        {
          paramq = null;
          if (paramq != null) {
            break label545;
          }
          paramInt1 = -1;
          ad.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomMemberDetail", "updateMemberDetail memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
          ((w)localObject).C(u.aqG(), com.tencent.mm.openim.room.a.b.c.aH(paramq));
          ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().replace((com.tencent.mm.sdk.e.c)localObject);
          localObject = paramArrayOfByte.Dwl;
          localc = new com.tencent.mm.openim.room.a.c();
          if (localObject == null) {
            break label913;
          }
          paramq = ((bvi)localObject).CxK;
          localbg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM();
          localj = p.auF();
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
          localc.foV = paramInt1;
          localIterator = paramq.iterator();
        }
        for (;;)
        {
          label355:
          if (!localIterator.hasNext()) {
            break label773;
          }
          bvl localbvl = (bvl)localIterator.next();
          if ((((bvi)localObject).DSI == 0) && (!bt.isNullOrNil(localbvl.userName)) && (!bt.isNullOrNil(localbvl.Dbh)))
          {
            paramArrayOfByte = localj.we(localbvl.userName);
            paramq = paramArrayOfByte;
            if (paramArrayOfByte == null)
            {
              paramq = new i();
              paramq.username = localbvl.userName;
            }
            paramq.gUg = localbvl.Dbg;
            paramq.gUf = localbvl.Dbh;
            paramq.evo = 3;
            if (bt.isNullOrNil(localbvl.Dbg)) {
              break label633;
            }
          }
          label545:
          label556:
          label567:
          label633:
          for (boolean bool = true;; bool = false)
          {
            paramq.ee(bool);
            localLinkedList2.add(paramq);
            paramq = localbg.aHY(localbvl.userName);
            if (paramq != null) {
              break label639;
            }
            ad.e("OpenIMChatRoomContactLogic", "updateMemberDetail memberlist username is null");
            break label355;
            paramq = paramArrayOfByte.Dwl.CxK;
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
            for (paramInt1 = com.tencent.mm.kernel.g.afE().eFQ();; paramInt1 = 0)
            {
              paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "PerfTrace");
              break;
            }
          }
          label639:
          if (paramq.ZL())
          {
            paramq.nd(localbvl.bNK);
            localLinkedList1.add(new Pair(localbvl.userName, paramq));
          }
          if (!bt.isNullOrNil(localbvl.appId)) {
            paramq.nm(localbvl.appId);
          }
          if (!bt.isNullOrNil(localbvl.DSK)) {
            paramq.nl(localbvl.DSK);
          }
          localbg.ae(paramq);
          if (!bt.isNullOrNil(localbvl.appId)) {
            ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).t(localbvl.appId, ac.ir(com.tencent.mm.sdk.platformtools.aj.getContext()), localbvl.DSK);
          }
        }
        label773:
        ad.d("OpenIMChatRoomContactLogic", "updateMemberDetail update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
        if (!localLinkedList2.isEmpty())
        {
          localc.ps(1);
          new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new a.1(localLinkedList2, localc, localj), true).av(100L, 100L);
        }
        if (!localLinkedList1.isEmpty())
        {
          localc.ps(2);
          new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new a.2(localLinkedList1, localc, localbg), true).av(100L, 100L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.f
 * JD-Core Version:    0.7.0.1
 */