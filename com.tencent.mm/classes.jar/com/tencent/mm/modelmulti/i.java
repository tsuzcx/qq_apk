package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
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
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private static final List<Object> hlD;
  private com.tencent.mm.al.g callback;
  private final List<bl> hlE;
  private int hlF;
  private boolean hlG;
  private final List<bl> hlH;
  private bl hlI;
  public com.tencent.mm.plugin.messenger.foundation.a.n hlJ;
  public long msgId;
  private b rr;
  
  static
  {
    AppMethodBeat.i(43043);
    hlD = new ArrayList();
    AppMethodBeat.o(43043);
  }
  
  public i()
  {
    AppMethodBeat.i(43027);
    this.hlE = new LinkedList();
    this.hlF = 3;
    this.hlG = false;
    this.hlH = new ArrayList();
    this.hlI = null;
    this.hlJ = null;
    ad.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bt.eGN() });
    ad.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(43027);
  }
  
  public i(long paramLong)
  {
    AppMethodBeat.i(43026);
    this.hlE = new LinkedList();
    this.hlF = 3;
    this.hlG = false;
    this.hlH = new ArrayList();
    this.hlI = null;
    this.hlJ = null;
    ad.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(paramLong)));
    this.msgId = paramLong;
    this.hlI = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramLong);
    if (this.hlI == null) {
      ad.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(43026);
  }
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43025);
    this.hlE = new LinkedList();
    this.hlF = 3;
    this.hlG = false;
    this.hlH = new ArrayList();
    this.hlI = null;
    this.hlJ = null;
    if (ad.getLogLevel() <= 1) {
      ad.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bt.eGN() });
    }
    bl localbl;
    if (!bt.isNullOrNil(paramString1))
    {
      localbl = new bl();
      localbl.setStatus(1);
      localbl.nY(paramString1);
      localbl.kY(bi.uj(paramString1));
      localbl.jV(1);
      localbl.setContent(paramString2);
      localbl.setType(paramInt1);
      if ((paramInt2 == 1) && (paramInt1 == 42)) {
        localbl.eMo();
      }
      String str = ((t)com.tencent.mm.kernel.g.ab(t.class)).N(localbl);
      if (!bt.isNullOrNil(str))
      {
        localbl.mZ(str);
        ad.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbl.esh });
      }
    }
    try
    {
      this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().c(localbl, true);
      if ((this.msgId != -1L) && (((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).adg(paramString1))) {
        ((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).a(paramString1, u.aqG(), paramString2, this.msgId);
      }
      if (this.msgId != -1L)
      {
        bool = true;
        Assert.assertTrue(bool);
        ad.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
        AppMethodBeat.o(43025);
        return;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 255L, 1L, false);
        if (!localSQLiteException.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        ad.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().cOR();
        this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().c(localbl, true);
      }
      AppMethodBeat.o(43025);
      throw localSQLiteException;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneSendMsg", localIllegalStateException, "", new Object[0]);
        continue;
        boolean bool = false;
      }
    }
  }
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(43024);
    this.hlE = new LinkedList();
    this.hlF = 3;
    this.hlG = false;
    this.hlH = new ArrayList();
    this.hlI = null;
    this.hlJ = null;
    if (ad.getLogLevel() <= 1) {
      ad.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bt.eGN() });
    }
    bl localbl;
    if (!bt.isNullOrNil(paramString1))
    {
      localbl = new bl();
      localbl.setStatus(1);
      localbl.nY(paramString1);
      localbl.kY(bi.uj(paramString1));
      localbl.jV(1);
      localbl.setContent(paramString2);
      localbl.setType(paramInt1);
      paramObject = a(((t)com.tencent.mm.kernel.g.ab(t.class)).N(localbl), paramObject, paramInt2);
      if (!bt.isNullOrNil(paramObject))
      {
        localbl.mZ(paramObject);
        ad.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbl.esh });
      }
      if ((paramInt2 & 0x2) != 0)
      {
        ad.i("MicroMsg.NetSceneSendMsg", "has paste fully flag");
        paramObject = new HashMap();
        paramObject.put(".msgsource.alnode.cf", "1");
        bk.b(localbl, bk.s(paramObject));
      }
    }
    try
    {
      this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().c(localbl, true);
      if (this.msgId == -1L)
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 255L, 1L, false);
        if (this.msgId == -1L) {
          break label490;
        }
        bool = true;
        Assert.assertTrue(bool);
        ad.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
        AppMethodBeat.o(43024);
      }
    }
    catch (SQLiteException paramObject)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 255L, 1L, false);
        if (!paramObject.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        ad.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().cOR();
        this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().c(localbl, true);
      }
      AppMethodBeat.o(43024);
      throw paramObject;
    }
    catch (IllegalStateException paramObject)
    {
      for (;;)
      {
        boolean bool;
        ad.printErrStackTrace("MicroMsg.NetSceneSendMsg", paramObject, "", new Object[0]);
        continue;
        if (((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).adg(paramString1))
        {
          ((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).a(paramString1, u.aqG(), paramString2, this.msgId);
          continue;
          label490:
          bool = false;
        }
      }
    }
  }
  
  private static void L(bl parambl)
  {
    AppMethodBeat.i(43033);
    sc localsc = new sc();
    localsc.dxL.dbD = parambl;
    a.ESL.l(localsc);
    ad.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[] { Long.valueOf(parambl.field_msgId) });
    AppMethodBeat.o(43033);
  }
  
  private static void M(bl parambl)
  {
    AppMethodBeat.i(43038);
    parambl.setStatus(5);
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 30L, 1L, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(parambl.field_msgId, parambl);
    parambl = hlD.iterator();
    while (parambl.hasNext()) {
      parambl.next();
    }
    AppMethodBeat.o(43038);
  }
  
  private static String a(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(163517);
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((bt.isNullOrNil(paramString)) || (paramString.startsWith("<msgsource>"))) {
        break;
      }
      ad.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramString });
      AppMethodBeat.o(163517);
      return paramString;
    }
    if (((paramInt & 0x1) != 0) && ((paramObject instanceof HashMap)))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (bt.isNullOrNil(paramString)) {
        localStringBuffer.append("<msgsource>");
      }
      paramObject = ((HashMap)paramObject).entrySet().iterator();
      while (paramObject.hasNext())
      {
        Object localObject = (Map.Entry)paramObject.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localObject = (String)((Map.Entry)localObject).getKey();
        if ((bt.isNullOrNil(str)) || (bt.isNullOrNil((String)localObject)))
        {
          ad.w("MicroMsg.NetSceneSendMsg", "%s %s", new Object[] { localObject, str });
        }
        else
        {
          localStringBuffer.append("<").append((String)localObject).append(">");
          localStringBuffer.append(str);
          localStringBuffer.append("</").append((String)localObject).append(">");
        }
      }
      if (bt.isNullOrNil(paramString))
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
  
  private void azp()
  {
    AppMethodBeat.i(43036);
    int i = 0;
    while (i < this.hlE.size())
    {
      ou(i);
      i += 1;
    }
    AppMethodBeat.o(43036);
  }
  
  private void ot(int paramInt)
  {
    AppMethodBeat.i(43032);
    if (this.hlE == null)
    {
      ad.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
      AppMethodBeat.o(43032);
      return;
    }
    if ((paramInt >= this.hlE.size()) || (paramInt < 0))
    {
      ad.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hlE.size()) });
      AppMethodBeat.o(43032);
      return;
    }
    L((bl)this.hlE.get(paramInt));
    AppMethodBeat.o(43032);
  }
  
  private void ou(int paramInt)
  {
    AppMethodBeat.i(43037);
    bl localbl = (bl)this.hlE.get(paramInt);
    ad.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[] { Long.valueOf(localbl.field_msgId) });
    M(localbl);
    AppMethodBeat.o(43037);
  }
  
  private void yN(String paramString)
  {
    AppMethodBeat.i(43035);
    ad.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(43031);
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new cpe();
    paramg.gUV = new cpf();
    paramg.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramg.funcId = 522;
    paramg.reqCmdId = 237;
    paramg.respCmdId = 1000000237;
    this.rr = paramg.atI();
    cpe localcpe = (cpe)this.rr.gUS.gUX;
    if (this.hlI == null) {
      paramg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().cOU();
    }
    while (paramg.size() == 0)
    {
      ad.w("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(43031);
      return -2;
      if (this.hlI.field_status != 5) {
        ad.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[] { Long.valueOf(this.hlI.field_msgId), Integer.valueOf(this.hlI.field_status) });
      }
      this.hlI.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.msgId, this.hlI);
      paramg = new ArrayList();
      paramg.add(this.hlI);
      this.hlI = null;
    }
    this.hlE.clear();
    int i = 0;
    while (i < paramg.size())
    {
      bl localbl = (bl)paramg.get(i);
      if (localbl.field_isSend == 1)
      {
        bps localbps = new bps();
        localbps.Cxy = new cmf().aEE(localbl.field_talker);
        localbps.CreateTime = ((int)(localbl.field_createTime / 1000L));
        localbps.mBH = localbl.getType();
        localbps.gKr = localbl.field_content;
        localbps.DOf = s.t(u.aqG(), localbl.field_createTime).hashCode();
        if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(localbl.field_talker)) {
          localbps.COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(localbl.field_talker);
        }
        if (this.hlJ == null) {
          this.hlJ = ((t)com.tencent.mm.kernel.g.ab(t.class)).azt();
        }
        ad.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[] { this.hlJ });
        this.hlJ.a(localbps, localbl);
        ad.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[] { localbps.CxC });
        localcpe.mAL.add(localbps);
        localcpe.mAK = localcpe.mAL.size();
        this.hlE.add(localbl);
      }
      i += 1;
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0)
    {
      ad.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      azp();
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
      ad.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, paramInt2 + 40, 1L, true);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 253L, 1L, false);
      if ((paramInt2 == 3) || (paramInt2 == 9) || (paramInt2 == 7) || (paramInt2 == 8) || (paramInt2 == 1))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        ad.e("MicroMsg.NetSceneSendMsg", "Message delivery failed due to network reasons.");
        AppMethodBeat.o(43034);
        return;
      }
      azp();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = 0;
      while (paramInt1 < this.hlE.size())
      {
        ot(paramInt1);
        paramInt1 += 1;
      }
      ad.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
      yN(paramString);
      AppMethodBeat.o(43034);
      return;
    }
    paramArrayOfByte = (cpf)this.rr.gUT.gUX;
    paramq = paramArrayOfByte.mAL;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramArrayOfByte.COU);
    paramArrayOfByte = new ArrayList();
    if (this.hlE.size() == paramq.size())
    {
      paramInt1 = 0;
      if (paramInt1 < paramq.size())
      {
        Object localObject = (bpt)paramq.get(paramInt1);
        if ((((bpt)localObject).Ret != 0) || (ab.hWl))
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 252L, 1L, false);
          if ((((bpt)localObject).Ret == -49) || (ab.hWl))
          {
            ad.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(((bpt)localObject).Ret), Integer.valueOf(paramInt1), Boolean.valueOf(ab.hWl), Integer.valueOf(this.hlF) });
            if (this.hlG)
            {
              localObject = (bl)this.hlE.get(paramInt1);
              this.hlH.add(localObject);
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (this.hlF < 0)
              {
                ou(paramInt1);
                this.callback.onSceneEnd(4, ((bpt)localObject).Ret, paramString, this);
                ot(paramInt1);
                AppMethodBeat.o(43034);
                return;
              }
              this.hlG = true;
              this.hlF -= 1;
              localObject = (bl)this.hlE.get(paramInt1);
              this.hlH.add(localObject);
              com.tencent.mm.kernel.g.afE().ax(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(43023);
                  new ac(5, "", "", "", "", false, 1, false).doScene(i.a(i.this), new com.tencent.mm.al.g()
                  {
                    public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
                    {
                      AppMethodBeat.i(43022);
                      paramAnonymous2n.setHasCallbackToQueue(true);
                      ad.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(i.b(i.this).size()), paramAnonymous2String, Boolean.valueOf(i.c(i.this)), Integer.valueOf(i.d(i.this)) });
                      if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                      {
                        i.b(i.this).clear();
                        i.a(i.this, paramAnonymous2String);
                      }
                      for (;;)
                      {
                        i.f(i.this);
                        ab.hWl = false;
                        AppMethodBeat.o(43022);
                        return;
                        i.aq(i.b(i.this));
                        i.e(i.this).onSceneEnd(4, -49, i.1.this.hlK, i.this);
                        i.ar(i.b(i.this));
                        i.b(i.this).clear();
                      }
                    }
                  });
                  AppMethodBeat.o(43023);
                }
              });
            }
          }
          ou(paramInt1);
          this.callback.onSceneEnd(4, ((bpt)localObject).Ret, paramString, this);
          ot(paramInt1);
          AppMethodBeat.o(43034);
          return;
        }
        long l = ((bl)this.hlE.get(paramInt1)).field_msgId;
        ad.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + ((bpt)localObject).uKZ + " sent successfully!");
        bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(l);
        localbl.kX(((bpt)localObject).uKZ);
        ad.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(((bpt)localObject).uKZ), Integer.valueOf(ab.hVD) });
        if ((10007 == ab.hVC) && (ab.hVD != 0))
        {
          localbl.kX(ab.hVD);
          ab.hVD = 0;
        }
        localbl.setStatus(2);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(l, localbl);
        if (this.hlE == null) {
          ad.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
        }
        for (;;)
        {
          paramArrayOfByte.add(Integer.valueOf(paramInt1));
          if (1 != ((bpt)localObject).mBH) {
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.a(11942, true, false, new Object[] { Long.valueOf(((bpt)localObject).uKZ) });
          com.tencent.mm.plugin.report.e.vIY.a(11945, false, true, new Object[] { Long.valueOf(((bpt)localObject).uKZ) });
          com.tencent.mm.plugin.report.e.vIY.a(11946, false, false, new Object[] { Long.valueOf(((bpt)localObject).uKZ) });
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(90L, 0L, 1L, false);
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(90L, 1L, 1L, true);
          break;
          if ((paramInt1 >= this.hlE.size()) || (paramInt1 < 0))
          {
            ad.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.hlE.size()) });
          }
          else
          {
            l = ((bl)this.hlE.get(paramInt1)).field_msgId;
            ad.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[] { Long.valueOf(l) });
            localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(l);
            se localse = new se();
            localse.dxN.dbD = localbl;
            a.ESL.l(localse);
          }
        }
      }
      ad.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[] { Integer.valueOf(paramInt1 - this.hlH.size()), Integer.valueOf(this.hlH.size()) });
    }
    ad.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[] { Boolean.valueOf(this.hlG) });
    if (this.hlG)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43034);
      return;
    }
    yN(paramString);
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
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 254L, 1L, false);
    }
    AppMethodBeat.o(43028);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(43029);
    if (this.hlE.size() > 0)
    {
      paramq = n.b.gVB;
      AppMethodBeat.o(43029);
      return paramq;
    }
    paramq = n.b.gVC;
    AppMethodBeat.o(43029);
    return paramq;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.i
 * JD-Core Version:    0.7.0.1
 */