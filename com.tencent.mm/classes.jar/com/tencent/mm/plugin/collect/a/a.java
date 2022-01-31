package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.collect.model.o;
import com.tencent.mm.plugin.collect.model.u;
import com.tencent.mm.plugin.collect.model.voice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
  implements at
{
  private bz.a kMG;
  private com.tencent.mm.plugin.collect.model.g kMH;
  private u kMI;
  public boolean kMJ;
  private c<k> kMK;
  
  public a()
  {
    AppMethodBeat.i(40910);
    this.kMG = new a.1(this);
    this.kMH = new com.tencent.mm.plugin.collect.model.g();
    this.kMI = new u();
    this.kMJ = false;
    this.kMK = new a.3(this);
    AppMethodBeat.o(40910);
  }
  
  private void Jo(String paramString)
  {
    AppMethodBeat.i(40918);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(304, new a.2(this));
    paramString = new o(bo.bf(paramString, ""));
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
    AppMethodBeat.o(40918);
  }
  
  public static a bhw()
  {
    AppMethodBeat.i(40911);
    a locala = (a)q.S(a.class);
    AppMethodBeat.o(40911);
    return locala;
  }
  
  public static com.tencent.mm.plugin.collect.model.d bhx()
  {
    AppMethodBeat.i(40914);
    com.tencent.mm.kernel.g.RJ().QQ();
    com.tencent.mm.plugin.collect.model.d locald = com.tencent.mm.plugin.collect.model.d.kMQ;
    AppMethodBeat.o(40914);
    return locald;
  }
  
  public static boolean bhy()
  {
    AppMethodBeat.i(40915);
    Object localObject = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yET, "");
    long l = r.Zs();
    if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).equals("in.caf")))
    {
      ab.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
      com.tencent.mm.kernel.g.RL().Ru().set(147457, Long.valueOf(l | 0x8000));
      localObject = new beg();
      ((beg)localObject).qsl = 1;
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new j.a(209, (com.tencent.mm.bv.a)localObject));
      AppMethodBeat.o(40915);
      return true;
    }
    if ((l & 0x8000) != 0L)
    {
      AppMethodBeat.o(40915);
      return true;
    }
    AppMethodBeat.o(40915);
    return false;
  }
  
  public final void bhA()
  {
    AppMethodBeat.i(40917);
    Jo("in.caf");
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yET, "in.caf");
    AppMethodBeat.o(40917);
  }
  
  public final void bhz()
  {
    AppMethodBeat.i(40916);
    Jo("cash.caf");
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yET, "cash.caf");
    AppMethodBeat.o(40916);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(40912);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.kMG, true);
    this.kMK.alive();
    com.tencent.mm.plugin.collect.model.g localg = this.kMH;
    localg.alive();
    localg.kMX = new ConcurrentLinkedQueue();
    com.tencent.mm.plugin.collect.model.voice.a locala = com.tencent.mm.plugin.collect.model.voice.a.bhJ();
    locala.kOh = localg;
    locala.kOi = new a.b(locala, locala.kOh);
    com.tencent.mm.kernel.g.RL().Ru().a(locala);
    com.tencent.mm.plugin.collect.model.voice.a.bhJ().bhK();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1384, localg);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1317, localg);
    this.kMI.alive();
    AppMethodBeat.o(40912);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(40913);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.kMG, true);
    Object localObject = this.kMH;
    ((com.tencent.mm.plugin.collect.model.g)localObject).dead();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(1384, (f)localObject);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(1317, (f)localObject);
    com.tencent.mm.plugin.collect.model.g.bhC();
    localObject = com.tencent.mm.plugin.collect.model.voice.a.bhJ();
    ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
    if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).kOg != null) {
      ((com.tencent.mm.plugin.collect.model.voice.a)localObject).kOg.kOA.destroy();
    }
    if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).kOm != null) {
      ((com.tencent.mm.plugin.collect.model.voice.a)localObject).kOm.dead();
    }
    if (((com.tencent.mm.plugin.collect.model.voice.a)localObject).kOn != null) {
      ((com.tencent.mm.plugin.collect.model.voice.a)localObject).kOn.dead();
    }
    com.tencent.mm.kernel.g.RL().Ru().b((n.b)localObject);
    com.tencent.mm.plugin.collect.model.voice.a.kOb = false;
    this.kMI.dead();
    this.kMK.dead();
    AppMethodBeat.o(40913);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a
 * JD-Core Version:    0.7.0.1
 */