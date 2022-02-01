package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.p;
import com.tencent.mm.plugin.collect.model.v;
import com.tencent.mm.plugin.collect.model.voice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements aw
{
  private cc.a nSR;
  private com.tencent.mm.plugin.collect.model.g nSS;
  private v nST;
  public boolean nSU;
  private c<com.tencent.mm.g.a.k> nSV;
  
  public a()
  {
    AppMethodBeat.i(63760);
    this.nSR = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(63757);
        a.bOn();
        if (a.bOo() != null)
        {
          String str1 = z.a(paramAnonymousa.fTo.Cxz);
          a.bOn();
          Object localObject1 = a.bOo();
          long l = paramAnonymousa.fTo.CreateTime;
          ad.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(str1)));
          if (bt.isNullOrNil(str1))
          {
            ad.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(63757);
            return;
          }
          Object localObject2 = bw.K(str1, "sysmsg");
          int i = bt.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.PayMsgType"), 0);
          if ((i != 9) && (i != 26))
          {
            ad.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=".concat(String.valueOf(i)));
            AppMethodBeat.o(63757);
            return;
          }
          paramAnonymousa = new com.tencent.mm.plugin.collect.model.u();
          paramAnonymousa.username = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.username"));
          paramAnonymousa.nUf = (bt.getDouble((String)((Map)localObject2).get(".sysmsg.paymsg.fee"), 0.0D) / 100.0D);
          paramAnonymousa.dem = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.feetype"));
          paramAnonymousa.nUh = bt.getInt((String)((Map)localObject2).get(".sysmsg.paymsgtimestamp"), (int)bt.aGK());
          paramAnonymousa.dcF = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.transid"));
          paramAnonymousa.fyo = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.displayname"));
          paramAnonymousa.scene = bt.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.scene"), 1);
          paramAnonymousa.status = bt.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.status"), 0);
          paramAnonymousa.msgType = i;
          paramAnonymousa.nUi = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.outtradeno"));
          paramAnonymousa.type = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.type"));
          str1 = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.voice_content"));
          String str2 = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.expire_voice_timestamp"));
          i = bt.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.need_failover"), 1);
          localObject1 = ((com.tencent.mm.plugin.collect.model.d)localObject1).nqa.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (d.a)((Iterator)localObject1).next();
            if (localObject2 != null) {
              ((d.a)localObject2).a(paramAnonymousa);
            }
          }
          if (paramAnonymousa.status == 1)
          {
            localObject1 = new cd();
            ((cd)localObject1).dek.del = ((int)Math.round(paramAnonymousa.nUf * 100.0D));
            ((cd)localObject1).dek.dem = paramAnonymousa.dem;
            ((cd)localObject1).dek.deo = paramAnonymousa.type;
            ((cd)localObject1).dek.den = paramAnonymousa.nUi;
            ((cd)localObject1).dek.ed = (ce.asR() - l * 1000L);
            ((cd)localObject1).dek.dep = 1;
            ((cd)localObject1).dek.deq = str1;
            ((cd)localObject1).dek.der = str2;
            if (i != 0) {
              break label601;
            }
          }
          label601:
          for (((cd)localObject1).dek.des = false;; ((cd)localObject1).dek.des = true)
          {
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
            AppMethodBeat.o(63757);
            return;
          }
        }
        ad.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
        AppMethodBeat.o(63757);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.nSS = new com.tencent.mm.plugin.collect.model.g();
    this.nST = new v();
    this.nSU = false;
    this.nSV = new a.3(this);
    AppMethodBeat.o(63760);
  }
  
  private void RU(String paramString)
  {
    AppMethodBeat.i(63768);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(304, new a.2(this));
    paramString = new p(bt.by(paramString, ""));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    AppMethodBeat.o(63768);
  }
  
  public static a bOn()
  {
    AppMethodBeat.i(63761);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(63761);
    return locala;
  }
  
  public static com.tencent.mm.plugin.collect.model.d bOo()
  {
    AppMethodBeat.i(63764);
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.plugin.collect.model.d locald = com.tencent.mm.plugin.collect.model.d.nTb;
    AppMethodBeat.o(63764);
    return locald;
  }
  
  public static boolean bOp()
  {
    AppMethodBeat.i(63765);
    Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FnA, "");
    long l = com.tencent.mm.model.u.aqL();
    if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equals("in.caf")))
    {
      ad.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
      com.tencent.mm.kernel.g.afB().afk().set(147457, Long.valueOf(l | 0x8000));
      localObject = new bqy();
      ((bqy)localObject).vJA = 1;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(209, (com.tencent.mm.bx.a)localObject));
      AppMethodBeat.o(63765);
      return true;
    }
    if ((l & 0x8000) != 0L)
    {
      AppMethodBeat.o(63765);
      return true;
    }
    AppMethodBeat.o(63765);
    return false;
  }
  
  public final void bOq()
  {
    AppMethodBeat.i(63766);
    RU("cash.caf");
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FnA, "cash.caf");
    AppMethodBeat.o(63766);
  }
  
  public final void bOr()
  {
    AppMethodBeat.i(63767);
    RU("in.caf");
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FnA, "in.caf");
    AppMethodBeat.o(63767);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(63762);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("paymsg", this.nSR, true);
    this.nSV.alive();
    com.tencent.mm.plugin.collect.model.g localg = this.nSS;
    localg.alive();
    localg.nTh = new ConcurrentLinkedQueue();
    com.tencent.mm.plugin.collect.model.voice.a locala = com.tencent.mm.plugin.collect.model.voice.a.bOE();
    locala.nUv = localg;
    locala.nUw = new a.b(locala, locala.nUv);
    com.tencent.mm.kernel.g.afB().afk().a(locala);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1384, localg);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1317, localg);
    this.nST.alive();
    AppMethodBeat.o(63762);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63763);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("paymsg", this.nSR, true);
    Object localObject = this.nSS;
    ((com.tencent.mm.plugin.collect.model.g)localObject).dead();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1384, (com.tencent.mm.al.g)localObject);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1317, (com.tencent.mm.al.g)localObject);
    com.tencent.mm.plugin.collect.model.g.bOt();
    localObject = com.tencent.mm.plugin.collect.model.voice.a.bOE();
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
    try
    {
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).nUu != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).nUu.nUO.destroy();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).nUA != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).nUA.dead();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).nUB != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).nUB.dead();
      }
      com.tencent.mm.kernel.g.afB().afk().b((n.b)localObject);
      com.tencent.mm.plugin.collect.model.voice.a.nUp = false;
      this.nST.dead();
      this.nSV.dead();
      AppMethodBeat.o(63763);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy() synthesizer.destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a
 * JD-Core Version:    0.7.0.1
 */