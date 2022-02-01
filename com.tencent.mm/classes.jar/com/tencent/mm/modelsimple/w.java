package com.tencent.mm.modelsimple;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.l;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.f.a.os;
import com.tencent.mm.f.a.ty;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.msgquote.a;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;

public final class w
  extends com.tencent.mm.an.q
  implements m
{
  private static final MMHandler mat;
  private com.tencent.mm.an.i callback;
  private final com.tencent.mm.an.d lKU;
  private final String mau;
  private String mav;
  private final long msgId;
  
  static
  {
    AppMethodBeat.i(20646);
    mat = new MMHandler("deleteRevokeMessageThread");
    AppMethodBeat.o(20646);
  }
  
  public w(ca paramca, String paramString1, String paramString2)
  {
    AppMethodBeat.i(274316);
    bh.beI();
    Object localObject = com.tencent.mm.model.c.aHp().b(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = Util.getInt(localObject.toString(), 0);; i = 0)
    {
      this.msgId = paramca.field_msgId;
      this.mau = paramString1;
      localObject = null;
      int k = 0;
      int m = (int)(paramca.field_createTime / 1000L);
      long l = paramca.field_msgSvrId;
      String str1 = z.bcZ();
      String str2 = paramca.field_talker;
      int j = k;
      paramString1 = (String)localObject;
      if (paramca.ill != 1) {
        switch (paramca.getType())
        {
        default: 
          paramString1 = (String)localObject;
          j = k;
        }
      }
      for (;;)
      {
        paramca = new d.a();
        paramca.lBU = new dzg();
        paramca.lBV = new dzh();
        paramca.uri = "/cgi-bin/micromsg-bin/revokemsg";
        paramca.funcId = 594;
        paramca.lBW = 0;
        paramca.respCmdId = 0;
        this.lKU = paramca.bgN();
        paramca = (dzg)d.b.b(this.lKU.lBR);
        paramca.RJQ = paramString1;
        paramca.UeO = j;
        paramca.UeP = 0;
        paramca.UeR = l;
        paramca.CreateTime = m;
        paramca.CRR = str1;
        paramca.CRQ = str2;
        paramca.UeQ = i;
        paramca.UeS = paramString2;
        this.mav = paramString2;
        Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { paramca.RJQ, Integer.valueOf(paramca.UeO), Integer.valueOf(paramca.UeP), Integer.valueOf(paramca.CreateTime), paramca.CRR, paramca.CRQ, Integer.valueOf(paramca.UeQ) });
        AppMethodBeat.o(274316);
        return;
        j = x.u(z.bcZ(), paramca.field_createTime).hashCode();
        Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[] { Integer.valueOf(j) });
        paramString1 = (String)localObject;
        continue;
        paramca = o.brz().YO(paramca.field_imgPath);
        j = k;
        paramString1 = (String)localObject;
        if (paramca != null)
        {
          paramString1 = paramca.clientId;
          Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[] { paramString1 });
          j = k;
          continue;
          paramString1 = paramca.field_imgPath;
          Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[] { paramString1 });
          j = k;
          continue;
          localObject = com.tencent.mm.ay.q.bmh().D(paramca.field_talker, paramca.field_msgId);
          paramString1 = paramca.ilo;
          Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[] { paramca.field_talker, Integer.valueOf(((com.tencent.mm.ay.g)localObject).lNR), Long.valueOf(((com.tencent.mm.ay.g)localObject).localId), paramString1 });
          j = k;
          continue;
          paramString1 = String.valueOf(be.bwQ(paramca.field_content).time);
          Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[] { paramString1 });
          j = k;
          continue;
          paramString1 = com.tencent.mm.pluginsdk.model.app.ao.ctZ().TR(paramca.field_msgId);
          if (paramString1 != null) {}
          for (paramca = paramString1.field_clientAppDataId;; paramca = paramca.field_talker + paramca.field_msgId + "T" + paramca.field_createTime)
          {
            Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[] { paramca });
            j = k;
            paramString1 = paramca;
            break;
          }
          paramString1 = paramca.field_talker + paramca.field_msgId + "T" + paramca.field_createTime;
          j = k;
        }
      }
    }
  }
  
  private static String Xb(String paramString)
  {
    AppMethodBeat.i(274318);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(274318);
      return "";
    }
    try
    {
      String str = Base64.encodeToString(paramString.getBytes(), 0);
      AppMethodBeat.o(274318);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneRevokeMsg", localThrowable, "safeBase64Encode err:%s", new Object[] { paramString });
      AppMethodBeat.o(274318);
    }
    return "";
  }
  
  public static void a(String paramString1, String paramString2, ca paramca, String paramString3)
  {
    AppMethodBeat.i(20645);
    if (ag(paramca))
    {
      String str = paramString3;
      if (paramca.getType() == 822083633) {
        str = Xb(paramString3);
      }
      paramString3 = Xb(paramca.hxy);
      int i = paramca.getType();
      paramca.setType(268445458);
      paramString1 = String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent><type><![CDATA[%s]]></type><msgSource><![CDATA[%s]]></msgSource></invokeMessage></sysmsg>", new Object[] { paramString1, Long.valueOf(cm.bfC()), paramString2, "", Integer.valueOf(i), paramString3 });
      paramca.setContent(str);
      paramca.Jz(paramString1);
      AppMethodBeat.o(20645);
      return;
    }
    paramca.setType(268445456);
    paramca.setContent(paramString1);
    paramca.Jz(paramString1);
    AppMethodBeat.o(20645);
  }
  
  private static boolean ag(ca paramca)
  {
    AppMethodBeat.i(274317);
    if (paramca != null)
    {
      if ((paramca.getType() == 1) || (paramca.getType() == 16777265) || (paramca.getType() == 822083633))
      {
        AppMethodBeat.o(274317);
        return true;
      }
      AppMethodBeat.o(274317);
      return false;
    }
    AppMethodBeat.o(274317);
    return false;
  }
  
  public final dzh boQ()
  {
    AppMethodBeat.i(274320);
    dzh localdzh = (dzh)d.c.b(this.lKU.lBS);
    AppMethodBeat.o(274320);
    return localdzh;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(20643);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(20643);
    return i;
  }
  
  public final int getType()
  {
    return 594;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20644);
    if (((paramInt2 == 0) && (paramInt3 == 0)) || (!Util.isNullOrNil(this.mav)))
    {
      bh.beI();
      params = com.tencent.mm.model.c.bbO().Oq(this.msgId);
      if (params.field_msgId != this.msgId) {
        break label464;
      }
      if (params.getType() == 1090519089)
      {
        paramArrayOfByte = params.field_content;
        com.tencent.e.h.ZvG.be(new w.1(this, paramArrayOfByte));
      }
      paramArrayOfByte = ca.bs(params);
      Object localObject = boQ();
      if (localObject == null)
      {
        AppMethodBeat.o(20644);
        return;
      }
      Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s， type:%s", new Object[] { Long.valueOf(params.field_msgId), Long.valueOf(params.field_msgSvrId), ((dzh)localObject).UeT, Integer.valueOf(params.getType()) });
      int i = params.getType();
      a(this.mau, "  " + MMApplicationContext.getContext().getString(R.l.eIv), params, params.field_content);
      params.pJ(0);
      params.hzU();
      localObject = new ty();
      ((ty)localObject).fTm.msgId = this.msgId;
      EventCenter.instance.publish((IEvent)localObject);
      bh.beI();
      com.tencent.mm.model.c.bbO().a(params.field_msgId, params);
      ((a)com.tencent.mm.kernel.h.ag(a.class)).handleRevokeMsgBySelf(params.field_msgId);
      paramInt1 = 0;
      bh.beI();
      localObject = com.tencent.mm.model.c.aHp().b(290818, Integer.valueOf(0));
      if (localObject != null) {
        paramInt1 = Util.getInt(localObject.toString(), 0);
      }
      bh.beI();
      com.tencent.mm.model.c.aHp().i(290818, Integer.valueOf(paramInt1 + 1));
      params.setType(i);
      if (!params.erk()) {
        break label453;
      }
      b.mcf.f(params, l.v(params));
      mat.postDelayed(new w.2(this, params), 300000L);
      if (aa.i(paramArrayOfByte))
      {
        params = new os();
        params.fNy.fNz = paramArrayOfByte;
        EventCenter.instance.publish(params);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20644);
      return;
      label453:
      b.mcf.ak(params);
      break;
      label464:
      Log.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[] { Long.valueOf(this.msgId) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w
 * JD-Core Version:    0.7.0.1
 */