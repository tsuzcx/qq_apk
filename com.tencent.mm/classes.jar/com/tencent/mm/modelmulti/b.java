package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.a;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.azf;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b
  extends m
  implements com.tencent.mm.network.k
{
  protected static int selector = 7;
  private String aox = "";
  private com.tencent.mm.ah.f dmL;
  private am ebj;
  private int errCode = 0;
  private int errType = 0;
  private int esl = 0;
  private g.a esm;
  private StringBuilder esn = new StringBuilder();
  private long eso = -1L;
  private boolean esp = false;
  
  public b()
  {
    y.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    this.esm = new g.a();
    this.esn.append("stack:" + bk.csb() + " time:" + bk.UX());
  }
  
  public b(s.b paramb, int paramInt, long paramLong)
  {
    this();
    this.esl = paramInt;
    this.eso = paramLong;
    y.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
    this.ebj = new am(com.tencent.mm.network.aa.Ux(), new b.1(this, paramb), false);
  }
  
  protected final int Ka()
  {
    return 500;
  }
  
  public final boolean Ky()
  {
    return super.Ky();
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    boolean bool = false;
    this.dmL = paramf;
    this.esn.append(" lastd:" + this.edd + " dotime:" + bk.UX() + " net:" + aq.getNetType(ae.getContext()));
    int i = hashCode();
    int j = selector;
    if (this.ebj != null) {
      bool = true;
    }
    y.i("MicroMsg.NetPushSync", "doScene[%d] selector:%d pusher:%b ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    if (this.ebj != null)
    {
      c(parame);
      this.ebj.S(0L, 0L);
      this.ebj = null;
      return -1;
    }
    paramf = new b.a();
    paramf.uin = com.tencent.mm.network.aa.Uu().eNL.CK();
    azf localazf = ((s.a)paramf.Kv()).sqi;
    localazf.sIh = selector;
    localazf.sIi = com.tencent.mm.platformtools.aa.I(bk.ZM(ae.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", "")));
    localazf.pyo = 1;
    localazf.tvu = new qw();
    localazf.syI = d.dOM;
    return a(parame, paramf, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    if ((paramq == null) || (paramq.getType() != 138))
    {
      if (paramq == null) {}
      for (paramInt1 = -2;; paramInt1 = paramq.getType())
      {
        y.e("MicroMsg.NetPushSync", "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        return;
      }
    }
    this.esn.append(" endtime:" + bk.UX());
    y.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.esp), Long.valueOf(this.esm.zJ()), this.esn });
    label175:
    s.b localb;
    label242:
    Object localObject1;
    if ((paramInt2 == 4) && (paramInt3 == -2006))
    {
      paramInt2 = 0;
      paramInt3 = 0;
      paramInt1 = 1;
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      localb = (s.b)paramq.HF();
      if (paramInt1 == 0)
      {
        paramString = com.tencent.mm.platformtools.aa.a(((s.a)paramq.Kv()).sqi.sIi);
        if (paramString == null)
        {
          paramInt1 = -1;
          y.d("MicroMsg.NetPushSync", "dkpush req Key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), bk.bD(paramString) });
          if (!bk.bE(paramString)) {
            break label1791;
          }
          paramString = bk.ZM(ae.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
          y.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bk.bD(paramString) });
          label329:
          paramq = com.tencent.mm.platformtools.aa.a(localb.sqj.sIi);
          paramArrayOfByte = z.g(paramString, paramq);
          if (paramArrayOfByte != null)
          {
            paramString = paramArrayOfByte;
            if (paramArrayOfByte.length > 0) {}
          }
          else
          {
            y.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
            paramString = paramq;
          }
          localb.sqj.sIi = com.tencent.mm.platformtools.aa.I(paramString);
          if ((localb.sqj.sIl != null) && (localb.sqj.sIl.hPT != null)) {
            break label706;
          }
          paramInt1 = 0;
          label418:
          y.i("MicroMsg.NetPushSync", "newMsgSize:%d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramString != null) {
            break label724;
          }
          paramInt2 = -1;
          label444:
          y.d("MicroMsg.NetPushSync", "newMsgSize:%d, mergeKey: %d[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bk.bD(paramString) });
        }
      }
      else
      {
        paramArrayOfByte = localb.sqj.sIl.hPT.iterator();
        paramInt2 = 0;
        label496:
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (qv)paramArrayOfByte.next();
          if (((qv)localObject1).sOA == 5) {
            paramString = com.tencent.mm.platformtools.aa.a(((qv)localObject1).sOB);
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        Object localObject2;
        long l;
        label706:
        label724:
        String str;
        try
        {
          localObject2 = new cd();
          ((cd)localObject2).aH(paramString);
          int i = ((cd)localObject2).kSW;
          paramString = ((cd)localObject2).svF.tFO;
          l = ((cd)localObject2).ndp;
          if (((cd)localObject2).svL == null)
          {
            paramInt1 = 0;
            if (((cd)localObject2).svH.tFO != null) {
              continue;
            }
            paramInt3 = 0;
            y.i("MicroMsg.NetPushSync", "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d", new Object[] { Integer.valueOf(i), paramString, Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
            paramInt1 = ((cd)localObject2).kSW;
            paramString = ((cd)localObject2).svF.tFO;
            paramq = ((cd)localObject2).svH.tFO;
            if (paramInt1 != 50) {
              continue;
            }
            y.i("MicroMsg.NetPushSync", "hit voip");
            paramInt1 = 1;
            if (paramInt1 == 0) {
              continue;
            }
            paramInt2 = 1;
            break label496;
            paramInt1 = paramString.length;
            break label242;
            paramInt1 = localb.sqj.sIl.hPT.size();
            break label418;
            paramInt2 = paramString.length;
            break label444;
          }
          paramInt1 = ((cd)localObject2).svL.length();
          continue;
          paramInt3 = ((cd)localObject2).svH.tFO.length();
          continue;
          if ((bk.bl(paramq)) || (bk.bl(paramString)))
          {
            y.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
            break label1799;
          }
          if ((paramInt1 == 9998) && (paramString.equalsIgnoreCase("weixin")))
          {
            y.i("MicroMsg.NetPushSync", "hit ipxx");
            paramInt1 = 1;
            continue;
          }
          if ((paramInt1 != 10002) || (!paramq.contains("revokemsg"))) {
            break label1799;
          }
          y.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
          paramInt1 = 1;
          continue;
          l = ((cd)localObject2).ndp;
          str = ((cd)localObject2).svF.tFO;
          paramString = ((cd)localObject2).svL;
          paramInt1 = ((cd)localObject2).kSW;
          if (!bk.bl(paramString)) {
            break label958;
          }
          y.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
          if (((cd)localObject2).kSW != 10002) {
            break label1190;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label496;
          }
          y.i("MicroMsg.NetPushSync", "need remove pushContent");
          ((cd)localObject2).svL = null;
          ((qv)localObject1).sOB = com.tencent.mm.platformtools.aa.I(((cd)localObject2).toByteArray());
        }
        catch (IOException paramString)
        {
          y.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
        }
        break label496;
        label958:
        PString localPString1 = new PString();
        PString localPString2 = new PString();
        paramq = bk.ZQ(paramString);
        paramInt3 = paramq.indexOf("<pushcontent");
        paramString = paramq;
        if (paramInt3 > 0) {
          paramString = paramq.substring(paramInt3);
        }
        paramString = bn.s(paramString, "pushcontent");
        if (paramString == null) {
          y.e("MicroMsg.NetPushSync", "inval xml");
        }
        for (;;)
        {
          paramString = (PluginZero)com.tencent.mm.kernel.g.t(PluginZero.class);
          if (paramString.rSe == null) {
            break;
          }
          paramq = com.tencent.mm.compatible.util.e.dOO + com.tencent.mm.a.g.o(new StringBuilder("mm").append(com.tencent.mm.network.aa.Uu().eNL.CK()).toString().getBytes());
          paramString.rSe.a(l, str, localPString2.value, localPString1.value, paramq + "/avatar/", paramInt1);
          break;
          localPString1.value = ((String)paramString.get(".pushcontent.$content"));
          localPString2.value = ((String)paramString.get(".pushcontent.$nickname"));
        }
        label1190:
        paramInt1 = 0;
        continue;
        try
        {
          paramq = localb.sqj.toByteArray();
          paramInt3 = com.tencent.mm.network.aa.Uu().eNL.CK();
          paramString = com.tencent.mm.booter.f.fR(paramInt3);
          paramInt1 = com.tencent.mm.booter.f.ep(paramString) + 1;
          paramArrayOfByte = paramString + "/syncResp.bin" + paramInt1;
          localObject1 = com.tencent.mm.a.g.o((com.tencent.mm.compatible.e.q.zf() + paramInt3).getBytes());
          localObject2 = com.tencent.mm.a.k.b(paramq, ((String)localObject1).getBytes());
          y.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramq.length), Integer.valueOf(localObject2.length), paramArrayOfByte, com.tencent.mm.booter.f.x(paramq), com.tencent.mm.booter.f.x((byte[])localObject2), com.tencent.mm.booter.f.x(((String)localObject1).getBytes()) });
          if (bk.bE((byte[])localObject2)) {
            y.e("MicroMsg.NotifySyncMgr", "encry failed");
          }
          for (;;)
          {
            y.d("MicroMsg.NetPushSync", "onRespHandled sync");
            ae.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bk.bG(com.tencent.mm.platformtools.aa.a(localb.sqj.sIi))).commit();
            y.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", new Object[] { Integer.valueOf(this.esl) });
            if (paramInt2 != 0) {
              break label1703;
            }
            if (((localb.sqj.sFD & selector) == 0) || (super.Ky())) {
              break label1698;
            }
            paramInt1 = 1;
            y.i("MicroMsg.NetPushSync", "continue flag=" + localb.sqj.sFD + ", selector=" + selector + ", limit reach=" + super.Ky());
            if (paramInt1 == 0) {
              break label1703;
            }
            a(this.edc, this.dmL);
            if (paramInt2 == 0) {
              break;
            }
            CoreService.vU();
            return;
            paramInt3 = com.tencent.mm.a.e.b(paramArrayOfByte, (byte[])localObject2, localObject2.length);
            boolean bool = com.tencent.mm.a.e.bK(paramArrayOfByte);
            if ((paramInt3 == 0) && (bool)) {
              break label1656;
            }
            y.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", new Object[] { Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            y.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", new Object[] { paramString });
            y.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
            continue;
            label1656:
            paramq = String.valueOf(paramInt1).getBytes();
            com.tencent.mm.a.e.b(paramString + "/syncResp.ini", paramq, paramq.length);
            continue;
            label1698:
            paramInt1 = 0;
            continue;
            label1703:
            if ((this.esl & 0x1) > 0)
            {
              y.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
              new f(this.eso, com.tencent.mm.platformtools.aa.a(localb.sqj.sIi), com.tencent.mm.network.aa.Uu().eNL.CK()).a(com.tencent.mm.network.aa.Uu(), new b.2(this));
            }
            this.dmL.onSceneEnd(this.errType, this.errCode, this.aox, this);
          }
        }
      }
      label1791:
      break label329;
      paramInt1 = 0;
      break label175;
      label1799:
      paramInt1 = 0;
    }
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  protected final void cancel()
  {
    super.cancel();
  }
  
  public final String getInfo()
  {
    return this.esn.toString();
  }
  
  public final int getType()
  {
    return 138;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b
 * JD-Core Version:    0.7.0.1
 */