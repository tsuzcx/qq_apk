package com.tencent.mm.modelmulti;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.a.pf;
import com.tencent.mm.h.a.ph;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bpc;
import com.tencent.mm.protocal.c.bpd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class h
  extends com.tencent.mm.ah.m
  implements k
{
  private static final List<Object> esN = new ArrayList();
  public long bIt;
  private b dmK;
  private com.tencent.mm.ah.f dmL;
  private final List<bi> esO = new LinkedList();
  private int esP = 3;
  private boolean esQ = false;
  private final List<bi> esR = new ArrayList();
  private bi esS = null;
  public com.tencent.mm.plugin.messenger.foundation.a.m esT = null;
  
  public h()
  {
    y.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bk.csb() });
    y.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
  }
  
  public h(long paramLong)
  {
    y.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = " + paramLong);
    this.bIt = paramLong;
    this.esS = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramLong);
    if (this.esS == null) {
      y.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[] { Long.valueOf(paramLong) });
    }
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    y.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bk.csb() });
    bi localbi;
    if (!bk.bl(paramString1))
    {
      localbi = new bi();
      localbi.setStatus(1);
      localbi.ec(paramString1);
      localbi.bg(bd.iK(paramString1));
      localbi.fA(1);
      localbi.setContent(paramString2);
      localbi.setType(paramInt);
      paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.q.class)).v(localbi);
      if (!bk.bl(paramString1))
      {
        localbi.cY(paramString1);
        y.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbi.czr });
      }
    }
    try
    {
      this.bIt = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().b(localbi, true);
      if (this.bIt == -1L) {
        com.tencent.mm.plugin.report.f.nEG.a(111L, 255L, 1L, false);
      }
      if (this.bIt != -1L) {
        bool = true;
      }
      Assert.assertTrue(bool);
      y.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.bIt);
      return;
    }
    catch (SQLiteException paramString1)
    {
      com.tencent.mm.plugin.report.f.nEG.a(111L, 255L, 1L, false);
      throw paramString1;
    }
  }
  
  public h(String paramString1, String paramString2, int paramInt1, int paramInt2, Object paramObject)
  {
    y.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bk.csb() });
    bi localbi;
    if (!bk.bl(paramString1))
    {
      localbi = new bi();
      localbi.setStatus(1);
      localbi.ec(paramString1);
      localbi.bg(bd.iK(paramString1));
      localbi.fA(1);
      localbi.setContent(paramString2);
      localbi.setType(paramInt1);
      paramString1 = a(((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.q.class)).v(localbi), paramObject, paramInt2);
      if (!bk.bl(paramString1))
      {
        localbi.cY(paramString1);
        y.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbi.czr });
      }
    }
    for (;;)
    {
      try
      {
        this.bIt = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().b(localbi, true);
        if (this.bIt == -1L) {
          com.tencent.mm.plugin.report.f.nEG.a(111L, 255L, 1L, false);
        }
        if (this.bIt != -1L)
        {
          bool = true;
          Assert.assertTrue(bool);
          y.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.bIt);
          return;
        }
      }
      catch (SQLiteException paramString1)
      {
        com.tencent.mm.plugin.report.f.nEG.a(111L, 255L, 1L, false);
        throw paramString1;
      }
      boolean bool = false;
    }
  }
  
  private void Pg()
  {
    int i = 0;
    while (i < this.esO.size())
    {
      iS(i);
      i += 1;
    }
  }
  
  private static String a(String paramString, Object paramObject, int paramInt)
  {
    boolean bool;
    if (paramObject == null)
    {
      bool = true;
      y.i("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((bk.bl(paramString)) || (paramString.startsWith("<msgsource>"))) {
        break label74;
      }
      y.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramString });
    }
    label74:
    while ((paramInt != 291) || (!(paramObject instanceof HashMap)))
    {
      return paramString;
      bool = false;
      break;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    if (bk.bl(paramString)) {
      localStringBuffer.append("<msgsource>");
    }
    paramObject = ((HashMap)paramObject).entrySet().iterator();
    while (paramObject.hasNext())
    {
      Object localObject = (Map.Entry)paramObject.next();
      String str = (String)((Map.Entry)localObject).getValue();
      localObject = (String)((Map.Entry)localObject).getKey();
      if ((bk.bl(str)) || (bk.bl((String)localObject)))
      {
        y.w("MicroMsg.NetSceneSendMsg", "%s %s", new Object[] { localObject, str });
      }
      else
      {
        localStringBuffer.append("<").append((String)localObject).append(">");
        localStringBuffer.append(str);
        localStringBuffer.append("</").append((String)localObject).append(">");
      }
    }
    if (bk.bl(paramString))
    {
      localStringBuffer.append("</msgsource>");
      return localStringBuffer.toString();
    }
    return paramString.replace("<msgsource>", "<msgsource>" + localStringBuffer.toString());
  }
  
  private void iR(int paramInt)
  {
    if (this.esO == null)
    {
      y.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
      return;
    }
    if ((paramInt >= this.esO.size()) || (paramInt < 0))
    {
      y.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.esO.size()) });
      return;
    }
    t((bi)this.esO.get(paramInt));
  }
  
  private void iS(int paramInt)
  {
    bi localbi = (bi)this.esO.get(paramInt);
    y.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
    u(localbi);
  }
  
  private void mE(String paramString)
  {
    y.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
    int i = a(this.edc, this.dmL);
    if (i == -2) {
      this.dmL.onSceneEnd(0, 0, paramString, this);
    }
    while (i >= 0) {
      return;
    }
    this.dmL.onSceneEnd(3, -1, paramString, this);
  }
  
  private static void t(bi parambi)
  {
    pf localpf = new pf();
    localpf.bYS.bFH = parambi;
    a.udP.m(localpf);
    y.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
  }
  
  private static void u(bi parambi)
  {
    parambi.setStatus(5);
    com.tencent.mm.plugin.report.f.nEG.a(111L, 30L, 1L, true);
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(parambi.field_msgId, parambi);
    Iterator localIterator = esN.iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      String str = parambi.field_talker;
      str = parambi.field_content;
    }
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final boolean Ky()
  {
    boolean bool = super.Ky();
    if (bool) {
      com.tencent.mm.plugin.report.f.nEG.a(111L, 254L, 1L, false);
    }
    return bool;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new bpc();
    paramf.ecI = new bpd();
    paramf.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramf.ecG = 522;
    paramf.ecJ = 237;
    paramf.ecK = 1000000237;
    this.dmK = paramf.Kt();
    bpc localbpc = (bpc)this.dmK.ecE.ecN;
    int i;
    if (this.esS == null)
    {
      paramf = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().bia();
      if (paramf.size() != 0) {
        break label244;
      }
      y.w("MicroMsg.NetSceneSendMsg", "no sending message");
      i = -2;
    }
    label244:
    int j;
    do
    {
      return i;
      if (this.esS.field_status != 5) {
        y.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[] { Long.valueOf(this.esS.field_msgId), Integer.valueOf(this.esS.field_status) });
      }
      this.esS.setStatus(1);
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.bIt, this.esS);
      paramf = new ArrayList();
      paramf.add(this.esS);
      this.esS = null;
      break;
      this.esO.clear();
      i = 0;
      while (i < paramf.size())
      {
        bi localbi = (bi)paramf.get(i);
        if (localbi.field_isSend == 1)
        {
          awn localawn = new awn();
          localawn.svG = new bml().YI(localbi.field_talker);
          localawn.mPL = ((int)(localbi.field_createTime / 1000L));
          localawn.hQR = localbi.getType();
          localawn.kVs = localbi.field_content;
          localawn.ttf = o.l(com.tencent.mm.model.q.Gj(), localbi.field_createTime).hashCode();
          if (this.esT == null) {
            this.esT = ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.q.class)).Pk();
          }
          y.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[] { this.esT });
          this.esT.a(localawn, localbi);
          y.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[] { localawn.svK });
          localbpc.hPT.add(localawn);
          localbpc.hPS = localbpc.hPT.size();
          this.esO.add(localbi);
        }
        i += 1;
      }
      j = a(parame, this.dmK, this);
      i = j;
    } while (j >= 0);
    y.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[] { Integer.valueOf(j) });
    Pg();
    return j;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      com.tencent.mm.plugin.report.f.nEG.a(111L, paramInt2 + 40, 1L, true);
      com.tencent.mm.plugin.report.f.nEG.a(111L, 253L, 1L, false);
      if ((paramInt2 == 3) || (paramInt2 == 9) || (paramInt2 == 7) || (paramInt2 == 8) || (paramInt2 == 1))
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        y.e("MicroMsg.NetSceneSendMsg", "Message delivery failed due to network reasons.");
        return;
      }
      Pg();
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = 0;
      while (paramInt1 < this.esO.size())
      {
        iR(paramInt1);
        paramInt1 += 1;
      }
      y.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
      mE(paramString);
      return;
    }
    paramq = ((bpd)this.dmK.ecF.ecN).hPT;
    paramArrayOfByte = new ArrayList();
    if (this.esO.size() == paramq.size())
    {
      paramInt1 = 0;
      if (paramInt1 < paramq.size())
      {
        Object localObject = (awo)paramq.get(paramInt1);
        if ((((awo)localObject).sze != 0) || (ae.eTw))
        {
          com.tencent.mm.plugin.report.f.nEG.a(111L, 252L, 1L, false);
          if ((((awo)localObject).sze == -49) || (ae.eTw))
          {
            y.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(((awo)localObject).sze), Integer.valueOf(paramInt1), Boolean.valueOf(ae.eTw), Integer.valueOf(this.esP) });
            if (this.esQ)
            {
              localObject = (bi)this.esO.get(paramInt1);
              this.esR.add(localObject);
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (this.esP < 0)
              {
                iS(paramInt1);
                this.dmL.onSceneEnd(4, ((awo)localObject).sze, paramString, this);
                iR(paramInt1);
                return;
              }
              this.esQ = true;
              this.esP -= 1;
              localObject = (bi)this.esO.get(paramInt1);
              this.esR.add(localObject);
              com.tencent.mm.kernel.g.DS().O(new h.1(this, paramString));
            }
          }
          iS(paramInt1);
          this.dmL.onSceneEnd(4, ((awo)localObject).sze, paramString, this);
          iR(paramInt1);
          return;
        }
        long l = ((bi)this.esO.get(paramInt1)).field_msgId;
        y.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + ((awo)localObject).ndp + " sent successfully!");
        bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(l);
        localbi.bf(((awo)localObject).ndp);
        y.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(((awo)localObject).ndp), Integer.valueOf(ae.eSQ) });
        if ((10007 == ae.eSP) && (ae.eSQ != 0))
        {
          localbi.bf(ae.eSQ);
          ae.eSQ = 0;
        }
        localbi.setStatus(2);
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(l, localbi);
        if (this.esO == null) {
          y.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
        }
        for (;;)
        {
          paramArrayOfByte.add(Integer.valueOf(paramInt1));
          if (1 != ((awo)localObject).hQR) {
            break;
          }
          com.tencent.mm.plugin.report.f.nEG.a(11942, true, false, new Object[] { Long.valueOf(((awo)localObject).ndp) });
          com.tencent.mm.plugin.report.f.nEG.a(11945, false, true, new Object[] { Long.valueOf(((awo)localObject).ndp) });
          com.tencent.mm.plugin.report.f.nEG.a(11946, false, false, new Object[] { Long.valueOf(((awo)localObject).ndp) });
          com.tencent.mm.plugin.report.f.nEG.a(90L, 0L, 1L, false);
          com.tencent.mm.plugin.report.f.nEG.a(90L, 1L, 1L, true);
          break;
          if ((paramInt1 >= this.esO.size()) || (paramInt1 < 0))
          {
            y.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.esO.size()) });
          }
          else
          {
            l = ((bi)this.esO.get(paramInt1)).field_msgId;
            y.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[] { Long.valueOf(l) });
            localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(l);
            ph localph = new ph();
            localph.bYU.bFH = localbi;
            a.udP.m(localph);
          }
        }
      }
      y.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[] { Integer.valueOf(paramInt1 - this.esR.size()), Integer.valueOf(this.esR.size()) });
    }
    y.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[] { Boolean.valueOf(this.esQ) });
    if (this.esQ)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    mE(paramString);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    if (this.esO.size() > 0) {
      return m.b.edr;
    }
    return m.b.eds;
  }
  
  public final int getType()
  {
    return 522;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.h
 * JD-Core Version:    0.7.0.1
 */