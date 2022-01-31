package com.tencent.mm.chatroom.c;

import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.aeb;
import com.tencent.mm.protocal.c.aec;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.c.ob;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private final String chatroomName;
  private final b dmK;
  private f dmL = null;
  private int dmX = 0;
  private int dmY;
  
  public k(String paramString, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aeb();
    ((b.a)localObject).ecI = new aec();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
    ((b.a)localObject).ecG = 551;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    this.chatroomName = paramString;
    int j = ((c)g.r(c.class)).FF().io(paramString).ctN();
    ((aeb)this.dmK.ecE.ecN).tci = paramString;
    localObject = (aeb)this.dmK.ecE.ecN;
    if (j < paramInt) {}
    for (int i = paramInt;; i = j)
    {
      ((aeb)localObject).sAl = i;
      y.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j), bk.csb() });
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (aec)this.dmK.ecF.ecN;
    paramArrayOfByte = ((c)g.r(c.class)).FF().io(this.chatroomName);
    long l1 = paramArrayOfByte.ctN();
    long l2 = 0xFFFFFFFF & paramq.hPP;
    int i = paramq.hPP;
    if (paramq.tcj == null) {}
    for (paramInt1 = 0;; paramInt1 = paramq.tcj.dne)
    {
      y.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom svrVer:%d, modCnt:%d， localVer:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Long.valueOf(l1) });
      if (l1 < l2) {
        break;
      }
      y.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramArrayOfByte.Fk(paramq.hPP);
    u.ctP();
    label287:
    i locali;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    label381:
    Iterator localIterator;
    if (paramq.tcj == null)
    {
      paramq = null;
      if (paramq != null) {
        break label602;
      }
      paramInt1 = -1;
      y.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      paramArrayOfByte.t(com.tencent.mm.model.q.Gj(), paramq);
      ((c)g.r(c.class)).FF().a(paramArrayOfByte);
      paramArrayOfByte = ((j)g.r(j.class)).Fw();
      locali = o.Kh();
      localLinkedList1 = new LinkedList();
      localLinkedList2 = new LinkedList();
      if (paramq != null) {
        break label613;
      }
      paramInt1 = -1;
      y.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
        break label624;
      }
      paramInt1 = 0;
      this.dmY = paramInt1;
      localIterator = paramq.iterator();
    }
    for (;;)
    {
      label424:
      if (!localIterator.hasNext()) {
        break label753;
      }
      ob localob = (ob)localIterator.next();
      if ((!bk.bl(localob.sLE)) && (!bk.bl(localob.hPY)))
      {
        paramq = locali.kp(localob.hPY);
        if (paramq != null) {
          break label689;
        }
        paramq = new h();
        paramq.username = localob.hPY;
        label504:
        paramq.ebT = localob.sLD;
        paramq.ebS = localob.sLE;
        paramq.cCq = 3;
        if (bk.bl(localob.sLD)) {
          break label706;
        }
      }
      label689:
      label706:
      for (boolean bool = true;; bool = false)
      {
        paramq.bK(bool);
        localLinkedList2.add(paramq);
        paramq = paramArrayOfByte.abl(localob.hPY);
        if (paramq != null) {
          break label712;
        }
        y.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
        break label424;
        paramq = paramq.tcj.sLz;
        break;
        label602:
        paramInt1 = paramq.size();
        break label287;
        label613:
        paramInt1 = paramq.size();
        break label381;
        label624:
        bool = WXHardCoderJNI.hcUpdateChatroomEnable;
        i = WXHardCoderJNI.hcUpdateChatroomDelay;
        int j = WXHardCoderJNI.hcUpdateChatroomCPU;
        int k = WXHardCoderJNI.hcUpdateChatroomIO;
        if (WXHardCoderJNI.hcUpdateChatroomThr) {}
        for (paramInt1 = g.DS().crd();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
          break;
        }
        paramq.JY().equals(localob.sLE);
        break label504;
      }
      label712:
      if (paramq.Bf())
      {
        paramq.dk(localob.hRf);
        localLinkedList1.add(new Pair(localob.hPY, paramq));
      }
    }
    label753:
    y.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
    if (!localLinkedList2.isEmpty())
    {
      this.dmX |= 0x1;
      new am(g.DS().mnU.getLooper(), new k.1(this, localLinkedList2, locali), true).S(100L, 100L);
    }
    if (!localLinkedList1.isEmpty())
    {
      this.dmX |= 0x2;
      new am(g.DS().mnU.getLooper(), new k.2(this, localLinkedList1, paramArrayOfByte), true).S(100L, 100L);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 551;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.k
 * JD-Core Version:    0.7.0.1
 */