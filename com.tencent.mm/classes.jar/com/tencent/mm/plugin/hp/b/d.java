package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ag;
import com.tencent.mm.app.ag.a;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.g.a.df;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.s;
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
  implements bd
{
  private final IListener<bk> rdQ;
  private final IListener<df> ymA;
  private final f ymB;
  private final IListener<bt> ymC;
  private boolean ymy;
  private final h ymz;
  
  public d()
  {
    AppMethodBeat.i(117418);
    this.ymy = true;
    this.ymz = new h();
    this.rdQ = new IListener() {};
    this.ymA = new IListener() {};
    this.ymB = new f();
    this.ymC = new IListener() {};
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
    this.ymy = paramBoolean;
    b.a(new g(), new String[] { "//tinker" });
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("prconfignotify", this.ymz, true);
    EventCenter.instance.addListener(this.rdQ);
    this.ymA.alive();
    EventCenter.instance.addListener(this.ymB);
    EventCenter.instance.addListener(this.ymC);
    Log.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
    com.tencent.mm.plugin.hp.tinker.h.gn(MMApplicationContext.getContext());
    for (;;)
    {
      try
      {
        l2 = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Odn, Long.valueOf(0L))).longValue();
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
        l1 = l1 - com.tencent.mm.plugin.hp.tinker.h.go(MMApplicationContext.getContext()) * 3600000L + i * 60000L;
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Odn, Long.valueOf(l1));
        Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update after %d minute currentTime %s lastUpdate %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        Log.printErrStackTrace("Tinker.SubCoreHotpatch", localException, "", new Object[0]);
        continue;
        a.hvX().Ey(paramBoolean);
        Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
        continue;
      }
      f.GQ(l1);
      if (!MMApplicationContext.isToolsIsolatedProcess()) {
        ag.a.dmC.WR();
      }
      AppMethodBeat.o(117419);
      return;
      a.hvX().Ey(true);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Odn, Long.valueOf(l1));
      Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(l2) });
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(117420);
    b.V(new String[] { "//tinker" });
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("prconfignotify", this.ymz, true);
    EventCenter.instance.removeListener(this.rdQ);
    this.ymA.dead();
    EventCenter.instance.removeListener(this.ymB);
    EventCenter.instance.removeListener(this.ymC);
    Log.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    AppMethodBeat.o(117420);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.d
 * JD-Core Version:    0.7.0.1
 */