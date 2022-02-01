package com.tencent.mm.chatroom.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.protocal.protobuf.xn;
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
  extends com.tencent.mm.an.q
  implements m
{
  private com.tencent.mm.an.i callback;
  private final String chatroomName;
  private int iWs;
  private int iWt;
  private final d rr;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(12478);
    this.callback = null;
    this.iWs = 0;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bsn();
    ((d.a)localObject).lBV = new bso();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
    ((d.a)localObject).funcId = 551;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    this.chatroomName = paramString;
    int j = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rx(paramString).hxE();
    ((bsn)d.b.b(this.rr.lBR)).TcP = paramString;
    localObject = (bsn)d.b.b(this.rr.lBR);
    if (j < paramInt) {}
    for (int i = paramInt;; i = j)
    {
      ((bsn)localObject).RPe = i;
      Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j), Util.getStack() });
      AppMethodBeat.o(12478);
      return;
    }
  }
  
  private static void a(ah paramah, int paramInt, List<xn> paramList)
  {
    AppMethodBeat.i(193514);
    paramah.asA(paramInt);
    paramah.H(z.bcZ(), paramList);
    AppMethodBeat.o(193514);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
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
    final bso localbso = (bso)d.c.b(this.rr.lBS);
    ah localah = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rx(this.chatroomName);
    long l1 = localah.hxE();
    long l2 = localbso.rVu & 0xFFFFFFFF;
    params = this.chatroomName;
    int i = localbso.rVu;
    if (localbso.TcQ == null) {}
    for (paramInt1 = 0;; paramInt1 = localbso.TcQ.iWB)
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
    final k localk;
    final LinkedList localLinkedList1;
    final LinkedList localLinkedList2;
    Iterator localIterator;
    if (localbso.TcQ == null)
    {
      params = null;
      if (params != null) {
        break label561;
      }
      paramInt1 = -1;
      Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      localbv = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL();
      localk = com.tencent.mm.am.q.bhP();
      localLinkedList1 = new LinkedList();
      localLinkedList2 = new LinkedList();
      if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
        break label572;
      }
      paramInt1 = 0;
      this.iWt = paramInt1;
      localIterator = params.iterator();
    }
    for (;;)
    {
      label383:
      if (!localIterator.hasNext()) {
        break label803;
      }
      xn localxn = (xn)localIterator.next();
      if ((!Util.isNullOrNil(localxn.SjJ)) && (!Util.isNullOrNil(localxn.UserName)))
      {
        paramArrayOfByte = localk.TS(localxn.UserName);
        if (paramArrayOfByte != null) {
          break label637;
        }
        paramArrayOfByte = new j();
        paramArrayOfByte.username = localxn.UserName;
        label463:
        paramArrayOfByte.lBe = localxn.SjI;
        paramArrayOfByte.lBd = localxn.SjJ;
        paramArrayOfByte.hDc = 3;
        if (Util.isNullOrNil(localxn.SjI)) {
          break label654;
        }
      }
      label654:
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte.gg(bool);
        localLinkedList2.add(paramArrayOfByte);
        paramArrayOfByte = localbv.RG(localxn.UserName);
        if (paramArrayOfByte != null) {
          break label660;
        }
        Log.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
        break label383;
        params = localbso.TcQ.SjE;
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
        for (paramInt1 = com.tencent.mm.kernel.h.aHJ().getProcessTid();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
          break;
        }
        label637:
        paramArrayOfByte.bhI().equals(localxn.SjJ);
        break label463;
      }
      label660:
      if (paramArrayOfByte.ayb())
      {
        paramArrayOfByte.setNickname(localxn.rWI);
        localLinkedList1.add(new Pair(localxn.UserName, paramArrayOfByte));
        Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail username:%s nickname:%s type:%s", new Object[] { Util.nullAs(localxn.UserName, ""), Util.secPrint(localxn.rWI), Integer.valueOf(paramArrayOfByte.field_type) });
      }
      else
      {
        Log.w("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail isChatRoomContact == false, username %s nickname %s type:%s", new Object[] { Util.nullAs(localxn.UserName, ""), Util.nullAs(localxn.rWI, ""), Integer.valueOf(paramArrayOfByte.field_type) });
      }
    }
    label803:
    Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
    if (!localLinkedList2.isEmpty())
    {
      this.iWs |= 0x1;
      paramArrayOfByte = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191130);
          int i;
          if (localLinkedList2.size() < 25)
          {
            i = localLinkedList2.size();
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img list size:%d, loopCount:%d", new Object[] { n.a(n.this), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label150;
            }
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done loopCount is 0", new Object[] { n.a(n.this) });
          }
          label150:
          label184:
          do
          {
            for (;;)
            {
              n.a(n.this, 1, n.a(n.this), localbso.rVu, params);
              Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { n.a(n.this) });
              AppMethodBeat.o(191130);
              return;
              i = 25;
              break;
              if (!localLinkedList2.isEmpty()) {
                break label184;
              }
              Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { n.a(n.this) });
            }
            long l1 = System.currentTimeMillis();
            long l2 = com.tencent.mm.kernel.h.aHG().kcF.beginTransaction(Thread.currentThread().getId());
            int j = 0;
            while (j < i)
            {
              j localj = (j)localLinkedList2.poll();
              if (localj == null) {
                break;
              }
              localk.b(localj);
              j += 1;
            }
            com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l2);
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { n.a(n.this), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(localLinkedList2.size()) });
          } while (localLinkedList2.isEmpty());
          com.tencent.e.h.ZvG.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(191130);
        }
      };
      com.tencent.e.h.ZvG.a(paramArrayOfByte, 100L, "chatroom_member_detail");
    }
    if (!localLinkedList1.isEmpty())
    {
      this.iWs |= 0x2;
      paramArrayOfByte = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188142);
          int i;
          if (localLinkedList1.size() < 25)
          {
            i = localLinkedList1.size();
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg list size:%d, loopCount:%d", new Object[] { n.a(n.this), Integer.valueOf(localLinkedList1.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label150;
            }
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done loopCount is 0", new Object[] { n.a(n.this) });
          }
          label150:
          do
          {
            n.a(n.this, 2, n.a(n.this), localbso.rVu, params);
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done updateList is empty", new Object[] { n.a(n.this) });
            AppMethodBeat.o(188142);
            return;
            i = 25;
            break;
            long l1 = System.currentTimeMillis();
            long l2 = com.tencent.mm.kernel.h.aHG().kcF.beginTransaction(Thread.currentThread().getId());
            int j = 0;
            while (j < i)
            {
              Pair localPair = (Pair)localLinkedList1.poll();
              localbv.c((String)localPair.first, (as)localPair.second);
              j += 1;
            }
            com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l2);
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { n.a(n.this), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(localLinkedList1.size()) });
          } while (localLinkedList1.isEmpty());
          com.tencent.e.h.ZvG.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(188142);
        }
      };
      com.tencent.e.h.ZvG.a(paramArrayOfByte, 100L, "chatroom_member_detail");
    }
    if ((localLinkedList2.isEmpty()) && (localLinkedList1.isEmpty()))
    {
      a(localah, localbso.rVu, params);
      ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().replace(localah);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.n
 * JD-Core Version:    0.7.0.1
 */