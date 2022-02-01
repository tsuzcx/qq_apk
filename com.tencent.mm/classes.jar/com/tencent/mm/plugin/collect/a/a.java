package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.p;
import com.tencent.mm.plugin.collect.model.voice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements az
{
  private cf.a pgl;
  private com.tencent.mm.plugin.collect.model.g pgm;
  private com.tencent.mm.plugin.collect.model.v pgn;
  public boolean pgo;
  private c<k> pgp;
  
  public a()
  {
    AppMethodBeat.i(63760);
    this.pgl = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(63757);
        a.cbv();
        if (a.cbw() != null)
        {
          String str1 = z.a(paramAnonymousa.gte.FNI);
          a.cbv();
          Object localObject1 = a.cbw();
          long l = paramAnonymousa.gte.CreateTime;
          ae.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(str1)));
          if (bu.isNullOrNil(str1))
          {
            ae.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(63757);
            return;
          }
          Object localObject2 = bx.M(str1, "sysmsg");
          int i = bu.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.PayMsgType"), 0);
          if ((i != 9) && (i != 26))
          {
            ae.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=".concat(String.valueOf(i)));
            AppMethodBeat.o(63757);
            return;
          }
          paramAnonymousa = new com.tencent.mm.plugin.collect.model.u();
          paramAnonymousa.username = bu.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.username"));
          paramAnonymousa.phz = (bu.getDouble((String)((Map)localObject2).get(".sysmsg.paymsg.fee"), 0.0D) / 100.0D);
          paramAnonymousa.dog = bu.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.feetype"));
          paramAnonymousa.phB = bu.getInt((String)((Map)localObject2).get(".sysmsg.paymsgtimestamp"), (int)bu.aRi());
          paramAnonymousa.dmx = bu.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.transid"));
          paramAnonymousa.fXp = bu.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.displayname"));
          paramAnonymousa.scene = bu.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.scene"), 1);
          paramAnonymousa.status = bu.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.status"), 0);
          paramAnonymousa.msgType = i;
          paramAnonymousa.phC = bu.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.outtradeno"));
          paramAnonymousa.type = bu.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.type"));
          str1 = bu.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.voice_content"));
          String str2 = bu.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.expire_voice_timestamp"));
          i = bu.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.need_failover"), 1);
          localObject1 = ((com.tencent.mm.plugin.collect.model.d)localObject1).oCX.iterator();
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
            ((cg)localObject1).doe.dof = ((int)Math.round(paramAnonymousa.phz * 100.0D));
            ((cg)localObject1).doe.dog = paramAnonymousa.dog;
            ((cg)localObject1).doe.doi = paramAnonymousa.type;
            ((cg)localObject1).doe.doh = paramAnonymousa.phC;
            ((cg)localObject1).doe.gW = (ch.aDb() - l * 1000L);
            ((cg)localObject1).doe.doj = 1;
            ((cg)localObject1).doe.dok = str1;
            ((cg)localObject1).doe.dol = str2;
            if (i != 0) {
              break label601;
            }
          }
          label601:
          for (((cg)localObject1).doe.dom = false;; ((cg)localObject1).doe.dom = true)
          {
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
            AppMethodBeat.o(63757);
            return;
          }
        }
        ae.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
        AppMethodBeat.o(63757);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.pgm = new com.tencent.mm.plugin.collect.model.g();
    this.pgn = new com.tencent.mm.plugin.collect.model.v();
    this.pgo = false;
    this.pgp = new a.3(this);
    AppMethodBeat.o(63760);
  }
  
  private void aaE(String paramString)
  {
    AppMethodBeat.i(63768);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(304, new a.2(this));
    paramString = new p(bu.bI(paramString, ""));
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
    AppMethodBeat.o(63768);
  }
  
  public static a cbv()
  {
    AppMethodBeat.i(63761);
    a locala = (a)com.tencent.mm.model.u.ap(a.class);
    AppMethodBeat.o(63761);
    return locala;
  }
  
  public static com.tencent.mm.plugin.collect.model.d cbw()
  {
    AppMethodBeat.i(63764);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.collect.model.d locald = com.tencent.mm.plugin.collect.model.d.pgv;
    AppMethodBeat.o(63764);
    return locald;
  }
  
  public static boolean cbx()
  {
    AppMethodBeat.i(63765);
    Object localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISf, "");
    long l = com.tencent.mm.model.v.aAH();
    if ((!bu.isNullOrNil((String)localObject)) && (!((String)localObject).equals("in.caf")))
    {
      ae.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
      com.tencent.mm.kernel.g.ajR().ajA().set(147457, Long.valueOf(l | 0x8000));
      localObject = new caz();
      ((caz)localObject).yxf = 1;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new k.a(209, (com.tencent.mm.bw.a)localObject));
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
  
  public final void cby()
  {
    AppMethodBeat.i(63766);
    aaE("cash.caf");
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISf, "cash.caf");
    AppMethodBeat.o(63766);
  }
  
  public final void cbz()
  {
    AppMethodBeat.i(63767);
    aaE("in.caf");
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISf, "in.caf");
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
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("paymsg", this.pgl, true);
    this.pgp.alive();
    com.tencent.mm.plugin.collect.model.g localg = this.pgm;
    localg.alive();
    localg.pgB = new ConcurrentLinkedQueue();
    com.tencent.mm.plugin.collect.model.voice.a locala = com.tencent.mm.plugin.collect.model.voice.a.cbM();
    locala.phP = localg;
    locala.phQ = new a.b(locala, locala.phP);
    com.tencent.mm.kernel.g.ajR().ajA().a(locala);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1384, localg);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1317, localg);
    this.pgn.alive();
    AppMethodBeat.o(63762);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63763);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("paymsg", this.pgl, true);
    Object localObject = this.pgm;
    ((com.tencent.mm.plugin.collect.model.g)localObject).dead();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(1384, (f)localObject);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(1317, (f)localObject);
    com.tencent.mm.plugin.collect.model.g.cbB();
    localObject = com.tencent.mm.plugin.collect.model.voice.a.cbM();
    ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
    try
    {
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).phO != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).phO.pij.destroy();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).phU != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).phU.dead();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).phV != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).phV.dead();
      }
      com.tencent.mm.kernel.g.ajR().ajA().b((n.b)localObject);
      com.tencent.mm.plugin.collect.model.voice.a.phJ = false;
      this.pgn.dead();
      this.pgp.dead();
      AppMethodBeat.o(63763);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy() synthesizer.destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a
 * JD-Core Version:    0.7.0.1
 */