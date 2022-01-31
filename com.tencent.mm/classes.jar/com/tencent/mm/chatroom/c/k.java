package com.tencent.mm.chatroom.c;

import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
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
  private f callback;
  private final String chatroomName;
  private int eey;
  private int eez;
  private final b rr;
  
  public k(String paramString, int paramInt)
  {
    AppMethodBeat.i(103933);
    this.callback = null;
    this.eey = 0;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aiv();
    ((b.a)localObject).fsY = new aiw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
    ((b.a)localObject).funcId = 551;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    this.chatroomName = paramString;
    int j = ((c)g.E(c.class)).YJ().oV(paramString).dwo();
    ((aiv)this.rr.fsV.fta).xaB = paramString;
    localObject = (aiv)this.rr.fsV.fta;
    if (j < paramInt) {}
    for (int i = paramInt;; i = j)
    {
      ((aiv)localObject).wur = i;
      ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j), bo.dtY() });
      AppMethodBeat.o(103933);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103934);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103934);
    return i;
  }
  
  public final int getType()
  {
    return 551;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103935);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103935);
      return;
    }
    ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (aiw)this.rr.fsW.fta;
    paramArrayOfByte = ((c)g.E(c.class)).YJ().oV(this.chatroomName);
    long l1 = paramArrayOfByte.dwo();
    long l2 = 0xFFFFFFFF & paramq.jJr;
    int i = paramq.jJr;
    if (paramq.xaC == null) {}
    for (paramInt1 = 0;; paramInt1 = paramq.xaC.eeF)
    {
      ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom svrVer:%d, modCnt:%d， localVer:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Long.valueOf(l1) });
      if (l1 < l2) {
        break;
      }
      ab.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103935);
      return;
    }
    paramArrayOfByte.Nq(paramq.jJr);
    label298:
    i locali;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    label392:
    Iterator localIterator;
    if (paramq.xaC == null)
    {
      paramq = null;
      if (paramq != null) {
        break label613;
      }
      paramInt1 = -1;
      ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      paramArrayOfByte.w(r.Zn(), paramq);
      ((c)g.E(c.class)).YJ().replace(paramArrayOfByte);
      paramArrayOfByte = ((j)g.E(j.class)).YA();
      locali = o.adg();
      localLinkedList1 = new LinkedList();
      localLinkedList2 = new LinkedList();
      if (paramq != null) {
        break label624;
      }
      paramInt1 = -1;
      ab.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
        break label635;
      }
      paramInt1 = 0;
      this.eez = paramInt1;
      localIterator = paramq.iterator();
    }
    for (;;)
    {
      label435:
      if (!localIterator.hasNext()) {
        break label764;
      }
      rd localrd = (rd)localIterator.next();
      if ((!bo.isNullOrNil(localrd.wJr)) && (!bo.isNullOrNil(localrd.jJA)))
      {
        paramq = locali.rj(localrd.jJA);
        if (paramq != null) {
          break label700;
        }
        paramq = new h();
        paramq.username = localrd.jJA;
        label515:
        paramq.fsl = localrd.wJq;
        paramq.fsk = localrd.wJr;
        paramq.dqB = 3;
        if (bo.isNullOrNil(localrd.wJq)) {
          break label717;
        }
      }
      label700:
      label717:
      for (boolean bool = true;; bool = false)
      {
        paramq.cM(bool);
        localLinkedList2.add(paramq);
        paramq = paramArrayOfByte.arw(localrd.jJA);
        if (paramq != null) {
          break label723;
        }
        ab.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
        break label435;
        paramq = paramq.xaC.wJm;
        break;
        label613:
        paramInt1 = paramq.size();
        break label298;
        label624:
        paramInt1 = paramq.size();
        break label392;
        label635:
        bool = WXHardCoderJNI.hcUpdateChatroomEnable;
        i = WXHardCoderJNI.hcUpdateChatroomDelay;
        int j = WXHardCoderJNI.hcUpdateChatroomCPU;
        int k = WXHardCoderJNI.hcUpdateChatroomIO;
        if (WXHardCoderJNI.hcUpdateChatroomThr) {}
        for (paramInt1 = g.RO().dtc();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
          break;
        }
        paramq.acY().equals(localrd.wJr);
        break label515;
      }
      label723:
      if (paramq.NV())
      {
        paramq.jp(localrd.jKG);
        localLinkedList1.add(new Pair(localrd.jJA, paramq));
      }
    }
    label764:
    ab.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
    if (!localLinkedList2.isEmpty())
    {
      this.eey |= 0x1;
      new ap(g.RO().oNc.getLooper(), new k.1(this, localLinkedList2, locali), true).ag(100L, 100L);
    }
    if (!localLinkedList1.isEmpty())
    {
      this.eey |= 0x2;
      new ap(g.RO().oNc.getLooper(), new k.2(this, localLinkedList1, paramArrayOfByte), true).ag(100L, 100L);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.k
 * JD-Core Version:    0.7.0.1
 */