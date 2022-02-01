package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ag;
import com.tencent.mm.app.ag.a;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.br;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class d
  implements az
{
  private final c<bi> pNw;
  private boolean uTX;
  private final h uTY;
  private final c<dc> uTZ;
  private final f uUa;
  private final c<br> uUb;
  
  public d()
  {
    AppMethodBeat.i(117418);
    this.uTX = true;
    this.uTY = new h();
    this.pNw = new c() {};
    this.uTZ = new c() {};
    this.uUa = new f();
    this.uUb = new c() {};
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
    this.uTX = paramBoolean;
    b.a(new g(), new String[] { "//tinker" });
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("prconfignotify", this.uTY, true);
    com.tencent.mm.sdk.b.a.IvT.c(this.pNw);
    this.uTZ.alive();
    com.tencent.mm.sdk.b.a.IvT.c(this.uUa);
    com.tencent.mm.sdk.b.a.IvT.c(this.uUb);
    ae.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
    com.tencent.mm.plugin.hp.tinker.h.fH(ak.getContext());
    for (;;)
    {
      try
      {
        l2 = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUV, Long.valueOf(0L))).longValue();
        l1 = System.currentTimeMillis();
        if (l1 - l2 < 3600000L) {
          continue;
        }
        int i = Calendar.getInstance().get(11);
        ae.i("Tinker.SubCoreHotpatch", "try to fetch patch update hour %d ", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          continue;
        }
        i = new Random().nextInt(60);
        l1 = l1 - com.tencent.mm.plugin.hp.tinker.h.fI(ak.getContext()) * 3600000L + i * 60000L;
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUV, Long.valueOf(l1));
        ae.i("Tinker.SubCoreHotpatch", "try to fetch patch update after %d minute currentTime %s lastUpdate %s", new Object[] { Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2) });
      }
      catch (Exception localException)
      {
        long l2;
        long l1;
        ae.printErrStackTrace("Tinker.SubCoreHotpatch", localException, "", new Object[0]);
        continue;
        com.tinkerboots.sdk.a.gix().Ai(false);
        ae.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
        continue;
      }
      f.yg(l1);
      if (!ak.foB()) {
        ag.a.cWf.MD();
      }
      AppMethodBeat.o(117419);
      return;
      com.tinkerboots.sdk.a.gix().Ai(true);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUV, Long.valueOf(l1));
      ae.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(l2) });
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(117420);
    b.S(new String[] { "//tinker" });
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("prconfignotify", this.uTY, true);
    com.tencent.mm.sdk.b.a.IvT.d(this.pNw);
    this.uTZ.dead();
    com.tencent.mm.sdk.b.a.IvT.d(this.uUa);
    com.tencent.mm.sdk.b.a.IvT.d(this.uUb);
    ae.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    AppMethodBeat.o(117420);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.d
 * JD-Core Version:    0.7.0.1
 */