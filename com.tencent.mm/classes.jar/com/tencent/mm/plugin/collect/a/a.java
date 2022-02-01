package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.p;
import com.tencent.mm.plugin.collect.model.v;
import com.tencent.mm.plugin.collect.model.voice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements ax
{
  private cd.a oZH;
  private com.tencent.mm.plugin.collect.model.g oZI;
  private v oZJ;
  public boolean oZK;
  private c<k> oZL;
  
  public a()
  {
    AppMethodBeat.i(63760);
    this.oZH = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(63757);
        a.cag();
        if (a.cah() != null)
        {
          String str1 = z.a(paramAnonymousa.gqE.Fvk);
          a.cag();
          Object localObject1 = a.cah();
          long l = paramAnonymousa.gqE.CreateTime;
          ad.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(str1)));
          if (bt.isNullOrNil(str1))
          {
            ad.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(63757);
            return;
          }
          Object localObject2 = bw.M(str1, "sysmsg");
          int i = bt.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.PayMsgType"), 0);
          if ((i != 9) && (i != 26))
          {
            ad.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=".concat(String.valueOf(i)));
            AppMethodBeat.o(63757);
            return;
          }
          paramAnonymousa = new com.tencent.mm.plugin.collect.model.u();
          paramAnonymousa.username = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.username"));
          paramAnonymousa.paV = (bt.getDouble((String)((Map)localObject2).get(".sysmsg.paymsg.fee"), 0.0D) / 100.0D);
          paramAnonymousa.dne = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.feetype"));
          paramAnonymousa.paX = bt.getInt((String)((Map)localObject2).get(".sysmsg.paymsgtimestamp"), (int)bt.aQJ());
          paramAnonymousa.dlv = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.transid"));
          paramAnonymousa.fVj = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.displayname"));
          paramAnonymousa.scene = bt.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.scene"), 1);
          paramAnonymousa.status = bt.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.status"), 0);
          paramAnonymousa.msgType = i;
          paramAnonymousa.paY = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.outtradeno"));
          paramAnonymousa.type = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.type"));
          str1 = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.voice_content"));
          String str2 = bt.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.expire_voice_timestamp"));
          i = bt.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.need_failover"), 1);
          localObject1 = ((com.tencent.mm.plugin.collect.model.d)localObject1).owv.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (d.a)((Iterator)localObject1).next();
            if (localObject2 != null) {
              ((d.a)localObject2).a(paramAnonymousa);
            }
          }
          if (paramAnonymousa.status == 1)
          {
            localObject1 = new cg();
            ((cg)localObject1).dnc.dnd = ((int)Math.round(paramAnonymousa.paV * 100.0D));
            ((cg)localObject1).dnc.dne = paramAnonymousa.dne;
            ((cg)localObject1).dnc.dng = paramAnonymousa.type;
            ((cg)localObject1).dnc.dnf = paramAnonymousa.paY;
            ((cg)localObject1).dnc.gW = (cf.aCL() - l * 1000L);
            ((cg)localObject1).dnc.dnh = 1;
            ((cg)localObject1).dnc.dni = str1;
            ((cg)localObject1).dnc.dnj = str2;
            if (i != 0) {
              break label601;
            }
          }
          label601:
          for (((cg)localObject1).dnc.dnk = false;; ((cg)localObject1).dnc.dnk = true)
          {
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
            AppMethodBeat.o(63757);
            return;
          }
        }
        ad.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
        AppMethodBeat.o(63757);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.oZI = new com.tencent.mm.plugin.collect.model.g();
    this.oZJ = new v();
    this.oZK = false;
    this.oZL = new c() {};
    AppMethodBeat.o(63760);
  }
  
  private void ZN(String paramString)
  {
    AppMethodBeat.i(63768);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(304, new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(63758);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.b(304, this);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          ad.i("MicroMsg.SubCoreCollect", "set sound fail!");
        }
        AppMethodBeat.o(63758);
      }
    });
    paramString = new p(bt.bI(paramString, ""));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    AppMethodBeat.o(63768);
  }
  
  public static a cag()
  {
    AppMethodBeat.i(63761);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(63761);
    return locala;
  }
  
  public static com.tencent.mm.plugin.collect.model.d cah()
  {
    AppMethodBeat.i(63764);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.collect.model.d locald = com.tencent.mm.plugin.collect.model.d.oZR;
    AppMethodBeat.o(63764);
    return locald;
  }
  
  public static boolean cai()
  {
    AppMethodBeat.i(63765);
    Object localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IxH, "");
    long l = com.tencent.mm.model.u.aAr();
    if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equals("in.caf")))
    {
      ad.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
      com.tencent.mm.kernel.g.ajC().ajl().set(147457, Long.valueOf(l | 0x8000));
      localObject = new caf();
      ((caf)localObject).yho = 1;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azo().c(new k.a(209, (com.tencent.mm.bx.a)localObject));
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
  
  public final void caj()
  {
    AppMethodBeat.i(63766);
    ZN("cash.caf");
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IxH, "cash.caf");
    AppMethodBeat.o(63766);
  }
  
  public final void cak()
  {
    AppMethodBeat.i(63767);
    ZN("in.caf");
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IxH, "in.caf");
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
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("paymsg", this.oZH, true);
    this.oZL.alive();
    com.tencent.mm.plugin.collect.model.g localg = this.oZI;
    localg.alive();
    localg.oZX = new ConcurrentLinkedQueue();
    com.tencent.mm.plugin.collect.model.voice.a locala = com.tencent.mm.plugin.collect.model.voice.a.cax();
    locala.pbl = localg;
    locala.pbm = new a.b(locala, locala.pbl);
    com.tencent.mm.kernel.g.ajC().ajl().a(locala);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1384, localg);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(1317, localg);
    this.oZJ.alive();
    AppMethodBeat.o(63762);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63763);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("paymsg", this.oZH, true);
    Object localObject = this.oZI;
    ((com.tencent.mm.plugin.collect.model.g)localObject).dead();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1384, (f)localObject);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(1317, (f)localObject);
    com.tencent.mm.plugin.collect.model.g.cam();
    localObject = com.tencent.mm.plugin.collect.model.voice.a.cax();
    ad.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
    try
    {
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).pbk != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).pbk.pbE.destroy();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).pbq != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).pbq.dead();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).pbr != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).pbr.dead();
      }
      com.tencent.mm.kernel.g.ajC().ajl().b((n.b)localObject);
      com.tencent.mm.plugin.collect.model.voice.a.pbf = false;
      this.oZJ.dead();
      this.oZL.dead();
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