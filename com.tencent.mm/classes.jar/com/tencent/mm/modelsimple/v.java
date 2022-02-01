package com.tencent.mm.modelsimple;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.l;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;

public final class v
  extends n
  implements k
{
  private static final ao hTd;
  private com.tencent.mm.ak.g callback;
  private final com.tencent.mm.ak.b hEg;
  private final String hTe;
  private final long msgId;
  
  static
  {
    AppMethodBeat.i(20646);
    hTd = new ao("deleteRevokeMessageThread");
    AppMethodBeat.o(20646);
  }
  
  public v(bo parambo, String paramString)
  {
    AppMethodBeat.i(20642);
    az.ayM();
    Object localObject = com.tencent.mm.model.c.agA().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = bs.getInt(localObject.toString(), 0);; i = 0)
    {
      this.msgId = parambo.field_msgId;
      this.hTe = paramString;
      localObject = null;
      int k = 0;
      int m = (int)(parambo.field_createTime / 1000L);
      long l = parambo.field_msgSvrId;
      String str1 = u.axw();
      String str2 = parambo.field_talker;
      int j = k;
      paramString = (String)localObject;
      if (parambo.eSf != 1) {}
      switch (parambo.getType())
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
          parambo = new b.a();
          parambo.hvt = new cqr();
          parambo.hvu = new cqs();
          parambo.uri = "/cgi-bin/micromsg-bin/revokemsg";
          parambo.funcId = 594;
          parambo.reqCmdId = 0;
          parambo.respCmdId = 0;
          this.hEg = parambo.aAz();
          parambo = (cqr)this.hEg.hvr.hvw;
          parambo.DRb = paramString;
          parambo.FDI = j;
          parambo.FDJ = 0;
          parambo.FDL = l;
          parambo.CreateTime = m;
          parambo.tlK = str1;
          parambo.tlJ = str2;
          parambo.FDK = i;
          ac.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { parambo.DRb, Integer.valueOf(parambo.FDI), Integer.valueOf(parambo.FDJ), Integer.valueOf(parambo.CreateTime), parambo.tlK, parambo.tlJ, Integer.valueOf(parambo.FDK) });
          AppMethodBeat.o(20642);
          return;
          j = s.u(u.axw(), parambo.field_createTime).hashCode();
          ac.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[] { Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          parambo = com.tencent.mm.modelvoice.o.aKp().EO(parambo.field_imgPath);
          j = k;
          paramString = (String)localObject;
          if (parambo != null)
          {
            paramString = parambo.clientId;
            ac.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            paramString = parambo.field_imgPath;
            ac.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            localObject = com.tencent.mm.av.o.aFx().qg(parambo.field_msgId);
            paramString = parambo.eSi;
            ac.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[] { parambo.field_talker, Integer.valueOf(((com.tencent.mm.av.e)localObject).hGX), Long.valueOf(((com.tencent.mm.av.e)localObject).dcd), paramString });
            j = k;
            continue;
            paramString = String.valueOf(au.aOb(parambo.field_content).time);
            ac.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[] { paramString });
            j = k;
          }
        }
      }
      paramString = ap.bEO().zM(parambo.field_msgId);
      if (paramString != null) {}
      for (parambo = paramString.field_clientAppDataId;; parambo = parambo.field_talker + parambo.field_msgId + "T" + parambo.field_createTime)
      {
        ac.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[] { parambo });
        j = k;
        paramString = parambo;
        break;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, bo parambo, String paramString3)
  {
    AppMethodBeat.i(20645);
    if ((parambo.getType() == 1) || (parambo.getType() == 16777265))
    {
      parambo.setType(10002);
      parambo.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent></invokeMessage></sysmsg>", new Object[] { paramString1, Long.valueOf(ce.azH()), paramString2, paramString3 }));
      AppMethodBeat.o(20645);
      return;
    }
    parambo.setType(10000);
    parambo.setContent(paramString1);
    AppMethodBeat.o(20645);
  }
  
  public final cqs aHP()
  {
    return (cqs)this.hEg.hvs.hvw;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(20643);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(20643);
    return i;
  }
  
  public final int getType()
  {
    return 594;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20644);
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      az.ayM();
      paramArrayOfByte = com.tencent.mm.model.c.awD().vP(this.msgId);
      if (paramArrayOfByte.field_msgId != this.msgId) {
        break label434;
      }
      paramq = bo.aK(paramArrayOfByte);
      localObject = aHP();
      ac.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", new Object[] { Long.valueOf(paramArrayOfByte.field_msgId), Long.valueOf(paramArrayOfByte.field_msgSvrId), ((cqs)localObject).FDN });
      int i = paramArrayOfByte.getType();
      a(this.hTe, "  " + ai.getContext().getString(2131760420), paramArrayOfByte, paramArrayOfByte.field_content);
      paramArrayOfByte.jT(0);
      paramArrayOfByte.jA(paramArrayOfByte.euk | 0x4);
      localObject = new ro();
      ((ro)localObject).duB.msgId = this.msgId;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      az.ayM();
      com.tencent.mm.model.c.awD().a(paramArrayOfByte.field_msgId, paramArrayOfByte);
      ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySelf(paramArrayOfByte.field_msgId);
      paramInt1 = 0;
      az.ayM();
      localObject = com.tencent.mm.model.c.agA().get(290818, Integer.valueOf(0));
      if (localObject != null) {
        paramInt1 = bs.getInt(localObject.toString(), 0);
      }
      az.ayM();
      com.tencent.mm.model.c.agA().set(290818, Integer.valueOf(paramInt1 + 1));
      paramArrayOfByte.setType(i);
      if (!paramArrayOfByte.cKN()) {
        break label407;
      }
      localObject = com.tencent.mm.modelstat.b.hUE;
      paramInt1 = l.r(paramArrayOfByte);
      if (((com.tencent.mm.modelstat.b)localObject).aIp()) {
        ((com.tencent.mm.modelstat.b)localObject).a(paramArrayOfByte, com.tencent.mm.modelstat.b.b.hUR, paramInt1);
      }
      hTd.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20641);
          ac.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[] { Long.valueOf(paramArrayOfByte.field_msgId) });
          paramArrayOfByte.setType(10002);
          v.a(v.a(v.this), "", paramArrayOfByte, "");
          az.ayM();
          com.tencent.mm.model.c.awD().a(paramArrayOfByte.field_msgId, paramArrayOfByte);
          AppMethodBeat.o(20641);
        }
      }, 300000L);
      if (aa.i(paramq))
      {
        paramArrayOfByte = new mv();
        paramArrayOfByte.dpp.dpq = paramq;
        com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20644);
      return;
      label407:
      localObject = com.tencent.mm.modelstat.b.hUE;
      if (!((com.tencent.mm.modelstat.b)localObject).aIp()) {
        break;
      }
      ((com.tencent.mm.modelstat.b)localObject).a(paramArrayOfByte, com.tencent.mm.modelstat.b.b.hUR, 0);
      break;
      label434:
      ac.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[] { Long.valueOf(this.msgId) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v
 * JD-Core Version:    0.7.0.1
 */