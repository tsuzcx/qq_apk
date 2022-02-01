package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends n
  implements k
{
  protected static int hLw = 7;
  private com.tencent.mm.ak.g callback;
  private int errCode;
  private String errMsg;
  private int errType;
  private f.a gma;
  private boolean hLA;
  private int hLx;
  private StringBuilder hLy;
  private long hLz;
  private au htR;
  
  public b()
  {
    AppMethodBeat.i(132542);
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.hLx = 0;
    this.hLy = new StringBuilder();
    this.hLz = -1L;
    this.hLA = false;
    ac.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    this.gma = new f.a();
    this.hLy.append("stack:" + bs.eWi() + " time:" + bs.aNx());
    AppMethodBeat.o(132542);
  }
  
  public b(final v.b paramb, int paramInt, long paramLong)
  {
    this();
    AppMethodBeat.i(132543);
    this.hLx = paramInt;
    this.hLz = paramLong;
    ac.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
    this.htR = new au(com.tencent.e.j.a.aTF("MMPushCore"), new au.a()
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
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    boolean bool = false;
    AppMethodBeat.i(132547);
    this.callback = paramg;
    this.hLy.append(" lastd:" + this.lastdispatch + " dotime:" + bs.aNx() + " net:" + ax.getNetType(ai.getContext()));
    int i = hashCode();
    int j = hLw;
    if (this.htR != null) {
      bool = true;
    }
    ac.i("MicroMsg.NetPushSync", "doScene[%d] selector:%d pusher:%b ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    if (this.htR != null)
    {
      prepareDispatcher(parame);
      this.htR.au(0L, 0L);
      this.htR = null;
      AppMethodBeat.o(132547);
      return -1;
    }
    paramg = new a();
    paramg.uin = com.tencent.mm.network.ad.aMf().ilv.getUin();
    bya localbya = ((v.a)paramg.getReqObj()).DJq;
    localbya.Ekh = hLw;
    localbya.Eki = z.al(bs.aLu(ai.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.YK()).getString("notify_sync_key_keybuf", "")));
    localbya.Scene = 1;
    localbya.Fnk = new xw();
    localbya.DUp = d.gMK;
    i = dispatch(parame, paramg, this);
    AppMethodBeat.o(132547);
    return i;
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(132544);
    String str = this.hLy.toString();
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
        ac.e("MicroMsg.NetPushSync", "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(132548);
        return;
      }
    }
    this.hLy.append(" endtime:" + bs.aNx());
    ac.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.hLA), Long.valueOf(this.gma.YH()), this.hLy });
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
        paramString = z.a(((v.a)paramq.getReqObj()).DJq.Eki);
        if (paramString == null)
        {
          paramInt1 = -1;
          ac.d("MicroMsg.NetPushSync", "dkpush req Key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), bs.cu(paramString) });
          if (!bs.cv(paramString)) {
            break label1820;
          }
          paramString = bs.aLu(ai.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.YK()).getString("notify_sync_key_keybuf", ""));
          ac.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bs.cu(paramString) });
          paramq = z.a(localb.DJr.Eki);
          paramArrayOfByte = com.tencent.mm.protocal.ad.k(paramString, paramq);
          if (paramArrayOfByte != null)
          {
            paramString = paramArrayOfByte;
            if (paramArrayOfByte.length > 0) {}
          }
          else
          {
            ac.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
            paramString = paramq;
          }
          localb.DJr.Eki = z.al(paramString);
          if ((localb.DJr.Ekl != null) && (localb.DJr.Ekl.ncM != null)) {
            break label726;
          }
          paramInt1 = 0;
          label438:
          ac.i("MicroMsg.NetPushSync", "newMsgSize:%d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramString != null) {
            break label744;
          }
          paramInt2 = -1;
          label464:
          ac.d("MicroMsg.NetPushSync", "newMsgSize:%d, mergeKey: %d[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bs.cu(paramString) });
        }
      }
      else
      {
        paramArrayOfByte = localb.DJr.Ekl.ncM.iterator();
        paramInt2 = 0;
        label516:
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (xv)paramArrayOfByte.next();
          if (((xv)localObject1).ErL == 5) {
            paramString = z.a(((xv)localObject1).ErM);
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
        localObject2 = new cu();
        ((cu)localObject2).parseFrom(paramString);
        int i = ((cu)localObject2).tit;
        paramString = ((cu)localObject2).DPT.FEm;
        l = ((cu)localObject2).vTQ;
        if (((cu)localObject2).DPZ == null)
        {
          paramInt1 = 0;
          if (((cu)localObject2).DPV.FEm != null) {
            continue;
          }
          paramInt3 = 0;
          ac.i("MicroMsg.NetPushSync", "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d", new Object[] { Integer.valueOf(i), paramString, Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
          paramInt1 = ((cu)localObject2).tit;
          paramString = ((cu)localObject2).DPT.FEm;
          paramq = ((cu)localObject2).DPV.FEm;
          if (paramInt1 != 50) {
            continue;
          }
          ac.i("MicroMsg.NetPushSync", "hit voip");
          paramInt1 = 1;
          if (paramInt1 == 0) {
            continue;
          }
          paramInt2 = 1;
          break label516;
          paramInt1 = paramString.length;
          break label260;
          paramInt1 = localb.DJr.Ekl.ncM.size();
          break label438;
          paramInt2 = paramString.length;
          break label464;
        }
        paramInt1 = ((cu)localObject2).DPZ.length();
        continue;
        paramInt3 = ((cu)localObject2).DPV.FEm.length();
        continue;
        if ((bs.isNullOrNil(paramq)) || (bs.isNullOrNil(paramString)))
        {
          ac.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
          break label1828;
        }
        if ((paramInt1 == 9998) && (paramString.equalsIgnoreCase("weixin")))
        {
          ac.i("MicroMsg.NetPushSync", "hit ipxx");
          paramInt1 = 1;
          continue;
        }
        if ((paramInt1 != 10002) || (!paramq.contains("revokemsg"))) {
          break label1828;
        }
        ac.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
        paramInt1 = 1;
        continue;
        l = ((cu)localObject2).vTQ;
        str = ((cu)localObject2).DPT.FEm;
        paramString = ((cu)localObject2).DPZ;
        paramInt1 = ((cu)localObject2).tit;
        if (!bs.isNullOrNil(paramString)) {
          break label978;
        }
        ac.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
        if (((cu)localObject2).tit != 10002) {
          break label1210;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label516;
        }
        ac.i("MicroMsg.NetPushSync", "need remove pushContent");
        ((cu)localObject2).DPZ = null;
        ((xv)localObject1).ErM = z.al(((cu)localObject2).toByteArray());
      }
      catch (IOException paramString)
      {
        ac.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
      }
      break label516;
      label978:
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      paramq = bs.aLx(paramString);
      paramInt3 = paramq.indexOf("<pushcontent");
      paramString = paramq;
      if (paramInt3 > 0) {
        paramString = paramq.substring(paramInt3);
      }
      paramString = bv.L(paramString, "pushcontent");
      if (paramString == null) {
        ac.e("MicroMsg.NetPushSync", "inval xml");
      }
      for (;;)
      {
        paramString = (PluginZero)com.tencent.mm.kernel.g.ad(PluginZero.class);
        if (paramString.Hap == null) {
          break;
        }
        paramq = com.tencent.mm.loader.j.b.aoY() + com.tencent.mm.b.g.getMessageDigest(new StringBuilder("mm").append(com.tencent.mm.network.ad.aMf().ilv.getUin()).toString().getBytes());
        paramString.Hap.a(l, str, localPString2.value, localPString1.value, paramq + "/avatar/", paramInt1);
        break;
        localPString1.value = ((String)paramString.get(".pushcontent.$content"));
        localPString2.value = ((String)paramString.get(".pushcontent.$nickname"));
      }
      label1210:
      paramInt1 = 0;
      continue;
      try
      {
        paramq = localb.DJr.toByteArray();
        paramInt3 = com.tencent.mm.network.ad.aMf().ilv.getUin();
        paramString = com.tencent.mm.booter.g.kp(paramInt3);
        paramInt1 = com.tencent.mm.booter.g.rt(paramString) + 1;
        paramArrayOfByte = paramString + "/syncResp.bin" + paramInt1;
        localObject1 = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.compatible.deviceinfo.q.cF(true) + paramInt3).getBytes());
        localObject2 = l.e(paramq, ((String)localObject1).getBytes());
        ac.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramq.length), Integer.valueOf(localObject2.length), paramArrayOfByte, com.tencent.mm.booter.g.O(paramq), com.tencent.mm.booter.g.O((byte[])localObject2), com.tencent.mm.booter.g.O(((String)localObject1).getBytes()) });
        if (bs.cv((byte[])localObject2)) {
          ac.e("MicroMsg.NotifySyncMgr", "encry failed");
        }
        for (;;)
        {
          ac.d("MicroMsg.NetPushSync", "onRespHandled sync");
          ai.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.YK()).edit().putString("notify_sync_key_keybuf", bs.cx(z.a(localb.DJr.Eki))).commit();
          ac.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", new Object[] { Integer.valueOf(this.hLx) });
          if (paramInt2 != 0) {
            break label1732;
          }
          if (((localb.DJr.EfS & hLw) == 0) || (securityLimitCountReach())) {
            break label1727;
          }
          paramInt1 = 1;
          ac.i("MicroMsg.NetPushSync", "continue flag=" + localb.DJr.EfS + ", selector=" + hLw + ", limit reach=" + securityLimitCountReach());
          if (paramInt1 == 0) {
            break label1732;
          }
          doScene(dispatcher(), this.callback);
          if (paramInt2 != 0) {
            CoreService.Uf();
          }
          AppMethodBeat.o(132548);
          return;
          paramInt3 = i.f(paramArrayOfByte, (byte[])localObject2, localObject2.length);
          boolean bool = i.eA(paramArrayOfByte);
          if ((paramInt3 == 0) && (bool)) {
            break;
          }
          ac.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", new Object[] { Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          ac.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", new Object[] { paramString });
          ac.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
          continue;
          paramq = String.valueOf(paramInt1).getBytes();
          i.f(paramString + "/syncResp.ini", paramq, paramq.length);
          continue;
          label1727:
          paramInt1 = 0;
          continue;
          label1732:
          if ((this.hLx & 0x1) > 0)
          {
            ac.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
            new g(this.hLz, z.a(localb.DJr.Eki), com.tencent.mm.network.ad.aMf().ilv.getUin()).doScene(com.tencent.mm.network.ad.aMf(), new b.2(this));
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
    return n.b.hwa;
  }
  
  public static final class a
    implements com.tencent.mm.network.q
  {
    private final v.a hLD;
    private final v.b hLE;
    private final boolean hLF;
    int uin;
    
    public a()
    {
      AppMethodBeat.i(132539);
      this.hLD = new v.a();
      this.hLE = new v.b();
      this.hLF = false;
      AppMethodBeat.o(132539);
    }
    
    public a(v.b paramb)
    {
      AppMethodBeat.i(132540);
      this.hLD = new v.a();
      this.hLE = paramb;
      this.hLF = true;
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
      this.hLD.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.XX());
      this.hLD.setDeviceType(d.gMK);
      this.hLD.setClientVersion(d.DIc);
      this.hLD.setUin(this.uin);
      v.a locala = this.hLD;
      AppMethodBeat.o(132541);
      return locala;
    }
    
    public final l.e getRespObj()
    {
      return this.hLE;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b
 * JD-Core Version:    0.7.0.1
 */