package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.aa.model.d;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.plugin.aa.model.l;
import com.tencent.mm.protocal.protobuf.u;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.b;

public class f
  extends com.tencent.mm.vending.app.a
{
  d pHZ;
  i pIa;
  l pIb;
  
  public f()
  {
    AppMethodBeat.i(63455);
    this.pHZ = new d();
    this.pIa = new i();
    this.pIb = new l();
    AppMethodBeat.o(63455);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63456);
    super.onCreate();
    Object localObject = this.pHZ.bVc();
    Log.i("MicroMsg.AAGetPaylistDetailLogic", "init");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1695, (com.tencent.mm.am.h)localObject);
    localObject = this.pIa.bVk();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1629, (com.tencent.mm.am.h)localObject);
    this.pIb.bVm().init();
    AppMethodBeat.o(63456);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63457);
    super.onDestroy();
    Object localObject = this.pHZ.bVc();
    Log.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1695, (com.tencent.mm.am.h)localObject);
    localObject = this.pIa.bVk();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1629, (com.tencent.mm.am.h)localObject);
    this.pIb.bVm().unInit();
    AppMethodBeat.o(63457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.f
 * JD-Core Version:    0.7.0.1
 */