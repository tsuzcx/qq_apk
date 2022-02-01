package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.f;
import com.tencent.mm.plugin.aa.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.app.a;

public final class d
  extends a
{
  m jTX;
  f jTY;
  
  public d()
  {
    AppMethodBeat.i(63443);
    this.jTX = new m();
    this.jTY = new f();
    AppMethodBeat.o(63443);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63444);
    super.onCreate();
    Log.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
    Object localObject = this.jTX.bmn();
    g.aAi();
    g.aAg().hqi.a(1624, (i)localObject);
    g.aAi();
    g.aAg().hqi.a(1655, (i)localObject);
    g.aAi();
    g.aAg().hqi.a(2831, (i)localObject);
    localObject = this.jTY.bmj();
    Log.i("MicroMsg.AAOperationData", "init");
    g.aAi();
    g.aAg().hqi.a(1698, (i)localObject);
    AppMethodBeat.o(63444);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63445);
    super.onDestroy();
    Log.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
    Object localObject = this.jTX.bmn();
    g.aAi();
    g.aAg().hqi.b(1624, (i)localObject);
    g.aAi();
    g.aAg().hqi.b(1655, (i)localObject);
    g.aAi();
    g.aAg().hqi.b(2831, (i)localObject);
    localObject = this.jTY.bmj();
    Log.i("MicroMsg.AAOperationData", "uninit");
    g.aAi();
    g.aAg().hqi.b(1698, (i)localObject);
    AppMethodBeat.o(63445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.d
 * JD-Core Version:    0.7.0.1
 */