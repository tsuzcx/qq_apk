package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.c;
import com.tencent.mm.plugin.aa.model.h;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.protocal.protobuf.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class f
  extends com.tencent.mm.vending.app.a
{
  c iUp;
  h iUq;
  k iUr;
  
  public f()
  {
    AppMethodBeat.i(63455);
    this.iUp = new c();
    this.iUq = new h();
    this.iUr = new k();
    AppMethodBeat.o(63455);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63456);
    super.onCreate();
    Object localObject = this.iUp.aQY();
    ad.i("MicroMsg.AAGetPaylistDetailLogic", "init");
    g.ajD();
    g.ajB().gAO.a(1695, (com.tencent.mm.al.f)localObject);
    localObject = this.iUq.aRg();
    g.ajD();
    g.ajB().gAO.a(1629, (com.tencent.mm.al.f)localObject);
    this.iUr.aRi().init();
    AppMethodBeat.o(63456);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63457);
    super.onDestroy();
    Object localObject = this.iUp.aQY();
    ad.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
    g.ajD();
    g.ajB().gAO.b(1695, (com.tencent.mm.al.f)localObject);
    localObject = this.iUq.aRg();
    g.ajD();
    g.ajB().gAO.b(1629, (com.tencent.mm.al.f)localObject);
    this.iUr.aRi().unInit();
    AppMethodBeat.o(63457);
  }
  
  public final String zf(String paramString)
  {
    AppMethodBeat.i(63458);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63458);
      return "";
    }
    String str = this.LgX.getStringExtra("chatroom");
    paramString = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString, str);
    AppMethodBeat.o(63458);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.f
 * JD-Core Version:    0.7.0.1
 */