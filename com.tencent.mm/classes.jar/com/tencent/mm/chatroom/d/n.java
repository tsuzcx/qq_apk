package com.tencent.mm.chatroom.d;

import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.protocal.protobuf.tr;
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

public final class n
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private final String chatroomName;
  private int foU;
  private int foV;
  private final b rr;
  
  public n(String paramString, int paramInt)
  {
    AppMethodBeat.i(12478);
    this.callback = null;
    this.foU = 0;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new asc();
    ((b.a)localObject).gUV = new asd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
    ((b.a)localObject).funcId = 551;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    this.chatroomName = paramString;
    int j = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tI(paramString).eKo();
    ((asc)this.rr.gUS.gUX).Dss = paramString;
    localObject = (asc)this.rr.gUS.gUX;
    if (j < paramInt) {}
    for (int i = paramInt;; i = j)
    {
      ((asc)localObject).CEj = i;
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j), bt.eGN() });
      AppMethodBeat.o(12478);
      return;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
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
    paramq = (asd)this.rr.gUT.gUX;
    paramArrayOfByte = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tI(this.chatroomName);
    long l1 = paramArrayOfByte.eKo();
    long l2 = 0xFFFFFFFF & paramq.mAH;
    int i = paramq.mAH;
    if (paramq.Dst == null) {}
    for (paramInt1 = 0;; paramInt1 = paramq.Dst.fpb)
    {
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom svrVer:%d, modCnt:%d， localVer:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Long.valueOf(l1) });
      if (l1 < l2) {
        break;
      }
      ad.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12480);
      return;
    }
    paramArrayOfByte.Wu(paramq.mAH);
    label301:
    j localj;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    label395:
    Iterator localIterator;
    if (paramq.Dst == null)
    {
      paramq = null;
      if (paramq != null) {
        break label616;
      }
      paramInt1 = -1;
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      paramArrayOfByte.C(u.aqG(), paramq);
      ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().replace(paramArrayOfByte);
      paramArrayOfByte = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM();
      localj = p.auF();
      localLinkedList1 = new LinkedList();
      localLinkedList2 = new LinkedList();
      if (paramq != null) {
        break label627;
      }
      paramInt1 = -1;
      ad.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 <= WXHardCoderJNI.hcUpdateChatroomMemberCount) {
        break label638;
      }
      paramInt1 = 0;
      this.foV = paramInt1;
      localIterator = paramq.iterator();
    }
    for (;;)
    {
      label438:
      if (!localIterator.hasNext()) {
        break label767;
      }
      tr localtr = (tr)localIterator.next();
      if ((!bt.isNullOrNil(localtr.CVw)) && (!bt.isNullOrNil(localtr.mAQ)))
      {
        paramq = localj.we(localtr.mAQ);
        if (paramq != null) {
          break label703;
        }
        paramq = new i();
        paramq.username = localtr.mAQ;
        label518:
        paramq.gUg = localtr.CVv;
        paramq.gUf = localtr.CVw;
        paramq.evo = 3;
        if (bt.isNullOrNil(localtr.CVv)) {
          break label720;
        }
      }
      label703:
      label720:
      for (boolean bool = true;; bool = false)
      {
        paramq.ee(bool);
        localLinkedList2.add(paramq);
        paramq = paramArrayOfByte.aHY(localtr.mAQ);
        if (paramq != null) {
          break label726;
        }
        ad.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
        break label438;
        paramq = paramq.Dst.CVr;
        break;
        label616:
        paramInt1 = paramq.size();
        break label301;
        label627:
        paramInt1 = paramq.size();
        break label395;
        label638:
        bool = WXHardCoderJNI.hcUpdateChatroomEnable;
        i = WXHardCoderJNI.hcUpdateChatroomDelay;
        int j = WXHardCoderJNI.hcUpdateChatroomCPU;
        int k = WXHardCoderJNI.hcUpdateChatroomIO;
        if (WXHardCoderJNI.hcUpdateChatroomThr) {}
        for (paramInt1 = com.tencent.mm.kernel.g.afE().eFQ();; paramInt1 = 0)
        {
          paramInt1 = WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt1, WXHardCoderJNI.hcUpdateChatroomTimeout, 401, WXHardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
          break;
        }
        paramq.auy().equals(localtr.CVw);
        break label518;
      }
      label726:
      if (paramq.ZL())
      {
        paramq.nd(localtr.mBV);
        localLinkedList1.add(new Pair(localtr.mAQ, paramq));
      }
    }
    label767:
    ad.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[] { Integer.valueOf(localLinkedList2.size()), Integer.valueOf(localLinkedList1.size()) });
    if (!localLinkedList2.isEmpty())
    {
      this.foU |= 0x1;
      new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new n.1(this, localLinkedList2, localj), true).av(100L, 100L);
    }
    if (!localLinkedList1.isEmpty())
    {
      this.foU |= 0x2;
      new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new n.2(this, localLinkedList1, paramArrayOfByte), true).av(100L, 100L);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.n
 * JD-Core Version:    0.7.0.1
 */