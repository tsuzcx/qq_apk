package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.aa.a.c;
import com.tencent.mm.plugin.aa.a.i;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class f
  extends com.tencent.mm.vending.app.a
{
  c goY;
  com.tencent.mm.plugin.aa.a.g goZ;
  j gpa;
  
  public f()
  {
    AppMethodBeat.i(40694);
    this.goY = new c();
    this.goZ = new com.tencent.mm.plugin.aa.a.g();
    this.gpa = new j();
    AppMethodBeat.o(40694);
  }
  
  public final String nE(String paramString)
  {
    AppMethodBeat.i(40697);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(40697);
      return "";
    }
    String str = this.ANL.getStringExtra("chatroom");
    paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString, str);
    AppMethodBeat.o(40697);
    return paramString;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(40695);
    super.onCreate();
    Object localObject = this.goY.aoJ();
    ab.i("MicroMsg.AAGetPaylistDetailLogic", "init");
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1695, (com.tencent.mm.ai.f)localObject);
    localObject = this.goZ.aoP();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(1629, (com.tencent.mm.ai.f)localObject);
    this.gpa.aoS().init();
    AppMethodBeat.o(40695);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(40696);
    super.onDestroy();
    Object localObject = this.goY.aoJ();
    ab.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(1695, (com.tencent.mm.ai.f)localObject);
    localObject = this.goZ.aoP();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(1629, (com.tencent.mm.ai.f)localObject);
    this.gpa.aoS().aoR();
    AppMethodBeat.o(40696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.c.f
 * JD-Core Version:    0.7.0.1
 */