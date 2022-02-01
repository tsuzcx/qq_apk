package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.aa.model.c;
import com.tencent.mm.plugin.aa.model.h;
import com.tencent.mm.plugin.aa.model.j;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class f
  extends com.tencent.mm.vending.app.a
{
  c iBf;
  h iBg;
  k iBh;
  
  public f()
  {
    AppMethodBeat.i(63455);
    this.iBf = new c();
    this.iBg = new h();
    this.iBh = new k();
    AppMethodBeat.o(63455);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(63456);
    super.onCreate();
    Object localObject = this.iBf.aNM();
    ac.i("MicroMsg.AAGetPaylistDetailLogic", "init");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1695, (com.tencent.mm.ak.g)localObject);
    localObject = this.iBg.aNU();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1629, (com.tencent.mm.ak.g)localObject);
    this.iBh.aNW().init();
    AppMethodBeat.o(63456);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(63457);
    super.onDestroy();
    Object localObject = this.iBf.aNM();
    ac.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1695, (com.tencent.mm.ak.g)localObject);
    localObject = this.iBg.aNU();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(1629, (com.tencent.mm.ak.g)localObject);
    this.iBh.aNW().unInit();
    AppMethodBeat.o(63457);
  }
  
  public final String wk(String paramString)
  {
    AppMethodBeat.i(63458);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63458);
      return "";
    }
    String str = this.Jps.getStringExtra("chatroom");
    paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString, str);
    AppMethodBeat.o(63458);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.f
 * JD-Core Version:    0.7.0.1
 */