package com.tencent.mm.plugin.hp.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.am;
import com.tencent.mm.app.am.a;
import com.tencent.mm.autogen.a.by;
import com.tencent.mm.autogen.a.ch;
import com.tencent.mm.autogen.a.du;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import com.tinkerboots.sdk.a;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class d
  implements be
{
  private boolean JDO;
  private final g JDP;
  private final IListener<du> JDQ;
  private final TinkerBootsActivateListener JDR;
  private final IListener<ch> JDS;
  private final IListener<by> xPB;
  
  public d()
  {
    AppMethodBeat.i(117418);
    this.JDO = true;
    this.JDP = new g();
    this.xPB = new SubCoreHotpatch.1(this, com.tencent.mm.app.f.hfK);
    this.JDQ = new SubCoreHotpatch.2(this, com.tencent.mm.app.f.hfK);
    this.JDR = new TinkerBootsActivateListener();
    this.JDS = new SubCoreHotpatch.3(this, com.tencent.mm.app.f.hfK);
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
    this.JDO = paramBoolean;
    b.a(new f(), new String[] { "//tinker" });
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("prconfignotify", this.JDP, true);
    this.xPB.alive();
    this.JDQ.alive();
    this.JDR.alive();
    this.JDS.alive();
    Log.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
    com.tencent.mm.plugin.hp.tinker.h.iF(MMApplicationContext.getContext());
    for (;;)
    {
      try
      {
        l2 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTb, Long.valueOf(0L))).longValue();
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
        l1 = l1 - com.tencent.mm.plugin.hp.tinker.h.iG(MMApplicationContext.getContext()) * 3600000L + i * 60000L;
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acTb, Long.valueOf(l1));
        Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update after %d minute currentTime %s lastUpdate %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        Log.printErrStackTrace("Tinker.SubCoreHotpatch", localException, "", new Object[0]);
        continue;
        a.kkr().Pi(paramBoolean);
        Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
        continue;
      }
      TinkerBootsActivateListener.sa(l1);
      if (!MMApplicationContext.isToolsIsolatedProcess()) {
        am.a.hiV.aDl();
      }
      AppMethodBeat.o(117419);
      return;
      a.kkr().Pi(true);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTb, Long.valueOf(l1));
      Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(l2) });
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(117420);
    b.X(new String[] { "//tinker" });
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("prconfignotify", this.JDP, true);
    this.xPB.dead();
    this.JDQ.dead();
    this.JDR.dead();
    this.JDS.dead();
    Log.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    AppMethodBeat.o(117420);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.model.d
 * JD-Core Version:    0.7.0.1
 */