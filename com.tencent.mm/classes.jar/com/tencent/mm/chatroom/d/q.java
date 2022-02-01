package com.tencent.mm.chatroom.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final String chatroomName;
  private int lyv;
  private int lyw;
  private final c rr;
  
  public q(String paramString, int paramInt)
  {
    AppMethodBeat.i(12478);
    this.callback = null;
    this.lyv = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new chg();
    ((c.a)localObject).otF = new chh();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
    ((c.a)localObject).funcId = 551;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.chatroomName = paramString;
    int j = ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK().Jv(paramString).iZi();
    ((chg)c.b.b(this.rr.otB)).aaqe = paramString;
    localObject = (chg)c.b.b(this.rr.otB);
    if (j < paramInt) {}
    for (int i = paramInt;; i = j)
    {
      ((chg)localObject).YMr = i;
      Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j), Util.getStack() });
      AppMethodBeat.o(12478);
      return;
    }
  }
  
  private static void a(aj paramaj, int paramInt, List<zh> paramList, djd paramdjd)
  {
    AppMethodBeat.i(241432);
    paramaj.a(paramdjd);
    paramaj.ayP(paramInt);
    if (aj.iZk())
    {
      Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "has get all inviteer info");
      paramaj.field_chatroomLocalVersion = 1L;
    }
    paramaj.P(z.bAM(), paramList);
    AppMethodBeat.o(241432);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(12479);
    this.callback = paramh;
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
    final chh localchh = (chh)c.c.b(this.rr.otC);
    aj localaj = ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK().Jv(this.chatroomName);
    long l1 = localaj.iZi();
    long l2 = localchh.vgK & 0xFFFFFFFF;
    params = this.chatroomName;
    int i = localchh.vgK;
    if (localchh.aaqf == null) {}
    for (paramInt1 = 0;; paramInt1 = localchh.aaqf.lyF)
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
    final djd localdjd;
    final bx localbx;
    final k localk;
    final LinkedList localLinkedList1;
    final LinkedList localLinkedList2;
    Iterator localIterator;
    if (localchh.aaqf == null)
    {
      params = null;
      if (params != null) {
        break label605;
      }
      paramInt1 = -1;
      Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      localdjd = new djd();
      if (localchh.aaqf != null)
      {
        localdjd.YGJ = localchh.aaqf.YGJ;
        localdjd.YGK = localchh.aaqf.YGK;
      }
      localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
      localk = com.tencent.mm.modelavatar.q.bFE();
      localLinkedList1 = new LinkedList();
      localLinkedList2 = new LinkedList();
      if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
        break label616;
      }
      paramInt1 = 0;
      this.lyw = paramInt1;
      localIterator = params.iterator();
    }
    for (;;)
    {
      label427:
      if (!localIterator.hasNext()) {
        break label862;
      }
      zh localzh = (zh)localIterator.next();
      if ((!Util.isNullOrNil(localzh.ZhP)) && (!Util.isNullOrNil(localzh.UserName)))
      {
        paramArrayOfByte = localk.LS(localzh.UserName);
        if (paramArrayOfByte != null) {
          break label681;
        }
        paramArrayOfByte = new j();
        paramArrayOfByte.username = localzh.UserName;
        label507:
        paramArrayOfByte.osN = localzh.ZhO;
        paramArrayOfByte.osM = localzh.ZhP;
        paramArrayOfByte.jZY = 3;
        if (Util.isNullOrNil(localzh.ZhO)) {
          break label698;
        }
      }
      label681:
      label698:
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte.gX(bool);
        localLinkedList2.add(paramArrayOfByte);
        paramArrayOfByte = localbx.JE(localzh.UserName);
        if (paramArrayOfByte != null) {
          break label704;
        }
        Log.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
        break label427;
        params = localchh.aaqf.ZhK;
        break;
        label605:
        paramInt1 = params.size();
        break label302;
        label616:
        bool = WXHardCoderJNI.hcUpdateChatroomEnable;
        i = WXHardCoderJNI.hcUpdateChatroomDelay;
        int j = WXHardCoderJNI.hcUpdateChatroomCPU;
        int k = WXHardCoderJNI.hcUpdateChatroomIO;
        if (WXHardCoderJNI.hcUpdateChatroomThr) {}
        for (paramInt1 = com.tencent.mm.kernel.h.baH().getProcessTid();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
          break;
        }
        paramArrayOfByte.bFx().equals(localzh.ZhP);
        break label507;
      }
      label704:
      if (paramArrayOfByte.aSE())
      {
        paramArrayOfByte.setNickname(localzh.vhX);
        localLinkedList1.add(new Pair(localzh.UserName, paramArrayOfByte));
        localbx.d(localzh.UserName, paramArrayOfByte);
        Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail username:%s nickname:%s type:%s", new Object[] { Util.nullAs(localzh.UserName, ""), Util.secPrint(localzh.vhX), Integer.valueOf(paramArrayOfByte.field_type) });
      }
      else
      {
        Log.w("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail isChatRoomContact == false, username %s nickname %s type:%s", new Object[] { Util.nullAs(localzh.UserName, ""), Util.nullAs(localzh.vhX, ""), Integer.valueOf(paramArrayOfByte.field_type) });
      }
    }
    label862:
    Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
    if (!localLinkedList2.isEmpty())
    {
      this.lyv |= 0x1;
      paramArrayOfByte = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(241427);
          int i;
          if (localLinkedList2.size() < 25)
          {
            i = localLinkedList2.size();
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img list size:%d, loopCount:%d", new Object[] { q.a(q.this), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label154;
            }
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done loopCount is 0", new Object[] { q.a(q.this) });
          }
          label154:
          label188:
          do
          {
            for (;;)
            {
              q.a(q.this, 1, q.a(q.this), localchh.vgK, params, localdjd);
              Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { q.a(q.this) });
              AppMethodBeat.o(241427);
              return;
              i = 25;
              break;
              if (!localLinkedList2.isEmpty()) {
                break label188;
              }
              Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img done newImgFlagList is empty", new Object[] { q.a(q.this) });
            }
            long l1 = System.currentTimeMillis();
            long l2 = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
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
            com.tencent.mm.kernel.h.baE().mCN.endTransaction(l2);
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update img loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { q.a(q.this), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(localLinkedList2.size()) });
          } while (localLinkedList2.isEmpty());
          com.tencent.threadpool.h.ahAA.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(241427);
        }
      };
      com.tencent.threadpool.h.ahAA.a(paramArrayOfByte, 100L, "chatroom_member_detail");
    }
    if (!localLinkedList1.isEmpty())
    {
      this.lyv |= 0x2;
      paramArrayOfByte = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(241420);
          int i;
          if (localLinkedList1.size() < 25)
          {
            i = localLinkedList1.size();
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg list size:%d, loopCount:%d", new Object[] { q.a(q.this), Integer.valueOf(localLinkedList1.size()), Integer.valueOf(i) });
            if (i != 0) {
              break label154;
            }
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done loopCount is 0", new Object[] { q.a(q.this) });
          }
          label154:
          do
          {
            q.a(q.this, 2, q.a(q.this), localchh.vgK, params, localdjd);
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg done updateList is empty", new Object[] { q.a(q.this) });
            AppMethodBeat.o(241420);
            return;
            i = 25;
            break;
            long l1 = System.currentTimeMillis();
            long l2 = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
            int j = 0;
            while (j < i)
            {
              Pair localPair = (Pair)localLinkedList1.poll();
              localbx.d((String)localPair.first, (au)localPair.second);
              j += 1;
            }
            com.tencent.mm.kernel.h.baE().mCN.endTransaction(l2);
            Log.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom(%s) update ctg loopCount:%d, take time:%d(ms), img list size:%d", new Object[] { q.a(q.this), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(localLinkedList1.size()) });
          } while (localLinkedList1.isEmpty());
          com.tencent.threadpool.h.ahAA.a(this, 100L, "chatroom_member_detail");
          AppMethodBeat.o(241420);
        }
      };
      com.tencent.threadpool.h.ahAA.a(paramArrayOfByte, 100L, "chatroom_member_detail");
    }
    if ((localLinkedList2.isEmpty()) && (localLinkedList1.isEmpty()))
    {
      a(localaj, localchh.vgK, params, localdjd);
      ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK().replace(localaj);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.q
 * JD-Core Version:    0.7.0.1
 */