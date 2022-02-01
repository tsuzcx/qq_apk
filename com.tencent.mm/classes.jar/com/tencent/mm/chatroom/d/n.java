package com.tencent.mm.chatroom.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  final String chatroomName;
  private int fst;
  private int fsu;
  private final b rr;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(12478);
    this.callback = null;
    this.fst = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new avg();
    ((b.a)localObject).hvu = new avh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
    ((b.a)localObject).funcId = 551;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    this.chatroomName = paramString;
    int j = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xO(paramString).eZL();
    ((avg)this.rr.hvr.hvw).ENv = paramString;
    localObject = (avg)this.rr.hvr.hvw;
    if (j < paramInt) {}
    for (int i = paramInt;; i = j)
    {
      ((avg)localObject).DWJ = i;
      ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j), bs.eWi() });
      AppMethodBeat.o(12478);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(12479);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12479);
    return i;
  }
  
  public final int getType()
  {
    return 551;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12480);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12480);
      return;
    }
    ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (avh)this.rr.hvs.hvw;
    paramArrayOfByte = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xO(this.chatroomName);
    long l1 = paramArrayOfByte.eZL();
    long l2 = 0xFFFFFFFF & paramq.ncI;
    Object localObject = this.chatroomName;
    int i = paramq.ncI;
    if (paramq.ENw == null) {}
    for (paramInt1 = 0;; paramInt1 = paramq.ENw.fsB)
    {
      ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s svrVer:%d, modCnt:%d， localVer:%d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramInt1), Long.valueOf(l1) });
      if (l1 < l2) {
        break;
      }
      ac.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12480);
      return;
    }
    paramArrayOfByte.YE(paramq.ncI);
    label312:
    final bj localbj;
    final j localj;
    final LinkedList localLinkedList;
    Iterator localIterator;
    if (paramq.ENw == null)
    {
      paramq = null;
      if (paramq != null) {
        break label581;
      }
      paramInt1 = -1;
      ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      paramArrayOfByte.z(u.axw(), paramq);
      localbj = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB();
      localj = p.aBw();
      localObject = new LinkedList();
      localLinkedList = new LinkedList();
      if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
        break label592;
      }
      paramInt1 = 0;
      this.fsu = paramInt1;
      localIterator = paramq.iterator();
    }
    for (;;)
    {
      label403:
      if (!localIterator.hasNext()) {
        break label764;
      }
      ub localub = (ub)localIterator.next();
      if ((!bs.isNullOrNil(localub.Eog)) && (!bs.isNullOrNil(localub.ncR)))
      {
        paramq = localj.Ak(localub.ncR);
        if (paramq != null) {
          break label657;
        }
        paramq = new com.tencent.mm.aj.i();
        paramq.username = localub.ncR;
        label483:
        paramq.huF = localub.Eof;
        paramq.huE = localub.Eog;
        paramq.exK = 3;
        if (bs.isNullOrNil(localub.Eof)) {
          break label674;
        }
      }
      label657:
      label674:
      for (boolean bool = true;; bool = false)
      {
        paramq.ez(bool);
        localLinkedList.add(paramq);
        paramq = localbj.aNt(localub.ncR);
        if (paramq != null) {
          break label680;
        }
        ac.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
        break label403;
        paramq = paramq.ENw.Eob;
        break;
        label581:
        paramInt1 = paramq.size();
        break label312;
        label592:
        bool = WXHardCoderJNI.hcUpdateChatroomEnable;
        i = WXHardCoderJNI.hcUpdateChatroomDelay;
        int j = WXHardCoderJNI.hcUpdateChatroomCPU;
        int k = WXHardCoderJNI.hcUpdateChatroomIO;
        if (WXHardCoderJNI.hcUpdateChatroomThr) {}
        for (paramInt1 = com.tencent.mm.kernel.g.agU().eVl();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
          break;
        }
        paramq.aBp().equals(localub.Eog);
        break label483;
      }
      label680:
      if (paramq.aaG())
      {
        paramq.qj(localub.ndW);
        ((LinkedList)localObject).add(new Pair(localub.ncR, paramq));
      }
      else
      {
        ac.w("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail isChatRoomContact == false, username %s nickname %s", new Object[] { bs.bG(localub.ncR, ""), bs.bG(localub.ndW, "") });
      }
    }
    label764:
    ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(((LinkedList)localObject).size()) });
    if (!localLinkedList.isEmpty())
    {
      this.fst |= 0x1;
      paramq = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197030);
          int i;
          if (localLinkedList.size() < 25)
          {
            i = localLinkedList.size();
            ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img list size:%d, loopCount:%d", new Object[] { n.this.chatroomName, Integer.valueOf(localLinkedList.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label136;
            }
            ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done loopCount is 0", new Object[] { n.this.chatroomName });
          }
          label136:
          label170:
          do
          {
            for (;;)
            {
              n.a(n.this, 1, paramArrayOfByte);
              ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { n.this.chatroomName });
              AppMethodBeat.o(197030);
              return;
              i = 25;
              break;
              if (!localLinkedList.isEmpty()) {
                break label170;
              }
              ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { n.this.chatroomName });
            }
            long l1 = System.currentTimeMillis();
            long l2 = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
            int j = 0;
            while (j < i)
            {
              com.tencent.mm.aj.i locali = (com.tencent.mm.aj.i)localLinkedList.poll();
              if (locali == null) {
                break;
              }
              localj.b(locali);
              j += 1;
            }
            com.tencent.mm.kernel.g.agR().ghG.qL(l2);
            ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { n.this.chatroomName, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(localLinkedList.size()) });
          } while (localLinkedList.isEmpty());
          com.tencent.e.h.JZN.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(197030);
        }
      };
      com.tencent.e.h.JZN.a(paramq, 100L, "chatroom_member_detail");
    }
    if (!((LinkedList)localObject).isEmpty())
    {
      this.fst |= 0x2;
      paramq = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197031);
          int i;
          if (this.fsz.size() < 25)
          {
            i = this.fsz.size();
            ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg list size:%d, loopCount:%d", new Object[] { n.this.chatroomName, Integer.valueOf(this.fsz.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label136;
            }
            ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done loopCount is 0", new Object[] { n.this.chatroomName });
          }
          label136:
          do
          {
            n.a(n.this, 2, paramArrayOfByte);
            ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done updateList is empty", new Object[] { n.this.chatroomName });
            AppMethodBeat.o(197031);
            return;
            i = 25;
            break;
            long l1 = System.currentTimeMillis();
            long l2 = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
            int j = 0;
            while (j < i)
            {
              Pair localPair = (Pair)this.fsz.poll();
              localbj.c((String)localPair.first, (ai)localPair.second);
              j += 1;
            }
            com.tencent.mm.kernel.g.agR().ghG.qL(l2);
            ac.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { n.this.chatroomName, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(this.fsz.size()) });
          } while (this.fsz.isEmpty());
          com.tencent.e.h.JZN.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(197031);
        }
      };
      com.tencent.e.h.JZN.a(paramq, 100L, "chatroom_member_detail");
    }
    if ((localLinkedList.isEmpty()) && (((LinkedList)localObject).isEmpty())) {
      ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().replace(paramArrayOfByte);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.n
 * JD-Core Version:    0.7.0.1
 */