package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.dtu;
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
  extends q
  implements m
{
  private static final List<Object> jcO;
  private com.tencent.mm.ak.i callback;
  private int jcN;
  private final List<ca> jcP;
  private int jcQ;
  private boolean jcR;
  private final List<ca> jcS;
  private ca jcT;
  public o jcU;
  public long msgId;
  private d rr;
  
  static
  {
    AppMethodBeat.i(43043);
    jcO = new ArrayList();
    AppMethodBeat.o(43043);
  }
  
  public i()
  {
    AppMethodBeat.i(43027);
    this.jcN = 15;
    this.jcP = new LinkedList();
    this.jcQ = 3;
    this.jcR = false;
    this.jcS = new ArrayList();
    this.jcT = null;
    this.jcU = null;
    Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { Util.getStack() });
    Log.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(43027);
  }
  
  public i(long paramLong)
  {
    AppMethodBeat.i(43026);
    this.jcN = 15;
    this.jcP = new LinkedList();
    this.jcQ = 3;
    this.jcR = false;
    this.jcS = new ArrayList();
    this.jcT = null;
    this.jcU = null;
    Log.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = ".concat(String.valueOf(paramLong)));
    this.msgId = paramLong;
    this.jcT = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(paramLong);
    if (this.jcT == null) {
      Log.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[] { Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(43026);
  }
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43025);
    this.jcN = 15;
    this.jcP = new LinkedList();
    this.jcQ = 3;
    this.jcR = false;
    this.jcS = new ArrayList();
    this.jcT = null;
    this.jcU = null;
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { Util.getStack() });
    }
    ca localca;
    if (!Util.isNullOrNil(paramString1))
    {
      localca = new ca();
      localca.setStatus(1);
      localca.Cy(paramString1);
      localca.setCreateTime(bp.Kw(paramString1));
      localca.nv(1);
      localca.setContent(paramString2);
      localca.setType(paramInt1);
      if ((paramInt2 == 1) && (paramInt1 == 42)) {
        localca.gDE();
      }
      String str = ((w)com.tencent.mm.kernel.g.af(w.class)).Z(localca);
      if (!Util.isNullOrNil(str))
      {
        localca.BB(str);
        Log.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localca.fqK });
      }
    }
    try
    {
      this.msgId = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().c(localca, true);
      if ((this.msgId != -1L) && (((j)com.tencent.mm.kernel.g.af(j.class)).aBf(paramString1))) {
        ((j)com.tencent.mm.kernel.g.af(j.class)).a(paramString1, z.aTY(), paramString2, this.msgId);
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
        e.Cxv.idkeyStat(111L, 255L, 1L, false);
        if (!localSQLiteException.toString().contains("UNIQUE constraint failed")) {
          break;
        }
        Log.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
        ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().eiI();
        this.msgId = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().c(localca, true);
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
    this.jcN = 15;
    this.jcP = new LinkedList();
    this.jcQ = 3;
    this.jcR = false;
    this.jcS = new ArrayList();
    this.jcT = null;
    this.jcU = null;
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[] { Util.getStack() });
    }
    ca localca;
    if (!Util.isNullOrNil(paramString1))
    {
      localca = new ca();
      localca.setStatus(1);
      localca.Cy(paramString1);
      localca.setCreateTime(bp.Kw(paramString1));
      localca.nv(1);
      localca.setContent(paramString2);
      localca.setType(paramInt1);
      paramObject = a(((w)com.tencent.mm.kernel.g.af(w.class)).Z(localca), paramObject, paramInt2);
      if (!Util.isNullOrNil(paramObject))
      {
        localca.BB(paramObject);
        Log.i("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[] { localca.fqK });
      }
      if (((paramInt2 & 0x4) != 0) || ((paramInt2 & 0x8) != 0))
      {
        if ((paramInt2 & 0x4) == 0) {
          break label372;
        }
        paramInt1 = 2;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NetSceneSendMsg", "has paste fully flag, %d", new Object[] { Integer.valueOf(paramInt1) });
      paramObject = new HashMap();
      paramObject.put(".msgsource.alnode.cf", String.valueOf(paramInt1));
      br.b(localca, br.B(paramObject));
      try
      {
        this.msgId = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().c(localca, true);
        if (this.msgId == -1L)
        {
          e.Cxv.idkeyStat(111L, 255L, 1L, false);
          if (this.msgId == -1L) {
            break label531;
          }
          bool = true;
          Assert.assertTrue(bool);
          Log.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.msgId);
          AppMethodBeat.o(43024);
          return;
          label372:
          paramInt1 = 3;
        }
      }
      catch (SQLiteException paramObject)
      {
        for (;;)
        {
          e.Cxv.idkeyStat(111L, 255L, 1L, false);
          if (!paramObject.toString().contains("UNIQUE constraint failed")) {
            break;
          }
          Log.e("MicroMsg.NetSceneSendMsg", "fallback to insert");
          ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().eiI();
          this.msgId = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().c(localca, true);
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
          if (((j)com.tencent.mm.kernel.g.af(j.class)).aBf(paramString1))
          {
            ((j)com.tencent.mm.kernel.g.af(j.class)).a(paramString1, z.aTY(), paramString2, this.msgId);
            continue;
            label531:
            bool = false;
          }
        }
      }
    }
  }
  
  private void Pk(String paramString)
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
  
  private static void X(ca paramca)
  {
    AppMethodBeat.i(43033);
    tx localtx = new tx();
    localtx.ear.dCM = paramca;
    EventCenter.instance.publish(localtx);
    Log.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
    AppMethodBeat.o(43033);
  }
  
  private static void Y(ca paramca)
  {
    AppMethodBeat.i(43038);
    paramca.setStatus(5);
    e.Cxv.idkeyStat(111L, 30L, 1L, true);
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(paramca.field_msgId, paramca);
    paramca = jcO.iterator();
    while (paramca.hasNext()) {
      paramca.next();
    }
    AppMethodBeat.o(43038);
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
  
  private void bdJ()
  {
    AppMethodBeat.i(225960);
    int i = 0;
    while (i < this.jcP.size())
    {
      tB(i);
      i += 1;
    }
    AppMethodBeat.o(225960);
  }
  
  private void bdK()
  {
    AppMethodBeat.i(43036);
    int i = 0;
    while (i < this.jcP.size())
    {
      tC(i);
      i += 1;
    }
    AppMethodBeat.o(43036);
  }
  
  private void tB(int paramInt)
  {
    AppMethodBeat.i(43032);
    if (this.jcP == null)
    {
      Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
      AppMethodBeat.o(43032);
      return;
    }
    if ((paramInt >= this.jcP.size()) || (paramInt < 0))
    {
      Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jcP.size()) });
      AppMethodBeat.o(43032);
      return;
    }
    X((ca)this.jcP.get(paramInt));
    AppMethodBeat.o(43032);
  }
  
  private void tC(int paramInt)
  {
    AppMethodBeat.i(43037);
    ca localca = (ca)this.jcP.get(paramInt);
    Log.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[] { Long.valueOf(localca.field_msgId) });
    Y(localca);
    AppMethodBeat.o(43037);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(43031);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new dtt();
    parami.iLO = new dtu();
    parami.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    parami.funcId = 522;
    parami.iLP = 237;
    parami.respCmdId = 1000000237;
    this.rr = parami.aXF();
    dtt localdtt = (dtt)this.rr.iLK.iLR;
    if (this.jcT == null) {
      parami = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Qp(this.jcN);
    }
    while ((parami == null) || (parami.size() == 0))
    {
      Log.w("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(43031);
      return -2;
      if (this.jcT.field_status != 5) {
        Log.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[] { Long.valueOf(this.jcT.field_msgId), Integer.valueOf(this.jcT.field_status) });
      }
      this.jcT.setStatus(1);
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.msgId, this.jcT);
      parami = new ArrayList();
      parami.add(this.jcT);
      this.jcT = null;
    }
    this.jcP.clear();
    int i = 0;
    while (i < parami.size())
    {
      ca localca = (ca)parami.get(i);
      if (localca.field_isSend == 1)
      {
        cot localcot = new cot();
        localcot.KHm = new dqi().bhy(localca.field_talker);
        localcot.CreateTime = ((int)(localca.field_createTime / 1000L));
        localcot.oUv = localca.getType();
        localcot.iAc = localca.field_content;
        localcot.MuU = x.x(z.aTY(), localca.field_createTime).hashCode();
        if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(localca.field_talker)) {
          localcot.LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(localca.field_talker);
        }
        if (this.jcU == null) {
          this.jcU = ((w)com.tencent.mm.kernel.g.af(w.class)).bdO();
        }
        Log.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[] { this.jcU });
        this.jcU.a(localcot, localca);
        Log.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[] { localcot.KHq });
        localdtt.oTA.add(localcot);
        localdtt.oTz = localdtt.oTA.size();
        this.jcP.add(localca);
      }
      i += 1;
    }
    i = dispatch(paramg, this.rr, this);
    if (i < 0)
    {
      Log.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[] { Integer.valueOf(i) });
      bdK();
    }
    AppMethodBeat.o(43031);
    return i;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, final String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43034);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      e.Cxv.idkeyStat(111L, paramInt2 + 40, 1L, true);
      e.Cxv.idkeyStat(111L, 253L, 1L, false);
      if (paramInt3 == 413)
      {
        paramInt1 = this.rr.iLK.iLR.computeSize();
        int i = this.jcN / 2;
        Log.e("MicroMsg.NetSceneSendMsg", "send msgs req exceed max limit, size %s, sendMsgMaxNum %s, newSendMsgMaxNum %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.jcN), Integer.valueOf(i) });
        if (this.jcN == 1)
        {
          Log.e("MicroMsg.NetSceneSendMsg", "one msg exceed?????");
          bdK();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          bdJ();
          AppMethodBeat.o(43034);
          return;
        }
        this.jcN = i;
        Pk(paramString);
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
      bdK();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      bdJ();
      Log.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
      Pk(paramString);
      AppMethodBeat.o(43034);
      return;
    }
    paramArrayOfByte = (dtu)this.rr.iLL.iLR;
    params = paramArrayOfByte.oTA;
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(paramArrayOfByte.LbO);
    paramArrayOfByte = new ArrayList();
    if (this.jcP.size() == params.size())
    {
      paramInt1 = 0;
      if (paramInt1 < params.size())
      {
        Object localObject = (cou)params.get(paramInt1);
        if ((((cou)localObject).Ret != 0) || (ac.jPl))
        {
          e.Cxv.idkeyStat(111L, 252L, 1L, false);
          if ((((cou)localObject).Ret == -49) || (ac.jPl))
          {
            Log.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[] { Integer.valueOf(((cou)localObject).Ret), Integer.valueOf(paramInt1), Boolean.valueOf(ac.jPl), Integer.valueOf(this.jcQ) });
            if (this.jcR)
            {
              localObject = (ca)this.jcP.get(paramInt1);
              this.jcS.add(localObject);
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (this.jcQ < 0)
              {
                tC(paramInt1);
                this.callback.onSceneEnd(4, ((cou)localObject).Ret, paramString, this);
                tB(paramInt1);
                AppMethodBeat.o(43034);
                return;
              }
              this.jcR = true;
              this.jcQ -= 1;
              localObject = (ca)this.jcP.get(paramInt1);
              this.jcS.add(localObject);
              com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(43023);
                  new ad(5, "", "", "", "", false, 1, false).doScene(i.a(i.this), new com.tencent.mm.ak.i()
                  {
                    public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
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
                        ac.jPl = false;
                        AppMethodBeat.o(43022);
                        return;
                        i.ax(i.b(i.this));
                        i.e(i.this).onSceneEnd(4, -49, i.1.this.jcV, i.this);
                        i.ay(i.b(i.this));
                        i.b(i.this).clear();
                      }
                    }
                  });
                  AppMethodBeat.o(43023);
                }
              });
            }
          }
          tC(paramInt1);
          this.callback.onSceneEnd(4, ((cou)localObject).Ret, paramString, this);
          tB(paramInt1);
          AppMethodBeat.o(43034);
          return;
        }
        long l = ((ca)this.jcP.get(paramInt1)).field_msgId;
        Log.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + ((cou)localObject).Brn + " sent successfully!");
        ca localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(l);
        localca.yF(((cou)localObject).Brn);
        Log.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(((cou)localObject).Brn), Integer.valueOf(ac.jOD) });
        if ((10007 == ac.jOC) && (ac.jOD != 0))
        {
          localca.yF(ac.jOD);
          ac.jOD = 0;
        }
        localca.setStatus(2);
        ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(l, localca);
        if (this.jcP == null) {
          Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
        }
        for (;;)
        {
          paramArrayOfByte.add(Integer.valueOf(paramInt1));
          if (1 != ((cou)localObject).oUv) {
            break;
          }
          e.Cxv.a(11942, true, false, new Object[] { Long.valueOf(((cou)localObject).Brn) });
          e.Cxv.a(11945, false, true, new Object[] { Long.valueOf(((cou)localObject).Brn) });
          e.Cxv.a(11946, false, false, new Object[] { Long.valueOf(((cou)localObject).Brn) });
          e.Cxv.idkeyStat(90L, 0L, 1L, false);
          e.Cxv.idkeyStat(90L, 1L, 1L, true);
          break;
          if ((paramInt1 >= this.jcP.size()) || (paramInt1 < 0))
          {
            Log.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.jcP.size()) });
          }
          else
          {
            l = ((ca)this.jcP.get(paramInt1)).field_msgId;
            Log.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[] { Long.valueOf(l) });
            localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(l);
            tz localtz = new tz();
            localtz.eat.dCM = localca;
            EventCenter.instance.publish(localtz);
          }
        }
      }
      Log.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[] { Integer.valueOf(paramInt1 - this.jcS.size()), Integer.valueOf(this.jcS.size()) });
    }
    Log.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[] { Boolean.valueOf(this.jcR) });
    if (this.jcR)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43034);
      return;
    }
    Pk(paramString);
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
      e.Cxv.idkeyStat(111L, 254L, 1L, false);
    }
    AppMethodBeat.o(43028);
    return bool;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(43029);
    if (this.jcP.size() > 0)
    {
      params = q.b.iMq;
      AppMethodBeat.o(43029);
      return params;
    }
    params = q.b.iMr;
    AppMethodBeat.o(43029);
    return params;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.i
 * JD-Core Version:    0.7.0.1
 */