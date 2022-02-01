package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ai;
import com.tencent.mm.app.ai.a;
import com.tencent.mm.f.a.bp;
import com.tencent.mm.f.a.by;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import com.tinkerboots.sdk.a;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class d
  implements be
{
  private boolean DMA;
  private final h DMB;
  private final IListener<dk> DMC;
  private final f DMD;
  private final IListener<by> DME;
  private final IListener<bp> uGV;
  
  public d()
  {
    AppMethodBeat.i(117418);
    this.DMA = true;
    this.DMB = new h();
    this.uGV = new IListener() {};
    this.DMC = new IListener() {};
    this.DMD = new f();
    this.DME = new IListener() {};
    AppMethodBeat.o(117418);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(117419);
    this.DMA = paramBoolean;
    b.a(new g(), new String[] { "//tinker" });
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("prconfignotify", this.DMB, true);
    EventCenter.instance.addListener(this.uGV);
    this.DMC.alive();
    EventCenter.instance.addListener(this.DMD);
    EventCenter.instance.addListener(this.DME);
    Log.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
    com.tencent.mm.plugin.hp.tinker.h.hk(MMApplicationContext.getContext());
    for (;;)
    {
      try
      {
        l2 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vrx, Long.valueOf(0L))).longValue();
        l1 = System.currentTimeMillis();
        if (l1 - l2 < 3600000L) {
          continue;
        }
        int i = Calendar.getInstance().get(11);
        Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update hour %d ", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          continue;
        }
        i = new Random().nextInt(60);
        l1 = l1 - com.tencent.mm.plugin.hp.tinker.h.hl(MMApplicationContext.getContext()) * 3600000L + i * 60000L;
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrx, Long.valueOf(l1));
        Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update after %d minute currentTime %s lastUpdate %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        Log.printErrStackTrace("Tinker.SubCoreHotpatch", localException, "", new Object[0]);
        continue;
        a.izW().Jb(paramBoolean);
        Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
        continue;
      }
      f.Of(l1);
      if (!MMApplicationContext.isToolsIsolatedProcess()) {
        ai.a.feP.abt();
      }
      AppMethodBeat.o(117419);
      return;
      a.izW().Jb(true);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrx, Long.valueOf(l1));
      Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(l2) });
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(117420);
    b.W(new String[] { "//tinker" });
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("prconfignotify", this.DMB, true);
    EventCenter.instance.removeListener(this.uGV);
    this.DMC.dead();
    EventCenter.instance.removeListener(this.DMD);
    EventCenter.instance.removeListener(this.DME);
    Log.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    AppMethodBeat.o(117420);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.d
 * JD-Core Version:    0.7.0.1
 */