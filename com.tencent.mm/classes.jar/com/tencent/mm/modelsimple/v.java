package com.tencent.mm.modelsimple;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.l;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bl;

public final class v
  extends n
  implements k
{
  private static final com.tencent.mm.sdk.platformtools.ap hsB;
  private com.tencent.mm.al.g callback;
  private final com.tencent.mm.al.b hdD;
  private final String hsC;
  private final long msgId;
  
  static
  {
    AppMethodBeat.i(20646);
    hsB = new com.tencent.mm.sdk.platformtools.ap("deleteRevokeMessageThread");
    AppMethodBeat.o(20646);
  }
  
  public v(bl parambl, String paramString)
  {
    AppMethodBeat.i(20642);
    az.arV();
    Object localObject = com.tencent.mm.model.c.afk().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = bt.getInt(localObject.toString(), 0);; i = 0)
    {
      this.msgId = parambl.field_msgId;
      this.hsC = paramString;
      localObject = null;
      int k = 0;
      int m = (int)(parambl.field_createTime / 1000L);
      long l = parambl.field_msgSvrId;
      String str1 = u.aqG();
      String str2 = parambl.field_talker;
      int j = k;
      paramString = (String)localObject;
      if (parambl.eOX != 1) {}
      switch (parambl.getType())
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
          parambl = new b.a();
          parambl.gUU = new clk();
          parambl.gUV = new cll();
          parambl.uri = "/cgi-bin/micromsg-bin/revokemsg";
          parambl.funcId = 594;
          parambl.reqCmdId = 0;
          parambl.respCmdId = 0;
          this.hdD = parambl.atI();
          parambl = (clk)this.hdD.gUS.gUX;
          parambl.CyF = paramString;
          parambl.EgJ = j;
          parambl.EgK = 0;
          parambl.EgM = l;
          parambl.CreateTime = m;
          parambl.sdQ = str1;
          parambl.sdP = str2;
          parambl.EgL = i;
          ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { parambl.CyF, Integer.valueOf(parambl.EgJ), Integer.valueOf(parambl.EgK), Integer.valueOf(parambl.CreateTime), parambl.sdQ, parambl.sdP, Integer.valueOf(parambl.EgL) });
          AppMethodBeat.o(20642);
          return;
          j = s.t(u.aqG(), parambl.field_createTime).hashCode();
          ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[] { Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          parambl = com.tencent.mm.modelvoice.o.aDy().AJ(parambl.field_imgPath);
          j = k;
          paramString = (String)localObject;
          if (parambl != null)
          {
            paramString = parambl.clientId;
            ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            paramString = parambl.field_imgPath;
            ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            localObject = com.tencent.mm.aw.o.ayF().ms(parambl.field_msgId);
            paramString = parambl.ePa;
            ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[] { parambl.field_talker, Integer.valueOf(((com.tencent.mm.aw.e)localObject).hgu), Long.valueOf(((com.tencent.mm.aw.e)localObject).deI), paramString });
            j = k;
            continue;
            paramString = String.valueOf(ar.aIF(parambl.field_content).time);
            ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[] { paramString });
            j = k;
          }
        }
      }
      paramString = com.tencent.mm.pluginsdk.model.app.ap.bxS().vj(parambl.field_msgId);
      if (paramString != null) {}
      for (parambl = paramString.field_clientAppDataId;; parambl = parambl.field_talker + parambl.field_msgId + "T" + parambl.field_createTime)
      {
        ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[] { parambl });
        j = k;
        paramString = parambl;
        break;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, bl parambl, String paramString3)
  {
    AppMethodBeat.i(20645);
    if ((parambl.getType() == 1) || (parambl.getType() == 16777265))
    {
      parambl.setType(10002);
      parambl.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent></invokeMessage></sysmsg>", new Object[] { paramString1, Long.valueOf(ce.asQ()), paramString2, paramString3 }));
      AppMethodBeat.o(20645);
      return;
    }
    parambl.setType(10000);
    parambl.setContent(paramString1);
    AppMethodBeat.o(20645);
  }
  
  public final cll aAZ()
  {
    return (cll)this.hdD.gUT.gUX;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(20643);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
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
      az.arV();
      paramArrayOfByte = com.tencent.mm.model.c.apO().rm(this.msgId);
      if (paramArrayOfByte.field_msgId != this.msgId) {
        break label434;
      }
      paramq = bl.aI(paramArrayOfByte);
      localObject = aAZ();
      ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", new Object[] { Long.valueOf(paramArrayOfByte.field_msgId), Long.valueOf(paramArrayOfByte.field_msgSvrId), ((cll)localObject).EgO });
      int i = paramArrayOfByte.getType();
      a(this.hsC, "  " + aj.getContext().getString(2131760420), paramArrayOfByte, paramArrayOfByte.field_content);
      paramArrayOfByte.jV(0);
      paramArrayOfByte.jC(paramArrayOfByte.esg | 0x4);
      localObject = new rf();
      ((rf)localObject).dwO.msgId = this.msgId;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      az.arV();
      com.tencent.mm.model.c.apO().a(paramArrayOfByte.field_msgId, paramArrayOfByte);
      ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySelf(paramArrayOfByte.field_msgId);
      paramInt1 = 0;
      az.arV();
      localObject = com.tencent.mm.model.c.afk().get(290818, Integer.valueOf(0));
      if (localObject != null) {
        paramInt1 = bt.getInt(localObject.toString(), 0);
      }
      az.arV();
      com.tencent.mm.model.c.afk().set(290818, Integer.valueOf(paramInt1 + 1));
      paramArrayOfByte.setType(i);
      if (!paramArrayOfByte.cxB()) {
        break label407;
      }
      localObject = com.tencent.mm.modelstat.b.huc;
      paramInt1 = l.r(paramArrayOfByte);
      if (((com.tencent.mm.modelstat.b)localObject).aBz()) {
        ((com.tencent.mm.modelstat.b)localObject).a(paramArrayOfByte, com.tencent.mm.modelstat.b.b.hup, paramInt1);
      }
      hsB.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20641);
          ad.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[] { Long.valueOf(paramArrayOfByte.field_msgId) });
          paramArrayOfByte.setType(10002);
          v.a(v.a(v.this), "", paramArrayOfByte, "");
          az.arV();
          com.tencent.mm.model.c.apO().a(paramArrayOfByte.field_msgId, paramArrayOfByte);
          AppMethodBeat.o(20641);
        }
      }, 300000L);
      if (aa.i(paramq))
      {
        paramArrayOfByte = new mm();
        paramArrayOfByte.drE.drF = paramq;
        com.tencent.mm.sdk.b.a.ESL.l(paramArrayOfByte);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20644);
      return;
      label407:
      localObject = com.tencent.mm.modelstat.b.huc;
      if (!((com.tencent.mm.modelstat.b)localObject).aBz()) {
        break;
      }
      ((com.tencent.mm.modelstat.b)localObject).a(paramArrayOfByte, com.tencent.mm.modelstat.b.b.hup, 0);
      break;
      label434:
      ad.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[] { Long.valueOf(this.msgId) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v
 * JD-Core Version:    0.7.0.1
 */