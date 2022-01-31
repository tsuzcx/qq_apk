package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.e;
import com.tencent.mm.plugin.aa.a.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.app.a;

public final class d
  extends a
{
  l eWT = new l();
  e eWU = new e();
  
  protected final void onCreate()
  {
    super.onCreate();
    y.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
    Object localObject = this.eWT.Vv();
    g.DQ();
    g.DO().dJT.a(1624, (f)localObject);
    g.DQ();
    g.DO().dJT.a(1655, (f)localObject);
    localObject = this.eWU.Vq();
    y.i("MicroMsg.AAOperationData", "init");
    g.DQ();
    g.DO().dJT.a(1698, (f)localObject);
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
    Object localObject = this.eWT.Vv();
    g.DQ();
    g.DO().dJT.b(1624, (f)localObject);
    g.DQ();
    g.DO().dJT.b(1655, (f)localObject);
    localObject = this.eWU.Vq();
    y.i("MicroMsg.AAOperationData", "uninit");
    g.DQ();
    g.DO().dJT.b(1698, (f)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.c.d
 * JD-Core Version:    0.7.0.1
 */