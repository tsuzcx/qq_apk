package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.aa.model.g;
import com.tencent.mm.plugin.aa.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.app.a;

public final class d
  extends a
{
  n pHR;
  g pHS;
  
  public d()
  {
    AppMethodBeat.i(63443);
    this.pHR = new n();
    this.pHS = new g();
    AppMethodBeat.o(63443);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63444);
    super.onCreate();
    Log.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
    Object localObject = this.pHR.bVn();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1624, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1655, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(2831, (com.tencent.mm.am.h)localObject);
    localObject = this.pHS.bVj();
    Log.i("MicroMsg.AAOperationData", "init");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1698, (com.tencent.mm.am.h)localObject);
    AppMethodBeat.o(63444);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63445);
    super.onDestroy();
    Log.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
    Object localObject = this.pHR.bVn();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1624, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1655, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(2831, (com.tencent.mm.am.h)localObject);
    localObject = this.pHS.bVj();
    Log.i("MicroMsg.AAOperationData", "uninit");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1698, (com.tencent.mm.am.h)localObject);
    AppMethodBeat.o(63445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.d
 * JD-Core Version:    0.7.0.1
 */