package com.tencent.mm.modelsimple;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.qc;
import com.tencent.mm.autogen.a.vn;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.d.ad;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.esl;
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class x
  extends p
  implements m
{
  private static final MMHandler oTi;
  private com.tencent.mm.am.h callback;
  private final long msgId;
  private final com.tencent.mm.am.c oDw;
  private final String oTj;
  private String oTk;
  private final long oTl;
  
  static
  {
    AppMethodBeat.i(20646);
    oTi = new MMHandler("deleteRevokeMessageThread");
    AppMethodBeat.o(20646);
  }
  
  public x(cc paramcc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(236745);
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.ban().d(290818, Integer.valueOf(0));
    if (localObject != null) {}
    for (int i = Util.getInt(localObject.toString(), 0);; i = 0)
    {
      this.msgId = paramcc.field_msgId;
      this.oTj = paramString1;
      localObject = null;
      int k = 0;
      int m = (int)(paramcc.getCreateTime() / 1000L);
      long l = paramcc.field_msgSvrId;
      this.oTl = l;
      String str1 = com.tencent.mm.model.z.bAM();
      String str2 = paramcc.field_talker;
      int j = k;
      paramString1 = (String)localObject;
      if (paramcc.kLk != 1) {
        switch (paramcc.getType())
        {
        default: 
          paramString1 = (String)localObject;
          j = k;
        }
      }
      for (;;)
      {
        paramcc = new c.a();
        paramcc.otE = new esl();
        paramcc.otF = new esm();
        paramcc.uri = "/cgi-bin/micromsg-bin/revokemsg";
        paramcc.funcId = 594;
        paramcc.otG = 0;
        paramcc.respCmdId = 0;
        this.oDw = paramcc.bEF();
        paramcc = (esl)c.b.b(this.oDw.otB);
        paramcc.YHk = paramString1;
        paramcc.abwb = j;
        paramcc.abwc = 0;
        paramcc.abwe = l;
        paramcc.CreateTime = m;
        paramcc.IMh = str1;
        paramcc.IMg = str2;
        paramcc.abwd = i;
        paramcc.abwf = paramString2;
        this.oTk = paramString2;
        Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[] { paramcc.YHk, Integer.valueOf(paramcc.abwb), Integer.valueOf(paramcc.abwc), Integer.valueOf(paramcc.CreateTime), paramcc.IMh, paramcc.IMg, Integer.valueOf(paramcc.abwd) });
        AppMethodBeat.o(236745);
        return;
        j = com.tencent.mm.model.x.z(com.tencent.mm.model.z.bAM(), paramcc.getCreateTime()).hashCode();
        Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[] { Integer.valueOf(j) });
        paramString1 = (String)localObject;
        continue;
        paramcc = o.bPf().QT(paramcc.field_imgPath);
        j = k;
        paramString1 = (String)localObject;
        if (paramcc != null)
        {
          paramString1 = paramcc.clientId;
          Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[] { paramString1 });
          j = k;
          continue;
          paramString1 = paramcc.field_imgPath;
          Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[] { paramString1 });
          j = k;
          continue;
          localObject = com.tencent.mm.modelimage.r.bKa().H(paramcc.field_talker, paramcc.field_msgId);
          paramString1 = paramcc.kLn;
          Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[] { paramcc.field_talker, Integer.valueOf(((com.tencent.mm.modelimage.h)localObject).oGB), Long.valueOf(((com.tencent.mm.modelimage.h)localObject).localId), paramString1 });
          j = k;
          continue;
          paramString1 = String.valueOf(bg.byj(paramcc.field_content).time);
          Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[] { paramString1 });
          j = k;
          continue;
          paramString1 = as.cWJ().yi(paramcc.field_msgId);
          if (paramString1 != null) {}
          for (paramcc = paramString1.field_clientAppDataId;; paramcc = paramcc.field_talker + paramcc.field_msgId + "T" + paramcc.getCreateTime())
          {
            Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[] { paramcc });
            j = k;
            paramString1 = paramcc;
            break;
          }
          paramString1 = paramcc.field_talker + paramcc.field_msgId + "T" + paramcc.getCreateTime();
          j = k;
        }
      }
    }
  }
  
  private static String Pb(String paramString)
  {
    AppMethodBeat.i(236751);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(236751);
      return "";
    }
    try
    {
      String str = Base64.encodeToString(paramString.getBytes(), 0);
      AppMethodBeat.o(236751);
      return str;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.NetSceneRevokeMsg", localThrowable, "safeBase64Encode err:%s", new Object[] { paramString });
      AppMethodBeat.o(236751);
    }
    return "";
  }
  
  public static void a(String paramString1, String paramString2, cc paramcc, String paramString3)
  {
    AppMethodBeat.i(20645);
    if (al(paramcc))
    {
      String str = paramString3;
      if (paramcc.getType() == 822083633) {
        str = Pb(paramString3);
      }
      paramString3 = Pb(paramcc.jUr);
      int i = paramcc.getType();
      paramcc.setType(268445458);
      paramString1 = String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent><type><![CDATA[%s]]></type><msgSource><![CDATA[%s]]></msgSource></invokeMessage></sysmsg>", new Object[] { paramString1, Long.valueOf(cn.bDu()), paramString2, "", Integer.valueOf(i), paramString3 });
      paramcc.setContent(str);
      paramcc.Cf(paramString1);
      AppMethodBeat.o(20645);
      return;
    }
    paramcc.setType(268445456);
    paramcc.setContent(paramString1);
    paramcc.Cf(paramString1);
    AppMethodBeat.o(20645);
  }
  
  private static boolean al(cc paramcc)
  {
    AppMethodBeat.i(236747);
    if (paramcc != null)
    {
      if ((paramcc.getType() == 1) || (paramcc.getType() == 16777265) || (paramcc.getType() == 822083633) || (paramcc.getType() == 805306417))
      {
        AppMethodBeat.o(236747);
        return true;
      }
      AppMethodBeat.o(236747);
      return false;
    }
    AppMethodBeat.o(236747);
    return false;
  }
  
  public final esm bMx()
  {
    AppMethodBeat.i(236767);
    esm localesm = (esm)c.c.b(this.oDw.otC);
    AppMethodBeat.o(236767);
    return localesm;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(20643);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(20643);
    return i;
  }
  
  public final int getType()
  {
    return 594;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final com.tencent.mm.network.s params, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20644);
    if (((paramInt2 == 0) && (paramInt3 == 0)) || (!Util.isNullOrNil(this.oTk)))
    {
      bh.bCz();
      params = com.tencent.mm.model.c.bzD().sl(this.msgId);
      if ((params == null) || (params.field_msgId != this.msgId)) {
        break label605;
      }
      if (params.getType() == 1090519089)
      {
        paramArrayOfByte = params.field_content;
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(20641);
            Object localObject = k.b.Hf(paramArrayOfByte);
            if ((localObject != null) && (((k.b)localObject).type == 6))
            {
              int i = n.am(x.a(x.this), ((k.b)localObject).title);
              Log.i("MicroMsg.NetSceneRevokeMsg", "pause msg:%s send, result:%s", new Object[] { Long.valueOf(x.a(x.this)), Integer.valueOf(i) });
            }
            localObject = com.tencent.mm.plugin.openapi.a.cWJ().yi(x.a(x.this));
            if (localObject != null)
            {
              y.deleteFile(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath);
              com.tencent.mm.plugin.openapi.a.cWJ().delete((IAutoDBItem)localObject, new String[] { "msgInfoId" });
            }
            AppMethodBeat.o(20641);
          }
        });
      }
      for (;;)
      {
        paramArrayOfByte = cc.bI(params);
        localObject = bMx();
        if (localObject != null) {
          break;
        }
        AppMethodBeat.o(20644);
        return;
        if ((params.getType() == 43) && (ab.bOG()))
        {
          paramArrayOfByte = ab.Qo(params.field_imgPath);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.status != 199))
          {
            ab.Qi(params.field_imgPath);
            params.setStatus(4);
            com.tencent.threadpool.h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(236752);
                String str = paramArrayOfByte.getFileName();
                try
                {
                  v.bOh();
                  new u(aa.PY(str)).diJ();
                  v.bOh();
                  new u(aa.PX(str)).diJ();
                  str = paramArrayOfByte.oYk;
                  if (Util.isNullOrNil(str))
                  {
                    AppMethodBeat.o(236752);
                    return;
                  }
                }
                catch (Exception localException1)
                {
                  for (;;)
                  {
                    Log.e("MicroMsg.NetSceneRevokeMsg", "ERR: Delete file Failed" + f.aPX() + " file:" + str + " msg:" + localException1.getMessage());
                  }
                  try
                  {
                    v.bOh();
                    new u(aa.PY(str)).diJ();
                    v.bOh();
                    new u(aa.PX(str)).diJ();
                    AppMethodBeat.o(236752);
                    return;
                  }
                  catch (Exception localException2)
                  {
                    Log.e("MicroMsg.NetSceneRevokeMsg", "ERR: Delete file Failed" + f.aPX() + " file:" + str + " msg:" + localException2.getMessage());
                    AppMethodBeat.o(236752);
                  }
                }
              }
            });
          }
        }
      }
      Log.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s， type:%s", new Object[] { Long.valueOf(params.field_msgId), Long.valueOf(params.field_msgSvrId), ((esm)localObject).abwg, Integer.valueOf(params.getType()) });
      int i = params.getType();
      a(this.oTj, "  " + MMApplicationContext.getContext().getString(R.l.gKc), params, params.field_content);
      params.pI(0);
      params.jbY();
      Object localObject = new vn();
      ((vn)localObject).hZk.msgId = this.msgId;
      ((vn)localObject).publish();
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(params.field_msgId, params);
      ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySelf(params.field_msgId);
      paramInt1 = 0;
      bh.bCz();
      localObject = com.tencent.mm.model.c.ban().d(290818, Integer.valueOf(0));
      if (localObject != null) {
        paramInt1 = Util.getInt(localObject.toString(), 0);
      }
      bh.bCz();
      com.tencent.mm.model.c.ban().B(290818, Integer.valueOf(paramInt1 + 1));
      params.setType(i);
      if (!params.fxR()) {
        break label594;
      }
      b.oUZ.f(params, l.v(params));
      oTi.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(236748);
          Log.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[] { Long.valueOf(params.field_msgId) });
          params.setType(10002);
          x.a(x.b(x.this), "", params, "");
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(params.field_msgId, params);
          AppMethodBeat.o(236748);
        }
      }, 300000L);
      if (ad.i(paramArrayOfByte))
      {
        localObject = new qc();
        ((qc)localObject).hTl.hTm = paramArrayOfByte;
        ((qc)localObject).publish();
      }
      if ((ab.bOG()) && (params.dSH()))
      {
        paramArrayOfByte = ab.Qo(params.field_imgPath);
        if ((paramArrayOfByte != null) && (paramArrayOfByte.hTh != this.oTl)) {
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(236749);
              params.gX(paramArrayOfByte.hTh);
              params.setType(43);
              x localx = new x(params, x.b(x.this), x.c(x.this));
              bh.aZW().a(localx, 0);
              AppMethodBeat.o(236749);
            }
          });
        }
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20644);
      return;
      label594:
      b.oUZ.ap(params);
      break;
      label605:
      Log.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[] { Long.valueOf(this.msgId) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.x
 * JD-Core Version:    0.7.0.1
 */