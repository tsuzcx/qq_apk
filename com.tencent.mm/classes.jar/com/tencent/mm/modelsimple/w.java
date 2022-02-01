package com.tencent.mm.modelsimple;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.l;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.cwr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;

public final class w
  extends n
  implements k
{
  private static final aq ipo;
  private f callback;
  private final com.tencent.mm.ak.b hZD;
  private final String ipp;
  private final long msgId;
  
  static
  {
    AppMethodBeat.i(20646);
    ipo = new aq("deleteRevokeMessageThread");
    AppMethodBeat.o(20646);
  }
  
  public w(bv parambv, String paramString)
  {
    AppMethodBeat.i(20642);
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.ajA().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = bu.getInt(localObject.toString(), 0);; i = 0)
    {
      this.msgId = parambv.field_msgId;
      this.ipp = paramString;
      localObject = null;
      int k = 0;
      int m = (int)(parambv.field_createTime / 1000L);
      long l = parambv.field_msgSvrId;
      String str1 = v.aAC();
      String str2 = parambv.field_talker;
      int j = k;
      paramString = (String)localObject;
      if (parambv.fmr != 1) {}
      switch (parambv.getType())
      {
      default: 
        paramString = (String)localObject;
        j = k;
      case 1: 
      case 42: 
      case 48: 
      case 66: 
      case 34: 
      case 43: 
      case 62: 
      case 3: 
      case 47: 
        for (;;)
        {
          parambv = new b.a();
          parambv.hQF = new cwq();
          parambv.hQG = new cwr();
          parambv.uri = "/cgi-bin/micromsg-bin/revokemsg";
          parambv.funcId = 594;
          parambv.hQH = 0;
          parambv.respCmdId = 0;
          this.hZD = parambv.aDS();
          parambv = (cwq)this.hZD.hQD.hQJ;
          parambv.FOR = paramString;
          parambv.HHv = j;
          parambv.HHw = 0;
          parambv.HHy = l;
          parambv.CreateTime = m;
          parambv.uvG = str1;
          parambv.uvF = str2;
          parambv.HHx = i;
          ae.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { parambv.FOR, Integer.valueOf(parambv.HHv), Integer.valueOf(parambv.HHw), Integer.valueOf(parambv.CreateTime), parambv.uvG, parambv.uvF, Integer.valueOf(parambv.HHx) });
          AppMethodBeat.o(20642);
          return;
          j = t.w(v.aAC(), parambv.field_createTime).hashCode();
          ae.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[] { Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          parambv = o.aNW().IF(parambv.field_imgPath);
          j = k;
          paramString = (String)localObject;
          if (parambv != null)
          {
            paramString = parambv.clientId;
            ae.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            paramString = parambv.field_imgPath;
            ae.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            localObject = com.tencent.mm.av.q.aIX().G(parambv.field_talker, parambv.field_msgId);
            paramString = parambv.fmu;
            ae.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[] { parambv.field_talker, Integer.valueOf(((com.tencent.mm.av.g)localObject).icz), Long.valueOf(((com.tencent.mm.av.g)localObject).doE), paramString });
            j = k;
            continue;
            paramString = String.valueOf(az.aVt(parambv.field_content).time);
            ae.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[] { paramString });
            j = k;
          }
        }
      }
      paramString = ao.bJV().CZ(parambv.field_msgId);
      if (paramString != null) {}
      for (parambv = paramString.field_clientAppDataId;; parambv = parambv.field_talker + parambv.field_msgId + "T" + parambv.field_createTime)
      {
        ae.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[] { parambv });
        j = k;
        paramString = parambv;
        break;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, bv parambv, String paramString3)
  {
    AppMethodBeat.i(20645);
    if ((parambv.getType() == 1) || (parambv.getType() == 16777265))
    {
      parambv.setType(10002);
      parambv.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent></invokeMessage></sysmsg>", new Object[] { paramString1, Long.valueOf(ch.aDa()), paramString2, paramString3 }));
      AppMethodBeat.o(20645);
      return;
    }
    parambv.setType(10000);
    parambv.setContent(paramString1);
    AppMethodBeat.o(20645);
  }
  
  public final cwr aLx()
  {
    return (cwr)this.hZD.hQE.hQJ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20643);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(20643);
    return i;
  }
  
  public final int getType()
  {
    return 594;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20644);
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bc.aCg();
      paramArrayOfByte = com.tencent.mm.model.c.azI().ys(this.msgId);
      if (paramArrayOfByte.field_msgId != this.msgId) {
        break label434;
      }
      paramq = bv.aM(paramArrayOfByte);
      localObject = aLx();
      ae.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", new Object[] { Long.valueOf(paramArrayOfByte.field_msgId), Long.valueOf(paramArrayOfByte.field_msgSvrId), ((cwr)localObject).HHA });
      int i = paramArrayOfByte.getType();
      a(this.ipp, "  " + ak.getContext().getString(2131760420), paramArrayOfByte, paramArrayOfByte.field_content);
      paramArrayOfByte.kt(0);
      paramArrayOfByte.ka(paramArrayOfByte.eNc | 0x4);
      localObject = new sb();
      ((sb)localObject).dHI.msgId = this.msgId;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      bc.aCg();
      com.tencent.mm.model.c.azI().a(paramArrayOfByte.field_msgId, paramArrayOfByte);
      ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySelf(paramArrayOfByte.field_msgId);
      paramInt1 = 0;
      bc.aCg();
      localObject = com.tencent.mm.model.c.ajA().get(290818, Integer.valueOf(0));
      if (localObject != null) {
        paramInt1 = bu.getInt(localObject.toString(), 0);
      }
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(290818, Integer.valueOf(paramInt1 + 1));
      paramArrayOfByte.setType(i);
      if (!paramArrayOfByte.cVH()) {
        break label407;
      }
      localObject = com.tencent.mm.modelstat.b.iqT;
      paramInt1 = l.r(paramArrayOfByte);
      if (((com.tencent.mm.modelstat.b)localObject).aLW()) {
        ((com.tencent.mm.modelstat.b)localObject).a(paramArrayOfByte, com.tencent.mm.modelstat.b.b.irg, paramInt1);
      }
      ipo.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20641);
          ae.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[] { Long.valueOf(paramArrayOfByte.field_msgId) });
          paramArrayOfByte.setType(10002);
          w.a(w.a(w.this), "", paramArrayOfByte, "");
          bc.aCg();
          com.tencent.mm.model.c.azI().a(paramArrayOfByte.field_msgId, paramArrayOfByte);
          AppMethodBeat.o(20641);
        }
      }, 300000L);
      if (aa.i(paramq))
      {
        paramArrayOfByte = new ne();
        paramArrayOfByte.dCh.dCi = paramq;
        com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfByte);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20644);
      return;
      label407:
      localObject = com.tencent.mm.modelstat.b.iqT;
      if (!((com.tencent.mm.modelstat.b)localObject).aLW()) {
        break;
      }
      ((com.tencent.mm.modelstat.b)localObject).a(paramArrayOfByte, com.tencent.mm.modelstat.b.b.irg, 0);
      break;
      label434:
      ae.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[] { Long.valueOf(this.msgId) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w
 * JD-Core Version:    0.7.0.1
 */