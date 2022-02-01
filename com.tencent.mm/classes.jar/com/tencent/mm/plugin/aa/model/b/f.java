package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.protocal.protobuf.u;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.b;

public class f
  extends com.tencent.mm.vending.app.a
{
  com.tencent.mm.plugin.aa.model.c mLs;
  com.tencent.mm.plugin.aa.model.h mLt;
  k mLu;
  
  public f()
  {
    AppMethodBeat.i(63455);
    this.mLs = new com.tencent.mm.plugin.aa.model.c();
    this.mLt = new com.tencent.mm.plugin.aa.model.h();
    this.mLu = new k();
    AppMethodBeat.o(63455);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63456);
    super.onCreate();
    Object localObject = this.mLs.bwj();
    Log.i("MicroMsg.AAGetPaylistDetailLogic", "init");
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1695, (i)localObject);
    localObject = this.mLt.bws();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(1629, (i)localObject);
    this.mLu.bwu().init();
    AppMethodBeat.o(63456);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63457);
    super.onDestroy();
    Object localObject = this.mLs.bwj();
    Log.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1695, (i)localObject);
    localObject = this.mLt.bws();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(1629, (i)localObject);
    this.mLu.bwu().unInit();
    AppMethodBeat.o(63457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.f
 * JD-Core Version:    0.7.0.1
 */