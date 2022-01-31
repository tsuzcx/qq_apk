package com.tencent.mm.plugin.brandservice;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;

public class PluginBrandService
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.brandservice.a.c
{
  private h.a jSC;
  private r.c jSD;
  
  public PluginBrandService()
  {
    AppMethodBeat.i(13807);
    this.jSC = new PluginBrandService.3(this);
    this.jSD = new PluginBrandService.4(this);
    AppMethodBeat.o(13807);
  }
  
  private void addBrandServiceEvent()
  {
    AppMethodBeat.i(13813);
    com.tencent.mm.sdk.b.a.ymk.c(new PluginBrandService.1(this));
    AppMethodBeat.o(13813);
  }
  
  private void addPlaceTopChangeListener()
  {
    AppMethodBeat.i(13814);
    com.tencent.mm.sdk.b.a.ymk.b(new PluginBrandService.2(this));
    AppMethodBeat.o(13814);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(13809);
    addBrandServiceEvent();
    addPlaceTopChangeListener();
    if (paramg.SD()) {
      pin(new q(d.class));
    }
    AppMethodBeat.o(13809);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(13810);
    com.tencent.mm.bq.c.anb("brandservice");
    if ((paramg.SD()) || (paramg.mI(":tools")) || (paramg.mI(":toolsmp"))) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.b.class, new c());
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.uD();
    paramg = a.jSs;
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new a(), new String[] { a.aWk() });
    AppMethodBeat.o(13810);
  }
  
  public void installed()
  {
    AppMethodBeat.i(13808);
    alias(com.tencent.mm.plugin.brandservice.a.c.class);
    AppMethodBeat.o(13808);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(13811);
    ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.jSC, Looper.getMainLooper());
    com.tencent.mm.aj.z.afo().a(this.jSD, Looper.getMainLooper());
    com.tencent.mm.aj.z.afp().a(this.jSD, Looper.getMainLooper());
    if (s.aWl())
    {
      new com.tencent.mm.plugin.brandservice.ui.timeline.c();
      ab.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
      int i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKe, Integer.valueOf(0))).intValue();
      if ((i & 0x1) == 0)
      {
        ((j)com.tencent.mm.kernel.g.E(j.class)).YF().arJ("officialaccounts");
        com.tencent.mm.aj.z.afo().dwe();
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKe, Integer.valueOf(i | 0x1));
      }
    }
    AppMethodBeat.o(13811);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(13812);
    ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.jSC);
    com.tencent.mm.aj.z.afo().a(this.jSD);
    com.tencent.mm.aj.z.afp().a(this.jSD);
    AppMethodBeat.o(13812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService
 * JD-Core Version:    0.7.0.1
 */