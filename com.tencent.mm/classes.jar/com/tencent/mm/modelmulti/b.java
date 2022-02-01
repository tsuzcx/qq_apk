package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
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
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends n
  implements k
{
  protected static int hkT = 7;
  private com.tencent.mm.al.g callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private av gTs;
  private f.a ghu;
  private int hkU;
  private StringBuilder hkV;
  private long hkW;
  private boolean hkX;
  
  public b()
  {
    AppMethodBeat.i(132542);
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.hkU = 0;
    this.hkV = new StringBuilder();
    this.hkW = -1L;
    this.hkX = false;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    this.ghu = new f.a();
    this.hkV.append("stack:" + bt.eGN() + " time:" + bt.aGK());
    AppMethodBeat.o(132542);
  }
  
  public b(final v.b paramb, int paramInt, long paramLong)
  {
    this();
    AppMethodBeat.i(132543);
    this.hkU = paramInt;
    this.hkW = paramLong;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
    this.gTs = new av(com.tencent.e.j.a.aOc("MMPushCore"), new av.a()
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
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    boolean bool = false;
    AppMethodBeat.i(132547);
    this.callback = paramg;
    this.hkV.append(" lastd:" + this.lastdispatch + " dotime:" + bt.aGK() + " net:" + ay.getNetType(aj.getContext()));
    int i = hashCode();
    int j = hkT;
    if (this.gTs != null) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "doScene[%d] selector:%d pusher:%b ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    if (this.gTs != null)
    {
      prepareDispatcher(parame);
      this.gTs.av(0L, 0L);
      this.gTs = null;
      AppMethodBeat.o(132547);
      return -1;
    }
    paramg = new a();
    paramg.uin = com.tencent.mm.network.ad.aFo().hKZ.getUin();
    btj localbtj = ((v.a)paramg.getReqObj()).CqY;
    localbtj.CRw = hkT;
    localbtj.CRx = z.am(bt.aGd(aj.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.XN()).getString("notify_sync_key_keybuf", "")));
    localbtj.Scene = 1;
    localbtj.DQS = new xe();
    localbtj.CBS = d.glX;
    i = dispatch(parame, paramg, this);
    AppMethodBeat.o(132547);
    return i;
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132544);
    String str = this.hkV.toString();
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetPushSync", "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(132548);
        return;
      }
    }
    this.hkV.append(" endtime:" + bt.aGK());
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.hkX), Long.valueOf(this.ghu.XK()), this.hkV });
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
        paramString = z.a(((v.a)paramq.getReqObj()).CqY.CRx);
        if (paramString == null)
        {
          paramInt1 = -1;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetPushSync", "dkpush req Key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), bt.cv(paramString) });
          if (!bt.cw(paramString)) {
            break label1820;
          }
          paramString = bt.aGd(aj.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.XN()).getString("notify_sync_key_keybuf", ""));
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bt.cv(paramString) });
          paramq = z.a(localb.CqZ.CRx);
          paramArrayOfByte = com.tencent.mm.protocal.ad.k(paramString, paramq);
          if (paramArrayOfByte != null)
          {
            paramString = paramArrayOfByte;
            if (paramArrayOfByte.length > 0) {}
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
            paramString = paramq;
          }
          localb.CqZ.CRx = z.am(paramString);
          if ((localb.CqZ.CRA != null) && (localb.CqZ.CRA.mAL != null)) {
            break label726;
          }
          paramInt1 = 0;
          label438:
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "newMsgSize:%d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramString != null) {
            break label744;
          }
          paramInt2 = -1;
          label464:
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetPushSync", "newMsgSize:%d, mergeKey: %d[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bt.cv(paramString) });
        }
      }
      else
      {
        paramArrayOfByte = localb.CqZ.CRA.mAL.iterator();
        paramInt2 = 0;
        label516:
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (xd)paramArrayOfByte.next();
          if (((xd)localObject1).CYY == 5) {
            paramString = z.a(((xd)localObject1).CYZ);
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
        localObject2 = new cs();
        ((cs)localObject2).parseFrom(paramString);
        int i = ((cs)localObject2).saz;
        paramString = ((cs)localObject2).Cxx.Ehn;
        l = ((cs)localObject2).uKZ;
        if (((cs)localObject2).CxD == null)
        {
          paramInt1 = 0;
          if (((cs)localObject2).Cxz.Ehn != null) {
            continue;
          }
          paramInt3 = 0;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d", new Object[] { Integer.valueOf(i), paramString, Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
          paramInt1 = ((cs)localObject2).saz;
          paramString = ((cs)localObject2).Cxx.Ehn;
          paramq = ((cs)localObject2).Cxz.Ehn;
          if (paramInt1 != 50) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "hit voip");
          paramInt1 = 1;
          if (paramInt1 == 0) {
            continue;
          }
          paramInt2 = 1;
          break label516;
          paramInt1 = paramString.length;
          break label260;
          paramInt1 = localb.CqZ.CRA.mAL.size();
          break label438;
          paramInt2 = paramString.length;
          break label464;
        }
        paramInt1 = ((cs)localObject2).CxD.length();
        continue;
        paramInt3 = ((cs)localObject2).Cxz.Ehn.length();
        continue;
        if ((bt.isNullOrNil(paramq)) || (bt.isNullOrNil(paramString)))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
          break label1828;
        }
        if ((paramInt1 == 9998) && (paramString.equalsIgnoreCase("weixin")))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "hit ipxx");
          paramInt1 = 1;
          continue;
        }
        if ((paramInt1 != 10002) || (!paramq.contains("revokemsg"))) {
          break label1828;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
        paramInt1 = 1;
        continue;
        l = ((cs)localObject2).uKZ;
        str = ((cs)localObject2).Cxx.Ehn;
        paramString = ((cs)localObject2).CxD;
        paramInt1 = ((cs)localObject2).saz;
        if (!bt.isNullOrNil(paramString)) {
          break label978;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
        if (((cs)localObject2).saz != 10002) {
          break label1210;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label516;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "need remove pushContent");
        ((cs)localObject2).CxD = null;
        ((xd)localObject1).CYZ = z.am(((cs)localObject2).toByteArray());
      }
      catch (IOException paramString)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
      }
      break label516;
      label978:
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      paramq = bt.aGg(paramString);
      paramInt3 = paramq.indexOf("<pushcontent");
      paramString = paramq;
      if (paramInt3 > 0) {
        paramString = paramq.substring(paramInt3);
      }
      paramString = bw.K(paramString, "pushcontent");
      if (paramString == null) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetPushSync", "inval xml");
      }
      for (;;)
      {
        paramString = (PluginZero)com.tencent.mm.kernel.g.ad(PluginZero.class);
        if (paramString.Lwp == null) {
          break;
        }
        paramq = com.tencent.mm.loader.j.b.ahY() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder("mm").append(com.tencent.mm.network.ad.aFo().hKZ.getUin()).toString().getBytes());
        paramString.Lwp.a(l, str, localPString2.value, localPString1.value, paramq + "/avatar/", paramInt1);
        break;
        localPString1.value = ((String)paramString.get(".pushcontent.$content"));
        localPString2.value = ((String)paramString.get(".pushcontent.$nickname"));
      }
      label1210:
      paramInt1 = 0;
      continue;
      try
      {
        paramq = localb.CqZ.toByteArray();
        paramInt3 = com.tencent.mm.network.ad.aFo().hKZ.getUin();
        paramString = com.tencent.mm.booter.g.ks(paramInt3);
        paramInt1 = com.tencent.mm.booter.g.on(paramString) + 1;
        paramArrayOfByte = paramString + "/syncResp.bin" + paramInt1;
        localObject1 = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.compatible.deviceinfo.q.cG(true) + paramInt3).getBytes());
        localObject2 = l.e(paramq, ((String)localObject1).getBytes());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramq.length), Integer.valueOf(localObject2.length), paramArrayOfByte, com.tencent.mm.booter.g.Q(paramq), com.tencent.mm.booter.g.Q((byte[])localObject2), com.tencent.mm.booter.g.Q(((String)localObject1).getBytes()) });
        if (bt.cw((byte[])localObject2)) {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NotifySyncMgr", "encry failed");
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetPushSync", "onRespHandled sync");
          aj.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.XN()).edit().putString("notify_sync_key_keybuf", bt.cy(z.a(localb.CqZ.CRx))).commit();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", new Object[] { Integer.valueOf(this.hkU) });
          if (paramInt2 != 0) {
            break label1732;
          }
          if (((localb.CqZ.CNq & hkT) == 0) || (securityLimitCountReach())) {
            break label1727;
          }
          paramInt1 = 1;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "continue flag=" + localb.CqZ.CNq + ", selector=" + hkT + ", limit reach=" + securityLimitCountReach());
          if (paramInt1 == 0) {
            break label1732;
          }
          doScene(dispatcher(), this.callback);
          if (paramInt2 != 0) {
            CoreService.Tl();
          }
          AppMethodBeat.o(132548);
          return;
          paramInt3 = i.f(paramArrayOfByte, (byte[])localObject2, localObject2.length);
          boolean bool = i.eK(paramArrayOfByte);
          if ((paramInt3 == 0) && (bool)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", new Object[] { Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", new Object[] { paramString });
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
          continue;
          paramq = String.valueOf(paramInt1).getBytes();
          i.f(paramString + "/syncResp.ini", paramq, paramq.length);
          continue;
          label1727:
          paramInt1 = 0;
          continue;
          label1732:
          if ((this.hkU & 0x1) > 0)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
            new g(this.hkW, z.a(localb.CqZ.CRx), com.tencent.mm.network.ad.aFo().hKZ.getUin()).doScene(com.tencent.mm.network.ad.aFo(), new b.2(this));
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
    return n.b.gVB;
  }
  
  public static final class a
    implements com.tencent.mm.network.q
  {
    private final v.a hla;
    private final v.b hlb;
    private final boolean hlc;
    int uin;
    
    public a()
    {
      AppMethodBeat.i(132539);
      this.hla = new v.a();
      this.hlb = new v.b();
      this.hlc = false;
      AppMethodBeat.o(132539);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132540);
      this.hla = new v.a();
      this.hlb = paramb;
      this.hlc = true;
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
    
    public final int getOptions()
    {
      return 0;
    }
    
    public final l.d getReqObj()
    {
      AppMethodBeat.i(132541);
      this.hla.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.Xa());
      this.hla.setDeviceType(d.glX);
      this.hla.setClientVersion(d.CpK);
      this.hla.setUin(this.uin);
      v.a locala = this.hla;
      AppMethodBeat.o(132541);
      return locala;
    }
    
    public final l.e getRespObj()
    {
      return this.hlb;
    }
    
    public final int getTimeOut()
    {
      return 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b
 * JD-Core Version:    0.7.0.1
 */