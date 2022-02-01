package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
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
  extends n
  implements k
{
  private static final List<Object> ifa;
  private f callback;
  private final List<bu> ifb;
  private int ifc;
  private boolean ifd;
  private final List<bu> ife;
  private bu iff;
  public o ifg;
  public long msgId;
  private b rr;
  
  static
  {
    AppMethodBeat.i(43043);
    ifa = new ArrayList();
    AppMethodBeat.o(43043);
  }
  
  public i()
  {
    AppMethodBeat.i(43027);
    this.ifb = new LinkedList();
    this.ifc = 3;
    this.ifd = false;
    this.ife = new ArrayList();
    this.iff = null;
    this.ifg = null;
    ad.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bt.flS() });
    ad.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(43027);
  }
  
  public i(long paramLong)
  {
    AppMethodBeat.i(43026);
    this.ifb = new LinkedList();
    this.ifc = 3;
    this.ifd = false;
    this.ife = new ArrayList();
    this.iff = null;
    this.ifg = null;
    ad.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(paramLong)));
    this.msgId = paramLong;
    this.iff = ((l)g.ab(l.class)).dlK().xY(paramLong);
    if (this.iff == null) {
      ad.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(43026);
  }
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43025);
    this.ifb = new LinkedList();
    this.ifc = 3;
    this.ifd = false;
    this.ife = new ArrayList();
    this.iff = null;
    this.ifg = null;
    if (ad.getLogLevel() <= 1) {
      ad.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bt.flS() });
    }
    bu localbu;
    if (!bt.isNullOrNil(paramString1))
    {
      localbu = new bu();
      localbu.setStatus(1);
      localbu.tN(paramString1);
      localbu.qA(bj.Bo(paramString1));
      localbu.kr(1);
      localbu.setContent(paramString2);
      localbu.setType(paramInt1);
      if ((paramInt2 == 1) && (paramInt1 == 42)) {
        localbu.frW();
      }
      String str = ((v)g.ab(v.class)).Q(localbu);
      if (!bt.isNullOrNil(str))
      {
        localbu.sP(str);
        ad.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbu.eLs });
      }
    }
    try
    {
      this.msgId = ((l)g.ab(l.class)).dlK().c(localbu, true);
      if ((this.msgId != -1L) && (((j)g.ab(j.class)).amL(paramString1))) {
        ((j)g.ab(j.class)).a(paramString1, u.aAm(), paramString2, this.msgId);
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
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 255L, 1L, false);
        if (!localSQLiteException.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        ad.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((l)g.ab(l.class)).dlK().dlU();
        this.msgId = ((l)g.ab(l.class)).dlK().c(localbu, true);
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
    this.ifb = new LinkedList();
    this.ifc = 3;
    this.ifd = false;
    this.ife = new ArrayList();
    this.iff = null;
    this.ifg = null;
    if (ad.getLogLevel() <= 1) {
      ad.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bt.flS() });
    }
    bu localbu;
    if (!bt.isNullOrNil(paramString1))
    {
      localbu = new bu();
      localbu.setStatus(1);
      localbu.tN(paramString1);
      localbu.qA(bj.Bo(paramString1));
      localbu.kr(1);
      localbu.setContent(paramString2);
      localbu.setType(paramInt1);
      paramObject = a(((v)g.ab(v.class)).Q(localbu), paramObject, paramInt2);
      if (!bt.isNullOrNil(paramObject))
      {
        localbu.sP(paramObject);
        ad.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbu.eLs });
      }
      if ((paramInt2 & 0x2) != 0)
      {
        ad.i("MicroMsg.NetSceneSendMsg", "has paste fully flag");
        paramObject = new HashMap();
        paramObject.put(".msgsource.alnode.cf", "1");
        bl.b(localbu, bl.s(paramObject));
      }
    }
    try
    {
      this.msgId = ((l)g.ab(l.class)).dlK().c(localbu, true);
      if (this.msgId == -1L)
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 255L, 1L, false);
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
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 255L, 1L, false);
        if (!paramObject.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        ad.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((l)g.ab(l.class)).dlK().dlU();
        this.msgId = ((l)g.ab(l.class)).dlK().c(localbu, true);
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
        if (((j)g.ab(j.class)).amL(paramString1))
        {
          ((j)g.ab(j.class)).a(paramString1, u.aAm(), paramString2, this.msgId);
          continue;
          label490:
          bool = false;
        }
      }
    }
  }
  
  private void FW(String paramString)
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
  
  private static void O(bu parambu)
  {
    AppMethodBeat.i(43033);
    sy localsy = new sy();
    localsy.dHA.dku = parambu;
    a.IbL.l(localsy);
    ad.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[] { Long.valueOf(parambu.field_msgId) });
    AppMethodBeat.o(43033);
  }
  
  private static void P(bu parambu)
  {
    AppMethodBeat.i(43038);
    parambu.setStatus(5);
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 30L, 1L, true);
    ((l)g.ab(l.class)).dlK().a(parambu.field_msgId, parambu);
    parambu = ifa.iterator();
    while (parambu.hasNext()) {
      parambu.next();
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
  
  private void aJp()
  {
    AppMethodBeat.i(43036);
    int i = 0;
    while (i < this.ifb.size())
    {
      pL(i);
      i += 1;
    }
    AppMethodBeat.o(43036);
  }
  
  private void pK(int paramInt)
  {
    AppMethodBeat.i(43032);
    if (this.ifb == null)
    {
      ad.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
      AppMethodBeat.o(43032);
      return;
    }
    if ((paramInt >= this.ifb.size()) || (paramInt < 0))
    {
      ad.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ifb.size()) });
      AppMethodBeat.o(43032);
      return;
    }
    O((bu)this.ifb.get(paramInt));
    AppMethodBeat.o(43032);
  }
  
  private void pL(int paramInt)
  {
    AppMethodBeat.i(43037);
    bu localbu = (bu)this.ifb.get(paramInt);
    ad.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[] { Long.valueOf(localbu.field_msgId) });
    P(localbu);
    AppMethodBeat.o(43037);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(43031);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new czv();
    paramf.hNN = new czw();
    paramf.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramf.funcId = 522;
    paramf.hNO = 237;
    paramf.respCmdId = 1000000237;
    this.rr = paramf.aDC();
    czv localczv = (czv)this.rr.hNK.hNQ;
    if (this.iff == null) {
      paramf = ((l)g.ab(l.class)).dlK().dlX();
    }
    while (paramf.size() == 0)
    {
      ad.w("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(43031);
      return -2;
      if (this.iff.field_status != 5) {
        ad.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[] { Long.valueOf(this.iff.field_msgId), Integer.valueOf(this.iff.field_status) });
      }
      this.iff.setStatus(1);
      ((l)g.ab(l.class)).dlK().a(this.msgId, this.iff);
      paramf = new ArrayList();
      paramf.add(this.iff);
      this.iff = null;
    }
    this.ifb.clear();
    int i = 0;
    while (i < paramf.size())
    {
      bu localbu = (bu)paramf.get(i);
      if (localbu.field_isSend == 1)
      {
        byy localbyy = new byy();
        localbyy.Fvj = new cwt().aPy(localbu.field_talker);
        localbyy.CreateTime = ((int)(localbu.field_createTime / 1000L));
        localbyy.nEf = localbu.getType();
        localbyy.hDa = localbu.field_content;
        localbyy.GUe = s.w(u.aAm(), localbu.field_createTime).hashCode();
        if (((r)g.ad(r.class)).ifAddTicketByActionFlag(localbu.field_talker)) {
          localbyy.FOL = ((l)g.ab(l.class)).azp().aTu(localbu.field_talker);
        }
        if (this.ifg == null) {
          this.ifg = ((v)g.ab(v.class)).aJt();
        }
        ad.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[] { this.ifg });
        this.ifg.a(localbyy, localbu);
        ad.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[] { localbyy.Fvn });
        localczv.nDj.add(localbyy);
        localczv.nDi = localczv.nDj.size();
        this.ifb.add(localbu);
      }
      i += 1;
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0)
    {
      ad.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      aJp();
    }
    AppMethodBeat.o(43031);
    return i;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, final String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43034);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, paramInt2 + 40, 1L, true);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 253L, 1L, false);
      if ((paramInt2 == 3) || (paramInt2 == 9) || (paramInt2 == 7) || (paramInt2 == 8) || (paramInt2 == 1))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        ad.e("MicroMsg.NetSceneSendMsg", "Message delivery failed due to network reasons.");
        AppMethodBeat.o(43034);
        return;
      }
      aJp();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramInt1 = 0;
      while (paramInt1 < this.ifb.size())
      {
        pK(paramInt1);
        paramInt1 += 1;
      }
      ad.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
      FW(paramString);
      AppMethodBeat.o(43034);
      return;
    }
    paramArrayOfByte = (czw)this.rr.hNL.hNQ;
    paramq = paramArrayOfByte.nDj;
    ((r)g.ad(r.class)).setEnSendMsgActionFlag(paramArrayOfByte.FOM);
    paramArrayOfByte = new ArrayList();
    if (this.ifb.size() == paramq.size())
    {
      paramInt1 = 0;
      if (paramInt1 < paramq.size())
      {
        Object localObject = (byz)paramq.get(paramInt1);
        if ((((byz)localObject).Ret != 0) || (com.tencent.mm.platformtools.ac.iPx))
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 252L, 1L, false);
          if ((((byz)localObject).Ret == -49) || (com.tencent.mm.platformtools.ac.iPx))
          {
            ad.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(((byz)localObject).Ret), Integer.valueOf(paramInt1), Boolean.valueOf(com.tencent.mm.platformtools.ac.iPx), Integer.valueOf(this.ifc) });
            if (this.ifd)
            {
              localObject = (bu)this.ifb.get(paramInt1);
              this.ife.add(localObject);
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (this.ifc < 0)
              {
                pL(paramInt1);
                this.callback.onSceneEnd(4, ((byz)localObject).Ret, paramString, this);
                pK(paramInt1);
                AppMethodBeat.o(43034);
                return;
              }
              this.ifd = true;
              this.ifc -= 1;
              localObject = (bu)this.ifb.get(paramInt1);
              this.ife.add(localObject);
              g.ajF().ay(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(43023);
                  new com.tencent.mm.modelsimple.ac(5, "", "", "", "", false, 1, false).doScene(i.a(i.this), new f()
                  {
                    public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
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
                        com.tencent.mm.platformtools.ac.iPx = false;
                        AppMethodBeat.o(43022);
                        return;
                        i.ao(i.b(i.this));
                        i.e(i.this).onSceneEnd(4, -49, i.1.this.ifh, i.this);
                        i.ap(i.b(i.this));
                        i.b(i.this).clear();
                      }
                    }
                  });
                  AppMethodBeat.o(43023);
                }
              });
            }
          }
          pL(paramInt1);
          this.callback.onSceneEnd(4, ((byz)localObject).Ret, paramString, this);
          pK(paramInt1);
          AppMethodBeat.o(43034);
          return;
        }
        long l = ((bu)this.ifb.get(paramInt1)).field_msgId;
        ad.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + ((byz)localObject).xbt + " sent successfully!");
        bu localbu = ((l)g.ab(l.class)).dlK().xY(l);
        localbu.qz(((byz)localObject).xbt);
        ad.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(((byz)localObject).xbt), Integer.valueOf(com.tencent.mm.platformtools.ac.iOO) });
        if ((10007 == com.tencent.mm.platformtools.ac.iON) && (com.tencent.mm.platformtools.ac.iOO != 0))
        {
          localbu.qz(com.tencent.mm.platformtools.ac.iOO);
          com.tencent.mm.platformtools.ac.iOO = 0;
        }
        localbu.setStatus(2);
        ((l)g.ab(l.class)).dlK().a(l, localbu);
        if (this.ifb == null) {
          ad.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
        }
        for (;;)
        {
          paramArrayOfByte.add(Integer.valueOf(paramInt1));
          if (1 != ((byz)localObject).nEf) {
            break;
          }
          com.tencent.mm.plugin.report.e.ygI.a(11942, true, false, new Object[] { Long.valueOf(((byz)localObject).xbt) });
          com.tencent.mm.plugin.report.e.ygI.a(11945, false, true, new Object[] { Long.valueOf(((byz)localObject).xbt) });
          com.tencent.mm.plugin.report.e.ygI.a(11946, false, false, new Object[] { Long.valueOf(((byz)localObject).xbt) });
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(90L, 0L, 1L, false);
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(90L, 1L, 1L, true);
          break;
          if ((paramInt1 >= this.ifb.size()) || (paramInt1 < 0))
          {
            ad.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.ifb.size()) });
          }
          else
          {
            l = ((bu)this.ifb.get(paramInt1)).field_msgId;
            ad.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[] { Long.valueOf(l) });
            localbu = ((l)g.ab(l.class)).dlK().xY(l);
            ta localta = new ta();
            localta.dHC.dku = localbu;
            a.IbL.l(localta);
          }
        }
      }
      ad.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[] { Integer.valueOf(paramInt1 - this.ife.size()), Integer.valueOf(this.ife.size()) });
    }
    ad.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[] { Boolean.valueOf(this.ifd) });
    if (this.ifd)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43034);
      return;
    }
    FW(paramString);
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
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 254L, 1L, false);
    }
    AppMethodBeat.o(43028);
    return bool;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(43029);
    if (this.ifb.size() > 0)
    {
      paramq = n.b.hOp;
      AppMethodBeat.o(43029);
      return paramq;
    }
    paramq = n.b.hOq;
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