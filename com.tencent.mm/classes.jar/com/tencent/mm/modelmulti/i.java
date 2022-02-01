package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
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
  private static final List<Object> ihT;
  private f callback;
  private int ihS;
  private final List<bv> ihU;
  private int ihV;
  private boolean ihW;
  private final List<bv> ihX;
  private bv ihY;
  public o ihZ;
  public long msgId;
  private b rr;
  
  static
  {
    AppMethodBeat.i(43043);
    ihT = new ArrayList();
    AppMethodBeat.o(43043);
  }
  
  public i()
  {
    AppMethodBeat.i(43027);
    this.ihS = 15;
    this.ihU = new LinkedList();
    this.ihV = 3;
    this.ihW = false;
    this.ihX = new ArrayList();
    this.ihY = null;
    this.ihZ = null;
    ae.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bu.fpN() });
    ae.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(43027);
  }
  
  public i(long paramLong)
  {
    AppMethodBeat.i(43026);
    this.ihS = 15;
    this.ihU = new LinkedList();
    this.ihV = 3;
    this.ihW = false;
    this.ihX = new ArrayList();
    this.ihY = null;
    this.ihZ = null;
    ae.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(paramLong)));
    this.msgId = paramLong;
    this.ihY = ((l)g.ab(l.class)).doJ().ys(paramLong);
    if (this.ihY == null) {
      ae.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(43026);
  }
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43025);
    this.ihS = 15;
    this.ihU = new LinkedList();
    this.ihV = 3;
    this.ihW = false;
    this.ihX = new ArrayList();
    this.ihY = null;
    this.ihZ = null;
    if (ae.getLogLevel() <= 1) {
      ae.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bu.fpN() });
    }
    bv localbv;
    if (!bu.isNullOrNil(paramString1))
    {
      localbv = new bv();
      localbv.setStatus(1);
      localbv.ui(paramString1);
      localbv.qN(bl.BQ(paramString1));
      localbv.kt(1);
      localbv.setContent(paramString2);
      localbv.setType(paramInt1);
      if ((paramInt2 == 1) && (paramInt1 == 42)) {
        localbv.fvX();
      }
      String str = ((w)g.ab(w.class)).Q(localbv);
      if (!bu.isNullOrNil(str))
      {
        localbv.tk(str);
        ae.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbv.eNd });
      }
    }
    try
    {
      this.msgId = ((l)g.ab(l.class)).doJ().c(localbv, true);
      if ((this.msgId != -1L) && (((j)g.ab(j.class)).anM(paramString1))) {
        ((j)g.ab(j.class)).a(paramString1, v.aAC(), paramString2, this.msgId);
      }
      if (this.msgId != -1L)
      {
        bool = true;
        Assert.assertTrue(bool);
        ae.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
        AppMethodBeat.o(43025);
        return;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 255L, 1L, false);
        if (!localSQLiteException.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        ae.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((l)g.ab(l.class)).doJ().doT();
        this.msgId = ((l)g.ab(l.class)).doJ().c(localbv, true);
      }
      AppMethodBeat.o(43025);
      throw localSQLiteException;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneSendMsg", localIllegalStateException, "", new Object[0]);
        continue;
        boolean bool = false;
      }
    }
  }
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(43024);
    this.ihS = 15;
    this.ihU = new LinkedList();
    this.ihV = 3;
    this.ihW = false;
    this.ihX = new ArrayList();
    this.ihY = null;
    this.ihZ = null;
    if (ae.getLogLevel() <= 1) {
      ae.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { bu.fpN() });
    }
    bv localbv;
    if (!bu.isNullOrNil(paramString1))
    {
      localbv = new bv();
      localbv.setStatus(1);
      localbv.ui(paramString1);
      localbv.qN(bl.BQ(paramString1));
      localbv.kt(1);
      localbv.setContent(paramString2);
      localbv.setType(paramInt1);
      paramObject = a(((w)g.ab(w.class)).Q(localbv), paramObject, paramInt2);
      if (!bu.isNullOrNil(paramObject))
      {
        localbv.tk(paramObject);
        ae.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localbv.eNd });
      }
      if ((paramInt2 & 0x2) != 0)
      {
        ae.i("MicroMsg.NetSceneSendMsg", "has paste fully flag");
        paramObject = new HashMap();
        paramObject.put(".msgsource.alnode.cf", "1");
        bn.b(localbv, bn.z(paramObject));
      }
    }
    try
    {
      this.msgId = ((l)g.ab(l.class)).doJ().c(localbv, true);
      if (this.msgId == -1L)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 255L, 1L, false);
        if (this.msgId == -1L) {
          break label497;
        }
        bool = true;
        Assert.assertTrue(bool);
        ae.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
        AppMethodBeat.o(43024);
      }
    }
    catch (SQLiteException paramObject)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 255L, 1L, false);
        if (!paramObject.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        ae.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((l)g.ab(l.class)).doJ().doT();
        this.msgId = ((l)g.ab(l.class)).doJ().c(localbv, true);
      }
      AppMethodBeat.o(43024);
      throw paramObject;
    }
    catch (IllegalStateException paramObject)
    {
      for (;;)
      {
        boolean bool;
        ae.printErrStackTrace("MicroMsg.NetSceneSendMsg", paramObject, "", new Object[0]);
        continue;
        if (((j)g.ab(j.class)).anM(paramString1))
        {
          ((j)g.ab(j.class)).a(paramString1, v.aAC(), paramString2, this.msgId);
          continue;
          label497:
          bool = false;
        }
      }
    }
  }
  
  private void Gy(String paramString)
  {
    AppMethodBeat.i(43035);
    ae.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
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
  
  private static void O(bv parambv)
  {
    AppMethodBeat.i(43033);
    sz localsz = new sz();
    localsz.dIE.dlw = parambv;
    com.tencent.mm.sdk.b.a.IvT.l(localsz);
    ae.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[] { Long.valueOf(parambv.field_msgId) });
    AppMethodBeat.o(43033);
  }
  
  private static void P(bv parambv)
  {
    AppMethodBeat.i(43038);
    parambv.setStatus(5);
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 30L, 1L, true);
    ((l)g.ab(l.class)).doJ().a(parambv.field_msgId, parambv);
    parambv = ihT.iterator();
    while (parambv.hasNext()) {
      parambv.next();
    }
    AppMethodBeat.o(43038);
  }
  
  private static String a(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(163517);
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((bu.isNullOrNil(paramString)) || (paramString.startsWith("<msgsource>"))) {
        break;
      }
      ae.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramString });
      AppMethodBeat.o(163517);
      return paramString;
    }
    if (((paramInt & 0x1) != 0) && ((paramObject instanceof HashMap)))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (bu.isNullOrNil(paramString)) {
        localStringBuffer.append("<msgsource>");
      }
      paramObject = ((HashMap)paramObject).entrySet().iterator();
      while (paramObject.hasNext())
      {
        Object localObject = (Map.Entry)paramObject.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localObject = (String)((Map.Entry)localObject).getKey();
        if ((bu.isNullOrNil(str)) || (bu.isNullOrNil((String)localObject)))
        {
          ae.w("MicroMsg.NetSceneSendMsg", "%s %s", new Object[] { localObject, str });
        }
        else
        {
          localStringBuffer.append("<").append((String)localObject).append(">");
          localStringBuffer.append(str);
          localStringBuffer.append("</").append((String)localObject).append(">");
        }
      }
      if (bu.isNullOrNil(paramString))
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
  
  private void aJH()
  {
    AppMethodBeat.i(213418);
    int i = 0;
    while (i < this.ihU.size())
    {
      pN(i);
      i += 1;
    }
    AppMethodBeat.o(213418);
  }
  
  private void aJI()
  {
    AppMethodBeat.i(43036);
    int i = 0;
    while (i < this.ihU.size())
    {
      pO(i);
      i += 1;
    }
    AppMethodBeat.o(43036);
  }
  
  private void pN(int paramInt)
  {
    AppMethodBeat.i(43032);
    if (this.ihU == null)
    {
      ae.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
      AppMethodBeat.o(43032);
      return;
    }
    if ((paramInt >= this.ihU.size()) || (paramInt < 0))
    {
      ae.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ihU.size()) });
      AppMethodBeat.o(43032);
      return;
    }
    O((bv)this.ihU.get(paramInt));
    AppMethodBeat.o(43032);
  }
  
  private void pO(int paramInt)
  {
    AppMethodBeat.i(43037);
    bv localbv = (bv)this.ihU.get(paramInt);
    ae.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[] { Long.valueOf(localbv.field_msgId) });
    P(localbv);
    AppMethodBeat.o(43037);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(43031);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new dap();
    paramf.hQG = new daq();
    paramf.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramf.funcId = 522;
    paramf.hQH = 237;
    paramf.respCmdId = 1000000237;
    this.rr = paramf.aDS();
    dap localdap = (dap)this.rr.hQD.hQJ;
    if (this.ihY == null) {
      paramf = ((l)g.ab(l.class)).doJ().Kn(this.ihS);
    }
    while ((paramf == null) || (paramf.size() == 0))
    {
      ae.w("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(43031);
      return -2;
      if (this.ihY.field_status != 5) {
        ae.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[] { Long.valueOf(this.ihY.field_msgId), Integer.valueOf(this.ihY.field_status) });
      }
      this.ihY.setStatus(1);
      ((l)g.ab(l.class)).doJ().a(this.msgId, this.ihY);
      paramf = new ArrayList();
      paramf.add(this.ihY);
      this.ihY = null;
    }
    this.ihU.clear();
    int i = 0;
    while (i < paramf.size())
    {
      bv localbv = (bv)paramf.get(i);
      if (localbv.field_isSend == 1)
      {
        bzs localbzs = new bzs();
        localbzs.FNH = new cxn().aQV(localbv.field_talker);
        localbzs.CreateTime = ((int)(localbv.field_createTime / 1000L));
        localbzs.nJA = localbv.getType();
        localbzs.hFS = localbv.field_content;
        localbzs.HnF = t.w(v.aAC(), localbv.field_createTime).hashCode();
        if (((s)g.ad(s.class)).ifAddTicketByActionFlag(localbv.field_talker)) {
          localbzs.Ghk = ((l)g.ab(l.class)).azF().aUV(localbv.field_talker);
        }
        if (this.ihZ == null) {
          this.ihZ = ((w)g.ab(w.class)).aJM();
        }
        ae.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[] { this.ihZ });
        this.ihZ.a(localbzs, localbv);
        ae.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[] { localbzs.FNL });
        localdap.nIE.add(localbzs);
        localdap.nID = localdap.nIE.size();
        this.ihU.add(localbv);
      }
      i += 1;
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0)
    {
      ae.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      aJI();
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
      ae.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, paramInt2 + 40, 1L, true);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 253L, 1L, false);
      if (paramInt3 == 413)
      {
        paramInt1 = this.rr.hQD.hQJ.computeSize();
        int i = this.ihS / 2;
        ae.e("MicroMsg.NetSceneSendMsg", "send msgs req exceed max limit, size %s, sendMsgMaxNum %s, newSendMsgMaxNum %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.ihS), Integer.valueOf(i) });
        if (this.ihS == 1)
        {
          ae.e("MicroMsg.NetSceneSendMsg", "one msg exceed?????");
          aJI();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          aJH();
          AppMethodBeat.o(43034);
          return;
        }
        this.ihS = i;
        Gy(paramString);
        ae.d("MicroMsg.NetSceneSendMsg", "resend SENDING msg");
        AppMethodBeat.o(43034);
        return;
      }
      if ((paramInt2 == 3) || (paramInt2 == 9) || (paramInt2 == 7) || (paramInt2 == 8) || (paramInt2 == 1))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        ae.e("MicroMsg.NetSceneSendMsg", "Message delivery failed due to network reasons.");
        AppMethodBeat.o(43034);
        return;
      }
      aJI();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      aJH();
      ae.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
      Gy(paramString);
      AppMethodBeat.o(43034);
      return;
    }
    paramArrayOfByte = (daq)this.rr.hQE.hQJ;
    paramq = paramArrayOfByte.nIE;
    ((s)g.ad(s.class)).setEnSendMsgActionFlag(paramArrayOfByte.Ghl);
    paramArrayOfByte = new ArrayList();
    if (this.ihU.size() == paramq.size())
    {
      paramInt1 = 0;
      if (paramInt1 < paramq.size())
      {
        Object localObject = (bzt)paramq.get(paramInt1);
        if ((((bzt)localObject).Ret != 0) || (ac.iSq))
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 252L, 1L, false);
          if ((((bzt)localObject).Ret == -49) || (ac.iSq))
          {
            ae.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(((bzt)localObject).Ret), Integer.valueOf(paramInt1), Boolean.valueOf(ac.iSq), Integer.valueOf(this.ihV) });
            if (this.ihW)
            {
              localObject = (bv)this.ihU.get(paramInt1);
              this.ihX.add(localObject);
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (this.ihV < 0)
              {
                pO(paramInt1);
                this.callback.onSceneEnd(4, ((bzt)localObject).Ret, paramString, this);
                pN(paramInt1);
                AppMethodBeat.o(43034);
                return;
              }
              this.ihW = true;
              this.ihV -= 1;
              localObject = (bv)this.ihU.get(paramInt1);
              this.ihX.add(localObject);
              g.ajU().aw(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(43023);
                  new ad(5, "", "", "", "", false, 1, false).doScene(i.a(i.this), new f()
                  {
                    public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
                    {
                      AppMethodBeat.i(43022);
                      paramAnonymous2n.setHasCallbackToQueue(true);
                      ae.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(i.b(i.this).size()), paramAnonymous2String, Boolean.valueOf(i.c(i.this)), Integer.valueOf(i.d(i.this)) });
                      if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                      {
                        i.b(i.this).clear();
                        i.a(i.this, paramAnonymous2String);
                      }
                      for (;;)
                      {
                        i.f(i.this);
                        ac.iSq = false;
                        AppMethodBeat.o(43022);
                        return;
                        i.ao(i.b(i.this));
                        i.e(i.this).onSceneEnd(4, -49, i.1.this.iia, i.this);
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
          pO(paramInt1);
          this.callback.onSceneEnd(4, ((bzt)localObject).Ret, paramString, this);
          pN(paramInt1);
          AppMethodBeat.o(43034);
          return;
        }
        long l = ((bv)this.ihU.get(paramInt1)).field_msgId;
        ae.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + ((bzt)localObject).xrk + " sent successfully!");
        bv localbv = ((l)g.ab(l.class)).doJ().ys(l);
        localbv.qM(((bzt)localObject).xrk);
        ae.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(((bzt)localObject).xrk), Integer.valueOf(ac.iRI) });
        if ((10007 == ac.iRH) && (ac.iRI != 0))
        {
          localbv.qM(ac.iRI);
          ac.iRI = 0;
        }
        localbv.setStatus(2);
        ((l)g.ab(l.class)).doJ().a(l, localbv);
        if (this.ihU == null) {
          ae.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
        }
        for (;;)
        {
          paramArrayOfByte.add(Integer.valueOf(paramInt1));
          if (1 != ((bzt)localObject).nJA) {
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.a(11942, true, false, new Object[] { Long.valueOf(((bzt)localObject).xrk) });
          com.tencent.mm.plugin.report.e.ywz.a(11945, false, true, new Object[] { Long.valueOf(((bzt)localObject).xrk) });
          com.tencent.mm.plugin.report.e.ywz.a(11946, false, false, new Object[] { Long.valueOf(((bzt)localObject).xrk) });
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(90L, 0L, 1L, false);
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(90L, 1L, 1L, true);
          break;
          if ((paramInt1 >= this.ihU.size()) || (paramInt1 < 0))
          {
            ae.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.ihU.size()) });
          }
          else
          {
            l = ((bv)this.ihU.get(paramInt1)).field_msgId;
            ae.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[] { Long.valueOf(l) });
            localbv = ((l)g.ab(l.class)).doJ().ys(l);
            tb localtb = new tb();
            localtb.dIG.dlw = localbv;
            com.tencent.mm.sdk.b.a.IvT.l(localtb);
          }
        }
      }
      ae.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[] { Integer.valueOf(paramInt1 - this.ihX.size()), Integer.valueOf(this.ihX.size()) });
    }
    ae.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[] { Boolean.valueOf(this.ihW) });
    if (this.ihW)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43034);
      return;
    }
    Gy(paramString);
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
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 254L, 1L, false);
    }
    AppMethodBeat.o(43028);
    return bool;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(43029);
    if (this.ihU.size() > 0)
    {
      paramq = n.b.hRi;
      AppMethodBeat.o(43029);
      return paramq;
    }
    paramq = n.b.hRj;
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