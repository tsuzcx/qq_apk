package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.b.l;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends n
  implements k
{
  protected static int dvk = 7;
  private f callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private f.a gIr;
  private aw hPc;
  private int ihj;
  private StringBuilder ihk;
  private long ihl;
  private boolean ihm;
  
  public b()
  {
    AppMethodBeat.i(132542);
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.ihj = 0;
    this.ihk = new StringBuilder();
    this.ihl = -1L;
    this.ihm = false;
    ae.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    this.gIr = new f.a();
    this.ihk.append("stack:" + bu.fpN() + " time:" + bu.aRi());
    AppMethodBeat.o(132542);
  }
  
  public b(final v.b paramb, int paramInt, long paramLong)
  {
    this();
    AppMethodBeat.i(132543);
    this.ihj = paramInt;
    this.ihl = paramLong;
    ae.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
    this.hPc = new aw(com.tencent.e.j.a.bbi("MMPushCore"), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132537);
        b.a(b.this);
        b.a locala = new b.a(paramb);
        b.this.onGYNetEnd(-1, 0, 0, "", locala, null);
        AppMethodBeat.o(132537);
        return false;
      }
    }, false);
    AppMethodBeat.o(132543);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(132546);
    super.cancel();
    AppMethodBeat.o(132546);
  }
  
  public final int doScene(e parame, f paramf)
  {
    boolean bool = false;
    AppMethodBeat.i(132547);
    this.callback = paramf;
    this.ihk.append(" lastd:" + this.lastdispatch + " dotime:" + bu.aRi() + " net:" + az.getNetType(ak.getContext()));
    int i = hashCode();
    int j = dvk;
    if (this.hPc != null) {
      bool = true;
    }
    ae.i("MicroMsg.NetPushSync", "doScene[%d] selector:%d pusher:%b ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    if (this.hPc != null)
    {
      prepareDispatcher(parame);
      this.hPc.ay(0L, 0L);
      this.hPc = null;
      AppMethodBeat.o(132547);
      return -1;
    }
    paramf = new a();
    paramf.uin = com.tencent.mm.network.ad.aPK().iHF.getUin();
    cdl localcdl = ((v.a)paramf.getReqObj()).FGV;
    localcdl.GjP = dvk;
    localcdl.GjQ = z.al(bu.aSx(ak.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.abv()).getString("notify_sync_key_keybuf", "")));
    localcdl.Scene = 1;
    localcdl.Hqt = new zy();
    localcdl.FSh = d.hjv;
    i = dispatch(parame, paramf, this);
    AppMethodBeat.o(132547);
    return i;
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132544);
    String str = this.ihk.toString();
    AppMethodBeat.o(132544);
    return str;
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132548);
    if ((paramq == null) || (paramq.getType() != 138))
    {
      if (paramq == null) {}
      for (paramInt1 = -2;; paramInt1 = paramq.getType())
      {
        ae.e("MicroMsg.NetPushSync", "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(132548);
        return;
      }
    }
    this.ihk.append(" endtime:" + bu.aRi());
    ae.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.ihm), Long.valueOf(this.gIr.abs()), this.ihk });
    v.b localb;
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
        AppMethodBeat.o(132548);
        return;
      }
      localb = (v.b)paramq.getRespObj();
      if (paramInt1 == 0)
      {
        paramString = z.a(((v.a)paramq.getReqObj()).FGV.GjQ);
        if (paramString == null)
        {
          paramInt1 = -1;
          ae.d("MicroMsg.NetPushSync", "dkpush req Key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), bu.cE(paramString) });
          if (!bu.cF(paramString)) {
            break label1820;
          }
          paramString = bu.aSx(ak.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.abv()).getString("notify_sync_key_keybuf", ""));
          ae.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bu.cE(paramString) });
          paramq = z.a(localb.FGW.GjQ);
          paramArrayOfByte = com.tencent.mm.protocal.ad.l(paramString, paramq);
          if (paramArrayOfByte != null)
          {
            paramString = paramArrayOfByte;
            if (paramArrayOfByte.length > 0) {}
          }
          else
          {
            ae.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
            paramString = paramq;
          }
          localb.FGW.GjQ = z.al(paramString);
          if ((localb.FGW.GjT != null) && (localb.FGW.GjT.nIE != null)) {
            break label726;
          }
          paramInt1 = 0;
          label438:
          ae.i("MicroMsg.NetPushSync", "newMsgSize:%d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramString != null) {
            break label744;
          }
          paramInt2 = -1;
          label464:
          ae.d("MicroMsg.NetPushSync", "newMsgSize:%d, mergeKey: %d[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bu.cE(paramString) });
        }
      }
      else
      {
        paramArrayOfByte = localb.FGW.GjT.nIE.iterator();
        paramInt2 = 0;
        label516:
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (zx)paramArrayOfByte.next();
          if (((zx)localObject1).Gru == 5) {
            paramString = z.a(((zx)localObject1).Grv);
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
        localObject2 = new cv();
        ((cv)localObject2).parseFrom(paramString);
        int i = ((cv)localObject2).urJ;
        paramString = ((cv)localObject2).FNG.HId;
        l = ((cv)localObject2).xrk;
        if (((cv)localObject2).FNM == null)
        {
          paramInt1 = 0;
          if (((cv)localObject2).FNI.HId != null) {
            continue;
          }
          paramInt3 = 0;
          ae.i("MicroMsg.NetPushSync", "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d", new Object[] { Integer.valueOf(i), paramString, Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
          paramInt1 = ((cv)localObject2).urJ;
          paramString = ((cv)localObject2).FNG.HId;
          paramq = ((cv)localObject2).FNI.HId;
          if (paramInt1 != 50) {
            continue;
          }
          ae.i("MicroMsg.NetPushSync", "hit voip");
          paramInt1 = 1;
          if (paramInt1 == 0) {
            continue;
          }
          paramInt2 = 1;
          break label516;
          paramInt1 = paramString.length;
          break label260;
          paramInt1 = localb.FGW.GjT.nIE.size();
          break label438;
          paramInt2 = paramString.length;
          break label464;
        }
        paramInt1 = ((cv)localObject2).FNM.length();
        continue;
        paramInt3 = ((cv)localObject2).FNI.HId.length();
        continue;
        if ((bu.isNullOrNil(paramq)) || (bu.isNullOrNil(paramString)))
        {
          ae.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
          break label1828;
        }
        if ((paramInt1 == 9998) && (paramString.equalsIgnoreCase("weixin")))
        {
          ae.i("MicroMsg.NetPushSync", "hit ipxx");
          paramInt1 = 1;
          continue;
        }
        if ((paramInt1 != 10002) || (!paramq.contains("revokemsg"))) {
          break label1828;
        }
        ae.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
        paramInt1 = 1;
        continue;
        l = ((cv)localObject2).xrk;
        str = ((cv)localObject2).FNG.HId;
        paramString = ((cv)localObject2).FNM;
        paramInt1 = ((cv)localObject2).urJ;
        if (!bu.isNullOrNil(paramString)) {
          break label978;
        }
        ae.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
        if (((cv)localObject2).urJ != 10002) {
          break label1210;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label516;
        }
        ae.i("MicroMsg.NetPushSync", "need remove pushContent");
        ((cv)localObject2).FNM = null;
        ((zx)localObject1).Grv = z.al(((cv)localObject2).toByteArray());
      }
      catch (IOException paramString)
      {
        ae.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
      }
      break label516;
      label978:
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      paramq = bu.aSA(paramString);
      paramInt3 = paramq.indexOf("<pushcontent");
      paramString = paramq;
      if (paramInt3 > 0) {
        paramString = paramq.substring(paramInt3);
      }
      paramString = bx.M(paramString, "pushcontent");
      if (paramString == null) {
        ae.e("MicroMsg.NetPushSync", "inval xml");
      }
      for (;;)
      {
        paramString = (PluginZero)com.tencent.mm.kernel.g.ad(PluginZero.class);
        if (paramString.LGn == null) {
          break;
        }
        paramq = com.tencent.mm.loader.j.b.asa() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder("mm").append(com.tencent.mm.network.ad.aPK().iHF.getUin()).toString().getBytes());
        paramString.LGn.a(l, str, localPString2.value, localPString1.value, paramq + "/avatar/", paramInt1);
        break;
        localPString1.value = ((String)paramString.get(".pushcontent.$content"));
        localPString2.value = ((String)paramString.get(".pushcontent.$nickname"));
      }
      label1210:
      paramInt1 = 0;
      continue;
      try
      {
        paramq = localb.FGW.toByteArray();
        paramInt3 = com.tencent.mm.network.ad.aPK().iHF.getUin();
        paramString = com.tencent.mm.booter.g.kO(paramInt3);
        paramInt1 = com.tencent.mm.booter.g.uA(paramString) + 1;
        paramArrayOfByte = paramString + "/syncResp.bin" + paramInt1;
        localObject1 = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.compatible.deviceinfo.q.cH(true) + paramInt3).getBytes());
        localObject2 = l.e(paramq, ((String)localObject1).getBytes());
        ae.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramq.length), Integer.valueOf(localObject2.length), paramArrayOfByte, com.tencent.mm.booter.g.N(paramq), com.tencent.mm.booter.g.N((byte[])localObject2), com.tencent.mm.booter.g.N(((String)localObject1).getBytes()) });
        if (bu.cF((byte[])localObject2)) {
          ae.e("MicroMsg.NotifySyncMgr", "encry failed");
        }
        for (;;)
        {
          ae.d("MicroMsg.NetPushSync", "onRespHandled sync");
          ak.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.abv()).edit().putString("notify_sync_key_keybuf", bu.cH(z.a(localb.FGW.GjQ))).commit();
          ae.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", new Object[] { Integer.valueOf(this.ihj) });
          if (paramInt2 != 0) {
            break label1732;
          }
          if (((localb.FGW.GeQ & dvk) == 0) || (securityLimitCountReach())) {
            break label1727;
          }
          paramInt1 = 1;
          ae.i("MicroMsg.NetPushSync", "continue flag=" + localb.FGW.GeQ + ", selector=" + dvk + ", limit reach=" + securityLimitCountReach());
          if (paramInt1 == 0) {
            break label1732;
          }
          doScene(dispatcher(), this.callback);
          if (paramInt2 != 0) {
            CoreService.WE();
          }
          AppMethodBeat.o(132548);
          return;
          paramInt3 = o.f(paramArrayOfByte, (byte[])localObject2, localObject2.length);
          boolean bool = o.fB(paramArrayOfByte);
          if ((paramInt3 == 0) && (bool)) {
            break;
          }
          ae.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", new Object[] { Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ae.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", new Object[] { paramString });
          ae.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
          continue;
          paramq = String.valueOf(paramInt1).getBytes();
          o.f(paramString + "/syncResp.ini", paramq, paramq.length);
          continue;
          label1727:
          paramInt1 = 0;
          continue;
          label1732:
          if ((this.ihj & 0x1) > 0)
          {
            ae.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
            new g(this.ihl, z.a(localb.FGW.GjQ), com.tencent.mm.network.ad.aPK().iHF.getUin()).doScene(com.tencent.mm.network.ad.aPK(), new b.2(this));
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
    AppMethodBeat.i(132545);
    boolean bool = super.securityLimitCountReach();
    AppMethodBeat.o(132545);
    return bool;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
  
  public static final class a
    implements com.tencent.mm.network.q
  {
    private final v.a ihp;
    private final v.b ihq;
    private final boolean ihr;
    int uin;
    
    public a()
    {
      AppMethodBeat.i(132539);
      this.ihp = new v.a();
      this.ihq = new v.b();
      this.ihr = false;
      AppMethodBeat.o(132539);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132540);
      this.ihp = new v.a();
      this.ihq = paramb;
      this.ihr = true;
      AppMethodBeat.o(132540);
    }
    
    public final boolean getIsLongPolling()
    {
      return false;
    }
    
    public final boolean getIsUserCmd()
    {
      return false;
    }
    
    public final int getLongPollingTimeout()
    {
      return 0;
    }
    
    public final int getNewExtFlags()
    {
      return 0;
    }
    
    public final int getOptions()
    {
      return 0;
    }
    
    public final l.d getReqObj()
    {
      AppMethodBeat.i(132541);
      this.ihp.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.aaH());
      this.ihp.setDeviceType(d.hjv);
      this.ihp.setClientVersion(d.FFH);
      this.ihp.setUin(this.uin);
      v.a locala = this.ihp;
      AppMethodBeat.o(132541);
      return locala;
    }
    
    public final l.e getRespObj()
    {
      return this.ihq;
    }
    
    public final int getTimeOut()
    {
      return 0;
    }
    
    public final byte[] getTransHeader()
    {
      return null;
    }
    
    public final int getType()
    {
      return 138;
    }
    
    public final String getUri()
    {
      return "/cgi-bin/micromsg-bin/newsync";
    }
    
    public final boolean isSingleSession()
    {
      return true;
    }
    
    public final void setConnectionInfo(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b
 * JD-Core Version:    0.7.0.1
 */