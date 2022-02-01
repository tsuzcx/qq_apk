package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ag;
import com.tencent.mm.app.ag.a;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.br;
import com.tencent.mm.g.a.db;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class d
  implements ax
{
  private final c<bi> pGS;
  private boolean uIk;
  private final h uIl;
  private final c<db> uIm;
  private final f uIn;
  private final c<br> uIo;
  
  public d()
  {
    AppMethodBeat.i(117418);
    this.uIk = true;
    this.uIl = new h();
    this.pGS = new c() {};
    this.uIm = new c() {};
    this.uIn = new f();
    this.uIo = new c() {};
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
    this.uIk = paramBoolean;
    b.a(new g(), new String[] { "//tinker" });
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("prconfignotify", this.uIl, true);
    com.tencent.mm.sdk.b.a.IbL.c(this.pGS);
    this.uIm.alive();
    com.tencent.mm.sdk.b.a.IbL.c(this.uIn);
    com.tencent.mm.sdk.b.a.IbL.c(this.uIo);
    ad.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
    com.tencent.mm.plugin.hp.tinker.h.fC(aj.getContext());
    for (;;)
    {
      try
      {
        l2 = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAw, Long.valueOf(0L))).longValue();
        l1 = System.currentTimeMillis();
        if (l1 - l2 < 3600000L) {
          continue;
        }
        int i = Calendar.getInstance().get(11);
        ad.i("Tinker.SubCoreHotpatch", "try to fetch patch update hour %d ", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          continue;
        }
        i = new Random().nextInt(60);
        l1 = l1 - com.tencent.mm.plugin.hp.tinker.h.fD(aj.getContext()) * 3600000L + i * 60000L;
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAw, Long.valueOf(l1));
        ad.i("Tinker.SubCoreHotpatch", "try to fetch patch update after %d minute currentTime %s lastUpdate %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        ad.printErrStackTrace("Tinker.SubCoreHotpatch", localException, "", new Object[0]);
        continue;
        com.tinkerboots.sdk.a.gdU().zV(false);
        ad.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
        continue;
      }
      f.xM(l1);
      if (!aj.fkH()) {
        ag.a.cVi.MI();
      }
      AppMethodBeat.o(117419);
      return;
      com.tinkerboots.sdk.a.gdU().zV(true);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAw, Long.valueOf(l1));
      ad.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(l2) });
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(117420);
    b.S(new String[] { "//tinker" });
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("prconfignotify", this.uIl, true);
    com.tencent.mm.sdk.b.a.IbL.d(this.pGS);
    this.uIm.dead();
    com.tencent.mm.sdk.b.a.IbL.d(this.uIn);
    com.tencent.mm.sdk.b.a.IbL.d(this.uIo);
    ad.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    AppMethodBeat.o(117420);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.d
 * JD-Core Version:    0.7.0.1
 */