package com.tencent.mm.chatroom.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private f callback;
  final String chatroomName;
  private int fMW;
  private int fMX;
  private final b rr;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(12478);
    this.callback = null;
    this.fMW = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new azu();
    ((b.a)localObject).hQG = new azv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
    ((b.a)localObject).funcId = 551;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    this.chatroomName = paramString;
    int j = ((c)g.ab(c.class)).azP().By(paramString).ftN();
    ((azu)this.rr.hQD.hQJ).GQa = paramString;
    localObject = (azu)this.rr.hQD.hQJ;
    if (j < paramInt) {}
    for (int i = paramInt;; i = j)
    {
      ((azu)localObject).FUA = i;
      ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j), bu.fpN() });
      AppMethodBeat.o(12478);
      return;
    }
  }
  
  private static void a(ac paramac, int paramInt, List<vz> paramList)
  {
    AppMethodBeat.i(217115);
    paramac.abv(paramInt);
    paramac.C(v.aAC(), paramList);
    AppMethodBeat.o(217115);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12480);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12480);
      return;
    }
    ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    final azv localazv = (azv)this.rr.hQE.hQJ;
    ac localac = ((c)g.ab(c.class)).azP().By(this.chatroomName);
    long l1 = localac.ftN();
    long l2 = localazv.nIA & 0xFFFFFFFF;
    paramq = this.chatroomName;
    int i = localazv.nIA;
    if (localazv.GQb == null) {}
    for (paramInt1 = 0;; paramInt1 = localazv.GQb.fNf)
    {
      ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s svrVer:%d, modCnt:%d， localVer:%d", new Object[] { paramq, Integer.valueOf(i), Integer.valueOf(paramInt1), Long.valueOf(l1) });
      if (l1 < l2) {
        break;
      }
      ae.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12480);
      return;
    }
    label302:
    final bq localbq;
    final j localj;
    final LinkedList localLinkedList1;
    final LinkedList localLinkedList2;
    Iterator localIterator;
    if (localazv.GQb == null)
    {
      paramq = null;
      if (paramq != null) {
        break label561;
      }
      paramInt1 = -1;
      ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      localbq = ((l)g.ab(l.class)).azF();
      localj = p.aEN();
      localLinkedList1 = new LinkedList();
      localLinkedList2 = new LinkedList();
      if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
        break label572;
      }
      paramInt1 = 0;
      this.fMX = paramInt1;
      localIterator = paramq.iterator();
    }
    for (;;)
    {
      label383:
      if (!localIterator.hasNext()) {
        break label744;
      }
      vz localvz = (vz)localIterator.next();
      if ((!bu.isNullOrNil(localvz.GnO)) && (!bu.isNullOrNil(localvz.nIJ)))
      {
        paramArrayOfByte = localj.DL(localvz.nIJ);
        if (paramArrayOfByte != null) {
          break label637;
        }
        paramArrayOfByte = new com.tencent.mm.aj.i();
        paramArrayOfByte.username = localvz.nIJ;
        label463:
        paramArrayOfByte.hPQ = localvz.GnN;
        paramArrayOfByte.hPP = localvz.GnO;
        paramArrayOfByte.eQU = 3;
        if (bu.isNullOrNil(localvz.GnN)) {
          break label654;
        }
      }
      label654:
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte.eD(bool);
        localLinkedList2.add(paramArrayOfByte);
        paramArrayOfByte = localbq.BH(localvz.nIJ);
        if (paramArrayOfByte != null) {
          break label660;
        }
        ae.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
        break label383;
        paramq = localazv.GQb.GnJ;
        break;
        label561:
        paramInt1 = paramq.size();
        break label302;
        label572:
        bool = WXHardCoderJNI.hcUpdateChatroomEnable;
        i = WXHardCoderJNI.hcUpdateChatroomDelay;
        int j = WXHardCoderJNI.hcUpdateChatroomCPU;
        int k = WXHardCoderJNI.hcUpdateChatroomIO;
        if (WXHardCoderJNI.hcUpdateChatroomThr) {}
        for (paramInt1 = g.ajU().foN();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
          break;
        }
        label637:
        paramArrayOfByte.aEH().equals(localvz.GnO);
        break label463;
      }
      label660:
      if (paramArrayOfByte.adu())
      {
        paramArrayOfByte.to(localvz.nJO);
        localLinkedList1.add(new Pair(localvz.nIJ, paramArrayOfByte));
      }
      else
      {
        ae.w("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail isChatRoomContact == false, username %s nickname %s", new Object[] { bu.bI(localvz.nIJ, ""), bu.bI(localvz.nJO, "") });
      }
    }
    label744:
    ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
    if (!localLinkedList2.isEmpty())
    {
      this.fMW |= 0x1;
      paramArrayOfByte = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217113);
          int i;
          if (localLinkedList2.size() < 25)
          {
            i = localLinkedList2.size();
            ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img list size:%d, loopCount:%d", new Object[] { n.this.chatroomName, Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label150;
            }
            ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done loopCount is 0", new Object[] { n.this.chatroomName });
          }
          label150:
          label184:
          do
          {
            for (;;)
            {
              n.a(n.this, 1, n.this.chatroomName, localazv.nIA, paramq);
              ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { n.this.chatroomName });
              AppMethodBeat.o(217113);
              return;
              i = 25;
              break;
              if (!localLinkedList2.isEmpty()) {
                break label184;
              }
              ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { n.this.chatroomName });
            }
            long l1 = System.currentTimeMillis();
            long l2 = g.ajR().gDX.yi(Thread.currentThread().getId());
            int j = 0;
            while (j < i)
            {
              com.tencent.mm.aj.i locali = (com.tencent.mm.aj.i)localLinkedList2.poll();
              if (locali == null) {
                break;
              }
              localj.b(locali);
              j += 1;
            }
            g.ajR().gDX.sW(l2);
            ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { n.this.chatroomName, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(localLinkedList2.size()) });
          } while (localLinkedList2.isEmpty());
          com.tencent.e.h.MqF.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(217113);
        }
      };
      com.tencent.e.h.MqF.a(paramArrayOfByte, 100L, "chatroom_member_detail");
    }
    if (!localLinkedList1.isEmpty())
    {
      this.fMW |= 0x2;
      paramArrayOfByte = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217114);
          int i;
          if (localLinkedList1.size() < 25)
          {
            i = localLinkedList1.size();
            ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg list size:%d, loopCount:%d", new Object[] { n.this.chatroomName, Integer.valueOf(localLinkedList1.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label150;
            }
            ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done loopCount is 0", new Object[] { n.this.chatroomName });
          }
          label150:
          do
          {
            n.a(n.this, 2, n.this.chatroomName, localazv.nIA, paramq);
            ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done updateList is empty", new Object[] { n.this.chatroomName });
            AppMethodBeat.o(217114);
            return;
            i = 25;
            break;
            long l1 = System.currentTimeMillis();
            long l2 = g.ajR().gDX.yi(Thread.currentThread().getId());
            int j = 0;
            while (j < i)
            {
              Pair localPair = (Pair)localLinkedList1.poll();
              localbq.c((String)localPair.first, (an)localPair.second);
              j += 1;
            }
            g.ajR().gDX.sW(l2);
            ae.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { n.this.chatroomName, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(localLinkedList1.size()) });
          } while (localLinkedList1.isEmpty());
          com.tencent.e.h.MqF.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(217114);
        }
      };
      com.tencent.e.h.MqF.a(paramArrayOfByte, 100L, "chatroom_member_detail");
    }
    if ((localLinkedList2.isEmpty()) && (localLinkedList1.isEmpty()))
    {
      a(localac, localazv.nIA, paramq);
      ((c)g.ab(c.class)).azP().replace(localac);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.n
 * JD-Core Version:    0.7.0.1
 */