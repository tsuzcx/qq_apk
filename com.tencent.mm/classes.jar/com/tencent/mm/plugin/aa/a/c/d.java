package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.e;
import com.tencent.mm.plugin.aa.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.app.a;

public final class d
  extends a
{
  l goR;
  e goS;
  
  public d()
  {
    AppMethodBeat.i(40684);
    this.goR = new l();
    this.goS = new e();
    AppMethodBeat.o(40684);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(40685);
    super.onCreate();
    ab.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
    Object localObject = this.goR.aoT();
    g.RM();
    g.RK().eHt.a(1624, (f)localObject);
    g.RM();
    g.RK().eHt.a(1655, (f)localObject);
    localObject = this.goS.aoO();
    ab.i("MicroMsg.AAOperationData", "init");
    g.RM();
    g.RK().eHt.a(1698, (f)localObject);
    AppMethodBeat.o(40685);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(40686);
    super.onDestroy();
    ab.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
    Object localObject = this.goR.aoT();
    g.RM();
    g.RK().eHt.b(1624, (f)localObject);
    g.RM();
    g.RK().eHt.b(1655, (f)localObject);
    localObject = this.goS.aoO();
    ab.i("MicroMsg.AAOperationData", "uninit");
    g.RM();
    g.RK().eHt.b(1698, (f)localObject);
    AppMethodBeat.o(40686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.c.d
 * JD-Core Version:    0.7.0.1
 */