package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.l;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.g;
import com.tencent.mm.plugin.collect.model.q;
import com.tencent.mm.plugin.collect.model.voice.a.b;
import com.tencent.mm.plugin.collect.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements be
{
  private ck.a tUv;
  private g tUw;
  private w tUx;
  public boolean tUy;
  private IListener<l> tUz;
  
  public a()
  {
    AppMethodBeat.i(63760);
    this.tUv = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(63757);
        a.cNP();
        if (a.cNQ() != null)
        {
          String str1 = com.tencent.mm.platformtools.z.a(paramAnonymousa.jQG.RIF);
          a.cNP();
          Object localObject1 = a.cNQ();
          long l = paramAnonymousa.jQG.CreateTime;
          Log.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(str1)));
          if (Util.isNullOrNil(str1))
          {
            Log.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
            AppMethodBeat.o(63757);
            return;
          }
          Object localObject2 = XmlParser.parseXml(str1, "sysmsg", null);
          int i = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.PayMsgType"), 0);
          if ((i != 9) && (i != 26))
          {
            Log.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=".concat(String.valueOf(i)));
            AppMethodBeat.o(63757);
            return;
          }
          paramAnonymousa = new com.tencent.mm.plugin.collect.model.v();
          paramAnonymousa.username = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.username"));
          paramAnonymousa.tVK = (Util.getDouble((String)((Map)localObject2).get(".sysmsg.paymsg.fee"), 0.0D) / 100.0D);
          paramAnonymousa.fyc = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.feetype"));
          paramAnonymousa.dXr = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsgtimestamp"), (int)Util.nowSecond());
          paramAnonymousa.fww = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.transid"));
          paramAnonymousa.jmB = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.displayname"));
          paramAnonymousa.scene = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.scene"), 1);
          paramAnonymousa.status = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.status"), 0);
          paramAnonymousa.msgType = i;
          paramAnonymousa.tVM = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.outtradeno"));
          paramAnonymousa.type = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.type"));
          str1 = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.voice_content"));
          String str2 = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.expire_voice_timestamp"));
          i = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.need_failover"), 1);
          localObject1 = ((com.tencent.mm.plugin.collect.model.d)localObject1).cSF.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (d.a)((Iterator)localObject1).next();
            if (localObject2 != null) {
              ((d.a)localObject2).a(paramAnonymousa);
            }
          }
          if (paramAnonymousa.status == 1)
          {
            localObject1 = new com.tencent.mm.f.a.cm();
            ((com.tencent.mm.f.a.cm)localObject1).fyb.fee = ((int)Math.round(paramAnonymousa.tVK * 100.0D));
            ((com.tencent.mm.f.a.cm)localObject1).fyb.fyc = paramAnonymousa.fyc;
            ((com.tencent.mm.f.a.cm)localObject1).fyb.fye = paramAnonymousa.type;
            ((com.tencent.mm.f.a.cm)localObject1).fyb.fyd = paramAnonymousa.tVM;
            ((com.tencent.mm.f.a.cm)localObject1).fyb.delay = (com.tencent.mm.model.cm.bfD() - l * 1000L);
            ((com.tencent.mm.f.a.cm)localObject1).fyb.source = 1;
            ((com.tencent.mm.f.a.cm)localObject1).fyb.fyf = str1;
            ((com.tencent.mm.f.a.cm)localObject1).fyb.fyg = str2;
            if (i != 0) {
              break label602;
            }
          }
          label602:
          for (((com.tencent.mm.f.a.cm)localObject1).fyb.fyh = false;; ((com.tencent.mm.f.a.cm)localObject1).fyb.fyh = true)
          {
            EventCenter.instance.publish((IEvent)localObject1);
            AppMethodBeat.o(63757);
            return;
          }
        }
        Log.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
        AppMethodBeat.o(63757);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.tUw = new g();
    this.tUx = new w();
    this.tUy = false;
    this.tUz = new a.3(this);
    AppMethodBeat.o(63760);
  }
  
  private void asz(String paramString)
  {
    AppMethodBeat.i(63768);
    h.aHH();
    h.aHF().kcd.a(304, new a.2(this));
    paramString = new q(Util.nullAs(paramString, ""));
    h.aHH();
    h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(63768);
  }
  
  public static a cNP()
  {
    AppMethodBeat.i(63761);
    a locala = (a)y.as(a.class);
    AppMethodBeat.o(63761);
    return locala;
  }
  
  public static com.tencent.mm.plugin.collect.model.d cNQ()
  {
    AppMethodBeat.i(63764);
    h.aHE().aGH();
    com.tencent.mm.plugin.collect.model.d locald = com.tencent.mm.plugin.collect.model.d.tUF;
    AppMethodBeat.o(63764);
    return locald;
  }
  
  public static boolean cNR()
  {
    AppMethodBeat.i(63765);
    Object localObject = (String)h.aHG().aHp().get(ar.a.Voj, "");
    long l = com.tencent.mm.model.z.bde();
    if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals("in.caf")))
    {
      Log.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
      h.aHG().aHp().i(147457, Long.valueOf(l | 0x8000));
      localObject = new cys();
      ((cys)localObject).Iza = 1;
      ((n)h.ae(n.class)).bbK().d(new k.a(209, (com.tencent.mm.cd.a)localObject));
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
  
  public final void cNS()
  {
    AppMethodBeat.i(63766);
    asz("cash.caf");
    h.aHG().aHp().set(ar.a.Voj, "cash.caf");
    AppMethodBeat.o(63766);
  }
  
  public final void cNT()
  {
    AppMethodBeat.i(63767);
    asz("in.caf");
    h.aHG().aHp().set(ar.a.Voj, "in.caf");
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
    ((com.tencent.mm.plugin.messenger.foundation.a.v)h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("paymsg", this.tUv, true);
    this.tUz.alive();
    g localg = this.tUw;
    localg.alive();
    localg.tUL = new ConcurrentLinkedQueue();
    com.tencent.mm.plugin.collect.model.voice.a locala = com.tencent.mm.plugin.collect.model.voice.a.cOg();
    locala.tVZ = localg;
    locala.tWa = new a.b(locala, locala.tVZ);
    h.aHG().aHp().add(locala);
    h.aHH();
    h.aHF().kcd.a(1384, localg);
    h.aHH();
    h.aHF().kcd.a(1317, localg);
    this.tUx.alive();
    AppMethodBeat.o(63762);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63763);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("paymsg", this.tUv, true);
    Object localObject = this.tUw;
    ((g)localObject).dead();
    h.aHH();
    h.aHF().kcd.b(1384, (i)localObject);
    h.aHH();
    h.aHF().kcd.b(1317, (i)localObject);
    g.cNV();
    localObject = com.tencent.mm.plugin.collect.model.voice.a.cOg();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
    try
    {
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).tVY != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).tVY.tWv.destroy();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).tWe != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).tWe.dead();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).tWf != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).tWf.dead();
      }
      h.aHG().aHp().remove((MStorageEx.IOnStorageChange)localObject);
      com.tencent.mm.plugin.collect.model.voice.a.tVT = false;
      this.tUx.dead();
      this.tUz.dead();
      AppMethodBeat.o(63763);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy() synthesizer.destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a
 * JD-Core Version:    0.7.0.1
 */