package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.mm.a.g;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.o.k.b;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.w.e.h;
import com.tencent.mm.protocal.c.cgk;
import com.tencent.mm.protocal.c.cgm;
import com.tencent.mm.protocal.c.cgr;
import com.tencent.mm.protocal.c.cgw;
import com.tencent.mm.protocal.c.cgx;
import com.tencent.mm.protocal.c.cgz;
import com.tencent.mm.protocal.c.cha;
import com.tencent.mm.protocal.c.chc;
import com.tencent.mm.protocal.c.chd;
import com.tencent.mm.protocal.c.che;
import com.tencent.mm.protocal.c.chg;
import com.tencent.mm.protocal.c.chj;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;

final class l$2
  implements k.b
{
  l$2(l paraml) {}
  
  public final void A(int paramInt, String paramString)
  {
    int i = 1;
    y.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[] { Integer.valueOf(paramInt), paramString });
    j localj = this.fSs.fSm;
    if ((!localj.aeD()) && (localj.fSe < 10L)) {}
    for (paramInt = i;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        com.tencent.mm.plugin.appbrand.u.n.DS().k(new l.2.1(this), 1000L);
        localj = this.fSs.fSm;
        localj.fSe += 1;
      }
      this.fSs.fSp.aeK();
      this.fSs.fSm.fRS = System.currentTimeMillis();
      this.fSs.fSq.aeS();
      this.fSs.fSm.setStatus(5);
      this.fSs.fSq.sS(paramString);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.w.e.a parama) {}
  
  public final void a(h paramh)
  {
    y.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
    this.fSs.fSm.fRS = System.currentTimeMillis();
    this.fSs.fSm.fSe = 0;
    if (!bk.bl(this.fSs.fSm.aez())) {
      l.a(this.fSs);
    }
    paramh = this.fSs.fSp;
    paramh.aeK();
    paramh.mTimer = new Timer();
    n.4 local4 = new n.4(paramh);
    paramh.mTimer.schedule(local4, 100L, 1000L);
  }
  
  public final void g(ByteBuffer paramByteBuffer)
  {
    this.fSs.fSm.fRS = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        paramByteBuffer = com.tencent.mm.plugin.appbrand.u.d.k(paramByteBuffer);
        paramByteBuffer = (cgk)new cgk().aH(paramByteBuffer);
        if (paramByteBuffer.sRj == null)
        {
          y.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
          return;
        }
        localObject1 = paramByteBuffer.sRj.oY;
        switch (paramByteBuffer.uC)
        {
        case 1006: 
          y.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[] { Integer.valueOf(paramByteBuffer.uC) });
          return;
        }
      }
      catch (Throwable paramByteBuffer)
      {
        y.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", new Object[] { Log.getStackTraceString(paramByteBuffer) });
        return;
      }
      Object localObject1 = (cgz)new cgz().aH((byte[])localObject1);
      Object localObject2 = this.fSs.fSp;
      if (r.a(((n)localObject2).fSm, paramByteBuffer, ((cgz)localObject1).tVS, ((n)localObject2).fSq, (n)localObject2))
      {
        y.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[] { Integer.valueOf(((cgz)localObject1).tVT), Integer.valueOf(((cgz)localObject1).tVU) });
        ((n)localObject2).fSm.bO(((cgz)localObject1).tVT, ((cgz)localObject1).tVU);
        ((n)localObject2).bQ(((cgz)localObject1).tVT, ((cgz)localObject1).tVU);
      }
      o.a(paramByteBuffer, (i)this.fSs.fSm.fSb.get(paramByteBuffer.dCX));
      continue;
      localObject1 = (chc)new chc().aH((byte[])localObject1);
      r.a(this.fSs.fSm, paramByteBuffer, ((chc)localObject1).tVS, this.fSs.fSq, this.fSs.fSp);
      this.fSs.fSm.fRS = System.currentTimeMillis();
      continue;
      localObject2 = (chg)new chg().aH((byte[])localObject1);
      localObject1 = this.fSs;
      if (r.a(((l)localObject1).fSm, paramByteBuffer, ((chg)localObject2).tVS, ((l)localObject1).fSq, ((l)localObject1).fSp))
      {
        y.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
        if (((chg)localObject2).tWc == null)
        {
          y.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
        }
        else if (((chg)localObject2).tWc.tVK)
        {
          ((l)localObject1).fSm.fRN = ((chg)localObject2).tWc;
          ((l)localObject1).onReady();
        }
        else
        {
          y.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
          ((l)localObject1).fSm.setStatus(2);
          localObject2 = new chd();
          ((chd)localObject2).tVQ = ((l)localObject1).fSm.fRJ;
          ((chd)localObject2).tVL = ((l)localObject1).fSm.fRO.dmT;
          ((chd)localObject2).username = "";
          ((chd)localObject2).tWb = ((l)localObject1).fSm.fRO.fSh;
          localObject2 = r.a(1003, (com.tencent.mm.bv.a)localObject2);
          ((l)localObject1).fSo.a((cgk)localObject2);
          continue;
          localObject1 = (che)new che().aH((byte[])localObject1);
          if (r.a(this.fSs.fSm, paramByteBuffer, ((che)localObject1).tVS, this.fSs.fSq, this.fSs.fSp))
          {
            localObject1 = this.fSs;
            Object localObject3 = WxaCommLibRuntimeReader.abQ();
            localObject2 = new cha();
            cgm localcgm = new cgm();
            ((cha)localObject2).tVW = localcgm;
            Object localObject5 = (p)((l)localObject1).fyo;
            Object localObject4 = ((p)localObject5).aaw();
            localObject5 = ((p)localObject5).getRuntime().getAppConfig().fNJ;
            ((cha)localObject2).tVX = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject4).toString(), localObject5 });
            ((cha)localObject2).tVZ = ((l)localObject1).fyo.getRuntime().ZB().fPS.bIW;
            ((cha)localObject2).tWa = 1;
            localObject4 = WxaCommLibRuntimeReader.qX("WAService.js");
            if (!bk.bl((String)localObject4)) {
              ((cha)localObject2).tVY = g.o(((String)localObject4).getBytes());
            }
            localcgm.tVy = ((WxaPkgWrappingInfo)localObject3).fEN;
            localcgm.sPc = com.tencent.mm.protocal.d.soV;
            localcgm.tVv = com.tencent.mm.protocal.d.DEVICE_NAME;
            localcgm.tVx = e.ag(((l)localObject1).fyk, com.tencent.mm.protocal.d.spa);
            localcgm.tVw = com.tencent.mm.protocal.d.soY;
            localcgm.tVA = ((l)localObject1).fyk.getResources().getDisplayMetrics().density;
            localcgm.tVz = (((l)localObject1).fyk.getResources().getDisplayMetrics().widthPixels / localcgm.tVA);
            localcgm.tVB = ((com.tencent.mm.plugin.appbrand.page.s)((l)localObject1).fyo.E(com.tencent.mm.plugin.appbrand.page.s.class)).gTF.getUserAgentString();
            localObject3 = new cgw();
            n.a((cgw)localObject3);
            ((cha)localObject2).tVV = ((cgw)localObject3);
            localObject3 = r.a((com.tencent.mm.bv.a)localObject2, ((l)localObject1).fSm, "setupContext");
            ((l)localObject1).fSp.a((m)localObject3);
            y.d("MicroMsg.RemoteDebugJsEngine", "setupContext %s/%s/%d, %s", new Object[] { ((cha)localObject2).tVY, ((cha)localObject2).tVZ, Integer.valueOf(localcgm.tVy), localcgm.tVB });
            continue;
            localObject1 = this.fSs.fSp;
            y.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
            ((n)localObject1).fSm.setStatus(4);
            localObject2 = ((n)localObject1).fSo;
            if (((q)localObject2).fSO == null) {
              y.w("MicroMsg.RemoteDebugSocket", "client is null");
            }
            for (;;)
            {
              localObject1 = ((n)localObject1).fSq;
              ((s)localObject1).aeS();
              ai.d(new s.6((s)localObject1));
              break;
              ((q)localObject2).fSO.S(1000, "quit");
              y.d("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", new Object[] { Integer.valueOf(1000), "quit" });
            }
            localObject1 = (chj)new chj().aH((byte[])localObject1);
            localObject2 = this.fSs.fSp;
            y.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
            if (r.a(((n)localObject2).fSm, paramByteBuffer, ((chj)localObject1).tVS, ((n)localObject2).fSq, (n)localObject2))
            {
              ((n)localObject2).u(((chj)localObject1).tVF);
              ((n)localObject2).fSm.kE(((chj)localObject1).tWf);
              ((n)localObject2).aeJ();
              continue;
              localObject1 = (cgr)new cgr().aH((byte[])localObject1);
              this.fSs.fSp.u(((cgr)localObject1).tVF);
              continue;
              this.fSs.onReady();
              continue;
              this.fSs.fSm.setStatus(4);
              this.fSs.fSp.quit();
            }
          }
        }
      }
    }
  }
  
  public final void sL(String paramString)
  {
    y.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[] { paramString });
    this.fSs.fSq.sS(paramString);
  }
  
  public final void sM(String paramString)
  {
    this.fSs.fSm.fRS = System.currentTimeMillis();
  }
  
  public final void sN(String paramString)
  {
    y.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.l.2
 * JD-Core Version:    0.7.0.1
 */