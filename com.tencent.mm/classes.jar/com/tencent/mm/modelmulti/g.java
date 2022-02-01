package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class g
  extends p
  implements m
{
  protected static int selector = 7;
  private com.tencent.mm.am.h callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private f.a mHw;
  private boolean oLA;
  private int oLx;
  private StringBuilder oLy;
  private long oLz;
  private MTimerHandler orP;
  
  public g()
  {
    AppMethodBeat.i(132542);
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.oLx = 0;
    this.oLy = new StringBuilder();
    this.oLz = -1L;
    this.oLA = false;
    Log.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    this.mHw = new f.a();
    this.oLy.append("stack:" + Util.getStack() + " time:" + Util.nowSecond());
    AppMethodBeat.o(132542);
  }
  
  public g(final v.b paramb, int paramInt, long paramLong)
  {
    this();
    AppMethodBeat.i(132543);
    this.oLx = paramInt;
    this.oLz = paramLong;
    Log.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
    this.orP = new MTimerHandler(com.tencent.threadpool.j.a.bFV("MMPushCore"), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132537);
        g.a(g.this);
        g.a locala = new g.a(paramb);
        g.this.onGYNetEnd(-1, 0, 0, "", locala, null);
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
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    boolean bool = false;
    AppMethodBeat.i(132547);
    this.callback = paramh;
    this.oLy.append(" lastd:" + this.lastdispatch + " dotime:" + Util.nowSecond() + " net:" + NetStatusUtil.getNetType(MMApplicationContext.getContext()));
    int i = hashCode();
    int j = selector;
    if (this.orP != null) {
      bool = true;
    }
    Log.i("MicroMsg.NetPushSync", "doScene[%d] selector:%d pusher:%b ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    if (this.orP != null)
    {
      prepareDispatcher(paramg);
      this.orP.startTimer(0L);
      this.orP = null;
      AppMethodBeat.o(132547);
      return -1;
    }
    paramh = new a();
    paramh.uin = ag.bRx().poh.getUin();
    duj localduj = ((v.a)paramh.getReqObj()).Yyz;
    localduj.ZdC = selector;
    localduj.ZdD = com.tencent.mm.platformtools.w.aN(Util.decodeHexString(MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aQe()).getString("notify_sync_key_keybuf", "")));
    localduj.IJG = 1;
    localduj.abat = new adx();
    localduj.YJY = d.nsC;
    i = dispatch(paramg, paramh, this);
    AppMethodBeat.o(132547);
    return i;
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132544);
    String str = this.oLy.toString();
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
    this.oLy.append(" endtime:" + Util.nowSecond());
    Log.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.oLA), Long.valueOf(this.mHw.aPY()), this.oLy });
    v.b localb;
    label260:
    label331:
    label473:
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
        params = com.tencent.mm.platformtools.w.a(((v.a)params.getReqObj()).Yyz.ZdD);
        if (params == null)
        {
          paramInt1 = -1;
          Log.d("MicroMsg.NetPushSync", "dkpush req Key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), Util.dumpHex(params) });
          paramString = params;
          if (Util.isNullOrNil(params))
          {
            paramString = Util.decodeHexString(MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aQe()).getString("notify_sync_key_keybuf", ""));
            if (paramString != null) {
              break label735;
            }
            paramInt1 = -1;
            Log.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), Util.dumpHex(paramString) });
          }
          params = com.tencent.mm.platformtools.w.a(localb.YyA.ZdD);
          paramArrayOfByte = ad.o(paramString, params);
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
          localb.YyA.ZdD = com.tencent.mm.platformtools.w.aN(paramString);
          if ((localb.YyA.ZdG != null) && (localb.YyA.ZdG.vgO != null)) {
            break label742;
          }
          paramInt1 = 0;
          label447:
          Log.i("MicroMsg.NetPushSync", "newMsgSize:%d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramString != null) {
            break label760;
          }
          paramInt2 = -1;
          Log.d("MicroMsg.NetPushSync", "newMsgSize:%d, mergeKey: %d[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Util.dumpHex(paramString) });
        }
      }
      else
      {
        paramArrayOfByte = localb.YyA.ZdG.vgO.iterator();
        paramInt2 = 0;
        label525:
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (adw)paramArrayOfByte.next();
          if (((adw)localObject1).Zmc == 5) {
            paramString = com.tencent.mm.platformtools.w.a(((adw)localObject1).Zmd);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      long l;
      label735:
      label742:
      label760:
      String str;
      try
      {
        localObject2 = new dl();
        ((dl)localObject2).parseFrom(paramString);
        int i = ((dl)localObject2).IIs;
        paramString = ((dl)localObject2).YFE.abwM;
        l = ((dl)localObject2).Njv;
        if (((dl)localObject2).YFK == null)
        {
          paramInt1 = 0;
          if (((dl)localObject2).YFG.abwM != null) {
            continue;
          }
          paramInt3 = 0;
          Log.i("MicroMsg.NetPushSync", "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d", new Object[] { Integer.valueOf(i), paramString, Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
          paramInt1 = ((dl)localObject2).IIs;
          paramString = ((dl)localObject2).YFE.abwM;
          params = ((dl)localObject2).YFG.abwM;
          if (paramInt1 != 50) {
            continue;
          }
          Log.i("MicroMsg.NetPushSync", "hit voip");
          paramInt1 = 1;
          if (paramInt1 == 0) {
            continue;
          }
          paramInt2 = 1;
          break label525;
          paramInt1 = params.length;
          break label260;
          paramInt1 = paramString.length;
          break label331;
          paramInt1 = localb.YyA.ZdG.vgO.size();
          break label447;
          paramInt2 = paramString.length;
          break label473;
        }
        paramInt1 = ((dl)localObject2).YFK.length();
        continue;
        paramInt3 = ((dl)localObject2).YFG.abwM.length();
        continue;
        if ((Util.isNullOrNil(params)) || (Util.isNullOrNil(paramString)))
        {
          Log.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
          break label1842;
        }
        if ((paramInt1 == 9998) && (paramString.equalsIgnoreCase("weixin")))
        {
          Log.i("MicroMsg.NetPushSync", "hit ipxx");
          paramInt1 = 1;
          continue;
        }
        if ((paramInt1 != 10002) || (!params.contains("revokemsg"))) {
          break label1842;
        }
        Log.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
        paramInt1 = 1;
        continue;
        l = ((dl)localObject2).Njv;
        str = ((dl)localObject2).YFE.abwM;
        paramString = ((dl)localObject2).YFK;
        paramInt1 = ((dl)localObject2).IIs;
        if (!Util.isNullOrNil(paramString)) {
          break label994;
        }
        Log.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
        if (((dl)localObject2).IIs != 10002) {
          break label1227;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label525;
        }
        Log.i("MicroMsg.NetPushSync", "need remove pushContent");
        ((dl)localObject2).YFK = null;
        ((adw)localObject1).Zmd = com.tencent.mm.platformtools.w.aN(((dl)localObject2).toByteArray());
      }
      catch (IOException paramString)
      {
        Log.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
      }
      break label525;
      label994:
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
        paramString = (PluginZero)com.tencent.mm.kernel.h.az(PluginZero.class);
        if (paramString.akjL == null) {
          break;
        }
        params = com.tencent.mm.loader.i.b.bmq() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder("mm").append(ag.bRx().poh.getUin()).toString().getBytes());
        paramString.akjL.a(l, str, localPString2.value, localPString1.value, params + "/avatar/", paramInt1);
        break;
        localPString1.value = ((String)paramString.get(".pushcontent.$content"));
        localPString2.value = ((String)paramString.get(".pushcontent.$nickname"));
      }
      label1227:
      paramInt1 = 0;
      continue;
      try
      {
        params = localb.YyA.toByteArray();
        paramInt3 = ag.bRx().poh.getUin();
        paramString = com.tencent.mm.booter.g.qf(paramInt3);
        paramInt1 = com.tencent.mm.booter.g.Cm(paramString) + 1;
        paramArrayOfByte = paramString + "/syncResp.bin" + paramInt1;
        localObject1 = com.tencent.mm.b.g.getMessageDigest((q.eD(true) + paramInt3).getBytes());
        localObject2 = com.tencent.mm.b.l.e(params, ((String)localObject1).getBytes());
        Log.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(params.length), Integer.valueOf(localObject2.length), paramArrayOfByte, com.tencent.mm.booter.g.ai(params), com.tencent.mm.booter.g.ai((byte[])localObject2), com.tencent.mm.booter.g.ai(((String)localObject1).getBytes()) });
        if (Util.isNullOrNil((byte[])localObject2)) {
          Log.e("MicroMsg.NotifySyncMgr", "encry failed");
        }
        for (;;)
        {
          Log.d("MicroMsg.NetPushSync", "onRespHandled sync");
          MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aQe()).edit().putString("notify_sync_key_keybuf", Util.encodeHexString(com.tencent.mm.platformtools.w.a(localb.YyA.ZdD))).commit();
          Log.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", new Object[] { Integer.valueOf(this.oLx) });
          if (paramInt2 != 0) {
            break label1749;
          }
          if (((localb.YyA.YYp & selector) == 0) || (securityLimitCountReach())) {
            break label1744;
          }
          paramInt1 = 1;
          Log.i("MicroMsg.NetPushSync", "continue flag=" + localb.YyA.YYp + ", selector=" + selector + ", limit reach=" + securityLimitCountReach());
          if (paramInt1 == 0) {
            break label1749;
          }
          doScene(dispatcher(), this.callback);
          if (paramInt2 != 0) {
            CoreService.aKm();
          }
          AppMethodBeat.o(132548);
          return;
          paramInt3 = y.f(paramArrayOfByte, (byte[])localObject2, localObject2.length);
          boolean bool = y.ZC(paramArrayOfByte);
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
          y.f(paramString + "/syncResp.ini", params, params.length);
          continue;
          label1744:
          paramInt1 = 0;
          continue;
          label1749:
          if ((this.oLx & 0x1) > 0)
          {
            Log.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
            new l(this.oLz, com.tencent.mm.platformtools.w.a(localb.YyA.ZdD), ag.bRx().poh.getUin()).doScene(ag.bRx(), new g.2(this));
          }
          this.callback.onSceneEnd(this.errType, this.errCode, this.errMsg, this);
        }
      }
      paramInt1 = 0;
      break;
      label1842:
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  public static final class a
    implements s
  {
    private final v.a oLD;
    private final v.b oLE;
    private final boolean oLF;
    int uin;
    
    public a()
    {
      AppMethodBeat.i(132539);
      this.oLD = new v.a();
      this.oLE = new v.b();
      this.oLF = false;
      AppMethodBeat.o(132539);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132540);
      this.oLD = new v.a();
      this.oLE = paramb;
      this.oLF = true;
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
      this.oLD.setDeviceID(q.aPg());
      this.oLD.setDeviceType(d.nsC);
      this.oLD.setClientVersion(d.Yxh);
      this.oLD.setUin(this.uin);
      v.a locala = this.oLD;
      AppMethodBeat.o(132541);
      return locala;
    }
    
    public final l.e getRespObj()
    {
      return this.oLE;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.g
 * JD-Core Version:    0.7.0.1
 */