package com.tencent.mm.plugin.collect.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.cv;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.collect.model.F2fRcvVoiceListener;
import com.tencent.mm.plugin.collect.model.ScanMaterialCodeListener;
import com.tencent.mm.plugin.collect.model.d.a;
import com.tencent.mm.plugin.collect.model.o;
import com.tencent.mm.plugin.collect.model.t;
import com.tencent.mm.plugin.collect.model.voice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements be
{
  private cl.a wXR;
  private F2fRcvVoiceListener wXS;
  private ScanMaterialCodeListener wXT;
  public boolean wXU;
  private IListener<com.tencent.mm.autogen.a.n> wXV;
  
  public a()
  {
    AppMethodBeat.i(63760);
    this.wXR = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(63757);
        a.dru();
        if (a.drv() != null)
        {
          String str1 = w.a(paramAnonymousa.mpN.YFG);
          a.dru();
          Object localObject1 = a.drv();
          long l = paramAnonymousa.mpN.CreateTime;
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
          paramAnonymousa = new t();
          paramAnonymousa.username = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.username"));
          paramAnonymousa.wZe = (Util.getDouble((String)((Map)localObject2).get(".sysmsg.paymsg.fee"), 0.0D) / 100.0D);
          paramAnonymousa.hCH = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.feetype"));
          paramAnonymousa.fZW = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsgtimestamp"), (int)Util.nowSecond());
          paramAnonymousa.hAU = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.transid"));
          paramAnonymousa.displayName = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.displayname"));
          paramAnonymousa.scene = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.scene"), 1);
          paramAnonymousa.status = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.status"), 0);
          paramAnonymousa.msgType = i;
          paramAnonymousa.wZg = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.outtradeno"));
          paramAnonymousa.type = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.type"));
          str1 = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.voice_content"));
          String str2 = Util.nullAsNil((String)((Map)localObject2).get(".sysmsg.paymsg.expire_voice_timestamp"));
          i = Util.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.need_failover"), 1);
          localObject1 = ((com.tencent.mm.plugin.collect.model.d)localObject1).eNV.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (d.a)((Iterator)localObject1).next();
            if (localObject2 != null) {
              ((d.a)localObject2).a(paramAnonymousa);
            }
          }
          if (paramAnonymousa.status == 1)
          {
            localObject1 = new cv();
            ((cv)localObject1).hCG.fee = ((int)Math.round(paramAnonymousa.wZe * 100.0D));
            ((cv)localObject1).hCG.hCH = paramAnonymousa.hCH;
            ((cv)localObject1).hCG.hCJ = paramAnonymousa.type;
            ((cv)localObject1).hCG.hCI = paramAnonymousa.wZg;
            ((cv)localObject1).hCG.delay = (cn.bDv() - l * 1000L);
            ((cv)localObject1).hCG.source = 1;
            ((cv)localObject1).hCG.hCK = str1;
            ((cv)localObject1).hCG.hCL = str2;
            if (i != 0) {
              break label599;
            }
          }
          label599:
          for (((cv)localObject1).hCG.hCM = false;; ((cv)localObject1).hCG.hCM = true)
          {
            ((cv)localObject1).publish();
            AppMethodBeat.o(63757);
            return;
          }
        }
        Log.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
        AppMethodBeat.o(63757);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.wXS = new F2fRcvVoiceListener();
    this.wXT = new ScanMaterialCodeListener();
    this.wXU = false;
    this.wXV = new SubCoreCollect.3(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(63760);
  }
  
  private void ame(String paramString)
  {
    AppMethodBeat.i(63768);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(304, new a.2(this));
    paramString = new o(Util.nullAs(paramString, ""));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(63768);
  }
  
  public static a dru()
  {
    AppMethodBeat.i(63761);
    a locala = (a)y.aL(a.class);
    AppMethodBeat.o(63761);
    return locala;
  }
  
  public static com.tencent.mm.plugin.collect.model.d drv()
  {
    AppMethodBeat.i(63764);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.collect.model.d locald = com.tencent.mm.plugin.collect.model.d.wYb;
    AppMethodBeat.o(63764);
    return locald;
  }
  
  public static boolean drw()
  {
    AppMethodBeat.i(63765);
    Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPF, "");
    long l = z.bAR();
    if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals("in.caf")))
    {
      Log.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
      com.tencent.mm.kernel.h.baE().ban().B(147457, Long.valueOf(l | 0x8000));
      localObject = new dpy();
      ((dpy)localObject).OzH = 1;
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d(new k.a(209, (com.tencent.mm.bx.a)localObject));
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
  
  public final void drx()
  {
    AppMethodBeat.i(63766);
    ame("cash.caf");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acPF, "cash.caf");
    AppMethodBeat.o(63766);
  }
  
  public final void dry()
  {
    AppMethodBeat.i(63767);
    ame("in.caf");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acPF, "in.caf");
    AppMethodBeat.o(63767);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(63762);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("paymsg", this.wXR, true);
    this.wXV.alive();
    F2fRcvVoiceListener localF2fRcvVoiceListener = this.wXS;
    localF2fRcvVoiceListener.alive();
    localF2fRcvVoiceListener.wYh = new ConcurrentLinkedQueue();
    com.tencent.mm.plugin.collect.model.voice.a locala = com.tencent.mm.plugin.collect.model.voice.a.drL();
    locala.wZt = localF2fRcvVoiceListener;
    locala.wZu = new a.b(locala, locala.wZt);
    com.tencent.mm.kernel.h.baE().ban().add(locala);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1384, localF2fRcvVoiceListener);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1317, localF2fRcvVoiceListener);
    this.wXT.alive();
    AppMethodBeat.o(63762);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63763);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("paymsg", this.wXR, true);
    Object localObject = this.wXS;
    ((F2fRcvVoiceListener)localObject).dead();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1384, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1317, (com.tencent.mm.am.h)localObject);
    F2fRcvVoiceListener.drA();
    localObject = com.tencent.mm.plugin.collect.model.voice.a.drL();
    Log.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
    try
    {
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).wZs != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).wZs.wZP.destroy();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).wZy != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).wZy.dead();
      }
      if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).wZz != null) {
        ((com.tencent.mm.plugin.collect.model.voice.a)localObject).wZz.dead();
      }
      com.tencent.mm.kernel.h.baE().ban().remove((MStorageEx.IOnStorageChange)localObject);
      com.tencent.mm.plugin.collect.model.voice.a.wZn = false;
      this.wXT.dead();
      this.wXV.dead();
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
 * Qualified Name:     com.tencent.mm.plugin.collect.app.a
 * JD-Core Version:    0.7.0.1
 */