package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.wq;
import com.tencent.mm.autogen.a.ws;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.exm;
import com.tencent.mm.protocal.protobuf.exn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
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

public final class n
  extends p
  implements m
{
  private static final List<Object> oMg;
  private com.tencent.mm.am.h callback;
  public long msgId;
  private int oMf;
  private final List<cc> oMh;
  private int oMi;
  private boolean oMj;
  private final List<cc> oMk;
  private cc oMl;
  public q oMm;
  private c rr;
  
  static
  {
    AppMethodBeat.i(43043);
    oMg = new ArrayList();
    AppMethodBeat.o(43043);
  }
  
  public n()
  {
    AppMethodBeat.i(43027);
    this.oMf = 15;
    this.oMh = new LinkedList();
    this.oMi = 3;
    this.oMj = false;
    this.oMk = new ArrayList();
    this.oMl = null;
    this.oMm = null;
    Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { Util.getStack() });
    Log.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(43027);
  }
  
  public n(long paramLong)
  {
    AppMethodBeat.i(43026);
    this.oMf = 15;
    this.oMh = new LinkedList();
    this.oMi = 3;
    this.oMj = false;
    this.oMk = new ArrayList();
    this.oMl = null;
    this.oMm = null;
    Log.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(paramLong)));
    this.msgId = paramLong;
    this.oMl = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramLong);
    if (this.oMl == null) {
      Log.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(43026);
  }
  
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43025);
    this.oMf = 15;
    this.oMh = new LinkedList();
    this.oMi = 3;
    this.oMj = false;
    this.oMk = new ArrayList();
    this.oMl = null;
    this.oMm = null;
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { Util.getStack() });
    }
    cc localcc;
    if (!Util.isNullOrNil(paramString1))
    {
      localcc = new cc();
      localcc.setStatus(1);
      localcc.BS(paramString1);
      localcc.setCreateTime(br.JN(paramString1));
      localcc.pI(1);
      localcc.setContent(paramString2);
      localcc.setType(paramInt1);
      if ((paramInt2 == 1) && (paramInt1 == 42)) {
        localcc.jbW();
      }
      String str = ((aa)com.tencent.mm.kernel.h.ax(aa.class)).ak(localcc);
      if (!Util.isNullOrNil(str))
      {
        localcc.AU(str);
        Log.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localcc.jUr });
      }
    }
    try
    {
      this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().c(localcc, true);
      if ((this.msgId != -1L) && (((l)com.tencent.mm.kernel.h.ax(l.class)).aHK(paramString1))) {
        ((l)com.tencent.mm.kernel.h.ax(l.class)).b(paramString1, com.tencent.mm.model.z.bAM(), paramString2, this.msgId);
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
        f.Ozc.idkeyStat(111L, 255L, 1L, false);
        if (!localSQLiteException.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        Log.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().gbj();
        this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().c(localcc, true);
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
  
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(43024);
    this.oMf = 15;
    this.oMh = new LinkedList();
    this.oMi = 3;
    this.oMj = false;
    this.oMk = new ArrayList();
    this.oMl = null;
    this.oMm = null;
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { Util.getStack() });
    }
    cc localcc;
    Object localObject;
    if (!Util.isNullOrNil(paramString1))
    {
      localcc = new cc();
      localcc.setStatus(1);
      localcc.BS(paramString1);
      localcc.setCreateTime(br.JN(paramString1));
      localcc.pI(1);
      localcc.setContent(paramString2);
      localcc.setType(paramInt1);
      localObject = a(((aa)com.tencent.mm.kernel.h.ax(aa.class)).ak(localcc), paramObject, paramInt2);
      if (!Util.isNullOrNil((String)localObject))
      {
        localcc.AU((String)localObject);
        Log.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localcc.jUr });
      }
      if (((paramInt2 & 0x4) == 0) && ((paramInt2 & 0x8) == 0)) {
        break label410;
      }
      if ((paramInt2 & 0x4) == 0) {
        break label405;
      }
      paramInt1 = 2;
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneSendMsg", "has paste fully flag, %d", new Object[] { Integer.valueOf(paramInt1) });
      localObject = new HashMap();
      ((Map)localObject).put(".msgsource.alnode.cf", String.valueOf(paramInt1));
      if ((paramObject instanceof HashMap)) {
        ((Map)localObject).put(".msgsource.alnode.inlenlist", (String)((HashMap)paramObject).get("similar_paste_seq"));
      }
      bt.d(localcc, bt.B((Map)localObject));
      try
      {
        label405:
        label410:
        do
        {
          this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().c(localcc, true);
          if (this.msgId != -1L) {
            break label642;
          }
          f.Ozc.idkeyStat(111L, 255L, 1L, false);
          if (this.msgId == -1L) {
            break label684;
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
          localObject = new HashMap();
          ((Map)localObject).put(".msgsource.alnode.cf", String.valueOf(paramInt1));
          if ((paramObject instanceof HashMap)) {
            ((Map)localObject).put(".msgsource.alnode.inlenlist", (String)((HashMap)paramObject).get("similar_paste_seq"));
          }
          bt.d(localcc, bt.B((Map)localObject));
          break;
        }
      }
      catch (SQLiteException paramObject)
      {
        for (;;)
        {
          f.Ozc.idkeyStat(111L, 255L, 1L, false);
          if (!paramObject.toString().contains("UNIQUE constraint failed")) {
            break;
          }
          Log.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().gbj();
          this.msgId = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().c(localcc, true);
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
          label642:
          if (((l)com.tencent.mm.kernel.h.ax(l.class)).aHK(paramString1))
          {
            ((l)com.tencent.mm.kernel.h.ax(l.class)).b(paramString1, com.tencent.mm.model.z.bAM(), paramString2, this.msgId);
            continue;
            label684:
            bool = false;
          }
        }
      }
    }
  }
  
  private void OG(String paramString)
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
        else if (!"similar_paste_seq".equalsIgnoreCase((String)localObject))
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
  
  private static void ai(cc paramcc)
  {
    AppMethodBeat.i(43033);
    wq localwq = new wq();
    localwq.ial.hzO = paramcc;
    localwq.publish();
    Log.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[] { Long.valueOf(paramcc.field_msgId) });
    AppMethodBeat.o(43033);
  }
  
  private static void aj(cc paramcc)
  {
    AppMethodBeat.i(43038);
    paramcc.setStatus(5);
    f.Ozc.idkeyStat(111L, 30L, 1L, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramcc.field_msgId, paramcc);
    paramcc = oMg.iterator();
    while (paramcc.hasNext()) {
      paramcc.next();
    }
    AppMethodBeat.o(43038);
  }
  
  private void bKP()
  {
    AppMethodBeat.i(243127);
    int i = 0;
    while (i < this.oMh.size())
    {
      wD(i);
      i += 1;
    }
    AppMethodBeat.o(243127);
  }
  
  private void bKQ()
  {
    AppMethodBeat.i(43036);
    int i = 0;
    while (i < this.oMh.size())
    {
      wE(i);
      i += 1;
    }
    AppMethodBeat.o(43036);
  }
  
  private void wD(int paramInt)
  {
    AppMethodBeat.i(43032);
    if (this.oMh == null)
    {
      Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
      AppMethodBeat.o(43032);
      return;
    }
    if ((paramInt >= this.oMh.size()) || (paramInt < 0))
    {
      Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.oMh.size()) });
      AppMethodBeat.o(43032);
      return;
    }
    ai((cc)this.oMh.get(paramInt));
    AppMethodBeat.o(43032);
  }
  
  private void wE(int paramInt)
  {
    AppMethodBeat.i(43037);
    cc localcc = (cc)this.oMh.get(paramInt);
    Log.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[] { Long.valueOf(localcc.field_msgId) });
    aj(localcc);
    AppMethodBeat.o(43037);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(43031);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new exm();
    paramh.otF = new exn();
    paramh.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramh.funcId = 522;
    paramh.otG = 237;
    paramh.respCmdId = 1000000237;
    this.rr = paramh.bEF();
    exm localexm = (exm)c.b.b(this.rr.otB);
    if (this.oMl == null) {
      paramh = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aaE(this.oMf);
    }
    while ((paramh == null) || (paramh.size() == 0))
    {
      Log.w("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(43031);
      return -2;
      if (this.oMl.field_status != 5) {
        Log.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[] { Long.valueOf(this.oMl.field_msgId), Integer.valueOf(this.oMl.field_status) });
      }
      this.oMl.setStatus(1);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.msgId, this.oMl);
      paramh = new ArrayList();
      paramh.add(this.oMl);
      this.oMl = null;
    }
    this.oMh.clear();
    int i = 0;
    while (i < paramh.size())
    {
      cc localcc = (cc)paramh.get(i);
      if (localcc.field_isSend == 1)
      {
        don localdon = new don();
        localdon.YFF = new etl().btH(localcc.field_talker);
        localdon.CreateTime = ((int)(localcc.getCreateTime() / 1000L));
        localdon.vhJ = localcc.getType();
        localdon.nUB = localcc.field_content;
        localdon.aaVx = x.z(com.tencent.mm.model.z.bAM(), localcc.getCreateTime()).hashCode();
        if (((v)com.tencent.mm.kernel.h.az(v.class)).ifAddTicketByActionFlag(localcc.field_talker)) {
          localdon.ZaR = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxH(localcc.field_talker);
        }
        if (this.oMm == null) {
          this.oMm = ((aa)com.tencent.mm.kernel.h.ax(aa.class)).bKU();
        }
        Log.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[] { this.oMm });
        this.oMm.a(localdon, localcc);
        Log.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[] { localdon.YFJ });
        localexm.vgO.add(localdon);
        localexm.vgN = localexm.vgO.size();
        this.oMh.add(localcc);
      }
      i += 1;
    }
    i = dispatch(paramg, this.rr, this);
    if (i < 0)
    {
      Log.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      bKQ();
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
      f.Ozc.idkeyStat(111L, paramInt2 + 40, 1L, true);
      f.Ozc.idkeyStat(111L, 253L, 1L, false);
      if (paramInt3 == 413)
      {
        paramInt1 = c.b.b(this.rr.otB).computeSize();
        int i = this.oMf / 2;
        Log.e("MicroMsg.NetSceneSendMsg", "send msgs req exceed max limit, size %s, sendMsgMaxNum %s, newSendMsgMaxNum %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.oMf), Integer.valueOf(i) });
        if (this.oMf == 1)
        {
          Log.e("MicroMsg.NetSceneSendMsg", "one msg exceed?????");
          bKQ();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          bKP();
          AppMethodBeat.o(43034);
          return;
        }
        this.oMf = i;
        OG(paramString);
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
      bKQ();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      bKP();
      Log.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
      OG(paramString);
      AppMethodBeat.o(43034);
      return;
    }
    paramArrayOfByte = (exn)c.c.b(this.rr.otC);
    params = paramArrayOfByte.vgO;
    ((v)com.tencent.mm.kernel.h.az(v.class)).setEnSendMsgActionFlag(paramArrayOfByte.ZaS);
    paramArrayOfByte = new ArrayList();
    if (this.oMh.size() == params.size())
    {
      paramInt1 = 0;
      if (paramInt1 < params.size())
      {
        Object localObject = (doo)params.get(paramInt1);
        if ((((doo)localObject).Idd != 0) || (com.tencent.mm.platformtools.z.pCV))
        {
          f.Ozc.idkeyStat(111L, 252L, 1L, false);
          if ((((doo)localObject).Idd == -49) || (com.tencent.mm.platformtools.z.pCV))
          {
            Log.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(((doo)localObject).Idd), Integer.valueOf(paramInt1), Boolean.valueOf(com.tencent.mm.platformtools.z.pCV), Integer.valueOf(this.oMi) });
            if (this.oMj)
            {
              localObject = (cc)this.oMh.get(paramInt1);
              this.oMk.add(localObject);
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (this.oMi < 0)
              {
                wE(paramInt1);
                this.callback.onSceneEnd(4, ((doo)localObject).Idd, paramString, this);
                wD(paramInt1);
                AppMethodBeat.o(43034);
                return;
              }
              this.oMj = true;
              this.oMi -= 1;
              localObject = (cc)this.oMh.get(paramInt1);
              this.oMk.add(localObject);
              com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(43023);
                  new ae(5, "", "", "", "", false, 1, false).doScene(n.a(n.this), new com.tencent.mm.am.h()
                  {
                    public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
                    {
                      AppMethodBeat.i(43022);
                      paramAnonymous2p.setHasCallbackToQueue(true);
                      Log.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(n.b(n.this).size()), paramAnonymous2String, Boolean.valueOf(n.c(n.this)), Integer.valueOf(n.d(n.this)) });
                      if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                      {
                        n.b(n.this).clear();
                        n.a(n.this, paramAnonymous2String);
                      }
                      for (;;)
                      {
                        n.f(n.this);
                        com.tencent.mm.platformtools.z.pCV = false;
                        AppMethodBeat.o(43022);
                        return;
                        n.ca(n.b(n.this));
                        n.e(n.this).onSceneEnd(4, -49, n.1.this.oMn, n.this);
                        n.cb(n.b(n.this));
                        n.b(n.this).clear();
                      }
                    }
                  });
                  AppMethodBeat.o(43023);
                }
              });
            }
          }
          wE(paramInt1);
          this.callback.onSceneEnd(4, ((doo)localObject).Idd, paramString, this);
          wD(paramInt1);
          AppMethodBeat.o(43034);
          return;
        }
        long l = ((cc)this.oMh.get(paramInt1)).field_msgId;
        Log.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + ((doo)localObject).Njv + " sent successfully!");
        cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(l);
        localcc.gX(((doo)localObject).Njv);
        Log.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(((doo)localObject).Njv), Integer.valueOf(com.tencent.mm.platformtools.z.pCn) });
        if ((10007 == com.tencent.mm.platformtools.z.pCm) && (com.tencent.mm.platformtools.z.pCn != 0))
        {
          localcc.gX(com.tencent.mm.platformtools.z.pCn);
          com.tencent.mm.platformtools.z.pCn = 0;
        }
        localcc.setStatus(2);
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(l, localcc);
        if (this.oMh == null) {
          Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
        }
        for (;;)
        {
          paramArrayOfByte.add(Integer.valueOf(paramInt1));
          if (1 != ((doo)localObject).vhJ) {
            break;
          }
          f.Ozc.a(11942, true, false, new Object[] { Long.valueOf(((doo)localObject).Njv) });
          f.Ozc.a(11945, false, true, new Object[] { Long.valueOf(((doo)localObject).Njv) });
          f.Ozc.a(11946, false, false, new Object[] { Long.valueOf(((doo)localObject).Njv) });
          f.Ozc.idkeyStat(90L, 0L, 1L, false);
          f.Ozc.idkeyStat(90L, 1L, 1L, true);
          break;
          if ((paramInt1 >= this.oMh.size()) || (paramInt1 < 0))
          {
            Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.oMh.size()) });
          }
          else
          {
            l = ((cc)this.oMh.get(paramInt1)).field_msgId;
            Log.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[] { Long.valueOf(l) });
            localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(l);
            ws localws = new ws();
            localws.ian.hzO = localcc;
            localws.publish();
          }
        }
      }
      Log.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[] { Integer.valueOf(paramInt1 - this.oMk.size()), Integer.valueOf(this.oMk.size()) });
    }
    Log.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[] { Boolean.valueOf(this.oMj) });
    if (this.oMj)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43034);
      return;
    }
    OG(paramString);
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
      f.Ozc.idkeyStat(111L, 254L, 1L, false);
    }
    AppMethodBeat.o(43028);
    return bool;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(43029);
    if (this.oMh.size() > 0)
    {
      params = p.b.ouh;
      AppMethodBeat.o(43029);
      return params;
    }
    params = p.b.oui;
    AppMethodBeat.o(43029);
    return params;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.n
 * JD-Core Version:    0.7.0.1
 */