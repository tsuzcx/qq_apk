package com.tencent.mm.aq;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.notification.d;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  implements w.a
{
  private static d fCA;
  private static b fCC;
  private b.b fCB;
  public b.a fCx;
  private m fCy;
  private ap fCz;
  
  static
  {
    AppMethodBeat.i(16455);
    fCA = new d(true);
    AppMethodBeat.o(16455);
  }
  
  private b()
  {
    AppMethodBeat.i(16446);
    this.fCz = new ap(aw.RO().oNc.getLooper(), new b.1(this), false);
    this.fCB = new b.2(this);
    AppMethodBeat.o(16446);
  }
  
  private static LinkedList<e.a> a(List<cm> paramList, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(16451);
    long l4 = ((j)g.E(j.class)).Zc().Tb(paramString);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    long l2 = 0L;
    if (localIterator.hasNext())
    {
      paramList = (cm)localIterator.next();
      long l3 = paramList.CreateTime * 1000L;
      long l1 = l3;
      if (l2 == 0L)
      {
        bi localbi = ((j)g.E(j.class)).bPQ().ao(aa.a(paramList.woP), paramList.woW);
        l1 = l3;
        if (localbi.field_createTime / 1000L == paramList.CreateTime) {
          l1 = localbi.field_createTime + 1L;
        }
      }
      if (l2 / 1000L == l1 / 1000L)
      {
        l1 = 1L + l2;
        paramList = new e.a(paramList, paramBoolean, l1);
        label181:
        if (l4 >= l1) {
          break label215;
        }
        localLinkedList.add(paramList);
      }
      for (;;)
      {
        l2 = l1;
        break;
        paramList = new e.a(paramList, paramBoolean, l1);
        break label181;
        label215:
        ab.w("MicroMsg.GetChatroomMsgFetcher", "this conversation[%s] has delete before! lastDeleteCreateTime:%s curTime:%s", new Object[] { paramString, Long.valueOf(l4), Long.valueOf(l1) });
      }
    }
    AppMethodBeat.o(16451);
    return localLinkedList;
  }
  
  private void a(com.tencent.mm.ai.b paramb, int paramInt, LinkedList<bi> paramLinkedList)
  {
    AppMethodBeat.i(16450);
    ab.w("MicroMsg.GetChatroomMsgFetcher", "[requestCallback] ret:".concat(String.valueOf(paramInt)));
    if (paramb == null)
    {
      paramb = com.tencent.mm.ui.chatting.j.b.zPL;
      com.tencent.mm.ui.chatting.j.b.dLd();
      if (this.fCB != null) {
        this.fCB.b(paramInt, paramLinkedList);
      }
      AppMethodBeat.o(16450);
      return;
    }
    air localair = (air)paramb.fsV.fta;
    paramb = (ais)paramb.fsW.fta;
    boolean bool1;
    if ((this.fCx != null) && (paramInt >= 0))
    {
      b.a locala = this.fCx;
      String str = aa.a(localair.xap);
      if (localair.xar == 1)
      {
        bool1 = true;
        com.tencent.mm.j.a.a.c localc = y(localair.xat, localair.woW);
        if (paramb.wBX != 0) {
          break label244;
        }
        bool2 = true;
        label145:
        locala.a(str, bool1, paramLinkedList, localc, bool2);
      }
    }
    else
    {
      if (this.fCB != null) {
        this.fCB.b(paramInt, paramLinkedList);
      }
      paramb = com.tencent.mm.ui.chatting.j.b.zPL;
      if (localair.xar != 0) {
        break label250;
      }
      bool1 = true;
      label194:
      if (paramInt < 0) {
        break label256;
      }
    }
    label256:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramb.c(bool1, bool2, aa.a(localair.xap));
      if (paramInt >= 0) {
        com.tencent.mm.ui.chatting.j.b.zPL.Qo(paramLinkedList.size());
      }
      AppMethodBeat.o(16450);
      return;
      bool1 = false;
      break;
      label244:
      bool2 = false;
      break label145;
      label250:
      bool1 = false;
      break label194;
    }
  }
  
  public static b agX()
  {
    AppMethodBeat.i(16447);
    if (fCC == null) {}
    try
    {
      if (fCC == null) {
        fCC = new b();
      }
      b localb = fCC;
      AppMethodBeat.o(16447);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(16447);
    }
  }
  
  public static void sS(String paramString)
  {
    AppMethodBeat.i(16453);
    if (((j)g.E(j.class)).bPL().SW(paramString))
    {
      ab.i("MicroMsg.GetChatroomMsgFetcher", "[clearConversationDeliverCount] username:%s", new Object[] { paramString });
      air localair = new air();
      localair.xap = aa.wA(paramString);
      localair.woW = 0;
      localair.xat = 0;
      localair.xaq = 0;
      localair.xar = 0;
      paramString = new com.tencent.mm.ai.b.a();
      paramString.fsX = localair;
      paramString.fsY = new ais();
      paramString.uri = "/cgi-bin/micromsg-bin/getcrmsg";
      paramString.funcId = 805;
      paramString.reqCmdId = 0;
      paramString.respCmdId = 0;
      w.b(paramString.ado());
    }
    AppMethodBeat.o(16453);
  }
  
  private static com.tencent.mm.j.a.a.c y(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(16452);
    if (paramLong1 > paramLong2) {}
    for (;;)
    {
      com.tencent.mm.j.a.a.c localc = new com.tencent.mm.j.a.a.c();
      localc.elA = paramLong2;
      localc.elB = paramLong1;
      AppMethodBeat.o(16452);
      return localc;
      long l = paramLong1;
      paramLong1 = paramLong2;
      paramLong2 = l;
    }
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(16449);
    ab.i("MicroMsg.GetChatroomMsgFetcher", "[callback] errType:%d errCode:%d errMsg:%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = new LinkedList();
    if (paramm.getType() != 805)
    {
      a(paramb, -1, paramString);
      AppMethodBeat.o(16449);
      return 0;
    }
    this.fCz.stopTimer();
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb == null))
    {
      a(paramb, -1, paramString);
      AppMethodBeat.o(16449);
      return 0;
    }
    Object localObject1 = (air)paramb.fsV.fta;
    paramm = (ais)paramb.fsW.fta;
    boolean bool1;
    if ((paramm == null) || (paramm.xau == null))
    {
      a(paramb, -1, paramString);
      if (paramm == null)
      {
        bool1 = true;
        if (paramm.xau != null) {
          break label215;
        }
      }
      label215:
      for (boolean bool2 = true;; bool2 = false)
      {
        ab.e("MicroMsg.GetChatroomMsgFetcher", "[callback] resp == null? %b resp.AddMsgList == null? %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(16449);
        return 0;
        bool1 = false;
        break;
      }
    }
    if (paramm.xau.size() <= 0)
    {
      ab.w("MicroMsg.GetChatroomMsgFetcher", "[callback] fetch size is 0! [%s:%s] isUpFlag:%s ChatroomId:%s", new Object[] { Integer.valueOf(((air)localObject1).woW), Integer.valueOf(((air)localObject1).xat), Integer.valueOf(((air)localObject1).xar), aa.a(((air)localObject1).xap) });
      a(paramb, 0, paramString);
      AppMethodBeat.o(16449);
      return 0;
    }
    e.a locala;
    for (;;)
    {
      try
      {
        i locali = (i)g.E(i.class);
        ((j)g.E(j.class)).bPQ().Th("MicroMsg.GetChatroomMsgFetcher" + hashCode());
        Object localObject3 = paramm.xau;
        if (((air)localObject1).xar == 1)
        {
          bool1 = true;
          localObject3 = a((List)localObject3, bool1, aa.a(((air)localObject1).xap)).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label825;
          }
          locala = (e.a)((Iterator)localObject3).next();
          localObject4 = locali.a(locala, fCA);
          if (localObject4 == null) {
            break;
          }
          if (((e.b)localObject4).cmQ != null) {
            break label563;
          }
          ab.e("MicroMsg.GetChatroomMsgFetcher", "ddMsgReturn.msg == null！may be revoke msg");
          continue;
        }
        bool1 = false;
      }
      finally
      {
        ((j)g.E(j.class)).bPQ().Ti("MicroMsg.GetChatroomMsgFetcher" + hashCode());
        localObject1 = aa.a(((air)localObject1).xap);
        ab.i("MicroMsg.GetChatroomMsgFetcher", "[callback] chatroomId:" + (String)localObject1 + " AddMsgList size:" + paramm.xau.size());
        a(paramb, 0, paramString);
        AppMethodBeat.o(16449);
      }
      continue;
      label563:
      paramString.add(((e.b)localObject4).cmQ);
    }
    Object localObject4 = locala.eyJ;
    bi localbi = new bi();
    localbi.fP(((cm)localObject4).pIG);
    localbi.fQ(locala.fth);
    localbi.fS(((cm)localObject4).woW);
    String str1 = aa.a(((cm)localObject4).woP);
    String str2 = aa.a(((cm)localObject4).woQ);
    k localk = ((j)g.E(j.class)).YI();
    String str3 = (String)g.RL().Ru().get(2, "");
    if (!localk.has(str1)) {
      if (!str3.equals(str1)) {
        break label933;
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        localbi.hL(1);
        localbi.kj(str2);
        paramInt1 = ((cm)localObject4).jJS;
      }
      for (;;)
      {
        localbi.setStatus(paramInt1);
        if (((cm)localObject4).nqW == 10000) {
          localbi.setStatus(4);
        }
        localbi.hV(2);
        paramString.add(localbi);
        ab.i("MicroMsg.GetChatroomMsgFetcher", "addMsgReturn == null! addMsgInfo addMsg type:%s", new Object[] { Integer.valueOf(locala.eyJ.nqW) });
        break;
        localbi.hL(0);
        localbi.kj(str1);
        if (((cm)localObject4).jJS > 3) {
          paramInt1 = ((cm)localObject4).jJS;
        } else {
          paramInt1 = 3;
        }
      }
      label825:
      ((j)g.E(j.class)).bPQ().Ti("MicroMsg.GetChatroomMsgFetcher" + hashCode());
      localObject1 = aa.a(((air)localObject1).xap);
      ab.i("MicroMsg.GetChatroomMsgFetcher", "[callback] chatroomId:" + (String)localObject1 + " AddMsgList size:" + paramm.xau.size());
      a(paramb, 0, paramString);
      AppMethodBeat.o(16449);
      return 0;
      paramInt1 = 1;
      continue;
      label933:
      paramInt1 = 0;
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, int paramInt, b.b paramb)
  {
    AppMethodBeat.i(16448);
    ab.i("MicroMsg.GetChatroomMsgFetcher", "[fetch] chatroomId:" + paramString + " msgSeq:" + paramLong1 + " filterSeq:" + paramLong2 + " upDownFlag:" + paramInt);
    this.fCB = paramb;
    paramb = new air();
    paramb.xap = aa.wA(paramString);
    paramb.woW = ((int)paramLong1);
    paramb.xat = ((int)paramLong2);
    paramb.xaq = 18;
    paramb.xar = paramInt;
    paramString = new com.tencent.mm.ai.b.a();
    paramString.fsX = paramb;
    paramString.fsY = new ais();
    paramString.uri = "/cgi-bin/micromsg-bin/getcrmsg";
    paramString.funcId = 805;
    paramString.reqCmdId = 0;
    paramString.respCmdId = 0;
    if (this.fCy != null) {
      w.a(this.fCy);
    }
    this.fCy = w.a(paramString.ado(), this, true);
    this.fCz.stopTimer();
    this.fCz.ag(8000L, 8000L);
    AppMethodBeat.o(16448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aq.b
 * JD-Core Version:    0.7.0.1
 */