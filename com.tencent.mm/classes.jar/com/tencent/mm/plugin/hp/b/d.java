package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ag;
import com.tencent.mm.app.ag.a;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class d
  implements aw
{
  private final c<bf> pdi;
  private boolean tFB;
  private final h tFC;
  private final c<cy> tFD;
  private final f tFE;
  private final c<bo> tFF;
  
  public d()
  {
    AppMethodBeat.i(117418);
    this.tFB = true;
    this.tFC = new h();
    this.pdi = new c() {};
    this.tFD = new c() {};
    this.tFE = new f();
    this.tFF = new c() {};
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
    this.tFB = paramBoolean;
    b.a(new g(), new String[] { "//tinker" });
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("prconfignotify", this.tFC, true);
    com.tencent.mm.sdk.b.a.GpY.c(this.pdi);
    this.tFD.alive();
    com.tencent.mm.sdk.b.a.GpY.c(this.tFE);
    com.tencent.mm.sdk.b.a.GpY.c(this.tFF);
    ac.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
    com.tencent.mm.plugin.hp.tinker.h.fx(ai.getContext());
    for (;;)
    {
      try
      {
        l2 = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOb, Long.valueOf(0L))).longValue();
        l1 = System.currentTimeMillis();
        if (l1 - l2 < 3600000L) {
          continue;
        }
        int i = Calendar.getInstance().get(11);
        ac.i("Tinker.SubCoreHotpatch", "try to fetch patch update hour %d ", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          continue;
        }
        i = new Random().nextInt(60);
        l1 = l1 - com.tencent.mm.plugin.hp.tinker.h.fy(ai.getContext()) * 3600000L + i * 60000L;
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOb, Long.valueOf(l1));
        ac.i("Tinker.SubCoreHotpatch", "try to fetch patch update after %d minute currentTime %s lastUpdate %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        ac.printErrStackTrace("Tinker.SubCoreHotpatch", localException, "", new Object[0]);
        continue;
        com.tinkerboots.sdk.a.fMx().zh(false);
        ac.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
        continue;
      }
      f.vC(l1);
      if (!ai.eVc()) {
        ag.a.cJV.La();
      }
      AppMethodBeat.o(117419);
      return;
      com.tinkerboots.sdk.a.fMx().zh(true);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOb, Long.valueOf(l1));
      ac.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(l2) });
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(117420);
    b.Q(new String[] { "//tinker" });
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("prconfignotify", this.tFC, true);
    com.tencent.mm.sdk.b.a.GpY.d(this.pdi);
    this.tFD.dead();
    com.tencent.mm.sdk.b.a.GpY.d(this.tFE);
    com.tencent.mm.sdk.b.a.GpY.d(this.tFF);
    ac.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    AppMethodBeat.o(117420);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.d
 * JD-Core Version:    0.7.0.1
 */