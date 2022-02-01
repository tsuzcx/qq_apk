package com.tencent.mm.chatroom.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private f callback;
  final String chatroomName;
  private int fKT;
  private int fKU;
  private final b rr;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(12478);
    this.callback = null;
    this.fKT = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new aze();
    ((b.a)localObject).hNN = new azf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
    ((b.a)localObject).funcId = 551;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    this.chatroomName = paramString;
    int j = ((c)g.ab(c.class)).azz().AO(paramString).fpN();
    ((aze)this.rr.hNK.hNQ).GwA = paramString;
    localObject = (aze)this.rr.hNK.hNQ;
    if (j < paramInt) {}
    for (int i = paramInt;; i = j)
    {
      ((aze)localObject).FCf = i;
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j), bt.flS() });
      AppMethodBeat.o(12478);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(12479);
    this.callback = paramf;
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
      ad.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12480);
      return;
    }
    ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (azf)this.rr.hNL.hNQ;
    paramArrayOfByte = ((c)g.ab(c.class)).azz().AO(this.chatroomName);
    long l1 = paramArrayOfByte.fpN();
    long l2 = 0xFFFFFFFF & paramq.nDf;
    Object localObject = this.chatroomName;
    int i = paramq.nDf;
    if (paramq.GwB == null) {}
    for (paramInt1 = 0;; paramInt1 = paramq.GwB.fLb)
    {
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s svrVer:%d, modCnt:%d， localVer:%d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(paramInt1), Long.valueOf(l1) });
      if (l1 < l2) {
        break;
      }
      ad.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12480);
      return;
    }
    paramArrayOfByte.aaN(paramq.nDf);
    label312:
    final bp localbp;
    final j localj;
    final LinkedList localLinkedList;
    Iterator localIterator;
    if (paramq.GwB == null)
    {
      paramq = null;
      if (paramq != null) {
        break label581;
      }
      paramInt1 = -1;
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      paramArrayOfByte.B(u.aAm(), paramq);
      localbp = ((l)g.ab(l.class)).azp();
      localj = p.aEx();
      localObject = new LinkedList();
      localLinkedList = new LinkedList();
      if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
        break label592;
      }
      paramInt1 = 0;
      this.fKU = paramInt1;
      localIterator = paramq.iterator();
    }
    for (;;)
    {
      label403:
      if (!localIterator.hasNext()) {
        break label764;
      }
      vw localvw = (vw)localIterator.next();
      if ((!bt.isNullOrNil(localvw.FVp)) && (!bt.isNullOrNil(localvw.nDo)))
      {
        paramq = localj.Dj(localvw.nDo);
        if (paramq != null) {
          break label657;
        }
        paramq = new com.tencent.mm.ak.i();
        paramq.username = localvw.nDo;
        label483:
        paramq.hMX = localvw.FVo;
        paramq.hMW = localvw.FVp;
        paramq.ePj = 3;
        if (bt.isNullOrNil(localvw.FVo)) {
          break label674;
        }
      }
      label657:
      label674:
      for (boolean bool = true;; bool = false)
      {
        paramq.eB(bool);
        localLinkedList.add(paramq);
        paramq = localbp.Bf(localvw.nDo);
        if (paramq != null) {
          break label680;
        }
        ad.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
        break label403;
        paramq = paramq.GwB.FVk;
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
        for (paramInt1 = g.ajF().fkS();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
          break;
        }
        paramq.aEr().equals(localvw.FVp);
        break label483;
      }
      label680:
      if (paramq.adj())
      {
        paramq.sT(localvw.nEt);
        ((LinkedList)localObject).add(new Pair(localvw.nDo, paramq));
      }
      else
      {
        ad.w("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail isChatRoomContact == false, username %s nickname %s", new Object[] { bt.bI(localvw.nDo, ""), bt.bI(localvw.nEt, "") });
      }
    }
    label764:
    ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList.size()), Integer.valueOf(((LinkedList)localObject).size()) });
    if (!localLinkedList.isEmpty())
    {
      this.fKT |= 0x1;
      paramq = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213401);
          int i;
          if (localLinkedList.size() < 25)
          {
            i = localLinkedList.size();
            ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img list size:%d, loopCount:%d", new Object[] { n.this.chatroomName, Integer.valueOf(localLinkedList.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label136;
            }
            ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done loopCount is 0", new Object[] { n.this.chatroomName });
          }
          label136:
          label170:
          do
          {
            for (;;)
            {
              n.a(n.this, 1, paramArrayOfByte);
              ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { n.this.chatroomName });
              AppMethodBeat.o(213401);
              return;
              i = 25;
              break;
              if (!localLinkedList.isEmpty()) {
                break label170;
              }
              ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { n.this.chatroomName });
            }
            long l1 = System.currentTimeMillis();
            long l2 = g.ajC().gBq.xO(Thread.currentThread().getId());
            int j = 0;
            while (j < i)
            {
              com.tencent.mm.ak.i locali = (com.tencent.mm.ak.i)localLinkedList.poll();
              if (locali == null) {
                break;
              }
              localj.b(locali);
              j += 1;
            }
            g.ajC().gBq.sJ(l2);
            ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { n.this.chatroomName, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(localLinkedList.size()) });
          } while (localLinkedList.isEmpty());
          com.tencent.e.h.LTJ.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(213401);
        }
      };
      com.tencent.e.h.LTJ.a(paramq, 100L, "chatroom_member_detail");
    }
    if (!((LinkedList)localObject).isEmpty())
    {
      this.fKT |= 0x2;
      paramq = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213402);
          int i;
          if (this.fKZ.size() < 25)
          {
            i = this.fKZ.size();
            ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg list size:%d, loopCount:%d", new Object[] { n.this.chatroomName, Integer.valueOf(this.fKZ.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label136;
            }
            ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done loopCount is 0", new Object[] { n.this.chatroomName });
          }
          label136:
          do
          {
            n.a(n.this, 2, paramArrayOfByte);
            ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done updateList is empty", new Object[] { n.this.chatroomName });
            AppMethodBeat.o(213402);
            return;
            i = 25;
            break;
            long l1 = System.currentTimeMillis();
            long l2 = g.ajC().gBq.xO(Thread.currentThread().getId());
            int j = 0;
            while (j < i)
            {
              Pair localPair = (Pair)this.fKZ.poll();
              localbp.c((String)localPair.first, (am)localPair.second);
              j += 1;
            }
            g.ajC().gBq.sJ(l2);
            ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { n.this.chatroomName, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(this.fKZ.size()) });
          } while (this.fKZ.isEmpty());
          com.tencent.e.h.LTJ.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(213402);
        }
      };
      com.tencent.e.h.LTJ.a(paramq, 100L, "chatroom_member_detail");
    }
    if ((localLinkedList.isEmpty()) && (((LinkedList)localObject).isEmpty())) {
      ((c)g.ab(c.class)).azz().replace(paramArrayOfByte);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.n
 * JD-Core Version:    0.7.0.1
 */