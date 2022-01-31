package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.aa.a.c;
import com.tencent.mm.plugin.aa.a.i;
import com.tencent.mm.plugin.aa.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.app.a;

public class f
  extends a
{
  c eXa = new c();
  com.tencent.mm.plugin.aa.a.g eXb = new com.tencent.mm.plugin.aa.a.g();
  j eXc = new j();
  
  protected final void onCreate()
  {
    super.onCreate();
    Object localObject = this.eXa.Vl();
    y.i("MicroMsg.AAGetPaylistDetailLogic", "init");
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(1695, (com.tencent.mm.ah.f)localObject);
    localObject = this.eXb.Vr();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(1629, (com.tencent.mm.ah.f)localObject);
    this.eXc.Vu().init();
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.eXa.Vl();
    y.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(1695, (com.tencent.mm.ah.f)localObject);
    localObject = this.eXb.Vr();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(1629, (com.tencent.mm.ah.f)localObject);
    this.eXc.Vu().Vt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.c.f
 * JD-Core Version:    0.7.0.1
 */