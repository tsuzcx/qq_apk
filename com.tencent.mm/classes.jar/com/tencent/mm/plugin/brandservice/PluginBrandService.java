package com.tencent.mm.plugin.brandservice;

import android.os.Looper;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;

public class PluginBrandService
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.brandservice.a.d
{
  private g.a ibM = new PluginBrandService.3(this);
  private r.c ibN = new PluginBrandService.4(this);
  
  private void addBrandServiceEvent()
  {
    com.tencent.mm.sdk.b.a.udP.c(new PluginBrandService.1(this));
  }
  
  private void addPlaceTopChangeListener()
  {
    com.tencent.mm.sdk.b.a.udP.b(new PluginBrandService.2(this));
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    addBrandServiceEvent();
    addPlaceTopChangeListener();
    if (paramg.Ex()) {
      pin(new p(c.class));
    }
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.br.c.Xg("brandservice");
    if (paramg.Ex()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.brandservice.a.a.class, new com.tencent.mm.plugin.brandservice.ui.timeline.a.a.c());
    }
    if ((paramg.Ex()) || (paramg.gn(":tools")) || (paramg.gn(":toolsmp"))) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.brandservice.a.b.class, new com.tencent.mm.plugin.brandservice.ui.timeline.a.b.b());
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.a.c.init();
  }
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.brandservice.a.d.class);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.ibM, Looper.getMainLooper());
    com.tencent.mm.ai.z.ME().a(this.ibN, Looper.getMainLooper());
    com.tencent.mm.ai.z.MF().a(this.ibN, Looper.getMainLooper());
    if (s.ctL())
    {
      new com.tencent.mm.plugin.brandservice.ui.timeline.d();
      y.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
      int i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzq, Integer.valueOf(0))).intValue();
      if ((i & 0x1) == 0)
      {
        ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abx("officialaccounts");
        com.tencent.mm.ai.z.ME().ctE();
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzq, Integer.valueOf(i | 0x1));
      }
    }
  }
  
  public void onAccountRelease()
  {
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.ibM);
    com.tencent.mm.ai.z.ME().a(this.ibN);
    com.tencent.mm.ai.z.MF().a(this.ibN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService
 * JD-Core Version:    0.7.0.1
 */