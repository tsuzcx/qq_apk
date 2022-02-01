package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
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
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements aw
{
  private cc.a owm;
  private com.tencent.mm.plugin.collect.model.g own;
  private v owo;
  public boolean owp;
  private c<com.tencent.mm.g.a.k> owq;
  
  public a()
  {
    AppMethodBeat.i(63760);
    this.owm = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(63757);
        a.bVD();
        if (a.bVE() != null)
        {
          String str1 = z.a(paramAnonymousa.fXi.DPV);
          a.bVD();
          Object localObject1 = a.bVE();
          long l = paramAnonymousa.fXi.CreateTime;
          ac.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(str1)));
          if (bs.isNullOrNil(str1))
          {
            ac.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(63757);
            return;
          }
          Object localObject2 = bv.L(str1, "sysmsg");
          int i = bs.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.PayMsgType"), 0);
          if ((i != 9) && (i != 26))
          {
            ac.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=".concat(String.valueOf(i)));
            AppMethodBeat.o(63757);
            return;
          }
          paramAnonymousa = new com.tencent.mm.plugin.collect.model.u();
          paramAnonymousa.username = bs.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.username"));
          paramAnonymousa.oxA = (bs.getDouble((String)((Map)localObject2).get(".sysmsg.paymsg.fee"), 0.0D) / 100.0D);
          paramAnonymousa.dbI = bs.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.feetype"));
          paramAnonymousa.oxC = bs.getInt((String)((Map)localObject2).get(".sysmsg.paymsgtimestamp"), (int)bs.aNx());
          paramAnonymousa.dad = bs.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.transid"));
          paramAnonymousa.fBV = bs.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.displayname"));
          paramAnonymousa.scene = bs.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.scene"), 1);
          paramAnonymousa.status = bs.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.status"), 0);
          paramAnonymousa.msgType = i;
          paramAnonymousa.oxD = bs.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.outtradeno"));
          paramAnonymousa.type = bs.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.type"));
          str1 = bs.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.voice_content"));
          String str2 = bs.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.expire_voice_timestamp"));
          i = bs.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.need_failover"), 1);
          localObject1 = ((com.tencent.mm.plugin.collect.model.d)localObject1).nTa.iterator();
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
            ((cd)localObject1).dbG.dbH = ((int)Math.round(paramAnonymousa.oxA * 100.0D));
            ((cd)localObject1).dbG.dbI = paramAnonymousa.dbI;
            ((cd)localObject1).dbG.dbK = paramAnonymousa.type;
            ((cd)localObject1).dbG.dbJ = paramAnonymousa.oxD;
            ((cd)localObject1).dbG.fe = (ce.azI() - l * 1000L);
            ((cd)localObject1).dbG.dbL = 1;
            ((cd)localObject1).dbG.dbM = str1;
            ((cd)localObject1).dbG.dbN = str2;
            if (i != 0) {
              break label601;
            }
          }
          label601:
          for (((cd)localObject1).dbG.dbO = false;; ((cd)localObject1).dbG.dbO = true)
          {
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
            AppMethodBeat.o(63757);
            return;
          }
        }
        ac.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
        AppMethodBeat.o(63757);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.own = new com.tencent.mm.plugin.collect.model.g();
    this.owo = new v();
    this.owp = false;
    this.owq = new a.3(this);
    AppMethodBeat.o(63760);
  }
  
  private void Wg(String paramString)
  {
    AppMethodBeat.i(63768);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(304, new a.2(this));
    paramString = new p(bs.bG(paramString, ""));
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
    AppMethodBeat.o(63768);
  }
  
  public static a bVD()
  {
    AppMethodBeat.i(63761);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(63761);
    return locala;
  }
  
  public static com.tencent.mm.plugin.collect.model.d bVE()
  {
    AppMethodBeat.i(63764);
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.plugin.collect.model.d locald = com.tencent.mm.plugin.collect.model.d.oww;
    AppMethodBeat.o(63764);
    return locald;
  }
  
  public static boolean bVF()
  {
    AppMethodBeat.i(63765);
    Object localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLp, "");
    long l = com.tencent.mm.model.u.axB();
    if ((!bs.isNullOrNil((String)localObject)) && (!((String)localObject).equals("in.caf")))
    {
      ac.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
      com.tencent.mm.kernel.g.agR().agA().set(147457, Long.valueOf(l | 0x8000));
      localObject = new bvp();
      ((bvp)localObject).wTE = 1;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(209, (com.tencent.mm.bw.a)localObject));
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
  
  public final void bVG()
  {
    AppMethodBeat.i(63766);
    Wg("cash.caf");
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLp, "cash.caf");
    AppMethodBeat.o(63766);
  }
  
  public final void bVH()
  {
    AppMethodBeat.i(63767);
    Wg("in.caf");
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLp, "in.caf");
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
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("paymsg", this.owm, true);
    this.owq.alive();
    com.tencent.mm.plugin.collect.model.g localg = this.own;
    localg.alive();
    localg.owC = new ConcurrentLinkedQueue();
    com.tencent.mm.plugin.collect.model.voice.a locala = com.tencent.mm.plugin.collect.model.voice.a.bVU();
    locala.oxQ = localg;
    locala.oxR = new a.b(locala, locala.oxQ);
    com.tencent.mm.kernel.g.agR().agA().a(locala);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1384, localg);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1317, localg);
    this.owo.alive();
    AppMethodBeat.o(63762);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63763);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("paymsg", this.owm, true);
    Object localObject = this.own;
    ((com.tencent.mm.plugin.collect.model.g)localObject).dead();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1384, (com.tencent.mm.ak.g)localObject);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1317, (com.tencent.mm.ak.g)localObject);
    com.tencent.mm.plugin.collect.model.g.bVJ();
    localObject = com.tencent.mm.plugin.collect.model.voice.a.bVU();
    ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
    try
    {
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).oxP != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).oxP.oyj.destroy();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).oxV != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).oxV.dead();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).oxW != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).oxW.dead();
      }
      com.tencent.mm.kernel.g.agR().agA().b((n.b)localObject);
      com.tencent.mm.plugin.collect.model.voice.a.oxK = false;
      this.owo.dead();
      this.owq.dead();
      AppMethodBeat.o(63763);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy() synthesizer.destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a
 * JD-Core Version:    0.7.0.1
 */