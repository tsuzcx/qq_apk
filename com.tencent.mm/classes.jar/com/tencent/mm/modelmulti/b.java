package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.b;
import com.tencent.mm.b.l;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.af;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.network.v;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.dcr;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends com.tencent.mm.an.q
  implements m
{
  protected static int fFT = 7;
  private i callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private f.a khd;
  private MTimerHandler lAo;
  private int lSE;
  private StringBuilder lSF;
  private long lSG;
  private boolean lSH;
  
  public b()
  {
    AppMethodBeat.i(132542);
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.lSE = 0;
    this.lSF = new StringBuilder();
    this.lSG = -1L;
    this.lSH = false;
    Log.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.khd = new f.a();
    this.lSF.append("stack:" + Util.getStack() + " time:" + Util.nowSecond());
    AppMethodBeat.o(132542);
  }
  
  public b(final v.b paramb, int paramInt, long paramLong)
  {
    this();
    AppMethodBeat.i(132543);
    this.lSE = paramInt;
    this.lSG = paramLong;
    Log.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
    this.lAo = new MTimerHandler(com.tencent.e.j.a.bDn("MMPushCore"), new MTimerHandler.CallBack()
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    boolean bool = false;
    AppMethodBeat.i(132547);
    this.callback = parami;
    this.lSF.append(" lastd:" + this.lastdispatch + " dotime:" + Util.nowSecond() + " net:" + NetStatusUtil.getNetType(MMApplicationContext.getContext()));
    int i = hashCode();
    int j = fFT;
    if (this.lAo != null) {
      bool = true;
    }
    Log.i("MicroMsg.NetPushSync", "doScene[%d] selector:%d pusher:%b ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    if (this.lAo != null)
    {
      prepareDispatcher(paramg);
      this.lAo.startTimer(0L);
      this.lAo = null;
      AppMethodBeat.o(132547);
      return -1;
    }
    parami = new a();
    parami.uin = af.btU().muM.getUin();
    dcq localdcq = ((v.a)parami.getReqObj()).RBW;
    localdcq.SfH = fFT;
    localdcq.SfI = z.aN(Util.decodeHexString(MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.avK()).getString("notify_sync_key_keybuf", "")));
    localdcq.CPw = 1;
    localdcq.TKA = new abv();
    localdcq.RMK = d.kQZ;
    i = dispatch(paramg, parami, this);
    AppMethodBeat.o(132547);
    return i;
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132544);
    String str = this.lSF.toString();
    AppMethodBeat.o(132544);
    return str;
  }
  
  public final int getType()
  {
    return 138;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132548);
    if ((params == null) || (params.getType() != 138))
    {
      if (params == null) {}
      for (paramInt1 = -2;; paramInt1 = params.getType())
      {
        Log.e("MicroMsg.NetPushSync", "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(132548);
        return;
      }
    }
    this.lSF.append(" endtime:" + Util.nowSecond());
    Log.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.lSH), Long.valueOf(this.khd.avE()), this.lSF });
    v.b localb;
    label260:
    label332:
    label474:
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
      localb = (v.b)params.getRespObj();
      if (paramInt1 == 0)
      {
        params = z.a(((v.a)params.getReqObj()).RBW.SfI);
        if (params == null)
        {
          paramInt1 = -1;
          Log.d("MicroMsg.NetPushSync", "dkpush req Key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), Util.dumpHex(params) });
          paramString = params;
          if (Util.isNullOrNil(params))
          {
            paramString = Util.decodeHexString(MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.avK()).getString("notify_sync_key_keybuf", ""));
            if (paramString != null) {
              break label736;
            }
            paramInt1 = -1;
            Log.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), Util.dumpHex(paramString) });
          }
          params = z.a(localb.RBX.SfI);
          paramArrayOfByte = ad.n(paramString, params);
          if (paramArrayOfByte != null)
          {
            paramString = paramArrayOfByte;
            if (paramArrayOfByte.length > 0) {}
          }
          else
          {
            Log.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
            paramString = params;
          }
          localb.RBX.SfI = z.aN(paramString);
          if ((localb.RBX.SfL != null) && (localb.RBX.SfL.rVy != null)) {
            break label743;
          }
          paramInt1 = 0;
          label448:
          Log.i("MicroMsg.NetPushSync", "newMsgSize:%d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramString != null) {
            break label761;
          }
          paramInt2 = -1;
          Log.d("MicroMsg.NetPushSync", "newMsgSize:%d, mergeKey: %d[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Util.dumpHex(paramString) });
        }
      }
      else
      {
        paramArrayOfByte = localb.RBX.SfL.rVy.iterator();
        paramInt2 = 0;
        label526:
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (abu)paramArrayOfByte.next();
          if (((abu)localObject1).SnG == 5) {
            paramString = z.a(((abu)localObject1).SnH);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      long l;
      label736:
      label743:
      label761:
      String str;
      try
      {
        localObject2 = new db();
        ((db)localObject2).parseFrom(paramString);
        int i = ((db)localObject2).COi;
        paramString = ((db)localObject2).RID.Ufy;
        l = ((db)localObject2).HlH;
        if (((db)localObject2).RIJ == null)
        {
          paramInt1 = 0;
          if (((db)localObject2).RIF.Ufy != null) {
            continue;
          }
          paramInt3 = 0;
          Log.i("MicroMsg.NetPushSync", "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d", new Object[] { Integer.valueOf(i), paramString, Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
          paramInt1 = ((db)localObject2).COi;
          paramString = ((db)localObject2).RID.Ufy;
          params = ((db)localObject2).RIF.Ufy;
          if (paramInt1 != 50) {
            continue;
          }
          Log.i("MicroMsg.NetPushSync", "hit voip");
          paramInt1 = 1;
          if (paramInt1 == 0) {
            continue;
          }
          paramInt2 = 1;
          break label526;
          paramInt1 = params.length;
          break label260;
          paramInt1 = paramString.length;
          break label332;
          paramInt1 = localb.RBX.SfL.rVy.size();
          break label448;
          paramInt2 = paramString.length;
          break label474;
        }
        paramInt1 = ((db)localObject2).RIJ.length();
        continue;
        paramInt3 = ((db)localObject2).RIF.Ufy.length();
        continue;
        if ((Util.isNullOrNil(params)) || (Util.isNullOrNil(paramString)))
        {
          Log.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
          break label1844;
        }
        if ((paramInt1 == 9998) && (paramString.equalsIgnoreCase("weixin")))
        {
          Log.i("MicroMsg.NetPushSync", "hit ipxx");
          paramInt1 = 1;
          continue;
        }
        if ((paramInt1 != 10002) || (!params.contains("revokemsg"))) {
          break label1844;
        }
        Log.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
        paramInt1 = 1;
        continue;
        l = ((db)localObject2).HlH;
        str = ((db)localObject2).RID.Ufy;
        paramString = ((db)localObject2).RIJ;
        paramInt1 = ((db)localObject2).COi;
        if (!Util.isNullOrNil(paramString)) {
          break label995;
        }
        Log.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
        if (((db)localObject2).COi != 10002) {
          break label1228;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label526;
        }
        Log.i("MicroMsg.NetPushSync", "need remove pushContent");
        ((db)localObject2).RIJ = null;
        ((abu)localObject1).SnH = z.aN(((db)localObject2).toByteArray());
      }
      catch (IOException paramString)
      {
        Log.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
      }
      break label526;
      label995:
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      params = Util.processXml(paramString);
      paramInt3 = params.indexOf("<pushcontent");
      paramString = params;
      if (paramInt3 > 0) {
        paramString = params.substring(paramInt3);
      }
      paramString = XmlParser.parseXml(paramString, "pushcontent", null);
      if (paramString == null) {
        Log.e("MicroMsg.NetPushSync", "inval xml");
      }
      for (;;)
      {
        paramString = (PluginZero)h.ag(PluginZero.class);
        if (paramString.Svl == null) {
          break;
        }
        params = com.tencent.mm.loader.j.b.aSC() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder("mm").append(af.btU().muM.getUin()).toString().getBytes());
        paramString.Svl.a(l, str, localPString2.value, localPString1.value, params + "/avatar/", paramInt1);
        break;
        localPString1.value = ((String)paramString.get(".pushcontent.$content"));
        localPString2.value = ((String)paramString.get(".pushcontent.$nickname"));
      }
      label1228:
      paramInt1 = 0;
      continue;
      try
      {
        params = localb.RBX.toByteArray();
        paramInt3 = af.btU().muM.getUin();
        paramString = com.tencent.mm.booter.g.qf(paramInt3);
        paramInt1 = com.tencent.mm.booter.g.JG(paramString) + 1;
        paramArrayOfByte = paramString + "/syncResp.bin" + paramInt1;
        localObject1 = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.compatible.deviceinfo.q.dR(true) + paramInt3).getBytes());
        localObject2 = l.e(params, ((String)localObject1).getBytes());
        Log.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(params.length), Integer.valueOf(localObject2.length), paramArrayOfByte, com.tencent.mm.booter.g.ai(params), com.tencent.mm.booter.g.ai((byte[])localObject2), com.tencent.mm.booter.g.ai(((String)localObject1).getBytes()) });
        if (Util.isNullOrNil((byte[])localObject2)) {
          Log.e("MicroMsg.NotifySyncMgr", "encry failed");
        }
        for (;;)
        {
          Log.d("MicroMsg.NetPushSync", "onRespHandled sync");
          MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.avK()).edit().putString("notify_sync_key_keybuf", Util.encodeHexString(z.a(localb.RBX.SfI))).commit();
          Log.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", new Object[] { Integer.valueOf(this.lSE) });
          if (paramInt2 != 0) {
            break label1751;
          }
          if (((localb.RBX.Saq & fFT) == 0) || (securityLimitCountReach())) {
            break label1746;
          }
          paramInt1 = 1;
          Log.i("MicroMsg.NetPushSync", "continue flag=" + localb.RBX.Saq + ", selector=" + fFT + ", limit reach=" + securityLimitCountReach());
          if (paramInt1 == 0) {
            break label1751;
          }
          doScene(dispatcher(), this.callback);
          if (paramInt2 != 0) {
            CoreService.aqo();
          }
          AppMethodBeat.o(132548);
          return;
          paramInt3 = u.f(paramArrayOfByte, (byte[])localObject2, localObject2.length);
          boolean bool = u.agG(paramArrayOfByte);
          if ((paramInt3 == 0) && (bool)) {
            break;
          }
          Log.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", new Object[] { Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", new Object[] { paramString });
          Log.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
          continue;
          params = String.valueOf(paramInt1).getBytes();
          u.f(paramString + "/syncResp.ini", params, params.length);
          continue;
          label1746:
          paramInt1 = 0;
          continue;
          label1751:
          if ((this.lSE & 0x1) > 0)
          {
            Log.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
            new g(this.lSG, z.a(localb.RBX.SfI), af.btU().muM.getUin()).doScene(af.btU(), new i()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
              {
                AppMethodBeat.i(132538);
                Log.i("MicroMsg.NetPushSync", "NetSceneNotifyData onSceneEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                paramAnonymousq.setHasCallbackToQueue(true);
                AppMethodBeat.o(132538);
              }
            });
          }
          this.callback.onSceneEnd(this.errType, this.errCode, this.errMsg, this);
        }
      }
      paramInt1 = 0;
      break;
      label1844:
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
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public static final class a
    implements s
  {
    private final v.a lSK;
    private final v.b lSL;
    private final boolean lSM;
    int uin;
    
    public a()
    {
      AppMethodBeat.i(132539);
      this.lSK = new v.a();
      this.lSL = new v.b();
      this.lSM = false;
      AppMethodBeat.o(132539);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132540);
      this.lSK = new v.a();
      this.lSL = paramb;
      this.lSM = true;
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
      this.lSK.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.auM());
      this.lSK.setDeviceType(d.kQZ);
      this.lSK.setClientVersion(d.RAD);
      this.lSK.setUin(this.uin);
      v.a locala = this.lSK;
      AppMethodBeat.o(132541);
      return locala;
    }
    
    public final l.e getRespObj()
    {
      return this.lSL;
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
    
    public final boolean keepAlive()
    {
      return false;
    }
    
    public final void setConnectionInfo(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b
 * JD-Core Version:    0.7.0.1
 */