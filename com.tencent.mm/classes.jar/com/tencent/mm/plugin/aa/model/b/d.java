package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.app.a;

public final class d
  extends a
{
  m iXb;
  com.tencent.mm.plugin.aa.model.f iXc;
  
  public d()
  {
    AppMethodBeat.i(63443);
    this.iXb = new m();
    this.iXc = new com.tencent.mm.plugin.aa.model.f();
    AppMethodBeat.o(63443);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63444);
    super.onCreate();
    ae.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
    Object localObject = this.iXb.aRI();
    g.ajS();
    g.ajQ().gDv.a(1624, (com.tencent.mm.ak.f)localObject);
    g.ajS();
    g.ajQ().gDv.a(1655, (com.tencent.mm.ak.f)localObject);
    localObject = this.iXc.aRE();
    ae.i("MicroMsg.AAOperationData", "init");
    g.ajS();
    g.ajQ().gDv.a(1698, (com.tencent.mm.ak.f)localObject);
    AppMethodBeat.o(63444);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63445);
    super.onDestroy();
    ae.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
    Object localObject = this.iXb.aRI();
    g.ajS();
    g.ajQ().gDv.b(1624, (com.tencent.mm.ak.f)localObject);
    g.ajS();
    g.ajQ().gDv.b(1655, (com.tencent.mm.ak.f)localObject);
    localObject = this.iXc.aRE();
    ae.i("MicroMsg.AAOperationData", "uninit");
    g.ajS();
    g.ajQ().gDv.b(1698, (com.tencent.mm.ak.f)localObject);
    AppMethodBeat.o(63445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.d
 * JD-Core Version:    0.7.0.1
 */