package com.tencent.mm.ap;

import android.os.HandlerThread;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.adx;
import com.tencent.mm.protocal.c.ady;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  implements w.a
{
  private static com.tencent.mm.plugin.messenger.foundation.g emd = new com.tencent.mm.plugin.messenger.foundation.g(true);
  private static b emf;
  public b.a emb;
  private am emc = new am(au.DS().mnU.getLooper(), new am.a()
  {
    public final boolean tC()
    {
      y.i("MicroMsg.GetChatroomMsgFetcher", "timeoutHandler onTimerExpired");
      b.a(b.this, new LinkedList());
      return false;
    }
  }, false);
  private b.b eme = new b.b()
  {
    public final void b(int paramAnonymousInt, List<bi> paramAnonymousList)
    {
      y.w("MicroMsg.GetChatroomMsgFetcher", "[onFinish] ret:" + paramAnonymousInt + " addSize:" + paramAnonymousList.size());
    }
  };
  
  public static b Oi()
  {
    if (emf == null) {}
    try
    {
      if (emf == null) {
        emf = new b();
      }
      return emf;
    }
    finally {}
  }
  
  private static LinkedList<e.a> a(List<cd> paramList, boolean paramBoolean, String paramString)
  {
    long l4 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Gb().Hp(paramString);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    long l2 = 0L;
    if (localIterator.hasNext())
    {
      paramList = (cd)localIterator.next();
      long l3 = paramList.mPL * 1000L;
      long l1 = l3;
      if (l2 == 0L)
      {
        bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().W(aa.a(paramList.svF), paramList.svM);
        l1 = l3;
        if (localbi.field_createTime / 1000L == paramList.mPL) {
          l1 = localbi.field_createTime + 1L;
        }
      }
      if (l2 / 1000L == l1 / 1000L)
      {
        l1 = 1L + l2;
        paramList = new e.a(paramList, paramBoolean, l1);
        label175:
        if (l4 >= l1) {
          break label209;
        }
        localLinkedList.add(paramList);
      }
      for (;;)
      {
        l2 = l1;
        break;
        paramList = new e.a(paramList, paramBoolean, l1);
        break label175;
        label209:
        y.w("MicroMsg.GetChatroomMsgFetcher", "this conversation[%s] has delete before! lastDeleteCreateTime:%s curTime:%s", new Object[] { paramString, Long.valueOf(l4), Long.valueOf(l1) });
      }
    }
    return localLinkedList;
  }
  
  private void a(com.tencent.mm.ah.b paramb, int paramInt, LinkedList<bi> paramLinkedList)
  {
    y.w("MicroMsg.GetChatroomMsgFetcher", "[requestCallback] ret:" + paramInt);
    if (paramb == null)
    {
      paramb = com.tencent.mm.ui.chatting.i.b.vzo;
      com.tencent.mm.ui.chatting.i.b.cGR();
      if (this.eme != null) {
        this.eme.b(paramInt, paramLinkedList);
      }
      return;
    }
    Object localObject = (adx)paramb.ecE.ecN;
    paramb = (ady)paramb.ecF.ecN;
    b.a locala;
    String str;
    boolean bool1;
    long l1;
    long l2;
    if ((this.emb != null) && (paramInt >= 0))
    {
      locala = this.emb;
      str = aa.a(((adx)localObject).tbW);
      if (((adx)localObject).tbY != 1) {
        break label344;
      }
      bool1 = true;
      l1 = ((adx)localObject).tca;
      l2 = ((adx)localObject).svM;
      if (l1 <= l2) {
        break label394;
      }
    }
    for (;;)
    {
      com.tencent.mm.k.a.a.c localc = new com.tencent.mm.k.a.a.c();
      localc.dtN = l2;
      localc.dtO = l1;
      boolean bool2;
      if (paramb.sFD == 0)
      {
        bool2 = true;
        label170:
        locala.a(str, bool1, paramLinkedList, localc, bool2);
        if (this.eme != null) {
          this.eme.b(paramInt, paramLinkedList);
        }
        paramb = com.tencent.mm.ui.chatting.i.b.vzo;
        if (((adx)localObject).tbY != 0) {
          break label356;
        }
        bool1 = true;
        label219:
        if (paramInt < 0) {
          break label362;
        }
        bool2 = true;
        label226:
        localObject = aa.a(((adx)localObject).tbW);
        y.i("MicroMsg.GetChatroomReporter", "[recordFetch] isDown:" + bool1 + " isSuccess:" + bool2 + " chatroomid:" + (String)localObject);
        if (!bool1) {
          break label368;
        }
        paramb.vzp += 1;
        label297:
        paramb.mCount += 1;
        if (bool2) {
          break label381;
        }
        paramb.qPO += 1;
      }
      for (;;)
      {
        if (paramInt < 0) {
          break label392;
        }
        paramb = com.tencent.mm.ui.chatting.i.b.vzo;
        paramb.vzr = (paramLinkedList.size() + paramb.vzr);
        return;
        label344:
        bool1 = false;
        break;
        bool2 = false;
        break label170;
        label356:
        bool1 = false;
        break label219;
        label362:
        bool2 = false;
        break label226;
        label368:
        paramb.vzq += 1;
        break label297;
        label381:
        paramb.mSuccessCount += 1;
      }
      label392:
      break;
      label394:
      long l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.b paramb, m paramm)
  {
    y.i("MicroMsg.GetChatroomMsgFetcher", "[callback] errType:%d errCode:%d errMsg:%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = new LinkedList();
    if (paramm.getType() != 805)
    {
      a(paramb, -1, paramString);
      return 0;
    }
    this.emc.stopTimer();
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb == null))
    {
      a(paramb, -1, paramString);
      return 0;
    }
    Object localObject1 = (adx)paramb.ecE.ecN;
    paramm = (ady)paramb.ecF.ecN;
    boolean bool1;
    if ((paramm == null) || (paramm.tcb == null))
    {
      a(paramb, -1, paramString);
      if (paramm == null)
      {
        bool1 = true;
        if (paramm.tcb != null) {
          break label191;
        }
      }
      label191:
      for (boolean bool2 = true;; bool2 = false)
      {
        y.e("MicroMsg.GetChatroomMsgFetcher", "[callback] resp == null? %b resp.AddMsgList == null? %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        return 0;
        bool1 = false;
        break;
      }
    }
    if (paramm.tcb.size() <= 0)
    {
      y.w("MicroMsg.GetChatroomMsgFetcher", "[callback] fetch size is 0! [%s:%s] isUpFlag:%s ChatroomId:%s", new Object[] { Integer.valueOf(((adx)localObject1).svM), Integer.valueOf(((adx)localObject1).tca), Integer.valueOf(((adx)localObject1).tbY), aa.a(((adx)localObject1).tbW) });
      a(paramb, 0, paramString);
      return 0;
    }
    e.a locala;
    for (;;)
    {
      try
      {
        i locali = (i)com.tencent.mm.kernel.g.r(i.class);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Hv("MicroMsg.GetChatroomMsgFetcher" + hashCode());
        Object localObject3 = paramm.tcb;
        if (((adx)localObject1).tbY == 1)
        {
          bool1 = true;
          localObject3 = a((List)localObject3, bool1, aa.a(((adx)localObject1).tbW)).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label789;
          }
          locala = (e.a)((Iterator)localObject3).next();
          localObject4 = locali.a(locala, emd);
          if (localObject4 == null) {
            break;
          }
          if (((e.b)localObject4).bFH != null) {
            break label527;
          }
          y.e("MicroMsg.GetChatroomMsgFetcher", "ddMsgReturn.msg == null！may be revoke msg");
          continue;
        }
        bool1 = false;
      }
      finally
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Hw("MicroMsg.GetChatroomMsgFetcher" + hashCode());
        localObject1 = aa.a(((adx)localObject1).tbW);
        y.i("MicroMsg.GetChatroomMsgFetcher", "[callback] chatroomId:" + (String)localObject1 + " AddMsgList size:" + paramm.tcb.size());
        a(paramb, 0, paramString);
      }
      continue;
      label527:
      paramString.add(((e.b)localObject4).bFH);
    }
    Object localObject4 = locala.dBs;
    bi localbi = new bi();
    localbi.bf(((cd)localObject4).ndp);
    localbi.bg(locala.ecV);
    localbi.bi(((cd)localObject4).svM);
    String str1 = aa.a(((cd)localObject4).svF);
    String str2 = aa.a(((cd)localObject4).svG);
    com.tencent.mm.plugin.messenger.foundation.a.a.j localj = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE();
    String str3 = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, "");
    if (!localj.has(str1)) {
      if (!str3.equals(str1)) {
        break label891;
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        localbi.fA(1);
        localbi.ec(str2);
        paramInt1 = ((cd)localObject4).hQq;
      }
      for (;;)
      {
        localbi.setStatus(paramInt1);
        if (((cd)localObject4).kSW == 10000) {
          localbi.setStatus(4);
        }
        localbi.fJ(2);
        paramString.add(localbi);
        y.i("MicroMsg.GetChatroomMsgFetcher", "addMsgReturn == null! addMsgInfo addMsg type:%s", new Object[] { Integer.valueOf(locala.dBs.kSW) });
        break;
        localbi.fA(0);
        localbi.ec(str1);
        if (((cd)localObject4).hQq > 3) {
          paramInt1 = ((cd)localObject4).hQq;
        } else {
          paramInt1 = 3;
        }
      }
      label789:
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Hw("MicroMsg.GetChatroomMsgFetcher" + hashCode());
      localObject1 = aa.a(((adx)localObject1).tbW);
      y.i("MicroMsg.GetChatroomMsgFetcher", "[callback] chatroomId:" + (String)localObject1 + " AddMsgList size:" + paramm.tcb.size());
      a(paramb, 0, paramString);
      return 0;
      paramInt1 = 1;
      continue;
      label891:
      paramInt1 = 0;
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, int paramInt, b.b paramb)
  {
    y.i("MicroMsg.GetChatroomMsgFetcher", "[fetch] chatroomId:" + paramString + " msgSeq:" + paramLong1 + " filterSeq:" + paramLong2 + " upDownFlag:" + paramInt);
    this.eme = paramb;
    paramb = new adx();
    paramb.tbW = aa.pj(paramString);
    paramb.svM = ((int)paramLong1);
    paramb.tca = ((int)paramLong2);
    paramb.tbX = 18;
    paramb.tbY = paramInt;
    paramString = new com.tencent.mm.ah.b.a();
    paramString.ecH = paramb;
    paramString.ecI = new ady();
    paramString.uri = "/cgi-bin/micromsg-bin/getcrmsg";
    paramString.ecG = 805;
    paramString.ecJ = 0;
    paramString.ecK = 0;
    w.a(paramString.Kt(), this, true);
    this.emc.stopTimer();
    this.emc.S(5000L, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ap.b
 * JD-Core Version:    0.7.0.1
 */