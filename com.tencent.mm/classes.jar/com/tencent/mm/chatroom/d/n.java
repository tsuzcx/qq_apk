package com.tencent.mm.chatroom.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.protocal.protobuf.xh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  final String chatroomName;
  private int gsh;
  private int gsi;
  private final d rr;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(12478);
    this.callback = null;
    this.gsh = 0;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ble();
    ((d.a)localObject).iLO = new blf();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
    ((d.a)localObject).funcId = 551;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    this.chatroomName = paramString;
    int j = ((c)com.tencent.mm.kernel.g.af(c.class)).aSX().Ke(paramString).gBt();
    ((ble)this.rr.iLK.iLR).LUh = paramString;
    localObject = (ble)this.rr.iLK.iLR;
    if (j < paramInt) {}
    for (int i = paramInt;; i = j)
    {
      ((ble)localObject).KOj = i;
      Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j), Util.getStack() });
      AppMethodBeat.o(12478);
      return;
    }
  }
  
  private static void a(ah paramah, int paramInt, List<xh> paramList)
  {
    AppMethodBeat.i(194029);
    paramah.akd(paramInt);
    paramah.I(z.aTY(), paramList);
    AppMethodBeat.o(194029);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(12479);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12479);
    return i;
  }
  
  public final int getType()
  {
    return 551;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12480);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12480);
      return;
    }
    Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    final blf localblf = (blf)this.rr.iLL.iLR;
    ah localah = ((c)com.tencent.mm.kernel.g.af(c.class)).aSX().Ke(this.chatroomName);
    long l1 = localah.gBt();
    long l2 = localblf.oTw & 0xFFFFFFFF;
    params = this.chatroomName;
    int i = localblf.oTw;
    if (localblf.LUi == null) {}
    for (paramInt1 = 0;; paramInt1 = localblf.LUi.gsq)
    {
      Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s svrVer:%d, modCnt:%d， localVer:%d", new Object[] { params, Integer.valueOf(i), Integer.valueOf(paramInt1), Long.valueOf(l1) });
      if (l1 < l2) {
        break;
      }
      Log.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12480);
      return;
    }
    label302:
    final bv localbv;
    final j localj;
    final LinkedList localLinkedList1;
    final LinkedList localLinkedList2;
    Iterator localIterator;
    if (localblf.LUi == null)
    {
      params = null;
      if (params != null) {
        break label561;
      }
      paramInt1 = -1;
      Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      localbv = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN();
      localj = p.aYB();
      localLinkedList1 = new LinkedList();
      localLinkedList2 = new LinkedList();
      if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
        break label572;
      }
      paramInt1 = 0;
      this.gsi = paramInt1;
      localIterator = params.iterator();
    }
    for (;;)
    {
      label383:
      if (!localIterator.hasNext()) {
        break label744;
      }
      xh localxh = (xh)localIterator.next();
      if ((!Util.isNullOrNil(localxh.Lis)) && (!Util.isNullOrNil(localxh.UserName)))
      {
        paramArrayOfByte = localj.Mx(localxh.UserName);
        if (paramArrayOfByte != null) {
          break label637;
        }
        paramArrayOfByte = new com.tencent.mm.aj.i();
        paramArrayOfByte.username = localxh.UserName;
        label463:
        paramArrayOfByte.iKX = localxh.Lir;
        paramArrayOfByte.iKW = localxh.Lis;
        paramArrayOfByte.fuz = 3;
        if (Util.isNullOrNil(localxh.Lir)) {
          break label654;
        }
      }
      label654:
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte.fv(bool);
        localLinkedList2.add(paramArrayOfByte);
        paramArrayOfByte = localbv.Kn(localxh.UserName);
        if (paramArrayOfByte != null) {
          break label660;
        }
        Log.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
        break label383;
        params = localblf.LUi.Lin;
        break;
        label561:
        paramInt1 = params.size();
        break label302;
        label572:
        bool = WXHardCoderJNI.hcUpdateChatroomEnable;
        i = WXHardCoderJNI.hcUpdateChatroomDelay;
        int j = WXHardCoderJNI.hcUpdateChatroomCPU;
        int k = WXHardCoderJNI.hcUpdateChatroomIO;
        if (WXHardCoderJNI.hcUpdateChatroomThr) {}
        for (paramInt1 = com.tencent.mm.kernel.g.aAk().getProcessTid();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
          break;
        }
        label637:
        paramArrayOfByte.aYu().equals(localxh.Lis);
        break label463;
      }
      label660:
      if (paramArrayOfByte.arx())
      {
        paramArrayOfByte.setNickname(localxh.oUJ);
        localLinkedList1.add(new Pair(localxh.UserName, paramArrayOfByte));
      }
      else
      {
        Log.w("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail isChatRoomContact == false, username %s nickname %s", new Object[] { Util.nullAs(localxh.UserName, ""), Util.nullAs(localxh.oUJ, "") });
      }
    }
    label744:
    Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
    if (!localLinkedList2.isEmpty())
    {
      this.gsh |= 0x1;
      paramArrayOfByte = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194027);
          int i;
          if (localLinkedList2.size() < 25)
          {
            i = localLinkedList2.size();
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img list size:%d, loopCount:%d", new Object[] { n.this.chatroomName, Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label150;
            }
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done loopCount is 0", new Object[] { n.this.chatroomName });
          }
          label150:
          label184:
          do
          {
            for (;;)
            {
              n.a(n.this, 1, n.this.chatroomName, localblf.oTw, params);
              Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { n.this.chatroomName });
              AppMethodBeat.o(194027);
              return;
              i = 25;
              break;
              if (!localLinkedList2.isEmpty()) {
                break label184;
              }
              Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { n.this.chatroomName });
            }
            long l1 = System.currentTimeMillis();
            long l2 = com.tencent.mm.kernel.g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
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
            com.tencent.mm.kernel.g.aAh().hqK.endTransaction(l2);
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { n.this.chatroomName, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(localLinkedList2.size()) });
          } while (localLinkedList2.isEmpty());
          com.tencent.f.h.RTc.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(194027);
        }
      };
      com.tencent.f.h.RTc.a(paramArrayOfByte, 100L, "chatroom_member_detail");
    }
    if (!localLinkedList1.isEmpty())
    {
      this.gsh |= 0x2;
      paramArrayOfByte = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194028);
          int i;
          if (localLinkedList1.size() < 25)
          {
            i = localLinkedList1.size();
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg list size:%d, loopCount:%d", new Object[] { n.this.chatroomName, Integer.valueOf(localLinkedList1.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label150;
            }
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done loopCount is 0", new Object[] { n.this.chatroomName });
          }
          label150:
          do
          {
            n.a(n.this, 2, n.this.chatroomName, localblf.oTw, params);
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done updateList is empty", new Object[] { n.this.chatroomName });
            AppMethodBeat.o(194028);
            return;
            i = 25;
            break;
            long l1 = System.currentTimeMillis();
            long l2 = com.tencent.mm.kernel.g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
            int j = 0;
            while (j < i)
            {
              Pair localPair = (Pair)localLinkedList1.poll();
              localbv.c((String)localPair.first, (as)localPair.second);
              j += 1;
            }
            com.tencent.mm.kernel.g.aAh().hqK.endTransaction(l2);
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { n.this.chatroomName, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(localLinkedList1.size()) });
          } while (localLinkedList1.isEmpty());
          com.tencent.f.h.RTc.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(194028);
        }
      };
      com.tencent.f.h.RTc.a(paramArrayOfByte, 100L, "chatroom_member_detail");
    }
    if ((localLinkedList2.isEmpty()) && (localLinkedList1.isEmpty()))
    {
      a(localah, localblf.oTw, params);
      ((c)com.tencent.mm.kernel.g.af(c.class)).aSX().replace(localah);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.n
 * JD-Core Version:    0.7.0.1
 */