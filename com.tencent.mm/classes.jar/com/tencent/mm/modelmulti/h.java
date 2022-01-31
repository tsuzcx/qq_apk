package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.p;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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
  extends com.tencent.mm.ai.m
  implements k
{
  private static final List<Object> fIA;
  private f callback;
  public long cpO;
  private final List<bi> fIB;
  private int fIC;
  private boolean fID;
  private final List<bi> fIE;
  private bi fIF;
  public com.tencent.mm.plugin.messenger.foundation.a.m fIG;
  private b rr;
  
  static
  {
    AppMethodBeat.i(59985);
    fIA = new ArrayList();
    AppMethodBeat.o(59985);
  }
  
  public h()
  {
    AppMethodBeat.i(59970);
    this.fIB = new LinkedList();
    this.fIC = 3;
    this.fID = false;
    this.fIE = new ArrayList();
    this.fIF = null;
    this.fIG = null;
    ab.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bo.dtY() });
    ab.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(59970);
  }
  
  public h(long paramLong)
  {
    AppMethodBeat.i(59969);
    this.fIB = new LinkedList();
    this.fIC = 3;
    this.fID = false;
    this.fIE = new ArrayList();
    this.fIF = null;
    this.fIG = null;
    ab.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(paramLong)));
    this.cpO = paramLong;
    this.fIF = ((j)g.E(j.class)).bPQ().kB(paramLong);
    if (this.fIF == null) {
      ab.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(59969);
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(59968);
    this.fIB = new LinkedList();
    this.fIC = 3;
    this.fID = false;
    this.fIE = new ArrayList();
    this.fIF = null;
    this.fIG = null;
    ab.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bo.dtY() });
    bi localbi;
    if (!bo.isNullOrNil(paramString1))
    {
      localbi = new bi();
      localbi.setStatus(1);
      localbi.kj(paramString1);
      localbi.fQ(bf.py(paramString1));
      localbi.hL(1);
      localbi.setContent(paramString2);
      localbi.setType(paramInt);
      paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.q)g.E(com.tencent.mm.plugin.messenger.foundation.a.q.class)).B(localbi);
      if (!bo.isNullOrNil(paramString1))
      {
        localbi.jl(paramString1);
        ab.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbi.dns });
      }
    }
    for (;;)
    {
      try
      {
        this.cpO = ((j)g.E(j.class)).bPQ().c(localbi, true);
        if (this.cpO == -1L) {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 255L, 1L, false);
        }
        if (this.cpO != -1L)
        {
          bool = true;
          Assert.assertTrue(bool);
          ab.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.cpO);
          AppMethodBeat.o(59968);
          return;
        }
      }
      catch (SQLiteException paramString1)
      {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 255L, 1L, false);
        AppMethodBeat.o(59968);
        throw paramString1;
      }
      boolean bool = false;
    }
  }
  
  public h(String paramString1, String paramString2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(59967);
    this.fIB = new LinkedList();
    this.fIC = 3;
    this.fID = false;
    this.fIE = new ArrayList();
    this.fIF = null;
    this.fIG = null;
    ab.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bo.dtY() });
    bi localbi;
    if (!bo.isNullOrNil(paramString1))
    {
      localbi = new bi();
      localbi.setStatus(1);
      localbi.kj(paramString1);
      localbi.fQ(bf.py(paramString1));
      localbi.hL(1);
      localbi.setContent(paramString2);
      localbi.setType(paramInt1);
      paramString1 = a(((com.tencent.mm.plugin.messenger.foundation.a.q)g.E(com.tencent.mm.plugin.messenger.foundation.a.q.class)).B(localbi), paramObject, paramInt2);
      if (!bo.isNullOrNil(paramString1))
      {
        localbi.jl(paramString1);
        ab.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbi.dns });
      }
    }
    for (;;)
    {
      try
      {
        this.cpO = ((j)g.E(j.class)).bPQ().c(localbi, true);
        if (this.cpO == -1L) {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 255L, 1L, false);
        }
        if (this.cpO != -1L)
        {
          bool = true;
          Assert.assertTrue(bool);
          ab.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.cpO);
          AppMethodBeat.o(59967);
          return;
        }
      }
      catch (SQLiteException paramString1)
      {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 255L, 1L, false);
        AppMethodBeat.o(59967);
        throw paramString1;
      }
      boolean bool = false;
    }
  }
  
  private static void A(bi parambi)
  {
    AppMethodBeat.i(59981);
    parambi.setStatus(5);
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 30L, 1L, true);
    ((j)g.E(j.class)).bPQ().a(parambi.field_msgId, parambi);
    parambi = fIA.iterator();
    while (parambi.hasNext()) {
      parambi.next();
    }
    AppMethodBeat.o(59981);
  }
  
  private static String a(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(59973);
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((bo.isNullOrNil(paramString)) || (paramString.startsWith("<msgsource>"))) {
        break;
      }
      ab.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramString });
      AppMethodBeat.o(59973);
      return paramString;
    }
    if ((paramInt == 291) && ((paramObject instanceof HashMap)))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (bo.isNullOrNil(paramString)) {
        localStringBuffer.append("<msgsource>");
      }
      paramObject = ((HashMap)paramObject).entrySet().iterator();
      while (paramObject.hasNext())
      {
        Object localObject = (Map.Entry)paramObject.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localObject = (String)((Map.Entry)localObject).getKey();
        if ((bo.isNullOrNil(str)) || (bo.isNullOrNil((String)localObject)))
        {
          ab.w("MicroMsg.NetSceneSendMsg", "%s %s", new Object[] { localObject, str });
        }
        else
        {
          localStringBuffer.append("<").append((String)localObject).append(">");
          localStringBuffer.append(str);
          localStringBuffer.append("</").append((String)localObject).append(">");
        }
      }
      if (bo.isNullOrNil(paramString))
      {
        localStringBuffer.append("</msgsource>");
        paramString = localStringBuffer.toString();
        AppMethodBeat.o(59973);
        return paramString;
      }
      paramString = paramString.replace("<msgsource>", "<msgsource>" + localStringBuffer.toString());
      AppMethodBeat.o(59973);
      return paramString;
    }
    AppMethodBeat.o(59973);
    return paramString;
  }
  
  private void aii()
  {
    AppMethodBeat.i(59979);
    int i = 0;
    while (i < this.fIB.size())
    {
      lK(i);
      i += 1;
    }
    AppMethodBeat.o(59979);
  }
  
  private void lJ(int paramInt)
  {
    AppMethodBeat.i(59975);
    if (this.fIB == null)
    {
      ab.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
      AppMethodBeat.o(59975);
      return;
    }
    if ((paramInt >= this.fIB.size()) || (paramInt < 0))
    {
      ab.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.fIB.size()) });
      AppMethodBeat.o(59975);
      return;
    }
    z((bi)this.fIB.get(paramInt));
    AppMethodBeat.o(59975);
  }
  
  private void lK(int paramInt)
  {
    AppMethodBeat.i(59980);
    bi localbi = (bi)this.fIB.get(paramInt);
    ab.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[] { Long.valueOf(localbi.field_msgId) });
    A(localbi);
    AppMethodBeat.o(59980);
  }
  
  private void tO(String paramString)
  {
    AppMethodBeat.i(59978);
    ab.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
    int i = doScene(dispatcher(), this.callback);
    if (i == -2)
    {
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(59978);
      return;
    }
    if (i < 0) {
      this.callback.onSceneEnd(3, -1, paramString, this);
    }
    AppMethodBeat.o(59978);
  }
  
  private static void z(bi parambi)
  {
    AppMethodBeat.i(59976);
    qk localqk = new qk();
    localqk.cGZ.cmQ = parambi;
    a.ymk.l(localqk);
    ab.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[] { Long.valueOf(parambi.field_msgId) });
    AppMethodBeat.o(59976);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(59974);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new byz();
    paramf.fsY = new bza();
    paramf.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramf.funcId = 522;
    paramf.reqCmdId = 237;
    paramf.respCmdId = 1000000237;
    this.rr = paramf.ado();
    byz localbyz = (byz)this.rr.fsV.fta;
    if (this.fIF == null) {
      paramf = ((j)g.E(j.class)).bPQ().bQc();
    }
    while (paramf.size() == 0)
    {
      ab.w("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(59974);
      return -2;
      if (this.fIF.field_status != 5) {
        ab.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[] { Long.valueOf(this.fIF.field_msgId), Integer.valueOf(this.fIF.field_status) });
      }
      this.fIF.setStatus(1);
      ((j)g.E(j.class)).bPQ().a(this.cpO, this.fIF);
      paramf = new ArrayList();
      paramf.add(this.fIF);
      this.fIF = null;
    }
    this.fIB.clear();
    int i = 0;
    while (i < paramf.size())
    {
      bi localbi = (bi)paramf.get(i);
      if (localbi.field_isSend == 1)
      {
        bdc localbdc = new bdc();
        localbdc.woQ = new bwc().aoF(localbi.field_talker);
        localbdc.CreateTime = ((int)(localbi.field_createTime / 1000L));
        localbdc.jKs = localbi.getType();
        localbdc.ntu = localbi.field_content;
        localbdc.xtf = p.t(r.Zn(), localbi.field_createTime).hashCode();
        if (this.fIG == null) {
          this.fIG = ((com.tencent.mm.plugin.messenger.foundation.a.q)g.E(com.tencent.mm.plugin.messenger.foundation.a.q.class)).aim();
        }
        ab.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[] { this.fIG });
        this.fIG.a(localbdc, localbi);
        ab.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[] { localbdc.woU });
        localbyz.jJv.add(localbdc);
        localbyz.jJu = localbyz.jJv.size();
        this.fIB.add(localbi);
      }
      i += 1;
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0)
    {
      ab.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      aii();
    }
    AppMethodBeat.o(59974);
    return i;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59977);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, paramInt2 + 40, 1L, true);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 253L, 1L, false);
      if ((paramInt2 == 3) || (paramInt2 == 9) || (paramInt2 == 7) || (paramInt2 == 8) || (paramInt2 == 1))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        ab.e("MicroMsg.NetSceneSendMsg", "Message delivery failed due to network reasons.");
        AppMethodBeat.o(59977);
        return;
      }
      aii();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = 0;
      while (paramInt1 < this.fIB.size())
      {
        lJ(paramInt1);
        paramInt1 += 1;
      }
      ab.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
      tO(paramString);
      AppMethodBeat.o(59977);
      return;
    }
    paramq = ((bza)this.rr.fsW.fta).jJv;
    paramArrayOfByte = new ArrayList();
    if (this.fIB.size() == paramq.size())
    {
      paramInt1 = 0;
      if (paramInt1 < paramq.size())
      {
        Object localObject = (bdd)paramq.get(paramInt1);
        if ((((bdd)localObject).Ret != 0) || (ae.glr))
        {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 252L, 1L, false);
          if ((((bdd)localObject).Ret == -49) || (ae.glr))
          {
            ab.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(((bdd)localObject).Ret), Integer.valueOf(paramInt1), Boolean.valueOf(ae.glr), Integer.valueOf(this.fIC) });
            if (this.fID)
            {
              localObject = (bi)this.fIB.get(paramInt1);
              this.fIE.add(localObject);
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (this.fIC < 0)
              {
                lK(paramInt1);
                this.callback.onSceneEnd(4, ((bdd)localObject).Ret, paramString, this);
                lJ(paramInt1);
                AppMethodBeat.o(59977);
                return;
              }
              this.fID = true;
              this.fIC -= 1;
              localObject = (bi)this.fIB.get(paramInt1);
              this.fIE.add(localObject);
              g.RO().ac(new h.1(this, paramString));
            }
          }
          lK(paramInt1);
          this.callback.onSceneEnd(4, ((bdd)localObject).Ret, paramString, this);
          lJ(paramInt1);
          AppMethodBeat.o(59977);
          return;
        }
        long l = ((bi)this.fIB.get(paramInt1)).field_msgId;
        ab.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + ((bdd)localObject).pIG + " sent successfully!");
        bi localbi = ((j)g.E(j.class)).bPQ().kB(l);
        localbi.fP(((bdd)localObject).pIG);
        ab.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(((bdd)localObject).pIG), Integer.valueOf(ae.gkL) });
        if ((10007 == ae.gkK) && (ae.gkL != 0))
        {
          localbi.fP(ae.gkL);
          ae.gkL = 0;
        }
        localbi.setStatus(2);
        ((j)g.E(j.class)).bPQ().a(l, localbi);
        if (this.fIB == null) {
          ab.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
        }
        for (;;)
        {
          paramArrayOfByte.add(Integer.valueOf(paramInt1));
          if (1 != ((bdd)localObject).jKs) {
            break;
          }
          com.tencent.mm.plugin.report.e.qrI.a(11942, true, false, new Object[] { Long.valueOf(((bdd)localObject).pIG) });
          com.tencent.mm.plugin.report.e.qrI.a(11945, false, true, new Object[] { Long.valueOf(((bdd)localObject).pIG) });
          com.tencent.mm.plugin.report.e.qrI.a(11946, false, false, new Object[] { Long.valueOf(((bdd)localObject).pIG) });
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(90L, 0L, 1L, false);
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(90L, 1L, 1L, true);
          break;
          if ((paramInt1 >= this.fIB.size()) || (paramInt1 < 0))
          {
            ab.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.fIB.size()) });
          }
          else
          {
            l = ((bi)this.fIB.get(paramInt1)).field_msgId;
            ab.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[] { Long.valueOf(l) });
            localbi = ((j)g.E(j.class)).bPQ().kB(l);
            qm localqm = new qm();
            localqm.cHb.cmQ = localbi;
            a.ymk.l(localqm);
          }
        }
      }
      ab.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[] { Integer.valueOf(paramInt1 - this.fIE.size()), Integer.valueOf(this.fIE.size()) });
    }
    ab.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[] { Boolean.valueOf(this.fID) });
    if (this.fID)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(59977);
      return;
    }
    tO(paramString);
    AppMethodBeat.o(59977);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(59971);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 254L, 1L, false);
    }
    AppMethodBeat.o(59971);
    return bool;
  }
  
  public final m.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(59972);
    if (this.fIB.size() > 0)
    {
      paramq = m.b.ftu;
      AppMethodBeat.o(59972);
      return paramq;
    }
    paramq = m.b.ftv;
    AppMethodBeat.o(59972);
    return paramq;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.h
 * JD-Core Version:    0.7.0.1
 */