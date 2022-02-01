package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.p;
import com.tencent.mm.plugin.collect.model.u;
import com.tencent.mm.plugin.collect.model.v;
import com.tencent.mm.plugin.collect.model.voice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.protocal.protobuf.de;
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
  implements bd
{
  private IListener<com.tencent.mm.g.a.l> qvA;
  private cj.a qvw;
  private com.tencent.mm.plugin.collect.model.g qvx;
  private v qvy;
  public boolean qvz;
  
  public a()
  {
    AppMethodBeat.i(63760);
    this.qvw = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(63757);
        a.czp();
        if (a.czq() != null)
        {
          String str1 = com.tencent.mm.platformtools.z.a(paramAnonymousa.heO.KHn);
          a.czp();
          Object localObject1 = a.czq();
          long l = paramAnonymousa.heO.CreateTime;
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
          paramAnonymousa = new u();
          paramAnonymousa.username = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.username"));
          paramAnonymousa.qwJ = (Util.getDouble((String)((Map)localObject2).get(".sysmsg.paymsg.fee"), 0.0D) / 100.0D);
          paramAnonymousa.dFv = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.feetype"));
          paramAnonymousa.qwL = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsgtimestamp"), (int)Util.nowSecond());
          paramAnonymousa.dDM = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.transid"));
          paramAnonymousa.gCv = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.displayname"));
          paramAnonymousa.scene = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.scene"), 1);
          paramAnonymousa.status = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.status"), 0);
          paramAnonymousa.msgType = i;
          paramAnonymousa.qwM = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.outtradeno"));
          paramAnonymousa.type = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.type"));
          str1 = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.voice_content"));
          String str2 = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.expire_voice_timestamp"));
          i = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.need_failover"), 1);
          localObject1 = ((com.tencent.mm.plugin.collect.model.d)localObject1).pQG.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (d.a)((Iterator)localObject1).next();
            if (localObject2 != null) {
              ((d.a)localObject2).a(paramAnonymousa);
            }
          }
          if (paramAnonymousa.status == 1)
          {
            localObject1 = new ci();
            ((ci)localObject1).dFt.dFu = ((int)Math.round(paramAnonymousa.qwJ * 100.0D));
            ((ci)localObject1).dFt.dFv = paramAnonymousa.dFv;
            ((ci)localObject1).dFt.dFx = paramAnonymousa.type;
            ((ci)localObject1).dFt.dFw = paramAnonymousa.qwM;
            ((ci)localObject1).dFt.gY = (cl.aWz() - l * 1000L);
            ((ci)localObject1).dFt.source = 1;
            ((ci)localObject1).dFt.dFy = str1;
            ((ci)localObject1).dFt.dFz = str2;
            if (i != 0) {
              break label602;
            }
          }
          label602:
          for (((ci)localObject1).dFt.dFA = false;; ((ci)localObject1).dFt.dFA = true)
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
    this.qvx = new com.tencent.mm.plugin.collect.model.g();
    this.qvy = new v();
    this.qvz = false;
    this.qvA = new a.3(this);
    AppMethodBeat.o(63760);
  }
  
  private void akK(String paramString)
  {
    AppMethodBeat.i(63768);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(304, new a.2(this));
    paramString = new p(Util.nullAs(paramString, ""));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(63768);
  }
  
  public static a czp()
  {
    AppMethodBeat.i(63761);
    a locala = (a)y.at(a.class);
    AppMethodBeat.o(63761);
    return locala;
  }
  
  public static com.tencent.mm.plugin.collect.model.d czq()
  {
    AppMethodBeat.i(63764);
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.plugin.collect.model.d locald = com.tencent.mm.plugin.collect.model.d.qvG;
    AppMethodBeat.o(63764);
    return locald;
  }
  
  public static boolean czr()
  {
    AppMethodBeat.i(63765);
    Object localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oah, "");
    long l = com.tencent.mm.model.z.aUd();
    if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals("in.caf")))
    {
      Log.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
      com.tencent.mm.kernel.g.aAh().azQ().set(147457, Long.valueOf(l | 0x8000));
      localObject = new cqb();
      ((cqb)localObject).Cyb = 1;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(209, (com.tencent.mm.bw.a)localObject));
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
  
  public void clearPluginData(int paramInt) {}
  
  public final void czs()
  {
    AppMethodBeat.i(63766);
    akK("cash.caf");
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oah, "cash.caf");
    AppMethodBeat.o(63766);
  }
  
  public final void czt()
  {
    AppMethodBeat.i(63767);
    akK("in.caf");
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oah, "in.caf");
    AppMethodBeat.o(63767);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(63762);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.qvw, true);
    this.qvA.alive();
    com.tencent.mm.plugin.collect.model.g localg = this.qvx;
    localg.alive();
    localg.qvM = new ConcurrentLinkedQueue();
    com.tencent.mm.plugin.collect.model.voice.a locala = com.tencent.mm.plugin.collect.model.voice.a.czG();
    locala.qwZ = localg;
    locala.qxa = new a.b(locala, locala.qwZ);
    com.tencent.mm.kernel.g.aAh().azQ().add(locala);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1384, localg);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(1317, localg);
    this.qvy.alive();
    AppMethodBeat.o(63762);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63763);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.qvw, true);
    Object localObject = this.qvx;
    ((com.tencent.mm.plugin.collect.model.g)localObject).dead();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(1384, (i)localObject);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(1317, (i)localObject);
    com.tencent.mm.plugin.collect.model.g.czv();
    localObject = com.tencent.mm.plugin.collect.model.voice.a.czG();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
    try
    {
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).qwY != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).qwY.qxv.destroy();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).qxe != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).qxe.dead();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).qxf != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).qxf.dead();
      }
      com.tencent.mm.kernel.g.aAh().azQ().remove((MStorageEx.IOnStorageChange)localObject);
      com.tencent.mm.plugin.collect.model.voice.a.qwT = false;
      this.qvy.dead();
      this.qvA.dead();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a
 * JD-Core Version:    0.7.0.1
 */