package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class i
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private static final List<Object> hMg;
  private com.tencent.mm.ak.g callback;
  private final List<bo> hMh;
  private int hMi;
  private boolean hMj;
  private final List<bo> hMk;
  private bo hMl;
  public com.tencent.mm.plugin.messenger.foundation.a.n hMm;
  public long msgId;
  private b rr;
  
  static
  {
    AppMethodBeat.i(43043);
    hMg = new ArrayList();
    AppMethodBeat.o(43043);
  }
  
  public i()
  {
    AppMethodBeat.i(43027);
    this.hMh = new LinkedList();
    this.hMi = 3;
    this.hMj = false;
    this.hMk = new ArrayList();
    this.hMl = null;
    this.hMm = null;
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bs.eWi() });
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(43027);
  }
  
  public i(long paramLong)
  {
    AppMethodBeat.i(43026);
    this.hMh = new LinkedList();
    this.hMi = 3;
    this.hMj = false;
    this.hMk = new ArrayList();
    this.hMl = null;
    this.hMm = null;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(paramLong)));
    this.msgId = paramLong;
    this.hMl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramLong);
    if (this.hMl == null) {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(43026);
  }
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43025);
    this.hMh = new LinkedList();
    this.hMi = 3;
    this.hMj = false;
    this.hMk = new ArrayList();
    this.hMl = null;
    this.hMm = null;
    if (com.tencent.mm.sdk.platformtools.ac.getLogLevel() <= 1) {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bs.eWi() });
    }
    bo localbo;
    if (!bs.isNullOrNil(paramString1))
    {
      localbo = new bo();
      localbo.setStatus(1);
      localbo.re(paramString1);
      localbo.oA(bi.yp(paramString1));
      localbo.jT(1);
      localbo.setContent(paramString2);
      localbo.setType(paramInt1);
      if ((paramInt2 == 1) && (paramInt1 == 42)) {
        localbo.fbT();
      }
      String str = ((t)com.tencent.mm.kernel.g.ab(t.class)).N(localbo);
      if (!bs.isNullOrNil(str))
      {
        localbo.qf(str);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbo.eul });
      }
    }
    try
    {
      this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().c(localbo, true);
      if ((this.msgId != -1L) && (((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).ahY(paramString1))) {
        ((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).a(paramString1, u.axw(), paramString2, this.msgId);
      }
      if (this.msgId != -1L)
      {
        bool = true;
        Assert.assertTrue(bool);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
        AppMethodBeat.o(43025);
        return;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 255L, 1L, false);
        if (!localSQLiteException.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().dcA();
        this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().c(localbo, true);
      }
      AppMethodBeat.o(43025);
      throw localSQLiteException;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.NetSceneSendMsg", localIllegalStateException, "", new Object[0]);
        continue;
        boolean bool = false;
      }
    }
  }
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(43024);
    this.hMh = new LinkedList();
    this.hMi = 3;
    this.hMj = false;
    this.hMk = new ArrayList();
    this.hMl = null;
    this.hMm = null;
    if (com.tencent.mm.sdk.platformtools.ac.getLogLevel() <= 1) {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bs.eWi() });
    }
    bo localbo;
    if (!bs.isNullOrNil(paramString1))
    {
      localbo = new bo();
      localbo.setStatus(1);
      localbo.re(paramString1);
      localbo.oA(bi.yp(paramString1));
      localbo.jT(1);
      localbo.setContent(paramString2);
      localbo.setType(paramInt1);
      paramObject = a(((t)com.tencent.mm.kernel.g.ab(t.class)).N(localbo), paramObject, paramInt2);
      if (!bs.isNullOrNil(paramObject))
      {
        localbo.qf(paramObject);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbo.eul });
      }
      if ((paramInt2 & 0x2) != 0)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "has paste fully flag");
        paramObject = new HashMap();
        paramObject.put(".msgsource.alnode.cf", "1");
        bk.b(localbo, bk.r(paramObject));
      }
    }
    try
    {
      this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().c(localbo, true);
      if (this.msgId == -1L)
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 255L, 1L, false);
        if (this.msgId == -1L) {
          break label490;
        }
        bool = true;
        Assert.assertTrue(bool);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
        AppMethodBeat.o(43024);
      }
    }
    catch (SQLiteException paramObject)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 255L, 1L, false);
        if (!paramObject.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().dcA();
        this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().c(localbo, true);
      }
      AppMethodBeat.o(43024);
      throw paramObject;
    }
    catch (IllegalStateException paramObject)
    {
      for (;;)
      {
        boolean bool;
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.NetSceneSendMsg", paramObject, "", new Object[0]);
        continue;
        if (((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).ahY(paramString1))
        {
          ((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).a(paramString1, u.axw(), paramString2, this.msgId);
          continue;
          label490:
          bool = false;
        }
      }
    }
  }
  
  private void CS(String paramString)
  {
    AppMethodBeat.i(43035);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
    int i = doScene(dispatcher(), this.callback);
    if (i == -2)
    {
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(43035);
      return;
    }
    if (i < 0) {
      this.callback.onSceneEnd(3, -1, paramString, this);
    }
    AppMethodBeat.o(43035);
  }
  
  private static void L(bo parambo)
  {
    AppMethodBeat.i(43033);
    sl localsl = new sl();
    localsl.dvx.cZc = parambo;
    a.GpY.l(localsl);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[] { Long.valueOf(parambo.field_msgId) });
    AppMethodBeat.o(43033);
  }
  
  private static void M(bo parambo)
  {
    AppMethodBeat.i(43038);
    parambo.setStatus(5);
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 30L, 1L, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(parambo.field_msgId, parambo);
    parambo = hMg.iterator();
    while (parambo.hasNext()) {
      parambo.next();
    }
    AppMethodBeat.o(43038);
  }
  
  private static String a(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(163517);
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((bs.isNullOrNil(paramString)) || (paramString.startsWith("<msgsource>"))) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramString });
      AppMethodBeat.o(163517);
      return paramString;
    }
    if (((paramInt & 0x1) != 0) && ((paramObject instanceof HashMap)))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (bs.isNullOrNil(paramString)) {
        localStringBuffer.append("<msgsource>");
      }
      paramObject = ((HashMap)paramObject).entrySet().iterator();
      while (paramObject.hasNext())
      {
        Object localObject = (Map.Entry)paramObject.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localObject = (String)((Map.Entry)localObject).getKey();
        if ((bs.isNullOrNil(str)) || (bs.isNullOrNil((String)localObject)))
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneSendMsg", "%s %s", new Object[] { localObject, str });
        }
        else
        {
          localStringBuffer.append("<").append((String)localObject).append(">");
          localStringBuffer.append(str);
          localStringBuffer.append("</").append((String)localObject).append(">");
        }
      }
      if (bs.isNullOrNil(paramString))
      {
        localStringBuffer.append("</msgsource>");
        paramString = localStringBuffer.toString();
        AppMethodBeat.o(163517);
        return paramString;
      }
      paramString = paramString.replace("<msgsource>", "<msgsource>" + localStringBuffer.toString());
      AppMethodBeat.o(163517);
      return paramString;
    }
    AppMethodBeat.o(163517);
    return paramString;
  }
  
  private void aGg()
  {
    AppMethodBeat.i(43036);
    int i = 0;
    while (i < this.hMh.size())
    {
      pi(i);
      i += 1;
    }
    AppMethodBeat.o(43036);
  }
  
  private void ph(int paramInt)
  {
    AppMethodBeat.i(43032);
    if (this.hMh == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
      AppMethodBeat.o(43032);
      return;
    }
    if ((paramInt >= this.hMh.size()) || (paramInt < 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hMh.size()) });
      AppMethodBeat.o(43032);
      return;
    }
    L((bo)this.hMh.get(paramInt));
    AppMethodBeat.o(43032);
  }
  
  private void pi(int paramInt)
  {
    AppMethodBeat.i(43037);
    bo localbo = (bo)this.hMh.get(paramInt);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[] { Long.valueOf(localbo.field_msgId) });
    M(localbo);
    AppMethodBeat.o(43037);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(43031);
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new cul();
    paramg.hvu = new cum();
    paramg.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramg.funcId = 522;
    paramg.reqCmdId = 237;
    paramg.respCmdId = 1000000237;
    this.rr = paramg.aAz();
    cul localcul = (cul)this.rr.hvr.hvw;
    if (this.hMl == null) {
      paramg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().dcD();
    }
    while (paramg.size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(43031);
      return -2;
      if (this.hMl.field_status != 5) {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[] { Long.valueOf(this.hMl.field_msgId), Integer.valueOf(this.hMl.field_status) });
      }
      this.hMl.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.msgId, this.hMl);
      paramg = new ArrayList();
      paramg.add(this.hMl);
      this.hMl = null;
    }
    this.hMh.clear();
    int i = 0;
    while (i < paramg.size())
    {
      bo localbo = (bo)paramg.get(i);
      if (localbo.field_isSend == 1)
      {
        buj localbuj = new buj();
        localbuj.DPU = new crm().aJV(localbo.field_talker);
        localbuj.CreateTime = ((int)(localbo.field_createTime / 1000L));
        localbuj.ndI = localbo.getType();
        localbuj.hkR = localbo.field_content;
        localbuj.Fkw = s.u(u.axw(), localbo.field_createTime).hashCode();
        if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(localbo.field_talker)) {
          localbuj.EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(localbo.field_talker);
        }
        if (this.hMm == null) {
          this.hMm = ((t)com.tencent.mm.kernel.g.ab(t.class)).aGk();
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[] { this.hMm });
        this.hMm.a(localbuj, localbo);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[] { localbuj.DPY });
        localcul.ncM.add(localbuj);
        localcul.ncL = localcul.ncM.size();
        this.hMh.add(localbo);
      }
      i += 1;
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      aGg();
    }
    AppMethodBeat.o(43031);
    return i;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, final String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43034);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, paramInt2 + 40, 1L, true);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 253L, 1L, false);
      if ((paramInt2 == 3) || (paramInt2 == 9) || (paramInt2 == 7) || (paramInt2 == 8) || (paramInt2 == 1))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneSendMsg", "Message delivery failed due to network reasons.");
        AppMethodBeat.o(43034);
        return;
      }
      aGg();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = 0;
      while (paramInt1 < this.hMh.size())
      {
        ph(paramInt1);
        paramInt1 += 1;
      }
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
      CS(paramString);
      AppMethodBeat.o(43034);
      return;
    }
    paramArrayOfByte = (cum)this.rr.hvs.hvw;
    paramq = paramArrayOfByte.ncM;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramArrayOfByte.EhF);
    paramArrayOfByte = new ArrayList();
    if (this.hMh.size() == paramq.size())
    {
      paramInt1 = 0;
      if (paramInt1 < paramq.size())
      {
        Object localObject = (buk)paramq.get(paramInt1);
        if ((((buk)localObject).Ret != 0) || (ab.iwp))
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 252L, 1L, false);
          if ((((buk)localObject).Ret == -49) || (ab.iwp))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(((buk)localObject).Ret), Integer.valueOf(paramInt1), Boolean.valueOf(ab.iwp), Integer.valueOf(this.hMi) });
            if (this.hMj)
            {
              localObject = (bo)this.hMh.get(paramInt1);
              this.hMk.add(localObject);
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (this.hMi < 0)
              {
                pi(paramInt1);
                this.callback.onSceneEnd(4, ((buk)localObject).Ret, paramString, this);
                ph(paramInt1);
                AppMethodBeat.o(43034);
                return;
              }
              this.hMj = true;
              this.hMi -= 1;
              localObject = (bo)this.hMh.get(paramInt1);
              this.hMk.add(localObject);
              com.tencent.mm.kernel.g.agU().az(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(43023);
                  new com.tencent.mm.modelsimple.ac(5, "", "", "", "", false, 1, false).doScene(i.a(i.this), new com.tencent.mm.ak.g()
                  {
                    public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
                    {
                      AppMethodBeat.i(43022);
                      paramAnonymous2n.setHasCallbackToQueue(true);
                      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(i.b(i.this).size()), paramAnonymous2String, Boolean.valueOf(i.c(i.this)), Integer.valueOf(i.d(i.this)) });
                      if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                      {
                        i.b(i.this).clear();
                        i.a(i.this, paramAnonymous2String);
                      }
                      for (;;)
                      {
                        i.f(i.this);
                        ab.iwp = false;
                        AppMethodBeat.o(43022);
                        return;
                        i.an(i.b(i.this));
                        i.e(i.this).onSceneEnd(4, -49, i.1.this.hMn, i.this);
                        i.ao(i.b(i.this));
                        i.b(i.this).clear();
                      }
                    }
                  });
                  AppMethodBeat.o(43023);
                }
              });
            }
          }
          pi(paramInt1);
          this.callback.onSceneEnd(4, ((buk)localObject).Ret, paramString, this);
          ph(paramInt1);
          AppMethodBeat.o(43034);
          return;
        }
        long l = ((bo)this.hMh.get(paramInt1)).field_msgId;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + ((buk)localObject).vTQ + " sent successfully!");
        bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(l);
        localbo.oz(((buk)localObject).vTQ);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(((buk)localObject).vTQ), Integer.valueOf(ab.ivH) });
        if ((10007 == ab.ivG) && (ab.ivH != 0))
        {
          localbo.oz(ab.ivH);
          ab.ivH = 0;
        }
        localbo.setStatus(2);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(l, localbo);
        if (this.hMh == null) {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
        }
        for (;;)
        {
          paramArrayOfByte.add(Integer.valueOf(paramInt1));
          if (1 != ((buk)localObject).ndI) {
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.a(11942, true, false, new Object[] { Long.valueOf(((buk)localObject).vTQ) });
          com.tencent.mm.plugin.report.e.wTc.a(11945, false, true, new Object[] { Long.valueOf(((buk)localObject).vTQ) });
          com.tencent.mm.plugin.report.e.wTc.a(11946, false, false, new Object[] { Long.valueOf(((buk)localObject).vTQ) });
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(90L, 0L, 1L, false);
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(90L, 1L, 1L, true);
          break;
          if ((paramInt1 >= this.hMh.size()) || (paramInt1 < 0))
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.hMh.size()) });
          }
          else
          {
            l = ((bo)this.hMh.get(paramInt1)).field_msgId;
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[] { Long.valueOf(l) });
            localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(l);
            sn localsn = new sn();
            localsn.dvz.cZc = localbo;
            a.GpY.l(localsn);
          }
        }
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[] { Integer.valueOf(paramInt1 - this.hMk.size()), Integer.valueOf(this.hMk.size()) });
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[] { Boolean.valueOf(this.hMj) });
    if (this.hMj)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43034);
      return;
    }
    CS(paramString);
    AppMethodBeat.o(43034);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(43028);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 254L, 1L, false);
    }
    AppMethodBeat.o(43028);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(43029);
    if (this.hMh.size() > 0)
    {
      paramq = n.b.hwa;
      AppMethodBeat.o(43029);
      return paramq;
    }
    paramq = n.b.hwb;
    AppMethodBeat.o(43029);
    return paramq;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.i
 * JD-Core Version:    0.7.0.1
 */