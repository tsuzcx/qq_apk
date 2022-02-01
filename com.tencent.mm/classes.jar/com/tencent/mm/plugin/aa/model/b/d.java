package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.app.a;

public final class d
  extends a
{
  m iUi;
  com.tencent.mm.plugin.aa.model.f iUj;
  
  public d()
  {
    AppMethodBeat.i(63443);
    this.iUi = new m();
    this.iUj = new com.tencent.mm.plugin.aa.model.f();
    AppMethodBeat.o(63443);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63444);
    super.onCreate();
    ad.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
    Object localObject = this.iUi.aRj();
    g.ajD();
    g.ajB().gAO.a(1624, (com.tencent.mm.al.f)localObject);
    g.ajD();
    g.ajB().gAO.a(1655, (com.tencent.mm.al.f)localObject);
    localObject = this.iUj.aRf();
    ad.i("MicroMsg.AAOperationData", "init");
    g.ajD();
    g.ajB().gAO.a(1698, (com.tencent.mm.al.f)localObject);
    AppMethodBeat.o(63444);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63445);
    super.onDestroy();
    ad.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
    Object localObject = this.iUi.aRj();
    g.ajD();
    g.ajB().gAO.b(1624, (com.tencent.mm.al.f)localObject);
    g.ajD();
    g.ajB().gAO.b(1655, (com.tencent.mm.al.f)localObject);
    localObject = this.iUj.aRf();
    ad.i("MicroMsg.AAOperationData", "uninit");
    g.ajD();
    g.ajB().gAO.b(1698, (com.tencent.mm.al.f)localObject);
    AppMethodBeat.o(63445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.d
 * JD-Core Version:    0.7.0.1
 */