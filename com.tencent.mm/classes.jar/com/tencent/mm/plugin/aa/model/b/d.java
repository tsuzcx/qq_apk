package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.aa.model.f;
import com.tencent.mm.plugin.aa.model.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.app.a;

public final class d
  extends a
{
  m iAY;
  f iAZ;
  
  public d()
  {
    AppMethodBeat.i(63443);
    this.iAY = new m();
    this.iAZ = new f();
    AppMethodBeat.o(63443);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63444);
    super.onCreate();
    ac.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
    Object localObject = this.iAY.aNX();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1624, (com.tencent.mm.ak.g)localObject);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1655, (com.tencent.mm.ak.g)localObject);
    localObject = this.iAZ.aNT();
    ac.i("MicroMsg.AAOperationData", "init");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1698, (com.tencent.mm.ak.g)localObject);
    AppMethodBeat.o(63444);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63445);
    super.onDestroy();
    ac.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
    Object localObject = this.iAY.aNX();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1624, (com.tencent.mm.ak.g)localObject);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1655, (com.tencent.mm.ak.g)localObject);
    localObject = this.iAZ.aNT();
    ac.i("MicroMsg.AAOperationData", "uninit");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1698, (com.tencent.mm.ak.g)localObject);
    AppMethodBeat.o(63445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.d
 * JD-Core Version:    0.7.0.1
 */