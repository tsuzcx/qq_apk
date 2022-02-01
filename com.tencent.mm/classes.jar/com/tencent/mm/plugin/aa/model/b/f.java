package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.c;
import com.tencent.mm.plugin.aa.model.h;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.sdk.platformtools.Log;

public class f
  extends com.tencent.mm.vending.app.a
{
  c jUf;
  h jUg;
  k jUh;
  
  public f()
  {
    AppMethodBeat.i(63455);
    this.jUf = new c();
    this.jUg = new h();
    this.jUh = new k();
    AppMethodBeat.o(63455);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63456);
    super.onCreate();
    Object localObject = this.jUf.bmb();
    Log.i("MicroMsg.AAGetPaylistDetailLogic", "init");
    g.aAi();
    g.aAg().hqi.a(1695, (i)localObject);
    localObject = this.jUg.bmk();
    g.aAi();
    g.aAg().hqi.a(1629, (i)localObject);
    this.jUh.bmm().init();
    AppMethodBeat.o(63456);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63457);
    super.onDestroy();
    Object localObject = this.jUf.bmb();
    Log.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
    g.aAi();
    g.aAg().hqi.b(1695, (i)localObject);
    localObject = this.jUg.bmk();
    g.aAi();
    g.aAg().hqi.b(1629, (i)localObject);
    this.jUh.bmm().unInit();
    AppMethodBeat.o(63457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.f
 * JD-Core Version:    0.7.0.1
 */