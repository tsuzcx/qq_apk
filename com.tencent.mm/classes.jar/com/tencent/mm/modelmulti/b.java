package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.network.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends m
  implements k
{
  protected static int fHY = 7;
  private com.tencent.mm.ai.f callback;
  private g.a eMo;
  private int errCode;
  private String errMsg;
  private int errType;
  private int fHZ;
  private StringBuilder fIa;
  private long fIb;
  private boolean fIc;
  private ap frx;
  
  public b()
  {
    AppMethodBeat.i(58352);
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.fHZ = 0;
    this.fIa = new StringBuilder();
    this.fIb = -1L;
    this.fIc = false;
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    this.eMo = new g.a();
    this.fIa.append("stack:" + bo.dtY() + " time:" + bo.aox());
    AppMethodBeat.o(58352);
  }
  
  public b(t.b paramb, int paramInt, long paramLong)
  {
    this();
    AppMethodBeat.i(58353);
    this.fHZ = paramInt;
    this.fIb = paramLong;
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
    this.frx = new ap(com.tencent.mm.network.ab.anI(), new b.1(this, paramb), false);
    AppMethodBeat.o(58353);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(58356);
    super.cancel();
    AppMethodBeat.o(58356);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    boolean bool = false;
    AppMethodBeat.i(58357);
    this.callback = paramf;
    this.fIa.append(" lastd:" + this.lastdispatch + " dotime:" + bo.aox() + " net:" + at.getNetType(ah.getContext()));
    int i = hashCode();
    int j = fHY;
    if (this.frx != null) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "doScene[%d] selector:%d pusher:%b ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    if (this.frx != null)
    {
      prepareDispatcher(parame);
      this.frx.ag(0L, 0L);
      this.frx = null;
      AppMethodBeat.o(58357);
      return -1;
    }
    paramf = new b.a();
    paramf.uin = com.tencent.mm.network.ab.anF().gdz.getUin();
    bgi localbgi = ((t.a)paramf.getReqObj()).wiM;
    localbgi.wFQ = fHY;
    localbgi.wFR = aa.ac(bo.apQ(ah.getContext().getSharedPreferences("notify_sync_pref", h.Mp()).getString("notify_sync_key_keybuf", "")));
    localbgi.Scene = 1;
    localbgi.xvF = new ue();
    localbgi.wsq = d.eQs;
    i = dispatch(parame, paramf, this);
    AppMethodBeat.o(58357);
    return i;
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(58354);
    String str = this.fIa.toString();
    AppMethodBeat.o(58354);
    return str;
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58358);
    if ((paramq == null) || (paramq.getType() != 138))
    {
      if (paramq == null) {}
      for (paramInt1 = -2;; paramInt1 = paramq.getType())
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetPushSync", "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(58358);
        return;
      }
    }
    this.fIa.append(" endtime:" + bo.aox());
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.fIc), Long.valueOf(this.eMo.Mm()), this.fIa });
    t.b localb;
    label260:
    label349:
    Object localObject1;
    if ((paramInt2 == 4) && (paramInt3 == -2006))
    {
      paramInt2 = 0;
      paramInt3 = 0;
      paramInt1 = 1;
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(58358);
        return;
      }
      localb = (t.b)paramq.getRespObj();
      if (paramInt1 == 0)
      {
        paramString = aa.a(((t.a)paramq.getReqObj()).wiM.wFR);
        if (paramString == null)
        {
          paramInt1 = -1;
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetPushSync", "dkpush req Key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), bo.cd(paramString) });
          if (!bo.ce(paramString)) {
            break label1820;
          }
          paramString = bo.apQ(ah.getContext().getSharedPreferences("notify_sync_pref", h.Mp()).getString("notify_sync_key_keybuf", ""));
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bo.cd(paramString) });
          paramq = aa.a(localb.wiN.wFR);
          paramArrayOfByte = com.tencent.mm.protocal.ab.j(paramString, paramq);
          if (paramArrayOfByte != null)
          {
            paramString = paramArrayOfByte;
            if (paramArrayOfByte.length > 0) {}
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
            paramString = paramq;
          }
          localb.wiN.wFR = aa.ac(paramString);
          if ((localb.wiN.wFU != null) && (localb.wiN.wFU.jJv != null)) {
            break label726;
          }
          paramInt1 = 0;
          label438:
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "newMsgSize:%d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramString != null) {
            break label744;
          }
          paramInt2 = -1;
          label464:
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetPushSync", "newMsgSize:%d, mergeKey: %d[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bo.cd(paramString) });
        }
      }
      else
      {
        paramArrayOfByte = localb.wiN.wFU.jJv.iterator();
        paramInt2 = 0;
        label516:
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (ud)paramArrayOfByte.next();
          if (((ud)localObject1).wMC == 5) {
            paramString = aa.a(((ud)localObject1).wMD);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      long l;
      label726:
      label744:
      String str;
      try
      {
        localObject2 = new cm();
        ((cm)localObject2).parseFrom(paramString);
        int i = ((cm)localObject2).nqW;
        paramString = ((cm)localObject2).woP.xJE;
        l = ((cm)localObject2).pIG;
        if (((cm)localObject2).woV == null)
        {
          paramInt1 = 0;
          if (((cm)localObject2).woR.xJE != null) {
            continue;
          }
          paramInt3 = 0;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d", new Object[] { Integer.valueOf(i), paramString, Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
          paramInt1 = ((cm)localObject2).nqW;
          paramString = ((cm)localObject2).woP.xJE;
          paramq = ((cm)localObject2).woR.xJE;
          if (paramInt1 != 50) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "hit voip");
          paramInt1 = 1;
          if (paramInt1 == 0) {
            continue;
          }
          paramInt2 = 1;
          break label516;
          paramInt1 = paramString.length;
          break label260;
          paramInt1 = localb.wiN.wFU.jJv.size();
          break label438;
          paramInt2 = paramString.length;
          break label464;
        }
        paramInt1 = ((cm)localObject2).woV.length();
        continue;
        paramInt3 = ((cm)localObject2).woR.xJE.length();
        continue;
        if ((bo.isNullOrNil(paramq)) || (bo.isNullOrNil(paramString)))
        {
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
          break label1828;
        }
        if ((paramInt1 == 9998) && (paramString.equalsIgnoreCase("weixin")))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "hit ipxx");
          paramInt1 = 1;
          continue;
        }
        if ((paramInt1 != 10002) || (!paramq.contains("revokemsg"))) {
          break label1828;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
        paramInt1 = 1;
        continue;
        l = ((cm)localObject2).pIG;
        str = ((cm)localObject2).woP.xJE;
        paramString = ((cm)localObject2).woV;
        paramInt1 = ((cm)localObject2).nqW;
        if (!bo.isNullOrNil(paramString)) {
          break label978;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
        if (((cm)localObject2).nqW != 10002) {
          break label1210;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label516;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "need remove pushContent");
        ((cm)localObject2).woV = null;
        ((ud)localObject1).wMD = aa.ac(((cm)localObject2).toByteArray());
      }
      catch (IOException paramString)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
      }
      break label516;
      label978:
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      paramq = bo.apU(paramString);
      paramInt3 = paramq.indexOf("<pushcontent");
      paramString = paramq;
      if (paramInt3 > 0) {
        paramString = paramq.substring(paramInt3);
      }
      paramString = br.F(paramString, "pushcontent");
      if (paramString == null) {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetPushSync", "inval xml");
      }
      for (;;)
      {
        paramString = (PluginZero)com.tencent.mm.kernel.g.G(PluginZero.class);
        if (paramString.vIZ == null) {
          break;
        }
        paramq = com.tencent.mm.compatible.util.e.eQu + com.tencent.mm.a.g.w(new StringBuilder("mm").append(com.tencent.mm.network.ab.anF().gdz.getUin()).toString().getBytes());
        paramString.vIZ.a(l, str, localPString2.value, localPString1.value, paramq + "/avatar/", paramInt1);
        break;
        localPString1.value = ((String)paramString.get(".pushcontent.$content"));
        localPString2.value = ((String)paramString.get(".pushcontent.$nickname"));
      }
      label1210:
      paramInt1 = 0;
      continue;
      try
      {
        paramq = localb.wiN.toByteArray();
        paramInt3 = com.tencent.mm.network.ab.anF().gdz.getUin();
        paramString = com.tencent.mm.booter.g.ig(paramInt3);
        paramInt1 = com.tencent.mm.booter.g.kw(paramString) + 1;
        paramArrayOfByte = paramString + "/syncResp.bin" + paramInt1;
        localObject1 = com.tencent.mm.a.g.w((com.tencent.mm.compatible.e.q.bP(true) + paramInt3).getBytes());
        localObject2 = l.d(paramq, ((String)localObject1).getBytes());
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramq.length), Integer.valueOf(localObject2.length), paramArrayOfByte, com.tencent.mm.booter.g.I(paramq), com.tencent.mm.booter.g.I((byte[])localObject2), com.tencent.mm.booter.g.I(((String)localObject1).getBytes()) });
        if (bo.ce((byte[])localObject2)) {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NotifySyncMgr", "encry failed");
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetPushSync", "onRespHandled sync");
          ah.getContext().getSharedPreferences("notify_sync_pref", h.Mp()).edit().putString("notify_sync_key_keybuf", bo.cg(aa.a(localb.wiN.wFR))).commit();
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", new Object[] { Integer.valueOf(this.fHZ) });
          if (paramInt2 != 0) {
            break label1732;
          }
          if (((localb.wiN.wBX & fHY) == 0) || (securityLimitCountReach())) {
            break label1727;
          }
          paramInt1 = 1;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "continue flag=" + localb.wiN.wBX + ", selector=" + fHY + ", limit reach=" + securityLimitCountReach());
          if (paramInt1 == 0) {
            break label1732;
          }
          doScene(dispatcher(), this.callback);
          if (paramInt2 != 0) {
            CoreService.Id();
          }
          AppMethodBeat.o(58358);
          return;
          paramInt3 = com.tencent.mm.a.e.b(paramArrayOfByte, (byte[])localObject2, localObject2.length);
          boolean bool = com.tencent.mm.a.e.cN(paramArrayOfByte);
          if ((paramInt3 == 0) && (bool)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", new Object[] { Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", new Object[] { paramString });
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
          continue;
          paramq = String.valueOf(paramInt1).getBytes();
          com.tencent.mm.a.e.b(paramString + "/syncResp.ini", paramq, paramq.length);
          continue;
          label1727:
          paramInt1 = 0;
          continue;
          label1732:
          if ((this.fHZ & 0x1) > 0)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
            new f(this.fIb, aa.a(localb.wiN.wFR), com.tencent.mm.network.ab.anF().gdz.getUin()).doScene(com.tencent.mm.network.ab.anF(), new b.2(this));
          }
          this.callback.onSceneEnd(this.errType, this.errCode, this.errMsg, this);
        }
      }
      label1820:
      break label349;
      paramInt1 = 0;
      break;
      label1828:
      paramInt1 = 0;
    }
  }
  
  public final int securityLimitCount()
  {
    return 500;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(58355);
    boolean bool = super.securityLimitCountReach();
    AppMethodBeat.o(58355);
    return bool;
  }
  
  public final m.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b
 * JD-Core Version:    0.7.0.1
 */