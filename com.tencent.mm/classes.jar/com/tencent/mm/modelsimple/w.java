package com.tencent.mm.modelsimple;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.l;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelstat.b.b;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.msgquote.a;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;

public final class w
  extends com.tencent.mm.ak.q
  implements m
{
  private static final MMHandler jkv;
  private com.tencent.mm.ak.i callback;
  private final com.tencent.mm.ak.d iUB;
  private final String jkw;
  private final long msgId;
  
  static
  {
    AppMethodBeat.i(20646);
    jkv = new MMHandler("deleteRevokeMessageThread");
    AppMethodBeat.o(20646);
  }
  
  public w(ca paramca, String paramString)
  {
    AppMethodBeat.i(20642);
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.azQ().get(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = Util.getInt(localObject.toString(), 0);; i = 0)
    {
      this.msgId = paramca.field_msgId;
      this.jkw = paramString;
      localObject = null;
      int k = 0;
      int m = (int)(paramca.field_createTime / 1000L);
      long l = paramca.field_msgSvrId;
      String str1 = z.aTY();
      String str2 = paramca.field_talker;
      int j = k;
      paramString = (String)localObject;
      if (paramca.fQV != 1) {}
      switch (paramca.getType())
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
          paramca = new d.a();
          paramca.iLN = new dpk();
          paramca.iLO = new dpl();
          paramca.uri = "/cgi-bin/micromsg-bin/revokemsg";
          paramca.funcId = 594;
          paramca.iLP = 0;
          paramca.respCmdId = 0;
          this.iUB = paramca.aXF();
          paramca = (dpk)this.iUB.iLK.iLR;
          paramca.KIz = paramString;
          paramca.MSH = j;
          paramca.MSI = 0;
          paramca.MSK = l;
          paramca.CreateTime = m;
          paramca.xNH = str1;
          paramca.xNG = str2;
          paramca.MSJ = i;
          Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { paramca.KIz, Integer.valueOf(paramca.MSH), Integer.valueOf(paramca.MSI), Integer.valueOf(paramca.CreateTime), paramca.xNH, paramca.xNG, Integer.valueOf(paramca.MSJ) });
          AppMethodBeat.o(20642);
          return;
          j = x.x(z.aTY(), paramca.field_createTime).hashCode();
          Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[] { Integer.valueOf(j) });
          paramString = (String)localObject;
          continue;
          paramca = o.bib().Rr(paramca.field_imgPath);
          j = k;
          paramString = (String)localObject;
          if (paramca != null)
          {
            paramString = paramca.clientId;
            Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            paramString = paramca.field_imgPath;
            Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[] { paramString });
            j = k;
            continue;
            localObject = com.tencent.mm.av.q.bcR().H(paramca.field_talker, paramca.field_msgId);
            paramString = paramca.fQY;
            Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[] { paramca.field_talker, Integer.valueOf(((com.tencent.mm.av.g)localObject).iXx), Long.valueOf(((com.tencent.mm.av.g)localObject).localId), paramString });
            j = k;
            continue;
            paramString = String.valueOf(be.bkr(paramca.field_content).time);
            Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[] { paramString });
            j = k;
          }
        }
      }
      paramString = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(paramca.field_msgId);
      if (paramString != null) {}
      for (paramca = paramString.field_clientAppDataId;; paramca = paramca.field_talker + paramca.field_msgId + "T" + paramca.field_createTime)
      {
        Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[] { paramca });
        j = k;
        paramString = paramca;
        break;
      }
    }
  }
  
  private static String PD(String paramString)
  {
    AppMethodBeat.i(231570);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(231570);
      return "";
    }
    try
    {
      String str = Base64.encodeToString(paramString.getBytes(), 0);
      AppMethodBeat.o(231570);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneRevokeMsg", localThrowable, "safeBase64Encode err:%s", new Object[] { paramString });
      AppMethodBeat.o(231570);
    }
    return "";
  }
  
  public static void a(String paramString1, String paramString2, ca paramca, String paramString3)
  {
    AppMethodBeat.i(20645);
    if (aa(paramca))
    {
      String str = paramString3;
      if (paramca.getType() == 822083633) {
        str = PD(paramString3);
      }
      paramString3 = PD(paramca.fqK);
      int i = paramca.getType();
      paramca.setType(10002);
      paramca.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent><type><![CDATA[%s]]></type><msgSource><![CDATA[%s]]></msgSource></invokeMessage></sysmsg>", new Object[] { paramString1, Long.valueOf(cl.aWy()), paramString2, str, Integer.valueOf(i), paramString3 }));
      AppMethodBeat.o(20645);
      return;
    }
    paramca.setType(10000);
    paramca.setContent(paramString1);
    AppMethodBeat.o(20645);
  }
  
  private static boolean aa(ca paramca)
  {
    AppMethodBeat.i(231569);
    if (paramca != null)
    {
      if ((paramca.getType() == 1) || (paramca.getType() == 16777265) || (paramca.getType() == 822083633))
      {
        AppMethodBeat.o(231569);
        return true;
      }
      AppMethodBeat.o(231569);
      return false;
    }
    AppMethodBeat.o(231569);
    return false;
  }
  
  public final dpl bfA()
  {
    return (dpl)this.iUB.iLL.iLR;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(20643);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
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
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bg.aVF();
      paramArrayOfByte = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
      if (paramArrayOfByte.field_msgId != this.msgId) {
        break label445;
      }
      params = ca.aZ(paramArrayOfByte);
      localObject = bfA();
      Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s， type:%s", new Object[] { Long.valueOf(paramArrayOfByte.field_msgId), Long.valueOf(paramArrayOfByte.field_msgSvrId), ((dpl)localObject).MSL, Integer.valueOf(paramArrayOfByte.getType()) });
      int i = paramArrayOfByte.getType();
      a(this.jkw, "  " + MMApplicationContext.getContext().getString(2131761865), paramArrayOfByte, paramArrayOfByte.field_content);
      paramArrayOfByte.nv(0);
      paramArrayOfByte.nc(paramArrayOfByte.fqJ | 0x4);
      localObject = new sx();
      ((sx)localObject).dZt.msgId = this.msgId;
      EventCenter.instance.publish((IEvent)localObject);
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(paramArrayOfByte.field_msgId, paramArrayOfByte);
      ((a)com.tencent.mm.kernel.g.ah(a.class)).handleRevokeMsgBySelf(paramArrayOfByte.field_msgId);
      paramInt1 = 0;
      bg.aVF();
      localObject = com.tencent.mm.model.c.azQ().get(290818, Integer.valueOf(0));
      if (localObject != null) {
        paramInt1 = Util.getInt(localObject.toString(), 0);
      }
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(290818, Integer.valueOf(paramInt1 + 1));
      paramArrayOfByte.setType(i);
      if (!paramArrayOfByte.dOQ()) {
        break label418;
      }
      localObject = b.jmd;
      paramInt1 = l.t(paramArrayOfByte);
      if (((b)localObject).bfZ()) {
        ((b)localObject).a(paramArrayOfByte, b.b.jmq, paramInt1);
      }
      jkv.postDelayed(new w.1(this, paramArrayOfByte), 300000L);
      if (aa.i(params))
      {
        paramArrayOfByte = new nv();
        paramArrayOfByte.dTW.dTX = params;
        EventCenter.instance.publish(paramArrayOfByte);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20644);
      return;
      label418:
      localObject = b.jmd;
      if (!((b)localObject).bfZ()) {
        break;
      }
      ((b)localObject).a(paramArrayOfByte, b.b.jmq, 0);
      break;
      label445:
      Log.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[] { Long.valueOf(this.msgId) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w
 * JD-Core Version:    0.7.0.1
 */