package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.c;
import com.tencent.mm.plugin.aa.model.h;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.protocal.protobuf.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class f
  extends com.tencent.mm.vending.app.a
{
  c iXi;
  h iXj;
  k iXk;
  
  public f()
  {
    AppMethodBeat.i(63455);
    this.iXi = new c();
    this.iXj = new h();
    this.iXk = new k();
    AppMethodBeat.o(63455);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63456);
    super.onCreate();
    Object localObject = this.iXi.aRx();
    ae.i("MicroMsg.AAGetPaylistDetailLogic", "init");
    g.ajS();
    g.ajQ().gDv.a(1695, (com.tencent.mm.ak.f)localObject);
    localObject = this.iXj.aRF();
    g.ajS();
    g.ajQ().gDv.a(1629, (com.tencent.mm.ak.f)localObject);
    this.iXk.aRH().init();
    AppMethodBeat.o(63456);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63457);
    super.onDestroy();
    Object localObject = this.iXi.aRx();
    ae.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
    g.ajS();
    g.ajQ().gDv.b(1695, (com.tencent.mm.ak.f)localObject);
    localObject = this.iXj.aRF();
    g.ajS();
    g.ajQ().gDv.b(1629, (com.tencent.mm.ak.f)localObject);
    this.iXk.aRH().unInit();
    AppMethodBeat.o(63457);
  }
  
  public final String zP(String paramString)
  {
    AppMethodBeat.i(63458);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63458);
      return "";
    }
    String str = this.LDz.getStringExtra("chatroom");
    paramString = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString, str);
    AppMethodBeat.o(63458);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.f
 * JD-Core Version:    0.7.0.1
 */