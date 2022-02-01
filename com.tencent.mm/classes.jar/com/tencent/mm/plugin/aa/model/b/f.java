package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.aa.model.c;
import com.tencent.mm.plugin.aa.model.h;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class f
  extends com.tencent.mm.vending.app.a
{
  c ibc;
  h ibd;
  k ibe;
  
  public f()
  {
    AppMethodBeat.i(63455);
    this.ibc = new c();
    this.ibd = new h();
    this.ibe = new k();
    AppMethodBeat.o(63455);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63456);
    super.onCreate();
    Object localObject = this.ibc.aGY();
    ad.i("MicroMsg.AAGetPaylistDetailLogic", "init");
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1695, (com.tencent.mm.al.g)localObject);
    localObject = this.ibd.aHg();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1629, (com.tencent.mm.al.g)localObject);
    this.ibe.aHi().init();
    AppMethodBeat.o(63456);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63457);
    super.onDestroy();
    Object localObject = this.ibc.aGY();
    ad.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1695, (com.tencent.mm.al.g)localObject);
    localObject = this.ibd.aHg();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1629, (com.tencent.mm.al.g)localObject);
    this.ibe.aHi().NX();
    AppMethodBeat.o(63457);
  }
  
  public final String sh(String paramString)
  {
    AppMethodBeat.i(63458);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63458);
      return "";
    }
    String str = this.HOX.getStringExtra("chatroom");
    paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString, str);
    AppMethodBeat.o(63458);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.f
 * JD-Core Version:    0.7.0.1
 */