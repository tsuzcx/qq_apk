package com.tencent.mm.modelsimple;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.h;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.ol;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bmd;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;

public final class t
  extends com.tencent.mm.ah.m
  implements k
{
  private static final ai eAg = new ai("deleteRevokeMessageThread");
  private final long bIt;
  private f dmL;
  private final String eAh;
  private final com.tencent.mm.ah.b esv;
  
  public t(bi parambi, String paramString)
  {
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Dz().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = bk.getInt(localObject.toString(), 0);; i = 0)
    {
      this.bIt = parambi.field_msgId;
      this.eAh = paramString;
      localObject = null;
      int k = 0;
      int m = (int)(parambi.field_createTime / 1000L);
      long l = parambi.field_msgSvrId;
      String str1 = com.tencent.mm.model.q.Gj();
      String str2 = parambi.field_talker;
      int j = k;
      paramString = (String)localObject;
      if (parambi.cQJ != 1) {}
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
          parambi.ecH = new bmd();
          parambi.ecI = new bme();
          parambi.uri = "/cgi-bin/micromsg-bin/revokemsg";
          parambi.ecG = 594;
          parambi.ecJ = 0;
          parambi.ecK = 0;
          this.esv = parambi.Kt();
          parambi = (bmd)this.esv.ecE.ecN;
          parambi.swQ = paramString;
          parambi.tFB = j;
          parambi.tFC = 0;
          parambi.tFE = l;
          parambi.mPL = m;
          parambi.kWn = str1;
          parambi.kWm = str2;
          parambi.tFD = i;
          y.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { parambi.swQ, Integer.valueOf(parambi.tFB), Integer.valueOf(parambi.tFC), Integer.valueOf(parambi.mPL), parambi.kWn, parambi.kWm, Integer.valueOf(parambi.tFD) });
          return;
          j = com.tencent.mm.model.o.l(com.tencent.mm.model.q.Gj(), parambi.field_createTime).hashCode();
          y.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[] { Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          parambi = com.tencent.mm.modelvoice.m.Tg().oJ(parambi.field_imgPath);
          j = k;
          paramString = (String)localObject;
          if (parambi != null)
          {
            paramString = parambi.clientId;
            y.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            paramString = parambi.field_imgPath;
            y.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            localObject = com.tencent.mm.as.o.OJ().bY(parambi.field_msgId);
            paramString = parambi.cQM;
            y.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[] { parambi.field_talker, Integer.valueOf(((com.tencent.mm.as.e)localObject).enz), Long.valueOf(((com.tencent.mm.as.e)localObject).enp), paramString });
            j = k;
            continue;
            paramString = String.valueOf(com.tencent.mm.storage.ap.abP(parambi.field_content).time);
            y.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[] { paramString });
            j = k;
          }
        }
      }
      paramString = com.tencent.mm.pluginsdk.model.app.ap.avh().gY(parambi.field_msgId);
      if (paramString != null) {}
      for (parambi = paramString.field_clientAppDataId;; parambi = parambi.field_talker + parambi.field_msgId + "T" + parambi.field_createTime)
      {
        y.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[] { parambi });
        j = k;
        paramString = parambi;
        break;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, bi parambi, String paramString3)
  {
    if ((parambi.getType() == 1) || (parambi.getType() == 16777265))
    {
      parambi.setType(10002);
      parambi.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent></invokeMessage></sysmsg>", new Object[] { paramString1, Long.valueOf(System.currentTimeMillis()), paramString2, paramString3 }));
      return;
    }
    parambi.setType(10000);
    parambi.setContent(paramString1);
  }
  
  public final bme QN()
  {
    return (bme)this.esv.ecF.ecN;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      au.Hx();
      paramq = com.tencent.mm.model.c.Fy().fd(this.bIt);
      if (paramq.field_msgId != this.bIt) {
        break label360;
      }
      paramArrayOfByte = QN();
      y.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", new Object[] { Long.valueOf(paramq.field_msgId), Long.valueOf(paramq.field_msgSvrId), paramArrayOfByte.tFG });
      int i = paramq.getType();
      a(this.eAh, "  " + ae.getContext().getString(R.l.invoke_message_reedit_tip), paramq, paramq.field_content);
      paramq.fA(0);
      paramq.ff(paramq.czq | 0x4);
      paramArrayOfByte = new ol();
      paramArrayOfByte.bYc.bIt = this.bIt;
      a.udP.m(paramArrayOfByte);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(paramq.field_msgId, paramq);
      paramInt1 = 0;
      au.Hx();
      paramArrayOfByte = com.tencent.mm.model.c.Dz().get(290818, Integer.valueOf(0));
      if (paramArrayOfByte != null) {
        paramInt1 = bk.getInt(paramArrayOfByte.toString(), 0);
      }
      au.Hx();
      com.tencent.mm.model.c.Dz().o(290818, Integer.valueOf(paramInt1 + 1));
      paramq.setType(i);
      if (!paramq.aVK()) {
        break label333;
      }
      paramArrayOfByte = com.tencent.mm.modelstat.b.eBD;
      paramInt1 = h.g(paramq);
      if (paramArrayOfByte.Rm()) {
        paramArrayOfByte.a(paramq, com.tencent.mm.modelstat.b.b.eBQ, paramInt1);
      }
      eAg.k(new t.1(this, paramq), 300000L);
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label333:
      paramArrayOfByte = com.tencent.mm.modelstat.b.eBD;
      if (!paramArrayOfByte.Rm()) {
        break;
      }
      paramArrayOfByte.a(paramq, com.tencent.mm.modelstat.b.b.eBQ, 0);
      break;
      label360:
      y.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[] { Long.valueOf(this.bIt) });
    }
  }
  
  public final int getType()
  {
    return 594;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.t
 * JD-Core Version:    0.7.0.1
 */