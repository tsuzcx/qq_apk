package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q.b;
import com.tencent.mm.cd.a;
import com.tencent.mm.f.a.va;
import com.tencent.mm.f.a.vc;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.edw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
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
  extends com.tencent.mm.an.q
  implements m
{
  private static final List<Object> lTn;
  private com.tencent.mm.an.i callback;
  private int lTm;
  private final List<ca> lTo;
  private int lTp;
  private boolean lTq;
  private final List<ca> lTr;
  private ca lTs;
  public com.tencent.mm.plugin.messenger.foundation.a.q lTt;
  public long msgId;
  private d rr;
  
  static
  {
    AppMethodBeat.i(43043);
    lTn = new ArrayList();
    AppMethodBeat.o(43043);
  }
  
  public i()
  {
    AppMethodBeat.i(43027);
    this.lTm = 15;
    this.lTo = new LinkedList();
    this.lTp = 3;
    this.lTq = false;
    this.lTr = new ArrayList();
    this.lTs = null;
    this.lTt = null;
    Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { Util.getStack() });
    Log.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(43027);
  }
  
  public i(long paramLong)
  {
    AppMethodBeat.i(43026);
    this.lTm = 15;
    this.lTo = new LinkedList();
    this.lTp = 3;
    this.lTq = false;
    this.lTr = new ArrayList();
    this.lTs = null;
    this.lTt = null;
    Log.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(paramLong)));
    this.msgId = paramLong;
    this.lTs = ((n)h.ae(n.class)).eSe().Oq(paramLong);
    if (this.lTs == null) {
      Log.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(43026);
  }
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43025);
    this.lTm = 15;
    this.lTo = new LinkedList();
    this.lTp = 3;
    this.lTq = false;
    this.lTr = new ArrayList();
    this.lTs = null;
    this.lTt = null;
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { Util.getStack() });
    }
    ca localca;
    if (!Util.isNullOrNil(paramString1))
    {
      localca = new ca();
      localca.setStatus(1);
      localca.Jm(paramString1);
      localca.setCreateTime(bq.RP(paramString1));
      localca.pJ(1);
      localca.setContent(paramString2);
      localca.setType(paramInt1);
      if ((paramInt2 == 1) && (paramInt1 == 42)) {
        localca.hzR();
      }
      String str = ((aa)h.ae(aa.class)).af(localca);
      if (!Util.isNullOrNil(str))
      {
        localca.Ip(str);
        Log.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localca.hxy });
      }
    }
    try
    {
      this.msgId = ((n)h.ae(n.class)).eSe().c(localca, true);
      if ((this.msgId != -1L) && (((l)h.ae(l.class)).aKT(paramString1))) {
        ((l)h.ae(l.class)).a(paramString1, z.bcZ(), paramString2, this.msgId);
      }
      if (this.msgId != -1L)
      {
        bool = true;
        Assert.assertTrue(bool);
        Log.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
        AppMethodBeat.o(43025);
        return;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        f.Iyx.idkeyStat(111L, 255L, 1L, false);
        if (!localSQLiteException.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        Log.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((n)h.ae(n.class)).eSe().eSo();
        this.msgId = ((n)h.ae(n.class)).eSe().c(localca, true);
      }
      AppMethodBeat.o(43025);
      throw localSQLiteException;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSendMsg", localIllegalStateException, "", new Object[0]);
        continue;
        boolean bool = false;
      }
    }
  }
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(43024);
    this.lTm = 15;
    this.lTo = new LinkedList();
    this.lTp = 3;
    this.lTq = false;
    this.lTr = new ArrayList();
    this.lTs = null;
    this.lTt = null;
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { Util.getStack() });
    }
    ca localca;
    if (!Util.isNullOrNil(paramString1))
    {
      localca = new ca();
      localca.setStatus(1);
      localca.Jm(paramString1);
      localca.setCreateTime(bq.RP(paramString1));
      localca.pJ(1);
      localca.setContent(paramString2);
      localca.setType(paramInt1);
      paramObject = a(((aa)h.ae(aa.class)).af(localca), paramObject, paramInt2);
      if (!Util.isNullOrNil(paramObject))
      {
        localca.Ip(paramObject);
        Log.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localca.hxy });
      }
      if (((paramInt2 & 0x4) == 0) && ((paramInt2 & 0x8) == 0)) {
        break label377;
      }
      if ((paramInt2 & 0x4) == 0) {
        break label372;
      }
      paramInt1 = 2;
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneSendMsg", "has paste fully flag, %d", new Object[] { Integer.valueOf(paramInt1) });
      paramObject = new HashMap();
      paramObject.put(".msgsource.alnode.cf", String.valueOf(paramInt1));
      bs.b(localca, bs.u(paramObject));
      try
      {
        label372:
        label377:
        do
        {
          this.msgId = ((n)h.ae(n.class)).eSe().c(localca, true);
          if (this.msgId != -1L) {
            break label576;
          }
          f.Iyx.idkeyStat(111L, 255L, 1L, false);
          if (this.msgId == -1L) {
            break label618;
          }
          bool = true;
          Assert.assertTrue(bool);
          Log.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
          AppMethodBeat.o(43024);
          return;
          paramInt1 = 3;
          break;
        } while (((paramInt2 & 0x10) == 0) && ((paramInt2 & 0x20) == 0));
        if ((paramInt2 & 0x10) != 0) {}
        for (paramInt1 = 4;; paramInt1 = 5)
        {
          Log.i("MicroMsg.NetSceneSendMsg", "has paste similar change flag, %d", new Object[] { Integer.valueOf(paramInt1) });
          paramObject = new HashMap();
          paramObject.put(".msgsource.alnode.cf", String.valueOf(paramInt1));
          bs.b(localca, bs.u(paramObject));
          break;
        }
      }
      catch (SQLiteException paramObject)
      {
        for (;;)
        {
          f.Iyx.idkeyStat(111L, 255L, 1L, false);
          if (!paramObject.toString().contains("UNIQUE constraint failed")) {
            break;
          }
          Log.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
          ((n)h.ae(n.class)).eSe().eSo();
          this.msgId = ((n)h.ae(n.class)).eSe().c(localca, true);
        }
        AppMethodBeat.o(43024);
        throw paramObject;
      }
      catch (IllegalStateException paramObject)
      {
        for (;;)
        {
          boolean bool;
          Log.printErrStackTrace("MicroMsg.NetSceneSendMsg", paramObject, "", new Object[0]);
          continue;
          label576:
          if (((l)h.ae(l.class)).aKT(paramString1))
          {
            ((l)h.ae(l.class)).a(paramString1, z.bcZ(), paramString2, this.msgId);
            continue;
            label618:
            bool = false;
          }
        }
      }
    }
  }
  
  private void WH(String paramString)
  {
    AppMethodBeat.i(43035);
    Log.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
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
  
  private static String a(String paramString, Object paramObject, int paramInt)
  {
    AppMethodBeat.i(163517);
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
      if ((Util.isNullOrNil(paramString)) || (paramString.startsWith("<msgsource>"))) {
        break;
      }
      Log.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[] { paramString });
      AppMethodBeat.o(163517);
      return paramString;
    }
    if (((paramInt & 0x1) != 0) && ((paramObject instanceof HashMap)))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (Util.isNullOrNil(paramString)) {
        localStringBuffer.append("<msgsource>");
      }
      paramObject = ((HashMap)paramObject).entrySet().iterator();
      while (paramObject.hasNext())
      {
        Object localObject = (Map.Entry)paramObject.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localObject = (String)((Map.Entry)localObject).getKey();
        if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject)))
        {
          Log.w("MicroMsg.NetSceneSendMsg", "%s %s", new Object[] { localObject, str });
        }
        else
        {
          localStringBuffer.append("<").append((String)localObject).append(">");
          localStringBuffer.append(str);
          localStringBuffer.append("</").append((String)localObject).append(">");
        }
      }
      if (Util.isNullOrNil(paramString))
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
  
  private static void ad(ca paramca)
  {
    AppMethodBeat.i(43033);
    va localva = new va();
    localva.fUo.fvt = paramca;
    EventCenter.instance.publish(localva);
    Log.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    AppMethodBeat.o(43033);
  }
  
  private static void ae(ca paramca)
  {
    AppMethodBeat.i(43038);
    paramca.setStatus(5);
    f.Iyx.idkeyStat(111L, 30L, 1L, true);
    ((n)h.ae(n.class)).eSe().a(paramca.field_msgId, paramca);
    paramca = lTn.iterator();
    while (paramca.hasNext()) {
      paramca.next();
    }
    AppMethodBeat.o(43038);
  }
  
  private void bne()
  {
    AppMethodBeat.i(238973);
    int i = 0;
    while (i < this.lTo.size())
    {
      wB(i);
      i += 1;
    }
    AppMethodBeat.o(238973);
  }
  
  private void bnf()
  {
    AppMethodBeat.i(43036);
    int i = 0;
    while (i < this.lTo.size())
    {
      wC(i);
      i += 1;
    }
    AppMethodBeat.o(43036);
  }
  
  private void wB(int paramInt)
  {
    AppMethodBeat.i(43032);
    if (this.lTo == null)
    {
      Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
      AppMethodBeat.o(43032);
      return;
    }
    if ((paramInt >= this.lTo.size()) || (paramInt < 0))
    {
      Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lTo.size()) });
      AppMethodBeat.o(43032);
      return;
    }
    ad((ca)this.lTo.get(paramInt));
    AppMethodBeat.o(43032);
  }
  
  private void wC(int paramInt)
  {
    AppMethodBeat.i(43037);
    ca localca = (ca)this.lTo.get(paramInt);
    Log.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[] { Long.valueOf(localca.field_msgId) });
    ae(localca);
    AppMethodBeat.o(43037);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(43031);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new edv();
    parami.lBV = new edw();
    parami.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    parami.funcId = 522;
    parami.lBW = 237;
    parami.respCmdId = 1000000237;
    this.rr = parami.bgN();
    edv localedv = (edv)d.b.b(this.rr.lBR);
    if (this.lTs == null) {
      parami = ((n)h.ae(n.class)).eSe().WC(this.lTm);
    }
    while ((parami == null) || (parami.size() == 0))
    {
      Log.w("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(43031);
      return -2;
      if (this.lTs.field_status != 5) {
        Log.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[] { Long.valueOf(this.lTs.field_msgId), Integer.valueOf(this.lTs.field_status) });
      }
      this.lTs.setStatus(1);
      ((n)h.ae(n.class)).eSe().a(this.msgId, this.lTs);
      parami = new ArrayList();
      parami.add(this.lTs);
      this.lTs = null;
    }
    this.lTo.clear();
    int i = 0;
    while (i < parami.size())
    {
      ca localca = (ca)parami.get(i);
      if (localca.field_isSend == 1)
      {
        cxi localcxi = new cxi();
        localcxi.RIE = new eaf().btQ(localca.field_talker);
        localcxi.CreateTime = ((int)(localca.field_createTime / 1000L));
        localcxi.rWu = localca.getType();
        localcxi.lpy = localca.field_content;
        localcxi.TFR = x.u(z.bcZ(), localca.field_createTime).hashCode();
        if (((v)h.ag(v.class)).ifAddTicketByActionFlag(localca.field_talker)) {
          localcxi.ScZ = ((n)h.ae(n.class)).bbL().bws(localca.field_talker);
        }
        if (this.lTt == null) {
          this.lTt = ((aa)h.ae(aa.class)).bnj();
        }
        Log.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[] { this.lTt });
        this.lTt.a(localcxi, localca);
        Log.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[] { localcxi.RII });
        localedv.rVy.add(localcxi);
        localedv.rVx = localedv.rVy.size();
        this.lTo.add(localca);
      }
      i += 1;
    }
    i = dispatch(paramg, this.rr, this);
    if (i < 0)
    {
      Log.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      bnf();
    }
    AppMethodBeat.o(43031);
    return i;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, final String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43034);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      f.Iyx.idkeyStat(111L, paramInt2 + 40, 1L, true);
      f.Iyx.idkeyStat(111L, 253L, 1L, false);
      if (paramInt3 == 413)
      {
        paramInt1 = d.b.b(this.rr.lBR).computeSize();
        int i = this.lTm / 2;
        Log.e("MicroMsg.NetSceneSendMsg", "send msgs req exceed max limit, size %s, sendMsgMaxNum %s, newSendMsgMaxNum %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.lTm), Integer.valueOf(i) });
        if (this.lTm == 1)
        {
          Log.e("MicroMsg.NetSceneSendMsg", "one msg exceed?????");
          bnf();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          bne();
          AppMethodBeat.o(43034);
          return;
        }
        this.lTm = i;
        WH(paramString);
        Log.d("MicroMsg.NetSceneSendMsg", "resend SENDING msg");
        AppMethodBeat.o(43034);
        return;
      }
      if ((paramInt2 == 3) || (paramInt2 == 9) || (paramInt2 == 7) || (paramInt2 == 8) || (paramInt2 == 1))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        Log.e("MicroMsg.NetSceneSendMsg", "Message delivery failed due to network reasons.");
        AppMethodBeat.o(43034);
        return;
      }
      bnf();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      bne();
      Log.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
      WH(paramString);
      AppMethodBeat.o(43034);
      return;
    }
    paramArrayOfByte = (edw)d.c.b(this.rr.lBS);
    params = paramArrayOfByte.rVy;
    ((v)h.ag(v.class)).setEnSendMsgActionFlag(paramArrayOfByte.Sda);
    paramArrayOfByte = new ArrayList();
    if (this.lTo.size() == params.size())
    {
      paramInt1 = 0;
      if (paramInt1 < params.size())
      {
        Object localObject = (cxj)params.get(paramInt1);
        if ((((cxj)localObject).CqV != 0) || (ac.mGv))
        {
          f.Iyx.idkeyStat(111L, 252L, 1L, false);
          if ((((cxj)localObject).CqV == -49) || (ac.mGv))
          {
            Log.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(((cxj)localObject).CqV), Integer.valueOf(paramInt1), Boolean.valueOf(ac.mGv), Integer.valueOf(this.lTp) });
            if (this.lTq)
            {
              localObject = (ca)this.lTo.get(paramInt1);
              this.lTr.add(localObject);
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (this.lTp < 0)
              {
                wC(paramInt1);
                this.callback.onSceneEnd(4, ((cxj)localObject).CqV, paramString, this);
                wB(paramInt1);
                AppMethodBeat.o(43034);
                return;
              }
              this.lTq = true;
              this.lTp -= 1;
              localObject = (ca)this.lTo.get(paramInt1);
              this.lTr.add(localObject);
              h.aHJ().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(43023);
                  new ad(5, "", "", "", "", false, 1, false).doScene(i.a(i.this), new com.tencent.mm.an.i()
                  {
                    public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.an.q paramAnonymous2q)
                    {
                      AppMethodBeat.i(43022);
                      paramAnonymous2q.setHasCallbackToQueue(true);
                      Log.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(i.b(i.this).size()), paramAnonymous2String, Boolean.valueOf(i.c(i.this)), Integer.valueOf(i.d(i.this)) });
                      if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                      {
                        i.b(i.this).clear();
                        i.a(i.this, paramAnonymous2String);
                      }
                      for (;;)
                      {
                        i.f(i.this);
                        ac.mGv = false;
                        AppMethodBeat.o(43022);
                        return;
                        i.av(i.b(i.this));
                        i.e(i.this).onSceneEnd(4, -49, i.1.this.lTu, i.this);
                        i.aw(i.b(i.this));
                        i.b(i.this).clear();
                      }
                    }
                  });
                  AppMethodBeat.o(43023);
                }
              });
            }
          }
          wC(paramInt1);
          this.callback.onSceneEnd(4, ((cxj)localObject).CqV, paramString, this);
          wB(paramInt1);
          AppMethodBeat.o(43034);
          return;
        }
        long l = ((ca)this.lTo.get(paramInt1)).field_msgId;
        Log.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + ((cxj)localObject).HlH + " sent successfully!");
        ca localca = ((n)h.ae(n.class)).eSe().Oq(l);
        localca.EG(((cxj)localObject).HlH);
        Log.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(((cxj)localObject).HlH), Integer.valueOf(ac.mFN) });
        if ((10007 == ac.mFM) && (ac.mFN != 0))
        {
          localca.EG(ac.mFN);
          ac.mFN = 0;
        }
        localca.setStatus(2);
        ((n)h.ae(n.class)).eSe().a(l, localca);
        if (this.lTo == null) {
          Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
        }
        for (;;)
        {
          paramArrayOfByte.add(Integer.valueOf(paramInt1));
          if (1 != ((cxj)localObject).rWu) {
            break;
          }
          f.Iyx.a(11942, true, false, new Object[] { Long.valueOf(((cxj)localObject).HlH) });
          f.Iyx.a(11945, false, true, new Object[] { Long.valueOf(((cxj)localObject).HlH) });
          f.Iyx.a(11946, false, false, new Object[] { Long.valueOf(((cxj)localObject).HlH) });
          f.Iyx.idkeyStat(90L, 0L, 1L, false);
          f.Iyx.idkeyStat(90L, 1L, 1L, true);
          break;
          if ((paramInt1 >= this.lTo.size()) || (paramInt1 < 0))
          {
            Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.lTo.size()) });
          }
          else
          {
            l = ((ca)this.lTo.get(paramInt1)).field_msgId;
            Log.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[] { Long.valueOf(l) });
            localca = ((n)h.ae(n.class)).eSe().Oq(l);
            vc localvc = new vc();
            localvc.fUq.fvt = localca;
            EventCenter.instance.publish(localvc);
          }
        }
      }
      Log.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[] { Integer.valueOf(paramInt1 - this.lTr.size()), Integer.valueOf(this.lTr.size()) });
    }
    Log.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[] { Boolean.valueOf(this.lTq) });
    if (this.lTq)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43034);
      return;
    }
    WH(paramString);
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
      f.Iyx.idkeyStat(111L, 254L, 1L, false);
    }
    AppMethodBeat.o(43028);
    return bool;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(43029);
    if (this.lTo.size() > 0)
    {
      params = q.b.lCx;
      AppMethodBeat.o(43029);
      return params;
    }
    params = q.b.lCy;
    AppMethodBeat.o(43029);
    return params;
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