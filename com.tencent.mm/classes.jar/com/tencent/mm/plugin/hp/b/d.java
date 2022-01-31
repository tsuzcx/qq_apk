package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.y;
import com.tencent.mm.app.y.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class d
  implements at
{
  private final c<ba> ljA;
  private boolean nKf;
  private final h nKg;
  private final c<cr> nKh;
  private final f nKi;
  private final c<bj> nKj;
  
  public d()
  {
    AppMethodBeat.i(90590);
    this.nKf = true;
    this.nKg = new h();
    this.ljA = new d.1(this);
    this.nKh = new d.2(this);
    this.nKi = new f();
    this.nKj = new c() {};
    AppMethodBeat.o(90590);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(90591);
    b.a(new g(), new String[] { "//tinker" });
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a("prconfignotify", this.nKg, true);
    com.tencent.mm.sdk.b.a.ymk.c(this.ljA);
    this.nKh.alive();
    com.tencent.mm.sdk.b.a.ymk.c(this.nKi);
    com.tencent.mm.sdk.b.a.ymk.c(this.nKj);
    ab.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
    com.tencent.mm.plugin.hp.tinker.h.ep(ah.getContext());
    for (;;)
    {
      try
      {
        l2 = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHs, Long.valueOf(0L))).longValue();
        l1 = System.currentTimeMillis();
        if (l1 - l2 < 3600000L) {
          continue;
        }
        int i = Calendar.getInstance().get(11);
        ab.i("Tinker.SubCoreHotpatch", "try to fetch patch update hour %d ", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          continue;
        }
        i = new Random().nextInt(60);
        l1 = l1 - com.tencent.mm.plugin.hp.tinker.h.eq(ah.getContext()) * 3600000L + i * 60000L;
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHs, Long.valueOf(l1));
        ab.i("Tinker.SubCoreHotpatch", "try to fetch patch update after %d minute currentTime %s lastUpdate %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        ab.printErrStackTrace("Tinker.SubCoreHotpatch", localException, "", new Object[0]);
        continue;
        com.tinkerboots.sdk.a.eaJ().sm(false);
        ab.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
        continue;
      }
      f.kp(l1);
      if (!ah.dsV()) {
        y.a.bZh.BF();
      }
      AppMethodBeat.o(90591);
      return;
      com.tinkerboots.sdk.a.eaJ().sm(true);
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHs, Long.valueOf(l1));
      ab.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(l2) });
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(90592);
    b.N(new String[] { "//tinker" });
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("prconfignotify", this.nKg, true);
    com.tencent.mm.sdk.b.a.ymk.d(this.ljA);
    this.nKh.dead();
    com.tencent.mm.sdk.b.a.ymk.d(this.nKi);
    com.tencent.mm.sdk.b.a.ymk.d(this.nKj);
    ab.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    AppMethodBeat.o(90592);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.d
 * JD-Core Version:    0.7.0.1
 */