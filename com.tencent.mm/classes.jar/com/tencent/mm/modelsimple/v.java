package com.tencent.mm.modelsimple;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.l;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bu;

public final class v
  extends n
  implements k
{
  private static final ap imu;
  private f callback;
  private final com.tencent.mm.al.b hWL;
  private final String imv;
  private final long msgId;
  
  static
  {
    AppMethodBeat.i(20646);
    imu = new ap("deleteRevokeMessageThread");
    AppMethodBeat.o(20646);
  }
  
  public v(bu parambu, String paramString)
  {
    AppMethodBeat.i(20642);
    ba.aBQ();
    Object localObject = com.tencent.mm.model.c.ajl().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = bt.getInt(localObject.toString(), 0);; i = 0)
    {
      this.msgId = parambu.field_msgId;
      this.imv = paramString;
      localObject = null;
      int k = 0;
      int m = (int)(parambu.field_createTime / 1000L);
      long l = parambu.field_msgSvrId;
      String str1 = u.aAm();
      String str2 = parambu.field_talker;
      int j = k;
      paramString = (String)localObject;
      if (parambu.fku != 1) {}
      switch (parambu.getType())
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
          parambu = new b.a();
          parambu.hNM = new cvw();
          parambu.hNN = new cvx();
          parambu.uri = "/cgi-bin/micromsg-bin/revokemsg";
          parambu.funcId = 594;
          parambu.hNO = 0;
          parambu.respCmdId = 0;
          this.hWL = parambu.aDC();
          parambu = (cvw)this.hWL.hNK.hNQ;
          parambu.Fwt = paramString;
          parambu.HnV = j;
          parambu.HnW = 0;
          parambu.HnY = l;
          parambu.CreateTime = m;
          parambu.ukj = str1;
          parambu.uki = str2;
          parambu.HnX = i;
          ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { parambu.Fwt, Integer.valueOf(parambu.HnV), Integer.valueOf(parambu.HnW), Integer.valueOf(parambu.CreateTime), parambu.ukj, parambu.uki, Integer.valueOf(parambu.HnX) });
          AppMethodBeat.o(20642);
          return;
          j = s.w(u.aAm(), parambu.field_createTime).hashCode();
          ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[] { Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          parambu = o.aNy().Id(parambu.field_imgPath);
          j = k;
          paramString = (String)localObject;
          if (parambu != null)
          {
            paramString = parambu.clientId;
            ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            paramString = parambu.field_imgPath;
            ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            localObject = com.tencent.mm.aw.q.aIF().G(parambu.field_talker, parambu.field_msgId);
            paramString = parambu.fkx;
            ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[] { parambu.field_talker, Integer.valueOf(((com.tencent.mm.aw.g)localObject).hZH), Long.valueOf(((com.tencent.mm.aw.g)localObject).dnz), paramString });
            j = k;
            continue;
            paramString = String.valueOf(ay.aTS(parambu.field_content).time);
            ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[] { paramString });
            j = k;
          }
        }
      }
      paramString = ao.bIX().CB(parambu.field_msgId);
      if (paramString != null) {}
      for (parambu = paramString.field_clientAppDataId;; parambu = parambu.field_talker + parambu.field_msgId + "T" + parambu.field_createTime)
      {
        ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[] { parambu });
        j = k;
        paramString = parambu;
        break;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, bu parambu, String paramString3)
  {
    AppMethodBeat.i(20645);
    if ((parambu.getType() == 1) || (parambu.getType() == 16777265))
    {
      parambu.setType(10002);
      parambu.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent></invokeMessage></sysmsg>", new Object[] { paramString1, Long.valueOf(cf.aCK()), paramString2, paramString3 }));
      AppMethodBeat.o(20645);
      return;
    }
    parambu.setType(10000);
    parambu.setContent(paramString1);
    AppMethodBeat.o(20645);
  }
  
  public final cvx aLa()
  {
    return (cvx)this.hWL.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20643);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
      ba.aBQ();
      paramArrayOfByte = com.tencent.mm.model.c.azs().xY(this.msgId);
      if (paramArrayOfByte.field_msgId != this.msgId) {
        break label434;
      }
      paramq = bu.aN(paramArrayOfByte);
      localObject = aLa();
      ad.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", new Object[] { Long.valueOf(paramArrayOfByte.field_msgId), Long.valueOf(paramArrayOfByte.field_msgSvrId), ((cvx)localObject).Hoa });
      int i = paramArrayOfByte.getType();
      a(this.imv, "  " + aj.getContext().getString(2131760420), paramArrayOfByte, paramArrayOfByte.field_content);
      paramArrayOfByte.kr(0);
      paramArrayOfByte.jY(paramArrayOfByte.eLr | 0x4);
      localObject = new sa();
      ((sa)localObject).dGC.msgId = this.msgId;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(paramArrayOfByte.field_msgId, paramArrayOfByte);
      ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySelf(paramArrayOfByte.field_msgId);
      paramInt1 = 0;
      ba.aBQ();
      localObject = com.tencent.mm.model.c.ajl().get(290818, Integer.valueOf(0));
      if (localObject != null) {
        paramInt1 = bt.getInt(localObject.toString(), 0);
      }
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(290818, Integer.valueOf(paramInt1 + 1));
      paramArrayOfByte.setType(i);
      if (!paramArrayOfByte.cTc()) {
        break label407;
      }
      localObject = com.tencent.mm.modelstat.b.inZ;
      paramInt1 = l.r(paramArrayOfByte);
      if (((com.tencent.mm.modelstat.b)localObject).aLz()) {
        ((com.tencent.mm.modelstat.b)localObject).a(paramArrayOfByte, com.tencent.mm.modelstat.b.b.iom, paramInt1);
      }
      imu.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20641);
          ad.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[] { Long.valueOf(paramArrayOfByte.field_msgId) });
          paramArrayOfByte.setType(10002);
          v.a(v.a(v.this), "", paramArrayOfByte, "");
          ba.aBQ();
          com.tencent.mm.model.c.azs().a(paramArrayOfByte.field_msgId, paramArrayOfByte);
          AppMethodBeat.o(20641);
        }
      }, 300000L);
      if (aa.i(paramq))
      {
        paramArrayOfByte = new nd();
        paramArrayOfByte.dBc.dBd = paramq;
        com.tencent.mm.sdk.b.a.IbL.l(paramArrayOfByte);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20644);
      return;
      label407:
      localObject = com.tencent.mm.modelstat.b.inZ;
      if (!((com.tencent.mm.modelstat.b)localObject).aLz()) {
        break;
      }
      ((com.tencent.mm.modelstat.b)localObject).a(paramArrayOfByte, com.tencent.mm.modelstat.b.b.iom, 0);
      break;
      label434:
      ad.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[] { Long.valueOf(this.msgId) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v
 * JD-Core Version:    0.7.0.1
 */