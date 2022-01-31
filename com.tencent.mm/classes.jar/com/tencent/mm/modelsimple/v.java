package com.tencent.mm.modelsimple;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.g;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;

public final class v
  extends m
  implements com.tencent.mm.network.k
{
  private static final com.tencent.mm.sdk.platformtools.al fPW;
  private f callback;
  private final long cpO;
  private final com.tencent.mm.ai.b fBd;
  private final String fPX;
  
  static
  {
    AppMethodBeat.i(16602);
    fPW = new com.tencent.mm.sdk.platformtools.al("deleteRevokeMessageThread");
    AppMethodBeat.o(16602);
  }
  
  public v(bi parambi, String paramString)
  {
    AppMethodBeat.i(16598);
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.Ru().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = bo.getInt(localObject.toString(), 0);; i = 0)
    {
      this.cpO = parambi.field_msgId;
      this.fPX = paramString;
      localObject = null;
      int k = 0;
      int m = (int)(parambi.field_createTime / 1000L);
      long l = parambi.field_msgSvrId;
      String str1 = com.tencent.mm.model.r.Zn();
      String str2 = parambi.field_talker;
      int j = k;
      paramString = (String)localObject;
      if (parambi.dGV != 1) {}
      switch (parambi.getType())
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
          parambi = new b.a();
          parambi.fsX = new bvq();
          parambi.fsY = new bvr();
          parambi.uri = "/cgi-bin/micromsg-bin/revokemsg";
          parambi.funcId = 594;
          parambi.reqCmdId = 0;
          parambi.respCmdId = 0;
          this.fBd = parambi.ado();
          parambi = (bvq)this.fBd.fsV.fta;
          parambi.wpS = paramString;
          parambi.xJj = j;
          parambi.xJk = 0;
          parambi.xJm = l;
          parambi.CreateTime = m;
          parambi.num = str1;
          parambi.nul = str2;
          parambi.xJl = i;
          ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { parambi.wpS, Integer.valueOf(parambi.xJj), Integer.valueOf(parambi.xJk), Integer.valueOf(parambi.CreateTime), parambi.num, parambi.nul, Integer.valueOf(parambi.xJl) });
          AppMethodBeat.o(16598);
          return;
          j = p.t(com.tencent.mm.model.r.Zn(), parambi.field_createTime).hashCode();
          ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[] { Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          parambi = com.tencent.mm.modelvoice.o.ams().vW(parambi.field_imgPath);
          j = k;
          paramString = (String)localObject;
          if (parambi != null)
          {
            paramString = parambi.clientId;
            ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            paramString = parambi.field_imgPath;
            ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            localObject = com.tencent.mm.at.o.ahC().gT(parambi.field_msgId);
            paramString = parambi.dGY;
            ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[] { parambi.field_talker, Integer.valueOf(((com.tencent.mm.at.e)localObject).fDW), Long.valueOf(((com.tencent.mm.at.e)localObject).fDL), paramString });
            j = k;
            continue;
            paramString = String.valueOf(ap.arZ(parambi.field_content).time);
            ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[] { paramString });
            j = k;
          }
        }
      }
      paramString = com.tencent.mm.pluginsdk.model.app.al.aUJ().nw(parambi.field_msgId);
      if (paramString != null) {}
      for (parambi = paramString.field_clientAppDataId;; parambi = parambi.field_talker + parambi.field_msgId + "T" + parambi.field_createTime)
      {
        ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[] { parambi });
        j = k;
        paramString = parambi;
        break;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, bi parambi, String paramString3)
  {
    AppMethodBeat.i(16601);
    if ((parambi.getType() == 1) || (parambi.getType() == 16777265))
    {
      parambi.setType(10002);
      parambi.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent></invokeMessage></sysmsg>", new Object[] { paramString1, Long.valueOf(System.currentTimeMillis()), paramString2, paramString3 }));
      AppMethodBeat.o(16601);
      return;
    }
    parambi.setType(10000);
    parambi.setContent(paramString1);
    AppMethodBeat.o(16601);
  }
  
  public final bvr ajV()
  {
    return (bvr)this.fBd.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(16599);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(16599);
    return i;
  }
  
  public final int getType()
  {
    return 594;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16600);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      aw.aaz();
      paramq = com.tencent.mm.model.c.YC().kB(this.cpO);
      if (paramq.field_msgId != this.cpO) {
        break label372;
      }
      paramArrayOfByte = ajV();
      ab.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", new Object[] { Long.valueOf(paramq.field_msgId), Long.valueOf(paramq.field_msgSvrId), paramArrayOfByte.xJo });
      int i = paramq.getType();
      a(this.fPX, "  " + ah.getContext().getString(2131300819), paramq, paramq.field_content);
      paramq.hL(0);
      paramq.hr(paramq.dnr | 0x4);
      paramArrayOfByte = new pn();
      paramArrayOfByte.cGd.cpO = this.cpO;
      a.ymk.l(paramArrayOfByte);
      aw.aaz();
      com.tencent.mm.model.c.YC().a(paramq.field_msgId, paramq);
      paramInt1 = 0;
      aw.aaz();
      paramArrayOfByte = com.tencent.mm.model.c.Ru().get(290818, Integer.valueOf(0));
      if (paramArrayOfByte != null) {
        paramInt1 = bo.getInt(paramArrayOfByte.toString(), 0);
      }
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(290818, Integer.valueOf(paramInt1 + 1));
      paramq.setType(i);
      if (!paramq.bCn()) {
        break label345;
      }
      paramArrayOfByte = com.tencent.mm.modelstat.b.fRu;
      paramInt1 = com.tencent.mm.af.k.k(paramq);
      if (paramArrayOfByte.aku()) {
        paramArrayOfByte.a(paramq, com.tencent.mm.modelstat.b.b.fRH, paramInt1);
      }
      fPW.o(new v.1(this, paramq), 300000L);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(16600);
      return;
      label345:
      paramArrayOfByte = com.tencent.mm.modelstat.b.fRu;
      if (!paramArrayOfByte.aku()) {
        break;
      }
      paramArrayOfByte.a(paramq, com.tencent.mm.modelstat.b.b.fRH, 0);
      break;
      label372:
      ab.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[] { Long.valueOf(this.cpO) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v
 * JD-Core Version:    0.7.0.1
 */